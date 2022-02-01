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
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.sdk.platformtools.g;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView
  extends View
{
  private Bitmap DvA;
  private Bitmap DvB;
  private Bitmap DvC;
  private float DvD;
  private float DvE;
  private long DvF;
  private float DvG;
  private float DvH;
  private a DvI;
  private Paint Dvk;
  private Paint Dvl;
  private Path Dvm;
  private Matrix Dvn;
  private Rect Dvo;
  private Rect Dvp;
  private ArrayList<f> Dvq;
  private boolean[][] Dvr;
  private PatternLockView.c Dvs;
  private int Dvt;
  private float Dvu;
  private boolean Dvv;
  private boolean Dvw;
  private boolean Dvx;
  private b Dvy;
  private Bitmap Dvz;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private boolean mSm;
  private int pwe;
  private int qnn;
  
  public PatternLockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(129865);
    this.Dvk = new Paint();
    this.Dvl = new Paint();
    this.Dvm = new Path();
    this.Dvn = new Matrix();
    this.Dvo = new Rect();
    this.Dvp = new Rect();
    this.Dvq = new ArrayList(9);
    this.Dvr = ((boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 }));
    this.Dvs = PatternLockView.c.DvQ;
    this.pwe = 6;
    this.Dvt = 200;
    this.Dvu = 0.66F;
    this.Dvv = false;
    this.Dvw = true;
    this.Dvx = false;
    int i;
    if (isInEditMode())
    {
      i = -1;
      this.qnn = i;
      this.Dvy = b.DvK;
      this.Dvz = null;
      this.DvA = null;
      this.DvB = null;
      this.DvC = null;
      this.DvD = -1.0F;
      this.DvE = -1.0F;
      this.mSm = false;
      this.DvF = 0L;
      this.mBitmapWidth = 0;
      this.mBitmapHeight = 0;
      this.DvG = 0.0F;
      this.DvH = 0.0F;
      this.DvI = null;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.mm_patternlock_view);
      this.Dvw = paramContext.getBoolean(4, this.Dvw);
      this.Dvt = paramContext.getInt(1, this.Dvt);
      this.pwe = paramContext.getInt(2, this.pwe);
      this.Dvv = paramContext.getBoolean(0, this.Dvv);
      switch (paramContext.getInt(3, this.Dvs.ordinal()))
      {
      default: 
        this.Dvs = PatternLockView.c.DvQ;
      }
    }
    for (;;)
    {
      paramContext.recycle();
      setClickable(true);
      this.Dvl.setStyle(Paint.Style.STROKE);
      this.Dvl.setStrokeJoin(Paint.Join.ROUND);
      this.Dvl.setStrokeCap(Paint.Cap.ROUND);
      this.Dvl.setAntiAlias(true);
      this.Dvl.setDither(false);
      this.Dvl.setAlpha(this.Dvt);
      this.Dvk.setAntiAlias(true);
      this.Dvk.setDither(true);
      if (isInEditMode()) {
        break label646;
      }
      if (this.Dvz == null)
      {
        this.Dvz = drawable2Bitmap(a.l(getContext(), 2131232595));
        this.DvA = drawable2Bitmap(a.l(getContext(), 2131232596));
        this.DvB = this.DvA;
        this.DvC = drawable2Bitmap(a.l(getContext(), 2131232597));
      }
      this.pwe = ((int)(this.pwe * g.aQF().density));
      paramContext = this.Dvz;
      paramAttributeSet = this.DvA;
      Bitmap localBitmap1 = this.DvB;
      Bitmap localBitmap2 = this.DvC;
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
      this.Dvs = PatternLockView.c.DvQ;
      continue;
      this.Dvs = PatternLockView.c.DvR;
    }
    label646:
    AppMethodBeat.o(129865);
  }
  
  private float VP(int paramInt)
  {
    AppMethodBeat.i(129880);
    float f1 = getPaddingLeft();
    float f2 = paramInt;
    float f3 = this.DvG;
    float f4 = this.DvG;
    AppMethodBeat.o(129880);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private float VQ(int paramInt)
  {
    AppMethodBeat.i(129881);
    float f1 = getPaddingTop();
    float f2 = paramInt;
    float f3 = this.DvH;
    float f4 = this.DvH;
    AppMethodBeat.o(129881);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(129876);
    Bitmap localBitmap;
    if ((!paramBoolean) || ((!this.Dvw) && (this.Dvy != b.DvL))) {
      localBitmap = this.Dvz;
    }
    for (;;)
    {
      int j = this.mBitmapWidth;
      int i = this.mBitmapHeight;
      float f1 = this.DvG;
      float f2 = this.DvH;
      j = (int)((f1 - j) * 0.5F);
      i = (int)((f2 - i) * 0.5F);
      f2 = getResources().getDisplayMetrics().density;
      f1 = Math.min((this.DvG - 33.0F * f2) / this.mBitmapWidth, 1.0F);
      f2 = Math.min((this.DvH - f2 * 33.0F) / this.mBitmapHeight, 1.0F);
      this.Dvn.setTranslate(j + paramInt1, i + paramInt2);
      this.Dvn.preTranslate(this.mBitmapWidth / 2, this.mBitmapHeight / 2);
      this.Dvn.preScale(f1, f2);
      this.Dvn.preTranslate(-this.mBitmapWidth / 2, -this.mBitmapHeight / 2);
      if (!isInEditMode()) {
        paramCanvas.drawBitmap(localBitmap, this.Dvn, this.Dvk);
      }
      AppMethodBeat.o(129876);
      return;
      if (this.mSm)
      {
        localBitmap = this.DvA;
      }
      else if (this.Dvy == b.DvL)
      {
        localBitmap = this.DvC;
      }
      else
      {
        if ((this.Dvy != b.DvK) && (this.Dvy != b.DvM)) {
          break;
        }
        localBitmap = this.DvB;
      }
    }
    paramCanvas = new IllegalStateException("unknown display mode " + this.Dvy);
    AppMethodBeat.o(129876);
    throw paramCanvas;
  }
  
  private void a(b paramb, List<f> paramList)
  {
    AppMethodBeat.i(129883);
    this.Dvq.clear();
    eJW();
    this.Dvq.addAll(paramList);
    paramList = this.Dvq.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      this.Dvr[localf.DuE][localf.DuF] = 1;
    }
    setDisplayMode(paramb);
    AppMethodBeat.o(129883);
  }
  
  private f ai(float paramFloat1, float paramFloat2)
  {
    int k = 0;
    AppMethodBeat.i(129877);
    Object localObject2 = null;
    float f1 = this.DvH;
    float f2 = f1 * this.Dvu;
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
          paramFloat2 = this.DvG;
          f1 = this.Dvu * paramFloat2;
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
        if (this.Dvr[j][i] == 0) {
          localObject1 = f.iM(j, i);
        }
      }
      if (localObject1 == null) {
        break label296;
      }
      this.Dvr[localObject1.DuE][localObject1.DuF] = 1;
      this.Dvq.add(localObject1);
      if (this.DvI != null) {
        new ArrayList(this.Dvq);
      }
      if (this.Dvv) {
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
  
  private void eJW()
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        this.Dvr[i][j] = 0;
        j += 1;
      }
      i += 1;
    }
  }
  
  private void eJX()
  {
    AppMethodBeat.i(129884);
    this.Dvq.clear();
    eJW();
    this.Dvy = b.DvK;
    invalidate();
    AppMethodBeat.o(129884);
  }
  
  private static String gQ(List<f> paramList)
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
      int k = localf.DuE;
      arrayOfByte[i] = ((byte)(localf.DuF + k * 3));
      i += 1;
    }
    paramList = new String(arrayOfByte);
    AppMethodBeat.o(129867);
    return paramList;
  }
  
  private static int iN(int paramInt1, int paramInt2)
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
  
  public final void eJY()
  {
    AppMethodBeat.i(129885);
    eJX();
    if (this.DvI != null) {
      this.DvI.a(this);
    }
    AppMethodBeat.o(129885);
  }
  
  public boolean getDisplayLine()
  {
    return this.Dvw;
  }
  
  public boolean getEnableHapticFeedback()
  {
    return this.Dvv;
  }
  
  public boolean getEnableInput()
  {
    return this.Dvx;
  }
  
  public List<f> getPattern()
  {
    AppMethodBeat.i(129882);
    ArrayList localArrayList = new ArrayList(this.Dvq);
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
    ArrayList localArrayList = this.Dvq;
    int m = localArrayList.size();
    boolean[][] arrayOfBoolean = this.Dvr;
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
    if (this.Dvy == b.DvM)
    {
      j = (int)(SystemClock.elapsedRealtime() - this.DvF) % ((m + 1) * 700);
      k = j / 700;
      eJW();
      i = 0;
      while (i < k)
      {
        localObject = (f)localArrayList.get(i);
        arrayOfBoolean[localObject.DuE][localObject.DuF] = 1;
        i += 1;
      }
      if ((k > 0) && (k < m))
      {
        i = 1;
        if (i != 0)
        {
          f1 = j % 700 / 700.0F;
          localObject = (f)localArrayList.get(k - 1);
          f2 = VP(((f)localObject).DuF);
          f3 = VQ(((f)localObject).DuE);
          localObject = (f)localArrayList.get(k);
          f4 = VP(((f)localObject).DuF);
          f5 = VQ(((f)localObject).DuE);
          this.DvD = (f2 + (f4 - f2) * f1);
          this.DvE = ((f5 - f3) * f1 + f3);
        }
        invalidate();
      }
    }
    else
    {
      this.Dvl.setColor(this.qnn);
      this.Dvl.setStrokeWidth(this.pwe);
      localObject = this.Dvm;
      ((Path)localObject).rewind();
      if ((!this.Dvw) && (this.Dvy != b.DvL)) {
        break label436;
      }
      i = 1;
      n = getPaddingTop();
      i1 = getPaddingLeft();
      f1 = this.DvG;
      f2 = this.DvH;
      if ((this.Dvk.getFlags() & 0x2) == 0) {
        break label442;
      }
      bool = true;
      label335:
      this.Dvk.setFilterBitmap(true);
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
        if (arrayOfBoolean[localf.DuE][localf.DuF] != 0)
        {
          j = 1;
          f3 = VP(localf.DuF);
          f4 = VQ(localf.DuE);
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
      if (((this.mSm) || (this.Dvy == b.DvM)) && (j != 0)) {
        ((Path)localObject).lineTo(this.DvD, this.DvE);
      }
      paramCanvas.drawPath((Path)localObject, this.Dvl);
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
    this.Dvk.setFilterBitmap(bool);
    AppMethodBeat.o(129875);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129874);
    int j = getSuggestedMinimumWidth();
    int i = getSuggestedMinimumHeight();
    paramInt1 = iN(paramInt1, j);
    i = iN(paramInt2, i);
    if (this.Dvs == PatternLockView.c.DvQ) {
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
    b localb = b.DvK;
    Object localObject = paramParcelable.DvO;
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
      localArrayList.add(f.iM(j / 3, j % 3));
      i += 1;
    }
    a(localb, localArrayList);
    this.Dvy = b.values()[paramParcelable.DvP];
    this.Dvw = paramParcelable.Dvw;
    this.Dvx = paramParcelable.Dvx;
    this.Dvv = paramParcelable.Dvv;
    AppMethodBeat.o(129869);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(129868);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState(), gQ(this.Dvq), this.Dvy.ordinal(), this.Dvw, this.Dvx, this.Dvv);
    AppMethodBeat.o(129868);
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(129872);
    this.DvG = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.DvH = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
    AppMethodBeat.o(129872);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(129878);
    if ((!this.Dvx) || (!isEnabled()))
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
      eJX();
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      paramMotionEvent = ai(f1, f2);
      if (paramMotionEvent != null)
      {
        this.mSm = true;
        this.Dvy = b.DvK;
        if (this.DvI == null) {}
      }
      for (;;)
      {
        if (paramMotionEvent != null)
        {
          f3 = VP(paramMotionEvent.DuF);
          f4 = VQ(paramMotionEvent.DuE);
          f5 = this.DvG * 0.5F;
          f6 = this.DvH * 0.5F;
          invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
        }
        this.DvD = f1;
        this.DvE = f2;
        AppMethodBeat.o(129878);
        return true;
        this.mSm = false;
      }
    case 1: 
      if (!this.Dvq.isEmpty())
      {
        this.mSm = false;
        if (this.DvI != null) {
          this.DvI.a(this, new ArrayList(this.Dvq));
        }
        invalidate();
      }
      AppMethodBeat.o(129878);
      return true;
    case 2: 
      float f7 = this.pwe;
      int k = paramMotionEvent.getHistorySize();
      this.Dvo.setEmpty();
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
          int m = this.Dvq.size();
          if ((localf1 != null) && (m == 1)) {
            this.mSm = true;
          }
          f3 = Math.abs(f1 - this.DvD);
          f4 = Math.abs(f2 - this.DvE);
          if ((f3 > 0.0F) || (f4 > 0.0F)) {
            j = 1;
          }
          if ((this.mSm) && (m > 0))
          {
            f localf2 = (f)this.Dvq.get(m - 1);
            f4 = VP(localf2.DuF);
            f3 = VQ(localf2.DuE);
            f5 = Math.min(f4, f1) - f7;
            f4 = Math.max(f4, f1) + f7;
            f6 = Math.min(f3, f2) - f7;
            f3 = Math.max(f3, f2) + f7;
            if (localf1 == null) {
              break label912;
            }
            f2 = this.DvG * 0.5F;
            float f8 = this.DvH * 0.5F;
            float f10 = VP(localf1.DuF);
            float f9 = VQ(localf1.DuE);
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
      this.Dvo.union(Math.round(f1), Math.round(f2), Math.round(f4), Math.round(f3));
      i += 1;
      break;
      f1 = paramMotionEvent.getX();
      break label318;
      label630:
      f2 = paramMotionEvent.getY();
      break label332;
      this.DvD = paramMotionEvent.getX();
      if (this.DvD < getPaddingLeft() + this.pwe)
      {
        this.DvD = (getPaddingLeft() + this.pwe);
        this.DvE = paramMotionEvent.getY();
        if (this.DvE >= getPaddingTop() + this.pwe) {
          break label816;
        }
        this.DvE = (getPaddingTop() + this.pwe);
      }
      for (;;)
      {
        if (j != 0)
        {
          this.Dvp.union(this.Dvo);
          invalidate(this.Dvp);
          this.Dvp.set(this.Dvo);
        }
        AppMethodBeat.o(129878);
        return true;
        if (this.DvD <= getPaddingLeft() + getWidth() - getPaddingRight() - this.pwe) {
          break;
        }
        this.DvD = (getPaddingLeft() + getWidth() - getPaddingRight() - this.pwe);
        break;
        label816:
        if (this.DvE > getPaddingTop() + getHeight() - getPaddingRight() - this.pwe) {
          this.DvE = (getPaddingTop() + getHeight() - getPaddingBottom() - this.pwe);
        }
      }
      if (this.mSm)
      {
        this.mSm = false;
        eJX();
        if (this.DvI != null) {
          this.DvI.a(this);
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
    this.Dvw = paramBoolean;
    invalidate();
    AppMethodBeat.o(129879);
  }
  
  public void setDisplayMode(b paramb)
  {
    AppMethodBeat.i(129886);
    switch (1.DvJ[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.Dvy = paramb;
      invalidate();
      AppMethodBeat.o(129886);
      return;
      this.qnn = getResources().getColor(2131100460);
      continue;
      this.qnn = getResources().getColor(2131100463);
      continue;
      if (this.Dvq.size() == 0)
      {
        paramb = new IllegalStateException("You should set a pattern before animating.");
        AppMethodBeat.o(129886);
        throw paramb;
      }
      this.Dvx = false;
      this.qnn = getResources().getColor(2131100460);
      f localf = (f)this.Dvq.get(0);
      this.DvD = VP(localf.DuF);
      this.DvE = VQ(localf.DuE);
      eJW();
      this.DvF = SystemClock.elapsedRealtime();
    }
  }
  
  public void setEnableHapticFeedback(boolean paramBoolean)
  {
    this.Dvv = paramBoolean;
  }
  
  public void setEnableInput(boolean paramBoolean)
  {
    this.Dvx = paramBoolean;
  }
  
  public void setOnPatternListener(a parama)
  {
    this.DvI = parama;
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    String DvO;
    int DvP;
    boolean Dvv;
    boolean Dvw;
    boolean Dvx;
    
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
      this.DvO = paramParcel.readString();
      this.DvP = paramParcel.readInt();
      this.Dvw = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.Dvx = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.Dvv = ((Boolean)paramParcel.readValue(null)).booleanValue();
      AppMethodBeat.o(129859);
    }
    
    public SavedState(Parcelable paramParcelable, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super();
      this.DvO = paramString;
      this.DvP = paramInt;
      this.Dvw = paramBoolean1;
      this.Dvx = paramBoolean2;
      this.Dvv = paramBoolean3;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(129860);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.DvO);
      paramParcel.writeInt(this.DvP);
      paramParcel.writeValue(Boolean.valueOf(this.Dvw));
      paramParcel.writeValue(Boolean.valueOf(this.Dvx));
      paramParcel.writeValue(Boolean.valueOf(this.Dvv));
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
      DvK = new b("Correct", 0);
      DvL = new b("Wrong", 1);
      DvM = new b("Animate", 2);
      DvN = new b[] { DvK, DvL, DvM };
      AppMethodBeat.o(129857);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView
 * JD-Core Version:    0.7.0.1
 */