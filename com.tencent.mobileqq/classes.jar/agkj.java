import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout.OnVisibilityListener;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

class agkj
  implements EmotionKeywordLayout.OnVisibilityListener
{
  agkj(agki paramagki) {}
  
  public void onVisibilityChanged(int paramInt)
  {
    if (paramInt == 8) {
      agki.a(this.a).c();
    }
    while ((paramInt != 0) || (agki.a(this.a) == 0L)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = agki.a(this.a);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecShowCost", true, l1 - l2, 0L, null, "");
    agki.a(this.a, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkj
 * JD-Core Version:    0.7.0.1
 */