import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendSubTitle;

public class afkn
  extends afjt
  implements View.OnClickListener
{
  public afkn(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof afko)))
    {
      localObject = new afko();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560922, null);
      ((afko)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377350));
      ((afko)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365715);
      ((afko)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.setTag(localObject);
      ((afko)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((atzd)this.jdField_a_of_type_Atza).a.title);
      localObject = ((afko)localObject).jdField_a_of_type_AndroidViewView;
      if (!((atzd)this.jdField_a_of_type_Atza).a.showEntrance) {
        break label133;
      }
    }
    label133:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      return paramView;
      localObject = (afko)paramView.getTag();
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
    akka.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    axqy.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkn
 * JD-Core Version:    0.7.0.1
 */