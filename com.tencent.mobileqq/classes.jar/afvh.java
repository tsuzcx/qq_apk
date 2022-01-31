import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class afvh
  implements View.OnClickListener
{
  afvh(afvg paramafvg, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Afvg, 0);
    }
    try
    {
      if (this.jdField_a_of_type_Afvg.isShowing()) {
        this.jdField_a_of_type_Afvg.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvh
 * JD-Core Version:    0.7.0.1
 */