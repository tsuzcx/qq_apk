import android.text.Editable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class aglo
  implements ActionMode.Callback
{
  int jdField_a_of_type_Int = 1;
  int b = 2;
  
  aglo(aglj paramaglj) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    boolean bool = false;
    if (paramMenuItem.getItemId() == this.jdField_a_of_type_Int)
    {
      bcst.b(aglj.a(this.jdField_a_of_type_Aglj), "dc00898", "", "", "0X800A513", "0X800A513", aglj.a(this.jdField_a_of_type_Aglj), 0, "", "", "", "");
      aglj.a(this.jdField_a_of_type_Aglj).a.getText().insert(aglj.a(this.jdField_a_of_type_Aglj).a.getSelectionStart(), "\n");
      paramActionMode.finish();
      bool = true;
    }
    while (paramMenuItem.getItemId() != this.b) {
      return bool;
    }
    if (this.jdField_a_of_type_Aglj.a())
    {
      bcst.b(aglj.a(this.jdField_a_of_type_Aglj), "dc00898", "", "", "0X800A514", "0X800A514", aglj.a(this.jdField_a_of_type_Aglj), 0, "", "", "", "");
      this.jdField_a_of_type_Aglj.a(false);
    }
    for (;;)
    {
      paramActionMode.finish();
      return true;
      bcst.b(aglj.a(this.jdField_a_of_type_Aglj), "dc00898", "", "", "0X8009F28", "0X8009F28", aglj.a(this.jdField_a_of_type_Aglj), 0, "", "", "", "");
      aglj.b(this.jdField_a_of_type_Aglj);
    }
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    if (bcnj.b()) {
      return true;
    }
    paramMenu.add(0, this.jdField_a_of_type_Int, 196608, anni.a(2131703750));
    int i = this.b;
    if (this.jdField_a_of_type_Aglj.a()) {}
    for (paramActionMode = anni.a(2131703751);; paramActionMode = anni.a(2131703748))
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
 * Qualified Name:     aglo
 * JD-Core Version:    0.7.0.1
 */