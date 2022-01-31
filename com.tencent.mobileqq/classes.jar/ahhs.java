import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendSubTitle;

public class ahhs
  extends ahgy
  implements View.OnClickListener
{
  public ahhs(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahht)))
    {
      localObject = new ahht();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561105, null);
      ((ahht)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377884));
      ((ahht)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365799);
      ((ahht)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.setTag(localObject);
      ((ahht)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((avqh)this.jdField_a_of_type_Avqe).a.title);
      localObject = ((ahht)localObject).jdField_a_of_type_AndroidViewView;
      if (!((avqh)this.jdField_a_of_type_Avqe).a.showEntrance) {
        break label133;
      }
    }
    label133:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      return paramView;
      localObject = (ahht)paramView.getTag();
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
    ambq.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    azmj.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhs
 * JD-Core Version:    0.7.0.1
 */