package com.tencent.mm.recovery.a;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.Request;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.TaskCallback;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class a
{
  public com.tencent.mm.plugin.hp.net.b.a JEj;
  SimpleHttpLogic.Request JEk;
  SimpleHttpLogic.TaskCallback JEl;
  com.tencent.mm.plugin.hp.net.b.a JEm;
  
  public a(dzp paramdzp)
  {
    AppMethodBeat.i(242770);
    this.JEj = new com.tencent.mm.plugin.hp.net.b.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.b.b paramAnonymousb)
      {
        AppMethodBeat.i(242765);
        Log.d("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "error%d response:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousb.toString() });
        AppMethodBeat.o(242765);
      }
    };
    this.JEl = new SimpleHttpLogic.TaskCallback()
    {
      public final void onCompleted(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(242768);
        Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "onCompleted errorType:%d errorCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 200)) {
          try
          {
            Object localObject = new PByteArray();
            Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "unpack result ".concat(String.valueOf(SimpleHttpLogic.unpackResponse(paramAnonymousArrayOfByte, (PByteArray)localObject))));
            paramAnonymousArrayOfByte = new dzq();
            paramAnonymousArrayOfByte.parseFrom(((PByteArray)localObject).value);
            localObject = paramAnonymousArrayOfByte.abeO;
            if (localObject != null)
            {
              paramAnonymousArrayOfByte = new com.tencent.mm.plugin.hp.b.b((dzt)localObject);
              a.this.JEm.a(0, paramAnonymousArrayOfByte);
              AppMethodBeat.o(242768);
              return;
            }
            Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "empty node. code:%d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.abeQ) });
            a.this.JEm.a(-5, null);
            AppMethodBeat.o(242768);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", paramAnonymousArrayOfByte, "debugMMTLSCheck", new Object[0]);
            a.this.JEm.a(-2, null);
            AppMethodBeat.o(242768);
            return;
          }
        }
        a.this.JEm.a(-1, null);
        AppMethodBeat.o(242768);
      }
    };
    this.JEm = this.JEj;
    dzp localdzp = paramdzp;
    if (paramdzp == null)
    {
      paramdzp = com.tencent.mm.loader.i.a.bmm();
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "baseTinkerId = ".concat(String.valueOf(paramdzp)));
      localdzp = new dzp();
      localdzp.abeK = paramdzp;
      localdzp.ycW = com.tencent.mm.loader.i.a.bmn();
      localdzp.abeL = b.fPU();
      localdzp.abeN = 1;
    }
    try
    {
      this.JEk = new SimpleHttpLogic.Request();
      this.JEk.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
      this.JEk.host = MMApplicationContext.getResources().getString(com.tencent.mm.plugin.boots.b.a.host_short_weixin_qq_com);
      paramdzp = new PByteArray();
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localdzp.toByteArray(), paramdzp))));
      this.JEk.body = paramdzp.value;
      paramdzp = new StringBuilder();
      if (localdzp != null)
      {
        paramdzp.append("baseId  :").append(localdzp.abeK).append("\n");
        paramdzp.append("patchId :").append(localdzp.ycW).append("\n");
      }
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "prconfig %s", new Object[] { paramdzp.toString() });
      AppMethodBeat.o(242770);
      return;
    }
    catch (IOException paramdzp)
    {
      for (;;)
      {
        this.JEk = null;
        Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", paramdzp, "mmtls request create failed.", new Object[0]);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.hp.net.b.a parama)
  {
    AppMethodBeat.i(242772);
    this.JEm = parama;
    if (this.JEk == null)
    {
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "doScene failed. request is null.");
      this.JEm.a(-3, null);
      AppMethodBeat.o(242772);
      return;
    }
    Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "start check");
    parama = "";
    if (BuildInfo.DEBUG) {
      parama = "101.227.131.113";
    }
    SimpleHttpLogic.startRequest(this.JEk, this.JEl, parama);
    AppMethodBeat.o(242772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recovery.a.a
 * JD-Core Version:    0.7.0.1
 */