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
  public static final int Sno = 2131496344;
  private CharSequence Bic;
  private Drawable SnB;
  private b.b<d> SnC;
  private g.a SnN;
  private b.c<d> SnO;
  private Drawable Snp;
  private b.b<d> Snq;
  
  public final int getLayoutResource()
  {
    return Sno;
  }
  
  public static class a
    extends a
  {
    public TextView BfZ;
    public ImageView SnI;
    public TextView Snt;
    public ImageView Snu;
    public ImageView Snv;
    public TextView titleTv;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159949);
      this.titleTv = ((TextView)paramView.findViewById(16908310));
      this.Snv = ((ImageView)paramView.findViewById(2131303139));
      this.SnI = ((ImageView)paramView.findViewById(2131307094));
      this.Snt = ((TextView)paramView.findViewById(2131309007));
      this.Snu = ((ImageView)paramView.findViewById(2131302593));
      this.BfZ = ((TextView)paramView.findViewById(2131308767));
      AppMethodBeat.o(159949);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.d
 * JD-Core Version:    0.7.0.1
 */