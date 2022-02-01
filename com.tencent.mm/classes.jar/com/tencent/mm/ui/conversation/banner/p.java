package com.tencent.mm.ui.conversation.banner;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.abg;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends com.tencent.mm.pluginsdk.ui.a.b
{
  private boolean aftM;
  boolean aftZ;
  private View doN;
  private TextView pJJ;
  private ImageView ttT;
  private IListener wPm;
  
  public p(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38859);
    this.aftM = false;
    this.doN = null;
    this.aftZ = false;
    if ((!this.aftM) && (this.view != null))
    {
      this.doN = this.view.findViewById(R.h.gai);
      this.pJJ = ((TextView)this.view.findViewById(R.h.gag));
      this.ttT = ((ImageView)this.view.findViewById(R.h.gah));
      this.aftM = true;
      this.wPm = new TryNewInitBanner.1(this, f.hfK);
      this.wPm.alive();
    }
    AppMethodBeat.o(38859);
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(38860);
    if (!this.aftZ)
    {
      Log.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", new Object[] { Boolean.valueOf(this.aftZ) });
      this.doN.setVisibility(8);
      AppMethodBeat.o(38860);
      return false;
    }
    if (!q.bKT())
    {
      Log.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
      this.aftZ = false;
      this.doN.setVisibility(8);
      AppMethodBeat.o(38860);
      return false;
    }
    this.pJJ.setText(R.l.gvC);
    this.ttT.setVisibility(0);
    this.doN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38858);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/conversation/banner/TryNewInitBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
        p.this.setVisibility(8);
        new abg().publish();
        Log.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
        a.a(this, "com/tencent/mm/ui/conversation/banner/TryNewInitBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(38858);
      }
    });
    this.doN.setVisibility(0);
    if (this.doN.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.TryNewInitBanner", "summerinit update set visible [%b]", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(38860);
      return true;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(38862);
    this.wPm.dead();
    AppMethodBeat.o(38862);
  }
  
  public final int getLayoutId()
  {
    return R.i.goE;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38861);
    if (this.doN != null) {
      this.doN.setVisibility(paramInt);
    }
    AppMethodBeat.o(38861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.p
 * JD-Core Version:    0.7.0.1
 */