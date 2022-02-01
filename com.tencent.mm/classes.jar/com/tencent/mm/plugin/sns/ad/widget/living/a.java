package com.tencent.mm.plugin.sns.ad.widget.living;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.bx;
import org.json.JSONObject;

public final class a
{
  public static bx[] q(SnsInfo paramSnsInfo)
  {
    bx localbx = null;
    AppMethodBeat.i(230174);
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null) || (paramSnsInfo.getAdXml().adLiveInfo == null))
    {
      AppMethodBeat.o(230174);
      return null;
    }
    g localg = paramSnsInfo.getAdXml().adLiveInfo;
    paramSnsInfo = localbx;
    if (localg.liveType == 0) {
      paramSnsInfo = new bx[1];
    }
    try
    {
      localbx = new bx();
      localbx.tpK = 2;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.putOpt("liveParams", localg.Jyr);
      localbx.data = localJSONObject.toString();
      paramSnsInfo[0] = localbx;
    }
    catch (Throwable localThrowable)
    {
      label101:
      break label101;
    }
    AppMethodBeat.o(230174);
    return paramSnsInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.a
 * JD-Core Version:    0.7.0.1
 */