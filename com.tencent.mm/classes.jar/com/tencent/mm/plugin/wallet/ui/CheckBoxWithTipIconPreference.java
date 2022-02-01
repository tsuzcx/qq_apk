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
  private TextView COs;
  private int COt;
  private String COu;
  private int COv;
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckBoxWithTipIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69843);
    this.COt = -1;
    this.COu = "";
    this.COv = 8;
    setLayoutResource(2131494891);
    AppMethodBeat.o(69843);
  }
  
  public final void Vv(int paramInt)
  {
    AppMethodBeat.i(69846);
    this.COv = paramInt;
    if (this.COs != null) {
      this.COs.setVisibility(paramInt);
    }
    AppMethodBeat.o(69846);
  }
  
  public final void fn(String paramString, int paramInt)
  {
    AppMethodBeat.i(69845);
    this.COt = paramInt;
    this.COu = paramString;
    if (this.COs != null)
    {
      if (this.COt > 0) {
        this.COs.setBackgroundResource(this.COt);
      }
      if (!TextUtils.isEmpty(this.COu)) {
        this.COs.setText(this.COu);
      }
    }
    AppMethodBeat.o(69845);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69844);
    super.onBindView(paramView);
    this.COs = ((TextView)paramView.findViewById(2131305883));
    fn(this.COu, this.COt);
    Vv(this.COv);
    AppMethodBeat.o(69844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.CheckBoxWithTipIconPreference
 * JD-Core Version:    0.7.0.1
 */