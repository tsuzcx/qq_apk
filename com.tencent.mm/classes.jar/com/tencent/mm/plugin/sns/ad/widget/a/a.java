package com.tencent.mm.plugin.sns.ad.widget.a;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public abstract class a
  extends b
{
  protected FrameLayout PQX;
  
  public a(Context paramContext, FrameLayout paramFrameLayout, b.a parama)
  {
    super(paramContext, parama);
    this.PQX = paramFrameLayout;
    hdg();
  }
  
  protected abstract void A(View paramView, int paramInt1, int paramInt2);
  
  protected final void B(Rect paramRect)
  {
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    int j = Math.abs(paramRect.right - paramRect.left);
    int i = Math.abs(paramRect.top - paramRect.bottom);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(j, i);
    localLayoutParams.leftMargin = paramRect.left;
    localLayoutParams.topMargin = paramRect.top;
    localImageView.setImageBitmap(this.Qhg.Qhk);
    this.PQX.addView(localImageView, localLayoutParams);
    j = paramRect.left;
    A(localImageView, paramRect.top + i / 2, i);
  }
  
  public final void clear()
  {
    super.clear();
    this.PQX.removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.a
 * JD-Core Version:    0.7.0.1
 */