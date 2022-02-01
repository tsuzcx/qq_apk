import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public class ajku
  extends ajjr
  implements View.OnClickListener
{
  public ajku(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
  }
  
  public View a(int paramInt, View paramView)
  {
    ajkv localajkv;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajkv)))
    {
      localajkv = new ajkv();
      paramView = LayoutInflater.from(this.a).inflate(2131561374, null);
      paramView.setTag(localajkv);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      return paramView;
      localajkv = (ajkv)paramView.getTag();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajku
 * JD-Core Version:    0.7.0.1
 */