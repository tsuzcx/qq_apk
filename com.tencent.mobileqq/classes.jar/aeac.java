import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class aeac
  implements bbvx
{
  public aeac(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void a(long paramLong) {}
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onStateChange , state =  " + paramInt + ", msgUniseq = " + paramLong);
    }
    if (paramInt == 4)
    {
      localObject = bbbf.a().a(Long.valueOf(paramLong));
      if ((localObject != null) && (!bbbf.a().a(Long.valueOf(paramLong))))
      {
        ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, this.a.jdField_a_of_type_AndroidContentContext);
        if (!bbbf.a().b(Long.valueOf(((MessageForShortVideo)localObject).uniseq)))
        {
          bbbf.a().a(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
          ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, this.a.jdField_a_of_type_AndroidContentContext);
        }
        bbbf.a().a(Long.valueOf(paramLong), true);
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
              ((aeah)localObject).a.setVisibility(0);
              this.a.a((aeah)localObject);
            } while (paramInt != 8);
            localObject = bbbf.a().a(Long.valueOf(paramLong));
          } while (localObject == null);
          this.a.a((MessageForShortVideo)localObject, ((MessageForShortVideo)localObject).videoFileTime * 1000);
          return;
          if (paramInt != 4) {
            break;
          }
          ShortVideoRealItemBuilder.a(this.a).removeCallbacksAndMessages(null);
          this.a.b((aeah)localObject);
          localObject = bbbf.a().a(Long.valueOf(paramLong));
        } while (localObject == null);
        this.a.a((MessageForShortVideo)localObject, 0L);
        return;
      } while (paramInt != 1);
      localMessageForShortVideo = bbbf.a().a(Long.valueOf(paramLong));
    } while (localMessageForShortVideo == null);
    ((aeah)localObject).a.setVisibility(0);
    this.a.c(localMessageForShortVideo, (aeah)localObject);
  }
  
  public void a(long paramLong, int paramInt, String paramString) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "playShortVideoByPath, onLoopBack, id = " + paramLong1);
    }
    MessageForShortVideo localMessageForShortVideo = bbbf.a().a(Long.valueOf(paramLong1));
    this.a.a(localMessageForShortVideo, paramLong2);
  }
  
  public void b(long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeac
 * JD-Core Version:    0.7.0.1
 */