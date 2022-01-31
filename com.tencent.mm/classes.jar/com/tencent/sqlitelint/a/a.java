package com.tencent.sqlitelint.a;

import com.tencent.sqlitelint.e;
import com.tencent.sqlitelint.e.a;
import com.tencent.sqlitelint.e.b;
import com.tencent.sqlitelint.e.c;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public final List<a> wRH;
  
  public a(e.c paramc)
  {
    e.a(paramc);
    this.wRH = new ArrayList();
  }
  
  public static final class a
  {
    public final e.a wRI;
    public final e.b wRJ;
    public int wRK;
    public final List<String> wRL = new ArrayList();
    
    static
    {
      if (!a.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    public a(e.a parama, e.b paramb)
    {
      this.wRI = parama;
      this.wRJ = paramb;
    }
    
    public final a aga(String paramString)
    {
      this.wRL.add(paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.a.a
 * JD-Core Version:    0.7.0.1
 */