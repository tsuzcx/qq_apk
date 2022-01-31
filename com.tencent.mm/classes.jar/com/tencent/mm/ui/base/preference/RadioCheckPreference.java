package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RadioCheckPreference
  extends Preference
{
  private TextView ubi;
  private int ubj;
  private String ubk;
  private int ubl;
  private boolean vxW;
  private CheckBox zqy;
  private int zqz;
  
  public RadioCheckPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RadioCheckPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107286);
    this.vxW = false;
    this.ubj = -1;
    this.ubk = "";
    this.ubl = 8;
    this.zqz = -1;
    setLayoutResource(2130970179);
    AppMethodBeat.o(107286);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(107288);
    super.onBindView(paramView);
    OW(8);
    this.zqy = ((CheckBox)paramView.findViewById(2131826260));
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
    AppMethodBeat.o(107288);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107287);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970262, localViewGroup);
    AppMethodBeat.o(107287);
    return paramViewGroup;
  }
  
  public final void qH(boolean paramBoolean)
  {
    AppMethodBeat.i(107289);
    this.vxW = paramBoolean;
    if (this.zqy != null) {
      this.zqy.setChecked(paramBoolean);
    }
    AppMethodBeat.o(107289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.RadioCheckPreference
 * JD-Core Version:    0.7.0.1
 */