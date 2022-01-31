import android.util.Pair;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QueryTask.Query;

public class aehx
  implements QueryTask.Query
{
  public aehx(EmoticonManager paramEmoticonManager) {}
  
  public EmoticonPackage a(Pair paramPair)
  {
    return this.a.b((String)paramPair.first, ((Integer)paramPair.second).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehx
 * JD-Core Version:    0.7.0.1
 */