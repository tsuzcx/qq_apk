package com.tencent.mm.plugin.walletlock.gesture.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.c;
import com.tencent.mm.plugin.walletlock.a.h;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.sdk.platformtools.c;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView
  extends View
{
  private static Bitmap qQA = null;
  private static Bitmap qQx = null;
  private static Bitmap qQy = null;
  private static Bitmap qQz = null;
  private int Au;
  private int Av;
  private int jGo;
  private float qQB;
  private float qQC;
  private boolean qQD;
  private long qQE;
  private float qQF;
  private float qQG;
  private PatternLockView.a qQH;
  private Paint qQh = new Paint();
  private Paint qQi = new Paint();
  private Path qQj = new Path();
  private Matrix qQk = new Matrix();
  private Rect qQl = new Rect();
  private Rect qQm = new Rect();
  private ArrayList<f> qQn = new ArrayList(9);
  private boolean[][] qQo = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 });
  private PatternLockView.c qQp = PatternLockView.c.qQP;
  private int qQq = 6;
  private int qQr = 200;
  private float qQs = 0.66F;
  private boolean qQt = false;
  private boolean qQu = true;
  private boolean qQv = false;
  private b qQw;
  
  public PatternLockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i;
    if (isInEditMode())
    {
      i = -1;
      this.jGo = i;
      this.qQw = b.qQJ;
      this.qQB = -1.0F;
      this.qQC = -1.0F;
      this.qQD = false;
      this.qQE = 0L;
      this.Au = 0;
      this.Av = 0;
      this.qQF = 0.0F;
      this.qQG = 0.0F;
      this.qQH = null;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.h.mm_patternlock_view);
      this.qQu = paramContext.getBoolean(a.h.mm_patternlock_view_showLine, this.qQu);
      this.qQr = paramContext.getInt(a.h.mm_patternlock_view_lineAlpha, this.qQr);
      this.qQq = paramContext.getInt(a.h.mm_patternlock_view_lineWidth, this.qQq);
      this.qQt = paramContext.getBoolean(a.h.mm_patternlock_view_hapticFeedback, this.qQt);
      switch (paramContext.getInt(a.h.mm_patternlock_view_shapeMode, this.qQp.ordinal()))
      {
      default: 
        this.qQp = PatternLockView.c.qQP;
      }
    }
    for (;;)
    {
      paramContext.recycle();
      setClickable(true);
      this.qQi.setStyle(Paint.Style.STROKE);
      this.qQi.setStrokeJoin(Paint.Join.ROUND);
      this.qQi.setStrokeCap(Paint.Cap.ROUND);
      this.qQi.setAntiAlias(true);
      this.qQi.setDither(false);
      this.qQi.setAlpha(this.qQr);
      this.qQh.setAntiAlias(true);
      this.qQh.setDither(true);
      if (isInEditMode()) {
        return;
      }
      if (qQx == null)
      {
        qQx = p(a.g(getContext(), a.c.gesture_node_normal));
        paramContext = p(a.g(getContext(), a.c.gesture_node_touched));
        qQy = paramContext;
        qQz = paramContext;
        qQA = p(a.g(getContext(), a.c.gesture_node_touched_wrong));
      }
      this.qQq = ((int)(this.qQq * c.cqp().density));
      paramContext = qQx;
      paramAttributeSet = qQy;
      Bitmap localBitmap1 = qQz;
      Bitmap localBitmap2 = qQA;
      i = 0;
      while (i < 4)
      {
        Bitmap localBitmap3 = new Bitmap[] { paramContext, paramAttributeSet, localBitmap1, localBitmap2 }[i];
        this.Au = Math.max(localBitmap3.getWidth(), this.Au);
        this.Av = Math.max(localBitmap3.getHeight(), this.Av);
        i += 1;
      }
      i = getResources().getColor(a.b.gesture_color_norm_line);
      break;
      this.qQp = PatternLockView.c.qQP;
      continue;
      this.qQp = PatternLockView.c.qQQ;
    }
  }
  
  private float Bc(int paramInt)
  {
    return getPaddingLeft() + paramInt * this.qQF + this.qQF * 0.5F;
  }
  
  private float Bd(int paramInt)
  {
    return getPaddingTop() + paramInt * this.qQG + this.qQG * 0.5F;
  }
  
  private f Z(float paramFloat1, float paramFloat2)
  {
    int k = 0;
    Object localObject2 = null;
    float f1 = this.qQG;
    float f2 = f1 * this.qQs;
    float f3 = getPaddingTop();
    float f4 = (f1 - f2) / 2.0F;
    int i = 0;
    int j;
    label77:
    Object localObject1;
    if (i < 3)
    {
      float f5 = i * f1 + (f4 + f3);
      if ((paramFloat2 >= f5) && (paramFloat2 <= f5 + f2))
      {
        j = i;
        localObject1 = localObject2;
        if (j >= 0)
        {
          paramFloat2 = this.qQF;
          f1 = this.qQs * paramFloat2;
          f2 = getPaddingLeft();
          f3 = (paramFloat2 - f1) / 2.0F;
          i = k;
          label116:
          if (i >= 3) {
            break label278;
          }
          f4 = i * paramFloat2 + (f2 + f3);
          if ((paramFloat1 < f4) || (paramFloat1 > f4 + f1)) {
            break label269;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (this.qQo[j][i] == 0) {
          localObject1 = f.ew(j, i);
        }
      }
      if (localObject1 == null) {
        break label284;
      }
      this.qQo[localObject1.qPB][localObject1.qPC] = 1;
      this.qQn.add(localObject1);
      if (this.qQH != null) {
        new ArrayList(this.qQn);
      }
      if (this.qQt) {
        performHapticFeedback(1, 3);
      }
      return localObject1;
      i += 1;
      break;
      j = -1;
      break label77;
      label269:
      i += 1;
      break label116;
      label278:
      i = -1;
    }
    label284:
    return null;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Bitmap localBitmap;
    if ((!paramBoolean) || ((!this.qQu) && (this.qQw != b.qQK))) {
      localBitmap = qQx;
    }
    for (;;)
    {
      int j = this.Au;
      int i = this.Av;
      float f1 = this.qQF;
      float f2 = this.qQG;
      j = (int)((f1 - j) * 0.5F);
      i = (int)((f2 - i) * 0.5F);
      f2 = getResources().getDisplayMetrics().density;
      f1 = Math.min((this.qQF - 33.0F * f2) / this.Au, 1.0F);
      f2 = Math.min((this.qQG - f2 * 33.0F) / this.Av, 1.0F);
      this.qQk.setTranslate(j + paramInt1, i + paramInt2);
      this.qQk.preTranslate(this.Au / 2, this.Av / 2);
      this.qQk.preScale(f1, f2);
      this.qQk.preTranslate(-this.Au / 2, -this.Av / 2);
      if (!isInEditMode()) {
        paramCanvas.drawBitmap(localBitmap, this.qQk, this.qQh);
      }
      return;
      if (this.qQD)
      {
        localBitmap = qQy;
      }
      else if (this.qQw == b.qQK)
      {
        localBitmap = qQA;
      }
      else
      {
        if ((this.qQw != b.qQJ) && (this.qQw != b.qQL)) {
          break;
        }
        localBitmap = qQz;
      }
    }
    throw new IllegalStateException("unknown display mode " + this.qQw);
  }
  
  private void a(b paramb, List<f> paramList)
  {
    this.qQn.clear();
    bYr();
    this.qQn.addAll(paramList);
    paramList = this.qQn.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      this.qQo[localf.qPB][localf.qPC] = 1;
    }
    setDisplayMode(paramb);
  }
  
  private void bYr()
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        this.qQo[i][j] = 0;
        j += 1;
      }
      i += 1;
    }
  }
  
  private void bYs()
  {
    this.qQn.clear();
    bYr();
    this.qQw = b.qQJ;
    invalidate();
  }
  
  private static String cZ(List<f> paramList)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("pattern is null");
    }
    int j = paramList.size();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      f localf = (f)paramList.get(i);
      int k = localf.qPB;
      arrayOfByte[i] = ((byte)(localf.qPC + k * 3));
      i += 1;
    }
    return new String(arrayOfByte);
  }
  
  private static int ex(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = paramInt2;
    switch (View.MeasureSpec.getMode(paramInt1))
    {
    default: 
      i = j;
    case 0: 
      return i;
    }
    return Math.max(j, paramInt2);
  }
  
  private static Bitmap p(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public final void bYt()
  {
    bYs();
    if (this.qQH != null) {
      this.qQH.a(this);
    }
  }
  
  public boolean getDisplayLine()
  {
    return this.qQu;
  }
  
  public boolean getEnableHapticFeedback()
  {
    return this.qQt;
  }
  
  public boolean getEnableInput()
  {
    return this.qQv;
  }
  
  public List<f> getPattern()
  {
    return new ArrayList(this.qQn);
  }
  
  protected int getSuggestedMinimumHeight()
  {
    float f = getResources().getDisplayMetrics().density;
    return (int)(3.0D * this.Av / f);
  }
  
  protected int getSuggestedMinimumWidth()
  {
    float f = getResources().getDisplayMetrics().density;
    return (int)(3.0D * this.Au / f);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    ArrayList localArrayList = this.qQn;
    int m = localArrayList.size();
    boolean[][] arrayOfBoolean = this.qQo;
    int j;
    int k;
    Object localObject;
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    label292:
    int n;
    int i1;
    boolean bool;
    if (this.qQw == b.qQL)
    {
      j = (int)(SystemClock.elapsedRealtime() - this.qQE) % ((m + 1) * 700);
      k = j / 700;
      bYr();
      i = 0;
      while (i < k)
      {
        localObject = (f)localArrayList.get(i);
        arrayOfBoolean[localObject.qPB][localObject.qPC] = 1;
        i += 1;
      }
      if ((k > 0) && (k < m))
      {
        i = 1;
        if (i != 0)
        {
          f1 = j % 700 / 700.0F;
          localObject = (f)localArrayList.get(k - 1);
          f2 = Bc(((f)localObject).qPC);
          f3 = Bd(((f)localObject).qPB);
          localObject = (f)localArrayList.get(k);
          f4 = Bc(((f)localObject).qPC);
          f5 = Bd(((f)localObject).qPB);
          this.qQB = (f2 + (f4 - f2) * f1);
          this.qQC = ((f5 - f3) * f1 + f3);
        }
        invalidate();
      }
    }
    else
    {
      this.qQi.setColor(this.jGo);
      this.qQi.setStrokeWidth(this.qQq);
      localObject = this.qQj;
      ((Path)localObject).rewind();
      if ((!this.qQu) && (this.qQw != b.qQK)) {
        break label430;
      }
      i = 1;
      n = getPaddingTop();
      i1 = getPaddingLeft();
      f1 = this.qQF;
      f2 = this.qQG;
      if ((this.qQh.getFlags() & 0x2) == 0) {
        break label436;
      }
      bool = true;
      label329:
      this.qQh.setFilterBitmap(true);
      j = 0;
    }
    float f6;
    for (;;)
    {
      if (j >= 3) {
        break label451;
      }
      f3 = n;
      f4 = j;
      k = 0;
      for (;;)
      {
        if (k < 3)
        {
          f5 = i1;
          f6 = k;
          if (arrayOfBoolean[j][k] == 0) {
            a(paramCanvas, (int)(f5 + f6 * f1), (int)(f4 * f2 + f3), arrayOfBoolean[j][k]);
          }
          k += 1;
          continue;
          i = 0;
          break;
          label430:
          i = 0;
          break label292;
          label436:
          bool = false;
          break label329;
        }
      }
      j += 1;
    }
    label451:
    if (i != 0)
    {
      j = 0;
      i = 0;
      if (i < m)
      {
        f localf = (f)localArrayList.get(i);
        if (arrayOfBoolean[localf.qPB][localf.qPC] != 0)
        {
          j = 1;
          f3 = Bc(localf.qPC);
          f4 = Bd(localf.qPB);
          if (i == 0) {
            ((Path)localObject).moveTo(f3, f4);
          }
          for (;;)
          {
            i += 1;
            break;
            ((Path)localObject).lineTo(f3, f4);
          }
        }
      }
      if (((this.qQD) || (this.qQw == b.qQL)) && (j != 0)) {
        ((Path)localObject).lineTo(this.qQB, this.qQC);
      }
      paramCanvas.drawPath((Path)localObject, this.qQi);
    }
    int i = 0;
    while (i < 3)
    {
      f3 = n;
      f4 = i;
      j = 0;
      while (j < 3)
      {
        f5 = i1;
        f6 = j;
        if (arrayOfBoolean[i][j] != 0) {
          a(paramCanvas, (int)(f5 + f6 * f1), (int)(f4 * f2 + f3), arrayOfBoolean[i][j]);
        }
        j += 1;
      }
      i += 1;
    }
    this.qQh.setFilterBitmap(bool);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getSuggestedMinimumWidth();
    int i = getSuggestedMinimumHeight();
    paramInt1 = ex(paramInt1, j);
    i = ex(paramInt2, i);
    if (this.qQp == PatternLockView.c.qQP) {
      paramInt2 = Math.min(paramInt1, i);
    }
    for (paramInt1 = paramInt2;; paramInt1 = i)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt2 = paramInt1;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (PatternLockView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    b localb = b.qQJ;
    Object localObject = paramParcelable.qQN;
    if (localObject == null) {
      throw new IllegalArgumentException("Serialized pattern is null");
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((String)localObject).getBytes();
    int i = 0;
    while (i < localObject.length)
    {
      int j = localObject[i];
      localArrayList.add(f.ew(j / 3, j % 3));
      i += 1;
    }
    a(localb, localArrayList);
    this.qQw = b.values()[paramParcelable.qQO];
    this.qQu = paramParcelable.qQu;
    this.qQv = paramParcelable.qQv;
    this.qQt = paramParcelable.qQt;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    return new PatternLockView.SavedState(super.onSaveInstanceState(), cZ(this.qQn), this.qQw.ordinal(), this.qQu, this.qQv, this.qQt);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.qQF = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.qQG = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.qQv) || (!isEnabled())) {
      return false;
    }
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    int j;
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      bYs();
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      paramMotionEvent = Z(f1, f2);
      if (paramMotionEvent != null)
      {
        this.qQD = true;
        this.qQw = b.qQJ;
        if (this.qQH == null) {}
      }
      for (;;)
      {
        if (paramMotionEvent != null)
        {
          f3 = Bc(paramMotionEvent.qPC);
          f4 = Bd(paramMotionEvent.qPB);
          f5 = this.qQF * 0.5F;
          f6 = this.qQG * 0.5F;
          invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
        }
        this.qQB = f1;
        this.qQC = f2;
        return true;
        this.qQD = false;
      }
    case 1: 
      if (!this.qQn.isEmpty())
      {
        this.qQD = false;
        if (this.qQH != null) {
          this.qQH.a(this, new ArrayList(this.qQn));
        }
        invalidate();
      }
      return true;
    case 2: 
      float f7 = this.qQq;
      int k = paramMotionEvent.getHistorySize();
      this.qQl.setEmpty();
      j = 0;
      i = 0;
      if (i < k + 1) {
        if (i < k)
        {
          f1 = paramMotionEvent.getHistoricalX(i);
          label288:
          if (i >= k) {
            break label600;
          }
          f2 = paramMotionEvent.getHistoricalY(i);
          label302:
          f localf1 = Z(f1, f2);
          int m = this.qQn.size();
          if ((localf1 != null) && (m == 1)) {
            this.qQD = true;
          }
          f3 = Math.abs(f1 - this.qQB);
          f4 = Math.abs(f2 - this.qQC);
          if ((f3 > 0.0F) || (f4 > 0.0F)) {
            j = 1;
          }
          if ((this.qQD) && (m > 0))
          {
            f localf2 = (f)this.qQn.get(m - 1);
            f4 = Bc(localf2.qPC);
            f3 = Bd(localf2.qPB);
            f5 = Math.min(f4, f1) - f7;
            f4 = Math.max(f4, f1) + f7;
            f6 = Math.min(f3, f2) - f7;
            f3 = Math.max(f3, f2) + f7;
            if (localf1 == null) {
              break label870;
            }
            f2 = this.qQF * 0.5F;
            float f8 = this.qQG * 0.5F;
            float f10 = Bc(localf1.qPC);
            float f9 = Bd(localf1.qPB);
            f1 = Math.min(f10 - f2, f5);
            f4 = Math.max(f2 + f10, f4);
            f2 = Math.min(f9 - f8, f6);
            f3 = Math.max(f9 + f8, f3);
          }
        }
      }
      break;
    }
    for (;;)
    {
      this.qQl.union(Math.round(f1), Math.round(f2), Math.round(f4), Math.round(f3));
      i += 1;
      break;
      f1 = paramMotionEvent.getX();
      break label288;
      label600:
      f2 = paramMotionEvent.getY();
      break label302;
      this.qQB = paramMotionEvent.getX();
      if (this.qQB < getPaddingLeft() + this.qQq)
      {
        this.qQB = (getPaddingLeft() + this.qQq);
        this.qQC = paramMotionEvent.getY();
        if (this.qQC >= getPaddingTop() + this.qQq) {
          break label780;
        }
        this.qQC = (getPaddingTop() + this.qQq);
      }
      for (;;)
      {
        if (j != 0)
        {
          this.qQm.union(this.qQl);
          invalidate(this.qQm);
          this.qQm.set(this.qQl);
        }
        return true;
        if (this.qQB <= getPaddingLeft() + getWidth() - getPaddingRight() - this.qQq) {
          break;
        }
        this.qQB = (getPaddingLeft() + getWidth() - getPaddingRight() - this.qQq);
        break;
        label780:
        if (this.qQC > getPaddingTop() + getHeight() - getPaddingRight() - this.qQq) {
          this.qQC = (getPaddingTop() + getHeight() - getPaddingBottom() - this.qQq);
        }
      }
      if (this.qQD)
      {
        this.qQD = false;
        bYs();
        if (this.qQH != null) {
          this.qQH.a(this);
        }
      }
      return true;
      label870:
      f2 = f6;
      f1 = f5;
    }
  }
  
  public void setDisplayLine(boolean paramBoolean)
  {
    this.qQu = paramBoolean;
    invalidate();
  }
  
  public void setDisplayMode(b paramb)
  {
    switch (1.qQI[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.qQw = paramb;
      invalidate();
      return;
      this.jGo = getResources().getColor(a.b.gesture_color_norm_line);
      continue;
      this.jGo = getResources().getColor(a.b.gesture_color_wrong_line);
      continue;
      if (this.qQn.size() == 0) {
        throw new IllegalStateException("You should set a pattern before animating.");
      }
      this.qQv = false;
      this.jGo = getResources().getColor(a.b.gesture_color_norm_line);
      f localf = (f)this.qQn.get(0);
      this.qQB = Bc(localf.qPC);
      this.qQC = Bd(localf.qPB);
      bYr();
      this.qQE = SystemClock.elapsedRealtime();
    }
  }
  
  public void setEnableHapticFeedback(boolean paramBoolean)
  {
    this.qQt = paramBoolean;
  }
  
  public void setEnableInput(boolean paramBoolean)
  {
    this.qQv = paramBoolean;
  }
  
  public void setOnPatternListener(PatternLockView.a parama)
  {
    this.qQH = parama;
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView
 * JD-Core Version:    0.7.0.1
 */