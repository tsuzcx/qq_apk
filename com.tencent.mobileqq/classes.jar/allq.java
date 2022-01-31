import android.os.Bundle;

public class allq
{
  private Bundle a;
  
  public allq(Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public Bundle a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    this.a.putLong("downloadItems", paramLong);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.putBoolean("NoLimitParams", paramBoolean);
  }
  
  public void b(long paramLong)
  {
    this.a.putLong("recognitionMask", paramLong);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.putBoolean("arTransferPromotion", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     allq
 * JD-Core Version:    0.7.0.1
 */