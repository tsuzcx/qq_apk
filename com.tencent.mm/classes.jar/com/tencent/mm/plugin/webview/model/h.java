package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.sw;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class h
{
  private final int uNE = 0;
  private final int uNF = 1;
  private final int uNG = 2;
  public LinkedList<String> uVv = null;
  public boolean uVw = false;
  
  public final int f(LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(153131);
    try
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 2;
      b.a locala = new b.a();
      locala.fsX = new sw();
      locala.fsY = new sx();
      locala.uri = "/cgi-bin/micromsg-bin/checktextlanguage";
      locala.funcId = 528;
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      sw localsw = (sw)locala.ado().fsV.fta;
      localsw.wLo = paramLinkedList;
      localsw.wLp = paramString;
      paramLinkedList = new CountDownLatch(1);
      new Bundle();
      com.tencent.mm.ipcinvoker.wx_extension.b.a(locala.ado(), new h.1(this, arrayOfInt, paramLinkedList));
      try
      {
        paramLinkedList.await(1000L, TimeUnit.MILLISECONDS);
        ab.i("MicroMsg.NetSceneCheckTextLanguage", "CheckTextLanguage end");
        int i = arrayOfInt[0];
        AppMethodBeat.o(153131);
        return i;
      }
      catch (InterruptedException paramLinkedList)
      {
        for (;;)
        {
          ab.w("MicroMsg.NetSceneCheckTextLanguage", paramLinkedList.getMessage());
          ab.printErrStackTrace("MicroMsg.NetSceneCheckTextLanguage", paramLinkedList, "", new Object[0]);
        }
      }
      return 2;
    }
    catch (Exception paramLinkedList)
    {
      ab.e("MicroMsg.NetSceneCheckTextLanguage", "CheckTextLanguage failed");
      AppMethodBeat.o(153131);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.h
 * JD-Core Version:    0.7.0.1
 */