package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class NewBizInfoMessagePreference$a
  extends RecyclerView.a<a>
{
  private static int Hed;
  private static final int Hee;
  private static int Hef;
  private static int Heg;
  private static int Heh;
  private static int Hei;
  private static int Hej;
  
  static
  {
    AppMethodBeat.i(27541);
    Hed = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 6);
    Hee = MMApplicationContext.getResources().getDimensionPixelSize(R.f.SmallerIconSize);
    Hef = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    Heg = 13;
    Heh = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 1);
    Hei = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    Hej = 13;
    AppMethodBeat.o(27541);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(27538);
    AppMethodBeat.o(27538);
    throw null;
  }
  
  public final class a
    extends RecyclerView.v
    implements View.OnClickListener
  {
    public ImageView GZJ;
    public TextView jiw;
    public ImageView jmf;
    public View olM;
    public LinearLayout tMH;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(27536);
      this.GZJ = ((ImageView)paramView.findViewById(R.h.dND));
      this.jmf = ((ImageView)paramView.findViewById(R.h.dNC));
      this.jiw = ((TextView)paramView.findViewById(R.h.dNF));
      this.tMH = ((LinearLayout)paramView.findViewById(R.h.dNz));
      this.olM = paramView.findViewById(R.h.dNB);
      paramView.setOnClickListener(this);
      AppMethodBeat.o(27536);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(27537);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMessagePreference$messageItemAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      AppMethodBeat.o(27537);
      throw null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference.a
 * JD-Core Version:    0.7.0.1
 */