package com.tencent.mm.plugin.sns.ad.widget.living;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.i;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.ch;
import org.json.JSONObject;

public final class a
{
  public static ch[] s(SnsInfo paramSnsInfo)
  {
    ch localch = null;
    AppMethodBeat.i(310371);
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null) || (paramSnsInfo.getAdXml().adLiveInfo == null))
    {
      AppMethodBeat.o(310371);
      return null;
    }
    i locali = paramSnsInfo.getAdXml().adLiveInfo;
    paramSnsInfo = localch;
    if (locali.liveType == 0) {
      paramSnsInfo = new ch[1];
    }
    try
    {
      localch = new ch();
      localch.wuj = 2;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.putOpt("liveParams", locali.PML);
      localch.data = localJSONObject.toString();
      paramSnsInfo[0] = localch;
    }
    finally
    {
      label101:
      break label101;
    }
    AppMethodBeat.o(310371);
    return paramSnsInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.a
 * JD-Core Version:    0.7.0.1
 */