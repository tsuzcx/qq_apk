package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession.Token;
import android.os.Handler;
import android.os.RemoteException;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MediaControllerCompat$MediaControllerImplApi21
  implements l
{
  protected final Object jZ;
  private final List<h> ka = new ArrayList();
  private d kb;
  private HashMap<h, m> kc = new HashMap();
  
  public MediaControllerCompat$MediaControllerImplApi21(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    this.jZ = new MediaController(paramContext, (MediaSession.Token)paramToken.bt());
    if (this.jZ == null) {
      throw new RemoteException();
    }
    this.kb = paramToken.bu();
    if (this.kb == null)
    {
      paramContext = new MediaControllerCompat.MediaControllerImplApi21.ExtraBinderRequestResultReceiver(this, new Handler());
      ((MediaController)this.jZ).sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, paramContext);
    }
  }
  
  public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
  {
    return ((MediaController)this.jZ).dispatchMediaButtonEvent(paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21
 * JD-Core Version:    0.7.0.1
 */