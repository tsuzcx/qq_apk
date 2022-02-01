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
  public static final int MFn = 2131493530;
  private Drawable MFo;
  private b.b<a> MFp;
  private b.a<a> MFq;
  private CharSequence xkf;
  
  public final int getLayoutResource()
  {
    return MFn;
  }
  
  public final class a
    extends com.tencent.toybrick.f.a
  {
    public TextView MFs;
    public ImageView MFt;
    public ImageView MFu;
    public MMSwitchBtn MFv;
    public TextView titleTv;
    public TextView xif;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159933);
      this.titleTv = ((TextView)paramView.findViewById(16908310));
      this.MFu = ((ImageView)paramView.findViewById(2131301384));
      this.MFs = ((TextView)paramView.findViewById(2131305740));
      this.MFt = ((ImageView)paramView.findViewById(2131300957));
      this.xif = ((TextView)paramView.findViewById(2131305546));
      this.MFv = ((MMSwitchBtn)paramView.findViewById(2131298255));
      this.MFv.setSwitchListener(new MMSwitchBtn.a()
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