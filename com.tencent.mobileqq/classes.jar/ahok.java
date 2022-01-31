import com.tencent.mobileqq.activity.contacts.fragment.AlphabetFriendFragment;
import com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment;
import com.tencent.mobileqq.activity.contacts.fragment.FriendFragment;
import com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment;
import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.activity.contacts.fragment.RecommendFriendFragment;
import com.tencent.mobileqq.activity.contacts.fragment.TroopFragment;

public class ahok
{
  public static ContactsBaseFragment a(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new FriendFragment();
    }
    for (;;)
    {
      ((ContactsBaseFragment)localObject).d(paramInt);
      return localObject;
      localObject = new RecommendFriendFragment();
      continue;
      localObject = new FriendFragment();
      continue;
      localObject = new TroopFragment();
      continue;
      localObject = new PublicAccountFragment();
      continue;
      localObject = new DeviceFragment();
      continue;
      localObject = new PhoneContactFragment();
      continue;
      localObject = new AlphabetFriendFragment();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahok
 * JD-Core Version:    0.7.0.1
 */