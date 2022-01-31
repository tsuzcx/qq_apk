package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.mm.h.c.dm;
import com.tencent.mm.protocal.c.jd;
import com.tencent.mm.protocal.c.je;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends dm
{
  public static c.a dUa;
  private List<b> kzj;
  private List<e> mZM;
  private List<a> nao;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.ujN.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "username";
    locala.columns[1] = "originalArticleCount";
    locala.ujN.put("originalArticleCount", "INTEGER default '1' ");
    localStringBuilder.append(" originalArticleCount INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "friendSubscribeCount";
    locala.ujN.put("friendSubscribeCount", "INTEGER default '1' ");
    localStringBuilder.append(" friendSubscribeCount INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "allArticleWording";
    locala.ujN.put("allArticleWording", "TEXT");
    localStringBuilder.append(" allArticleWording TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "historyArticlesUrl";
    locala.ujN.put("historyArticlesUrl", "TEXT");
    localStringBuilder.append(" historyArticlesUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "userRole";
    locala.ujN.put("userRole", "INTEGER default '1' ");
    localStringBuilder.append(" userRole INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "banReason";
    locala.ujN.put("banReason", "TEXT");
    localStringBuilder.append(" banReason TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "showRecommendArticle";
    locala.ujN.put("showRecommendArticle", "INTEGER default '0' ");
    localStringBuilder.append(" showRecommendArticle INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "showService";
    locala.ujN.put("showService", "INTEGER default '0' ");
    localStringBuilder.append(" showService INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "messageListStr";
    locala.ujN.put("messageListStr", "TEXT");
    localStringBuilder.append(" messageListStr TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "serviceInfoListStr";
    locala.ujN.put("serviceInfoListStr", "TEXT");
    localStringBuilder.append(" serviceInfoListStr TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "bizAccountListStr";
    locala.ujN.put("bizAccountListStr", "TEXT");
    localStringBuilder.append(" bizAccountListStr TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "cacheTime";
    locala.ujN.put("cacheTime", "LONG default '0' ");
    localStringBuilder.append(" cacheTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "decryptUserName";
    locala.ujN.put("decryptUserName", "TEXT default '' ");
    localStringBuilder.append(" decryptUserName TEXT default '' ");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    dUa = locala;
  }
  
  private static List<e> KY(String paramString)
  {
    localArrayList = new ArrayList();
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return localArrayList;
      try
      {
        paramString = new JSONArray(new JSONObject(paramString).optString("button_list"));
        int i = 0;
        while (i < paramString.length())
        {
          e locale = e.af(paramString.getJSONObject(i));
          if (locale != null) {
            localArrayList.add(locale);
          }
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        y.b("MicroMsg.ProfileInfo", "", new Object[] { paramString });
      }
    }
  }
  
  private static List<a> KZ(String paramString)
  {
    localArrayList = new ArrayList();
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return localArrayList;
      try
      {
        paramString = new JSONArray(new JSONObject(paramString).optString("BizAccount"));
        int i = 0;
        while (i < paramString.length())
        {
          a locala = a.ad(paramString.getJSONObject(i));
          if (locala != null) {
            localArrayList.add(locala);
          }
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        y.b("MicroMsg.ProfileInfo", "", new Object[] { paramString });
      }
    }
  }
  
  private static List<b> La(String paramString)
  {
    localArrayList = new ArrayList();
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return localArrayList;
      try
      {
        paramString = new JSONArray(new JSONObject(paramString).optString("ArticleInfo"));
        int i = 0;
        while (i < paramString.length())
        {
          b localb = b.ae(paramString.getJSONObject(i));
          if (localb != null) {
            localArrayList.add(localb);
          }
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        y.b("MicroMsg.ProfileInfo", "", new Object[] { paramString });
      }
    }
  }
  
  public static d a(String paramString, jd paramjd)
  {
    d locald = new d();
    locald.field_username = paramString;
    paramString = paramjd.sAP.iterator();
    while (paramString.hasNext())
    {
      paramjd = (je)paramString.next();
      if (paramjd.sCH.equals("OriginalArticleCount"))
      {
        locald.field_originalArticleCount = bk.getInt(paramjd.nFs, -1);
      }
      else if (paramjd.sCH.equals("FriendSubscribeCount"))
      {
        locald.field_friendSubscribeCount = bk.getInt(paramjd.nFs, -1);
      }
      else if (paramjd.sCH.equals("AllArticleWording"))
      {
        locald.field_allArticleWording = paramjd.nFs;
      }
      else if (paramjd.sCH.equals("HistoryArticlesUrl"))
      {
        locald.field_historyArticlesUrl = paramjd.nFs;
      }
      else if (paramjd.sCH.equals("ArticleList"))
      {
        locald.field_messageListStr = paramjd.nFs;
        locald.kzj = La(locald.field_messageListStr);
      }
      else if (paramjd.sCH.equals("BizAccountList"))
      {
        locald.field_bizAccountListStr = paramjd.nFs;
        locald.nao = KZ(locald.field_bizAccountListStr);
      }
      else if (paramjd.sCH.equals("MenuInfo"))
      {
        locald.field_serviceInfoListStr = paramjd.nFs;
        locald.mZM = KY(locald.field_serviceInfoListStr);
      }
      else if (paramjd.sCH.equals("UserRole"))
      {
        locald.field_userRole = bk.getInt(paramjd.nFs, 0);
      }
      else if (paramjd.sCH.equals("BanReason"))
      {
        locald.field_banReason = paramjd.nFs;
      }
      else if (paramjd.sCH.equals("ShowRecommendArticle"))
      {
        locald.field_showRecommendArticle = bk.getInt(paramjd.nFs, 0);
      }
      else if (paramjd.sCH.equals("ShowMenuService"))
      {
        locald.field_showService = bk.getInt(paramjd.nFs, 0);
      }
      else if (paramjd.sCH.equals("UserName"))
      {
        locald.field_decryptUserName = paramjd.nFs;
      }
    }
    locald.field_cacheTime = System.currentTimeMillis();
    return locald;
  }
  
  public final List<b> bsV()
  {
    if (this.kzj == null) {
      this.kzj = La(this.field_messageListStr);
    }
    return this.kzj;
  }
  
  public final List<e> bsW()
  {
    if (this.mZM == null) {
      this.mZM = KY(this.field_serviceInfoListStr);
    }
    return this.mZM;
  }
  
  public final boolean bsX()
  {
    return !bk.bl(this.field_allArticleWording);
  }
  
  public final boolean bsY()
  {
    return this.field_showRecommendArticle == 1;
  }
  
  public final boolean bsZ()
  {
    return this.field_showService == 1;
  }
  
  public final boolean isNormal()
  {
    return this.field_userRole == 1;
  }
  
  public final c.a rM()
  {
    return dUa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.d
 * JD-Core Version:    0.7.0.1
 */