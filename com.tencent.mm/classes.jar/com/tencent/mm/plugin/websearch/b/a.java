package com.tencent.mm.plugin.websearch.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.c.bnz;
import com.tencent.mm.protocal.c.boa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;

public final class a
  extends com.tencent.mm.ah.a<boa>
{
  b dmK;
  
  public a(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecG = 1944;
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchlocalpage";
    ((b.a)localObject).ecH = new bnz();
    ((b.a)localObject).ecI = new boa();
    this.dmK = ((b.a)localObject).Kt();
    this.dmK = this.dmK;
    localObject = (bnz)this.dmK.ecE.ecN;
    ((bnz)localObject).tGE = paramString;
    ((bnz)localObject).pyo = 25;
    ((bnz)localObject).jxi = x.fB(ae.getContext());
    ((bnz)localObject).tqT = aa.Jx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.a
 * JD-Core Version:    0.7.0.1
 */