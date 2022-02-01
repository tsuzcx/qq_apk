import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahdb
  implements View.OnClickListener
{
  public ahdb(FlashPicItemBuilder paramFlashPicItemBuilder) {}
  
  public void onClick(View paramView)
  {
    long l = SystemClock.uptimeMillis();
    if (l - FlashPicItemBuilder.a(this.a) < 800L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FlashPicItemBuilder.a(this.a, l);
      ahde localahde = (ahde)agej.a(paramView);
      if (localahde != null)
      {
        Object localObject3 = localahde.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = this.a.a.a().a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq);
          localObject1 = localObject2;
          if ((localObject3 instanceof MessageForPic)) {
            localObject1 = (MessageForPic)localObject3;
          }
        }
        if (localObject1 != null)
        {
          if (anzr.a((MessageRecord)localObject1)) {}
          for (boolean bool = anzr.b((MessageRecord)localObject1);; bool = anxg.b((MessageRecord)localObject1))
          {
            if (bool) {
              break label185;
            }
            if (localahde.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 0) {
              break label187;
            }
            if (localahde.jdField_a_of_type_ComTencentImageURLDrawable.isDownloadStarted()) {
              break;
            }
            localahde.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
            break;
          }
          label185:
          continue;
          label187:
          if (localahde.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2) {
            localahde.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
          } else {
            FlashPicItemBuilder.a(this.a, (MessageForPic)localObject1, localahde.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdb
 * JD-Core Version:    0.7.0.1
 */