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
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;

public final class d
  extends a
{
  public boolean dfZ;
  public String userName;
  
  public d(String paramString, boolean paramBoolean)
  {
    super(new p());
    AppMethodBeat.i(99846);
    this.userName = paramString;
    this.dfZ = paramBoolean;
    fxa();
    AppMethodBeat.o(99846);
  }
  
  public final String A(long paramLong, String paramString)
  {
    AppMethodBeat.i(179326);
    ac.d("MicroMsg.SnsUserPageVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(af.dHH().dIv()), paramString });
    Object localObject = com.tencent.mm.plugin.sns.data.q.wX(af.dHR().b(paramLong, af.dHH().atV(this.userName), this.userName, this.dfZ));
    if (this.yEq.equals("")) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = af.dHV().auY(this.userName).dMm();
      if (((agu)localObject).EyT != 0L) {
        break;
      }
      AppMethodBeat.o(179326);
      return paramString;
      paramString = (String)localObject;
      if (((String)localObject).compareTo(this.yEq) >= 0) {
        paramString = this.yEq;
      }
    }
    localObject = com.tencent.mm.plugin.sns.data.q.wX(((agu)localObject).EyT);
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
  
  public final Cursor dRF()
  {
    AppMethodBeat.i(99847);
    init();
    g.agS();
    Object localObject = (String)g.agR().agA().get(2, null);
    if (this.userName.equals(localObject)) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.SnsUserPageVending", "prepareCursorAsynchronous");
      localObject = af.dHR().g(this.userName, bool, dRC());
      AppMethodBeat.o(99847);
      return localObject;
    }
  }
  
  public final String xU(long paramLong)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.d
 * JD-Core Version:    0.7.0.1
 */