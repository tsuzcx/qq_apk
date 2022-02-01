package org.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.b.d.i;

public class c
  extends b
{
  public final String b(i parami)
  {
    AppMethodBeat.i(40503);
    parami = String.format("https://api.twitter.com/oauth/authorize?oauth_token=%s", new Object[] { parami.token });
    AppMethodBeat.o(40503);
    return parami;
  }
  
  public String gfO()
  {
    return "http://api.twitter.com/oauth/request_token";
  }
  
  public String gfP()
  {
    return "http://api.twitter.com/oauth/access_token";
  }
  
  public static class a
    extends c
  {
    public final String gfO()
    {
      return "https://api.twitter.com/oauth/request_token";
    }
    
    public final String gfP()
    {
      return "https://api.twitter.com/oauth/access_token";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */