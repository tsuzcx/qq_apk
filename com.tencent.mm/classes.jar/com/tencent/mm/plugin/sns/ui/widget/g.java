package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.j.a.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.j;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.x;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.vfs.y;

public final class g
{
  public static CharSequence a(Context paramContext, fdv paramfdv, j paramj, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(100534);
    paramContext = b(paramContext, paramfdv, paramj, paramInt1, paramString, paramInt2, paramBoolean1, paramBoolean2, paramSnsInfo);
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
        paramImageView.setTag(b.f.sns_prefer_avatar_url, paramSnsInfo);
        Log.i("SnsCommentUtil", "trySetAdBossCommentAvater, isSet=true");
        paramString = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mC("adId", paramSnsInfo);
        if (y.ZC(paramString)) {
          if (com.tencent.mm.plugin.sns.ad.timeline.helper.k.hbW())
          {
            com.tencent.mm.plugin.sns.ad.timeline.helper.k.i(paramImageView, paramString, 1);
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
        paramString = com.tencent.mm.plugin.sns.ad.g.o.PWQ.Cr(paramString);
        bool1 = bool2;
        if (paramString == null) {
          continue;
        }
        paramImageView.setImageBitmap(paramString);
        Log.i("SnsCommentUtil", "trySetAdBossCommentAvater use local cache, url=".concat(String.valueOf(paramSnsInfo)));
        bool1 = bool2;
        continue;
      }
      finally
      {
        Log.e("SnsCommentUtil", "trySetAdBossCommentAvater decode exp=" + paramImageView.toString());
        bool1 = bool2;
      }
      continue;
      if (com.tencent.mm.plugin.sns.ad.timeline.helper.k.hbW())
      {
        Log.i("SnsCommentUtil", "detail: download use avatar with cdn, but the statement should not reach!");
        com.tencent.mm.plugin.sns.ad.timeline.helper.k.j(paramImageView, paramSnsInfo, 1);
        bool1 = bool2;
      }
      else
      {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.a(paramSnsInfo, false, new g.a()
        {
          public final void aWn(String paramAnonymousString)
          {
            AppMethodBeat.i(100533);
            try
            {
              Log.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadedSucc, url=" + g.this);
              String str = (String)paramImageView.getTag(b.f.sns_prefer_avatar_url);
              if (TextUtils.isEmpty(str)) {}
              for (str = "";; str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mC("adId", str))
              {
                if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str)))
                {
                  paramAnonymousString = com.tencent.mm.plugin.sns.ad.g.o.PWQ.Cr(paramAnonymousString);
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
            finally
            {
              Log.e("SnsCommentUtil", "trySetAdBossCommentAvater, download decode, exp=" + paramAnonymousString.toString());
              AppMethodBeat.o(100533);
            }
          }
          
          public final void gZM() {}
          
          public final void gZN()
          {
            AppMethodBeat.i(100532);
            Log.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadError, url=" + g.this);
            AppMethodBeat.o(100532);
          }
        });
        bool1 = bool2;
        continue;
        bool1 = false;
      }
    }
  }
  
  private static CharSequence b(Context paramContext, fdv paramfdv, j paramj, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(100535);
    String str1 = b(paramfdv);
    if (b(paramSnsInfo, paramfdv.Username)) {
      str1 = e(paramSnsInfo.getAdXml(), str1);
    }
    label650:
    label794:
    label1694:
    for (;;)
    {
      Object localObject1 = "";
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = al.hgp().bxv(paramfdv.abDA);
      int i2;
      label86:
      String str2;
      if ((paramBoolean1) && (com.tencent.mm.plugin.sns.easteregg.a.aXL(paramfdv.Username)))
      {
        paramBoolean1 = true;
        if (paramInt1 != 21) {
          break label890;
        }
        i2 = 3;
        str2 = Util.nullAsNil(paramfdv.nUB);
        if (Util.isNullOrNil(paramString)) {
          break label1974;
        }
        h.baF();
      }
      label1185:
      label1962:
      label1974:
      for (Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu(paramString);; localObject2 = null)
      {
        int n;
        int i1;
        if (paramInt2 == 1) {
          if ((com.tencent.mm.plugin.sns.easteregg.a.aXK(paramfdv.Username)) && (paramBoolean2) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()))
          {
            localObject1 = str1 + "  ";
            n = 0;
            i1 = 1;
          }
        }
        for (;;)
        {
          label184:
          label230:
          int k;
          int i;
          int j;
          int m;
          if ((lU(paramfdv.abDl, 1)) && (TextUtils.isEmpty(paramfdv.abDA))) {
            if (localObject2 != null) {
              if ((localObject2 == null) || (TextUtils.isEmpty(((au)localObject2).aSV())))
              {
                localObject3 = paramString;
                localObject2 = localObject3;
                if (paramSnsInfo != null)
                {
                  localObject2 = localObject3;
                  if (paramSnsInfo.isAd()) {
                    localObject2 = e(paramSnsInfo.getAdXml(), (String)localObject3);
                  }
                }
                localObject1 = (String)localObject1 + paramContext.getString(b.j.sns_at);
                k = ((String)localObject1).length();
                localObject1 = (String)localObject1 + (String)localObject2;
                localObject1 = "" + (String)localObject1 + ": ";
                i = 0;
                j = 0;
                m = 0;
                localObject3 = localObject2;
                localObject2 = localObject4;
              }
            }
          }
          int i3;
          for (;;)
          {
            localObject4 = x.iNO();
            if (!com.tencent.mm.plugin.sns.data.t.a(paramfdv)) {
              break label1538;
            }
            i3 = 5;
            label379:
            ((Bundle)localObject4).putInt("ShareScene", i3);
            ((Bundle)localObject4).putString("ShareSceneId", paramSnsInfo.getUserName() + "#" + com.tencent.mm.plugin.sns.data.t.uA(paramSnsInfo.field_snsId) + "#" + paramfdv.Username + "#" + paramfdv.abDh);
            ((Bundle)localObject4).putLong("CreateTime", paramfdv.CreateTime);
            if (paramInt2 != 2) {
              break label1544;
            }
            i3 = 3;
            label480:
            ((Bundle)localObject4).putInt("TimelineEnterSource", i3);
            ((Bundle)localObject4).putInt("SnsContentType", paramSnsInfo.field_type);
            localObject5 = com.tencent.mm.plugin.sns.j.a.QCu;
            a.a.a(paramContext, paramfdv, paramSnsInfo, paramInt2);
            localObject5 = p.a(paramContext, true, (CharSequence)localObject1, com.tencent.mm.cd.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.cd.a.getScaleSize(paramContext))), 2, paramBoolean1, localObject4, null, 5);
            localObject1 = p.a(paramContext, true, str2, com.tencent.mm.cd.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.cd.a.getScaleSize(paramContext))), 2, paramBoolean1, localObject4, null, 5);
            localObject4 = com.tencent.mm.plugin.sns.h.a.a(paramSnsInfo.field_snsId, (CharSequence)localObject1, paramfdv.abDh);
            localObject1 = localObject4;
            if (Tiger2022Helper.b(paramSnsInfo.getTimeLine(), paramfdv.nUB)) {
              localObject1 = Tiger2022Helper.bE((CharSequence)localObject4);
            }
            localObject4 = new SpannableStringBuilder();
            ((SpannableStringBuilder)localObject4).append((CharSequence)localObject5);
            ((SpannableStringBuilder)localObject4).append((CharSequence)localObject1);
            if (paramInt1 != 21) {
              break label1550;
            }
            paramInt1 = 3;
            localObject1 = new SpannableStringBuilder((CharSequence)localObject4);
            if (paramInt2 == 1)
            {
              if (!b(paramSnsInfo, paramfdv.Username)) {
                break label1561;
              }
              if (!lU(paramfdv.abDl, 32)) {
                break label1555;
              }
              paramInt2 = 27;
              label695:
              ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.pluginsdk.ui.span.u(new com.tencent.mm.plugin.sns.data.d(paramSnsInfo.isAd(), paramfdv.Username, paramSnsInfo.getLocalid(), 0, paramInt2), paramj, paramInt1), 0, str1.length(), 33);
              label741:
              if (i1 == 0) {
                break label1590;
              }
              ((SpannableStringBuilder)localObject1).setSpan(new k(((e)h.az(e.class)).getStoryUIFactory().EE(true)), str1.length() + 1, str1.length() + 2, 17);
            }
            if (Util.isNullOrNil((String)localObject3)) {
              break label1694;
            }
            if ((paramSnsInfo == null) || (!paramSnsInfo.isAd()) || (!paramString.equals(paramSnsInfo.getUserName()))) {
              break label1662;
            }
            ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.pluginsdk.ui.span.u(new com.tencent.mm.plugin.sns.data.d(paramSnsInfo.isAd(), paramString, paramSnsInfo.getLocalid(), 0, 2), paramj, i2), k, ((String)localObject3).length() + k, 33);
            label876:
            AppMethodBeat.o(100535);
            return localObject1;
            paramBoolean1 = false;
            break;
            label890:
            i2 = 2;
            break label86;
            if ((ac.hGf()) && (((f)h.az(f.class)).hasStatus(paramfdv.Username)))
            {
              localObject1 = str1 + " ";
              n = 1;
              i1 = 0;
              break label184;
            }
            n = 0;
            i1 = 0;
            localObject1 = str1;
            break label184;
            localObject3 = ((au)localObject2).aSV();
            break label230;
            Log.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", new Object[] { paramString });
            i = 0;
            j = 0;
            k = 0;
            m = 0;
            localObject1 = "";
            localObject2 = localObject4;
            continue;
            if (!lU(paramfdv.abDl, 8)) {
              break label1185;
            }
            localObject4 = ((b)h.ax(b.class)).getDisplayName(paramfdv.abDA);
            localObject2 = localObject1;
            if (!Util.isNullOrNil((String)localObject1)) {
              localObject2 = (String)localObject1 + ": ";
            }
            localObject1 = (String)localObject2 + paramContext.getString(b.j.sns_at);
            m = ((String)localObject1).length();
            localObject1 = (String)localObject1 + (String)localObject4;
            localObject1 = "" + (String)localObject1 + " ";
            i = 0;
            j = 0;
            k = 0;
            localObject2 = localObject4;
          }
          if (!Util.isNullOrNil(paramfdv.abDA)) {
            if (localObject5 == null)
            {
              localObject2 = paramfdv.abDA;
              label1206:
              if ((paramSnsInfo == null) || (!paramSnsInfo.isAd()) || (!paramfdv.abDA.equals(paramSnsInfo.getUserName()))) {
                break label1962;
              }
              localObject2 = e(paramSnsInfo.getAdXml(), (String)localObject2);
            }
          }
          for (;;)
          {
            localObject4 = (String)localObject1 + paramContext.getString(b.j.sns_reply);
            m = ((String)localObject4).length();
            if ((com.tencent.mm.plugin.sns.easteregg.a.aXK(paramfdv.abDA)) && (paramBoolean2) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()))
            {
              localObject1 = (String)localObject2 + "  ";
              i = 0;
              j = 1;
            }
            for (;;)
            {
              localObject2 = (String)localObject4 + (String)localObject1;
              localObject4 = "" + (String)localObject2 + ": ";
              k = 0;
              localObject2 = localObject1;
              localObject1 = localObject4;
              break;
              localObject2 = ((com.tencent.mm.contact.d)localObject5).aSV();
              break label1206;
              if ((ac.hGf()) && (((f)h.az(f.class)).hasStatus(paramfdv.abDA)))
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
                k = 0;
                m = 0;
                localObject2 = localObject4;
                break;
                i3 = 4;
                break label379;
                i3 = 1;
                break label480;
                paramInt1 = 2;
                break label650;
                paramInt2 = 2;
                break label695;
                ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.pluginsdk.ui.span.u(paramfdv.Username, paramj, paramInt1), 0, str1.length(), 33);
                break label741;
                label1590:
                if (n == 0) {
                  break label794;
                }
                localObject4 = ((f)h.az(f.class)).getTextStatusSpanSync(null, paramfdv.Username, a.b.ThH, com.tencent.mm.cd.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.cd.a.getScaleSize(paramContext))));
                if (localObject4 == null) {
                  break label794;
                }
                ((SpannableStringBuilder)localObject1).setSpan(localObject4, str1.length(), str1.length() + 1, 17);
                break label794;
                label1662:
                ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.pluginsdk.ui.span.u(paramString, paramj, i2), k, ((String)localObject3).length() + k, 33);
                break label876;
                if (Util.isNullOrNil((String)localObject2)) {
                  break label876;
                }
                if ((paramSnsInfo != null) && (paramSnsInfo.isAd()) && (paramfdv.abDA.equals(paramSnsInfo.getUserName()))) {
                  ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.pluginsdk.ui.span.u(new com.tencent.mm.plugin.sns.data.d(paramSnsInfo.isAd(), paramfdv.abDA, paramSnsInfo.getLocalid(), 0, 2), paramj, i2), m, ((String)localObject2).length() + m, 33);
                }
                for (;;)
                {
                  if (j == 0) {
                    break label1874;
                  }
                  ((SpannableStringBuilder)localObject1).setSpan(new k(((e)h.az(e.class)).getStoryUIFactory().EE(true)), ((String)localObject2).length() + m - 1, ((String)localObject2).length() + m, 17);
                  break;
                  ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.pluginsdk.ui.span.u(paramfdv.abDA, paramj, i2), m, ((String)localObject2).length() + m, 33);
                }
                label1874:
                if (i == 0) {
                  break label876;
                }
                paramContext = ((f)h.az(f.class)).getTextStatusSpanSync(null, paramfdv.abDA, a.b.ThH, com.tencent.mm.cd.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.cd.a.getScaleSize(paramContext))));
                if (paramContext == null) {
                  break label876;
                }
                ((SpannableStringBuilder)localObject1).setSpan(paramContext, ((String)localObject2).length() + m - 1, ((String)localObject2).length() + m, 17);
                break label876;
              }
              i = 0;
              j = 0;
              localObject1 = localObject2;
            }
          }
          n = 0;
          i1 = 0;
        }
      }
    }
  }
  
  public static String b(fdv paramfdv)
  {
    AppMethodBeat.i(100536);
    au localau = al.hgp().bxv(paramfdv.Username);
    if (localau != null)
    {
      paramfdv = localau.aSV();
      AppMethodBeat.o(100536);
      return paramfdv;
    }
    if (paramfdv.Nickname != null)
    {
      paramfdv = paramfdv.Nickname;
      AppMethodBeat.o(100536);
      return paramfdv;
    }
    paramfdv = paramfdv.Username;
    AppMethodBeat.o(100536);
    return paramfdv;
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
    AppMethodBeat.i(309231);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableStringBuilder);
    if (!Util.isNullOrNil(paramSpannableStringBuilder))
    {
      paramSpannableStringBuilder = (com.tencent.mm.pluginsdk.ui.span.t[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), com.tencent.mm.pluginsdk.ui.span.t.class);
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
            if ((str1 != null) && (str1.length() > aj.Qum) && (localSpannableStringBuilder.toString().contains(str1)))
            {
              String str2 = str1.substring(0, aj.Qum) + "...";
              SpannableString localSpannableString = new SpannableString(str2);
              localSpannableString.setSpan(new com.tencent.mm.pluginsdk.ui.span.t(2, localObject.getHrefInfo()), 0, str2.length(), 33);
              int k = localSpannableStringBuilder.toString().indexOf(str1);
              localSpannableStringBuilder.replace(k, str1.length() + k, localSpannableString);
            }
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(309231);
    return localSpannableStringBuilder;
  }
  
  public static boolean c(fdv paramfdv)
  {
    return (paramfdv != null) && (paramfdv.DeleteFlag > 0);
  }
  
  public static String e(ADXml paramADXml, String paramString)
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
  
  public static boolean lU(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */