package navsns;

import com.tencent.tencentmap.mapsdk.a.av;
import com.tencent.tencentmap.mapsdk.a.nk;
import com.tencent.tencentmap.mapsdk.a.nl;
import com.tencent.tencentmap.mapsdk.a.nn;
import java.util.HashMap;
import java.util.Map;

public final class RttServantPrxHelper
  extends av
  implements RttServantPrx
{
  protected String a = "GBK";
  
  public final Map __defaultContext()
  {
    return new HashMap();
  }
  
  public final void async_getLinks(RttServantPrxCallback paramRttServantPrxCallback, user_login_t paramuser_login_t, RttLinkRequest paramRttLinkRequest)
  {
    async_getLinks(paramRttServantPrxCallback, paramuser_login_t, paramRttLinkRequest, __defaultContext());
  }
  
  public final void async_getLinks(RttServantPrxCallback paramRttServantPrxCallback, user_login_t paramuser_login_t, RttLinkRequest paramRttLinkRequest, Map paramMap)
  {
    nl localnl = new nl(0);
    localnl.a(this.a);
    localnl.a(paramuser_login_t, 1);
    localnl.a(paramRttLinkRequest, 2);
    a(paramRttServantPrxCallback, "getLinks", nn.a(localnl.a()), paramMap, new HashMap());
  }
  
  public final int getLinks(user_login_t paramuser_login_t, RttLinkRequest paramRttLinkRequest, RttLinkResponseHolder paramRttLinkResponseHolder)
  {
    return getLinks(paramuser_login_t, paramRttLinkRequest, paramRttLinkResponseHolder, __defaultContext());
  }
  
  public final int getLinks(user_login_t paramuser_login_t, RttLinkRequest paramRttLinkRequest, RttLinkResponseHolder paramRttLinkResponseHolder, Map paramMap)
  {
    nl localnl = new nl(0);
    localnl.a(this.a);
    localnl.a(paramuser_login_t, 1);
    localnl.a(paramRttLinkRequest, 2);
    if (paramRttLinkResponseHolder.value != null) {
      localnl.a(paramRttLinkResponseHolder.value, 3);
    }
    paramuser_login_t = new nk(taf_invoke("getLinks", nn.a(localnl.a()), paramMap, new HashMap()));
    paramuser_login_t.a(this.a);
    int i = paramuser_login_t.a(0, 0, true);
    paramRttLinkResponseHolder.value = new RttLinkResponse();
    paramRttLinkResponseHolder.value = ((RttLinkResponse)paramuser_login_t.a(paramRttLinkResponseHolder.value, 3, true));
    return i;
  }
  
  public final int setServerEncoding(String paramString)
  {
    this.a = paramString;
    return 0;
  }
  
  public final RttServantPrxHelper taf_hash(int paramInt)
  {
    super.taf_hash(paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     navsns.RttServantPrxHelper
 * JD-Core Version:    0.7.0.1
 */