package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class MultiButtonPreference
  extends Preference
{
  private String Bgn;
  public String Bgo;
  private String Bgp;
  private View.OnClickListener Bgq;
  public View.OnClickListener Bgr;
  private View.OnClickListener Bgs;
  
  public MultiButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27263);
    setLayoutResource(2131495983);
    AppMethodBeat.o(27263);
  }
  
  public MultiButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27262);
    setLayoutResource(2131495983);
    AppMethodBeat.o(27262);
  }
  
  public final void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.Bgn = paramString;
    this.Bgq = paramOnClickListener;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27264);
    super.onBindView(paramView);
    Button localButton1 = (Button)paramView.findViewById(2131297896);
    View localView1 = paramView.findViewById(2131297897);
    Button localButton2 = (Button)paramView.findViewById(2131297898);
    View localView2 = paramView.findViewById(2131297899);
    Button localButton3 = (Button)paramView.findViewById(2131297900);
    paramView.setBackgroundColor(0);
    if (!Util.isNullOrNil(this.Bgn))
    {
      localButton1.setVisibility(0);
      localButton1.setText(this.Bgn);
      if (Util.isNullOrNil(this.Bgo)) {
        break label219;
      }
      if (!Util.isNullOrNil(this.Bgn)) {
        break label211;
      }
      localView1.setVisibility(8);
      label112:
      localButton2.setVisibility(0);
      localButton2.setText(this.Bgo);
      label127:
      if (Util.isNullOrNil(this.Bgp)) {
        break label244;
      }
      if (!Util.isNullOrNil(this.Bgo)) {
        break label235;
      }
      localView2.setVisibility(8);
      label154:
      localButton3.setVisibility(0);
      localButton3.setText(this.Bgp);
    }
    for (;;)
    {
      localButton1.setOnClickListener(this.Bgq);
      localButton2.setOnClickListener(this.Bgr);
      localButton3.setOnClickListener(this.Bgs);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.MultiButtonPreference
 * JD-Core Version:    0.7.0.1
 */