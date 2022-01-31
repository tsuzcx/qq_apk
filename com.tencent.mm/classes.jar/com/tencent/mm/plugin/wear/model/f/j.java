package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bq;
import com.tencent.mm.storage.bi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  extends b
{
  private boolean cBe;
  private int cmy;
  private String talker;
  
  public j(String paramString, int paramInt, boolean paramBoolean)
  {
    this.talker = paramString;
    this.cmy = paramInt;
    this.cBe = paramBoolean;
  }
  
  private static String Y(ArrayList<bi> paramArrayList)
  {
    AppMethodBeat.i(26449);
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
    paramArrayList = ag.cE(localStringBuffer.toString());
    AppMethodBeat.o(26449);
    return paramArrayList;
  }
  
  private static String k(String paramString, ArrayList<bi> paramArrayList)
  {
    AppMethodBeat.i(26448);
    ab.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", new Object[] { paramString, Integer.valueOf(paramArrayList.size()) });
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      localStringBuffer.append(b(paramString, (bi)paramArrayList.get(i)));
      localStringBuffer.append("​​");
      i -= 1;
    }
    paramString = localStringBuffer.toString().trim();
    AppMethodBeat.o(26448);
    return paramString;
  }
  
  public final String getName()
  {
    return "WearNotificationCreateTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(26450);
    ab.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
    f localf = com.tencent.mm.plugin.wear.model.a.cYy().uGE.agb(this.talker);
    Object localObject1 = new ArrayList();
    int j = this.cmy - localf.uHk;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ab.d("MicroMsg.WearNotificationCreateTask", "limit=%d", new Object[] { Integer.valueOf(i) });
    aw.aaz();
    Object localObject2 = c.YC().cC(this.talker, i).iterator();
    label148:
    while (((Iterator)localObject2).hasNext())
    {
      bi localbi = (bi)((Iterator)localObject2).next();
      if (localbi.isSystem()) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label148;
        }
        ((ArrayList)localObject1).add(localbi);
        break;
      }
    }
    ab.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
    if (((ArrayList)localObject1).size() == 0)
    {
      AppMethodBeat.o(26450);
      return;
    }
    localObject2 = Y((ArrayList)localObject1);
    if (localf.cqq.equals(localObject2))
    {
      ab.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
      AppMethodBeat.o(26450);
      return;
    }
    localf.cqq = ((String)localObject2);
    localObject2 = new cxj();
    ((cxj)localObject2).nuk = localf.id;
    ((cxj)localObject2).xlH = localf.talker;
    ((cxj)localObject2).Title = com.tencent.mm.plugin.wear.model.h.agg(localf.talker);
    ((cxj)localObject2).ntu = k(localf.talker, (ArrayList)localObject1);
    ((cxj)localObject2).xLK = this.cmy;
    ((cxj)localObject2).yeT = this.cBe;
    boolean bool;
    if (!bq.duf()) {
      bool = true;
    }
    for (;;)
    {
      ((cxj)localObject2).yeS = bool;
      localObject1 = com.tencent.mm.plugin.wear.model.h.agf(localf.talker);
      if (localObject1 != null) {
        ((cxj)localObject2).yeB = new com.tencent.mm.bv.b(com.tencent.mm.plugin.wear.model.h.ad((Bitmap)localObject1));
      }
      ab.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
      try
      {
        com.tencent.mm.plugin.wear.model.a.cYy();
        r.a(20003, ((cxj)localObject2).toByteArray(), true);
        label373:
        ab.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
        com.tencent.mm.plugin.wear.model.a.cYy().uGE.a(localf);
        com.tencent.mm.plugin.wear.model.a.cYy().uGE.age(this.talker);
        com.tencent.mm.plugin.wear.model.c.a.gD(6, 0);
        com.tencent.mm.plugin.wear.model.c.a.IR(1);
        AppMethodBeat.o(26450);
        return;
        bool = false;
      }
      catch (IOException localIOException)
      {
        break label373;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.j
 * JD-Core Version:    0.7.0.1
 */