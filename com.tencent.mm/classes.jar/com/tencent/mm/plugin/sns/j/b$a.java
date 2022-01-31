package com.tencent.mm.plugin.sns.j;

import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;

public final class b$a
  implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>>
{
  public b$a(b paramb) {}
  
  public final c<Void> b(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return f.a(paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt)).c(this);
  }
  
  public final String vP()
  {
    return "Vending.LOGIC";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.b.a
 * JD-Core Version:    0.7.0.1
 */