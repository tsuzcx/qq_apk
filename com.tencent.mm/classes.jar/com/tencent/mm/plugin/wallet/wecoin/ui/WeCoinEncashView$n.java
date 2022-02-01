package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"})
final class WeCoinEncashView$n
  implements TextView.OnEditorActionListener
{
  WeCoinEncashView$n(View.OnClickListener paramOnClickListener) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(270482);
    if (paramKeyEvent == null)
    {
      AppMethodBeat.o(270482);
      return true;
    }
    if ((paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 66))
    {
      Log.i("MicroMsg.WeCoinEncashView", "click enter");
      this.OGQ.onClick(null);
      AppMethodBeat.o(270482);
      return true;
    }
    AppMethodBeat.o(270482);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinEncashView.n
 * JD-Core Version:    0.7.0.1
 */