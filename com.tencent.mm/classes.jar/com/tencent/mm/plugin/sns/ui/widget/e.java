package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.a.a;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.j;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class e
{
  public static CharSequence a(Context paramContext, ejo paramejo, j paramj, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(100534);
    paramContext = b(paramContext, paramejo, paramj, paramInt1, paramString, paramInt2, paramBoolean1, paramBoolean2, paramSnsInfo);
    AppMethodBeat.o(100534);
    return paramContext;
  }
  
  public static boolean a(final ImageView paramImageView, SnsInfo paramSnsInfo, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(100539);
    boolean bool1;
    if ((paramSnsInfo != null) && (b(paramSnsInfo, paramString)))
    {
      paramSnsInfo = paramSnsInfo.getAdXml();
      if ((paramSnsInfo != null) && (paramSnsInfo.usePreferedInfo) && (!TextUtils.isEmpty(paramSnsInfo.preferAvatar)))
      {
        paramSnsInfo = paramSnsInfo.preferAvatar;
        paramImageView.setTag(i.f.sns_prefer_avatar_url, paramSnsInfo);
        Log.i("SnsCommentUtil", "trySetAdBossCommentAvater, isSet=true");
        paramString = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", paramSnsInfo);
        if (com.tencent.mm.vfs.u.agG(paramString)) {
          if (com.tencent.mm.plugin.sns.ad.timeline.b.h.fLz())
          {
            com.tencent.mm.plugin.sns.ad.timeline.b.h.i(paramImageView, paramString, 1);
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(100539);
      return bool1;
      try
      {
        paramString = com.tencent.mm.plugin.sns.ad.f.o.JFQ.JL(paramString);
        bool1 = bool2;
        if (paramString == null) {
          continue;
        }
        paramImageView.setImageBitmap(paramString);
        Log.i("SnsCommentUtil", "trySetAdBossCommentAvater use local cache, url=".concat(String.valueOf(paramSnsInfo)));
        bool1 = bool2;
      }
      catch (Throwable paramImageView)
      {
        Log.e("SnsCommentUtil", "trySetAdBossCommentAvater decode exp=" + paramImageView.toString());
        bool1 = bool2;
      }
      continue;
      if (com.tencent.mm.plugin.sns.ad.timeline.b.h.fLz())
      {
        Log.i("SnsCommentUtil", "detail: download use avatar with cdn, but the statement should not reach!");
        com.tencent.mm.plugin.sns.ad.timeline.b.h.j(paramImageView, paramSnsInfo, 1);
        bool1 = bool2;
      }
      else
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramSnsInfo, false, new f.a()
        {
          public final void aYs(String paramAnonymousString)
          {
            AppMethodBeat.i(100533);
            try
            {
              Log.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadedSucc, url=" + this.JJc);
              String str = (String)paramImageView.getTag(i.f.sns_prefer_avatar_url);
              if (TextUtils.isEmpty(str)) {}
              for (str = "";; str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", str))
              {
                if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str)))
                {
                  paramAnonymousString = com.tencent.mm.plugin.sns.ad.f.o.JFQ.JL(paramAnonymousString);
                  if (paramAnonymousString != null)
                  {
                    paramImageView.setImageBitmap(paramAnonymousString);
                    Log.i("SnsCommentUtil", "trySetAdBossCommentAvater setImageBitmap");
                  }
                }
                AppMethodBeat.o(100533);
                return;
              }
              return;
            }
            catch (Throwable paramAnonymousString)
            {
              Log.e("SnsCommentUtil", "trySetAdBossCommentAvater, download decode, exp=" + paramAnonymousString.toString());
              AppMethodBeat.o(100533);
            }
          }
          
          public final void fJU() {}
          
          public final void fJV()
          {
            AppMethodBeat.i(100532);
            Log.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadError, url=" + this.JJc);
            AppMethodBeat.o(100532);
          }
        });
        bool1 = bool2;
        continue;
        bool1 = false;
      }
    }
  }
  
  private static CharSequence b(Context paramContext, ejo paramejo, j paramj, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(100535);
    Object localObject5 = "";
    String str1 = b(paramejo);
    if (b(paramSnsInfo, paramejo.Username)) {
      str1 = d(paramSnsInfo.getAdXml(), str1);
    }
    label194:
    label579:
    label1105:
    for (;;)
    {
      Object localObject1 = "";
      Object localObject3 = null;
      Object localObject4 = null;
      int n = 0;
      int i2 = 0;
      as localas = aj.fOw().bwh(paramejo.UlG);
      int i1;
      label96:
      String str2;
      if ((paramBoolean1) && (com.tencent.mm.plugin.sns.f.a.aZA(paramejo.Username)))
      {
        paramBoolean1 = true;
        if (paramInt1 != 21) {
          break label819;
        }
        i1 = 3;
        str2 = Util.nullAsNil(paramejo.lpy);
        if (Util.isNullOrNil(paramString)) {
          break label1885;
        }
        com.tencent.mm.kernel.h.aHH();
      }
      label723:
      label1885:
      for (Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg(paramString);; localObject2 = null)
      {
        int k;
        int m;
        if (paramInt2 == 1) {
          if ((com.tencent.mm.plugin.sns.f.a.aZz(paramejo.Username)) && (paramBoolean2) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()))
          {
            localObject1 = str1 + "  ";
            k = 0;
            m = 1;
          }
        }
        for (;;)
        {
          label240:
          int i;
          int j;
          if ((ki(paramejo.Ulr, 1)) && (TextUtils.isEmpty(paramejo.UlG))) {
            if (localObject2 != null) {
              if ((localObject2 == null) || (TextUtils.isEmpty(((as)localObject2).ays())))
              {
                localObject3 = paramString;
                localObject2 = localObject3;
                if (paramSnsInfo != null)
                {
                  localObject2 = localObject3;
                  if (paramSnsInfo.isAd()) {
                    localObject2 = d(paramSnsInfo.getAdXml(), (String)localObject3);
                  }
                }
                localObject1 = (String)localObject1 + paramContext.getString(i.j.sns_at);
                i2 = ((String)localObject1).length();
                localObject1 = (String)localObject1 + (String)localObject2;
                localObject1 = "" + (String)localObject1 + ": ";
                i = 0;
                j = 0;
                localObject3 = localObject2;
                localObject2 = localObject4;
              }
            }
          }
          int i3;
          for (;;)
          {
            localObject1 = (String)localObject1 + str2;
            localObject4 = com.tencent.mm.pluginsdk.ui.span.t.hmY();
            if (!com.tencent.mm.plugin.sns.data.t.a(paramejo)) {
              break label1449;
            }
            i3 = 5;
            ((Bundle)localObject4).putInt("ShareScene", i3);
            ((Bundle)localObject4).putString("ShareSceneId", paramSnsInfo.getUserName() + "#" + com.tencent.mm.plugin.sns.data.t.Qu(paramSnsInfo.field_snsId) + "#" + paramejo.Username + "#" + paramejo.Uln);
            ((Bundle)localObject4).putLong("CreateTime", paramejo.CreateTime);
            if (paramInt2 != 2) {
              break label1455;
            }
            i3 = 3;
            label509:
            ((Bundle)localObject4).putInt("TimelineEnterSource", i3);
            ((Bundle)localObject4).putInt("SnsContentType", paramSnsInfo.field_type);
            localObject5 = com.tencent.mm.plugin.sns.i.a.KeP;
            a.a.a(paramContext, paramejo, paramSnsInfo, paramInt2);
            localObject1 = l.b(paramContext, (CharSequence)localObject1, com.tencent.mm.ci.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.ci.a.ez(paramContext))), paramBoolean1, localObject4);
            if (paramInt1 != 21) {
              break label1461;
            }
            paramInt1 = 3;
            localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
            if (paramInt2 == 1)
            {
              if (!b(paramSnsInfo, paramejo.Username)) {
                break label1472;
              }
              if (!ki(paramejo.Ulr, 32)) {
                break label1466;
              }
              paramInt2 = 27;
              label624:
              ((SpannableStringBuilder)localObject1).setSpan(new q(new com.tencent.mm.plugin.sns.data.d(paramSnsInfo.isAd(), paramejo.Username, paramSnsInfo.getLocalid(), 0, paramInt2), paramj, paramInt1), 0, str1.length(), 33);
              if (m == 0) {
                break label1501;
              }
              ((SpannableStringBuilder)localObject1).setSpan(new h(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().zn(true)), str1.length() + 1, str1.length() + 2, 17);
            }
            if (Util.isNullOrNil((String)localObject3)) {
              break label1605;
            }
            if ((paramSnsInfo == null) || (!paramSnsInfo.isAd()) || (!paramString.equals(paramSnsInfo.getUserName()))) {
              break label1573;
            }
            ((SpannableStringBuilder)localObject1).setSpan(new q(new com.tencent.mm.plugin.sns.data.d(paramSnsInfo.isAd(), paramString, paramSnsInfo.getLocalid(), 0, 2), paramj, i1), i2, ((String)localObject3).length() + i2, 33);
            AppMethodBeat.o(100535);
            return localObject1;
            paramBoolean1 = false;
            break;
            i1 = 2;
            break label96;
            if ((com.tencent.mm.plugin.textstatus.a.t.gll()) && (((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).hasStatus(paramejo.Username)))
            {
              localObject1 = str1 + " ";
              k = 1;
              m = 0;
              break label194;
            }
            k = 0;
            m = 0;
            localObject1 = str1;
            break label194;
            localObject3 = ((as)localObject2).ays();
            break label240;
            Log.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", new Object[] { paramString });
            i = 0;
            j = 0;
            localObject2 = localObject4;
            localObject1 = localObject5;
            continue;
            if (!ki(paramejo.Ulr, 8)) {
              break label1105;
            }
            localObject4 = ((b)com.tencent.mm.kernel.h.ae(b.class)).PJ(paramejo.UlG);
            localObject2 = localObject1;
            if (!Util.isNullOrNil((String)localObject1)) {
              localObject2 = (String)localObject1 + ": ";
            }
            localObject1 = (String)localObject2 + paramContext.getString(i.j.sns_at);
            n = ((String)localObject1).length();
            localObject1 = (String)localObject1 + (String)localObject4;
            localObject1 = "" + (String)localObject1 + " ";
            i = 0;
            j = 0;
            localObject2 = localObject4;
          }
          if (!Util.isNullOrNil(paramejo.UlG)) {
            if (localas == null)
            {
              localObject2 = paramejo.UlG;
              label1126:
              if ((paramSnsInfo == null) || (!paramSnsInfo.isAd()) || (!paramejo.UlG.equals(paramSnsInfo.getUserName()))) {
                break label1873;
              }
              localObject2 = d(paramSnsInfo.getAdXml(), (String)localObject2);
            }
          }
          for (;;)
          {
            localObject4 = (String)localObject1 + paramContext.getString(i.j.sns_reply);
            n = ((String)localObject4).length();
            if ((com.tencent.mm.plugin.sns.f.a.aZz(paramejo.UlG)) && (paramBoolean2) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()))
            {
              localObject1 = (String)localObject2 + "  ";
              i = 0;
              j = 1;
            }
            for (;;)
            {
              localObject2 = (String)localObject4 + (String)localObject1;
              localObject4 = "" + (String)localObject2 + ": ";
              localObject2 = localObject1;
              localObject1 = localObject4;
              break;
              localObject2 = localas.ays();
              break label1126;
              if ((com.tencent.mm.plugin.textstatus.a.t.gll()) && (((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).hasStatus(paramejo.UlG)))
              {
                localObject1 = (String)localObject2 + " ";
                i = 1;
                j = 0;
                continue;
                localObject2 = localObject1;
                if (!Util.isNullOrNil((String)localObject1)) {
                  localObject2 = (String)localObject1 + ": ";
                }
                localObject1 = "" + (String)localObject2;
                i = 0;
                j = 0;
                localObject2 = localObject4;
                break;
                i3 = 4;
                break label408;
                i3 = 1;
                break label509;
                paramInt1 = 2;
                break label579;
                paramInt2 = 2;
                break label624;
                ((SpannableStringBuilder)localObject1).setSpan(new q(paramejo.Username, paramj, paramInt1), 0, str1.length(), 33);
                break label670;
                label1501:
                if (k == 0) {
                  break label723;
                }
                localObject4 = ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).getTextStatusSpanSync(null, paramejo.Username, a.b.MzD, com.tencent.mm.ci.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.ci.a.ez(paramContext))));
                if (localObject4 == null) {
                  break label723;
                }
                ((SpannableStringBuilder)localObject1).setSpan(localObject4, str1.length(), str1.length() + 1, 17);
                break label723;
                ((SpannableStringBuilder)localObject1).setSpan(new q(paramString, paramj, i1), i2, ((String)localObject3).length() + i2, 33);
                break label805;
                if (Util.isNullOrNil((String)localObject2)) {
                  break label805;
                }
                if ((paramSnsInfo != null) && (paramSnsInfo.isAd()) && (paramejo.UlG.equals(paramSnsInfo.getUserName()))) {
                  ((SpannableStringBuilder)localObject1).setSpan(new q(new com.tencent.mm.plugin.sns.data.d(paramSnsInfo.isAd(), paramejo.UlG, paramSnsInfo.getLocalid(), 0, 2), paramj, i1), n, ((String)localObject2).length() + n, 33);
                }
                for (;;)
                {
                  if (j == 0) {
                    break label1785;
                  }
                  ((SpannableStringBuilder)localObject1).setSpan(new h(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().zn(true)), ((String)localObject2).length() + n - 1, ((String)localObject2).length() + n, 17);
                  break;
                  ((SpannableStringBuilder)localObject1).setSpan(new q(paramejo.UlG, paramj, i1), n, ((String)localObject2).length() + n, 33);
                }
                label1785:
                if (i == 0) {
                  break label805;
                }
                paramContext = ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).getTextStatusSpanSync(null, paramejo.UlG, a.b.MzD, com.tencent.mm.ci.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.ci.a.ez(paramContext))));
                if (paramContext == null) {
                  break label805;
                }
                ((SpannableStringBuilder)localObject1).setSpan(paramContext, ((String)localObject2).length() + n - 1, ((String)localObject2).length() + n, 17);
                break label805;
              }
              i = 0;
              j = 0;
              localObject1 = localObject2;
            }
          }
          k = 0;
          m = 0;
        }
      }
    }
  }
  
  public static String b(ejo paramejo)
  {
    AppMethodBeat.i(100536);
    as localas = aj.fOw().bwh(paramejo.Username);
    if (localas != null)
    {
      paramejo = localas.ays();
      AppMethodBeat.o(100536);
      return paramejo;
    }
    if (paramejo.Nickname != null)
    {
      paramejo = paramejo.Nickname;
      AppMethodBeat.o(100536);
      return paramejo;
    }
    paramejo = paramejo.Username;
    AppMethodBeat.o(100536);
    return paramejo;
  }
  
  public static boolean b(SnsInfo paramSnsInfo, String paramString)
  {
    AppMethodBeat.i(100538);
    if ((paramSnsInfo != null) && (paramSnsInfo.isAd()) && (paramString != null) && (paramString.equals(paramSnsInfo.getUserName())))
    {
      AppMethodBeat.o(100538);
      return true;
    }
    AppMethodBeat.o(100538);
    return false;
  }
  
  public static CharSequence c(SpannableStringBuilder paramSpannableStringBuilder)
  {
    AppMethodBeat.i(266520);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableStringBuilder);
    if (!Util.isNullOrNil(paramSpannableStringBuilder))
    {
      paramSpannableStringBuilder = (p[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), p.class);
      if ((paramSpannableStringBuilder != null) && (paramSpannableStringBuilder.length > 0))
      {
        int j = paramSpannableStringBuilder.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramSpannableStringBuilder[i];
          if (localObject.getType() == 1)
          {
            String str1 = localObject.getHrefInfo().url;
            if ((str1 != null) && (str1.length() > ah.JXe) && (localSpannableStringBuilder.toString().contains(str1)))
            {
              String str2 = str1.substring(0, ah.JXe) + "...";
              SpannableString localSpannableString = new SpannableString(str2);
              localSpannableString.setSpan(new p(2, localObject.getHrefInfo()), 0, str2.length(), 33);
              int k = localSpannableStringBuilder.toString().indexOf(str1);
              localSpannableStringBuilder.replace(k, str1.length() + k, localSpannableString);
            }
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(266520);
    return localSpannableStringBuilder;
  }
  
  public static boolean c(ejo paramejo)
  {
    return (paramejo != null) && (paramejo.DeleteFlag > 0);
  }
  
  public static String d(ADXml paramADXml, String paramString)
  {
    AppMethodBeat.i(100537);
    String str = paramString;
    if (paramADXml != null)
    {
      if (!paramADXml.usePreferedInfo) {
        break label32;
      }
      str = paramADXml.preferNickName;
    }
    for (;;)
    {
      AppMethodBeat.o(100537);
      return str;
      label32:
      str = paramString;
      if (Util.isNullOrNil(paramString))
      {
        str = paramString;
        if (!Util.isNullOrNil(paramADXml.nickname)) {
          str = paramADXml.nickname;
        }
      }
    }
  }
  
  public static boolean ki(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */