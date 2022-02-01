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
  public static final int IGe = 2131495469;
  private g.a IGD;
  private b.c<d> IGE;
  private Drawable IGf;
  private b.b<d> IGg;
  private Drawable IGr;
  private b.b<d> IGs;
  private CharSequence uEo;
  
  public final int getLayoutResource()
  {
    return IGe;
  }
  
  public static class a
    extends a
  {
    public TextView IGj;
    public ImageView IGk;
    public ImageView IGl;
    public ImageView IGy;
    public TextView titleTv;
    public TextView uCm;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159949);
      this.titleTv = ((TextView)paramView.findViewById(16908310));
      this.IGl = ((ImageView)paramView.findViewById(2131301384));
      this.IGy = ((ImageView)paramView.findViewById(2131304185));
      this.IGj = ((TextView)paramView.findViewById(2131305740));
      this.IGk = ((ImageView)paramView.findViewById(2131300957));
      this.uCm = ((TextView)paramView.findViewById(2131305546));
      AppMethodBeat.o(159949);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.c.d
 * JD-Core Version:    0.7.0.1
 */