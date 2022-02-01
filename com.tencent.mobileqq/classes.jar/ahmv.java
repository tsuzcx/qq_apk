import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahmv
  implements View.OnClickListener
{
  ahmv(ahmu paramahmu) {}
  
  public void onClick(View paramView)
  {
    if (!ahmu.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (llq.c())
      {
        Object localObject = (afrk)AIOUtils.getHolder(paramView);
        if (localObject != null)
        {
          localObject = (MessageForVideo)((afrk)localObject).a;
          ahmu.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, (MessageForVideo)localObject, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          if (((MessageForVideo)localObject).istroop == 1044) {
            bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD93", "0X800AD93", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmv
 * JD-Core Version:    0.7.0.1
 */