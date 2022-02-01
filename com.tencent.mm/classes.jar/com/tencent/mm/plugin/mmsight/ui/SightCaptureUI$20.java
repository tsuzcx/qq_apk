package com.tencent.mm.plugin.mmsight.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

final class SightCaptureUI$20
  implements h.a
{
  SightCaptureUI$20(SightCaptureUI paramSightCaptureUI) {}
  
  public final void dY(int paramInt1, int paramInt2) {}
  
  public final int eM(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(94668);
    SightCaptureUI.S(this.tLo).d(0.0D, true);
    AppMethodBeat.o(94668);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94666);
    ad.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(this.tLo.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(94666);
  }
  
  public final void rq()
  {
    AppMethodBeat.i(94667);
    if (SightCaptureUI.S(this.tLo) != null)
    {
      SightCaptureUI.S(this.tLo).start();
      SightCaptureUI.S(this.tLo).setLoop(true);
    }
    aq.az(SightCaptureUI.M(this.tLo));
    SightCaptureUI.S(this.tLo).setOneTimeVideoTextureUpdateCallback(new h.e()
    {
      public final void beo()
      {
        AppMethodBeat.i(94665);
        aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94664);
            ad.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
            if (SightCaptureUI.S(SightCaptureUI.20.this.tLo) == null)
            {
              AppMethodBeat.o(94664);
              return;
            }
            SightCaptureUI.S(SightCaptureUI.20.this.tLo).setAlpha(1.0F);
            SightCaptureUI.b(SightCaptureUI.20.this.tLo, 4);
            SightCaptureUI.F(SightCaptureUI.20.this.tLo);
            AppMethodBeat.o(94664);
          }
        }, 50L);
        if (SightCaptureUI.a(SightCaptureUI.20.this.tLo).tBh) {
          SightCaptureUI.R(SightCaptureUI.20.this.tLo).setVisibility(0);
        }
        AppMethodBeat.o(94665);
      }
    });
    AppMethodBeat.o(94667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.20
 * JD-Core Version:    0.7.0.1
 */