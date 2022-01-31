import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;

public class abzr
  implements QueryCallback
{
  public abzr(SmallEmoticonInfo paramSmallEmoticonInfo, int paramInt1, int paramInt2, EditText paramEditText, QQAppInterface paramQQAppInterface) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    char[] arrayOfChar1 = EmosmUtils.a(this.jdField_a_of_type_Int, this.b);
    char[] arrayOfChar2 = new char[5];
    arrayOfChar2[0] = '\024';
    arrayOfChar2[1] = arrayOfChar1[3];
    arrayOfChar2[2] = arrayOfChar1[2];
    arrayOfChar2[3] = arrayOfChar1[1];
    arrayOfChar2[4] = arrayOfChar1[0];
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.isAPNG == 2)) {
      arrayOfChar2[1] = 'ǿ';
    }
    int i = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    int j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
    this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, String.valueOf(arrayOfChar2));
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800717E", 0, 0, this.jdField_a_of_type_Int + "", this.b + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abzr
 * JD-Core Version:    0.7.0.1
 */