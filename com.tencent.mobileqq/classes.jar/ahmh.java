import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendSubTitle;

public class ahmh
  extends ahln
  implements View.OnClickListener
{
  public ahmh(Context paramContext, QQAppInterface paramQQAppInterface, akln paramakln, avun paramavun)
  {
    super(paramContext, paramQQAppInterface, paramakln, paramavun);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahmi)))
    {
      localObject = new ahmi();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561123, null);
      ((ahmi)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377938));
      ((ahmi)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365801);
      ((ahmi)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.setTag(localObject);
      ((ahmi)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((avuq)this.jdField_a_of_type_Avun).a.title);
      localObject = ((ahmi)localObject).jdField_a_of_type_AndroidViewView;
      if (!((avuq)this.jdField_a_of_type_Avun).a.showEntrance) {
        break label133;
      }
    }
    label133:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      return paramView;
      localObject = (ahmi)paramView.getTag();
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
    amgf.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    azqs.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmh
 * JD-Core Version:    0.7.0.1
 */