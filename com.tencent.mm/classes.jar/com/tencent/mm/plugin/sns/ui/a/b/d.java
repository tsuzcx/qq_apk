package com.tencent.mm.plugin.sns.ui.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;

public final class d
  extends a
{
  public boolean diE;
  public String userName;
  
  public d(String paramString, boolean paramBoolean)
  {
    super(new p());
    AppMethodBeat.i(99846);
    this.userName = paramString;
    this.diE = paramBoolean;
    fgY();
    AppMethodBeat.o(99846);
  }
  
  public final String C(long paramLong, String paramString)
  {
    AppMethodBeat.i(179326);
    ad.d("MicroMsg.SnsUserPageVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(af.dtk().dtX()), paramString });
    Object localObject = com.tencent.mm.plugin.sns.data.q.su(af.dtu().a(paramLong, af.dtk().aoJ(this.userName), this.userName, this.diE));
    if (this.xrA.equals("")) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = af.dty().apP(this.userName).dxP();
      if (((afv)localObject).DfN != 0L) {
        break;
      }
      AppMethodBeat.o(179326);
      return paramString;
      paramString = (String)localObject;
      if (((String)localObject).compareTo(this.xrA) >= 0) {
        paramString = this.xrA;
      }
    }
    localObject = com.tencent.mm.plugin.sns.data.q.su(((afv)localObject).DfN);
    if (paramString.equals(""))
    {
      AppMethodBeat.o(179326);
      return localObject;
    }
    if (((String)localObject).compareTo(paramString) > 0)
    {
      AppMethodBeat.o(179326);
      return localObject;
    }
    AppMethodBeat.o(179326);
    return paramString;
  }
  
  public final Cursor dDi()
  {
    AppMethodBeat.i(99847);
    init();
    g.afC();
    Object localObject = (String)g.afB().afk().get(2, null);
    if (this.userName.equals(localObject)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.SnsUserPageVending", "prepareCursorAsynchronous");
      localObject = af.dtu().g(this.userName, bool, dDf());
      AppMethodBeat.o(99847);
      return localObject;
    }
  }
  
  public final String tr(long paramLong)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.d
 * JD-Core Version:    0.7.0.1
 */