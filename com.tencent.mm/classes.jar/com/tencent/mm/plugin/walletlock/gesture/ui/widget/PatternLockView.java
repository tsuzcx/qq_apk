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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.walletlock.a.a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView
  extends View
{
  private Paint BUQ;
  private Paint BUR;
  private Path BUS;
  private Matrix BUT;
  private Rect BUU;
  private Rect BUV;
  private ArrayList<com.tencent.mm.plugin.walletlock.gesture.a.f> BUW;
  private boolean[][] BUX;
  private PatternLockView.c BUY;
  private int BUZ;
  private float BVa;
  private boolean BVb;
  private boolean BVc;
  private boolean BVd;
  private b BVe;
  private Bitmap BVf;
  private Bitmap BVg;
  private Bitmap BVh;
  private Bitmap BVi;
  private float BVj;
  private float BVk;
  private long BVl;
  private float BVm;
  private float BVn;
  private a BVo;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private boolean mrH;
  private int oSu;
  private int pJI;
  
  public PatternLockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(129865);
    this.BUQ = new Paint();
    this.BUR = new Paint();
    this.BUS = new Path();
    this.BUT = new Matrix();
    this.BUU = new Rect();
    this.BUV = new Rect();
    this.BUW = new ArrayList(9);
    this.BUX = ((boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 }));
    this.BUY = PatternLockView.c.BVw;
    this.oSu = 6;
    this.BUZ = 200;
    this.BVa = 0.66F;
    this.BVb = false;
    this.BVc = true;
    this.BVd = false;
    int i;
    if (isInEditMode())
    {
      i = -1;
      this.pJI = i;
      this.BVe = b.BVq;
      this.BVf = null;
      this.BVg = null;
      this.BVh = null;
      this.BVi = null;
      this.BVj = -1.0F;
      this.BVk = -1.0F;
      this.mrH = false;
      this.BVl = 0L;
      this.mBitmapWidth = 0;
      this.mBitmapHeight = 0;
      this.BVm = 0.0F;
      this.BVn = 0.0F;
      this.BVo = null;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.mm_patternlock_view);
      this.BVc = paramContext.getBoolean(4, this.BVc);
      this.BUZ = paramContext.getInt(1, this.BUZ);
      this.oSu = paramContext.getInt(2, this.oSu);
      this.BVb = paramContext.getBoolean(0, this.BVb);
      switch (paramContext.getInt(3, this.BUY.ordinal()))
      {
      default: 
        this.BUY = PatternLockView.c.BVw;
      }
    }
    for (;;)
    {
      paramContext.recycle();
      setClickable(true);
      this.BUR.setStyle(Paint.Style.STROKE);
      this.BUR.setStrokeJoin(Paint.Join.ROUND);
      this.BUR.setStrokeCap(Paint.Cap.ROUND);
      this.BUR.setAntiAlias(true);
      this.BUR.setDither(false);
      this.BUR.setAlpha(this.BUZ);
      this.BUQ.setAntiAlias(true);
      this.BUQ.setDither(true);
      if (isInEditMode()) {
        break label646;
      }
      if (this.BVf == null)
      {
        this.BVf = drawable2Bitmap(a.l(getContext(), 2131232595));
        this.BVg = drawable2Bitmap(a.l(getContext(), 2131232596));
        this.BVh = this.BVg;
        this.BVi = drawable2Bitmap(a.l(getContext(), 2131232597));
      }
      this.oSu = ((int)(this.oSu * com.tencent.mm.sdk.platformtools.f.aNu().density));
      paramContext = this.BVf;
      paramAttributeSet = this.BVg;
      Bitmap localBitmap1 = this.BVh;
      Bitmap localBitmap2 = this.BVi;
      i = 0;
      while (i < 4)
      {
        Bitmap localBitmap3 = new Bitmap[] { paramContext, paramAttributeSet, localBitmap1, localBitmap2 }[i];
        this.mBitmapWidth = Math.max(localBitmap3.getWidth(), this.mBitmapWidth);
        this.mBitmapHeight = Math.max(localBitmap3.getHeight(), this.mBitmapHeight);
        i += 1;
      }
      i = getResources().getColor(2131099699);
      break;
      this.BUY = PatternLockView.c.BVw;
      continue;
      this.BUY = PatternLockView.c.BVx;
    }
    label646:
    AppMethodBeat.o(129865);
  }
  
  private float TX(int paramInt)
  {
    AppMethodBeat.i(129880);
    float f1 = getPaddingLeft();
    float f2 = paramInt;
    float f3 = this.BVm;
    float f4 = this.BVm;
    AppMethodBeat.o(129880);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private float TY(int paramInt)
  {
    AppMethodBeat.i(129881);
    float f1 = getPaddingTop();
    float f2 = paramInt;
    float f3 = this.BVn;
    float f4 = this.BVn;
    AppMethodBeat.o(129881);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(129876);
    Bitmap localBitmap;
    if ((!paramBoolean) || ((!this.BVc) && (this.BVe != b.BVr))) {
      localBitmap = this.BVf;
    }
    for (;;)
    {
      int j = this.mBitmapWidth;
      int i = this.mBitmapHeight;
      float f1 = this.BVm;
      float f2 = this.BVn;
      j = (int)((f1 - j) * 0.5F);
      i = (int)((f2 - i) * 0.5F);
      f2 = getResources().getDisplayMetrics().density;
      f1 = Math.min((this.BVm - 33.0F * f2) / this.mBitmapWidth, 1.0F);
      f2 = Math.min((this.BVn - f2 * 33.0F) / this.mBitmapHeight, 1.0F);
      this.BUT.setTranslate(j + paramInt1, i + paramInt2);
      this.BUT.preTranslate(this.mBitmapWidth / 2, this.mBitmapHeight / 2);
      this.BUT.preScale(f1, f2);
      this.BUT.preTranslate(-this.mBitmapWidth / 2, -this.mBitmapHeight / 2);
      if (!isInEditMode()) {
        paramCanvas.drawBitmap(localBitmap, this.BUT, this.BUQ);
      }
      AppMethodBeat.o(129876);
      return;
      if (this.mrH)
      {
        localBitmap = this.BVg;
      }
      else if (this.BVe == b.BVr)
      {
        localBitmap = this.BVi;
      }
      else
      {
        if ((this.BVe != b.BVq) && (this.BVe != b.BVs)) {
          break;
        }
        localBitmap = this.BVh;
      }
    }
    paramCanvas = new IllegalStateException("unknown display mode " + this.BVe);
    AppMethodBeat.o(129876);
    throw paramCanvas;
  }
  
  private void a(b paramb, List<com.tencent.mm.plugin.walletlock.gesture.a.f> paramList)
  {
    AppMethodBeat.i(129883);
    this.BUW.clear();
    evQ();
    this.BUW.addAll(paramList);
    paramList = this.BUW.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.walletlock.gesture.a.f localf = (com.tencent.mm.plugin.walletlock.gesture.a.f)paramList.next();
      this.BUX[localf.BUk][localf.BUl] = 1;
    }
    setDisplayMode(paramb);
    AppMethodBeat.o(129883);
  }
  
  private com.tencent.mm.plugin.walletlock.gesture.a.f ae(float paramFloat1, float paramFloat2)
  {
    int k = 0;
    AppMethodBeat.i(129877);
    Object localObject2 = null;
    float f1 = this.BVn;
    float f2 = f1 * this.BVa;
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
          paramFloat2 = this.BVm;
          f1 = this.BVa * paramFloat2;
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
        if (this.BUX[j][i] == 0) {
          localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.f.iz(j, i);
        }
      }
      if (localObject1 == null) {
        break label296;
      }
      this.BUX[localObject1.BUk][localObject1.BUl] = 1;
      this.BUW.add(localObject1);
      if (this.BVo != null) {
        new ArrayList(this.BUW);
      }
      if (this.BVb) {
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
  
  private void evQ()
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        this.BUX[i][j] = 0;
        j += 1;
      }
      i += 1;
    }
  }
  
  private void evR()
  {
    AppMethodBeat.i(129884);
    this.BUW.clear();
    evQ();
    this.BVe = b.BVq;
    invalidate();
    AppMethodBeat.o(129884);
  }
  
  private static String gE(List<com.tencent.mm.plugin.walletlock.gesture.a.f> paramList)
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
      com.tencent.mm.plugin.walletlock.gesture.a.f localf = (com.tencent.mm.plugin.walletlock.gesture.a.f)paramList.get(i);
      int k = localf.BUk;
      arrayOfByte[i] = ((byte)(localf.BUl + k * 3));
      i += 1;
    }
    paramList = new String(arrayOfByte);
    AppMethodBeat.o(129867);
    return paramList;
  }
  
  private static int iA(int paramInt1, int paramInt2)
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
  
  public final void evS()
  {
    AppMethodBeat.i(129885);
    evR();
    if (this.BVo != null) {
      this.BVo.a(this);
    }
    AppMethodBeat.o(129885);
  }
  
  public boolean getDisplayLine()
  {
    return this.BVc;
  }
  
  public boolean getEnableHapticFeedback()
  {
    return this.BVb;
  }
  
  public boolean getEnableInput()
  {
    return this.BVd;
  }
  
  public List<com.tencent.mm.plugin.walletlock.gesture.a.f> getPattern()
  {
    AppMethodBeat.i(129882);
    ArrayList localArrayList = new ArrayList(this.BUW);
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
    ArrayList localArrayList = this.BUW;
    int m = localArrayList.size();
    boolean[][] arrayOfBoolean = this.BUX;
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
    if (this.BVe == b.BVs)
    {
      j = (int)(SystemClock.elapsedRealtime() - this.BVl) % ((m + 1) * 700);
      k = j / 700;
      evQ();
      i = 0;
      while (i < k)
      {
        localObject = (com.tencent.mm.plugin.walletlock.gesture.a.f)localArrayList.get(i);
        arrayOfBoolean[localObject.BUk][localObject.BUl] = 1;
        i += 1;
      }
      if ((k > 0) && (k < m))
      {
        i = 1;
        if (i != 0)
        {
          f1 = j % 700 / 700.0F;
          localObject = (com.tencent.mm.plugin.walletlock.gesture.a.f)localArrayList.get(k - 1);
          f2 = TX(((com.tencent.mm.plugin.walletlock.gesture.a.f)localObject).BUl);
          f3 = TY(((com.tencent.mm.plugin.walletlock.gesture.a.f)localObject).BUk);
          localObject = (com.tencent.mm.plugin.walletlock.gesture.a.f)localArrayList.get(k);
          f4 = TX(((com.tencent.mm.plugin.walletlock.gesture.a.f)localObject).BUl);
          f5 = TY(((com.tencent.mm.plugin.walletlock.gesture.a.f)localObject).BUk);
          this.BVj = (f2 + (f4 - f2) * f1);
          this.BVk = ((f5 - f3) * f1 + f3);
        }
        invalidate();
      }
    }
    else
    {
      this.BUR.setColor(this.pJI);
      this.BUR.setStrokeWidth(this.oSu);
      localObject = this.BUS;
      ((Path)localObject).rewind();
      if ((!this.BVc) && (this.BVe != b.BVr)) {
        break label436;
      }
      i = 1;
      n = getPaddingTop();
      i1 = getPaddingLeft();
      f1 = this.BVm;
      f2 = this.BVn;
      if ((this.BUQ.getFlags() & 0x2) == 0) {
        break label442;
      }
      bool = true;
      label335:
      this.BUQ.setFilterBitmap(true);
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
        com.tencent.mm.plugin.walletlock.gesture.a.f localf = (com.tencent.mm.plugin.walletlock.gesture.a.f)localArrayList.get(i);
        if (arrayOfBoolean[localf.BUk][localf.BUl] != 0)
        {
          j = 1;
          f3 = TX(localf.BUl);
          f4 = TY(localf.BUk);
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
      if (((this.mrH) || (this.BVe == b.BVs)) && (j != 0)) {
        ((Path)localObject).lineTo(this.BVj, this.BVk);
      }
      paramCanvas.drawPath((Path)localObject, this.BUR);
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
    this.BUQ.setFilterBitmap(bool);
    AppMethodBeat.o(129875);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129874);
    int j = getSuggestedMinimumWidth();
    int i = getSuggestedMinimumHeight();
    paramInt1 = iA(paramInt1, j);
    i = iA(paramInt2, i);
    if (this.BUY == PatternLockView.c.BVw) {
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
    b localb = b.BVq;
    Object localObject = paramParcelable.BVu;
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
      localArrayList.add(com.tencent.mm.plugin.walletlock.gesture.a.f.iz(j / 3, j % 3));
      i += 1;
    }
    a(localb, localArrayList);
    this.BVe = b.values()[paramParcelable.BVv];
    this.BVc = paramParcelable.BVc;
    this.BVd = paramParcelable.BVd;
    this.BVb = paramParcelable.BVb;
    AppMethodBeat.o(129869);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(129868);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState(), gE(this.BUW), this.BVe.ordinal(), this.BVc, this.BVd, this.BVb);
    AppMethodBeat.o(129868);
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(129872);
    this.BVm = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.BVn = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
    AppMethodBeat.o(129872);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(129878);
    if ((!this.BVd) || (!isEnabled()))
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
      evR();
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      paramMotionEvent = ae(f1, f2);
      if (paramMotionEvent != null)
      {
        this.mrH = true;
        this.BVe = b.BVq;
        if (this.BVo == null) {}
      }
      for (;;)
      {
        if (paramMotionEvent != null)
        {
          f3 = TX(paramMotionEvent.BUl);
          f4 = TY(paramMotionEvent.BUk);
          f5 = this.BVm * 0.5F;
          f6 = this.BVn * 0.5F;
          invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
        }
        this.BVj = f1;
        this.BVk = f2;
        AppMethodBeat.o(129878);
        return true;
        this.mrH = false;
      }
    case 1: 
      if (!this.BUW.isEmpty())
      {
        this.mrH = false;
        if (this.BVo != null) {
          this.BVo.a(this, new ArrayList(this.BUW));
        }
        invalidate();
      }
      AppMethodBeat.o(129878);
      return true;
    case 2: 
      float f7 = this.oSu;
      int k = paramMotionEvent.getHistorySize();
      this.BUU.setEmpty();
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
          com.tencent.mm.plugin.walletlock.gesture.a.f localf1 = ae(f1, f2);
          int m = this.BUW.size();
          if ((localf1 != null) && (m == 1)) {
            this.mrH = true;
          }
          f3 = Math.abs(f1 - this.BVj);
          f4 = Math.abs(f2 - this.BVk);
          if ((f3 > 0.0F) || (f4 > 0.0F)) {
            j = 1;
          }
          if ((this.mrH) && (m > 0))
          {
            com.tencent.mm.plugin.walletlock.gesture.a.f localf2 = (com.tencent.mm.plugin.walletlock.gesture.a.f)this.BUW.get(m - 1);
            f4 = TX(localf2.BUl);
            f3 = TY(localf2.BUk);
            f5 = Math.min(f4, f1) - f7;
            f4 = Math.max(f4, f1) + f7;
            f6 = Math.min(f3, f2) - f7;
            f3 = Math.max(f3, f2) + f7;
            if (localf1 == null) {
              break label912;
            }
            f2 = this.BVm * 0.5F;
            float f8 = this.BVn * 0.5F;
            float f10 = TX(localf1.BUl);
            float f9 = TY(localf1.BUk);
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
      this.BUU.union(Math.round(f1), Math.round(f2), Math.round(f4), Math.round(f3));
      i += 1;
      break;
      f1 = paramMotionEvent.getX();
      break label318;
      label630:
      f2 = paramMotionEvent.getY();
      break label332;
      this.BVj = paramMotionEvent.getX();
      if (this.BVj < getPaddingLeft() + this.oSu)
      {
        this.BVj = (getPaddingLeft() + this.oSu);
        this.BVk = paramMotionEvent.getY();
        if (this.BVk >= getPaddingTop() + this.oSu) {
          break label816;
        }
        this.BVk = (getPaddingTop() + this.oSu);
      }
      for (;;)
      {
        if (j != 0)
        {
          this.BUV.union(this.BUU);
          invalidate(this.BUV);
          this.BUV.set(this.BUU);
        }
        AppMethodBeat.o(129878);
        return true;
        if (this.BVj <= getPaddingLeft() + getWidth() - getPaddingRight() - this.oSu) {
          break;
        }
        this.BVj = (getPaddingLeft() + getWidth() - getPaddingRight() - this.oSu);
        break;
        label816:
        if (this.BVk > getPaddingTop() + getHeight() - getPaddingRight() - this.oSu) {
          this.BVk = (getPaddingTop() + getHeight() - getPaddingBottom() - this.oSu);
        }
      }
      if (this.mrH)
      {
        this.mrH = false;
        evR();
        if (this.BVo != null) {
          this.BVo.a(this);
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
    this.BVc = paramBoolean;
    invalidate();
    AppMethodBeat.o(129879);
  }
  
  public void setDisplayMode(b paramb)
  {
    AppMethodBeat.i(129886);
    switch (1.BVp[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.BVe = paramb;
      invalidate();
      AppMethodBeat.o(129886);
      return;
      this.pJI = getResources().getColor(2131100460);
      continue;
      this.pJI = getResources().getColor(2131100463);
      continue;
      if (this.BUW.size() == 0)
      {
        paramb = new IllegalStateException("You should set a pattern before animating.");
        AppMethodBeat.o(129886);
        throw paramb;
      }
      this.BVd = false;
      this.pJI = getResources().getColor(2131100460);
      com.tencent.mm.plugin.walletlock.gesture.a.f localf = (com.tencent.mm.plugin.walletlock.gesture.a.f)this.BUW.get(0);
      this.BVj = TX(localf.BUl);
      this.BVk = TY(localf.BUk);
      evQ();
      this.BVl = SystemClock.elapsedRealtime();
    }
  }
  
  public void setEnableHapticFeedback(boolean paramBoolean)
  {
    this.BVb = paramBoolean;
  }
  
  public void setEnableInput(boolean paramBoolean)
  {
    this.BVd = paramBoolean;
  }
  
  public void setOnPatternListener(a parama)
  {
    this.BVo = parama;
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean BVb;
    boolean BVc;
    boolean BVd;
    String BVu;
    int BVv;
    
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
      this.BVu = paramParcel.readString();
      this.BVv = paramParcel.readInt();
      this.BVc = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.BVd = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.BVb = ((Boolean)paramParcel.readValue(null)).booleanValue();
      AppMethodBeat.o(129859);
    }
    
    public SavedState(Parcelable paramParcelable, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super();
      this.BVu = paramString;
      this.BVv = paramInt;
      this.BVc = paramBoolean1;
      this.BVd = paramBoolean2;
      this.BVb = paramBoolean3;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(129860);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.BVu);
      paramParcel.writeInt(this.BVv);
      paramParcel.writeValue(Boolean.valueOf(this.BVc));
      paramParcel.writeValue(Boolean.valueOf(this.BVd));
      paramParcel.writeValue(Boolean.valueOf(this.BVb));
      AppMethodBeat.o(129860);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(PatternLockView paramPatternLockView);
    
    public abstract void a(PatternLockView paramPatternLockView, List<com.tencent.mm.plugin.walletlock.gesture.a.f> paramList);
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(129857);
      BVq = new b("Correct", 0);
      BVr = new b("Wrong", 1);
      BVs = new b("Animate", 2);
      BVt = new b[] { BVq, BVr, BVs };
      AppMethodBeat.o(129857);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView
 * JD-Core Version:    0.7.0.1
 */