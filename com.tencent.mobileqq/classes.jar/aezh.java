import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;

public class aezh
  extends aeyf
  implements View.OnClickListener
{
  public aezh(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
  }
  
  private void a(TextView paramTextView, atcu paramatcu)
  {
    if ((paramatcu == null) || (!(paramatcu instanceof atdb))) {}
    do
    {
      return;
      paramatcu = (atdb)paramatcu;
    } while ((paramatcu.jdField_a_of_type_JavaUtilArrayList == null) || (paramatcu.jdField_a_of_type_JavaUtilArrayList.size() == 0));
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131633450);
    paramTextView.setVisibility(0);
    paramTextView.setText(str);
    if (paramatcu.jdField_a_of_type_Boolean)
    {
      paramTextView.setPadding(0, bajq.a(16.0F), 0, bajq.a(6.0F));
      return;
    }
    paramTextView.setPadding(0, bajq.a(16.0F), 0, bajq.a(6.0F));
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof aezi)))
    {
      paramView = new aezi();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495343, null);
      paramView.a = ((TextView)localView.findViewById(2131310988));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      c(((aezi)localObject).a);
      a(((aezi)localObject).a, this.jdField_a_of_type_Atcu);
      localView.setOnClickListener(this);
      return localView;
      localObject = (aezi)paramView.getTag();
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
      paramView.setBackgroundResource(2130839104);
      return;
    }
    paramView.setBackgroundResource(2130848902);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezh
 * JD-Core Version:    0.7.0.1
 */