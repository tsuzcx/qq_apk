package com.tencent.mm.plugin.sns.ad.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a
{
  protected int DAQ;
  protected int DAR;
  protected int DAS;
  protected int DAT;
  protected FrameLayout DAU;
  protected BitmapDrawable DAV;
  protected ArrayList<Rect> DAW = new ArrayList();
  protected int atU;
  protected Bitmap mBmp;
  protected Context mContext;
  protected int mMaxSize;
  
  public a(Context paramContext, FrameLayout paramFrameLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mBmp = paramBitmap;
    this.mContext = paramContext;
    this.DAQ = paramInt3;
    this.mMaxSize = paramInt4;
    this.DAU = paramFrameLayout;
    this.DAR = paramInt1;
    this.DAS = paramInt2;
    this.atU = paramInt5;
    this.DAV = new BitmapDrawable(paramContext.getResources(), this.mBmp);
    eYA();
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
  
  private void eYA()
  {
    int j;
    for (int i = 16;; i = j) {
      try
      {
        clear();
        j = (int)(1.3F * this.DAR * this.DAS / this.mMaxSize / this.DAQ / 12.0F);
        if (j < 16)
        {
          this.DAT = i;
          com.tencent.mm.sdk.platformtools.Log.i("BaseAnimScene", "spireNum=" + this.DAT);
          i = 0;
          while (i < this.DAT)
          {
            this.DAW.add(eYz());
            i += 1;
          }
          Iterator localIterator = this.DAW.iterator();
          while (localIterator.hasNext())
          {
            Rect localRect = (Rect)localIterator.next();
            View localView = new View(this.mContext);
            i = Math.abs(localRect.right - localRect.left);
            j = Math.abs(localRect.top - localRect.bottom);
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, j);
            localLayoutParams.leftMargin = localRect.left;
            localLayoutParams.topMargin = localRect.top;
            localView.setBackgroundDrawable(this.DAV);
            this.DAU.addView(localView, localLayoutParams);
            int k = localRect.left;
            c(localView, i / 2 + k, localRect.top + j / 2, j);
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.Log.e("BaseAnimScene", "buildSprites exp=" + android.util.Log.getStackTraceString(localThrowable));
      }
    }
  }
  
  protected abstract void c(View paramView, int paramInt1, int paramInt2, int paramInt3);
  
  public final void clear()
  {
    this.DAU.removeAllViews();
    this.DAW.clear();
  }
  
  protected abstract Rect eYz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.a
 * JD-Core Version:    0.7.0.1
 */