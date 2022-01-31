import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;

public class ahmp
  extends ahln
  implements View.OnClickListener
{
  public ahmp(Context paramContext, QQAppInterface paramQQAppInterface, akln paramakln, avun paramavun)
  {
    super(paramContext, paramQQAppInterface, paramakln, paramavun);
  }
  
  private void a(TextView paramTextView, avun paramavun)
  {
    if ((paramavun == null) || (!(paramavun instanceof avuu))) {}
    do
    {
      return;
      paramavun = (avuu)paramavun;
    } while ((paramavun.jdField_a_of_type_JavaUtilArrayList == null) || (paramavun.jdField_a_of_type_JavaUtilArrayList.size() == 0));
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131699568);
    paramTextView.setVisibility(0);
    paramTextView.setText(str);
    if (paramavun.jdField_a_of_type_Boolean)
    {
      paramTextView.setPadding(0, bdoo.a(16.0F), 0, bdoo.a(6.0F));
      return;
    }
    paramTextView.setPadding(0, bdoo.a(16.0F), 0, bdoo.a(6.0F));
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahmq)))
    {
      paramView = new ahmq();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561121, null);
      paramView.a = ((TextView)localView.findViewById(2131377366));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      c(((ahmq)localObject).a);
      a(((ahmq)localObject).a, this.jdField_a_of_type_Avun);
      localView.setOnClickListener(this);
      return localView;
      localObject = (ahmq)paramView.getTag();
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
      paramView.setBackgroundResource(2130839217);
      return;
    }
    paramView.setBackgroundResource(2130849643);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmp
 * JD-Core Version:    0.7.0.1
 */