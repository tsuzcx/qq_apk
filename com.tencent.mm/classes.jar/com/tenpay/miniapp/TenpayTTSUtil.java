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
    AppMethodBeat.i(208607);
    if (sTts != null)
    {
      sTts.stop();
      sTts.shutdown();
      sTts = null;
    }
    AppMethodBeat.o(208607);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(208583);
    if (sTts == null) {
      sTts = new TextToSpeech(paramContext.getApplicationContext(), null);
    }
    AppMethodBeat.o(208583);
  }
  
  public static void setEnabled(boolean paramBoolean)
  {
    sEnabled = paramBoolean;
  }
  
  public static void speak(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(208594);
    if ((sEnabled) && (sTts != null) && (!TextUtils.isEmpty(paramCharSequence))) {
      sTts.speak(paramCharSequence.toString(), 1, null);
    }
    AppMethodBeat.o(208594);
  }
  
  public static void speak(String paramString)
  {
    AppMethodBeat.i(208590);
    if ((sEnabled) && (sTts != null) && (!TextUtils.isEmpty(paramString))) {
      sTts.speak(paramString, 1, null);
    }
    AppMethodBeat.o(208590);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(208599);
    if (sTts != null) {
      sTts.stop();
    }
    AppMethodBeat.o(208599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tenpay.miniapp.TenpayTTSUtil
 * JD-Core Version:    0.7.0.1
 */