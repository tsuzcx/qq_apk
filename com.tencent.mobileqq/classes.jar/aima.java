import QQService.EVIPSPEC;
import com.tencent.mobileqq.data.Friends;
import java.util.Comparator;

class aima
  implements Comparator<aiqo>
{
  public int a(aiqo paramaiqo1, aiqo paramaiqo2)
  {
    paramaiqo1 = (Friends)paramaiqo1.a;
    paramaiqo2 = (Friends)paramaiqo2.a;
    int i = a(paramaiqo1);
    int j = a(paramaiqo2);
    if (i == j) {
      return ajuj.a(paramaiqo1.mComparePartInt, paramaiqo1.mCompareSpell, paramaiqo2.mComparePartInt, paramaiqo2.mCompareSpell);
    }
    return i - j;
  }
  
  public int a(Friends paramFriends)
  {
    int i = 16384;
    int k = bbcl.a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    int j;
    if ((k != 6) && (k != 0))
    {
      j = 65536;
      label32:
      if (!axmt.b()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aima
 * JD-Core Version:    0.7.0.1
 */