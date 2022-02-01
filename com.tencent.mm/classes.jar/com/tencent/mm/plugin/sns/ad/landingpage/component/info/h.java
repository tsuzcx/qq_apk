package com.tencent.mm.plugin.sns.ad.landingpage.component.info;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Map;

public final class h
  extends aa
{
  public String PSl;
  public String PSm;
  public String PSn;
  @p(hkF=1)
  public String PSo;
  @p(hkF=1)
  public String PSp;
  @p(hkF=1)
  public String PSq;
  public String PSr;
  @p(hkF=1)
  public String PSs;
  public ArrayList<String> PSt;
  public ArrayList<String> PSu;
  public String PSv;
  public String PSw;
  public String desc;
  
  public static h ab(Map<String, String> paramMap, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(310663);
    for (;;)
    {
      int i;
      try
      {
        h localh = new h();
        localh.PSl = Util.nullAsNil((String)paramMap.get(paramString + ".titlePrefix"));
        localh.PSm = Util.nullAsNil((String)paramMap.get(paramString + ".titleInfix"));
        localh.PSn = Util.nullAsNil((String)paramMap.get(paramString + ".titleSuffix"));
        localh.desc = Util.nullAsNil((String)paramMap.get(paramString + ".desc"));
        localh.PSo = Util.nullAsNil((String)paramMap.get(paramString + ".backgroundImgWithFriends"));
        localh.PSp = Util.nullAsNil((String)paramMap.get(paramString + ".backgroundImgCommon"));
        localh.PSq = Util.nullAsNil((String)paramMap.get(paramString + ".avatarBackgroundImg"));
        localh.PSr = Util.nullAsNil((String)paramMap.get(paramString + ".avatarDesc"));
        localh.PSs = Util.nullAsNil((String)paramMap.get(paramString + ".adAvatarImg"));
        localh.PSt = new ArrayList();
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
            localh.PSt.add(localObject);
            break label679;
          }
        }
        else
        {
          localObject = Integer.valueOf(i);
          continue;
        }
        localh.PSu = new ArrayList();
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
            localh.PSu.add(localObject);
            break label686;
          }
        }
        else
        {
          localObject = Integer.valueOf(i);
          continue;
        }
        localh.PSv = Util.nullAsNil((String)paramMap.get(paramString + ".friendAvatarDescWithFriends"));
        localh.PSw = Util.nullAsNil((String)paramMap.get(paramString + ".friendAvatarDescCommon"));
        AppMethodBeat.o(310663);
        return localh;
      }
      finally
      {
        Log.e("MicroMsg.AdLandingPageComponentInfo", "parseFromXml, exp=" + paramMap.toString());
        Log.e("MicroMsg.AdLandingPageComponentInfo", "parseFromXml, null");
        AppMethodBeat.o(310663);
        return null;
      }
      label679:
      i += 1;
      continue;
      label686:
      i += 1;
    }
  }
  
  public final String toString()
  {
    int j = 0;
    AppMethodBeat.i(310672);
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = ((StringBuilder)localObject).append("[titlePrefix=").append(this.PSl).append(", titleInfix=").append(this.PSm).append(", titleSuffix=").append(this.PSn).append(", desc=").append(this.desc).append(", backgroundImgWithFriends=").append(this.PSo).append(", backgroundImgCommon=").append(this.PSp).append(", avatarBackgroundImg=").append(this.PSq).append(", avatarDesc=").append(this.PSr).append(", adAvatarImg=").append(this.PSs).append(", userNameList.size=");
    if (this.PSt == null)
    {
      i = 0;
      localStringBuilder = localStringBuilder.append(i).append(", avatarUrlList.size=");
      if (this.PSu != null) {
        break label221;
      }
    }
    label221:
    for (int i = j;; i = this.PSu.size())
    {
      localStringBuilder.append(i).append(", friendAvatarDescWithFriends=").append(this.PSv).append(", friendAvatarDescCommon=").append(this.PSw).append("]");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(310672);
      return localObject;
      i = this.PSt.size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.info.h
 * JD-Core Version:    0.7.0.1
 */