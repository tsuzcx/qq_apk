import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;

class afsz
  implements begh
{
  int jdField_a_of_type_Int = 0;
  int b = 0;
  
  afsz(afsu paramafsu) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
    this.b = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Afsu.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() == this.jdField_a_of_type_Afsu.jdField_a_of_type_Afte) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i(afsu.jdField_a_of_type_JavaLangString, 2, "onScrollStateChanged, scrollState = " + paramInt + ", lastItem = " + this.jdField_a_of_type_Int + ", totalItemCount = " + this.b);
      }
    } while ((this.b == 0) || (this.jdField_a_of_type_Int != this.b) || (paramInt != 0));
    if (QLog.isColorLevel()) {
      QLog.i(afsu.jdField_a_of_type_JavaLangString, 2, "onScrollStateChanged, reach bottom, lastItem = " + this.jdField_a_of_type_Int + ", totalItemCount = " + this.b);
    }
    afsu.a(this.jdField_a_of_type_Afsu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afsz
 * JD-Core Version:    0.7.0.1
 */