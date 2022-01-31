package com.tencent.mm.plugin.sns.ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.el;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class ArtistUI$5
  implements f.a
{
  ArtistUI$5(ArtistUI paramArtistUI) {}
  
  public final void a(el paramel)
  {
    if (ArtistUI.c(this.oNf) != null)
    {
      ArtistUI.c(this.oNf).setVisibility(0);
      ArtistUI.c(this.oNf).setUserName(paramel);
      paramel = paramel.kRZ;
      if ((paramel != null) && (!paramel.equals(""))) {
        ArtistUI.d(this.oNf).edit().putString("artist_name", paramel).commit();
      }
      if (ArtistUI.a(this.oNf) != null) {
        ArtistUI.a(this.oNf).notifyDataSetChanged();
      }
    }
    ArtistUI.e(this.oNf).dismiss();
  }
  
  public final void b(el paramel)
  {
    if (ArtistUI.c(this.oNf) != null)
    {
      ArtistUI.c(this.oNf).setVisibility(0);
      ArtistUI.c(this.oNf).setUserName(paramel);
    }
  }
  
  public final void bHh()
  {
    if ((ArtistUI.f(this.oNf) == null) && (ArtistUI.e(this.oNf) != null))
    {
      y.d("MicroMsg.ArtistUI", "onNothingBgGet");
      a.eUS.aQ(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistUI.5
 * JD-Core Version:    0.7.0.1
 */