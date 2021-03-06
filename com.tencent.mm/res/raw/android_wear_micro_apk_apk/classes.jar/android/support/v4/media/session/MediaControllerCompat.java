package android.support.v4.media.session;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import java.util.HashSet;

public final class MediaControllerCompat
{
  private final l jR;
  private final MediaSessionCompat.Token jS;
  private final HashSet<h> jT = new HashSet();
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    if (paramToken == null) {
      throw new IllegalArgumentException("sessionToken must not be null");
    }
    this.jS = paramToken;
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.jR = new o(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.jR = new n(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jR = new MediaControllerCompat.MediaControllerImplApi21(paramContext, paramToken);
      return;
    }
    this.jR = new p(this.jS);
  }
  
  public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent == null) {
      throw new IllegalArgumentException("KeyEvent may not be null");
    }
    return this.jR.dispatchMediaButtonEvent(paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat
 * JD-Core Version:    0.7.0.1
 */