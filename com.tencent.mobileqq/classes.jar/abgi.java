import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;

public class abgi
  implements View.OnClickListener
{
  public abgi(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (abgm)paramView.getTag();
    this.a.a(paramView.jdField_a_of_type_JavaLangString, paramView.b, paramView.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgi
 * JD-Core Version:    0.7.0.1
 */