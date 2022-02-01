package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class r
  extends b
{
  private boolean IHQ;
  boolean IIf;
  private c IIg;
  private TextView iCg;
  private ImageView lzC;
  private View qe;
  
  public r(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38859);
    this.IHQ = false;
    this.qe = null;
    this.IIf = false;
    if ((!this.IHQ) && (this.view != null))
    {
      this.qe = this.view.findViewById(2131305954);
      this.iCg = ((TextView)this.view.findViewById(2131305952));
      this.lzC = ((ImageView)this.view.findViewById(2131305953));
      this.IHQ = true;
      this.IIg = new c() {};
      a.GpY.c(this.IIg);
    }
    AppMethodBeat.o(38859);
  }
  
  public final boolean bvU()
  {
    AppMethodBeat.i(38860);
    if (!this.IIf)
    {
      ac.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", new Object[] { Boolean.valueOf(this.IIf) });
      this.qe.setVisibility(8);
      AppMethodBeat.o(38860);
      return false;
    }
    if (!l.aGj())
    {
      ac.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
      this.IIf = false;
      this.qe.setVisibility(8);
      AppMethodBeat.o(38860);
      return false;
    }
    this.iCg.setText(2131756419);
    this.lzC.setVisibility(0);
    this.qe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38858);
        ac.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
        r.this.setVisibility(8);
        a.GpY.l(new wh());
        ac.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
        AppMethodBeat.o(38858);
      }
    });
    this.qe.setVisibility(0);
    if (this.qe.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.TryNewInitBanner", "summerinit update set visible [%b]", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(38860);
      return true;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38862);
    a.GpY.d(this.IIg);
    AppMethodBeat.o(38862);
  }
  
  public final int getLayoutId()
  {
    return 2131495808;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38861);
    if (this.qe != null) {
      this.qe.setVisibility(paramInt);
    }
    AppMethodBeat.o(38861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.r
 * JD-Core Version:    0.7.0.1
 */