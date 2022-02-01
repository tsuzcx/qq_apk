import QQService.EVIPSPEC;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Comparator;

class ajkz
  implements Comparator<ajiy>
{
  public int a(ajiy paramajiy1, ajiy paramajiy2)
  {
    paramajiy1 = (Friends)paramajiy1.a;
    paramajiy2 = (Friends)paramajiy2.a;
    int i = a(paramajiy1);
    int j = a(paramajiy2);
    if (i == j) {
      return ansk.a(paramajiy1.mComparePartInt, paramajiy1.mCompareSpell, paramajiy2.mComparePartInt, paramajiy2.mCompareSpell);
    }
    return i - j;
  }
  
  public int a(Friends paramFriends)
  {
    int i = 16384;
    int k = ContactUtils.getFriendStatus(paramFriends.detalStatusFlag, paramFriends.iTermType);
    int j;
    if ((k != 6) && (k != 0))
    {
      j = 65536;
      label32:
      if (!bdfk.b()) {
        break label100;
      }
    }
    for (;;)
    {
      switch (k)
      {
      case 5: 
      case 6: 
      default: 
        return j | i | (int)paramFriends.getLastLoginType();
        j = 131072;
        break label32;
        label100:
        if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
          i = 0;
        } else if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
          i = 4096;
        } else if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
          i = 8192;
        } else if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
          i = 12288;
        }
        break;
      }
    }
    return j | i | 0x1;
    return j | i | 0x2;
    return j | i | 0x3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkz
 * JD-Core Version:    0.7.0.1
 */