package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/EffectProfileData;", "", "ptr", "", "(J)V", "getPtr", "()J", "array2ProfileRecorder", "Lcom/tencent/mm/xeffect/effect/EffectProfileData$ProfileRecorder;", "array", "", "getCreatePAGFile", "getCreatePAGSurface", "getRenderPAG", "nGetCreatePAGFile", "nGetCreatePAGSurface", "nGetRenderPAG", "nReset", "", "reset", "ProfileRecorder", "renderlib_release"})
public final class EffectProfileData
{
  public final long ptr;
  
  public EffectProfileData(long paramLong)
  {
    this.ptr = paramLong;
  }
  
  public static a g(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(237072);
    a locala = new a((byte)0);
    if (paramArrayOfLong.length >= 3)
    {
      locala.JRy = ((int)paramArrayOfLong[0]);
      locala.successCount = ((int)paramArrayOfLong[1]);
      locala.RxT = paramArrayOfLong[2];
    }
    AppMethodBeat.o(237072);
    return locala;
  }
  
  private final native long[] nGetCreatePAGSurface(long paramLong);
  
  private final native void nReset(long paramLong);
  
  public final native long[] nGetCreatePAGFile();
  
  public final native long[] nGetRenderPAG(long paramLong);
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/EffectProfileData$ProfileRecorder;", "", "startCount", "", "successCount", "costAvg", "", "(IIJ)V", "getCostAvg", "()J", "setCostAvg", "(J)V", "getStartCount", "()I", "setStartCount", "(I)V", "getSuccessCount", "setSuccessCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "renderlib_release"})
  public static final class a
  {
    public int JRy = 0;
    public long RxT = 0L;
    public int successCount = 0;
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (this != paramObject)
      {
        bool1 = bool2;
        if (!(paramObject instanceof a)) {
          break label86;
        }
        paramObject = (a)paramObject;
        if (this.JRy != paramObject.JRy) {
          break label88;
        }
        i = 1;
        bool1 = bool2;
        if (i == 0) {
          break label86;
        }
        if (this.successCount != paramObject.successCount) {
          break label93;
        }
        i = 1;
        label56:
        bool1 = bool2;
        if (i == 0) {
          break label86;
        }
        if (this.RxT != paramObject.RxT) {
          break label98;
        }
      }
      label86:
      label88:
      label93:
      label98:
      for (int i = 1;; i = 0)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
        return bool1;
        i = 0;
        break;
        i = 0;
        break label56;
      }
    }
    
    public final int hashCode()
    {
      int i = this.JRy;
      int j = this.successCount;
      long l = this.RxT;
      return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(237071);
      String str = "ProfileRecorder(startCount=" + this.JRy + ", successCount=" + this.successCount + ", costAvg=" + this.RxT + ")";
      AppMethodBeat.o(237071);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.EffectProfileData
 * JD-Core Version:    0.7.0.1
 */