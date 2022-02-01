package com.tencent.mm.plugin.sns.b;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelsns.g;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.storage.bv;

public abstract interface j
  extends a
{
  public abstract String W(bv parambv);
  
  public abstract String a(String paramString, PString paramPString);
  
  public abstract void a(String paramString, z.b paramb, bv parambv);
  
  public abstract void aC(bv parambv);
  
  public abstract void b(String paramString, g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.b.j
 * JD-Core Version:    0.7.0.1
 */