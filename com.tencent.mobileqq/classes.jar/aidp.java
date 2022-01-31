import com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CEmotionFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CMediaFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopDateFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopEmotionFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopLinkFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class aidp
{
  public static ChatHistoryBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new ChatHistoryC2CAllFragment();
    case 2131364149: 
      return new ChatHistoryC2CAllFragment();
    case 2131364152: 
      return new ChatHistoryC2CFileFragment();
    case 2131364154: 
      return new ChatHistoryC2CMediaFragment();
    case 2131364151: 
      return new ChatHistoryC2CEmotionFragment();
    case 2131364153: 
      return new ChatHistoryC2CLinkFragment();
    case 2131364155: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364150: 
      return new ChatHistoryC2CDateFragment();
    case 2131364156: 
      return new ChatHistoryTroopAllFragment();
    case 2131364161: 
      return new ChatHistoryTroopMediaFragment();
    case 2131364158: 
      return new ChatHistoryTroopEmotionFragment();
    case 2131364159: 
      return new ChatHistoryTroopFileFragment();
    case 2131364160: 
      return new ChatHistoryTroopLinkFragment();
    case 2131364163: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364157: 
      return new ChatHistoryTroopDateFragment();
    }
    return new ChatHistoryTroopMemberFragment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidp
 * JD-Core Version:    0.7.0.1
 */