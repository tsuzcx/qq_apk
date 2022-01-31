import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.HorizontalListView;

public class almo
  extends alms
  implements Runnable
{
  public int a;
  
  private almo(HorizontalListView paramHorizontalListView)
  {
    super(paramHorizontalListView, null);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.c()) {}
    ListAdapter localListAdapter;
    int i;
    View localView;
    do
    {
      do
      {
        ((View)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getParent()).performClick();
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b);
        localListAdapter = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a;
        i = this.jdField_a_of_type_Int;
      } while ((localListAdapter == null) || (i == -1) || (i >= localListAdapter.getCount()) || (!a()));
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition());
    } while (localView == null);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.performItemClick(localView, i, localListAdapter.getItemId(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     almo
 * JD-Core Version:    0.7.0.1
 */