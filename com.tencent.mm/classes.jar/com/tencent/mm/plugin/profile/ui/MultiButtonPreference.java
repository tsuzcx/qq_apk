package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class MultiButtonPreference
  extends Preference
{
  private String MPk;
  public String MYb;
  private String MYc;
  private View.OnClickListener MYd;
  public View.OnClickListener MYe;
  private View.OnClickListener MYf;
  
  public MultiButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27263);
    setLayoutResource(R.i.gnh);
    AppMethodBeat.o(27263);
  }
  
  public MultiButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27262);
    setLayoutResource(R.i.gnh);
    AppMethodBeat.o(27262);
  }
  
  public final void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.MPk = paramString;
    this.MYd = paramOnClickListener;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27264);
    super.onBindView(paramView);
    Button localButton1 = (Button)paramView.findViewById(R.h.fvc);
    View localView1 = paramView.findViewById(R.h.fvd);
    Button localButton2 = (Button)paramView.findViewById(R.h.fve);
    View localView2 = paramView.findViewById(R.h.fvf);
    Button localButton3 = (Button)paramView.findViewById(R.h.fvg);
    paramView.setBackgroundColor(0);
    if (!Util.isNullOrNil(this.MPk))
    {
      localButton1.setVisibility(0);
      localButton1.setText(this.MPk);
      if (Util.isNullOrNil(this.MYb)) {
        break label224;
      }
      if (!Util.isNullOrNil(this.MPk)) {
        break label216;
      }
      localView1.setVisibility(8);
      label117:
      localButton2.setVisibility(0);
      localButton2.setText(this.MYb);
      label132:
      if (Util.isNullOrNil(this.MYc)) {
        break label249;
      }
      if (!Util.isNullOrNil(this.MYb)) {
        break label240;
      }
      localView2.setVisibility(8);
      label159:
      localButton3.setVisibility(0);
      localButton3.setText(this.MYc);
    }
    for (;;)
    {
      localButton1.setOnClickListener(this.MYd);
      localButton2.setOnClickListener(this.MYe);
      localButton3.setOnClickListener(this.MYf);
      AppMethodBeat.o(27264);
      return;
      localButton1.setVisibility(8);
      break;
      label216:
      localView1.setVisibility(0);
      break label117;
      label224:
      localView1.setVisibility(8);
      localButton2.setVisibility(8);
      break label132;
      label240:
      localView2.setVisibility(0);
      break label159;
      label249:
      localView2.setVisibility(8);
      localButton3.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.MultiButtonPreference
 * JD-Core Version:    0.7.0.1
 */