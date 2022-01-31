import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.ThemeImageView;

public class aezf
  extends aeyf
  implements View.OnClickListener
{
  public aezf(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof aezg)))
    {
      paramView = new aezg();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495342, null);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      a(localView, ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766) - bajq.a(80.0F));
      paramView.a = ((Button)localView.findViewById(2131301633));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        paramView.a.setBackgroundResource(2130839020);
      }
      localObject = (ThemeImageView)localView.findViewById(2131301630);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(beog.b);
      localView.setTag(paramView);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "1", "", "", "");
      localObject = paramView;
    }
    for (;;)
    {
      ((aezg)localObject).a.setOnClickListener(this);
      return localView;
      localObject = (aezg)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "1", "", "", "");
    if (badq.d(this.jdField_a_of_type_AndroidContentContext))
    {
      paramView = (afgd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295);
      if (paramView != null) {
        paramView.b(true);
      }
      return;
    }
    bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626719), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezf
 * JD-Core Version:    0.7.0.1
 */