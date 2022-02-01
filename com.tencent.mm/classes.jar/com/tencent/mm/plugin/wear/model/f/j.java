package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.protocal.protobuf.drn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  extends b
{
  private int dbk;
  private boolean drn;
  private String talker;
  
  public j(String paramString, int paramInt, boolean paramBoolean)
  {
    this.talker = paramString;
    this.dbk = paramInt;
    this.drn = paramBoolean;
  }
  
  private static String aw(ArrayList<bl> paramArrayList)
  {
    AppMethodBeat.i(30131);
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bl localbl = (bl)paramArrayList.next();
      localStringBuffer.append(localbl.field_msgId);
      localStringBuffer.append(localbl.field_talker);
      localStringBuffer.append(localbl.field_content);
      localStringBuffer.append(localbl.getType());
      localStringBuffer.append(localbl.field_createTime);
    }
    paramArrayList = ai.du(localStringBuffer.toString());
    AppMethodBeat.o(30131);
    return paramArrayList;
  }
  
  private static String j(String paramString, ArrayList<bl> paramArrayList)
  {
    AppMethodBeat.i(30130);
    ad.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", new Object[] { paramString, Integer.valueOf(paramArrayList.size()) });
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      localStringBuffer.append(c(paramString, (bl)paramArrayList.get(i)));
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
    ad.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
    f localf = com.tencent.mm.plugin.wear.model.a.egT().auM(this.talker);
    Object localObject1 = new ArrayList();
    int j = this.dbk - localf.AEp;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ad.d("MicroMsg.WearNotificationCreateTask", "limit=%d", new Object[] { Integer.valueOf(i) });
    az.arV();
    Object localObject2 = c.apO().dE(this.talker, i).iterator();
    label145:
    while (((Iterator)localObject2).hasNext())
    {
      bl localbl = (bl)((Iterator)localObject2).next();
      if (localbl.isSystem()) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label145;
        }
        ((ArrayList)localObject1).add(localbl);
        break;
      }
    }
    ad.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
    if (((ArrayList)localObject1).size() == 0)
    {
      AppMethodBeat.o(30132);
      return;
    }
    localObject2 = aw((ArrayList)localObject1);
    if (localf.md5.equals(localObject2))
    {
      ad.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
      AppMethodBeat.o(30132);
      return;
    }
    localf.md5 = ((String)localObject2);
    localObject2 = new drn();
    ((drn)localObject2).sdO = localf.id;
    ((drn)localObject2).Egc = localf.talker;
    ((drn)localObject2).Title = com.tencent.mm.plugin.wear.model.h.auR(localf.talker);
    ((drn)localObject2).gKr = j(localf.talker, (ArrayList)localObject1);
    ((drn)localObject2).EjI = this.dbk;
    ((drn)localObject2).EGD = this.drn;
    boolean bool;
    if (!bv.eGV()) {
      bool = true;
    }
    for (;;)
    {
      ((drn)localObject2).EGC = bool;
      localObject1 = com.tencent.mm.plugin.wear.model.h.auQ(localf.talker);
      if (localObject1 != null) {
        ((drn)localObject2).EGl = new com.tencent.mm.bx.b(com.tencent.mm.plugin.wear.model.h.ap((Bitmap)localObject1));
      }
      ad.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
      try
      {
        com.tencent.mm.plugin.wear.model.a.egZ();
        r.a(20003, ((drn)localObject2).toByteArray(), true);
        label370:
        ad.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
        com.tencent.mm.plugin.wear.model.a.egT().a(localf);
        com.tencent.mm.plugin.wear.model.a.egT().auP(this.talker);
        com.tencent.mm.plugin.wear.model.c.a.in(6, 0);
        com.tencent.mm.plugin.wear.model.c.a.RQ(1);
        AppMethodBeat.o(30132);
        return;
        bool = false;
      }
      catch (IOException localIOException)
      {
        break label370;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.j
 * JD-Core Version:    0.7.0.1
 */