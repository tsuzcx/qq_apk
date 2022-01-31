package navsns;

import java.util.Map;

public abstract interface RttServantPrx
{
  public abstract void async_getLinks(RttServantPrxCallback paramRttServantPrxCallback, user_login_t paramuser_login_t, RttLinkRequest paramRttLinkRequest);
  
  public abstract void async_getLinks(RttServantPrxCallback paramRttServantPrxCallback, user_login_t paramuser_login_t, RttLinkRequest paramRttLinkRequest, Map paramMap);
  
  public abstract int getLinks(user_login_t paramuser_login_t, RttLinkRequest paramRttLinkRequest, RttLinkResponseHolder paramRttLinkResponseHolder);
  
  public abstract int getLinks(user_login_t paramuser_login_t, RttLinkRequest paramRttLinkRequest, RttLinkResponseHolder paramRttLinkResponseHolder, Map paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     navsns.RttServantPrx
 * JD-Core Version:    0.7.0.1
 */