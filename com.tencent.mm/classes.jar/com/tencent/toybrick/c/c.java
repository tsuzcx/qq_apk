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
  public static final int MFn = 2131495269;
  private Drawable MFA;
  private b.b<c> MFB;
  private b.d<c> MFC;
  private boolean MFD;
  private b<Boolean, c> MFE;
  private b<Boolean, c> MFF;
  private Drawable MFo;
  private b.b<c> MFp;
  private CharSequence xkf;
  
  public final int getLayoutResource()
  {
    return MFn;
  }
  
  public final class a
    extends d.a
  {
    ImageView MFH;
    ImageView MFI;
    ImageView MFJ;
    TextView MFK;
    View MFL;
    ImageView zTB;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159942);
      this.MFH = ((ImageView)paramView.findViewById(2131300959));
      this.MFK = ((TextView)paramView.findViewById(2131304182));
      this.MFI = ((ImageView)paramView.findViewById(2131304190));
      this.MFL = paramView.findViewById(2131304191);
      this.zTB = ((ImageView)paramView.findViewById(2131304172));
      this.MFJ = ((ImageView)paramView.findViewById(2131304181));
      AppMethodBeat.o(159942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.c
 * JD-Core Version:    0.7.0.1
 */