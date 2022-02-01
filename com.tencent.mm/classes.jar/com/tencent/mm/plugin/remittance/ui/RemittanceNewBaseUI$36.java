package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.fib;
import com.tencent.mm.protocal.protobuf.fid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.g;

final class RemittanceNewBaseUI$36
  implements View.OnClickListener
{
  RemittanceNewBaseUI$36(RemittanceNewBaseUI paramRemittanceNewBaseUI, fid paramfid) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(272831);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.RemittanceNewBaseUI", " click option item : %s ,type:%s", new Object[] { this.Isc.wording, Integer.valueOf(this.Isc.UHY.type) });
    switch (this.Isc.UHY.type)
    {
    default: 
      Log.e("MicroMsg.RemittanceNewBaseUI", "unknow text info type");
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceNewBaseUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(272831);
      return;
      Log.i("MicroMsg.RemittanceNewBaseUI", " textInfo.jumpInfo.url ：%s", new Object[] { this.Isc.UHY.url });
      g.p(this.IuE.getContext(), this.Isc.UHY.url, false);
      continue;
      Log.i("MicroMsg.RemittanceNewBaseUI", " textInfo.jumpInfo.username ：%s", new Object[] { this.Isc.UHY.username });
      g.v(this.Isc.UHY.username, this.Isc.UHY.InB, 0, 1000);
      continue;
      Log.e("MicroMsg.RemittanceNewBaseUI", " text info type is OPTIONS_MENU_ITEM_JUMP_TYPE_NATIVE");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.36
 * JD-Core Version:    0.7.0.1
 */