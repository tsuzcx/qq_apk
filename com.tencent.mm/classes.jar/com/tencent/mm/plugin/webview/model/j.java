package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.abt;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class j
{
  public LinkedList<String> WKN = null;
  public boolean vqO = false;
  
  public final int h(final LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(78869);
    try
    {
      final int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 2;
      c.a locala = new c.a();
      locala.otE = new abt();
      locala.otF = new abu();
      locala.uri = "/cgi-bin/micromsg-bin/checktextlanguage";
      locala.funcId = 528;
      locala.otG = 0;
      locala.respCmdId = 0;
      abt localabt = (abt)c.b.b(locala.bEF().otB);
      localabt.Zkn = paramLinkedList;
      localabt.Zko = paramString;
      paramLinkedList = new CountDownLatch(1);
      new Bundle();
      IPCRunCgi.a(locala.bEF(), new IPCRunCgi.a()
      {
        public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc)
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
          paramAnonymousString = (abu)c.c.b(paramAnonymousc.otC);
          if (paramAnonymousString.Zkq == 1) {
            arrayOfInt[0] = 0;
          }
          for (;;)
          {
            paramLinkedList.countDown();
            AppMethodBeat.o(78868);
            return;
            if (paramAnonymousString.Zkq == 2) {
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