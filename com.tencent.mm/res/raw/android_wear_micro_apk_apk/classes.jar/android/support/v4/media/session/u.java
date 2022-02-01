package android.support.v4.media.session;

import android.media.session.MediaSession.Token;

final class u
{
  public static Object n(Object paramObject)
  {
    if ((paramObject instanceof MediaSession.Token)) {
      return paramObject;
    }
    throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.u
 * JD-Core Version:    0.7.0.1
 */