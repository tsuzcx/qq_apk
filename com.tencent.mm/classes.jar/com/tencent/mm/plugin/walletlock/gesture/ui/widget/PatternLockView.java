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
import com.tencent.mm.plugin.walletlock.a.a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView
  extends View
{
  private Rect ACA;
  private ArrayList<com.tencent.mm.plugin.walletlock.gesture.a.f> ACB;
  private boolean[][] ACC;
  private PatternLockView.c ACD;
  private int ACE;
  private float ACF;
  private boolean ACG;
  private boolean ACH;
  private boolean ACI;
  private b ACJ;
  private Bitmap ACK;
  private Bitmap ACL;
  private Bitmap ACM;
  private Bitmap ACN;
  private float ACO;
  private float ACP;
  private long ACQ;
  private float ACR;
  private float ACS;
  private a ACT;
  private Paint ACv;
  private Paint ACw;
  private Path ACx;
  private Matrix ACy;
  private Rect ACz;
  private int HC;
  private int HD;
  private boolean lPF;
  private int ooU;
  private int pgy;
  
  public PatternLockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(129865);
    this.ACv = new Paint();
    this.ACw = new Paint();
    this.ACx = new Path();
    this.ACy = new Matrix();
    this.ACz = new Rect();
    this.ACA = new Rect();
    this.ACB = new ArrayList(9);
    this.ACC = ((boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 }));
    this.ACD = PatternLockView.c.ADb;
    this.ooU = 6;
    this.ACE = 200;
    this.ACF = 0.66F;
    this.ACG = false;
    this.ACH = true;
    this.ACI = false;
    int i;
    if (isInEditMode())
    {
      i = -1;
      this.pgy = i;
      this.ACJ = b.ACV;
      this.ACK = null;
      this.ACL = null;
      this.ACM = null;
      this.ACN = null;
      this.ACO = -1.0F;
      this.ACP = -1.0F;
      this.lPF = false;
      this.ACQ = 0L;
      this.HC = 0;
      this.HD = 0;
      this.ACR = 0.0F;
      this.ACS = 0.0F;
      this.ACT = null;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.mm_patternlock_view);
      this.ACH = paramContext.getBoolean(4, this.ACH);
      this.ACE = paramContext.getInt(1, this.ACE);
      this.ooU = paramContext.getInt(2, this.ooU);
      this.ACG = paramContext.getBoolean(0, this.ACG);
      switch (paramContext.getInt(3, this.ACD.ordinal()))
      {
      default: 
        this.ACD = PatternLockView.c.ADb;
      }
    }
    for (;;)
    {
      paramContext.recycle();
      setClickable(true);
      this.ACw.setStyle(Paint.Style.STROKE);
      this.ACw.setStrokeJoin(Paint.Join.ROUND);
      this.ACw.setStrokeCap(Paint.Cap.ROUND);
      this.ACw.setAntiAlias(true);
      this.ACw.setDither(false);
      this.ACw.setAlpha(this.ACE);
      this.ACv.setAntiAlias(true);
      this.ACv.setDither(true);
      if (isInEditMode()) {
        break label646;
      }
      if (this.ACK == null)
      {
        this.ACK = A(a.l(getContext(), 2131232595));
        this.ACL = A(a.l(getContext(), 2131232596));
        this.ACM = this.ACL;
        this.ACN = A(a.l(getContext(), 2131232597));
      }
      this.ooU = ((int)(this.ooU * com.tencent.mm.sdk.platformtools.f.aGH().density));
      paramContext = this.ACK;
      paramAttributeSet = this.ACL;
      Bitmap localBitmap1 = this.ACM;
      Bitmap localBitmap2 = this.ACN;
      i = 0;
      while (i < 4)
      {
        Bitmap localBitmap3 = new Bitmap[] { paramContext, paramAttributeSet, localBitmap1, localBitmap2 }[i];
        this.HC = Math.max(localBitmap3.getWidth(), this.HC);
        this.HD = Math.max(localBitmap3.getHeight(), this.HD);
        i += 1;
      }
      i = getResources().getColor(2131099699);
      break;
      this.ACD = PatternLockView.c.ADb;
      continue;
      this.ACD = PatternLockView.c.ADc;
    }
    label646:
    AppMethodBeat.o(129865);
  }
  
  private static Bitmap A(Drawable paramDrawable)
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
  
  private float RN(int paramInt)
  {
    AppMethodBeat.i(129880);
    float f1 = getPaddingLeft();
    float f2 = paramInt;
    float f3 = this.ACR;
    float f4 = this.ACR;
    AppMethodBeat.o(129880);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private float RO(int paramInt)
  {
    AppMethodBeat.i(129881);
    float f1 = getPaddingTop();
    float f2 = paramInt;
    float f3 = this.ACS;
    float f4 = this.ACS;
    AppMethodBeat.o(129881);
    return f1 + f2 * f3 + f4 * 0.5F;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(129876);
    Bitmap localBitmap;
    if ((!paramBoolean) || ((!this.ACH) && (this.ACJ != b.ACW))) {
      localBitmap = this.ACK;
    }
    for (;;)
    {
      int j = this.HC;
      int i = this.HD;
      float f1 = this.ACR;
      float f2 = this.ACS;
      j = (int)((f1 - j) * 0.5F);
      i = (int)((f2 - i) * 0.5F);
      f2 = getResources().getDisplayMetrics().density;
      f1 = Math.min((this.ACR - 33.0F * f2) / this.HC, 1.0F);
      f2 = Math.min((this.ACS - f2 * 33.0F) / this.HD, 1.0F);
      this.ACy.setTranslate(j + paramInt1, i + paramInt2);
      this.ACy.preTranslate(this.HC / 2, this.HD / 2);
      this.ACy.preScale(f1, f2);
      this.ACy.preTranslate(-this.HC / 2, -this.HD / 2);
      if (!isInEditMode()) {
        paramCanvas.drawBitmap(localBitmap, this.ACy, this.ACv);
      }
      AppMethodBeat.o(129876);
      return;
      if (this.lPF)
      {
        localBitmap = this.ACL;
      }
      else if (this.ACJ == b.ACW)
      {
        localBitmap = this.ACN;
      }
      else
      {
        if ((this.ACJ != b.ACV) && (this.ACJ != b.ACX)) {
          break;
        }
        localBitmap = this.ACM;
      }
    }
    paramCanvas = new IllegalStateException("unknown display mode " + this.ACJ);
    AppMethodBeat.o(129876);
    throw paramCanvas;
  }
  
  private void a(b paramb, List<com.tencent.mm.plugin.walletlock.gesture.a.f> paramList)
  {
    AppMethodBeat.i(129883);
    this.ACB.clear();
    egw();
    this.ACB.addAll(paramList);
    paramList = this.ACB.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.walletlock.gesture.a.f localf = (com.tencent.mm.plugin.walletlock.gesture.a.f)paramList.next();
      this.ACC[localf.ABP][localf.ABQ] = 1;
    }
    setDisplayMode(paramb);
    AppMethodBeat.o(129883);
  }
  
  private com.tencent.mm.plugin.walletlock.gesture.a.f aa(float paramFloat1, float paramFloat2)
  {
    int k = 0;
    AppMethodBeat.i(129877);
    Object localObject2 = null;
    float f1 = this.ACS;
    float f2 = f1 * this.ACF;
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
          paramFloat2 = this.ACR;
          f1 = this.ACF * paramFloat2;
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
        if (this.ACC[j][i] == 0) {
          localObject1 = com.tencent.mm.plugin.walletlock.gesture.a.f.ik(j, i);
        }
      }
      if (localObject1 == null) {
        break label296;
      }
      this.ACC[localObject1.ABP][localObject1.ABQ] = 1;
      this.ACB.add(localObject1);
      if (this.ACT != null) {
        new ArrayList(this.ACB);
      }
      if (this.ACG) {
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
  
  private void egw()
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        this.ACC[i][j] = 0;
        j += 1;
      }
      i += 1;
    }
  }
  
  private void egx()
  {
    AppMethodBeat.i(129884);
    this.ACB.clear();
    egw();
    this.ACJ = b.ACV;
    invalidate();
    AppMethodBeat.o(129884);
  }
  
  private static String gt(List<com.tencent.mm.plugin.walletlock.gesture.a.f> paramList)
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
      int k = localf.ABP;
      arrayOfByte[i] = ((byte)(localf.ABQ + k * 3));
      i += 1;
    }
    paramList = new String(arrayOfByte);
    AppMethodBeat.o(129867);
    return paramList;
  }
  
  private static int il(int paramInt1, int paramInt2)
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
  
  public final void egy()
  {
    AppMethodBeat.i(129885);
    egx();
    if (this.ACT != null) {
      this.ACT.a(this);
    }
    AppMethodBeat.o(129885);
  }
  
  public boolean getDisplayLine()
  {
    return this.ACH;
  }
  
  public boolean getEnableHapticFeedback()
  {
    return this.ACG;
  }
  
  public boolean getEnableInput()
  {
    return this.ACI;
  }
  
  public List<com.tencent.mm.plugin.walletlock.gesture.a.f> getPattern()
  {
    AppMethodBeat.i(129882);
    ArrayList localArrayList = new ArrayList(this.ACB);
    AppMethodBeat.o(129882);
    return localArrayList;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    AppMethodBeat.i(129871);
    float f = getResources().getDisplayMetrics().density;
    int i = (int)(3.0D * this.HD / f);
    AppMethodBeat.o(129871);
    return i;
  }
  
  protected int getSuggestedMinimumWidth()
  {
    AppMethodBeat.i(129870);
    float f = getResources().getDisplayMetrics().density;
    int i = (int)(3.0D * this.HC / f);
    AppMethodBeat.o(129870);
    return i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(129875);
    ArrayList localArrayList = this.ACB;
    int m = localArrayList.size();
    boolean[][] arrayOfBoolean = this.ACC;
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
    if (this.ACJ == b.ACX)
    {
      j = (int)(SystemClock.elapsedRealtime() - this.ACQ) % ((m + 1) * 700);
      k = j / 700;
      egw();
      i = 0;
      while (i < k)
      {
        localObject = (com.tencent.mm.plugin.walletlock.gesture.a.f)localArrayList.get(i);
        arrayOfBoolean[localObject.ABP][localObject.ABQ] = 1;
        i += 1;
      }
      if ((k > 0) && (k < m))
      {
        i = 1;
        if (i != 0)
        {
          f1 = j % 700 / 700.0F;
          localObject = (com.tencent.mm.plugin.walletlock.gesture.a.f)localArrayList.get(k - 1);
          f2 = RN(((com.tencent.mm.plugin.walletlock.gesture.a.f)localObject).ABQ);
          f3 = RO(((com.tencent.mm.plugin.walletlock.gesture.a.f)localObject).ABP);
          localObject = (com.tencent.mm.plugin.walletlock.gesture.a.f)localArrayList.get(k);
          f4 = RN(((com.tencent.mm.plugin.walletlock.gesture.a.f)localObject).ABQ);
          f5 = RO(((com.tencent.mm.plugin.walletlock.gesture.a.f)localObject).ABP);
          this.ACO = (f2 + (f4 - f2) * f1);
          this.ACP = ((f5 - f3) * f1 + f3);
        }
        invalidate();
      }
    }
    else
    {
      this.ACw.setColor(this.pgy);
      this.ACw.setStrokeWidth(this.ooU);
      localObject = this.ACx;
      ((Path)localObject).rewind();
      if ((!this.ACH) && (this.ACJ != b.ACW)) {
        break label436;
      }
      i = 1;
      n = getPaddingTop();
      i1 = getPaddingLeft();
      f1 = this.ACR;
      f2 = this.ACS;
      if ((this.ACv.getFlags() & 0x2) == 0) {
        break label442;
      }
      bool = true;
      label335:
      this.ACv.setFilterBitmap(true);
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
        if (arrayOfBoolean[localf.ABP][localf.ABQ] != 0)
        {
          j = 1;
          f3 = RN(localf.ABQ);
          f4 = RO(localf.ABP);
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
      if (((this.lPF) || (this.ACJ == b.ACX)) && (j != 0)) {
        ((Path)localObject).lineTo(this.ACO, this.ACP);
      }
      paramCanvas.drawPath((Path)localObject, this.ACw);
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
    this.ACv.setFilterBitmap(bool);
    AppMethodBeat.o(129875);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129874);
    int j = getSuggestedMinimumWidth();
    int i = getSuggestedMinimumHeight();
    paramInt1 = il(paramInt1, j);
    i = il(paramInt2, i);
    if (this.ACD == PatternLockView.c.ADb) {
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
    b localb = b.ACV;
    Object localObject = paramParcelable.ACZ;
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
      localArrayList.add(com.tencent.mm.plugin.walletlock.gesture.a.f.ik(j / 3, j % 3));
      i += 1;
    }
    a(localb, localArrayList);
    this.ACJ = b.values()[paramParcelable.ADa];
    this.ACH = paramParcelable.ACH;
    this.ACI = paramParcelable.ACI;
    this.ACG = paramParcelable.ACG;
    AppMethodBeat.o(129869);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(129868);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState(), gt(this.ACB), this.ACJ.ordinal(), this.ACH, this.ACI, this.ACG);
    AppMethodBeat.o(129868);
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(129872);
    this.ACR = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.ACS = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
    AppMethodBeat.o(129872);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(129878);
    if ((!this.ACI) || (!isEnabled()))
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
      egx();
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      paramMotionEvent = aa(f1, f2);
      if (paramMotionEvent != null)
      {
        this.lPF = true;
        this.ACJ = b.ACV;
        if (this.ACT == null) {}
      }
      for (;;)
      {
        if (paramMotionEvent != null)
        {
          f3 = RN(paramMotionEvent.ABQ);
          f4 = RO(paramMotionEvent.ABP);
          f5 = this.ACR * 0.5F;
          f6 = this.ACS * 0.5F;
          invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
        }
        this.ACO = f1;
        this.ACP = f2;
        AppMethodBeat.o(129878);
        return true;
        this.lPF = false;
      }
    case 1: 
      if (!this.ACB.isEmpty())
      {
        this.lPF = false;
        if (this.ACT != null) {
          this.ACT.a(this, new ArrayList(this.ACB));
        }
        invalidate();
      }
      AppMethodBeat.o(129878);
      return true;
    case 2: 
      float f7 = this.ooU;
      int k = paramMotionEvent.getHistorySize();
      this.ACz.setEmpty();
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
          com.tencent.mm.plugin.walletlock.gesture.a.f localf1 = aa(f1, f2);
          int m = this.ACB.size();
          if ((localf1 != null) && (m == 1)) {
            this.lPF = true;
          }
          f3 = Math.abs(f1 - this.ACO);
          f4 = Math.abs(f2 - this.ACP);
          if ((f3 > 0.0F) || (f4 > 0.0F)) {
            j = 1;
          }
          if ((this.lPF) && (m > 0))
          {
            com.tencent.mm.plugin.walletlock.gesture.a.f localf2 = (com.tencent.mm.plugin.walletlock.gesture.a.f)this.ACB.get(m - 1);
            f4 = RN(localf2.ABQ);
            f3 = RO(localf2.ABP);
            f5 = Math.min(f4, f1) - f7;
            f4 = Math.max(f4, f1) + f7;
            f6 = Math.min(f3, f2) - f7;
            f3 = Math.max(f3, f2) + f7;
            if (localf1 == null) {
              break label912;
            }
            f2 = this.ACR * 0.5F;
            float f8 = this.ACS * 0.5F;
            float f10 = RN(localf1.ABQ);
            float f9 = RO(localf1.ABP);
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
      this.ACz.union(Math.round(f1), Math.round(f2), Math.round(f4), Math.round(f3));
      i += 1;
      break;
      f1 = paramMotionEvent.getX();
      break label318;
      label630:
      f2 = paramMotionEvent.getY();
      break label332;
      this.ACO = paramMotionEvent.getX();
      if (this.ACO < getPaddingLeft() + this.ooU)
      {
        this.ACO = (getPaddingLeft() + this.ooU);
        this.ACP = paramMotionEvent.getY();
        if (this.ACP >= getPaddingTop() + this.ooU) {
          break label816;
        }
        this.ACP = (getPaddingTop() + this.ooU);
      }
      for (;;)
      {
        if (j != 0)
        {
          this.ACA.union(this.ACz);
          invalidate(this.ACA);
          this.ACA.set(this.ACz);
        }
        AppMethodBeat.o(129878);
        return true;
        if (this.ACO <= getPaddingLeft() + getWidth() - getPaddingRight() - this.ooU) {
          break;
        }
        this.ACO = (getPaddingLeft() + getWidth() - getPaddingRight() - this.ooU);
        break;
        label816:
        if (this.ACP > getPaddingTop() + getHeight() - getPaddingRight() - this.ooU) {
          this.ACP = (getPaddingTop() + getHeight() - getPaddingBottom() - this.ooU);
        }
      }
      if (this.lPF)
      {
        this.lPF = false;
        egx();
        if (this.ACT != null) {
          this.ACT.a(this);
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
    this.ACH = paramBoolean;
    invalidate();
    AppMethodBeat.o(129879);
  }
  
  public void setDisplayMode(b paramb)
  {
    AppMethodBeat.i(129886);
    switch (1.ACU[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.ACJ = paramb;
      invalidate();
      AppMethodBeat.o(129886);
      return;
      this.pgy = getResources().getColor(2131100460);
      continue;
      this.pgy = getResources().getColor(2131100463);
      continue;
      if (this.ACB.size() == 0)
      {
        paramb = new IllegalStateException("You should set a pattern before animating.");
        AppMethodBeat.o(129886);
        throw paramb;
      }
      this.ACI = false;
      this.pgy = getResources().getColor(2131100460);
      com.tencent.mm.plugin.walletlock.gesture.a.f localf = (com.tencent.mm.plugin.walletlock.gesture.a.f)this.ACB.get(0);
      this.ACO = RN(localf.ABQ);
      this.ACP = RO(localf.ABP);
      egw();
      this.ACQ = SystemClock.elapsedRealtime();
    }
  }
  
  public void setEnableHapticFeedback(boolean paramBoolean)
  {
    this.ACG = paramBoolean;
  }
  
  public void setEnableInput(boolean paramBoolean)
  {
    this.ACI = paramBoolean;
  }
  
  public void setOnPatternListener(a parama)
  {
    this.ACT = parama;
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean ACG;
    boolean ACH;
    boolean ACI;
    String ACZ;
    int ADa;
    
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
      this.ACZ = paramParcel.readString();
      this.ADa = paramParcel.readInt();
      this.ACH = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.ACI = ((Boolean)paramParcel.readValue(null)).booleanValue();
      this.ACG = ((Boolean)paramParcel.readValue(null)).booleanValue();
      AppMethodBeat.o(129859);
    }
    
    public SavedState(Parcelable paramParcelable, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super();
      this.ACZ = paramString;
      this.ADa = paramInt;
      this.ACH = paramBoolean1;
      this.ACI = paramBoolean2;
      this.ACG = paramBoolean3;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(129860);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.ACZ);
      paramParcel.writeInt(this.ADa);
      paramParcel.writeValue(Boolean.valueOf(this.ACH));
      paramParcel.writeValue(Boolean.valueOf(this.ACI));
      paramParcel.writeValue(Boolean.valueOf(this.ACG));
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
      ACV = new b("Correct", 0);
      ACW = new b("Wrong", 1);
      ACX = new b("Animate", 2);
      ACY = new b[] { ACV, ACW, ACX };
      AppMethodBeat.o(129857);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView
 * JD-Core Version:    0.7.0.1
 */