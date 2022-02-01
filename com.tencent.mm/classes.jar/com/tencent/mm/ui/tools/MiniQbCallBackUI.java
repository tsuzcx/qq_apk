package com.tencent.mm.ui.tools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.sdk.event.EventCenter;

public class MiniQbCallBackUI
  extends MiniQbCallBackBaseUI
{
  protected final void b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(234465);
    super.b(paramString1, paramString2, paramInt1, paramString3, paramInt2);
    paramString1 = new mn();
    paramString1.dSa.action = paramInt1;
    paramString1.dSa.filePath = paramString3;
    paramString1.dSa.dSc = paramInt2;
    EventCenter.instance.publish(paramString1);
    AppMethodBeat.o(234465);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MiniQbCallBackUI
 * JD-Core Version:    0.7.0.1
 */