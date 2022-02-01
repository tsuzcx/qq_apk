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
  public StringBuilder fWs;
  public int rwA;
  private boolean xpG;
  private ImageView xpH;
  private ImageView xpI;
  private ImageView xpJ;
  private ImageView xpK;
  private a xpL;
  private MMPwdInputView.b xpM;
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27697);
    this.fWs = new StringBuilder();
    this.xpG = false;
    this.xpM = MMPwdInputView.b.xpO;
    paramContext = inflate(getContext(), 2131495149, null);
    this.xpH = ((ImageView)paramContext.findViewById(2131300106));
    this.xpI = ((ImageView)paramContext.findViewById(2131304457));
    this.xpJ = ((ImageView)paramContext.findViewById(2131305767));
    this.xpK = ((ImageView)paramContext.findViewById(2131300234));
    this.xpH.setImageResource(2131231075);
    this.xpI.setImageResource(2131231075);
    this.xpJ.setImageResource(2131231075);
    this.xpK.setImageResource(2131231075);
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
  
  public final void bdi()
  {
    AppMethodBeat.i(27702);
    if (this.rwA > 0) {
      this.fWs.delete(0, this.rwA);
    }
    cvL();
    dFh();
    AppMethodBeat.o(27702);
  }
  
  public final void cvL()
  {
    AppMethodBeat.i(27701);
    if (this.fWs != null)
    {
      this.rwA = this.fWs.length();
      if (this.rwA < 4) {
        break label79;
      }
    }
    label79:
    for (this.xpG = true;; this.xpG = false)
    {
      if (this.xpL != null) {
        this.xpL.y(this.xpG, this.fWs.toString());
      }
      AppMethodBeat.o(27701);
      return;
      this.rwA = 0;
      break;
    }
  }
  
  public final void dFh()
  {
    AppMethodBeat.i(27699);
    int i = 0;
    if (i < 4)
    {
      String str;
      if (this.rwA > i)
      {
        str = this.fWs.toString().charAt(i);
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
        t(this.xpH, str);
        continue;
        t(this.xpI, str);
        continue;
        t(this.xpJ, str);
        continue;
        t(this.xpK, str);
      }
    }
    AppMethodBeat.o(27699);
  }
  
  public final void input(String paramString)
  {
    AppMethodBeat.i(27703);
    if ((TextUtils.isEmpty(paramString)) || (this.xpG))
    {
      AppMethodBeat.o(27703);
      return;
    }
    this.fWs.append(paramString);
    cvL();
    dFh();
    AppMethodBeat.o(27703);
  }
  
  public void setNumberStyle(MMPwdInputView.b paramb)
  {
    this.xpM = paramb;
  }
  
  public void setNumberWidth(int paramInt)
  {
    AppMethodBeat.i(27698);
    if (this.xpH != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.xpH.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.xpH.setLayoutParams(localLayoutParams);
      this.xpI.setLayoutParams(localLayoutParams);
      this.xpJ.setLayoutParams(localLayoutParams);
      this.xpK.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(27698);
  }
  
  public void setOnFinishInputListener(a parama)
  {
    this.xpL = parama;
  }
  
  public static abstract interface a
  {
    public abstract void y(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView
 * JD-Core Version:    0.7.0.1
 */