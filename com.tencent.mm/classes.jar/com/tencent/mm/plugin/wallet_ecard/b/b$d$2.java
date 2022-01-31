package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.protocal.protobuf.awn;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;

final class b$d$2
  implements DialogInterface.OnClickListener
{
  b$d$2(b.d paramd, EditText paramEditText, d paramd1, TextView paramTextView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48088);
    ab.i("MicroMsg.OpenECardProcess", "click verify btn");
    paramDialogInterface = this.uzw.getText().toString();
    if (paramDialogInterface.length() == 11)
    {
      this.uzv.AXB.addSceneEndListener(1985);
      bhv localbhv = (bhv)((com.tencent.mm.ai.b)this.uzx.getReqResp()).fsV.fta;
      b.o(this.uzv.uzs).putInt(a.uzg, 2);
      paramDialogInterface = new d(b.b(this.uzv.uzs), localbhv.wvo, localbhv.xwP, paramDialogInterface, localbhv.poq, b.n(this.uzv.uzs), true, 2, localbhv.xwS);
      this.uzv.AXB.a(paramDialogInterface, true, 1);
      AppMethodBeat.o(48088);
      return;
    }
    paramDialogInterface = new awn();
    paramDialogInterface.xma = new yd();
    paramDialogInterface.xma.desc = this.uzv.hwZ.getString(2131299058);
    paramDialogInterface.xma.color = "#FA5151";
    paramDialogInterface.xmb = new yd();
    paramDialogInterface.xmb.desc = this.uzv.hwZ.getString(2131299057);
    paramDialogInterface.xmb.color = "#0C4F8E";
    this.uzv.a(paramDialogInterface, this.uzy);
    AppMethodBeat.o(48088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.d.2
 * JD-Core Version:    0.7.0.1
 */