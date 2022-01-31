import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

public final class akcc
  implements View.OnClickListener
{
  public akcc(DialogInterface.OnClickListener paramOnClickListener1, Dialog paramDialog, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369989) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_AndroidAppDialog, 0);
        }
        if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        return;
      }
      catch (Exception paramView) {}
      if (paramView.getId() == 2131369990)
      {
        if (this.b != null) {
          this.b.onClick(this.jdField_a_of_type_AndroidAppDialog, 1);
        }
        try
        {
          if (this.jdField_a_of_type_AndroidAppDialog.isShowing())
          {
            this.jdField_a_of_type_AndroidAppDialog.dismiss();
            return;
          }
        }
        catch (Exception paramView) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akcc
 * JD-Core Version:    0.7.0.1
 */