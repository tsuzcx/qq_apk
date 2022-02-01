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
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.walletlock.a.a;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView
  extends View
{
  private float IwA;
  private float IwB;
  private a IwC;
  private Paint Iwe;
  private Paint Iwf;
  private Path Iwg;
  private Matrix Iwh;
  private Rect Iwi;
  private Rect Iwj;
  private ArrayList<f> Iwk;
  private boolean[][] Iwl;
  private PatternLockView.c Iwm;
  private int Iwn;
  private float Iwo;
  private boolean Iwp;
  private boolean Iwq;
  private boolean Iwr;
  private b Iws;
  private Bitmap Iwt;
  private Bitmap Iwu;
  private Bitmap Iwv;
  private Bitmap Iww;
  private float Iwx;
  private float Iwy;
  private long Iwz;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private boolean okz;
  private int qSa;
  private int rLa;
  
  public PatternLockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(129865);
    this.Iwe = new Paint();
    this.Iwf = new Paint();
    this.Iwg = new Path();
    this.Iwh = new Matrix();
    this.Iwi = new Rect();
    this.Iwj = new Rect();
    this.Iwk = new ArrayList(9);
    this.Iwl = ((boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 }));
    this.Iwm = PatternLockView.c.IwK;
    this.qSa = 6;
    this.Iwn = 200;
    this.Iwo = 0.66F;
    this.Iwp = false;
    this.Iwq = true;
    this.Iwr = false;
    int i;
    if (isInEditMode())
    {
      i = -1;
      this.rLa = i;
      this.Iws = b.IwE;
      this.Iwt = null;
      this.Iwu = null;
      this.Iwv = null;
      this.Iww = null;
      this.Iwx = -1.0F;
      this.Iwy = -1.0F;
      this.okz = false;
      this.Iwz = 0L;
      this.mBitmapWidth = 0;
      this.mBitmapHeight = 0;
      this.IwA = 0.0F;
      this.IwB = 0.0F;
      this.IwC = null;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.mm_patternlock_view);
      this.Iwq = paramContext.getBoolean(4, this.Iwq);
      this.Iwn = paramContext.getInt(1, this.Iwn);
      this.qSa = paramContext.getInt(2, this.qSa);
      this.Iwp = paramContext.getBoolean(0, this.Iwp);
      switch (paramContext.getInt(3, this.Iwm.ordinal()))
      {
      default: 
        this.Iwm = PatternLockView.c.IwK;
      }
    }
    for (;;)
    {
      paramContext.recycle();
      setClickable(true);
      this.Iwf.setStyle(Paint.Style.STROKE);
      this.Iwf.setStrokeJoin(Paint.Join.ROUND);
      this.Iwf.setStrokeCap(Paint.Cap.ROUND);
      this.Iwf.setAntiAlias(true);
      this.Iwf.setDither(false);
      this.Iwf.setAlpha(this.Iwn);
      this.Iwe.setAntiAlias(true);
      this.Iwe.setDither(true);
      if (isInEditMode()) {
        break label646;
      }
      if (this.Iwt == null)
      {
        this.Iwt = drawable2Bitmap(a.l(getContext(), 2131232990));
        this.Iwu = drawable2Bitmap(a.l(getContext(), 2131232991));
        this.Iwv = this.Iwu;
        this.Iww = drawable2Bitmap(a.l(getContext(), 2131232992));
      }
      this.qSa = ((int)(this.qSa * BitmapUtil.getDefaultDisplayMetrics().density));
      paramContext = this.Iwt;
      paramAttributeSet = this.Iwu;
      Bitmap localBitmap1 = this.Iwv;
      Bitmap localBitmap2 = this.Iww;
      i = 0;
      while (i < 4)
      {
        Bitmap localBitmap3 = new Bitmap[] { paramContext, paramAttributeSet, localBitmap1, localBitmap2 }[i];
        this.mBitmapWidth = Math.max(localBitmap3.getWidth(), this.mBitmapWidth);
        this.mBitmapHeight = Math.max(localBitmap3.getHeight(), this.mBitmapHeight);
        i += 1;
      }
      i = getResources().getColor(2131099710);
      break;
      this.Iwm = PatternLockView.c.IwK;
      continue;
      this.Iwm = PatternLockView.c.IwL;
    }
    label646:
    AppMethodBeat.o(129865);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(129876);
    Bitmap localBitmap;
    if ((!paramBoolean) || ((!this.Iwq) && (this.Iws != b.IwF))) {
      localBitmap = this.Iwt;
    }
    for (;;)
    {
      int j = this.mBitmapWidth;
      int i = this.mBitmapHeight;
      float f1 = this.IwA;
      float f2 = this.IwB;
      j = (int)((f1 - j) * 0.5F);
      i = (int)((f2 - i) * 0.5F);
      f2 = getResources().getDisplayMetrics().density;
      f1 = Math.min((this.IwA - 33.0F * f2) / this.mBitmapWidth, 1.0F);
      f2 = Math.min((this.IwB - f2 * 33.0F) / this.mBitmapHeight, 1.0F);
      this.Iwh.setTranslate(j + paramInt1, i + paramInt2);
      this.Iwh.preTranslate(this.mBitmapWidth / 2, this.mBitmapHeight / 2);
      this.Iwh.preScale(f1, f2);
      this.Iwh.preTranslate(-this.mBitmapWidth / 2, -this.mBitmapHeight / 2);
      if (!isInEditMode()) {
        paramCanvas.drawBitmap(localBitmap, this.Iwh, this.Iwe);
      }
      AppMethodBeat.o(129876);
      return;
      if (this.okz)
      {
        localBitmap = this.Iwu;
      }
      else if (this.Iws == b.IwF)
      {
        localBitmap = this.Iww;
      }
      else
      {
        if ((this.Iws != b.IwE) && (this.Iws != b.IwG)) {
          break;
        }
        localBitmap = this.Iwv;
      }
    }
    paramCanvas = new IllegalStateException("unknown display mode " + this.Iws);
    AppMethodBeat.o(129876);
    throw paramCanvas;
  }
  
  private void a(b paramb, List<f> paramList)
  {
    AppMethodBeat.i(129883);
    this.Iwk.clear();
    fVn();
    this.Iwk.addAll(paramList);
    paramList = this.Iwk.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      this.Iwl[localf.Ivy][localf.Ivz] = 1;
    }
    setDisplayMode(paramb);
    AppMethodBeat.o(129883);
  }
  
  private float afc(int paramInt)
  {
    AppMethodBeat.i(129880);
    float f1 = getPaddingLeft();
    float f2 = paramInt;
    float f3 = this.IwA;
    float f4 = this.IwA;
    AppMethodBeat.o(129880);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private float afd(int paramInt)
  {
    AppMethodBeat.i(129881);
    float f1 = getPaddingTop();
    float f2 = paramInt;
    float f3 = this.IwB;
    float f4 = this.IwB;
    AppMethodBeat.o(129881);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private f ap(float paramFloat1, float paramFloat2)
  {
    int k = 0;
    AppMethodBeat.i(129877);
    Object localObject2 = null;
    float f1 = this.IwB;
    float f2 = f1 * this.Iwo;
    float f3 = getPaddingTop();
    float f4 = (f1 - f2) / 2.0F;
    int i = 0;
    int j;
    label83:
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
          paramFloat2 = this.IwA;
          f1 = this.Iwo * paramFloat2;
          f2 = getPaddingLeft();
          f3 = (paramFloat2 - f1) / 2.0F;
          i = k;
          label122:
          if (i >= 3) {
            break label290;
          }
          f4 = i * paramFloat2 + (f2 + f3);
          if ((paramFloat1 < f4) || (paramFloat1 > f4 + f1)) {
            break label281;
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
        if (this.Iwl[j][i] == 0) {
          localObject1 = f.jW(j, i);
        }
      }
      if (localObject1 == null) {
        break label296;
      }
      this.Iwl[localObject1.Ivy][localObject1.Ivz] = 1;
      this.Iwk.add(localObject1);
      if (this.IwC != null) {
        new ArrayList(this.Iwk);
      }
      if (this.Iwp) {
        performHapticFeedback(1, 3);
      }
      AppMethodBeat.o(129877);
      return localObject1;
      i += 1;
      break;
      j = -1;
      break label83;
      label281:
      i += 1;
      break label122;
      label290:
      i = -1;
    }
    label296:
    AppMethodBeat.o(129877);
    return null;
  }
  
  private static Bitmap drawable2Bitmap(Drawable paramDrawable)
  {
    AppMethodBeat.i(129866);
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.draw(localCanvas);
      AppMethodBeat.o(129866);
      return localObject;
    }
  }
  
  private void fVn()
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        this.Iwl[i][j] = 0;
        j += 1;
      }
      i += 1;
    }
  }
  
  private void fVo()
  {
    AppMethodBeat.i(129884);
    this.Iwk.clear();
    fVn();
    this.Iws = b.IwE;
    invalidate();
    AppMethodBeat.o(129884);
  }
  
  private static String ig(List<f> paramList)
  {
    AppMethodBeat.i(129867);
    if (paramList == null)
    {
      paramList = new IllegalArgumentException("pattern is null");
      AppMethodBeat.o(129867);
      throw paramList;
    }
    int j = paramList.size();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      f localf = (f)paramList.get(i);
      int k = localf.Ivy;
      arrayOfByte[i] = ((byte)(localf.Ivz + k * 3));
      i += 1;
    }
    paramList = new String(arrayOfByte);
    AppMethodBeat.o(129867);
    return paramList;
  }
  
  private static int jX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129873);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = paramInt2;
    switch (View.MeasureSpec.getMode(paramInt1))
    {
    }
    for (i = j;; i = Math.max(j, paramInt2))
    {
      AppMethodBeat.o(129873);
      return i;
    }
  }
  
  public final void fVp()
  {
    AppMethodBeat.i(129885);
    fVo();
    if (this.IwC != null) {
      this.IwC.a(this);
    }
    AppMethodBeat.o(129885);
  }
  
  public boolean getDisplayLine()
  {
    return this.Iwq;
  }
  
  public boolean getEnableHapticFeedback()
  {
    return this.Iwp;
  }
  
  public boolean getEnableInput()
  {
    return this.Iwr;
  }
  
  public List<f> getPattern()
  {
    AppMethodBeat.i(129882);
    ArrayList localArrayList = new ArrayList(this.Iwk);
    AppMethodBeat.o(129882);
    return localArrayList;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    AppMethodBeat.i(129871);
    float f = getResources().getDisplayMetrics().density;
    int i = (int)(3.0D * this.mBitmapHeight / f);
    AppMethodBeat.o(129871);
    return i;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    AppMethodBeat.i(129870);
    float f = getResources().getDisplayMetrics().density;
    int i = (int)(3.0D * this.mBitmapWidth / f);
    AppMethodBeat.o(129870);
    return i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(129875);
    ArrayList localArrayList = this.Iwk;
    int m = localArrayList.size();
    boolean[][] arrayOfBoolean = this.Iwl;
    int j;
    int k;
    Object localObject;
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    label298:
    int n;
    int i1;
    boolean bool;
    if (this.Iws == b.IwG)
    {
      j = (int)(SystemClock.elapsedRealtime() - this.Iwz) % ((m + 1) * 700);
      k = j / 700;
      fVn();
      i = 0;
      while (i < k)
      {
        localObject = (f)localArrayList.get(i);
        arrayOfBoolean[localObject.Ivy][localObject.Ivz] = 1;
        i += 1;
      }
      if ((k > 0) && (k < m))
      {
        i = 1;
        if (i != 0)
        {
          f1 = j % 700 / 700.0F;
          localObject = (f)localArrayList.get(k - 1);
          f2 = afc(((f)localObject).Ivz);
          f3 = afd(((f)localObject).Ivy);
          localObject = (f)localArrayList.get(k);
          f4 = afc(((f)localObject).Ivz);
          f5 = afd(((f)localObject).Ivy);
          this.Iwx = (f2 + (f4 - f2) * f1);
          this.Iwy = ((f5 - f3) * f1 + f3);
        }
        invalidate();
      }
    }
    else
    {
      this.Iwf.setColor(this.rLa);
      this.Iwf.setStrokeWidth(this.qSa);
      localObject = this.Iwg;
      ((Path)localObject).rewind();
      if ((!this.Iwq) && (this.Iws != b.IwF)) {
        break label436;
      }
      i = 1;
      n = getPaddingTop();
      i1 = getPaddingLeft();
      f1 = this.IwA;
      f2 = this.IwB;
      if ((this.Iwe.getFlags() & 0x2) == 0) {
        break label442;
      }
      bool = true;
      label335:
      this.Iwe.setFilterBitmap(true);
      j = 0;
    }
    float f6;
    for (;;)
    {
      if (j >= 3) {
        break label457;
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
          label436:
          i = 0;
          break label298;
          label442:
          bool = false;
          break label335;
        }
      }
      j += 1;
    }
    label457:
    if (i != 0)
    {
      j = 0;
      i = 0;
      if (i < m)
      {
        f localf = (f)localArrayList.get(i);
        if (arrayOfBoolean[localf.Ivy][localf.Ivz] != 0)
        {
          j = 1;
          f3 = afc(localf.Ivz);
          f4 = afd(localf.Ivy);
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
      if (((this.okz) || (this.Iws == b.IwG)) && (j != 0)) {
        ((Path)localObject).lineTo(this.Iwx, this.Iwy);
      }
      paramCanvas.drawPath((Path)localObject, this.Iwf);
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
    this.Iwe.setFilterBitmap(bool);
    AppMethodBeat.o(129875);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129874);
    int j = getSuggestedMinimumWidth();
    int i = getSuggestedMinimumHeight();
    paramInt1 = jX(paramInt1, j);
    i = jX(paramInt2, i);
    if (this.Iwm == PatternLockView.c.IwK) {
      paramInt2 = Math.min(paramInt1, i);
    }
    for (paramInt1 = paramInt2;; paramInt1 = i)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      AppMethodBeat.o(129874);
      return;
      paramInt2 = paramInt1;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(129869);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    b localb = b.IwE;
    Object localObject = paramParcelable.IwI;
    if (localObject == null)
    {
      paramParcelable = new IllegalArgumentException("Serialized pattern is null");
      AppMethodBeat.o(129869);
      throw paramParcelable;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((String)localObject).getBytes();
    int i = 0;
    while (i < localObject.length)
    {
      int j = localObject[i];
      localArrayList.add(f.jW(j / 3, j % 3));
      i += 1;
    }
    a(localb, localArrayList);
    this.Iws = b.values()[paramParcelable.IwJ];
    this.Iwq = paramParcelable.Iwq;
    this.Iwr = paramParcelable.Iwr;
    this.Iwp = paramParcelable.Iwp;
    AppMethodBeat.o(129869);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(129868);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState(), ig(this.Iwk), this.Iws.ordinal(), this.Iwq, this.Iwr, this.Iwp);
    AppMethodBeat.o(129868);
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(129872);
    this.IwA = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.IwB = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
    AppMethodBeat.o(129872);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(129878);
    if ((!this.Iwr) || (!isEnabled()))
    {
      AppMethodBeat.o(129878);
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
      AppMethodBeat.o(129878);
      return false;
    case 0: 
      fVo();
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      paramMotionEvent = ap(f1, f2);
      if (paramMotionEvent != null)
      {
        this.okz = true;
        this.Iws = b.IwE;
        if (this.IwC == null) {}
      }
      for (;;)
      {
        if (paramMotionEvent != null)
        {
          f3 = afc(paramMotionEvent.Ivz);
          f4 = afd(paramMotionEvent.Ivy);
          f5 = this.IwA * 0.5F;
          f6 = this.IwB * 0.5F;
          invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
        }
        this.Iwx = f1;
        this.Iwy = f2;
        AppMethodBeat.o(129878);
        return true;
        this.okz = false;
      }
    case 1: 
      if (!this.Iwk.isEmpty())
      {
        this.okz = false;
        if (this.IwC != null) {
          this.IwC.a(this, new ArrayList(this.Iwk));
        }
        invalidate();
      }
      AppMethodBeat.o(129878);
      return true;
    case 2: 
      float f7 = this.qSa;
      int k = paramMotionEvent.getHistorySize();
      this.Iwi.setEmpty();
      j = 0;
      i = 0;
      if (i < k + 1) {
        if (i < k)
        {
          f1 = paramMotionEvent.getHistoricalX(i);
          label318:
          if (i >= k) {
            break label630;
          }
          f2 = paramMotionEvent.getHistoricalY(i);
          label332:
          f localf1 = ap(f1, f2);
          int m = this.Iwk.size();
          if ((localf1 != null) && (m == 1)) {
            this.okz = true;
          }
          f3 = Math.abs(f1 - this.Iwx);
          f4 = Math.abs(f2 - this.Iwy);
          if ((f3 > 0.0F) || (f4 > 0.0F)) {
            j = 1;
          }
          if ((this.okz) && (m > 0))
          {
            f localf2 = (f)this.Iwk.get(m - 1);
            f4 = afc(localf2.Ivz);
            f3 = afd(localf2.Ivy);
            f5 = Math.min(f4, f1) - f7;
            f4 = Math.max(f4, f1) + f7;
            f6 = Math.min(f3, f2) - f7;
            f3 = Math.max(f3, f2) + f7;
            if (localf1 == null) {
              break label912;
            }
            f2 = this.IwA * 0.5F;
            float f8 = this.IwB * 0.5F;
            float f10 = afc(localf1.Ivz);
            float f9 = afd(localf1.Ivy);
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
      this.Iwi.union(Math.round(f1), Math.round(f2), Math.round(f4), Math.round(f3));
      i += 1;
      break;
      f1 = paramMotionEvent.getX();
      break label318;
      label630:
      f2 = paramMotionEvent.getY();
      break label332;
      this.Iwx = paramMotionEvent.getX();
      if (this.Iwx < getPaddingLeft() + this.qSa)
      {
        this.Iwx = (getPaddingLeft() + this.qSa);
        this.Iwy = paramMotionEvent.getY();
        if (this.Iwy >= getPaddingTop() + this.qSa) {
          break label816;
        }
        this.Iwy = (getPaddingTop() + this.qSa);
      }
      for (;;)
      {
        if (j != 0)
        {
          this.Iwj.union(this.Iwi);
          invalidate(this.Iwj);
          this.Iwj.set(this.Iwi);
        }
        AppMethodBeat.o(129878);
        return true;
        if (this.Iwx <= getPaddingLeft() + getWidth() - getPaddingRight() - this.qSa) {
          break;
        }
        this.Iwx = (getPaddingLeft() + getWidth() - getPaddingRight() - this.qSa);
        break;
        label816:
        if (this.Iwy > getPaddingTop() + getHeight() - getPaddingRight() - this.qSa) {
          this.Iwy = (getPaddingTop() + getHeight() - getPaddingBottom() - this.qSa);
        }
      }
      if (this.okz)
      {
        this.okz = false;
        fVo();
        if (this.IwC != null) {
          this.IwC.a(this);
        }
      }
      AppMethodBeat.o(129878);
      return true;
      label912:
      f2 = f6;
      f1 = f5;
    }
  }
  
  public void setDisplayLine(boolean paramBoolean)
  {
    AppMethodBeat.i(129879);
    this.Iwq = paramBoolean;
    invalidate();
    AppMethodBeat.o(129879);
  }
  
  public void setDisplayMode(b paramb)
  {
    AppMethodBeat.i(129886);
    switch (1.IwD[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.Iws = paramb;
      invalidate();
      AppMethodBeat.o(129886);
      return;
      this.rLa = getResources().getColor(2131100562);
      continue;
      this.rLa = getResources().getColor(2131100565);
      continue;
      if (this.Iwk.size() == 0)
      {
        paramb = new IllegalStateException("You should set a pattern before animating.");
        AppMethodBeat.o(129886);
        throw paramb;
      }
      this.Iwr = false;
      this.rLa = getResources().getColor(2131100562);
      f localf = (f)this.Iwk.get(0);
      this.Iwx = afc(localf.Ivz);
      this.Iwy = afd(localf.Ivy);
      fVn();
      this.Iwz = SystemClock.elapsedRealtime();
    }
  }
  
  public void setEnableHapticFeedback(boolean paramBoolean)
  {
    this.Iwp = paramBoolean;
  }
  
  public void setEnableInput(boolean paramBoolean)
  {
    this.Iwr = paramBoolean;
  }
  
  public void setOnPatternListener(a parama)
  {
    this.IwC = parama;
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    String IwI;
    int IwJ;
    boolean Iwp;
    boolean Iwq;
    boolean Iwr;
    
    static
    {
      AppMethodBeat.i(129861);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(129861);
    }
    
    public SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(129859);
      this.IwI = paramParcel.readString();
      this.IwJ = paramParcel.readInt();
      this.Iwq = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.Iwr = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.Iwp = ((Boolean)paramParcel.readValue(null)).booleanValue();
      AppMethodBeat.o(129859);
    }
    
    public SavedState(Parcelable paramParcelable, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super();
      this.IwI = paramString;
      this.IwJ = paramInt;
      this.Iwq = paramBoolean1;
      this.Iwr = paramBoolean2;
      this.Iwp = paramBoolean3;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(129860);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.IwI);
      paramParcel.writeInt(this.IwJ);
      paramParcel.writeValue(Boolean.valueOf(this.Iwq));
      paramParcel.writeValue(Boolean.valueOf(this.Iwr));
      paramParcel.writeValue(Boolean.valueOf(this.Iwp));
      AppMethodBeat.o(129860);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(PatternLockView paramPatternLockView);
    
    public abstract void a(PatternLockView paramPatternLockView, List<f> paramList);
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(129857);
      IwE = new b("Correct", 0);
      IwF = new b("Wrong", 1);
      IwG = new b("Animate", 2);
      IwH = new b[] { IwE, IwF, IwG };
      AppMethodBeat.o(129857);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView
 * JD-Core Version:    0.7.0.1
 */