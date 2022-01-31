package android.support.v4.media;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.app.h;

final class m
{
  private Messenger gK;
  private Bundle gv;
  
  public m(IBinder paramIBinder, Bundle paramBundle)
  {
    this.gK = new Messenger(paramIBinder);
    this.gv = paramBundle;
  }
  
  private void a(int paramInt, Bundle paramBundle, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localMessage.arg1 = 1;
    localMessage.setData(paramBundle);
    localMessage.replyTo = paramMessenger;
    this.gK.send(localMessage);
  }
  
  final void a(Context paramContext, Messenger paramMessenger)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("data_package_name", paramContext.getPackageName());
    localBundle.putBundle("data_root_hints", this.gv);
    a(1, localBundle, paramMessenger);
  }
  
  final void a(String paramString, IBinder paramIBinder, Bundle paramBundle, Messenger paramMessenger)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("data_media_item_id", paramString);
    h.a(localBundle, "data_callback_token", paramIBinder);
    localBundle.putBundle("data_options", paramBundle);
    a(3, localBundle, paramMessenger);
  }
  
  final void c(Messenger paramMessenger)
  {
    a(2, null, paramMessenger);
  }
  
  final void d(Messenger paramMessenger)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBundle("data_root_hints", this.gv);
    a(6, localBundle, paramMessenger);
  }
  
  final void e(Messenger paramMessenger)
  {
    a(7, null, paramMessenger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.m
 * JD-Core Version:    0.7.0.1
 */