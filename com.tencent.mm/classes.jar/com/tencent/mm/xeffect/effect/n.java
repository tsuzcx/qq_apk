package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "setConfigJson", "", "config", "", "setScene", "scene", "", "setShowFaceLandmarks", "show", "", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "Scene", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class n
  extends af
{
  public n(long paramLong)
  {
    super(paramLong);
  }
  
  public final void Oo(boolean paramBoolean)
  {
    AppMethodBeat.i(234567);
    VLogEffectJNI.INSTANCE.setShowLandmarks$renderlib_release(this.ptr, paramBoolean);
    AppMethodBeat.o(234567);
  }
  
  public final void bEY(String paramString)
  {
    AppMethodBeat.i(234554);
    s.t(paramString, "config");
    VLogEffectJNI.INSTANCE.setConfigJson$renderlib_release(this.ptr, paramString);
    AppMethodBeat.o(234554);
  }
  
  public final j jQi()
  {
    return j.agXY;
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(234559);
    VLogEffectJNI.INSTANCE.setScene$renderlib_release(this.ptr, paramInt);
    AppMethodBeat.o(234559);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect$Scene;", "", "(Ljava/lang/String;I)V", "Pet", "People", "Food", "Plant", "Flower", "Sky", "SunriseSunset", "Snow", "City", "Night", "Room", "Doc", "Origin", "renderlib_release"}, k=1, mv={1, 1, 15})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(234589);
      a locala1 = new a("Pet", 0);
      agYm = locala1;
      a locala2 = new a("People", 1);
      agYn = locala2;
      a locala3 = new a("Food", 2);
      agYo = locala3;
      a locala4 = new a("Plant", 3);
      agYp = locala4;
      a locala5 = new a("Flower", 4);
      agYq = locala5;
      a locala6 = new a("Sky", 5);
      agYr = locala6;
      a locala7 = new a("SunriseSunset", 6);
      agYs = locala7;
      a locala8 = new a("Snow", 7);
      agYt = locala8;
      a locala9 = new a("City", 8);
      agYu = locala9;
      a locala10 = new a("Night", 9);
      agYv = locala10;
      a locala11 = new a("Room", 10);
      agYw = locala11;
      a locala12 = new a("Doc", 11);
      agYx = locala12;
      a locala13 = new a("Origin", 12);
      agYy = locala13;
      agYz = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13 };
      AppMethodBeat.o(234589);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.n
 * JD-Core Version:    0.7.0.1
 */