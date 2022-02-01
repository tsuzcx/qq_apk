package com.tencent.mm.plugin.recordvideo.ui.editor.c;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Vibrator;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "", "()V", "CalibrationDistance", "", "TAG", "", "boundArrayDst", "", "getBoundArrayDst", "()[F", "setBoundArrayDst", "([F)V", "boundArrayOut", "getBoundArrayOut", "setBoundArrayOut", "boundArraySrc", "getBoundArraySrc", "setBoundArraySrc", "clockwise", "", "hasInit", "height", "", "getHeight", "()I", "setHeight", "(I)V", "holdX", "getHoldX", "()F", "setHoldX", "(F)V", "holdY", "getHoldY", "setHoldY", "holdingThreshold", "getHoldingThreshold", "setHoldingThreshold", "lastDrag", "lastRotate", "lastStardAngle", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "needVibrator", "pIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pIndices", "pivotDst", "pivotType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$PivotType;", "pointDownRotate", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "selfCalibration", "state", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$TouchState;", "transStart", "transformBoundArray", "getTransformBoundArray", "setTransformBoundArray", "vibrator", "Landroid/os/Vibrator;", "width", "getWidth", "setWidth", "appendTouchEvent", "event", "Landroid/view/MotionEvent;", "findIndices", "", "findMaxBottom", "findMaxRight", "findMinLeft", "findMinTop", "getRotate", "inSafeArea", "newLeft", "newTop", "newRight", "newBottom", "resetHold", "updateMatrix", "m", "updateState", "isEqual", "input", "PivotType", "TouchState", "plugin-recordvideo_release"})
public final class c
{
  public Rect BKm;
  private ArrayList<Integer> CgV;
  private ArrayList<Integer> CgW;
  private float[] CgX;
  private float[] CgY;
  private float[] CgZ;
  private b Cha;
  public int Chb;
  private float Chc;
  private float Chd;
  private float[] Che;
  private float[] Chf;
  public float[] Chg;
  private float[] Chh;
  private c.a Chi;
  private boolean Chj;
  private float Chk;
  private float Chl;
  private float Chm;
  private boolean Chn;
  private boolean Cho;
  private int Chp;
  private final String TAG;
  public float aXt;
  public float aXu;
  public Matrix gT;
  private boolean hasInit;
  public int height;
  private final Vibrator paT;
  public int width;
  
  public c()
  {
    AppMethodBeat.i(237950);
    this.TAG = "TouchTracker";
    this.CgV = new ArrayList();
    this.CgW = new ArrayList();
    this.CgX = new float[2];
    this.CgY = new float[4];
    this.CgZ = new float[2];
    this.Cha = b.Cht;
    this.gT = new Matrix();
    this.Che = new float[8];
    this.Chf = new float[8];
    this.Chg = new float[4];
    this.Chh = new float[4];
    this.aXt = 10.0F;
    this.aXu = 0.1F;
    this.Chi = c.a.Chq;
    this.Chj = true;
    this.Chk = 15.0F;
    Object localObject = MMApplicationContext.getContext().getSystemService("vibrator");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(237950);
      throw ((Throwable)localObject);
    }
    this.paT = ((Vibrator)localObject);
    this.Cho = true;
    this.gT.setScale(1.0F, 1.0F);
    AppMethodBeat.o(237950);
  }
  
  private final void Z(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237942);
    Object localObject1;
    Object localObject2;
    if (this.CgV.size() == 1)
    {
      this.Cha = b.Chu;
      localObject1 = this.CgX;
      localObject2 = this.CgW.get(0);
      p.g(localObject2, "pIndices[0]");
      localObject1[0] = paramMotionEvent.getX(((Number)localObject2).intValue());
      localObject1 = this.CgX;
      localObject2 = this.CgW.get(0);
      p.g(localObject2, "pIndices[0]");
      localObject1[1] = paramMotionEvent.getY(((Number)localObject2).intValue());
      AppMethodBeat.o(237942);
      return;
    }
    if (this.CgV.size() == 2)
    {
      this.Cha = b.Chv;
      if (this.Chi == c.a.Chr) {
        this.gT.mapPoints(this.CgZ, new float[] { this.width / 2.0F, this.height / 2.0F });
      }
      localObject1 = new Matrix();
      this.gT.invert((Matrix)localObject1);
      aa(paramMotionEvent);
      if ((p.compare(((Number)this.CgW.get(0)).intValue(), paramMotionEvent.getPointerCount()) < 0) && (p.compare(((Number)this.CgW.get(1)).intValue(), paramMotionEvent.getPointerCount()) < 0))
      {
        localObject2 = this.CgY;
        Object localObject3 = this.CgW.get(0);
        p.g(localObject3, "pIndices[0]");
        float f1 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.CgW.get(0);
        p.g(localObject3, "pIndices[0]");
        float f2 = paramMotionEvent.getY(((Number)localObject3).intValue());
        localObject3 = this.CgW.get(1);
        p.g(localObject3, "pIndices[1]");
        float f3 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.CgW.get(1);
        p.g(localObject3, "pIndices[1]");
        ((Matrix)localObject1).mapPoints((float[])localObject2, new float[] { f1, f2, f3, paramMotionEvent.getY(((Number)localObject3).intValue()) });
      }
    }
    AppMethodBeat.o(237942);
  }
  
  private final void aa(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237943);
    Iterator localIterator = ((Iterable)j.r((Collection)this.CgV)).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ab)localIterator).nextInt();
      ArrayList localArrayList = this.CgW;
      Object localObject = this.CgV.get(i);
      p.g(localObject, "pIds[i]");
      localArrayList.set(i, Integer.valueOf(paramMotionEvent.findPointerIndex(((Number)localObject).intValue())));
    }
    AppMethodBeat.o(237943);
  }
  
  private static boolean ag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237949);
    if (Math.abs(paramFloat1 - paramFloat2) < 0.2F)
    {
      AppMethodBeat.o(237949);
      return true;
    }
    AppMethodBeat.o(237949);
    return false;
  }
  
  private final float eMA()
  {
    AppMethodBeat.i(237947);
    float f2 = this.Chf[0];
    float[] arrayOfFloat = this.Chf;
    int k = arrayOfFloat.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      float f3 = arrayOfFloat[j];
      float f1 = f2;
      switch (i)
      {
      default: 
        f1 = f2;
      }
      for (;;)
      {
        j += 1;
        i += 1;
        f2 = f1;
        break;
        f1 = Math.max(f2, f3);
        continue;
        f1 = Math.max(f2, f3);
        continue;
        f1 = Math.max(f2, f3);
      }
    }
    AppMethodBeat.o(237947);
    return f2;
  }
  
  private final float eMB()
  {
    AppMethodBeat.i(237948);
    float f2 = this.Chf[1];
    float[] arrayOfFloat = this.Chf;
    int k = arrayOfFloat.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      float f3 = arrayOfFloat[j];
      float f1 = f2;
      switch (i)
      {
      default: 
        f1 = f2;
      }
      for (;;)
      {
        j += 1;
        i += 1;
        f2 = f1;
        break;
        f1 = Math.max(f2, f3);
        continue;
        f1 = Math.max(f2, f3);
        continue;
        f1 = Math.max(f2, f3);
      }
    }
    AppMethodBeat.o(237948);
    return f2;
  }
  
  private final void eMx()
  {
    this.Chc = 0.0F;
    this.Chd = 0.0F;
  }
  
  private final float eMy()
  {
    AppMethodBeat.i(237945);
    float f2 = this.Chf[0];
    float[] arrayOfFloat = this.Chf;
    int k = arrayOfFloat.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      float f3 = arrayOfFloat[j];
      float f1 = f2;
      switch (i)
      {
      default: 
        f1 = f2;
      }
      for (;;)
      {
        j += 1;
        i += 1;
        f2 = f1;
        break;
        f1 = Math.min(f2, f3);
        continue;
        f1 = Math.min(f2, f3);
        continue;
        f1 = Math.min(f2, f3);
      }
    }
    AppMethodBeat.o(237945);
    return f2;
  }
  
  private final float eMz()
  {
    AppMethodBeat.i(237946);
    float f2 = this.Chf[1];
    float[] arrayOfFloat = this.Chf;
    int k = arrayOfFloat.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      float f3 = arrayOfFloat[j];
      float f1 = f2;
      switch (i)
      {
      default: 
        f1 = f2;
      }
      for (;;)
      {
        j += 1;
        i += 1;
        f2 = f1;
        break;
        f1 = Math.min(f2, f3);
        continue;
        f1 = Math.min(f2, f3);
        continue;
        f1 = Math.min(f2, f3);
      }
    }
    AppMethodBeat.o(237946);
    return f2;
  }
  
  private final float h(Matrix paramMatrix)
  {
    AppMethodBeat.i(237941);
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    float f2 = (float)(Math.atan2(arrayOfFloat[1], arrayOfFloat[0]) * 57.295779513082323D);
    float f1;
    if ((this.Chm < -90.0F) && (f2 > 0.0F)) {
      f1 = f2 - 360.0F;
    }
    for (;;)
    {
      AppMethodBeat.o(237941);
      return f1;
      f1 = f2;
      if (this.Chm > 90.0F)
      {
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = f2 + 360.0F;
        }
      }
    }
  }
  
  private final boolean r(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(237944);
    Rect localRect = this.BKm;
    if (localRect == null) {
      p.hyc();
    }
    if (paramFloat1 > localRect.left)
    {
      localRect = this.BKm;
      if (localRect == null) {
        p.hyc();
      }
      if (paramFloat1 < localRect.right)
      {
        localRect = this.BKm;
        if (localRect == null) {
          p.hyc();
        }
        if (paramFloat2 > localRect.top)
        {
          localRect = this.BKm;
          if (localRect == null) {
            p.hyc();
          }
          if (paramFloat2 < localRect.bottom)
          {
            localRect = this.BKm;
            if (localRect == null) {
              p.hyc();
            }
            if (paramFloat3 > localRect.left)
            {
              localRect = this.BKm;
              if (localRect == null) {
                p.hyc();
              }
              if (paramFloat3 < localRect.right)
              {
                localRect = this.BKm;
                if (localRect == null) {
                  p.hyc();
                }
                if (paramFloat4 > localRect.top)
                {
                  localRect = this.BKm;
                  if (localRect == null) {
                    p.hyc();
                  }
                  if (paramFloat4 < localRect.bottom)
                  {
                    AppMethodBeat.o(237944);
                    return true;
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(237944);
    return false;
  }
  
  public final boolean Y(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237939);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(237939);
      return true;
      Object localObject1 = new float[2];
      Object localObject2 = new Matrix();
      this.gT.invert((Matrix)localObject2);
      ((Matrix)localObject2).mapPoints((float[])localObject1, new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
      if ((localObject1[0] < 0.0F) || (localObject1[0] > this.width) || (localObject1[1] < 0.0F) || (localObject1[1] > this.height))
      {
        AppMethodBeat.o(237939);
        return false;
      }
      this.CgV.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
      this.CgW.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
      Z(paramMotionEvent);
      if (!this.hasInit)
      {
        localObject1 = this.CgW.get(0);
        p.g(localObject1, "pIndices[0]");
        float f1 = paramMotionEvent.getX(((Number)localObject1).intValue());
        localObject1 = this.CgW.get(0);
        p.g(localObject1, "pIndices[0]");
        float f2 = paramMotionEvent.getY(((Number)localObject1).intValue());
        float f3 = this.CgX[0];
        float f4 = this.CgX[1];
        this.gT.postTranslate(f1 - f3, f2 - f4);
        this.CgX[0] = f1;
        this.CgX[1] = f2;
        this.gT.mapPoints(this.Chf, this.Che);
        this.Chg[0] = eMy();
        this.Chg[1] = eMz();
        this.Chg[2] = eMA();
        this.Chg[3] = eMB();
        this.hasInit = true;
        continue;
        this.CgV.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
        this.CgW.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
        Z(paramMotionEvent);
        if (paramMotionEvent.getPointerCount() == 2)
        {
          this.Chm = 0.0F;
          this.Chl = h(this.gT);
          this.Chm = this.Chl;
          Log.i(this.TAG, "downRotate :" + this.Chl);
          continue;
          aa(paramMotionEvent);
          if (paramMotionEvent.getPointerCount() == 1) {
            this.Cha = b.Chu;
          }
          localObject1 = this.Cha;
          switch (d.$EnumSwitchMapping$0[localObject1.ordinal()])
          {
          default: 
            break;
          case 1: 
            localObject1 = this.CgW.get(0);
            p.g(localObject1, "pIndices[0]");
            f2 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.CgW.get(0);
            p.g(localObject1, "pIndices[0]");
            f3 = paramMotionEvent.getY(((Number)localObject1).intValue());
            f4 = f2 - this.CgX[0];
            f1 = f3 - this.CgX[1];
            this.gT.postTranslate(f4, f1);
            this.CgX[0] = f2;
            this.CgX[1] = f3;
            this.gT.mapPoints(this.Chf, this.Che);
            this.Chg[0] = eMy();
            this.Chg[1] = eMz();
            this.Chg[2] = eMA();
            this.Chg[3] = eMB();
            if ((this.BKm != null) && (!r(this.Chg[0] + f4, this.Chg[1] + f1, this.Chg[2] + f4, this.Chg[3] + f1)))
            {
              f2 = Math.abs(f4);
              f1 = Math.abs(f1);
              paramMotionEvent = this.BKm;
              if (paramMotionEvent == null) {
                p.hyc();
              }
              if ((paramMotionEvent.left >= this.Chg[0]) && (this.Chc <= this.Chb))
              {
                paramMotionEvent = this.gT;
                localObject1 = this.BKm;
                if (localObject1 == null) {
                  p.hyc();
                }
                paramMotionEvent.postTranslate(((Rect)localObject1).left - this.Chg[0], 0.0F);
                this.Chc += f2;
              }
              paramMotionEvent = this.BKm;
              if (paramMotionEvent == null) {
                p.hyc();
              }
              if ((paramMotionEvent.top >= this.Chg[1]) && (this.Chd <= this.Chb))
              {
                paramMotionEvent = this.gT;
                localObject1 = this.BKm;
                if (localObject1 == null) {
                  p.hyc();
                }
                paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).top - this.Chg[1]);
                this.Chd += f1;
              }
              paramMotionEvent = this.BKm;
              if (paramMotionEvent == null) {
                p.hyc();
              }
              if ((paramMotionEvent.right <= this.Chg[2]) && (this.Chc <= this.Chb))
              {
                paramMotionEvent = this.gT;
                localObject1 = this.BKm;
                if (localObject1 == null) {
                  p.hyc();
                }
                paramMotionEvent.postTranslate(((Rect)localObject1).right - this.Chg[2], 0.0F);
                this.Chc = (f2 + this.Chc);
              }
              paramMotionEvent = this.BKm;
              if (paramMotionEvent == null) {
                p.hyc();
              }
              if ((paramMotionEvent.bottom <= this.Chg[3]) && (this.Chd <= this.Chb))
              {
                paramMotionEvent = this.gT;
                localObject1 = this.BKm;
                if (localObject1 == null) {
                  p.hyc();
                }
                paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).bottom - this.Chg[3]);
                this.Chd += f1;
              }
            }
            else
            {
              eMx();
            }
            break;
          case 2: 
            localObject1 = this.CgW.get(0);
            p.g(localObject1, "pIndices[0]");
            f1 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.CgW.get(0);
            p.g(localObject1, "pIndices[0]");
            f2 = paramMotionEvent.getY(((Number)localObject1).intValue());
            localObject1 = this.CgW.get(1);
            p.g(localObject1, "pIndices[1]");
            f3 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.CgW.get(1);
            p.g(localObject1, "pIndices[1]");
            f4 = paramMotionEvent.getY(((Number)localObject1).intValue());
            this.gT.setPolyToPoly(this.CgY, 0, new float[] { f1, f2, f3, f4 }, 0, 2);
            localObject1 = new float[2];
            localObject2 = this.CgW.get(0);
            p.g(localObject2, "pIndices[0]");
            f1 = paramMotionEvent.getX(((Number)localObject2).intValue());
            localObject2 = this.CgW.get(1);
            p.g(localObject2, "pIndices[1]");
            localObject1[0] = ((paramMotionEvent.getX(((Number)localObject2).intValue()) + f1) / 2.0F);
            localObject2 = this.CgW.get(0);
            p.g(localObject2, "pIndices[0]");
            f1 = paramMotionEvent.getY(((Number)localObject2).intValue());
            localObject2 = this.CgW.get(1);
            p.g(localObject2, "pIndices[1]");
            localObject1[1] = ((paramMotionEvent.getY(((Number)localObject2).intValue()) + f1) / 2.0F);
            if (this.Chj)
            {
              f1 = h(this.gT);
              if (Math.abs(f1 - this.Chl) > this.Chk) {
                break label1729;
              }
              this.gT.postRotate(f1 - this.Chl, localObject1[0], localObject1[1]);
              if ((!ag(this.Chm, this.Chl)) && ((int)this.Chl % 90 == 0) && (this.Cho))
              {
                paramMotionEvent = this.paT;
                if (paramMotionEvent != null) {
                  paramMotionEvent.vibrate(10L);
                }
                this.Cho = false;
                this.Chm = this.Chl;
              }
              if (f1 >= this.Chl) {
                break label1723;
              }
            }
            label1723:
            for (boolean bool = true;; bool = false)
            {
              this.Chn = bool;
              if (this.Chi == c.a.Chr)
              {
                paramMotionEvent = new float[2];
                this.gT.mapPoints(paramMotionEvent, new float[] { this.width / 2.0F, this.height / 2.0F });
                this.gT.postTranslate(this.CgZ[0] - paramMotionEvent[0], this.CgZ[1] - paramMotionEvent[1]);
              }
              paramMotionEvent = b.CgU;
              b.a.a(this.gT, (float[])localObject1, this.aXu, this.aXt);
              this.gT.mapPoints(this.Chf, this.Che);
              this.Chg[0] = eMy();
              this.Chg[1] = eMz();
              this.Chg[2] = eMA();
              this.Chg[3] = eMB();
              break;
            }
            label1729:
            if (f1 - this.Chl > 0.0F)
            {
              f1 = this.Chk;
              label1745:
              this.gT.postRotate(f1, localObject1[0], localObject1[1]);
              f1 = h(this.gT);
              if (((!this.Chn) || (f1 > this.Chm + 0.5D)) && (f1 > this.Chm - 0.5D)) {
                break label1958;
              }
              i = (int)((f1 - 90.0F) / 90.0F) * 90;
              if ((Math.abs(f1 - i) <= this.Chk) && (f1 >= i))
              {
                this.gT.postRotate(f1 - i, localObject1[0], localObject1[1]);
                if ((!ag(this.Chl, i)) || (this.Cho))
                {
                  this.Chl = i;
                  this.Cho = false;
                  paramMotionEvent = this.paT;
                  if (paramMotionEvent != null) {
                    paramMotionEvent.vibrate(10L);
                  }
                }
              }
              if (this.Chp != i)
              {
                this.Chp = i;
                this.Cho = true;
              }
            }
            for (this.Chn = true;; this.Chn = false)
            {
              this.Chm = f1;
              break;
              f1 = -this.Chk;
              break label1745;
              label1958:
              i = (int)((90.0F + f1) / 90.0F) * 90;
              if ((Math.abs(f1 - i) <= this.Chk) && (f1 <= i))
              {
                this.gT.postRotate(f1 - i, localObject1[0], localObject1[1]);
                if ((!ag(this.Chl, i)) || (this.Cho))
                {
                  this.Chl = i;
                  this.Cho = false;
                  paramMotionEvent = this.paT;
                  if (paramMotionEvent != null) {
                    paramMotionEvent.vibrate(10L);
                  }
                }
              }
              if (this.Chp != i)
              {
                this.Chp = i;
                this.Cho = true;
              }
            }
            aa(paramMotionEvent);
            int i = this.CgW.indexOf(Integer.valueOf(paramMotionEvent.getActionIndex()));
            this.CgW.remove(i);
            this.CgV.remove(i);
            Z(paramMotionEvent);
            continue;
            this.Cha = b.Cht;
            this.CgV.clear();
            this.CgW.clear();
          }
        }
      }
    }
  }
  
  public final void g(Matrix paramMatrix)
  {
    AppMethodBeat.i(237940);
    p.h(paramMatrix, "m");
    this.gT.set(paramMatrix);
    this.gT.mapPoints(this.Chf, this.Che);
    this.Chg[0] = eMy();
    this.Chg[1] = eMz();
    this.Chg[2] = eMA();
    this.Chg[3] = eMB();
    AppMethodBeat.o(237940);
  }
  
  public final void o(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(237938);
    p.h(paramArrayOfFloat, "<set-?>");
    this.Che = paramArrayOfFloat;
    AppMethodBeat.o(237938);
  }
  
  public final void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(237937);
    p.h(paramMatrix, "<set-?>");
    this.gT = paramMatrix;
    AppMethodBeat.o(237937);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$TouchState;", "", "(Ljava/lang/String;I)V", "NONE", "DRAG", "SCALE", "plugin-recordvideo_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(237933);
      b localb1 = new b("NONE", 0);
      Cht = localb1;
      b localb2 = new b("DRAG", 1);
      Chu = localb2;
      b localb3 = new b("SCALE", 2);
      Chv = localb3;
      Chw = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(237933);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.c.c
 * JD-Core Version:    0.7.0.1
 */