import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public class afkr
  extends afjv
  implements View.OnClickListener
{
  public afkr(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
  }
  
  public View a(int paramInt, View paramView)
  {
    afks localafks;
    if ((paramView == null) || (!(paramView.getTag() instanceof afks)))
    {
      localafks = new afks();
      paramView = LayoutInflater.from(this.a).inflate(2131560924, null);
      paramView.setTag(localafks);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      return paramView;
      localafks = (afks)paramView.getTag();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkr
 * JD-Core Version:    0.7.0.1
 */