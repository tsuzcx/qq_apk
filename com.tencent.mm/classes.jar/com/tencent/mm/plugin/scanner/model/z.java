package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "", "()V", "catId", "", "getCatId", "()I", "setCatId", "(I)V", "centerX", "", "getCenterX", "()F", "setCenterX", "(F)V", "centerY", "getCenterY", "setCenterY", "imgUrl", "", "getImgUrl", "()Ljava/lang/String;", "setImgUrl", "(Ljava/lang/String;)V", "jumpKeyWord", "getJumpKeyWord", "setJumpKeyWord", "jumpType", "getJumpType", "setJumpType", "matchObj", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "getMatchObj", "()Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "setMatchObj", "(Lcom/tencent/mm/protocal/protobuf/GoodsObject;)V", "reqKey", "getReqKey", "setReqKey", "returnType", "getReturnType", "setReturnType", "scanId", "getScanId", "setScanId", "seqNum", "getSeqNum", "setSeqNum", "sessionId", "", "getSessionId", "()J", "setSessionId", "(J)V", "shouldShowResult", "", "getShouldShowResult", "()Z", "setShouldShowResult", "(Z)V", "source", "getSource", "setSource", "wxaAppid", "getWxaAppid", "setWxaAppid", "wxaPath", "getWxaPath", "setWxaPath", "convertFromResponse", "", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "Companion", "plugin-scan_release"})
public final class z
{
  public static final z.a CGq;
  public boolean CGj;
  String CGk;
  String CGl;
  GoodsObject CGm;
  public int CGn;
  public int CGo;
  private String CGp = "";
  public float centerX;
  public float centerY;
  public String dDL;
  public int jumpType;
  public long sessionId;
  public int source;
  String twt;
  
  static
  {
    AppMethodBeat.i(52214);
    CGq = new z.a((byte)0);
    AppMethodBeat.o(52214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.z
 * JD-Core Version:    0.7.0.1
 */