package com.tencent.mm.wear.app.ui.message;

import android.app.RemoteInput;
import android.os.Bundle;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.g.b;
import com.tencent.mm.wear.app.ui.MMActivity;

public class OverseaReplyTextUI
  extends MMActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = RemoteInput.getResultsFromIntent(getIntent());
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getCharSequence("oversea_voice_reply");; paramBundle = null)
    {
      if (paramBundle != null) {
        h.mP().a(new a(this, paramBundle.toString()));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.OverseaReplyTextUI
 * JD-Core Version:    0.7.0.1
 */