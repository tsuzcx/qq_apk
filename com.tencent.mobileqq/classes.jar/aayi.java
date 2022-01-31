import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;
import com.tencent.mobileqq.ark.ArkAiAppPanel;

public class aayi
  implements ArkAppContainer.ArkAppModuleCallback
{
  public aayi(ArkAiAppPanel paramArkAiAppPanel) {}
  
  public boolean a(ArkAppContainer paramArkAppContainer)
  {
    if (ArkAiAppPanel.a(this.a) != null)
    {
      ArkAiAppPanel.a(this.a).ai();
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
 * Qualified Name:     aayi
 * JD-Core Version:    0.7.0.1
 */