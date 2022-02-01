import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaiw
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  aaiw(aaiu paramaaiu) {}
  
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
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0) && (!aaiu.a(this.jdField_a_of_type_Aaiu)) && (!aaiu.b(this.jdField_a_of_type_Aaiu)))
    {
      QLog.i(aaiu.a(), 1, "onLastItemVisible");
      aaiu.a(this.jdField_a_of_type_Aaiu, aaiu.a(this.jdField_a_of_type_Aaiu).a(aaiu.a(this.jdField_a_of_type_Aaiu)));
      if (aaiu.a(this.jdField_a_of_type_Aaiu) != null)
      {
        aaiu.a(this.jdField_a_of_type_Aaiu).a(aaiu.a(this.jdField_a_of_type_Aaiu), true);
        aaiu.a(this.jdField_a_of_type_Aaiu, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaiw
 * JD-Core Version:    0.7.0.1
 */