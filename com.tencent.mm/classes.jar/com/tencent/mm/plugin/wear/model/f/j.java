package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.eev;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  extends b
{
  private boolean dBR;
  private int dla;
  private String talker;
  
  public j(String paramString, int paramInt, boolean paramBoolean)
  {
    this.talker = paramString;
    this.dla = paramInt;
    this.dBR = paramBoolean;
  }
  
  private static String aG(ArrayList<bv> paramArrayList)
  {
    AppMethodBeat.i(30131);
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bv localbv = (bv)paramArrayList.next();
      localStringBuffer.append(localbv.field_msgId);
      localStringBuffer.append(localbv.field_talker);
      localStringBuffer.append(localbv.field_content);
      localStringBuffer.append(localbv.getType());
      localStringBuffer.append(localbv.field_createTime);
    }
    paramArrayList = aj.ej(localStringBuffer.toString());
    AppMethodBeat.o(30131);
    return paramArrayList;
  }
  
  private static String j(String paramString, ArrayList<bv> paramArrayList)
  {
    AppMethodBeat.i(30130);
    ae.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", new Object[] { paramString, Integer.valueOf(paramArrayList.size()) });
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      localStringBuffer.append(c(paramString, (bv)paramArrayList.get(i)));
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
    ae.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
    f localf = com.tencent.mm.plugin.wear.model.a.eOb().aGH(this.talker);
    Object localObject1 = new ArrayList();
    int j = this.dla - localf.DOI;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ae.d("MicroMsg.WearNotificationCreateTask", "limit=%d", new Object[] { Integer.valueOf(i) });
    bc.aCg();
    Object localObject2 = c.azI().ei(this.talker, i).iterator();
    label145:
    while (((Iterator)localObject2).hasNext())
    {
      bv localbv = (bv)((Iterator)localObject2).next();
      if (localbv.isSystem()) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label145;
        }
        ((ArrayList)localObject1).add(localbv);
        break;
      }
    }
    ae.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
    if (((ArrayList)localObject1).size() == 0)
    {
      AppMethodBeat.o(30132);
      return;
    }
    localObject2 = aG((ArrayList)localObject1);
    if (localf.md5.equals(localObject2))
    {
      ae.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
      AppMethodBeat.o(30132);
      return;
    }
    localf.md5 = ((String)localObject2);
    localObject2 = new eev();
    ((eev)localObject2).uvE = localf.id;
    ((eev)localObject2).HGP = localf.talker;
    ((eev)localObject2).Title = h.aGM(localf.talker);
    ((eev)localObject2).hFS = j(localf.talker, (ArrayList)localObject1);
    ((eev)localObject2).HKR = this.dla;
    ((eev)localObject2).Ijc = this.dBR;
    boolean bool;
    if (!bw.fpV()) {
      bool = true;
    }
    for (;;)
    {
      ((eev)localObject2).Ijb = bool;
      localObject1 = h.aGL(localf.talker);
      if (localObject1 != null) {
        ((eev)localObject2).IiK = new com.tencent.mm.bw.b(h.at((Bitmap)localObject1));
      }
      ae.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
      try
      {
        com.tencent.mm.plugin.wear.model.a.eOh();
        r.a(20003, ((eev)localObject2).toByteArray(), true);
        label370:
        ae.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
        com.tencent.mm.plugin.wear.model.a.eOb().a(localf);
        com.tencent.mm.plugin.wear.model.a.eOb().aGK(this.talker);
        com.tencent.mm.plugin.wear.model.c.a.iT(6, 0);
        com.tencent.mm.plugin.wear.model.c.a.Wz(1);
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