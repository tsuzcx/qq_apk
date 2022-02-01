import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;

public class afac
  extends QQLruCache<String, ahdi>
{
  public afac(CustomizeStrategyFactory paramCustomizeStrategyFactory, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(boolean paramBoolean, String paramString, ahdi paramahdi1, ahdi paramahdi2)
  {
    super.entryRemoved(paramBoolean, paramString, paramahdi1, paramahdi2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afac
 * JD-Core Version:    0.7.0.1
 */