package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class RemarkInfoPreference
  extends Preference
{
  private MMActivity cmc;
  private ImageView iQd;
  private TextView pAD;
  private boolean pCB;
  private String summary;
  private String title;
  private TextView titleTv;
  
  public RemarkInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23761);
    this.pCB = false;
    this.cmc = ((MMActivity)paramContext);
    AppMethodBeat.o(23761);
  }
  
  public RemarkInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23762);
    this.pCB = false;
    setLayoutResource(2130970179);
    setWidgetLayoutResource(2130970254);
    AppMethodBeat.o(23762);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23764);
    this.titleTv = ((TextView)paramView.findViewById(2131820680));
    this.pAD = ((TextView)paramView.findViewById(2131821890));
    this.iQd = ((ImageView)paramView.findViewById(2131822243));
    if (!this.pCB) {
      this.iQd.setVisibility(8);
    }
    for (;;)
    {
      if (this.titleTv != null) {
        this.titleTv.setText(this.title);
      }
      if (this.pAD != null) {
        this.pAD.setText(this.summary);
      }
      super.onBindView(paramView);
      AppMethodBeat.o(23764);
      return;
      this.iQd.setVisibility(0);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(23763);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970217, localViewGroup);
    AppMethodBeat.o(23763);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.RemarkInfoPreference
 * JD-Core Version:    0.7.0.1
 */