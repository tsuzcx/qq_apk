package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.ah;

final class h$12
  implements DialogInterface.OnClickListener
{
  h$12(h paramh) {}
  
  public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29325);
    paramDialogInterface = this.yXo.qHE.getText().toString();
    this.yXo.qHE.setText("");
    this.yXo.qHE.clearFocus();
    ah.a(this.yXo.yXg, this.yXo.qHE);
    if ((paramDialogInterface == null) || (paramDialogInterface.equals("")))
    {
      com.tencent.mm.ui.base.h.a(this.yXo.yXg, 2131304500, 2131297087, new h.12.1(this));
      AppMethodBeat.o(29325);
      return;
    }
    this.yXo.dBF();
    aw.Rc().a(384, this.yXo.yXj);
    paramDialogInterface = new ac(paramDialogInterface, "", "", "");
    aw.Rc().a(paramDialogInterface, 0);
    h localh = this.yXo;
    MMFragmentActivity localMMFragmentActivity = this.yXo.yXg;
    this.yXo.getString(2131297087);
    localh.eeN = com.tencent.mm.ui.base.h.b(localMMFragmentActivity, this.yXo.getString(2131303292), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(29324);
        aw.Rc().b(384, h.12.this.yXo.yXj);
        h.12.this.yXo.yXj = null;
        aw.Rc().a(paramDialogInterface);
        AppMethodBeat.o(29324);
      }
    });
    AppMethodBeat.o(29325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.h.12
 * JD-Core Version:    0.7.0.1
 */