package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.protocal.protobuf.vq;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class j
{
  private final int AKo = 0;
  private final int AKp = 1;
  private final int AKq = 2;
  public LinkedList<String> AXb = null;
  public boolean mJO = false;
  
  public final int f(final LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(78869);
    try
    {
      final int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 2;
      b.a locala = new b.a();
      locala.gUU = new vp();
      locala.gUV = new vq();
      locala.uri = "/cgi-bin/micromsg-bin/checktextlanguage";
      locala.funcId = 528;
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      vp localvp = (vp)locala.atI().gUS.gUX;
      localvp.CXG = paramLinkedList;
      localvp.CXH = paramString;
      paramLinkedList = new CountDownLatch(1);
      new Bundle();
      IPCRunCgi.a(locala.atI(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(78868);
          ad.i("MicroMsg.NetSceneCheckTextLanguage", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          arrayOfInt[0] = 2;
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            paramLinkedList.countDown();
            AppMethodBeat.o(78868);
            return;
          }
          paramAnonymousString = (vq)paramAnonymousb.gUT.gUX;
          if (paramAnonymousString.CXJ == 1) {
            arrayOfInt[0] = 0;
          }
          for (;;)
          {
            paramLinkedList.countDown();
            AppMethodBeat.o(78868);
            return;
            if (paramAnonymousString.CXJ == 2) {
              arrayOfInt[0] = 1;
            }
          }
        }
      });
      try
      {
        paramLinkedList.await(1000L, TimeUnit.MILLISECONDS);
        ad.i("MicroMsg.NetSceneCheckTextLanguage", "CheckTextLanguage end");
        int i = arrayOfInt[0];
        AppMethodBeat.o(78869);
        return i;
      }
      catch (InterruptedException paramLinkedList)
      {
        for (;;)
        {
          ad.w("MicroMsg.NetSceneCheckTextLanguage", paramLinkedList.getMessage());
          ad.printErrStackTrace("MicroMsg.NetSceneCheckTextLanguage", paramLinkedList, "", new Object[0]);
        }
      }
      return 2;
    }
    catch (Exception paramLinkedList)
    {
      ad.e("MicroMsg.NetSceneCheckTextLanguage", "CheckTextLanguage failed");
      AppMethodBeat.o(78869);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.j
 * JD-Core Version:    0.7.0.1
 */