import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;

public class ackn
  extends QQLruCache<String, aeav>
{
  public ackn(CustomizeStrategyFactory paramCustomizeStrategyFactory, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(boolean paramBoolean, String paramString, aeav paramaeav1, aeav paramaeav2)
  {
    super.entryRemoved(paramBoolean, paramString, paramaeav1, paramaeav2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ackn
 * JD-Core Version:    0.7.0.1
 */