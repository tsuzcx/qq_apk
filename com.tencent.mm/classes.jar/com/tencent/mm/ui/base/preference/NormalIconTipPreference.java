package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public class NormalIconTipPreference
  extends NormalIconPreference
{
  private String OZm = "";
  private TextView pJV = null;
  
  public NormalIconTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NormalIconTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void gLP()
  {
    AppMethodBeat.i(205304);
    if (this.pJV != null)
    {
      if (Util.isNullOrNil(this.OZm))
      {
        this.pJV.setVisibility(8);
        this.pJV.setText("");
        AppMethodBeat.o(205304);
        return;
      }
      this.pJV.setVisibility(0);
      this.pJV.setText(this.OZm);
    }
    AppMethodBeat.o(205304);
  }
  
  public final void bml(String paramString)
  {
    AppMethodBeat.i(205303);
    this.OZm = paramString;
    gLP();
    AppMethodBeat.o(205303);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(205302);
    super.onBindView(paramView);
    this.pJV = ((TextView)paramView.findViewById(2131302511));
    gLP();
    paramView = paramView.findViewById(2131307104);
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    AppMethodBeat.o(205302);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(205301);
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(205301);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.NormalIconTipPreference
 * JD-Core Version:    0.7.0.1
 */