import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

public class adpv
  implements View.OnClickListener
{
  public adpv(FlashPicItemBuilder paramFlashPicItemBuilder) {}
  
  public void onClick(View paramView)
  {
    long l = SystemClock.uptimeMillis();
    if (l - FlashPicItemBuilder.a(this.a) < 800L) {}
    adpy localadpy;
    label169:
    for (;;)
    {
      return;
      FlashPicItemBuilder.a(this.a, l);
      localadpy = (adpy)actj.a(paramView);
      if (localadpy != null)
      {
        Object localObject2 = localadpy.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
          if (ajyi.a(paramView)) {}
          for (boolean bool = ajyi.b(paramView);; bool = ajwb.b(paramView))
          {
            if (bool) {
              break label169;
            }
            if (localadpy.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 0) {
              break label171;
            }
            if (localadpy.jdField_a_of_type_ComTencentImageURLDrawable.isDownloadStarted()) {
              break;
            }
            localadpy.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
            return;
          }
        }
      }
    }
    label171:
    if (localadpy.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2)
    {
      localadpy.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      return;
    }
    FlashPicItemBuilder.a(this.a, paramView, localadpy.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder$FlashPicAIOThumbView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adpv
 * JD-Core Version:    0.7.0.1
 */