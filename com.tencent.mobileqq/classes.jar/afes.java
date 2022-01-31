import android.text.Editable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class afes
  implements ActionMode.Callback
{
  int jdField_a_of_type_Int = 1;
  int b = 2;
  
  afes(afeq paramafeq) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    boolean bool = false;
    if (paramMenuItem.getItemId() == this.jdField_a_of_type_Int)
    {
      azqs.b(this.jdField_a_of_type_Afeq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A513", "0X800A513", this.jdField_a_of_type_Afeq.a(), 0, "", "", "", "");
      this.jdField_a_of_type_Afeq.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getText().insert(this.jdField_a_of_type_Afeq.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getSelectionStart(), "\n");
      paramActionMode.finish();
      bool = true;
    }
    while (paramMenuItem.getItemId() != this.b) {
      return bool;
    }
    if (this.jdField_a_of_type_Afeq.a())
    {
      azqs.b(this.jdField_a_of_type_Afeq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A514", "0X800A514", this.jdField_a_of_type_Afeq.a(), 0, "", "", "", "");
      this.jdField_a_of_type_Afeq.a(false);
    }
    for (;;)
    {
      paramActionMode.finish();
      return true;
      azqs.b(this.jdField_a_of_type_Afeq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F28", "0X8009F28", this.jdField_a_of_type_Afeq.a(), 0, "", "", "", "");
      afeq.b(this.jdField_a_of_type_Afeq);
    }
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    paramMenu.add(0, this.jdField_a_of_type_Int, 196608, alud.a(2131705354));
    int i = this.b;
    if (this.jdField_a_of_type_Afeq.a()) {}
    for (paramActionMode = alud.a(2131705355);; paramActionMode = alud.a(2131705352))
    {
      paramMenu.add(0, i, 196608, paramActionMode);
      return true;
    }
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afes
 * JD-Core Version:    0.7.0.1
 */