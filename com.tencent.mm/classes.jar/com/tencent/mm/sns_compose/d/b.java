package com.tencent.mm.sns_compose.d;

import android.content.Context;
import androidx.compose.runtime.h;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.j;
import coil.d.c;
import coil.d.d;
import coil.d.d.a;
import coil.d.f;
import coil.j.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"isInit", "", "()Z", "setInit", "(Z)V", "CoilImageLoader", "", "context", "Landroid/content/Context;", "NetworkImageLoader", "Lcoil/compose/ImagePainter;", "imgPath", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Lcoil/compose/ImagePainter;", "sns-compose_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static boolean isInit;
  
  public static final d b(String paramString, h paramh)
  {
    AppMethodBeat.i(235408);
    s.u(paramString, "imgPath");
    paramh.bx(1968779645);
    paramString = new h.a((Context)paramh.a((p)j.yJ())).aZ(paramString).a(coil.size.e.cpY).gS(100).gS(320).Na();
    paramh.bx(604400642);
    d.a locala = d.a.cmA;
    paramString = coil.d.e.a(paramString, c.a(f.MO(), paramh), locala, paramh);
    paramh.od();
    paramh.od();
    AppMethodBeat.o(235408);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.d.b
 * JD-Core Version:    0.7.0.1
 */