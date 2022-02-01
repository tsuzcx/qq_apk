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
  private TextView zVJ;
  private int zVK;
  private String zVL;
  private int zVM;
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69843);
    this.zVK = -1;
    this.zVL = "";
    this.zVM = 8;
    setLayoutResource(2131494891);
    AppMethodBeat.o(69843);
  }
  
  public final void Ru(int paramInt)
  {
    AppMethodBeat.i(69846);
    this.zVM = paramInt;
    if (this.zVJ != null) {
      this.zVJ.setVisibility(paramInt);
    }
    AppMethodBeat.o(69846);
  }
  
  public final void eM(String paramString, int paramInt)
  {
    AppMethodBeat.i(69845);
    this.zVK = paramInt;
    this.zVL = paramString;
    if (this.zVJ != null)
    {
      if (this.zVK > 0) {
        this.zVJ.setBackgroundResource(this.zVK);
      }
      if (!TextUtils.isEmpty(this.zVL)) {
        this.zVJ.setText(this.zVL);
      }
    }
    AppMethodBeat.o(69845);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69844);
    super.onBindView(paramView);
    this.zVJ = ((TextView)paramView.findViewById(2131305883));
    eM(this.zVL, this.zVK);
    Ru(this.zVM);
    AppMethodBeat.o(69844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.CheckBoxWithTipIconPreference
 * JD-Core Version:    0.7.0.1
 */