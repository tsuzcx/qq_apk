import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class aeog
  implements View.OnClickListener
{
  aeog(aeoe paramaeoe, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((aeoe.a(this.jdField_a_of_type_Aeoe) != null) && (aeoe.a(this.jdField_a_of_type_Aeoe).isShowing())) {
      aeoe.a(this.jdField_a_of_type_Aeoe).dismiss();
    }
    if ((this.jdField_a_of_type_Aeoe.a != null) && (this.jdField_a_of_type_Aeoe.a.isShowing()))
    {
      this.jdField_a_of_type_Aeoe.a.dismiss();
      this.jdField_a_of_type_Aeoe.a = null;
    }
    aeoe.a(this.jdField_a_of_type_Aeoe, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeog
 * JD-Core Version:    0.7.0.1
 */