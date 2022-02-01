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
  public static final int Miq = 2131493530;
  private Drawable Mir;
  private b.b<a> Mis;
  private b.a<a> Mit;
  private CharSequence wUo;
  
  public final int getLayoutResource()
  {
    return Miq;
  }
  
  public final class a
    extends com.tencent.toybrick.f.a
  {
    public TextView Miv;
    public ImageView Miw;
    public ImageView Mix;
    public MMSwitchBtn Miy;
    public TextView titleTv;
    public TextView wSo;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159933);
      this.titleTv = ((TextView)paramView.findViewById(16908310));
      this.Mix = ((ImageView)paramView.findViewById(2131301384));
      this.Miv = ((TextView)paramView.findViewById(2131305740));
      this.Miw = ((ImageView)paramView.findViewById(2131300957));
      this.wSo = ((TextView)paramView.findViewById(2131305546));
      this.Miy = ((MMSwitchBtn)paramView.findViewById(2131298255));
      this.Miy.setSwitchListener(new MMSwitchBtn.a()
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