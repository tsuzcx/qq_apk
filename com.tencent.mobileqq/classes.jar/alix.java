import com.tencent.mobileqq.data.ApolloFavActionData;
import java.util.Comparator;

class alix
  implements Comparator<ApolloFavActionData>
{
  alix(aliw paramaliw) {}
  
  public int a(ApolloFavActionData paramApolloFavActionData1, ApolloFavActionData paramApolloFavActionData2)
  {
    if (paramApolloFavActionData2.favId == paramApolloFavActionData1.favId) {
      return 0;
    }
    if (paramApolloFavActionData2.favId > paramApolloFavActionData1.favId) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alix
 * JD-Core Version:    0.7.0.1
 */