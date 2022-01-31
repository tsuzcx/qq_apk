import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

final class ajgi
  implements Comparator<atmo>
{
  public int a(atmo paramatmo1, atmo paramatmo2)
  {
    int i = 0;
    if ((paramatmo1 instanceof Groups))
    {
      paramatmo1 = (Groups)paramatmo1;
      paramatmo2 = (Groups)paramatmo2;
      return paramatmo1.seqid - paramatmo2.seqid;
    }
    Object localObject = "-";
    String str = "-";
    int j;
    if ((paramatmo1 instanceof Friends))
    {
      paramatmo1 = (Friends)paramatmo1;
      localObject = (Friends)paramatmo2;
      j = paramatmo1.mComparePartInt;
      paramatmo2 = paramatmo1.mCompareSpell;
      i = ((Friends)localObject).mComparePartInt;
      paramatmo1 = ((Friends)localObject).mCompareSpell;
    }
    for (;;)
    {
      return ajgh.a(j, paramatmo2, i, paramatmo1);
      if ((paramatmo1 instanceof TroopInfo))
      {
        paramatmo1 = (TroopInfo)paramatmo1;
        localObject = (TroopInfo)paramatmo2;
        j = paramatmo1.mComparePartInt;
        i = ((TroopInfo)localObject).mComparePartInt;
        paramatmo2 = paramatmo1.mCompareSpell;
        paramatmo1 = ((TroopInfo)localObject).mCompareSpell;
      }
      else if ((paramatmo1 instanceof DiscussionInfo))
      {
        paramatmo1 = (DiscussionInfo)paramatmo1;
        localObject = (DiscussionInfo)paramatmo2;
        j = paramatmo1.mComparePartInt;
        i = ((DiscussionInfo)localObject).mComparePartInt;
        paramatmo2 = paramatmo1.mCompareSpell;
        paramatmo1 = ((DiscussionInfo)localObject).mCompareSpell;
      }
      else if ((paramatmo1 instanceof PublicAccountInfo))
      {
        paramatmo1 = (PublicAccountInfo)paramatmo1;
        localObject = (PublicAccountInfo)paramatmo2;
        j = paramatmo1.mComparePartInt;
        i = ((PublicAccountInfo)localObject).mComparePartInt;
        paramatmo2 = paramatmo1.mCompareSpell;
        paramatmo1 = ((PublicAccountInfo)localObject).mCompareSpell;
      }
      else
      {
        j = 0;
        paramatmo1 = str;
        paramatmo2 = (atmo)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajgi
 * JD-Core Version:    0.7.0.1
 */