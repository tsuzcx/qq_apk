package com.tencent.mm.recovery.a;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.Request;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.TaskCallback;
import com.tencent.mm.plugin.hp.net.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class a
{
  public b.a ymT;
  SimpleHttpLogic.Request ymU;
  SimpleHttpLogic.TaskCallback ymV;
  b.a ymW;
  
  public a(cxv paramcxv)
  {
    AppMethodBeat.i(193909);
    this.ymT = new b.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
      {
        AppMethodBeat.i(193907);
        Log.d("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "error%d response:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousb.toString() });
        AppMethodBeat.o(193907);
      }
    };
    this.ymV = new SimpleHttpLogic.TaskCallback()
    {
      public final void onCompleted(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(193908);
        Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "onCompleted errorType:%d errorCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 200)) {
          try
          {
            Object localObject = new PByteArray();
            Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "unpack result ".concat(String.valueOf(SimpleHttpLogic.unpackResponse(paramAnonymousArrayOfByte, (PByteArray)localObject))));
            paramAnonymousArrayOfByte = new cxw();
            paramAnonymousArrayOfByte.parseFrom(((PByteArray)localObject).value);
            localObject = paramAnonymousArrayOfByte.MCM;
            if (localObject != null)
            {
              paramAnonymousArrayOfByte = new com.tencent.mm.plugin.hp.d.b((cxz)localObject);
              a.this.ymW.a(0, paramAnonymousArrayOfByte);
              AppMethodBeat.o(193908);
              return;
            }
            Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "empty node. code:%d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.MCO) });
            a.this.ymW.a(-5, null);
            AppMethodBeat.o(193908);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", paramAnonymousArrayOfByte, "debugMMTLSCheck", new Object[0]);
            a.this.ymW.a(-2, null);
            AppMethodBeat.o(193908);
            return;
          }
        }
        a.this.ymW.a(-1, null);
        AppMethodBeat.o(193908);
      }
    };
    this.ymW = this.ymT;
    cxv localcxv = paramcxv;
    if (paramcxv == null)
    {
      paramcxv = com.tencent.mm.loader.j.a.aKw();
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "baseTinkerId = ".concat(String.valueOf(paramcxv)));
      localcxv = new cxv();
      localcxv.MCI = paramcxv;
      localcxv.APx = com.tencent.mm.loader.j.a.aKx();
      localcxv.MCJ = b.dZe();
      localcxv.MCL = 1;
    }
    try
    {
      this.ymU = new SimpleHttpLogic.Request();
      this.ymU.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
      this.ymU.host = MMApplicationContext.getResources().getString(2131761739);
      paramcxv = new PByteArray();
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localcxv.toByteArray(), paramcxv))));
      this.ymU.body = paramcxv.value;
      paramcxv = new StringBuilder();
      if (localcxv != null)
      {
        paramcxv.append("baseId  :").append(localcxv.MCI).append("\n");
        paramcxv.append("patchId :").append(localcxv.APx).append("\n");
      }
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "prconfig %s", new Object[] { paramcxv.toString() });
      AppMethodBeat.o(193909);
      return;
    }
    catch (IOException paramcxv)
    {
      for (;;)
      {
        this.ymU = null;
        Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", paramcxv, "mmtls request create failed.", new Object[0]);
      }
    }
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(193910);
    this.ymW = parama;
    if (this.ymU == null)
    {
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "doScene failed. request is null.");
      this.ymW.a(-3, null);
      AppMethodBeat.o(193910);
      return;
    }
    Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "start check");
    parama = "";
    if (BuildInfo.DEBUG) {
      parama = "101.227.131.113";
    }
    SimpleHttpLogic.startRequest(this.ymU, this.ymV, parama);
    AppMethodBeat.o(193910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recovery.a.a
 * JD-Core Version:    0.7.0.1
 */