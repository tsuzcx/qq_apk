package com.tencent.mm.plugin.multitalk.b;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.protocal.protobuf.aaz;
import com.tencent.mm.protocal.protobuf.dxm;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

final class p$20$1
  implements Runnable
{
  p$20$1(p.20 param20, int paramInt1, int paramInt2, b paramb) {}
  
  @SuppressLint({"DefaultLocale"})
  public final void run()
  {
    AppMethodBeat.i(190598);
    if ((this.val$errType != 0) || (this.val$errCode != 0) || (this.hSn.hQE.hQJ == null))
    {
      ae.e("MicroMsg.Multitalk.ILinkService", "hy: getroomId fail, errType:" + this.val$errType + ",errCode:" + this.val$errCode);
      AppMethodBeat.o(190598);
      return;
    }
    final LinkedList localLinkedList1 = ((dxm)this.hSn.hQE.hQJ).IcK;
    LinkedList localLinkedList2 = new LinkedList();
    Iterator localIterator = localLinkedList1.iterator();
    while (localIterator.hasNext())
    {
      dxw localdxw = (dxw)localIterator.next();
      localLinkedList2.add(localdxw.IcF);
      ae.i("MicroMsg.Multitalk.ILinkService", "add new member username: %s, sdkname:%s", new Object[] { localdxw.username, localdxw.IcF });
    }
    p.n(this.woC.wnP, new l.a()
    {
      private static aaz bw(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(190595);
        aaz localaaz = new aaz();
        try
        {
          localaaz.parseFrom(paramAnonymousArrayOfByte);
          AppMethodBeat.o(190595);
          return localaaz;
        }
        catch (IOException paramAnonymousArrayOfByte)
        {
          ae.printErrStackTrace("MicroMsg.Multitalk.ILinkService", paramAnonymousArrayOfByte, "hy: unable to parse from data", new Object[0]);
          AppMethodBeat.o(190595);
        }
        return null;
      }
      
      public final boolean cbm()
      {
        return false;
      }
    });
    p.m(this.woC.wnP).a(17, p.Z(this.woC.wnP));
    p.m(this.woC.wnP).a(18, p.Z(this.woC.wnP));
    int i = p.L(this.woC.wnP);
    p.c(this.woC.wnP);
    m.b(localLinkedList2, i, p.x(this.woC.wnP));
    AppMethodBeat.o(190598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.p.20.1
 * JD-Core Version:    0.7.0.1
 */