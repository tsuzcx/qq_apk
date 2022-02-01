package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "", "()V", "catId", "", "getCatId", "()I", "setCatId", "(I)V", "centerX", "", "getCenterX", "()F", "setCenterX", "(F)V", "centerY", "getCenterY", "setCenterY", "imgUrl", "", "getImgUrl", "()Ljava/lang/String;", "setImgUrl", "(Ljava/lang/String;)V", "jumpKeyWord", "getJumpKeyWord", "setJumpKeyWord", "jumpType", "getJumpType", "setJumpType", "matchObj", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "getMatchObj", "()Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "setMatchObj", "(Lcom/tencent/mm/protocal/protobuf/GoodsObject;)V", "reqKey", "getReqKey", "setReqKey", "returnType", "getReturnType", "setReturnType", "scanId", "getScanId", "setScanId", "seqNum", "getSeqNum", "setSeqNum", "sessionId", "", "getSessionId", "()J", "setSessionId", "(J)V", "shouldShowResult", "", "getShouldShowResult", "()Z", "setShouldShowResult", "(Z)V", "source", "getSource", "setSource", "wxaAppid", "getWxaAppid", "setWxaAppid", "wxaPath", "getWxaPath", "setWxaPath", "convertFromResponse", "", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
{
  public static final ae.a OSx;
  String ADt;
  String OSA;
  GoodsObject OSB;
  public int OSC;
  public int OSD;
  private String OSE = "";
  public boolean OSy;
  String OSz;
  public float centerX;
  public float centerY;
  public String hAT;
  public int jumpType;
  public long sessionId;
  public int source;
  
  static
  {
    AppMethodBeat.i(52214);
    OSx = new ae.a((byte)0);
    AppMethodBeat.o(52214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ae
 * JD-Core Version:    0.7.0.1
 */