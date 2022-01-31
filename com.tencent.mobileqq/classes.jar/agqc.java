import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

class agqc
  extends nub
{
  agqc(agot paramagot) {}
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (agot.a(this.a).getVisibility() != 0))
    {
      if (mdj.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        agot.b(this.a).setVisibility(0);
        agot.c(this.a).setOnClickListener(this.a);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130846559, 2130846560);
      }
    }
    else {
      return;
    }
    agot.d(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqc
 * JD-Core Version:    0.7.0.1
 */