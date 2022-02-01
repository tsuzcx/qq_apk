package com.tencent.mm.ui.tools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.kernel.g;
import com.tencent.mm.miniutil.MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bs;

public class MiniQbCallBackMMUI
  extends MiniQbCallBackBaseUI
{
  protected final String getTag()
  {
    return "MicroMsg.FilesFloatBall.MiniQbCallBackMMUI";
  }
  
  protected final void h(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(39076);
    super.h(paramString1, paramString2, paramInt, paramString3);
    if (bs.isNullOrNil(paramString2))
    {
      paramString1 = new ln();
      paramString1.dnv.action = paramInt;
      paramString1.dnv.filePath = paramString3;
      a.GpY.l(paramString1);
      AppMethodBeat.o(39076);
      return;
    }
    paramString1 = new MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent(paramInt, paramString3);
    ((f)g.ab(f.class)).a(paramString2, paramString1);
    AppMethodBeat.o(39076);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MiniQbCallBackMMUI
 * JD-Core Version:    0.7.0.1
 */