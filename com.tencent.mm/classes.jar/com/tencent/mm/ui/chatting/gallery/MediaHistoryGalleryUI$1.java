package com.tencent.mm.ui.chatting.gallery;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MediaHistoryGalleryUI$1
  extends RecyclerView.l
{
  MediaHistoryGalleryUI$1(MediaHistoryGalleryUI paramMediaHistoryGalleryUI)
  {
    AppMethodBeat.i(36345);
    AppMethodBeat.o(36345);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(233455);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt);
    a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    AppMethodBeat.o(233455);
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233454);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt1);
    localb.pH(paramInt2);
    a.b("com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/ui/chatting/gallery/MediaHistoryGalleryUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(233454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.1
 * JD-Core Version:    0.7.0.1
 */