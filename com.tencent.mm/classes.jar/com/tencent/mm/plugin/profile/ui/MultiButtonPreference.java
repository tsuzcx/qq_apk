package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public class MultiButtonPreference
  extends Preference
{
  private String pAS;
  public String pAT;
  private String pAU;
  private View.OnClickListener pAV;
  public View.OnClickListener pAW;
  private View.OnClickListener pAX;
  
  public MultiButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23650);
    setLayoutResource(2130970467);
    AppMethodBeat.o(23650);
  }
  
  public MultiButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23649);
    setLayoutResource(2130970467);
    AppMethodBeat.o(23649);
  }
  
  public final void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.pAS = paramString;
    this.pAV = paramOnClickListener;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23651);
    super.onBindView(paramView);
    Button localButton1 = (Button)paramView.findViewById(2131826854);
    View localView1 = paramView.findViewById(2131826855);
    Button localButton2 = (Button)paramView.findViewById(2131826856);
    View localView2 = paramView.findViewById(2131826857);
    Button localButton3 = (Button)paramView.findViewById(2131826858);
    paramView.setBackgroundColor(0);
    if (!bo.isNullOrNil(this.pAS))
    {
      localButton1.setVisibility(0);
      localButton1.setText(this.pAS);
      if (bo.isNullOrNil(this.pAT)) {
        break label219;
      }
      if (!bo.isNullOrNil(this.pAS)) {
        break label211;
      }
      localView1.setVisibility(8);
      label112:
      localButton2.setVisibility(0);
      localButton2.setText(this.pAT);
      label127:
      if (bo.isNullOrNil(this.pAU)) {
        break label244;
      }
      if (!bo.isNullOrNil(this.pAT)) {
        break label235;
      }
      localView2.setVisibility(8);
      label154:
      localButton3.setVisibility(0);
      localButton3.setText(this.pAU);
    }
    for (;;)
    {
      localButton1.setOnClickListener(this.pAV);
      localButton2.setOnClickListener(this.pAW);
      localButton3.setOnClickListener(this.pAX);
      AppMethodBeat.o(23651);
      return;
      localButton1.setVisibility(8);
      break;
      label211:
      localView1.setVisibility(0);
      break label112;
      label219:
      localView1.setVisibility(8);
      localButton2.setVisibility(8);
      break label127;
      label235:
      localView2.setVisibility(0);
      break label154;
      label244:
      localView2.setVisibility(8);
      localButton3.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.MultiButtonPreference
 * JD-Core Version:    0.7.0.1
 */