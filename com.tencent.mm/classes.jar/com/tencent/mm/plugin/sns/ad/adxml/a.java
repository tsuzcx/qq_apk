package com.tencent.mm.plugin.sns.ad.adxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class a
{
  public long PKZ;
  public String PLa;
  public String PLb;
  public String PLc;
  public String PLd;
  public String PLe;
  public String PLf;
  public String PLg;
  public String PLh;
  public long PLi;
  public String PLj;
  public String content;
  public String nickname;
  public String nnS;
  public String title;
  
  public static a u(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309836);
    if (paramMap != null) {}
    try
    {
      boolean bool = paramMap.containsKey(paramString);
      if (!bool)
      {
        AppMethodBeat.o(309836);
        return null;
      }
      a locala = new a();
      locala.PKZ = Util.safeParseLong((String)paramMap.get(paramString + ".appointmentId"));
      locala.PLd = Util.nullAsNil((String)paramMap.get(paramString + ".btnTitleAfterAppointment"));
      locala.nickname = Util.nullAsNil((String)paramMap.get(paramString + ".nickname"));
      locala.nnS = Util.nullAsNil((String)paramMap.get(paramString + ".headImageUrl"));
      locala.title = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
      locala.content = Util.nullAsNil((String)paramMap.get(paramString + ".content"));
      locala.PLa = Util.nullAsNil((String)paramMap.get(paramString + ".extraContent"));
      locala.PLb = Util.nullAsNil((String)paramMap.get(paramString + ".submitBtnTitle"));
      locala.PLc = Util.nullAsNil((String)paramMap.get(paramString + ".cancelBtnTitle"));
      locala.PLe = Util.nullAsNil((String)paramMap.get(paramString + ".submitSucToast"));
      locala.PLf = Util.nullAsNil((String)paramMap.get(paramString + ".submitFailedToast"));
      locala.PLg = Util.nullAsNil((String)paramMap.get(paramString + ".cancelSucToast"));
      locala.PLh = Util.nullAsNil((String)paramMap.get(paramString + ".cancelFailedToast"));
      locala.PLi = Util.safeParseLong((String)paramMap.get(paramString + ".expiredTime"));
      locala.PLj = Util.nullAsNil((String)paramMap.get(paramString + ".expiredBtnTitle"));
      AppMethodBeat.o(309836);
      return locala;
    }
    finally
    {
      Log.e("AdAppointmentInfo", "parse the update info failed!!");
      AppMethodBeat.o(309836);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.a
 * JD-Core Version:    0.7.0.1
 */