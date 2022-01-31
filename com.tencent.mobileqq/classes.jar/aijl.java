import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public final class aijl
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
      localLocalMediaInfo.thumbnailPath = paramParcel.readString();
      localLocalMediaInfo.index = paramParcel.readInt();
      localLocalMediaInfo.position = Integer.valueOf(paramParcel.readInt());
      localLocalMediaInfo.mMimeType = paramParcel.readString();
      localLocalMediaInfo.mMediaType = paramParcel.readInt();
      localLocalMediaInfo.mediaWidth = paramParcel.readInt();
      localLocalMediaInfo.mediaHeight = paramParcel.readInt();
      if (paramParcel.readByte() != 1) {
        break label339;
      }
      bool1 = true;
      label202:
      localLocalMediaInfo.isSystemMeidaStore = bool1;
      if (paramParcel.readByte() != 1) {
        break label344;
      }
      bool1 = true;
      label218:
      localLocalMediaInfo.isRegionThumbUseNewDecoder = bool1;
      localLocalMediaInfo.longitude = paramParcel.readInt();
      localLocalMediaInfo.latitude = paramParcel.readInt();
      localLocalMediaInfo.panoramaPhotoType = paramParcel.readInt();
      localLocalMediaInfo.mCloudPhotoOwnerUin = paramParcel.readLong();
      localLocalMediaInfo.mCloudPhotoOwnerAlbumId = paramParcel.readString();
      localLocalMediaInfo.mCloudPhotoId = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label349;
      }
    }
    label339:
    label344:
    label349:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localLocalMediaInfo.isVideoReady = bool1;
      localLocalMediaInfo.missionID = paramParcel.readString();
      localLocalMediaInfo.mTransferPosList = paramParcel.readArrayList(Long.class.getClassLoader());
      localLocalMediaInfo.aiTextLabel = paramParcel.readArrayList(String.class.getClassLoader());
      return localLocalMediaInfo;
      bool1 = false;
      break;
      bool1 = false;
      break label202;
      bool1 = false;
      break label218;
    }
  }
  
  public LocalMediaInfo[] a(int paramInt)
  {
    return new LocalMediaInfo[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijl
 * JD-Core Version:    0.7.0.1
 */