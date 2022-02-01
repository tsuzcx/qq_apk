package com.tenpay.android.wechat;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TenpayTTSUtil
{
  private static boolean sEnabled = true;
  private static TextToSpeech sTts;
  
  public static void destroy()
  {
    AppMethodBeat.i(130963);
    if (sTts != null)
    {
      sTts.stop();
      sTts.shutdown();
      sTts = null;
    }
    AppMethodBeat.o(130963);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(130959);
    if (sTts == null) {
      sTts = new TextToSpeech(paramContext.getApplicationContext(), null);
    }
    AppMethodBeat.o(130959);
  }
  
  public static void setEnabled(boolean paramBoolean)
  {
    sEnabled = paramBoolean;
  }
  
  public static void speak(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(130961);
    if ((sEnabled) && (sTts != null) && (!TextUtils.isEmpty(paramCharSequence))) {
      sTts.speak(paramCharSequence.toString(), 1, null);
    }
    AppMethodBeat.o(130961);
  }
  
  public static void speak(String paramString)
  {
    AppMethodBeat.i(130960);
    if ((sEnabled) && (sTts != null) && (!TextUtils.isEmpty(paramString))) {
      sTts.speak(paramString, 1, null);
    }
    AppMethodBeat.o(130960);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(130962);
    if (sTts != null) {
      sTts.stop();
    }
    AppMethodBeat.o(130962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tenpay.android.wechat.TenpayTTSUtil
 * JD-Core Version:    0.7.0.1
 */