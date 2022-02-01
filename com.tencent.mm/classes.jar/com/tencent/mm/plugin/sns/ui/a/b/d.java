package com.tencent.mm.plugin.sns.ui.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ao.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

public final class d
  extends a
{
  public boolean dsB;
  public String userName;
  
  public d(String paramString, boolean paramBoolean)
  {
    super(new p());
    AppMethodBeat.i(99846);
    this.userName = paramString;
    this.dsB = paramBoolean;
    fSi();
    AppMethodBeat.o(99846);
  }
  
  public final String AQ(long paramLong)
  {
    return null;
  }
  
  public final String F(long paramLong, String paramString)
  {
    AppMethodBeat.i(179326);
    ae.d("MicroMsg.SnsUserPageVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(ah.dXu().dYi()), paramString });
    Object localObject = r.zW(ah.dXE().b(paramLong, ah.dXu().aAr(this.userName), this.userName, this.dsB));
    if (this.AmT.equals("")) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = ah.dXI().aBw(this.userName).ecg();
      if (((aju)localObject).Gzo != 0L) {
        break;
      }
      AppMethodBeat.o(179326);
      return paramString;
      paramString = (String)localObject;
      if (((String)localObject).compareTo(this.AmT) >= 0) {
        paramString = this.AmT;
      }
    }
    localObject = r.zW(((aju)localObject).Gzo);
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
  
  public final Cursor ehG()
  {
    AppMethodBeat.i(99847);
    init();
    g.ajS();
    Object localObject = (String)g.ajR().ajA().get(2, null);
    if (this.userName.equals(localObject)) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.SnsUserPageVending", "prepareCursorAsynchronous");
      localObject = ah.dXE().g(this.userName, bool, ehD());
      AppMethodBeat.o(99847);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.d
 * JD-Core Version:    0.7.0.1
 */