package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.xa;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class r
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private boolean KyY;
  boolean Kzm;
  private c Kzn;
  private TextView iVq;
  private ImageView lZa;
  private View rY;
  
  public r(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38859);
    this.KyY = false;
    this.rY = null;
    this.Kzm = false;
    if ((!this.KyY) && (this.view != null))
    {
      this.rY = this.view.findViewById(2131305954);
      this.iVq = ((TextView)this.view.findViewById(2131305952));
      this.lZa = ((ImageView)this.view.findViewById(2131305953));
      this.KyY = true;
      this.Kzn = new c() {};
      com.tencent.mm.sdk.b.a.IbL.c(this.Kzn);
    }
    AppMethodBeat.o(38859);
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(38860);
    if (!this.Kzm)
    {
      ad.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", new Object[] { Boolean.valueOf(this.Kzm) });
      this.rY.setVisibility(8);
      AppMethodBeat.o(38860);
      return false;
    }
    if (!l.aJs())
    {
      ad.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
      this.Kzm = false;
      this.rY.setVisibility(8);
      AppMethodBeat.o(38860);
      return false;
    }
    this.iVq.setText(2131756419);
    this.lZa.setVisibility(0);
    this.rY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38858);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/TryNewInitBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
        r.this.setVisibility(8);
        com.tencent.mm.sdk.b.a.IbL.l(new xa());
        ad.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/TryNewInitBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(38858);
      }
    });
    this.rY.setVisibility(0);
    if (this.rY.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.TryNewInitBanner", "summerinit update set visible [%b]", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(38860);
      return true;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38862);
    com.tencent.mm.sdk.b.a.IbL.d(this.Kzn);
    AppMethodBeat.o(38862);
  }
  
  public final int getLayoutId()
  {
    return 2131495808;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38861);
    if (this.rY != null) {
      this.rY.setVisibility(paramInt);
    }
    AppMethodBeat.o(38861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.r
 * JD-Core Version:    0.7.0.1
 */