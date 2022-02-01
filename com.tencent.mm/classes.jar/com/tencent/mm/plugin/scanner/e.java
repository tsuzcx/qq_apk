package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.cw.f;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.j.c;
import java.util.LinkedList;

public final class e
{
  public final com.tencent.mm.vending.g.e<cei> bX(int paramInt, String paramString)
  {
    AppMethodBeat.i(151552);
    paramString = new f().M(new Object[] { Integer.valueOf(paramInt), paramString }).b(new a() {});
    AppMethodBeat.o(151552);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e
 * JD-Core Version:    0.7.0.1
 */