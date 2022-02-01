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
    AppMethodBeat.i(99879);
    Object localObject = new Intent(this.xNS.getActivity(), SnsUserUI.class);
    ((Intent)localObject).putExtra("sns_rpt_scene", 21);
    ((Intent)localObject).putExtra("sns_userName", SnsAlbumUI.b(this.xNS));
    paramView = this.xNS.getActivity();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(99879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI.4
 * JD-Core Version:    0.7.0.1
 */