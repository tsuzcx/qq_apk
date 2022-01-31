import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afkz
  extends afjv
  implements View.OnClickListener
{
  public afkz(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
  }
  
  public View a(int paramInt, View paramView)
  {
    afla localafla;
    if ((paramView == null) || (!(paramView.getTag() instanceof afla)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561131, null);
      localafla = new afla();
      localafla.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367376));
      paramView.setOnClickListener(this);
      paramView.setTag(localafla);
    }
    for (;;)
    {
      String str = ((atzg)this.jdField_a_of_type_Atyy).b;
      localafla.jdField_f_of_type_JavaLangString = str;
      localafla.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(1, str));
      akkb.a += 1;
      return paramView;
      localafla = (afla)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerifyBlockedBuilder", 2, "start PhoneLaunchActivity");
    }
    akkb.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    axqw.b(null, "dc00898", "", "", "0X800A3A4", "0X800A3A4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkz
 * JD-Core Version:    0.7.0.1
 */