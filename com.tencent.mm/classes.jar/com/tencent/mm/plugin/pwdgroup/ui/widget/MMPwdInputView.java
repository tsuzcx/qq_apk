package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public class MMPwdInputView
  extends LinearLayout
{
  public StringBuilder dsX = new StringBuilder();
  public int jUY;
  private boolean ncg = false;
  private ImageView nch;
  private ImageView nci;
  private ImageView ncj;
  private ImageView nck;
  private a ncl;
  private b ncm = b.nco;
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMPwdInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramContext = inflate(getContext(), R.i.pwd_input_view, null);
    this.nch = ((ImageView)paramContext.findViewById(R.h.first));
    this.nci = ((ImageView)paramContext.findViewById(R.h.second));
    this.ncj = ((ImageView)paramContext.findViewById(R.h.third));
    this.nck = ((ImageView)paramContext.findViewById(R.h.fourth));
    this.nch.setImageResource(R.g.around_friends_point);
    this.nci.setImageResource(R.g.around_friends_point);
    this.ncj.setImageResource(R.g.around_friends_point);
    this.nck.setImageResource(R.g.around_friends_point);
    addView(paramContext);
  }
  
  private static void m(ImageView paramImageView, String paramString)
  {
    if (paramImageView == null) {
      return;
    }
    if (paramString.equals("0"))
    {
      paramImageView.setImageResource(R.g.around_friends_number0);
      return;
    }
    if (paramString.equals("1"))
    {
      paramImageView.setImageResource(R.g.around_friends_number1);
      return;
    }
    if (paramString.equals("2"))
    {
      paramImageView.setImageResource(R.g.around_friends_number2);
      return;
    }
    if (paramString.equals("3"))
    {
      paramImageView.setImageResource(R.g.around_friends_number3);
      return;
    }
    if (paramString.equals("4"))
    {
      paramImageView.setImageResource(R.g.around_friends_number4);
      return;
    }
    if (paramString.equals("5"))
    {
      paramImageView.setImageResource(R.g.around_friends_number5);
      return;
    }
    if (paramString.equals("6"))
    {
      paramImageView.setImageResource(R.g.around_friends_number6);
      return;
    }
    if (paramString.equals("7"))
    {
      paramImageView.setImageResource(R.g.around_friends_number7);
      return;
    }
    if (paramString.equals("8"))
    {
      paramImageView.setImageResource(R.g.around_friends_number8);
      return;
    }
    if (paramString.equals("9"))
    {
      paramImageView.setImageResource(R.g.around_friends_number9);
      return;
    }
    paramImageView.setImageResource(R.g.around_friends_point);
  }
  
  public final void aUK()
  {
    if (this.jUY > 0) {
      this.dsX.delete(0, this.jUY);
    }
    bth();
    btg();
  }
  
  public final void btg()
  {
    int i = 0;
    if (i < 4)
    {
      String str;
      if (this.jUY > i)
      {
        str = this.dsX.toString().charAt(i);
        label40:
        switch (i)
        {
        }
      }
      for (;;)
      {
        i += 1;
        break;
        str = "";
        break label40;
        m(this.nch, str);
        continue;
        m(this.nci, str);
        continue;
        m(this.ncj, str);
        continue;
        m(this.nck, str);
      }
    }
  }
  
  public final void bth()
  {
    if (this.dsX != null)
    {
      this.jUY = this.dsX.length();
      if (this.jUY < 4) {
        break label67;
      }
    }
    label67:
    for (this.ncg = true;; this.ncg = false)
    {
      if (this.ncl != null) {
        this.ncl.l(this.ncg, this.dsX.toString());
      }
      return;
      this.jUY = 0;
      break;
    }
  }
  
  public final void input(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.ncg)) {
      return;
    }
    this.dsX.append(paramString);
    bth();
    btg();
  }
  
  public void setNumberStyle(b paramb)
  {
    this.ncm = paramb;
  }
  
  public void setNumberWidth(int paramInt)
  {
    if (this.nch != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.nch.getLayoutParams();
      localLayoutParams.width = paramInt;
      this.nch.setLayoutParams(localLayoutParams);
      this.nci.setLayoutParams(localLayoutParams);
      this.ncj.setLayoutParams(localLayoutParams);
      this.nck.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setOnFinishInputListener(a parama)
  {
    this.ncl = parama;
  }
  
  public static abstract interface a
  {
    public abstract void l(boolean paramBoolean, String paramString);
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView
 * JD-Core Version:    0.7.0.1
 */