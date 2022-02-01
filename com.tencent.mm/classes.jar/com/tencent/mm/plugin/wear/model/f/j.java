package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.ezd;
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
  private int dCm;
  private boolean dTG;
  private String talker;
  
  public j(String paramString, int paramInt, boolean paramBoolean)
  {
    this.talker = paramString;
    this.dCm = paramInt;
    this.dTG = paramBoolean;
  }
  
  private static String aY(ArrayList<ca> paramArrayList)
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
  
  private String n(String paramString, ArrayList<ca> paramArrayList)
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
  
  public final String getName()
  {
    return "WearNotificationCreateTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30132);
    Log.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
    f localf = com.tencent.mm.plugin.wear.model.a.fVK().aWj(this.talker);
    Object localObject1 = new ArrayList();
    int j = this.dCm - localf.IxY;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Log.d("MicroMsg.WearNotificationCreateTask", "limit=%d", new Object[] { Integer.valueOf(i) });
    bg.aVF();
    Object localObject2 = c.aSQ().ew(this.talker, i).iterator();
    label145:
    while (((Iterator)localObject2).hasNext())
    {
      ca localca = (ca)((Iterator)localObject2).next();
      if (localca.isSystem()) {}
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
    localObject2 = aY((ArrayList)localObject1);
    if (localf.md5.equals(localObject2))
    {
      Log.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
      AppMethodBeat.o(30132);
      return;
    }
    localf.md5 = ((String)localObject2);
    localObject2 = new ezd();
    ((ezd)localObject2).xNF = localf.id;
    ((ezd)localObject2).MRZ = localf.talker;
    ((ezd)localObject2).Title = h.aWo(localf.talker);
    ((ezd)localObject2).iAc = n(localf.talker, (ArrayList)localObject1);
    ((ezd)localObject2).MWA = this.dCm;
    ((ezd)localObject2).NvG = this.dTG;
    boolean bool;
    if (!WeChatLocaleUtil.isOverseasUserByWechatLanguage()) {
      bool = true;
    }
    for (;;)
    {
      ((ezd)localObject2).NvF = bool;
      localObject1 = h.aWn(localf.talker);
      if (localObject1 != null) {
        ((ezd)localObject2).Nvo = new com.tencent.mm.bw.b(h.aF((Bitmap)localObject1));
      }
      Log.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
      try
      {
        com.tencent.mm.plugin.wear.model.a.fVQ();
        r.a(20003, ((ezd)localObject2).toByteArray(), true);
        label371:
        Log.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
        com.tencent.mm.plugin.wear.model.a.fVK().a(localf);
        com.tencent.mm.plugin.wear.model.a.fVK().aWm(this.talker);
        com.tencent.mm.plugin.wear.model.c.a.jZ(6, 0);
        com.tencent.mm.plugin.wear.model.c.a.aff(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.j
 * JD-Core Version:    0.7.0.1
 */