package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.a.a;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

final class VideoAdPlayerUI$4
  implements View.OnClickListener
{
  VideoAdPlayerUI$4(VideoAdPlayerUI paramVideoAdPlayerUI) {}
  
  public final void onClick(View paramView)
  {
    if (VideoAdPlayerUI.q(this.pkW) != 0) {
      j.a(j.a.olS, this.pkW.pkG, this.pkW.pkF, VideoAdPlayerUI.r(this.pkW), VideoAdPlayerUI.q(this.pkW), VideoAdPlayerUI.s(this.pkW), VideoAdPlayerUI.t(this.pkW), VideoAdPlayerUI.u(this.pkW), VideoAdPlayerUI.v(this.pkW), VideoAdPlayerUI.w(this.pkW), VideoAdPlayerUI.x(this.pkW));
    }
    if (VideoAdPlayerUI.e(this.pkW) != 0)
    {
      int j = VideoAdPlayerUI.a(this.pkW).olx.omv;
      int i = j;
      if (VideoAdPlayerUI.b(this.pkW))
      {
        i = j;
        if (VideoAdPlayerUI.a(this.pkW).olx.omz != 0L) {
          i = j + (int)(bk.cp(VideoAdPlayerUI.a(this.pkW).olx.omz) / 1000L);
        }
      }
      paramView = new com.tencent.mm.modelstat.i(13228, "1,1," + i + "," + VideoAdPlayerUI.f(this.pkW) + "," + VideoAdPlayerUI.g(this.pkW) + "," + bk.UX() + "," + VideoAdPlayerUI.h(this.pkW) + "," + VideoAdPlayerUI.i(this.pkW), (int)bk.UX());
      g.DQ();
      g.DO().dJT.a(paramView, 0);
    }
    this.pkW.finish();
    paramView = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_snsad_statextstr", VideoAdPlayerUI.y(this.pkW));
    paramView.putExtra("jsapiargs", localBundle);
    paramView.putExtra("rawUrl", VideoAdPlayerUI.z(this.pkW));
    paramView.putExtra("useJs", true);
    if (VideoAdPlayerUI.A(this.pkW)) {
      com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(0, 6, VideoAdPlayerUI.B(this.pkW).field_snsId, 18, 0));
    }
    new ah(Looper.getMainLooper()).post(new VideoAdPlayerUI.4.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.4
 * JD-Core Version:    0.7.0.1
 */