package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.mq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class b
  extends c<mq>
{
  protected ArrayList<String> EJP = new ArrayList(3);
  
  public b()
  {
    super(0);
    this.__eventId = mq.class.getName().hashCode();
  }
  
  public static void a(String paramString, b paramb)
  {
    if (!paramb.EJP.contains(paramString)) {
      paramb.EJP.add(paramString);
    }
    a.IbL.c(paramb);
    e.aLp(paramString);
  }
  
  public static void b(String paramString, b paramb)
  {
    e.aLq(paramString);
    a.IbL.d(paramb);
    if (paramb.EJP.contains(paramString)) {
      paramb.EJP.remove(paramString);
    }
  }
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.sdk.b.b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.b
 * JD-Core Version:    0.7.0.1
 */