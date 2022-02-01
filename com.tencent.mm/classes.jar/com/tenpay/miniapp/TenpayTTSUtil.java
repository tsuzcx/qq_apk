package com.tenpay.miniapp;

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
    AppMethodBeat.i(231275);
    if (sTts != null)
    {
      sTts.stop();
      sTts.shutdown();
      sTts = null;
    }
    AppMethodBeat.o(231275);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(231266);
    if (sTts == null) {
      sTts = new TextToSpeech(paramContext.getApplicationContext(), null);
    }
    AppMethodBeat.o(231266);
  }
  
  public static void setEnabled(boolean paramBoolean)
  {
    sEnabled = paramBoolean;
  }
  
  public static void speak(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(231271);
    if ((sEnabled) && (sTts != null) && (!TextUtils.isEmpty(paramCharSequence))) {
      sTts.speak(paramCharSequence.toString(), 1, null);
    }
    AppMethodBeat.o(231271);
  }
  
  public static void speak(String paramString)
  {
    AppMethodBeat.i(231268);
    if ((sEnabled) && (sTts != null) && (!TextUtils.isEmpty(paramString))) {
      sTts.speak(paramString, 1, null);
    }
    AppMethodBeat.o(231268);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(231274);
    if (sTts != null) {
      sTts.stop();
    }
    AppMethodBeat.o(231274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tenpay.miniapp.TenpayTTSUtil
 * JD-Core Version:    0.7.0.1
 */