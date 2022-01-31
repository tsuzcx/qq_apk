import android.database.DataSetObserver;
import com.tencent.mobileqq.filemanager.widget.QfileHorizontalListView;

public class aczc
  extends DataSetObserver
{
  public aczc(QfileHorizontalListView paramQfileHorizontalListView) {}
  
  public void onChanged()
  {
    synchronized (this.a)
    {
      QfileHorizontalListView.a(this.a, true);
      this.a.invalidate();
      this.a.requestLayout();
      return;
    }
  }
  
  public void onInvalidated()
  {
    QfileHorizontalListView.a(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aczc
 * JD-Core Version:    0.7.0.1
 */