import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;

public class agzl
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
    if (paramView == null) {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559257, paramViewGroup, false);
    }
    for (paramViewGroup = new agzm(paramView);; paramViewGroup = (agzm)paramView.getTag())
    {
      paramViewGroup.a.setText(str);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzl
 * JD-Core Version:    0.7.0.1
 */