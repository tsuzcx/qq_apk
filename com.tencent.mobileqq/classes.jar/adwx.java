import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class adwx
  implements bewb
{
  public adwx(EditInfoActivity paramEditInfoActivity) {}
  
  public void a(View paramView, int paramInt, bewc parambewc)
  {
    if ((paramInt >= 0) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > paramInt))
    {
      int i = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      this.a.jdField_a_of_type_AndroidWidgetEditText.getText().insert(i, this.a.jdField_a_of_type_Bewa.a(paramInt));
      this.a.app.reportClickEvent("dc00899", "Grp_set", "", "nickname edit", "nickname edit_def_click", 0, 0, String.valueOf(this.a.e), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwx
 * JD-Core Version:    0.7.0.1
 */