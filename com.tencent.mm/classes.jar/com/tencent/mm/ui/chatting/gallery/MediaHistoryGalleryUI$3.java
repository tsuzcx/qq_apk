package com.tencent.mm.ui.chatting.gallery;

import android.os.Process;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.s;

final class MediaHistoryGalleryUI$3
  extends RecyclerView.m
{
  private Runnable khx = new MediaHistoryGalleryUI.3.1(this);
  
  MediaHistoryGalleryUI$3(MediaHistoryGalleryUI paramMediaHistoryGalleryUI) {}
  
  private void gc(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      MediaHistoryGalleryUI.b(this.vxK).removeCallbacks(this.khx);
      if (MediaHistoryGalleryUI.b(this.vxK).getVisibility() != 0)
      {
        MediaHistoryGalleryUI.b(this.vxK).clearAnimation();
        Animation localAnimation = AnimationUtils.loadAnimation(this.vxK.mController.uMN, R.a.fast_faded_in);
        MediaHistoryGalleryUI.b(this.vxK).setVisibility(0);
        MediaHistoryGalleryUI.b(this.vxK).startAnimation(localAnimation);
      }
      return;
    }
    MediaHistoryGalleryUI.b(this.vxK).removeCallbacks(this.khx);
    MediaHistoryGalleryUI.b(this.vxK).postDelayed(this.khx, 256L);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.a(paramRecyclerView, paramInt1, paramInt2);
    Object localObject = (LinearLayoutManager)MediaHistoryGalleryUI.c(this.vxK).aRV();
    paramRecyclerView = (b)MediaHistoryGalleryUI.c(this.vxK).aRX();
    localObject = paramRecyclerView.GZ(((LinearLayoutManager)localObject).gY());
    if (localObject == null) {
      return;
    }
    paramRecyclerView = paramRecyclerView.eL(((b.c)localObject).timeStamp);
    MediaHistoryGalleryUI.b(this.vxK).setText(bk.aM(paramRecyclerView, ""));
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    int i;
    if (1 == paramInt)
    {
      gc(true);
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcMediaGalleryScrollEnable, MediaHistoryGalleryUI.d(this.vxK));
      MediaHistoryGalleryUI localMediaHistoryGalleryUI = this.vxK;
      boolean bool = WXHardCoderJNI.hcMediaGalleryScrollEnable;
      int j = WXHardCoderJNI.hcMediaGalleryScrollDelay;
      int k = WXHardCoderJNI.hcMediaGalleryScrollCPU;
      int m = WXHardCoderJNI.hcMediaGalleryScrollIO;
      if (WXHardCoderJNI.hcMediaGalleryScrollThr)
      {
        i = Process.myTid();
        MediaHistoryGalleryUI.a(localMediaHistoryGalleryUI, WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMediaGalleryScrollTimeout, 703, WXHardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI"));
      }
    }
    for (;;)
    {
      if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
      {
        if ((((LinearLayoutManager)paramRecyclerView.getLayoutManager()).gY() == 0) && (!MediaHistoryGalleryUI.e(this.vxK))) {
          MediaHistoryGalleryUI.c(this.vxK).l(false, -1);
        }
        MediaHistoryGalleryUI.f(this.vxK);
        o.ON().bR(paramInt);
      }
      return;
      i = 0;
      break;
      if (paramInt == 0) {
        gc(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.3
 * JD-Core Version:    0.7.0.1
 */