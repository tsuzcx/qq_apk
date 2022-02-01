package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.zt;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class j
{
  public LinkedList<String> PUb = null;
  public boolean sfb = false;
  
  public final int i(final LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(78869);
    try
    {
      final int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 2;
      d.a locala = new d.a();
      locala.lBU = new zt();
      locala.lBV = new zu();
      locala.uri = "/cgi-bin/micromsg-bin/checktextlanguage";
      locala.funcId = 528;
      locala.lBW = 0;
      locala.respCmdId = 0;
      zt localzt = (zt)d.b.b(locala.bgN().lBR);
      localzt.Sma = paramLinkedList;
      localzt.Smb = paramString;
      paramLinkedList = new CountDownLatch(1);
      new Bundle();
      IPCRunCgi.a(locala.bgN(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
        {
          AppMethodBeat.i(78868);
          Log.i("MicroMsg.NetSceneCheckTextLanguage", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          arrayOfInt[0] = 2;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            paramLinkedList.countDown();
            AppMethodBeat.o(78868);
            return;
          }
          paramAnonymousString = (zu)d.c.b(paramAnonymousd.lBS);
          if (paramAnonymousString.Smd == 1) {
            arrayOfInt[0] = 0;
          }
          for (;;)
          {
            paramLinkedList.countDown();
            AppMethodBeat.o(78868);
            return;
            if (paramAnonymousString.Smd == 2) {
              arrayOfInt[0] = 1;
            }
          }
        }
      });
      try
      {
        paramLinkedList.await(1000L, TimeUnit.MILLISECONDS);
        Log.i("MicroMsg.NetSceneCheckTextLanguage", "CheckTextLanguage end");
        int i = arrayOfInt[0];
        AppMethodBeat.o(78869);
        return i;
      }
      catch (InterruptedException paramLinkedList)
      {
        for (;;)
        {
          Log.w("MicroMsg.NetSceneCheckTextLanguage", paramLinkedList.getMessage());
          Log.printErrStackTrace("MicroMsg.NetSceneCheckTextLanguage", paramLinkedList, "", new Object[0]);
        }
      }
      return 2;
    }
    catch (Exception paramLinkedList)
    {
      Log.e("MicroMsg.NetSceneCheckTextLanguage", "CheckTextLanguage failed");
      AppMethodBeat.o(78869);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.j
 * JD-Core Version:    0.7.0.1
 */