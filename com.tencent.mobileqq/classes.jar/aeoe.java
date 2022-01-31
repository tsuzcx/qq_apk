import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class aeoe
  implements View.OnClickListener
{
  aeoe(aeoc paramaeoc, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((aeoc.a(this.jdField_a_of_type_Aeoc) != null) && (aeoc.a(this.jdField_a_of_type_Aeoc).isShowing())) {
      aeoc.a(this.jdField_a_of_type_Aeoc).dismiss();
    }
    if ((this.jdField_a_of_type_Aeoc.a != null) && (this.jdField_a_of_type_Aeoc.a.isShowing()))
    {
      this.jdField_a_of_type_Aeoc.a.dismiss();
      this.jdField_a_of_type_Aeoc.a = null;
    }
    aeoc.a(this.jdField_a_of_type_Aeoc, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeoe
 * JD-Core Version:    0.7.0.1
 */