package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.j;
import com.tencent.xweb.util.c;
import java.util.Iterator;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ap
{
  private String qUZ = "";
  private int qVa = 1;
  private long qVb;
  private String qVc;
  String qVd;
  String qVe;
  
  public ap(String paramString1, String paramString2, String paramString3)
  {
    this.qVc = paramString1;
    this.qVd = paramString2;
    this.qVe = paramString3;
  }
  
  private com.tencent.mm.vfs.b bZS()
  {
    return new com.tencent.mm.vfs.b(aoA(), "config.conf");
  }
  
  public final int NA()
  {
    if ((this.qVa <= 1) || (bZS().lastModified() > this.qVb)) {
      bZR();
    }
    return this.qVa;
  }
  
  public final String aoA()
  {
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(com.tencent.mm.loader.a.b.dOQ.replace("/data/user/0", "/data/data"), this.qVc);
    if (!localb.exists()) {
      localb.mkdirs();
    }
    return j.n(localb.cLr());
  }
  
  public final String bZQ()
  {
    if ((bk.bl(this.qUZ)) || (bZS().lastModified() > this.qVb)) {
      bZR();
    }
    return this.qUZ;
  }
  
  public final void bZR()
  {
    Properties localProperties = aa.j(bZS());
    this.qVa = Integer.valueOf(localProperties.getProperty("version", "1")).intValue();
    this.qUZ = localProperties.getProperty("buildjsmd5", "");
    this.qVb = System.currentTimeMillis();
  }
  
  public final String bZT()
  {
    return j.n(new com.tencent.mm.vfs.b(aoA(), this.qVd).cLr());
  }
  
  public final boolean bZU()
  {
    Object localObject = aa.j(bZS()).getProperty("jsmd5");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
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
          String str2 = c.bQ(aoA() + "/dist/" + str1);
          String str3 = localJSONObject.getString(str1);
          if ((TextUtils.isEmpty(str2)) || (!str2.equals(str3)))
          {
            y.w("MicroMsg.WebSearch.WebSearchTemplate", "isMd5Valid fail, fileName %s, fileMd5 %s, expect md5 %s", new Object[] { str1, str2, str3 });
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (JSONException localJSONException)
    {
      y.printErrStackTrace("MicroMsg.WebSearch.WebSearchTemplate", localJSONException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ap
 * JD-Core Version:    0.7.0.1
 */