package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.protocal.protobuf.fuv;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.ma;
import com.tencent.mm.protocal.protobuf.mb;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/report/net/NetSceneBatchUploadUserDataList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BatchUploadUserDataListResp;", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/UserDataListItem;", "(Ljava/util/LinkedList;)V", "Companion", "plugin-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.am.b<mb>
{
  public static final a Ozu;
  
  static
  {
    AppMethodBeat.i(261675);
    Ozu = new a((byte)0);
    AppMethodBeat.o(261675);
  }
  
  public d(LinkedList<fuv> paramLinkedList)
  {
    AppMethodBeat.i(261673);
    c.a locala = new c.a();
    ma localma = new ma();
    localma.timestamp = cn.getSyncServerTimeSecond();
    lz locallz = new lz();
    locallz.user_data_list = paramLinkedList;
    localma.YNs = new com.tencent.mm.bx.b(locallz.toByteArray());
    locala.otE = ((a)localma);
    locala.otF = ((a)new mb());
    locala.uri = "/cgi-bin/micromsg-bin/batchuploaduserdatalist";
    locala.funcId = 7181;
    c(locala.bEF());
    AppMethodBeat.o(261673);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/report/net/NetSceneBatchUploadUserDataList$Companion;", "", "()V", "TAG", "", "plugin-report_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.b.d
 * JD-Core Version:    0.7.0.1
 */