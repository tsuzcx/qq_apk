import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;

public class acvc
  extends QQLruCache<String, aels>
{
  public acvc(CustomizeStrategyFactory paramCustomizeStrategyFactory, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(boolean paramBoolean, String paramString, aels paramaels1, aels paramaels2)
  {
    super.entryRemoved(paramBoolean, paramString, paramaels1, paramaels2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acvc
 * JD-Core Version:    0.7.0.1
 */