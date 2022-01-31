package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

abstract class f$b
{
  View.OnClickListener oMB = new f.b.1(this);
  View.OnClickListener oMC = new f.b.2(this);
  View.OnClickListener oMD = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      f.b.this.oME = ((f.b.a)paramAnonymousView.getTag());
      int i = f.b.this.oME.position;
      f.b.this.yv(i);
    }
  };
  public a oME = new a();
  
  public abstract void yv(int paramInt);
  
  public static final class a
  {
    public String bRV;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f.b
 * JD-Core Version:    0.7.0.1
 */