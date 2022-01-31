import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afkx
  extends afjt
  implements View.OnClickListener
{
  public afkx(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
  }
  
  public View a(int paramInt, View paramView)
  {
    afky localafky;
    if ((paramView == null) || (!(paramView.getTag() instanceof afky)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561130, null);
      localafky = new afky();
      localafky.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367376));
      paramView.setOnClickListener(this);
      paramView.setTag(localafky);
    }
    for (;;)
    {
      String str = ((atzi)this.jdField_a_of_type_Atza).b;
      localafky.jdField_f_of_type_JavaLangString = str;
      localafky.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(1, str));
      akka.a += 1;
      return paramView;
      localafky = (afky)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerifyBlockedBuilder", 2, "start PhoneLaunchActivity");
    }
    akka.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    axqy.b(null, "dc00898", "", "", "0X800A3A4", "0X800A3A4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkx
 * JD-Core Version:    0.7.0.1
 */