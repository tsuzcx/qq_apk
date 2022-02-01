package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.ede;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  extends b
{
  private boolean dAM;
  private int djY;
  private String talker;
  
  public j(String paramString, int paramInt, boolean paramBoolean)
  {
    this.talker = paramString;
    this.djY = paramInt;
    this.dAM = paramBoolean;
  }
  
  private static String aF(ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(30131);
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bu localbu = (bu)paramArrayList.next();
      localStringBuffer.append(localbu.field_msgId);
      localStringBuffer.append(localbu.field_talker);
      localStringBuffer.append(localbu.field_content);
      localStringBuffer.append(localbu.getType());
      localStringBuffer.append(localbu.field_createTime);
    }
    paramArrayList = ai.ee(localStringBuffer.toString());
    AppMethodBeat.o(30131);
    return paramArrayList;
  }
  
  private static String j(String paramString, ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(30130);
    ad.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", new Object[] { paramString, Integer.valueOf(paramArrayList.size()) });
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      localStringBuffer.append(c(paramString, (bu)paramArrayList.get(i)));
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
    f localf = com.tencent.mm.plugin.wear.model.a.eKt().aFn(this.talker);
    Object localObject1 = new ArrayList();
    int j = this.djY - localf.Dxd;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ad.d("MicroMsg.WearNotificationCreateTask", "limit=%d", new Object[] { Integer.valueOf(i) });
    ba.aBQ();
    Object localObject2 = c.azs().eb(this.talker, i).iterator();
    label145:
    while (((Iterator)localObject2).hasNext())
    {
      bu localbu = (bu)((Iterator)localObject2).next();
      if (localbu.isSystem()) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label145;
        }
        ((ArrayList)localObject1).add(localbu);
        break;
      }
    }
    ad.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
    if (((ArrayList)localObject1).size() == 0)
    {
      AppMethodBeat.o(30132);
      return;
    }
    localObject2 = aF((ArrayList)localObject1);
    if (localf.md5.equals(localObject2))
    {
      ad.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
      AppMethodBeat.o(30132);
      return;
    }
    localf.md5 = ((String)localObject2);
    localObject2 = new ede();
    ((ede)localObject2).ukh = localf.id;
    ((ede)localObject2).Hnp = localf.talker;
    ((ede)localObject2).Title = h.aFs(localf.talker);
    ((ede)localObject2).hDa = j(localf.talker, (ArrayList)localObject1);
    ((ede)localObject2).Hrp = this.djY;
    ((ede)localObject2).HOV = this.dAM;
    boolean bool;
    if (!bv.fma()) {
      bool = true;
    }
    for (;;)
    {
      ((ede)localObject2).HOU = bool;
      localObject1 = h.aFr(localf.talker);
      if (localObject1 != null) {
        ((ede)localObject2).HOD = new com.tencent.mm.bx.b(h.as((Bitmap)localObject1));
      }
      ad.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
      try
      {
        com.tencent.mm.plugin.wear.model.a.eKz();
        r.a(20003, ((ede)localObject2).toByteArray(), true);
        label370:
        ad.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
        com.tencent.mm.plugin.wear.model.a.eKt().a(localf);
        com.tencent.mm.plugin.wear.model.a.eKt().aFq(this.talker);
        com.tencent.mm.plugin.wear.model.c.a.iP(6, 0);
        com.tencent.mm.plugin.wear.model.c.a.VS(1);
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