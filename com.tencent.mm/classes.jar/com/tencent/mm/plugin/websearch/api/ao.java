package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.j;
import com.tencent.xweb.util.d;
import java.util.Iterator;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ao
{
  private String uKk = "";
  private int uKl = 1;
  private long uKm;
  private String uKn;
  String uKo;
  String uKp;
  
  public ao(String paramString1, String paramString2, String paramString3)
  {
    this.uKn = paramString1;
    this.uKo = paramString2;
    this.uKp = paramString3;
  }
  
  private static String agk()
  {
    AppMethodBeat.i(124246);
    String str = com.tencent.mm.loader.j.b.eQw.replace("/data/user/0", "/data/data");
    AppMethodBeat.o(124246);
    return str;
  }
  
  private com.tencent.mm.vfs.b cZN()
  {
    AppMethodBeat.i(124245);
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(aLw(), "config.conf");
    AppMethodBeat.o(124245);
    return localb;
  }
  
  public final String aLw()
  {
    AppMethodBeat.i(124247);
    Object localObject = new com.tencent.mm.vfs.b(agk(), this.uKn);
    if (!((com.tencent.mm.vfs.b)localObject).exists()) {
      ((com.tencent.mm.vfs.b)localObject).mkdirs();
    }
    localObject = j.p(((com.tencent.mm.vfs.b)localObject).dQJ());
    AppMethodBeat.o(124247);
    return localObject;
  }
  
  public final int agn()
  {
    AppMethodBeat.i(124242);
    if ((this.uKl <= 1) || (cZN().lastModified() > this.uKm)) {
      cZM();
    }
    int i = this.uKl;
    AppMethodBeat.o(124242);
    return i;
  }
  
  public final String cZL()
  {
    AppMethodBeat.i(124243);
    if ((bo.isNullOrNil(this.uKk)) || (cZN().lastModified() > this.uKm)) {
      cZM();
    }
    String str = this.uKk;
    AppMethodBeat.o(124243);
    return str;
  }
  
  public final void cZM()
  {
    AppMethodBeat.i(124244);
    Properties localProperties = aa.l(cZN());
    this.uKl = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    this.uKk = localProperties.getProperty("buildjsmd5", "");
    this.uKm = System.currentTimeMillis();
    AppMethodBeat.o(124244);
  }
  
  public final String cZO()
  {
    AppMethodBeat.i(124248);
    String str = j.p(new com.tencent.mm.vfs.b(aLw(), this.uKo).dQJ());
    AppMethodBeat.o(124248);
    return str;
  }
  
  public final boolean cZP()
  {
    AppMethodBeat.i(124249);
    Object localObject = aa.l(cZN()).getProperty("jsmd5");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AppMethodBeat.o(124249);
      return true;
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = d.getMD5(aLw() + "/dist/" + str1);
          String str3 = localJSONObject.getString(str1);
          if ((TextUtils.isEmpty(str2)) || (!str2.equals(str3)))
          {
            ab.w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, fileName %s, fileMd5 %s, expect md5 %s", new Object[] { str1, str2, str3 });
            AppMethodBeat.o(124249);
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (JSONException localJSONException)
    {
      ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localJSONException, "", new Object[0]);
      AppMethodBeat.o(124249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ao
 * JD-Core Version:    0.7.0.1
 */