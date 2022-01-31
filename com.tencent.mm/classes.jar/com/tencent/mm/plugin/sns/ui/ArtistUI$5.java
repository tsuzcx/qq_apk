package com.tencent.mm.plugin.sns.ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

final class ArtistUI$5
  implements f.a
{
  ArtistUI$5(ArtistUI paramArtistUI) {}
  
  public final void a(fo paramfo)
  {
    AppMethodBeat.i(38117);
    if (ArtistUI.c(this.rEQ) != null)
    {
      ArtistUI.c(this.rEQ).setVisibility(0);
      ArtistUI.c(this.rEQ).setUserName(paramfo);
      paramfo = paramfo.Name;
      if ((paramfo != null) && (!paramfo.equals(""))) {
        ArtistUI.d(this.rEQ).edit().putString("artist_name", paramfo).commit();
      }
      if (ArtistUI.a(this.rEQ) != null) {
        ArtistUI.a(this.rEQ).notifyDataSetChanged();
      }
    }
    ArtistUI.e(this.rEQ).dismiss();
    AppMethodBeat.o(38117);
  }
  
  public final void b(fo paramfo)
  {
    AppMethodBeat.i(38118);
    if (ArtistUI.c(this.rEQ) != null)
    {
      ArtistUI.c(this.rEQ).setVisibility(0);
      ArtistUI.c(this.rEQ).setUserName(paramfo);
    }
    AppMethodBeat.o(38118);
  }
  
  public final void ctl()
  {
    AppMethodBeat.i(38119);
    if ((ArtistUI.f(this.rEQ) == null) && (ArtistUI.e(this.rEQ) != null))
    {
      ab.d("MicroMsg.ArtistUI", "onNothingBgGet");
      a.gmP.bs(true);
    }
    AppMethodBeat.o(38119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistUI.5
 * JD-Core Version:    0.7.0.1
 */