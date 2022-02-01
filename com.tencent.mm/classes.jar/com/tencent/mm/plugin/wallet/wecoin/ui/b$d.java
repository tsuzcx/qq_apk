package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinCustomAmountInputDialog$bindAction$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$d
  implements TextWatcher
{
  b$d(b paramb) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(316071);
    s.u(paramEditable, "s");
    paramEditable = paramEditable.toString();
    b.a(this.Vwk, paramEditable);
    AppMethodBeat.o(316071);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(316060);
    s.u(paramCharSequence, "s");
    AppMethodBeat.o(316060);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(316065);
    s.u(paramCharSequence, "s");
    AppMethodBeat.o(316065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.b.d
 * JD-Core Version:    0.7.0.1
 */