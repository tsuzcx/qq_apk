package com.tencent.mm.ui.conversation;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class h$e
{
  private ad dnp = null;
  private boolean initialized = false;
  private String talker = null;
  private Integer vQx = null;
  
  public h$e(h paramh) {}
  
  public final ad cIi()
  {
    if ((this.initialized) && (this.dnp == null) && (au.DK()))
    {
      au.Hx();
      this.dnp = c.Fw().abl(this.talker);
    }
    return this.dnp;
  }
  
  public final void ec(String paramString)
  {
    this.talker = paramString;
    this.dnp = null;
    this.vQx = null;
    this.initialized = false;
    if (!ah.bl(paramString)) {
      this.initialized = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h.e
 * JD-Core Version:    0.7.0.1
 */