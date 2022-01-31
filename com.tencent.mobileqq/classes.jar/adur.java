import android.util.Pair;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QueryTask.Query;

public class adur
  implements QueryTask.Query
{
  public adur(EmoticonManager paramEmoticonManager) {}
  
  public EmoticonPackage a(Pair paramPair)
  {
    return this.a.b((String)paramPair.first, ((Integer)paramPair.second).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adur
 * JD-Core Version:    0.7.0.1
 */