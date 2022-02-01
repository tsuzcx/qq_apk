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
  public static final int IGe = 2131493530;
  private Drawable IGf;
  private b.b<a> IGg;
  private b.a<a> IGh;
  private CharSequence uEo;
  
  public final int getLayoutResource()
  {
    return IGe;
  }
  
  public final class a
    extends com.tencent.toybrick.f.a
  {
    public TextView IGj;
    public ImageView IGk;
    public ImageView IGl;
    public MMSwitchBtn IGm;
    public TextView titleTv;
    public TextView uCm;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(159933);
      this.titleTv = ((TextView)paramView.findViewById(16908310));
      this.IGl = ((ImageView)paramView.findViewById(2131301384));
      this.IGj = ((TextView)paramView.findViewById(2131305740));
      this.IGk = ((ImageView)paramView.findViewById(2131300957));
      this.uCm = ((TextView)paramView.findViewById(2131305546));
      this.IGm = ((MMSwitchBtn)paramView.findViewById(2131298255));
      this.IGm.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(159933);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.c.a
 * JD-Core Version:    0.7.0.1
 */