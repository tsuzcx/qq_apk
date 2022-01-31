import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.Callback;
import com.tencent.mobileqq.ark.ArkAiAppPanel;
import java.util.ArrayList;

public class aarq
  implements ArkAppView.Callback
{
  public aarq(ArkAiAppPanel paramArkAiAppPanel) {}
  
  public void a()
  {
    boolean bool = ((ArkAioContainerWrapper)ArkAiAppPanel.a(this.a).get(ArkAiAppPanel.a(this.a))).checkShare();
    if (bool != ArkAiAppPanel.a(this.a))
    {
      ArkAiAppPanel.a(this.a, bool);
      ArkAiAppPanel.a(this.a, ArkAiAppPanel.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarq
 * JD-Core Version:    0.7.0.1
 */