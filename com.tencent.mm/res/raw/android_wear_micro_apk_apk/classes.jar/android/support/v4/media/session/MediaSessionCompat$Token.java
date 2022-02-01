package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class MediaSessionCompat$Token
  implements Parcelable
{
  public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator() {};
  private final d kb;
  private final Object ko;
  
  MediaSessionCompat$Token(Object paramObject)
  {
    this(paramObject, null);
  }
  
  private MediaSessionCompat$Token(Object paramObject, d paramd)
  {
    this.ko = paramObject;
    this.kb = paramd;
  }
  
  public static Token a(Object paramObject, d paramd)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21)) {
      return new Token(u.n(paramObject), paramd);
    }
    return null;
  }
  
  public static Token m(Object paramObject)
  {
    return a(paramObject, null);
  }
  
  public final Object bt()
  {
    return this.ko;
  }
  
  public final d bu()
  {
    return this.kb;
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
      if (this.ko != null) {
        break;
      }
    } while (paramObject.ko == null);
    return false;
    if (paramObject.ko == null) {
      return false;
    }
    return this.ko.equals(paramObject.ko);
  }
  
  public final int hashCode()
  {
    if (this.ko == null) {
      return 0;
    }
    return this.ko.hashCode();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramParcel.writeParcelable((Parcelable)this.ko, paramInt);
      return;
    }
    paramParcel.writeStrongBinder((IBinder)this.ko);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.Token
 * JD-Core Version:    0.7.0.1
 */