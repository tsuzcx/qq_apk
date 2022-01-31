package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;

class DefaultLoader$1
  implements Handler.Callback
{
  DefaultLoader$1(DefaultLoader paramDefaultLoader, Loader.Listener paramListener) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.val$listener == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      DefaultLoader.access$002(this.this$0, false);
      Logger.i("DefaultLoader", "[handleMessage] loading = false");
      switch (paramMessage.what)
      {
      default: 
        return false;
      case 3: 
        this.val$listener.onLoadCompleted();
        return true;
      }
      break;
    }
    this.val$listener.onLoadProgress(paramMessage.arg1, paramMessage.arg2);
    return true;
    this.val$listener.onLoadError((IOException)paramMessage.obj);
    return true;
    this.val$listener.onLoadCancelled(DefaultLoader.access$100(this.this$0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader.1
 * JD-Core Version:    0.7.0.1
 */