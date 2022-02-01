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
  public StringBuilder fUm;
  public int rov;
  private boolean wZP;
  private ImageView wZQ;
  private ImageView wZR;
  private ImageView wZS;
  private ImageView wZT;
  private a wZU;
  private MMPwdInputView.b wZV;
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27697);
    this.fUm = new StringBuilder();
    this.wZP = false;
    this.wZV = MMPwdInputView.b.wZX;
    paramContext = inflate(getContext(), 2131495149, null);
    this.wZQ = ((ImageView)paramContext.findViewById(2131300106));
    this.wZR = ((ImageView)paramContext.findViewById(2131304457));
    this.wZS = ((ImageView)paramContext.findViewById(2131305767));
    this.wZT = ((ImageView)paramContext.findViewById(2131300234));
    this.wZQ.setImageResource(2131231075);
    this.wZR.setImageResource(2131231075);
    this.wZS.setImageResource(2131231075);
    this.wZT.setImageResource(2131231075);
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
  
  public final void bcD()
  {
    AppMethodBeat.i(27702);
    if (this.rov > 0) {
      this.fUm.delete(0, this.rov);
    }
    cuk();
    dBQ();
    AppMethodBeat.o(27702);
  }
  
  public final void cuk()
  {
    AppMethodBeat.i(27701);
    if (this.fUm != null)
    {
      this.rov = this.fUm.length();
      if (this.rov < 4) {
        break label79;
      }
    }
    label79:
    for (this.wZP = true;; this.wZP = false)
    {
      if (this.wZU != null) {
        this.wZU.x(this.wZP, this.fUm.toString());
      }
      AppMethodBeat.o(27701);
      return;
      this.rov = 0;
      break;
    }
  }
  
  public final void dBQ()
  {
    AppMethodBeat.i(27699);
    int i = 0;
    if (i < 4)
    {
      String str;
      if (this.rov > i)
      {
        str = this.fUm.toString().charAt(i);
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
        t(this.wZQ, str);
        continue;
        t(this.wZR, str);
        continue;
        t(this.wZS, str);
        continue;
        t(this.wZT, str);
      }
    }
    AppMethodBeat.o(27699);
  }
  
  public final void input(String paramString)
  {
    AppMethodBeat.i(27703);
    if ((TextUtils.isEmpty(paramString)) || (this.wZP))
    {
      AppMethodBeat.o(27703);
      return;
    }
    this.fUm.append(paramString);
    cuk();
    dBQ();
    AppMethodBeat.o(27703);
  }
  
  public void setNumberStyle(MMPwdInputView.b paramb)
  {
    this.wZV = paramb;
  }
  
  public void setNumberWidth(int paramInt)
  {
    AppMethodBeat.i(27698);
    if (this.wZQ != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.wZQ.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.wZQ.setLayoutParams(localLayoutParams);
      this.wZR.setLayoutParams(localLayoutParams);
      this.wZS.setLayoutParams(localLayoutParams);
      this.wZT.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(27698);
  }
  
  public void setOnFinishInputListener(a parama)
  {
    this.wZU = parama;
  }
  
  public static abstract interface a
  {
    public abstract void x(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView
 * JD-Core Version:    0.7.0.1
 */