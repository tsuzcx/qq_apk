package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.de;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.ek.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class ChattingSendDataToDeviceUI$1
  implements AdapterView.OnItemClickListener
{
  ChattingSendDataToDeviceUI$1(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(30760);
    this.zAW.zAM = true;
    ChattingSendDataToDeviceUI.c localc = ChattingSendDataToDeviceUI.a(this.zAW).Pt(paramInt);
    String str1 = localc.cqJ;
    paramAdapterView = localc.deviceID;
    String str2 = localc.csi;
    try
    {
      if (ChattingSendDataToDeviceUI.b(this.zAW).get(paramAdapterView) != null)
      {
        ab.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
        paramView = new de();
        paramView.cqF.bYu = paramAdapterView;
        a.ymk.l(paramView);
        ChattingSendDataToDeviceUI.a(this.zAW, "send_data_cancel", paramAdapterView, 0);
        localc.csn = "send_data_cancel";
        ChattingSendDataToDeviceUI.b(this.zAW).remove(paramAdapterView);
        paramAdapterView = (ap)((View)ChattingSendDataToDeviceUI.c(this.zAW).get(Integer.valueOf(paramInt))).getTag();
        paramAdapterView.zBd.setText(this.zAW.getText(2131298314));
        paramAdapterView.zBd.setTextColor(this.zAW.getResources().getColor(2131690438));
        paramAdapterView.zCQ.setVisibility(8);
        paramAdapterView.zCQ.Px(0);
        AppMethodBeat.o(30760);
        return;
      }
      localc.csn = "send_data_sending";
      ChattingSendDataToDeviceUI.d(this.zAW).put(localc.deviceID, localc);
      ChattingSendDataToDeviceUI.b(this.zAW).put(paramAdapterView, paramView);
      ChattingSendDataToDeviceUI.a(this.zAW, "send_data_sending", paramAdapterView, 1);
      ChattingSendDataToDeviceUI.a(this.zAW, 3);
      paramView = new ek();
      paramView.csg.bYu = paramAdapterView;
      paramView.csg.cqJ = str1;
      paramView.csg.data = ChattingSendDataToDeviceUI.e(this.zAW);
      paramView.csg.csi = str2;
      if (this.zAW.csj)
      {
        paramView.csg.crk = ChattingSendDataToDeviceUI.f(this.zAW);
        paramView.csg.csj = this.zAW.csj;
      }
      for (;;)
      {
        a.ymk.l(paramView);
        if (!paramView.csh.csk)
        {
          ChattingSendDataToDeviceUI.atL("send_data_failed");
          ab.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
        }
        AppMethodBeat.o(30760);
        return;
        paramView.csg.cpO = ChattingSendDataToDeviceUI.g(this.zAW);
      }
      return;
    }
    catch (Exception paramAdapterView)
    {
      ChattingSendDataToDeviceUI.atL("send_data_failed");
      ab.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", new Object[] { paramAdapterView });
      AppMethodBeat.o(30760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.1
 * JD-Core Version:    0.7.0.1
 */