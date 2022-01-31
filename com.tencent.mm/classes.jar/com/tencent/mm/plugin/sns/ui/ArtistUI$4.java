package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;

final class ArtistUI$4
  extends f.b
{
  ArtistUI$4(ArtistUI paramArtistUI) {}
  
  public final void yv(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_gallery_is_artist", true);
    localIntent.putExtra("sns_gallery_position", paramInt);
    localIntent.putExtra("sns_gallery_artist_lan", ArtistUI.b(this.oNf));
    localIntent.putExtra("sns_gallery_showtype", 2);
    localIntent.setClass(this.oNf, ArtistBrowseUI.class);
    this.oNf.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistUI.4
 * JD-Core Version:    0.7.0.1
 */