package com.tencent.mm.ui.tools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.le;
import com.tencent.mm.sdk.b.a;

public class MiniQbCallBackUI
  extends MiniQbCallBackBaseUI
{
  protected final void g(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(39077);
    super.g(paramString1, paramString2, paramInt, paramString3);
    paramString1 = new le();
    paramString1.dpK.action = paramInt;
    paramString1.dpK.filePath = paramString3;
    a.ESL.l(paramString1);
    AppMethodBeat.o(39077);
  }
  
  protected final String getTag()
  {
    return "MicroMsg.FilesFloatBall.MiniQbCallBackUI";
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MiniQbCallBackUI
 * JD-Core Version:    0.7.0.1
 */