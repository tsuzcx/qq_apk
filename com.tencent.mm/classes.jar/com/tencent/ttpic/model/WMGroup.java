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
  private Map<String, WMAnimationFilterBase> mAnimationFilerMap = new HashMap();
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bcE);
  private h mCopyFrame = new h();
  private Map<String, WMElement> mIdElementMap = new HashMap();
  private int[] mTexId = new int[1];
  private int width;
  public List<WMElement> wmElements = new ArrayList();
  
  public void clear()
  {
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
  }
  
  public WMAnimationFilterBase createAnimationFilter(WMElement paramWMElement, int paramInt1, int paramInt2)
  {
    if ("scale".equals(paramWMElement.animateType)) {
      return new WMScaleAnimationFilter(paramWMElement, paramInt1, paramInt2);
    }
    if ("dithering".equals(paramWMElement.animateType)) {
      return new WMDitheringAnimationFilter(paramWMElement, paramInt1, paramInt2);
    }
    return null;
  }
  
  public int getTexture()
  {
    return this.mCopyFrame.texture[0];
  }
  
  public void init()
  {
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
  }
  
  public void setItemId(String paramString)
  {
    Iterator localIterator = this.wmElements.iterator();
    while (localIterator.hasNext()) {
      ((WMElement)localIterator.next()).itemId = paramString;
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void updateTexture(long paramLong)
  {
    Object localObject1 = this.wmElements.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((WMElement)((Iterator)localObject1).next()).updateBitmap(paramLong);
    }
    localObject1 = this.wmElements.iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (!((WMElement)((Iterator)localObject1).next()).isContentChanged());
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        BenchUtil.benchStart("updateTexture");
        BenchUtil.benchStart("clear texture");
        FrameUtil.clearFrame(this.mCopyFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.width, this.height);
        BenchUtil.benchEnd("clear texture");
        Iterator localIterator = this.wmElements.iterator();
        while (localIterator.hasNext())
        {
          WMElement localWMElement = (WMElement)localIterator.next();
          localObject1 = localWMElement.getBitmap();
          if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
          {
            BenchUtil.benchStart("load texture");
            GlUtil.loadTexture(this.mTexId[0], (Bitmap)localObject1);
            BenchUtil.benchEnd("load texture");
            float f3 = this.width;
            float f4 = this.height;
            localObject1 = new PointF(0.0F, 0.0F);
            float f1 = f4;
            float f2 = f3;
            if (!TextUtils.isEmpty(localWMElement.relativeID))
            {
              localObject2 = (WMElement)this.mIdElementMap.get(localWMElement.relativeID);
              f1 = f4;
              f2 = f3;
              if (localObject2 != null)
              {
                f1 = f4;
                f2 = f3;
                if (((WMElement)localObject2).finalContentRect != null)
                {
                  f2 = ((WMElement)localObject2).finalContentRect.width();
                  f1 = ((WMElement)localObject2).finalContentRect.height();
                  ((PointF)localObject1).x = ((WMElement)localObject2).finalContentRect.left;
                  ((PointF)localObject1).y = ((WMElement)localObject2).finalContentRect.top;
                }
              }
            }
            Object localObject2 = new PointF(localWMElement.offsetX, localWMElement.offsetY);
            f2 = ((PointF)localObject1).x + f2 * localWMElement.relativeAnchor.x + ((PointF)localObject2).x - localWMElement.width * localWMElement.anchor.x;
            f3 = ((PointF)localObject1).y;
            f1 = f1 * localWMElement.relativeAnchor.y + f3 + ((PointF)localObject2).y - localWMElement.height * localWMElement.anchor.y;
            f3 = f2 + localWMElement.width;
            f4 = f1 + localWMElement.height;
            if ((localWMElement instanceof ImageWMElement))
            {
              localWMElement.finalContentRect.left = f2;
              localWMElement.finalContentRect.top = f1;
              localWMElement.finalContentRect.right = f3;
            }
            for (localWMElement.finalContentRect.bottom = f4;; localWMElement.finalContentRect.bottom = (((TextWMElement)localObject1).getTextRect().bottom + f1))
            {
              localObject2 = this.mCopyFilter;
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(localWMElement.animateType))
              {
                localObject1 = localObject2;
                if (this.mAnimationFilerMap.containsKey(localWMElement.animateType))
                {
                  localObject1 = (WMAnimationFilterBase)this.mAnimationFilerMap.get(localWMElement.animateType);
                  ((WMAnimationFilterBase)localObject1).updateParams(localWMElement, this.width, this.height);
                }
              }
              BenchUtil.benchStart("draw texture");
              ((BaseFilter)localObject1).setPositions(AlgoUtils.calPositions(f2, f4, f3, f1, this.width, this.height));
              ((BaseFilter)localObject1).OnDrawFrameGLSL();
              ((BaseFilter)localObject1).renderTexture(this.mTexId[0], this.width, this.height);
              BenchUtil.benchEnd("draw texture");
              break;
              localObject1 = (TextWMElement)localWMElement;
              localWMElement.finalContentRect.left = (((TextWMElement)localObject1).getTextRect().left + f2);
              localWMElement.finalContentRect.top = (((TextWMElement)localObject1).getTextRect().top + f1);
              localWMElement.finalContentRect.right = (((TextWMElement)localObject1).getTextRect().right + f2);
            }
          }
        }
        BenchUtil.benchEnd("updateTexture");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.model.WMGroup
 * JD-Core Version:    0.7.0.1
 */