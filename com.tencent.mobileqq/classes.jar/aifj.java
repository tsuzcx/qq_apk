import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;

public class aifj
  extends aiea
  implements View.OnClickListener
{
  public aifj(Context paramContext, QQAppInterface paramQQAppInterface, aifw paramaifw, aigo paramaigo)
  {
    super(paramContext, paramQQAppInterface, paramaifw, paramaigo);
  }
  
  private void a(TextView paramTextView, aigo paramaigo)
  {
    if ((paramaigo == null) || (!(paramaigo instanceof aigv))) {}
    do
    {
      return;
      paramaigo = (aigv)paramaigo;
    } while ((paramaigo.a == null) || (paramaigo.a.size() == 0));
    paramaigo = this.jdField_a_of_type_AndroidContentContext.getString(2131698371);
    paramTextView.setVisibility(0);
    paramTextView.setText(paramaigo);
    paramTextView.setPadding(0, ViewUtils.dip2px(16.0F), 0, ViewUtils.dip2px(6.0F));
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof aifk)))
    {
      paramView = new aifk();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561245, null);
      paramView.a = ((TextView)localView.findViewById(2131378115));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      c(((aifk)localObject).a);
      a(((aifk)localObject).a, this.jdField_a_of_type_Aigo);
      localView.setOnClickListener(this);
      return localView;
      localObject = (aifk)paramView.getTag();
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
      paramView.setBackgroundResource(2130839437);
      return;
    }
    paramView.setBackgroundResource(2130850152);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifj
 * JD-Core Version:    0.7.0.1
 */