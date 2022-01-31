import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class adev
  implements View.OnClickListener
{
  public adev(FlashPicItemBuilder paramFlashPicItemBuilder) {}
  
  public void onClick(View paramView)
  {
    long l = SystemClock.uptimeMillis();
    if (l - FlashPicItemBuilder.a(this.a) < 800L) {}
    adey localadey;
    label169:
    for (;;)
    {
      return;
      FlashPicItemBuilder.a(this.a, l);
      localadey = (adey)aciy.a(paramView);
      if (localadey != null)
      {
        Object localObject2 = localadey.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        Object localObject1 = null;
        paramView = localObject1;
        if (localObject2 != null)
        {
          localObject2 = this.a.a.a().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq);
          paramView = localObject1;
          if ((localObject2 instanceof MessageForPic)) {
            paramView = (MessageForPic)localObject2;
          }
        }
        if (paramView != null)
        {
          if (ajke.a(paramView)) {}
          for (boolean bool = ajke.b(paramView);; bool = ajhz.b(paramView))
          {
            if (bool) {
              break label169;
            }
            if (localadey.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 0) {
              break label171;
            }
            if (localadey.jdField_a_of_type_ComTencentImageURLDrawable.isDownloadStarted()) {
              break;
            }
            localadey.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
            return;
          }
        }
      }
    }
    label171:
    if (localadey.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2)
    {
      localadey.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      return;
    }
    FlashPicItemBuilder.a(this.a, paramView, localadey.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adev
 * JD-Core Version:    0.7.0.1
 */