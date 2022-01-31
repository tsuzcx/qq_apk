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
  private MMActivity cmc;
  private RecyclerView iQe;
  private View jjH;
  private boolean lJS;
  private NewBizInfoMessagePreference.a pDL;
  private int state;
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23890);
    this.state = 1;
    this.lJS = false;
    this.cmc = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(23890);
  }
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23891);
    this.state = 1;
    this.lJS = false;
    this.cmc = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(23891);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23892);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    this.iQe = ((RecyclerView)paramView.findViewById(2131823150));
    this.iQe.setLayoutParams(new FrameLayout.LayoutParams(-1, localDisplayMetrics.heightPixels));
    this.iQe.setLayoutManager(new LinearLayoutManager());
    this.iQe.setHasFixedSize(true);
    this.jjH = paramView.findViewById(2131823146);
    this.lJS = true;
    if (this.lJS)
    {
      if (this.state != 1) {
        break label125;
      }
      this.jjH.setVisibility(0);
    }
    label125:
    do
    {
      this.iQe.setVisibility(8);
      AppMethodBeat.o(23892);
      return;
      if (this.state == 2)
      {
        this.iQe.setVisibility(8);
        this.jjH.setVisibility(0);
        AppMethodBeat.o(23892);
        return;
      }
    } while (this.state != 3);
    this.jjH.setVisibility(8);
    this.iQe.setVisibility(0);
    this.iQe.setAdapter(this.pDL);
    AppMethodBeat.o(23892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference
 * JD-Core Version:    0.7.0.1
 */