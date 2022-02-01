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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "", "()V", "CalibrationDistance", "", "TAG", "", "boundArrayDst", "", "getBoundArrayDst", "()[F", "setBoundArrayDst", "([F)V", "boundArrayOut", "getBoundArrayOut", "setBoundArrayOut", "boundArraySrc", "getBoundArraySrc", "setBoundArraySrc", "clockwise", "", "hasInit", "height", "", "getHeight", "()I", "setHeight", "(I)V", "holdX", "getHoldX", "()F", "setHoldX", "(F)V", "holdY", "getHoldY", "setHoldY", "holdingThreshold", "getHoldingThreshold", "setHoldingThreshold", "lastDrag", "lastRotate", "lastStardAngle", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "needVibrator", "pIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pIndices", "pivotDst", "pivotType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$PivotType;", "pointDownRotate", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "selfCalibration", "state", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$TouchState;", "transStart", "transformBoundArray", "getTransformBoundArray", "setTransformBoundArray", "vibrator", "Landroid/os/Vibrator;", "width", "getWidth", "setWidth", "appendTouchEvent", "event", "Landroid/view/MotionEvent;", "findIndices", "", "findMaxBottom", "findMaxRight", "findMinLeft", "findMinTop", "getRotate", "inSafeArea", "newLeft", "newTop", "newRight", "newBottom", "resetHold", "updateMatrix", "m", "updateState", "isEqual", "input", "PivotType", "TouchState", "plugin-recordvideo_release"})
public final class c
{
  public Rect HGw;
  private ArrayList<Integer> IdL;
  private ArrayList<Integer> IdM;
  private float[] IdN;
  private float[] IdO;
  private float[] IdP;
  private b IdQ;
  public int IdR;
  private float IdS;
  private float IdT;
  private float[] IdU;
  private float[] IdV;
  public float[] IdW;
  private float[] IdX;
  private c.a IdY;
  private boolean IdZ;
  private float Iea;
  private float Ieb;
  private float Iec;
  private boolean Ied;
  private boolean Iee;
  private int Ief;
  private final String TAG;
  public float aGN;
  public float aGO;
  public Matrix aHZ;
  private boolean hasInit;
  public int height;
  private final Vibrator rqC;
  public int width;
  
  public c()
  {
    AppMethodBeat.i(222538);
    this.TAG = "TouchTracker";
    this.IdL = new ArrayList();
    this.IdM = new ArrayList();
    this.IdN = new float[2];
    this.IdO = new float[4];
    this.IdP = new float[2];
    this.IdQ = b.Iej;
    this.aHZ = new Matrix();
    this.IdU = new float[8];
    this.IdV = new float[8];
    this.IdW = new float[4];
    this.IdX = new float[4];
    this.aGN = 10.0F;
    this.aGO = 0.1F;
    this.IdY = c.a.Ieg;
    this.IdZ = true;
    this.Iea = 15.0F;
    Object localObject = MMApplicationContext.getContext().getSystemService("vibrator");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(222538);
      throw ((Throwable)localObject);
    }
    this.rqC = ((Vibrator)localObject);
    this.Iee = true;
    this.aHZ.setScale(1.0F, 1.0F);
    AppMethodBeat.o(222538);
  }
  
  private final void ai(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(222464);
    Object localObject1;
    Object localObject2;
    if (this.IdL.size() == 1)
    {
      this.IdQ = b.Iek;
      localObject1 = this.IdN;
      localObject2 = this.IdM.get(0);
      p.j(localObject2, "pIndices[0]");
      localObject1[0] = paramMotionEvent.getX(((Number)localObject2).intValue());
      localObject1 = this.IdN;
      localObject2 = this.IdM.get(0);
      p.j(localObject2, "pIndices[0]");
      localObject1[1] = paramMotionEvent.getY(((Number)localObject2).intValue());
      AppMethodBeat.o(222464);
      return;
    }
    if (this.IdL.size() == 2)
    {
      this.IdQ = b.Iel;
      if (this.IdY == c.a.Ieh) {
        this.aHZ.mapPoints(this.IdP, new float[] { this.width / 2.0F, this.height / 2.0F });
      }
      localObject1 = new Matrix();
      this.aHZ.invert((Matrix)localObject1);
      aj(paramMotionEvent);
      if ((p.compare(((Number)this.IdM.get(0)).intValue(), paramMotionEvent.getPointerCount()) < 0) && (p.compare(((Number)this.IdM.get(1)).intValue(), paramMotionEvent.getPointerCount()) < 0))
      {
        localObject2 = this.IdO;
        Object localObject3 = this.IdM.get(0);
        p.j(localObject3, "pIndices[0]");
        float f1 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.IdM.get(0);
        p.j(localObject3, "pIndices[0]");
        float f2 = paramMotionEvent.getY(((Number)localObject3).intValue());
        localObject3 = this.IdM.get(1);
        p.j(localObject3, "pIndices[1]");
        float f3 = paramMotionEvent.getX(((Number)localObject3).intValue());
        localObject3 = this.IdM.get(1);
        p.j(localObject3, "pIndices[1]");
        ((Matrix)localObject1).mapPoints((float[])localObject2, new float[] { f1, f2, f3, paramMotionEvent.getY(((Number)localObject3).intValue()) });
      }
    }
    AppMethodBeat.o(222464);
  }
  
  private static boolean ai(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(222523);
    if (Math.abs(paramFloat1 - paramFloat2) < 0.2F)
    {
      AppMethodBeat.o(222523);
      return true;
    }
    AppMethodBeat.o(222523);
    return false;
  }
  
  private final void aj(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(222471);
    Iterator localIterator = ((Iterable)j.p((Collection)this.IdL)).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ab)localIterator).zD();
      ArrayList localArrayList = this.IdM;
      Object localObject = this.IdL.get(i);
      p.j(localObject, "pIds[i]");
      localArrayList.set(i, Integer.valueOf(paramMotionEvent.findPointerIndex(((Number)localObject).intValue())));
    }
    AppMethodBeat.o(222471);
  }
  
  private final void fzi()
  {
    this.IdS = 0.0F;
    this.IdT = 0.0F;
  }
  
  private final float fzj()
  {
    AppMethodBeat.i(222496);
    float f2 = this.IdV[0];
    float[] arrayOfFloat = this.IdV;
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
    AppMethodBeat.o(222496);
    return f2;
  }
  
  private final float fzk()
  {
    AppMethodBeat.i(222506);
    float f2 = this.IdV[1];
    float[] arrayOfFloat = this.IdV;
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
    AppMethodBeat.o(222506);
    return f2;
  }
  
  private final float fzl()
  {
    AppMethodBeat.i(222512);
    float f2 = this.IdV[0];
    float[] arrayOfFloat = this.IdV;
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
    AppMethodBeat.o(222512);
    return f2;
  }
  
  private final float fzm()
  {
    AppMethodBeat.i(222520);
    float f2 = this.IdV[1];
    float[] arrayOfFloat = this.IdV;
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
    AppMethodBeat.o(222520);
    return f2;
  }
  
  private final float h(Matrix paramMatrix)
  {
    AppMethodBeat.i(222452);
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    float f2 = (float)(Math.atan2(arrayOfFloat[1], arrayOfFloat[0]) * 57.295779513082323D);
    float f1;
    if ((this.Iec < -90.0F) && (f2 > 0.0F)) {
      f1 = f2 - 360.0F;
    }
    for (;;)
    {
      AppMethodBeat.o(222452);
      return f1;
      f1 = f2;
      if (this.Iec > 90.0F)
      {
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = f2 + 360.0F;
        }
      }
    }
  }
  
  private final boolean s(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(222483);
    Rect localRect = this.HGw;
    if (localRect == null) {
      p.iCn();
    }
    if (paramFloat1 > localRect.left)
    {
      localRect = this.HGw;
      if (localRect == null) {
        p.iCn();
      }
      if (paramFloat1 < localRect.right)
      {
        localRect = this.HGw;
        if (localRect == null) {
          p.iCn();
        }
        if (paramFloat2 > localRect.top)
        {
          localRect = this.HGw;
          if (localRect == null) {
            p.iCn();
          }
          if (paramFloat2 < localRect.bottom)
          {
            localRect = this.HGw;
            if (localRect == null) {
              p.iCn();
            }
            if (paramFloat3 > localRect.left)
            {
              localRect = this.HGw;
              if (localRect == null) {
                p.iCn();
              }
              if (paramFloat3 < localRect.right)
              {
                localRect = this.HGw;
                if (localRect == null) {
                  p.iCn();
                }
                if (paramFloat4 > localRect.top)
                {
                  localRect = this.HGw;
                  if (localRect == null) {
                    p.iCn();
                  }
                  if (paramFloat4 < localRect.bottom)
                  {
                    AppMethodBeat.o(222483);
                    return true;
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(222483);
    return false;
  }
  
  public final boolean ah(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(222445);
    p.k(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(222445);
      return true;
      Object localObject1 = new float[2];
      Object localObject2 = new Matrix();
      this.aHZ.invert((Matrix)localObject2);
      ((Matrix)localObject2).mapPoints((float[])localObject1, new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
      if ((localObject1[0] < 0.0F) || (localObject1[0] > this.width) || (localObject1[1] < 0.0F) || (localObject1[1] > this.height))
      {
        AppMethodBeat.o(222445);
        return false;
      }
      this.IdL.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
      this.IdM.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
      ai(paramMotionEvent);
      if (!this.hasInit)
      {
        localObject1 = this.IdM.get(0);
        p.j(localObject1, "pIndices[0]");
        float f1 = paramMotionEvent.getX(((Number)localObject1).intValue());
        localObject1 = this.IdM.get(0);
        p.j(localObject1, "pIndices[0]");
        float f2 = paramMotionEvent.getY(((Number)localObject1).intValue());
        float f3 = this.IdN[0];
        float f4 = this.IdN[1];
        this.aHZ.postTranslate(f1 - f3, f2 - f4);
        this.IdN[0] = f1;
        this.IdN[1] = f2;
        this.aHZ.mapPoints(this.IdV, this.IdU);
        this.IdW[0] = fzj();
        this.IdW[1] = fzk();
        this.IdW[2] = fzl();
        this.IdW[3] = fzm();
        this.hasInit = true;
        continue;
        this.IdL.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
        this.IdM.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
        ai(paramMotionEvent);
        if (paramMotionEvent.getPointerCount() == 2)
        {
          this.Iec = 0.0F;
          this.Ieb = h(this.aHZ);
          this.Iec = this.Ieb;
          Log.i(this.TAG, "downRotate :" + this.Ieb);
          continue;
          aj(paramMotionEvent);
          if (paramMotionEvent.getPointerCount() == 1) {
            this.IdQ = b.Iek;
          }
          localObject1 = this.IdQ;
          switch (d.$EnumSwitchMapping$0[localObject1.ordinal()])
          {
          default: 
            break;
          case 1: 
            localObject1 = this.IdM.get(0);
            p.j(localObject1, "pIndices[0]");
            f2 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.IdM.get(0);
            p.j(localObject1, "pIndices[0]");
            f3 = paramMotionEvent.getY(((Number)localObject1).intValue());
            f4 = f2 - this.IdN[0];
            f1 = f3 - this.IdN[1];
            this.aHZ.postTranslate(f4, f1);
            this.IdN[0] = f2;
            this.IdN[1] = f3;
            this.aHZ.mapPoints(this.IdV, this.IdU);
            this.IdW[0] = fzj();
            this.IdW[1] = fzk();
            this.IdW[2] = fzl();
            this.IdW[3] = fzm();
            if ((this.HGw != null) && (!s(this.IdW[0] + f4, this.IdW[1] + f1, this.IdW[2] + f4, this.IdW[3] + f1)))
            {
              f2 = Math.abs(f4);
              f1 = Math.abs(f1);
              paramMotionEvent = this.HGw;
              if (paramMotionEvent == null) {
                p.iCn();
              }
              if ((paramMotionEvent.left >= this.IdW[0]) && (this.IdS <= this.IdR))
              {
                paramMotionEvent = this.aHZ;
                localObject1 = this.HGw;
                if (localObject1 == null) {
                  p.iCn();
                }
                paramMotionEvent.postTranslate(((Rect)localObject1).left - this.IdW[0], 0.0F);
                this.IdS += f2;
              }
              paramMotionEvent = this.HGw;
              if (paramMotionEvent == null) {
                p.iCn();
              }
              if ((paramMotionEvent.top >= this.IdW[1]) && (this.IdT <= this.IdR))
              {
                paramMotionEvent = this.aHZ;
                localObject1 = this.HGw;
                if (localObject1 == null) {
                  p.iCn();
                }
                paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).top - this.IdW[1]);
                this.IdT += f1;
              }
              paramMotionEvent = this.HGw;
              if (paramMotionEvent == null) {
                p.iCn();
              }
              if ((paramMotionEvent.right <= this.IdW[2]) && (this.IdS <= this.IdR))
              {
                paramMotionEvent = this.aHZ;
                localObject1 = this.HGw;
                if (localObject1 == null) {
                  p.iCn();
                }
                paramMotionEvent.postTranslate(((Rect)localObject1).right - this.IdW[2], 0.0F);
                this.IdS = (f2 + this.IdS);
              }
              paramMotionEvent = this.HGw;
              if (paramMotionEvent == null) {
                p.iCn();
              }
              if ((paramMotionEvent.bottom <= this.IdW[3]) && (this.IdT <= this.IdR))
              {
                paramMotionEvent = this.aHZ;
                localObject1 = this.HGw;
                if (localObject1 == null) {
                  p.iCn();
                }
                paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).bottom - this.IdW[3]);
                this.IdT += f1;
              }
            }
            else
            {
              fzi();
            }
            break;
          case 2: 
            localObject1 = this.IdM.get(0);
            p.j(localObject1, "pIndices[0]");
            f1 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.IdM.get(0);
            p.j(localObject1, "pIndices[0]");
            f2 = paramMotionEvent.getY(((Number)localObject1).intValue());
            localObject1 = this.IdM.get(1);
            p.j(localObject1, "pIndices[1]");
            f3 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.IdM.get(1);
            p.j(localObject1, "pIndices[1]");
            f4 = paramMotionEvent.getY(((Number)localObject1).intValue());
            this.aHZ.setPolyToPoly(this.IdO, 0, new float[] { f1, f2, f3, f4 }, 0, 2);
            localObject1 = new float[2];
            localObject2 = this.IdM.get(0);
            p.j(localObject2, "pIndices[0]");
            f1 = paramMotionEvent.getX(((Number)localObject2).intValue());
            localObject2 = this.IdM.get(1);
            p.j(localObject2, "pIndices[1]");
            localObject1[0] = ((paramMotionEvent.getX(((Number)localObject2).intValue()) + f1) / 2.0F);
            localObject2 = this.IdM.get(0);
            p.j(localObject2, "pIndices[0]");
            f1 = paramMotionEvent.getY(((Number)localObject2).intValue());
            localObject2 = this.IdM.get(1);
            p.j(localObject2, "pIndices[1]");
            localObject1[1] = ((paramMotionEvent.getY(((Number)localObject2).intValue()) + f1) / 2.0F);
            if (this.IdZ)
            {
              f1 = h(this.aHZ);
              if (Math.abs(f1 - this.Ieb) > this.Iea) {
                break label1729;
              }
              this.aHZ.postRotate(f1 - this.Ieb, localObject1[0], localObject1[1]);
              if ((!ai(this.Iec, this.Ieb)) && ((int)this.Ieb % 90 == 0) && (this.Iee))
              {
                paramMotionEvent = this.rqC;
                if (paramMotionEvent != null) {
                  paramMotionEvent.vibrate(10L);
                }
                this.Iee = false;
                this.Iec = this.Ieb;
              }
              if (f1 >= this.Ieb) {
                break label1723;
              }
            }
            label1723:
            for (boolean bool = true;; bool = false)
            {
              this.Ied = bool;
              if (this.IdY == c.a.Ieh)
              {
                paramMotionEvent = new float[2];
                this.aHZ.mapPoints(paramMotionEvent, new float[] { this.width / 2.0F, this.height / 2.0F });
                this.aHZ.postTranslate(this.IdP[0] - paramMotionEvent[0], this.IdP[1] - paramMotionEvent[1]);
              }
              paramMotionEvent = b.IdK;
              b.a.a(this.aHZ, (float[])localObject1, this.aGO, this.aGN);
              this.aHZ.mapPoints(this.IdV, this.IdU);
              this.IdW[0] = fzj();
              this.IdW[1] = fzk();
              this.IdW[2] = fzl();
              this.IdW[3] = fzm();
              break;
            }
            label1729:
            if (f1 - this.Ieb > 0.0F)
            {
              f1 = this.Iea;
              label1745:
              this.aHZ.postRotate(f1, localObject1[0], localObject1[1]);
              f1 = h(this.aHZ);
              if (((!this.Ied) || (f1 > this.Iec + 0.5D)) && (f1 > this.Iec - 0.5D)) {
                break label1958;
              }
              i = (int)((f1 - 90.0F) / 90.0F) * 90;
              if ((Math.abs(f1 - i) <= this.Iea) && (f1 >= i))
              {
                this.aHZ.postRotate(f1 - i, localObject1[0], localObject1[1]);
                if ((!ai(this.Ieb, i)) || (this.Iee))
                {
                  this.Ieb = i;
                  this.Iee = false;
                  paramMotionEvent = this.rqC;
                  if (paramMotionEvent != null) {
                    paramMotionEvent.vibrate(10L);
                  }
                }
              }
              if (this.Ief != i)
              {
                this.Ief = i;
                this.Iee = true;
              }
            }
            for (this.Ied = true;; this.Ied = false)
            {
              this.Iec = f1;
              break;
              f1 = -this.Iea;
              break label1745;
              label1958:
              i = (int)((90.0F + f1) / 90.0F) * 90;
              if ((Math.abs(f1 - i) <= this.Iea) && (f1 <= i))
              {
                this.aHZ.postRotate(f1 - i, localObject1[0], localObject1[1]);
                if ((!ai(this.Ieb, i)) || (this.Iee))
                {
                  this.Ieb = i;
                  this.Iee = false;
                  paramMotionEvent = this.rqC;
                  if (paramMotionEvent != null) {
                    paramMotionEvent.vibrate(10L);
                  }
                }
              }
              if (this.Ief != i)
              {
                this.Ief = i;
                this.Iee = true;
              }
            }
            aj(paramMotionEvent);
            int i = this.IdM.indexOf(Integer.valueOf(paramMotionEvent.getActionIndex()));
            this.IdM.remove(i);
            this.IdL.remove(i);
            ai(paramMotionEvent);
            continue;
            this.IdQ = b.Iej;
            this.IdL.clear();
            this.IdM.clear();
          }
        }
      }
    }
  }
  
  public final void g(Matrix paramMatrix)
  {
    AppMethodBeat.i(222448);
    p.k(paramMatrix, "m");
    this.aHZ.set(paramMatrix);
    this.aHZ.mapPoints(this.IdV, this.IdU);
    this.IdW[0] = fzj();
    this.IdW[1] = fzk();
    this.IdW[2] = fzl();
    this.IdW[3] = fzm();
    AppMethodBeat.o(222448);
  }
  
  public final void p(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(222397);
    p.k(paramArrayOfFloat, "<set-?>");
    this.IdU = paramArrayOfFloat;
    AppMethodBeat.o(222397);
  }
  
  public final void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(222395);
    p.k(paramMatrix, "<set-?>");
    this.aHZ = paramMatrix;
    AppMethodBeat.o(222395);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$TouchState;", "", "(Ljava/lang/String;I)V", "NONE", "DRAG", "SCALE", "plugin-recordvideo_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(216763);
      b localb1 = new b("NONE", 0);
      Iej = localb1;
      b localb2 = new b("DRAG", 1);
      Iek = localb2;
      b localb3 = new b("SCALE", 2);
      Iel = localb3;
      Iem = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(216763);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.c.c
 * JD-Core Version:    0.7.0.1
 */