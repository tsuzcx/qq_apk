import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class aejv
  implements AdapterView.OnItemLongClickListener
{
  public aejv(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Comments.Comment)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null) {
      return true;
    }
    paramLong = Long.parseLong(this.a.a.getCurrentAccountUin());
    if (paramAdapterView.c == paramLong)
    {
      ShortVideoCommentsView.b(this.a, paramAdapterView);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aejv
 * JD-Core Version:    0.7.0.1
 */