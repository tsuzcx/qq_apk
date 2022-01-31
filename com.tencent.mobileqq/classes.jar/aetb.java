import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

class aetb
  extends nqs
{
  aetb(aert paramaert) {}
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (aert.a(this.a).getVisibility() != 0))
    {
      if (mau.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        aert.b(this.a).setVisibility(0);
        aert.c(this.a).setOnClickListener(this.a);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130846180, 2130846181);
      }
    }
    else {
      return;
    }
    aert.d(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aetb
 * JD-Core Version:    0.7.0.1
 */