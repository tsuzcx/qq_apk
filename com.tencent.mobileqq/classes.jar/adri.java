import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class adri
  implements View.OnClickListener
{
  public adri(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int k = VipUtils.a(this.a.app, null);
    int i;
    label31:
    QQToast localQQToast;
    if ((k & 0x2) != 0)
    {
      i = 1;
      if ((k & 0x4) == 0) {
        break label103;
      }
      if ((i == 0) && (j == 0)) {
        break label108;
      }
      if (30 != MoveToGroupActivity.a(this.a).size()) {
        break label162;
      }
      localQQToast = new QQToast(this.a);
      localQQToast.d(2000);
      localQQToast.c(2131719007);
      localQQToast.a();
    }
    label162:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      label103:
      j = 0;
      break label31;
      label108:
      if (16 == MoveToGroupActivity.a(this.a).size())
      {
        localQQToast = new QQToast(this.a);
        localQQToast.d(2000);
        localQQToast.c(2131719006);
        localQQToast.a();
      }
      else
      {
        MoveToGroupActivity.a(this.a, bfur.a(this.a, 2131692876, 2131692882, null, MoveToGroupActivity.a(this.a), null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adri
 * JD-Core Version:    0.7.0.1
 */