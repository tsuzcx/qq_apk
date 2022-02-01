import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agsd
  implements View.OnClickListener
{
  public agsd(FlashPicItemBuilder paramFlashPicItemBuilder) {}
  
  public void onClick(View paramView)
  {
    long l = SystemClock.uptimeMillis();
    if (l - FlashPicItemBuilder.a(this.a) < 800L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FlashPicItemBuilder.a(this.a, l);
      agsg localagsg = (agsg)AIOUtils.getHolder(paramView);
      if (localagsg != null)
      {
        Object localObject3 = localagsg.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = this.a.a.getMessageFacade().getMsgItemByUniseq(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq);
          localObject1 = localObject2;
          if ((localObject3 instanceof MessageForPic)) {
            localObject1 = (MessageForPic)localObject3;
          }
        }
        if (localObject1 != null)
        {
          if (anwf.a((MessageRecord)localObject1)) {}
          for (boolean bool = anwf.b((MessageRecord)localObject1);; bool = anud.b((MessageRecord)localObject1))
          {
            if (bool) {
              break label185;
            }
            if (localagsg.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 0) {
              break label187;
            }
            if (localagsg.jdField_a_of_type_ComTencentImageURLDrawable.isDownloadStarted()) {
              break;
            }
            localagsg.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
            break;
          }
          label185:
          continue;
          label187:
          if (localagsg.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2) {
            localagsg.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
          } else {
            FlashPicItemBuilder.a(this.a, (MessageForPic)localObject1, localagsg.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsd
 * JD-Core Version:    0.7.0.1
 */