package com.tencent.toybrick.c;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.e.c.a;
import com.tencent.toybrick.f.a;
import com.tencent.toybrick.g.b.b;
import com.tencent.toybrick.g.b.c;

public final class d
  extends g<d, a>
{
  public static final int Ksp = 2131495469;
  private Drawable KsC;
  private b.b<d> KsD;
  private g.a KsO;
  private b.c<d> KsP;
  private Drawable Ksq;
  private b.b<d> Ksr;
  private CharSequence vNf;
  
  public final int getLayoutResource()
  {
    return Ksp;
  }
  
  public static class a
    extends a
  {
    public ImageView KsJ;
    public TextView Ksu;
    public ImageView Ksv;
    public ImageView Ksw;
    public TextView titleTv;
    public TextView vLf;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159949);
      this.titleTv = ((TextView)paramView.findViewById(16908310));
      this.Ksw = ((ImageView)paramView.findViewById(2131301384));
      this.KsJ = ((ImageView)paramView.findViewById(2131304185));
      this.Ksu = ((TextView)paramView.findViewById(2131305740));
      this.Ksv = ((ImageView)paramView.findViewById(2131300957));
      this.vLf = ((TextView)paramView.findViewById(2131305546));
      AppMethodBeat.o(159949);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.c.d
 * JD-Core Version:    0.7.0.1
 */