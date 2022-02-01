import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendSubTitle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajaa
  extends aiyz
  implements View.OnClickListener
{
  public ajaa(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajab)))
    {
      localObject = new ajab();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561309, null);
      ((ajab)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379001));
      ((ajab)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366224);
      ((ajab)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.setTag(localObject);
      ((ajab)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((ajbq)this.jdField_a_of_type_Ajbn).a.title);
      localObject = ((ajab)localObject).jdField_a_of_type_AndroidViewView;
      if (!((ajbq)this.jdField_a_of_type_Ajbn).a.showEntrance) {
        break label133;
      }
    }
    label133:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      return paramView;
      localObject = (ajab)paramView.getTag();
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
      aixk.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      bdla.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajaa
 * JD-Core Version:    0.7.0.1
 */