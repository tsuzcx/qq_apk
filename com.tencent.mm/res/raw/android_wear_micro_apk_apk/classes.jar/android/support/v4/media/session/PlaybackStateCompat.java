package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PlaybackStateCompat
  implements Parcelable
{
  public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator() {};
  final int cs;
  final Bundle gl;
  final long kA;
  List<PlaybackStateCompat.CustomAction> kB;
  final long kC;
  private Object kD;
  final long ku;
  final long kv;
  final float kw;
  final long kx;
  final int ky;
  final CharSequence kz;
  
  private PlaybackStateCompat(int paramInt, long paramLong1, long paramLong2, float paramFloat, long paramLong3, CharSequence paramCharSequence, long paramLong4, List<PlaybackStateCompat.CustomAction> paramList, long paramLong5, Bundle paramBundle)
  {
    this.cs = paramInt;
    this.ku = paramLong1;
    this.kv = paramLong2;
    this.kw = paramFloat;
    this.kx = paramLong3;
    this.ky = 0;
    this.kz = paramCharSequence;
    this.kA = paramLong4;
    this.kB = new ArrayList(paramList);
    this.kC = paramLong5;
    this.gl = paramBundle;
  }
  
  PlaybackStateCompat(Parcel paramParcel)
  {
    this.cs = paramParcel.readInt();
    this.ku = paramParcel.readLong();
    this.kw = paramParcel.readFloat();
    this.kA = paramParcel.readLong();
    this.kv = paramParcel.readLong();
    this.kx = paramParcel.readLong();
    this.kz = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.kB = paramParcel.createTypedArrayList(PlaybackStateCompat.CustomAction.CREATOR);
    this.kC = paramParcel.readLong();
    this.gl = paramParcel.readBundle();
    this.ky = paramParcel.readInt();
  }
  
  public static PlaybackStateCompat o(Object paramObject)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      Object localObject3 = ((PlaybackState)paramObject).getCustomActions();
      Object localObject1 = null;
      if (localObject3 != null)
      {
        localObject2 = new ArrayList(((List)localObject3).size());
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          ((List)localObject2).add(PlaybackStateCompat.CustomAction.p(((Iterator)localObject3).next()));
        }
      }
      if (Build.VERSION.SDK_INT >= 22) {}
      for (Object localObject2 = ((PlaybackState)paramObject).getExtras();; localObject2 = null)
      {
        localObject1 = new PlaybackStateCompat(((PlaybackState)paramObject).getState(), ((PlaybackState)paramObject).getPosition(), ((PlaybackState)paramObject).getBufferedPosition(), ((PlaybackState)paramObject).getPlaybackSpeed(), ((PlaybackState)paramObject).getActions(), ((PlaybackState)paramObject).getErrorMessage(), ((PlaybackState)paramObject).getLastPositionUpdateTime(), (List)localObject1, ((PlaybackState)paramObject).getActiveQueueItemId(), (Bundle)localObject2);
        ((PlaybackStateCompat)localObject1).kD = paramObject;
        return localObject1;
      }
    }
    return null;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PlaybackState {");
    localStringBuilder.append("state=").append(this.cs);
    localStringBuilder.append(", position=").append(this.ku);
    localStringBuilder.append(", buffered position=").append(this.kv);
    localStringBuilder.append(", speed=").append(this.kw);
    localStringBuilder.append(", updated=").append(this.kA);
    localStringBuilder.append(", actions=").append(this.kx);
    localStringBuilder.append(", error code=").append(this.ky);
    localStringBuilder.append(", error message=").append(this.kz);
    localStringBuilder.append(", custom actions=").append(this.kB);
    localStringBuilder.append(", active item id=").append(this.kC);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.cs);
    paramParcel.writeLong(this.ku);
    paramParcel.writeFloat(this.kw);
    paramParcel.writeLong(this.kA);
    paramParcel.writeLong(this.kv);
    paramParcel.writeLong(this.kx);
    TextUtils.writeToParcel(this.kz, paramParcel, paramInt);
    paramParcel.writeTypedList(this.kB);
    paramParcel.writeLong(this.kC);
    paramParcel.writeBundle(this.gl);
    paramParcel.writeInt(this.ky);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.PlaybackStateCompat
 * JD-Core Version:    0.7.0.1
 */