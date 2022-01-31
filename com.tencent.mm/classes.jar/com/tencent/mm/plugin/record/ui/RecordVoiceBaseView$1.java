package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.record.b.s;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

final class RecordVoiceBaseView$1
  implements View.OnClickListener
{
  RecordVoiceBaseView$1(RecordVoiceBaseView paramRecordVoiceBaseView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24324);
    ab.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", new Object[] { RecordVoiceBaseView.a(this.pZY), Boolean.valueOf(RecordVoiceBaseView.b(this.pZY).bwz()) });
    if ((a.bO(RecordVoiceBaseView.c(this.pZY))) || (a.bM(RecordVoiceBaseView.c(this.pZY))))
    {
      AppMethodBeat.o(24324);
      return;
    }
    if ((!f.Mi()) && (!bo.isNullOrNil(RecordVoiceBaseView.a(this.pZY))))
    {
      t.ii(paramView.getContext());
      AppMethodBeat.o(24324);
      return;
    }
    if (!bo.bf(RecordVoiceBaseView.a(this.pZY), "").equals(RecordVoiceBaseView.b(this.pZY).path))
    {
      RecordVoiceBaseView.d(this.pZY);
      AppMethodBeat.o(24324);
      return;
    }
    if (RecordVoiceBaseView.b(this.pZY).bwz())
    {
      this.pZY.stopPlay();
      AppMethodBeat.o(24324);
      return;
    }
    if (!RecordVoiceBaseView.e(this.pZY)) {
      RecordVoiceBaseView.d(this.pZY);
    }
    AppMethodBeat.o(24324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordVoiceBaseView.1
 * JD-Core Version:    0.7.0.1
 */