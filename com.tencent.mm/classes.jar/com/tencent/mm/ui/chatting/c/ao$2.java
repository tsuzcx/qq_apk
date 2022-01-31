package com.tencent.mm.ui.chatting.c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;
import java.util.List;

final class ao$2
  implements Runnable
{
  ao$2(ao paramao, int paramInt, bi parambi) {}
  
  public final void run()
  {
    AppMethodBeat.i(31784);
    Object localObject = this.zIW.dJp();
    if (localObject != null)
    {
      if (ao.c(this.zIW)) {
        ao.b(this.zIW, 4);
      }
      this.zIW.a((bi)((Pair)localObject).first, false, ((Integer)((Pair)localObject).second).intValue(), 0);
      AppMethodBeat.o(31784);
      return;
    }
    if (this.gxr != -1)
    {
      localObject = ((h)this.zIW.caz.ay(h.class)).Pz(this.gxr + 1);
      if ((localObject != null) && (((bi)localObject).dvW()) && (((dd)localObject).field_isSend == 0) && (ao.d(this.zIW)))
      {
        ao.e(this.zIW);
        ao.b(this.zIW, 2);
        AppMethodBeat.o(31784);
        return;
      }
      if ((localObject != null) && (((bi)localObject).dvW()) && (((dd)localObject).field_isSend == 0) && (!s.K((bi)localObject)))
      {
        if (!ao.c(this.zIW)) {
          ao.f(this.zIW).add(Long.valueOf(this.zIX.field_msgId));
        }
        ao.g(this.zIW);
        ao.f(this.zIW).add(Long.valueOf(((dd)localObject).field_msgId));
        s.M((bi)localObject);
        this.zIW.a((bi)localObject, false, this.gxr + 1, 0);
        AppMethodBeat.o(31784);
        return;
      }
      ao.b(this.zIW, 0);
    }
    AppMethodBeat.o(31784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ao.2
 * JD-Core Version:    0.7.0.1
 */