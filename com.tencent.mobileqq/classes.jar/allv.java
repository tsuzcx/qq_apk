import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

final class allv
  implements Comparator<awbv>
{
  public int a(awbv paramawbv1, awbv paramawbv2)
  {
    int i = 0;
    if ((paramawbv1 instanceof Groups))
    {
      paramawbv1 = (Groups)paramawbv1;
      paramawbv2 = (Groups)paramawbv2;
      return paramawbv1.seqid - paramawbv2.seqid;
    }
    Object localObject = "-";
    String str = "-";
    int j;
    if ((paramawbv1 instanceof Friends))
    {
      paramawbv1 = (Friends)paramawbv1;
      localObject = (Friends)paramawbv2;
      j = paramawbv1.mComparePartInt;
      paramawbv2 = paramawbv1.mCompareSpell;
      i = ((Friends)localObject).mComparePartInt;
      paramawbv1 = ((Friends)localObject).mCompareSpell;
    }
    for (;;)
    {
      return allu.a(j, paramawbv2, i, paramawbv1);
      if ((paramawbv1 instanceof TroopInfo))
      {
        paramawbv1 = (TroopInfo)paramawbv1;
        localObject = (TroopInfo)paramawbv2;
        j = paramawbv1.mComparePartInt;
        i = ((TroopInfo)localObject).mComparePartInt;
        paramawbv2 = paramawbv1.mCompareSpell;
        paramawbv1 = ((TroopInfo)localObject).mCompareSpell;
      }
      else if ((paramawbv1 instanceof DiscussionInfo))
      {
        paramawbv1 = (DiscussionInfo)paramawbv1;
        localObject = (DiscussionInfo)paramawbv2;
        j = paramawbv1.mComparePartInt;
        i = ((DiscussionInfo)localObject).mComparePartInt;
        paramawbv2 = paramawbv1.mCompareSpell;
        paramawbv1 = ((DiscussionInfo)localObject).mCompareSpell;
      }
      else if ((paramawbv1 instanceof PublicAccountInfo))
      {
        paramawbv1 = (PublicAccountInfo)paramawbv1;
        localObject = (PublicAccountInfo)paramawbv2;
        j = paramawbv1.mComparePartInt;
        i = ((PublicAccountInfo)localObject).mComparePartInt;
        paramawbv2 = paramawbv1.mCompareSpell;
        paramawbv1 = ((PublicAccountInfo)localObject).mCompareSpell;
      }
      else
      {
        j = 0;
        paramawbv1 = str;
        paramawbv2 = (awbv)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     allv
 * JD-Core Version:    0.7.0.1
 */