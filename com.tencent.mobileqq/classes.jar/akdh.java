import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;

class akdh
  implements AdapterView.OnItemClickListener
{
  akdh(akda paramakda) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(akda.jdField_a_of_type_JavaLangString, 2, "onItemClick, position = " + paramInt);
    }
    paramAdapterView = this.a.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
    if (paramAdapterView == this.a.jdField_a_of_type_Akcz)
    {
      paramAdapterView = (akcy)this.a.jdField_a_of_type_Akcz.getItem(paramInt);
      this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      this.a.jdField_a_of_type_Int = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgRecordIndex(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      if (QLog.isColorLevel()) {
        QLog.i(akda.jdField_a_of_type_JavaLangString, 2, "onItemClick, mRecordCount = " + this.a.jdField_a_of_type_Int);
      }
      this.a.a(true);
      this.a.dismiss();
    }
    do
    {
      return;
      if (paramAdapterView == this.a.jdField_a_of_type_Akdk)
      {
        paramAdapterView = (akco)this.a.jdField_a_of_type_Akdk.getItem(paramInt);
        this.a.b = false;
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramAdapterView.jdField_a_of_type_JavaLangString);
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramAdapterView.jdField_a_of_type_JavaLangString.length());
        this.a.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        ((InputMethodManager)this.a.jdField_a_of_type_AndroidWidgetEditText.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i(akda.jdField_a_of_type_JavaLangString, 2, "onItemClick, unknown data type");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdh
 * JD-Core Version:    0.7.0.1
 */