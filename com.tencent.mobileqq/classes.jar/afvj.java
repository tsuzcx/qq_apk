import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class afvj
  implements View.OnClickListener
{
  afvj(afvi paramafvi, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Afvi, 0);
    }
    try
    {
      if (this.jdField_a_of_type_Afvi.isShowing()) {
        this.jdField_a_of_type_Afvi.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvj
 * JD-Core Version:    0.7.0.1
 */