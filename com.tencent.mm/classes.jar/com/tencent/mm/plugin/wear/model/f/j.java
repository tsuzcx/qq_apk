package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.g;
import com.tencent.mm.protocal.protobuf.dxe;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  extends b
{
  private int cYG;
  private boolean doY;
  private String talker;
  
  public j(String paramString, int paramInt, boolean paramBoolean)
  {
    this.talker = paramString;
    this.cYG = paramInt;
    this.doY = paramBoolean;
  }
  
  private static String aI(ArrayList<bo> paramArrayList)
  {
    AppMethodBeat.i(30131);
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bo localbo = (bo)paramArrayList.next();
      localStringBuffer.append(localbo.field_msgId);
      localStringBuffer.append(localbo.field_talker);
      localStringBuffer.append(localbo.field_content);
      localStringBuffer.append(localbo.getType());
      localStringBuffer.append(localbo.field_createTime);
    }
    paramArrayList = ah.dg(localStringBuffer.toString());
    AppMethodBeat.o(30131);
    return paramArrayList;
  }
  
  private static String j(String paramString, ArrayList<bo> paramArrayList)
  {
    AppMethodBeat.i(30130);
    ac.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", new Object[] { paramString, Integer.valueOf(paramArrayList.size()) });
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      localStringBuffer.append(c(paramString, (bo)paramArrayList.get(i)));
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
    ac.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
    f localf = com.tencent.mm.plugin.wear.model.a.ewn().aAd(this.talker);
    Object localObject1 = new ArrayList();
    int j = this.cYG - localf.BWJ;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    ac.d("MicroMsg.WearNotificationCreateTask", "limit=%d", new Object[] { Integer.valueOf(i) });
    az.ayM();
    Object localObject2 = c.awD().dK(this.talker, i).iterator();
    label145:
    while (((Iterator)localObject2).hasNext())
    {
      bo localbo = (bo)((Iterator)localObject2).next();
      if (localbo.isSystem()) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label145;
        }
        ((ArrayList)localObject1).add(localbo);
        break;
      }
    }
    ac.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
    if (((ArrayList)localObject1).size() == 0)
    {
      AppMethodBeat.o(30132);
      return;
    }
    localObject2 = aI((ArrayList)localObject1);
    if (localf.md5.equals(localObject2))
    {
      ac.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
      AppMethodBeat.o(30132);
      return;
    }
    localf.md5 = ((String)localObject2);
    localObject2 = new dxe();
    ((dxe)localObject2).tlI = localf.id;
    ((dxe)localObject2).FDc = localf.talker;
    ((dxe)localObject2).Title = com.tencent.mm.plugin.wear.model.h.aAi(localf.talker);
    ((dxe)localObject2).hkR = j(localf.talker, (ArrayList)localObject1);
    ((dxe)localObject2).FGG = this.cYG;
    ((dxe)localObject2).GdP = this.doY;
    boolean bool;
    if (!bu.eWq()) {
      bool = true;
    }
    for (;;)
    {
      ((dxe)localObject2).GdO = bool;
      localObject1 = com.tencent.mm.plugin.wear.model.h.aAh(localf.talker);
      if (localObject1 != null) {
        ((dxe)localObject2).Gdx = new com.tencent.mm.bw.b(com.tencent.mm.plugin.wear.model.h.aq((Bitmap)localObject1));
      }
      ac.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
      try
      {
        com.tencent.mm.plugin.wear.model.a.ewt();
        r.a(20003, ((dxe)localObject2).toByteArray(), true);
        label370:
        ac.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
        com.tencent.mm.plugin.wear.model.a.ewn().a(localf);
        com.tencent.mm.plugin.wear.model.a.ewn().aAg(this.talker);
        com.tencent.mm.plugin.wear.model.c.a.iC(6, 0);
        com.tencent.mm.plugin.wear.model.c.a.Ua(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.j
 * JD-Core Version:    0.7.0.1
 */