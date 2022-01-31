import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.FTSSearchResultItem;
import java.util.Comparator;

public class ahfw
  implements Comparator
{
  public ahfw(FTSMessageSearchEngine paramFTSMessageSearchEngine) {}
  
  public int a(FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem1, FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem2)
  {
    int j = Long.signum(paramFTSSearchResultItem1.jdField_a_of_type_Int - paramFTSSearchResultItem2.jdField_a_of_type_Int);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramFTSSearchResultItem1.b - paramFTSSearchResultItem2.b);
      i = j;
      if (j == 0)
      {
        j = Long.signum(paramFTSSearchResultItem1.c - paramFTSSearchResultItem2.c);
        i = j;
        if (j == 0) {
          i = Long.signum(-paramFTSSearchResultItem1.jdField_a_of_type_Long + paramFTSSearchResultItem2.jdField_a_of_type_Long);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahfw
 * JD-Core Version:    0.7.0.1
 */