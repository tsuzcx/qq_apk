package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public class MMPwdInputView
  extends LinearLayout
{
  private boolean Hkl;
  private ImageView Hkm;
  private ImageView Hkn;
  private ImageView Hko;
  private ImageView Hkp;
  private a Hkq;
  private MMPwdInputView.b Hkr;
  public StringBuilder jlE;
  public int wCv;
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27697);
    this.jlE = new StringBuilder();
    this.Hkl = false;
    this.Hkr = MMPwdInputView.b.Hkt;
    paramContext = inflate(getContext(), R.i.ekk, null);
    this.Hkm = ((ImageView)paramContext.findViewById(R.h.dHa));
    this.Hkn = ((ImageView)paramContext.findViewById(R.h.second));
    this.Hko = ((ImageView)paramContext.findViewById(R.h.dWy));
    this.Hkp = ((ImageView)paramContext.findViewById(R.h.dHF));
    this.Hkm.setImageResource(R.g.dmj);
    this.Hkn.setImageResource(R.g.dmj);
    this.Hko.setImageResource(R.g.dmj);
    this.Hkp.setImageResource(R.g.dmj);
    addView(paramContext);
    AppMethodBeat.o(27697);
  }
  
  private static void v(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(27700);
    if (paramImageView == null)
    {
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("0"))
    {
      paramImageView.setImageResource(R.g.dlZ);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("1"))
    {
      paramImageView.setImageResource(R.g.dma);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("2"))
    {
      paramImageView.setImageResource(R.g.dmb);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("3"))
    {
      paramImageView.setImageResource(R.g.dmc);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("4"))
    {
      paramImageView.setImageResource(R.g.dmd);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("5"))
    {
      paramImageView.setImageResource(R.g.dme);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("6"))
    {
      paramImageView.setImageResource(R.g.dmf);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("7"))
    {
      paramImageView.setImageResource(R.g.dmg);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("8"))
    {
      paramImageView.setImageResource(R.g.dmh);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("9"))
    {
      paramImageView.setImageResource(R.g.dmi);
      AppMethodBeat.o(27700);
      return;
    }
    paramImageView.setImageResource(R.g.dmj);
    AppMethodBeat.o(27700);
  }
  
  public final void aVa(String paramString)
  {
    AppMethodBeat.i(27703);
    if ((TextUtils.isEmpty(paramString)) || (this.Hkl))
    {
      AppMethodBeat.o(27703);
      return;
    }
    this.jlE.append(paramString);
    djb();
    frX();
    AppMethodBeat.o(27703);
  }
  
  public final void bJQ()
  {
    AppMethodBeat.i(27702);
    if (this.wCv > 0) {
      this.jlE.delete(0, this.wCv);
    }
    djb();
    frX();
    AppMethodBeat.o(27702);
  }
  
  public final void djb()
  {
    AppMethodBeat.i(27701);
    if (this.jlE != null)
    {
      this.wCv = this.jlE.length();
      if (this.wCv < 4) {
        break label79;
      }
    }
    label79:
    for (this.Hkl = true;; this.Hkl = false)
    {
      if (this.Hkq != null) {
        this.Hkq.E(this.Hkl, this.jlE.toString());
      }
      AppMethodBeat.o(27701);
      return;
      this.wCv = 0;
      break;
    }
  }
  
  public final void frX()
  {
    AppMethodBeat.i(27699);
    int i = 0;
    if (i < 4)
    {
      String str;
      if (this.wCv > i)
      {
        str = this.jlE.toString().charAt(i);
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
        v(this.Hkm, str);
        continue;
        v(this.Hkn, str);
        continue;
        v(this.Hko, str);
        continue;
        v(this.Hkp, str);
      }
    }
    AppMethodBeat.o(27699);
  }
  
  public void setNumberStyle(MMPwdInputView.b paramb)
  {
    this.Hkr = paramb;
  }
  
  public void setNumberWidth(int paramInt)
  {
    AppMethodBeat.i(27698);
    if (this.Hkm != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.Hkm.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.Hkm.setLayoutParams(localLayoutParams);
      this.Hkn.setLayoutParams(localLayoutParams);
      this.Hko.setLayoutParams(localLayoutParams);
      this.Hkp.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(27698);
  }
  
  public void setOnFinishInputListener(a parama)
  {
    this.Hkq = parama;
  }
  
  public static abstract interface a
  {
    public abstract void E(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView
 * JD-Core Version:    0.7.0.1
 */