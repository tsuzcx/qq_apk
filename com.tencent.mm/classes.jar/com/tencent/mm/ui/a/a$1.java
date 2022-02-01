package com.tencent.mm.ui.a;

import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Locale;

final class a$1
  implements TextToSpeech.OnInitListener
{
  a$1(a parama, String paramString) {}
  
  public final void onInit(int paramInt)
  {
    AppMethodBeat.i(141492);
    TextToSpeech localTextToSpeech;
    if (this.JgS.JgP != null)
    {
      localTextToSpeech = this.JgS.JgP;
      if (!ac.fko()) {
        break label62;
      }
    }
    label62:
    for (Locale localLocale = Locale.CHINESE;; localLocale = Locale.ENGLISH)
    {
      localTextToSpeech.setLanguage(localLocale);
      this.JgS.JgP.speak(this.ilu, 0, null);
      AppMethodBeat.o(141492);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.a.a.1
 * JD-Core Version:    0.7.0.1
 */