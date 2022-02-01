package com.tencent.mm.plugin.sns.ui.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ap.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class d
  extends a
{
  public boolean fCB;
  public String userName;
  
  public d(String paramString, boolean paramBoolean)
  {
    super(new SnsInfo());
    AppMethodBeat.i(99846);
    this.userName = paramString;
    this.fCB = paramBoolean;
    iet();
    AppMethodBeat.o(99846);
  }
  
  public final String Rp(long paramLong)
  {
    return null;
  }
  
  public final String T(long paramLong, String paramString)
  {
    AppMethodBeat.i(179326);
    Log.d("MicroMsg.SnsUserPageVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(aj.fOy().fPp()), paramString });
    Object localObject = t.Qv(aj.fOI().a(paramLong, aj.fOy().baj(this.userName), this.userName, this.fCB));
    if (this.KJw.equals("")) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = aj.fOM().bbr(this.userName).fSG();
      if (((anj)localObject).SxC != 0L) {
        break;
      }
      AppMethodBeat.o(179326);
      return paramString;
      paramString = (String)localObject;
      if (((String)localObject).compareTo(this.KJw) >= 0) {
        paramString = this.KJw;
      }
    }
    localObject = t.Qv(((anj)localObject).SxC);
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
  
  public final Cursor fYr()
  {
    AppMethodBeat.i(99847);
    init();
    h.aHH();
    Object localObject = (String)h.aHG().aHp().b(2, null);
    if (this.userName.equals(localObject)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.SnsUserPageVending", "prepareCursorAsynchronous");
      localObject = aj.fOI().f(this.userName, bool, fYo());
      AppMethodBeat.o(99847);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.d
 * JD-Core Version:    0.7.0.1
 */