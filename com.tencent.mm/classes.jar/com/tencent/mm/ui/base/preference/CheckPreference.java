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
  private TextView Bod;
  private int Boe;
  private String Bof;
  private int Bog;
  private CheckBox HDO;
  public int HDP;
  public boolean mF;
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142518);
    this.mF = false;
    this.Boe = -1;
    this.Bof = "";
    this.Bog = 8;
    this.HDP = -1;
    setLayoutResource(2131494888);
    AppMethodBeat.o(142518);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142520);
    super.onBindView(paramView);
    this.HDO = ((CheckBox)paramView.findViewById(2131298255));
    this.HDO.setChecked(this.mF);
    this.Bod = ((TextView)paramView.findViewById(2131305883));
    paramView = this.Bof;
    int i = this.Boe;
    this.Boe = i;
    this.Bof = paramView;
    if (this.Bod != null)
    {
      if (i > 0) {
        this.Bod.setBackgroundResource(this.Boe);
      }
      if (!TextUtils.isEmpty(this.Bof)) {
        this.Bod.setText(this.Bof);
      }
    }
    this.Bog = this.Bog;
    if (this.Bod != null) {
      this.Bod.setVisibility(this.Bog);
    }
    paramView = (LinearLayout.LayoutParams)this.HDO.getLayoutParams();
    if (-1 != this.HDP) {
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, this.HDP, paramView.bottomMargin);
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