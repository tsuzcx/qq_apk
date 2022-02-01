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
  private String GRG;
  public String GZW;
  private String GZX;
  private View.OnClickListener GZY;
  public View.OnClickListener GZZ;
  private View.OnClickListener Haa;
  
  public MultiButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27263);
    setLayoutResource(R.i.eke);
    AppMethodBeat.o(27263);
  }
  
  public MultiButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27262);
    setLayoutResource(R.i.eke);
    AppMethodBeat.o(27262);
  }
  
  public final void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.GRG = paramString;
    this.GZY = paramOnClickListener;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27264);
    super.onBindView(paramView);
    Button localButton1 = (Button)paramView.findViewById(R.h.duK);
    View localView1 = paramView.findViewById(R.h.duL);
    Button localButton2 = (Button)paramView.findViewById(R.h.duM);
    View localView2 = paramView.findViewById(R.h.duN);
    Button localButton3 = (Button)paramView.findViewById(R.h.duO);
    paramView.setBackgroundColor(0);
    if (!Util.isNullOrNil(this.GRG))
    {
      localButton1.setVisibility(0);
      localButton1.setText(this.GRG);
      if (Util.isNullOrNil(this.GZW)) {
        break label224;
      }
      if (!Util.isNullOrNil(this.GRG)) {
        break label216;
      }
      localView1.setVisibility(8);
      label117:
      localButton2.setVisibility(0);
      localButton2.setText(this.GZW);
      label132:
      if (Util.isNullOrNil(this.GZX)) {
        break label249;
      }
      if (!Util.isNullOrNil(this.GZW)) {
        break label240;
      }
      localView2.setVisibility(8);
      label159:
      localButton3.setVisibility(0);
      localButton3.setText(this.GZX);
    }
    for (;;)
    {
      localButton1.setOnClickListener(this.GZY);
      localButton2.setOnClickListener(this.GZZ);
      localButton3.setOnClickListener(this.Haa);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.MultiButtonPreference
 * JD-Core Version:    0.7.0.1
 */