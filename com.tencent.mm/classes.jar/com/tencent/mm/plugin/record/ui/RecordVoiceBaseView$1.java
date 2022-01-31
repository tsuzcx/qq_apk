package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.record.b.m;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

final class RecordVoiceBaseView$1
  implements View.OnClickListener
{
  RecordVoiceBaseView$1(RecordVoiceBaseView paramRecordVoiceBaseView) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", new Object[] { RecordVoiceBaseView.a(this.nuq), Boolean.valueOf(RecordVoiceBaseView.b(this.nuq).aQk()) });
    if ((a.bk(RecordVoiceBaseView.c(this.nuq))) || (a.bi(RecordVoiceBaseView.c(this.nuq)))) {}
    do
    {
      return;
      if ((!f.zF()) && (!bk.bl(RecordVoiceBaseView.a(this.nuq))))
      {
        s.gM(paramView.getContext());
        return;
      }
      if (!bk.aM(RecordVoiceBaseView.a(this.nuq), "").equals(RecordVoiceBaseView.b(this.nuq).path))
      {
        RecordVoiceBaseView.d(this.nuq);
        return;
      }
      if (RecordVoiceBaseView.b(this.nuq).aQk())
      {
        this.nuq.stopPlay();
        return;
      }
    } while (RecordVoiceBaseView.e(this.nuq));
    RecordVoiceBaseView.d(this.nuq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordVoiceBaseView.1
 * JD-Core Version:    0.7.0.1
 */