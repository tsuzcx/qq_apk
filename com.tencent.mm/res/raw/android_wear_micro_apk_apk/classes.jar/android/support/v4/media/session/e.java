package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;

public abstract class e
  extends Binder
  implements d
{
  public static d b(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
    if ((localIInterface != null) && ((localIInterface instanceof d))) {
      return (d)localIInterface;
    }
    return new f(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int j = 0;
    int k = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 0;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("android.support.v4.media.session.IMediaSession");
      return true;
    case 1: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      String str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label520;
        }
      }
      for (paramParcel1 = (MediaSessionCompat.ResultReceiverWrapper)MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(str, (Bundle)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    case 2: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      if (paramParcel1.readInt() != 0)
      {
        paramParcel1 = (KeyEvent)KeyEvent.CREATOR.createFromParcel(paramParcel1);
        bool1 = a(paramParcel1);
        paramParcel2.writeNoException();
        if (!bool1) {
          break label581;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
        paramParcel1 = null;
        break;
      }
    case 3: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      a(b.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      b(b.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      bool1 = aP();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      paramParcel1 = getPackageName();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 7: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      paramParcel1 = getTag();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 8: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      paramParcel1 = aQ();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      long l = getFlags();
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    case 10: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      paramParcel1 = aR();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 11: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      a(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      b(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 27: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      paramParcel1 = aS();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 28: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      paramParcel1 = aT();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 29: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      paramParcel1 = getQueue();
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      return true;
    case 30: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      paramParcel1 = getQueueTitle();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        TextUtils.writeToParcel(paramParcel1, paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 31: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      paramParcel1 = getExtras();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 32: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      paramInt1 = getRatingType();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 45: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      bool1 = aU();
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 37: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      paramInt1 = getRepeatMode();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 38: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      bool1 = aV();
      paramParcel2.writeNoException();
      paramInt1 = k;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 47: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      paramInt1 = aW();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 41: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 42: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      if (paramParcel1.readInt() != 0) {}
      for (localObject = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel1);; localObject = null)
      {
        a((MediaDescriptionCompat)localObject, paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
    case 43: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        b(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 44: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      n(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 33: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      prepare();
      paramParcel2.writeNoException();
      return true;
    case 34: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      localObject = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        prepareFromMediaId((String)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 35: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      localObject = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        prepareFromSearch((String)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 36: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      if (paramParcel1.readInt() != 0)
      {
        localObject = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1512;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        prepareFromUri((Uri)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    case 13: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      play();
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      localObject = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        playFromMediaId((String)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 15: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      localObject = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        playFromSearch((String)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 16: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      if (paramParcel1.readInt() != 0)
      {
        localObject = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1699;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        playFromUri((Uri)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    case 17: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      skipToQueueItem(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 18: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      pause();
      paramParcel2.writeNoException();
      return true;
    case 19: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      stop();
      paramParcel2.writeNoException();
      return true;
    case 20: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      aX();
      paramParcel2.writeNoException();
      return true;
    case 21: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      aY();
      paramParcel2.writeNoException();
      return true;
    case 22: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      fastForward();
      paramParcel2.writeNoException();
      return true;
    case 23: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      rewind();
      paramParcel2.writeNoException();
      return true;
    case 24: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      seekTo(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 25: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (RatingCompat)RatingCompat.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 51: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      if (paramParcel1.readInt() != 0)
      {
        localObject = (RatingCompat)RatingCompat.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1948;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((RatingCompat)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    case 46: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      g(bool1);
      paramParcel2.writeNoException();
      return true;
    case 39: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      setRepeatMode(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 40: 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      bool1 = bool2;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      h(bool1);
      paramParcel2.writeNoException();
      return true;
    case 48: 
      label520:
      label581:
      label1512:
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
      label1699:
      o(paramParcel1.readInt());
      label1948:
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("android.support.v4.media.session.IMediaSession");
    Object localObject = paramParcel1.readString();
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      sendCustomAction((String)localObject, paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.e
 * JD-Core Version:    0.7.0.1
 */