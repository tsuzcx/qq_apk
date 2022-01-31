import android.util.Pair;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QueryTask.Query;

public class aeqh
  implements QueryTask.Query
{
  public aeqh(EmoticonManager paramEmoticonManager) {}
  
  public EmoticonPackage a(Pair paramPair)
  {
    return this.a.c((String)paramPair.first, ((Integer)paramPair.second).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqh
 * JD-Core Version:    0.7.0.1
 */