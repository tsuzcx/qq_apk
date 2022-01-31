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
  protected final Object ia;
  private final List<h> ib = new ArrayList();
  private d ic;
  private HashMap<h, m> ie = new HashMap();
  
  public MediaControllerCompat$MediaControllerImplApi21(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    this.ia = new MediaController(paramContext, (MediaSession.Token)paramToken.bc());
    if (this.ia == null) {
      throw new RemoteException();
    }
    this.ic = paramToken.bd();
    if (this.ic == null)
    {
      paramContext = new MediaControllerCompat.MediaControllerImplApi21.ExtraBinderRequestResultReceiver(this, new Handler());
      ((MediaController)this.ia).sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, paramContext);
    }
  }
  
  public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
  {
    return ((MediaController)this.ia).dispatchMediaButtonEvent(paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21
 * JD-Core Version:    0.7.0.1
 */