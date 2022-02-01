import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendSubTitle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajks
  extends ajjr
  implements View.OnClickListener
{
  public ajks(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajkt)))
    {
      localObject = new ajkt();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561373, null);
      ((ajkt)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378936));
      ((ajkt)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366094);
      ((ajkt)localObject).jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.setTag(localObject);
      ((ajkt)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(((ajmi)this.jdField_a_of_type_Ajmf).a.title);
      localObject = ((ajkt)localObject).jdField_a_of_type_AndroidViewView;
      if (!((ajmi)this.jdField_a_of_type_Ajmf).a.showEntrance) {
        break label133;
      }
    }
    label133:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      return paramView;
      localObject = (ajkt)paramView.getTag();
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
      ajic.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      bdll.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajks
 * JD-Core Version:    0.7.0.1
 */