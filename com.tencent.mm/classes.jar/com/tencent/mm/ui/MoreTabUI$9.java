package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.ay.a.d.b;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.preference.f;

final class MoreTabUI$9
  implements h
{
  MoreTabUI$9(MoreTabUI paramMoreTabUI) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView)
  {
    AppMethodBeat.i(33542);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33539);
        this.Wcx.auF(0);
        this.Wcx.auE(R.g.my_card_package_defaultlogo);
        AppMethodBeat.o(33539);
      }
    });
    AppMethodBeat.o(33542);
  }
  
  public final void b(final String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(33543);
    paramString = (NormalIconNewTipPreference)MoreTabUI.g(this.Wcv).byG("settings_mm_cardpackage");
    if (paramb.bitmap != null)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33540);
          paramString.aK(this.mLY);
          paramString.auF(0);
          AppMethodBeat.o(33540);
        }
      });
      AppMethodBeat.o(33543);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33541);
        paramString.aK(null);
        paramString.auF(8);
        AppMethodBeat.o(33541);
      }
    });
    AppMethodBeat.o(33543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.9
 * JD-Core Version:    0.7.0.1
 */