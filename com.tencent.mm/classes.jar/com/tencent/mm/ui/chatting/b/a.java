package com.tencent.mm.ui.chatting.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.choosemsgfile.compat.b.b;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.m.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;

public final class a
  implements com.tencent.mm.choosemsgfile.compat.b
{
  public final com.tencent.mm.vending.e.a a(final long paramLong, final String paramString, final b.a parama)
  {
    AppMethodBeat.i(35060);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect() mediaId is null, return");
      AppMethodBeat.o(35060);
      return null;
    }
    com.tencent.mm.ak.g local2 = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(35052);
        ac.i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect errType:%d errCode:%d, errMsg:%s type:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousn.getType()) });
        if (paramAnonymousn.getType() != 221)
        {
          AppMethodBeat.o(35052);
          return;
        }
        paramAnonymousn = (com.tencent.mm.plugin.record.b.e)paramAnonymousn;
        if (!paramString.equals(paramAnonymousn.getMediaId()))
        {
          ac.w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", new Object[] { paramString, paramAnonymousn.getMediaId() });
          AppMethodBeat.o(35052);
          return;
        }
        az.agi().b(221, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousInt1 = paramAnonymousn.retCode;
          ac.i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect retCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          if ((paramAnonymousInt1 < 0) && (parama != null)) {
            parama.r(paramAnonymousInt1, "");
          }
          AppMethodBeat.o(35052);
          return;
        }
        paramAnonymousn = m.q(paramString, paramLong);
        if ((paramAnonymousn != null) && (paramAnonymousn.field_status == 102L))
        {
          if (parama != null) {
            parama.r(1, paramAnonymousString);
          }
          AppMethodBeat.o(35052);
          return;
        }
        if (parama != null) {
          parama.r(-1, paramAnonymousString);
        }
        AppMethodBeat.o(35052);
      }
    };
    az.agi().a(221, local2);
    paramString = new com.tencent.mm.plugin.record.b.e(paramLong, paramString, new h()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
      {
        AppMethodBeat.i(35053);
        if (parama != null) {
          parama.co(paramAnonymousInt1, paramAnonymousInt2);
        }
        if ((paramAnonymousInt1 >= paramAnonymousInt2) && (parama != null)) {
          parama.r(0, "");
        }
        AppMethodBeat.o(35053);
      }
    });
    az.agi().a(paramString, 0);
    paramString = new com.tencent.mm.vending.e.a()
    {
      public final void dead()
      {
        AppMethodBeat.i(35054);
        paramString.a(null);
        com.tencent.mm.kernel.g.agi().a(paramString);
        AppMethodBeat.o(35054);
      }
    };
    AppMethodBeat.o(35060);
    return paramString;
  }
  
  public final String a(bo parambo, com.tencent.mm.av.e parame)
  {
    AppMethodBeat.i(35063);
    parambo = com.tencent.mm.ui.chatting.gallery.d.a(parambo, parame);
    AppMethodBeat.o(35063);
    return parambo;
  }
  
  public final void a(com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(35059);
    if (paramc != null)
    {
      paramc.field_status = 101L;
      paramc.field_lastModifyTime = bs.aNx();
      ap.bEO().a(paramc, new String[0]);
    }
    AppMethodBeat.o(35059);
  }
  
  public final void a(bo parambo, final b.a parama)
  {
    AppMethodBeat.i(35065);
    m.a(parambo, new m.a()
    {
      public final void iY(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(35055);
        if (parama != null) {
          parama.co(paramAnonymousInt1, paramAnonymousInt2);
        }
        if ((paramAnonymousInt1 >= paramAnonymousInt2) && (parama != null)) {
          parama.r(0, "");
        }
        AppMethodBeat.o(35055);
      }
    });
    AppMethodBeat.o(35065);
  }
  
  public final boolean a(bo parambo, com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(35056);
    boolean bool = m.a(parambo, paramc);
    AppMethodBeat.o(35056);
    return bool;
  }
  
  public final boolean a(final String paramString, bo parambo, final b.b paramb)
  {
    AppMethodBeat.i(35058);
    if ((bs.isNullOrNil(paramString)) || (parambo == null))
    {
      ac.e("MicroMsg.ChooseMsgFileCompat", "mediaId:%s or msg is null, err", new Object[] { paramString });
      AppMethodBeat.o(35058);
      return false;
    }
    com.tencent.mm.ak.g local1 = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(35051);
        ac.i("MicroMsg.ChooseMsgFileCompat", "tryInitAttachInfo errType:%d errCode:%d, errMsg:%s type:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousn.getType()) });
        if (paramAnonymousn.getType() != 728)
        {
          AppMethodBeat.o(35051);
          return;
        }
        paramAnonymousn = (com.tencent.mm.plugin.record.b.c)paramAnonymousn;
        if (!paramString.equals(paramAnonymousn.getMediaId()))
        {
          ac.w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", new Object[] { paramString, paramAnonymousn.getMediaId() });
          AppMethodBeat.o(35051);
          return;
        }
        az.agi().b(728, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (paramb != null)
          {
            paramb.s(0, "");
            AppMethodBeat.o(35051);
          }
        }
        else if (paramb != null) {
          paramb.s(paramAnonymousInt2, paramAnonymousString);
        }
        AppMethodBeat.o(35051);
      }
    };
    az.agi().a(728, local1);
    if (!m.e(paramString, parambo)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramb.s(0, "");
        az.agi().b(728, local1);
      }
      AppMethodBeat.o(35058);
      return true;
    }
  }
  
  public final boolean j(bo parambo)
  {
    AppMethodBeat.i(35061);
    boolean bool = com.tencent.mm.ui.chatting.gallery.b.j(parambo);
    AppMethodBeat.o(35061);
    return bool;
  }
  
  public final com.tencent.mm.av.e k(bo parambo)
  {
    AppMethodBeat.i(35062);
    parambo = com.tencent.mm.ui.chatting.gallery.d.k(parambo);
    AppMethodBeat.o(35062);
    return parambo;
  }
  
  public final String l(bo parambo)
  {
    AppMethodBeat.i(35064);
    parambo = com.tencent.mm.ui.chatting.gallery.b.l(parambo);
    AppMethodBeat.o(35064);
    return parambo;
  }
  
  public final boolean m(bo parambo)
  {
    AppMethodBeat.i(35066);
    boolean bool = com.tencent.mm.ui.chatting.gallery.b.m(parambo);
    AppMethodBeat.o(35066);
    return bool;
  }
  
  public final com.tencent.mm.pluginsdk.model.app.c q(String paramString, long paramLong)
  {
    AppMethodBeat.i(35057);
    paramString = m.q(paramString, paramLong);
    AppMethodBeat.o(35057);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.a
 * JD-Core Version:    0.7.0.1
 */