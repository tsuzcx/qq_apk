import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class ahcr
  implements Comparator
{
  public ahcr(FunctionModuleConfigManager paramFunctionModuleConfigManager) {}
  
  public int a(GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem1, GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem2)
  {
    int i = paramGroupBaseNetSearchModelItem2.a[2] - paramGroupBaseNetSearchModelItem1.a[2];
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = paramGroupBaseNetSearchModelItem1.a[0] - paramGroupBaseNetSearchModelItem2.a[0];
      i = j;
    } while (j != 0);
    paramGroupBaseNetSearchModelItem1 = paramGroupBaseNetSearchModelItem1.c.substring(paramGroupBaseNetSearchModelItem1.a[0] + paramGroupBaseNetSearchModelItem1.a[1]);
    paramGroupBaseNetSearchModelItem2 = paramGroupBaseNetSearchModelItem2.c.substring(paramGroupBaseNetSearchModelItem2.a[0] + paramGroupBaseNetSearchModelItem2.a[1]);
    return ChnToSpell.a(paramGroupBaseNetSearchModelItem1, 2).compareTo(ChnToSpell.a(paramGroupBaseNetSearchModelItem2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahcr
 * JD-Core Version:    0.7.0.1
 */