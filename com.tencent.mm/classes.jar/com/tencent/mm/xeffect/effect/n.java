package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "setConfigJson", "", "config", "", "setScene", "scene", "", "setShowFaceLandmarks", "show", "", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "Scene", "renderlib_release"})
public final class n
  extends af
{
  public n(long paramLong)
  {
    super(paramLong);
  }
  
  public final void Im(boolean paramBoolean)
  {
    AppMethodBeat.i(195809);
    VLogEffectJNI.INSTANCE.setShowLandmarks$renderlib_release(this.ptr, paramBoolean);
    AppMethodBeat.o(195809);
  }
  
  public final void bCB(String paramString)
  {
    AppMethodBeat.i(195807);
    p.k(paramString, "config");
    VLogEffectJNI.INSTANCE.setConfigJson$renderlib_release(this.ptr, paramString);
    AppMethodBeat.o(195807);
  }
  
  public final j ika()
  {
    return j.YZM;
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(195808);
    VLogEffectJNI.INSTANCE.setScene$renderlib_release(this.ptr, paramInt);
    AppMethodBeat.o(195808);
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect$Scene;", "", "(Ljava/lang/String;I)V", "Pet", "People", "Food", "Plant", "Flower", "Sky", "SunriseSunset", "Snow", "City", "Night", "Room", "Doc", "Origin", "renderlib_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(195799);
      a locala1 = new a("Pet", 0);
      Zaa = locala1;
      a locala2 = new a("People", 1);
      Zab = locala2;
      a locala3 = new a("Food", 2);
      Zac = locala3;
      a locala4 = new a("Plant", 3);
      Zad = locala4;
      a locala5 = new a("Flower", 4);
      Zae = locala5;
      a locala6 = new a("Sky", 5);
      Zaf = locala6;
      a locala7 = new a("SunriseSunset", 6);
      Zag = locala7;
      a locala8 = new a("Snow", 7);
      Zah = locala8;
      a locala9 = new a("City", 8);
      Zai = locala9;
      a locala10 = new a("Night", 9);
      Zaj = locala10;
      a locala11 = new a("Room", 10);
      Zak = locala11;
      a locala12 = new a("Doc", 11);
      Zal = locala12;
      a locala13 = new a("Origin", 12);
      Zam = locala13;
      Zan = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10, locala11, locala12, locala13 };
      AppMethodBeat.o(195799);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.n
 * JD-Core Version:    0.7.0.1
 */