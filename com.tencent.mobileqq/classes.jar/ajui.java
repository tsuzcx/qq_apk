import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

final class ajui
  implements Comparator<auko>
{
  public int a(auko paramauko1, auko paramauko2)
  {
    int i = 0;
    if ((paramauko1 instanceof Groups))
    {
      paramauko1 = (Groups)paramauko1;
      paramauko2 = (Groups)paramauko2;
      return paramauko1.seqid - paramauko2.seqid;
    }
    Object localObject = "-";
    String str = "-";
    int j;
    if ((paramauko1 instanceof Friends))
    {
      paramauko1 = (Friends)paramauko1;
      localObject = (Friends)paramauko2;
      j = paramauko1.mComparePartInt;
      paramauko2 = paramauko1.mCompareSpell;
      i = ((Friends)localObject).mComparePartInt;
      paramauko1 = ((Friends)localObject).mCompareSpell;
    }
    for (;;)
    {
      return ajuh.a(j, paramauko2, i, paramauko1);
      if ((paramauko1 instanceof TroopInfo))
      {
        paramauko1 = (TroopInfo)paramauko1;
        localObject = (TroopInfo)paramauko2;
        j = paramauko1.mComparePartInt;
        i = ((TroopInfo)localObject).mComparePartInt;
        paramauko2 = paramauko1.mCompareSpell;
        paramauko1 = ((TroopInfo)localObject).mCompareSpell;
      }
      else if ((paramauko1 instanceof DiscussionInfo))
      {
        paramauko1 = (DiscussionInfo)paramauko1;
        localObject = (DiscussionInfo)paramauko2;
        j = paramauko1.mComparePartInt;
        i = ((DiscussionInfo)localObject).mComparePartInt;
        paramauko2 = paramauko1.mCompareSpell;
        paramauko1 = ((DiscussionInfo)localObject).mCompareSpell;
      }
      else if ((paramauko1 instanceof PublicAccountInfo))
      {
        paramauko1 = (PublicAccountInfo)paramauko1;
        localObject = (PublicAccountInfo)paramauko2;
        j = paramauko1.mComparePartInt;
        i = ((PublicAccountInfo)localObject).mComparePartInt;
        paramauko2 = paramauko1.mCompareSpell;
        paramauko1 = ((PublicAccountInfo)localObject).mCompareSpell;
      }
      else
      {
        j = 0;
        paramauko1 = str;
        paramauko2 = (auko)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajui
 * JD-Core Version:    0.7.0.1
 */