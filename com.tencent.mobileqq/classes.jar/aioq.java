import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

class aioq
  extends oep
{
  aioq(ainh paramainh) {}
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (ainh.a(this.a).getVisibility() != 0))
    {
      if (mbh.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        ainh.b(this.a).setVisibility(0);
        ainh.c(this.a).setOnClickListener(this.a);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130847091, 2130847092);
      }
    }
    else {
      return;
    }
    ainh.d(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aioq
 * JD-Core Version:    0.7.0.1
 */