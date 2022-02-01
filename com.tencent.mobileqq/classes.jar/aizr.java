import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;

public class aizr
  extends aiyi
  implements View.OnClickListener
{
  public aizr(Context paramContext, QQAppInterface paramQQAppInterface, ajae paramajae, ajax paramajax)
  {
    super(paramContext, paramQQAppInterface, paramajae, paramajax);
  }
  
  private void a(TextView paramTextView, ajax paramajax)
  {
    if ((paramajax == null) || (!(paramajax instanceof ajbe))) {}
    do
    {
      return;
      paramajax = (ajbe)paramajax;
    } while ((paramajax.jdField_a_of_type_JavaUtilArrayList == null) || (paramajax.jdField_a_of_type_JavaUtilArrayList.size() == 0));
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131698105);
    paramTextView.setVisibility(0);
    paramTextView.setText(str);
    if (paramajax.jdField_a_of_type_Boolean)
    {
      paramTextView.setPadding(0, bgtn.a(16.0F), 0, bgtn.a(6.0F));
      return;
    }
    paramTextView.setPadding(0, bgtn.a(16.0F), 0, bgtn.a(6.0F));
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof aizs)))
    {
      paramView = new aizs();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561332, null);
      paramView.a = ((TextView)localView.findViewById(2131378191));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      c(((aizs)localObject).a);
      a(((aizs)localObject).a, this.jdField_a_of_type_Ajax);
      localView.setOnClickListener(this);
      return localView;
      localObject = (aizs)paramView.getTag();
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
      paramView.setBackgroundResource(2130839394);
      return;
    }
    paramView.setBackgroundResource(2130850219);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizr
 * JD-Core Version:    0.7.0.1
 */