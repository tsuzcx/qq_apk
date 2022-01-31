import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

class adjk
  extends akfk
{
  adjk(adji paramadji) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedpointHandler", 2, "troopChatPie RedpointObserver  onDataChange");
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((avps)adji.a(this.a).a.getManager(36)).a(4, String.valueOf(130500));
    if (this.a.b == null) {
      this.a.b = ((ImageView)adji.a(this.a).c.findViewById(2131375030));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adjk
 * JD-Core Version:    0.7.0.1
 */