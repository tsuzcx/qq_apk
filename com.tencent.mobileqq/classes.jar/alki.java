import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;

public class alki
  extends alkm
  implements Runnable
{
  public int a;
  
  private alki(AbsListView paramAbsListView)
  {
    super(paramAbsListView, null);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView.mDataChanged) {}
    ListAdapter localListAdapter;
    int i;
    boolean bool;
    View localView;
    do
    {
      do
      {
        return;
        localListAdapter = this.jdField_a_of_type_ComTencentWidgetAbsListView.mAdapter;
        i = this.jdField_a_of_type_Int;
        bool = AbsListView.access$500(this.jdField_a_of_type_ComTencentWidgetAbsListView, i, this.jdField_a_of_type_ComTencentWidgetAbsListView.mAdapter.getCount());
      } while ((localListAdapter == null) || ((!bool) && (!AbsListView.access$600(this.jdField_a_of_type_ComTencentWidgetAbsListView))) || (!a()));
      localView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(i - this.jdField_a_of_type_ComTencentWidgetAbsListView.mFirstPosition);
    } while ((localView == null) && (!AbsListView.access$600(this.jdField_a_of_type_ComTencentWidgetAbsListView)));
    AbsListView localAbsListView = this.jdField_a_of_type_ComTencentWidgetAbsListView;
    if (bool) {}
    for (long l = localListAdapter.getItemId(i);; l = 0L)
    {
      localAbsListView.performItemClick(localView, i, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alki
 * JD-Core Version:    0.7.0.1
 */