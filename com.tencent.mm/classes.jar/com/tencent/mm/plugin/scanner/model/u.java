package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "", "()V", "centerX", "", "getCenterX", "()F", "setCenterX", "(F)V", "centerY", "getCenterY", "setCenterY", "imgUrl", "", "getImgUrl", "()Ljava/lang/String;", "setImgUrl", "(Ljava/lang/String;)V", "jumpType", "", "getJumpType", "()I", "setJumpType", "(I)V", "matchObj", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "getMatchObj", "()Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "setMatchObj", "(Lcom/tencent/mm/protocal/protobuf/GoodsObject;)V", "reqKey", "getReqKey", "setReqKey", "scanId", "getScanId", "setScanId", "sessionId", "", "getSessionId", "()J", "setSessionId", "(J)V", "shouldShowResult", "", "getShouldShowResult", "()Z", "setShouldShowResult", "(Z)V", "source", "getSource", "setSource", "wxaAppid", "getWxaAppid", "setWxaAppid", "wxaPath", "getWxaPath", "setWxaPath", "convertFromResponse", "", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "Companion", "plugin-scan_release"})
public final class u
{
  public static final u.a vPi;
  public float centerX;
  public float centerY;
  public String dcE;
  public int dep;
  int jumpType;
  String qpB;
  public long sessionId;
  public boolean vPd;
  String vPe;
  String vPf;
  GoodsObject vPg;
  public int vPh;
  
  static
  {
    AppMethodBeat.i(52214);
    vPi = new u.a((byte)0);
    AppMethodBeat.o(52214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.u
 * JD-Core Version:    0.7.0.1
 */