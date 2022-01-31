import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aezj
  extends aeyf
  implements View.OnClickListener
{
  public aezj(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
  }
  
  public View a(int paramInt, View paramView)
  {
    aezk localaezk;
    if ((paramView == null) || (!(paramView.getTag() instanceof aezk)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495543, null);
      localaezk = new aezk();
      localaezk.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301766));
      paramView.setOnClickListener(this);
      paramView.setTag(localaezk);
    }
    for (;;)
    {
      String str = ((atdc)this.jdField_a_of_type_Atcu).b;
      localaezk.jdField_f_of_type_JavaLangString = str;
      localaezk.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(1, str));
      ajvr.a += 1;
      return paramView;
      localaezk = (aezk)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerifyBlockedBuilder", 2, "start PhoneLaunchActivity");
    }
    ajvr.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    awqx.b(null, "dc00898", "", "", "0X800A3A4", "0X800A3A4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezj
 * JD-Core Version:    0.7.0.1
 */