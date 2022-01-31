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

public class agbc
{
  public static ChatHistoryBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new ChatHistoryC2CAllFragment();
    case 2131364085: 
      return new ChatHistoryC2CAllFragment();
    case 2131364088: 
      return new ChatHistoryC2CFileFragment();
    case 2131364090: 
      return new ChatHistoryC2CMediaFragment();
    case 2131364087: 
      return new ChatHistoryC2CEmotionFragment();
    case 2131364089: 
      return new ChatHistoryC2CLinkFragment();
    case 2131364091: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364086: 
      return new ChatHistoryC2CDateFragment();
    case 2131364092: 
      return new ChatHistoryTroopAllFragment();
    case 2131364097: 
      return new ChatHistoryTroopMediaFragment();
    case 2131364094: 
      return new ChatHistoryTroopEmotionFragment();
    case 2131364095: 
      return new ChatHistoryTroopFileFragment();
    case 2131364096: 
      return new ChatHistoryTroopLinkFragment();
    case 2131364099: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364093: 
      return new ChatHistoryTroopDateFragment();
    }
    return new ChatHistoryTroopMemberFragment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agbc
 * JD-Core Version:    0.7.0.1
 */