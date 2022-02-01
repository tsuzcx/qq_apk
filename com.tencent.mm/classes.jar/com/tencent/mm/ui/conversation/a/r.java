package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.yf;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private boolean QiI;
  boolean QiW;
  private TextView jVO;
  private ImageView nnL;
  private IListener qnf;
  private View sc;
  
  public r(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38859);
    this.QiI = false;
    this.sc = null;
    this.QiW = false;
    if ((!this.QiI) && (this.view != null))
    {
      this.sc = this.view.findViewById(2131309257);
      this.jVO = ((TextView)this.view.findViewById(2131309255));
      this.nnL = ((ImageView)this.view.findViewById(2131309256));
      this.QiI = true;
      this.qnf = new IListener() {};
      EventCenter.instance.addListener(this.qnf);
    }
    AppMethodBeat.o(38859);
  }
  
  public final boolean bYa()
  {
    AppMethodBeat.i(38860);
    if (!this.QiW)
    {
      Log.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", new Object[] { Boolean.valueOf(this.QiW) });
      this.sc.setVisibility(8);
      AppMethodBeat.o(38860);
      return false;
    }
    if (!l.bdN())
    {
      Log.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
      this.QiW = false;
      this.sc.setVisibility(8);
      AppMethodBeat.o(38860);
      return false;
    }
    this.jVO.setText(2131756554);
    this.nnL.setVisibility(0);
    this.sc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38858);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/conversation/banner/TryNewInitBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
        r.this.setVisibility(8);
        EventCenter.instance.publish(new yf());
        Log.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
        a.a(this, "com/tencent/mm/ui/conversation/banner/TryNewInitBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(38858);
      }
    });
    this.sc.setVisibility(0);
    if (this.sc.getVisibility() == 0) {}
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
    EventCenter.instance.removeListener(this.qnf);
    AppMethodBeat.o(38862);
  }
  
  public final int getLayoutId()
  {
    return 2131496766;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(38861);
    if (this.sc != null) {
      this.sc.setVisibility(paramInt);
    }
    AppMethodBeat.o(38861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.r
 * JD-Core Version:    0.7.0.1
 */