import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

final class ajuk
  implements Comparator<aukm>
{
  public int a(aukm paramaukm1, aukm paramaukm2)
  {
    int i = 0;
    if ((paramaukm1 instanceof Groups))
    {
      paramaukm1 = (Groups)paramaukm1;
      paramaukm2 = (Groups)paramaukm2;
      return paramaukm1.seqid - paramaukm2.seqid;
    }
    Object localObject = "-";
    String str = "-";
    int j;
    if ((paramaukm1 instanceof Friends))
    {
      paramaukm1 = (Friends)paramaukm1;
      localObject = (Friends)paramaukm2;
      j = paramaukm1.mComparePartInt;
      paramaukm2 = paramaukm1.mCompareSpell;
      i = ((Friends)localObject).mComparePartInt;
      paramaukm1 = ((Friends)localObject).mCompareSpell;
    }
    for (;;)
    {
      return ajuj.a(j, paramaukm2, i, paramaukm1);
      if ((paramaukm1 instanceof TroopInfo))
      {
        paramaukm1 = (TroopInfo)paramaukm1;
        localObject = (TroopInfo)paramaukm2;
        j = paramaukm1.mComparePartInt;
        i = ((TroopInfo)localObject).mComparePartInt;
        paramaukm2 = paramaukm1.mCompareSpell;
        paramaukm1 = ((TroopInfo)localObject).mCompareSpell;
      }
      else if ((paramaukm1 instanceof DiscussionInfo))
      {
        paramaukm1 = (DiscussionInfo)paramaukm1;
        localObject = (DiscussionInfo)paramaukm2;
        j = paramaukm1.mComparePartInt;
        i = ((DiscussionInfo)localObject).mComparePartInt;
        paramaukm2 = paramaukm1.mCompareSpell;
        paramaukm1 = ((DiscussionInfo)localObject).mCompareSpell;
      }
      else if ((paramaukm1 instanceof PublicAccountInfo))
      {
        paramaukm1 = (PublicAccountInfo)paramaukm1;
        localObject = (PublicAccountInfo)paramaukm2;
        j = paramaukm1.mComparePartInt;
        i = ((PublicAccountInfo)localObject).mComparePartInt;
        paramaukm2 = paramaukm1.mCompareSpell;
        paramaukm1 = ((PublicAccountInfo)localObject).mCompareSpell;
      }
      else
      {
        j = 0;
        paramaukm1 = str;
        paramaukm2 = (aukm)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajuk
 * JD-Core Version:    0.7.0.1
 */