import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;

public class akfa
  implements ShareActionSheet.OnItemClickListener
{
  public akfa(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int i = paramActionSheetItem.action;
    int j = paramActionSheetItem.uinType;
    paramActionSheetItem = paramActionSheetItem.uin;
    switch (i)
    {
    default: 
      QLog.e("MiniMsgTabFragment", 1, "handleShareChatItemClick with invalid case:" + i);
    case 2: 
    case 73: 
    case 3: 
    case 9: 
    case 10: 
    case 70: 
    case 82: 
    case 76: 
    case 77: 
    case 14: 
    case 78: 
      do
      {
        return;
        MiniMsgTabFragment.a(this.a, 1, null);
        return;
        MiniMsgTabFragment.a(this.a, 5, null);
        return;
        MiniMsgTabFragment.a(this.a, 6, null);
        return;
        MiniMsgTabFragment.a(this.a, 7, null);
        return;
        MiniMsgTabFragment.a(this.a, 13, null);
        return;
        MiniMsgTabFragment.a(this.a, 8, null);
        return;
        MiniMsgTabFragment.a(this.a, 10, null);
        return;
      } while (MiniMsgTabFragment.a(this.a) == -1);
      if (MiniMsgTabFragment.a(this.a))
      {
        MainPageFragment.launchForMiniGame(this.a.getActivity(), MiniMsgTabFragment.a(this.a), 1, true);
        return;
      }
      MainPageFragment.launch(this.a.getActivity(), MiniMsgTabFragment.a(this.a), MiniMsgTabFragment.a(this.a));
      return;
    case 11: 
      MiniMsgTabFragment.a(this.a, 11, null);
      return;
    case 74: 
    case 75: 
      MiniMsgTabFragment.a(this.a, 2, null);
      return;
    case 79: 
    case 80: 
      MiniMsgTabFragment.a(this.a, 3, null);
      return;
    case 72: 
      MiniMsgTabFragment.a(this.a, paramActionSheetItem, j);
      return;
    case 81: 
      MiniMsgTabFragment.a(this.a, 9, null);
      return;
    case 83: 
      if (this.a.getActivity() != null)
      {
        PermissionSettingFragment.launchForResult(this.a.getActivity(), MiniMsgTabFragment.a(this.a), MiniMsgTabFragment.b(this.a), 5);
        return;
      }
      QLog.e("MiniMsgTabFragment", 1, "handleShareChatItemClick getActivity is null when ACTION_SETTING");
      return;
    case 128: 
      MiniMsgTabFragment.a(this.a, 14, null);
      return;
    case 158: 
      MiniMsgTabFragment.a(this.a, 15, null);
      return;
    case 159: 
      MiniMsgTabFragment.a(this.a, 16, null);
      return;
    }
    MiniMsgTabFragment.a(this.a, 17, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfa
 * JD-Core Version:    0.7.0.1
 */