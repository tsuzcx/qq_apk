package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class MultiSummaryPreference
  extends Preference
{
  public String[] Bgt;
  private Context context;
  public String title;
  
  public MultiSummaryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27266);
    this.context = paramContext;
    setLayoutResource(2131495538);
    AppMethodBeat.o(27266);
  }
  
  public MultiSummaryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27265);
    this.context = paramContext;
    setLayoutResource(2131495538);
    AppMethodBeat.o(27265);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27268);
    super.onBindView(paramView);
    ((TextView)paramView.findViewById(2131309195)).setText(this.title);
    LinearLayout localLinearLayout1 = (LinearLayout)paramView.findViewById(2131308768);
    LinearLayout localLinearLayout2 = (LinearLayout)paramView.findViewById(2131308769);
    localLinearLayout1.setVisibility(8);
    localLinearLayout2.setVisibility(8);
    if ((this.Bgt != null) && (this.Bgt.length > 0))
    {
      if (this.Bgt.length == 1)
      {
        ((TextView)localLinearLayout2.findViewById(2131308776)).setText(this.Bgt[0]);
        localLinearLayout2.setVisibility(0);
      }
      for (;;)
      {
        ((View)paramView.findViewById(2131307076).getParent()).setVisibility(8);
        AppMethodBeat.o(27268);
        return;
        if (this.Bgt.length == 2)
        {
          ((TextView)localLinearLayout1.findViewById(2131308775)).setText(this.Bgt[0]);
          localLinearLayout1.setVisibility(0);
          ((TextView)localLinearLayout2.findViewById(2131308776)).setText(this.Bgt[1]);
          localLinearLayout2.setVisibility(0);
        }
      }
    }
    ((View)paramView.findViewById(2131307076).getParent()).setVisibility(0);
    AppMethodBeat.o(27268);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27267);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131495710, localViewGroup);
    AppMethodBeat.o(27267);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.MultiSummaryPreference
 * JD-Core Version:    0.7.0.1
 */