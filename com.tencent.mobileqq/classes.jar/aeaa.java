import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class aeaa
  implements bbwl
{
  public aeaa(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void a(long paramLong) {}
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onStateChange , state =  " + paramInt + ", msgUniseq = " + paramLong);
    }
    if (paramInt == 4)
    {
      localObject = bbbt.a().a(Long.valueOf(paramLong));
      if ((localObject != null) && (!bbbt.a().a(Long.valueOf(paramLong))))
      {
        ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, this.a.jdField_a_of_type_AndroidContentContext);
        if (!bbbt.a().b(Long.valueOf(((MessageForShortVideo)localObject).uniseq)))
        {
          bbbt.a().a(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
          ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, this.a.jdField_a_of_type_AndroidContentContext);
        }
        bbbt.a().a(Long.valueOf(paramLong), true);
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
              ((aeaf)localObject).a.setVisibility(0);
              this.a.a((aeaf)localObject);
            } while (paramInt != 8);
            localObject = bbbt.a().a(Long.valueOf(paramLong));
          } while (localObject == null);
          this.a.a((MessageForShortVideo)localObject, ((MessageForShortVideo)localObject).videoFileTime * 1000);
          return;
          if (paramInt != 4) {
            break;
          }
          ShortVideoRealItemBuilder.a(this.a).removeCallbacksAndMessages(null);
          this.a.b((aeaf)localObject);
          localObject = bbbt.a().a(Long.valueOf(paramLong));
        } while (localObject == null);
        this.a.a((MessageForShortVideo)localObject, 0L);
        return;
      } while (paramInt != 1);
      localMessageForShortVideo = bbbt.a().a(Long.valueOf(paramLong));
    } while (localMessageForShortVideo == null);
    ((aeaf)localObject).a.setVisibility(0);
    this.a.c(localMessageForShortVideo, (aeaf)localObject);
  }
  
  public void a(long paramLong, int paramInt, String paramString) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "playShortVideoByPath, onLoopBack, id = " + paramLong1);
    }
    MessageForShortVideo localMessageForShortVideo = bbbt.a().a(Long.valueOf(paramLong1));
    this.a.a(localMessageForShortVideo, paramLong2);
  }
  
  public void b(long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeaa
 * JD-Core Version:    0.7.0.1
 */