import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;

class agyv
  implements View.OnClickListener
{
  agyv(agxq paramagxq) {}
  
  public void onClick(View paramView)
  {
    int j;
    Intent localIntent;
    if (agxq.a(this.a) != null)
    {
      paramView = agxq.a(this.a).app;
      if (paramView == null) {
        break label1094;
      }
      j = paramView.a().e();
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "initMultiVideoBar-->SessionType");
      }
      if ((j != 1) && (j != 2)) {
        break label521;
      }
      localIntent = new Intent(agxq.a(this.a).getApplicationContext(), AVActivity.class);
      if (paramView.a().f() != 1011) {
        break label97;
      }
    }
    label97:
    long l;
    label521:
    int k;
    int m;
    do
    {
      return;
      paramView = null;
      break;
      if ((paramView.c()) && (paramView.a().f() != 1) && (paramView.a().f() != 3000) && (paramView.a().g()) && (paramView.a().f()) && (paramView.a().f() != 1011) && (paramView.a().f() != 21))
      {
        localIntent = new Intent(agxq.a(this.a), VideoInviteActivity.class);
        localIntent.addFlags(268435456);
        localIntent.putExtra("uinType", paramView.a().f());
        localIntent.putExtra("peerUin", paramView.a().c());
        localIntent.putExtra("extraUin", paramView.a().d());
        if (j == 1)
        {
          bool = true;
          localIntent.putExtra("isAudioMode", bool);
          agxq.a(this.a).startActivity(localIntent);
          agxq.a(this.a).overridePendingTransition(2130772132, 0);
        }
      }
      for (;;)
      {
        awqx.a(agxq.a(this.a).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 1, 0, "", "", "", "");
        return;
        bool = false;
        break;
        localIntent.addFlags(262144);
        localIntent.addFlags(268435456);
        if (paramView.a().b(paramView.a().c()))
        {
          localIntent.putExtra("sessionType", 3);
          localIntent.putExtra("GroupId", paramView.a().c());
          localIntent.putExtra("isDoubleVideoMeeting", true);
          agxq.a(this.a).startActivity(localIntent);
          agxq.a(this.a).overridePendingTransition(2130772132, 0);
          awqx.b(paramView, "CliOper", "", "", "0X800520A", "0X800520A", 0, 0, "", "", "", "");
        }
        else
        {
          localIntent.putExtra("sessionType", j);
          localIntent.putExtra("uin", paramView.a().c());
          agxq.a(this.a).startActivity(localIntent);
          agxq.a(this.a).overridePendingTransition(2130772132, 0);
          awqx.b(paramView, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "1", "", "", "");
        }
      }
      l = agxq.a(this.a).app.a().b();
      k = agxq.a(this.a).app.a().a();
      if ((l == 0L) && (agxq.a(this.a).app.a().b() <= 0)) {
        break label1077;
      }
      m = paramView.a().b(l);
      if (agxq.a(this.a).app.a().b() <= 0) {
        break label650;
      }
    } while ((paramView.a().c() == 1) || (paramView.a().c() == 3) || (!QLog.isColorLevel()));
    QLog.e("MultiVideoBar", 2, "status error");
    return;
    label650:
    label665:
    int i;
    if (m == 2)
    {
      localIntent = new Intent();
      if (paramView.a().a(k, l) <= 0L) {
        break label898;
      }
      if (!paramView.a().a(k, l)) {
        break label893;
      }
      i = 2;
    }
    for (;;)
    {
      localIntent.addFlags(262144);
      localIntent.addFlags(268435456);
      localIntent.putExtra("GroupId", String.valueOf(l));
      localIntent.putExtra("Type", i);
      localIntent.putExtra("sessionType", j);
      localIntent.putExtra("uinType", mjg.c(k));
      localIntent.putExtra("MultiAVType", m);
      if (m != 2) {
        break label988;
      }
      if (paramView.a().d(String.valueOf(l)) != 14) {
        break label903;
      }
      ((aqkz)paramView.getManager(236)).a(agxq.a(this.a), paramView.getCurrentAccountUin(), String.valueOf(l), "2", "openRoom");
      label823:
      agxq.a(this.a).overridePendingTransition(2130772132, 0);
      if (k != 2) {
        break label1003;
      }
      awqx.b(paramView, "CliOper", "", "", "Multi_call", "Msgtab_back", 0, 0, "", "", "", "");
      break;
      localIntent = new Intent(agxq.a(this.a).getApplicationContext(), AVActivity.class);
      break label665;
      label893:
      i = 1;
      continue;
      label898:
      i = 0;
    }
    label903:
    TroopManager localTroopManager = (TroopManager)paramView.getManager(52);
    if ((localTroopManager != null) && (localTroopManager.b(l + "") == null)) {}
    for (boolean bool = false;; bool = true)
    {
      localIntent.putExtra("troopmember", bool);
      localIntent.putExtra("Fromwhere", "SmallScreen");
      bfch.a(paramView, agxq.a(this.a), localIntent, 1);
      break label823;
      label988:
      agxq.a(this.a).startActivity(localIntent);
      break label823;
      label1003:
      if (k != 1) {
        break;
      }
      if (paramView.a().b(l) == 10)
      {
        awqx.b(paramView, "CliOper", "", "", "0X8005931", "0X8005931", 0, 0, "", "", "", "");
        break;
      }
      awqx.b(paramView, "CliOper", "", "", "0X80046D8", "0X80046D8", 0, 0, "", "", "", "");
      break;
      label1077:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiVideoBar", 2, "status error");
      break;
      label1094:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("MultiVideoBar", 2, "app is null");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agyv
 * JD-Core Version:    0.7.0.1
 */