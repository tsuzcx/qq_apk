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
  private TextView COs;
  private int COt;
  private String COu;
  private int COv;
  private CheckBox JrE;
  public int JrF;
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
    this.COt = -1;
    this.COu = "";
    this.COv = 8;
    this.JrF = -1;
    setLayoutResource(2131494888);
    AppMethodBeat.o(142518);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142520);
    super.onBindView(paramView);
    this.JrE = ((CheckBox)paramView.findViewById(2131298255));
    this.JrE.setChecked(this.oB);
    this.COs = ((TextView)paramView.findViewById(2131305883));
    paramView = this.COu;
    int i = this.COt;
    this.COt = i;
    this.COu = paramView;
    if (this.COs != null)
    {
      if (i > 0) {
        this.COs.setBackgroundResource(this.COt);
      }
      if (!TextUtils.isEmpty(this.COu)) {
        this.COs.setText(this.COu);
      }
    }
    this.COv = this.COv;
    if (this.COs != null) {
      this.COs.setVisibility(this.COv);
    }
    paramView = (LinearLayout.LayoutParams)this.JrE.getLayoutParams();
    if (-1 != this.JrF) {
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, this.JrF, paramView.bottomMargin);
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