package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.h.a.qj;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  implements b.b
{
  public c ono = new a.1(this);
  
  public a()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.ono);
    af.bDA().a(this);
  }
  
  public final void Ni(String paramString)
  {
    y.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", new Object[] { paramString });
    qj localqj = new qj();
    localqj.bZJ.bHz = 2;
    localqj.bZJ.bUi = paramString;
    String str = an.eJ(af.getAccSnsPath(), paramString);
    localqj.bZJ.path = (str + i.MR(paramString));
    com.tencent.mm.sdk.b.a.udP.m(localqj);
  }
  
  public final void bCt() {}
  
  public final void ba(String paramString, boolean paramBoolean) {}
  
  public final void bb(String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.e.a
 * JD-Core Version:    0.7.0.1
 */