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
  private MMActivity fLP;
  private View gWO;
  private RecyclerView gmV;
  private boolean qhs;
  private int state;
  private NewBizInfoMessagePreference.a wVO;
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27542);
    this.state = 1;
    this.qhs = false;
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(27542);
  }
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27543);
    this.state = 1;
    this.qhs = false;
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(27543);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27544);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    this.gmV = ((RecyclerView)paramView.findViewById(2131302734));
    this.gmV.setLayoutParams(new FrameLayout.LayoutParams(-1, localDisplayMetrics.heightPixels));
    this.gmV.setLayoutManager(new LinearLayoutManager());
    this.gmV.setHasFixedSize(true);
    this.gWO = paramView.findViewById(2131302722);
    this.qhs = true;
    if (this.qhs)
    {
      if (this.state != 1) {
        break label125;
      }
      this.gWO.setVisibility(0);
    }
    label125:
    do
    {
      this.gmV.setVisibility(8);
      AppMethodBeat.o(27544);
      return;
      if (this.state == 2)
      {
        this.gmV.setVisibility(8);
        this.gWO.setVisibility(0);
        AppMethodBeat.o(27544);
        return;
      }
    } while (this.state != 3);
    this.gWO.setVisibility(8);
    this.gmV.setVisibility(0);
    this.gmV.setAdapter(this.wVO);
    AppMethodBeat.o(27544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference
 * JD-Core Version:    0.7.0.1
 */