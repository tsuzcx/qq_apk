package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class BaseVoicePrintUI$4
  implements ap.a
{
  BaseVoicePrintUI$4(BaseVoicePrintUI paramBaseVoicePrintUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(26133);
    Object localObject2 = BaseVoicePrintUI.c(this.trX);
    if (((VoiceTipInfoView)localObject2).pBu.getAnimation() == null)
    {
      TextView localTextView = ((VoiceTipInfoView)localObject2).pBu;
      Object localObject1 = ((VoiceTipInfoView)localObject2).getContext();
      localObject2 = new VoiceTipInfoView.1((VoiceTipInfoView)localObject2);
      float f = localTextView.getWidth();
      ab.d("MicroMsg.VoiceViewAnimationHelper", "target ".concat(String.valueOf(f)));
      int[] arrayOfInt = new int[2];
      localTextView.getLocationInWindow(arrayOfInt);
      int i = (int)(f + arrayOfInt[0]);
      ab.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(i) });
      localObject1 = AnimationUtils.loadAnimation((Context)localObject1, 2131034280);
      ((Animation)localObject1).setDuration(200L);
      ((Animation)localObject1).setStartOffset(0L);
      ((Animation)localObject1).setRepeatCount(0);
      ((Animation)localObject1).setFillAfter(true);
      ((Animation)localObject1).setAnimationListener(new a.1((a.a)localObject2));
      localTextView.startAnimation((Animation)localObject1);
    }
    AppMethodBeat.o(26133);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.4
 * JD-Core Version:    0.7.0.1
 */