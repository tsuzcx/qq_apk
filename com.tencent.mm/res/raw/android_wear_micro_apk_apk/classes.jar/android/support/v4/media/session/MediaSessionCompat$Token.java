package android.support.v4.media.session;

import android.media.session.MediaSession.Token;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class MediaSessionCompat$Token
  implements Parcelable
{
  public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator() {};
  private final d ic;
  private final Object iq;
  
  MediaSessionCompat$Token(Object paramObject)
  {
    this(paramObject, null);
  }
  
  private MediaSessionCompat$Token(Object paramObject, d paramd)
  {
    this.iq = paramObject;
    this.ic = paramd;
  }
  
  public static Token a(Object paramObject, d paramd)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      if ((paramObject instanceof MediaSession.Token)) {
        return new Token(paramObject, paramd);
      }
      throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
    return null;
  }
  
  public static Token g(Object paramObject)
  {
    return a(paramObject, null);
  }
  
  public final Object bc()
  {
    return this.iq;
  }
  
  public final d bd()
  {
    return this.ic;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Token)) {
        return false;
      }
      paramObject = (Token)paramObject;
      if (this.iq != null) {
        break;
      }
    } while (paramObject.iq == null);
    return false;
    if (paramObject.iq == null) {
      return false;
    }
    return this.iq.equals(paramObject.iq);
  }
  
  public final int hashCode()
  {
    if (this.iq == null) {
      return 0;
    }
    return this.iq.hashCode();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramParcel.writeParcelable((Parcelable)this.iq, paramInt);
      return;
    }
    paramParcel.writeStrongBinder((IBinder)this.iq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.Token
 * JD-Core Version:    0.7.0.1
 */