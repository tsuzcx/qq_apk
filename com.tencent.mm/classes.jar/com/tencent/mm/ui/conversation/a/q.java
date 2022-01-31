package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class q
  extends b
{
  boolean AnA;
  private c AnB;
  private boolean Anm;
  private TextView gpL;
  private ImageView ivs;
  private View jIo;
  
  public q(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(34735);
    this.Anm = false;
    this.jIo = null;
    this.AnA = false;
    if ((!this.Anm) && (this.view != null))
    {
      this.jIo = this.view.findViewById(2131828645);
      this.gpL = ((TextView)this.view.findViewById(2131828647));
      this.ivs = ((ImageView)this.view.findViewById(2131828646));
      this.Anm = true;
      this.AnB = new q.1(this);
      a.ymk.c(this.AnB);
    }
    AppMethodBeat.o(34735);
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(34736);
    if (!this.AnA)
    {
      ab.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", new Object[] { Boolean.valueOf(this.AnA) });
      this.jIo.setVisibility(8);
      AppMethodBeat.o(34736);
      return false;
    }
    if (!k.ail())
    {
      ab.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
      this.AnA = false;
      this.jIo.setVisibility(8);
      AppMethodBeat.o(34736);
      return false;
    }
    this.gpL.setText(2131297532);
    this.ivs.setVisibility(0);
    this.jIo.setOnClickListener(new q.2(this));
    this.jIo.setVisibility(0);
    if (this.jIo.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.TryNewInitBanner", "summerinit update set visible [%b]", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(34736);
      return true;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(34738);
    a.ymk.d(this.AnB);
    AppMethodBeat.o(34738);
  }
  
  public final int getLayoutId()
  {
    return 2130971043;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(34737);
    if (this.jIo != null) {
      this.jIo.setVisibility(paramInt);
    }
    AppMethodBeat.o(34737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.q
 * JD-Core Version:    0.7.0.1
 */