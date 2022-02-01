package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;

public class MultiButtonPreference
  extends Preference
{
  private String uCA;
  public String uCB;
  private String uCC;
  private View.OnClickListener uCD;
  public View.OnClickListener uCE;
  private View.OnClickListener uCF;
  
  public MultiButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27263);
    setLayoutResource(2131495140);
    AppMethodBeat.o(27263);
  }
  
  public MultiButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27262);
    setLayoutResource(2131495140);
    AppMethodBeat.o(27262);
  }
  
  public final void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.uCA = paramString;
    this.uCD = paramOnClickListener;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27264);
    super.onBindView(paramView);
    Button localButton1 = (Button)paramView.findViewById(2131297634);
    View localView1 = paramView.findViewById(2131297635);
    Button localButton2 = (Button)paramView.findViewById(2131297636);
    View localView2 = paramView.findViewById(2131297637);
    Button localButton3 = (Button)paramView.findViewById(2131297638);
    paramView.setBackgroundColor(0);
    if (!bt.isNullOrNil(this.uCA))
    {
      localButton1.setVisibility(0);
      localButton1.setText(this.uCA);
      if (bt.isNullOrNil(this.uCB)) {
        break label219;
      }
      if (!bt.isNullOrNil(this.uCA)) {
        break label211;
      }
      localView1.setVisibility(8);
      label112:
      localButton2.setVisibility(0);
      localButton2.setText(this.uCB);
      label127:
      if (bt.isNullOrNil(this.uCC)) {
        break label244;
      }
      if (!bt.isNullOrNil(this.uCB)) {
        break label235;
      }
      localView2.setVisibility(8);
      label154:
      localButton3.setVisibility(0);
      localButton3.setText(this.uCC);
    }
    for (;;)
    {
      localButton1.setOnClickListener(this.uCD);
      localButton2.setOnClickListener(this.uCE);
      localButton3.setOnClickListener(this.uCF);
      AppMethodBeat.o(27264);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.MultiButtonPreference
 * JD-Core Version:    0.7.0.1
 */