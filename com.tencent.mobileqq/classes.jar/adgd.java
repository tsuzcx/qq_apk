import android.widget.ListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class adgd
{
  private int a = -1;
  private int b = -1;
  
  private void a(QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListViewExposeLogic", 2, "reportListItemMessage : exposeItemIndex -> " + paramInt);
    }
    if (paramInt >= 0)
    {
      Object localObject = paramListView.getAdapter();
      if ((localObject != null) && (paramInt < ((ListAdapter)localObject).getCount()))
      {
        localObject = ((ListAdapter)localObject).getItem(paramInt);
        if ((localObject instanceof MessageRecord))
        {
          localObject = (MessageRecord)localObject;
          adgb.a(paramListView.getContext(), paramQQAppInterface, (MessageRecord)localObject, 1);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    int j = paramListView.mFirstPosition;
    int k = paramListView.getChildCount();
    if (QLog.isColorLevel()) {
      QLog.d("ListViewExposeLogic", 2, "reportExposeOnShowFirst : curFirstPosition -> " + j + ", childCount -> " + k);
    }
    int i = j;
    while (i < j + k)
    {
      a(paramQQAppInterface, paramListView, i);
      i += 1;
    }
    this.a = paramListView.mFirstPosition;
    this.b = paramListView.getChildCount();
  }
  
  public void b(QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    int j = paramListView.mFirstPosition;
    int k = paramListView.getChildCount();
    if ((j == this.a) && (this.b == k)) {
      return;
    }
    int i = -1;
    if (j < this.a) {
      i = j;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListViewExposeLogic", 2, "handleListViewScroll : curExposeItemIndex -> " + i + ", curFirstPosition -> " + j + ", childCount -> " + k);
      }
      this.a = j;
      this.b = k;
      a(paramQQAppInterface, paramListView, i);
      return;
      if (j + k > this.a + this.b) {
        i = j + k - 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adgd
 * JD-Core Version:    0.7.0.1
 */