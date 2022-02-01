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
  long LBd;
  
  static
  {
    AppMethodBeat.i(220046);
    e.load("xlabeffect");
    e.load("pag");
    PAGFont.loadSystemFonts();
    AppMethodBeat.o(220046);
  }
  
  public VLogEffectMgr()
  {
    AppMethodBeat.i(220022);
    this.LBd = nativeInit();
    AppMethodBeat.o(220022);
  }
  
  private VLogEffectMgr(long paramLong)
  {
    AppMethodBeat.i(220023);
    this.LBd = nativeCopy(paramLong);
    AppMethodBeat.o(220023);
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
  
  private static native boolean removePAGSticker(long paramLong1, long paramLong2);
  
  private static native boolean removePAGText(long paramLong1, long paramLong2);
  
  private static native boolean removeVLogEffectRange(long paramLong1, long paramLong2);
  
  private static native void reset(long paramLong);
  
  private static native void setEffectParams(long paramLong1, long paramLong2, int[] paramArrayOfInt, float[] paramArrayOfFloat);
  
  private static native void setEffectRangeParams(long paramLong1, long paramLong2, int[] paramArrayOfInt, float[] paramArrayOfFloat);
  
  private static native boolean updatePAGSticker(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
  
  private static native boolean updatePAGText(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, String paramString1, float paramFloat3, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native boolean updateVLogEffectRange(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long[] paramArrayOfLong);
  
  public final boolean EJ(long paramLong)
  {
    AppMethodBeat.i(220036);
    if (this.LBd != 0L)
    {
      boolean bool = removeVLogEffectRange(this.LBd, paramLong);
      AppMethodBeat.o(220036);
      return bool;
    }
    AppMethodBeat.o(220036);
    return false;
  }
  
  public final boolean EK(long paramLong)
  {
    AppMethodBeat.i(220039);
    if (this.LBd != 0L)
    {
      boolean bool = removePAGText(this.LBd, paramLong);
      AppMethodBeat.o(220039);
      return bool;
    }
    AppMethodBeat.o(220039);
    return false;
  }
  
  public final boolean EL(long paramLong)
  {
    AppMethodBeat.i(220040);
    if (this.LBd != 0L)
    {
      boolean bool = bringToFront(this.LBd, paramLong);
      AppMethodBeat.o(220040);
      return bool;
    }
    AppMethodBeat.o(220040);
    return false;
  }
  
  public final int EM(long paramLong)
  {
    AppMethodBeat.i(220041);
    if (this.LBd != 0L)
    {
      int i = getVLogEffectReplacementImages(this.LBd, paramLong);
      AppMethodBeat.o(220041);
      return i;
    }
    AppMethodBeat.o(220041);
    return -1;
  }
  
  public final Size EN(long paramLong)
  {
    AppMethodBeat.i(220042);
    if (this.LBd != 0L)
    {
      Size localSize = new Size(getVLogEffectWidth(this.LBd, paramLong), getVLogEffectHeight(this.LBd, paramLong));
      AppMethodBeat.o(220042);
      return localSize;
    }
    AppMethodBeat.o(220042);
    return null;
  }
  
  public final long EO(long paramLong)
  {
    AppMethodBeat.i(220043);
    if (this.LBd != 0L)
    {
      paramLong = getVLogEffectDuration(this.LBd, paramLong);
      AppMethodBeat.o(220043);
      return paramLong;
    }
    AppMethodBeat.o(220043);
    return 0L;
  }
  
  public final List<Pair<Long, Long>> EP(long paramLong)
  {
    AppMethodBeat.i(220044);
    if (this.LBd != 0L)
    {
      int j = EM(paramLong);
      long[] arrayOfLong1 = new long[j];
      long[] arrayOfLong2 = new long[j];
      getTemplateReplaceImageInfo(this.LBd, paramLong, arrayOfLong1, arrayOfLong2);
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new Pair(Long.valueOf(arrayOfLong1[i]), Long.valueOf(arrayOfLong2[i])));
        i += 1;
      }
      AppMethodBeat.o(220044);
      return localArrayList;
    }
    AppMethodBeat.o(220044);
    return null;
  }
  
  public final long a(long paramLong1, long paramLong2, long paramLong3, b paramb, c paramc)
  {
    AppMethodBeat.i(220037);
    if (this.LBd != 0L)
    {
      paramLong1 = addPAGText(this.LBd, paramLong1, paramLong2, paramLong3, paramb.translateX, paramb.translateY, paramb.scale, paramb.kRD, paramc.text, paramc.fontSize, paramc.fontFamily, paramc.LBk, paramc.sWe);
      AppMethodBeat.o(220037);
      return paramLong1;
    }
    AppMethodBeat.o(220037);
    return -1L;
  }
  
  public final long a(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong)
  {
    AppMethodBeat.i(220034);
    if (this.LBd != 0L)
    {
      paramLong1 = addVLogEffectRangeAtTimeRange(this.LBd, paramLong1, paramLong2, paramLong3, paramArrayOfLong);
      AppMethodBeat.o(220034);
      return paramLong1;
    }
    AppMethodBeat.o(220034);
    return -1L;
  }
  
  public final long a(a parama)
  {
    AppMethodBeat.i(220025);
    if (this.LBd != 0L)
    {
      long l = createVLogEffectFromType(this.LBd, parama.ordinal());
      AppMethodBeat.o(220025);
      return l;
    }
    AppMethodBeat.o(220025);
    return -1L;
  }
  
  public final long a(a parama, AssetManager paramAssetManager, String paramString)
  {
    AppMethodBeat.i(220026);
    if (this.LBd != 0L)
    {
      long l = createVLogEffectFromAssetPath(this.LBd, parama.ordinal(), paramAssetManager, paramString);
      AppMethodBeat.o(220026);
      return l;
    }
    AppMethodBeat.o(220026);
    return -1L;
  }
  
  public final long a(a parama, String paramString)
  {
    AppMethodBeat.i(220027);
    if (this.LBd != 0L)
    {
      long l = createVLogEffectFromPath(this.LBd, parama.ordinal(), paramString);
      AppMethodBeat.o(220027);
      return l;
    }
    AppMethodBeat.o(220027);
    return -1L;
  }
  
  public final void a(long paramLong, HashMap<Integer, Float> paramHashMap)
  {
    AppMethodBeat.i(220031);
    if (this.LBd != 0L)
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
      setEffectParams(this.LBd, paramLong, arrayOfInt, arrayOfFloat);
    }
    AppMethodBeat.o(220031);
  }
  
  public final boolean a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, b paramb, c paramc)
  {
    AppMethodBeat.i(220038);
    if (this.LBd != 0L)
    {
      boolean bool = updatePAGText(this.LBd, paramLong1, paramLong2, paramLong3, paramLong4, paramb.translateX, paramb.translateY, paramb.scale, paramb.kRD, paramc.text, paramc.fontSize, paramc.fontFamily, paramc.LBk, paramc.sWe);
      AppMethodBeat.o(220038);
      return bool;
    }
    AppMethodBeat.o(220038);
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long[] paramArrayOfLong)
  {
    AppMethodBeat.i(220035);
    if (this.LBd != 0L)
    {
      boolean bool = updateVLogEffectRange(this.LBd, paramLong1, paramLong2, paramLong3, paramLong4, paramArrayOfLong);
      AppMethodBeat.o(220035);
      return bool;
    }
    AppMethodBeat.o(220035);
    return false;
  }
  
  public final void b(long paramLong, HashMap<Integer, Float> paramHashMap)
  {
    AppMethodBeat.i(220032);
    if (this.LBd != 0L)
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
      setEffectRangeParams(this.LBd, paramLong, arrayOfInt, arrayOfFloat);
    }
    AppMethodBeat.o(220032);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(220045);
    if (this.LBd != 0L)
    {
      nativeDestroy(this.LBd);
      this.LBd = 0L;
    }
    AppMethodBeat.o(220045);
  }
  
  public final VLogEffectMgr fSp()
  {
    AppMethodBeat.i(220024);
    VLogEffectMgr localVLogEffectMgr = new VLogEffectMgr(this.LBd);
    AppMethodBeat.o(220024);
    return localVLogEffectMgr;
  }
  
  public final void fSq()
  {
    AppMethodBeat.i(220028);
    if (this.LBd != 0L) {
      clearVLogEffectRange(this.LBd);
    }
    AppMethodBeat.o(220028);
  }
  
  public final void fSr()
  {
    AppMethodBeat.i(220029);
    if (this.LBd != 0L) {
      clearTransEffectRange(this.LBd);
    }
    AppMethodBeat.o(220029);
  }
  
  public final void fSs()
  {
    AppMethodBeat.i(220030);
    if (this.LBd != 0L) {
      clearStickers(this.LBd);
    }
    AppMethodBeat.o(220030);
  }
  
  public final long s(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(220033);
    paramLong1 = a(paramLong1, paramLong2, paramLong3, new long[0]);
    AppMethodBeat.o(220033);
    return paramLong1;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(220018);
      LBm = new a("PAGTransitionEffect", 0);
      LBn = new a("PAGStickerEffect", 1);
      LBo = new a("PAGTextEffect", 2);
      LBp = new a("PAGImageReplacementEffect", 3);
      LBq = new a("PAGGlobalImageReplacementEffect", 4);
      LBr = new a("PAGVideoTemplateEffect", 5);
      LBs = new a("LutFilterEffect", 6);
      LBt = new a("BrightnessFilterEffect", 7);
      LBu = new a("ContrastFilterEffect", 8);
      LBv = new a("SaturationFilterEffect", 9);
      LBw = new a("HueFilterEffect", 10);
      LBx = new a("WhiteBalanceEffect", 11);
      LBy = new a("ImageEnhanceEffect", 12);
      LBz = new a("Unknown", 13);
      LBA = new a[] { LBm, LBn, LBo, LBp, LBq, LBr, LBs, LBt, LBu, LBv, LBw, LBx, LBy, LBz };
      AppMethodBeat.o(220018);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.xeffect.VLogEffectMgr
 * JD-Core Version:    0.7.0.1
 */