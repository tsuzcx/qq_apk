package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.e;
import com.tencent.mm.vending.j.c;
import java.util.LinkedList;

public final class d
{
  public final e<bws> bZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(151552);
    paramString = new f().L(new Object[] { Integer.valueOf(paramInt), paramString }).b(new a() {});
    AppMethodBeat.o(151552);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.d
 * JD-Core Version:    0.7.0.1
 */