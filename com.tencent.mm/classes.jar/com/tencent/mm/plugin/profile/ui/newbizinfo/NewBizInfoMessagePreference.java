package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoMessagePreference
  extends Preference
{
  private NewBizInfoMessagePreference.a BjG;
  private MMActivity gte;
  private View hSw;
  private RecyclerView hak;
  private boolean rFe;
  private int state;
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27542);
    this.state = 1;
    this.rFe = false;
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(27542);
  }
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27543);
    this.state = 1;
    this.rFe = false;
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(27543);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27544);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    this.hak = ((RecyclerView)paramView.findViewById(2131305301));
    this.hak.setLayoutParams(new FrameLayout.LayoutParams(-1, localDisplayMetrics.heightPixels));
    this.hak.setLayoutManager(new LinearLayoutManager());
    this.hak.setHasFixedSize(true);
    this.hSw = paramView.findViewById(2131305289);
    this.rFe = true;
    if (this.rFe)
    {
      if (this.state != 1) {
        break label125;
      }
      this.hSw.setVisibility(0);
    }
    label125:
    do
    {
      this.hak.setVisibility(8);
      AppMethodBeat.o(27544);
      return;
      if (this.state == 2)
      {
        this.hak.setVisibility(8);
        this.hSw.setVisibility(0);
        AppMethodBeat.o(27544);
        return;
      }
    } while (this.state != 3);
    this.hSw.setVisibility(8);
    this.hak.setVisibility(0);
    this.hak.setAdapter(this.BjG);
    AppMethodBeat.o(27544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference
 * JD-Core Version:    0.7.0.1
 */