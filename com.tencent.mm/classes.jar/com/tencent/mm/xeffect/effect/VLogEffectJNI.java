package com.tencent.mm.xeffect.effect;

import android.util.Pair;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.XEffectLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/VLogEffectJNI;", "", "()V", "TAG", "", "destroyEffect", "", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "getPagDuration", "", "nPtr", "getPagDuration$renderlib_release", "getPagFrameRate", "", "getPagFrameRate$renderlib_release", "getPagImageNum", "", "getPagImageNum$renderlib_release", "getPagSize", "Landroid/util/Size;", "getPagSize$renderlib_release", "getPagTemplateInfo", "", "Landroid/util/Pair;", "replacementType", "Lcom/tencent/mm/xeffect/effect/PAGReplacementType;", "checkMarker", "", "getPagTemplateInfo$renderlib_release", "nDestroy", "ptr", "nGetPagDuration", "nGetPagFrameRate", "nGetPagImageNum", "nGetPagSize", "", "nGetPagTemplateInfo", "", "nSetCheckMarker", "check", "nSetConfigJson", "json", "nSetEffectIsPreMultiplied", "isPreMultiplied", "nSetEffectLayout", "centerX", "centerY", "scale", "rotate", "nSetEffectParams", "keys", "values", "", "nSetEffectText", "text", "fontSize", "fontFamily", "italic", "bold", "nSetEffectTexture", "textureId", "width", "height", "nSetEffectTime", "start", "end", "nSetFadeEffectFadeBackgroundColor", "red", "green", "blue", "nSetGradientBlurContentOffsetPercent", "percent", "nSetGradientBlurEffectBlurBottom", "blur", "nSetGradientBlurEffectBlurMaskRatio", "ratio", "nSetGradientBlurEffectBlurTop", "nSetGradientBlurEffectCenterCropBlur", "nSetGradientBlurEffectContentOffset", "offset", "nSetLutFilterWeight", "weight", "nSetPagTemplateText", "index", "nSetScene", "scene", "nSetShowLandmarks", "show", "nSetStickerSize", "setCheckMarker", "setCheckMarker$renderlib_release", "setConfigJson", "setConfigJson$renderlib_release", "setEffectLayout", "layout", "Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "setEffectLayout$renderlib_release", "setEffectParams", "effectParams", "", "setEffectParams$renderlib_release", "setEffectText", "textInfo", "Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "setEffectText$renderlib_release", "setEffectTexture", "setEffectTexture$renderlib_release", "setEffectTime", "timeRange", "Lcom/tencent/mm/xeffect/effect/EffectTimeRange;", "setEffectTime$renderlib_release", "setPagTemplateText", "setPagTemplateText$renderlib_release", "setScene", "setScene$renderlib_release", "setShowLandmarks", "setShowLandmarks$renderlib_release", "setStickerSize", "setStickerSize$renderlib_release", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class VLogEffectJNI
{
  public static final VLogEffectJNI INSTANCE;
  private static final String TAG = "VLogEffectJNI";
  
  static
  {
    AppMethodBeat.i(234614);
    INSTANCE = new VLogEffectJNI();
    TAG = "VLogEffectJNI";
    AppMethodBeat.o(234614);
  }
  
  private final native void nDestroy(long paramLong);
  
  private final native long nGetPagDuration(long paramLong);
  
  private final native float nGetPagFrameRate(long paramLong);
  
  private final native int nGetPagImageNum(long paramLong);
  
  private final native int[] nGetPagSize(long paramLong);
  
  private final native long[] nGetPagTemplateInfo(long paramLong, int paramInt, boolean paramBoolean);
  
  private final native void nSetCheckMarker(long paramLong, boolean paramBoolean);
  
  private final native void nSetConfigJson(long paramLong, String paramString);
  
  private final native void nSetEffectLayout(long paramLong, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
  
  private final native void nSetEffectParams(long paramLong, int[] paramArrayOfInt, float[] paramArrayOfFloat);
  
  private final native void nSetEffectText(long paramLong, String paramString1, float paramFloat, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  private final native void nSetEffectTexture(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private final native void nSetEffectTime(long paramLong1, long paramLong2, long paramLong3);
  
  private final native void nSetPagTemplateText(long paramLong, int paramInt, String paramString1, float paramFloat, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  private final native void nSetScene(long paramLong, int paramInt);
  
  private final native void nSetShowLandmarks(long paramLong, boolean paramBoolean);
  
  private final native void nSetStickerSize(long paramLong, int paramInt1, int paramInt2);
  
  public final void destroyEffect(af paramaf)
  {
    AppMethodBeat.i(234618);
    kotlin.g.b.s.t(paramaf, "effect");
    nDestroy(paramaf.ptr);
    AppMethodBeat.o(234618);
  }
  
  public final long getPagDuration$renderlib_release(long paramLong)
  {
    AppMethodBeat.i(234649);
    paramLong = nGetPagDuration(paramLong);
    AppMethodBeat.o(234649);
    return paramLong;
  }
  
  public final float getPagFrameRate$renderlib_release(long paramLong)
  {
    AppMethodBeat.i(234662);
    float f = nGetPagFrameRate(paramLong);
    AppMethodBeat.o(234662);
    return f;
  }
  
  public final int getPagImageNum$renderlib_release(long paramLong)
  {
    AppMethodBeat.i(234648);
    int i = nGetPagImageNum(paramLong);
    AppMethodBeat.o(234648);
    return i;
  }
  
  public final Size getPagSize$renderlib_release(long paramLong)
  {
    AppMethodBeat.i(234645);
    Object localObject = nGetPagSize(paramLong);
    localObject = new Size(localObject[0], localObject[1]);
    AppMethodBeat.o(234645);
    return localObject;
  }
  
  public final List<Pair<Long, Long>> getPagTemplateInfo$renderlib_release(long paramLong, s params, boolean paramBoolean)
  {
    AppMethodBeat.i(234659);
    kotlin.g.b.s.t(params, "replacementType");
    ArrayList localArrayList = new ArrayList();
    params = nGetPagTemplateInfo(paramLong, params.ordinal(), paramBoolean);
    if (params != null)
    {
      int i = 0;
      int j = params.length / 2;
      while (i < j)
      {
        localArrayList.add(new Pair(Long.valueOf(params[(i * 2)]), Long.valueOf(params[(i * 2 + 1)])));
        i += 1;
      }
    }
    params = (List)localArrayList;
    AppMethodBeat.o(234659);
    return params;
  }
  
  public final native void nSetEffectIsPreMultiplied(long paramLong, boolean paramBoolean);
  
  public final native void nSetFadeEffectFadeBackgroundColor(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public final native void nSetGradientBlurContentOffsetPercent(long paramLong, float paramFloat);
  
  public final native void nSetGradientBlurEffectBlurBottom(long paramLong, boolean paramBoolean);
  
  public final native void nSetGradientBlurEffectBlurMaskRatio(long paramLong, float paramFloat);
  
  public final native void nSetGradientBlurEffectBlurTop(long paramLong, boolean paramBoolean);
  
  public final native void nSetGradientBlurEffectCenterCropBlur(long paramLong, boolean paramBoolean);
  
  public final native void nSetGradientBlurEffectContentOffset(long paramLong, float paramFloat);
  
  public final native void nSetLutFilterWeight(long paramLong, float paramFloat);
  
  public final void setCheckMarker$renderlib_release(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(234653);
    nSetCheckMarker(paramLong, paramBoolean);
    AppMethodBeat.o(234653);
  }
  
  public final void setConfigJson$renderlib_release(long paramLong, String paramString)
  {
    AppMethodBeat.i(234664);
    kotlin.g.b.s.t(paramString, "json");
    nSetConfigJson(paramLong, paramString);
    AppMethodBeat.o(234664);
  }
  
  public final void setEffectLayout$renderlib_release(long paramLong, f paramf)
  {
    AppMethodBeat.i(234626);
    kotlin.g.b.s.t(paramf, "layout");
    if (paramLong != 0L) {
      nSetEffectLayout(paramLong, paramf.centerX, paramf.centerY, paramf.scale, paramf.aBi);
    }
    AppMethodBeat.o(234626);
  }
  
  public final void setEffectParams$renderlib_release(long paramLong, Map<Integer, Float> paramMap)
  {
    AppMethodBeat.i(234679);
    kotlin.g.b.s.t(paramMap, "effectParams");
    int i = paramMap.size();
    int[] arrayOfInt = new int[i];
    float[] arrayOfFloat = new float[i];
    Iterator localIterator = ((Iterable)paramMap.entrySet()).iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (Map.Entry)localObject;
      arrayOfInt[i] = ((Number)((Map.Entry)localObject).getKey()).intValue();
      arrayOfFloat[i] = ((Number)((Map.Entry)localObject).getValue()).floatValue();
      i += 1;
    }
    nSetEffectParams(paramLong, p.I((Collection)paramMap.keySet()), p.H(paramMap.values()));
    AppMethodBeat.o(234679);
  }
  
  public final void setEffectText$renderlib_release(long paramLong, h paramh)
  {
    AppMethodBeat.i(234631);
    kotlin.g.b.s.t(paramh, "textInfo");
    if (paramLong != 0L) {
      nSetEffectText(paramLong, paramh.text, paramh.fontSize, paramh.fontFamily, paramh.agXM, paramh.bold);
    }
    AppMethodBeat.o(234631);
  }
  
  public final void setEffectTexture$renderlib_release(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(234635);
    nSetEffectTexture(paramLong, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(234635);
  }
  
  public final void setEffectTime$renderlib_release(long paramLong, i parami)
  {
    AppMethodBeat.i(234623);
    kotlin.g.b.s.t(parami, "timeRange");
    if (paramLong != 0L) {
      nSetEffectTime(paramLong, parami.start, parami.axI);
    }
    AppMethodBeat.o(234623);
  }
  
  public final void setPagTemplateText$renderlib_release(long paramLong, int paramInt, h paramh)
  {
    AppMethodBeat.i(234655);
    kotlin.g.b.s.t(paramh, "textInfo");
    if (paramLong != 0L) {
      nSetPagTemplateText(paramLong, paramInt, paramh.text, paramh.fontSize, paramh.fontFamily, paramh.agXM, paramh.bold);
    }
    AppMethodBeat.o(234655);
  }
  
  public final void setScene$renderlib_release(long paramLong, int paramInt)
  {
    AppMethodBeat.i(234668);
    nSetScene(paramLong, paramInt);
    AppMethodBeat.o(234668);
  }
  
  public final void setShowLandmarks$renderlib_release(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(234673);
    nSetShowLandmarks(paramLong, paramBoolean);
    AppMethodBeat.o(234673);
  }
  
  public final void setStickerSize$renderlib_release(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234641);
    XEffectLog.i(TAG, "setStickerSize ptr:" + paramLong + ", width:" + paramInt1 + ", height:" + paramInt2, new Object[0]);
    nSetStickerSize(paramLong, paramInt1, paramInt2);
    AppMethodBeat.o(234641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.VLogEffectJNI
 * JD-Core Version:    0.7.0.1
 */