package com.tencent.mm.plugin.sns.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.sdk.platformtools.ak;

final class ArtistUI$6
  implements AbsListView.OnScrollListener
{
  ArtistUI$6(ArtistUI paramArtistUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(38120);
    if (paramInt == 2)
    {
      if ((this.rEQ.rEM.rdd) || (this.rEQ.rEN.rdd))
      {
        this.rEQ.loX.removeCallbacks(ArtistUI.g(this.rEQ));
        this.rEQ.loX.removeCallbacks(ArtistUI.h(this.rEQ));
        this.rEQ.loX.postDelayed(ArtistUI.g(this.rEQ), 0L);
        AppMethodBeat.o(38120);
      }
    }
    else
    {
      if ((this.rEQ.rEM.rdd) && (this.rEQ.rEN.rdd))
      {
        AppMethodBeat.o(38120);
        return;
      }
      this.rEQ.loX.removeCallbacks(ArtistUI.g(this.rEQ));
      this.rEQ.loX.removeCallbacks(ArtistUI.h(this.rEQ));
      this.rEQ.loX.postDelayed(ArtistUI.h(this.rEQ), 0L);
    }
    AppMethodBeat.o(38120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistUI.6
 * JD-Core Version:    0.7.0.1
 */