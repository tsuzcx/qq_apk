package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.ui.base.h;

final class j$12
  implements DialogInterface.OnClickListener
{
  j$12(j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.uJI.nTE.getText().toString();
    this.uJI.nTE.setText("");
    this.uJI.nTE.clearFocus();
    ah.a(this.uJI.uJA, this.uJI.nTE);
    if ((paramDialogInterface == null) || (paramDialogInterface.equals("")))
    {
      h.a(this.uJI.uJA, R.l.verify_password_null_tip, R.l.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      return;
    }
    this.uJI.cyB();
    au.Dk().a(384, this.uJI.uJD);
    paramDialogInterface = new ab(paramDialogInterface, "", "", "");
    au.Dk().a(paramDialogInterface, 0);
    j localj = this.uJI;
    MMFragmentActivity localMMFragmentActivity = this.uJI.uJA;
    this.uJI.getString(R.l.app_tip);
    localj.dnm = h.b(localMMFragmentActivity, this.uJI.getString(R.l.settings_loading), true, new j.12.2(this, paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.j.12
 * JD-Core Version:    0.7.0.1
 */