package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CheckPreference
  extends Preference
{
  private int HIJ;
  private String HIK;
  private int HIL;
  private TextView HMo;
  private CheckBox OXt;
  public int OXu;
  public boolean oD;
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142518);
    this.oD = false;
    this.HIJ = -1;
    this.HIK = "";
    this.HIL = 8;
    this.OXu = -1;
    setLayoutResource(2131495626);
    AppMethodBeat.o(142518);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142520);
    super.onBindView(paramView);
    this.OXt = ((CheckBox)paramView.findViewById(2131298639));
    this.OXt.setChecked(this.oD);
    this.HMo = ((TextView)paramView.findViewById(2131309166));
    paramView = this.HIK;
    int i = this.HIJ;
    this.HIJ = i;
    this.HIK = paramView;
    if (this.HMo != null)
    {
      if (i > 0) {
        this.HMo.setBackgroundResource(this.HIJ);
      }
      if (!TextUtils.isEmpty(this.HIK)) {
        this.HMo.setText(this.HIK);
      }
    }
    this.HIL = this.HIL;
    if (this.HMo != null) {
      this.HMo.setVisibility(this.HIL);
    }
    paramView = (LinearLayout.LayoutParams)this.OXt.getLayoutParams();
    if (-1 != this.OXu) {
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, this.OXu, paramView.bottomMargin);
    }
    AppMethodBeat.o(142520);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142519);
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(142519);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckPreference
 * JD-Core Version:    0.7.0.1
 */