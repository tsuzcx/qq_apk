package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;

final class NoteVoiceView$2
  implements View.OnClickListener
{
  NoteVoiceView$2(NoteVoiceView paramNoteVoiceView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27211);
    if ((com.tencent.mm.r.a.bO(paramView.getContext())) || (com.tencent.mm.r.a.bM(paramView.getContext())))
    {
      AppMethodBeat.o(27211);
      return;
    }
    if ((!f.Mi()) && (!bo.isNullOrNil(NoteVoiceView.h(this.vEp))))
    {
      t.ii(paramView.getContext());
      AppMethodBeat.o(27211);
      return;
    }
    if (!bo.bf(NoteVoiceView.h(this.vEp), "").equals(NoteVoiceView.i(this.vEp).path))
    {
      NoteVoiceView.j(this.vEp);
      AppMethodBeat.o(27211);
      return;
    }
    if (NoteVoiceView.i(this.vEp).bwz())
    {
      paramView = this.vEp;
      ab.i("MicroMsg.NoteVoiceView", "pause play");
      localObject = paramView.vEn;
      ab.i("MicroMsg.RecordVoiceHelper", "pause play");
      aj.apl("keep_app_silent");
      if (((a)localObject).mtU == null) {
        ab.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
      }
      for (;;)
      {
        localObject = paramView.vEo;
        ((NoteVoiceView.a)localObject).isPaused = true;
        ((NoteVoiceView.a)localObject).removeMessages(4096);
        NoteVoiceView.c(((NoteVoiceView.a)localObject).vEp).setImageResource(2131232175);
        NoteVoiceView.c(((NoteVoiceView.a)localObject).vEp).setContentDescription(((NoteVoiceView.a)localObject).vEp.getContext().getResources().getString(2131297039));
        paramView.myl.setKeepScreenOn(false);
        AppMethodBeat.o(27211);
        return;
        if (((a)localObject).mtU.pause())
        {
          localObject = ((a)localObject).callbacks.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((Iterator)localObject).next();
          }
        }
      }
    }
    paramView = this.vEp;
    ab.i("MicroMsg.NoteVoiceView", "resume play");
    Object localObject = paramView.vEn;
    ab.i("MicroMsg.RecordVoiceHelper", "resume play");
    aj.apk("keep_app_silent");
    int i;
    if (((a)localObject).mtU == null)
    {
      ab.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
      i = 0;
    }
    boolean bool;
    do
    {
      localObject = paramView.vEo;
      ((NoteVoiceView.a)localObject).isPaused = false;
      ((NoteVoiceView.a)localObject).sendEmptyMessage(4096);
      NoteVoiceView.c(((NoteVoiceView.a)localObject).vEp).setImageResource(2131232176);
      NoteVoiceView.c(((NoteVoiceView.a)localObject).vEp).setContentDescription(((NoteVoiceView.a)localObject).vEp.getContext().getResources().getString(2131297021));
      paramView.myl.setKeepScreenOn(true);
      if (i == 0) {
        NoteVoiceView.j(this.vEp);
      }
      AppMethodBeat.o(27211);
      return;
      bool = ((a)localObject).mtU.Eo();
      i = bool;
    } while (!bool);
    localObject = ((a)localObject).callbacks.iterator();
    for (;;)
    {
      i = bool;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      ((Iterator)localObject).next();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView.2
 * JD-Core Version:    0.7.0.1
 */