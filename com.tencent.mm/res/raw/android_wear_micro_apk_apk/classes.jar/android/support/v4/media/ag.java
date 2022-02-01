package android.support.v4.media;

import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.i;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;

final class ag
  extends Handler
{
  private final ad jw = new ad(this.iY);
  
  ag(MediaBrowserServiceCompat paramMediaBrowserServiceCompat) {}
  
  private void c(Runnable paramRunnable)
  {
    if (Thread.currentThread() == getLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    post(paramRunnable);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int k = 0;
    Object localObject1 = paramMessage.getData();
    switch (paramMessage.what)
    {
    default: 
      Log.w("MBServiceCompat", "Unhandled message: " + paramMessage + "\n  Service version: 2\n  Client version: " + paramMessage.arg1);
    }
    ad localad;
    String str;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
          localad = this.jw;
          str = ((Bundle)localObject1).getString("data_package_name");
          int m = ((Bundle)localObject1).getInt("data_calling_uid");
          localObject1 = ((Bundle)localObject1).getBundle("data_root_hints");
          paramMessage = new af(paramMessage.replyTo);
          localObject2 = localad.iY;
          int j = k;
          int n;
          int i;
          if (str != null)
          {
            localObject2 = ((MediaBrowserServiceCompat)localObject2).getPackageManager().getPackagesForUid(m);
            n = localObject2.length;
            i = 0;
          }
          for (;;)
          {
            j = k;
            if (i < n)
            {
              if (localObject2[i].equals(str)) {
                j = 1;
              }
            }
            else
            {
              if (j != 0) {
                break;
              }
              throw new IllegalArgumentException("Package/uid mismatch: uid=" + m + " package=" + str);
            }
            i += 1;
          }
          localad.iY.iT.c(new ad.1(localad, paramMessage, str, (Bundle)localObject1, m));
          return;
          localObject1 = this.jw;
          paramMessage = new af(paramMessage.replyTo);
          ((ad)localObject1).iY.iT.c(new ad.2((ad)localObject1, paramMessage));
          return;
          localad = this.jw;
          str = ((Bundle)localObject1).getString("data_media_item_id");
          localObject2 = i.a((Bundle)localObject1, "data_callback_token");
          localObject1 = ((Bundle)localObject1).getBundle("data_options");
          paramMessage = new af(paramMessage.replyTo);
          localad.iY.iT.c(new ad.3(localad, paramMessage, str, (IBinder)localObject2, (Bundle)localObject1));
          return;
          localad = this.jw;
          str = ((Bundle)localObject1).getString("data_media_item_id");
          localObject1 = i.a((Bundle)localObject1, "data_callback_token");
          paramMessage = new af(paramMessage.replyTo);
          localad.iY.iT.c(new ad.4(localad, paramMessage, str, (IBinder)localObject1));
          return;
          localad = this.jw;
          str = ((Bundle)localObject1).getString("data_media_item_id");
          localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
          paramMessage = new af(paramMessage.replyTo);
        } while ((TextUtils.isEmpty(str)) || (localObject1 == null));
        localad.iY.iT.c(new ad.5(localad, paramMessage, str, (ResultReceiver)localObject1));
        return;
        localad = this.jw;
        paramMessage = new af(paramMessage.replyTo);
        localObject1 = ((Bundle)localObject1).getBundle("data_root_hints");
        localad.iY.iT.c(new ad.6(localad, paramMessage, (Bundle)localObject1));
        return;
        localObject1 = this.jw;
        paramMessage = new af(paramMessage.replyTo);
        ((ad)localObject1).iY.iT.c(new ad.7((ad)localObject1, paramMessage));
        return;
        localad = this.jw;
        str = ((Bundle)localObject1).getString("data_search_query");
        localObject2 = ((Bundle)localObject1).getBundle("data_search_extras");
        localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
        paramMessage = new af(paramMessage.replyTo);
      } while ((TextUtils.isEmpty(str)) || (localObject1 == null));
      localad.iY.iT.c(new ad.8(localad, paramMessage, str, (Bundle)localObject2, (ResultReceiver)localObject1));
      return;
      localad = this.jw;
      str = ((Bundle)localObject1).getString("data_custom_action");
      localObject2 = ((Bundle)localObject1).getBundle("data_custom_action_extras");
      localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
      paramMessage = new af(paramMessage.replyTo);
    } while ((TextUtils.isEmpty(str)) || (localObject1 == null));
    localad.iY.iT.c(new ad.9(localad, paramMessage, str, (Bundle)localObject2, (ResultReceiver)localObject1));
  }
  
  public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    Bundle localBundle = paramMessage.getData();
    localBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
    localBundle.putInt("data_calling_uid", Binder.getCallingUid());
    return super.sendMessageAtTime(paramMessage, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.ag
 * JD-Core Version:    0.7.0.1
 */