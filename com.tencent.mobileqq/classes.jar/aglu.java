import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public final class aglu
  implements Parcelable.Creator<LocalMediaInfo>
{
  public LocalMediaInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo._id = paramParcel.readLong();
    localLocalMediaInfo.path = paramParcel.readString();
    localLocalMediaInfo.fileSize = paramParcel.readLong();
    localLocalMediaInfo.addedDate = paramParcel.readLong();
    localLocalMediaInfo.modifiedDate = paramParcel.readLong();
    localLocalMediaInfo.orientation = paramParcel.readInt();
    localLocalMediaInfo.rotation = paramParcel.readInt();
    localLocalMediaInfo.mDuration = paramParcel.readLong();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      localLocalMediaInfo.mChecked = bool1;
      localLocalMediaInfo.selectStatus = paramParcel.readInt();
      localLocalMediaInfo.thumbWidth = paramParcel.readInt();
      localLocalMediaInfo.thumbHeight = paramParcel.readInt();
      localLocalMediaInfo.index = paramParcel.readInt();
      localLocalMediaInfo.position = Integer.valueOf(paramParcel.readInt());
      localLocalMediaInfo.mMimeType = paramParcel.readString();
      localLocalMediaInfo.mMediaType = paramParcel.readInt();
      localLocalMediaInfo.mediaWidth = paramParcel.readInt();
      localLocalMediaInfo.mediaHeight = paramParcel.readInt();
      if (paramParcel.readByte() != 1) {
        break label291;
      }
      bool1 = true;
      label193:
      localLocalMediaInfo.isSystemMeidaStore = bool1;
      if (paramParcel.readByte() != 1) {
        break label296;
      }
    }
    label291:
    label296:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localLocalMediaInfo.isRegionThumbUseNewDecoder = bool1;
      localLocalMediaInfo.longitude = paramParcel.readInt();
      localLocalMediaInfo.latitude = paramParcel.readInt();
      localLocalMediaInfo.panoramaPhotoType = paramParcel.readInt();
      localLocalMediaInfo.mCloudPhotoOwnerUin = paramParcel.readLong();
      localLocalMediaInfo.mCloudPhotoOwnerAlbumId = paramParcel.readString();
      localLocalMediaInfo.mCloudPhotoId = paramParcel.readString();
      localLocalMediaInfo.mTransferPosList = paramParcel.readArrayList(Long.class.getClassLoader());
      return localLocalMediaInfo;
      bool1 = false;
      break;
      bool1 = false;
      break label193;
    }
  }
  
  public LocalMediaInfo[] a(int paramInt)
  {
    return new LocalMediaInfo[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aglu
 * JD-Core Version:    0.7.0.1
 */