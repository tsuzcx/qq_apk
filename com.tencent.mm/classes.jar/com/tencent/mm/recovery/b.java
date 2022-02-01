package com.tencent.mm.recovery;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.net.b.a;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.toolkit.a.a.d;
import com.tencent.mm.toolkit.a.f;
import com.tencent.mm.toolkit.a.g;
import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  public static void a(final Context paramContext, dzp paramdzp, final androidx.core.f.a<Integer> parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(242754);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramdzp = new com.tencent.mm.recovery.a.a(paramdzp);
    com.tencent.mm.recoveryv2.e.i("MicroMsg.recovery.operator", "NetSceneBaseMMTLSCheckCopycat#doSceneSync()");
    paramdzp.a(new b.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.b.b paramAnonymousb)
      {
        AppMethodBeat.i(242766);
        com.tencent.mm.recoveryv2.e.i("MicroMsg.recovery.operator", "onCheckEnd, error = " + paramAnonymousInt + ", response = " + paramAnonymousb);
        if ((paramAnonymousInt != 0) && (paramAnonymousInt != -5))
        {
          com.tencent.mm.recoveryv2.e.w("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp error, abort");
          b.this.set(Math.abs(paramAnonymousInt) + 20);
          parama.accept(Integer.valueOf(b.this.get()));
          AppMethodBeat.o(242766);
          return;
        }
        com.tencent.mm.recoveryv2.e.i("MicroMsg.recovery.operator", "fetchTinkerPatch cgi rsp successful");
        if ((paramAnonymousInt == -5) || (paramAnonymousb == null) || (TextUtils.isEmpty(paramAnonymousb.mOI)))
        {
          b.this.set(1);
          parama.accept(Integer.valueOf(b.this.get()));
          AppMethodBeat.o(242766);
          return;
        }
        String str = paramAnonymousb.mOI;
        long l = Math.max(paramAnonymousb.fileSize, 0);
        paramAnonymousb = paramAnonymousb.vyS;
        b.a(paramContext, str, l, paramAnonymousb, parama, paramBoolean);
        AppMethodBeat.o(242766);
      }
    });
    AppMethodBeat.o(242754);
  }
  
  public static void a(final Context paramContext, String paramString1, long paramLong, String paramString2, final androidx.core.f.a<Integer> parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(242758);
    com.tencent.mm.recoveryv2.e.i("MicroMsg.recovery.operator", "#downloadTinkerPatch, file size = " + paramLong + ", url = " + paramString1);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    paramString1 = new com.tencent.mm.toolkit.a.c(paramString1).Q(new File(paramContext.getCacheDir(), "recovery/tinker_path_file_" + System.currentTimeMillis()));
    paramString1.adsX = new com.tencent.mm.toolkit.a.a.b()
    {
      public final void a(com.tencent.mm.toolkit.a.c paramAnonymousc)
      {
        AppMethodBeat.i(242763);
        paramAnonymousc = paramAnonymousc.adsM;
        com.tencent.mm.recoveryv2.e.i("MicroMsg.recovery.operator", "#onComplete, file = ".concat(String.valueOf(paramAnonymousc)));
        com.tencent.mm.recoveryv2.e.i("MicroMsg.recovery.operator", "download tinker path success");
        if (paramAnonymousc.exists())
        {
          b.this.set(0);
          if (paramBoolean) {
            com.tencent.tinker.lib.e.c.ds(paramContext, paramAnonymousc.getAbsolutePath());
          }
          parama.accept(Integer.valueOf(b.this.get()));
          AppMethodBeat.o(242763);
          return;
        }
        b.this.set(2);
        parama.accept(Integer.valueOf(b.this.get()));
        AppMethodBeat.o(242763);
      }
      
      public final void dX(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(242764);
        com.tencent.mm.recoveryv2.e.w("MicroMsg.recovery.operator", "#onFailed, code = " + paramAnonymousInt + ", msg = " + paramAnonymousString);
        int j = 2;
        int i;
        if (paramAnonymousInt == 1001) {
          i = 3;
        }
        for (;;)
        {
          b.this.set(i);
          parama.accept(Integer.valueOf(b.this.get()));
          AppMethodBeat.o(242764);
          return;
          i = j;
          if (paramAnonymousInt >= 1101)
          {
            i = j;
            if (paramAnonymousInt <= 1106) {
              i = paramAnonymousInt - 1101 + 4;
            }
          }
        }
      }
      
      public final boolean isCanceled()
      {
        return false;
      }
    };
    if (paramLong > 0L) {
      paramString1.mContentLength = paramLong;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.adsV = new f(paramString2);
    }
    com.tencent.mm.recoveryv2.e.i("MicroMsg.recovery.operator", "#downloadTinkerPatch start sync downloading");
    new g().mI(paramContext).e(paramString1);
    AppMethodBeat.o(242758);
  }
  
  public static void a(Context paramContext, String paramString, androidx.core.f.a<Integer> parama)
  {
    AppMethodBeat.i(242756);
    a(paramContext, paramString, 0L, null, parama, true);
    AppMethodBeat.o(242756);
  }
  
  public static void b(Context paramContext, final androidx.core.f.a<Integer> parama)
  {
    AppMethodBeat.i(242752);
    com.tencent.mm.recoveryv2.e.i("MicroMsg.recovery.operator", "#fetchTinkerPatch");
    if (!com.tencent.mm.plugin.expansions.e.aQh())
    {
      com.tencent.mm.recoveryv2.e.w("MicroMsg.recovery.operator", "expansions mmtls is not ready");
      parama.accept(Integer.valueOf(1));
      AppMethodBeat.o(242752);
      return;
    }
    com.tencent.mm.plugin.expansions.e.tryLoadLibrary("wechathttp");
    parama = new androidx.core.f.a() {};
    String str = com.tencent.mm.loader.i.a.bmm();
    Log.i("MicroMsg.recovery.operator", "baseTinkerId = ".concat(String.valueOf(str)));
    dzp localdzp = new dzp();
    localdzp.abeK = str;
    localdzp.ycW = com.tencent.mm.loader.i.a.bmn();
    localdzp.abeL = com.tencent.mm.recovery.a.b.fPU();
    localdzp.abeL.add(com.tencent.mm.recovery.a.b.jE("biz-scene", "recovery"));
    localdzp.abeN = 1;
    a(paramContext, localdzp, parama, true);
    AppMethodBeat.o(242752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recovery.b
 * JD-Core Version:    0.7.0.1
 */