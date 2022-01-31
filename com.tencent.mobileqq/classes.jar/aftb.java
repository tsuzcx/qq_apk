import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;

class aftb
  implements behi
{
  aftb(afsu paramafsu) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(afsu.jdField_a_of_type_JavaLangString, 2, "onItemClick, position = " + paramInt);
    }
    paramAdapterView = this.a.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    if (paramAdapterView == this.a.jdField_a_of_type_Afst)
    {
      paramAdapterView = (afss)this.a.jdField_a_of_type_Afst.getItem(paramInt);
      this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      this.a.jdField_a_of_type_Int = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      if (QLog.isColorLevel()) {
        QLog.i(afsu.jdField_a_of_type_JavaLangString, 2, "onItemClick, mRecordCount = " + this.a.jdField_a_of_type_Int);
      }
      this.a.a(true);
      this.a.dismiss();
    }
    do
    {
      return;
      if (paramAdapterView == this.a.jdField_a_of_type_Afte)
      {
        paramAdapterView = (afsi)this.a.jdField_a_of_type_Afte.getItem(paramInt);
        this.a.b = false;
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramAdapterView.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramAdapterView.jdField_a_of_type_JavaLangString.length());
        this.a.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        ((InputMethodManager)this.a.jdField_a_of_type_AndroidWidgetEditText.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i(afsu.jdField_a_of_type_JavaLangString, 2, "onItemClick, unknown data type");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aftb
 * JD-Core Version:    0.7.0.1
 */