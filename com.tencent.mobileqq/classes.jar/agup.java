import android.text.Editable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XEditTextEx;

class agup
  implements ActionMode.Callback
{
  agup(aguk paramaguk) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    Object localObject = aguk.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool1;
    if (paramMenuItem.getItemId() == 1)
    {
      bdll.b((QQAppInterface)localObject, "dc00898", "", "", "0X800A513", "0X800A513", aguk.a(this.a), 0, "", "", "", "");
      aguk.a(this.a).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().insert(aguk.a(this.a).jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart(), "\n");
      paramActionMode.finish();
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        if (paramMenuItem.getItemId() == 2)
        {
          if (this.a.a())
          {
            bdll.b((QQAppInterface)localObject, "dc00898", "", "", "0X800A514", "0X800A514", aguk.a(this.a), 0, "", "", "", "");
            this.a.a(false);
          }
          for (;;)
          {
            paramActionMode.finish();
            return true;
            bdll.b((QQAppInterface)localObject, "dc00898", "", "", "0X8009F28", "0X8009F28", aguk.a(this.a), 0, "", "", "", "");
            aguk.b(this.a);
          }
        }
        bool1 = bool2;
      } while (paramMenuItem.getItemId() != 3);
      localObject = ((bemp)aguk.a(this.a).a(74)).a();
      bool1 = bool2;
    } while (localObject == null);
    return ((ActionMode.Callback)localObject).onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    if (!bdgb.b())
    {
      paramMenu.add(0, 1, 196608, anzj.a(2131703857));
      if (!this.a.a()) {
        break label88;
      }
    }
    label88:
    for (String str = anzj.a(2131703858);; str = anzj.a(2131703855))
    {
      paramMenu.add(0, 2, 196608, str);
      if (this.a.a() == 0) {
        ((bemp)aguk.a(this.a).a(74)).a().onCreateActionMode(paramActionMode, paramMenu);
      }
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
 * Qualified Name:     agup
 * JD-Core Version:    0.7.0.1
 */