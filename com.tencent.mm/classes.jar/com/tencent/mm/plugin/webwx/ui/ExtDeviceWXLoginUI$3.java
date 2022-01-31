package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class ExtDeviceWXLoginUI$3
  implements View.OnClickListener
{
  ExtDeviceWXLoginUI$3(ExtDeviceWXLoginUI paramExtDeviceWXLoginUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26523);
    if (ExtDeviceWXLoginUI.b(this.vux) == 0)
    {
      if (ExtDeviceWXLoginUI.c(this.vux))
      {
        boolean bool = ((CheckBox)this.vux.findViewById(2131823389)).isChecked();
        ExtDeviceWXLoginUI.a(this.vux, false);
        if (bool)
        {
          aw.aaz();
          c.Ru().set(ac.a.yEn, Boolean.TRUE);
          paramView = this.vux;
          if ((!ExtDeviceWXLoginUI.c(this.vux)) || (!bool)) {
            break label158;
          }
        }
        label158:
        for (bool = true;; bool = false)
        {
          ExtDeviceWXLoginUI.b(paramView, bool);
          AppMethodBeat.o(26523);
          return;
          aw.aaz();
          if (((Boolean)c.Ru().get(ac.a.yEn, Boolean.TRUE)).booleanValue()) {
            ExtDeviceWXLoginUI.a(this.vux, true);
          }
          aw.aaz();
          c.Ru().set(ac.a.yEn, Boolean.FALSE);
          break;
        }
      }
      ExtDeviceWXLoginUI.b(this.vux, false);
      AppMethodBeat.o(26523);
      return;
    }
    if (ExtDeviceWXLoginUI.b(this.vux) == -2)
    {
      paramView = new Intent();
      paramView.putExtra("BaseScanUI_select_scan_mode", 1);
      paramView.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
      paramView.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
      paramView.putExtra("from_album", false);
      paramView.putExtra("show_intro", false);
      paramView.setFlags(65536);
      d.b(this.vux, "scanner", ".ui.BaseScanUI", paramView);
      this.vux.finish();
    }
    AppMethodBeat.o(26523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.3
 * JD-Core Version:    0.7.0.1
 */