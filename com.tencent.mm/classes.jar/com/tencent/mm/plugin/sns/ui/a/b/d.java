package com.tencent.mm.plugin.sns.ui.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class d
  extends a
{
  public boolean dJM;
  public String userName;
  
  public d(String paramString, boolean paramBoolean)
  {
    super(new SnsInfo());
    AppMethodBeat.i(99846);
    this.userName = paramString;
    this.dJM = paramBoolean;
    hdm();
    AppMethodBeat.o(99846);
  }
  
  public final String JV(long paramLong)
  {
    return null;
  }
  
  public final String L(long paramLong, String paramString)
  {
    AppMethodBeat.i(179326);
    Log.d("MicroMsg.SnsUserPageVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(aj.faE().fbw()), paramString });
    Object localObject = r.Jc(aj.faO().b(paramLong, aj.faE().aPn(this.userName), this.userName, this.dJM));
    if (this.EvF.equals("")) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = aj.faS().aQr(this.userName).feM();
      if (((ami)localObject).Lvc != 0L) {
        break;
      }
      AppMethodBeat.o(179326);
      return paramString;
      paramString = (String)localObject;
      if (((String)localObject).compareTo(this.EvF) >= 0) {
        paramString = this.EvF;
      }
    }
    localObject = r.Jc(((ami)localObject).Lvc);
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
  
  public final Cursor fki()
  {
    AppMethodBeat.i(99847);
    init();
    g.aAi();
    Object localObject = (String)g.aAh().azQ().get(2, null);
    if (this.userName.equals(localObject)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.SnsUserPageVending", "prepareCursorAsynchronous");
      localObject = aj.faO().g(this.userName, bool, fkf());
      AppMethodBeat.o(99847);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.d
 * JD-Core Version:    0.7.0.1
 */