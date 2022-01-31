import android.database.DataSetObserver;
import com.tencent.mobileqq.emosm.view.DragSortListView;

class acaj
  extends DataSetObserver
{
  acaj(acai paramacai, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Acai.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Acai.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acaj
 * JD-Core Version:    0.7.0.1
 */