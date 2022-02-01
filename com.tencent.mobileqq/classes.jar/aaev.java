import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaev
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  aaev(aaet paramaaet) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramAbsListView.getFirstVisiblePosition() + paramInt2 >= paramInt3))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0) && (!aaet.a(this.jdField_a_of_type_Aaet)) && (!aaet.b(this.jdField_a_of_type_Aaet)))
    {
      QLog.i(aaet.a(), 1, "onLastItemVisible");
      aaet.a(this.jdField_a_of_type_Aaet, aaet.a(this.jdField_a_of_type_Aaet).a(aaet.a(this.jdField_a_of_type_Aaet)));
      if (aaet.a(this.jdField_a_of_type_Aaet) != null)
      {
        aaet.a(this.jdField_a_of_type_Aaet).a(aaet.a(this.jdField_a_of_type_Aaet), true);
        aaet.a(this.jdField_a_of_type_Aaet, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaev
 * JD-Core Version:    0.7.0.1
 */