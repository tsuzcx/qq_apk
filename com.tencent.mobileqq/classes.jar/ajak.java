import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajak
  extends aiyz
  implements View.OnClickListener
{
  public ajak(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
  }
  
  public View a(int paramInt, View paramView)
  {
    ajal localajal;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajal)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561549, null);
      localajal = new ajal();
      localajal.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368063));
      paramView.setOnClickListener(this);
      paramView.setTag(localajal);
    }
    for (;;)
    {
      String str = ((ajbv)this.jdField_a_of_type_Ajbn).b;
      localajal.jdField_f_of_type_JavaLangString = str;
      localajal.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(1, str));
      aixk.a += 1;
      return paramView;
      localajal = (ajal)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerifyBlockedBuilder", 2, "start PhoneLaunchActivity");
    }
    aixk.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    bdla.b(null, "dc00898", "", "", "0X800A3A4", "0X800A3A4", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajak
 * JD-Core Version:    0.7.0.1
 */