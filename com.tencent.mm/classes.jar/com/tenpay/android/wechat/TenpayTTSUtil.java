package com.tenpay.android.wechat;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;

public class TenpayTTSUtil
{
  private static boolean sEnabled = true;
  private static TextToSpeech sTts;
  
  public static void destroy()
  {
    if (sTts != null)
    {
      sTts.stop();
      sTts.shutdown();
      sTts = null;
    }
  }
  
  public static void init(Context paramContext)
  {
    if (sTts == null) {
      sTts = new TextToSpeech(paramContext.getApplicationContext(), null);
    }
  }
  
  public static void setEnabled(boolean paramBoolean)
  {
    sEnabled = paramBoolean;
  }
  
  public static void speak(CharSequence paramCharSequence)
  {
    if ((sEnabled) && (sTts != null) && (!TextUtils.isEmpty(paramCharSequence))) {
      sTts.speak(paramCharSequence.toString(), 1, null);
    }
  }
  
  public static void speak(String paramString)
  {
    if ((sEnabled) && (sTts != null) && (!TextUtils.isEmpty(paramString))) {
      sTts.speak(paramString, 1, null);
    }
  }
  
  public static void stop()
  {
    if (sTts != null) {
      sTts.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tenpay.android.wechat.TenpayTTSUtil
 * JD-Core Version:    0.7.0.1
 */