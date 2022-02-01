import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class ajxd
  implements bkhe
{
  int jdField_a_of_type_Int = 0;
  int b;
  int c = 0;
  
  ajxd(ajwy paramajwy)
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
      QLog.i("LinkMessageSearchDialog", 2, "onScrollStateChanged, reach bottom, scrollState " + paramInt + " firstVisibleItem: " + this.c + ", lastItem:" + this.jdField_a_of_type_Int + ", totalItemCount = " + this.jdField_b_of_type_Int + ", mIsComplete: " + this.jdField_a_of_type_Ajwy.jdField_c_of_type_Boolean + ", requesting:" + this.jdField_a_of_type_Ajwy.jdField_b_of_type_Boolean + ", mSearchMode: " + this.jdField_a_of_type_Ajwy.jdField_b_of_type_Int + ", mCurrentKeyword: " + this.jdField_a_of_type_Ajwy.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_Int == 0) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Int != this.jdField_b_of_type_Int) || (paramInt != 0));
      if ((this.c != 0) && (!this.jdField_a_of_type_Ajwy.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Ajwy.jdField_b_of_type_Boolean = true;
        if (this.jdField_a_of_type_Ajwy.jdField_b_of_type_Int == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("LinkMessageSearchDialog", 2, "onScrollStateChanged searchRoamMessageLocal >>>>> isComplete: " + this.jdField_a_of_type_Ajwy.jdField_c_of_type_Boolean);
          }
          this.jdField_a_of_type_Ajwy.jdField_a_of_type_Ajwx.a(this.jdField_a_of_type_Ajwy.jdField_a_of_type_Long, this.jdField_a_of_type_Ajwy.jdField_a_of_type_JavaLangString, 2);
          this.jdField_a_of_type_Ajwy.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ajwy.jdField_a_of_type_AndroidContentContext.getString(2131717625));
          this.jdField_a_of_type_Ajwy.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_Ajwy.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131372927).setVisibility(0);
          this.jdField_a_of_type_Ajwy.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("LinkMessageSearchDialog", 2, "onScrollStateChanged searchRoamMessageInCloud >>>>> isComplete: " + this.jdField_a_of_type_Ajwy.jdField_c_of_type_Boolean);
        }
        if (this.jdField_a_of_type_Ajwy.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_Ajwy.jdField_b_of_type_AndroidWidgetTextView.setText(anni.a(2131700082));
          this.jdField_a_of_type_Ajwy.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131372927).setVisibility(8);
          this.jdField_a_of_type_Ajwy.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_a_of_type_Ajwy.jdField_b_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_Ajwy.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ajwy.jdField_a_of_type_AndroidContentContext.getString(2131717624));
        this.jdField_a_of_type_Ajwy.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Ajwy.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131372927).setVisibility(0);
        this.jdField_a_of_type_Ajwy.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Ajwy.jdField_a_of_type_Long = System.currentTimeMillis();
        return;
      }
    } while ((this.c != 0) || (this.jdField_a_of_type_Ajwy.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Ajwy.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Ajwy.jdField_b_of_type_Int != 1));
    this.jdField_a_of_type_Ajwy.jdField_b_of_type_AndroidWidgetTextView.setText(anni.a(2131700083));
    this.jdField_a_of_type_Ajwy.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131372927).setVisibility(8);
    this.jdField_a_of_type_Ajwy.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_Ajwy.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxd
 * JD-Core Version:    0.7.0.1
 */