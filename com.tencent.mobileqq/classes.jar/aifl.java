import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aifl
  extends aiea
  implements View.OnClickListener
{
  public aifl(Context paramContext, QQAppInterface paramQQAppInterface, aifw paramaifw, aigo paramaigo)
  {
    super(paramContext, paramQQAppInterface, paramaifw, paramaigo);
  }
  
  public View a(int paramInt, View paramView)
  {
    aifm localaifm;
    if ((paramView == null) || (!(paramView.getTag() instanceof aifm)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561487, null);
      localaifm = new aifm();
      localaifm.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367927));
      paramView.setOnClickListener(this);
      paramView.setTag(localaifm);
    }
    for (;;)
    {
      String str = ((aigw)this.jdField_a_of_type_Aigo).b;
      localaifm.jdField_f_of_type_JavaLangString = str;
      localaifm.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(1, str));
      aicl.a += 1;
      return paramView;
      localaifm = (aifm)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerifyBlockedBuilder", 2, "start PhoneLaunchActivity");
    }
    aicl.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    bcef.b(null, "dc00898", "", "", "0X800A3A4", "0X800A3A4", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifl
 * JD-Core Version:    0.7.0.1
 */