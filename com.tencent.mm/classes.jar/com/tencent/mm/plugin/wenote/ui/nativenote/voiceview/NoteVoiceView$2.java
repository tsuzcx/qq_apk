package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.h;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.List;

final class NoteVoiceView$2
  implements View.OnClickListener
{
  NoteVoiceView$2(NoteVoiceView paramNoteVoiceView) {}
  
  public final void onClick(View paramView)
  {
    if ((com.tencent.mm.r.a.bk(paramView.getContext())) || (com.tencent.mm.r.a.bi(paramView.getContext()))) {
      return;
    }
    if ((!f.zF()) && (!bk.bl(NoteVoiceView.h(this.rNL))))
    {
      s.gM(paramView.getContext());
      return;
    }
    if (!bk.aM(NoteVoiceView.h(this.rNL), "").equals(NoteVoiceView.i(this.rNL).path))
    {
      NoteVoiceView.j(this.rNL);
      return;
    }
    if (NoteVoiceView.i(this.rNL).aQk())
    {
      paramView = this.rNL;
      y.i("MicroMsg.NoteVoiceView", "pause play");
      localObject = paramView.rNJ;
      y.i("MicroMsg.RecordVoiceHelper", "pause play");
      ag.Zn("keep_app_silent");
      if (((a)localObject).jZC == null) {
        y.w("MicroMsg.RecordVoiceHelper", "pause play error, player is null");
      }
      for (;;)
      {
        localObject = paramView.rNK;
        ((NoteVoiceView.a)localObject).isPaused = true;
        ((NoteVoiceView.a)localObject).removeMessages(4096);
        NoteVoiceView.c(((NoteVoiceView.a)localObject).rNL).setImageResource(R.k.voicepost_beginicon);
        NoteVoiceView.c(((NoteVoiceView.a)localObject).rNL).setContentDescription(((NoteVoiceView.a)localObject).rNL.getContext().getResources().getString(R.l.app_play));
        paramView.kdB.setKeepScreenOn(false);
        return;
        if (((a)localObject).jZC.pause())
        {
          localObject = ((a)localObject).dhm.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((Iterator)localObject).next();
          }
        }
      }
    }
    paramView = this.rNL;
    y.i("MicroMsg.NoteVoiceView", "resume play");
    Object localObject = paramView.rNJ;
    y.i("MicroMsg.RecordVoiceHelper", "resume play");
    ag.Zm("keep_app_silent");
    int i;
    if (((a)localObject).jZC == null)
    {
      y.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
      i = 0;
    }
    boolean bool;
    do
    {
      localObject = paramView.rNK;
      ((NoteVoiceView.a)localObject).isPaused = false;
      ((NoteVoiceView.a)localObject).sendEmptyMessage(4096);
      NoteVoiceView.c(((NoteVoiceView.a)localObject).rNL).setImageResource(R.k.voicepost_pauseicon);
      NoteVoiceView.c(((NoteVoiceView.a)localObject).rNL).setContentDescription(((NoteVoiceView.a)localObject).rNL.getContext().getResources().getString(R.l.app_pause));
      paramView.kdB.setKeepScreenOn(true);
      if (i != 0) {
        break;
      }
      NoteVoiceView.j(this.rNL);
      return;
      bool = ((a)localObject).jZC.ub();
      i = bool;
    } while (!bool);
    localObject = ((a)localObject).dhm.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView.2
 * JD-Core Version:    0.7.0.1
 */