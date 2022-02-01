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
  public StringBuilder fAW;
  public int qEF;
  private boolean vSF;
  private ImageView vSG;
  private ImageView vSH;
  private ImageView vSI;
  private ImageView vSJ;
  private a vSK;
  private MMPwdInputView.b vSL;
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27697);
    this.fAW = new StringBuilder();
    this.vSF = false;
    this.vSL = MMPwdInputView.b.vSN;
    paramContext = inflate(getContext(), 2131495149, null);
    this.vSG = ((ImageView)paramContext.findViewById(2131300106));
    this.vSH = ((ImageView)paramContext.findViewById(2131304457));
    this.vSI = ((ImageView)paramContext.findViewById(2131305767));
    this.vSJ = ((ImageView)paramContext.findViewById(2131300234));
    this.vSG.setImageResource(2131231075);
    this.vSH.setImageResource(2131231075);
    this.vSI.setImageResource(2131231075);
    this.vSJ.setImageResource(2131231075);
    addView(paramContext);
    AppMethodBeat.o(27697);
  }
  
  private static void t(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(27700);
    if (paramImageView == null)
    {
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("0"))
    {
      paramImageView.setImageResource(2131231065);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("1"))
    {
      paramImageView.setImageResource(2131231066);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("2"))
    {
      paramImageView.setImageResource(2131231067);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("3"))
    {
      paramImageView.setImageResource(2131231068);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("4"))
    {
      paramImageView.setImageResource(2131231069);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("5"))
    {
      paramImageView.setImageResource(2131231070);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("6"))
    {
      paramImageView.setImageResource(2131231071);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("7"))
    {
      paramImageView.setImageResource(2131231072);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("8"))
    {
      paramImageView.setImageResource(2131231073);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("9"))
    {
      paramImageView.setImageResource(2131231074);
      AppMethodBeat.o(27700);
      return;
    }
    paramImageView.setImageResource(2131231075);
    AppMethodBeat.o(27700);
  }
  
  public final void aZf()
  {
    AppMethodBeat.i(27702);
    if (this.qEF > 0) {
      this.fAW.delete(0, this.qEF);
    }
    coF();
    dro();
    AppMethodBeat.o(27702);
  }
  
  public final void coF()
  {
    AppMethodBeat.i(27701);
    if (this.fAW != null)
    {
      this.qEF = this.fAW.length();
      if (this.qEF < 4) {
        break label79;
      }
    }
    label79:
    for (this.vSF = true;; this.vSF = false)
    {
      if (this.vSK != null) {
        this.vSK.t(this.vSF, this.fAW.toString());
      }
      AppMethodBeat.o(27701);
      return;
      this.qEF = 0;
      break;
    }
  }
  
  public final void dro()
  {
    AppMethodBeat.i(27699);
    int i = 0;
    if (i < 4)
    {
      String str;
      if (this.qEF > i)
      {
        str = this.fAW.toString().charAt(i);
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
        t(this.vSG, str);
        continue;
        t(this.vSH, str);
        continue;
        t(this.vSI, str);
        continue;
        t(this.vSJ, str);
      }
    }
    AppMethodBeat.o(27699);
  }
  
  public final void input(String paramString)
  {
    AppMethodBeat.i(27703);
    if ((TextUtils.isEmpty(paramString)) || (this.vSF))
    {
      AppMethodBeat.o(27703);
      return;
    }
    this.fAW.append(paramString);
    coF();
    dro();
    AppMethodBeat.o(27703);
  }
  
  public void setNumberStyle(MMPwdInputView.b paramb)
  {
    this.vSL = paramb;
  }
  
  public void setNumberWidth(int paramInt)
  {
    AppMethodBeat.i(27698);
    if (this.vSG != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.vSG.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.vSG.setLayoutParams(localLayoutParams);
      this.vSH.setLayoutParams(localLayoutParams);
      this.vSI.setLayoutParams(localLayoutParams);
      this.vSJ.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(27698);
  }
  
  public void setOnFinishInputListener(a parama)
  {
    this.vSK = parama;
  }
  
  public static abstract interface a
  {
    public abstract void t(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView
 * JD-Core Version:    0.7.0.1
 */