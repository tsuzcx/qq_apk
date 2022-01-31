package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.sdk.platformtools.ah;

public final class NoteVoiceView$a
  extends ah
{
  boolean isPaused;
  float kdG;
  float kdH;
  int kdI;
  int kdJ;
  
  private NoteVoiceView$a(NoteVoiceView paramNoteVoiceView) {}
  
  @SuppressLint({"ResourceType"})
  public final void Du(int paramInt)
  {
    this.isPaused = false;
    this.kdG = b.eu(paramInt);
    this.kdH = this.kdG;
    this.kdJ = a.fromDPToPix(this.rNL.getContext(), 0);
    NoteVoiceView.a(this.rNL).setText(j.x(this.rNL.getContext(), (int)(this.kdG - this.kdH)));
    NoteVoiceView.b(this.rNL).setText(j.x(this.rNL.getContext(), (int)this.kdG));
    NoteVoiceView.c(this.rNL).setImageResource(R.k.voicepost_beginicon);
    NoteVoiceView.c(this.rNL).setContentDescription(this.rNL.getContext().getResources().getString(R.l.app_play));
    NoteVoiceView.d(this.rNL).setWidth(this.kdJ);
  }
  
  public final void aRr()
  {
    this.kdI = ((int)((1.0F - this.kdH / this.kdG) * (NoteVoiceView.f(this.rNL).getWidth() - this.kdJ)) + this.kdJ);
    NoteVoiceView.a(this.rNL).setText(j.x(this.rNL.getContext(), (int)(this.kdG - this.kdH)));
    NoteVoiceView.b(this.rNL).setText(j.x(this.rNL.getContext(), (int)this.kdG));
    NoteVoiceView.d(this.rNL).setWidth(this.kdI);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    this.kdH = Math.max(0.0F, this.kdH - 0.256F);
    aRr();
    if (this.kdH <= 0.1F) {
      return;
    }
    sendEmptyMessageDelayed(4096, 256L);
  }
  
  @SuppressLint({"ResourceType"})
  public final void lK(boolean paramBoolean)
  {
    this.kdJ = a.fromDPToPix(this.rNL.getContext(), 0);
    NoteVoiceView.c(this.rNL).setImageResource(R.k.voicepost_beginicon);
    NoteVoiceView.c(this.rNL).setContentDescription(this.rNL.getContext().getResources().getString(R.l.app_play));
    aRr();
    if (paramBoolean)
    {
      NoteVoiceView.c(this.rNL).setImageResource(R.k.voicepost_pauseicon);
      NoteVoiceView.c(this.rNL).setContentDescription(this.rNL.getContext().getResources().getString(R.l.app_pause));
      sendEmptyMessage(4096);
    }
  }
  
  public final void stop()
  {
    this.isPaused = false;
    removeMessages(4096);
    Du(NoteVoiceView.e(this.rNL));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView.a
 * JD-Core Version:    0.7.0.1
 */