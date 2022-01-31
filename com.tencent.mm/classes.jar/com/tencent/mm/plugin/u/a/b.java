package com.tencent.mm.plugin.u.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
  implements a.a
{
  public Map<String, List<b.a>> bZ;
  public List<String> fGO;
  public ak iMP;
  public Map<String, Set<Integer>> pPm;
  String pPn;
  a pPo;
  
  public b()
  {
    AppMethodBeat.i(80753);
    this.iMP = new ak(Looper.getMainLooper());
    this.fGO = new LinkedList();
    this.bZ = new HashMap();
    this.pPm = new HashMap();
    AppMethodBeat.o(80753);
  }
  
  public final int a(d paramd)
  {
    AppMethodBeat.i(80756);
    this.iMP.post(new b.3(this, paramd));
    AppMethodBeat.o(80756);
    return 0;
  }
  
  public final void a(String paramString, b.a parama, Set<Integer> paramSet)
  {
    AppMethodBeat.i(80754);
    ab.i("MicroMsg.FileScanQueueService", "startDecodeBlockLoop, fileUri: %s, callback: %x", new Object[] { paramString, Integer.valueOf(parama.hashCode()) });
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.FileScanQueueService", "start failed, uri is null or nil");
      AppMethodBeat.o(80754);
      return;
    }
    this.iMP.post(new b.1(this, paramString, parama, paramSet));
    AppMethodBeat.o(80754);
  }
  
  final void ceH()
  {
    AppMethodBeat.i(80755);
    if (this.pPo != null)
    {
      ab.d("MicroMsg.FileScanQueueService", "it is scanning");
      AppMethodBeat.o(80755);
      return;
    }
    if (this.bZ.isEmpty())
    {
      ab.d("MicroMsg.FileScanQueueService", "queue is empty");
      AppMethodBeat.o(80755);
      return;
    }
    this.pPn = ((String)this.fGO.get(0));
    this.fGO.remove(0);
    this.pPo = new a();
    this.pPo.cEw = ((Set)this.pPm.get(this.pPn));
    a locala = this.pPo;
    String str = this.pPn;
    ab.i("MicroMsg.scanner.DecodeFile", "start decode file: ".concat(String.valueOf(str)));
    locala.pPj = this;
    al.d(new a.1(locala, str));
    AppMethodBeat.o(80755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.b
 * JD-Core Version:    0.7.0.1
 */