package com.tencent.mm.plugin.thumbplayer.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.effect.g.c;
import com.tencent.mm.xeffect.LayoutInfo;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.j.c;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/effect/ImageAnimation;", "", "()V", "applyAnimation", "", "animation", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;", "targetWidth", "", "targetHeight", "width", "height", "animationType", "Lcom/tencent/mm/plugin/thumbplayer/effect/ImageAnimation$AnimateType;", "applyImageContentAnimate", "bitmap", "Landroid/graphics/Bitmap;", "effectController", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController;", "type", "getAnimationType", "toAnimateType", "AnimateType", "plugin-thumbplayer_release"})
public final class a
{
  public static final a MPX;
  
  static
  {
    AppMethodBeat.i(189749);
    MPX = new a();
    AppMethodBeat.o(189749);
  }
  
  public static void a(g.c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a parama)
  {
    AppMethodBeat.i(189736);
    p.k(paramc, "animation");
    p.k(parama, "animationType");
    LayoutInfo localLayoutInfo = paramc.YJd;
    paramc = paramc.YJe;
    localLayoutInfo.centerX = (paramInt1 / 2);
    localLayoutInfo.centerY = (paramInt2 / 2);
    localLayoutInfo.YZo = 1;
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
      AppMethodBeat.o(189736);
      return;
      localLayoutInfo.YZo = 0;
      localLayoutInfo.scale = f;
      localLayoutInfo.centerX = (paramInt3 / 2 + paramInt1 / 2);
      paramc.scale = f;
      paramc.centerX = (paramInt3 / 2 - paramInt1 / 2);
      AppMethodBeat.o(189736);
      return;
      localLayoutInfo.YZo = 0;
      localLayoutInfo.scale = f;
      localLayoutInfo.centerX = (paramInt3 / 2 - paramInt1 / 2);
      paramc.scale = f;
      paramc.centerX = (paramInt3 / 2 + paramInt1 / 2);
      AppMethodBeat.o(189736);
      return;
      localLayoutInfo.YZo = 4;
      localLayoutInfo.scale = 1.05F;
      paramc.scale = 1.0F;
      AppMethodBeat.o(189736);
      return;
      localLayoutInfo.YZo = 4;
      localLayoutInfo.scale = 1.0F;
      paramc.scale = 1.05F;
      AppMethodBeat.o(189736);
      return;
      localLayoutInfo.YZo = 3;
      localLayoutInfo.scale = 1.05F;
      paramc.scale = 1.0F;
      AppMethodBeat.o(189736);
      return;
      localLayoutInfo.YZo = 3;
      localLayoutInfo.scale = 1.0F;
      paramc.scale = 1.05F;
    }
  }
  
  public static a ajp(int paramInt)
  {
    AppMethodBeat.i(189723);
    if (paramInt < a.values().length - 1)
    {
      locala = a.values()[paramInt];
      AppMethodBeat.o(189723);
      return locala;
    }
    a locala = a.MQf;
    AppMethodBeat.o(189723);
    return locala;
  }
  
  public static int kt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189743);
    float f = paramInt1 * 1.0F / paramInt2;
    Object localObject;
    if (f < 0.75F) {
      localObject = j.listOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(6) });
    }
    c localc;
    for (;;)
    {
      localObject = (Collection)localObject;
      localc = (c)c.aaBL;
      p.k(localObject, "$this$random");
      p.k(localc, "random");
      if (!((Collection)localObject).isEmpty()) {
        break;
      }
      localObject = (Throwable)new NoSuchElementException("Collection is empty.");
      AppMethodBeat.o(189743);
      throw ((Throwable)localObject);
      if (f <= 1.333333F) {
        localObject = j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6) });
      } else {
        localObject = j.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(4) });
      }
    }
    paramInt1 = ((Number)j.b((Iterable)localObject, localc.Nz(((Collection)localObject).size()))).intValue();
    AppMethodBeat.o(189743);
    return paramInt1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/effect/ImageAnimation$AnimateType;", "", "(Ljava/lang/String;I)V", "Default", "RightToLeft", "LeftToRight", "ZoomOutAspectFit", "ZoomInAspectFit", "ZoomOutAspectFill", "ZoomInAspectFill", "Unknown", "plugin-thumbplayer_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(189754);
      a locala1 = new a("Default", 0);
      MPY = locala1;
      a locala2 = new a("RightToLeft", 1);
      MPZ = locala2;
      a locala3 = new a("LeftToRight", 2);
      MQa = locala3;
      a locala4 = new a("ZoomOutAspectFit", 3);
      MQb = locala4;
      a locala5 = new a("ZoomInAspectFit", 4);
      MQc = locala5;
      a locala6 = new a("ZoomOutAspectFill", 5);
      MQd = locala6;
      a locala7 = new a("ZoomInAspectFill", 6);
      MQe = locala7;
      a locala8 = new a("Unknown", 7);
      MQf = locala8;
      MQg = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8 };
      AppMethodBeat.o(189754);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.a
 * JD-Core Version:    0.7.0.1
 */