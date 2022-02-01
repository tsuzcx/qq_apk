import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public class aifd
  extends aiea
  implements View.OnClickListener
{
  public aifd(Context paramContext, QQAppInterface paramQQAppInterface, aifw paramaifw, aigo paramaigo)
  {
    super(paramContext, paramQQAppInterface, paramaifw, paramaigo);
  }
  
  public View a(int paramInt, View paramView)
  {
    aife localaife;
    if ((paramView == null) || (!(paramView.getTag() instanceof aife)))
    {
      localaife = new aife();
      paramView = LayoutInflater.from(this.a).inflate(2131561249, null);
      paramView.setTag(localaife);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      return paramView;
      localaife = (aife)paramView.getTag();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifd
 * JD-Core Version:    0.7.0.1
 */