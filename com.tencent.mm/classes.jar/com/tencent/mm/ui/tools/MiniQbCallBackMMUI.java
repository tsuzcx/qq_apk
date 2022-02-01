package com.tencent.mm.ui.tools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ne;
import com.tencent.mm.kernel.h;
import com.tencent.mm.miniutil.MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;

public class MiniQbCallBackMMUI
  extends MiniQbCallBackBaseUI
{
  protected final void b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(216511);
    super.b(paramString1, paramString2, paramInt1, paramString3, paramInt2);
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = new ne();
      paramString1.fLx.action = paramInt1;
      paramString1.fLx.filePath = paramString3;
      paramString1.fLx.fLz = paramInt2;
      EventCenter.instance.publish(paramString1);
      AppMethodBeat.o(216511);
      return;
    }
    paramString1 = new MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent(paramInt1, paramString3);
    ((f)h.ae(f.class)).a(paramString2, paramString1);
    AppMethodBeat.o(216511);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MiniQbCallBackMMUI
 * JD-Core Version:    0.7.0.1
 */