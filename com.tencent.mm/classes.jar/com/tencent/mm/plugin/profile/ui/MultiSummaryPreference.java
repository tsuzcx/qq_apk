package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.base.preference.Preference;

public class MultiSummaryPreference
  extends Preference
{
  public String[] MYg;
  private Context context;
  public String title;
  
  public MultiSummaryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27266);
    this.context = paramContext;
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(27266);
  }
  
  public MultiSummaryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27265);
    this.context = paramContext;
    setLayoutResource(R.i.mm_preference);
    AppMethodBeat.o(27265);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27268);
    super.onBindView(paramView);
    ((TextView)paramView.findViewById(R.h.title)).setText(this.title);
    LinearLayout localLinearLayout1 = (LinearLayout)paramView.findViewById(R.h.fYq);
    LinearLayout localLinearLayout2 = (LinearLayout)paramView.findViewById(R.h.fYr);
    localLinearLayout1.setVisibility(8);
    localLinearLayout2.setVisibility(8);
    if ((this.MYg != null) && (this.MYg.length > 0))
    {
      if (this.MYg.length == 1)
      {
        ((TextView)localLinearLayout2.findViewById(R.h.fYt)).setText(this.MYg[0]);
        localLinearLayout2.setVisibility(0);
      }
      for (;;)
      {
        ((View)paramView.findViewById(R.h.right_arrow).getParent()).setVisibility(8);
        AppMethodBeat.o(27268);
        return;
        if (this.MYg.length == 2)
        {
          ((TextView)localLinearLayout1.findViewById(R.h.fYs)).setText(this.MYg[0]);
          localLinearLayout1.setVisibility(0);
          ((TextView)localLinearLayout2.findViewById(R.h.fYt)).setText(this.MYg[1]);
          localLinearLayout2.setVisibility(0);
        }
      }
    }
    ((View)paramView.findViewById(R.h.right_arrow).getParent()).setVisibility(0);
    AppMethodBeat.o(27268);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27267);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.gmm, localViewGroup);
    AppMethodBeat.o(27267);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.MultiSummaryPreference
 * JD-Core Version:    0.7.0.1
 */