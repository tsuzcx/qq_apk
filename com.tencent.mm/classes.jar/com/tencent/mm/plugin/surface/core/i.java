package com.tencent.mm.plugin.surface.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.gka;
import com.tencent.mm.protocal.protobuf.gkb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/core/SurfacePublicLibChecker;", "", "()V", "TAG", "", "usePreDownLoad", "", "getUsePreDownLoad", "()Z", "usePreDownLoad$delegate", "Lkotlin/Lazy;", "check", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  private static final j SKA;
  public static final i SKz;
  
  static
  {
    AppMethodBeat.i(265241);
    SKz = new i();
    SKA = k.cm((kotlin.g.a.a)a.SKB);
    AppMethodBeat.o(265241);
  }
  
  public static boolean check()
  {
    AppMethodBeat.i(265214);
    if (hBN())
    {
      e.SKg.bcU("wx4edd479d258d7f25");
      Log.i("MicroMsg.SurfaceApp.SurfacePublicLibChecker", "download public lib use pre download.");
      AppMethodBeat.o(265214);
      return true;
    }
    if ((!h.baz()) || (b.aZG()))
    {
      Log.e("MicroMsg.SurfaceApp.SurfacePublicLibChecker", "check MMCore null, skip");
      AppMethodBeat.o(265214);
      return false;
    }
    Object localObject = h.baE().ban().get(at.a.acNd, Long.valueOf(0L));
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(265214);
      throw ((Throwable)localObject);
    }
    long l1 = ((Long)localObject).longValue();
    long l2 = Util.nowSecond();
    Log.i("MicroMsg.SurfaceApp.SurfacePublicLibChecker", "check, nextSec = %d, nowSec = %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if (l2 < l1)
    {
      AppMethodBeat.o(265214);
      return false;
    }
    localObject = new c.a();
    gka localgka = new gka();
    localgka.version = 0;
    ((c.a)localObject).otE = ((com.tencent.mm.bx.a)localgka);
    ((c.a)localObject).otF = ((com.tencent.mm.bx.a)new gkb());
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/getpubliclibinfo";
    ((c.a)localObject).funcId = 1168;
    z.a(((c.a)localObject).bEF(), i..ExternalSyntheticLambda0.INSTANCE, true);
    AppMethodBeat.o(265214);
    return true;
  }
  
  private static final int f(int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
  {
    AppMethodBeat.i(265225);
    if (h.baz())
    {
      long l = Util.nowSecond();
      h.baE().ban().set(at.a.acNd, Long.valueOf(86400L + l));
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.SurfaceApp.SurfacePublicLibChecker", "onResp, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(265225);
      return 0;
    }
    AppMethodBeat.o(265225);
    return 0;
  }
  
  public static boolean hBN()
  {
    AppMethodBeat.i(265194);
    boolean bool = ((Boolean)SKA.getValue()).booleanValue();
    AppMethodBeat.o(265194);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final a SKB;
    
    static
    {
      AppMethodBeat.i(265210);
      SKB = new a();
      AppMethodBeat.o(265210);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.core.i
 * JD-Core Version:    0.7.0.1
 */