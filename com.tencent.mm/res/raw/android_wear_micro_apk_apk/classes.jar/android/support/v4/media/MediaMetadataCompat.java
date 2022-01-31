package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.b.a;

public final class MediaMetadataCompat
  implements Parcelable
{
  public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new Parcelable.Creator() {};
  static final a<String, Integer> hG;
  private static final String[] hH;
  private static final String[] hI;
  private static final String[] hJ;
  final Bundle hK;
  private Object hL;
  
  static
  {
    a locala = new a();
    hG = locala;
    locala.put("android.media.metadata.TITLE", Integer.valueOf(1));
    hG.put("android.media.metadata.ARTIST", Integer.valueOf(1));
    hG.put("android.media.metadata.DURATION", Integer.valueOf(0));
    hG.put("android.media.metadata.ALBUM", Integer.valueOf(1));
    hG.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
    hG.put("android.media.metadata.WRITER", Integer.valueOf(1));
    hG.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
    hG.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
    hG.put("android.media.metadata.DATE", Integer.valueOf(1));
    hG.put("android.media.metadata.YEAR", Integer.valueOf(0));
    hG.put("android.media.metadata.GENRE", Integer.valueOf(1));
    hG.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
    hG.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
    hG.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
    hG.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
    hG.put("android.media.metadata.ART", Integer.valueOf(2));
    hG.put("android.media.metadata.ART_URI", Integer.valueOf(1));
    hG.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
    hG.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
    hG.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
    hG.put("android.media.metadata.RATING", Integer.valueOf(3));
    hG.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
    hG.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
    hG.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
    hG.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
    hG.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
    hG.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
    hG.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
    hG.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
    hG.put("android.media.metadata.ADVERTISEMENT", Integer.valueOf(0));
    hG.put("android.media.metadata.DOWNLOAD_STATUS", Integer.valueOf(0));
    hH = new String[] { "android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER" };
    hI = new String[] { "android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART" };
    hJ = new String[] { "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI" };
  }
  
  MediaMetadataCompat(Parcel paramParcel)
  {
    this.hK = paramParcel.readBundle();
  }
  
  public static MediaMetadataCompat d(Object paramObject)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      Parcel localParcel = Parcel.obtain();
      ((MediaMetadata)paramObject).writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      MediaMetadataCompat localMediaMetadataCompat = (MediaMetadataCompat)CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      localMediaMetadataCompat.hL = paramObject;
      return localMediaMetadataCompat;
    }
    return null;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.hK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.MediaMetadataCompat
 * JD-Core Version:    0.7.0.1
 */