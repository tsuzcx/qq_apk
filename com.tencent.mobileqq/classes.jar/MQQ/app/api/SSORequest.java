package mqq.app.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import java.util.HashMap;

public class SSORequest
  implements QRouteApi
{
  public byte[] body;
  public String cmd;
  public Integer dataType;
  public HashMap extra;
  public Integer timeout;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.api.SSORequest
 * JD-Core Version:    0.7.0.1
 */