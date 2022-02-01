package com.tencent.toybrick.c;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.toybrick.e.c.a;
import com.tencent.toybrick.g.b.a;
import com.tencent.toybrick.g.b.b;

public final class a
  extends g<a, a>
{
  public static final int Sno = 2131493642;
  private CharSequence Bic;
  private Drawable Snp;
  private b.b<a> Snq;
  private b.a<a> Snr;
  
  public final int getLayoutResource()
  {
    return Sno;
  }
  
  public final class a
    extends com.tencent.toybrick.f.a
  {
    public TextView BfZ;
    public TextView Snt;
    public ImageView Snu;
    public ImageView Snv;
    public MMSwitchBtn Snw;
    public TextView titleTv;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159933);
      this.titleTv = ((TextView)paramView.findViewById(16908310));
      this.Snv = ((ImageView)paramView.findViewById(2131303139));
      this.Snt = ((TextView)paramView.findViewById(2131309007));
      this.Snu = ((ImageView)paramView.findViewById(2131302593));
      this.BfZ = ((TextView)paramView.findViewById(2131308767));
      this.Snw = ((MMSwitchBtn)paramView.findViewById(2131298639));
      this.Snw.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(159933);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.toybrick.c.a
 * JD-Core Version:    0.7.0.1
 */