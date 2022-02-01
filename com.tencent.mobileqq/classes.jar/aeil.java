import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aeil
  implements View.OnClickListener
{
  public aeil(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public void onClick(View paramView)
  {
    int k = 0;
    int i;
    int j;
    label37:
    QQToast localQQToast;
    if (MoveToGroupActivity.a(this.a) == null)
    {
      i = 0;
      int m = VipUtils.a(this.a.app, null);
      if ((m & 0x2) == 0) {
        break label120;
      }
      j = 1;
      if ((m & 0x4) != 0) {
        k = 1;
      }
      if ((j == 0) && (k == 0)) {
        break label125;
      }
      if (30 != i) {
        break label168;
      }
      localQQToast = new QQToast(this.a);
      localQQToast.d(2000);
      localQQToast.c(2131719412);
      localQQToast.a();
    }
    label168:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = MoveToGroupActivity.a(this.a).size();
      break;
      label120:
      j = 0;
      break label37;
      label125:
      if (16 == i)
      {
        localQQToast = new QQToast(this.a);
        localQQToast.d(2000);
        localQQToast.c(2131719411);
        localQQToast.a();
      }
      else
      {
        MoveToGroupActivity.a(this.a, bhdj.a(this.a, 2131692982, 2131692988, null, MoveToGroupActivity.a(this.a), null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeil
 * JD-Core Version:    0.7.0.1
 */