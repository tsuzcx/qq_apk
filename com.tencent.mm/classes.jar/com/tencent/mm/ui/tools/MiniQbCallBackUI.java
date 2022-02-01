package com.tencent.mm.ui.tools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.sdk.b.a;

public class MiniQbCallBackUI
  extends MiniQbCallBackBaseUI
{
  protected final String getTag()
  {
    return "MicroMsg.FilesFloatBall.MiniQbCallBackUI";
  }
  
  protected final void h(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(39077);
    super.h(paramString1, paramString2, paramInt, paramString3);
    paramString1 = new lx();
    paramString1.dAo.action = paramInt;
    paramString1.dAo.filePath = paramString3;
    a.IvT.l(paramString1);
    AppMethodBeat.o(39077);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MiniQbCallBackUI
 * JD-Core Version:    0.7.0.1
 */