import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import java.util.Comparator;

public class ahux
  implements Comparator
{
  public ahux(ScribbleResMgr paramScribbleResMgr) {}
  
  public int a(ScribbleResMgr.ResInfo paramResInfo1, ScribbleResMgr.ResInfo paramResInfo2)
  {
    if ((paramResInfo1 != null) && (paramResInfo2 != null)) {
      return paramResInfo1.orderIndex - paramResInfo2.orderIndex;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahux
 * JD-Core Version:    0.7.0.1
 */