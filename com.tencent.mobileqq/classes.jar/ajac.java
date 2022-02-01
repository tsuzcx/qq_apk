import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public class ajac
  extends aiyz
  implements View.OnClickListener
{
  public ajac(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
  }
  
  public View a(int paramInt, View paramView)
  {
    ajad localajad;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajad)))
    {
      localajad = new ajad();
      paramView = LayoutInflater.from(this.a).inflate(2131561310, null);
      paramView.setTag(localajad);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      return paramView;
      localajad = (ajad)paramView.getTag();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajac
 * JD-Core Version:    0.7.0.1
 */