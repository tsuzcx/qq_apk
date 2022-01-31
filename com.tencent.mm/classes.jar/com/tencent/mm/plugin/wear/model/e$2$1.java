package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.e.j;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.c;
import java.io.UnsupportedEncodingException;

final class e$2$1
  extends c
{
  e$2$1(e.2 param2) {}
  
  public final String getName()
  {
    return "SendMsgSyncTask";
  }
  
  protected final void send()
  {
    try
    {
      a.bYL();
      r.b(20007, a.bYL().qRu.qRM.qSB.getBytes("utf8"), false);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.2.1
 * JD-Core Version:    0.7.0.1
 */