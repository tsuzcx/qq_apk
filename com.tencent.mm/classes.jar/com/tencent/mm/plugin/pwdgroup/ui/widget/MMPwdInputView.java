package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMPwdInputView
  extends LinearLayout
{
  public StringBuilder ekE;
  public int mpr;
  private ImageView pHA;
  private ImageView pHB;
  private ImageView pHC;
  private MMPwdInputView.a pHD;
  private MMPwdInputView.b pHE;
  private boolean pHy;
  private ImageView pHz;
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(24056);
    this.ekE = new StringBuilder();
    this.pHy = false;
    this.pHE = MMPwdInputView.b.pHG;
    paramContext = inflate(getContext(), 2130970476, null);
    this.pHz = ((ImageView)paramContext.findViewById(2131826867));
    this.pHA = ((ImageView)paramContext.findViewById(2131826868));
    this.pHB = ((ImageView)paramContext.findViewById(2131826869));
    this.pHC = ((ImageView)paramContext.findViewById(2131826870));
    this.pHz.setImageResource(2130837819);
    this.pHA.setImageResource(2130837819);
    this.pHB.setImageResource(2130837819);
    this.pHC.setImageResource(2130837819);
    addView(paramContext);
    AppMethodBeat.o(24056);
  }
  
  private static void r(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(24059);
    if (paramImageView == null)
    {
      AppMethodBeat.o(24059);
      return;
    }
    if (paramString.equals("0"))
    {
      paramImageView.setImageResource(2130837809);
      AppMethodBeat.o(24059);
      return;
    }
    if (paramString.equals("1"))
    {
      paramImageView.setImageResource(2130837810);
      AppMethodBeat.o(24059);
      return;
    }
    if (paramString.equals("2"))
    {
      paramImageView.setImageResource(2130837811);
      AppMethodBeat.o(24059);
      return;
    }
    if (paramString.equals("3"))
    {
      paramImageView.setImageResource(2130837812);
      AppMethodBeat.o(24059);
      return;
    }
    if (paramString.equals("4"))
    {
      paramImageView.setImageResource(2130837813);
      AppMethodBeat.o(24059);
      return;
    }
    if (paramString.equals("5"))
    {
      paramImageView.setImageResource(2130837814);
      AppMethodBeat.o(24059);
      return;
    }
    if (paramString.equals("6"))
    {
      paramImageView.setImageResource(2130837815);
      AppMethodBeat.o(24059);
      return;
    }
    if (paramString.equals("7"))
    {
      paramImageView.setImageResource(2130837816);
      AppMethodBeat.o(24059);
      return;
    }
    if (paramString.equals("8"))
    {
      paramImageView.setImageResource(2130837817);
      AppMethodBeat.o(24059);
      return;
    }
    if (paramString.equals("9"))
    {
      paramImageView.setImageResource(2130837818);
      AppMethodBeat.o(24059);
      return;
    }
    paramImageView.setImageResource(2130837819);
    AppMethodBeat.o(24059);
  }
  
  public final void axH()
  {
    AppMethodBeat.i(24061);
    if (this.mpr > 0) {
      this.ekE.delete(0, this.mpr);
    }
    bvD();
    cdo();
    AppMethodBeat.o(24061);
  }
  
  public final void bvD()
  {
    AppMethodBeat.i(24060);
    if (this.ekE != null)
    {
      this.mpr = this.ekE.length();
      if (this.mpr < 4) {
        break label79;
      }
    }
    label79:
    for (this.pHy = true;; this.pHy = false)
    {
      if (this.pHD != null) {
        this.pHD.q(this.pHy, this.ekE.toString());
      }
      AppMethodBeat.o(24060);
      return;
      this.mpr = 0;
      break;
    }
  }
  
  public final void cdo()
  {
    AppMethodBeat.i(24058);
    int i = 0;
    if (i < 4)
    {
      String str;
      if (this.mpr > i)
      {
        str = this.ekE.toString().charAt(i);
        label46:
        switch (i)
        {
        }
      }
      for (;;)
      {
        i += 1;
        break;
        str = "";
        break label46;
        r(this.pHz, str);
        continue;
        r(this.pHA, str);
        continue;
        r(this.pHB, str);
        continue;
        r(this.pHC, str);
      }
    }
    AppMethodBeat.o(24058);
  }
  
  public final void input(String paramString)
  {
    AppMethodBeat.i(24062);
    if ((TextUtils.isEmpty(paramString)) || (this.pHy))
    {
      AppMethodBeat.o(24062);
      return;
    }
    this.ekE.append(paramString);
    bvD();
    cdo();
    AppMethodBeat.o(24062);
  }
  
  public void setNumberStyle(MMPwdInputView.b paramb)
  {
    this.pHE = paramb;
  }
  
  public void setNumberWidth(int paramInt)
  {
    AppMethodBeat.i(24057);
    if (this.pHz != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.pHz.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.pHz.setLayoutParams(localLayoutParams);
      this.pHA.setLayoutParams(localLayoutParams);
      this.pHB.setLayoutParams(localLayoutParams);
      this.pHC.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(24057);
  }
  
  public void setOnFinishInputListener(MMPwdInputView.a parama)
  {
    this.pHD = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView
 * JD-Core Version:    0.7.0.1
 */