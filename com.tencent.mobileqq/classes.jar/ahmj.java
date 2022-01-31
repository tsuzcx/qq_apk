import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public class ahmj
  extends ahln
  implements View.OnClickListener
{
  public ahmj(Context paramContext, QQAppInterface paramQQAppInterface, akln paramakln, avun paramavun)
  {
    super(paramContext, paramQQAppInterface, paramakln, paramavun);
  }
  
  public View a(int paramInt, View paramView)
  {
    ahmk localahmk;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahmk)))
    {
      localahmk = new ahmk();
      paramView = LayoutInflater.from(this.a).inflate(2131561124, null);
      paramView.setTag(localahmk);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      return paramView;
      localahmk = (ahmk)paramView.getTag();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmj
 * JD-Core Version:    0.7.0.1
 */