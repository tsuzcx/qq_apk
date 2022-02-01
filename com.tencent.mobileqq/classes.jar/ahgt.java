import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahgt
  implements View.OnClickListener
{
  public ahgt(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c != 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c <= 500L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c = System.currentTimeMillis();
      bdcw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.a);
      alpt.b("", "0X8008CEB");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgt
 * JD-Core Version:    0.7.0.1
 */