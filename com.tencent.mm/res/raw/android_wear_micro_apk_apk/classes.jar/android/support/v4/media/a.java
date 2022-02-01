package android.support.v4.media;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.util.Log;
import java.lang.ref.WeakReference;

final class a
  extends Handler
{
  private final WeakReference<l> il;
  private WeakReference<Messenger> im;
  
  a(l paraml)
  {
    this.il = new WeakReference(paraml);
  }
  
  final void a(Messenger paramMessenger)
  {
    this.im = new WeakReference(paramMessenger);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.im == null) || (this.im.get() == null) || (this.il.get() == null)) {
      return;
    }
    Bundle localBundle = paramMessage.getData();
    localBundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
    l locall = (l)this.il.get();
    Messenger localMessenger = (Messenger)this.im.get();
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 1: 
          Log.w("MediaBrowserCompat", "Unhandled message: " + paramMessage + "\n  Client version: 1\n  Service version: " + paramMessage.arg1);
          return;
        }
      }
      catch (BadParcelableException localBadParcelableException)
      {
        Log.e("MediaBrowserCompat", "Could not unparcel the data.");
      }
      if (paramMessage.what != 1) {
        break;
      }
      locall.b(localMessenger);
      return;
      locall.a(localMessenger, localBadParcelableException.getString("data_media_item_id"), (MediaSessionCompat.Token)localBadParcelableException.getParcelable("data_media_session_token"), localBadParcelableException.getBundle("data_root_hints"));
      return;
      locall.b(localMessenger);
      return;
      String str = localBadParcelableException.getString("data_media_item_id");
      localBadParcelableException.getParcelableArrayList("data_media_item_list");
      locall.a(localMessenger, str, localBadParcelableException.getBundle("data_options"));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.a
 * JD-Core Version:    0.7.0.1
 */