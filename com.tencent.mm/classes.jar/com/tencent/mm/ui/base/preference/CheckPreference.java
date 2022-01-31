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
  private TextView ubi;
  private int ubj;
  private String ubk;
  private int ubl;
  public boolean vxW;
  private CheckBox zqy;
  public int zqz;
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107141);
    this.vxW = false;
    this.ubj = -1;
    this.ubk = "";
    this.ubl = 8;
    this.zqz = -1;
    setLayoutResource(2130970258);
    AppMethodBeat.o(107141);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(107143);
    super.onBindView(paramView);
    this.zqy = ((CheckBox)paramView.findViewById(2131820950));
    this.zqy.setChecked(this.vxW);
    this.ubi = ((TextView)paramView.findViewById(2131826257));
    paramView = this.ubk;
    int i = this.ubj;
    this.ubj = i;
    this.ubk = paramView;
    if (this.ubi != null)
    {
      if (i > 0) {
        this.ubi.setBackgroundResource(this.ubj);
      }
      if (!TextUtils.isEmpty(this.ubk)) {
        this.ubi.setText(this.ubk);
      }
    }
    this.ubl = this.ubl;
    if (this.ubi != null) {
      this.ubi.setVisibility(this.ubl);
    }
    paramView = (LinearLayout.LayoutParams)this.zqy.getLayoutParams();
    if (-1 != this.zqz) {
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, this.zqz, paramView.bottomMargin);
    }
    AppMethodBeat.o(107143);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107142);
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(107142);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckPreference
 * JD-Core Version:    0.7.0.1
 */