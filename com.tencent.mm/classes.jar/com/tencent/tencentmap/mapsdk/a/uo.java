package com.tencent.tencentmap.mapsdk.a;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

public class uo
  extends uj
{
  private static AtomicInteger c = new AtomicInteger(0);
  private String[] b = { "https://s0.map.gtimg.com/oversea", "https://s1.map.gtimg.com/oversea", "https://s2.map.gtimg.com/oversea", "https://s3.map.gtimg.com/oversea" };
  
  public uo(int paramInt)
  {
    super(paramInt);
  }
  
  public static void a()
  {
    new Thread(new uo.1(c.get())).start();
    c.set(0);
  }
  
  public URL a(int paramInt1, int paramInt2, int paramInt3, Object... paramVarArgs)
  {
    int i = a(paramInt1 + paramInt2, this.b.length);
    paramVarArgs = this.b[i];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramVarArgs);
    localStringBuilder.append("?");
    localStringBuilder.append("z=").append(paramInt3);
    localStringBuilder.append("&x=").append(paramInt1);
    localStringBuilder.append("&y=").append(paramInt2);
    localStringBuilder.append("&styleid=").append(tp.e());
    localStringBuilder.append("&scene=").append(tp.f());
    localStringBuilder.append("&version=").append(tp.g());
    localStringBuilder.append("&ch=").append(tn.q());
    paramVarArgs = localStringBuilder.toString();
    try
    {
      c.incrementAndGet();
      paramVarArgs = new URL(paramVarArgs);
      return paramVarArgs;
    }
    catch (MalformedURLException paramVarArgs) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.uo
 * JD-Core Version:    0.7.0.1
 */