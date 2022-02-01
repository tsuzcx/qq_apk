import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;

public class ajla
  extends ajjr
  implements View.OnClickListener
{
  public ajla(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
  }
  
  private void a(TextView paramTextView, ajmf paramajmf)
  {
    if ((paramajmf == null) || (!(paramajmf instanceof ajmm))) {}
    do
    {
      return;
      paramajmf = (ajmm)paramajmf;
    } while ((paramajmf.jdField_a_of_type_JavaUtilArrayList == null) || (paramajmf.jdField_a_of_type_JavaUtilArrayList.size() == 0));
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131698206);
    paramTextView.setVisibility(0);
    paramTextView.setText(str);
    if (paramajmf.jdField_a_of_type_Boolean)
    {
      paramTextView.setPadding(0, bhtq.a(16.0F), 0, bhtq.a(6.0F));
      return;
    }
    paramTextView.setPadding(0, bhtq.a(16.0F), 0, bhtq.a(6.0F));
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajlb)))
    {
      paramView = new ajlb();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561370, null);
      paramView.a = ((TextView)localView.findViewById(2131378348));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      c(((ajlb)localObject).a);
      a(((ajlb)localObject).a, this.jdField_a_of_type_Ajmf);
      localView.setOnClickListener(this);
      return localView;
      localObject = (ajlb)paramView.getTag();
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
      paramView.setBackgroundResource(2130839402);
      return;
    }
    paramView.setBackgroundResource(2130850231);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajla
 * JD-Core Version:    0.7.0.1
 */