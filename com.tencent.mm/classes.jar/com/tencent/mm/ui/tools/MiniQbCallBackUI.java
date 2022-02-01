package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ol;

public class MiniQbCallBackUI
  extends MiniQbCallBackBaseUI
{
  protected final void b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(250972);
    super.b(paramString1, paramString2, paramInt1, paramString3, paramInt2);
    paramString1 = new ol();
    paramString1.hRf.action = paramInt1;
    paramString1.hRf.filePath = paramString3;
    paramString1.hRf.hRh = paramInt2;
    paramString1.publish();
    AppMethodBeat.o(250972);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MiniQbCallBackUI
 * JD-Core Version:    0.7.0.1
 */