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
import kotlin.Metadata;
import kotlin.a.ah;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "", "()V", "CalibrationDistance", "", "TAG", "", "boundArrayDst", "", "getBoundArrayDst", "()[F", "setBoundArrayDst", "([F)V", "boundArrayOut", "getBoundArrayOut", "setBoundArrayOut", "boundArraySrc", "getBoundArraySrc", "setBoundArraySrc", "clockwise", "", "hasInit", "height", "", "getHeight", "()I", "setHeight", "(I)V", "holdX", "getHoldX", "()F", "setHoldX", "(F)V", "holdY", "getHoldY", "setHoldY", "holdingThreshold", "getHoldingThreshold", "setHoldingThreshold", "lastDrag", "lastRotate", "lastStardAngle", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "needVibrator", "pIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pIndices", "pivotDst", "pivotType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$PivotType;", "pointDownRotate", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "selfCalibration", "state", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$TouchState;", "transStart", "transformBoundArray", "getTransformBoundArray", "setTransformBoundArray", "vibrator", "Landroid/os/Vibrator;", "width", "getWidth", "setWidth", "appendTouchEvent", "event", "Landroid/view/MotionEvent;", "findIndices", "", "findMaxBottom", "findMaxRight", "findMinLeft", "findMinTop", "getRotate", "inSafeArea", "newLeft", "newTop", "newRight", "newBottom", "resetHold", "updateMatrix", "m", "updateState", "isEqual", "input", "PivotType", "TouchState", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public Rect NDV;
  private ArrayList<Integer> Oab;
  private ArrayList<Integer> Oac;
  private float[] Oad;
  private float[] Oae;
  private float[] Oaf;
  private b Oag;
  public int Oah;
  private float Oai;
  private float Oaj;
  private float[] Oak;
  private float[] Oal;
  public float[] Oam;
  private float[] Oan;
  private c.a Oao;
  private boolean Oap;
  private float Oaq;
  private float Oar;
  private float Oas;
  private boolean Oat;
  private boolean Oau;
  private int Oav;
  private final String TAG;
  private boolean hasInit;
  public int height;
  public Matrix matrix;
  public float maxScale;
  public float minScale;
  private final Vibrator uAL;
  public int width;
  
  public c()
  {
    AppMethodBeat.i(280173);
    this.TAG = "TouchTracker";
    this.Oab = new ArrayList();
    this.Oac = new ArrayList();
    this.Oad = new float[2];
    this.Oae = new float[4];
    this.Oaf = new float[2];
    this.Oag = b.Oaz;
    this.matrix = new Matrix();
    this.Oak = new float[8];
    this.Oal = new float[8];
    this.Oam = new float[4];
    this.Oan = new float[4];
    this.maxScale = 10.0F;
    this.minScale = 0.1F;
    this.Oao = c.a.Oaw;
    this.Oap = true;
    this.Oaq = 15.0F;
    Object localObject = MMApplicationContext.getContext().getSystemService("vibrator");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
      AppMethodBeat.o(280173);
      throw ((Throwable)localObject);
    }
    this.uAL = ((Vibrator)localObject);
    this.Oau = true;
    this.matrix.setScale(1.0F, 1.0F);
    AppMethodBeat.o(280173);
  }
  
  private static boolean aN(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(280260);
    if (Math.abs(paramFloat1 - paramFloat2) < 0.2F)
    {
      AppMethodBeat.o(280260);
      return true;
    }
    AppMethodBeat.o(280260);
    return false;
  }
  
  private final void al(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280197);
    Object localObject1;
    Object localObject2;
    if (this.Oab.size() == 1)
    {
      this.Oag = b.OaA;
      localObject1 = this.Oad;
      localObject2 = this.Oac.get(0);
      s.s(localObject2, "pIndices[0]");
      localObject1[0] = paramMotionEvent.getX(((Number)localObject2).intValue());
      localObject1 = this.Oad;
      localObject2 = this.Oac.get(0);
      s.s(localObject2, "pIndices[0]");
      localObject1[1] = paramMotionEvent.getY(((Number)localObject2).intValue());
      AppMethodBeat.o(280197);
      return;
    }
    if (this.Oab.size() == 2)
    {
      this.Oag = b.OaB;
      if (this.Oao == c.a.Oax) {
        this.matrix.mapPoints(this.Oaf, new float[] { this.width / 2.0F, this.height / 2.0F });
      }
      localObject1 = new Matrix();
      this.matrix.invert((Matrix)localObject1);
      am(paramMotionEvent);
      localObject2 = this.Oac.get(0);
      s.s(localObject2, "pIndices[0]");
      if (((Number)localObject2).intValue() < paramMotionEvent.getPointerCount())
      {
        localObject2 = this.Oac.get(1);
        s.s(localObject2, "pIndices[1]");
        if (((Number)localObject2).intValue() < paramMotionEvent.getPointerCount())
        {
          localObject2 = this.Oae;
          Object localObject3 = this.Oac.get(0);
          s.s(localObject3, "pIndices[0]");
          float f1 = paramMotionEvent.getX(((Number)localObject3).intValue());
          localObject3 = this.Oac.get(0);
          s.s(localObject3, "pIndices[0]");
          float f2 = paramMotionEvent.getY(((Number)localObject3).intValue());
          localObject3 = this.Oac.get(1);
          s.s(localObject3, "pIndices[1]");
          float f3 = paramMotionEvent.getX(((Number)localObject3).intValue());
          localObject3 = this.Oac.get(1);
          s.s(localObject3, "pIndices[1]");
          ((Matrix)localObject1).mapPoints((float[])localObject2, new float[] { f1, f2, f3, paramMotionEvent.getY(((Number)localObject3).intValue()) });
        }
      }
    }
    AppMethodBeat.o(280197);
  }
  
  private final void am(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280211);
    Iterator localIterator = ((Iterable)p.F((Collection)this.Oab)).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ah)localIterator).Zo();
      ArrayList localArrayList = this.Oac;
      Object localObject = this.Oab.get(i);
      s.s(localObject, "pIds[i]");
      localArrayList.set(i, Integer.valueOf(paramMotionEvent.findPointerIndex(((Number)localObject).intValue())));
    }
    AppMethodBeat.o(280211);
  }
  
  private final void gKU()
  {
    this.Oai = 0.0F;
    this.Oaj = 0.0F;
  }
  
  private final float gKV()
  {
    AppMethodBeat.i(280242);
    float f2 = this.Oal[0];
    float[] arrayOfFloat = this.Oal;
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
    AppMethodBeat.o(280242);
    return f2;
  }
  
  private final float gKW()
  {
    AppMethodBeat.i(280248);
    float f2 = this.Oal[1];
    float[] arrayOfFloat = this.Oal;
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
    AppMethodBeat.o(280248);
    return f2;
  }
  
  private final float gKX()
  {
    AppMethodBeat.i(280253);
    float f2 = this.Oal[0];
    float[] arrayOfFloat = this.Oal;
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
    AppMethodBeat.o(280253);
    return f2;
  }
  
  private final float gKY()
  {
    AppMethodBeat.i(280256);
    float f2 = this.Oal[1];
    float[] arrayOfFloat = this.Oal;
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
    AppMethodBeat.o(280256);
    return f2;
  }
  
  private final float j(Matrix paramMatrix)
  {
    AppMethodBeat.i(280179);
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    float f2 = (float)(Math.atan2(arrayOfFloat[1], arrayOfFloat[0]) * 57.295779513082323D);
    float f1;
    if ((this.Oas < -90.0F) && (f2 > 0.0F)) {
      f1 = f2 - 360.0F;
    }
    for (;;)
    {
      AppMethodBeat.o(280179);
      return f1;
      f1 = f2;
      if (this.Oas > 90.0F)
      {
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = f2 + 360.0F;
        }
      }
    }
  }
  
  private final boolean w(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(280222);
    Rect localRect = this.NDV;
    s.checkNotNull(localRect);
    if (paramFloat1 > localRect.left)
    {
      localRect = this.NDV;
      s.checkNotNull(localRect);
      if (paramFloat1 < localRect.right)
      {
        localRect = this.NDV;
        s.checkNotNull(localRect);
        if (paramFloat2 > localRect.top)
        {
          localRect = this.NDV;
          s.checkNotNull(localRect);
          if (paramFloat2 < localRect.bottom)
          {
            localRect = this.NDV;
            s.checkNotNull(localRect);
            if (paramFloat3 > localRect.left)
            {
              localRect = this.NDV;
              s.checkNotNull(localRect);
              if (paramFloat3 < localRect.right)
              {
                localRect = this.NDV;
                s.checkNotNull(localRect);
                if (paramFloat4 > localRect.top)
                {
                  localRect = this.NDV;
                  s.checkNotNull(localRect);
                  if (paramFloat4 < localRect.bottom)
                  {
                    AppMethodBeat.o(280222);
                    return true;
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(280222);
    return false;
  }
  
  public final boolean ak(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280296);
    s.u(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(280296);
      return true;
      Object localObject1 = new float[2];
      Object localObject2 = new Matrix();
      this.matrix.invert((Matrix)localObject2);
      ((Matrix)localObject2).mapPoints((float[])localObject1, new float[] { paramMotionEvent.getX(), paramMotionEvent.getY() });
      if ((localObject1[0] < 0.0F) || (localObject1[0] > this.width) || (localObject1[1] < 0.0F) || (localObject1[1] > this.height))
      {
        AppMethodBeat.o(280296);
        return false;
      }
      this.Oab.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
      this.Oac.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
      al(paramMotionEvent);
      if (!this.hasInit)
      {
        localObject1 = this.Oac.get(0);
        s.s(localObject1, "pIndices[0]");
        float f1 = paramMotionEvent.getX(((Number)localObject1).intValue());
        localObject1 = this.Oac.get(0);
        s.s(localObject1, "pIndices[0]");
        float f2 = paramMotionEvent.getY(((Number)localObject1).intValue());
        float f3 = this.Oad[0];
        float f4 = this.Oad[1];
        this.matrix.postTranslate(f1 - f3, f2 - f4);
        this.Oad[0] = f1;
        this.Oad[1] = f2;
        this.matrix.mapPoints(this.Oal, this.Oak);
        this.Oam[0] = gKV();
        this.Oam[1] = gKW();
        this.Oam[2] = gKX();
        this.Oam[3] = gKY();
        this.hasInit = true;
        continue;
        this.Oab.add(Integer.valueOf(paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())));
        this.Oac.add(Integer.valueOf(paramMotionEvent.getActionIndex()));
        al(paramMotionEvent);
        if (paramMotionEvent.getPointerCount() == 2)
        {
          this.Oas = 0.0F;
          this.Oar = j(this.matrix);
          this.Oas = this.Oar;
          Log.i(this.TAG, s.X("downRotate :", Float.valueOf(this.Oar)));
          continue;
          am(paramMotionEvent);
          if (paramMotionEvent.getPointerCount() == 1) {
            this.Oag = b.OaA;
          }
          localObject1 = this.Oag;
          switch (c.$EnumSwitchMapping$0[localObject1.ordinal()])
          {
          default: 
            break;
          case 1: 
            localObject1 = this.Oac.get(0);
            s.s(localObject1, "pIndices[0]");
            f2 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.Oac.get(0);
            s.s(localObject1, "pIndices[0]");
            f3 = paramMotionEvent.getY(((Number)localObject1).intValue());
            f4 = f2 - this.Oad[0];
            f1 = f3 - this.Oad[1];
            this.matrix.postTranslate(f4, f1);
            this.Oad[0] = f2;
            this.Oad[1] = f3;
            this.matrix.mapPoints(this.Oal, this.Oak);
            this.Oam[0] = gKV();
            this.Oam[1] = gKW();
            this.Oam[2] = gKX();
            this.Oam[3] = gKY();
            if ((this.NDV != null) && (!w(this.Oam[0] + f4, this.Oam[1] + f1, this.Oam[2] + f4, this.Oam[3] + f1)))
            {
              f2 = Math.abs(f4);
              f1 = Math.abs(f1);
              paramMotionEvent = this.NDV;
              s.checkNotNull(paramMotionEvent);
              if ((paramMotionEvent.left >= this.Oam[0]) && (this.Oai <= this.Oah))
              {
                paramMotionEvent = this.matrix;
                localObject1 = this.NDV;
                s.checkNotNull(localObject1);
                paramMotionEvent.postTranslate(((Rect)localObject1).left - this.Oam[0], 0.0F);
                this.Oai += f2;
              }
              paramMotionEvent = this.NDV;
              s.checkNotNull(paramMotionEvent);
              if ((paramMotionEvent.top >= this.Oam[1]) && (this.Oaj <= this.Oah))
              {
                paramMotionEvent = this.matrix;
                localObject1 = this.NDV;
                s.checkNotNull(localObject1);
                paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).top - this.Oam[1]);
                this.Oaj += f1;
              }
              paramMotionEvent = this.NDV;
              s.checkNotNull(paramMotionEvent);
              if ((paramMotionEvent.right <= this.Oam[2]) && (this.Oai <= this.Oah))
              {
                paramMotionEvent = this.matrix;
                localObject1 = this.NDV;
                s.checkNotNull(localObject1);
                paramMotionEvent.postTranslate(((Rect)localObject1).right - this.Oam[2], 0.0F);
                this.Oai = (f2 + this.Oai);
              }
              paramMotionEvent = this.NDV;
              s.checkNotNull(paramMotionEvent);
              if ((paramMotionEvent.bottom <= this.Oam[3]) && (this.Oaj <= this.Oah))
              {
                paramMotionEvent = this.matrix;
                localObject1 = this.NDV;
                s.checkNotNull(localObject1);
                paramMotionEvent.postTranslate(0.0F, ((Rect)localObject1).bottom - this.Oam[3]);
                this.Oaj += f1;
              }
            }
            else
            {
              gKU();
            }
            break;
          case 2: 
            localObject1 = this.Oac.get(0);
            s.s(localObject1, "pIndices[0]");
            f1 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.Oac.get(0);
            s.s(localObject1, "pIndices[0]");
            f2 = paramMotionEvent.getY(((Number)localObject1).intValue());
            localObject1 = this.Oac.get(1);
            s.s(localObject1, "pIndices[1]");
            f3 = paramMotionEvent.getX(((Number)localObject1).intValue());
            localObject1 = this.Oac.get(1);
            s.s(localObject1, "pIndices[1]");
            f4 = paramMotionEvent.getY(((Number)localObject1).intValue());
            this.matrix.setPolyToPoly(this.Oae, 0, new float[] { f1, f2, f3, f4 }, 0, 2);
            localObject1 = new float[2];
            localObject2 = this.Oac.get(0);
            s.s(localObject2, "pIndices[0]");
            f1 = paramMotionEvent.getX(((Number)localObject2).intValue());
            localObject2 = this.Oac.get(1);
            s.s(localObject2, "pIndices[1]");
            localObject1[0] = ((paramMotionEvent.getX(((Number)localObject2).intValue()) + f1) / 2.0F);
            localObject2 = this.Oac.get(0);
            s.s(localObject2, "pIndices[0]");
            f1 = paramMotionEvent.getY(((Number)localObject2).intValue());
            localObject2 = this.Oac.get(1);
            s.s(localObject2, "pIndices[1]");
            localObject1[1] = ((paramMotionEvent.getY(((Number)localObject2).intValue()) + f1) / 2.0F);
            if (this.Oap)
            {
              f1 = j(this.matrix);
              if (Math.abs(f1 - this.Oar) > this.Oaq) {
                break label1697;
              }
              this.matrix.postRotate(f1 - this.Oar, localObject1[0], localObject1[1]);
              if ((!aN(this.Oas, this.Oar)) && ((int)this.Oar % 90 == 0) && (this.Oau))
              {
                paramMotionEvent = this.uAL;
                if (paramMotionEvent != null) {
                  paramMotionEvent.vibrate(10L);
                }
                this.Oau = false;
                this.Oas = this.Oar;
              }
              if (f1 >= this.Oar) {
                break label1691;
              }
            }
            label1691:
            for (boolean bool = true;; bool = false)
            {
              this.Oat = bool;
              if (this.Oao == c.a.Oax)
              {
                paramMotionEvent = new float[2];
                this.matrix.mapPoints(paramMotionEvent, new float[] { this.width / 2.0F, this.height / 2.0F });
                this.matrix.postTranslate(this.Oaf[0] - paramMotionEvent[0], this.Oaf[1] - paramMotionEvent[1]);
              }
              paramMotionEvent = b.Oaa;
              b.a.a(this.matrix, (float[])localObject1, this.minScale, this.maxScale);
              this.matrix.mapPoints(this.Oal, this.Oak);
              this.Oam[0] = gKV();
              this.Oam[1] = gKW();
              this.Oam[2] = gKX();
              this.Oam[3] = gKY();
              break;
            }
            label1697:
            if (f1 - this.Oar > 0.0F)
            {
              f1 = this.Oaq;
              label1713:
              this.matrix.postRotate(f1, localObject1[0], localObject1[1]);
              f1 = j(this.matrix);
              if (((!this.Oat) || (f1 > this.Oas + 0.5D)) && (f1 > this.Oas - 0.5D)) {
                break label1926;
              }
              i = (int)((f1 - 90.0F) / 90.0F) * 90;
              if ((Math.abs(f1 - i) <= this.Oaq) && (f1 >= i))
              {
                this.matrix.postRotate(f1 - i, localObject1[0], localObject1[1]);
                if ((!aN(this.Oar, i)) || (this.Oau))
                {
                  this.Oar = i;
                  this.Oau = false;
                  paramMotionEvent = this.uAL;
                  if (paramMotionEvent != null) {
                    paramMotionEvent.vibrate(10L);
                  }
                }
              }
              if (this.Oav != i)
              {
                this.Oav = i;
                this.Oau = true;
              }
            }
            for (this.Oat = true;; this.Oat = false)
            {
              this.Oas = f1;
              break;
              f1 = -this.Oaq;
              break label1713;
              label1926:
              i = (int)((90.0F + f1) / 90.0F) * 90;
              if ((Math.abs(f1 - i) <= this.Oaq) && (f1 <= i))
              {
                this.matrix.postRotate(f1 - i, localObject1[0], localObject1[1]);
                if ((!aN(this.Oar, i)) || (this.Oau))
                {
                  this.Oar = i;
                  this.Oau = false;
                  paramMotionEvent = this.uAL;
                  if (paramMotionEvent != null) {
                    paramMotionEvent.vibrate(10L);
                  }
                }
              }
              if (this.Oav != i)
              {
                this.Oav = i;
                this.Oau = true;
              }
            }
            am(paramMotionEvent);
            int i = this.Oac.indexOf(Integer.valueOf(paramMotionEvent.getActionIndex()));
            this.Oac.remove(i);
            this.Oab.remove(i);
            al(paramMotionEvent);
            continue;
            this.Oag = b.Oaz;
            this.Oab.clear();
            this.Oac.clear();
          }
        }
      }
    }
  }
  
  public final void i(Matrix paramMatrix)
  {
    AppMethodBeat.i(280304);
    s.u(paramMatrix, "m");
    this.matrix.set(paramMatrix);
    this.matrix.mapPoints(this.Oal, this.Oak);
    this.Oam[0] = gKV();
    this.Oam[1] = gKW();
    this.Oam[2] = gKX();
    this.Oam[3] = gKY();
    AppMethodBeat.o(280304);
  }
  
  public final void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(280265);
    s.u(paramMatrix, "<set-?>");
    this.matrix = paramMatrix;
    AppMethodBeat.o(280265);
  }
  
  public final void x(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(280271);
    s.u(paramArrayOfFloat, "<set-?>");
    this.Oak = paramArrayOfFloat;
    AppMethodBeat.o(280271);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker$TouchState;", "", "(Ljava/lang/String;I)V", "NONE", "DRAG", "SCALE", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(280187);
      Oaz = new b("NONE", 0);
      OaA = new b("DRAG", 1);
      OaB = new b("SCALE", 2);
      OaC = new b[] { Oaz, OaA, OaB };
      AppMethodBeat.o(280187);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.c.c
 * JD-Core Version:    0.7.0.1
 */