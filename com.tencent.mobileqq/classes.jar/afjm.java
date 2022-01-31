import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class afjm
  implements View.OnClickListener
{
  afjm(afjl paramafjl, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Afjl, 0);
    }
    try
    {
      if (this.jdField_a_of_type_Afjl.isShowing()) {
        this.jdField_a_of_type_Afjl.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afjm
 * JD-Core Version:    0.7.0.1
 */