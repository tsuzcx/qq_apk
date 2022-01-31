import android.util.Pair;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QueryTask.Query;

public class aein
  implements QueryTask.Query
{
  public aein(EmoticonManager paramEmoticonManager) {}
  
  public Emoticon a(Pair paramPair)
  {
    return this.a.a((String)paramPair.first, (String)paramPair.second);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aein
 * JD-Core Version:    0.7.0.1
 */