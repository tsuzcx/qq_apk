import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class agbd
  implements VideoPlayerCallback
{
  public agbd(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "playShortVideoByPath, onLoopBack, id = " + paramLong1);
    }
    MessageForShortVideo localMessageForShortVideo = bdew.a().a(Long.valueOf(paramLong1));
    this.a.a(localMessageForShortVideo, paramLong2);
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onStateChange , state =  " + paramInt + ", msgUniseq = " + paramLong);
    }
    if (paramInt == 4)
    {
      localObject = bdew.a().a(Long.valueOf(paramLong));
      if ((localObject != null) && (!bdew.a().a(Long.valueOf(paramLong))))
      {
        ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, this.a.jdField_a_of_type_AndroidContentContext);
        if (!bdew.a().b(Long.valueOf(((MessageForShortVideo)localObject).uniseq)))
        {
          bdew.a().a(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
          ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, this.a.jdField_a_of_type_AndroidContentContext);
        }
        bdew.a().a(Long.valueOf(paramLong), true);
      }
    }
    Object localObject = this.a.a(paramLong);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "holder == null, msgUniseq = " + paramLong);
      }
    }
    label219:
    MessageForShortVideo localMessageForShortVideo;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              break label219;
              break label219;
              break label219;
              do
              {
                return;
              } while (paramInt == 5);
              if ((paramInt != 7) && (paramInt != 8)) {
                break;
              }
              ShortVideoRealItemBuilder.a(this.a).removeCallbacksAndMessages(null);
              ((agbi)localObject).a.setVisibility(0);
              this.a.a((agbi)localObject);
            } while (paramInt != 8);
            localObject = bdew.a().a(Long.valueOf(paramLong));
          } while (localObject == null);
          this.a.a((MessageForShortVideo)localObject, ((MessageForShortVideo)localObject).videoFileTime * 1000);
          return;
          if (paramInt != 4) {
            break;
          }
          ShortVideoRealItemBuilder.a(this.a).removeCallbacksAndMessages(null);
          this.a.b((agbi)localObject);
          localObject = bdew.a().a(Long.valueOf(paramLong));
        } while (localObject == null);
        this.a.a((MessageForShortVideo)localObject, 0L);
        return;
      } while (paramInt != 1);
      localMessageForShortVideo = bdew.a().a(Long.valueOf(paramLong));
    } while (localMessageForShortVideo == null);
    ((agbi)localObject).a.setVisibility(0);
    this.a.c(localMessageForShortVideo, (agbi)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbd
 * JD-Core Version:    0.7.0.1
 */