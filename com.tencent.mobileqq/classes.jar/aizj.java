import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendSubTitle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aizj
  extends aiyi
  implements View.OnClickListener
{
  public aizj(Context paramContext, QQAppInterface paramQQAppInterface, ajae paramajae, ajax paramajax)
  {
    super(paramContext, paramQQAppInterface, paramajae, paramajax);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof aizk)))
    {
      localObject = new aizk();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561334, null);
      ((aizk)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378776));
      ((aizk)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366048);
      ((aizk)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.setTag(localObject);
      ((aizk)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((ajba)this.jdField_a_of_type_Ajax).a.title);
      localObject = ((aizk)localObject).jdField_a_of_type_AndroidViewView;
      if (!((ajba)this.jdField_a_of_type_Ajax).a.showEntrance) {
        break label133;
      }
    }
    label133:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      return paramView;
      localObject = (aizk)paramView.getTag();
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aiwt.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      bcst.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizj
 * JD-Core Version:    0.7.0.1
 */