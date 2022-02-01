import android.os.Handler;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.adapter.BaseWhatASmoothAdapter.1;

public abstract class ambp
  extends BaseAdapter
  implements AbsListView.OnScrollListener
{
  protected Handler a;
  public String a;
  
  private final void a(View paramView, Object paramObject, int paramInt, ambq paramambq)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return;
    }
    paramView = new BaseWhatASmoothAdapter.1(this, paramView, localObject, paramObject, paramInt, paramambq);
    ambq.a(paramambq, true);
    ambq.a(paramambq, paramView);
    this.a.post(paramView);
  }
  
  protected abstract Object a(int paramInt);
  
  public abstract void a(View paramView, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambp
 * JD-Core Version:    0.7.0.1
 */