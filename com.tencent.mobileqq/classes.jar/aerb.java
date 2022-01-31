import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;

public class aerb
  extends QQLruCache<String, agmy>
{
  public aerb(CustomizeStrategyFactory paramCustomizeStrategyFactory, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(boolean paramBoolean, String paramString, agmy paramagmy1, agmy paramagmy2)
  {
    super.entryRemoved(paramBoolean, paramString, paramagmy1, paramagmy2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aerb
 * JD-Core Version:    0.7.0.1
 */