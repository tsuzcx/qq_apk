import com.tencent.mobileqq.ark.ArkAppInfo.ContextActionAppInfo;
import java.util.Comparator;

class aajv
  implements Comparator
{
  aajv(aaju paramaaju) {}
  
  public int a(ArkAppInfo.ContextActionAppInfo paramContextActionAppInfo1, ArkAppInfo.ContextActionAppInfo paramContextActionAppInfo2)
  {
    int i = paramContextActionAppInfo1.a.compareTo(paramContextActionAppInfo2.a);
    if (i != 0) {
      return i;
    }
    return paramContextActionAppInfo1.b.compareTo(paramContextActionAppInfo2.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajv
 * JD-Core Version:    0.7.0.1
 */