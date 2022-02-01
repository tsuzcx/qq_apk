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
  public static final int Miq = 2131495469;
  private Drawable MiD;
  private b.b<d> MiE;
  private g.a MiP;
  private b.c<d> MiQ;
  private Drawable Mir;
  private b.b<d> Mis;
  private CharSequence wUo;
  
  public final int getLayoutResource()
  {
    return Miq;
  }
  
  public static class a
    extends a
  {
    public ImageView MiK;
    public TextView Miv;
    public ImageView Miw;
    public ImageView Mix;
    public TextView titleTv;
    public TextView wSo;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159949);
      this.titleTv = ((TextView)paramView.findViewById(16908310));
      this.Mix = ((ImageView)paramView.findViewById(2131301384));
      this.MiK = ((ImageView)paramView.findViewById(2131304185));
      this.Miv = ((TextView)paramView.findViewById(2131305740));
      this.Miw = ((ImageView)paramView.findViewById(2131300957));
      this.wSo = ((TextView)paramView.findViewById(2131305546));
      AppMethodBeat.o(159949);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.d
 * JD-Core Version:    0.7.0.1
 */