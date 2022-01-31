import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendSubTitle;

public class afkp
  extends afjv
  implements View.OnClickListener
{
  public afkp(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof afkq)))
    {
      localObject = new afkq();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560923, null);
      ((afkq)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377350));
      ((afkq)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365716);
      ((afkq)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.setTag(localObject);
      ((afkq)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((atzb)this.jdField_a_of_type_Atyy).a.title);
      localObject = ((afkq)localObject).jdField_a_of_type_AndroidViewView;
      if (!((atzb)this.jdField_a_of_type_Atyy).a.showEntrance) {
        break label133;
      }
    }
    label133:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      return paramView;
      localObject = (afkq)paramView.getTag();
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    akkb.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    axqw.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkp
 * JD-Core Version:    0.7.0.1
 */