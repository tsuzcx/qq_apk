import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;

class acij
  extends DataSetObserver
{
  acij(acii paramacii, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Acii.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Acii.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acij
 * JD-Core Version:    0.7.0.1
 */