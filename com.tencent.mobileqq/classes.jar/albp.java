import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class albp
  extends Handler
{
  public albp(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label366:
    do
    {
      Object[] arrayOfObject;
      String str;
      do
      {
        do
        {
          return;
          TroopMemberListInnerFrame.a(this.a, paramMessage);
          return;
          paramMessage = this.a;
          paramMessage.jdField_a_of_type_Double += TroopMemberListInnerFrame.jdField_b_of_type_Double;
        } while ((this.a.jdField_a_of_type_Double >= 90.0D) || (this.a.jdField_a_of_type_Int <= 0));
        if (this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
          this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)this.a.jdField_a_of_type_Double);
        this.a.d.setText(String.format(amtj.a(2131714629), new Object[] { Integer.valueOf(Math.min((int)(this.a.jdField_a_of_type_Int * this.a.jdField_a_of_type_Double / 100.0D), this.a.jdField_a_of_type_Int)), Integer.valueOf(this.a.jdField_a_of_type_Int) }));
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(4), 800L);
        return;
        TroopMemberListInnerFrame.a(this.a, paramMessage.arg1);
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
        if (!(paramMessage.obj instanceof Object[])) {
          break label366;
        }
        arrayOfObject = (Object[])paramMessage.obj;
        if (arrayOfObject.length <= 0) {
          break label366;
        }
        str = (String)arrayOfObject[1];
        if (str.equals(this.a.jdField_b_of_type_JavaLangString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, troopUin != mTroopUin, break:" + str + "," + this.a.jdField_b_of_type_JavaLangString);
      return;
      this.a.jdField_a_of_type_JavaUtilMap = ((Map)arrayOfObject[0]);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, mIndexedFriends.size=" + this.a.jdField_a_of_type_JavaUtilMap.size());
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mSubType == 1) || (this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mSubType == 0) || (this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mSubType == 5))
      {
        int i = TroopMemberListInnerFrame.a(this.a, this.a.jdField_a_of_type_JavaUtilMap);
        this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.afterMemberFilter(i);
      }
      paramMessage.obj = TroopMemberListInnerFrame.a(this.a);
      TroopMemberListInnerFrame.a(this.a, paramMessage);
    } while ((this.a.jdField_a_of_type_Boolean) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.mIsSelectAllMembers));
    this.a.jdField_a_of_type_Boolean = true;
    paramMessage = this.a.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.a.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramMessage.setChecked(bool);
      this.a.onCheckedChanged(this.a.jdField_a_of_type_AndroidWidgetCheckBox, this.a.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albp
 * JD-Core Version:    0.7.0.1
 */