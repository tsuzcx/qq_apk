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
  private boolean BpS;
  private ImageView BpT;
  private ImageView BpU;
  private ImageView BpV;
  private ImageView BpW;
  private a BpX;
  private MMPwdInputView.b BpY;
  public StringBuilder gBy;
  public int sWx;
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27697);
    this.gBy = new StringBuilder();
    this.BpS = false;
    this.BpY = MMPwdInputView.b.Bqa;
    paramContext = inflate(getContext(), 2131495992, null);
    this.BpT = ((ImageView)paramContext.findViewById(2131301545));
    this.BpU = ((ImageView)paramContext.findViewById(2131307433));
    this.BpV = ((ImageView)paramContext.findViewById(2131309038));
    this.BpW = ((ImageView)paramContext.findViewById(2131301708));
    this.BpT.setImageResource(2131231110);
    this.BpU.setImageResource(2131231110);
    this.BpV.setImageResource(2131231110);
    this.BpW.setImageResource(2131231110);
    addView(paramContext);
    AppMethodBeat.o(27697);
  }
  
  private static void w(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(27700);
    if (paramImageView == null)
    {
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("0"))
    {
      paramImageView.setImageResource(2131231100);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("1"))
    {
      paramImageView.setImageResource(2131231101);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("2"))
    {
      paramImageView.setImageResource(2131231102);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("3"))
    {
      paramImageView.setImageResource(2131231103);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("4"))
    {
      paramImageView.setImageResource(2131231104);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("5"))
    {
      paramImageView.setImageResource(2131231105);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("6"))
    {
      paramImageView.setImageResource(2131231106);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("7"))
    {
      paramImageView.setImageResource(2131231107);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("8"))
    {
      paramImageView.setImageResource(2131231108);
      AppMethodBeat.o(27700);
      return;
    }
    if (paramString.equals("9"))
    {
      paramImageView.setImageResource(2131231109);
      AppMethodBeat.o(27700);
      return;
    }
    paramImageView.setImageResource(2131231110);
    AppMethodBeat.o(27700);
  }
  
  public final void byC()
  {
    AppMethodBeat.i(27702);
    if (this.sWx > 0) {
      this.gBy.delete(0, this.sWx);
    }
    cTV();
    eFX();
    AppMethodBeat.o(27702);
  }
  
  public final void cTV()
  {
    AppMethodBeat.i(27701);
    if (this.gBy != null)
    {
      this.sWx = this.gBy.length();
      if (this.sWx < 4) {
        break label79;
      }
    }
    label79:
    for (this.BpS = true;; this.BpS = false)
    {
      if (this.BpX != null) {
        this.BpX.z(this.BpS, this.gBy.toString());
      }
      AppMethodBeat.o(27701);
      return;
      this.sWx = 0;
      break;
    }
  }
  
  public final void eFX()
  {
    AppMethodBeat.i(27699);
    int i = 0;
    if (i < 4)
    {
      String str;
      if (this.sWx > i)
      {
        str = this.gBy.toString().charAt(i);
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
        w(this.BpT, str);
        continue;
        w(this.BpU, str);
        continue;
        w(this.BpV, str);
        continue;
        w(this.BpW, str);
      }
    }
    AppMethodBeat.o(27699);
  }
  
  public final void input(String paramString)
  {
    AppMethodBeat.i(27703);
    if ((TextUtils.isEmpty(paramString)) || (this.BpS))
    {
      AppMethodBeat.o(27703);
      return;
    }
    this.gBy.append(paramString);
    cTV();
    eFX();
    AppMethodBeat.o(27703);
  }
  
  public void setNumberStyle(MMPwdInputView.b paramb)
  {
    this.BpY = paramb;
  }
  
  public void setNumberWidth(int paramInt)
  {
    AppMethodBeat.i(27698);
    if (this.BpT != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.BpT.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.BpT.setLayoutParams(localLayoutParams);
      this.BpU.setLayoutParams(localLayoutParams);
      this.BpV.setLayoutParams(localLayoutParams);
      this.BpW.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(27698);
  }
  
  public void setOnFinishInputListener(a parama)
  {
    this.BpX = parama;
  }
  
  public static abstract interface a
  {
    public abstract void z(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView
 * JD-Core Version:    0.7.0.1
 */