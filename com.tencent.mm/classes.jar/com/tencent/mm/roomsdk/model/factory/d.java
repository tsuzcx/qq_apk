package com.tencent.mm.roomsdk.model.factory;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.ay.b;
import com.tencent.mm.ay.b.a;
import com.tencent.mm.ay.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.protocal.protobuf.dze;
import com.tencent.mm.protocal.protobuf.dzf;
import com.tencent.mm.roomsdk.model.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
{
  com.tencent.mm.ay.c acmG;
  com.tencent.mm.am.h maV;
  
  public d()
  {
    AppMethodBeat.i(234084);
    this.maV = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(234090);
        if (d.this.acmG.equals(paramAnonymousp))
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.b(paramAnonymousp.getType(), d.this.maV);
          if (d.this.tipDialog != null) {
            d.this.tipDialog.dismiss();
          }
          if (d.this.acmz != null)
          {
            paramAnonymousString = ((b.c)((b)paramAnonymousp).oPG.getRespObj()).oPL;
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              break label306;
            }
          }
        }
        for (;;)
        {
          try
          {
            paramAnonymousInt1 = ((Integer)paramAnonymousString.abdX.aamU.getLast()).intValue();
            paramAnonymousInt2 = paramAnonymousInt1;
            paramAnonymousp = (dzc)paramAnonymousString.abdX.abdY.getLast();
            if (paramAnonymousp != null)
            {
              paramAnonymousInt2 = paramAnonymousInt1;
              if (!Util.isNullOrNil(paramAnonymousp.nUB))
              {
                paramAnonymousInt2 = paramAnonymousInt1;
                paramAnonymousString = paramAnonymousp.nUB;
              }
            }
            Object localObject;
            paramAnonymousString = null;
          }
          catch (Exception paramAnonymousp)
          {
            try
            {
              localObject = Util.nullAs(paramAnonymousp.hAP, "");
              paramAnonymousp = paramAnonymousString;
              paramAnonymousString = (String)localObject;
              localObject = paramAnonymousp;
              paramAnonymousp = paramAnonymousString;
              paramAnonymousString = (String)localObject;
              if ((d.this.acmz instanceof e))
              {
                localObject = (e)d.this.acmz;
                ((e)localObject).ret = paramAnonymousInt1;
                ((e)localObject).title = paramAnonymousp;
                ((e)localObject).content = paramAnonymousString;
              }
              d.this.acmz.onResult(0, paramAnonymousInt1, "", d.this.acmz);
              AppMethodBeat.o(234090);
              return;
            }
            catch (Exception paramAnonymousp)
            {
              continue;
            }
            paramAnonymousp = paramAnonymousp;
            paramAnonymousString = null;
            paramAnonymousInt1 = paramAnonymousInt2;
            Log.e("MicroMsg.RoomCallbackFactory", "NetSceneSyncOplog %s", new Object[] { paramAnonymousp.getMessage() });
            paramAnonymousp = null;
            continue;
            paramAnonymousp = null;
            paramAnonymousString = null;
            continue;
          }
          label306:
          paramAnonymousp = null;
          paramAnonymousInt1 = paramAnonymousInt2;
        }
      }
    };
    this.acmw = true;
    AppMethodBeat.o(234084);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(234094);
    if (this.acmG == null)
    {
      AppMethodBeat.o(234094);
      return;
    }
    this.tipDialog = k.a(paramContext, paramString2, paramBoolean2, paramOnCancelListener);
    blj();
    AppMethodBeat.o(234094);
  }
  
  public final void a(k.b paramb)
  {
    AppMethodBeat.i(234089);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramb);
    this.acmG = new com.tencent.mm.ay.c(localLinkedList);
    AppMethodBeat.o(234089);
  }
  
  public final void blj()
  {
    AppMethodBeat.i(234092);
    if (this.acmG == null)
    {
      AppMethodBeat.o(234092);
      return;
    }
    Log.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.acmG });
    if ((this.tipDialog != null) || (this.acmx != null) || (this.acmy != null) || (this.acmz != null))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(this.acmG.getType(), this.maV);
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(this.acmG, 0);
    AppMethodBeat.o(234092);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(234085);
    if (this.acmG == null)
    {
      AppMethodBeat.o(234085);
      return;
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(this.acmG);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(this.acmG.getType(), this.maV);
    AppMethodBeat.o(234085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.model.factory.d
 * JD-Core Version:    0.7.0.1
 */