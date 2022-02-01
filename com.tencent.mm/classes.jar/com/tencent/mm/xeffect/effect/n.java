package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "setConfigJson", "", "config", "", "setScene", "scene", "", "setShowFaceLandmarks", "show", "", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "Scene", "renderlib_release"})
public final class n
  extends ad
{
  public n(long paramLong)
  {
    super(paramLong);
  }
  
  public final void DL(boolean paramBoolean)
  {
    AppMethodBeat.i(237088);
    VLogEffectJNI.INSTANCE.setShowLandmarks$renderlib_release(this.ptr, paramBoolean);
    AppMethodBeat.o(237088);
  }
  
  public final void bpE(String paramString)
  {
    AppMethodBeat.i(237086);
    p.h(paramString, "config");
    VLogEffectJNI.INSTANCE.setConfigJson$renderlib_release(this.ptr, paramString);
    AppMethodBeat.o(237086);
  }
  
  public final j hiu()
  {
    return j.Ryg;
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(237087);
    VLogEffectJNI.INSTANCE.setScene$renderlib_release(this.ptr, paramInt);
    AppMethodBeat.o(237087);
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect$Scene;", "", "(Ljava/lang/String;I)V", "Pet", "People", "Food", "Plant", "Flower", "Sky", "SunriseSunset", "Snow", "City", "Night", "Room", "Doc", "Origin", "renderlib_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(237083);
      a locala1 = new a("Pet", 0);
      Rys = locala1;
      a locala2 = new a("People", 1);
      Ryt = locala2;
      a locala3 = new a("Food", 2);
      Ryu = locala3;
      a locala4 = new a("Plant", 3);
      Ryv = locala4;
      a locala5 = new a("Flower", 4);
      Ryw = locala5;
      a locala6 = new a("Sky", 5);
      Ryx = locala6;
      a locala7 = new a("SunriseSunset", 6);
      Ryy = locala7;
      a locala8 = new a("Snow", 7);
      Ryz = locala8;
      a locala9 = new a("City", 8);
      RyA = locala9;
      a locala10 = new a("Night", 9);
      RyB = locala10;
      a locala11 = new a("Room", 10);
      RyC = locala11;
      a locala12 = new a("Doc", 11);
      RyD = locala12;
      a locala13 = new a("Origin", 12);
      RyE = locala13;
      RyF = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13 };
      AppMethodBeat.o(237083);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.n
 * JD-Core Version:    0.7.0.1
 */