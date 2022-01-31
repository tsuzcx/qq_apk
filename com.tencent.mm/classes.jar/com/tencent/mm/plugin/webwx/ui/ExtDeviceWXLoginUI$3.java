package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.R.h;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class ExtDeviceWXLoginUI$3
  implements View.OnClickListener
{
  ExtDeviceWXLoginUI$3(ExtDeviceWXLoginUI paramExtDeviceWXLoginUI) {}
  
  public final void onClick(View paramView)
  {
    if (ExtDeviceWXLoginUI.b(this.rDV) == 0) {
      if (ExtDeviceWXLoginUI.c(this.rDV))
      {
        bool = ((CheckBox)this.rDV.findViewById(R.h.status_content_checkbox)).isChecked();
        ExtDeviceWXLoginUI.a(this.rDV, false);
        if (bool)
        {
          au.Hx();
          c.Dz().c(ac.a.uuk, Boolean.valueOf(true));
          paramView = this.rDV;
          if ((!ExtDeviceWXLoginUI.c(this.rDV)) || (!bool)) {
            break label150;
          }
          bool = true;
          ExtDeviceWXLoginUI.b(paramView, bool);
        }
      }
    }
    label150:
    while (ExtDeviceWXLoginUI.b(this.rDV) != -2)
    {
      for (;;)
      {
        return;
        au.Hx();
        if (((Boolean)c.Dz().get(ac.a.uuk, Boolean.valueOf(true))).booleanValue()) {
          ExtDeviceWXLoginUI.a(this.rDV, true);
        }
        au.Hx();
        c.Dz().c(ac.a.uuk, Boolean.valueOf(false));
        continue;
        boolean bool = false;
      }
      ExtDeviceWXLoginUI.b(this.rDV, false);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("BaseScanUI_select_scan_mode", 1);
    paramView.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
    paramView.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
    paramView.putExtra("from_album", false);
    paramView.putExtra("show_intro", false);
    paramView.setFlags(65536);
    d.b(this.rDV, "scanner", ".ui.BaseScanUI", paramView);
    this.rDV.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.3
 * JD-Core Version:    0.7.0.1
 */