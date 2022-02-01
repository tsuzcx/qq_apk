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
import com.tencent.mm.cd.a;
import com.tencent.mm.ce.b;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.c;
import com.tencent.mm.plugin.walletlock.a.h;
import com.tencent.mm.plugin.walletlock.gesture.a.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView
  extends View
{
  private Paint WgW;
  private Paint WgX;
  private Path WgY;
  private Matrix WgZ;
  private Rect Wha;
  private Rect Whb;
  private ArrayList<h> Whc;
  private boolean[][] Whd;
  private PatternLockView.c Whe;
  private int Whf;
  private float Whg;
  private boolean Whh;
  private boolean Whi;
  private boolean Whj;
  private b Whk;
  private Bitmap Whl;
  private Bitmap Whm;
  private Bitmap Whn;
  private Bitmap Who;
  private float Whp;
  private float Whq;
  private long Whr;
  private float Whs;
  private float Wht;
  private a Whu;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private boolean uwK;
  private int xAD;
  private int yDa;
  
  public PatternLockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(129865);
    this.WgW = new Paint();
    this.WgX = new Paint();
    this.WgY = new Path();
    this.WgZ = new Matrix();
    this.Wha = new Rect();
    this.Whb = new Rect();
    this.Whc = new ArrayList(9);
    this.Whd = ((boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 }));
    this.Whe = PatternLockView.c.WhC;
    this.xAD = 6;
    this.Whf = 200;
    this.Whg = 0.66F;
    this.Whh = false;
    this.Whi = true;
    this.Whj = false;
    if (isInEditMode())
    {
      i = -1;
      this.yDa = i;
      this.Whk = b.Whw;
      this.Whl = null;
      this.Whm = null;
      this.Whn = null;
      this.Who = null;
      this.Whp = -1.0F;
      this.Whq = -1.0F;
      this.uwK = false;
      this.Whr = 0L;
      this.mBitmapWidth = 0;
      this.mBitmapHeight = 0;
      this.Whs = 0.0F;
      this.Wht = 0.0F;
      this.Whu = null;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.h.WfH);
      this.Whi = paramContext.getBoolean(a.h.WfM, this.Whi);
      this.Whf = paramContext.getInt(a.h.WfJ, this.Whf);
      this.xAD = paramContext.getInt(a.h.WfK, this.xAD);
      this.Whh = paramContext.getBoolean(a.h.WfI, this.Whh);
      switch (paramContext.getInt(a.h.WfL, this.Whe.ordinal()))
      {
      default: 
        this.Whe = PatternLockView.c.WhC;
        label355:
        paramContext.recycle();
        setClickable(true);
        this.WgX.setStyle(Paint.Style.STROKE);
        this.WgX.setStrokeJoin(Paint.Join.ROUND);
        this.WgX.setStrokeCap(Paint.Cap.ROUND);
        this.WgX.setAntiAlias(true);
        this.WgX.setDither(false);
        this.WgX.setAlpha(this.Whf);
        this.WgW.setAntiAlias(true);
        this.WgW.setDither(true);
        if (isInEditMode()) {
          break label689;
        }
        if (this.Whl == null)
        {
          this.Whl = drawable2Bitmap(a.m(getContext(), a.c.Wel));
          paramContext = getContext();
          if (!b.iRp()) {
            break label675;
          }
          i = a.c.Wen;
          label483:
          this.Whm = drawable2Bitmap(a.m(paramContext, i));
          this.Whn = this.Whm;
          paramContext = getContext();
          if (!b.iRp()) {
            break label682;
          }
        }
        break;
      }
    }
    label675:
    label682:
    for (int i = a.c.Wep;; i = a.c.Weo)
    {
      this.Who = drawable2Bitmap(a.m(paramContext, i));
      this.xAD = ((int)(this.xAD * BitmapUtil.getDefaultDisplayMetrics().density));
      paramContext = this.Whl;
      paramAttributeSet = this.Whm;
      Bitmap localBitmap1 = this.Whn;
      Bitmap localBitmap2 = this.Who;
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
      this.Whe = PatternLockView.c.WhC;
      break label355;
      this.Whe = PatternLockView.c.WhD;
      break label355;
      i = a.c.Wem;
      break label483;
    }
    label689:
    AppMethodBeat.o(129865);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(129876);
    Bitmap localBitmap;
    if ((!paramBoolean) || ((!this.Whi) && (this.Whk != b.Whx))) {
      localBitmap = this.Whl;
    }
    for (;;)
    {
      int j = this.mBitmapWidth;
      int i = this.mBitmapHeight;
      float f1 = this.Whs;
      float f2 = this.Wht;
      j = (int)((f1 - j) * 0.5F);
      i = (int)((f2 - i) * 0.5F);
      f2 = getResources().getDisplayMetrics().density;
      f1 = Math.min((this.Whs - 33.0F * f2) / this.mBitmapWidth, 1.0F);
      f2 = Math.min((this.Wht - f2 * 33.0F) / this.mBitmapHeight, 1.0F);
      this.WgZ.setTranslate(j + paramInt1, i + paramInt2);
      this.WgZ.preTranslate(this.mBitmapWidth / 2, this.mBitmapHeight / 2);
      this.WgZ.preScale(f1, f2);
      this.WgZ.preTranslate(-this.mBitmapWidth / 2, -this.mBitmapHeight / 2);
      if (!isInEditMode()) {
        paramCanvas.drawBitmap(localBitmap, this.WgZ, this.WgW);
      }
      AppMethodBeat.o(129876);
      return;
      if (this.uwK)
      {
        localBitmap = this.Whm;
      }
      else if (this.Whk == b.Whx)
      {
        localBitmap = this.Who;
      }
      else
      {
        if ((this.Whk != b.Whw) && (this.Whk != b.Why)) {
          break;
        }
        localBitmap = this.Whn;
      }
    }
    paramCanvas = new IllegalStateException("unknown display mode " + this.Whk);
    AppMethodBeat.o(129876);
    throw paramCanvas;
  }
  
  private void a(b paramb, List<h> paramList)
  {
    AppMethodBeat.i(129883);
    this.Whc.clear();
    ini();
    this.Whc.addAll(paramList);
    paramList = this.Whc.iterator();
    while (paramList.hasNext())
    {
      h localh = (h)paramList.next();
      this.Whd[localh.Wgq][localh.Wgr] = 1;
    }
    setDisplayMode(paramb);
    AppMethodBeat.o(129883);
  }
  
  private float asH(int paramInt)
  {
    AppMethodBeat.i(129880);
    float f1 = getPaddingLeft();
    float f2 = paramInt;
    float f3 = this.Whs;
    float f4 = this.Whs;
    AppMethodBeat.o(129880);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private float asI(int paramInt)
  {
    AppMethodBeat.i(129881);
    float f1 = getPaddingTop();
    float f2 = paramInt;
    float f3 = this.Wht;
    float f4 = this.Wht;
    AppMethodBeat.o(129881);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private h ba(float paramFloat1, float paramFloat2)
  {
    int k = 0;
    AppMethodBeat.i(129877);
    Object localObject2 = null;
    float f1 = this.Wht;
    float f2 = f1 * this.Whg;
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
          paramFloat2 = this.Whs;
          f1 = this.Whg * paramFloat2;
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
        if (this.Whd[j][i] == 0) {
          localObject1 = h.mX(j, i);
        }
      }
      if (localObject1 == null) {
        break label296;
      }
      this.Whd[localObject1.Wgq][localObject1.Wgr] = 1;
      this.Whc.add(localObject1);
      if (this.Whu != null) {
        new ArrayList(this.Whc);
      }
      if (this.Whh) {
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
  
  private void ini()
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        this.Whd[i][j] = 0;
        j += 1;
      }
      i += 1;
    }
  }
  
  private void inj()
  {
    AppMethodBeat.i(129884);
    this.Whc.clear();
    ini();
    this.Whk = b.Whw;
    invalidate();
    AppMethodBeat.o(129884);
  }
  
  private static int mY(int paramInt1, int paramInt2)
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
  
  private static String me(List<h> paramList)
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
      h localh = (h)paramList.get(i);
      int k = localh.Wgq;
      arrayOfByte[i] = ((byte)(localh.Wgr + k * 3));
      i += 1;
    }
    paramList = new String(arrayOfByte);
    AppMethodBeat.o(129867);
    return paramList;
  }
  
  public boolean getDisplayLine()
  {
    return this.Whi;
  }
  
  public boolean getEnableHapticFeedback()
  {
    return this.Whh;
  }
  
  public boolean getEnableInput()
  {
    return this.Whj;
  }
  
  public List<h> getPattern()
  {
    AppMethodBeat.i(129882);
    ArrayList localArrayList = new ArrayList(this.Whc);
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
  
  public final void ink()
  {
    AppMethodBeat.i(129885);
    inj();
    if (this.Whu != null) {
      this.Whu.a(this);
    }
    AppMethodBeat.o(129885);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(129875);
    ArrayList localArrayList = this.Whc;
    int m = localArrayList.size();
    boolean[][] arrayOfBoolean = this.Whd;
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
    if (this.Whk == b.Why)
    {
      j = (int)(SystemClock.elapsedRealtime() - this.Whr) % ((m + 1) * 700);
      k = j / 700;
      ini();
      i = 0;
      while (i < k)
      {
        localObject = (h)localArrayList.get(i);
        arrayOfBoolean[localObject.Wgq][localObject.Wgr] = 1;
        i += 1;
      }
      if ((k > 0) && (k < m))
      {
        i = 1;
        if (i != 0)
        {
          f1 = j % 700 / 700.0F;
          localObject = (h)localArrayList.get(k - 1);
          f2 = asH(((h)localObject).Wgr);
          f3 = asI(((h)localObject).Wgq);
          localObject = (h)localArrayList.get(k);
          f4 = asH(((h)localObject).Wgr);
          f5 = asI(((h)localObject).Wgq);
          this.Whp = (f2 + (f4 - f2) * f1);
          this.Whq = ((f5 - f3) * f1 + f3);
        }
        invalidate();
      }
    }
    else
    {
      this.WgX.setColor(this.yDa);
      this.WgX.setStrokeWidth(this.xAD);
      localObject = this.WgY;
      ((Path)localObject).rewind();
      if ((!this.Whi) && (this.Whk != b.Whx)) {
        break label436;
      }
      i = 1;
      n = getPaddingTop();
      i1 = getPaddingLeft();
      f1 = this.Whs;
      f2 = this.Wht;
      if ((this.WgW.getFlags() & 0x2) == 0) {
        break label442;
      }
      bool = true;
      label335:
      this.WgW.setFilterBitmap(true);
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
        h localh = (h)localArrayList.get(i);
        if (arrayOfBoolean[localh.Wgq][localh.Wgr] != 0)
        {
          j = 1;
          f3 = asH(localh.Wgr);
          f4 = asI(localh.Wgq);
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
      if (((this.uwK) || (this.Whk == b.Why)) && (j != 0)) {
        ((Path)localObject).lineTo(this.Whp, this.Whq);
      }
      paramCanvas.drawPath((Path)localObject, this.WgX);
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
    this.WgW.setFilterBitmap(bool);
    AppMethodBeat.o(129875);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129874);
    int j = getSuggestedMinimumWidth();
    int i = getSuggestedMinimumHeight();
    paramInt1 = mY(paramInt1, j);
    i = mY(paramInt2, i);
    if (this.Whe == PatternLockView.c.WhC) {
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
    b localb = b.Whw;
    Object localObject = paramParcelable.WhA;
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
      localArrayList.add(h.mX(j / 3, j % 3));
      i += 1;
    }
    a(localb, localArrayList);
    this.Whk = b.values()[paramParcelable.WhB];
    this.Whi = paramParcelable.Whi;
    this.Whj = paramParcelable.Whj;
    this.Whh = paramParcelable.Whh;
    AppMethodBeat.o(129869);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(129868);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState(), me(this.Whc), this.Whk.ordinal(), this.Whi, this.Whj, this.Whh);
    AppMethodBeat.o(129868);
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(129872);
    this.Whs = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.Wht = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
    AppMethodBeat.o(129872);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(129878);
    if ((!this.Whj) || (!isEnabled()))
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
      inj();
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      paramMotionEvent = ba(f1, f2);
      if (paramMotionEvent != null)
      {
        this.uwK = true;
        this.Whk = b.Whw;
        if (this.Whu == null) {}
      }
      for (;;)
      {
        if (paramMotionEvent != null)
        {
          f3 = asH(paramMotionEvent.Wgr);
          f4 = asI(paramMotionEvent.Wgq);
          f5 = this.Whs * 0.5F;
          f6 = this.Wht * 0.5F;
          invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
        }
        this.Whp = f1;
        this.Whq = f2;
        AppMethodBeat.o(129878);
        return true;
        this.uwK = false;
      }
    case 1: 
      if (!this.Whc.isEmpty())
      {
        this.uwK = false;
        if (this.Whu != null) {
          this.Whu.a(this, new ArrayList(this.Whc));
        }
        invalidate();
      }
      AppMethodBeat.o(129878);
      return true;
    case 2: 
      float f7 = this.xAD;
      int k = paramMotionEvent.getHistorySize();
      this.Wha.setEmpty();
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
          h localh1 = ba(f1, f2);
          int m = this.Whc.size();
          if ((localh1 != null) && (m == 1)) {
            this.uwK = true;
          }
          f3 = Math.abs(f1 - this.Whp);
          f4 = Math.abs(f2 - this.Whq);
          if ((f3 > 0.0F) || (f4 > 0.0F)) {
            j = 1;
          }
          if ((this.uwK) && (m > 0))
          {
            h localh2 = (h)this.Whc.get(m - 1);
            f4 = asH(localh2.Wgr);
            f3 = asI(localh2.Wgq);
            f5 = Math.min(f4, f1) - f7;
            f4 = Math.max(f4, f1) + f7;
            f6 = Math.min(f3, f2) - f7;
            f3 = Math.max(f3, f2) + f7;
            if (localh1 == null) {
              break label912;
            }
            f2 = this.Whs * 0.5F;
            float f8 = this.Wht * 0.5F;
            float f10 = asH(localh1.Wgr);
            float f9 = asI(localh1.Wgq);
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
      this.Wha.union(Math.round(f1), Math.round(f2), Math.round(f4), Math.round(f3));
      i += 1;
      break;
      f1 = paramMotionEvent.getX();
      break label318;
      label630:
      f2 = paramMotionEvent.getY();
      break label332;
      this.Whp = paramMotionEvent.getX();
      if (this.Whp < getPaddingLeft() + this.xAD)
      {
        this.Whp = (getPaddingLeft() + this.xAD);
        this.Whq = paramMotionEvent.getY();
        if (this.Whq >= getPaddingTop() + this.xAD) {
          break label816;
        }
        this.Whq = (getPaddingTop() + this.xAD);
      }
      for (;;)
      {
        if (j != 0)
        {
          this.Whb.union(this.Wha);
          invalidate(this.Whb);
          this.Whb.set(this.Wha);
        }
        AppMethodBeat.o(129878);
        return true;
        if (this.Whp <= getPaddingLeft() + getWidth() - getPaddingRight() - this.xAD) {
          break;
        }
        this.Whp = (getPaddingLeft() + getWidth() - getPaddingRight() - this.xAD);
        break;
        label816:
        if (this.Whq > getPaddingTop() + getHeight() - getPaddingRight() - this.xAD) {
          this.Whq = (getPaddingTop() + getHeight() - getPaddingBottom() - this.xAD);
        }
      }
      if (this.uwK)
      {
        this.uwK = false;
        inj();
        if (this.Whu != null) {
          this.Whu.a(this);
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
    this.Whi = paramBoolean;
    invalidate();
    AppMethodBeat.o(129879);
  }
  
  public void setDisplayMode(b paramb)
  {
    AppMethodBeat.i(129886);
    switch (1.Whv[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.Whk = paramb;
      invalidate();
      AppMethodBeat.o(129886);
      return;
      this.yDa = getResources().getColor(a.b.Brand);
      continue;
      this.yDa = getResources().getColor(a.b.Wek);
      continue;
      if (this.Whc.size() == 0)
      {
        paramb = new IllegalStateException("You should set a pattern before animating.");
        AppMethodBeat.o(129886);
        throw paramb;
      }
      this.Whj = false;
      this.yDa = getResources().getColor(a.b.Brand);
      h localh = (h)this.Whc.get(0);
      this.Whp = asH(localh.Wgr);
      this.Whq = asI(localh.Wgq);
      ini();
      this.Whr = SystemClock.elapsedRealtime();
    }
  }
  
  public void setEnableHapticFeedback(boolean paramBoolean)
  {
    this.Whh = paramBoolean;
  }
  
  public void setEnableInput(boolean paramBoolean)
  {
    this.Whj = paramBoolean;
  }
  
  public void setOnPatternListener(a parama)
  {
    this.Whu = parama;
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    String WhA;
    int WhB;
    boolean Whh;
    boolean Whi;
    boolean Whj;
    
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
      this.WhA = paramParcel.readString();
      this.WhB = paramParcel.readInt();
      this.Whi = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.Whj = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.Whh = ((Boolean)paramParcel.readValue(null)).booleanValue();
      AppMethodBeat.o(129859);
    }
    
    public SavedState(Parcelable paramParcelable, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super();
      this.WhA = paramString;
      this.WhB = paramInt;
      this.Whi = paramBoolean1;
      this.Whj = paramBoolean2;
      this.Whh = paramBoolean3;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(129860);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.WhA);
      paramParcel.writeInt(this.WhB);
      paramParcel.writeValue(Boolean.valueOf(this.Whi));
      paramParcel.writeValue(Boolean.valueOf(this.Whj));
      paramParcel.writeValue(Boolean.valueOf(this.Whh));
      AppMethodBeat.o(129860);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(PatternLockView paramPatternLockView);
    
    public abstract void a(PatternLockView paramPatternLockView, List<h> paramList);
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(129857);
      Whw = new b("Correct", 0);
      Whx = new b("Wrong", 1);
      Why = new b("Animate", 2);
      Whz = new b[] { Whw, Whx, Why };
      AppMethodBeat.o(129857);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView
 * JD-Core Version:    0.7.0.1
 */