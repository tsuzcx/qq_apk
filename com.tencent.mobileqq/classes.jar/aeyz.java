import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendSubTitle;

public class aeyz
  extends aeyf
  implements View.OnClickListener
{
  public aeyz(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof aeza)))
    {
      localObject = new aeza();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495345, null);
      ((aeza)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311534));
      ((aeza)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131300119);
      ((aeza)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.setTag(localObject);
      ((aeza)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((atcx)this.jdField_a_of_type_Atcu).a.title);
      localObject = ((aeza)localObject).jdField_a_of_type_AndroidViewView;
      if (!((atcx)this.jdField_a_of_type_Atcu).a.showEntrance) {
        break label133;
      }
    }
    label133:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      return paramView;
      localObject = (aeza)paramView.getTag();
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
    ajvr.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    awqx.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeyz
 * JD-Core Version:    0.7.0.1
 */