package com.tencent.mm.plugin.sns.ad.landingpage.component.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends aa
{
  public String JBP;
  public String JBQ;
  public String JBR;
  public String JBS;
  public String JBT;
  public String JBU;
  public String JBV;
  public String JBW;
  public ArrayList<String> JBX;
  public ArrayList<String> JBY;
  public String JBZ;
  public String JCa;
  public String desc;
  
  public static f L(Map<String, String> paramMap, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(252086);
    for (;;)
    {
      int i;
      try
      {
        f localf = new f();
        localf.JBP = Util.nullAsNil((String)paramMap.get(paramString + ".titlePrefix"));
        localf.JBQ = Util.nullAsNil((String)paramMap.get(paramString + ".titleInfix"));
        localf.JBR = Util.nullAsNil((String)paramMap.get(paramString + ".titleSuffix"));
        localf.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
        localf.JBS = Util.nullAsNil((String)paramMap.get(paramString + ".backgroundImgWithFriends"));
        localf.JBT = Util.nullAsNil((String)paramMap.get(paramString + ".backgroundImgCommon"));
        localf.JBU = Util.nullAsNil((String)paramMap.get(paramString + ".avatarBackgroundImg"));
        localf.JBV = Util.nullAsNil((String)paramMap.get(paramString + ".avatarDesc"));
        localf.JBW = Util.nullAsNil((String)paramMap.get(paramString + ".adAvatarImg"));
        localf.JBX = new ArrayList();
        i = 0;
        StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(".friendAvatarImgs.username");
        Object localObject;
        if (i == 0)
        {
          localObject = "";
          localObject = localObject;
          if (paramMap.containsKey(localObject))
          {
            localObject = Util.nullAsNil((String)paramMap.get(localObject));
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break label679;
            }
            localf.JBX.add(localObject);
            break label679;
          }
        }
        else
        {
          localObject = Integer.valueOf(i);
          continue;
        }
        localf.JBY = new ArrayList();
        i = j;
        localStringBuilder = new StringBuilder().append(paramString).append(".commonAvatarImgs.imageUrl");
        if (i == 0)
        {
          localObject = "";
          localObject = localObject;
          if (paramMap.containsKey(localObject))
          {
            localObject = Util.nullAsNil((String)paramMap.get(localObject));
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break label686;
            }
            localf.JBY.add(localObject);
            break label686;
          }
        }
        else
        {
          localObject = Integer.valueOf(i);
          continue;
        }
        localf.JBZ = Util.nullAsNil((String)paramMap.get(paramString + ".friendAvatarDescWithFriends"));
        localf.JCa = Util.nullAsNil((String)paramMap.get(paramString + ".friendAvatarDescCommon"));
        AppMethodBeat.o(252086);
        return localf;
      }
      catch (Throwable paramMap)
      {
        Log.e("MicroMsg.AdLandingPageComponentInfo", "parseFromXml, exp=" + paramMap.toString());
        Log.e("MicroMsg.AdLandingPageComponentInfo", "parseFromXml, null");
        AppMethodBeat.o(252086);
        return null;
      }
      label679:
      i += 1;
      continue;
      label686:
      i += 1;
    }
  }
  
  public final void aYx(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(252092);
    Log.i("MicroMsg.AdLandingPageComponentInfo", "updateFromJson, json=".concat(String.valueOf(paramString)));
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject1 = paramString.optString("titlePrefix");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.JBP = ((String)localObject1);
        }
        localObject1 = paramString.optString("titleInfix");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.JBQ = ((String)localObject1);
        }
        localObject1 = paramString.optString("titleSuffix");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.JBR = ((String)localObject1);
        }
        localObject1 = paramString.optString("desc");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.desc = ((String)localObject1);
        }
        localObject1 = paramString.optString("avatarDesc");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.JBV = ((String)localObject1);
        }
        localObject1 = paramString.optString("friendAvatarDescWithFriends");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.JBZ = ((String)localObject1);
        }
        localObject1 = paramString.optString("friendAvatarDescCommon");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.JCa = ((String)localObject1);
        }
        localObject1 = new ArrayList();
        Object localObject2 = paramString.optJSONArray("friendAvatarImgs");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            String str = ((JSONArray)localObject2).optString(i);
            if (TextUtils.isEmpty(str)) {
              break label372;
            }
            ((ArrayList)localObject1).add(str);
            break label372;
          }
        }
        this.JBX = ((ArrayList)localObject1);
        localObject1 = new ArrayList();
        paramString = paramString.optJSONArray("commonAvatarImgs");
        if ((paramString != null) && (paramString.length() > 0))
        {
          i = j;
          if (i < paramString.length())
          {
            localObject2 = paramString.optString(i);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label379;
            }
            ((ArrayList)localObject1).add(localObject2);
            break label379;
          }
        }
        if (((ArrayList)localObject1).size() > 0) {
          this.JBY = ((ArrayList)localObject1);
        }
        AppMethodBeat.o(252092);
        return;
      }
      catch (Throwable paramString)
      {
        Log.e("MicroMsg.AdLandingPageComponentInfo", "updateFromJson, exp=" + paramString.toString());
        AppMethodBeat.o(252092);
        return;
      }
      label372:
      i += 1;
      continue;
      label379:
      i += 1;
    }
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(252095);
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = ((StringBuilder)localObject).append("[titlePrefix=").append(this.JBP).append(", titleInfix=").append(this.JBQ).append(", titleSuffix=").append(this.JBR).append(", desc=").append(this.desc).append(", backgroundImgWithFriends=").append(this.JBS).append(", backgroundImgCommon=").append(this.JBT).append(", avatarBackgroundImg=").append(this.JBU).append(", avatarDesc=").append(this.JBV).append(", adAvatarImg=").append(this.JBW).append(", userNameList.size=");
    if (this.JBX == null)
    {
      i = 0;
      localStringBuilder = localStringBuilder.append(i).append(", avatarUrlList.size=");
      if (this.JBY != null) {
        break label221;
      }
    }
    label221:
    for (int i = j;; i = this.JBY.size())
    {
      localStringBuilder.append(i).append(", friendAvatarDescWithFriends=").append(this.JBZ).append(", friendAvatarDescCommon=").append(this.JCa).append("]");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(252095);
      return localObject;
      i = this.JBX.size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.b.f
 * JD-Core Version:    0.7.0.1
 */