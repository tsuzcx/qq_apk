package com.tencent.mm.plugin.thumbplayer.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.effect.h.c;
import com.tencent.mm.xeffect.LayoutInfo;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.j.c;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/effect/ImageAnimation;", "", "()V", "applyAnimation", "", "animation", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;", "targetWidth", "", "targetHeight", "width", "height", "animationType", "Lcom/tencent/mm/plugin/thumbplayer/effect/ImageAnimation$AnimateType;", "applyImageContentAnimate", "bitmap", "Landroid/graphics/Bitmap;", "effectController", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController;", "type", "getAnimationType", "toAnimateType", "AnimateType", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a TCz;
  
  static
  {
    AppMethodBeat.i(272492);
    TCz = new a();
    AppMethodBeat.o(272492);
  }
  
  public static void a(h.c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a parama)
  {
    AppMethodBeat.i(272477);
    s.u(paramc, "animation");
    s.u(parama, "animationType");
    LayoutInfo localLayoutInfo = paramc.agEW;
    paramc = paramc.agEX;
    localLayoutInfo.centerX = (paramInt1 / 2);
    localLayoutInfo.centerY = (paramInt2 / 2);
    localLayoutInfo.agXz = 1;
    localLayoutInfo.scale = 1.0F;
    paramc.centerX = (paramInt1 / 2);
    paramc.centerY = (paramInt2 / 2);
    paramc.scale = 1.0F;
    float f = paramInt2 * 1.0F / paramInt4;
    paramInt1 = paramInt3 / 10;
    switch (b.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(272477);
      return;
      localLayoutInfo.agXz = 0;
      localLayoutInfo.scale = f;
      localLayoutInfo.centerX = (paramInt3 / 2 + paramInt1 / 2);
      paramc.scale = f;
      paramc.centerX = (paramInt3 / 2 - paramInt1 / 2);
      AppMethodBeat.o(272477);
      return;
      localLayoutInfo.agXz = 0;
      localLayoutInfo.scale = f;
      localLayoutInfo.centerX = (paramInt3 / 2 - paramInt1 / 2);
      paramc.scale = f;
      paramc.centerX = (paramInt3 / 2 + paramInt1 / 2);
      AppMethodBeat.o(272477);
      return;
      localLayoutInfo.agXz = 4;
      localLayoutInfo.scale = 1.05F;
      paramc.scale = 1.0F;
      AppMethodBeat.o(272477);
      return;
      localLayoutInfo.agXz = 4;
      localLayoutInfo.scale = 1.0F;
      paramc.scale = 1.05F;
      AppMethodBeat.o(272477);
      return;
      localLayoutInfo.agXz = 3;
      localLayoutInfo.scale = 1.05F;
      paramc.scale = 1.0F;
      AppMethodBeat.o(272477);
      return;
      localLayoutInfo.agXz = 3;
      localLayoutInfo.scale = 1.0F;
      paramc.scale = 1.05F;
    }
  }
  
  public static a aoD(int paramInt)
  {
    AppMethodBeat.i(272469);
    if (paramInt < a.values().length - 1)
    {
      locala = a.values()[paramInt];
      AppMethodBeat.o(272469);
      return locala;
    }
    a locala = a.TCH;
    AppMethodBeat.o(272469);
    return locala;
  }
  
  public static int mg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272486);
    float f = paramInt1 * 1.0F / paramInt2;
    Object localObject;
    if (f < 0.75F) {
      localObject = p.listOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(6) });
    }
    c localc;
    for (;;)
    {
      localObject = (Collection)localObject;
      localc = (c)c.aixl;
      s.u(localObject, "$this$random");
      s.u(localc, "random");
      if (!((Collection)localObject).isEmpty()) {
        break;
      }
      localObject = (Throwable)new NoSuchElementException("Collection is empty.");
      AppMethodBeat.o(272486);
      throw ((Throwable)localObject);
      if (f <= 1.333333F) {
        localObject = p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6) });
      } else {
        localObject = p.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(4) });
      }
    }
    paramInt1 = ((Number)p.b((Iterable)localObject, localc.Pa(((Collection)localObject).size()))).intValue();
    AppMethodBeat.o(272486);
    return paramInt1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/effect/ImageAnimation$AnimateType;", "", "(Ljava/lang/String;I)V", "Default", "RightToLeft", "LeftToRight", "ZoomOutAspectFit", "ZoomInAspectFit", "ZoomOutAspectFill", "ZoomInAspectFill", "Unknown", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(272498);
      TCA = new a("Default", 0);
      TCB = new a("RightToLeft", 1);
      TCC = new a("LeftToRight", 2);
      TCD = new a("ZoomOutAspectFit", 3);
      TCE = new a("ZoomInAspectFit", 4);
      TCF = new a("ZoomOutAspectFill", 5);
      TCG = new a("ZoomInAspectFill", 6);
      TCH = new a("Unknown", 7);
      TCI = new a[] { TCA, TCB, TCC, TCD, TCE, TCF, TCG, TCH };
      AppMethodBeat.o(272498);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.a
 * JD-Core Version:    0.7.0.1
 */