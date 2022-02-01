package com.tencent.mm.xeffect;

import android.content.res.AssetManager;
import android.util.Pair;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.libpag.PAGFont;

public class VLogEffectMgr
{
  long LYd;
  
  static
  {
    AppMethodBeat.i(216797);
    e.load("xlabeffect");
    e.load("pag");
    PAGFont.loadSystemFonts();
    AppMethodBeat.o(216797);
  }
  
  public VLogEffectMgr()
  {
    AppMethodBeat.i(216773);
    this.LYd = nativeInit();
    AppMethodBeat.o(216773);
  }
  
  private VLogEffectMgr(long paramLong)
  {
    AppMethodBeat.i(216774);
    this.LYd = nativeCopy(paramLong);
    AppMethodBeat.o(216774);
  }
  
  private static native long addPAGSticker(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
  
  private static native long addPAGText(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, String paramString1, float paramFloat3, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native long addVLogEffectRange(long paramLong1, long paramLong2);
  
  private static native long addVLogEffectRangeAtTimeRange(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long[] paramArrayOfLong);
  
  private static native boolean bringToFront(long paramLong1, long paramLong2);
  
  private static native void clearStickers(long paramLong);
  
  private static native void clearTransEffectRange(long paramLong);
  
  private static native void clearVLogEffect(long paramLong);
  
  private static native void clearVLogEffectRange(long paramLong);
  
  private static native long createVLogEffectFromAssetPath(long paramLong, int paramInt, AssetManager paramAssetManager, String paramString);
  
  private static native long createVLogEffectFromPath(long paramLong, int paramInt, String paramString);
  
  private static native long createVLogEffectFromType(long paramLong, int paramInt);
  
  private static native void getTemplateReplaceImageInfo(long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2);
  
  private static native long getVLogEffectDuration(long paramLong1, long paramLong2);
  
  private static native int getVLogEffectHeight(long paramLong1, long paramLong2);
  
  private static native int getVLogEffectReplacementImages(long paramLong1, long paramLong2);
  
  private static native int getVLogEffectWidth(long paramLong1, long paramLong2);
  
  private static native long nativeCopy(long paramLong);
  
  private static native void nativeDestroy(long paramLong);
  
  private static native long nativeInit();
  
  private static native boolean nativeSetImageEnhancementSceneFilterSettings(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfInt1, float[] paramArrayOfFloat, String[] paramArrayOfString, int[] paramArrayOfInt2);
  
  private static native boolean nativeSetImageEnhancementSceneFilterSettingsByJsonConfig(long paramLong1, long paramLong2, String paramString);
  
  private static native boolean removePAGSticker(long paramLong1, long paramLong2);
  
  private static native boolean removePAGText(long paramLong1, long paramLong2);
  
  private static native boolean removeVLogEffectRange(long paramLong1, long paramLong2);
  
  private static native void reset(long paramLong);
  
  private static native void setEffectParams(long paramLong1, long paramLong2, int[] paramArrayOfInt, float[] paramArrayOfFloat);
  
  private static native void setEffectRangeParams(long paramLong1, long paramLong2, int[] paramArrayOfInt, float[] paramArrayOfFloat);
  
  private static native boolean updatePAGSticker(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
  
  private static native boolean updatePAGText(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, String paramString1, float paramFloat3, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native boolean updateVLogEffectRange(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long[] paramArrayOfLong);
  
  public final boolean Fl(long paramLong)
  {
    AppMethodBeat.i(216787);
    if (this.LYd != 0L)
    {
      boolean bool = removeVLogEffectRange(this.LYd, paramLong);
      AppMethodBeat.o(216787);
      return bool;
    }
    AppMethodBeat.o(216787);
    return false;
  }
  
  public final boolean Fm(long paramLong)
  {
    AppMethodBeat.i(216790);
    if (this.LYd != 0L)
    {
      boolean bool = removePAGText(this.LYd, paramLong);
      AppMethodBeat.o(216790);
      return bool;
    }
    AppMethodBeat.o(216790);
    return false;
  }
  
  public final boolean Fn(long paramLong)
  {
    AppMethodBeat.i(216791);
    if (this.LYd != 0L)
    {
      boolean bool = bringToFront(this.LYd, paramLong);
      AppMethodBeat.o(216791);
      return bool;
    }
    AppMethodBeat.o(216791);
    return false;
  }
  
  public final int Fo(long paramLong)
  {
    AppMethodBeat.i(216792);
    if (this.LYd != 0L)
    {
      int i = getVLogEffectReplacementImages(this.LYd, paramLong);
      AppMethodBeat.o(216792);
      return i;
    }
    AppMethodBeat.o(216792);
    return -1;
  }
  
  public final Size Fp(long paramLong)
  {
    AppMethodBeat.i(216793);
    if (this.LYd != 0L)
    {
      Size localSize = new Size(getVLogEffectWidth(this.LYd, paramLong), getVLogEffectHeight(this.LYd, paramLong));
      AppMethodBeat.o(216793);
      return localSize;
    }
    AppMethodBeat.o(216793);
    return null;
  }
  
  public final long Fq(long paramLong)
  {
    AppMethodBeat.i(216794);
    if (this.LYd != 0L)
    {
      paramLong = getVLogEffectDuration(this.LYd, paramLong);
      AppMethodBeat.o(216794);
      return paramLong;
    }
    AppMethodBeat.o(216794);
    return 0L;
  }
  
  public final List<Pair<Long, Long>> Fr(long paramLong)
  {
    AppMethodBeat.i(216795);
    if (this.LYd != 0L)
    {
      int j = Fo(paramLong);
      long[] arrayOfLong1 = new long[j];
      long[] arrayOfLong2 = new long[j];
      getTemplateReplaceImageInfo(this.LYd, paramLong, arrayOfLong1, arrayOfLong2);
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new Pair(Long.valueOf(arrayOfLong1[i]), Long.valueOf(arrayOfLong2[i])));
        i += 1;
      }
      AppMethodBeat.o(216795);
      return localArrayList;
    }
    AppMethodBeat.o(216795);
    return null;
  }
  
  public final long a(long paramLong1, long paramLong2, long paramLong3, b paramb, c paramc)
  {
    AppMethodBeat.i(216788);
    if (this.LYd != 0L)
    {
      paramLong1 = addPAGText(this.LYd, paramLong1, paramLong2, paramLong3, paramb.translateX, paramb.translateY, paramb.scale, paramb.kVl, paramc.text, paramc.fontSize, paramc.fontFamily, paramc.LYk, paramc.ryR);
      AppMethodBeat.o(216788);
      return paramLong1;
    }
    AppMethodBeat.o(216788);
    return -1L;
  }
  
  public final long a(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong)
  {
    AppMethodBeat.i(216785);
    if (this.LYd != 0L)
    {
      paramLong1 = addVLogEffectRangeAtTimeRange(this.LYd, paramLong1, paramLong2, paramLong3, paramArrayOfLong);
      AppMethodBeat.o(216785);
      return paramLong1;
    }
    AppMethodBeat.o(216785);
    return -1L;
  }
  
  public final long a(a parama)
  {
    AppMethodBeat.i(216776);
    if (this.LYd != 0L)
    {
      long l = createVLogEffectFromType(this.LYd, parama.ordinal());
      AppMethodBeat.o(216776);
      return l;
    }
    AppMethodBeat.o(216776);
    return -1L;
  }
  
  public final long a(a parama, AssetManager paramAssetManager, String paramString)
  {
    AppMethodBeat.i(216777);
    if (this.LYd != 0L)
    {
      long l = createVLogEffectFromAssetPath(this.LYd, parama.ordinal(), paramAssetManager, paramString);
      AppMethodBeat.o(216777);
      return l;
    }
    AppMethodBeat.o(216777);
    return -1L;
  }
  
  public final long a(a parama, String paramString)
  {
    AppMethodBeat.i(216778);
    if (this.LYd != 0L)
    {
      long l = createVLogEffectFromPath(this.LYd, parama.ordinal(), paramString);
      AppMethodBeat.o(216778);
      return l;
    }
    AppMethodBeat.o(216778);
    return -1L;
  }
  
  public final void a(long paramLong, HashMap<Integer, Float> paramHashMap)
  {
    AppMethodBeat.i(216782);
    if (this.LYd != 0L)
    {
      int[] arrayOfInt = new int[paramHashMap.size()];
      float[] arrayOfFloat = new float[paramHashMap.size()];
      Iterator localIterator = paramHashMap.keySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        arrayOfInt[i] = localInteger.intValue();
        arrayOfFloat[i] = ((Float)paramHashMap.get(localInteger)).floatValue();
        i += 1;
      }
      setEffectParams(this.LYd, paramLong, arrayOfInt, arrayOfFloat);
    }
    AppMethodBeat.o(216782);
  }
  
  public final boolean a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, b paramb, c paramc)
  {
    AppMethodBeat.i(216789);
    if (this.LYd != 0L)
    {
      boolean bool = updatePAGText(this.LYd, paramLong1, paramLong2, paramLong3, paramLong4, paramb.translateX, paramb.translateY, paramb.scale, paramb.kVl, paramc.text, paramc.fontSize, paramc.fontFamily, paramc.LYk, paramc.ryR);
      AppMethodBeat.o(216789);
      return bool;
    }
    AppMethodBeat.o(216789);
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long[] paramArrayOfLong)
  {
    AppMethodBeat.i(216786);
    if (this.LYd != 0L)
    {
      boolean bool = updateVLogEffectRange(this.LYd, paramLong1, paramLong2, paramLong3, paramLong4, paramArrayOfLong);
      AppMethodBeat.o(216786);
      return bool;
    }
    AppMethodBeat.o(216786);
    return false;
  }
  
  public final void b(long paramLong, HashMap<Integer, Float> paramHashMap)
  {
    AppMethodBeat.i(216783);
    if (this.LYd != 0L)
    {
      int[] arrayOfInt = new int[paramHashMap.size()];
      float[] arrayOfFloat = new float[paramHashMap.size()];
      Iterator localIterator = paramHashMap.keySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        arrayOfInt[i] = localInteger.intValue();
        arrayOfFloat[i] = ((Float)paramHashMap.get(localInteger)).floatValue();
        i += 1;
      }
      setEffectRangeParams(this.LYd, paramLong, arrayOfInt, arrayOfFloat);
    }
    AppMethodBeat.o(216783);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(216796);
    if (this.LYd != 0L)
    {
      nativeDestroy(this.LYd);
      this.LYd = 0L;
    }
    AppMethodBeat.o(216796);
  }
  
  public final VLogEffectMgr fWO()
  {
    AppMethodBeat.i(216775);
    VLogEffectMgr localVLogEffectMgr = new VLogEffectMgr(this.LYd);
    AppMethodBeat.o(216775);
    return localVLogEffectMgr;
  }
  
  public final void fWP()
  {
    AppMethodBeat.i(216779);
    if (this.LYd != 0L) {
      clearVLogEffectRange(this.LYd);
    }
    AppMethodBeat.o(216779);
  }
  
  public final void fWQ()
  {
    AppMethodBeat.i(216780);
    if (this.LYd != 0L) {
      clearTransEffectRange(this.LYd);
    }
    AppMethodBeat.o(216780);
  }
  
  public final void fWR()
  {
    AppMethodBeat.i(216781);
    if (this.LYd != 0L) {
      clearStickers(this.LYd);
    }
    AppMethodBeat.o(216781);
  }
  
  public final long s(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(216784);
    paramLong1 = a(paramLong1, paramLong2, paramLong3, new long[0]);
    AppMethodBeat.o(216784);
    return paramLong1;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(216769);
      LYm = new a("PAGTransitionEffect", 0);
      LYn = new a("PAGStickerEffect", 1);
      LYo = new a("PAGTextEffect", 2);
      LYp = new a("PAGImageReplacementEffect", 3);
      LYq = new a("PAGGlobalImageReplacementEffect", 4);
      LYr = new a("PAGVideoTemplateEffect", 5);
      LYs = new a("LutFilterEffect", 6);
      LYt = new a("BrightnessFilterEffect", 7);
      LYu = new a("ContrastFilterEffect", 8);
      LYv = new a("SaturationFilterEffect", 9);
      LYw = new a("HueFilterEffect", 10);
      LYx = new a("WhiteBalanceEffect", 11);
      LYy = new a("ImageEnhanceEffect", 12);
      LYz = new a("Unknown", 13);
      LYA = new a[] { LYm, LYn, LYo, LYp, LYq, LYr, LYs, LYt, LYu, LYv, LYw, LYx, LYy, LYz };
      AppMethodBeat.o(216769);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.xeffect.VLogEffectMgr
 * JD-Core Version:    0.7.0.1
 */