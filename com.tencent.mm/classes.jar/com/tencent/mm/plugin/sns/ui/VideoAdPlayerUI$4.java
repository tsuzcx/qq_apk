package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.a.a;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.k;
import com.tencent.mm.plugin.sns.a.b.k.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class VideoAdPlayerUI$4
  implements View.OnClickListener
{
  VideoAdPlayerUI$4(VideoAdPlayerUI paramVideoAdPlayerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39916);
    if (VideoAdPlayerUI.q(this.sdl) != 0) {
      k.a(k.a.rag, this.sdl.rNA, this.sdl.rNz, VideoAdPlayerUI.r(this.sdl), VideoAdPlayerUI.q(this.sdl), VideoAdPlayerUI.s(this.sdl), VideoAdPlayerUI.t(this.sdl), VideoAdPlayerUI.u(this.sdl), VideoAdPlayerUI.v(this.sdl), VideoAdPlayerUI.w(this.sdl), VideoAdPlayerUI.x(this.sdl));
    }
    if (VideoAdPlayerUI.e(this.sdl) != 0)
    {
      int j = VideoAdPlayerUI.a(this.sdl).qZJ.raJ;
      int i = j;
      if (VideoAdPlayerUI.b(this.sdl))
      {
        i = j;
        if (VideoAdPlayerUI.a(this.sdl).qZJ.raN != 0L) {
          i = j + (int)(bo.av(VideoAdPlayerUI.a(this.sdl).qZJ.raN) / 1000L);
        }
      }
      paramView = new com.tencent.mm.modelstat.i(13228, "1,1," + i + "," + VideoAdPlayerUI.f(this.sdl) + "," + VideoAdPlayerUI.g(this.sdl) + "," + bo.aox() + "," + VideoAdPlayerUI.h(this.sdl) + "," + VideoAdPlayerUI.i(this.sdl), (int)bo.aox());
      g.RM();
      g.RK().eHt.a(paramView, 0);
    }
    this.sdl.finish();
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_snsad_statextstr", VideoAdPlayerUI.y(this.sdl));
    String str = VideoAdPlayerUI.z(this.sdl);
    paramView = str;
    if (VideoAdPlayerUI.A(this.sdl))
    {
      paramView = str;
      if (!TextUtils.isEmpty(this.sdl.rNz)) {
        paramView = com.tencent.mm.plugin.sns.data.i.gg(str, this.sdl.rNz);
      }
    }
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramView);
    localIntent.putExtra("useJs", true);
    if (VideoAdPlayerUI.A(this.sdl)) {
      com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(0, 6, VideoAdPlayerUI.B(this.sdl).field_snsId, 18, 0));
    }
    new ak(Looper.getMainLooper()).post(new VideoAdPlayerUI.4.1(this, localIntent));
    AppMethodBeat.o(39916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.4
 * JD-Core Version:    0.7.0.1
 */