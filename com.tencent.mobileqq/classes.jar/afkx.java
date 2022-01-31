import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;

public class afkx
  extends afjv
  implements View.OnClickListener
{
  public afkx(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
  }
  
  private void a(TextView paramTextView, atyy paramatyy)
  {
    if ((paramatyy == null) || (!(paramatyy instanceof atzf))) {}
    do
    {
      return;
      paramatyy = (atzf)paramatyy;
    } while ((paramatyy.jdField_a_of_type_JavaUtilArrayList == null) || (paramatyy.jdField_a_of_type_JavaUtilArrayList.size() == 0));
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131699200);
    paramTextView.setVisibility(0);
    paramTextView.setText(str);
    if (paramatyy.jdField_a_of_type_Boolean)
    {
      paramTextView.setPadding(0, bbkx.a(16.0F), 0, bbkx.a(6.0F));
      return;
    }
    paramTextView.setPadding(0, bbkx.a(16.0F), 0, bbkx.a(6.0F));
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof afky)))
    {
      paramView = new afky();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560921, null);
      paramView.a = ((TextView)localView.findViewById(2131376797));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      c(((afky)localObject).a);
      a(((afky)localObject).a, this.jdField_a_of_type_Atyy);
      localView.setOnClickListener(this);
      return localView;
      localObject = (afky)paramView.getTag();
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
    paramView.setBackgroundResource(2130849130);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkx
 * JD-Core Version:    0.7.0.1
 */