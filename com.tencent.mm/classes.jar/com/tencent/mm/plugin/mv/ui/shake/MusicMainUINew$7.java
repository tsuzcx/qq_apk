package com.tencent.mm.plugin.mv.ui.shake;

import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.ui.MMActivity.a;

final class MusicMainUINew$7
  implements MMActivity.a
{
  MusicMainUINew$7(MusicMainUINew paramMusicMainUINew) {}
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(287360);
    if ((1 == paramInt1) && (paramInt2 == -1)) {
      Toast.makeText(this.McG.getContext(), this.McG.getContext().getResources().getString(b.h.share_ok), 0).show();
    }
    AppMethodBeat.o(287360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.shake.MusicMainUINew.7
 * JD-Core Version:    0.7.0.1
 */