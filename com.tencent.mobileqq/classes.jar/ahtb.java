import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class ahtb
  implements View.OnClickListener
{
  ahtb(ahta paramahta, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Ahta, 0);
    }
    try
    {
      if (this.jdField_a_of_type_Ahta.isShowing()) {
        this.jdField_a_of_type_Ahta.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtb
 * JD-Core Version:    0.7.0.1
 */