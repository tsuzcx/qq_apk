package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.cjw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bm;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  extends b
{
  private int bFo;
  private boolean bTx;
  private String talker;
  
  public j(String paramString, int paramInt, boolean paramBoolean)
  {
    this.talker = paramString;
    this.bFo = paramInt;
    this.bTx = paramBoolean;
  }
  
  private static String T(ArrayList<bi> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bi localbi = (bi)paramArrayList.next();
      localStringBuffer.append(localbi.field_msgId);
      localStringBuffer.append(localbi.field_talker);
      localStringBuffer.append(localbi.field_content);
      localStringBuffer.append(localbi.getType());
      localStringBuffer.append(localbi.field_createTime);
    }
    return ad.bB(localStringBuffer.toString());
  }
  
  private static String i(String paramString, ArrayList<bi> paramArrayList)
  {
    y.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", new Object[] { paramString, Integer.valueOf(paramArrayList.size()) });
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      localStringBuffer.append(b(paramString, (bi)paramArrayList.get(i)));
      localStringBuffer.append("​​");
      i -= 1;
    }
    return localStringBuffer.toString().trim();
  }
  
  public final String getName()
  {
    return "WearNotificationCreateTask";
  }
  
  protected final void send()
  {
    y.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
    f localf = com.tencent.mm.plugin.wear.model.a.bYL().qRw.Re(this.talker);
    Object localObject1 = new ArrayList();
    int j = this.bFo - localf.qSd;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    y.d("MicroMsg.WearNotificationCreateTask", "limit=%d", new Object[] { Integer.valueOf(i) });
    au.Hx();
    Object localObject2 = c.Fy().bM(this.talker, i).iterator();
    label142:
    while (((Iterator)localObject2).hasNext())
    {
      bi localbi = (bi)((Iterator)localObject2).next();
      if (localbi.isSystem()) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label142;
        }
        ((ArrayList)localObject1).add(localbi);
        break;
      }
    }
    y.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
    if (((ArrayList)localObject1).size() == 0) {
      return;
    }
    localObject2 = T((ArrayList)localObject1);
    if (localf.bIW.equals(localObject2))
    {
      y.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
      return;
    }
    localf.bIW = ((String)localObject2);
    localObject2 = new cjw();
    ((cjw)localObject2).kWl = localf.id;
    ((cjw)localObject2).tXp = localf.talker;
    ((cjw)localObject2).bGw = h.Rj(localf.talker);
    ((cjw)localObject2).kVs = i(localf.talker, (ArrayList)localObject1);
    ((cjw)localObject2).tXB = this.bFo;
    ((cjw)localObject2).tXD = this.bTx;
    boolean bool;
    if (!bm.csh()) {
      bool = true;
    }
    for (;;)
    {
      ((cjw)localObject2).tXC = bool;
      localObject1 = h.Ri(localf.talker);
      if (localObject1 != null) {
        ((cjw)localObject2).tXh = new com.tencent.mm.bv.b(h.P((Bitmap)localObject1));
      }
      y.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
      try
      {
        com.tencent.mm.plugin.wear.model.a.bYL();
        r.b(20003, ((cjw)localObject2).toByteArray(), true);
        label355:
        y.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
        com.tencent.mm.plugin.wear.model.a.bYL().qRw.a(localf);
        com.tencent.mm.plugin.wear.model.a.bYL().qRw.Rh(this.talker);
        com.tencent.mm.plugin.wear.model.c.a.ez(6, 0);
        com.tencent.mm.plugin.wear.model.c.a.Bf(1);
        return;
        bool = false;
      }
      catch (IOException localIOException)
      {
        break label355;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.j
 * JD-Core Version:    0.7.0.1
 */