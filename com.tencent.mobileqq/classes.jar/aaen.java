import android.content.res.Resources;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class aaen
  extends axqx
{
  public aaen(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, "onDeleteNearbyPeopleAuthVideo isSuccess:" + paramBoolean);
    }
    ((axny)TroopMemberApiService.f(this.a).getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(((QQAppInterface)TroopMemberApiService.g(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      bhhr.a(BaseApplication.getContext(), false);
      QQToast.a(BaseApplication.getContext(), 2, anvx.a(2131714918), 0).b(this.a.getResources().getDimensionPixelSize(2131299080));
      if (!paramBoolean) {
        break label164;
      }
    }
    label164:
    for (String str = "1";; str = "2")
    {
      axqn.a("clk_del_video", new String[] { str });
      return;
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131714995), 0).b(this.a.getResources().getDimensionPixelSize(2131299080));
      break;
    }
  }
  
  protected void a(boolean paramBoolean, UpdatePhotoList.HeadInfo paramHeadInfo)
  {
    if (QLog.isColorLevel())
    {
      if (paramHeadInfo != null) {
        QLog.d("TroopMemberApiService", 2, "onUpdateNearbyPeopleAuthVideo + HeadInfo = " + paramHeadInfo.toString());
      }
    }
    else
    {
      ((axny)TroopMemberApiService.h(this.a).getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(((QQAppInterface)TroopMemberApiService.i(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
      if (!paramBoolean) {
        break label150;
      }
      bhhr.a(BaseApplication.getContext(), true);
      QQToast.a(BaseApplication.getContext(), 2, anvx.a(2131714996), 0).b(this.a.getResources().getDimensionPixelSize(2131299080));
      label118:
      if (!paramBoolean) {
        break label182;
      }
    }
    label150:
    label182:
    for (paramHeadInfo = "1";; paramHeadInfo = "2")
    {
      axqn.a("clk_upload_video", new String[] { paramHeadInfo });
      return;
      QLog.d("TroopMemberApiService", 2, "onUpdateNearbyPeopleAuthVideo , headInfo is null");
      break;
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131714924), 0).b(this.a.getResources().getDimensionPixelSize(2131299080));
      break label118;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaen
 * JD-Core Version:    0.7.0.1
 */