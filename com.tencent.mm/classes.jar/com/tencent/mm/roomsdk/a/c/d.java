package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.b.a;
import com.tencent.mm.ba.b.c;
import com.tencent.mm.ba.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
{
  c GkF;
  com.tencent.mm.ak.g hwV;
  
  public d()
  {
    AppMethodBeat.i(192714);
    this.hwV = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(192713);
        if (d.this.GkF.equals(paramAnonymousn))
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.b(paramAnonymousn.getType(), d.this.hwV);
          if (d.this.tipDialog != null) {
            d.this.tipDialog.dismiss();
          }
          if (d.this.Gkx != null)
          {
            paramAnonymousString = ((b.c)((com.tencent.mm.ba.b)paramAnonymousn).hOV.getRespObj()).hPa;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label309;
            }
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousInt1 = ((Integer)paramAnonymousString.FpR.EKK.getLast()).intValue();
            paramAnonymousInt2 = paramAnonymousInt1;
            paramAnonymousn = (cbt)paramAnonymousString.FpR.FpS.getLast();
            if (paramAnonymousn != null)
            {
              paramAnonymousInt2 = paramAnonymousInt1;
              if (!bs.isNullOrNil(paramAnonymousn.hkR))
              {
                paramAnonymousInt2 = paramAnonymousInt1;
                paramAnonymousString = paramAnonymousn.hkR;
              }
            }
            Object localObject;
            paramAnonymousString = null;
          }
          catch (Exception paramAnonymousn)
          {
            try
            {
              localObject = bs.bG(paramAnonymousn.Title, "");
              paramAnonymousn = paramAnonymousString;
              paramAnonymousString = (String)localObject;
              localObject = paramAnonymousn;
              paramAnonymousn = paramAnonymousString;
              paramAnonymousString = (String)localObject;
              if ((d.this.Gkx instanceof e))
              {
                localObject = (e)d.this.Gkx;
                ((e)localObject).ret = paramAnonymousInt1;
                ((e)localObject).title = paramAnonymousn;
                ((e)localObject).content = paramAnonymousString;
              }
              d.this.Gkx.a(0, paramAnonymousInt1, "", d.this.Gkx);
              AppMethodBeat.o(192713);
              return;
            }
            catch (Exception paramAnonymousn)
            {
              continue;
            }
            paramAnonymousn = paramAnonymousn;
            paramAnonymousString = null;
            paramAnonymousInt1 = paramAnonymousInt2;
            ac.e("MicroMsg.RoomCallbackFactory", "NetSceneSyncOplog %s", new Object[] { paramAnonymousn.getMessage() });
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
    this.Gku = true;
    AppMethodBeat.o(192714);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(192718);
    if (this.GkF == null)
    {
      AppMethodBeat.o(192718);
      return;
    }
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    csU();
    AppMethodBeat.o(192718);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(192715);
    if (this.GkF == null)
    {
      AppMethodBeat.o(192715);
      return;
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(this.GkF);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(this.GkF.getType(), this.hwV);
    AppMethodBeat.o(192715);
  }
  
  public final void csU()
  {
    AppMethodBeat.i(192717);
    if (this.GkF == null)
    {
      AppMethodBeat.o(192717);
      return;
    }
    ac.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.GkF });
    if ((this.tipDialog != null) || (this.Gkv != null) || (this.Gkw != null) || (this.Gkx != null))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(this.GkF.getType(), this.hwV);
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(this.GkF, 0);
    AppMethodBeat.o(192717);
  }
  
  public final void e(j.b paramb)
  {
    AppMethodBeat.i(192716);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramb);
    this.GkF = new c(localLinkedList);
    AppMethodBeat.o(192716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.d
 * JD-Core Version:    0.7.0.1
 */