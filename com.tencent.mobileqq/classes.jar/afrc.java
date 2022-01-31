import android.os.Bundle;
import com.tencent.mobileqq.activity.contacts.fragment.FriendFragment;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class afrc
  extends ajxl
{
  private afrc(FriendFragment paramFriendFragment) {}
  
  protected void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onDeleteGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onGroupDataInited()
  {
    FriendFragment.a(this.a, 1400L, true);
  }
  
  protected void onRenameGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onResortGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "onSetSpecialCareSwitch_global isSuccess: " + paramBoolean);
    }
    if (this.a.jdField_a_of_type_Ailu != null) {
      this.a.jdField_a_of_type_Ailu.notifyDataSetChanged();
    }
    if ((paramBoolean) && (this.a.isResumed())) {
      try
      {
        String[] arrayOfString = (String[])paramArrayOfObject[1];
        paramArrayOfObject = (boolean[])paramArrayOfObject[2];
        if (QLog.isColorLevel()) {
          QLog.d("contacts.fragment.FriendFragment", 2, new Object[] { "onSetSpecialCareSwitch_global uinArray=%s stateArray=%s", Arrays.toString(arrayOfString), Arrays.toString(paramArrayOfObject) });
        }
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
        {
          if (paramArrayOfObject[0] != 0)
          {
            bcpw.a(this.a.getActivity(), 2, ajyc.a(2131704864), 0).a();
            return;
          }
          bcpw.a(this.a.getActivity(), 2, ajyc.a(2131704865), 0).a();
          return;
        }
      }
      catch (Exception paramArrayOfObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("contacts.fragment.FriendFragment", 2, "onSetSpecialCareSwitch_global fail!", paramArrayOfObject);
        }
      }
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateAddFriend isSucess= " + paramBoolean1 + ",addSuccess=" + paramBoolean2 + " addDirect=" + paramBoolean3);
    }
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      FriendFragment.a(this.a, 5000L, false);
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateDelFriend isSucess= " + paramBoolean);
    }
    if (paramBoolean) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    FriendFragment localFriendFragment = this.a;
    boolean bool;
    if ((paramBoolean2) || (!paramBoolean1))
    {
      bool = true;
      FriendFragment.a(localFriendFragment, bool);
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateFriendList isSucess= " + paramBoolean1 + ",isComplete=" + paramBoolean2);
      }
      paramBoolean2 = FriendFragment.a(this.a);
      if (FriendFragment.a(this.a))
      {
        if (FriendFragment.b(this.a))
        {
          FriendFragment.b(this.a, false);
          if (this.a.jdField_a_of_type_Afqu != null) {
            this.a.jdField_a_of_type_Afqu.a(this.a.b(), paramBoolean1, null);
          }
        }
        localFriendFragment = this.a;
        if (!FriendFragment.b(this.a)) {
          break label189;
        }
      }
    }
    label189:
    for (long l = 0L;; l = 1400L)
    {
      FriendFragment.a(localFriendFragment, l, true);
      if ((!paramBoolean2) && (FriendFragment.b(this.a))) {
        FriendFragment.a(this.a, 1400L, true);
      }
      return;
      bool = false;
      break;
    }
  }
  
  protected void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
      FriendFragment.a(this.a, 0L, true);
    }
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    FriendFragment.a(this.a, 1400L, false);
  }
  
  protected void onUpdateLastLoginInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      FriendFragment.a(this.a, 1400L, false);
    }
  }
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if ((paramString != null) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateOlympicTorchList(boolean paramBoolean)
  {
    if (paramBoolean) {
      FriendFragment.a(this.a, 1400L, false);
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, false);
    }
  }
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateSpecialCareList isSucess= " + paramBoolean1 + ",isComplete=" + paramBoolean2);
    }
    if ((paramBoolean1) && (this.a.jdField_a_of_type_Ailu != null)) {
      this.a.jdField_a_of_type_Ailu.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afrc
 * JD-Core Version:    0.7.0.1
 */