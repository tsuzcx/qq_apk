package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public List<String> dAY;
  public String gir;
  public String nah;
  public int nai;
  public List<String> naj;
  public String nak;
  public String nal;
  public String nam;
  public String nan;
  public int status;
  public String title;
  public int type;
  
  public static b ae(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.MessageInfo", "json is null, err");
      return null;
    }
    b localb = new b();
    for (;;)
    {
      int i;
      try
      {
        localb.title = paramJSONObject.optString("Title");
        localb.gir = paramJSONObject.optString("CoverImgUrl");
        localb.nah = paramJSONObject.optString("ArticleUrl");
        localb.nai = paramJSONObject.optInt("IsOriginalArticle", 0);
        localb.naj = new ArrayList();
        localb.dAY = new ArrayList();
        JSONArray localJSONArray = paramJSONObject.optJSONArray("UserInfoList");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            Object localObject = localJSONArray.optJSONObject(i);
            String str = ((JSONObject)localObject).optString("HeadImgUrl");
            localObject = ((JSONObject)localObject).optString("UserName");
            if ((bk.bl(str)) || (bk.bl((String)localObject))) {
              break label250;
            }
            localb.naj.add(str);
            localb.dAY.add(localObject);
            break label250;
          }
        }
        localb.nak = paramJSONObject.optString("UserInfoListDesc");
        localb.status = paramJSONObject.optInt("Status");
        localb.type = paramJSONObject.optInt("Type");
        localb.nal = paramJSONObject.optString("AppMsgId");
        localb.nam = paramJSONObject.optString("ItemIndex");
        localb.nan = paramJSONObject.optString("ReportContent");
        return localb;
      }
      catch (Exception paramJSONObject)
      {
        y.printErrStackTrace("MicroMsg.MessageInfo", paramJSONObject, "", new Object[0]);
        return localb;
      }
      label250:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.b
 * JD-Core Version:    0.7.0.1
 */