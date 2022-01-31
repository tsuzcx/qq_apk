import QQService.EVIPSPEC;
import com.tencent.mobileqq.data.Friends;
import java.util.Comparator;

class akdj
  implements Comparator<akhx>
{
  public int a(akhx paramakhx1, akhx paramakhx2)
  {
    paramakhx1 = (Friends)paramakhx1.a;
    paramakhx2 = (Friends)paramakhx2.a;
    int i = a(paramakhx1);
    int j = a(paramakhx2);
    if (i == j) {
      return allu.a(paramakhx1.mComparePartInt, paramakhx1.mCompareSpell, paramakhx2.mComparePartInt, paramakhx2.mCompareSpell);
    }
    return i - j;
  }
  
  public int a(Friends paramFriends)
  {
    int i = 16384;
    int k = bdbt.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    int j;
    if ((k != 6) && (k != 0))
    {
      j = 65536;
      label32:
      if (!azib.b()) {
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
        if (paramFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
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
 * Qualified Name:     akdj
 * JD-Core Version:    0.7.0.1
 */