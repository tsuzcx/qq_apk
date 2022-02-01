package com.tencent.mm.ui.chatting.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.choosemsgfile.compat.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class a
  implements com.tencent.mm.choosemsgfile.compat.b
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
    i local2 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(35052);
        Log.i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect errType:%d errCode:%d, errMsg:%s type:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousq.getType()) });
        if (paramAnonymousq.getType() != 221)
        {
          AppMethodBeat.o(35052);
          return;
        }
        paramAnonymousq = (f)paramAnonymousq;
        if (!paramString.equals(paramAnonymousq.getMediaId()))
        {
          Log.w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", new Object[] { paramString, paramAnonymousq.getMediaId() });
          AppMethodBeat.o(35052);
          return;
        }
        bg.azz().b(221, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousInt1 = paramAnonymousq.retCode;
          Log.i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect retCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          if ((paramAnonymousInt1 < 0) && (parama != null)) {
            parama.t(paramAnonymousInt1, "");
          }
          AppMethodBeat.o(35052);
          return;
        }
        paramAnonymousq = m.s(paramString, paramLong);
        if ((paramAnonymousq != null) && (paramAnonymousq.field_status == 102L))
        {
          if (parama != null) {
            parama.t(1, paramAnonymousString);
          }
          AppMethodBeat.o(35052);
          return;
        }
        if (parama != null) {
          parama.t(-1, paramAnonymousString);
        }
        AppMethodBeat.o(35052);
      }
    };
    bg.azz().a(221, local2);
    paramString = new f(paramLong, paramString, new j()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, q paramAnonymousq)
      {
        AppMethodBeat.i(35053);
        if (parama != null) {
          parama.cs(paramAnonymousInt1, paramAnonymousInt2);
        }
        if ((paramAnonymousInt1 >= paramAnonymousInt2) && (parama != null)) {
          parama.t(0, "");
        }
        AppMethodBeat.o(35053);
      }
    });
    bg.azz().a(paramString, 0);
    paramString = new com.tencent.mm.vending.e.a()
    {
      public final void dead()
      {
        AppMethodBeat.i(35054);
        paramString.a(null);
        com.tencent.mm.kernel.g.azz().a(paramString);
        AppMethodBeat.o(35054);
      }
    };
    AppMethodBeat.o(35060);
    return paramString;
  }
  
  public final String a(ca paramca, com.tencent.mm.av.g paramg)
  {
    AppMethodBeat.i(35063);
    paramca = com.tencent.mm.ui.chatting.gallery.d.a(paramca, paramg);
    AppMethodBeat.o(35063);
    return paramca;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(35059);
    if (paramc != null)
    {
      paramc.field_status = 101L;
      paramc.field_lastModifyTime = Util.nowSecond();
      ao.cgO().a(paramc, new String[0]);
    }
    AppMethodBeat.o(35059);
  }
  
  public final void a(ca paramca, final b.a parama)
  {
    AppMethodBeat.i(35065);
    m.a(paramca, new m.a()
    {
      public final void kA(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(35055);
        if (parama != null) {
          parama.cs(paramAnonymousInt1, paramAnonymousInt2);
        }
        if ((paramAnonymousInt1 >= paramAnonymousInt2) && (parama != null)) {
          parama.t(0, "");
        }
        AppMethodBeat.o(35055);
      }
    });
    AppMethodBeat.o(35065);
  }
  
  public final boolean a(ca paramca, c paramc)
  {
    AppMethodBeat.i(35056);
    boolean bool = m.a(paramca, paramc);
    AppMethodBeat.o(35056);
    return bool;
  }
  
  public final boolean a(final String paramString, ca paramca, final b.b paramb)
  {
    AppMethodBeat.i(35058);
    if ((Util.isNullOrNil(paramString)) || (paramca == null))
    {
      Log.e("MicroMsg.ChooseMsgFileCompat", "mediaId:%s or msg is null, err", new Object[] { paramString });
      AppMethodBeat.o(35058);
      return false;
    }
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(35051);
        Log.i("MicroMsg.ChooseMsgFileCompat", "tryInitAttachInfo errType:%d errCode:%d, errMsg:%s type:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousq.getType()) });
        if (paramAnonymousq.getType() != 728)
        {
          AppMethodBeat.o(35051);
          return;
        }
        paramAnonymousq = (com.tencent.mm.plugin.record.b.d)paramAnonymousq;
        if (!paramString.equals(paramAnonymousq.getMediaId()))
        {
          Log.w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", new Object[] { paramString, paramAnonymousq.getMediaId() });
          AppMethodBeat.o(35051);
          return;
        }
        bg.azz().b(728, this);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          if (paramb != null)
          {
            paramb.u(0, "");
            AppMethodBeat.o(35051);
          }
        }
        else if (paramb != null) {
          paramb.u(paramAnonymousInt2, paramAnonymousString);
        }
        AppMethodBeat.o(35051);
      }
    };
    bg.azz().a(728, local1);
    if (!m.e(paramString, paramca)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramb.u(0, "");
        bg.azz().b(728, local1);
      }
      AppMethodBeat.o(35058);
      return true;
    }
  }
  
  public final boolean j(ca paramca)
  {
    AppMethodBeat.i(35061);
    boolean bool = com.tencent.mm.ui.chatting.gallery.b.j(paramca);
    AppMethodBeat.o(35061);
    return bool;
  }
  
  public final com.tencent.mm.av.g k(ca paramca)
  {
    AppMethodBeat.i(35062);
    paramca = com.tencent.mm.ui.chatting.gallery.d.k(paramca);
    AppMethodBeat.o(35062);
    return paramca;
  }
  
  public final String l(ca paramca)
  {
    AppMethodBeat.i(35064);
    paramca = com.tencent.mm.ui.chatting.gallery.b.l(paramca);
    AppMethodBeat.o(35064);
    return paramca;
  }
  
  public final boolean m(ca paramca)
  {
    AppMethodBeat.i(35066);
    boolean bool = com.tencent.mm.ui.chatting.gallery.b.m(paramca);
    AppMethodBeat.o(35066);
    return bool;
  }
  
  public final c s(String paramString, long paramLong)
  {
    AppMethodBeat.i(35057);
    paramString = m.s(paramString, paramLong);
    AppMethodBeat.o(35057);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.a
 * JD-Core Version:    0.7.0.1
 */