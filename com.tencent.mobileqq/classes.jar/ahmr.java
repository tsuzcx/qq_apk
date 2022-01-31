import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ahmr
  extends ahln
  implements View.OnClickListener
{
  public ahmr(Context paramContext, QQAppInterface paramQQAppInterface, akln paramakln, avun paramavun)
  {
    super(paramContext, paramQQAppInterface, paramakln, paramavun);
  }
  
  public View a(int paramInt, View paramView)
  {
    ahms localahms;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahms)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561335, null);
      localahms = new ahms();
      localahms.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367516));
      paramView.setOnClickListener(this);
      paramView.setTag(localahms);
    }
    for (;;)
    {
      String str = ((avuv)this.jdField_a_of_type_Avun).b;
      localahms.jdField_f_of_type_JavaLangString = str;
      localahms.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(1, str));
      amgf.a += 1;
      return paramView;
      localahms = (ahms)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerifyBlockedBuilder", 2, "start PhoneLaunchActivity");
    }
    amgf.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    azqs.b(null, "dc00898", "", "", "0X800A3A4", "0X800A3A4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmr
 * JD-Core Version:    0.7.0.1
 */