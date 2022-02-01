package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.fju;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.WeChatLocaleUtil;
import com.tencent.mm.storage.ca;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  extends b
{
  private boolean fNh;
  private int fuP;
  private String talker;
  
  public j(String paramString, int paramInt, boolean paramBoolean)
  {
    this.talker = paramString;
    this.fuP = paramInt;
    this.fNh = paramBoolean;
  }
  
  private static String bm(ArrayList<ca> paramArrayList)
  {
    AppMethodBeat.i(30131);
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ca localca = (ca)paramArrayList.next();
      localStringBuffer.append(localca.field_msgId);
      localStringBuffer.append(localca.field_talker);
      localStringBuffer.append(localca.field_content);
      localStringBuffer.append(localca.getType());
      localStringBuffer.append(localca.field_createTime);
    }
    paramArrayList = MD5Util.getMD5String(localStringBuffer.toString());
    AppMethodBeat.o(30131);
    return paramArrayList;
  }
  
  private String p(String paramString, ArrayList<ca> paramArrayList)
  {
    AppMethodBeat.i(30130);
    Log.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", new Object[] { paramString, Integer.valueOf(paramArrayList.size()) });
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      localStringBuffer.append(c(paramString, (ca)paramArrayList.get(i)));
      localStringBuffer.append("​​");
      i -= 1;
    }
    paramString = localStringBuffer.toString().trim();
    AppMethodBeat.o(30130);
    return paramString;
  }
  
  protected final void gOA()
  {
    AppMethodBeat.i(30132);
    Log.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
    f localf = com.tencent.mm.plugin.wear.model.a.gOr().bhQ(this.talker);
    Object localObject1 = new ArrayList();
    int j = this.fuP - localf.Psd;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Log.d("MicroMsg.WearNotificationCreateTask", "limit=%d", new Object[] { Integer.valueOf(i) });
    bh.beI();
    Object localObject2 = c.bbO().eX(this.talker, i).iterator();
    label145:
    while (((Iterator)localObject2).hasNext())
    {
      ca localca = (ca)((Iterator)localObject2).next();
      if (localca.hzz()) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label145;
        }
        ((ArrayList)localObject1).add(localca);
        break;
      }
    }
    Log.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
    if (((ArrayList)localObject1).size() == 0)
    {
      AppMethodBeat.o(30132);
      return;
    }
    localObject2 = bm((ArrayList)localObject1);
    if (localf.md5.equals(localObject2))
    {
      Log.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
      AppMethodBeat.o(30132);
      return;
    }
    localf.md5 = ((String)localObject2);
    localObject2 = new fju();
    ((fju)localObject2).CRP = localf.id;
    ((fju)localObject2).Ueg = localf.talker;
    ((fju)localObject2).fwr = h.bhV(localf.talker);
    ((fju)localObject2).lpy = p(localf.talker, (ArrayList)localObject1);
    ((fju)localObject2).UiV = this.fuP;
    ((fju)localObject2).UIR = this.fNh;
    boolean bool;
    if (!WeChatLocaleUtil.isOverseasUserByWechatLanguage()) {
      bool = true;
    }
    for (;;)
    {
      ((fju)localObject2).UIQ = bool;
      localObject1 = h.bhU(localf.talker);
      if (localObject1 != null) {
        ((fju)localObject2).UIy = new com.tencent.mm.cd.b(h.aC((Bitmap)localObject1));
      }
      Log.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
      try
      {
        com.tencent.mm.plugin.wear.model.a.gOx();
        r.a(20003, ((fju)localObject2).toByteArray(), true);
        label371:
        Log.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
        com.tencent.mm.plugin.wear.model.a.gOr().a(localf);
        com.tencent.mm.plugin.wear.model.a.gOr().bhT(this.talker);
        com.tencent.mm.plugin.wear.model.c.a.lp(6, 0);
        com.tencent.mm.plugin.wear.model.c.a.amT(1);
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
  
  public final String getName()
  {
    return "WearNotificationCreateTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.j
 * JD-Core Version:    0.7.0.1
 */