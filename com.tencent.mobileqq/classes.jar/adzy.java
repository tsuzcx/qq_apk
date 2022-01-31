import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;

public class adzy
  implements View.OnClickListener
{
  public adzy(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c != 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c <= 500L)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.c = System.currentTimeMillis();
    axjs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.a);
    ahtz.b("", "0X8008CEB");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzy
 * JD-Core Version:    0.7.0.1
 */