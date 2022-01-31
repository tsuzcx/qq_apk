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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;

public class MMGestureGallery
  extends Gallery
{
  public MMGestureGallery.l AvG;
  public MMGestureGallery.l AvH;
  public MMGestureGallery.l AvI;
  private MMGestureGallery.a AvJ;
  private MMGestureGallery.f AvK;
  private MMGestureGallery.c AvL;
  private MMGestureGallery.e AvM;
  private boolean AvN;
  private MMGestureGallery.b AvO;
  private int akq;
  private int akr;
  private float atq;
  private float atr;
  private float bVQ;
  private int count;
  private ak handler;
  private int iiW;
  private int iiX;
  private VelocityTracker mVelocityTracker;
  private RectF nhA;
  private float nhC;
  private boolean nhD;
  private boolean nhE;
  private boolean nhF;
  private boolean nhG;
  private MultiTouchImageView nhO;
  private long nhs;
  private long nht;
  private float nhu;
  private float nhv;
  private long nhw;
  private boolean nhx;
  private OverScroller nhy;
  private GestureDetector nhz;
  private boolean rUb;
  private boolean rUc;
  private boolean rUd;
  private final int znC;
  private final int znD;
  public boolean znj;
  private boolean znk;
  private boolean znl;
  private boolean znm;
  private boolean znn;
  private int zno;
  
  public MMGestureGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107685);
    this.nhx = false;
    this.znk = false;
    this.znl = false;
    this.znm = false;
    this.znn = false;
    this.nhD = false;
    this.nhE = false;
    this.nhF = false;
    this.nhG = false;
    this.zno = 0;
    this.count = 0;
    this.nhs = 0L;
    this.nht = 0L;
    this.nhu = 0.0F;
    this.nhv = 0.0F;
    this.nhw = 0L;
    this.nhA = new RectF();
    this.handler = new ak(Looper.getMainLooper());
    this.AvN = true;
    this.atq = 0.0F;
    this.atr = 0.0F;
    this.rUb = false;
    this.rUc = false;
    this.rUd = false;
    this.znj = false;
    this.znC = 60;
    this.znD = 500;
    setStaticTransformationsEnabled(true);
    this.nhz = new GestureDetector(paramContext, new MMGestureGallery.d(this, (byte)0));
    this.AvG = new MMGestureGallery.l(new WeakReference(this));
    this.AvH = new MMGestureGallery.l(new WeakReference(this));
    this.AvI = new MMGestureGallery.l(new WeakReference(this));
    this.nhy = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    this.zno = ((int)(getResources().getDisplayMetrics().density * 3000.0F));
    setOnTouchListener(new MMGestureGallery.1(this));
    AppMethodBeat.o(107685);
  }
  
  public MMGestureGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107683);
    this.nhx = false;
    this.znk = false;
    this.znl = false;
    this.znm = false;
    this.znn = false;
    this.nhD = false;
    this.nhE = false;
    this.nhF = false;
    this.nhG = false;
    this.zno = 0;
    this.count = 0;
    this.nhs = 0L;
    this.nht = 0L;
    this.nhu = 0.0F;
    this.nhv = 0.0F;
    this.nhw = 0L;
    this.nhA = new RectF();
    this.handler = new ak(Looper.getMainLooper());
    this.AvN = true;
    this.atq = 0.0F;
    this.atr = 0.0F;
    this.rUb = false;
    this.rUc = false;
    this.rUd = false;
    this.znj = false;
    this.znC = 60;
    this.znD = 500;
    setStaticTransformationsEnabled(true);
    AppMethodBeat.o(107683);
  }
  
  private void a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat)
  {
    AppMethodBeat.i(107694);
    float f3 = paramMotionEvent1.getX();
    float f4 = paramMotionEvent2.getX();
    float f1 = paramMotionEvent1.getY();
    float f2 = paramMotionEvent2.getY();
    boolean bool = b(paramMotionEvent1, paramMotionEvent2);
    f3 = Math.abs(f3 - f4);
    f1 = Math.abs(f1 - f2);
    if (Math.abs(paramFloat) <= 500.0F)
    {
      AppMethodBeat.o(107694);
      return;
    }
    if (f3 < 60.0F)
    {
      AppMethodBeat.o(107694);
      return;
    }
    if (f3 < f1)
    {
      AppMethodBeat.o(107694);
      return;
    }
    if (bool)
    {
      onKeyDown(21, null);
      AppMethodBeat.o(107694);
      return;
    }
    onKeyDown(22, null);
    AppMethodBeat.o(107694);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, View paramView, float paramFloat3)
  {
    AppMethodBeat.i(107688);
    int i;
    if ((this.znl) || (this.znk)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(107688);
      return true;
      if (getPositionForView(paramView) == getAdapter().getCount() - 1)
      {
        if (this.znn)
        {
          if (paramFloat3 > 0.0F)
          {
            if (paramFloat2 >= this.iiW) {
              this.nhO.ap(-paramFloat3, 0.0F);
            }
            for (;;)
            {
              i = 1;
              break;
              if ((paramFloat2 > this.iiW * 0.7F) && (paramFloat2 < this.iiX)) {
                this.nhO.ap(-(paramFloat3 * 0.3F), 0.0F);
              }
            }
          }
          i = 0;
          continue;
        }
        if (paramFloat3 > 0.0F)
        {
          if (paramFloat2 < this.iiW) {
            this.znn = true;
          }
          if (paramFloat2 >= this.iiW) {
            this.nhO.ap(-paramFloat3, 0.0F);
          }
          for (;;)
          {
            i = 1;
            break;
            if ((paramFloat2 > this.iiW * 0.7F) && (paramFloat2 < this.iiX)) {
              this.nhO.ap(-(paramFloat3 * 0.3F), 0.0F);
            }
          }
        }
      }
      this.znn = false;
      i = 0;
    }
    if ((this.znl) || (this.znk)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(107688);
      return true;
      if (getPositionForView(paramView) == 0)
      {
        if (this.znm)
        {
          if (paramFloat3 < 0.0F)
          {
            if ((paramFloat1 > 0.0F) && (paramFloat1 < this.iiW * 0.3F)) {
              this.nhO.ap(-(paramFloat3 * 0.3F), 0.0F);
            }
            for (;;)
            {
              i = 1;
              break;
              if (paramFloat1 <= 0.0F) {
                this.nhO.ap(-paramFloat3, 0.0F);
              }
            }
          }
          i = 0;
          continue;
        }
        if (paramFloat3 < 0.0F)
        {
          if (paramFloat1 > 0.0F) {
            this.znm = true;
          }
          if ((paramFloat1 > 0.0F) && (paramFloat1 < this.iiW * 0.3F)) {
            this.nhO.ap(-(paramFloat3 * 0.3F), 0.0F);
          }
          for (;;)
          {
            i = 1;
            break;
            if (paramFloat1 <= 0.0F) {
              this.nhO.ap(-paramFloat3, 0.0F);
            }
          }
        }
      }
      this.znm = false;
      i = 0;
    }
    AppMethodBeat.o(107688);
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(107687);
    if (this.znk)
    {
      AppMethodBeat.o(107687);
      return true;
    }
    this.znl = true;
    if (this.AvM != null) {
      this.AvM.cvo();
    }
    boolean bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    AppMethodBeat.o(107687);
    return bool;
  }
  
  private static boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    AppMethodBeat.i(107693);
    if (paramMotionEvent1.getX() - paramMotionEvent2.getX() < 0.0F)
    {
      AppMethodBeat.o(107693);
      return true;
    }
    AppMethodBeat.o(107693);
    return false;
  }
  
  private void bEJ()
  {
    AppMethodBeat.i(107684);
    this.AvG.removeMessages(1);
    AppMethodBeat.o(107684);
  }
  
  public void computeScroll()
  {
    int m = 0;
    AppMethodBeat.i(107698);
    if (this.nhO == null)
    {
      AppMethodBeat.o(107698);
      return;
    }
    float f4;
    float f5;
    int j;
    int k;
    if (this.nhy.computeScrollOffset())
    {
      i = this.nhy.getCurrX() - this.akq;
      int n = this.nhy.getCurrY() - this.akr;
      this.akq = this.nhy.getCurrX();
      this.akr = this.nhy.getCurrY();
      float f3 = this.nhO.getScale();
      f4 = this.nhO.getImageWidth();
      float f1 = this.nhO.getScale() * this.nhO.getImageHeight();
      float[] arrayOfFloat = new float[9];
      this.nhO.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f3 * f4 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.nhA.right - Math.round(f3)) {
          j = (int)(this.nhA.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.nhA.left - Math.round(f2)) {
          i = (int)(this.nhA.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.nhA.bottom - Math.round(f5)) {
          k = (int)(this.nhA.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.nhA.top - Math.round(f4)) {
          j = (int)(this.nhA.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.nhA.left) && (Math.round(f3) > this.nhA.right)) {
        break label433;
      }
      k = 0;
      if (f1 >= this.iiX) {
        break label481;
      }
    }
    label433:
    label481:
    for (int i = m;; i = j)
    {
      this.nhO.ap(k, i);
      postInvalidate();
      AppMethodBeat.o(107698);
      return;
      if (Math.round(f4) < this.nhA.top)
      {
        k = i;
        if (Math.round(f5) > this.nhA.bottom) {
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
    return this.iiW;
  }
  
  public int getXDown()
  {
    return (int)this.atq;
  }
  
  public int getYDown()
  {
    return (int)this.atr;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107690);
    if (this.nhy != null) {
      this.nhy.forceFinished(true);
    }
    boolean bool = super.onDown(paramMotionEvent);
    AppMethodBeat.o(107690);
    return bool;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(107691);
    Object localObject2 = getSelectedView();
    Object localObject1 = localObject2;
    if ((localObject2 instanceof ViewGroup))
    {
      localObject1 = ((View)localObject2).findViewById(2131820630);
      if ((localObject1 == null) || (((View)localObject1).getVisibility() == 8))
      {
        a(paramMotionEvent1, paramMotionEvent2, paramFloat1);
        AppMethodBeat.o(107691);
        return false;
      }
      localObject2 = ((View)localObject1).findViewById(2131820629);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        a(paramMotionEvent1, paramMotionEvent2, paramFloat1);
        AppMethodBeat.o(107691);
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
      if ((((MultiTouchImageView)localObject1).zom) || (((MultiTouchImageView)localObject1).zon) || ((int)f2 > this.iiW) || ((int)f5 > this.iiX))
      {
        localObject2 = new float[9];
        ((MultiTouchImageView)localObject1).getImageMatrix().getValues((float[])localObject2);
        f3 = localObject2[2];
        f4 = f3 + f2;
        f6 = localObject2[5];
        ab.d("MicroMsg.MMGestureGallery", "jacks left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(b(paramMotionEvent1, paramMotionEvent2)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
        if ((Math.round(f3) < this.nhA.left) && (Math.round(f4) > this.nhA.right)) {
          break label665;
        }
      }
    }
    label665:
    for (float f1 = 0.0F;; f1 = paramFloat1)
    {
      if ((Math.round(f6) >= this.nhA.top) || (Math.round(f6 + f5) <= this.nhA.bottom)) {
        paramFloat2 = 0.0F;
      }
      int i;
      int j;
      int k;
      int m;
      if (Math.round(f6) < this.nhA.top)
      {
        this.znj = true;
        i = (int)(this.nhA.right - f2);
        j = (int)(f2 + this.nhA.right);
        k = (int)(this.nhA.bottom - f5);
        m = (int)(this.nhA.bottom + f5);
        if (f1 < 0.0F) {
          break label577;
        }
        f2 = f1;
        if (Math.abs(f1) >= this.zno) {
          f2 = this.zno;
        }
        label450:
        if (paramFloat2 < 0.0F) {
          break label606;
        }
        f1 = paramFloat2;
        if (Math.abs(paramFloat2) >= this.zno) {
          f1 = this.zno;
        }
      }
      for (;;)
      {
        this.nhy.forceFinished(true);
        this.nhy.fling(this.nhy.getCurrX(), this.nhy.getCurrY(), (int)f2, (int)f1, i, j, k, m, 0, 0);
        if (((b(paramMotionEvent1, paramMotionEvent2)) && (f3 >= 0.0F)) || ((!b(paramMotionEvent1, paramMotionEvent2)) && (f4 <= this.iiW))) {
          break label635;
        }
        AppMethodBeat.o(107691);
        return true;
        this.znj = false;
        break;
        label577:
        f2 = f1;
        if (Math.abs(f1) >= this.zno) {
          f2 = -this.zno;
        }
        break label450;
        label606:
        f1 = paramFloat2;
        if (Math.abs(paramFloat2) >= this.zno) {
          f1 = -this.zno;
        }
      }
      label635:
      if (this.nhx)
      {
        AppMethodBeat.o(107691);
        return true;
      }
      a(paramMotionEvent1, paramMotionEvent2, paramFloat1);
      AppMethodBeat.o(107691);
      return true;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(107696);
    if (paramBoolean) {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
    }
    AppMethodBeat.o(107696);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107692);
    this.rUd = true;
    super.onLongPress(paramMotionEvent);
    AppMethodBeat.o(107692);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107686);
    super.onMeasure(paramInt1, paramInt2);
    this.iiW = View.MeasureSpec.getSize(paramInt1);
    this.iiX = View.MeasureSpec.getSize(paramInt2);
    this.nhA.set(0.0F, 0.0F, this.iiW, this.iiX);
    ab.v("MicroMsg.MMGestureGallery", "MMGestureGallery width:" + this.iiW + " height:" + this.iiX);
    AppMethodBeat.o(107686);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(107689);
    if ((this.nhx) || (this.rUb))
    {
      AppMethodBeat.o(107689);
      return true;
    }
    Object localObject2 = getSelectedView();
    Object localObject1 = localObject2;
    boolean bool;
    if ((localObject2 instanceof ViewGroup))
    {
      localObject1 = ((View)localObject2).findViewById(2131820630);
      if ((localObject1 == null) || (((View)localObject1).getVisibility() == 8))
      {
        bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        AppMethodBeat.o(107689);
        return bool;
      }
      localObject2 = ((View)localObject1).findViewById(2131820629);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        AppMethodBeat.o(107689);
        return bool;
      }
    }
    float f1;
    float f5;
    float f4;
    float f6;
    float f7;
    if ((localObject1 instanceof MultiTouchImageView))
    {
      this.nhO = ((MultiTouchImageView)localObject1);
      localObject2 = new float[9];
      this.nhO.getImageMatrix().getValues((float[])localObject2);
      f1 = this.nhO.getScale() * this.nhO.getImageWidth();
      float f2 = this.nhO.getScale() * this.nhO.getImageHeight();
      f5 = localObject2[2];
      f4 = f5 + f1;
      f6 = localObject2[5];
      f7 = f6 + f2;
      localObject2 = new Rect();
      this.nhO.getGlobalVisibleRect((Rect)localObject2);
      if (((int)f1 <= this.iiW) && ((int)f2 <= this.iiX))
      {
        if (a(f5, f4, (View)localObject1, paramFloat1))
        {
          AppMethodBeat.o(107689);
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.iiW)
          {
            bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
            AppMethodBeat.o(107689);
            return bool;
          }
        }
        else if (f5 >= 0.0F)
        {
          bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
          AppMethodBeat.o(107689);
          return bool;
        }
        if (!this.znl) {
          this.nhO.ap(-paramFloat1, 0.0F);
        }
        AppMethodBeat.o(107689);
        return true;
      }
      if (((int)f1 <= this.iiW) && ((int)f2 > this.iiX))
      {
        if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
        {
          if ((this.znl) || (this.znm) || (this.znn))
          {
            AppMethodBeat.o(107689);
            return true;
          }
          this.znk = true;
          f2 = 0.0F;
          float f3 = 0.0F;
          if (paramFloat2 < 0.0F)
          {
            if (f6 > this.nhA.top) {
              this.nhD = true;
            }
            if ((f6 <= this.nhA.top) || (f7 < this.iiX))
            {
              f1 = -paramFloat2;
              if ((paramFloat1 >= 0.0F) || (f5 <= this.nhA.left)) {
                break label691;
              }
              this.nhF = true;
              paramFloat2 = -(0.3F * paramFloat1);
            }
          }
          for (;;)
          {
            this.nhO.ap(paramFloat2, f1);
            AppMethodBeat.o(107689);
            return true;
            f1 = f3;
            if (f6 <= this.nhA.top) {
              break;
            }
            f1 = f3;
            if (f6 >= this.iiX * 0.3F) {
              break;
            }
            f1 = -(0.3F * paramFloat2);
            break;
            if (f7 < this.nhA.bottom) {
              this.nhE = true;
            }
            if ((f6 > 0.0F) || (f7 >= this.iiX))
            {
              f1 = -paramFloat2;
              break;
            }
            f1 = f3;
            if (f7 <= this.iiX * 0.7F) {
              break;
            }
            f1 = f3;
            if (f7 >= this.iiX) {
              break;
            }
            f1 = -(0.3F * paramFloat2);
            break;
            label691:
            paramFloat2 = f2;
            if (paramFloat1 > 0.0F)
            {
              paramFloat2 = f2;
              if (f4 < this.nhA.right)
              {
                this.nhG = true;
                paramFloat2 = -(0.3F * paramFloat1);
              }
            }
          }
        }
        if (a(f5, f4, (View)localObject1, paramFloat1))
        {
          AppMethodBeat.o(107689);
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.iiW)
          {
            if (f4 > this.iiW * 0.7F)
            {
              bool = a(paramMotionEvent1, paramMotionEvent2, 0.3F * paramFloat1, 0.0F);
              AppMethodBeat.o(107689);
              return bool;
            }
            bool = a(paramMotionEvent1, paramMotionEvent2, 0.0F, 0.0F);
            AppMethodBeat.o(107689);
            return bool;
          }
        }
        else if (f5 >= 0.0F)
        {
          if (f5 < this.iiW * 0.3F)
          {
            bool = a(paramMotionEvent1, paramMotionEvent2, 0.3F * paramFloat1, 0.0F);
            AppMethodBeat.o(107689);
            return bool;
          }
          bool = a(paramMotionEvent1, paramMotionEvent2, 0.0F, 0.0F);
          AppMethodBeat.o(107689);
          return bool;
        }
        if (!this.znl) {
          this.nhO.ap(-paramFloat1, 0.0F);
        }
        AppMethodBeat.o(107689);
        return true;
      }
      if (((int)f1 > this.iiW) && ((int)f2 <= this.iiX))
      {
        if (a(f5, f4, (View)localObject1, paramFloat1))
        {
          AppMethodBeat.o(107689);
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.iiW)
          {
            bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
            AppMethodBeat.o(107689);
            return bool;
          }
        }
        else if (f5 >= 0.0F)
        {
          bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
          AppMethodBeat.o(107689);
          return bool;
        }
        if (!this.znl) {
          this.nhO.ap(-paramFloat1, 0.0F);
        }
        AppMethodBeat.o(107689);
        return true;
      }
      if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
      {
        if (paramFloat1 == 0.0F) {
          break label1581;
        }
        this.znl = true;
        if (paramFloat1 < 0.0F)
        {
          if (f5 > this.nhA.left) {
            this.nhF = true;
          }
          f1 = paramFloat1;
          if (f5 > this.nhA.left)
          {
            if (f4 >= this.iiW) {
              break label1213;
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
        this.znk = true;
        if (paramFloat2 < 0.0F)
        {
          if (f6 > this.nhA.top) {
            this.nhD = true;
          }
          paramFloat1 = paramFloat2;
          if (f6 > this.nhA.top)
          {
            if (f7 >= this.iiX) {
              break label1329;
            }
            paramFloat1 = paramFloat2;
          }
        }
      }
      for (;;)
      {
        this.nhO.ap(-f1, -paramFloat1);
        AppMethodBeat.o(107689);
        return true;
        label1213:
        if ((f5 <= this.nhA.left) || (f5 >= this.iiW * 0.3F)) {
          break label1581;
        }
        f1 = paramFloat1 * 0.3F;
        break;
        if (f4 < this.nhA.right) {
          this.nhG = true;
        }
        f1 = paramFloat1;
        if (f5 > 0.0F) {
          break;
        }
        f1 = paramFloat1;
        if (f4 >= this.iiW) {
          break;
        }
        if ((f4 <= this.iiW * 0.7F) || (f4 >= this.iiW)) {
          break label1581;
        }
        f1 = paramFloat1 * 0.3F;
        break;
        label1329:
        if ((f6 > this.nhA.top) && (f6 < this.iiX * 0.3F))
        {
          paramFloat1 = paramFloat2 * 0.3F;
          continue;
          if (f7 < this.nhA.bottom) {
            this.nhE = true;
          }
          paramFloat1 = paramFloat2;
          if (f6 > 0.0F) {
            continue;
          }
          paramFloat1 = paramFloat2;
          if (f7 >= this.iiX) {
            continue;
          }
          if ((f7 > this.iiX * 0.7F) && (f7 < this.iiX))
          {
            paramFloat1 = paramFloat2 * 0.3F;
            continue;
            if (a(f5, f4, (View)localObject1, paramFloat1))
            {
              AppMethodBeat.o(107689);
              return true;
            }
            if (paramFloat1 > 0.0F)
            {
              if (f4 <= this.iiW)
              {
                bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
                AppMethodBeat.o(107689);
                return bool;
              }
            }
            else if (f5 >= 0.0F)
            {
              bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
              AppMethodBeat.o(107689);
              return bool;
            }
            if (!this.znl) {
              this.nhO.ap(-paramFloat1, -paramFloat2);
            }
            AppMethodBeat.o(107689);
            return true;
            bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
            AppMethodBeat.o(107689);
            return bool;
          }
        }
        paramFloat1 = 0.0F;
      }
      label1581:
      f1 = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107695);
    this.nhz.onTouchEvent(paramMotionEvent);
    ab.d("dktest", "onTouchEvent event.getAction()" + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      computeScroll();
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(107695);
      return bool;
      Object localObject = getSelectedView();
      if ((localObject instanceof MultiTouchImageView))
      {
        this.nhO = ((MultiTouchImageView)localObject);
        float f2 = this.nhO.getScale() * this.nhO.getImageWidth();
        float f1 = this.nhO.getScale() * this.nhO.getImageHeight();
        if (((int)f2 <= this.iiW) && ((int)f1 <= this.iiX))
        {
          ab.i("dktest", "onTouchEvent width:" + f2 + "height:" + f1);
        }
        else
        {
          localObject = new float[9];
          this.nhO.getImageMatrix().getValues((float[])localObject);
          f2 = localObject[5];
          ab.d("dktest", "onTouchEvent top:" + f2 + " height:" + f1 + " bottom:" + (f2 + f1));
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(107697);
    if (paramBoolean) {
      super.onWindowFocusChanged(paramBoolean);
    }
    AppMethodBeat.o(107697);
  }
  
  public void setGalleryScaleListener(MMGestureGallery.b paramb)
  {
    this.AvO = paramb;
  }
  
  public void setLoadQuit(boolean paramBoolean)
  {
    this.AvN = paramBoolean;
  }
  
  public void setLongClickOverListener(MMGestureGallery.c paramc)
  {
    this.AvL = paramc;
  }
  
  public void setScrollLeftRightListener(MMGestureGallery.e parame)
  {
    this.AvM = parame;
  }
  
  public void setSingleClickOverListener(MMGestureGallery.f paramf)
  {
    this.AvK = paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery
 * JD-Core Version:    0.7.0.1
 */