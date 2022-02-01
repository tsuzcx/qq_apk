import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class ahgb
  implements VideoPlayerCallback
{
  ahgb(ahfz paramahfz, VideoPlayParam paramVideoPlayParam) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoItemBuilder", 2, "onDownloadComplete, id = " + paramLong);
    }
    if (ahfz.a(this.jdField_a_of_type_Ahfz) == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoItemBuilder", 2, "onDownloadComplete , mListView is null.");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = AIOUtils.findMessage(paramLong, ahfz.a(this.jdField_a_of_type_Ahfz).getAdapter());
      } while (!(localObject instanceof MessageForShortVideo));
      localObject = (MessageForShortVideo)localObject;
    } while (((((MessageForShortVideo)localObject).fileType != 6) && (((MessageForShortVideo)localObject).fileType != 17) && (((MessageForShortVideo)localObject).fileType != 9)) || (((MessageForShortVideo)localObject).videoFileStatus == 2003));
    ((MessageForShortVideo)localObject).videoFileStatus = 2003;
    ((MessageForShortVideo)localObject).transferedSize = 0;
    ((MessageForShortVideo)localObject).videoFileProgress = 100;
    ((MessageForShortVideo)localObject).serial();
    this.jdField_a_of_type_Ahfz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(((MessageForShortVideo)localObject).frienduin, this.jdField_a_of_type_Ahfz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, ((MessageForShortVideo)localObject).uniseq, ((MessageForShortVideo)localObject).msgData);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onLoopBack, id = " + paramLong1 + " ,position = " + paramLong2);
    }
    MessageForShortVideo localMessageForShortVideo = bhbz.a().a(Long.valueOf(paramLong1));
    ahfz.a(this.jdField_a_of_type_Ahfz, localMessageForShortVideo, paramLong2);
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ahfz.a(this.jdField_a_of_type_Ahfz, paramLong, paramInt1, paramInt2, paramInt3, paramString, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onStateChange , state = " + paramInt + ", msgUniseq=" + paramLong + " , getAIOState() = " + this.jdField_a_of_type_Ahfz.a());
    }
    ahfz.a(this.jdField_a_of_type_Ahfz, paramLong, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgb
 * JD-Core Version:    0.7.0.1
 */