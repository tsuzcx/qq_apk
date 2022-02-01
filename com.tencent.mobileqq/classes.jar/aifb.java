import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendSubTitle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aifb
  extends aiea
  implements View.OnClickListener
{
  public aifb(Context paramContext, QQAppInterface paramQQAppInterface, aifw paramaifw, aigo paramaigo)
  {
    super(paramContext, paramQQAppInterface, paramaifw, paramaigo);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof aifc)))
    {
      localObject = new aifc();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561248, null);
      ((aifc)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378707));
      ((aifc)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366123);
      ((aifc)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.setTag(localObject);
      ((aifc)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((aigr)this.jdField_a_of_type_Aigo).a.title);
      localObject = ((aifc)localObject).jdField_a_of_type_AndroidViewView;
      if (!((aigr)this.jdField_a_of_type_Aigo).a.showEntrance) {
        break label133;
      }
    }
    label133:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      return paramView;
      localObject = (aifc)paramView.getTag();
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
      aicl.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      bcef.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifb
 * JD-Core Version:    0.7.0.1
 */