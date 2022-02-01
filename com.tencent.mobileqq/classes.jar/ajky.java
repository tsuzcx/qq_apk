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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;

public class ajky
  extends ajjr
  implements View.OnClickListener
{
  public ajky(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajkz)))
    {
      paramView = new ajkz();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561369, null);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      a(localView, ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011) - bhtq.a(80.0F));
      paramView.a = ((Button)localView.findViewById(2131367762));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        paramView.a.setBackgroundResource(2130839313);
      }
      localObject = (ThemeImageView)localView.findViewById(2131367758);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(blqj.b);
      localView.setTag(paramView);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "1", "", "", "");
      localObject = paramView;
    }
    for (;;)
    {
      ((ajkz)localObject).a.setOnClickListener(this);
      return localView;
      localObject = (ajkz)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "1", "", "", "");
    if (bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      ajwm localajwm = (ajwm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295);
      if (localajwm != null) {
        localajwm.b(true);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691989), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajky
 * JD-Core Version:    0.7.0.1
 */