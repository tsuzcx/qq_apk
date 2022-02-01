package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.bd.b;
import com.tencent.mm.bd.b.a;
import com.tencent.mm.bd.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
{
  com.tencent.mm.bd.c URt;
  i jxB;
  
  public d()
  {
    AppMethodBeat.i(237193);
    this.jxB = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(215308);
        if (d.this.URt.equals(paramAnonymousq))
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.b(paramAnonymousq.getType(), d.this.jxB);
          if (d.this.tipDialog != null) {
            d.this.tipDialog.dismiss();
          }
          if (d.this.URl != null)
          {
            paramAnonymousString = ((b.c)((b)paramAnonymousq).lWE.getRespObj()).lWJ;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label309;
            }
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousInt1 = ((Integer)paramAnonymousString.TNE.SZW.getLast()).intValue();
            paramAnonymousInt2 = paramAnonymousInt1;
            paramAnonymousq = (dgv)paramAnonymousString.TNE.TNF.getLast();
            if (paramAnonymousq != null)
            {
              paramAnonymousInt2 = paramAnonymousInt1;
              if (!Util.isNullOrNil(paramAnonymousq.lpy))
              {
                paramAnonymousInt2 = paramAnonymousInt1;
                paramAnonymousString = paramAnonymousq.lpy;
              }
            }
            Object localObject;
            paramAnonymousString = null;
          }
          catch (Exception paramAnonymousq)
          {
            try
            {
              localObject = Util.nullAs(paramAnonymousq.fwr, "");
              paramAnonymousq = paramAnonymousString;
              paramAnonymousString = (String)localObject;
              localObject = paramAnonymousq;
              paramAnonymousq = paramAnonymousString;
              paramAnonymousString = (String)localObject;
              if ((d.this.URl instanceof e))
              {
                localObject = (e)d.this.URl;
                ((e)localObject).ret = paramAnonymousInt1;
                ((e)localObject).title = paramAnonymousq;
                ((e)localObject).content = paramAnonymousString;
              }
              d.this.URl.a(0, paramAnonymousInt1, "", d.this.URl);
              AppMethodBeat.o(215308);
              return;
            }
            catch (Exception paramAnonymousq)
            {
              continue;
            }
            paramAnonymousq = paramAnonymousq;
            paramAnonymousString = null;
            paramAnonymousInt1 = paramAnonymousInt2;
            Log.e("MicroMsg.RoomCallbackFactory", "NetSceneSyncOplog %s", new Object[] { paramAnonymousq.getMessage() });
            paramAnonymousq = null;
            continue;
            paramAnonymousq = null;
            paramAnonymousString = null;
            continue;
          }
          label309:
          paramAnonymousq = null;
          paramAnonymousInt1 = paramAnonymousInt2;
        }
      }
    };
    this.URi = true;
    AppMethodBeat.o(237193);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(237201);
    if (this.URt == null)
    {
      AppMethodBeat.o(237201);
      return;
    }
    this.tipDialog = com.tencent.mm.ui.base.h.a(paramContext, paramString2, paramBoolean2, paramOnCancelListener);
    aRu();
    AppMethodBeat.o(237201);
  }
  
  public final void a(k.b paramb)
  {
    AppMethodBeat.i(237197);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramb);
    this.URt = new com.tencent.mm.bd.c(localLinkedList);
    AppMethodBeat.o(237197);
  }
  
  public final void aRu()
  {
    AppMethodBeat.i(237199);
    if (this.URt == null)
    {
      AppMethodBeat.o(237199);
      return;
    }
    Log.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.URt });
    if ((this.tipDialog != null) || (this.URj != null) || (this.URk != null) || (this.URl != null))
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(this.URt.getType(), this.jxB);
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(this.URt, 0);
    AppMethodBeat.o(237199);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(237195);
    if (this.URt == null)
    {
      AppMethodBeat.o(237195);
      return;
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(this.URt);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(this.URt.getType(), this.jxB);
    AppMethodBeat.o(237195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.d
 * JD-Core Version:    0.7.0.1
 */