import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout;
import java.util.ArrayList;

public class afcb
  extends BaseAdapter
{
  private afcb(RDBaseListLayout paramRDBaseListLayout) {}
  
  public void a() {}
  
  public void b() {}
  
  public int getCount()
  {
    return RDBaseListLayout.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return RDBaseListLayout.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = RDBaseListLayout.a(this.a).get(paramInt);
    if (paramView == null) {
      paramView = this.a.a(paramInt, paramViewGroup);
    }
    for (;;)
    {
      if (paramView == null) {
        paramViewGroup = null;
      }
      View localView;
      do
      {
        return paramViewGroup;
        paramView = (afcc)paramView.getTag();
        if (paramView == null) {
          break label102;
        }
        paramView = paramView.a;
        break;
        this.a.a(paramInt, paramViewGroup, paramView);
        localView = ((afcd)paramView).a();
        paramViewGroup = localView;
      } while (localView == null);
      localView.setTag(new afcc(this.a, paramInt, paramView));
      return localView;
      label102:
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcb
 * JD-Core Version:    0.7.0.1
 */