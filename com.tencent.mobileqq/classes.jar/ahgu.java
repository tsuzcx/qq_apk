import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahgu
  implements View.OnClickListener
{
  public ahgu(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c != 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c <= 300L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Boolean) && (this.b)) {
        bczv.a().a((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      } else {
        QLog.d("ShortVideoRealItemBuilder", 1, String.format("not support dance Pendant, codec[%s], entry[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.b) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgu
 * JD-Core Version:    0.7.0.1
 */