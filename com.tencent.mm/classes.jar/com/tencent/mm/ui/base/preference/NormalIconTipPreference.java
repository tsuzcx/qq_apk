package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.sdk.platformtools.Util;

public class NormalIconTipPreference
  extends NormalIconPreference
{
  private TextView DMt = null;
  private String adZL = "";
  
  public NormalIconTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NormalIconTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void jnB()
  {
    AppMethodBeat.i(251497);
    if (this.DMt != null)
    {
      if (Util.isNullOrNil(this.adZL))
      {
        this.DMt.setVisibility(8);
        this.DMt.setText("");
        AppMethodBeat.o(251497);
        return;
      }
      this.DMt.setVisibility(0);
      this.DMt.setText(this.adZL);
    }
    AppMethodBeat.o(251497);
  }
  
  public final void bAm(String paramString)
  {
    AppMethodBeat.i(251502);
    this.adZL = paramString;
    jnB();
    AppMethodBeat.o(251502);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(251499);
    super.onBindView(paramView);
    this.DMt = ((TextView)paramView.findViewById(a.g.icon_tips_tv));
    jnB();
    paramView = paramView.findViewById(a.g.right_rl);
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    AppMethodBeat.o(251499);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(251498);
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(251498);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.NormalIconTipPreference
 * JD-Core Version:    0.7.0.1
 */