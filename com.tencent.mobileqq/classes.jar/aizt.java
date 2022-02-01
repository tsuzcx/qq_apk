import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aizt
  extends aiyi
  implements View.OnClickListener
{
  public aizt(Context paramContext, QQAppInterface paramQQAppInterface, ajae paramajae, ajax paramajax)
  {
    super(paramContext, paramQQAppInterface, paramajae, paramajax);
  }
  
  public View a(int paramInt, View paramView)
  {
    aizu localaizu;
    if ((paramView == null) || (!(paramView.getTag() instanceof aizu)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561568, null);
      localaizu = new aizu();
      localaizu.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367826));
      paramView.setOnClickListener(this);
      paramView.setTag(localaizu);
    }
    for (;;)
    {
      String str = ((ajbf)this.jdField_a_of_type_Ajax).b;
      localaizu.jdField_f_of_type_JavaLangString = str;
      localaizu.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(1, str));
      aiwt.a += 1;
      return paramView;
      localaizu = (aizu)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerifyBlockedBuilder", 2, "start PhoneLaunchActivity");
    }
    aiwt.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    bcst.b(null, "dc00898", "", "", "0X800A3A4", "0X800A3A4", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizt
 * JD-Core Version:    0.7.0.1
 */