package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/CameraScanCombineClientLogReporter;", "", "()V", "TAG", "", "reportAction", "", "action", "", "clientLogInfo", "Lcom/tencent/mm/plugin/scanner/model/CameraScanCombineClientLogReporter$ClientLogInfo;", "Action", "ClientLogInfo", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d ORk;
  
  static
  {
    AppMethodBeat.i(314391);
    ORk = new d();
    AppMethodBeat.o(314391);
  }
  
  public static final void UI(int paramInt)
  {
    AppMethodBeat.i(314377);
    a(paramInt, null);
    AppMethodBeat.o(314377);
  }
  
  public static final void a(int paramInt, a parama)
  {
    int n = 0;
    AppMethodBeat.i(314385);
    h localh = h.OAn;
    int i;
    int j;
    label25:
    int k;
    label32:
    int m;
    if (parama == null)
    {
      i = 0;
      if (parama != null) {
        break label115;
      }
      j = 0;
      if (parama != null) {
        break label123;
      }
      k = 0;
      if (parama != null) {
        break label132;
      }
      m = 0;
      label39:
      if (parama != null) {
        break label141;
      }
    }
    for (;;)
    {
      localh.b(24657, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
      AppMethodBeat.o(314385);
      return;
      i = parama.OPw;
      break;
      label115:
      j = parama.ORl;
      break label25;
      label123:
      k = parama.ORm;
      break label32;
      label132:
      m = parama.ORn;
      break label39;
      label141:
      n = parama.ORo;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/CameraScanCombineClientLogReporter$ClientLogInfo;", "", "modelVersion", "", "(I)V", "imageEncodeSize", "getImageEncodeSize", "()I", "setImageEncodeSize", "imageEncodeType", "getImageEncodeType$annotations", "()V", "getImageEncodeType", "setImageEncodeType", "itemCategory", "getItemCategory", "setItemCategory", "itemStatus", "getItemStatus", "setItemStatus", "getModelVersion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final int OPw = 0;
    public int ORl;
    public int ORm;
    public int ORn;
    public int ORo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.d
 * JD-Core Version:    0.7.0.1
 */