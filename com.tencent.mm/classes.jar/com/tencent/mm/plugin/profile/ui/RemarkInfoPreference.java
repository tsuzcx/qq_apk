package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class RemarkInfoPreference
  extends Preference
{
  private MMActivity bER;
  private TextView eXr;
  private ImageView heN;
  private TextView mXQ;
  private boolean mZa = false;
  private String summary;
  private String title;
  
  public RemarkInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bER = ((MMActivity)paramContext);
  }
  
  public RemarkInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(R.i.mm_preference);
    setWidgetLayoutResource(R.i.mm_preference_submenu);
  }
  
  public final void onBindView(View paramView)
  {
    this.eXr = ((TextView)paramView.findViewById(R.h.title));
    this.mXQ = ((TextView)paramView.findViewById(R.h.summary));
    this.heN = ((ImageView)paramView.findViewById(R.h.image_iv));
    if (!this.mZa) {
      this.heN.setVisibility(8);
    }
    for (;;)
    {
      if (this.eXr != null) {
        this.eXr.setText(this.title);
      }
      if (this.mXQ != null) {
        this.mXQ.setText(this.summary);
      }
      super.onBindView(paramView);
      return;
      this.heN.setVisibility(0);
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.mm_preference_content_remark_info, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.RemarkInfoPreference
 * JD-Core Version:    0.7.0.1
 */