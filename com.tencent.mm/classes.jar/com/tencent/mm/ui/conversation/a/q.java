package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.lr;
import com.tencent.mm.f.a.zm;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private boolean XFO;
  boolean XGc;
  private View bvK;
  private TextView mNb;
  private ImageView qps;
  private IListener tLW;
  
  public q(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38859);
    this.XFO = false;
    this.bvK = null;
    this.XGc = false;
    if ((!this.XFO) && (this.view != null))
    {
      this.bvK = this.view.findViewById(R.h.dXD);
      this.mNb = ((TextView)this.view.findViewById(R.h.dXB));
      this.qps = ((ImageView)this.view.findViewById(R.h.dXC));
      this.XFO = true;
      this.tLW = new IListener() {};
      EventCenter.instance.addListener(this.tLW);
    }
    AppMethodBeat.o(38859);
  }
  
  public final boolean ckL()
  {
    AppMethodBeat.i(38860);
    if (!this.XGc)
    {
      Log.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", new Object[] { Boolean.valueOf(this.XGc) });
      this.bvK.setVisibility(8);
      AppMethodBeat.o(38860);
      return false;
    }
    if (!l.bni())
    {
      Log.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
      this.XGc = false;
      this.bvK.setVisibility(8);
      AppMethodBeat.o(38860);
      return false;
    }
    this.mNb.setText(R.l.esB);
    this.qps.setVisibility(0);
    this.bvK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38858);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/conversation/banner/TryNewInitBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
        q.this.setVisibility(8);
        EventCenter.instance.publish(new zm());
        Log.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
        a.a(this, "com/tencent/mm/ui/conversation/banner/TryNewInitBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(38858);
      }
    });
    this.bvK.setVisibility(0);
    if (this.bvK.getVisibility() == 0) {}
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
    EventCenter.instance.removeListener(this.tLW);
    AppMethodBeat.o(38862);
  }
  
  public final int getLayoutId()
  {
    return R.i.elA;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38861);
    if (this.bvK != null) {
      this.bvK.setVisibility(paramInt);
    }
    AppMethodBeat.o(38861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.q
 * JD-Core Version:    0.7.0.1
 */