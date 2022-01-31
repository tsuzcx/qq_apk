package com.tencent.mm.plugin.sns.ui.album;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.SnsUserUI;

final class SnsAlbumUI$4
  implements View.OnClickListener
{
  SnsAlbumUI$4(SnsAlbumUI paramSnsAlbumUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39989);
    paramView = new Intent(this.seK.getActivity(), SnsUserUI.class);
    paramView.putExtra("sns_userName", SnsAlbumUI.b(this.seK));
    this.seK.getActivity().startActivity(paramView);
    AppMethodBeat.o(39989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.4
 * JD-Core Version:    0.7.0.1
 */