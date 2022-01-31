package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Gallery;
import android.widget.OverScroller;
import android.widget.SpinnerAdapter;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;

public class MMGestureGallery
  extends Gallery
{
  private int aia;
  private int aib;
  private float aqX = 0.0F;
  private float aqY = 0.0F;
  private float buF;
  private int count = 0;
  private VelocityTracker fB;
  private int gHR;
  private int gHS;
  private ah handler = new ah(Looper.getMainLooper());
  private long kKP = 0L;
  private long kKQ = 0L;
  private float kKR = 0.0F;
  private float kKS = 0.0F;
  private long kKT = 0L;
  private boolean kKU = false;
  private OverScroller kKV;
  private GestureDetector kKW;
  private RectF kKX = new RectF();
  private float kKZ;
  private boolean kLa = false;
  private boolean kLb = false;
  private boolean kLc = false;
  private boolean kLd = false;
  private MultiTouchImageView kLl;
  private boolean pbn = false;
  private boolean pbo = false;
  private boolean pbp = false;
  public boolean uYS = false;
  private boolean uYT = false;
  private boolean uYU = false;
  private boolean uYV = false;
  private boolean uYW = false;
  private int uYX = 0;
  private final int uZl = 60;
  private final int uZm = 500;
  public MMGestureGallery.l wcZ;
  public MMGestureGallery.l wda;
  public MMGestureGallery.l wdb;
  private MMGestureGallery.a wdc;
  private MMGestureGallery.f wdd;
  private MMGestureGallery.c wde;
  private MMGestureGallery.e wdf;
  private boolean wdg = true;
  private MMGestureGallery.b wdh;
  
  public MMGestureGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setStaticTransformationsEnabled(true);
    this.kKW = new GestureDetector(paramContext, new MMGestureGallery.d(this, (byte)0));
    this.wcZ = new MMGestureGallery.l(new WeakReference(this));
    this.wda = new MMGestureGallery.l(new WeakReference(this));
    this.wdb = new MMGestureGallery.l(new WeakReference(this));
    this.kKV = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    this.uYX = ((int)(getResources().getDisplayMetrics().density * 3000.0F));
    setOnTouchListener(new MMGestureGallery.1(this));
  }
  
  public MMGestureGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setStaticTransformationsEnabled(true);
  }
  
  private void a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat)
  {
    float f3 = paramMotionEvent1.getX();
    float f4 = paramMotionEvent2.getX();
    float f1 = paramMotionEvent1.getY();
    float f2 = paramMotionEvent2.getY();
    boolean bool = b(paramMotionEvent1, paramMotionEvent2);
    f3 = Math.abs(f3 - f4);
    f1 = Math.abs(f1 - f2);
    if (Math.abs(paramFloat) <= 500.0F) {}
    while ((f3 < 60.0F) || (f3 < f1)) {
      return;
    }
    if (bool)
    {
      onKeyDown(21, null);
      return;
    }
    onKeyDown(22, null);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, View paramView, float paramFloat3)
  {
    int i;
    if ((this.uYU) || (this.uYT))
    {
      i = 0;
      if (i == 0) {
        break label234;
      }
    }
    for (;;)
    {
      return true;
      if (getPositionForView(paramView) == getAdapter().getCount() - 1)
      {
        if (this.uYW)
        {
          if (paramFloat3 > 0.0F)
          {
            if (paramFloat2 >= this.gHR) {
              this.kLl.ae(-paramFloat3, 0.0F);
            }
            for (;;)
            {
              i = 1;
              break;
              if ((paramFloat2 > this.gHR * 0.7F) && (paramFloat2 < this.gHS)) {
                this.kLl.ae(-(paramFloat3 * 0.3F), 0.0F);
              }
            }
          }
          i = 0;
          break;
        }
        if (paramFloat3 > 0.0F)
        {
          if (paramFloat2 < this.gHR) {
            this.uYW = true;
          }
          if (paramFloat2 >= this.gHR) {
            this.kLl.ae(-paramFloat3, 0.0F);
          }
          for (;;)
          {
            i = 1;
            break;
            if ((paramFloat2 > this.gHR * 0.7F) && (paramFloat2 < this.gHS)) {
              this.kLl.ae(-(paramFloat3 * 0.3F), 0.0F);
            }
          }
        }
      }
      this.uYW = false;
      i = 0;
      break;
      label234:
      if ((this.uYU) || (this.uYT)) {
        i = 0;
      }
      while (i == 0)
      {
        return false;
        if (getPositionForView(paramView) == 0)
        {
          if (this.uYV)
          {
            if (paramFloat3 < 0.0F)
            {
              if ((paramFloat1 > 0.0F) && (paramFloat1 < this.gHR * 0.3F)) {
                this.kLl.ae(-(paramFloat3 * 0.3F), 0.0F);
              }
              for (;;)
              {
                i = 1;
                break;
                if (paramFloat1 <= 0.0F) {
                  this.kLl.ae(-paramFloat3, 0.0F);
                }
              }
            }
            i = 0;
            continue;
          }
          if (paramFloat3 < 0.0F)
          {
            if (paramFloat1 > 0.0F) {
              this.uYV = true;
            }
            if ((paramFloat1 > 0.0F) && (paramFloat1 < this.gHR * 0.3F)) {
              this.kLl.ae(-(paramFloat3 * 0.3F), 0.0F);
            }
            for (;;)
            {
              i = 1;
              break;
              if (paramFloat1 <= 0.0F) {
                this.kLl.ae(-paramFloat3, 0.0F);
              }
            }
          }
        }
        this.uYV = false;
        i = 0;
      }
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.uYT) {
      return true;
    }
    this.uYU = true;
    if (this.wdf != null) {
      this.wdf.bIT();
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  private void aXW()
  {
    this.wcZ.removeMessages(1);
  }
  
  private static boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    return paramMotionEvent1.getX() - paramMotionEvent2.getX() < 0.0F;
  }
  
  public void computeScroll()
  {
    int m = 0;
    if (this.kLl == null) {}
    while (!this.kKV.computeScrollOffset()) {
      return;
    }
    int i = this.kKV.getCurrX() - this.aia;
    int n = this.kKV.getCurrY() - this.aib;
    this.aia = this.kKV.getCurrX();
    this.aib = this.kKV.getCurrY();
    float f3 = this.kLl.getScale();
    float f4 = this.kLl.getImageWidth();
    float f1 = this.kLl.getScale() * this.kLl.getImageHeight();
    float[] arrayOfFloat = new float[9];
    this.kLl.getImageMatrix().getValues(arrayOfFloat);
    float f2 = arrayOfFloat[2];
    f3 = f3 * f4 + f2;
    f4 = arrayOfFloat[5];
    float f5 = f4 + f1;
    int j = i;
    if (i < 0)
    {
      j = i;
      if (i < this.kKX.right - Math.round(f3)) {
        j = (int)(this.kKX.right - Math.round(f3));
      }
    }
    i = j;
    if (j > 0)
    {
      i = j;
      if (j > this.kKX.left - Math.round(f2)) {
        i = (int)(this.kKX.left - Math.round(f2));
      }
    }
    int k = n;
    if (n < 0)
    {
      k = n;
      if (n < this.kKX.bottom - Math.round(f5)) {
        k = (int)(this.kKX.bottom - Math.round(f5));
      }
    }
    j = k;
    if (k > 0)
    {
      j = k;
      if (k > this.kKX.top - Math.round(f4)) {
        j = (int)(this.kKX.top - Math.round(f4));
      }
    }
    if ((Math.round(f2) >= this.kKX.left) || (Math.round(f3) <= this.kKX.right))
    {
      k = 0;
      if (f1 >= this.gHS) {
        break label463;
      }
    }
    label463:
    for (i = m;; i = j)
    {
      this.kLl.ae(k, i);
      postInvalidate();
      return;
      if (Math.round(f4) < this.kKX.top)
      {
        k = i;
        if (Math.round(f5) > this.kKX.bottom) {
          break;
        }
      }
      j = 0;
      k = i;
      break;
    }
  }
  
  public int getScreenWidth()
  {
    return this.gHR;
  }
  
  public int getXDown()
  {
    return (int)this.aqX;
  }
  
  public int getYDown()
  {
    return (int)this.aqY;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (this.kKV != null) {
      this.kKV.forceFinished(true);
    }
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = getSelectedView();
    Object localObject1 = localObject2;
    if ((localObject2 instanceof ViewGroup))
    {
      localObject1 = ((View)localObject2).findViewById(a.g.image_gallery_download_success);
      if ((localObject1 == null) || (((View)localObject1).getVisibility() == 8))
      {
        a(paramMotionEvent1, paramMotionEvent2, paramFloat1);
        return false;
      }
      localObject2 = ((View)localObject1).findViewById(a.g.image);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        a(paramMotionEvent1, paramMotionEvent2, paramFloat1);
        return false;
      }
    }
    float f2;
    float f5;
    float f3;
    float f4;
    float f6;
    if ((localObject1 instanceof MultiTouchImageView))
    {
      localObject1 = (MultiTouchImageView)localObject1;
      f2 = ((MultiTouchImageView)localObject1).getScale() * ((MultiTouchImageView)localObject1).getImageWidth();
      f5 = ((MultiTouchImageView)localObject1).getScale() * ((MultiTouchImageView)localObject1).getImageHeight();
      if ((((MultiTouchImageView)localObject1).uZW) || (((MultiTouchImageView)localObject1).uZX) || ((int)f2 > this.gHR) || ((int)f5 > this.gHS))
      {
        localObject2 = new float[9];
        ((MultiTouchImageView)localObject1).getImageMatrix().getValues((float[])localObject2);
        f3 = localObject2[2];
        f4 = f3 + f2;
        f6 = localObject2[5];
        y.d("MicroMsg.MMGestureGallery", "jacks left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(b(paramMotionEvent1, paramMotionEvent2)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
        if ((Math.round(f3) < this.kKX.left) && (Math.round(f4) > this.kKX.right)) {
          break label629;
        }
      }
    }
    label432:
    label582:
    label611:
    label629:
    for (float f1 = 0.0F;; f1 = paramFloat1)
    {
      if ((Math.round(f6) >= this.kKX.top) || (Math.round(f6 + f5) <= this.kKX.bottom)) {
        paramFloat2 = 0.0F;
      }
      int i;
      int j;
      int k;
      int m;
      if (Math.round(f6) < this.kKX.top)
      {
        this.uYS = true;
        i = (int)(this.kKX.right - f2);
        j = (int)(f2 + this.kKX.right);
        k = (int)(this.kKX.bottom - f5);
        m = (int)(this.kKX.bottom + f5);
        if (f1 < 0.0F) {
          break label553;
        }
        f2 = f1;
        if (Math.abs(f1) >= this.uYX) {
          f2 = this.uYX;
        }
        if (paramFloat2 < 0.0F) {
          break label582;
        }
        f1 = paramFloat2;
        if (Math.abs(paramFloat2) >= this.uYX) {
          f1 = this.uYX;
        }
      }
      for (;;)
      {
        this.kKV.forceFinished(true);
        this.kKV.fling(this.kKV.getCurrX(), this.kKV.getCurrY(), (int)f2, (int)f1, i, j, k, m, 0, 0);
        if (((b(paramMotionEvent1, paramMotionEvent2)) && (f3 >= 0.0F)) || ((!b(paramMotionEvent1, paramMotionEvent2)) && (f4 <= this.gHR))) {
          break label611;
        }
        return true;
        this.uYS = false;
        break;
        f2 = f1;
        if (Math.abs(f1) >= this.uYX) {
          f2 = -this.uYX;
        }
        break label432;
        f1 = paramFloat2;
        if (Math.abs(paramFloat2) >= this.uYX) {
          f1 = -this.uYX;
        }
      }
      if (this.kKU) {
        return true;
      }
      a(paramMotionEvent1, paramMotionEvent2, paramFloat1);
      return true;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (paramBoolean) {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    this.pbp = true;
    super.onLongPress(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.gHR = View.MeasureSpec.getSize(paramInt1);
    this.gHS = View.MeasureSpec.getSize(paramInt2);
    this.kKX.set(0.0F, 0.0F, this.gHR, this.gHS);
    y.v("MicroMsg.MMGestureGallery", "MMGestureGallery width:" + this.gHR + " height:" + this.gHS);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.kKU) || (this.pbn)) {
      return true;
    }
    Object localObject2 = getSelectedView();
    Object localObject1 = localObject2;
    if ((localObject2 instanceof ViewGroup))
    {
      localObject1 = ((View)localObject2).findViewById(a.g.image_gallery_download_success);
      if ((localObject1 == null) || (((View)localObject1).getVisibility() == 8)) {
        return a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      localObject2 = ((View)localObject1).findViewById(a.g.image);
      localObject1 = localObject2;
      if (localObject2 == null) {
        return a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
    }
    float f1;
    float f5;
    float f4;
    float f6;
    float f7;
    if ((localObject1 instanceof MultiTouchImageView))
    {
      this.kLl = ((MultiTouchImageView)localObject1);
      localObject2 = new float[9];
      this.kLl.getImageMatrix().getValues((float[])localObject2);
      f1 = this.kLl.getScale() * this.kLl.getImageWidth();
      float f2 = this.kLl.getScale() * this.kLl.getImageHeight();
      f5 = localObject2[2];
      f4 = f5 + f1;
      f6 = localObject2[5];
      f7 = f6 + f2;
      localObject2 = new Rect();
      this.kLl.getGlobalVisibleRect((Rect)localObject2);
      if (((int)f1 <= this.gHR) && ((int)f2 <= this.gHS))
      {
        if (a(f5, f4, (View)localObject1, paramFloat1)) {
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.gHR) {
            return a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
          }
        }
        else if (f5 >= 0.0F) {
          return a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
        }
        if (!this.uYU) {
          this.kLl.ae(-paramFloat1, 0.0F);
        }
        return true;
      }
      if (((int)f1 <= this.gHR) && ((int)f2 > this.gHS))
      {
        if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
        {
          if ((this.uYU) || (this.uYV) || (this.uYW)) {
            return true;
          }
          this.uYT = true;
          f2 = 0.0F;
          float f3 = 0.0F;
          if (paramFloat2 < 0.0F)
          {
            if (f6 > this.kKX.top) {
              this.kLa = true;
            }
            if ((f6 <= this.kKX.top) || (f7 < this.gHS))
            {
              f1 = -paramFloat2;
              if ((paramFloat1 >= 0.0F) || (f5 <= this.kKX.left)) {
                break label615;
              }
              this.kLc = true;
              paramFloat2 = -(0.3F * paramFloat1);
            }
          }
          for (;;)
          {
            this.kLl.ae(paramFloat2, f1);
            return true;
            f1 = f3;
            if (f6 <= this.kKX.top) {
              break;
            }
            f1 = f3;
            if (f6 >= this.gHS * 0.3F) {
              break;
            }
            f1 = -(0.3F * paramFloat2);
            break;
            if (f7 < this.kKX.bottom) {
              this.kLb = true;
            }
            if ((f6 > 0.0F) || (f7 >= this.gHS))
            {
              f1 = -paramFloat2;
              break;
            }
            f1 = f3;
            if (f7 <= this.gHS * 0.7F) {
              break;
            }
            f1 = f3;
            if (f7 >= this.gHS) {
              break;
            }
            f1 = -(0.3F * paramFloat2);
            break;
            label615:
            paramFloat2 = f2;
            if (paramFloat1 > 0.0F)
            {
              paramFloat2 = f2;
              if (f4 < this.kKX.right)
              {
                this.kLd = true;
                paramFloat2 = -(0.3F * paramFloat1);
              }
            }
          }
        }
        if (a(f5, f4, (View)localObject1, paramFloat1)) {
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.gHR)
          {
            if (f4 > this.gHR * 0.7F) {
              return a(paramMotionEvent1, paramMotionEvent2, 0.3F * paramFloat1, 0.0F);
            }
            return a(paramMotionEvent1, paramMotionEvent2, 0.0F, 0.0F);
          }
        }
        else if (f5 >= 0.0F)
        {
          if (f5 < this.gHR * 0.3F) {
            return a(paramMotionEvent1, paramMotionEvent2, 0.3F * paramFloat1, 0.0F);
          }
          return a(paramMotionEvent1, paramMotionEvent2, 0.0F, 0.0F);
        }
        if (!this.uYU) {
          this.kLl.ae(-paramFloat1, 0.0F);
        }
        return true;
      }
      if (((int)f1 > this.gHR) && ((int)f2 <= this.gHS))
      {
        if (a(f5, f4, (View)localObject1, paramFloat1)) {
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.gHR) {
            return a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
          }
        }
        else if (f5 >= 0.0F) {
          return a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
        }
        if (!this.uYU) {
          this.kLl.ae(-paramFloat1, 0.0F);
        }
        return true;
      }
      if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
      {
        if (paramFloat1 == 0.0F) {
          break label1373;
        }
        this.uYU = true;
        if (paramFloat1 < 0.0F)
        {
          if (f5 > this.kKX.left) {
            this.kLc = true;
          }
          f1 = paramFloat1;
          if (f5 > this.kKX.left)
          {
            if (f4 >= this.gHR) {
              break label1047;
            }
            f1 = paramFloat1;
          }
        }
      }
    }
    for (;;)
    {
      if (paramFloat2 != 0.0F)
      {
        this.uYT = true;
        if (paramFloat2 < 0.0F)
        {
          if (f6 > this.kKX.top) {
            this.kLa = true;
          }
          paramFloat1 = paramFloat2;
          if (f6 > this.kKX.top)
          {
            if (f7 >= this.gHS) {
              break label1163;
            }
            paramFloat1 = paramFloat2;
          }
        }
      }
      for (;;)
      {
        this.kLl.ae(-f1, -paramFloat1);
        return true;
        label1047:
        if ((f5 <= this.kKX.left) || (f5 >= this.gHR * 0.3F)) {
          break label1373;
        }
        f1 = paramFloat1 * 0.3F;
        break;
        if (f4 < this.kKX.right) {
          this.kLd = true;
        }
        f1 = paramFloat1;
        if (f5 > 0.0F) {
          break;
        }
        f1 = paramFloat1;
        if (f4 >= this.gHR) {
          break;
        }
        if ((f4 <= this.gHR * 0.7F) || (f4 >= this.gHR)) {
          break label1373;
        }
        f1 = paramFloat1 * 0.3F;
        break;
        label1163:
        if ((f6 > this.kKX.top) && (f6 < this.gHS * 0.3F))
        {
          paramFloat1 = paramFloat2 * 0.3F;
          continue;
          if (f7 < this.kKX.bottom) {
            this.kLb = true;
          }
          paramFloat1 = paramFloat2;
          if (f6 > 0.0F) {
            continue;
          }
          paramFloat1 = paramFloat2;
          if (f7 >= this.gHS) {
            continue;
          }
          if ((f7 > this.gHS * 0.7F) && (f7 < this.gHS))
          {
            paramFloat1 = paramFloat2 * 0.3F;
            continue;
            if (a(f5, f4, (View)localObject1, paramFloat1)) {
              return true;
            }
            if (paramFloat1 > 0.0F)
            {
              if (f4 <= this.gHR) {
                return a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
              }
            }
            else if (f5 >= 0.0F) {
              return a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
            }
            if (!this.uYU) {
              this.kLl.ae(-paramFloat1, -paramFloat2);
            }
            return true;
            return a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
          }
        }
        paramFloat1 = 0.0F;
      }
      label1373:
      f1 = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.kKW.onTouchEvent(paramMotionEvent);
    y.d("dktest", "onTouchEvent event.getAction()" + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      computeScroll();
      return super.onTouchEvent(paramMotionEvent);
      Object localObject = getSelectedView();
      if ((localObject instanceof MultiTouchImageView))
      {
        this.kLl = ((MultiTouchImageView)localObject);
        float f2 = this.kLl.getScale() * this.kLl.getImageWidth();
        float f1 = this.kLl.getScale() * this.kLl.getImageHeight();
        if (((int)f2 <= this.gHR) && ((int)f1 <= this.gHS))
        {
          y.i("dktest", "onTouchEvent width:" + f2 + "height:" + f1);
        }
        else
        {
          localObject = new float[9];
          this.kLl.getImageMatrix().getValues((float[])localObject);
          f2 = localObject[5];
          y.d("dktest", "onTouchEvent top:" + f2 + " height:" + f1 + " bottom:" + (f2 + f1));
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      super.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void setGalleryScaleListener(MMGestureGallery.b paramb)
  {
    this.wdh = paramb;
  }
  
  public void setLoadQuit(boolean paramBoolean)
  {
    this.wdg = paramBoolean;
  }
  
  public void setLongClickOverListener(MMGestureGallery.c paramc)
  {
    this.wde = paramc;
  }
  
  public void setScrollLeftRightListener(MMGestureGallery.e parame)
  {
    this.wdf = parame;
  }
  
  public void setSingleClickOverListener(MMGestureGallery.f paramf)
  {
    this.wdd = paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery
 * JD-Core Version:    0.7.0.1
 */