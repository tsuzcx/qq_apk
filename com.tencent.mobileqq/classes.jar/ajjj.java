import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.widget.QQToast;

public class ajjj
  implements ajjo
{
  public ajjj(TroopShareUtility paramTroopShareUtility) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.d = paramString;
      TroopShareUtility.e(this.a);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, "分享群聊失败!", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajjj
 * JD-Core Version:    0.7.0.1
 */