import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public class afkp
  extends afjt
  implements View.OnClickListener
{
  public afkp(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
  }
  
  public View a(int paramInt, View paramView)
  {
    afkq localafkq;
    if ((paramView == null) || (!(paramView.getTag() instanceof afkq)))
    {
      localafkq = new afkq();
      paramView = LayoutInflater.from(this.a).inflate(2131560923, null);
      paramView.setTag(localafkq);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      return paramView;
      localafkq = (afkq)paramView.getTag();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkp
 * JD-Core Version:    0.7.0.1
 */