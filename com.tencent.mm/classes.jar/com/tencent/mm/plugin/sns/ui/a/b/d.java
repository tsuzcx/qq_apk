package com.tencent.mm.plugin.sns.ui.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;

public final class d
  extends a
{
  public boolean hHq;
  public String userName;
  
  public d(String paramString, boolean paramBoolean)
  {
    super(new SnsInfo());
    AppMethodBeat.i(99846);
    this.userName = paramString;
    this.hHq = paramBoolean;
    jJA();
    AppMethodBeat.o(99846);
  }
  
  public final String ai(long paramLong, String paramString)
  {
    AppMethodBeat.i(179326);
    Log.d("MicroMsg.SnsUserPageVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(al.hgr().hhi()), paramString });
    Object localObject = t.uB(al.hgB().a(paramLong, al.hgr().aYB(this.userName), this.userName, this.hHq));
    if (this.RiY.equals("")) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = al.hgF().aZW(this.userName).hkS();
      if (((arc)localObject).Zyu != 0L) {
        break;
      }
      AppMethodBeat.o(179326);
      return paramString;
      paramString = (String)localObject;
      if (((String)localObject).compareTo(this.RiY) >= 0) {
        paramString = this.RiY;
      }
    }
    localObject = t.uB(((arc)localObject).Zyu);
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
  
  public final Cursor hqP()
  {
    AppMethodBeat.i(99847);
    init();
    h.baF();
    Object localObject = (String)h.baE().ban().d(2, null);
    if (this.userName.equals(localObject)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.SnsUserPageVending", "prepareCursorAsynchronous");
      localObject = al.hgB().j(this.userName, bool, hqM());
      AppMethodBeat.o(99847);
      return localObject;
    }
  }
  
  public final String vy(long paramLong)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.d
 * JD-Core Version:    0.7.0.1
 */