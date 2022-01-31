import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;

public class aemm
  extends QQLruCache<String, agij>
{
  public aemm(CustomizeStrategyFactory paramCustomizeStrategyFactory, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(boolean paramBoolean, String paramString, agij paramagij1, agij paramagij2)
  {
    super.entryRemoved(paramBoolean, paramString, paramagij1, paramagij2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemm
 * JD-Core Version:    0.7.0.1
 */