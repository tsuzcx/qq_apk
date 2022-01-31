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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.walletlock.a.a;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView
  extends View
{
  private static Bitmap uFF = null;
  private static Bitmap uFG = null;
  private static Bitmap uFH = null;
  private static Bitmap uFI = null;
  private int Bg;
  private int Bh;
  private int lPM;
  private float uFA;
  private boolean uFB;
  private boolean uFC;
  private boolean uFD;
  private PatternLockView.b uFE;
  private float uFJ;
  private float uFK;
  private boolean uFL;
  private long uFM;
  private float uFN;
  private float uFO;
  private PatternLockView.a uFP;
  private Paint uFp;
  private Paint uFq;
  private Path uFr;
  private Matrix uFs;
  private Rect uFt;
  private Rect uFu;
  private ArrayList<f> uFv;
  private boolean[][] uFw;
  private PatternLockView.c uFx;
  private int uFy;
  private int uFz;
  
  public PatternLockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51660);
    this.uFp = new Paint();
    this.uFq = new Paint();
    this.uFr = new Path();
    this.uFs = new Matrix();
    this.uFt = new Rect();
    this.uFu = new Rect();
    this.uFv = new ArrayList(9);
    this.uFw = ((boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 }));
    this.uFx = PatternLockView.c.uFX;
    this.uFy = 6;
    this.uFz = 200;
    this.uFA = 0.66F;
    this.uFB = false;
    this.uFC = true;
    this.uFD = false;
    int i;
    if (isInEditMode())
    {
      i = -1;
      this.lPM = i;
      this.uFE = PatternLockView.b.uFR;
      this.uFJ = -1.0F;
      this.uFK = -1.0F;
      this.uFL = false;
      this.uFM = 0L;
      this.Bg = 0;
      this.Bh = 0;
      this.uFN = 0.0F;
      this.uFO = 0.0F;
      this.uFP = null;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.mm_patternlock_view);
      this.uFC = paramContext.getBoolean(4, this.uFC);
      this.uFz = paramContext.getInt(1, this.uFz);
      this.uFy = paramContext.getInt(2, this.uFy);
      this.uFB = paramContext.getBoolean(3, this.uFB);
      switch (paramContext.getInt(0, this.uFx.ordinal()))
      {
      default: 
        this.uFx = PatternLockView.c.uFX;
      }
    }
    for (;;)
    {
      paramContext.recycle();
      setClickable(true);
      this.uFq.setStyle(Paint.Style.STROKE);
      this.uFq.setStrokeJoin(Paint.Join.ROUND);
      this.uFq.setStrokeCap(Paint.Cap.ROUND);
      this.uFq.setAntiAlias(true);
      this.uFq.setDither(false);
      this.uFq.setAlpha(this.uFz);
      this.uFp.setAntiAlias(true);
      this.uFp.setDither(true);
      if (isInEditMode()) {
        break label616;
      }
      if (uFF == null)
      {
        uFF = t(a.k(getContext(), 2130839053));
        paramContext = t(a.k(getContext(), 2130839054));
        uFG = paramContext;
        uFH = paramContext;
        uFI = t(a.k(getContext(), 2130839055));
      }
      this.uFy = ((int)(this.uFy * d.aow().density));
      paramContext = uFF;
      paramAttributeSet = uFG;
      Bitmap localBitmap1 = uFH;
      Bitmap localBitmap2 = uFI;
      i = 0;
      while (i < 4)
      {
        Bitmap localBitmap3 = new Bitmap[] { paramContext, paramAttributeSet, localBitmap1, localBitmap2 }[i];
        this.Bg = Math.max(localBitmap3.getWidth(), this.Bg);
        this.Bh = Math.max(localBitmap3.getHeight(), this.Bh);
        i += 1;
      }
      i = getResources().getColor(2131690135);
      break;
      this.uFx = PatternLockView.c.uFX;
      continue;
      this.uFx = PatternLockView.c.uFY;
    }
    label616:
    AppMethodBeat.o(51660);
  }
  
  private float IO(int paramInt)
  {
    AppMethodBeat.i(51675);
    float f1 = getPaddingLeft();
    float f2 = paramInt;
    float f3 = this.uFN;
    float f4 = this.uFN;
    AppMethodBeat.o(51675);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private float IP(int paramInt)
  {
    AppMethodBeat.i(51676);
    float f1 = getPaddingTop();
    float f2 = paramInt;
    float f3 = this.uFO;
    float f4 = this.uFO;
    AppMethodBeat.o(51676);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(51671);
    Bitmap localBitmap;
    if ((!paramBoolean) || ((!this.uFC) && (this.uFE != PatternLockView.b.uFS))) {
      localBitmap = uFF;
    }
    for (;;)
    {
      int j = this.Bg;
      int i = this.Bh;
      float f1 = this.uFN;
      float f2 = this.uFO;
      j = (int)((f1 - j) * 0.5F);
      i = (int)((f2 - i) * 0.5F);
      f2 = getResources().getDisplayMetrics().density;
      f1 = Math.min((this.uFN - 33.0F * f2) / this.Bg, 1.0F);
      f2 = Math.min((this.uFO - f2 * 33.0F) / this.Bh, 1.0F);
      this.uFs.setTranslate(j + paramInt1, i + paramInt2);
      this.uFs.preTranslate(this.Bg / 2, this.Bh / 2);
      this.uFs.preScale(f1, f2);
      this.uFs.preTranslate(-this.Bg / 2, -this.Bh / 2);
      if (!isInEditMode()) {
        paramCanvas.drawBitmap(localBitmap, this.uFs, this.uFp);
      }
      AppMethodBeat.o(51671);
      return;
      if (this.uFL)
      {
        localBitmap = uFG;
      }
      else if (this.uFE == PatternLockView.b.uFS)
      {
        localBitmap = uFI;
      }
      else
      {
        if ((this.uFE != PatternLockView.b.uFR) && (this.uFE != PatternLockView.b.uFT)) {
          break;
        }
        localBitmap = uFH;
      }
    }
    paramCanvas = new IllegalStateException("unknown display mode " + this.uFE);
    AppMethodBeat.o(51671);
    throw paramCanvas;
  }
  
  private void a(PatternLockView.b paramb, List<f> paramList)
  {
    AppMethodBeat.i(51678);
    this.uFv.clear();
    cYc();
    this.uFv.addAll(paramList);
    paramList = this.uFv.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      this.uFw[localf.uEJ][localf.uEK] = 1;
    }
    setDisplayMode(paramb);
    AppMethodBeat.o(51678);
  }
  
  private f aj(float paramFloat1, float paramFloat2)
  {
    int k = 0;
    AppMethodBeat.i(51672);
    Object localObject2 = null;
    float f1 = this.uFO;
    float f2 = f1 * this.uFA;
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
          paramFloat2 = this.uFN;
          f1 = this.uFA * paramFloat2;
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
        if (this.uFw[j][i] == 0) {
          localObject1 = f.gA(j, i);
        }
      }
      if (localObject1 == null) {
        break label296;
      }
      this.uFw[localObject1.uEJ][localObject1.uEK] = 1;
      this.uFv.add(localObject1);
      if (this.uFP != null) {
        new ArrayList(this.uFv);
      }
      if (this.uFB) {
        performHapticFeedback(1, 3);
      }
      AppMethodBeat.o(51672);
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
    AppMethodBeat.o(51672);
    return null;
  }
  
  private void cYc()
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        this.uFw[i][j] = 0;
        j += 1;
      }
      i += 1;
    }
  }
  
  private void cYd()
  {
    AppMethodBeat.i(51679);
    this.uFv.clear();
    cYc();
    this.uFE = PatternLockView.b.uFR;
    invalidate();
    AppMethodBeat.o(51679);
  }
  
  private static String ed(List<f> paramList)
  {
    AppMethodBeat.i(51662);
    if (paramList == null)
    {
      paramList = new IllegalArgumentException("pattern is null");
      AppMethodBeat.o(51662);
      throw paramList;
    }
    int j = paramList.size();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      f localf = (f)paramList.get(i);
      int k = localf.uEJ;
      arrayOfByte[i] = ((byte)(localf.uEK + k * 3));
      i += 1;
    }
    paramList = new String(arrayOfByte);
    AppMethodBeat.o(51662);
    return paramList;
  }
  
  private static int gB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51668);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = paramInt2;
    switch (View.MeasureSpec.getMode(paramInt1))
    {
    }
    for (i = j;; i = Math.max(j, paramInt2))
    {
      AppMethodBeat.o(51668);
      return i;
    }
  }
  
  private static Bitmap t(Drawable paramDrawable)
  {
    AppMethodBeat.i(51661);
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.draw(localCanvas);
      AppMethodBeat.o(51661);
      return localObject;
    }
  }
  
  public final void cYe()
  {
    AppMethodBeat.i(51680);
    cYd();
    if (this.uFP != null) {
      this.uFP.a(this);
    }
    AppMethodBeat.o(51680);
  }
  
  public boolean getDisplayLine()
  {
    return this.uFC;
  }
  
  public boolean getEnableHapticFeedback()
  {
    return this.uFB;
  }
  
  public boolean getEnableInput()
  {
    return this.uFD;
  }
  
  public List<f> getPattern()
  {
    AppMethodBeat.i(51677);
    ArrayList localArrayList = new ArrayList(this.uFv);
    AppMethodBeat.o(51677);
    return localArrayList;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    AppMethodBeat.i(51666);
    float f = getResources().getDisplayMetrics().density;
    int i = (int)(3.0D * this.Bh / f);
    AppMethodBeat.o(51666);
    return i;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    AppMethodBeat.i(51665);
    float f = getResources().getDisplayMetrics().density;
    int i = (int)(3.0D * this.Bg / f);
    AppMethodBeat.o(51665);
    return i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51670);
    ArrayList localArrayList = this.uFv;
    int m = localArrayList.size();
    boolean[][] arrayOfBoolean = this.uFw;
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
    if (this.uFE == PatternLockView.b.uFT)
    {
      j = (int)(SystemClock.elapsedRealtime() - this.uFM) % ((m + 1) * 700);
      k = j / 700;
      cYc();
      i = 0;
      while (i < k)
      {
        localObject = (f)localArrayList.get(i);
        arrayOfBoolean[localObject.uEJ][localObject.uEK] = 1;
        i += 1;
      }
      if ((k > 0) && (k < m))
      {
        i = 1;
        if (i != 0)
        {
          f1 = j % 700 / 700.0F;
          localObject = (f)localArrayList.get(k - 1);
          f2 = IO(((f)localObject).uEK);
          f3 = IP(((f)localObject).uEJ);
          localObject = (f)localArrayList.get(k);
          f4 = IO(((f)localObject).uEK);
          f5 = IP(((f)localObject).uEJ);
          this.uFJ = (f2 + (f4 - f2) * f1);
          this.uFK = ((f5 - f3) * f1 + f3);
        }
        invalidate();
      }
    }
    else
    {
      this.uFq.setColor(this.lPM);
      this.uFq.setStrokeWidth(this.uFy);
      localObject = this.uFr;
      ((Path)localObject).rewind();
      if ((!this.uFC) && (this.uFE != PatternLockView.b.uFS)) {
        break label436;
      }
      i = 1;
      n = getPaddingTop();
      i1 = getPaddingLeft();
      f1 = this.uFN;
      f2 = this.uFO;
      if ((this.uFp.getFlags() & 0x2) == 0) {
        break label442;
      }
      bool = true;
      label335:
      this.uFp.setFilterBitmap(true);
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
        if (arrayOfBoolean[localf.uEJ][localf.uEK] != 0)
        {
          j = 1;
          f3 = IO(localf.uEK);
          f4 = IP(localf.uEJ);
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
      if (((this.uFL) || (this.uFE == PatternLockView.b.uFT)) && (j != 0)) {
        ((Path)localObject).lineTo(this.uFJ, this.uFK);
      }
      paramCanvas.drawPath((Path)localObject, this.uFq);
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
    this.uFp.setFilterBitmap(bool);
    AppMethodBeat.o(51670);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51669);
    int j = getSuggestedMinimumWidth();
    int i = getSuggestedMinimumHeight();
    paramInt1 = gB(paramInt1, j);
    i = gB(paramInt2, i);
    if (this.uFx == PatternLockView.c.uFX) {
      paramInt2 = Math.min(paramInt1, i);
    }
    for (paramInt1 = paramInt2;; paramInt1 = i)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      AppMethodBeat.o(51669);
      return;
      paramInt2 = paramInt1;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(51664);
    paramParcelable = (PatternLockView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    PatternLockView.b localb = PatternLockView.b.uFR;
    Object localObject = paramParcelable.uFV;
    if (localObject == null)
    {
      paramParcelable = new IllegalArgumentException("Serialized pattern is null");
      AppMethodBeat.o(51664);
      throw paramParcelable;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((String)localObject).getBytes();
    int i = 0;
    while (i < localObject.length)
    {
      int j = localObject[i];
      localArrayList.add(f.gA(j / 3, j % 3));
      i += 1;
    }
    a(localb, localArrayList);
    this.uFE = PatternLockView.b.values()[paramParcelable.uFW];
    this.uFC = paramParcelable.uFC;
    this.uFD = paramParcelable.uFD;
    this.uFB = paramParcelable.uFB;
    AppMethodBeat.o(51664);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(51663);
    PatternLockView.SavedState localSavedState = new PatternLockView.SavedState(super.onSaveInstanceState(), ed(this.uFv), this.uFE.ordinal(), this.uFC, this.uFD, this.uFB);
    AppMethodBeat.o(51663);
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(51667);
    this.uFN = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.uFO = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
    AppMethodBeat.o(51667);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(51673);
    if ((!this.uFD) || (!isEnabled()))
    {
      AppMethodBeat.o(51673);
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
      AppMethodBeat.o(51673);
      return false;
    case 0: 
      cYd();
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      paramMotionEvent = aj(f1, f2);
      if (paramMotionEvent != null)
      {
        this.uFL = true;
        this.uFE = PatternLockView.b.uFR;
        if (this.uFP == null) {}
      }
      for (;;)
      {
        if (paramMotionEvent != null)
        {
          f3 = IO(paramMotionEvent.uEK);
          f4 = IP(paramMotionEvent.uEJ);
          f5 = this.uFN * 0.5F;
          f6 = this.uFO * 0.5F;
          invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
        }
        this.uFJ = f1;
        this.uFK = f2;
        AppMethodBeat.o(51673);
        return true;
        this.uFL = false;
      }
    case 1: 
      if (!this.uFv.isEmpty())
      {
        this.uFL = false;
        if (this.uFP != null) {
          this.uFP.a(this, new ArrayList(this.uFv));
        }
        invalidate();
      }
      AppMethodBeat.o(51673);
      return true;
    case 2: 
      float f7 = this.uFy;
      int k = paramMotionEvent.getHistorySize();
      this.uFt.setEmpty();
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
          f localf1 = aj(f1, f2);
          int m = this.uFv.size();
          if ((localf1 != null) && (m == 1)) {
            this.uFL = true;
          }
          f3 = Math.abs(f1 - this.uFJ);
          f4 = Math.abs(f2 - this.uFK);
          if ((f3 > 0.0F) || (f4 > 0.0F)) {
            j = 1;
          }
          if ((this.uFL) && (m > 0))
          {
            f localf2 = (f)this.uFv.get(m - 1);
            f4 = IO(localf2.uEK);
            f3 = IP(localf2.uEJ);
            f5 = Math.min(f4, f1) - f7;
            f4 = Math.max(f4, f1) + f7;
            f6 = Math.min(f3, f2) - f7;
            f3 = Math.max(f3, f2) + f7;
            if (localf1 == null) {
              break label912;
            }
            f2 = this.uFN * 0.5F;
            float f8 = this.uFO * 0.5F;
            float f10 = IO(localf1.uEK);
            float f9 = IP(localf1.uEJ);
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
      this.uFt.union(Math.round(f1), Math.round(f2), Math.round(f4), Math.round(f3));
      i += 1;
      break;
      f1 = paramMotionEvent.getX();
      break label318;
      label630:
      f2 = paramMotionEvent.getY();
      break label332;
      this.uFJ = paramMotionEvent.getX();
      if (this.uFJ < getPaddingLeft() + this.uFy)
      {
        this.uFJ = (getPaddingLeft() + this.uFy);
        this.uFK = paramMotionEvent.getY();
        if (this.uFK >= getPaddingTop() + this.uFy) {
          break label816;
        }
        this.uFK = (getPaddingTop() + this.uFy);
      }
      for (;;)
      {
        if (j != 0)
        {
          this.uFu.union(this.uFt);
          invalidate(this.uFu);
          this.uFu.set(this.uFt);
        }
        AppMethodBeat.o(51673);
        return true;
        if (this.uFJ <= getPaddingLeft() + getWidth() - getPaddingRight() - this.uFy) {
          break;
        }
        this.uFJ = (getPaddingLeft() + getWidth() - getPaddingRight() - this.uFy);
        break;
        label816:
        if (this.uFK > getPaddingTop() + getHeight() - getPaddingRight() - this.uFy) {
          this.uFK = (getPaddingTop() + getHeight() - getPaddingBottom() - this.uFy);
        }
      }
      if (this.uFL)
      {
        this.uFL = false;
        cYd();
        if (this.uFP != null) {
          this.uFP.a(this);
        }
      }
      AppMethodBeat.o(51673);
      return true;
      label912:
      f2 = f6;
      f1 = f5;
    }
  }
  
  public void setDisplayLine(boolean paramBoolean)
  {
    AppMethodBeat.i(51674);
    this.uFC = paramBoolean;
    invalidate();
    AppMethodBeat.o(51674);
  }
  
  public void setDisplayMode(PatternLockView.b paramb)
  {
    AppMethodBeat.i(51681);
    switch (PatternLockView.1.uFQ[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.uFE = paramb;
      invalidate();
      AppMethodBeat.o(51681);
      return;
      this.lPM = getResources().getColor(2131690135);
      continue;
      this.lPM = getResources().getColor(2131690138);
      continue;
      if (this.uFv.size() == 0)
      {
        paramb = new IllegalStateException("You should set a pattern before animating.");
        AppMethodBeat.o(51681);
        throw paramb;
      }
      this.uFD = false;
      this.lPM = getResources().getColor(2131690135);
      f localf = (f)this.uFv.get(0);
      this.uFJ = IO(localf.uEK);
      this.uFK = IP(localf.uEJ);
      cYc();
      this.uFM = SystemClock.elapsedRealtime();
    }
  }
  
  public void setEnableHapticFeedback(boolean paramBoolean)
  {
    this.uFB = paramBoolean;
  }
  
  public void setEnableInput(boolean paramBoolean)
  {
    this.uFD = paramBoolean;
  }
  
  public void setOnPatternListener(PatternLockView.a parama)
  {
    this.uFP = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView
 * JD-Core Version:    0.7.0.1
 */