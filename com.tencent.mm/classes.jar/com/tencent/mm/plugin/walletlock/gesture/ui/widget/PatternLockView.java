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
import com.tencent.mm.sdk.platformtools.h;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView
  extends View
{
  private Paint DMP;
  private Paint DMQ;
  private Path DMR;
  private Matrix DMS;
  private Rect DMT;
  private Rect DMU;
  private ArrayList<f> DMV;
  private boolean[][] DMW;
  private PatternLockView.c DMX;
  private int DMY;
  private float DMZ;
  private boolean DNa;
  private boolean DNb;
  private boolean DNc;
  private b DNd;
  private Bitmap DNe;
  private Bitmap DNf;
  private Bitmap DNg;
  private Bitmap DNh;
  private float DNi;
  private float DNj;
  private long DNk;
  private float DNl;
  private float DNm;
  private a DNn;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private boolean mXw;
  private int pCI;
  private int qtS;
  
  public PatternLockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(129865);
    this.DMP = new Paint();
    this.DMQ = new Paint();
    this.DMR = new Path();
    this.DMS = new Matrix();
    this.DMT = new Rect();
    this.DMU = new Rect();
    this.DMV = new ArrayList(9);
    this.DMW = ((boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 }));
    this.DMX = PatternLockView.c.DNv;
    this.pCI = 6;
    this.DMY = 200;
    this.DMZ = 0.66F;
    this.DNa = false;
    this.DNb = true;
    this.DNc = false;
    int i;
    if (isInEditMode())
    {
      i = -1;
      this.qtS = i;
      this.DNd = b.DNp;
      this.DNe = null;
      this.DNf = null;
      this.DNg = null;
      this.DNh = null;
      this.DNi = -1.0F;
      this.DNj = -1.0F;
      this.mXw = false;
      this.DNk = 0L;
      this.mBitmapWidth = 0;
      this.mBitmapHeight = 0;
      this.DNl = 0.0F;
      this.DNm = 0.0F;
      this.DNn = null;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.mm_patternlock_view);
      this.DNb = paramContext.getBoolean(4, this.DNb);
      this.DMY = paramContext.getInt(1, this.DMY);
      this.pCI = paramContext.getInt(2, this.pCI);
      this.DNa = paramContext.getBoolean(0, this.DNa);
      switch (paramContext.getInt(3, this.DMX.ordinal()))
      {
      default: 
        this.DMX = PatternLockView.c.DNv;
      }
    }
    for (;;)
    {
      paramContext.recycle();
      setClickable(true);
      this.DMQ.setStyle(Paint.Style.STROKE);
      this.DMQ.setStrokeJoin(Paint.Join.ROUND);
      this.DMQ.setStrokeCap(Paint.Cap.ROUND);
      this.DMQ.setAntiAlias(true);
      this.DMQ.setDither(false);
      this.DMQ.setAlpha(this.DMY);
      this.DMP.setAntiAlias(true);
      this.DMP.setDither(true);
      if (isInEditMode()) {
        break label646;
      }
      if (this.DNe == null)
      {
        this.DNe = drawable2Bitmap(a.l(getContext(), 2131232595));
        this.DNf = drawable2Bitmap(a.l(getContext(), 2131232596));
        this.DNg = this.DNf;
        this.DNh = drawable2Bitmap(a.l(getContext(), 2131232597));
      }
      this.pCI = ((int)(this.pCI * h.aRe().density));
      paramContext = this.DNe;
      paramAttributeSet = this.DNf;
      Bitmap localBitmap1 = this.DNg;
      Bitmap localBitmap2 = this.DNh;
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
      this.DMX = PatternLockView.c.DNv;
      continue;
      this.DMX = PatternLockView.c.DNw;
    }
    label646:
    AppMethodBeat.o(129865);
  }
  
  private float Ww(int paramInt)
  {
    AppMethodBeat.i(129880);
    float f1 = getPaddingLeft();
    float f2 = paramInt;
    float f3 = this.DNl;
    float f4 = this.DNl;
    AppMethodBeat.o(129880);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private float Wx(int paramInt)
  {
    AppMethodBeat.i(129881);
    float f1 = getPaddingTop();
    float f2 = paramInt;
    float f3 = this.DNm;
    float f4 = this.DNm;
    AppMethodBeat.o(129881);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(129876);
    Bitmap localBitmap;
    if ((!paramBoolean) || ((!this.DNb) && (this.DNd != b.DNq))) {
      localBitmap = this.DNe;
    }
    for (;;)
    {
      int j = this.mBitmapWidth;
      int i = this.mBitmapHeight;
      float f1 = this.DNl;
      float f2 = this.DNm;
      j = (int)((f1 - j) * 0.5F);
      i = (int)((f2 - i) * 0.5F);
      f2 = getResources().getDisplayMetrics().density;
      f1 = Math.min((this.DNl - 33.0F * f2) / this.mBitmapWidth, 1.0F);
      f2 = Math.min((this.DNm - f2 * 33.0F) / this.mBitmapHeight, 1.0F);
      this.DMS.setTranslate(j + paramInt1, i + paramInt2);
      this.DMS.preTranslate(this.mBitmapWidth / 2, this.mBitmapHeight / 2);
      this.DMS.preScale(f1, f2);
      this.DMS.preTranslate(-this.mBitmapWidth / 2, -this.mBitmapHeight / 2);
      if (!isInEditMode()) {
        paramCanvas.drawBitmap(localBitmap, this.DMS, this.DMP);
      }
      AppMethodBeat.o(129876);
      return;
      if (this.mXw)
      {
        localBitmap = this.DNf;
      }
      else if (this.DNd == b.DNq)
      {
        localBitmap = this.DNh;
      }
      else
      {
        if ((this.DNd != b.DNp) && (this.DNd != b.DNr)) {
          break;
        }
        localBitmap = this.DNg;
      }
    }
    paramCanvas = new IllegalStateException("unknown display mode " + this.DNd);
    AppMethodBeat.o(129876);
    throw paramCanvas;
  }
  
  private void a(b paramb, List<f> paramList)
  {
    AppMethodBeat.i(129883);
    this.DMV.clear();
    eNE();
    this.DMV.addAll(paramList);
    paramList = this.DMV.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      this.DMW[localf.DMj][localf.DMk] = 1;
    }
    setDisplayMode(paramb);
    AppMethodBeat.o(129883);
  }
  
  private f ai(float paramFloat1, float paramFloat2)
  {
    int k = 0;
    AppMethodBeat.i(129877);
    Object localObject2 = null;
    float f1 = this.DNm;
    float f2 = f1 * this.DMZ;
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
          paramFloat2 = this.DNl;
          f1 = this.DMZ * paramFloat2;
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
        if (this.DMW[j][i] == 0) {
          localObject1 = f.iQ(j, i);
        }
      }
      if (localObject1 == null) {
        break label296;
      }
      this.DMW[localObject1.DMj][localObject1.DMk] = 1;
      this.DMV.add(localObject1);
      if (this.DNn != null) {
        new ArrayList(this.DMV);
      }
      if (this.DNa) {
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
  
  private void eNE()
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        this.DMW[i][j] = 0;
        j += 1;
      }
      i += 1;
    }
  }
  
  private void eNF()
  {
    AppMethodBeat.i(129884);
    this.DMV.clear();
    eNE();
    this.DNd = b.DNp;
    invalidate();
    AppMethodBeat.o(129884);
  }
  
  private static String ha(List<f> paramList)
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
      int k = localf.DMj;
      arrayOfByte[i] = ((byte)(localf.DMk + k * 3));
      i += 1;
    }
    paramList = new String(arrayOfByte);
    AppMethodBeat.o(129867);
    return paramList;
  }
  
  private static int iR(int paramInt1, int paramInt2)
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
  
  public final void eNG()
  {
    AppMethodBeat.i(129885);
    eNF();
    if (this.DNn != null) {
      this.DNn.a(this);
    }
    AppMethodBeat.o(129885);
  }
  
  public boolean getDisplayLine()
  {
    return this.DNb;
  }
  
  public boolean getEnableHapticFeedback()
  {
    return this.DNa;
  }
  
  public boolean getEnableInput()
  {
    return this.DNc;
  }
  
  public List<f> getPattern()
  {
    AppMethodBeat.i(129882);
    ArrayList localArrayList = new ArrayList(this.DMV);
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
    ArrayList localArrayList = this.DMV;
    int m = localArrayList.size();
    boolean[][] arrayOfBoolean = this.DMW;
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
    if (this.DNd == b.DNr)
    {
      j = (int)(SystemClock.elapsedRealtime() - this.DNk) % ((m + 1) * 700);
      k = j / 700;
      eNE();
      i = 0;
      while (i < k)
      {
        localObject = (f)localArrayList.get(i);
        arrayOfBoolean[localObject.DMj][localObject.DMk] = 1;
        i += 1;
      }
      if ((k > 0) && (k < m))
      {
        i = 1;
        if (i != 0)
        {
          f1 = j % 700 / 700.0F;
          localObject = (f)localArrayList.get(k - 1);
          f2 = Ww(((f)localObject).DMk);
          f3 = Wx(((f)localObject).DMj);
          localObject = (f)localArrayList.get(k);
          f4 = Ww(((f)localObject).DMk);
          f5 = Wx(((f)localObject).DMj);
          this.DNi = (f2 + (f4 - f2) * f1);
          this.DNj = ((f5 - f3) * f1 + f3);
        }
        invalidate();
      }
    }
    else
    {
      this.DMQ.setColor(this.qtS);
      this.DMQ.setStrokeWidth(this.pCI);
      localObject = this.DMR;
      ((Path)localObject).rewind();
      if ((!this.DNb) && (this.DNd != b.DNq)) {
        break label436;
      }
      i = 1;
      n = getPaddingTop();
      i1 = getPaddingLeft();
      f1 = this.DNl;
      f2 = this.DNm;
      if ((this.DMP.getFlags() & 0x2) == 0) {
        break label442;
      }
      bool = true;
      label335:
      this.DMP.setFilterBitmap(true);
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
        if (arrayOfBoolean[localf.DMj][localf.DMk] != 0)
        {
          j = 1;
          f3 = Ww(localf.DMk);
          f4 = Wx(localf.DMj);
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
      if (((this.mXw) || (this.DNd == b.DNr)) && (j != 0)) {
        ((Path)localObject).lineTo(this.DNi, this.DNj);
      }
      paramCanvas.drawPath((Path)localObject, this.DMQ);
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
    this.DMP.setFilterBitmap(bool);
    AppMethodBeat.o(129875);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129874);
    int j = getSuggestedMinimumWidth();
    int i = getSuggestedMinimumHeight();
    paramInt1 = iR(paramInt1, j);
    i = iR(paramInt2, i);
    if (this.DMX == PatternLockView.c.DNv) {
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
    b localb = b.DNp;
    Object localObject = paramParcelable.DNt;
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
      localArrayList.add(f.iQ(j / 3, j % 3));
      i += 1;
    }
    a(localb, localArrayList);
    this.DNd = b.values()[paramParcelable.DNu];
    this.DNb = paramParcelable.DNb;
    this.DNc = paramParcelable.DNc;
    this.DNa = paramParcelable.DNa;
    AppMethodBeat.o(129869);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(129868);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState(), ha(this.DMV), this.DNd.ordinal(), this.DNb, this.DNc, this.DNa);
    AppMethodBeat.o(129868);
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(129872);
    this.DNl = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.DNm = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
    AppMethodBeat.o(129872);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(129878);
    if ((!this.DNc) || (!isEnabled()))
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
      eNF();
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      paramMotionEvent = ai(f1, f2);
      if (paramMotionEvent != null)
      {
        this.mXw = true;
        this.DNd = b.DNp;
        if (this.DNn == null) {}
      }
      for (;;)
      {
        if (paramMotionEvent != null)
        {
          f3 = Ww(paramMotionEvent.DMk);
          f4 = Wx(paramMotionEvent.DMj);
          f5 = this.DNl * 0.5F;
          f6 = this.DNm * 0.5F;
          invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
        }
        this.DNi = f1;
        this.DNj = f2;
        AppMethodBeat.o(129878);
        return true;
        this.mXw = false;
      }
    case 1: 
      if (!this.DMV.isEmpty())
      {
        this.mXw = false;
        if (this.DNn != null) {
          this.DNn.a(this, new ArrayList(this.DMV));
        }
        invalidate();
      }
      AppMethodBeat.o(129878);
      return true;
    case 2: 
      float f7 = this.pCI;
      int k = paramMotionEvent.getHistorySize();
      this.DMT.setEmpty();
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
          f localf1 = ai(f1, f2);
          int m = this.DMV.size();
          if ((localf1 != null) && (m == 1)) {
            this.mXw = true;
          }
          f3 = Math.abs(f1 - this.DNi);
          f4 = Math.abs(f2 - this.DNj);
          if ((f3 > 0.0F) || (f4 > 0.0F)) {
            j = 1;
          }
          if ((this.mXw) && (m > 0))
          {
            f localf2 = (f)this.DMV.get(m - 1);
            f4 = Ww(localf2.DMk);
            f3 = Wx(localf2.DMj);
            f5 = Math.min(f4, f1) - f7;
            f4 = Math.max(f4, f1) + f7;
            f6 = Math.min(f3, f2) - f7;
            f3 = Math.max(f3, f2) + f7;
            if (localf1 == null) {
              break label912;
            }
            f2 = this.DNl * 0.5F;
            float f8 = this.DNm * 0.5F;
            float f10 = Ww(localf1.DMk);
            float f9 = Wx(localf1.DMj);
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
      this.DMT.union(Math.round(f1), Math.round(f2), Math.round(f4), Math.round(f3));
      i += 1;
      break;
      f1 = paramMotionEvent.getX();
      break label318;
      label630:
      f2 = paramMotionEvent.getY();
      break label332;
      this.DNi = paramMotionEvent.getX();
      if (this.DNi < getPaddingLeft() + this.pCI)
      {
        this.DNi = (getPaddingLeft() + this.pCI);
        this.DNj = paramMotionEvent.getY();
        if (this.DNj >= getPaddingTop() + this.pCI) {
          break label816;
        }
        this.DNj = (getPaddingTop() + this.pCI);
      }
      for (;;)
      {
        if (j != 0)
        {
          this.DMU.union(this.DMT);
          invalidate(this.DMU);
          this.DMU.set(this.DMT);
        }
        AppMethodBeat.o(129878);
        return true;
        if (this.DNi <= getPaddingLeft() + getWidth() - getPaddingRight() - this.pCI) {
          break;
        }
        this.DNi = (getPaddingLeft() + getWidth() - getPaddingRight() - this.pCI);
        break;
        label816:
        if (this.DNj > getPaddingTop() + getHeight() - getPaddingRight() - this.pCI) {
          this.DNj = (getPaddingTop() + getHeight() - getPaddingBottom() - this.pCI);
        }
      }
      if (this.mXw)
      {
        this.mXw = false;
        eNF();
        if (this.DNn != null) {
          this.DNn.a(this);
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
    this.DNb = paramBoolean;
    invalidate();
    AppMethodBeat.o(129879);
  }
  
  public void setDisplayMode(b paramb)
  {
    AppMethodBeat.i(129886);
    switch (1.DNo[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.DNd = paramb;
      invalidate();
      AppMethodBeat.o(129886);
      return;
      this.qtS = getResources().getColor(2131100460);
      continue;
      this.qtS = getResources().getColor(2131100463);
      continue;
      if (this.DMV.size() == 0)
      {
        paramb = new IllegalStateException("You should set a pattern before animating.");
        AppMethodBeat.o(129886);
        throw paramb;
      }
      this.DNc = false;
      this.qtS = getResources().getColor(2131100460);
      f localf = (f)this.DMV.get(0);
      this.DNi = Ww(localf.DMk);
      this.DNj = Wx(localf.DMj);
      eNE();
      this.DNk = SystemClock.elapsedRealtime();
    }
  }
  
  public void setEnableHapticFeedback(boolean paramBoolean)
  {
    this.DNa = paramBoolean;
  }
  
  public void setEnableInput(boolean paramBoolean)
  {
    this.DNc = paramBoolean;
  }
  
  public void setOnPatternListener(a parama)
  {
    this.DNn = parama;
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean DNa;
    boolean DNb;
    boolean DNc;
    String DNt;
    int DNu;
    
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
      this.DNt = paramParcel.readString();
      this.DNu = paramParcel.readInt();
      this.DNb = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.DNc = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.DNa = ((Boolean)paramParcel.readValue(null)).booleanValue();
      AppMethodBeat.o(129859);
    }
    
    public SavedState(Parcelable paramParcelable, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super();
      this.DNt = paramString;
      this.DNu = paramInt;
      this.DNb = paramBoolean1;
      this.DNc = paramBoolean2;
      this.DNa = paramBoolean3;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(129860);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.DNt);
      paramParcel.writeInt(this.DNu);
      paramParcel.writeValue(Boolean.valueOf(this.DNb));
      paramParcel.writeValue(Boolean.valueOf(this.DNc));
      paramParcel.writeValue(Boolean.valueOf(this.DNa));
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
      DNp = new b("Correct", 0);
      DNq = new b("Wrong", 1);
      DNr = new b("Animate", 2);
      DNs = new b[] { DNp, DNq, DNr };
      AppMethodBeat.o(129857);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView
 * JD-Core Version:    0.7.0.1
 */