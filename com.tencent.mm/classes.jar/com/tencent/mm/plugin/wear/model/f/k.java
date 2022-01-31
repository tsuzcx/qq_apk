package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.cka;
import java.io.IOException;

public final class k
  extends c
{
  private String bHk;
  private int code;
  
  public k(int paramInt, String paramString)
  {
    this.code = paramInt;
    this.bHk = paramString;
  }
  
  public final String getName()
  {
    return "WearPushPayResponseTask";
  }
  
  protected final void send()
  {
    cka localcka = new cka();
    switch (this.code)
    {
    }
    for (;;)
    {
      localcka.tWr = this.bHk;
      try
      {
        a.bYL();
        r.b(20016, localcka.toByteArray(), true);
        return;
      }
      catch (IOException localIOException) {}
      localcka.tMt = 0;
      continue;
      localcka.tMt = 196610;
      continue;
      localcka.tMt = 196613;
      continue;
      localcka.tMt = 196614;
      continue;
      localcka.tMt = 196615;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.k
 * JD-Core Version:    0.7.0.1
 */