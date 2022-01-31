package com.tencent.mm.plugin.sns.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.sdk.platformtools.ah;

final class ArtistUI$6
  implements AbsListView.OnScrollListener
{
  ArtistUI$6(ArtistUI paramArtistUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 2) {
      if ((this.oNf.oNb.ooI) || (this.oNf.oNc.ooI))
      {
        this.oNf.jge.removeCallbacks(ArtistUI.g(this.oNf));
        this.oNf.jge.removeCallbacks(ArtistUI.h(this.oNf));
        this.oNf.jge.postDelayed(ArtistUI.g(this.oNf), 0L);
      }
    }
    while ((this.oNf.oNb.ooI) && (this.oNf.oNc.ooI)) {
      return;
    }
    this.oNf.jge.removeCallbacks(ArtistUI.g(this.oNf));
    this.oNf.jge.removeCallbacks(ArtistUI.h(this.oNf));
    this.oNf.jge.postDelayed(ArtistUI.h(this.oNf), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistUI.6
 * JD-Core Version:    0.7.0.1
 */