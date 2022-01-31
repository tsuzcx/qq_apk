package com.tencent.mm.plugin.sight.decode.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

final class VideoPlayView$1
  implements e.a
{
  VideoPlayView$1(VideoPlayView paramVideoPlayView) {}
  
  public final void Es()
  {
    AppMethodBeat.i(70313);
    ab.d("MicroMsg.VideoPlayView", "on completion " + bo.dtY().toString());
    if (!VideoPlayView.b(this.qUK))
    {
      VideoPlayView.a(this.qUK, 0.0D);
      this.qUK.A(0.0D);
      VideoPlayView.c(this.qUK).setIsPlay(false);
      VideoPlayView.a(this.qUK, 0);
      VideoPlayView.d(this.qUK);
      if (System.currentTimeMillis() - VideoPlayView.e(this.qUK) < 2000L)
      {
        ab.i("MicroMsg.VideoPlayView", "Too short onCompletion");
        AppMethodBeat.o(70313);
        return;
      }
      VideoPlayView.a(this.qUK, System.currentTimeMillis());
      if (VideoPlayView.f(this.qUK) != null)
      {
        VideoPlayView.f(this.qUK).cmS();
        AppMethodBeat.o(70313);
      }
    }
    else
    {
      VideoPlayView.c(this.qUK).setIsPlay(false);
      VideoPlayView.a(this.qUK, (int)VideoPlayView.g(this.qUK));
      VideoPlayView.d(this.qUK);
      if (VideoPlayView.f(this.qUK) != null) {
        VideoPlayView.f(this.qUK).cmT();
      }
    }
    AppMethodBeat.o(70313);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70314);
    al.d(new VideoPlayView.1.1(this, paramInt1, paramInt2));
    AppMethodBeat.o(70314);
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70315);
    VideoPlayView.c(this.qUK, paramInt1);
    VideoPlayView.d(this.qUK, paramInt2);
    if (VideoPlayView.k(this.qUK)) {
      VideoPlayView.l(this.qUK).post(new VideoPlayView.1.2(this));
    }
    AppMethodBeat.o(70315);
  }
  
  public final void mG()
  {
    AppMethodBeat.i(70311);
    ab.d("MicroMsg.VideoPlayView", g.Mk() + " onPrepared");
    VideoPlayView.a(this.qUK, true);
    AppMethodBeat.o(70311);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70312);
    ab.e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    VideoPlayView.a(this.qUK).stop();
    AppMethodBeat.o(70312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.1
 * JD-Core Version:    0.7.0.1
 */