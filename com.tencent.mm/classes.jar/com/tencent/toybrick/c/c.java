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
  public static final int IGe = 2131495269;
  private Drawable IGf;
  private b.b<c> IGg;
  private Drawable IGr;
  private b.b<c> IGs;
  private b.d<c> IGt;
  private boolean IGu;
  private b<Boolean, c> IGv;
  private b<Boolean, c> IGw;
  private CharSequence uEo;
  
  public final int getLayoutResource()
  {
    return IGe;
  }
  
  public final class a
    extends d.a
  {
    ImageView IGA;
    TextView IGB;
    View IGC;
    ImageView IGy;
    ImageView IGz;
    ImageView wYW;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159942);
      this.IGy = ((ImageView)paramView.findViewById(2131300959));
      this.IGB = ((TextView)paramView.findViewById(2131304182));
      this.IGz = ((ImageView)paramView.findViewById(2131304190));
      this.IGC = paramView.findViewById(2131304191);
      this.wYW = ((ImageView)paramView.findViewById(2131304172));
      this.IGA = ((ImageView)paramView.findViewById(2131304181));
      AppMethodBeat.o(159942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.c.c
 * JD-Core Version:    0.7.0.1
 */