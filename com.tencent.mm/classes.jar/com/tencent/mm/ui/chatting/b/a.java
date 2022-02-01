package com.tencent.mm.ui.chatting.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.i;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.choosemsgfile.compat.b;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.choosemsgfile.compat.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.record.model.e;
import com.tencent.mm.plugin.record.model.g;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.gallery.j;

public final class a
  implements b
{
  public final com.tencent.mm.vending.e.a a(final long paramLong, final String paramString, final b.a parama)
  {
    AppMethodBeat.i(35060);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect() mediaId is null, return");
      AppMethodBeat.o(35060);
      return null;
    }
    com.tencent.mm.am.h local2 = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(35052);
        Log.i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect errType:%d errCode:%d, errMsg:%s type:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousp.getType()) });
        if (paramAnonymousp.getType() != 221)
        {
          AppMethodBeat.o(35052);
          return;
        }
        paramAnonymousp = (g)paramAnonymousp;
        if (!paramString.equals(paramAnonymousp.getMediaId()))
        {
          Log.w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", new Object[] { paramString, paramAnonymousp.getMediaId() });
          AppMethodBeat.o(35052);
          return;
        }
        bh.aZW().b(221, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousInt1 = paramAnonymousp.retCode;
          Log.i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect retCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          if ((paramAnonymousInt1 < 0) && (parama != null)) {
            parama.u(paramAnonymousInt1, "");
          }
          AppMethodBeat.o(35052);
          return;
        }
        paramAnonymousp = n.q(paramString, paramLong);
        if ((paramAnonymousp != null) && (paramAnonymousp.field_status == 102L))
        {
          if (parama != null) {
            parama.u(1, paramAnonymousString);
          }
          AppMethodBeat.o(35052);
          return;
        }
        if (parama != null) {
          parama.u(-1, paramAnonymousString);
        }
        AppMethodBeat.o(35052);
      }
    };
    bh.aZW().a(221, local2);
    paramString = new g(paramLong, paramString, new i()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, p paramAnonymousp)
      {
        AppMethodBeat.i(35053);
        if (parama != null) {
          parama.dA(paramAnonymousInt1, paramAnonymousInt2);
        }
        if ((paramAnonymousInt1 >= paramAnonymousInt2) && (parama != null)) {
          parama.u(0, "");
        }
        AppMethodBeat.o(35053);
      }
    });
    bh.aZW().a(paramString, 0);
    paramString = new com.tencent.mm.vending.e.a()
    {
      public final void dead()
      {
        AppMethodBeat.i(35054);
        paramString.a(null);
        com.tencent.mm.kernel.h.aZW().a(paramString);
        AppMethodBeat.o(35054);
      }
    };
    AppMethodBeat.o(35060);
    return paramString;
  }
  
  public final String a(cc paramcc, com.tencent.mm.modelimage.h paramh)
  {
    AppMethodBeat.i(35063);
    paramcc = j.a(paramcc, paramh);
    AppMethodBeat.o(35063);
    return paramcc;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(35059);
    if (paramc != null)
    {
      paramc.field_status = 101L;
      paramc.field_lastModifyTime = Util.nowSecond();
      as.cWJ().a(paramc, new String[0]);
    }
    AppMethodBeat.o(35059);
  }
  
  public final void a(cc paramcc, final b.a parama)
  {
    AppMethodBeat.i(35065);
    n.a(paramcc, new n.a()
    {
      public final void nH(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(35055);
        if (parama != null) {
          parama.dA(paramAnonymousInt1, paramAnonymousInt2);
        }
        if ((paramAnonymousInt1 >= paramAnonymousInt2) && (parama != null)) {
          parama.u(0, "");
        }
        AppMethodBeat.o(35055);
      }
    });
    AppMethodBeat.o(35065);
  }
  
  public final boolean a(cc paramcc, c paramc)
  {
    AppMethodBeat.i(35056);
    boolean bool = n.a(paramcc, paramc);
    AppMethodBeat.o(35056);
    return bool;
  }
  
  public final boolean a(final String paramString, cc paramcc, final b.b paramb)
  {
    AppMethodBeat.i(35058);
    if ((Util.isNullOrNil(paramString)) || (paramcc == null))
    {
      Log.e("MicroMsg.ChooseMsgFileCompat", "mediaId:%s or msg is null, err", new Object[] { paramString });
      AppMethodBeat.o(35058);
      return false;
    }
    com.tencent.mm.am.h local1 = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(35051);
        Log.i("MicroMsg.ChooseMsgFileCompat", "tryInitAttachInfo errType:%d errCode:%d, errMsg:%s type:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousp.getType()) });
        if (paramAnonymousp.getType() != 728)
        {
          AppMethodBeat.o(35051);
          return;
        }
        paramAnonymousp = (e)paramAnonymousp;
        if (!paramString.equals(paramAnonymousp.getMediaId()))
        {
          Log.w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", new Object[] { paramString, paramAnonymousp.getMediaId() });
          AppMethodBeat.o(35051);
          return;
        }
        bh.aZW().b(728, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (paramb != null)
          {
            paramb.v(0, "");
            AppMethodBeat.o(35051);
          }
        }
        else if (paramb != null) {
          paramb.v(paramAnonymousInt2, paramAnonymousString);
        }
        AppMethodBeat.o(35051);
      }
    };
    bh.aZW().a(728, local1);
    if (!n.e(paramString, paramcc)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramb.v(0, "");
        bh.aZW().b(728, local1);
      }
      AppMethodBeat.o(35058);
      return true;
    }
  }
  
  public final boolean j(cc paramcc)
  {
    AppMethodBeat.i(35061);
    boolean bool = com.tencent.mm.ui.chatting.gallery.h.j(paramcc);
    AppMethodBeat.o(35061);
    return bool;
  }
  
  public final com.tencent.mm.modelimage.h k(cc paramcc)
  {
    AppMethodBeat.i(35062);
    paramcc = j.k(paramcc);
    AppMethodBeat.o(35062);
    return paramcc;
  }
  
  public final String l(cc paramcc)
  {
    AppMethodBeat.i(35064);
    paramcc = com.tencent.mm.ui.chatting.gallery.h.l(paramcc);
    AppMethodBeat.o(35064);
    return paramcc;
  }
  
  public final boolean m(cc paramcc)
  {
    AppMethodBeat.i(35066);
    boolean bool = com.tencent.mm.ui.chatting.gallery.h.m(paramcc);
    AppMethodBeat.o(35066);
    return bool;
  }
  
  public final c q(String paramString, long paramLong)
  {
    AppMethodBeat.i(35057);
    paramString = n.q(paramString, paramLong);
    AppMethodBeat.o(35057);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.a
 * JD-Core Version:    0.7.0.1
 */