package com.tencent.toybrick.c;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.g.b;
import com.tencent.toybrick.g.b.b;
import com.tencent.toybrick.g.b.d;

public final class c
  extends g<c, a>
{
  public static final int Ksp = 2131495269;
  private Drawable KsC;
  private b.b<c> KsD;
  private b.d<c> KsE;
  private boolean KsF;
  private b<Boolean, c> KsG;
  private b<Boolean, c> KsH;
  private Drawable Ksq;
  private b.b<c> Ksr;
  private CharSequence vNf;
  
  public final int getLayoutResource()
  {
    return Ksp;
  }
  
  public final class a
    extends d.a
  {
    ImageView KsJ;
    ImageView KsK;
    ImageView KsL;
    TextView KsM;
    View KsN;
    ImageView ylK;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159942);
      this.KsJ = ((ImageView)paramView.findViewById(2131300959));
      this.KsM = ((TextView)paramView.findViewById(2131304182));
      this.KsK = ((ImageView)paramView.findViewById(2131304190));
      this.KsN = paramView.findViewById(2131304191);
      this.ylK = ((ImageView)paramView.findViewById(2131304172));
      this.KsL = ((ImageView)paramView.findViewById(2131304181));
      AppMethodBeat.o(159942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.c.c
 * JD-Core Version:    0.7.0.1
 */