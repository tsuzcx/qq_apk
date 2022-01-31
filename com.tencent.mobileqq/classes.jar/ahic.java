import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ahic
  extends ahgy
  implements View.OnClickListener
{
  public ahic(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
  }
  
  public View a(int paramInt, View paramView)
  {
    ahid localahid;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahid)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561317, null);
      localahid = new ahid();
      localahid.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367506));
      paramView.setOnClickListener(this);
      paramView.setTag(localahid);
    }
    for (;;)
    {
      String str = ((avqm)this.jdField_a_of_type_Avqe).b;
      localahid.jdField_f_of_type_JavaLangString = str;
      localahid.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(1, str));
      ambq.a += 1;
      return paramView;
      localahid = (ahid)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerifyBlockedBuilder", 2, "start PhoneLaunchActivity");
    }
    ambq.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    azmj.b(null, "dc00898", "", "", "0X800A3A4", "0X800A3A4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahic
 * JD-Core Version:    0.7.0.1
 */