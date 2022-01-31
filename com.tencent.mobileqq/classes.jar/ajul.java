import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.IAnimationMessage;
import java.util.Comparator;

public class ajul
  implements Comparator
{
  public ajul(AIOAnimationControlManager paramAIOAnimationControlManager) {}
  
  public int a(AIOAnimationControlManager.IAnimationMessage paramIAnimationMessage1, AIOAnimationControlManager.IAnimationMessage paramIAnimationMessage2)
  {
    int j = -1;
    if (((paramIAnimationMessage1 instanceof MessageForDeliverGiftTips)) && ((paramIAnimationMessage2 instanceof MessageForDeliverGiftTips)))
    {
      paramIAnimationMessage1 = (MessageForDeliverGiftTips)paramIAnimationMessage1;
      paramIAnimationMessage2 = (MessageForDeliverGiftTips)paramIAnimationMessage2;
      int i;
      if ((paramIAnimationMessage1.isToAll()) && (paramIAnimationMessage2.isToAll())) {
        i = (int)(paramIAnimationMessage1.time - paramIAnimationMessage2.time);
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramIAnimationMessage1.isToAll());
        if (paramIAnimationMessage2.isToAll()) {
          return 1;
        }
        if ((paramIAnimationMessage1.receiverUin == this.a.a.getLongAccountUin()) && (paramIAnimationMessage2.receiverUin == this.a.a.getLongAccountUin())) {
          return (int)(paramIAnimationMessage1.time - paramIAnimationMessage2.time);
        }
        i = j;
      } while (paramIAnimationMessage1.receiverUin == this.a.a.getLongAccountUin());
      if (paramIAnimationMessage2.receiverUin == this.a.a.getLongAccountUin()) {
        return 1;
      }
      return (int)(paramIAnimationMessage1.time - paramIAnimationMessage2.time);
    }
    return (int)(paramIAnimationMessage1.getShmsgseq() - paramIAnimationMessage2.getShmsgseq());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajul
 * JD-Core Version:    0.7.0.1
 */