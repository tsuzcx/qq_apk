package com.tencent.mm.ui.widget.a;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

public class c$a
{
  public Context mContext;
  public a wmT;
  
  public c$a(Context paramContext)
  {
    this.mContext = paramContext;
    this.wmT = new a();
  }
  
  public final a Ip(int paramInt)
  {
    this.wmT.title = this.mContext.getString(paramInt);
    return this;
  }
  
  public final a Iq(int paramInt)
  {
    this.wmT.wlR = this.mContext.getString(paramInt);
    return this;
  }
  
  public final a Ir(int paramInt)
  {
    this.wmT.wml = paramInt;
    return this;
  }
  
  public final a Is(int paramInt)
  {
    this.wmT.wlU = this.mContext.getString(paramInt);
    return this;
  }
  
  public final a It(int paramInt)
  {
    this.wmT.wlV = this.mContext.getString(paramInt);
    return this;
  }
  
  public final a S(CharSequence paramCharSequence)
  {
    this.wmT.title = paramCharSequence;
    return this;
  }
  
  public final a T(CharSequence paramCharSequence)
  {
    this.wmT.wlB = paramCharSequence;
    return this;
  }
  
  public final a U(CharSequence paramCharSequence)
  {
    this.wmT.wlS = paramCharSequence;
    return this;
  }
  
  public final a a(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.wmT.wmc = paramOnClickListener;
    return this;
  }
  
  public final a a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.wmT.Oj = paramOnDismissListener;
    return this;
  }
  
  public final a a(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
  {
    this.wmT.wlQ = paramBitmap;
    this.wmT.wmb = paramBoolean;
    this.wmT.wmm = paramInt;
    return this;
  }
  
  public final a a(c.a.d paramd)
  {
    this.wmT.wlN = paramd;
    return this;
  }
  
  public final a a(String paramString, CharSequence paramCharSequence, Boolean paramBoolean, c.a.c paramc, a parama)
  {
    this.wmT.wlG = paramString;
    this.wmT.wlH = paramCharSequence;
    this.wmT.wlI = paramBoolean.booleanValue();
    this.wmT.wlK = paramc;
    this.wmT.wlL = parama;
    return this;
  }
  
  public final a a(boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.wmT.wmc = paramOnClickListener;
    this.wmT.wmq = paramBoolean;
    return this;
  }
  
  public final a aeA(String paramString)
  {
    this.wmT.wlR = paramString;
    return this;
  }
  
  public final a aeB(String paramString)
  {
    this.wmT.thumbPath = paramString;
    return this;
  }
  
  public final a aeC(String paramString)
  {
    this.wmT.wlD = paramString;
    return this;
  }
  
  public final a aeD(String paramString)
  {
    this.wmT.wlU = paramString;
    return this;
  }
  
  public final a aeE(String paramString)
  {
    this.wmT.wlV = paramString;
    return this;
  }
  
  public final a aez(String paramString)
  {
    this.wmT.title = paramString;
    return this;
  }
  
  public c aoP()
  {
    c localc = new c(this.mContext);
    localc.a(this.wmT);
    return localc;
  }
  
  public final a b(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.wmT.wmd = paramOnClickListener;
    return this;
  }
  
  public final a e(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.wmT.Oi = paramOnCancelListener;
    return this;
  }
  
  public final a ei(View paramView)
  {
    this.wmT.rod = paramView;
    return this;
  }
  
  public final a nU(boolean paramBoolean)
  {
    this.wmT.wma = paramBoolean;
    return this;
  }
  
  public final a nV(boolean paramBoolean)
  {
    this.wmT.wlF = paramBoolean;
    return this;
  }
  
  public final a nW(boolean paramBoolean)
  {
    this.wmT.fsA = paramBoolean;
    return this;
  }
  
  public final a nX(boolean paramBoolean)
  {
    this.wmT.wlZ = paramBoolean;
    return this;
  }
  
  public final void show()
  {
    aoP().show();
  }
  
  public static abstract interface a
  {
    public abstract void q(ImageView paramImageView, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void aSe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.c.a
 * JD-Core Version:    0.7.0.1
 */