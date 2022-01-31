import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class akgg
  implements View.OnClickListener
{
  akgg(akge paramakge) {}
  
  public void onClick(View paramView)
  {
    if (!akge.a(this.a)) {
      bdcd.a(akge.a(this.a), 230, "", alpo.a(2131713861), new akgh(this), null).show();
    }
    do
    {
      return;
      localObject = paramView.getTag();
    } while ((localObject == null) || (!(localObject instanceof String)));
    if ((paramView instanceof Button))
    {
      paramView = (Button)paramView;
      if (paramView != null) {
        paramView.setEnabled(false);
      }
    }
    Object localObject = (String)localObject;
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(akge.a(this.a));
      }
      catch (Exception paramView)
      {
        try
        {
          l2 = Long.parseLong((String)localObject);
          akge.a(this.a).add(localObject);
          ((alzf)akge.a(this.a).a(20)).c(l1, l2);
          if (akge.a(this.a) == null) {
            break;
          }
          azmj.b(akge.a(this.a).app, "dc00898", "", "", "", "0X8009FA0", 0, 0, (String)localObject, "", "", "");
          return;
        }
        catch (Exception paramView)
        {
          long l1;
          long l2;
          break label189;
        }
        paramView = paramView;
        l1 = 0L;
      }
      label189:
      if (QLog.isColorLevel()) {
        QLog.d("RobotAdapter", 2, "parseLong err", paramView);
      }
      l2 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgg
 * JD-Core Version:    0.7.0.1
 */