import QQService.EVIPSPEC;
import com.tencent.mobileqq.data.Friends;
import java.util.Comparator;

class akhy
  implements Comparator<akmm>
{
  public int a(akmm paramakmm1, akmm paramakmm2)
  {
    paramakmm1 = (Friends)paramakmm1.a;
    paramakmm2 = (Friends)paramakmm2.a;
    int i = a(paramakmm1);
    int j = a(paramakmm2);
    if (i == j) {
      return alqj.a(paramakmm1.mComparePartInt, paramakmm1.mCompareSpell, paramakmm2.mComparePartInt, paramakmm2.mCompareSpell);
    }
    return i - j;
  }
  
  public int a(Friends paramFriends)
  {
    int i = 16384;
    int k = bdgc.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    int j;
    if ((k != 6) && (k != 0))
    {
      j = 65536;
      label32:
      if (!azmk.b()) {
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
 * Qualified Name:     akhy
 * JD-Core Version:    0.7.0.1
 */