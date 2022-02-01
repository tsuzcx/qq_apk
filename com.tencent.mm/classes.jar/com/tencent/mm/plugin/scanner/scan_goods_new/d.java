package com.tencent.mm.plugin.scanner.scan_goods_new;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageTrackIdManager;", "", "()V", "localTrackId", "", "trackIdSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "addTrackId", "", "trackId", "generateLocalTrackId", "release", "trackIdExist", "", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a OVO;
  int OVP;
  HashSet<Integer> OVQ;
  
  static
  {
    AppMethodBeat.i(313849);
    OVO = new a((byte)0);
    AppMethodBeat.o(313849);
  }
  
  public d()
  {
    AppMethodBeat.i(313841);
    this.OVQ = new HashSet();
    AppMethodBeat.o(313841);
  }
  
  public final void aij(int paramInt)
  {
    AppMethodBeat.i(313855);
    synchronized (this.OVQ)
    {
      this.OVQ.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(313855);
      return;
    }
  }
  
  public final boolean aik(int paramInt)
  {
    AppMethodBeat.i(313857);
    synchronized (this.OVQ)
    {
      boolean bool = this.OVQ.contains(Integer.valueOf(paramInt));
      AppMethodBeat.o(313857);
      return bool;
    }
  }
  
  public final int gRM()
  {
    AppMethodBeat.i(313862);
    synchronized (Integer.valueOf(this.OVP))
    {
      this.OVP -= 1;
      int i = this.OVP;
      AppMethodBeat.o(313862);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageTrackIdManager$Companion;", "", "()V", "TAG", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.d
 * JD-Core Version:    0.7.0.1
 */