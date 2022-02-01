import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adzi
  implements View.OnClickListener
{
  public adzi(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!agdu.b())
      {
        String str = this.a.a.jdField_a_of_type_JavaLangString;
        if (this.a.a.jdField_a_of_type_Int == 1006) {
          str = this.a.a.f;
        }
        switch (((Integer)localObject).intValue())
        {
        default: 
          break;
        case 1: 
          BaseChatPie.a(this.a, str);
          break;
        case 2: 
          BaseChatPie.b(this.a, str);
          break;
        case 3: 
          BaseChatPie.c(this.a);
          break;
        case 4: 
          BaseChatPie.d(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzi
 * JD-Core Version:    0.7.0.1
 */