import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;
import com.tencent.mobileqq.utils.QQCustomArkDialog;

public class akli
  implements ArkAppContainer.ArkAppModuleCallback
{
  public akli(QQCustomArkDialog paramQQCustomArkDialog) {}
  
  public boolean a(ArkAppContainer paramArkAppContainer)
  {
    if (this.a.isShowing())
    {
      this.a.dismiss();
      return true;
    }
    return false;
  }
  
  public boolean a(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akli
 * JD-Core Version:    0.7.0.1
 */