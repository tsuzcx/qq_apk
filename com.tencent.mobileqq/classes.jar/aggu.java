import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment;
import com.tencent.mobileqq.mini.activity.MiniAppEntrySettingFragment;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.qphone.base.util.QLog;

public class aggu
  implements bcur
{
  public aggu(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void a(bbje parambbje, bcuq parambcuq)
  {
    int i = parambbje.jdField_c_of_type_Int;
    int j = parambbje.f;
    parambbje = parambbje.jdField_c_of_type_JavaLangString;
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
      } while (MiniMsgTabFragment.b(this.a) == -1);
      if (MiniMsgTabFragment.b(this.a))
      {
        MainPageFragment.launchForMiniGame(this.a.getActivity(), MiniMsgTabFragment.a(this.a), 1, true);
        return;
      }
      MainPageFragment.launch(this.a.getActivity(), MiniMsgTabFragment.a(this.a), MiniMsgTabFragment.b(this.a));
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
      MiniMsgTabFragment.a(this.a, parambbje, j);
      return;
    case 81: 
      MiniMsgTabFragment.a(this.a, 9, null);
      return;
    }
    PublicFragmentActivity.a(this.a.getActivity(), MiniAppEntrySettingFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggu
 * JD-Core Version:    0.7.0.1
 */