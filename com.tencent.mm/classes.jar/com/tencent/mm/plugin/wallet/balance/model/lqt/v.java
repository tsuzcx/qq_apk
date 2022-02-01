package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.a.zk;
import com.tencent.mm.g.a.zl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.abc;
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.wallet_core.c.aa;

public class v
  extends com.tencent.mm.vending.app.a
{
  public final void onCreate()
  {
    AppMethodBeat.i(68481);
    super.onCreate();
    AppMethodBeat.o(68481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.v
 * JD-Core Version:    0.7.0.1
 */