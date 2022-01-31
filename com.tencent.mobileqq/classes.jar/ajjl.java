import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import java.util.Comparator;

class ajjl
  implements Comparator<SpecialCareInfo>
{
  ajjl(ajjj paramajjj) {}
  
  private String a(SpecialCareInfo paramSpecialCareInfo)
  {
    Friends localFriends = this.a.b(paramSpecialCareInfo.uin);
    if (localFriends == null) {
      return paramSpecialCareInfo.uin;
    }
    return babh.a(localFriends) + localFriends.uin;
  }
  
  public int a(SpecialCareInfo paramSpecialCareInfo1, SpecialCareInfo paramSpecialCareInfo2)
  {
    return ajgh.a(a(paramSpecialCareInfo1), a(paramSpecialCareInfo2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajjl
 * JD-Core Version:    0.7.0.1
 */