import com.tencent.mobileqq.data.HotChatItemData;
import java.util.Comparator;

class alpt
  implements Comparator<HotChatItemData>
{
  alpt(alpr paramalpr) {}
  
  public int a(HotChatItemData paramHotChatItemData1, HotChatItemData paramHotChatItemData2)
  {
    long l1 = Math.max(paramHotChatItemData1.mLatestMsgSec, paramHotChatItemData1.mDraftSec);
    long l2 = Math.max(paramHotChatItemData2.mLatestMsgSec, paramHotChatItemData2.mDraftSec);
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alpt
 * JD-Core Version:    0.7.0.1
 */