import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class ambt
  extends QQLruCache<Integer, ambg>
{
  public ambt(BubbleManager paramBubbleManager, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void a()
  {
    Map localMap = snapshot();
    if (localMap != null)
    {
      Iterator localIterator = localMap.values().iterator();
      while (localIterator.hasNext()) {
        ((ambg)localIterator.next()).a();
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleManager", 2, "BubbleInfoLruCache cleared, size = " + localMap.size());
      }
    }
  }
  
  protected void a(boolean paramBoolean, Integer paramInteger, ambg paramambg1, ambg paramambg2)
  {
    super.entryRemoved(paramBoolean, paramInteger, paramambg1, paramambg2);
    if (QLog.isColorLevel()) {
      QLog.d("BubbleManager", 2, "entryRemoved key=" + paramInteger);
    }
    paramambg1.a();
  }
  
  public boolean a(int paramInt)
  {
    return get(Integer.valueOf(paramInt)) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambt
 * JD-Core Version:    0.7.0.1
 */