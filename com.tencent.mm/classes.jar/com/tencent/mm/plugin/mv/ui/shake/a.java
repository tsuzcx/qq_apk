package com.tencent.mm.plugin.mv.ui.shake;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.l;
import com.tencent.mm.plugin.mv.model.a.b;
import com.tencent.mm.protocal.protobuf.boo;

public final class a
{
  boo Gbe;
  b McM;
  
  static void a(com.tencent.mm.plugin.music.model.e.a parama, boo paramboo)
  {
    paramboo.songName = parama.field_songName;
    paramboo.rDl = parama.field_songSinger;
    paramboo.ZWR = parama.field_songWebUrl;
    paramboo.ZWQ = "wx5aa333606550dfd5";
    paramboo.musicDataUrl = parama.field_songWifiUrl;
    paramboo.ZWS = parama.field_songHAlbumUrl;
    paramboo.albumName = parama.field_songAlbum;
    paramboo.mLQ = parama.field_originMusicId;
    paramboo.oOZ = parama.field_mid;
  }
  
  public final boo be(Activity paramActivity)
  {
    AppMethodBeat.i(287381);
    if (this.Gbe == null)
    {
      l locall = l.LMH;
      paramActivity = l.bb(paramActivity);
      this.Gbe = new boo();
      if (paramActivity != null) {
        a(paramActivity, this.Gbe);
      }
    }
    paramActivity = this.Gbe;
    AppMethodBeat.o(287381);
    return paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.shake.a
 * JD-Core Version:    0.7.0.1
 */