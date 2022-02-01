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
  public StringBuilder fxp;
  public int pWa;
  private boolean uJO;
  private ImageView uJP;
  private ImageView uJQ;
  private ImageView uJR;
  private ImageView uJS;
  private a uJT;
  private MMPwdInputView.b uJU;
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27697);
    this.fxp = new StringBuilder();
    this.uJO = false;
    this.uJU = MMPwdInputView.b.uJW;
    paramContext = inflate(getContext(), 2131495149, null);
    this.uJP = ((ImageView)paramContext.findViewById(2131300106));
    this.uJQ = ((ImageView)paramContext.findViewById(2131304457));
    this.uJR = ((ImageView)paramContext.findViewById(2131305767));
    this.uJS = ((ImageView)paramContext.findViewById(2131300234));
    this.uJP.setImageResource(2131231075);
    this.uJQ.setImageResource(2131231075);
    this.uJR.setImageResource(2131231075);
    this.uJS.setImageResource(2131231075);
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
  
  public final void aSi()
  {
    AppMethodBeat.i(27702);
    if (this.pWa > 0) {
      this.fxp.delete(0, this.pWa);
    }
    cgY();
    ddG();
    AppMethodBeat.o(27702);
  }
  
  public final void cgY()
  {
    AppMethodBeat.i(27701);
    if (this.fxp != null)
    {
      this.pWa = this.fxp.length();
      if (this.pWa < 4) {
        break label79;
      }
    }
    label79:
    for (this.uJO = true;; this.uJO = false)
    {
      if (this.uJT != null) {
        this.uJT.s(this.uJO, this.fxp.toString());
      }
      AppMethodBeat.o(27701);
      return;
      this.pWa = 0;
      break;
    }
  }
  
  public final void ddG()
  {
    AppMethodBeat.i(27699);
    int i = 0;
    if (i < 4)
    {
      String str;
      if (this.pWa > i)
      {
        str = this.fxp.toString().charAt(i);
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
        t(this.uJP, str);
        continue;
        t(this.uJQ, str);
        continue;
        t(this.uJR, str);
        continue;
        t(this.uJS, str);
      }
    }
    AppMethodBeat.o(27699);
  }
  
  public final void input(String paramString)
  {
    AppMethodBeat.i(27703);
    if ((TextUtils.isEmpty(paramString)) || (this.uJO))
    {
      AppMethodBeat.o(27703);
      return;
    }
    this.fxp.append(paramString);
    cgY();
    ddG();
    AppMethodBeat.o(27703);
  }
  
  public void setNumberStyle(MMPwdInputView.b paramb)
  {
    this.uJU = paramb;
  }
  
  public void setNumberWidth(int paramInt)
  {
    AppMethodBeat.i(27698);
    if (this.uJP != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.uJP.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.uJP.setLayoutParams(localLayoutParams);
      this.uJQ.setLayoutParams(localLayoutParams);
      this.uJR.setLayoutParams(localLayoutParams);
      this.uJS.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(27698);
  }
  
  public void setOnFinishInputListener(a parama)
  {
    this.uJT = parama;
  }
  
  public static abstract interface a
  {
    public abstract void s(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView
 * JD-Core Version:    0.7.0.1
 */