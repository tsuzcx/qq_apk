package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.ggi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.WeChatLocaleUtil;
import com.tencent.mm.storage.cc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  extends b
{
  private boolean hSR;
  private int hzj;
  private String talker;
  
  public j(String paramString, int paramInt, boolean paramBoolean)
  {
    this.talker = paramString;
    this.hzj = paramInt;
    this.hSR = paramBoolean;
  }
  
  private static String bN(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(30131);
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      cc localcc = (cc)paramArrayList.next();
      localStringBuffer.append(localcc.field_msgId);
      localStringBuffer.append(localcc.field_talker);
      localStringBuffer.append(localcc.field_content);
      localStringBuffer.append(localcc.getType());
      localStringBuffer.append(localcc.getCreateTime());
    }
    paramArrayList = MD5Util.getMD5String(localStringBuffer.toString());
    AppMethodBeat.o(30131);
    return paramArrayList;
  }
  
  private String q(String paramString, ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(30130);
    Log.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", new Object[] { paramString, Integer.valueOf(paramArrayList.size()) });
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      localStringBuffer.append(c(paramString, (cc)paramArrayList.get(i)));
      localStringBuffer.append("​​");
      i -= 1;
    }
    paramString = localStringBuffer.toString().trim();
    AppMethodBeat.o(30130);
    return paramString;
  }
  
  public final String getName()
  {
    return "WearNotificationCreateTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30132);
    Log.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
    f localf = com.tencent.mm.plugin.wear.model.a.inG().bhz(this.talker);
    Object localObject1 = new ArrayList();
    int j = this.hzj - localf.WiQ;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Log.d("MicroMsg.WearNotificationCreateTask", "limit=%d", new Object[] { Integer.valueOf(i) });
    bh.bCz();
    Object localObject2 = c.bzD().fQ(this.talker, i).iterator();
    label145:
    while (((Iterator)localObject2).hasNext())
    {
      cc localcc = (cc)((Iterator)localObject2).next();
      if (localcc.jbD()) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label145;
        }
        ((ArrayList)localObject1).add(localcc);
        break;
      }
    }
    Log.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
    if (((ArrayList)localObject1).size() == 0)
    {
      AppMethodBeat.o(30132);
      return;
    }
    localObject2 = bN((ArrayList)localObject1);
    if (localf.md5.equals(localObject2))
    {
      Log.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
      AppMethodBeat.o(30132);
      return;
    }
    localf.md5 = ((String)localObject2);
    localObject2 = new ggi();
    ((ggi)localObject2).IMf = localf.id;
    ((ggi)localObject2).abvu = localf.talker;
    ((ggi)localObject2).hAP = h.bhE(localf.talker);
    ((ggi)localObject2).nUB = q(localf.talker, (ArrayList)localObject1);
    ((ggi)localObject2).abAu = this.hzj;
    ((ggi)localObject2).accZ = this.hSR;
    boolean bool;
    if (!WeChatLocaleUtil.isOverseasUserByWechatLanguage()) {
      bool = true;
    }
    for (;;)
    {
      ((ggi)localObject2).accY = bool;
      localObject1 = h.bhD(localf.talker);
      if (localObject1 != null) {
        ((ggi)localObject2).accH = new com.tencent.mm.bx.b(h.aU((Bitmap)localObject1));
      }
      Log.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
      try
      {
        com.tencent.mm.plugin.wear.model.a.inM();
        r.a(20003, ((ggi)localObject2).toByteArray(), true);
        label371:
        Log.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
        com.tencent.mm.plugin.wear.model.a.inG().a(localf);
        com.tencent.mm.plugin.wear.model.a.inG().bhC(this.talker);
        com.tencent.mm.plugin.wear.model.c.a.kK(6, 0);
        com.tencent.mm.plugin.wear.model.c.a.asK(1);
        AppMethodBeat.o(30132);
        return;
        bool = false;
      }
      catch (IOException localIOException)
      {
        break label371;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.j
 * JD-Core Version:    0.7.0.1
 */