package com.tencent.mm.ui.chatting.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.choosemsgfile.compat.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.m.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;

public final class a
  implements com.tencent.mm.choosemsgfile.compat.b
{
  public final com.tencent.mm.vending.e.a a(final long paramLong, final String paramString, final b.a parama)
  {
    AppMethodBeat.i(35060);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect() mediaId is null, return");
      AppMethodBeat.o(35060);
      return null;
    }
    com.tencent.mm.al.f local2 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(35052);
        ad.i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect errType:%d errCode:%d, errMsg:%s type:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousn.getType()) });
        if (paramAnonymousn.getType() != 221)
        {
          AppMethodBeat.o(35052);
          return;
        }
        paramAnonymousn = (com.tencent.mm.plugin.record.b.f)paramAnonymousn;
        if (!paramString.equals(paramAnonymousn.getMediaId()))
        {
          ad.w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", new Object[] { paramString, paramAnonymousn.getMediaId() });
          AppMethodBeat.o(35052);
          return;
        }
        ba.aiU().b(221, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousInt1 = paramAnonymousn.retCode;
          ad.i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect retCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          if ((paramAnonymousInt1 < 0) && (parama != null)) {
            parama.r(paramAnonymousInt1, "");
          }
          AppMethodBeat.o(35052);
          return;
        }
        paramAnonymousn = m.r(paramString, paramLong);
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
    ba.aiU().a(221, local2);
    paramString = new com.tencent.mm.plugin.record.b.f(paramLong, paramString, new com.tencent.mm.al.g()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn)
      {
        AppMethodBeat.i(35053);
        if (parama != null) {
          parama.cq(paramAnonymousInt1, paramAnonymousInt2);
        }
        if ((paramAnonymousInt1 >= paramAnonymousInt2) && (parama != null)) {
          parama.r(0, "");
        }
        AppMethodBeat.o(35053);
      }
    });
    ba.aiU().a(paramString, 0);
    paramString = new com.tencent.mm.vending.e.a()
    {
      public final void dead()
      {
        AppMethodBeat.i(35054);
        paramString.a(null);
        com.tencent.mm.kernel.g.aiU().a(paramString);
        AppMethodBeat.o(35054);
      }
    };
    AppMethodBeat.o(35060);
    return paramString;
  }
  
  public final String a(bu parambu, com.tencent.mm.aw.g paramg)
  {
    AppMethodBeat.i(35063);
    parambu = com.tencent.mm.ui.chatting.gallery.d.a(parambu, paramg);
    AppMethodBeat.o(35063);
    return parambu;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(35059);
    if (paramc != null)
    {
      paramc.field_status = 101L;
      paramc.field_lastModifyTime = bt.aQJ();
      ao.bIX().a(paramc, new String[0]);
    }
    AppMethodBeat.o(35059);
  }
  
  public final void a(bu parambu, final b.a parama)
  {
    AppMethodBeat.i(35065);
    m.a(parambu, new m.a()
    {
      public final void jk(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(35055);
        if (parama != null) {
          parama.cq(paramAnonymousInt1, paramAnonymousInt2);
        }
        if ((paramAnonymousInt1 >= paramAnonymousInt2) && (parama != null)) {
          parama.r(0, "");
        }
        AppMethodBeat.o(35055);
      }
    });
    AppMethodBeat.o(35065);
  }
  
  public final boolean a(bu parambu, c paramc)
  {
    AppMethodBeat.i(35056);
    boolean bool = m.a(parambu, paramc);
    AppMethodBeat.o(35056);
    return bool;
  }
  
  public final boolean a(final String paramString, bu parambu, final b.b paramb)
  {
    AppMethodBeat.i(35058);
    if ((bt.isNullOrNil(paramString)) || (parambu == null))
    {
      ad.e("MicroMsg.ChooseMsgFileCompat", "mediaId:%s or msg is null, err", new Object[] { paramString });
      AppMethodBeat.o(35058);
      return false;
    }
    com.tencent.mm.al.f local1 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(35051);
        ad.i("MicroMsg.ChooseMsgFileCompat", "tryInitAttachInfo errType:%d errCode:%d, errMsg:%s type:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousn.getType()) });
        if (paramAnonymousn.getType() != 728)
        {
          AppMethodBeat.o(35051);
          return;
        }
        paramAnonymousn = (com.tencent.mm.plugin.record.b.d)paramAnonymousn;
        if (!paramString.equals(paramAnonymousn.getMediaId()))
        {
          ad.w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", new Object[] { paramString, paramAnonymousn.getMediaId() });
          AppMethodBeat.o(35051);
          return;
        }
        ba.aiU().b(728, this);
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
    ba.aiU().a(728, local1);
    if (!m.e(paramString, parambu)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramb.s(0, "");
        ba.aiU().b(728, local1);
      }
      AppMethodBeat.o(35058);
      return true;
    }
  }
  
  public final boolean j(bu parambu)
  {
    AppMethodBeat.i(35061);
    boolean bool = com.tencent.mm.ui.chatting.gallery.b.j(parambu);
    AppMethodBeat.o(35061);
    return bool;
  }
  
  public final com.tencent.mm.aw.g k(bu parambu)
  {
    AppMethodBeat.i(35062);
    parambu = com.tencent.mm.ui.chatting.gallery.d.k(parambu);
    AppMethodBeat.o(35062);
    return parambu;
  }
  
  public final String l(bu parambu)
  {
    AppMethodBeat.i(35064);
    parambu = com.tencent.mm.ui.chatting.gallery.b.l(parambu);
    AppMethodBeat.o(35064);
    return parambu;
  }
  
  public final boolean m(bu parambu)
  {
    AppMethodBeat.i(35066);
    boolean bool = com.tencent.mm.ui.chatting.gallery.b.m(parambu);
    AppMethodBeat.o(35066);
    return bool;
  }
  
  public final c r(String paramString, long paramLong)
  {
    AppMethodBeat.i(35057);
    paramString = m.r(paramString, paramLong);
    AppMethodBeat.o(35057);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.a
 * JD-Core Version:    0.7.0.1
 */