package com.tencent.mm.plugin.textstatus.third;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.y;
import com.tencent.mm.plugin.textstatus.proto.m;
import com.tencent.mm.plugin.textstatus.proto.q;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/third/TextStatusActionTask$jumpSetStatus$setStatusCallback$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusActionTask$jumpSetStatus$setStatusCallback$1
  extends ResultReceiver
{
  TextStatusActionTask$jumpSetStatus$setStatusCallback$1(l paraml)
  {
    super(null);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(290079);
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == -1) {}
    for (paramInt = 0;; paramInt = 2)
    {
      y localy = this.Tvd.Tvc;
      if (localy != null)
      {
        q localq = new q();
        localq.action = 2;
        m localm = new m();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getByteArray("select_status_info");
          if (paramBundle != null) {
            localm.parseFrom(paramBundle);
          }
        }
        paramBundle = ah.aiuX;
        localq.Tpn = localm;
        paramBundle = ah.aiuX;
        localy.onFinishAction(paramInt, "", localq);
      }
      AppMethodBeat.o(290079);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.TextStatusActionTask.jumpSetStatus.setStatusCallback.1
 * JD-Core Version:    0.7.0.1
 */