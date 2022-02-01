package mqq.app.api;

import com.tencent.mobileqq.qroute.QRouteApi;

public class SSOResponse
  implements QRouteApi
{
  public byte[] body;
  public Integer errCode;
  public Boolean isSuc;
  public SSORequest request;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.api.SSOResponse
 * JD-Core Version:    0.7.0.1
 */