package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public class CheckBoxWithTipIconPreference
  extends CheckBoxPreference
{
  private int DcV;
  private String DcW;
  private int DcX;
  private TextView Dga;
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69843);
    this.DcV = -1;
    this.DcW = "";
    this.DcX = 8;
    setLayoutResource(2131494891);
    AppMethodBeat.o(69843);
  }
  
  public final void VX(int paramInt)
  {
    AppMethodBeat.i(69846);
    this.DcX = paramInt;
    if (this.Dga != null) {
      this.Dga.setVisibility(paramInt);
    }
    AppMethodBeat.o(69846);
  }
  
  public final void fw(String paramString, int paramInt)
  {
    AppMethodBeat.i(69845);
    this.DcV = paramInt;
    this.DcW = paramString;
    if (this.Dga != null)
    {
      if (this.DcV > 0) {
        this.Dga.setBackgroundResource(this.DcV);
      }
      if (!TextUtils.isEmpty(this.DcW)) {
        this.Dga.setText(this.DcW);
      }
    }
    AppMethodBeat.o(69845);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69844);
    super.onBindView(paramView);
    this.Dga = ((TextView)paramView.findViewById(2131305883));
    fw(this.DcW, this.DcV);
    VX(this.DcX);
    AppMethodBeat.o(69844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.CheckBoxWithTipIconPreference
 * JD-Core Version:    0.7.0.1
 */