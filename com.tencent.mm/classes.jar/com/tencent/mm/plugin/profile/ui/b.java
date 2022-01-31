package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.m;
import java.util.List;

public final class b
  extends m
{
  private String bVk;
  private ad dnp;
  private ah handler = new ah();
  private List<com.tencent.mm.plugin.fts.a.a.l> kxO;
  private com.tencent.mm.plugin.fts.a.a.a kxg;
  private com.tencent.mm.plugin.fts.a.l mVF = new b.1(this);
  
  public b(com.tencent.mm.ui.contact.l paraml, int paramInt, ad paramad)
  {
    super(paraml, false, paramInt);
    this.dnp = paramad;
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    this.bVk = paramString;
    paramArrayOfInt = new i();
    paramArrayOfInt.bVk = paramString;
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.kxf = this.mVF;
    paramArrayOfInt.kwY = this.dnp.field_username;
    paramArrayOfInt.kwX = 7;
    this.kxg = ((n)g.t(n.class)).search(2, paramArrayOfInt);
  }
  
  public final void adg()
  {
    this.bVk = null;
    if (this.kxg != null) {
      ((n)g.t(n.class)).cancelSearchTask(this.kxg);
    }
  }
  
  public final int getCount()
  {
    if (this.kxO == null) {
      return 0;
    }
    return this.kxO.size();
  }
  
  protected final com.tencent.mm.ui.contact.a.a jQ(int paramInt)
  {
    e locale = new e(paramInt);
    au.Hx();
    locale.dnp = c.Fw().abl(((com.tencent.mm.plugin.fts.a.a.l)this.kxO.get(paramInt)).kwg);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b
 * JD-Core Version:    0.7.0.1
 */