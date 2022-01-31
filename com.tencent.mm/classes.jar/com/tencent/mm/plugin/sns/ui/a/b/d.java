package com.tencent.mm.plugin.sns.ui.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

public final class d
  extends a
{
  public boolean ctJ;
  public String userName;
  
  public d(String paramString, boolean paramBoolean)
  {
    super(new n());
    AppMethodBeat.i(39956);
    this.userName = paramString;
    this.ctJ = paramBoolean;
    dQd();
    AppMethodBeat.o(39956);
  }
  
  public final Cursor cwQ()
  {
    AppMethodBeat.i(39957);
    init();
    g.RM();
    Object localObject = (String)g.RL().Ru().get(2, null);
    if (this.userName.equals(localObject)) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.SnsUserPageVending", "prepareCursorAsynchronous");
      localObject = ag.cpf().e(this.userName, bool, cwN());
      AppMethodBeat.o(39957);
      return localObject;
    }
  }
  
  public final String w(long paramLong, String paramString)
  {
    AppMethodBeat.i(39958);
    ab.d("MicroMsg.SnsUserPageVending", "updateLitmitSeq %s %s", new Object[] { Integer.valueOf(ag.coV().cpD()), paramString });
    Object localObject = i.lr(ag.cpf().a(paramLong, ag.coV().aaB(this.userName), this.userName, this.ctJ));
    if (this.rKW.equals("")) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = ag.cpj().abz(this.userName).csy();
      if (((abx)localObject).wSq != 0L) {
        break;
      }
      AppMethodBeat.o(39958);
      return paramString;
      paramString = (String)localObject;
      if (((String)localObject).compareTo(this.rKW) >= 0) {
        paramString = this.rKW;
      }
    }
    localObject = i.lr(((abx)localObject).wSq);
    if (paramString.equals(""))
    {
      AppMethodBeat.o(39958);
      return localObject;
    }
    if (((String)localObject).compareTo(paramString) > 0)
    {
      AppMethodBeat.o(39958);
      return localObject;
    }
    AppMethodBeat.o(39958);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.d
 * JD-Core Version:    0.7.0.1
 */