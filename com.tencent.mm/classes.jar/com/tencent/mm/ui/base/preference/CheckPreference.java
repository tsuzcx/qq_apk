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
  private int DcV;
  private String DcW;
  private int DcX;
  private TextView Dga;
  private CheckBox JMt;
  public int JMu;
  public boolean oB;
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142518);
    this.oB = false;
    this.DcV = -1;
    this.DcW = "";
    this.DcX = 8;
    this.JMu = -1;
    setLayoutResource(2131494888);
    AppMethodBeat.o(142518);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142520);
    super.onBindView(paramView);
    this.JMt = ((CheckBox)paramView.findViewById(2131298255));
    this.JMt.setChecked(this.oB);
    this.Dga = ((TextView)paramView.findViewById(2131305883));
    paramView = this.DcW;
    int i = this.DcV;
    this.DcV = i;
    this.DcW = paramView;
    if (this.Dga != null)
    {
      if (i > 0) {
        this.Dga.setBackgroundResource(this.DcV);
      }
      if (!TextUtils.isEmpty(this.DcW)) {
        this.Dga.setText(this.DcW);
      }
    }
    this.DcX = this.DcX;
    if (this.Dga != null) {
      this.Dga.setVisibility(this.DcX);
    }
    paramView = (LinearLayout.LayoutParams)this.JMt.getLayoutParams();
    if (-1 != this.JMu) {
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, this.JMu, paramView.bottomMargin);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckPreference
 * JD-Core Version:    0.7.0.1
 */