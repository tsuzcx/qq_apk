import android.util.SparseArray;
import com.tencent.mobileqq.data.ApolloGameData;
import java.util.Comparator;

class aizl
  implements Comparator<ApolloGameData>
{
  SparseArray<Long> a;
  
  aizl(SparseArray paramSparseArray)
  {
    this.a = paramSparseArray;
  }
  
  public int a(ApolloGameData paramApolloGameData1, ApolloGameData paramApolloGameData2)
  {
    long l2 = 0L;
    long l1;
    if (this.a.get(paramApolloGameData1.gameId) == null)
    {
      l1 = 0L;
      if (this.a.get(paramApolloGameData2.gameId) != null) {
        break label63;
      }
    }
    for (;;)
    {
      if (l1 <= l2) {
        break label85;
      }
      return -1;
      l1 = ((Long)this.a.get(paramApolloGameData1.gameId)).longValue();
      break;
      label63:
      l2 = ((Long)this.a.get(paramApolloGameData2.gameId)).longValue();
    }
    label85:
    if (l1 < l2) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aizl
 * JD-Core Version:    0.7.0.1
 */