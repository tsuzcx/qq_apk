import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;

public class ajai
  extends aiyz
  implements View.OnClickListener
{
  public ajai(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
  }
  
  private void a(TextView paramTextView, ajbn paramajbn)
  {
    if ((paramajbn == null) || (!(paramajbn instanceof ajbu))) {}
    do
    {
      return;
      paramajbn = (ajbu)paramajbn;
    } while ((paramajbn.a == null) || (paramajbn.a.size() == 0));
    paramajbn = this.jdField_a_of_type_AndroidContentContext.getString(2131698667);
    paramTextView.setVisibility(0);
    paramTextView.setText(paramajbn);
    paramTextView.setPadding(0, ViewUtils.dip2px(16.0F), 0, ViewUtils.dip2px(6.0F));
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajaj)))
    {
      paramView = new ajaj();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561306, null);
      paramView.a = ((TextView)localView.findViewById(2131378403));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      c(((ajaj)localObject).a);
      a(((ajaj)localObject).a, this.jdField_a_of_type_Ajbn);
      localView.setOnClickListener(this);
      return localView;
      localObject = (ajaj)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839458);
      return;
    }
    paramView.setBackgroundResource(2130850254);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajai
 * JD-Core Version:    0.7.0.1
 */