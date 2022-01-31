import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView.GridViewAdapter;

public class ajbm
  implements View.OnKeyListener
{
  public ajbm(NewTroopContactView paramNewTroopContactView) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67)
    {
      if (paramKeyEvent.getAction() != 0) {
        break label35;
      }
      this.a.jdField_a_of_type_Boolean = TextUtils.isEmpty(this.a.jdField_a_of_type_AndroidWidgetEditText.getText());
    }
    for (;;)
    {
      return false;
      label35:
      if ((paramKeyEvent.getAction() == 1) && (this.a.jdField_a_of_type_Boolean)) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView$GridViewAdapter.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbm
 * JD-Core Version:    0.7.0.1
 */