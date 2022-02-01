package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.mv.ui.shake.d;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.protocal.protobuf.dso;
import com.tencent.mm.protocal.protobuf.dsp;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private static String TAG = "INetSceneGetFinderRecommended";
  public boo Gbe;
  public List<com.tencent.mm.plugin.mv.ui.a.b> LYF;
  public a LYG;
  public com.tencent.mm.am.h LYH;
  private int hzl;
  
  public b(boo paramboo, int paramInt)
  {
    AppMethodBeat.i(286261);
    this.LYF = new ArrayList();
    this.LYH = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(286259);
        if (((paramAnonymousp instanceof a)) && (((a)paramAnonymousp).LYA != 0) && (((a)paramAnonymousp).LYA != b.a(b.this)))
        {
          AppMethodBeat.o(286259);
          return;
        }
        if ((paramAnonymousp instanceof n))
        {
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((n)paramAnonymousp).LXH != null))
          {
            b.a(b.this, ((n)paramAnonymousp).LXH, b.a(b.this));
            AppMethodBeat.o(286259);
          }
        }
        else if ((paramAnonymousp instanceof k))
        {
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((k)paramAnonymousp).LWS != null))
          {
            b.a(b.this, ((k)paramAnonymousp).LWS, ((k)paramAnonymousp).LZe);
            AppMethodBeat.o(286259);
          }
        }
        else if (((paramAnonymousp instanceof d)) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = ((d)paramAnonymousp).oDw;
          if (paramAnonymousString == null) {
            break label254;
          }
          paramAnonymousString = c.c.b(paramAnonymousString.otC);
          if (paramAnonymousString == null) {
            break label254;
          }
        }
        label254:
        for (paramAnonymousString = ((dso)paramAnonymousString).ToF;; paramAnonymousString = null)
        {
          if ((paramAnonymousString != null) && (paramAnonymousString.get(0) != null))
          {
            paramAnonymousString = (dsp)paramAnonymousString.get(0);
            if (paramAnonymousString != null) {
              com.tencent.mm.plugin.mv.ui.shake.MusicMainUINew.LIC = paramAnonymousString.aaYi;
            }
          }
          AppMethodBeat.o(286259);
          return;
        }
      }
    };
    this.Gbe = paramboo;
    this.hzl = paramInt;
    AppMethodBeat.o(286261);
  }
  
  public static void kC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(286267);
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(286267);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    dsn localdsn = new dsn();
    localdsn.appid = paramString1;
    localdsn.oOZ = paramString2;
    localLinkedList.add(localdsn);
    paramString1 = new d(localLinkedList);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    AppMethodBeat.o(286267);
  }
  
  public final void gpP()
  {
    AppMethodBeat.i(286306);
    com.tencent.mm.kernel.h.aZW().a(6860, this.LYH);
    com.tencent.mm.kernel.h.aZW().a(3763, this.LYH);
    com.tencent.mm.kernel.h.aZW().a(6473, this.LYH);
    AppMethodBeat.o(286306);
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.mv.ui.a.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.b
 * JD-Core Version:    0.7.0.1
 */