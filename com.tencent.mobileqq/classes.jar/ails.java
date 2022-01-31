import android.os.Handler;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.adapter.BaseWhatASmoothAdapter.1;

public abstract class ails
  extends BaseAdapter
  implements AbsListView.OnScrollListener
{
  protected Handler a;
  public String a;
  
  private final void a(View paramView, Object paramObject, int paramInt, ailt paramailt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return;
    }
    paramView = new BaseWhatASmoothAdapter.1(this, paramView, localObject, paramObject, paramInt, paramailt);
    ailt.a(paramailt, true);
    ailt.a(paramailt, paramView);
    this.a.post(paramView);
  }
  
  protected abstract Object a(int paramInt);
  
  public abstract void a(View paramView, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ails
 * JD-Core Version:    0.7.0.1
 */