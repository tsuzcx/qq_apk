package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class as$g
{
  public int errCode;
  public SnsAdClick pzR;
  private ArrayList<String> uWV;
  
  public as$g()
  {
    AppMethodBeat.i(6764);
    this.uWV = new ArrayList();
    AppMethodBeat.o(6764);
  }
  
  public final void L(String... paramVarArgs)
  {
    AppMethodBeat.i(6765);
    int i = 0;
    while (i < 4)
    {
      String str = paramVarArgs[i];
      this.uWV.add(str);
      i += 1;
    }
    AppMethodBeat.o(6765);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(6766);
    try
    {
      if (!this.uWV.isEmpty())
      {
        Bundle localBundle = new Bundle();
        localBundle.putStringArrayList("reportAdH5Load", this.uWV);
        localBundle.putInt("errCode", this.errCode);
        localBundle.putParcelable("snsAdClick", this.pzR);
        paramd.i(204, localBundle);
      }
      this.pzR = null;
      this.uWV.clear();
      AppMethodBeat.o(6766);
      return;
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WebviewReporter", paramd, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.as.g
 * JD-Core Version:    0.7.0.1
 */