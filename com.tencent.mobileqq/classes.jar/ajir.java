import android.os.Bundle;
import com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ajir
  extends anvi
{
  private ajir(AlphabetFriendFragment paramAlphabetFriendFragment) {}
  
  protected void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (AlphabetFriendFragment.b(this.a))) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onDeleteGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (AlphabetFriendFragment.b(this.a))) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onGroupDataInited()
  {
    AlphabetFriendFragment.a(this.a, 1400L, true);
  }
  
  protected void onRenameGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (AlphabetFriendFragment.b(this.a))) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onResortGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (AlphabetFriendFragment.b(this.a))) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (AlphabetFriendFragment.b(this.a))) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onSetSpecialCareSwitch_global isSuccess: " + paramBoolean);
    }
    if ((this.a.b) && (AlphabetFriendFragment.a(this.a) != null)) {
      AlphabetFriendFragment.a(this.a).a();
    }
    if ((paramBoolean) && (this.a.isResumed())) {
      try
      {
        String[] arrayOfString = (String[])paramArrayOfObject[1];
        paramArrayOfObject = (boolean[])paramArrayOfObject[2];
        if (QLog.isColorLevel()) {
          QLog.d("contacts.fragment.AlphabetFriendFragment", 2, new Object[] { "onSetSpecialCareSwitch_global uinArray=%s stateArray=%s", Arrays.toString(arrayOfString), Arrays.toString(paramArrayOfObject) });
        }
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
        {
          if (paramArrayOfObject[0] != 0)
          {
            QQToast.a(this.a.getActivity(), 2, anvx.a(2131699731), 0).a();
            return;
          }
          QQToast.a(this.a.getActivity(), 2, anvx.a(2131699732), 0).a();
          return;
        }
      }
      catch (Exception paramArrayOfObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("contacts.fragment.AlphabetFriendFragment", 2, "onSetSpecialCareSwitch_global fail!", paramArrayOfObject);
        }
      }
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onUpdateAddFriend isSucess= " + paramBoolean1 + ",addSuccess=" + paramBoolean2 + " addDirect=" + paramBoolean3);
    }
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (AlphabetFriendFragment.b(this.a))) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      AlphabetFriendFragment.a(this.a, 5000L, false);
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onUpdateDelFriend isSucess= " + paramBoolean);
    }
    if (paramBoolean) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (AlphabetFriendFragment.b(this.a))) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    AlphabetFriendFragment localAlphabetFriendFragment = this.a;
    boolean bool;
    if ((paramBoolean2) || (!paramBoolean1))
    {
      bool = true;
      AlphabetFriendFragment.a(localAlphabetFriendFragment, bool);
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onUpdateFriendList isSucess= " + paramBoolean1 + ",isComplete=" + paramBoolean2);
      }
      paramBoolean2 = AlphabetFriendFragment.a(this.a);
      if (AlphabetFriendFragment.a(this.a))
      {
        if (AlphabetFriendFragment.b(this.a))
        {
          AlphabetFriendFragment.b(this.a, false);
          if (AlphabetFriendFragment.a(this.a) != null) {
            AlphabetFriendFragment.b(this.a).a(this.a.b(), paramBoolean1, null);
          }
        }
        localAlphabetFriendFragment = this.a;
        if (!AlphabetFriendFragment.b(this.a)) {
          break label189;
        }
      }
    }
    label189:
    for (long l = 0L;; l = 1400L)
    {
      AlphabetFriendFragment.a(localAlphabetFriendFragment, l, true);
      if ((!paramBoolean2) && (AlphabetFriendFragment.b(this.a))) {
        AlphabetFriendFragment.a(this.a, 1400L, true);
      }
      return;
      bool = false;
      break;
    }
  }
  
  protected void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
      AlphabetFriendFragment.a(this.a, 0L, true);
    }
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    AlphabetFriendFragment.a(this.a, 1400L, false);
  }
  
  protected void onUpdateLastLoginInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      AlphabetFriendFragment.a(this.a, 1400L, false);
    }
  }
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if ((paramString != null) && (AlphabetFriendFragment.b(this.a))) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateOlympicTorchList(boolean paramBoolean)
  {
    if (paramBoolean) {
      AlphabetFriendFragment.a(this.a, 1400L, false);
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (AlphabetFriendFragment.b(this.a))) {
      AlphabetFriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (AlphabetFriendFragment.b(this.a))) {
      AlphabetFriendFragment.a(this.a, 1400L, false);
    }
  }
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onUpdateSpecialCareList isSucess= " + paramBoolean1 + ",isComplete=" + paramBoolean2);
    }
    if ((this.a.b) && (paramBoolean1) && (AlphabetFriendFragment.a(this.a) != null))
    {
      AlphabetFriendFragment.a(this.a).a();
      AlphabetFriendFragment.a(this.a, 0L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajir
 * JD-Core Version:    0.7.0.1
 */