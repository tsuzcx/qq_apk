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

public class ajud
{
  public static ChatHistoryBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new ChatHistoryC2CAllFragment();
    case 2131364355: 
      return new ChatHistoryC2CAllFragment();
    case 2131364358: 
      return new ChatHistoryC2CFileFragment();
    case 2131364360: 
      return new ChatHistoryC2CMediaFragment();
    case 2131364357: 
      return new ChatHistoryC2CEmotionFragment();
    case 2131364359: 
      return new ChatHistoryC2CLinkFragment();
    case 2131364361: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364356: 
      return new ChatHistoryC2CDateFragment();
    case 2131364362: 
      return new ChatHistoryTroopAllFragment();
    case 2131364367: 
      return new ChatHistoryTroopMediaFragment();
    case 2131364364: 
      return new ChatHistoryTroopEmotionFragment();
    case 2131364365: 
      return new ChatHistoryTroopFileFragment();
    case 2131364366: 
      return new ChatHistoryTroopLinkFragment();
    case 2131364369: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364363: 
      return new ChatHistoryTroopDateFragment();
    }
    return new ChatHistoryTroopMemberFragment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajud
 * JD-Core Version:    0.7.0.1
 */