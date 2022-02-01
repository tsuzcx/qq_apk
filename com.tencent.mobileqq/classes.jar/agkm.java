import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

class agkm
  extends aocm
{
  agkm(agkk paramagkk) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedpointHandler", 2, "troopChatPie RedpointObserver  onDataChange");
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbbq)agkk.a(this.a).app.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(4, String.valueOf(130500));
    if (this.a.b == null) {
      this.a.b = ((ImageView)agkk.a(this.a).mAIORootView.findViewById(2131376435));
    }
    if (this.a.b == null) {
      return;
    }
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1))
    {
      this.a.b.setVisibility(0);
      return;
    }
    this.a.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkm
 * JD-Core Version:    0.7.0.1
 */