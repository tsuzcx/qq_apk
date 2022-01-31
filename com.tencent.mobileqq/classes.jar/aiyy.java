import com.tencent.mobileqq.data.ApolloActionData;
import java.util.Comparator;

class aiyy
  implements Comparator<ApolloActionData>
{
  aiyy(aiyu paramaiyu) {}
  
  public int a(ApolloActionData paramApolloActionData1, ApolloActionData paramApolloActionData2)
  {
    if (paramApolloActionData2.obtainedTime == paramApolloActionData1.obtainedTime) {
      return 0;
    }
    if (paramApolloActionData2.obtainedTime > paramApolloActionData1.obtainedTime) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiyy
 * JD-Core Version:    0.7.0.1
 */