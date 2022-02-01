package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoMessagePreference
  extends Preference
{
  private NewBizInfoMessagePreference.a Hec;
  private MMActivity iXq;
  private RecyclerView jLl;
  private View kGT;
  private int state;
  private boolean vkO;
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27542);
    this.state = 1;
    this.vkO = false;
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(27542);
  }
  
  public NewBizInfoMessagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27543);
    this.state = 1;
    this.vkO = false;
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(27543);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27544);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    this.jLl = ((RecyclerView)paramView.findViewById(R.h.dNE));
    this.jLl.setLayoutParams(new FrameLayout.LayoutParams(-1, localDisplayMetrics.heightPixels));
    this.jLl.setLayoutManager(new LinearLayoutManager());
    this.jLl.setHasFixedSize(true);
    this.kGT = paramView.findViewById(R.h.dNt);
    this.vkO = true;
    if (this.vkO)
    {
      if (this.state != 1) {
        break label127;
      }
      this.kGT.setVisibility(0);
    }
    label127:
    do
    {
      this.jLl.setVisibility(8);
      AppMethodBeat.o(27544);
      return;
      if (this.state == 2)
      {
        this.jLl.setVisibility(8);
        this.kGT.setVisibility(0);
        AppMethodBeat.o(27544);
        return;
      }
    } while (this.state != 3);
    this.kGT.setVisibility(8);
    this.jLl.setVisibility(0);
    this.jLl.setAdapter(this.Hec);
    AppMethodBeat.o(27544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference
 * JD-Core Version:    0.7.0.1
 */