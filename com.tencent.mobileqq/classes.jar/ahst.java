import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.Comparator;

public class ahst
  implements Comparator<TroopMemberInfo>
{
  private ahst(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame) {}
  
  public int a(TroopMemberInfo paramTroopMemberInfo1, TroopMemberInfo paramTroopMemberInfo2)
  {
    int j = 0;
    int k = 0;
    int i;
    if (this.a.f == TroopAddFrdsInnerFrame.e)
    {
      i = paramTroopMemberInfo1.addState - paramTroopMemberInfo2.addState;
      if (i == 0) {
        if (paramTroopMemberInfo1.commonFrdCnt == -2147483648)
        {
          i = 0;
          if (paramTroopMemberInfo2.commonFrdCnt != -2147483648) {
            break label189;
          }
          j = 0;
          label56:
          if ((i != 0) || (j != 0) || (TroopAddFrdsInnerFrame.a(this.a) == null)) {
            break label257;
          }
          if ((!TroopAddFrdsInnerFrame.a(this.a).isTroopAdmin(paramTroopMemberInfo1.memberuin)) && (!TroopAddFrdsInnerFrame.a(this.a).isTroopOwner(paramTroopMemberInfo1.memberuin))) {
            break label252;
          }
          i = 1;
          label111:
          if (!TroopAddFrdsInnerFrame.a(this.a).isTroopAdmin(paramTroopMemberInfo2.memberuin))
          {
            j = k;
            if (!TroopAddFrdsInnerFrame.a(this.a).isTroopOwner(paramTroopMemberInfo2.memberuin)) {}
          }
          else
          {
            j = 1;
          }
          j -= i;
          i = j;
          if (j == 0) {
            i = Long.signum(paramTroopMemberInfo2.last_active_time - paramTroopMemberInfo1.last_active_time);
          }
        }
      }
    }
    for (;;)
    {
      return i;
      i = paramTroopMemberInfo1.commonFrdCnt;
      break;
      label189:
      j = paramTroopMemberInfo2.commonFrdCnt;
      break label56;
      return i;
      i = j;
      if (this.a.f == TroopAddFrdsInnerFrame.d)
      {
        i = j;
        if (paramTroopMemberInfo1 != null)
        {
          i = j;
          if (paramTroopMemberInfo1.displayedNamePinyinFirst != null)
          {
            i = j;
            if (paramTroopMemberInfo2 != null)
            {
              return paramTroopMemberInfo1.displayedNamePinyinFirst.compareToIgnoreCase(paramTroopMemberInfo2.displayedNamePinyinFirst);
              label252:
              i = 0;
              break label111;
              label257:
              i = j - i;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahst
 * JD-Core Version:    0.7.0.1
 */