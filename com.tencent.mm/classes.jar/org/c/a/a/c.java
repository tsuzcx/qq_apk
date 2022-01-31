package org.c.a.a;

import org.c.d.i;

public class c
  extends b
{
  public final String b(i parami)
  {
    return String.format("https://api.twitter.com/oauth/authorize?oauth_token=%s", new Object[] { parami.token });
  }
  
  public String cUS()
  {
    return "http://api.twitter.com/oauth/request_token";
  }
  
  public String cUT()
  {
    return "http://api.twitter.com/oauth/access_token";
  }
  
  public static class a
    extends c
  {
    public final String cUS()
    {
      return "https://api.twitter.com/oauth/request_token";
    }
    
    public final String cUT()
    {
      return "https://api.twitter.com/oauth/access_token";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.c.a.a.c
 * JD-Core Version:    0.7.0.1
 */