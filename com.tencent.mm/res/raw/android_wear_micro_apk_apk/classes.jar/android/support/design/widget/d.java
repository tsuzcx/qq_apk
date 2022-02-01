package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class d
  extends ViewGroup.MarginLayoutParams
{
  CoordinatorLayout.Behavior be;
  boolean bf = false;
  public int bg = 0;
  public int bh = -1;
  int bi = -1;
  public int bj = 0;
  public int bk = 0;
  int bl;
  int bm;
  View bn;
  View bo;
  private boolean bp;
  private boolean bq;
  private boolean br;
  private boolean bs;
  final Rect bt = new Rect();
  Object bu;
  public int gravity = 0;
  
  public d()
  {
    super(-2, -2);
  }
  
  d(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, android.support.b.d.aw);
    this.gravity = localTypedArray.getInteger(android.support.b.d.ax, 0);
    this.bi = localTypedArray.getResourceId(android.support.b.d.az, -1);
    this.bg = localTypedArray.getInteger(android.support.b.d.aB, 0);
    this.bh = localTypedArray.getInteger(android.support.b.d.aA, -1);
    this.bj = localTypedArray.getInt(android.support.b.d.aC, 0);
    this.bk = localTypedArray.getInt(android.support.b.d.aD, 0);
    this.bf = localTypedArray.hasValue(android.support.b.d.ay);
    if (this.bf) {
      this.be = CoordinatorLayout.a(paramContext, paramAttributeSet, localTypedArray.getString(android.support.b.d.ay));
    }
    localTypedArray.recycle();
  }
  
  public d(d paramd)
  {
    super(paramd);
  }
  
  public d(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public d(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  final void a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.bq = paramBoolean;
      return;
    }
    this.br = paramBoolean;
  }
  
  public final void a(CoordinatorLayout.Behavior paramBehavior)
  {
    if (this.be != paramBehavior)
    {
      this.be = paramBehavior;
      this.bu = null;
      this.bf = true;
    }
  }
  
  final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    if (this.bp) {
      return true;
    }
    boolean bool = this.bp | false;
    this.bp = bool;
    return bool;
  }
  
  final void h(int paramInt)
  {
    a(paramInt, false);
  }
  
  final boolean i(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
      return this.bq;
    }
    return this.br;
  }
  
  final boolean w()
  {
    if (this.be == null) {
      this.bp = false;
    }
    return this.bp;
  }
  
  final void x()
  {
    this.bp = false;
  }
  
  final void y()
  {
    this.bs = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.design.widget.d
 * JD-Core Version:    0.7.0.1
 */