import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public class aizl
  extends aiyi
  implements View.OnClickListener
{
  public aizl(Context paramContext, QQAppInterface paramQQAppInterface, ajae paramajae, ajax paramajax)
  {
    super(paramContext, paramQQAppInterface, paramajae, paramajax);
  }
  
  public View a(int paramInt, View paramView)
  {
    aizm localaizm;
    if ((paramView == null) || (!(paramView.getTag() instanceof aizm)))
    {
      localaizm = new aizm();
      paramView = LayoutInflater.from(this.a).inflate(2131561335, null);
      paramView.setTag(localaizm);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      return paramView;
      localaizm = (aizm)paramView.getTag();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizl
 * JD-Core Version:    0.7.0.1
 */