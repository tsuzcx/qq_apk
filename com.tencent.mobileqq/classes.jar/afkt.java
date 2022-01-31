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

public class afkt
  extends afjt
  implements View.OnClickListener
{
  public afkt(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof afku)))
    {
      paramView = new afku();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560919, null);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      a(localView, ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865) - bbll.a(80.0F));
      paramView.a = ((Button)localView.findViewById(2131367245));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        paramView.a.setBackgroundResource(2130839048);
      }
      localObject = (ThemeImageView)localView.findViewById(2131367242);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(bfwr.b);
      localView.setTag(paramView);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "1", "", "", "");
      localObject = paramView;
    }
    for (;;)
    {
      ((afku)localObject).a.setOnClickListener(this);
      return localView;
      localObject = (afku)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "1", "", "", "");
    if (bbfj.d(this.jdField_a_of_type_AndroidContentContext))
    {
      paramView = (afry)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295);
      if (paramView != null) {
        paramView.b(true);
      }
      return;
    }
    bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692321), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkt
 * JD-Core Version:    0.7.0.1
 */