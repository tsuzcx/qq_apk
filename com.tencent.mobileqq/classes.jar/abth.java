import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;

class abth
  extends DataSetObserver
{
  abth(abtg paramabtg, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Abtg.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Abtg.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abth
 * JD-Core Version:    0.7.0.1
 */