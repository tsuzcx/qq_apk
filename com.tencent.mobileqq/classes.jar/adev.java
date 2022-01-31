import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import java.util.Comparator;

public class adev
  implements Comparator
{
  public adev(MessageForUniteGrayTip paramMessageForUniteGrayTip) {}
  
  public int a(MessageForGrayTips.HightlightItem paramHightlightItem1, MessageForGrayTips.HightlightItem paramHightlightItem2)
  {
    return paramHightlightItem1.start - paramHightlightItem2.start;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adev
 * JD-Core Version:    0.7.0.1
 */