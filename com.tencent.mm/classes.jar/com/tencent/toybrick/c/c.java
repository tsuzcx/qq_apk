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
  public static final int Sno = 2131496119;
  private CharSequence Bic;
  private Drawable SnB;
  private b.b<c> SnC;
  private b.d<c> SnD;
  private boolean SnE;
  private b<Boolean, c> SnF;
  private b<Boolean, c> SnG;
  private Drawable Snp;
  private b.b<c> Snq;
  
  public final int getLayoutResource()
  {
    return Sno;
  }
  
  public final class a
    extends d.a
  {
    ImageView EbJ;
    ImageView SnI;
    ImageView SnJ;
    ImageView SnK;
    TextView SnL;
    View SnM;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159942);
      this.SnI = ((ImageView)paramView.findViewById(2131302595));
      this.SnL = ((TextView)paramView.findViewById(2131307091));
      this.SnJ = ((ImageView)paramView.findViewById(2131307102));
      this.SnM = paramView.findViewById(2131307104);
      this.EbJ = ((ImageView)paramView.findViewById(2131307076));
      this.SnK = ((ImageView)paramView.findViewById(2131307090));
      AppMethodBeat.o(159942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.c
 * JD-Core Version:    0.7.0.1
 */