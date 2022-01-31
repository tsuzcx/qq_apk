import android.text.Editable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class adhy
  implements ActionMode.Callback
{
  int jdField_a_of_type_Int = 1;
  int b = 2;
  
  adhy(adhw paramadhw) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    boolean bool = false;
    if (paramMenuItem.getItemId() == this.jdField_a_of_type_Int)
    {
      axqy.b(this.jdField_a_of_type_Adhw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A513", "0X800A513", this.jdField_a_of_type_Adhw.a(), 0, "", "", "", "");
      this.jdField_a_of_type_Adhw.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getText().insert(this.jdField_a_of_type_Adhw.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getSelectionStart(), "\n");
      paramActionMode.finish();
      bool = true;
    }
    while (paramMenuItem.getItemId() != this.b) {
      return bool;
    }
    if (this.jdField_a_of_type_Adhw.a())
    {
      axqy.b(this.jdField_a_of_type_Adhw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A514", "0X800A514", this.jdField_a_of_type_Adhw.a(), 0, "", "", "", "");
      this.jdField_a_of_type_Adhw.a(false);
    }
    for (;;)
    {
      paramActionMode.finish();
      return true;
      axqy.b(this.jdField_a_of_type_Adhw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F28", "0X8009F28", this.jdField_a_of_type_Adhw.a(), 0, "", "", "", "");
      this.jdField_a_of_type_Adhw.a();
    }
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    paramMenu.add(0, this.jdField_a_of_type_Int, 196608, ajya.a(2131704970));
    int i = this.b;
    if (this.jdField_a_of_type_Adhw.a()) {}
    for (paramActionMode = ajya.a(2131704971);; paramActionMode = ajya.a(2131704968))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhy
 * JD-Core Version:    0.7.0.1
 */