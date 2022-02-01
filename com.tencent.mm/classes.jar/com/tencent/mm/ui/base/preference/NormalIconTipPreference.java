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
  private TextView AWF = null;
  private String Wsv = "";
  
  public NormalIconTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NormalIconTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void hKU()
  {
    AppMethodBeat.i(193067);
    if (this.AWF != null)
    {
      if (Util.isNullOrNil(this.Wsv))
      {
        this.AWF.setVisibility(8);
        this.AWF.setText("");
        AppMethodBeat.o(193067);
        return;
      }
      this.AWF.setVisibility(0);
      this.AWF.setText(this.Wsv);
    }
    AppMethodBeat.o(193067);
  }
  
  public final void byK(String paramString)
  {
    AppMethodBeat.i(193064);
    this.Wsv = paramString;
    hKU();
    AppMethodBeat.o(193064);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(193063);
    super.onBindView(paramView);
    this.AWF = ((TextView)paramView.findViewById(a.g.icon_tips_tv));
    hKU();
    paramView = paramView.findViewById(a.g.right_rl);
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    AppMethodBeat.o(193063);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(193058);
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(193058);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.NormalIconTipPreference
 * JD-Core Version:    0.7.0.1
 */