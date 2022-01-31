import com.tencent.mobileqq.data.ApolloActionData;
import java.util.Comparator;

class ajmy
  implements Comparator<ApolloActionData>
{
  ajmy(ajmu paramajmu) {}
  
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
 * Qualified Name:     ajmy
 * JD-Core Version:    0.7.0.1
 */