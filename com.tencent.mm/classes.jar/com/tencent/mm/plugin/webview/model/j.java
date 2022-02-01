package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.xy;
import com.tencent.mm.protocal.protobuf.xz;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class j
{
  private final int DFF = 0;
  private final int DFG = 1;
  private final int DFH = 2;
  public LinkedList<String> DSM = null;
  public boolean nME = false;
  
  public final int g(final LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(78869);
    try
    {
      final int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 2;
      b.a locala = new b.a();
      locala.hNM = new xy();
      locala.hNN = new xz();
      locala.uri = "/cgi-bin/micromsg-bin/checktextlanguage";
      locala.funcId = 528;
      locala.hNO = 0;
      locala.respCmdId = 0;
      xy localxy = (xy)locala.aDC().hNK.hNQ;
      localxy.FXA = paramLinkedList;
      localxy.FXB = paramString;
      paramLinkedList = new CountDownLatch(1);
      new Bundle();
      IPCRunCgi.a(locala.aDC(), new IPCRunCgi.a()
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
          paramAnonymousString = (xz)paramAnonymousb.hNL.hNQ;
          if (paramAnonymousString.FXD == 1) {
            arrayOfInt[0] = 0;
          }
          for (;;)
          {
            paramLinkedList.countDown();
            AppMethodBeat.o(78868);
            return;
            if (paramAnonymousString.FXD == 2) {
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