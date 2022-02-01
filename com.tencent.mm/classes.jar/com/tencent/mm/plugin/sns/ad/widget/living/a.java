package com.tencent.mm.plugin.sns.ad.widget.living;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.a.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.bz;
import org.json.JSONObject;

public final class a
{
  public static bz[] q(SnsInfo paramSnsInfo)
  {
    bz localbz = null;
    AppMethodBeat.i(202407);
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null) || (paramSnsInfo.getAdXml().adLiveInfo == null))
    {
      AppMethodBeat.o(202407);
      return null;
    }
    g localg = paramSnsInfo.getAdXml().adLiveInfo;
    paramSnsInfo = localbz;
    if (localg.liveType == 0) {
      paramSnsInfo = new bz[1];
    }
    try
    {
      localbz = new bz();
      localbz.pTI = 2;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.putOpt("liveParams", localg.DrY);
      localbz.data = localJSONObject.toString();
      paramSnsInfo[0] = localbz;
    }
    catch (Throwable localThrowable)
    {
      label101:
      break label101;
    }
    AppMethodBeat.o(202407);
    return paramSnsInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.a
 * JD-Core Version:    0.7.0.1
 */