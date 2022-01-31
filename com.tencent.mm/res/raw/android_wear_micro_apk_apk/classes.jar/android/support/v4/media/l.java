package android.support.v4.media;

import android.os.Bundle;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat.Token;

abstract interface l
{
  public abstract void a(Messenger paramMessenger, String paramString, Bundle paramBundle);
  
  public abstract void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle);
  
  public abstract void b(Messenger paramMessenger);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.l
 * JD-Core Version:    0.7.0.1
 */