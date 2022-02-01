package com.tencent.mm.ui.tools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.le;
import com.tencent.mm.miniutil.MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bt;

public class MiniQbCallBackMMUI
  extends MiniQbCallBackBaseUI
{
  protected final void g(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(39076);
    super.g(paramString1, paramString2, paramInt, paramString3);
    if (bt.isNullOrNil(paramString2))
    {
      paramString1 = new le();
      paramString1.dpK.action = paramInt;
      paramString1.dpK.filePath = paramString3;
      a.ESL.l(paramString1);
      AppMethodBeat.o(39076);
      return;
    }
    paramString1 = new MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent(paramInt, paramString3);
    ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class)).a(paramString2, paramString1);
    AppMethodBeat.o(39076);
  }
  
  protected final String getTag()
  {
    return "MicroMsg.FilesFloatBall.MiniQbCallBackMMUI";
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MiniQbCallBackMMUI
 * JD-Core Version:    0.7.0.1
 */