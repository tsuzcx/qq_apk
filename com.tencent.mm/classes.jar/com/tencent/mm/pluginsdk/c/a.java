package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.js;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class a
  extends c<js>
{
  protected ArrayList<String> vJP = new ArrayList(3);
  
  public a()
  {
    this.__eventId = js.class.getName().hashCode();
  }
  
  public static void a(String paramString, a parama)
  {
    if (!parama.vJP.contains(paramString)) {
      parama.vJP.add(paramString);
    }
    com.tencent.mm.sdk.b.a.ymk.c(parama);
    e.alc(paramString);
  }
  
  public static void b(String paramString, a parama)
  {
    e.ald(paramString);
    com.tencent.mm.sdk.b.a.ymk.d(parama);
    if (parama.vJP.contains(paramString)) {
      parama.vJP.remove(paramString);
    }
  }
  
  public abstract void i(b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.a
 * JD-Core Version:    0.7.0.1
 */