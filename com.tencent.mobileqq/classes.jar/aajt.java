import com.tencent.mobileqq.ark.ArkActionAppMgr;
import com.tencent.mobileqq.ark.ArkAppInfo.Context;
import java.util.Comparator;

public class aajt
  implements Comparator
{
  public aajt(ArkActionAppMgr paramArkActionAppMgr) {}
  
  public int a(ArkAppInfo.Context paramContext1, ArkAppInfo.Context paramContext2)
  {
    int i = paramContext1.a.compareTo(paramContext2.a);
    if (i != 0) {
      return i;
    }
    return paramContext1.b.compareTo(paramContext2.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajt
 * JD-Core Version:    0.7.0.1
 */