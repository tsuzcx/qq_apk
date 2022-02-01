import QQService.EVIPSPEC;
import com.tencent.mobileqq.data.Friends;
import java.util.Comparator;

class ajun
  implements Comparator<ajsm>
{
  public int a(ajsm paramajsm1, ajsm paramajsm2)
  {
    paramajsm1 = (Friends)paramajsm1.a;
    paramajsm2 = (Friends)paramajsm2.a;
    int i = a(paramajsm1);
    int j = a(paramajsm2);
    if (i == j) {
      return anvp.a(paramajsm1.mComparePartInt, paramajsm1.mCompareSpell, paramajsm2.mComparePartInt, paramajsm2.mCompareSpell);
    }
    return i - j;
  }
  
  public int a(Friends paramFriends)
  {
    int i = 16384;
    int k = bhlg.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    int j;
    if ((k != 6) && (k != 0))
    {
      j = 65536;
      label32:
      if (!bdgb.b()) {
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
 * Qualified Name:     ajun
 * JD-Core Version:    0.7.0.1
 */