import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;

public class afkv
  extends afjt
  implements View.OnClickListener
{
  public afkv(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
  }
  
  private void a(TextView paramTextView, atza paramatza)
  {
    if ((paramatza == null) || (!(paramatza instanceof atzh))) {}
    do
    {
      return;
      paramatza = (atzh)paramatza;
    } while ((paramatza.jdField_a_of_type_JavaUtilArrayList == null) || (paramatza.jdField_a_of_type_JavaUtilArrayList.size() == 0));
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131699210);
    paramTextView.setVisibility(0);
    paramTextView.setText(str);
    if (paramatza.jdField_a_of_type_Boolean)
    {
      paramTextView.setPadding(0, bbll.a(16.0F), 0, bbll.a(6.0F));
      return;
    }
    paramTextView.setPadding(0, bbll.a(16.0F), 0, bbll.a(6.0F));
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof afkw)))
    {
      paramView = new afkw();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560920, null);
      paramView.a = ((TextView)localView.findViewById(2131376799));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      c(((afkw)localObject).a);
      a(((afkw)localObject).a, this.jdField_a_of_type_Atza);
      localView.setOnClickListener(this);
      return localView;
      localObject = (afkw)paramView.getTag();
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
      paramView.setBackgroundResource(2130839132);
      return;
    }
    paramView.setBackgroundResource(2130849139);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkv
 * JD-Core Version:    0.7.0.1
 */