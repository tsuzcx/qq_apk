package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bb.b.a;
import com.tencent.mm.bb.b.c;
import com.tencent.mm.bb.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
{
  c HWr;
  f hPn;
  
  public d()
  {
    AppMethodBeat.i(195482);
    this.hPn = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(195481);
        if (d.this.HWr.equals(paramAnonymousn))
        {
          g.ajD();
          g.ajB().gAO.b(paramAnonymousn.getType(), d.this.hPn);
          if (d.this.tipDialog != null) {
            d.this.tipDialog.dismiss();
          }
          if (d.this.HWj != null)
          {
            paramAnonymousString = ((b.c)((com.tencent.mm.bb.b)paramAnonymousn).iij.getRespObj()).iio;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label309;
            }
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousInt1 = ((Integer)paramAnonymousString.GZB.GtN.getLast()).intValue();
            paramAnonymousInt2 = paramAnonymousInt1;
            paramAnonymousn = (cgk)paramAnonymousString.GZB.GZC.getLast();
            if (paramAnonymousn != null)
            {
              paramAnonymousInt2 = paramAnonymousInt1;
              if (!bt.isNullOrNil(paramAnonymousn.hDa))
              {
                paramAnonymousInt2 = paramAnonymousInt1;
                paramAnonymousString = paramAnonymousn.hDa;
              }
            }
            Object localObject;
            paramAnonymousString = null;
          }
          catch (Exception paramAnonymousn)
          {
            try
            {
              localObject = bt.bI(paramAnonymousn.Title, "");
              paramAnonymousn = paramAnonymousString;
              paramAnonymousString = (String)localObject;
              localObject = paramAnonymousn;
              paramAnonymousn = paramAnonymousString;
              paramAnonymousString = (String)localObject;
              if ((d.this.HWj instanceof e))
              {
                localObject = (e)d.this.HWj;
                ((e)localObject).ret = paramAnonymousInt1;
                ((e)localObject).title = paramAnonymousn;
                ((e)localObject).content = paramAnonymousString;
              }
              d.this.HWj.a(0, paramAnonymousInt1, "", d.this.HWj);
              AppMethodBeat.o(195481);
              return;
            }
            catch (Exception paramAnonymousn)
            {
              continue;
            }
            paramAnonymousn = paramAnonymousn;
            paramAnonymousString = null;
            paramAnonymousInt1 = paramAnonymousInt2;
            ad.e("MicroMsg.RoomCallbackFactory", "NetSceneSyncOplog %s", new Object[] { paramAnonymousn.getMessage() });
            paramAnonymousn = null;
            continue;
            paramAnonymousn = null;
            paramAnonymousString = null;
            continue;
          }
          label309:
          paramAnonymousn = null;
          paramAnonymousInt1 = paramAnonymousInt2;
        }
      }
    };
    this.HWg = true;
    AppMethodBeat.o(195482);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(195486);
    if (this.HWr == null)
    {
      AppMethodBeat.o(195486);
      return;
    }
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    cyR();
    AppMethodBeat.o(195486);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(195483);
    if (this.HWr == null)
    {
      AppMethodBeat.o(195483);
      return;
    }
    g.ajD();
    g.ajB().gAO.a(this.HWr);
    g.ajD();
    g.ajB().gAO.b(this.HWr.getType(), this.hPn);
    AppMethodBeat.o(195483);
  }
  
  public final void cyR()
  {
    AppMethodBeat.i(195485);
    if (this.HWr == null)
    {
      AppMethodBeat.o(195485);
      return;
    }
    ad.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.HWr });
    if ((this.tipDialog != null) || (this.HWh != null) || (this.HWi != null) || (this.HWj != null))
    {
      g.ajD();
      g.ajB().gAO.a(this.HWr.getType(), this.hPn);
    }
    g.ajD();
    g.ajB().gAO.a(this.HWr, 0);
    AppMethodBeat.o(195485);
  }
  
  public final void e(k.b paramb)
  {
    AppMethodBeat.i(195484);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramb);
    this.HWr = new c(localLinkedList);
    AppMethodBeat.o(195484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.d
 * JD-Core Version:    0.7.0.1
 */