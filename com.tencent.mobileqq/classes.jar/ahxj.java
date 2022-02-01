import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahxj
  implements View.OnClickListener
{
  ahxj(ahxi paramahxi) {}
  
  public void onClick(View paramView)
  {
    if (!ahxi.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (llk.c())
      {
        Object localObject = (aghd)agej.a(paramView);
        if (localObject != null)
        {
          localObject = (MessageForVideo)((aghd)localObject).a;
          ahxi.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, (MessageForVideo)localObject, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          if (((MessageForVideo)localObject).istroop == 1044) {
            bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD93", "0X800AD93", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxj
 * JD-Core Version:    0.7.0.1
 */