import com.tencent.ad.tangram.net.AdHttp.Params;

class acxe
  extends AdHttp.Params
{
  public int a = -2147483648;
  
  public boolean isSuccess()
  {
    return (super.isSuccess()) && (this.responseData != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxe
 * JD-Core Version:    0.7.0.1
 */