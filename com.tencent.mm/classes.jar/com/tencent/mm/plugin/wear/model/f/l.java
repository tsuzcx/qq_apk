package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.ckp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class l
  extends c
{
  private int qSa;
  private String talker;
  
  public l(int paramInt, String paramString)
  {
    this.qSa = paramInt;
    this.talker = paramString;
  }
  
  public final String getName()
  {
    return "WearVoipControllerTask";
  }
  
  protected final void send()
  {
    switch (this.qSa)
    {
    default: 
      return;
    case 20010: 
      ckp localckp = new ckp();
      localckp.tXp = this.talker;
      localckp.hRf = h.Rj(this.talker);
      try
      {
        a.bYL();
        r.b(this.qSa, localckp.toByteArray(), false);
        return;
      }
      catch (IOException localIOException)
      {
        return;
      }
    }
    try
    {
      a.bYL();
      r.b(this.qSa, this.talker.getBytes("utf8"), false);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.l
 * JD-Core Version:    0.7.0.1
 */