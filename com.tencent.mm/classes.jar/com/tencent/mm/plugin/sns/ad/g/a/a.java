package com.tencent.mm.plugin.sns.ad.g.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a
{
  protected int atW;
  protected Bitmap mBmp;
  protected Context mContext;
  protected FrameLayout neD;
  protected int zsg;
  protected int zsh;
  protected int zsi;
  protected int zsj;
  protected int zsk;
  protected BitmapDrawable zsl;
  protected ArrayList<Rect> zsm = new ArrayList();
  
  public a(Context paramContext, FrameLayout paramFrameLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mBmp = paramBitmap;
    this.mContext = paramContext;
    this.zsg = paramInt3;
    this.zsh = paramInt4;
    this.neD = paramFrameLayout;
    this.zsi = paramInt1;
    this.zsj = paramInt2;
    this.atW = paramInt5;
    this.zsl = new BitmapDrawable(paramContext.getResources(), this.mBmp);
    dVK();
  }
  
  protected static Rect a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 /= 2;
    paramRect.left = (paramInt1 - paramInt3);
    paramRect.right = (paramInt1 + paramInt3);
    paramRect.top = (paramInt2 - paramInt3);
    paramRect.bottom = (paramInt3 + paramInt2);
    return paramRect;
  }
  
  private void dVK()
  {
    try
    {
      clear();
      this.zsk = ((int)(1.3F * this.zsi * this.zsj / this.zsh / this.zsg / 12.0F));
      ae.i("BaseAnimScene", "spireNum=" + this.zsk);
      int i = 0;
      while (i < this.zsk)
      {
        this.zsm.add(dVJ());
        i += 1;
      }
      Iterator localIterator = this.zsm.iterator();
      while (localIterator.hasNext())
      {
        Rect localRect = (Rect)localIterator.next();
        View localView = new View(this.mContext);
        i = Math.abs(localRect.right - localRect.left);
        int j = Math.abs(localRect.top - localRect.bottom);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, j);
        localLayoutParams.leftMargin = localRect.left;
        localLayoutParams.topMargin = localRect.top;
        localView.setBackgroundDrawable(this.zsl);
        this.neD.addView(localView, localLayoutParams);
        int k = localRect.left;
        c(localView, i / 2 + k, localRect.top + j / 2, j);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("BaseAnimScene", "buildSprites exp=" + Log.getStackTraceString(localThrowable));
    }
  }
  
  protected abstract void c(View paramView, int paramInt1, int paramInt2, int paramInt3);
  
  public final void clear()
  {
    this.neD.removeAllViews();
    this.zsm.clear();
  }
  
  protected abstract Rect dVJ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.a.a
 * JD-Core Version:    0.7.0.1
 */