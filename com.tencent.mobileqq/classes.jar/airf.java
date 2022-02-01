import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class airf
  extends BaseAdapter
{
  public Handler a;
  public QQAppInterface a;
  public String[] a;
  
  public String a(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.length;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = a(paramInt);
    View localView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559393, paramViewGroup, false);
    }
    airg localairg;
    for (paramView = new airg(localView);; paramView = localairg)
    {
      paramView.a.setText(str);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localairg = (airg)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airf
 * JD-Core Version:    0.7.0.1
 */