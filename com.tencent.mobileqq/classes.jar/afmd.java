import com.tencent.mobileqq.data.MayKnowRecommend;
import java.util.Comparator;

class afmd
  implements Comparator<MayKnowRecommend>
{
  afmd(afly paramafly) {}
  
  public int a(MayKnowRecommend paramMayKnowRecommend1, MayKnowRecommend paramMayKnowRecommend2)
  {
    return paramMayKnowRecommend2.timestamp - paramMayKnowRecommend1.timestamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afmd
 * JD-Core Version:    0.7.0.1
 */