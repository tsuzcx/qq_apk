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
  private TextView Bod;
  private int Boe;
  private String Bof;
  private int Bog;
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69843);
    this.Boe = -1;
    this.Bof = "";
    this.Bog = 8;
    setLayoutResource(2131494891);
    AppMethodBeat.o(69843);
  }
  
  public final void TD(int paramInt)
  {
    AppMethodBeat.i(69846);
    this.Bog = paramInt;
    if (this.Bod != null) {
      this.Bod.setVisibility(paramInt);
    }
    AppMethodBeat.o(69846);
  }
  
  public final void eU(String paramString, int paramInt)
  {
    AppMethodBeat.i(69845);
    this.Boe = paramInt;
    this.Bof = paramString;
    if (this.Bod != null)
    {
      if (this.Boe > 0) {
        this.Bod.setBackgroundResource(this.Boe);
      }
      if (!TextUtils.isEmpty(this.Bof)) {
        this.Bod.setText(this.Bof);
      }
    }
    AppMethodBeat.o(69845);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69844);
    super.onBindView(paramView);
    this.Bod = ((TextView)paramView.findViewById(2131305883));
    eU(this.Bof, this.Boe);
    TD(this.Bog);
    AppMethodBeat.o(69844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.CheckBoxWithTipIconPreference
 * JD-Core Version:    0.7.0.1
 */