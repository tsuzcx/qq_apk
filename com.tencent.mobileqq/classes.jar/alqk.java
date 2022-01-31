import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

final class alqk
  implements Comparator<awge>
{
  public int a(awge paramawge1, awge paramawge2)
  {
    int i = 0;
    if ((paramawge1 instanceof Groups))
    {
      paramawge1 = (Groups)paramawge1;
      paramawge2 = (Groups)paramawge2;
      return paramawge1.seqid - paramawge2.seqid;
    }
    Object localObject = "-";
    String str = "-";
    int j;
    if ((paramawge1 instanceof Friends))
    {
      paramawge1 = (Friends)paramawge1;
      localObject = (Friends)paramawge2;
      j = paramawge1.mComparePartInt;
      paramawge2 = paramawge1.mCompareSpell;
      i = ((Friends)localObject).mComparePartInt;
      paramawge1 = ((Friends)localObject).mCompareSpell;
    }
    for (;;)
    {
      return alqj.a(j, paramawge2, i, paramawge1);
      if ((paramawge1 instanceof TroopInfo))
      {
        paramawge1 = (TroopInfo)paramawge1;
        localObject = (TroopInfo)paramawge2;
        j = paramawge1.mComparePartInt;
        i = ((TroopInfo)localObject).mComparePartInt;
        paramawge2 = paramawge1.mCompareSpell;
        paramawge1 = ((TroopInfo)localObject).mCompareSpell;
      }
      else if ((paramawge1 instanceof DiscussionInfo))
      {
        paramawge1 = (DiscussionInfo)paramawge1;
        localObject = (DiscussionInfo)paramawge2;
        j = paramawge1.mComparePartInt;
        i = ((DiscussionInfo)localObject).mComparePartInt;
        paramawge2 = paramawge1.mCompareSpell;
        paramawge1 = ((DiscussionInfo)localObject).mCompareSpell;
      }
      else if ((paramawge1 instanceof PublicAccountInfo))
      {
        paramawge1 = (PublicAccountInfo)paramawge1;
        localObject = (PublicAccountInfo)paramawge2;
        j = paramawge1.mComparePartInt;
        i = ((PublicAccountInfo)localObject).mComparePartInt;
        paramawge2 = paramawge1.mCompareSpell;
        paramawge1 = ((PublicAccountInfo)localObject).mCompareSpell;
      }
      else
      {
        j = 0;
        paramawge1 = str;
        paramawge2 = (awge)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alqk
 * JD-Core Version:    0.7.0.1
 */