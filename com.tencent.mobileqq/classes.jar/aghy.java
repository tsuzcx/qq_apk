import android.text.Editable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XEditTextEx;

class aghy
  implements ActionMode.Callback
{
  aghy(aght paramaght) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    Object localObject = aght.a(this.a).app;
    boolean bool1;
    if (paramMenuItem.getItemId() == 1)
    {
      bdla.b((QQAppInterface)localObject, "dc00898", "", "", "0X800A513", "0X800A513", aght.a(this.a), 0, "", "", "", "");
      aght.a(this.a).input.getText().insert(aght.a(this.a).input.getSelectionStart(), "\n");
      paramActionMode.finish();
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (paramMenuItem.getItemId() == 2)
          {
            if (this.a.a())
            {
              bdla.b((QQAppInterface)localObject, "dc00898", "", "", "0X800A514", "0X800A514", aght.a(this.a), 0, "", "", "", "");
              this.a.a(false);
            }
            for (;;)
            {
              paramActionMode.finish();
              return true;
              bdla.b((QQAppInterface)localObject, "dc00898", "", "", "0X8009F28", "0X8009F28", aght.a(this.a), 0, "", "", "", "");
              aght.b(this.a);
            }
          }
          bool1 = bool2;
        } while (paramMenuItem.getItemId() != 3);
        localObject = (benk)aght.a(this.a).getHelper(74);
        bool1 = bool2;
      } while (localObject == null);
      localObject = ((benk)localObject).a();
      bool1 = bool2;
    } while (localObject == null);
    return ((ActionMode.Callback)localObject).onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    if (!bdfk.b())
    {
      paramMenu.add(0, 1, 196608, anvx.a(2131704437));
      if (!this.a.a()) {
        break label100;
      }
    }
    label100:
    for (Object localObject = anvx.a(2131704438);; localObject = anvx.a(2131704435))
    {
      paramMenu.add(0, 2, 196608, (CharSequence)localObject);
      if (this.a.a() == 0)
      {
        localObject = (benk)aght.a(this.a).getHelper(74);
        if (localObject != null)
        {
          localObject = ((benk)localObject).a();
          if (localObject != null) {
            ((ActionMode.Callback)localObject).onCreateActionMode(paramActionMode, paramMenu);
          }
        }
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
 * Qualified Name:     aghy
 * JD-Core Version:    0.7.0.1
 */