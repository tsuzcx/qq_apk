import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public class aezb
  extends aeyf
  implements View.OnClickListener
{
  public aezb(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
  }
  
  public View a(int paramInt, View paramView)
  {
    aezc localaezc;
    if ((paramView == null) || (!(paramView.getTag() instanceof aezc)))
    {
      localaezc = new aezc();
      paramView = LayoutInflater.from(this.a).inflate(2131495346, null);
      paramView.setTag(localaezc);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      return paramView;
      localaezc = (aezc)paramView.getTag();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezb
 * JD-Core Version:    0.7.0.1
 */