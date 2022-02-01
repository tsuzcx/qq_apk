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
  public static final int MFn = 2131495469;
  private Drawable MFA;
  private b.b<d> MFB;
  private g.a MFM;
  private b.c<d> MFN;
  private Drawable MFo;
  private b.b<d> MFp;
  private CharSequence xkf;
  
  public final int getLayoutResource()
  {
    return MFn;
  }
  
  public static class a
    extends a
  {
    public ImageView MFH;
    public TextView MFs;
    public ImageView MFt;
    public ImageView MFu;
    public TextView titleTv;
    public TextView xif;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159949);
      this.titleTv = ((TextView)paramView.findViewById(16908310));
      this.MFu = ((ImageView)paramView.findViewById(2131301384));
      this.MFH = ((ImageView)paramView.findViewById(2131304185));
      this.MFs = ((TextView)paramView.findViewById(2131305740));
      this.MFt = ((ImageView)paramView.findViewById(2131300957));
      this.xif = ((TextView)paramView.findViewById(2131305546));
      AppMethodBeat.o(159949);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.d
 * JD-Core Version:    0.7.0.1
 */