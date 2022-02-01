package com.tencent.mm.plugin.sns.ad.f.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a
{
  protected int atW;
  protected Bitmap mBmp;
  protected Context mContext;
  protected FrameLayout mZv;
  protected int zbD;
  protected int zbE;
  protected int zbF;
  protected int zbG;
  protected int zbH;
  protected BitmapDrawable zbI;
  protected ArrayList<Rect> zbJ = new ArrayList();
  
  public a(Context paramContext, FrameLayout paramFrameLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mBmp = paramBitmap;
    this.mContext = paramContext;
    this.zbD = paramInt3;
    this.zbE = paramInt4;
    this.mZv = paramFrameLayout;
    this.zbF = paramInt1;
    this.zbG = paramInt2;
    this.atW = paramInt5;
    this.zbI = new BitmapDrawable(paramContext.getResources(), this.mBmp);
    dSm();
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
  
  private void dSm()
  {
    try
    {
      clear();
      this.zbH = ((int)(1.3F * this.zbF * this.zbG / this.zbE / this.zbD / 12.0F));
      ad.i("BaseAnimScene", "spireNum=" + this.zbH);
      int i = 0;
      while (i < this.zbH)
      {
        this.zbJ.add(dSl());
        i += 1;
      }
      Iterator localIterator = this.zbJ.iterator();
      while (localIterator.hasNext())
      {
        Rect localRect = (Rect)localIterator.next();
        View localView = new View(this.mContext);
        i = Math.abs(localRect.right - localRect.left);
        int j = Math.abs(localRect.top - localRect.bottom);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, j);
        localLayoutParams.leftMargin = localRect.left;
        localLayoutParams.topMargin = localRect.top;
        localView.setBackgroundDrawable(this.zbI);
        this.mZv.addView(localView, localLayoutParams);
        int k = localRect.left;
        c(localView, i / 2 + k, localRect.top + j / 2, j);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("BaseAnimScene", "buildSprites exp=" + Log.getStackTraceString(localThrowable));
    }
  }
  
  protected abstract void c(View paramView, int paramInt1, int paramInt2, int paramInt3);
  
  public final void clear()
  {
    this.mZv.removeAllViews();
    this.zbJ.clear();
  }
  
  protected abstract Rect dSl();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.a.a
 * JD-Core Version:    0.7.0.1
 */