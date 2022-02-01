package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat.Token;
import java.util.ArrayList;
import java.util.List;

final class af
  implements ae
{
  final Messenger jv;
  
  af(Messenger paramMessenger)
  {
    this.jv = paramMessenger;
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localMessage.arg1 = 2;
    localMessage.setData(paramBundle);
    this.jv.send(localMessage);
  }
  
  public final void a(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("extra_service_version", 2);
    paramBundle = new Bundle();
    paramBundle.putString("data_media_item_id", paramString);
    paramBundle.putParcelable("data_media_session_token", paramToken);
    paramBundle.putBundle("data_root_hints", localBundle);
    a(1, paramBundle);
  }
  
  public final void a(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("data_media_item_id", paramString);
    localBundle.putBundle("data_options", paramBundle);
    if (paramList != null) {
      if (!(paramList instanceof ArrayList)) {
        break label57;
      }
    }
    label57:
    for (paramString = (ArrayList)paramList;; paramString = new ArrayList(paramList))
    {
      localBundle.putParcelableArrayList("data_media_item_list", paramString);
      a(3, localBundle);
      return;
    }
  }
  
  public final IBinder asBinder()
  {
    return this.jv.getBinder();
  }
  
  public final void bd()
  {
    a(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.af
 * JD-Core Version:    0.7.0.1
 */