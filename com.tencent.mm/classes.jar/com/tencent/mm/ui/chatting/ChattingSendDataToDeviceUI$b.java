package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.mm.h.a.ee;
import com.tencent.mm.h.a.ee.a;
import com.tencent.mm.h.a.ei;
import com.tencent.mm.h.a.ei.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ChattingSendDataToDeviceUI$b
{
  public ChattingSendDataToDeviceUI$b(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI) {}
  
  public final boolean n(b paramb)
  {
    int i;
    Object localObject2;
    if ((paramb instanceof ee))
    {
      paramb = ((ee)paramb).bKG.bJT;
      localObject1 = new ArrayList();
      i = 0;
      while (i < paramb.size())
      {
        localObject2 = new ChattingSendDataToDeviceUI.c(this.vlx);
        ((ChattingSendDataToDeviceUI.c)localObject2).bJp = ((String)((Map)paramb.get(i)).get("deviceType"));
        ((ChattingSendDataToDeviceUI.c)localObject2).deviceID = ((String)((Map)paramb.get(i)).get("deviceID"));
        ((ChattingSendDataToDeviceUI.c)localObject2).dtK = ((String)((Map)paramb.get(i)).get("displayName"));
        ((ChattingSendDataToDeviceUI.c)localObject2).iconUrl = ((String)((Map)paramb.get(i)).get("iconUrl"));
        ((ChattingSendDataToDeviceUI.c)localObject2).bKO = ((String)((Map)paramb.get(i)).get("ability"));
        ((ChattingSendDataToDeviceUI.c)localObject2).vlJ = ((String)((Map)paramb.get(i)).get("abilityInf"));
        if (((this.vlx.bKP) && (ChattingSendDataToDeviceUI.b((ChattingSendDataToDeviceUI.c)localObject2, ChattingSendDataToDeviceUI.f(this.vlx)))) || ((!this.vlx.bKP) && (ChattingSendDataToDeviceUI.b((ChattingSendDataToDeviceUI.c)localObject2, ChattingSendDataToDeviceUI.g(this.vlx)))))
        {
          if ((ChattingSendDataToDeviceUI.d(this.vlx).containsKey(((ChattingSendDataToDeviceUI.c)localObject2).deviceID)) && (((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(this.vlx).get(((ChattingSendDataToDeviceUI.c)localObject2).deviceID)).bKT != null))
          {
            ((ChattingSendDataToDeviceUI.c)localObject2).bKT = ((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(this.vlx).get(((ChattingSendDataToDeviceUI.c)localObject2).deviceID)).bKT;
            ((ChattingSendDataToDeviceUI.c)localObject2).progress = ((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(this.vlx).get(((ChattingSendDataToDeviceUI.c)localObject2).deviceID)).progress;
          }
          ((List)localObject1).add(localObject2);
        }
        i += 1;
      }
      if (ChattingSendDataToDeviceUI.l(this.vlx).size() != ((List)localObject1).size())
      {
        ChattingSendDataToDeviceUI.a(this.vlx, (List)localObject1);
        this.vlx.runOnUiThread(new ChattingSendDataToDeviceUI.b.1(this));
      }
    }
    do
    {
      do
      {
        return true;
      } while (!(paramb instanceof ei));
      localObject1 = (ei)paramb;
      localObject2 = ((ei)localObject1).bKR.bKT;
      paramb = ((ei)localObject1).bKR.bwK;
      if (((String)localObject2).equals("send_data_sending"))
      {
        ChattingSendDataToDeviceUI.a(this.vlx, "send_data_sending", paramb, ((ei)localObject1).bKR.progress);
        return true;
      }
      if (((String)localObject2).equals("send_data_failed"))
      {
        ChattingSendDataToDeviceUI.a(this.vlx, "send_data_failed", paramb, 0);
        return true;
      }
    } while (!((String)localObject2).equals("send_data_sucess"));
    Object localObject1 = this.vlx;
    for (;;)
    {
      int j;
      try
      {
        i = ((Integer)((ChattingSendDataToDeviceUI)localObject1).vlt.get(paramb)).intValue();
        localObject2 = (as)((View)((ChattingSendDataToDeviceUI)localObject1).vls.get(Integer.valueOf(i))).getTag();
        y.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", new Object[] { Integer.valueOf(((as)localObject2).vnu.getProgress()), paramb });
        ChattingSendDataToDeviceUI.c localc = (ChattingSendDataToDeviceUI.c)((ChattingSendDataToDeviceUI)localObject1).vlr.get(paramb);
        ((ChattingSendDataToDeviceUI)localObject1).runOnUiThread(new ChattingSendDataToDeviceUI.7((ChattingSendDataToDeviceUI)localObject1, (as)localObject2, localc));
        j = Math.abs(((as)localObject2).vnu.getProgress());
        localc.progress = j;
        if (j >= 100)
        {
          i = 0;
          y.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", new Object[] { Integer.valueOf(i) });
          e.b(new ChattingSendDataToDeviceUI.8((ChattingSendDataToDeviceUI)localObject1, j, (as)localObject2, paramb, localc, i), "progressSuccess_handler").start();
          ((ChattingSendDataToDeviceUI)localObject1).vlr.put(localc.deviceID, localc);
          return true;
        }
      }
      catch (Exception paramb)
      {
        y.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", new Object[] { paramb });
        return true;
      }
      i = 500 / (100 - j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.b
 * JD-Core Version:    0.7.0.1
 */