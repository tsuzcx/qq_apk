import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class alcx
  extends EditText
  implements ActionMode.Callback
{
  public alcx(Context paramContext)
  {
    super(paramContext);
    super.setLongClickable(false);
    super.setTextIsSelectable(false);
    super.setImeOptions(268435456);
    if (Build.VERSION.SDK_INT >= 11) {
      super.setCustomSelectionActionModeCallback(this);
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      super.setSelection(paramInt);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloDiyTextActivity", 1, localException.getMessage());
    }
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcx
 * JD-Core Version:    0.7.0.1
 */