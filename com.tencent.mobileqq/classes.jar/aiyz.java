import com.tencent.mobileqq.data.ApolloActionData;
import java.util.Comparator;

class aiyz
  implements Comparator<ApolloActionData>
{
  aiyz(aiyu paramaiyu) {}
  
  public int a(ApolloActionData paramApolloActionData1, ApolloActionData paramApolloActionData2)
  {
    if (paramApolloActionData2.version == paramApolloActionData1.version) {
      return 0;
    }
    if (paramApolloActionData2.version > paramApolloActionData1.version) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiyz
 * JD-Core Version:    0.7.0.1
 */