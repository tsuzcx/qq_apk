package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.filter.m.b;
import com.tencent.filter.m.d;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.WMAnimationFilterBase;
import com.tencent.ttpic.filter.WMDitheringAnimationFilter;
import com.tencent.ttpic.filter.WMScaleAnimationFilter;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FrameUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WMGroup
{
  private int height;
  public int id;
  private boolean locked;
  private Map<String, WMAnimationFilterBase> mAnimationFilerMap;
  private BaseFilter mCopyFilter;
  private h mCopyFrame;
  private Map<String, WMElement> mIdElementMap;
  private int[] mTexId;
  private int width;
  public List<WMElement> wmElements;
  
  public WMGroup()
  {
    AppMethodBeat.i(83589);
    this.wmElements = new ArrayList();
    this.mIdElementMap = new HashMap();
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mCopyFrame = new h();
    this.mTexId = new int[1];
    this.mAnimationFilerMap = new HashMap();
    this.locked = false;
    AppMethodBeat.o(83589);
  }
  
  public void clear()
  {
    AppMethodBeat.i(83591);
    this.mCopyFilter.clearGLSLSelf();
    this.mCopyFrame.clear();
    GLES20.glDeleteTextures(this.mTexId.length, this.mTexId, 0);
    Iterator localIterator = this.wmElements.iterator();
    while (localIterator.hasNext()) {
      ((WMElement)localIterator.next()).clear();
    }
    localIterator = this.mAnimationFilerMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((WMAnimationFilterBase)((Map.Entry)localIterator.next()).getValue()).ClearGLSL();
    }
    AppMethodBeat.o(83591);
  }
  
  public WMAnimationFilterBase createAnimationFilter(WMElement paramWMElement, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(83597);
    if ("scale".equals(paramWMElement.animateType))
    {
      paramWMElement = new WMScaleAnimationFilter(paramWMElement, paramInt1, paramInt2);
      AppMethodBeat.o(83597);
      return paramWMElement;
    }
    if ("dithering".equals(paramWMElement.animateType))
    {
      paramWMElement = new WMDitheringAnimationFilter(paramWMElement, paramInt1, paramInt2);
      AppMethodBeat.o(83597);
      return paramWMElement;
    }
    AppMethodBeat.o(83597);
    return null;
  }
  
  public boolean firstDrew()
  {
    AppMethodBeat.i(83596);
    Iterator localIterator = this.wmElements.iterator();
    while (localIterator.hasNext()) {
      if (((WMElement)localIterator.next()).firstDrew)
      {
        AppMethodBeat.o(83596);
        return true;
      }
    }
    AppMethodBeat.o(83596);
    return false;
  }
  
  public int getCurTexture()
  {
    return this.mCopyFrame.texture[0];
  }
  
  public int getTexture()
  {
    return this.mCopyFrame.texture[0];
  }
  
  public void init()
  {
    AppMethodBeat.i(83590);
    LogicDataManager.getInstance().getEditableWMElement().clear();
    this.mCopyFilter.addParam(new m.b("ditheringOffset", 0.0F, 0.0F));
    this.mCopyFilter.addParam(new m.i("texNeedTransform", 1));
    this.mCopyFilter.addParam(new m.b("canvasSize", 0.0F, 0.0F));
    this.mCopyFilter.addParam(new m.b("texAnchor", 0.0F, 0.0F));
    this.mCopyFilter.addParam(new m.f("texScale", 1.0F));
    this.mCopyFilter.addParam(new m.d("texRotate", 0.0F, 0.0F, 0.0F));
    this.mCopyFilter.addParam(new m.f("positionRotate", 0.0F));
    this.mCopyFilter.ApplyGLSLFilter();
    FrameUtil.clearFrame(this.mCopyFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.width, this.height);
    GLES20.glGenTextures(this.mTexId.length, this.mTexId, 0);
    Iterator localIterator = this.wmElements.iterator();
    while (localIterator.hasNext())
    {
      WMElement localWMElement = (WMElement)localIterator.next();
      localWMElement.init();
      if ((!TextUtils.isEmpty(localWMElement.animateType)) && (!this.mAnimationFilerMap.containsKey(localWMElement.animateType)))
      {
        WMAnimationFilterBase localWMAnimationFilterBase = createAnimationFilter(localWMElement, this.width, this.height);
        if (localWMAnimationFilterBase != null)
        {
          localWMAnimationFilterBase.ApplyGLSLFilter();
          this.mAnimationFilerMap.put(localWMElement.animateType, localWMAnimationFilterBase);
        }
      }
      this.mIdElementMap.put(localWMElement.id, localWMElement);
    }
    AppMethodBeat.o(83590);
  }
  
  public boolean isAsyncDrawFinished()
  {
    AppMethodBeat.i(83593);
    Iterator localIterator = this.wmElements.iterator();
    while (localIterator.hasNext())
    {
      WMElement localWMElement = (WMElement)localIterator.next();
      if (((localWMElement instanceof TextWMElement)) && (((TextWMElement)localWMElement).isAsyncDrawFinished()))
      {
        AppMethodBeat.o(83593);
        return true;
      }
    }
    AppMethodBeat.o(83593);
    return false;
  }
  
  public boolean isLock()
  {
    return this.locked;
  }
  
  public void lock()
  {
    this.locked = true;
  }
  
  public void reset()
  {
    AppMethodBeat.i(83598);
    Iterator localIterator = this.wmElements.iterator();
    while (localIterator.hasNext()) {
      ((WMElement)localIterator.next()).reset();
    }
    AppMethodBeat.o(83598);
  }
  
  public void setItemId(String paramString)
  {
    AppMethodBeat.i(83595);
    Iterator localIterator = this.wmElements.iterator();
    while (localIterator.hasNext()) {
      ((WMElement)localIterator.next()).itemId = paramString;
    }
    AppMethodBeat.o(83595);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void unlock()
  {
    this.locked = false;
  }
  
  public boolean updateTexture(long paramLong)
  {
    AppMethodBeat.i(83592);
    boolean bool = updateTexture(paramLong, false, false, false);
    AppMethodBeat.o(83592);
    return bool;
  }
  
  public boolean updateTexture(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(83594);
    Object localObject1;
    boolean bool1;
    Object localObject2;
    if (paramBoolean1)
    {
      if (!this.locked)
      {
        localObject1 = this.wmElements.iterator();
        bool1 = false;
        for (;;)
        {
          bool2 = bool1;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (WMElement)((Iterator)localObject1).next();
          if (((localObject2 instanceof TextWMElement)) && (paramBoolean2)) {
            ((TextWMElement)localObject2).updateTextShaderBmp(paramLong);
          } else {
            bool1 = ((WMElement)localObject2).updateBitmap(paramLong, paramBoolean3) | bool1;
          }
        }
      }
      boolean bool2 = false;
      if (bool2) {
        lock();
      }
      localObject1 = this.wmElements.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (WMElement)((Iterator)localObject1).next();
      } while ((!(localObject2 instanceof TextWMElement)) || (((WMElement)localObject2).isContentChanged()));
    }
    for (paramBoolean1 = false;; paramBoolean1 = true)
    {
      localObject1 = this.wmElements.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!((WMElement)((Iterator)localObject1).next()).isContentChanged());
      for (bool1 = true;; bool1 = false)
      {
        label282:
        WMElement localWMElement;
        float f3;
        float f4;
        float f1;
        float f2;
        if (bool1)
        {
          this.mCopyFrame.a(-1, this.width, this.height, 0.0D);
          paramBoolean2 = GlUtil.curBlendModeEnabled;
          GlUtil.setBlendMode(true);
          BenchUtil.benchStart("updateTexture");
          BenchUtil.benchStart("clear texture");
          FrameUtil.clearFrame(this.mCopyFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.width, this.height);
          BenchUtil.benchEnd("clear texture");
          localObject2 = this.wmElements.iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localWMElement = (WMElement)((Iterator)localObject2).next();
              localObject1 = localWMElement.getBitmap();
              if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
              {
                BenchUtil.benchStart("load texture");
                GlUtil.loadTexture(this.mTexId[0], (Bitmap)localObject1);
                BenchUtil.benchEnd("load texture");
                f3 = this.width;
                f4 = this.height;
                localObject1 = new PointF(0.0F, 0.0F);
                f1 = f4;
                f2 = f3;
                if (!TextUtils.isEmpty(localWMElement.relativeID))
                {
                  localObject3 = (WMElement)this.mIdElementMap.get(localWMElement.relativeID);
                  f1 = f4;
                  f2 = f3;
                  if (localObject3 != null)
                  {
                    f1 = f4;
                    f2 = f3;
                    if (((WMElement)localObject3).finalContentRect != null)
                    {
                      f2 = ((WMElement)localObject3).finalContentRect.width();
                      f1 = ((WMElement)localObject3).finalContentRect.height();
                      ((PointF)localObject1).x = ((WMElement)localObject3).finalContentRect.left;
                      ((PointF)localObject1).y = ((WMElement)localObject3).finalContentRect.top;
                    }
                  }
                }
                Object localObject3 = new PointF(localWMElement.offsetX, localWMElement.offsetY);
                f3 = ((PointF)localObject1).x;
                f2 = f2 * localWMElement.relativeAnchor.x + f3 + ((PointF)localObject3).x - localWMElement.width * localWMElement.anchor.x;
                f3 = ((PointF)localObject1).y;
                f1 = f1 * localWMElement.relativeAnchor.y + f3 + ((PointF)localObject3).y - localWMElement.height * localWMElement.anchor.y;
                f3 = f2 + localWMElement.width;
                f4 = localWMElement.height + f1;
                if ((localWMElement instanceof ImageWMElement))
                {
                  localWMElement.finalContentRect.left = f2;
                  localWMElement.finalContentRect.top = f1;
                  localWMElement.finalContentRect.right = f3;
                  localWMElement.finalContentRect.bottom = f4;
                  label667:
                  localObject1 = this.mCopyFilter;
                  if ((TextUtils.isEmpty(localWMElement.animateType)) || (!this.mAnimationFilerMap.containsKey(localWMElement.animateType))) {
                    break label978;
                  }
                  localObject1 = (WMAnimationFilterBase)this.mAnimationFilerMap.get(localWMElement.animateType);
                  ((WMAnimationFilterBase)localObject1).updateParams(localWMElement, this.width, this.height);
                }
              }
            }
          }
        }
        label978:
        for (;;)
        {
          BenchUtil.benchStart("draw texture");
          ((BaseFilter)localObject1).setPositions(AlgoUtils.calPositions(f2, f4, f3, f1, this.width, this.height));
          ((BaseFilter)localObject1).OnDrawFrameGLSL();
          ((BaseFilter)localObject1).renderTexture(this.mTexId[0], this.width, this.height);
          BenchUtil.benchEnd("draw texture");
          break label282;
          localObject1 = this.wmElements.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (WMElement)((Iterator)localObject1).next();
            if (((localObject2 instanceof TextWMElement)) && (paramBoolean2)) {
              ((TextWMElement)localObject2).updateTextShaderBmp(paramLong);
            } else {
              ((WMElement)localObject2).updateBitmap(paramLong, paramBoolean3);
            }
          }
          break;
          localObject1 = (TextWMElement)localWMElement;
          localWMElement.finalContentRect.left = (((TextWMElement)localObject1).getTextRect().left + f2);
          localWMElement.finalContentRect.top = (((TextWMElement)localObject1).getTextRect().top + f1);
          localWMElement.finalContentRect.right = (((TextWMElement)localObject1).getTextRect().right + f2);
          localWMElement.finalContentRect.bottom = (((TextWMElement)localObject1).getTextRect().bottom + f1);
          break label667;
          BenchUtil.benchEnd("updateTexture");
          GlUtil.setBlendMode(paramBoolean2);
          AppMethodBeat.o(83594);
          return paramBoolean1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.model.WMGroup
 * JD-Core Version:    0.7.0.1
 */