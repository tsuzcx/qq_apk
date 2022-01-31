package com.tencent.mm.ui.chatting.gallery;

import android.os.Process;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.chatting.e.a.a;

final class MediaHistoryGalleryUI$3
  extends RecyclerView.m
{
  private Runnable kGn;
  
  MediaHistoryGalleryUI$3(MediaHistoryGalleryUI paramMediaHistoryGalleryUI)
  {
    AppMethodBeat.i(32408);
    this.kGn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(32407);
        Animation localAnimation = AnimationUtils.loadAnimation(MediaHistoryGalleryUI.3.this.zNW.getContext(), 2131034182);
        MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.3.this.zNW).startAnimation(localAnimation);
        MediaHistoryGalleryUI.b(MediaHistoryGalleryUI.3.this.zNW).setVisibility(8);
        AppMethodBeat.o(32407);
      }
    };
    AppMethodBeat.o(32408);
  }
  
  private void gh(boolean paramBoolean)
  {
    AppMethodBeat.i(32409);
    if (paramBoolean)
    {
      MediaHistoryGalleryUI.b(this.zNW).removeCallbacks(this.kGn);
      if (MediaHistoryGalleryUI.b(this.zNW).getVisibility() != 0)
      {
        MediaHistoryGalleryUI.b(this.zNW).clearAnimation();
        Animation localAnimation = AnimationUtils.loadAnimation(this.zNW.getContext(), 2131034181);
        MediaHistoryGalleryUI.b(this.zNW).setVisibility(0);
        MediaHistoryGalleryUI.b(this.zNW).startAnimation(localAnimation);
        AppMethodBeat.o(32409);
      }
    }
    else
    {
      MediaHistoryGalleryUI.b(this.zNW).removeCallbacks(this.kGn);
      MediaHistoryGalleryUI.b(this.zNW).postDelayed(this.kGn, 256L);
    }
    AppMethodBeat.o(32409);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32410);
    super.a(paramRecyclerView, paramInt1, paramInt2);
    Object localObject = (LinearLayoutManager)MediaHistoryGalleryUI.c(this.zNW).bgA();
    paramRecyclerView = (b)MediaHistoryGalleryUI.c(this.zNW).byo();
    localObject = paramRecyclerView.PC(((LinearLayoutManager)localObject).it());
    if (localObject == null)
    {
      AppMethodBeat.o(32410);
      return;
    }
    paramRecyclerView = paramRecyclerView.in(((b.c)localObject).timeStamp);
    MediaHistoryGalleryUI.b(this.zNW).setText(bo.bf(paramRecyclerView, ""));
    AppMethodBeat.o(32410);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(32411);
    int i;
    if (1 == paramInt)
    {
      gh(true);
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMediaGalleryScrollEnable, MediaHistoryGalleryUI.d(this.zNW));
      MediaHistoryGalleryUI localMediaHistoryGalleryUI = this.zNW;
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
        if ((((LinearLayoutManager)paramRecyclerView.getLayoutManager()).it() == 0) && (!MediaHistoryGalleryUI.e(this.zNW)) && (MediaHistoryGalleryUI.c(this.zNW) != null)) {
          MediaHistoryGalleryUI.c(this.zNW).v(false, -1);
        }
        MediaHistoryGalleryUI.f(this.zNW);
        o.ahG().bX(paramInt);
      }
      AppMethodBeat.o(32411);
      return;
      i = 0;
      break;
      if (paramInt == 0) {
        gh(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.3
 * JD-Core Version:    0.7.0.1
 */