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

public class akfm
{
  public static ChatHistoryBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new ChatHistoryC2CAllFragment();
    case 2131364399: 
      return new ChatHistoryC2CAllFragment();
    case 2131364402: 
      return new ChatHistoryC2CFileFragment();
    case 2131364404: 
      return new ChatHistoryC2CMediaFragment();
    case 2131364401: 
      return new ChatHistoryC2CEmotionFragment();
    case 2131364403: 
      return new ChatHistoryC2CLinkFragment();
    case 2131364405: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364400: 
      return new ChatHistoryC2CDateFragment();
    case 2131364406: 
      return new ChatHistoryTroopAllFragment();
    case 2131364411: 
      return new ChatHistoryTroopMediaFragment();
    case 2131364408: 
      return new ChatHistoryTroopEmotionFragment();
    case 2131364409: 
      return new ChatHistoryTroopFileFragment();
    case 2131364410: 
      return new ChatHistoryTroopLinkFragment();
    case 2131364413: 
      return new ChatHistoryBaseTenDocFragment();
    case 2131364407: 
      return new ChatHistoryTroopDateFragment();
    }
    return new ChatHistoryTroopMemberFragment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfm
 * JD-Core Version:    0.7.0.1
 */