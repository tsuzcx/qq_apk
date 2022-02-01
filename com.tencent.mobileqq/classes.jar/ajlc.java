import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajlc
  extends ajjr
  implements View.OnClickListener
{
  public ajlc(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
  }
  
  public View a(int paramInt, View paramView)
  {
    ajld localajld;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajld)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561609, null);
      localajld = new ajld();
      localajld.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367895));
      paramView.setOnClickListener(this);
      paramView.setTag(localajld);
    }
    for (;;)
    {
      String str = ((ajmn)this.jdField_a_of_type_Ajmf).b;
      localajld.jdField_f_of_type_JavaLangString = str;
      localajld.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(1, str));
      ajic.a += 1;
      return paramView;
      localajld = (ajld)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerifyBlockedBuilder", 2, "start PhoneLaunchActivity");
    }
    ajic.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    bdll.b(null, "dc00898", "", "", "0X800A3A4", "0X800A3A4", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlc
 * JD-Core Version:    0.7.0.1
 */