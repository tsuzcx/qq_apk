import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

public class acdj
  implements TextWatcher
{
  int jdField_a_of_type_Int;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  int b;
  int c;
  
  public acdj(int paramInt, EditText paramEditText)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    Object localObject2;
    String str3;
    String str1;
    Object localObject1;
    if (str2.getBytes().length > this.jdField_a_of_type_Int)
    {
      localObject2 = "";
      str3 = "";
      str1 = "";
      paramEditable = str1;
      localObject1 = str3;
    }
    try
    {
      String str4 = str2.substring(0, this.b);
      paramEditable = str1;
      localObject1 = str3;
      localObject2 = str4;
      String str5 = str2.substring(this.b + this.c, str2.length());
      paramEditable = str1;
      localObject1 = str5;
      localObject2 = str4;
      str1 = str2.substring(this.b, this.b + this.c);
      paramEditable = str1;
      localObject1 = str5;
      localObject2 = str4;
      if (str4.getBytes().length + str5.getBytes().length <= this.jdField_a_of_type_Int)
      {
        for (;;)
        {
          paramEditable = str1;
          localObject1 = str5;
          localObject2 = str4;
          if (str2.getBytes().length <= this.jdField_a_of_type_Int) {
            break;
          }
          paramEditable = str1;
          localObject1 = str5;
          localObject2 = str4;
          if (str1.length() <= 0) {
            break;
          }
          paramEditable = str1;
          localObject1 = str5;
          localObject2 = str4;
          str1 = str1.substring(0, str1.length() - 1);
          paramEditable = str1;
          localObject1 = str5;
          localObject2 = str4;
          str2 = str4 + str1 + str5;
        }
        paramEditable = str1;
        localObject1 = str5;
        localObject2 = str4;
        byte[] arrayOfByte = String.valueOf(str2.charAt(str2.length() - 1)).getBytes("UTF-16BE");
        str3 = str2;
        paramEditable = str1;
        localObject1 = str5;
        localObject2 = str4;
        if (arrayOfByte.length == 2)
        {
          str3 = str2;
          paramEditable = str1;
          localObject1 = str5;
          localObject2 = str4;
          if (str2.length() > 1)
          {
            int i = (char)(arrayOfByte[0] & 0xFF);
            i = (char)((char)(arrayOfByte[1] & 0xFF) | i << 8);
            str3 = str2;
            if (i >= 55296)
            {
              str3 = str2;
              if (i <= 55359)
              {
                paramEditable = str1;
                localObject1 = str5;
                localObject2 = str4;
                str3 = str2.substring(0, str2.length() - 1);
              }
            }
          }
        }
        paramEditable = str1;
        localObject1 = str5;
        localObject2 = str4;
        this.jdField_a_of_type_AndroidWidgetEditText.setText(str3);
        paramEditable = str1;
        localObject1 = str5;
        localObject2 = str4;
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str3.length());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AddFriendVerifyActivity", 2, "afterTextChanged, headStr:" + (String)localObject2 + ", tailStr = " + (String)localObject1 + ", insert = " + paramEditable, localThrowable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt3;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdj
 * JD-Core Version:    0.7.0.1
 */