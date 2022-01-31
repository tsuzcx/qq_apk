import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class akkv
  implements View.OnClickListener
{
  akkv(akkt paramakkt) {}
  
  public void onClick(View paramView)
  {
    if (!akkt.a(this.a)) {
      bdgm.a(akkt.a(this.a), 230, "", alud.a(2131713873), new akkw(this), null).show();
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
        l1 = Long.parseLong(akkt.a(this.a));
      }
      catch (Exception paramView)
      {
        try
        {
          l2 = Long.parseLong((String)localObject);
          akkt.a(this.a).add(localObject);
          ((amdu)akkt.a(this.a).a(20)).c(l1, l2);
          if (akkt.a(this.a) == null) {
            break;
          }
          azqs.b(akkt.a(this.a).app, "dc00898", "", "", "", "0X8009FA0", 0, 0, (String)localObject, "", "", "");
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
 * Qualified Name:     akkv
 * JD-Core Version:    0.7.0.1
 */