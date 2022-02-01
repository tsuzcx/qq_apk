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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.c;
import com.tencent.mm.plugin.walletlock.a.h;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView
  extends View
{
  private Bitmap PqA;
  private Bitmap PqB;
  private float PqC;
  private float PqD;
  private long PqE;
  private float PqF;
  private float PqG;
  private a PqH;
  private Paint Pqj;
  private Paint Pqk;
  private Path Pql;
  private Matrix Pqm;
  private Rect Pqn;
  private Rect Pqo;
  private ArrayList<f> Pqp;
  private boolean[][] Pqq;
  private PatternLockView.c Pqr;
  private int Pqs;
  private float Pqt;
  private boolean Pqu;
  private boolean Pqv;
  private boolean Pqw;
  private b Pqx;
  private Bitmap Pqy;
  private Bitmap Pqz;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private boolean rmR;
  private int uug;
  private int vqJ;
  
  public PatternLockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(129865);
    this.Pqj = new Paint();
    this.Pqk = new Paint();
    this.Pql = new Path();
    this.Pqm = new Matrix();
    this.Pqn = new Rect();
    this.Pqo = new Rect();
    this.Pqp = new ArrayList(9);
    this.Pqq = ((boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 }));
    this.Pqr = PatternLockView.c.PqP;
    this.uug = 6;
    this.Pqs = 200;
    this.Pqt = 0.66F;
    this.Pqu = false;
    this.Pqv = true;
    this.Pqw = false;
    int i;
    if (isInEditMode())
    {
      i = -1;
      this.vqJ = i;
      this.Pqx = b.PqJ;
      this.Pqy = null;
      this.Pqz = null;
      this.PqA = null;
      this.PqB = null;
      this.PqC = -1.0F;
      this.PqD = -1.0F;
      this.rmR = false;
      this.PqE = 0L;
      this.mBitmapWidth = 0;
      this.mBitmapHeight = 0;
      this.PqF = 0.0F;
      this.PqG = 0.0F;
      this.PqH = null;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.h.PoY);
      this.Pqv = paramContext.getBoolean(a.h.Ppd, this.Pqv);
      this.Pqs = paramContext.getInt(a.h.Ppa, this.Pqs);
      this.uug = paramContext.getInt(a.h.Ppb, this.uug);
      this.Pqu = paramContext.getBoolean(a.h.PoZ, this.Pqu);
      switch (paramContext.getInt(a.h.Ppc, this.Pqr.ordinal()))
      {
      default: 
        this.Pqr = PatternLockView.c.PqP;
      }
    }
    for (;;)
    {
      paramContext.recycle();
      setClickable(true);
      this.Pqk.setStyle(Paint.Style.STROKE);
      this.Pqk.setStrokeJoin(Paint.Join.ROUND);
      this.Pqk.setStrokeCap(Paint.Cap.ROUND);
      this.Pqk.setAntiAlias(true);
      this.Pqk.setDither(false);
      this.Pqk.setAlpha(this.Pqs);
      this.Pqj.setAntiAlias(true);
      this.Pqj.setDither(true);
      if (isInEditMode()) {
        break label655;
      }
      if (this.Pqy == null)
      {
        this.Pqy = drawable2Bitmap(a.m(getContext(), a.c.PnN));
        this.Pqz = drawable2Bitmap(a.m(getContext(), a.c.PnO));
        this.PqA = this.Pqz;
        this.PqB = drawable2Bitmap(a.m(getContext(), a.c.PnP));
      }
      this.uug = ((int)(this.uug * BitmapUtil.getDefaultDisplayMetrics().density));
      paramContext = this.Pqy;
      paramAttributeSet = this.Pqz;
      Bitmap localBitmap1 = this.PqA;
      Bitmap localBitmap2 = this.PqB;
      i = 0;
      while (i < 4)
      {
        Bitmap localBitmap3 = new Bitmap[] { paramContext, paramAttributeSet, localBitmap1, localBitmap2 }[i];
        this.mBitmapWidth = Math.max(localBitmap3.getWidth(), this.mBitmapWidth);
        this.mBitmapHeight = Math.max(localBitmap3.getHeight(), this.mBitmapHeight);
        i += 1;
      }
      i = getResources().getColor(a.b.Brand);
      break;
      this.Pqr = PatternLockView.c.PqP;
      continue;
      this.Pqr = PatternLockView.c.PqQ;
    }
    label655:
    AppMethodBeat.o(129865);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(129876);
    Bitmap localBitmap;
    if ((!paramBoolean) || ((!this.Pqv) && (this.Pqx != b.PqK))) {
      localBitmap = this.Pqy;
    }
    for (;;)
    {
      int j = this.mBitmapWidth;
      int i = this.mBitmapHeight;
      float f1 = this.PqF;
      float f2 = this.PqG;
      j = (int)((f1 - j) * 0.5F);
      i = (int)((f2 - i) * 0.5F);
      f2 = getResources().getDisplayMetrics().density;
      f1 = Math.min((this.PqF - 33.0F * f2) / this.mBitmapWidth, 1.0F);
      f2 = Math.min((this.PqG - f2 * 33.0F) / this.mBitmapHeight, 1.0F);
      this.Pqm.setTranslate(j + paramInt1, i + paramInt2);
      this.Pqm.preTranslate(this.mBitmapWidth / 2, this.mBitmapHeight / 2);
      this.Pqm.preScale(f1, f2);
      this.Pqm.preTranslate(-this.mBitmapWidth / 2, -this.mBitmapHeight / 2);
      if (!isInEditMode()) {
        paramCanvas.drawBitmap(localBitmap, this.Pqm, this.Pqj);
      }
      AppMethodBeat.o(129876);
      return;
      if (this.rmR)
      {
        localBitmap = this.Pqz;
      }
      else if (this.Pqx == b.PqK)
      {
        localBitmap = this.PqB;
      }
      else
      {
        if ((this.Pqx != b.PqJ) && (this.Pqx != b.PqL)) {
          break;
        }
        localBitmap = this.PqA;
      }
    }
    paramCanvas = new IllegalStateException("unknown display mode " + this.Pqx);
    AppMethodBeat.o(129876);
    throw paramCanvas;
  }
  
  private void a(b paramb, List<f> paramList)
  {
    AppMethodBeat.i(129883);
    this.Pqp.clear();
    gNT();
    this.Pqp.addAll(paramList);
    paramList = this.Pqp.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      this.Pqq[localf.PpD][localf.PpE] = 1;
    }
    setDisplayMode(paramb);
    AppMethodBeat.o(129883);
  }
  
  private float amQ(int paramInt)
  {
    AppMethodBeat.i(129880);
    float f1 = getPaddingLeft();
    float f2 = paramInt;
    float f3 = this.PqF;
    float f4 = this.PqF;
    AppMethodBeat.o(129880);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private float amR(int paramInt)
  {
    AppMethodBeat.i(129881);
    float f1 = getPaddingTop();
    float f2 = paramInt;
    float f3 = this.PqG;
    float f4 = this.PqG;
    AppMethodBeat.o(129881);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private f au(float paramFloat1, float paramFloat2)
  {
    int k = 0;
    AppMethodBeat.i(129877);
    Object localObject2 = null;
    float f1 = this.PqG;
    float f2 = f1 * this.Pqt;
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
          paramFloat2 = this.PqF;
          f1 = this.Pqt * paramFloat2;
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
        if (this.Pqq[j][i] == 0) {
          localObject1 = f.lm(j, i);
        }
      }
      if (localObject1 == null) {
        break label296;
      }
      this.Pqq[localObject1.PpD][localObject1.PpE] = 1;
      this.Pqp.add(localObject1);
      if (this.PqH != null) {
        new ArrayList(this.Pqp);
      }
      if (this.Pqu) {
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
  
  private void gNT()
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        this.Pqq[i][j] = 0;
        j += 1;
      }
      i += 1;
    }
  }
  
  private void gNU()
  {
    AppMethodBeat.i(129884);
    this.Pqp.clear();
    gNT();
    this.Pqx = b.PqJ;
    invalidate();
    AppMethodBeat.o(129884);
  }
  
  private static String iW(List<f> paramList)
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
      int k = localf.PpD;
      arrayOfByte[i] = ((byte)(localf.PpE + k * 3));
      i += 1;
    }
    paramList = new String(arrayOfByte);
    AppMethodBeat.o(129867);
    return paramList;
  }
  
  private static int ln(int paramInt1, int paramInt2)
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
  
  public final void gNV()
  {
    AppMethodBeat.i(129885);
    gNU();
    if (this.PqH != null) {
      this.PqH.a(this);
    }
    AppMethodBeat.o(129885);
  }
  
  public boolean getDisplayLine()
  {
    return this.Pqv;
  }
  
  public boolean getEnableHapticFeedback()
  {
    return this.Pqu;
  }
  
  public boolean getEnableInput()
  {
    return this.Pqw;
  }
  
  public List<f> getPattern()
  {
    AppMethodBeat.i(129882);
    ArrayList localArrayList = new ArrayList(this.Pqp);
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
    ArrayList localArrayList = this.Pqp;
    int m = localArrayList.size();
    boolean[][] arrayOfBoolean = this.Pqq;
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
    if (this.Pqx == b.PqL)
    {
      j = (int)(SystemClock.elapsedRealtime() - this.PqE) % ((m + 1) * 700);
      k = j / 700;
      gNT();
      i = 0;
      while (i < k)
      {
        localObject = (f)localArrayList.get(i);
        arrayOfBoolean[localObject.PpD][localObject.PpE] = 1;
        i += 1;
      }
      if ((k > 0) && (k < m))
      {
        i = 1;
        if (i != 0)
        {
          f1 = j % 700 / 700.0F;
          localObject = (f)localArrayList.get(k - 1);
          f2 = amQ(((f)localObject).PpE);
          f3 = amR(((f)localObject).PpD);
          localObject = (f)localArrayList.get(k);
          f4 = amQ(((f)localObject).PpE);
          f5 = amR(((f)localObject).PpD);
          this.PqC = (f2 + (f4 - f2) * f1);
          this.PqD = ((f5 - f3) * f1 + f3);
        }
        invalidate();
      }
    }
    else
    {
      this.Pqk.setColor(this.vqJ);
      this.Pqk.setStrokeWidth(this.uug);
      localObject = this.Pql;
      ((Path)localObject).rewind();
      if ((!this.Pqv) && (this.Pqx != b.PqK)) {
        break label436;
      }
      i = 1;
      n = getPaddingTop();
      i1 = getPaddingLeft();
      f1 = this.PqF;
      f2 = this.PqG;
      if ((this.Pqj.getFlags() & 0x2) == 0) {
        break label442;
      }
      bool = true;
      label335:
      this.Pqj.setFilterBitmap(true);
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
        if (arrayOfBoolean[localf.PpD][localf.PpE] != 0)
        {
          j = 1;
          f3 = amQ(localf.PpE);
          f4 = amR(localf.PpD);
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
      if (((this.rmR) || (this.Pqx == b.PqL)) && (j != 0)) {
        ((Path)localObject).lineTo(this.PqC, this.PqD);
      }
      paramCanvas.drawPath((Path)localObject, this.Pqk);
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
    this.Pqj.setFilterBitmap(bool);
    AppMethodBeat.o(129875);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129874);
    int j = getSuggestedMinimumWidth();
    int i = getSuggestedMinimumHeight();
    paramInt1 = ln(paramInt1, j);
    i = ln(paramInt2, i);
    if (this.Pqr == PatternLockView.c.PqP) {
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
    b localb = b.PqJ;
    Object localObject = paramParcelable.PqN;
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
      localArrayList.add(f.lm(j / 3, j % 3));
      i += 1;
    }
    a(localb, localArrayList);
    this.Pqx = b.values()[paramParcelable.PqO];
    this.Pqv = paramParcelable.Pqv;
    this.Pqw = paramParcelable.Pqw;
    this.Pqu = paramParcelable.Pqu;
    AppMethodBeat.o(129869);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(129868);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState(), iW(this.Pqp), this.Pqx.ordinal(), this.Pqv, this.Pqw, this.Pqu);
    AppMethodBeat.o(129868);
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(129872);
    this.PqF = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.PqG = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
    AppMethodBeat.o(129872);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(129878);
    if ((!this.Pqw) || (!isEnabled()))
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
      gNU();
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      paramMotionEvent = au(f1, f2);
      if (paramMotionEvent != null)
      {
        this.rmR = true;
        this.Pqx = b.PqJ;
        if (this.PqH == null) {}
      }
      for (;;)
      {
        if (paramMotionEvent != null)
        {
          f3 = amQ(paramMotionEvent.PpE);
          f4 = amR(paramMotionEvent.PpD);
          f5 = this.PqF * 0.5F;
          f6 = this.PqG * 0.5F;
          invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
        }
        this.PqC = f1;
        this.PqD = f2;
        AppMethodBeat.o(129878);
        return true;
        this.rmR = false;
      }
    case 1: 
      if (!this.Pqp.isEmpty())
      {
        this.rmR = false;
        if (this.PqH != null) {
          this.PqH.a(this, new ArrayList(this.Pqp));
        }
        invalidate();
      }
      AppMethodBeat.o(129878);
      return true;
    case 2: 
      float f7 = this.uug;
      int k = paramMotionEvent.getHistorySize();
      this.Pqn.setEmpty();
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
          f localf1 = au(f1, f2);
          int m = this.Pqp.size();
          if ((localf1 != null) && (m == 1)) {
            this.rmR = true;
          }
          f3 = Math.abs(f1 - this.PqC);
          f4 = Math.abs(f2 - this.PqD);
          if ((f3 > 0.0F) || (f4 > 0.0F)) {
            j = 1;
          }
          if ((this.rmR) && (m > 0))
          {
            f localf2 = (f)this.Pqp.get(m - 1);
            f4 = amQ(localf2.PpE);
            f3 = amR(localf2.PpD);
            f5 = Math.min(f4, f1) - f7;
            f4 = Math.max(f4, f1) + f7;
            f6 = Math.min(f3, f2) - f7;
            f3 = Math.max(f3, f2) + f7;
            if (localf1 == null) {
              break label912;
            }
            f2 = this.PqF * 0.5F;
            float f8 = this.PqG * 0.5F;
            float f10 = amQ(localf1.PpE);
            float f9 = amR(localf1.PpD);
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
      this.Pqn.union(Math.round(f1), Math.round(f2), Math.round(f4), Math.round(f3));
      i += 1;
      break;
      f1 = paramMotionEvent.getX();
      break label318;
      label630:
      f2 = paramMotionEvent.getY();
      break label332;
      this.PqC = paramMotionEvent.getX();
      if (this.PqC < getPaddingLeft() + this.uug)
      {
        this.PqC = (getPaddingLeft() + this.uug);
        this.PqD = paramMotionEvent.getY();
        if (this.PqD >= getPaddingTop() + this.uug) {
          break label816;
        }
        this.PqD = (getPaddingTop() + this.uug);
      }
      for (;;)
      {
        if (j != 0)
        {
          this.Pqo.union(this.Pqn);
          invalidate(this.Pqo);
          this.Pqo.set(this.Pqn);
        }
        AppMethodBeat.o(129878);
        return true;
        if (this.PqC <= getPaddingLeft() + getWidth() - getPaddingRight() - this.uug) {
          break;
        }
        this.PqC = (getPaddingLeft() + getWidth() - getPaddingRight() - this.uug);
        break;
        label816:
        if (this.PqD > getPaddingTop() + getHeight() - getPaddingRight() - this.uug) {
          this.PqD = (getPaddingTop() + getHeight() - getPaddingBottom() - this.uug);
        }
      }
      if (this.rmR)
      {
        this.rmR = false;
        gNU();
        if (this.PqH != null) {
          this.PqH.a(this);
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
    this.Pqv = paramBoolean;
    invalidate();
    AppMethodBeat.o(129879);
  }
  
  public void setDisplayMode(b paramb)
  {
    AppMethodBeat.i(129886);
    switch (1.PqI[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.Pqx = paramb;
      invalidate();
      AppMethodBeat.o(129886);
      return;
      this.vqJ = getResources().getColor(a.b.PnL);
      continue;
      this.vqJ = getResources().getColor(a.b.PnM);
      continue;
      if (this.Pqp.size() == 0)
      {
        paramb = new IllegalStateException("You should set a pattern before animating.");
        AppMethodBeat.o(129886);
        throw paramb;
      }
      this.Pqw = false;
      this.vqJ = getResources().getColor(a.b.PnL);
      f localf = (f)this.Pqp.get(0);
      this.PqC = amQ(localf.PpE);
      this.PqD = amR(localf.PpD);
      gNT();
      this.PqE = SystemClock.elapsedRealtime();
    }
  }
  
  public void setEnableHapticFeedback(boolean paramBoolean)
  {
    this.Pqu = paramBoolean;
  }
  
  public void setEnableInput(boolean paramBoolean)
  {
    this.Pqw = paramBoolean;
  }
  
  public void setOnPatternListener(a parama)
  {
    this.PqH = parama;
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    String PqN;
    int PqO;
    boolean Pqu;
    boolean Pqv;
    boolean Pqw;
    
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
      this.PqN = paramParcel.readString();
      this.PqO = paramParcel.readInt();
      this.Pqv = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.Pqw = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.Pqu = ((Boolean)paramParcel.readValue(null)).booleanValue();
      AppMethodBeat.o(129859);
    }
    
    public SavedState(Parcelable paramParcelable, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super();
      this.PqN = paramString;
      this.PqO = paramInt;
      this.Pqv = paramBoolean1;
      this.Pqw = paramBoolean2;
      this.Pqu = paramBoolean3;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(129860);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.PqN);
      paramParcel.writeInt(this.PqO);
      paramParcel.writeValue(Boolean.valueOf(this.Pqv));
      paramParcel.writeValue(Boolean.valueOf(this.Pqw));
      paramParcel.writeValue(Boolean.valueOf(this.Pqu));
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
      PqJ = new b("Correct", 0);
      PqK = new b("Wrong", 1);
      PqL = new b("Animate", 2);
      PqM = new b[] { PqJ, PqK, PqL };
      AppMethodBeat.o(129857);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView
 * JD-Core Version:    0.7.0.1
 */