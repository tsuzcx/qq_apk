package com.tencent.mm.plugin.recordvideo.ui.editor.c;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.a.ab;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "", "()V", "CalibrationDistance", "", "TAG", "", "boundArrayDst", "", "getBoundArrayDst", "()[F", "setBoundArrayDst", "([F)V", "boundArrayOut", "getBoundArrayOut", "setBoundArrayOut", "boundArraySrc", "getBoundArraySrc", "setBoundArraySrc", "clockwise", "", "hasInit", "height", "", "getHeight", "()I", "setHeight", "(I)V", "holdX", "getHoldX", "()F", "setHoldX", "(F)V", "holdY", "getHoldY", "setHoldY", "holdingThreshold", "getHoldingThreshold", "setHoldingThreshold", "lastDrag", "lastRotate", "lastStardAngle", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "needVibrator", "pIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pIndices", "pivotDst", "pivotType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$PivotType;", "pointDownRotate", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "selfCalibration", "state", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$TouchState;", "transStart", "transformBoundArray", "getTransformBoundArray", "setTransformBoundArray", "vibrator", "Landroid/os/Vibrator;", "width", "getWidth", "setWidth", "appendTouchEvent", "event", "Landroid/view/MotionEvent;", "findIndices", "", "findMaxBottom", "findMaxRight", "findMinLeft", "findMinTop", "getRotate", "inSafeArea", "newLeft", "newTop", "newRight", "newBottom", "resetHold", "updateMatrix", "m", "updateState", "isEqual", "input", "PivotType", "TouchState", "plugin-recordvideo_release"})
public final class c
{
  private final String TAG;
  public float aXE;
  public float aXF;
  public Matrix gR;
  private boolean hasInit;
  public int height;
  private final Vibrator nKv;
  public int width;
  private ArrayList<Integer> xQf;
  private ArrayList<Integer> xQg;
  private float[] xQh;
  private float[] xQi;
  private float[] xQj;
  private b xQk;
  public int xQl;
  private float xQm;
  private float xQn;
  private float[] xQo;
  private float[] xQp;
  public float[] xQq;
  private float[] xQr;
  private c.a xQs;
  private boolean xQt;
  private float xQu;
  private float xQv;
  private float xQw;
  private boolean xQx;
  private boolean xQy;
  private int xQz;
  public Rect xul;
  
  public c()
  {
    AppMethodBeat.i(200851);
    this.TAG = "TouchTracker";
    this.xQf = new ArrayList();
    this.xQg = new ArrayList();
    this.xQh = new float[2];
    this.xQi = new float[4];
    this.xQj = new float[2];
    this.xQk = b.xQD;
    this.gR = new Matrix();
    this.xQo = new float[8];
    this.xQp = new float[8];
    this.xQq = new float[4];
    this.xQr = new float[4];
    this.aXE = 10.0F;
    this.aXF = 0.1F;
    this.xQs = c.a.xQA;
    this.xQt = true;
    this.xQu = 15.0F;
    Object localObject = aj.getContext().getSystemService("vibrator");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(200851);
      throw ((Throwable)localObject);
    }
    this.nKv = ((Vibrator)localObject);
    this.xQy = true;
    this.gR.setScale(1.0F, 1.0F);
    AppMethodBeat.o(200851);
  }
  
  private final void X(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200843);
    Object localObject1;
    Object localObject2;
    if (this.xQf.size() == 1)
    {
      this.xQk = b.xQE;
      localObject1 = this.xQh;
      localObject2 = this.xQg.get(0);
      p.g(localObject2, "pIndices[0]");
      localObject1[0] = paramMotionEvent.getX(((Number)localObject2).intValue());
      localObject1 = this.xQh;
      localObject2 = this.xQg.get(0);
      p.g(localObject2, "pIndices[0]");
      localObject1[1] = paramMotionEvent.getY(((Number)localObject2).intValue());
      AppMethodBeat.o(200843);
      return;
    }
    if (this.xQf.size() == 2)
    {
      this.xQk = b.xQF;
      if (this.xQs == c.a.xQB) {
        this.gR.mapPoints(this.xQj, new float[] { this.width / 2.0F, this.height / 2.0F });
      }
      localObject1 = new Matrix();
      this.gR.invert((Matrix)localObject1);
      Y(paramMotionEvent);
      if ((p.compare(((Number)this.xQg.get(0)).intValue(), paramMotionEvent.getPointerCount()) < 0) && (p.compare(((Number)this.xQg.get(1)).intValue(), paramMotionEvent.getPointerCount()) < 0))
      {
        localObject2 = this.xQi;
        Object localObject3 = this.xQg.get(0);
        p.g(localObject3, "pIndices[0]");
        float f1 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.xQg.get(0);
        p.g(localObject3, "pIndices[0]");
        float f2 = paramMotionEvent.getY(((Number)localObject3).intValue());
        localObject3 = this.xQg.get(1);
        p.g(localObject3, "pIndices[1]");
        float f3 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.xQg.get(1);
        p.g(localObject3, "pIndices[1]");
        ((Matrix)localObject1).mapPoints((float[])localObject2, new float[] { f1, f2, f3, paramMotionEvent.getY(((Number)localObject3).intValue()) });
      }
    }
    AppMethodBeat.o(200843);
  }
  
  private final void Y(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200844);
    Iterator localIterator = ((Iterable)j.o((Collection)this.xQf)).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ab)localIterator).nextInt();
      ArrayList localArrayList = this.xQg;
      Object localObject = this.xQf.get(i);
      p.g(localObject, "pIds[i]");
      localArrayList.set(i, Integer.valueOf(paramMotionEvent.findPointerIndex(((Number)localObject).intValue())));
    }
    AppMethodBeat.o(200844);
  }
  
  private static boolean ab(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(200850);
    if (Math.abs(paramFloat1 - paramFloat2) < 0.2F)
    {
      AppMethodBeat.o(200850);
      return true;
    }
    AppMethodBeat.o(200850);
    return false;
  }
  
  private final void dIi()
  {
    this.xQm = 0.0F;
    this.xQn = 0.0F;
  }
  
  private final float dIj()
  {
    AppMethodBeat.i(200846);
    float f2 = this.xQp[0];
    float[] arrayOfFloat = this.xQp;
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
    AppMethodBeat.o(200846);
    return f2;
  }
  
  private final float dIk()
  {
    AppMethodBeat.i(200847);
    float f2 = this.xQp[1];
    float[] arrayOfFloat = this.xQp;
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
    AppMethodBeat.o(200847);
    return f2;
  }
  
  private final float dIl()
  {
    AppMethodBeat.i(200848);
    float f2 = this.xQp[0];
    float[] arrayOfFloat = this.xQp;
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
    AppMethodBeat.o(200848);
    return f2;
  }
  
  private final float dIm()
  {
    AppMethodBeat.i(200849);
    float f2 = this.xQp[1];
    float[] arrayOfFloat = this.xQp;
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
    AppMethodBeat.o(200849);
    return f2;
  }
  
  private final float h(Matrix paramMatrix)
  {
    AppMethodBeat.i(200842);
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    float f2 = (float)(Math.atan2(arrayOfFloat[1], arrayOfFloat[0]) * 57.295779513082323D);
    float f1;
    if ((this.xQw < -90.0F) && (f2 > 0.0F)) {
      f1 = f2 - 360.0F;
    }
    for (;;)
    {
      AppMethodBeat.o(200842);
      return f1;
      f1 = f2;
      if (this.xQw > 90.0F)
      {
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = f2 + 360.0F;
        }
      }
    }
  }
  
  private final boolean o(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(200845);
    Rect localRect = this.xul;
    if (localRect == null) {
      p.gfZ();
    }
    if (paramFloat1 > localRect.left)
    {
      localRect = this.xul;
      if (localRect == null) {
        p.gfZ();
      }
      if (paramFloat1 < localRect.right)
      {
        localRect = this.xul;
        if (localRect == null) {
          p.gfZ();
        }
        if (paramFloat2 > localRect.top)
        {
          localRect = this.xul;
          if (localRect == null) {
            p.gfZ();
          }
          if (paramFloat2 < localRect.bottom)
          {
            localRect = this.xul;
            if (localRect == null) {
              p.gfZ();
            }
            if (paramFloat3 > localRect.left)
            {
              localRect = this.xul;
              if (localRect == null) {
                p.gfZ();
              }
              if (paramFloat3 < localRect.right)
              {
                localRect = this.xul;
                if (localRect == null) {
                  p.gfZ();
                }
                if (paramFloat4 > localRect.top)
                {
                  localRect = this.xul;
                  if (localRect == null) {
                    p.gfZ();
                  }
                  if (paramFloat4 < localRect.bottom)
                  {
                    AppMethodBeat.o(200845);
                    return true;
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(200845);
    return false;
  }
  
  public final boolean W(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200840);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200840);
      return true;
      Object localObject1 = new float[2];
      Object localObject2 = new Matrix();
      this.gR.invert((Matrix)localObject2);
      ((Matrix)localObject2).mapPoints((float[])localObject1, new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
      if ((localObject1[0] < 0.0F) || (localObject1[0] > this.width) || (localObject1[1] < 0.0F) || (localObject1[1] > this.height))
      {
        AppMethodBeat.o(200840);
        return false;
      }
      this.xQf.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
      this.xQg.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
      X(paramMotionEvent);
      if (!this.hasInit)
      {
        localObject1 = this.xQg.get(0);
        p.g(localObject1, "pIndices[0]");
        float f1 = paramMotionEvent.getX(((Number)localObject1).intValue());
        localObject1 = this.xQg.get(0);
        p.g(localObject1, "pIndices[0]");
        float f2 = paramMotionEvent.getY(((Number)localObject1).intValue());
        float f3 = this.xQh[0];
        float f4 = this.xQh[1];
        this.gR.postTranslate(f1 - f3, f2 - f4);
        this.xQh[0] = f1;
        this.xQh[1] = f2;
        this.gR.mapPoints(this.xQp, this.xQo);
        this.xQq[0] = dIj();
        this.xQq[1] = dIk();
        this.xQq[2] = dIl();
        this.xQq[3] = dIm();
        this.hasInit = true;
        continue;
        this.xQf.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
        this.xQg.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
        X(paramMotionEvent);
        if (paramMotionEvent.getPointerCount() == 2)
        {
          this.xQw = 0.0F;
          this.xQv = h(this.gR);
          this.xQw = this.xQv;
          ad.i(this.TAG, "downRotate :" + this.xQv);
          continue;
          Y(paramMotionEvent);
          if (paramMotionEvent.getPointerCount() == 1) {
            this.xQk = b.xQE;
          }
          localObject1 = this.xQk;
          switch (d.cpQ[localObject1.ordinal()])
          {
          default: 
            break;
          case 1: 
            localObject1 = this.xQg.get(0);
            p.g(localObject1, "pIndices[0]");
            f2 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.xQg.get(0);
            p.g(localObject1, "pIndices[0]");
            f3 = paramMotionEvent.getY(((Number)localObject1).intValue());
            f4 = f2 - this.xQh[0];
            f1 = f3 - this.xQh[1];
            this.gR.postTranslate(f4, f1);
            this.xQh[0] = f2;
            this.xQh[1] = f3;
            this.gR.mapPoints(this.xQp, this.xQo);
            this.xQq[0] = dIj();
            this.xQq[1] = dIk();
            this.xQq[2] = dIl();
            this.xQq[3] = dIm();
            if ((this.xul != null) && (!o(this.xQq[0] + f4, this.xQq[1] + f1, this.xQq[2] + f4, this.xQq[3] + f1)))
            {
              f2 = Math.abs(f4);
              f1 = Math.abs(f1);
              paramMotionEvent = this.xul;
              if (paramMotionEvent == null) {
                p.gfZ();
              }
              if ((paramMotionEvent.left >= this.xQq[0]) && (this.xQm <= this.xQl))
              {
                paramMotionEvent = this.gR;
                localObject1 = this.xul;
                if (localObject1 == null) {
                  p.gfZ();
                }
                paramMotionEvent.postTranslate(((Rect)localObject1).left - this.xQq[0], 0.0F);
                this.xQm += f2;
              }
              paramMotionEvent = this.xul;
              if (paramMotionEvent == null) {
                p.gfZ();
              }
              if ((paramMotionEvent.top >= this.xQq[1]) && (this.xQn <= this.xQl))
              {
                paramMotionEvent = this.gR;
                localObject1 = this.xul;
                if (localObject1 == null) {
                  p.gfZ();
                }
                paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).top - this.xQq[1]);
                this.xQn += f1;
              }
              paramMotionEvent = this.xul;
              if (paramMotionEvent == null) {
                p.gfZ();
              }
              if ((paramMotionEvent.right <= this.xQq[2]) && (this.xQm <= this.xQl))
              {
                paramMotionEvent = this.gR;
                localObject1 = this.xul;
                if (localObject1 == null) {
                  p.gfZ();
                }
                paramMotionEvent.postTranslate(((Rect)localObject1).right - this.xQq[2], 0.0F);
                this.xQm = (f2 + this.xQm);
              }
              paramMotionEvent = this.xul;
              if (paramMotionEvent == null) {
                p.gfZ();
              }
              if ((paramMotionEvent.bottom <= this.xQq[3]) && (this.xQn <= this.xQl))
              {
                paramMotionEvent = this.gR;
                localObject1 = this.xul;
                if (localObject1 == null) {
                  p.gfZ();
                }
                paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).bottom - this.xQq[3]);
                this.xQn += f1;
              }
            }
            else
            {
              dIi();
            }
            break;
          case 2: 
            localObject1 = this.xQg.get(0);
            p.g(localObject1, "pIndices[0]");
            f1 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.xQg.get(0);
            p.g(localObject1, "pIndices[0]");
            f2 = paramMotionEvent.getY(((Number)localObject1).intValue());
            localObject1 = this.xQg.get(1);
            p.g(localObject1, "pIndices[1]");
            f3 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.xQg.get(1);
            p.g(localObject1, "pIndices[1]");
            f4 = paramMotionEvent.getY(((Number)localObject1).intValue());
            this.gR.setPolyToPoly(this.xQi, 0, new float[] { f1, f2, f3, f4 }, 0, 2);
            localObject1 = new float[2];
            localObject2 = this.xQg.get(0);
            p.g(localObject2, "pIndices[0]");
            f1 = paramMotionEvent.getX(((Number)localObject2).intValue());
            localObject2 = this.xQg.get(1);
            p.g(localObject2, "pIndices[1]");
            localObject1[0] = ((paramMotionEvent.getX(((Number)localObject2).intValue()) + f1) / 2.0F);
            localObject2 = this.xQg.get(0);
            p.g(localObject2, "pIndices[0]");
            f1 = paramMotionEvent.getY(((Number)localObject2).intValue());
            localObject2 = this.xQg.get(1);
            p.g(localObject2, "pIndices[1]");
            localObject1[1] = ((paramMotionEvent.getY(((Number)localObject2).intValue()) + f1) / 2.0F);
            if (this.xQt)
            {
              f1 = h(this.gR);
              if (Math.abs(f1 - this.xQv) > this.xQu) {
                break label1727;
              }
              this.gR.postRotate(f1 - this.xQv, localObject1[0], localObject1[1]);
              if ((!ab(this.xQw, this.xQv)) && ((int)this.xQv % 90 == 0) && (this.xQy))
              {
                this.nKv.vibrate(VibrationEffect.createOneShot(10L, -1));
                this.xQy = false;
                this.xQw = this.xQv;
              }
              if (f1 >= this.xQv) {
                break label1721;
              }
            }
            label1721:
            for (boolean bool = true;; bool = false)
            {
              this.xQx = bool;
              if (this.xQs == c.a.xQB)
              {
                paramMotionEvent = new float[2];
                this.gR.mapPoints(paramMotionEvent, new float[] { this.width / 2.0F, this.height / 2.0F });
                this.gR.postTranslate(this.xQj[0] - paramMotionEvent[0], this.xQj[1] - paramMotionEvent[1]);
              }
              paramMotionEvent = b.xQe;
              b.a.a(this.gR, (float[])localObject1, this.aXF, this.aXE);
              this.gR.mapPoints(this.xQp, this.xQo);
              this.xQq[0] = dIj();
              this.xQq[1] = dIk();
              this.xQq[2] = dIl();
              this.xQq[3] = dIm();
              break;
            }
            label1727:
            if (f1 - this.xQv > 0.0F)
            {
              f1 = this.xQu;
              label1743:
              this.gR.postRotate(f1, localObject1[0], localObject1[1]);
              f1 = h(this.gR);
              if (((!this.xQx) || (f1 > this.xQw + 0.5D)) && (f1 > this.xQw - 0.5D)) {
                break label1954;
              }
              i = (int)((f1 - 90.0F) / 90.0F) * 90;
              if ((Math.abs(f1 - i) <= this.xQu) && (f1 >= i))
              {
                this.gR.postRotate(f1 - i, localObject1[0], localObject1[1]);
                if ((!ab(this.xQv, i)) || (this.xQy))
                {
                  this.xQv = i;
                  this.xQy = false;
                  this.nKv.vibrate(VibrationEffect.createOneShot(10L, -1));
                }
              }
              if (this.xQz != i)
              {
                this.xQz = i;
                this.xQy = true;
              }
            }
            for (this.xQx = true;; this.xQx = false)
            {
              this.xQw = f1;
              break;
              f1 = -this.xQu;
              break label1743;
              label1954:
              i = (int)((90.0F + f1) / 90.0F) * 90;
              if ((Math.abs(f1 - i) <= this.xQu) && (f1 <= i))
              {
                this.gR.postRotate(f1 - i, localObject1[0], localObject1[1]);
                if ((!ab(this.xQv, i)) || (this.xQy))
                {
                  this.xQv = i;
                  this.xQy = false;
                  this.nKv.vibrate(VibrationEffect.createOneShot(10L, -1));
                }
              }
              if (this.xQz != i)
              {
                this.xQz = i;
                this.xQy = true;
              }
            }
            Y(paramMotionEvent);
            int i = this.xQg.indexOf(Integer.valueOf(paramMotionEvent.getActionIndex()));
            this.xQg.remove(i);
            this.xQf.remove(i);
            X(paramMotionEvent);
            continue;
            this.xQk = b.xQD;
            this.xQf.clear();
            this.xQg.clear();
          }
        }
      }
    }
  }
  
  public final void g(Matrix paramMatrix)
  {
    AppMethodBeat.i(200841);
    p.h(paramMatrix, "m");
    this.gR.set(paramMatrix);
    this.gR.mapPoints(this.xQp, this.xQo);
    this.xQq[0] = dIj();
    this.xQq[1] = dIk();
    this.xQq[2] = dIl();
    this.xQq[3] = dIm();
    AppMethodBeat.o(200841);
  }
  
  public final void o(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(200839);
    p.h(paramArrayOfFloat, "<set-?>");
    this.xQo = paramArrayOfFloat;
    AppMethodBeat.o(200839);
  }
  
  public final void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(200838);
    p.h(paramMatrix, "<set-?>");
    this.gR = paramMatrix;
    AppMethodBeat.o(200838);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$TouchState;", "", "(Ljava/lang/String;I)V", "NONE", "DRAG", "SCALE", "plugin-recordvideo_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(200834);
      b localb1 = new b("NONE", 0);
      xQD = localb1;
      b localb2 = new b("DRAG", 1);
      xQE = localb2;
      b localb3 = new b("SCALE", 2);
      xQF = localb3;
      xQG = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(200834);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.c.c
 * JD-Core Version:    0.7.0.1
 */