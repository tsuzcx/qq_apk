package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.g.a.eh.a;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.el.a;
import com.tencent.mm.sdk.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ChattingSendDataToDeviceUI$b
{
  public ChattingSendDataToDeviceUI$b(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI) {}
  
  private boolean n(b paramb)
  {
    AppMethodBeat.i(30785);
    paramb = (el)paramb;
    String str1 = paramb.csl.csn;
    String str2 = paramb.csl.bYu;
    if (str1.equals("send_data_sending")) {
      ChattingSendDataToDeviceUI.a(this.zAW, "send_data_sending", str2, paramb.csl.progress);
    }
    for (;;)
    {
      AppMethodBeat.o(30785);
      return true;
      if (str1.equals("send_data_failed")) {
        ChattingSendDataToDeviceUI.a(this.zAW, "send_data_failed", str2, 0);
      } else if (str1.equals("send_data_sucess")) {
        this.zAW.atK(str2);
      }
    }
  }
  
  private boolean o(b paramb)
  {
    AppMethodBeat.i(30786);
    paramb = ((eh)paramb).csa.crn;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramb.size())
    {
      ChattingSendDataToDeviceUI.c localc = new ChattingSendDataToDeviceUI.c(this.zAW);
      localc.cqJ = ((String)((Map)paramb.get(i)).get("deviceType"));
      localc.deviceID = ((String)((Map)paramb.get(i)).get("deviceID"));
      localc.elx = ((String)((Map)paramb.get(i)).get("displayName"));
      localc.iconUrl = ((String)((Map)paramb.get(i)).get("iconUrl"));
      localc.csi = ((String)((Map)paramb.get(i)).get("ability"));
      localc.zBi = ((String)((Map)paramb.get(i)).get("abilityInf"));
      if (((this.zAW.csj) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.f(this.zAW)))) || ((!this.zAW.csj) && (ChattingSendDataToDeviceUI.b(localc, ChattingSendDataToDeviceUI.g(this.zAW)))))
      {
        if ((ChattingSendDataToDeviceUI.d(this.zAW).containsKey(localc.deviceID)) && (((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(this.zAW).get(localc.deviceID)).csn != null))
        {
          localc.csn = ((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(this.zAW).get(localc.deviceID)).csn;
          localc.progress = ((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(this.zAW).get(localc.deviceID)).progress;
        }
        localArrayList.add(localc);
      }
      i += 1;
    }
    if (ChattingSendDataToDeviceUI.l(this.zAW).size() != localArrayList.size())
    {
      ChattingSendDataToDeviceUI.a(this.zAW, localArrayList);
      this.zAW.runOnUiThread(new ChattingSendDataToDeviceUI.b.1(this));
    }
    AppMethodBeat.o(30786);
    return true;
  }
  
  public final boolean m(b paramb)
  {
    AppMethodBeat.i(30784);
    boolean bool;
    if ((paramb instanceof eh))
    {
      bool = o(paramb);
      AppMethodBeat.o(30784);
      return bool;
    }
    if ((paramb instanceof el))
    {
      bool = n(paramb);
      AppMethodBeat.o(30784);
      return bool;
    }
    AppMethodBeat.o(30784);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.b
 * JD-Core Version:    0.7.0.1
 */