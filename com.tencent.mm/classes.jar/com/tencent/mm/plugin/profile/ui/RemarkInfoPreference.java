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
  private TextView BfZ;
  private boolean Bih;
  private ImageView gBZ;
  private MMActivity gte;
  private String summary;
  private String title;
  private TextView titleTv;
  
  public RemarkInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27387);
    this.Bih = false;
    this.gte = ((MMActivity)paramContext);
    AppMethodBeat.o(27387);
  }
  
  public RemarkInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27388);
    this.Bih = false;
    setLayoutResource(2131495538);
    setWidgetLayoutResource(2131495622);
    AppMethodBeat.o(27388);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27390);
    this.titleTv = ((TextView)paramView.findViewById(2131309195));
    this.BfZ = ((TextView)paramView.findViewById(2131308767));
    this.gBZ = ((ImageView)paramView.findViewById(2131302573));
    if (!this.Bih) {
      this.gBZ.setVisibility(8);
    }
    for (;;)
    {
      if (this.titleTv != null) {
        this.titleTv.setText(this.title);
      }
      if (this.BfZ != null) {
        this.BfZ.setText(this.summary);
      }
      super.onBindView(paramView);
      AppMethodBeat.o(27390);
      return;
      this.gBZ.setVisibility(0);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27389);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131495579, localViewGroup);
    AppMethodBeat.o(27389);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.RemarkInfoPreference
 * JD-Core Version:    0.7.0.1
 */