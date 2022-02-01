import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class agro
  extends BaseAdapter
{
  private agro(RDBaseListLayout paramRDBaseListLayout) {}
  
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
    Object localObject2 = RDBaseListLayout.a(this.a).get(paramInt);
    Object localObject1;
    if (paramView == null) {
      localObject1 = this.a.a(paramInt, localObject2);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject2 = null;
        localObject1 = paramView;
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject2;
        localObject1 = (agrp)paramView.getTag();
        if (localObject1 == null) {
          break label141;
        }
        localObject1 = ((agrp)localObject1).a;
        break;
        this.a.a(paramInt, localObject2, localObject1);
        localObject2 = ((agrq)localObject1).a();
        if (localObject2 != null) {
          ((View)localObject2).setTag(new agrp(this.a, paramInt, localObject1));
        }
        paramView = (View)localObject2;
        localObject1 = localObject2;
        localObject2 = paramView;
      }
      label141:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agro
 * JD-Core Version:    0.7.0.1
 */