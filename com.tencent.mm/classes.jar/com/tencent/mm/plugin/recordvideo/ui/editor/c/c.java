package com.tencent.mm.plugin.recordvideo.ui.editor.c;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.a.ab;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "", "()V", "CalibrationDistance", "", "TAG", "", "boundArrayDst", "", "getBoundArrayDst", "()[F", "setBoundArrayDst", "([F)V", "boundArrayOut", "getBoundArrayOut", "setBoundArrayOut", "boundArraySrc", "getBoundArraySrc", "setBoundArraySrc", "clockwise", "", "hasInit", "height", "", "getHeight", "()I", "setHeight", "(I)V", "holdX", "getHoldX", "()F", "setHoldX", "(F)V", "holdY", "getHoldY", "setHoldY", "holdingThreshold", "getHoldingThreshold", "setHoldingThreshold", "lastDrag", "lastRotate", "lastStardAngle", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "needVibrator", "pIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pIndices", "pivotDst", "pivotType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$PivotType;", "pointDownRotate", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "selfCalibration", "state", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$TouchState;", "transStart", "transformBoundArray", "getTransformBoundArray", "setTransformBoundArray", "vibrator", "Landroid/os/Vibrator;", "width", "getWidth", "setWidth", "appendTouchEvent", "event", "Landroid/view/MotionEvent;", "findIndices", "", "findMaxBottom", "findMaxRight", "findMinLeft", "findMinTop", "getRotate", "inSafeArea", "newLeft", "newTop", "newRight", "newBottom", "resetHold", "updateMatrix", "m", "updateState", "isEqual", "input", "PivotType", "TouchState", "plugin-recordvideo_release"})
public final class c
{
  private final String TAG;
  public float aXE;
  public float aXF;
  public Matrix gR;
  private boolean hasInit;
  public int height;
  private final Vibrator nQa;
  public int width;
  public Rect xKi;
  private ArrayList<Integer> yfY;
  private ArrayList<Integer> yfZ;
  private float[] yga;
  private float[] ygb;
  private float[] ygc;
  private b ygd;
  public int yge;
  private float ygf;
  private float ygg;
  private float[] ygh;
  private float[] ygi;
  public float[] ygj;
  private float[] ygk;
  private c.a ygl;
  private boolean ygm;
  private float ygn;
  private float ygo;
  private float ygp;
  private boolean ygq;
  private boolean ygr;
  private int ygs;
  
  public c()
  {
    AppMethodBeat.i(207109);
    this.TAG = "TouchTracker";
    this.yfY = new ArrayList();
    this.yfZ = new ArrayList();
    this.yga = new float[2];
    this.ygb = new float[4];
    this.ygc = new float[2];
    this.ygd = b.ygw;
    this.gR = new Matrix();
    this.ygh = new float[8];
    this.ygi = new float[8];
    this.ygj = new float[4];
    this.ygk = new float[4];
    this.aXE = 10.0F;
    this.aXF = 0.1F;
    this.ygl = c.a.ygt;
    this.ygm = true;
    this.ygn = 15.0F;
    Object localObject = ak.getContext().getSystemService("vibrator");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(207109);
      throw ((Throwable)localObject);
    }
    this.nQa = ((Vibrator)localObject);
    this.ygr = true;
    this.gR.setScale(1.0F, 1.0F);
    AppMethodBeat.o(207109);
  }
  
  private final void V(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207101);
    Object localObject1;
    Object localObject2;
    if (this.yfY.size() == 1)
    {
      this.ygd = b.ygx;
      localObject1 = this.yga;
      localObject2 = this.yfZ.get(0);
      p.g(localObject2, "pIndices[0]");
      localObject1[0] = paramMotionEvent.getX(((Number)localObject2).intValue());
      localObject1 = this.yga;
      localObject2 = this.yfZ.get(0);
      p.g(localObject2, "pIndices[0]");
      localObject1[1] = paramMotionEvent.getY(((Number)localObject2).intValue());
      AppMethodBeat.o(207101);
      return;
    }
    if (this.yfY.size() == 2)
    {
      this.ygd = b.ygy;
      if (this.ygl == c.a.ygu) {
        this.gR.mapPoints(this.ygc, new float[] { this.width / 2.0F, this.height / 2.0F });
      }
      localObject1 = new Matrix();
      this.gR.invert((Matrix)localObject1);
      W(paramMotionEvent);
      if ((p.compare(((Number)this.yfZ.get(0)).intValue(), paramMotionEvent.getPointerCount()) < 0) && (p.compare(((Number)this.yfZ.get(1)).intValue(), paramMotionEvent.getPointerCount()) < 0))
      {
        localObject2 = this.ygb;
        Object localObject3 = this.yfZ.get(0);
        p.g(localObject3, "pIndices[0]");
        float f1 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.yfZ.get(0);
        p.g(localObject3, "pIndices[0]");
        float f2 = paramMotionEvent.getY(((Number)localObject3).intValue());
        localObject3 = this.yfZ.get(1);
        p.g(localObject3, "pIndices[1]");
        float f3 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.yfZ.get(1);
        p.g(localObject3, "pIndices[1]");
        ((Matrix)localObject1).mapPoints((float[])localObject2, new float[] { f1, f2, f3, paramMotionEvent.getY(((Number)localObject3).intValue()) });
      }
    }
    AppMethodBeat.o(207101);
  }
  
  private final void W(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207102);
    Iterator localIterator = ((Iterable)j.o((Collection)this.yfY)).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ab)localIterator).nextInt();
      ArrayList localArrayList = this.yfZ;
      Object localObject = this.yfY.get(i);
      p.g(localObject, "pIds[i]");
      localArrayList.set(i, Integer.valueOf(paramMotionEvent.findPointerIndex(((Number)localObject).intValue())));
    }
    AppMethodBeat.o(207102);
  }
  
  private static boolean ab(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(207108);
    if (Math.abs(paramFloat1 - paramFloat2) < 0.2F)
    {
      AppMethodBeat.o(207108);
      return true;
    }
    AppMethodBeat.o(207108);
    return false;
  }
  
  private final float dLA()
  {
    AppMethodBeat.i(207104);
    float f2 = this.ygi[0];
    float[] arrayOfFloat = this.ygi;
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
    AppMethodBeat.o(207104);
    return f2;
  }
  
  private final float dLB()
  {
    AppMethodBeat.i(207105);
    float f2 = this.ygi[1];
    float[] arrayOfFloat = this.ygi;
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
    AppMethodBeat.o(207105);
    return f2;
  }
  
  private final float dLC()
  {
    AppMethodBeat.i(207106);
    float f2 = this.ygi[0];
    float[] arrayOfFloat = this.ygi;
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
    AppMethodBeat.o(207106);
    return f2;
  }
  
  private final float dLD()
  {
    AppMethodBeat.i(207107);
    float f2 = this.ygi[1];
    float[] arrayOfFloat = this.ygi;
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
    AppMethodBeat.o(207107);
    return f2;
  }
  
  private final void dLz()
  {
    this.ygf = 0.0F;
    this.ygg = 0.0F;
  }
  
  private final float h(Matrix paramMatrix)
  {
    AppMethodBeat.i(207100);
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    float f2 = (float)(Math.atan2(arrayOfFloat[1], arrayOfFloat[0]) * 57.295779513082323D);
    float f1;
    if ((this.ygp < -90.0F) && (f2 > 0.0F)) {
      f1 = f2 - 360.0F;
    }
    for (;;)
    {
      AppMethodBeat.o(207100);
      return f1;
      f1 = f2;
      if (this.ygp > 90.0F)
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
    AppMethodBeat.i(207103);
    Rect localRect = this.xKi;
    if (localRect == null) {
      p.gkB();
    }
    if (paramFloat1 > localRect.left)
    {
      localRect = this.xKi;
      if (localRect == null) {
        p.gkB();
      }
      if (paramFloat1 < localRect.right)
      {
        localRect = this.xKi;
        if (localRect == null) {
          p.gkB();
        }
        if (paramFloat2 > localRect.top)
        {
          localRect = this.xKi;
          if (localRect == null) {
            p.gkB();
          }
          if (paramFloat2 < localRect.bottom)
          {
            localRect = this.xKi;
            if (localRect == null) {
              p.gkB();
            }
            if (paramFloat3 > localRect.left)
            {
              localRect = this.xKi;
              if (localRect == null) {
                p.gkB();
              }
              if (paramFloat3 < localRect.right)
              {
                localRect = this.xKi;
                if (localRect == null) {
                  p.gkB();
                }
                if (paramFloat4 > localRect.top)
                {
                  localRect = this.xKi;
                  if (localRect == null) {
                    p.gkB();
                  }
                  if (paramFloat4 < localRect.bottom)
                  {
                    AppMethodBeat.o(207103);
                    return true;
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(207103);
    return false;
  }
  
  public final boolean U(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207098);
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207098);
      return true;
      Object localObject1 = new float[2];
      Object localObject2 = new Matrix();
      this.gR.invert((Matrix)localObject2);
      ((Matrix)localObject2).mapPoints((float[])localObject1, new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
      if ((localObject1[0] < 0.0F) || (localObject1[0] > this.width) || (localObject1[1] < 0.0F) || (localObject1[1] > this.height))
      {
        AppMethodBeat.o(207098);
        return false;
      }
      this.yfY.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
      this.yfZ.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
      V(paramMotionEvent);
      if (!this.hasInit)
      {
        localObject1 = this.yfZ.get(0);
        p.g(localObject1, "pIndices[0]");
        float f1 = paramMotionEvent.getX(((Number)localObject1).intValue());
        localObject1 = this.yfZ.get(0);
        p.g(localObject1, "pIndices[0]");
        float f2 = paramMotionEvent.getY(((Number)localObject1).intValue());
        float f3 = this.yga[0];
        float f4 = this.yga[1];
        this.gR.postTranslate(f1 - f3, f2 - f4);
        this.yga[0] = f1;
        this.yga[1] = f2;
        this.gR.mapPoints(this.ygi, this.ygh);
        this.ygj[0] = dLA();
        this.ygj[1] = dLB();
        this.ygj[2] = dLC();
        this.ygj[3] = dLD();
        this.hasInit = true;
        continue;
        this.yfY.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
        this.yfZ.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
        V(paramMotionEvent);
        if (paramMotionEvent.getPointerCount() == 2)
        {
          this.ygp = 0.0F;
          this.ygo = h(this.gR);
          this.ygp = this.ygo;
          ae.i(this.TAG, "downRotate :" + this.ygo);
          continue;
          W(paramMotionEvent);
          if (paramMotionEvent.getPointerCount() == 1) {
            this.ygd = b.ygx;
          }
          localObject1 = this.ygd;
          switch (d.cqt[localObject1.ordinal()])
          {
          default: 
            break;
          case 1: 
            localObject1 = this.yfZ.get(0);
            p.g(localObject1, "pIndices[0]");
            f2 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.yfZ.get(0);
            p.g(localObject1, "pIndices[0]");
            f3 = paramMotionEvent.getY(((Number)localObject1).intValue());
            f4 = f2 - this.yga[0];
            f1 = f3 - this.yga[1];
            this.gR.postTranslate(f4, f1);
            this.yga[0] = f2;
            this.yga[1] = f3;
            this.gR.mapPoints(this.ygi, this.ygh);
            this.ygj[0] = dLA();
            this.ygj[1] = dLB();
            this.ygj[2] = dLC();
            this.ygj[3] = dLD();
            if ((this.xKi != null) && (!o(this.ygj[0] + f4, this.ygj[1] + f1, this.ygj[2] + f4, this.ygj[3] + f1)))
            {
              f2 = Math.abs(f4);
              f1 = Math.abs(f1);
              paramMotionEvent = this.xKi;
              if (paramMotionEvent == null) {
                p.gkB();
              }
              if ((paramMotionEvent.left >= this.ygj[0]) && (this.ygf <= this.yge))
              {
                paramMotionEvent = this.gR;
                localObject1 = this.xKi;
                if (localObject1 == null) {
                  p.gkB();
                }
                paramMotionEvent.postTranslate(((Rect)localObject1).left - this.ygj[0], 0.0F);
                this.ygf += f2;
              }
              paramMotionEvent = this.xKi;
              if (paramMotionEvent == null) {
                p.gkB();
              }
              if ((paramMotionEvent.top >= this.ygj[1]) && (this.ygg <= this.yge))
              {
                paramMotionEvent = this.gR;
                localObject1 = this.xKi;
                if (localObject1 == null) {
                  p.gkB();
                }
                paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).top - this.ygj[1]);
                this.ygg += f1;
              }
              paramMotionEvent = this.xKi;
              if (paramMotionEvent == null) {
                p.gkB();
              }
              if ((paramMotionEvent.right <= this.ygj[2]) && (this.ygf <= this.yge))
              {
                paramMotionEvent = this.gR;
                localObject1 = this.xKi;
                if (localObject1 == null) {
                  p.gkB();
                }
                paramMotionEvent.postTranslate(((Rect)localObject1).right - this.ygj[2], 0.0F);
                this.ygf = (f2 + this.ygf);
              }
              paramMotionEvent = this.xKi;
              if (paramMotionEvent == null) {
                p.gkB();
              }
              if ((paramMotionEvent.bottom <= this.ygj[3]) && (this.ygg <= this.yge))
              {
                paramMotionEvent = this.gR;
                localObject1 = this.xKi;
                if (localObject1 == null) {
                  p.gkB();
                }
                paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).bottom - this.ygj[3]);
                this.ygg += f1;
              }
            }
            else
            {
              dLz();
            }
            break;
          case 2: 
            localObject1 = this.yfZ.get(0);
            p.g(localObject1, "pIndices[0]");
            f1 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.yfZ.get(0);
            p.g(localObject1, "pIndices[0]");
            f2 = paramMotionEvent.getY(((Number)localObject1).intValue());
            localObject1 = this.yfZ.get(1);
            p.g(localObject1, "pIndices[1]");
            f3 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.yfZ.get(1);
            p.g(localObject1, "pIndices[1]");
            f4 = paramMotionEvent.getY(((Number)localObject1).intValue());
            this.gR.setPolyToPoly(this.ygb, 0, new float[] { f1, f2, f3, f4 }, 0, 2);
            localObject1 = new float[2];
            localObject2 = this.yfZ.get(0);
            p.g(localObject2, "pIndices[0]");
            f1 = paramMotionEvent.getX(((Number)localObject2).intValue());
            localObject2 = this.yfZ.get(1);
            p.g(localObject2, "pIndices[1]");
            localObject1[0] = ((paramMotionEvent.getX(((Number)localObject2).intValue()) + f1) / 2.0F);
            localObject2 = this.yfZ.get(0);
            p.g(localObject2, "pIndices[0]");
            f1 = paramMotionEvent.getY(((Number)localObject2).intValue());
            localObject2 = this.yfZ.get(1);
            p.g(localObject2, "pIndices[1]");
            localObject1[1] = ((paramMotionEvent.getY(((Number)localObject2).intValue()) + f1) / 2.0F);
            if (this.ygm)
            {
              f1 = h(this.gR);
              if (Math.abs(f1 - this.ygo) > this.ygn) {
                break label1727;
              }
              this.gR.postRotate(f1 - this.ygo, localObject1[0], localObject1[1]);
              if ((!ab(this.ygp, this.ygo)) && ((int)this.ygo % 90 == 0) && (this.ygr))
              {
                this.nQa.vibrate(VibrationEffect.createOneShot(10L, -1));
                this.ygr = false;
                this.ygp = this.ygo;
              }
              if (f1 >= this.ygo) {
                break label1721;
              }
            }
            label1721:
            for (boolean bool = true;; bool = false)
            {
              this.ygq = bool;
              if (this.ygl == c.a.ygu)
              {
                paramMotionEvent = new float[2];
                this.gR.mapPoints(paramMotionEvent, new float[] { this.width / 2.0F, this.height / 2.0F });
                this.gR.postTranslate(this.ygc[0] - paramMotionEvent[0], this.ygc[1] - paramMotionEvent[1]);
              }
              paramMotionEvent = b.yfX;
              b.a.a(this.gR, (float[])localObject1, this.aXF, this.aXE);
              this.gR.mapPoints(this.ygi, this.ygh);
              this.ygj[0] = dLA();
              this.ygj[1] = dLB();
              this.ygj[2] = dLC();
              this.ygj[3] = dLD();
              break;
            }
            label1727:
            if (f1 - this.ygo > 0.0F)
            {
              f1 = this.ygn;
              label1743:
              this.gR.postRotate(f1, localObject1[0], localObject1[1]);
              f1 = h(this.gR);
              if (((!this.ygq) || (f1 > this.ygp + 0.5D)) && (f1 > this.ygp - 0.5D)) {
                break label1954;
              }
              i = (int)((f1 - 90.0F) / 90.0F) * 90;
              if ((Math.abs(f1 - i) <= this.ygn) && (f1 >= i))
              {
                this.gR.postRotate(f1 - i, localObject1[0], localObject1[1]);
                if ((!ab(this.ygo, i)) || (this.ygr))
                {
                  this.ygo = i;
                  this.ygr = false;
                  this.nQa.vibrate(VibrationEffect.createOneShot(10L, -1));
                }
              }
              if (this.ygs != i)
              {
                this.ygs = i;
                this.ygr = true;
              }
            }
            for (this.ygq = true;; this.ygq = false)
            {
              this.ygp = f1;
              break;
              f1 = -this.ygn;
              break label1743;
              label1954:
              i = (int)((90.0F + f1) / 90.0F) * 90;
              if ((Math.abs(f1 - i) <= this.ygn) && (f1 <= i))
              {
                this.gR.postRotate(f1 - i, localObject1[0], localObject1[1]);
                if ((!ab(this.ygo, i)) || (this.ygr))
                {
                  this.ygo = i;
                  this.ygr = false;
                  this.nQa.vibrate(VibrationEffect.createOneShot(10L, -1));
                }
              }
              if (this.ygs != i)
              {
                this.ygs = i;
                this.ygr = true;
              }
            }
            W(paramMotionEvent);
            int i = this.yfZ.indexOf(Integer.valueOf(paramMotionEvent.getActionIndex()));
            this.yfZ.remove(i);
            this.yfY.remove(i);
            V(paramMotionEvent);
            continue;
            this.ygd = b.ygw;
            this.yfY.clear();
            this.yfZ.clear();
          }
        }
      }
    }
  }
  
  public final void g(Matrix paramMatrix)
  {
    AppMethodBeat.i(207099);
    p.h(paramMatrix, "m");
    this.gR.set(paramMatrix);
    this.gR.mapPoints(this.ygi, this.ygh);
    this.ygj[0] = dLA();
    this.ygj[1] = dLB();
    this.ygj[2] = dLC();
    this.ygj[3] = dLD();
    AppMethodBeat.o(207099);
  }
  
  public final void o(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(207097);
    p.h(paramArrayOfFloat, "<set-?>");
    this.ygh = paramArrayOfFloat;
    AppMethodBeat.o(207097);
  }
  
  public final void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(207096);
    p.h(paramMatrix, "<set-?>");
    this.gR = paramMatrix;
    AppMethodBeat.o(207096);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$TouchState;", "", "(Ljava/lang/String;I)V", "NONE", "DRAG", "SCALE", "plugin-recordvideo_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(207092);
      b localb1 = new b("NONE", 0);
      ygw = localb1;
      b localb2 = new b("DRAG", 1);
      ygx = localb2;
      b localb3 = new b("SCALE", 2);
      ygy = localb3;
      ygz = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(207092);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.c.c
 * JD-Core Version:    0.7.0.1
 */