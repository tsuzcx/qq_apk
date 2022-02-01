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
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;

public class CheckPreference
  extends Preference
{
  private int OAB;
  private String OAC;
  private int OAD;
  private TextView OEk;
  private CheckBox WqD;
  public int WqE;
  public boolean bBh;
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CheckPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142518);
    this.bBh = false;
    this.OAB = -1;
    this.OAC = "";
    this.OAD = 8;
    this.WqE = -1;
    setLayoutResource(a.h.mm_preference_summary_check);
    AppMethodBeat.o(142518);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(142520);
    super.onBindView(paramView);
    this.WqD = ((CheckBox)paramView.findViewById(a.g.checkbox));
    this.WqD.setChecked(this.bBh);
    this.OEk = ((TextView)paramView.findViewById(a.g.tipicon));
    paramView = this.OAC;
    int i = this.OAB;
    this.OAB = i;
    this.OAC = paramView;
    if (this.OEk != null)
    {
      if (i > 0) {
        this.OEk.setBackgroundResource(this.OAB);
      }
      if (!TextUtils.isEmpty(this.OAC)) {
        this.OEk.setText(this.OAC);
      }
    }
    this.OAD = this.OAD;
    if (this.OEk != null) {
      this.OEk.setVisibility(this.OAD);
    }
    paramView = (LinearLayout.LayoutParams)this.WqD.getLayoutParams();
    if (-1 != this.WqE) {
      paramView.setMargins(paramView.leftMargin, paramView.topMargin, this.WqE, paramView.bottomMargin);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.CheckPreference
 * JD-Core Version:    0.7.0.1
 */