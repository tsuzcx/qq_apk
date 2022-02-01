package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class RemarkInfoPreference
  extends Preference
{
  private TextView GZI;
  private boolean HbY;
  private MMActivity iXq;
  private ImageView jmf;
  private String summary;
  private String title;
  private TextView titleTv;
  
  public RemarkInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27387);
    this.HbY = false;
    this.iXq = ((MMActivity)paramContext);
    AppMethodBeat.o(27387);
  }
  
  public RemarkInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27388);
    this.HbY = false;
    setLayoutResource(R.i.mm_preference);
    auN(R.i.mm_preference_submenu);
    AppMethodBeat.o(27388);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27390);
    this.titleTv = ((TextView)paramView.findViewById(R.h.title));
    this.GZI = ((TextView)paramView.findViewById(R.h.summary));
    this.jmf = ((ImageView)paramView.findViewById(R.h.image_iv));
    if (!this.HbY) {
      this.jmf.setVisibility(8);
    }
    for (;;)
    {
      if (this.titleTv != null) {
        this.titleTv.setText(this.title);
      }
      if (this.GZI != null) {
        this.GZI.setText(this.summary);
      }
      super.onBindView(paramView);
      AppMethodBeat.o(27390);
      return;
      this.jmf.setVisibility(0);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27389);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.eiY, localViewGroup);
    AppMethodBeat.o(27389);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.RemarkInfoPreference
 * JD-Core Version:    0.7.0.1
 */