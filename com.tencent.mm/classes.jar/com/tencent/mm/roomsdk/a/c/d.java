package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.b.a;
import com.tencent.mm.ba.b.c;
import com.tencent.mm.ba.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
{
  c Iqz;
  f ghB;
  
  public d()
  {
    AppMethodBeat.i(218935);
    this.ghB = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(218934);
        if (d.this.Iqz.equals(paramAnonymousn))
        {
          g.ajS();
          g.ajQ().gDv.b(paramAnonymousn.getType(), d.this.ghB);
          if (d.this.tipDialog != null) {
            d.this.tipDialog.dismiss();
          }
          if (d.this.Iqr != null)
          {
            paramAnonymousString = ((b.c)((com.tencent.mm.ba.b)paramAnonymousn).ilc.getRespObj()).ilh;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label309;
            }
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousInt1 = ((Integer)paramAnonymousString.Htc.GNm.getLast()).intValue();
            paramAnonymousInt2 = paramAnonymousInt1;
            paramAnonymousn = (che)paramAnonymousString.Htc.Htd.getLast();
            if (paramAnonymousn != null)
            {
              paramAnonymousInt2 = paramAnonymousInt1;
              if (!bu.isNullOrNil(paramAnonymousn.hFS))
              {
                paramAnonymousInt2 = paramAnonymousInt1;
                paramAnonymousString = paramAnonymousn.hFS;
              }
            }
            Object localObject;
            paramAnonymousString = null;
          }
          catch (Exception paramAnonymousn)
          {
            try
            {
              localObject = bu.bI(paramAnonymousn.Title, "");
              paramAnonymousn = paramAnonymousString;
              paramAnonymousString = (String)localObject;
              localObject = paramAnonymousn;
              paramAnonymousn = paramAnonymousString;
              paramAnonymousString = (String)localObject;
              if ((d.this.Iqr instanceof e))
              {
                localObject = (e)d.this.Iqr;
                ((e)localObject).ret = paramAnonymousInt1;
                ((e)localObject).title = paramAnonymousn;
                ((e)localObject).content = paramAnonymousString;
              }
              d.this.Iqr.a(0, paramAnonymousInt1, "", d.this.Iqr);
              AppMethodBeat.o(218934);
              return;
            }
            catch (Exception paramAnonymousn)
            {
              continue;
            }
            paramAnonymousn = paramAnonymousn;
            paramAnonymousString = null;
            paramAnonymousInt1 = paramAnonymousInt2;
            ae.e("MicroMsg.RoomCallbackFactory", "NetSceneSyncOplog %s", new Object[] { paramAnonymousn.getMessage() });
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
    this.Iqo = true;
    AppMethodBeat.o(218935);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(218939);
    if (this.Iqz == null)
    {
      AppMethodBeat.o(218939);
      return;
    }
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    cAs();
    AppMethodBeat.o(218939);
  }
  
  public final void a(k.b paramb)
  {
    AppMethodBeat.i(218937);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramb);
    this.Iqz = new c(localLinkedList);
    AppMethodBeat.o(218937);
  }
  
  public final void cAs()
  {
    AppMethodBeat.i(218938);
    if (this.Iqz == null)
    {
      AppMethodBeat.o(218938);
      return;
    }
    ae.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.Iqz });
    if ((this.tipDialog != null) || (this.Iqp != null) || (this.Iqq != null) || (this.Iqr != null))
    {
      g.ajS();
      g.ajQ().gDv.a(this.Iqz.getType(), this.ghB);
    }
    g.ajS();
    g.ajQ().gDv.a(this.Iqz, 0);
    AppMethodBeat.o(218938);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(218936);
    if (this.Iqz == null)
    {
      AppMethodBeat.o(218936);
      return;
    }
    g.ajS();
    g.ajQ().gDv.a(this.Iqz);
    g.ajS();
    g.ajQ().gDv.b(this.Iqz.getType(), this.ghB);
    AppMethodBeat.o(218936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.d
 * JD-Core Version:    0.7.0.1
 */