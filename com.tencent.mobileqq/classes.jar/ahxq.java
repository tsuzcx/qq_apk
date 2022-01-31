import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class ahxq
  implements View.OnClickListener
{
  ahxq(ahxp paramahxp, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Ahxp, 0);
    }
    try
    {
      if (this.jdField_a_of_type_Ahxp.isShowing()) {
        this.jdField_a_of_type_Ahxp.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxq
 * JD-Core Version:    0.7.0.1
 */