package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;
import org.xwalk.core.Log;

public final class b
  extends i
{
  private ImageView Img;
  ViewGroup Imh;
  private View jBN;
  TextView mPa;
  
  public b(Context paramContext)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(71417);
    this.jBN = View.inflate(getContext(), 2131497037, null);
    this.Img = ((ImageView)this.jBN.findViewById(2131310570));
    this.Imh = ((ViewGroup)this.jBN.findViewById(2131310571));
    this.mPa = ((TextView)this.jBN.findViewById(2131310343));
    paramContext = this.Img;
    int i = WcPayCashierDialog.Ill;
    int j = WcPayCashierDialog.Ill;
    Util.expandViewTouchArea(paramContext, i, i, j, j);
    this.Img.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71416);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFetchFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.WcPayCashierFetchFavorDialog", "click back");
        b.this.cancel();
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/cashier/WcPayCashierFetchFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71416);
      }
    });
    setContentView(this.jBN);
    setCanceledOnTouchOutside(false);
    AppMethodBeat.o(71417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.b
 * JD-Core Version:    0.7.0.1
 */