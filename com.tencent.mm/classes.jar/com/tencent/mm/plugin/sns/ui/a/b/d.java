package com.tencent.mm.plugin.sns.ui.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;

public final class d
  extends a
{
  public boolean drv;
  public String userName;
  
  public d(String paramString, boolean paramBoolean)
  {
    super(new p());
    AppMethodBeat.i(99846);
    this.userName = paramString;
    this.drv = paramBoolean;
    fNN();
    AppMethodBeat.o(99846);
  }
  
  public final String As(long paramLong)
  {
    return null;
  }
  
  public final String E(long paramLong, String paramString)
  {
    AppMethodBeat.i(179326);
    ad.d("MicroMsg.SnsUserPageVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(ag.dTU().dUI()), paramString });
    Object localObject = com.tencent.mm.plugin.sns.data.q.zx(ag.dUe().b(paramLong, ag.dTU().aza(this.userName), this.userName, this.drv));
    if (this.zVL.equals("")) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = ag.dUi().aAf(this.userName).dYC();
      if (((ajk)localObject).GgF != 0L) {
        break;
      }
      AppMethodBeat.o(179326);
      return paramString;
      paramString = (String)localObject;
      if (((String)localObject).compareTo(this.zVL) >= 0) {
        paramString = this.zVL;
      }
    }
    localObject = com.tencent.mm.plugin.sns.data.q.zx(((ajk)localObject).GgF);
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
  
  public final Cursor edZ()
  {
    AppMethodBeat.i(99847);
    init();
    g.ajD();
    Object localObject = (String)g.ajC().ajl().get(2, null);
    if (this.userName.equals(localObject)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.SnsUserPageVending", "prepareCursorAsynchronous");
      localObject = ag.dUe().g(this.userName, bool, edW());
      AppMethodBeat.o(99847);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.d
 * JD-Core Version:    0.7.0.1
 */