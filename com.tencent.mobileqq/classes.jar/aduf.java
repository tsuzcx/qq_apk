import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aduf
  implements View.OnClickListener
{
  public aduf(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    bdll.b(this.a.app, "CliOper", "", "", "Verification_msg", "Vfc_answ_clk", 0, 0, "", "", "", "");
    Object localObject1 = this.a;
    int i;
    if (AddRequestActivity.a(this.a) == 3999)
    {
      i = 3041;
      AddRequestActivity.a((AddRequestActivity)localObject1, i);
      Object localObject2 = (anyw)this.a.app.getManager(51);
      boolean bool = ((anyw)localObject2).b(this.a.a);
      localObject1 = agej.a(new Intent(this.a, SplashActivity.class), null);
      ((Intent)localObject1).putExtra("uin", this.a.a);
      ((Intent)localObject1).putExtra("add_friend_source_id", AddRequestActivity.a(this.a));
      if (!bool) {
        break label236;
      }
      localObject2 = ((anyw)localObject2).e(this.a.a);
      if (localObject2 != null)
      {
        ((Intent)localObject1).putExtra("cSpecialFlag", ((Friends)localObject2).cSpecialFlag);
        ((Intent)localObject1).putExtra("uinname", bhlg.a((Friends)localObject2));
      }
      label192:
      if (!bool) {
        break label269;
      }
      i = j;
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("uintype", i);
      this.a.startActivity((Intent)localObject1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = AddRequestActivity.a(this.a);
      break;
      label236:
      ((Intent)localObject1).putExtra("uinname", this.a.b);
      ((Intent)localObject1).putExtra("param_wzry_data", AddRequestActivity.a(this.a));
      break label192;
      label269:
      if ((AddRequestActivity.a(this.a) == 2007) || (AddRequestActivity.a(this.a) == 3007) || (AddRequestActivity.a(this.a) == 4007)) {
        i = 1001;
      } else if ((AddRequestActivity.a(this.a) == 2019) || (AddRequestActivity.a(this.a) == 3019)) {
        i = 1010;
      } else {
        i = 1022;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduf
 * JD-Core Version:    0.7.0.1
 */