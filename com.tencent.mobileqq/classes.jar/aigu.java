import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class aigu
  implements bhtv
{
  int jdField_a_of_type_Int = 0;
  int b;
  int c = 0;
  
  aigu(aigp paramaigp)
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
    this.jdField_b_of_type_Int = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onScrollStateChanged, reach bottom, scrollState " + paramInt + " firstVisibleItem: " + this.c + ", lastItem:" + this.jdField_a_of_type_Int + ", totalItemCount = " + this.jdField_b_of_type_Int + ", mIsComplete: " + this.jdField_a_of_type_Aigp.d + ", requesting:" + this.jdField_a_of_type_Aigp.jdField_c_of_type_Boolean + ", mSearchMode: " + this.jdField_a_of_type_Aigp.jdField_b_of_type_Int + ", mCurrentKeyword: " + this.jdField_a_of_type_Aigp.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_Int == 0) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Int != this.jdField_b_of_type_Int) || (paramInt != 0));
      if ((this.c != 0) && (!this.jdField_a_of_type_Aigp.jdField_c_of_type_Boolean))
      {
        this.jdField_a_of_type_Aigp.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_Aigp.jdField_b_of_type_Int == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("C2CMessageSearchDialog", 2, "onScrollStateChanged searchRoamMessageLocal >>>>> isComplete: " + this.jdField_a_of_type_Aigp.d);
          }
          this.jdField_a_of_type_Aigp.jdField_a_of_type_Aign.a(this.jdField_a_of_type_Aigp.jdField_a_of_type_Long, this.jdField_a_of_type_Aigp.jdField_a_of_type_JavaLangString, 2);
          this.jdField_a_of_type_Aigp.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Aigp.jdField_a_of_type_AndroidContentContext.getString(2131719589));
          this.jdField_a_of_type_Aigp.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_Aigp.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131372333).setVisibility(0);
          this.jdField_a_of_type_Aigp.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("C2CMessageSearchDialog", 2, "onScrollStateChanged searchRoamMessageInCloud >>>>> isComplete: " + this.jdField_a_of_type_Aigp.d);
        }
        if (this.jdField_a_of_type_Aigp.d)
        {
          this.jdField_a_of_type_Aigp.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131701666));
          this.jdField_a_of_type_Aigp.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131372333).setVisibility(8);
          this.jdField_a_of_type_Aigp.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_a_of_type_Aigp.jdField_b_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_Aigp.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Aigp.jdField_a_of_type_AndroidContentContext.getString(2131719588));
        this.jdField_a_of_type_Aigp.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Aigp.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131372333).setVisibility(0);
        this.jdField_a_of_type_Aigp.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Aigp.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Aigp.b(2);
        VipUtils.a(this.jdField_a_of_type_Aigp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatSearch", "Slip_resultup", 0, 0, new String[0]);
        return;
      }
    } while ((this.c != 0) || (this.jdField_a_of_type_Aigp.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_Aigp.d) || (this.jdField_a_of_type_Aigp.jdField_b_of_type_Int != 1));
    this.jdField_a_of_type_Aigp.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131701671));
    this.jdField_a_of_type_Aigp.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131372333).setVisibility(8);
    this.jdField_a_of_type_Aigp.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_Aigp.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigu
 * JD-Core Version:    0.7.0.1
 */