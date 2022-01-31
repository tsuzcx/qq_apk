import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.FTSSearchResultItem;
import java.util.Comparator;

public class ahtw
  implements Comparator
{
  public ahtw(FTSMessageSearchEngine paramFTSMessageSearchEngine) {}
  
  public int a(FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem1, FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem2)
  {
    int j = Long.signum(paramFTSSearchResultItem1.b - paramFTSSearchResultItem2.b);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramFTSSearchResultItem1.c - paramFTSSearchResultItem2.c);
      i = j;
      if (j == 0) {
        i = Long.signum(-paramFTSSearchResultItem1.a + paramFTSSearchResultItem2.a);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahtw
 * JD-Core Version:    0.7.0.1
 */