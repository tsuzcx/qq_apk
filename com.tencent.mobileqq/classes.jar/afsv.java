import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout.OnVisibilityListener;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

class afsv
  implements EmotionKeywordLayout.OnVisibilityListener
{
  afsv(afsu paramafsu) {}
  
  public void onVisibilityChanged(int paramInt)
  {
    if (paramInt == 8) {
      afsu.a(this.a).b();
    }
    while ((paramInt != 0) || (afsu.a(this.a) == 0L)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = afsu.a(this.a);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecShowCost", true, l1 - l2, 0L, null, "");
    afsu.a(this.a, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsv
 * JD-Core Version:    0.7.0.1
 */