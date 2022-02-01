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
  private TextView Bod;
  private int Boe;
  private String Bof;
  private int Bog;
  private CheckBox HDO;
  private int HDP;
  private boolean mF;
  
  public RadioCheckPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RadioCheckPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142666);
    this.mF = false;
    this.Boe = -1;
    this.Bof = "";
    this.Bog = 8;
    this.HDP = -1;
    setLayoutResource(2131494804);
    AppMethodBeat.o(142666);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142668);
    super.onBindView(paramView);
    aam(8);
    this.HDO = ((CheckBox)paramView.findViewById(2131303709));
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
    AppMethodBeat.o(142668);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142667);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494892, localViewGroup);
    AppMethodBeat.o(142667);
    return paramViewGroup;
  }
  
  public final void wT(boolean paramBoolean)
  {
    AppMethodBeat.i(142669);
    this.mF = paramBoolean;
    if (this.HDO != null) {
      this.HDO.setChecked(paramBoolean);
    }
    AppMethodBeat.o(142669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.RadioCheckPreference
 * JD-Core Version:    0.7.0.1
 */