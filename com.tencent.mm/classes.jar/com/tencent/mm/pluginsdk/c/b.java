package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.mh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class b
  extends c<mh>
{
  protected ArrayList<String> DfT = new ArrayList(3);
  
  public b()
  {
    super(0);
    this.__eventId = mh.class.getName().hashCode();
  }
  
  public static void a(String paramString, b paramb)
  {
    if (!paramb.DfT.contains(paramString)) {
      paramb.DfT.add(paramString);
    }
    a.GpY.c(paramb);
    e.aFP(paramString);
  }
  
  public static void b(String paramString, b paramb)
  {
    e.aFQ(paramString);
    a.GpY.d(paramb);
    if (paramb.DfT.contains(paramString)) {
      paramb.DfT.remove(paramString);
    }
  }
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.sdk.b.b paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.b
 * JD-Core Version:    0.7.0.1
 */