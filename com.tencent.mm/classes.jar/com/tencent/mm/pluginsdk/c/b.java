package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.kt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class b
  extends c<kt>
{
  protected ArrayList<String> vJP = new ArrayList(3);
  
  public b()
  {
    super(0);
    this.__eventId = kt.class.getName().hashCode();
  }
  
  public static void a(String paramString, b paramb)
  {
    if (!paramb.vJP.contains(paramString)) {
      paramb.vJP.add(paramString);
    }
    a.ymk.c(paramb);
    e.alc(paramString);
  }
  
  public static void b(String paramString, b paramb)
  {
    e.ald(paramString);
    a.ymk.d(paramb);
    if (paramb.vJP.contains(paramString)) {
      paramb.vJP.remove(paramString);
    }
  }
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.sdk.b.b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.b
 * JD-Core Version:    0.7.0.1
 */