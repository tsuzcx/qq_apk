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
  public static final int Miq = 2131495269;
  private Drawable MiD;
  private b.b<c> MiE;
  private b.d<c> MiF;
  private boolean MiG;
  private b<Boolean, c> MiH;
  private b<Boolean, c> MiI;
  private Drawable Mir;
  private b.b<c> Mis;
  private CharSequence wUo;
  
  public final int getLayoutResource()
  {
    return Miq;
  }
  
  public final class a
    extends d.a
  {
    ImageView MiK;
    ImageView MiL;
    ImageView MiM;
    TextView MiN;
    View MiO;
    ImageView zCz;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159942);
      this.MiK = ((ImageView)paramView.findViewById(2131300959));
      this.MiN = ((TextView)paramView.findViewById(2131304182));
      this.MiL = ((ImageView)paramView.findViewById(2131304190));
      this.MiO = paramView.findViewById(2131304191);
      this.zCz = ((ImageView)paramView.findViewById(2131304172));
      this.MiM = ((ImageView)paramView.findViewById(2131304181));
      AppMethodBeat.o(159942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.c
 * JD-Core Version:    0.7.0.1
 */