package com.tencent.mm.recovery.a;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.Request;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.TaskCallback;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class a
{
  public com.tencent.mm.plugin.hp.net.b.a DMV;
  SimpleHttpLogic.Request DMW;
  SimpleHttpLogic.TaskCallback DMX;
  com.tencent.mm.plugin.hp.net.b.a DMY;
  
  public a(dhg paramdhg)
  {
    AppMethodBeat.i(202488);
    this.DMV = new com.tencent.mm.plugin.hp.net.b.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.plugin.hp.d.b paramAnonymousb)
      {
        AppMethodBeat.i(202399);
        Log.d("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "error%d response:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousb.toString() });
        AppMethodBeat.o(202399);
      }
    };
    this.DMX = new SimpleHttpLogic.TaskCallback()
    {
      public final void onCompleted(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(202271);
        Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "onCompleted errorType:%d errorCode:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 200)) {
          try
          {
            Object localObject = new PByteArray();
            Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "unpack result ".concat(String.valueOf(SimpleHttpLogic.unpackResponse(paramAnonymousArrayOfByte, (PByteArray)localObject))));
            paramAnonymousArrayOfByte = new dhh();
            paramAnonymousArrayOfByte.parseFrom(((PByteArray)localObject).value);
            localObject = paramAnonymousArrayOfByte.TOs;
            if (localObject != null)
            {
              paramAnonymousArrayOfByte = new com.tencent.mm.plugin.hp.d.b((dhk)localObject);
              a.this.DMY.a(0, paramAnonymousArrayOfByte);
              AppMethodBeat.o(202271);
              return;
            }
            Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "empty node. code:%d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.TOu) });
            a.this.DMY.a(-5, null);
            AppMethodBeat.o(202271);
            return;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", paramAnonymousArrayOfByte, "debugMMTLSCheck", new Object[0]);
            a.this.DMY.a(-2, null);
            AppMethodBeat.o(202271);
            return;
          }
        }
        a.this.DMY.a(-1, null);
        AppMethodBeat.o(202271);
      }
    };
    this.DMY = this.DMV;
    dhg localdhg = paramdhg;
    if (paramdhg == null)
    {
      paramdhg = com.tencent.mm.loader.j.a.aSy();
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "baseTinkerId = ".concat(String.valueOf(paramdhg)));
      localdhg = new dhg();
      localdhg.TOo = paramdhg;
      localdhg.GIL = com.tencent.mm.loader.j.a.aSz();
      localdhg.TOp = b.eIb();
      localdhg.TOr = 1;
    }
    try
    {
      this.DMW = new SimpleHttpLogic.Request();
      this.DMW.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
      this.DMW.host = MMApplicationContext.getResources().getString(com.tencent.mm.plugin.boots.b.a.host_short_weixin_qq_com);
      paramdhg = new PByteArray();
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(localdhg.toByteArray(), paramdhg))));
      this.DMW.body = paramdhg.value;
      paramdhg = new StringBuilder();
      if (localdhg != null)
      {
        paramdhg.append("baseId  :").append(localdhg.TOo).append("\n");
        paramdhg.append("patchId :").append(localdhg.GIL).append("\n");
      }
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "prconfig %s", new Object[] { paramdhg.toString() });
      AppMethodBeat.o(202488);
      return;
    }
    catch (IOException paramdhg)
    {
      for (;;)
      {
        this.DMW = null;
        Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", paramdhg, "mmtls request create failed.", new Object[0]);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.hp.net.b.a parama)
  {
    AppMethodBeat.i(202491);
    this.DMY = parama;
    if (this.DMW == null)
    {
      Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "doScene failed. request is null.");
      this.DMY.a(-3, null);
      AppMethodBeat.o(202491);
      return;
    }
    Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "start check");
    parama = "";
    if (BuildInfo.DEBUG) {
      parama = "101.227.131.113";
    }
    SimpleHttpLogic.startRequest(this.DMW, this.DMX, parama);
    AppMethodBeat.o(202491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recovery.a.a
 * JD-Core Version:    0.7.0.1
 */