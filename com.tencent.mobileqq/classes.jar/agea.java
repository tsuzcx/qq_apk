import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class agea
  implements bfos
{
  int jdField_a_of_type_Int = 0;
  int b;
  int c = 0;
  
  agea(agdv paramagdv)
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
      QLog.i("C2CMessageSearchDialog", 2, "onScrollStateChanged, reach bottom, scrollState " + paramInt + " firstVisibleItem: " + this.c + ", lastItem:" + this.jdField_a_of_type_Int + ", totalItemCount = " + this.jdField_b_of_type_Int + ", mIsComplete: " + this.jdField_a_of_type_Agdv.d + ", requesting:" + this.jdField_a_of_type_Agdv.jdField_c_of_type_Boolean + ", mSearchMode: " + this.jdField_a_of_type_Agdv.jdField_b_of_type_Int + ", mCurrentKeyword: " + this.jdField_a_of_type_Agdv.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_Int == 0) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Int != this.jdField_b_of_type_Int) || (paramInt != 0));
      if ((this.c != 0) && (!this.jdField_a_of_type_Agdv.jdField_c_of_type_Boolean))
      {
        this.jdField_a_of_type_Agdv.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_Agdv.jdField_b_of_type_Int == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("C2CMessageSearchDialog", 2, "onScrollStateChanged searchRoamMessageLocal >>>>> isComplete: " + this.jdField_a_of_type_Agdv.d);
          }
          this.jdField_a_of_type_Agdv.jdField_a_of_type_Agdt.a(this.jdField_a_of_type_Agdv.jdField_a_of_type_Long, this.jdField_a_of_type_Agdv.jdField_a_of_type_JavaLangString, 2);
          this.jdField_a_of_type_Agdv.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Agdv.jdField_a_of_type_AndroidContentContext.getString(2131719097));
          this.jdField_a_of_type_Agdv.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_Agdv.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131371996).setVisibility(0);
          this.jdField_a_of_type_Agdv.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("C2CMessageSearchDialog", 2, "onScrollStateChanged searchRoamMessageInCloud >>>>> isComplete: " + this.jdField_a_of_type_Agdv.d);
        }
        if (this.jdField_a_of_type_Agdv.d)
        {
          this.jdField_a_of_type_Agdv.jdField_c_of_type_AndroidWidgetTextView.setText(ajya.a(2131701285));
          this.jdField_a_of_type_Agdv.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131371996).setVisibility(8);
          this.jdField_a_of_type_Agdv.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_a_of_type_Agdv.jdField_b_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_Agdv.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Agdv.jdField_a_of_type_AndroidContentContext.getString(2131719096));
        this.jdField_a_of_type_Agdv.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Agdv.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131371996).setVisibility(0);
        this.jdField_a_of_type_Agdv.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Agdv.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Agdv.b(2);
        VipUtils.a(this.jdField_a_of_type_Agdv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatSearch", "Slip_resultup", 0, 0, new String[0]);
        return;
      }
    } while ((this.c != 0) || (this.jdField_a_of_type_Agdv.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_Agdv.d) || (this.jdField_a_of_type_Agdv.jdField_b_of_type_Int != 1));
    this.jdField_a_of_type_Agdv.jdField_c_of_type_AndroidWidgetTextView.setText(ajya.a(2131701290));
    this.jdField_a_of_type_Agdv.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131371996).setVisibility(8);
    this.jdField_a_of_type_Agdv.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_Agdv.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agea
 * JD-Core Version:    0.7.0.1
 */