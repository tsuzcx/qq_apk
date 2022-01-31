import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class ahcs
  implements Comparator
{
  public ahcs(FunctionModuleConfigManager paramFunctionModuleConfigManager) {}
  
  public int a(GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem1, GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem2)
  {
    paramGroupBaseNetSearchModelItem1 = paramGroupBaseNetSearchModelItem1.c;
    paramGroupBaseNetSearchModelItem2 = paramGroupBaseNetSearchModelItem2.c;
    return ChnToSpell.a(paramGroupBaseNetSearchModelItem1, 2).compareTo(ChnToSpell.a(paramGroupBaseNetSearchModelItem2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahcs
 * JD-Core Version:    0.7.0.1
 */