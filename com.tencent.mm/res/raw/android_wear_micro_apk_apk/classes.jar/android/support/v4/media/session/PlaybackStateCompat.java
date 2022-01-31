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
  final int aJ;
  final Bundle ew;
  final int iA;
  final CharSequence iB;
  final long iC;
  List<PlaybackStateCompat.CustomAction> iD;
  final long iE;
  private Object iF;
  final long iw;
  final long ix;
  final float iy;
  final long iz;
  
  private PlaybackStateCompat(int paramInt, long paramLong1, long paramLong2, float paramFloat, long paramLong3, CharSequence paramCharSequence, long paramLong4, List<PlaybackStateCompat.CustomAction> paramList, long paramLong5, Bundle paramBundle)
  {
    this.aJ = paramInt;
    this.iw = paramLong1;
    this.ix = paramLong2;
    this.iy = paramFloat;
    this.iz = paramLong3;
    this.iA = 0;
    this.iB = paramCharSequence;
    this.iC = paramLong4;
    this.iD = new ArrayList(paramList);
    this.iE = paramLong5;
    this.ew = paramBundle;
  }
  
  PlaybackStateCompat(Parcel paramParcel)
  {
    this.aJ = paramParcel.readInt();
    this.iw = paramParcel.readLong();
    this.iy = paramParcel.readFloat();
    this.iC = paramParcel.readLong();
    this.ix = paramParcel.readLong();
    this.iz = paramParcel.readLong();
    this.iB = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.iD = paramParcel.createTypedArrayList(PlaybackStateCompat.CustomAction.CREATOR);
    this.iE = paramParcel.readLong();
    this.ew = paramParcel.readBundle();
    this.iA = paramParcel.readInt();
  }
  
  public static PlaybackStateCompat h(Object paramObject)
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
          ((List)localObject2).add(PlaybackStateCompat.CustomAction.i(((Iterator)localObject3).next()));
        }
      }
      if (Build.VERSION.SDK_INT >= 22) {}
      for (Object localObject2 = ((PlaybackState)paramObject).getExtras();; localObject2 = null)
      {
        localObject1 = new PlaybackStateCompat(((PlaybackState)paramObject).getState(), ((PlaybackState)paramObject).getPosition(), ((PlaybackState)paramObject).getBufferedPosition(), ((PlaybackState)paramObject).getPlaybackSpeed(), ((PlaybackState)paramObject).getActions(), ((PlaybackState)paramObject).getErrorMessage(), ((PlaybackState)paramObject).getLastPositionUpdateTime(), (List)localObject1, ((PlaybackState)paramObject).getActiveQueueItemId(), (Bundle)localObject2);
        ((PlaybackStateCompat)localObject1).iF = paramObject;
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
    localStringBuilder.append("state=").append(this.aJ);
    localStringBuilder.append(", position=").append(this.iw);
    localStringBuilder.append(", buffered position=").append(this.ix);
    localStringBuilder.append(", speed=").append(this.iy);
    localStringBuilder.append(", updated=").append(this.iC);
    localStringBuilder.append(", actions=").append(this.iz);
    localStringBuilder.append(", error code=").append(this.iA);
    localStringBuilder.append(", error message=").append(this.iB);
    localStringBuilder.append(", custom actions=").append(this.iD);
    localStringBuilder.append(", active item id=").append(this.iE);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aJ);
    paramParcel.writeLong(this.iw);
    paramParcel.writeFloat(this.iy);
    paramParcel.writeLong(this.iC);
    paramParcel.writeLong(this.ix);
    paramParcel.writeLong(this.iz);
    TextUtils.writeToParcel(this.iB, paramParcel, paramInt);
    paramParcel.writeTypedList(this.iD);
    paramParcel.writeLong(this.iE);
    paramParcel.writeBundle(this.ew);
    paramParcel.writeInt(this.iA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.PlaybackStateCompat
 * JD-Core Version:    0.7.0.1
 */