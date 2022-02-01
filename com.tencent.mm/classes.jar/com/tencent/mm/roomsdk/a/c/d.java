package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.ba.b.a;
import com.tencent.mm.ba.b.c;
import com.tencent.mm.ba.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
{
  c NDW;
  i gNh;
  
  public d()
  {
    AppMethodBeat.i(223899);
    this.gNh = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
      {
        AppMethodBeat.i(223898);
        if (d.this.NDW.equals(paramAnonymousq))
        {
          g.aAi();
          g.aAg().hqi.b(paramAnonymousq.getType(), d.this.gNh);
          if (d.this.tipDialog != null) {
            d.this.tipDialog.dismiss();
          }
          if (d.this.NDO != null)
          {
            paramAnonymousString = ((b.c)((com.tencent.mm.ba.b)paramAnonymousq).jgb.getRespObj()).jgg;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label309;
            }
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousInt1 = ((Integer)paramAnonymousString.MBY.LRr.getLast()).intValue();
            paramAnonymousInt2 = paramAnonymousInt1;
            paramAnonymousq = (cxl)paramAnonymousString.MBY.MBZ.getLast();
            if (paramAnonymousq != null)
            {
              paramAnonymousInt2 = paramAnonymousInt1;
              if (!Util.isNullOrNil(paramAnonymousq.iAc))
              {
                paramAnonymousInt2 = paramAnonymousInt1;
                paramAnonymousString = paramAnonymousq.iAc;
              }
            }
            Object localObject;
            paramAnonymousString = null;
          }
          catch (Exception paramAnonymousq)
          {
            try
            {
              localObject = Util.nullAs(paramAnonymousq.Title, "");
              paramAnonymousq = paramAnonymousString;
              paramAnonymousString = (String)localObject;
              localObject = paramAnonymousq;
              paramAnonymousq = paramAnonymousString;
              paramAnonymousString = (String)localObject;
              if ((d.this.NDO instanceof e))
              {
                localObject = (e)d.this.NDO;
                ((e)localObject).ret = paramAnonymousInt1;
                ((e)localObject).title = paramAnonymousq;
                ((e)localObject).content = paramAnonymousString;
              }
              d.this.NDO.a(0, paramAnonymousInt1, "", d.this.NDO);
              AppMethodBeat.o(223898);
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
    this.NDL = true;
    AppMethodBeat.o(223899);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(223903);
    if (this.NDW == null)
    {
      AppMethodBeat.o(223903);
      return;
    }
    this.tipDialog = h.a(paramContext, paramString2, paramBoolean2, paramOnCancelListener);
    aJu();
    AppMethodBeat.o(223903);
  }
  
  public final void a(k.b paramb)
  {
    AppMethodBeat.i(223901);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramb);
    this.NDW = new c(localLinkedList);
    AppMethodBeat.o(223901);
  }
  
  public final void aJu()
  {
    AppMethodBeat.i(223902);
    if (this.NDW == null)
    {
      AppMethodBeat.o(223902);
      return;
    }
    Log.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.NDW });
    if ((this.tipDialog != null) || (this.NDM != null) || (this.NDN != null) || (this.NDO != null))
    {
      g.aAi();
      g.aAg().hqi.a(this.NDW.getType(), this.gNh);
    }
    g.aAi();
    g.aAg().hqi.a(this.NDW, 0);
    AppMethodBeat.o(223902);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(223900);
    if (this.NDW == null)
    {
      AppMethodBeat.o(223900);
      return;
    }
    g.aAi();
    g.aAg().hqi.a(this.NDW);
    g.aAi();
    g.aAg().hqi.b(this.NDW.getType(), this.gNh);
    AppMethodBeat.o(223900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.d
 * JD-Core Version:    0.7.0.1
 */