package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;

public class CheckPreference
  extends Preference
{
  private TextView qqn;
  private int qqo = -1;
  private String qqp = "";
  private int qqq = 8;
  public boolean rHo = false;
  private CheckBox vbX;
  public int vbY = -1;
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.h.mm_preference_summary_check);
  }
  
  public final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.vbX = ((CheckBox)paramView.findViewById(a.g.checkbox));
    this.vbX.setChecked(this.rHo);
    this.qqn = ((TextView)paramView.findViewById(a.g.tipicon));
    paramView = this.qqp;
    int i = this.qqo;
    this.qqo = i;
    this.qqp = paramView;
    if (this.qqn != null)
    {
      if (i > 0) {
        this.qqn.setBackgroundResource(this.qqo);
      }
      if (!TextUtils.isEmpty(this.qqp)) {
        this.qqn.setText(this.qqp);
      }
    }
    this.qqq = this.qqq;
    if (this.qqn != null) {
      this.qqn.setVisibility(this.qqq);
    }
    paramView = (LinearLayout.LayoutParams)this.vbX.getLayoutParams();
    if (-1 != this.vbY) {
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, this.vbY, paramView.bottomMargin);
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    return super.onCreateView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckPreference
 * JD-Core Version:    0.7.0.1
 */