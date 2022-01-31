package com.tencent.mm.plugin.s;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;

public final class g
{
  public long auM = 0L;
  public long cfq = 0L;
  private boolean dnJ;
  public boolean joQ = true;
  public boolean joR = false;
  public long mef = 0L;
  public long meg = -1L;
  public long meh = 0L;
  public long mei = 0L;
  public long mej = 0L;
  public long mek = 10L;
  public boolean mel = true;
  public boolean mem = false;
  boolean men = false;
  boolean meo = false;
  
  public g(boolean paramBoolean)
  {
    this.dnJ = paramBoolean;
  }
  
  public final void Ih(String paramString)
  {
    if (!this.mel) {
      return;
    }
    h.nFQ.a(354L, 152L, 1L, false);
    h.nFQ.f(13836, new Object[] { Integer.valueOf(500), Long.valueOf(bk.UX()), paramString });
  }
  
  public final void Ii(String paramString)
  {
    if (!this.mel) {
      return;
    }
    h.nFQ.a(354L, 153L, 1L, false);
    h.nFQ.f(13836, new Object[] { Integer.valueOf(501), Long.valueOf(bk.UX()), paramString });
  }
  
  public final String ayN()
  {
    return hashCode();
  }
  
  public final void bis()
  {
    if (!this.mel) {
      return;
    }
    h.nFQ.a(354L, 155L, 1L, false);
    h.nFQ.f(13836, new Object[] { Integer.valueOf(503), Long.valueOf(bk.UX()), "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.s.g
 * JD-Core Version:    0.7.0.1
 */