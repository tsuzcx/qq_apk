package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.ly;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class b
  extends c<ly>
{
  protected ArrayList<String> BNJ = new ArrayList(3);
  
  public b()
  {
    super(0);
    this.__eventId = ly.class.getName().hashCode();
  }
  
  public static void a(String paramString, b paramb)
  {
    if (!paramb.BNJ.contains(paramString)) {
      paramb.BNJ.add(paramString);
    }
    a.ESL.c(paramb);
    e.aAx(paramString);
  }
  
  public static void b(String paramString, b paramb)
  {
    e.aAy(paramString);
    a.ESL.d(paramb);
    if (paramb.BNJ.contains(paramString)) {
      paramb.BNJ.remove(paramString);
    }
  }
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.sdk.b.b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.b
 * JD-Core Version:    0.7.0.1
 */