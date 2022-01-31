import android.content.res.Resources;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aepv
  extends TroopGiftCallback
{
  public aepv(TroopGiftPanelForNearby paramTroopGiftPanelForNearby) {}
  
  public void a(int paramInt)
  {
    NearbyFlowerManager.a("gift_store", "suc_one", this.a.a(), TroopGiftPanelForNearby.a(this.a) + "", "", "");
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    if (paramInt == 20007) {
      QQToast.a(TroopGiftPanelForNearby.a(this.a), "对方拒收了你的礼物", 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
    }
    for (;;)
    {
      NearbyFlowerManager.a("gift_store", "fail_one", this.a.a(), TroopGiftPanelForNearby.b(this.a) + "", "", "");
      return;
      QQToast.a(TroopGiftPanelForNearby.b(this.a), "赠送失败", 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aepv
 * JD-Core Version:    0.7.0.1
 */