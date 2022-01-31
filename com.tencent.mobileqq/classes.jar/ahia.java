import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;

public class ahia
  extends ahgy
  implements View.OnClickListener
{
  public ahia(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
  }
  
  private void a(TextView paramTextView, avqe paramavqe)
  {
    if ((paramavqe == null) || (!(paramavqe instanceof avql))) {}
    do
    {
      return;
      paramavqe = (avql)paramavqe;
    } while ((paramavqe.jdField_a_of_type_JavaUtilArrayList == null) || (paramavqe.jdField_a_of_type_JavaUtilArrayList.size() == 0));
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131699556);
    paramTextView.setVisibility(0);
    paramTextView.setText(str);
    if (paramavqe.jdField_a_of_type_Boolean)
    {
      paramTextView.setPadding(0, bdkf.a(16.0F), 0, bdkf.a(6.0F));
      return;
    }
    paramTextView.setPadding(0, bdkf.a(16.0F), 0, bdkf.a(6.0F));
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahib)))
    {
      paramView = new ahib();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561103, null);
      paramView.a = ((TextView)localView.findViewById(2131377312));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      c(((ahib)localObject).a);
      a(((ahib)localObject).a, this.jdField_a_of_type_Avqe);
      localView.setOnClickListener(this);
      return localView;
      localObject = (ahib)paramView.getTag();
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
      paramView.setBackgroundResource(2130839216);
      return;
    }
    paramView.setBackgroundResource(2130849570);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahia
 * JD-Core Version:    0.7.0.1
 */