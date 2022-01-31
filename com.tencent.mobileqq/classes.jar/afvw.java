import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.12.1;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.12.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class afvw
  implements VideoPlayerCallback
{
  afvw(afvt paramafvt) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoItemBuilder", 2, "onDownloadComplete, id = " + paramLong);
    }
    if (afvt.a(this.a) == null) {
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
        localObject = aekt.a(paramLong, afvt.a(this.a).getAdapter());
      } while (!(localObject instanceof MessageForShortVideo));
      localObject = (MessageForShortVideo)localObject;
    } while (((((MessageForShortVideo)localObject).fileType != 6) && (((MessageForShortVideo)localObject).fileType != 17) && (((MessageForShortVideo)localObject).fileType != 9)) || (((MessageForShortVideo)localObject).videoFileStatus == 2003));
    ((MessageForShortVideo)localObject).videoFileStatus = 2003;
    ((MessageForShortVideo)localObject).transferedSize = 0;
    ((MessageForShortVideo)localObject).videoFileProgress = 100;
    ((MessageForShortVideo)localObject).serial();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForShortVideo)localObject).frienduin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ((MessageForShortVideo)localObject).uniseq, ((MessageForShortVideo)localObject).msgData);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onLoopBack, id = " + paramLong1 + " ,position = " + paramLong2);
    }
    MessageForShortVideo localMessageForShortVideo = bdan.a().a(Long.valueOf(paramLong1));
    afvt.a(this.a, localMessageForShortVideo, paramLong2);
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onPlayError , id = ").append(paramLong);
      localStringBuilder1.append(" , errorCode = ").append(paramInt3);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(" , exInfo =");
      if (paramString != null)
      {
        localStringBuilder2.append(paramString);
        QLog.e("ShortVideoItemBuilder", 2, localStringBuilder1.toString());
      }
    }
    else
    {
      if ((paramInt3 == 14011001) && (afvt.a(this.a) != null)) {
        break label98;
      }
    }
    label98:
    do
    {
      return;
      paramString = "null";
      break;
      paramString = aekt.a(paramLong, afvt.a(this.a).getAdapter());
    } while (!(paramString instanceof MessageForShortVideo));
    paramString = (MessageForShortVideo)paramString;
    paramString.videoFileStatus = 5002;
    paramString.serial();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString.frienduin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramString.uniseq, paramString.msgData);
    afvt.a(this.a).post(new ShortVideoItemBuilder.12.2(this, paramString));
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onStateChange , state = " + paramInt + ", msgUniseq=" + paramLong);
    }
    if (paramInt == 4)
    {
      localObject = bdan.a().a(Long.valueOf(paramLong));
      if ((!bdan.a().a(Long.valueOf(paramLong))) && (localObject != null))
      {
        ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, this.a.jdField_a_of_type_AndroidContentContext);
        if (!bdan.a().b(Long.valueOf(((MessageForShortVideo)localObject).uniseq)))
        {
          bdan.a().a(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
          ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, this.a.jdField_a_of_type_AndroidContentContext);
        }
        bdan.a().a(Long.valueOf(paramLong), true);
      }
    }
    Object localObject = afvt.a(this.a, paramLong);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoItemBuilder", 2, "holder == null, msgUniseq=" + paramLong);
      }
    }
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
          if (((MessageForShortVideo)((afwd)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage).videoFileTime <= 8) {}
          for (bool = true; paramInt == 5; bool = false)
          {
            afvt.a(this.a).postDelayed(new ShortVideoItemBuilder.12.1(this, bool, (afwd)localObject), 1200L);
            return;
          }
          if ((paramInt != 7) && (paramInt != 8)) {
            break;
          }
          afvt.a(this.a).removeCallbacksAndMessages(null);
          ((afwd)localObject).d.setVisibility(8);
          ((afwd)localObject).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
          this.a.b((afwd)localObject);
          ((afwd)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          ((afwd)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        } while (paramInt != 8);
        localObject = bdan.a().a(Long.valueOf(paramLong));
      } while (localObject == null);
      afvt.a(this.a, (MessageForShortVideo)localObject, ((MessageForShortVideo)localObject).videoFileTime * 1000);
      return;
    } while (paramInt != 4);
    afvt.a(this.a).removeCallbacksAndMessages(null);
    if (bool) {
      ((afwd)localObject).d.setVisibility(8);
    }
    for (;;)
    {
      this.a.a((afwd)localObject);
      ((afwd)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      ((afwd)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localObject = bdan.a().a(Long.valueOf(paramLong));
      if (localObject == null) {
        break;
      }
      afvt.a(this.a, (MessageForShortVideo)localObject, 0L);
      return;
      ((afwd)localObject).d.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvw
 * JD-Core Version:    0.7.0.1
 */