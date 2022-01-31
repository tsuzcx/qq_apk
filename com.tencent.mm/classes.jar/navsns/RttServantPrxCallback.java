package navsns;

import com.tencent.tencentmap.mapsdk.a.aw;
import com.tencent.tencentmap.mapsdk.a.ju;
import com.tencent.tencentmap.mapsdk.a.nk;
import java.util.Arrays;

public abstract class RttServantPrxCallback
  extends aw
{
  protected String[] a = { "getLinks" };
  protected String b = "GBK";
  
  public final int _onDispatch(String paramString, ju paramju)
  {
    int i = Arrays.binarySearch(this.a, paramString);
    if ((i < 0) || (i > 0)) {
      return -1;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      if (paramju.e != 0)
      {
        callback_getLinks_exception(paramju.e);
        return paramju.e;
      }
      paramString = new nk(paramju.f);
      paramString.a(this.b);
      callback_getLinks(paramString.a(0, 0, true), (RttLinkResponse)paramString.a(new RttLinkResponse(), 3, true));
    }
  }
  
  public abstract void callback_getLinks(int paramInt, RttLinkResponse paramRttLinkResponse);
  
  public abstract void callback_getLinks_exception(int paramInt);
  
  public int setServerEncoding(String paramString)
  {
    this.b = paramString;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     navsns.RttServantPrxCallback
 * JD-Core Version:    0.7.0.1
 */