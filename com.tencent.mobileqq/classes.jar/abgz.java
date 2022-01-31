import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class abgz
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public boolean a;
  private int b;
  public boolean b;
  private int c;
  
  public abgz(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity, int paramInt, EditText paramEditText)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    localObject1 = paramEditable;
    if (paramEditable.getBytes().length > this.jdField_a_of_type_Int) {
      localEditable = paramEditable;
    }
    try
    {
      String str1 = paramEditable.substring(0, this.jdField_b_of_type_Int);
      localEditable = paramEditable;
      String str2 = paramEditable.substring(this.jdField_b_of_type_Int + this.c, paramEditable.length());
      localEditable = paramEditable;
      Object localObject2 = paramEditable.substring(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int + this.c);
      localObject1 = paramEditable;
      localEditable = paramEditable;
      if (str1.getBytes().length + str2.getBytes().length <= this.jdField_a_of_type_Int)
      {
        localObject1 = localObject2;
        for (;;)
        {
          localEditable = paramEditable;
          if (paramEditable.getBytes().length <= this.jdField_a_of_type_Int) {
            break;
          }
          localEditable = paramEditable;
          if (((String)localObject1).length() <= 0) {
            break;
          }
          localEditable = paramEditable;
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
          localEditable = paramEditable;
          paramEditable = str1 + (String)localObject1 + str2;
        }
        localEditable = paramEditable;
        this.jdField_a_of_type_AndroidWidgetEditText.setText(paramEditable);
        localEditable = paramEditable;
        localObject2 = this.jdField_a_of_type_AndroidWidgetEditText;
        localEditable = paramEditable;
        int i = str1.length();
        localEditable = paramEditable;
        ((EditText)localObject2).setSelection(((String)localObject1).length() + i);
        localObject1 = paramEditable;
      }
    }
    catch (Exception paramEditable)
    {
      for (;;)
      {
        label292:
        localObject1 = localEditable;
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidWidgetEditText != this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.jdField_a_of_type_AndroidWidgetEditText) {
        break label292;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.a(FriendProfileMoreInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.getString(2131695416), (String)localObject1);
    }
    do
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      break;
      if (this.jdField_a_of_type_AndroidWidgetEditText == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.a(FriendProfileMoreInfoActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.getString(2131695366), (String)localObject1);
        return;
      }
      if (this.jdField_a_of_type_AndroidWidgetEditText == this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.a(FriendProfileMoreInfoActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.getString(2131695443), (String)localObject1);
        return;
      }
    } while (this.jdField_a_of_type_AndroidWidgetEditText != this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.d);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.a(FriendProfileMoreInfoActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.d, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity.getString(2131695399), (String)localObject1);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt3;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abgz
 * JD-Core Version:    0.7.0.1
 */