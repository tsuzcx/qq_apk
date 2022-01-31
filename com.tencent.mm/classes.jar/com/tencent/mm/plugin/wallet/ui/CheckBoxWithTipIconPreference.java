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
  private TextView ubi;
  private int ubj;
  private String ubk;
  private int ubl;
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(46448);
    this.ubj = -1;
    this.ubk = "";
    this.ubl = 8;
    setLayoutResource(2130970261);
    AppMethodBeat.o(46448);
  }
  
  public final void Iu(int paramInt)
  {
    AppMethodBeat.i(46451);
    this.ubl = paramInt;
    if (this.ubi != null) {
      this.ubi.setVisibility(paramInt);
    }
    AppMethodBeat.o(46451);
  }
  
  public final void dE(String paramString, int paramInt)
  {
    AppMethodBeat.i(46450);
    this.ubj = paramInt;
    this.ubk = paramString;
    if (this.ubi != null)
    {
      if (this.ubj > 0) {
        this.ubi.setBackgroundResource(this.ubj);
      }
      if (!TextUtils.isEmpty(this.ubk)) {
        this.ubi.setText(this.ubk);
      }
    }
    AppMethodBeat.o(46450);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(46449);
    super.onBindView(paramView);
    this.ubi = ((TextView)paramView.findViewById(2131826257));
    dE(this.ubk, this.ubj);
    Iu(this.ubl);
    AppMethodBeat.o(46449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.CheckBoxWithTipIconPreference
 * JD-Core Version:    0.7.0.1
 */