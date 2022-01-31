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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ThemeImageView;

public class ahhy
  extends ahgy
  implements View.OnClickListener
{
  public ahhy(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahhz)))
    {
      paramView = new ahhz();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561102, null);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      a(localView, ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914) - bdkf.a(80.0F));
      paramView.a = ((Button)localView.findViewById(2131367375));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        paramView.a.setBackgroundResource(2130839129);
      }
      localObject = (ThemeImageView)localView.findViewById(2131367372);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(bhxo.b);
      localView.setTag(paramView);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "1", "", "", "");
      localObject = paramView;
    }
    for (;;)
    {
      ((ahhz)localObject).a.setOnClickListener(this);
      return localView;
      localObject = (ahhz)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "1", "", "", "");
    if (bdee.d(this.jdField_a_of_type_AndroidContentContext))
    {
      paramView = (ahpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295);
      if (paramView != null) {
        paramView.b(true);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692397), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhy
 * JD-Core Version:    0.7.0.1
 */