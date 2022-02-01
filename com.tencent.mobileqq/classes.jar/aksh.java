import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import tencent.im.qqwallet.kua_kua_hb_srv.TopicMatchRequest;

public class aksh
  implements bmhi
{
  aksh(aksg paramaksg) {}
  
  public void a(int paramInt, String... paramVarArgs)
  {
    if (this.a.a.b()) {
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketKuaKuaFragment", 2, "ansyBack:getActivity() == null || getActivity().isFinishing()");
      }
    }
    while ((paramVarArgs.length <= 0) || (paramVarArgs[0] == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketKuaKuaFragment", 2, "get getPskeyAsync success");
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    String str1 = RedPacketKuaKuaFragment.a(this.a.a).curFriendUin;
    paramInt = albv.a(this.a.a.getActivity().app, RedPacketKuaKuaFragment.a(this.a.a));
    String str2 = this.a.a.getActivity().app.getCurrentUin();
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), akqa.class);
    localNewIntent.putExtra("cmd", "trpc.qqhb.kua_kua_hb_srv.KuaKuaHbSvc.TopicMatch");
    paramVarArgs = this.a.a.a(paramVarArgs[0], str2, paramInt, str1);
    if (paramVarArgs != null) {
      localNewIntent.putExtra("data", bhjl.a(paramVarArgs.toByteArray()));
    }
    localNewIntent.setObserver(new aksi(this, l));
    this.a.a.getActivity().app.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksh
 * JD-Core Version:    0.7.0.1
 */