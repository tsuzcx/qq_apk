package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.h;
import kotlin.l.b.a.b.f.c;
import kotlin.v;

public final class q
{
  private static final c aiOU;
  private static final c aiOV;
  private static final y<r> aiOW;
  private static final r aiOX;
  
  static
  {
    AppMethodBeat.i(192032);
    aiOU = new c("org.jspecify.nullness");
    aiOV = new c("org.checkerframework.checker.nullness.compatqual");
    Object localObject1 = new c("org.jetbrains.annotations");
    Object localObject2 = r.aiOY;
    localObject1 = v.Y(localObject1, r.krE());
    localObject2 = new c("androidx.annotation");
    Object localObject3 = r.aiOY;
    localObject2 = v.Y(localObject2, r.krE());
    localObject3 = new c("android.support.annotation");
    Object localObject4 = r.aiOY;
    localObject3 = v.Y(localObject3, r.krE());
    localObject4 = new c("android.annotation");
    Object localObject5 = r.aiOY;
    localObject4 = v.Y(localObject4, r.krE());
    localObject5 = new c("com.android.annotations");
    Object localObject6 = r.aiOY;
    localObject5 = v.Y(localObject5, r.krE());
    localObject6 = new c("org.eclipse.jdt.annotation");
    Object localObject7 = r.aiOY;
    localObject6 = v.Y(localObject6, r.krE());
    localObject7 = new c("org.checkerframework.checker.nullness.qual");
    Object localObject8 = r.aiOY;
    localObject7 = v.Y(localObject7, r.krE());
    localObject8 = aiOV;
    Object localObject9 = r.aiOY;
    localObject8 = v.Y(localObject8, r.krE());
    localObject9 = new c("javax.annotation");
    Object localObject10 = r.aiOY;
    localObject9 = v.Y(localObject9, r.krE());
    localObject10 = new c("edu.umd.cs.findbugs.annotations");
    Object localObject11 = r.aiOY;
    localObject10 = v.Y(localObject10, r.krE());
    localObject11 = new c("io.reactivex.annotations");
    Object localObject12 = r.aiOY;
    localObject11 = v.Y(localObject11, r.krE());
    localObject12 = v.Y(new c("androidx.annotation.RecentlyNullable"), new r(ab.aiQi, null, null, 4));
    kotlin.r localr = v.Y(new c("androidx.annotation.RecentlyNonNull"), new r(ab.aiQi, null, null, 4));
    c localc = new c("lombok");
    r.a locala = r.aiOY;
    aiOW = (y)new z(ak.e(new kotlin.r[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localr, v.Y(localc, r.krE()), v.Y(aiOU, new r(ab.aiQi, new h(6), ab.aiQj)), v.Y(new c("io.reactivex.rxjava3.annotations"), new r(ab.aiQi, new h(7), ab.aiQj)) }));
    aiOX = new r(ab.aiQi, null, null, 4);
    AppMethodBeat.o(192032);
  }
  
  public static final c krC()
  {
    return aiOU;
  }
  
  public static final ab o(c paramc)
  {
    AppMethodBeat.i(192025);
    s.u(paramc, "annotationFqName");
    Object localObject1 = y.aiPZ;
    Object localObject2 = y.a.krT();
    localObject1 = h.aiuC;
    s.u(paramc, "annotation");
    s.u(localObject2, "configuredReportLevels");
    s.u(localObject1, "configuredKotlinVersion");
    localObject2 = (ab)((y)localObject2).p(paramc);
    if (localObject2 != null)
    {
      AppMethodBeat.o(192025);
      return localObject2;
    }
    paramc = (r)aiOW.p(paramc);
    if (paramc == null)
    {
      paramc = ab.aiQh;
      AppMethodBeat.o(192025);
      return paramc;
    }
    if ((paramc.aiPa != null) && (paramc.aiPa.a((h)localObject1) <= 0))
    {
      paramc = paramc.aiPb;
      AppMethodBeat.o(192025);
      return paramc;
    }
    paramc = paramc.aiOZ;
    AppMethodBeat.o(192025);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.q
 * JD-Core Version:    0.7.0.1
 */