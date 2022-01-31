import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public class ahhu
  extends ahgy
  implements View.OnClickListener
{
  public ahhu(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
  }
  
  public View a(int paramInt, View paramView)
  {
    ahhv localahhv;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahhv)))
    {
      localahhv = new ahhv();
      paramView = LayoutInflater.from(this.a).inflate(2131561106, null);
      paramView.setTag(localahhv);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      return paramView;
      localahhv = (ahhv)paramView.getTag();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhu
 * JD-Core Version:    0.7.0.1
 */