import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.MessageForShortVideo;

public final class abnu
  implements Parcelable.Creator
{
  public MessageForShortVideo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    MessageForShortVideo localMessageForShortVideo = new MessageForShortVideo();
    localMessageForShortVideo.uniseq = paramParcel.readLong();
    localMessageForShortVideo.istroop = paramParcel.readInt();
    localMessageForShortVideo.selfuin = paramParcel.readString();
    localMessageForShortVideo.frienduin = paramParcel.readString();
    localMessageForShortVideo.senderuin = paramParcel.readString();
    localMessageForShortVideo.uuid = paramParcel.readString();
    localMessageForShortVideo.md5 = paramParcel.readString();
    localMessageForShortVideo.videoFileName = paramParcel.readString();
    localMessageForShortVideo.videoFileSize = paramParcel.readInt();
    localMessageForShortVideo.videoFileFormat = paramParcel.readInt();
    localMessageForShortVideo.videoFileTime = paramParcel.readInt();
    localMessageForShortVideo.thumbWidth = paramParcel.readInt();
    localMessageForShortVideo.thumbHeight = paramParcel.readInt();
    localMessageForShortVideo.videoFileStatus = paramParcel.readInt();
    localMessageForShortVideo.videoFileProgress = paramParcel.readInt();
    localMessageForShortVideo.fileType = paramParcel.readInt();
    localMessageForShortVideo.thumbMD5 = paramParcel.readString();
    localMessageForShortVideo.fileSource = paramParcel.readString();
    localMessageForShortVideo.lastModified = paramParcel.readLong();
    localMessageForShortVideo.thumbFileSize = paramParcel.readInt();
    localMessageForShortVideo.busiType = paramParcel.readInt();
    localMessageForShortVideo.fromChatType = paramParcel.readInt();
    localMessageForShortVideo.toChatType = paramParcel.readInt();
    localMessageForShortVideo.uiOperatorFlag = paramParcel.readInt();
    localMessageForShortVideo.mVideoFileSourceDir = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localMessageForShortVideo.supportProgressive = bool1;
      localMessageForShortVideo.fileWidth = paramParcel.readInt();
      localMessageForShortVideo.fileHeight = paramParcel.readInt();
      localMessageForShortVideo.transferedSize = paramParcel.readInt();
      localMessageForShortVideo.subBusiType = paramParcel.readInt();
      localMessageForShortVideo.videoAttr = paramParcel.readInt();
      localMessageForShortVideo.binarySet = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label409;
      }
    }
    label409:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localMessageForShortVideo.mediacodecEncode = bool1;
      localMessageForShortVideo.hotVideoIconUrl = paramParcel.readString();
      localMessageForShortVideo.hotVideoSubIconUrl = paramParcel.readString();
      localMessageForShortVideo.hotVideoTitle = paramParcel.readString();
      localMessageForShortVideo.hotVideoUrl = paramParcel.readString();
      localMessageForShortVideo.specialVideoType = paramParcel.readInt();
      localMessageForShortVideo.msgTailType = paramParcel.readInt();
      localMessageForShortVideo.redBagType = paramParcel.readInt();
      localMessageForShortVideo.shortVideoId = paramParcel.readString();
      localMessageForShortVideo.redBagStat = paramParcel.readInt();
      return localMessageForShortVideo;
      bool1 = false;
      break;
    }
  }
  
  public MessageForShortVideo[] a(int paramInt)
  {
    return new MessageForShortVideo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abnu
 * JD-Core Version:    0.7.0.1
 */