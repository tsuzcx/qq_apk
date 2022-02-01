package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class r
  extends b
{
  boolean HhM;
  private c HhN;
  private boolean Hhx;
  private TextView ica;
  private ImageView kXS;
  private View pf;
  
  public r(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38859);
    this.Hhx = false;
    this.pf = null;
    this.HhM = false;
    if ((!this.Hhx) && (this.view != null))
    {
      this.pf = this.view.findViewById(2131305954);
      this.ica = ((TextView)this.view.findViewById(2131305952));
      this.kXS = ((ImageView)this.view.findViewById(2131305953));
      this.Hhx = true;
      this.HhN = new c() {};
      a.ESL.c(this.HhN);
    }
    AppMethodBeat.o(38859);
  }
  
  public final boolean boZ()
  {
    AppMethodBeat.i(38860);
    if (!this.HhM)
    {
      ad.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", new Object[] { Boolean.valueOf(this.HhM) });
      this.pf.setVisibility(8);
      AppMethodBeat.o(38860);
      return false;
    }
    if (!l.azs())
    {
      ad.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
      this.HhM = false;
      this.pf.setVisibility(8);
      AppMethodBeat.o(38860);
      return false;
    }
    this.ica.setText(2131756419);
    this.kXS.setVisibility(0);
    this.pf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38858);
        ad.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
        r.this.setVisibility(8);
        a.ESL.l(new vw());
        ad.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
        AppMethodBeat.o(38858);
      }
    });
    this.pf.setVisibility(0);
    if (this.pf.getVisibility() == 0) {}
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
    a.ESL.d(this.HhN);
    AppMethodBeat.o(38862);
  }
  
  public final int getLayoutId()
  {
    return 2131495808;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38861);
    if (this.pf != null) {
      this.pf.setVisibility(paramInt);
    }
    AppMethodBeat.o(38861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.r
 * JD-Core Version:    0.7.0.1
 */