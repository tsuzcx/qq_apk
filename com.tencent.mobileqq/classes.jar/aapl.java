import com.tencent.ad.tangram.net.AdHttp.Params;

class aapl
  extends AdHttp.Params
{
  public int a = -2147483648;
  
  public boolean isSuccess()
  {
    return (super.isSuccess()) && (this.responseData != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapl
 * JD-Core Version:    0.7.0.1
 */