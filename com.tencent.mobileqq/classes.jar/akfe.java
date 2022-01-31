import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.widget.QQToast;

public class akfe
  implements akfg
{
  public akfe(TroopShareUtility paramTroopShareUtility) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.d = paramString;
      TroopShareUtility.d(this.a);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, "分享群聊失败!", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfe
 * JD-Core Version:    0.7.0.1
 */