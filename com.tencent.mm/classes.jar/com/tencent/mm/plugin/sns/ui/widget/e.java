package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.i.a.a;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.j;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.s;

public final class e
{
  public static CharSequence a(Context paramContext, dzo paramdzo, j paramj, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(100534);
    paramContext = b(paramContext, paramdzo, paramj, paramInt1, paramString, paramInt2, paramBoolean1, paramBoolean2, paramSnsInfo);
    AppMethodBeat.o(100534);
    return paramContext;
  }
  
  public static boolean a(final ImageView paramImageView, SnsInfo paramSnsInfo, String paramString)
  {
    AppMethodBeat.i(100539);
    boolean bool2;
    if ((paramSnsInfo != null) && (b(paramSnsInfo, paramString)))
    {
      paramSnsInfo = paramSnsInfo.getAdXml();
      if ((paramSnsInfo != null) && (paramSnsInfo.usePreferedInfo) && (!TextUtils.isEmpty(paramSnsInfo.preferAvatar)))
      {
        paramSnsInfo = paramSnsInfo.preferAvatar;
        paramImageView.setTag(2131308195, paramSnsInfo);
        bool2 = true;
        Log.i("SnsCommentUtil", "trySetAdBossCommentAvater, isSet=true");
        paramString = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", paramSnsInfo);
        if (!s.YS(paramString)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramString = com.tencent.mm.plugin.sns.ad.g.n.Dwr.getBitmap(paramString);
        bool1 = bool2;
        if (paramString != null)
        {
          paramImageView.setImageBitmap(paramString);
          Log.i("SnsCommentUtil", "trySetAdBossCommentAvater use local cache, url=".concat(String.valueOf(paramSnsInfo)));
          bool1 = bool2;
        }
      }
      catch (Throwable paramImageView)
      {
        Log.e("SnsCommentUtil", "trySetAdBossCommentAvater decode exp=" + paramImageView.toString());
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(100539);
      return bool1;
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramSnsInfo, false, new f.a()
      {
        public final void aNH(String paramAnonymousString)
        {
          AppMethodBeat.i(100533);
          try
          {
            Log.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadedSucc, url=" + this.Fft);
            String str = (String)paramImageView.getTag(2131308195);
            if (TextUtils.isEmpty(str)) {}
            for (str = "";; str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", str))
            {
              if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str)))
              {
                paramAnonymousString = com.tencent.mm.plugin.sns.ad.g.n.Dwr.getBitmap(paramAnonymousString);
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
        
        public final void eWN() {}
        
        public final void eWO()
        {
          AppMethodBeat.i(100532);
          Log.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadError, url=" + this.Fft);
          AppMethodBeat.o(100532);
        }
      });
      boolean bool1 = bool2;
      continue;
      bool1 = false;
    }
  }
  
  private static CharSequence b(Context paramContext, dzo paramdzo, j paramj, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(100535);
    Object localObject5 = "";
    String str1 = b(paramdzo);
    if (b(paramSnsInfo, paramdzo.Username)) {
      str1 = c(paramSnsInfo.getAdXml(), str1);
    }
    label197:
    label1095:
    label1864:
    for (;;)
    {
      Object localObject1 = "";
      Object localObject3 = null;
      Object localObject4 = null;
      int m = 0;
      int i2 = 0;
      int i1 = 0;
      as localas = aj.faC().bjK(paramdzo.MZm);
      int n;
      label99:
      String str2;
      if ((paramBoolean1) && (com.tencent.mm.plugin.sns.f.a.aOE(paramdzo.Username)))
      {
        paramBoolean1 = true;
        if (paramInt1 != 21) {
          break label817;
        }
        n = 3;
        str2 = Util.nullAsNil(paramdzo.iAc);
        if (Util.isNullOrNil(paramString)) {
          break label1876;
        }
        g.aAi();
      }
      label721:
      label1876:
      for (Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(paramString);; localObject2 = null)
      {
        int j;
        int k;
        if (paramInt2 == 1) {
          if ((com.tencent.mm.plugin.sns.f.a.aOD(paramdzo.Username)) && (paramBoolean2) && (o.isShowStoryCheck()))
          {
            localObject1 = str1 + "  ";
            j = 0;
            k = 1;
          }
        }
        for (;;)
        {
          label243:
          int i;
          if ((iY(paramdzo.MYX, 1)) && (TextUtils.isEmpty(paramdzo.MZm))) {
            if (localObject2 != null) {
              if ((localObject2 == null) || (TextUtils.isEmpty(((as)localObject2).arJ())))
              {
                localObject3 = paramString;
                localObject2 = localObject3;
                if (paramSnsInfo != null)
                {
                  localObject2 = localObject3;
                  if (paramSnsInfo.isAd()) {
                    localObject2 = c(paramSnsInfo.getAdXml(), (String)localObject3);
                  }
                }
                localObject1 = (String)localObject1 + paramContext.getString(2131766002);
                i2 = ((String)localObject1).length();
                localObject1 = (String)localObject1 + (String)localObject2;
                localObject1 = "" + (String)localObject1 + ": ";
                i = 0;
                localObject3 = localObject2;
                localObject2 = localObject4;
              }
            }
          }
          int i3;
          for (;;)
          {
            localObject1 = (String)localObject1 + str2;
            localObject4 = t.grY();
            if (!r.a(paramdzo)) {
              break label1442;
            }
            i3 = 5;
            ((Bundle)localObject4).putInt("ShareScene", i3);
            ((Bundle)localObject4).putString("ShareSceneId", paramSnsInfo.getUserName() + "#" + r.Jb(paramSnsInfo.field_snsId) + "#" + paramdzo.Username + "#" + paramdzo.MYT);
            ((Bundle)localObject4).putLong("CreateTime", paramdzo.CreateTime);
            if (paramInt2 != 2) {
              break label1448;
            }
            i3 = 3;
            label506:
            ((Bundle)localObject4).putInt("TimelineEnterSource", i3);
            ((Bundle)localObject4).putInt("SnsContentType", paramSnsInfo.field_type);
            localObject5 = com.tencent.mm.plugin.sns.i.a.DRI;
            a.a.a(paramContext, paramdzo, paramSnsInfo, paramInt2);
            localObject1 = com.tencent.mm.pluginsdk.ui.span.l.a(paramContext, (CharSequence)localObject1, com.tencent.mm.cb.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.cb.a.ez(paramContext))), 2, paramBoolean1, localObject4);
            if (paramInt1 != 21) {
              break label1454;
            }
            paramInt1 = 3;
            localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
            if (paramInt2 == 1)
            {
              if (!b(paramSnsInfo, paramdzo.Username)) {
                break label1465;
              }
              if (!iY(paramdzo.MYX, 32)) {
                break label1459;
              }
              paramInt2 = 27;
              label622:
              ((SpannableStringBuilder)localObject1).setSpan(new q(new com.tencent.mm.plugin.sns.data.b(paramSnsInfo.isAd(), paramdzo.Username, paramSnsInfo.getLocalid(), 0, paramInt2), paramj, paramInt1), 0, str1.length(), 33);
              if (k == 0) {
                break label1494;
              }
              ((SpannableStringBuilder)localObject1).setSpan(new h(((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().vJ(true)), str1.length() + 1, str1.length() + 2, 17);
            }
            if (Util.isNullOrNil((String)localObject3)) {
              break label1597;
            }
            if ((paramSnsInfo == null) || (!paramSnsInfo.isAd()) || (!paramString.equals(paramSnsInfo.getUserName()))) {
              break label1565;
            }
            ((SpannableStringBuilder)localObject1).setSpan(new q(new com.tencent.mm.plugin.sns.data.b(paramSnsInfo.isAd(), paramString, paramSnsInfo.getLocalid(), 0, 2), paramj, n), i2, ((String)localObject3).length() + i2, 33);
            AppMethodBeat.o(100535);
            return localObject1;
            paramBoolean1 = false;
            break;
            n = 2;
            break label99;
            if ((com.tencent.mm.plugin.textstatus.a.p.fvK()) && (((com.tencent.mm.plugin.textstatus.a.c)g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).hasStatus(paramdzo.Username)))
            {
              localObject1 = str1 + " ";
              j = 1;
              k = 0;
              break label197;
            }
            j = 0;
            k = 0;
            localObject1 = str1;
            break label197;
            localObject3 = ((as)localObject2).arJ();
            break label243;
            Log.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", new Object[] { paramString });
            i = 0;
            localObject2 = localObject4;
            localObject1 = localObject5;
            continue;
            if (!iY(paramdzo.MYX, 8)) {
              break label1095;
            }
            localObject4 = ((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramdzo.MZm);
            localObject2 = localObject1;
            if (!Util.isNullOrNil((String)localObject1)) {
              localObject2 = (String)localObject1 + ": ";
            }
            localObject1 = (String)localObject2 + paramContext.getString(2131766002);
            m = ((String)localObject1).length();
            localObject1 = (String)localObject1 + (String)localObject4;
            localObject1 = "" + (String)localObject1 + " ";
            i = 0;
            localObject2 = localObject4;
          }
          if (!Util.isNullOrNil(paramdzo.MZm)) {
            if (localas == null)
            {
              localObject2 = paramdzo.MZm;
              label1116:
              if ((paramSnsInfo == null) || (!paramSnsInfo.isAd()) || (!paramdzo.MZm.equals(paramSnsInfo.getUserName()))) {
                break label1864;
              }
              localObject2 = c(paramSnsInfo.getAdXml(), (String)localObject2);
            }
          }
          for (;;)
          {
            localObject4 = (String)localObject1 + paramContext.getString(2131766183);
            i3 = ((String)localObject4).length();
            if ((com.tencent.mm.plugin.sns.f.a.aOD(paramdzo.MZm)) && (paramBoolean2) && (o.isShowStoryCheck()))
            {
              localObject1 = (String)localObject2 + "  ";
              i = 0;
              m = 1;
            }
            for (;;)
            {
              localObject2 = (String)localObject4 + (String)localObject1;
              localObject4 = "" + (String)localObject2 + ": ";
              localObject2 = localObject1;
              localObject1 = localObject4;
              i1 = m;
              m = i3;
              break;
              localObject2 = localas.arJ();
              break label1116;
              if ((com.tencent.mm.plugin.textstatus.a.p.fvK()) && (((com.tencent.mm.plugin.textstatus.a.c)g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).hasStatus(paramdzo.MZm)))
              {
                localObject1 = (String)localObject2 + " ";
                i = 1;
                m = 0;
                continue;
                localObject2 = localObject1;
                if (!Util.isNullOrNil((String)localObject1)) {
                  localObject2 = (String)localObject1 + ": ";
                }
                localObject1 = "" + (String)localObject2;
                i = 0;
                localObject2 = localObject4;
                break;
                i3 = 4;
                break label406;
                i3 = 1;
                break label506;
                paramInt1 = 2;
                break label577;
                paramInt2 = 2;
                break label622;
                ((SpannableStringBuilder)localObject1).setSpan(new q(paramdzo.Username, paramj, paramInt1), 0, str1.length(), 33);
                break label668;
                label1494:
                if (j == 0) {
                  break label721;
                }
                localObject4 = ((com.tencent.mm.plugin.textstatus.a.c)g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).getTextStatusSpanSync(paramdzo.Username, a.b.FXk, com.tencent.mm.cb.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.cb.a.ez(paramContext))));
                if (localObject4 == null) {
                  break label721;
                }
                ((SpannableStringBuilder)localObject1).setSpan(localObject4, str1.length(), str1.length() + 1, 17);
                break label721;
                ((SpannableStringBuilder)localObject1).setSpan(new q(paramString, paramj, n), i2, ((String)localObject3).length() + i2, 33);
                break label803;
                if (Util.isNullOrNil((String)localObject2)) {
                  break label803;
                }
                if ((paramSnsInfo != null) && (paramSnsInfo.isAd()) && (paramdzo.MZm.equals(paramSnsInfo.getUserName()))) {
                  ((SpannableStringBuilder)localObject1).setSpan(new q(new com.tencent.mm.plugin.sns.data.b(paramSnsInfo.isAd(), paramdzo.MZm, paramSnsInfo.getLocalid(), 0, 2), paramj, n), m, ((String)localObject2).length() + m, 33);
                }
                for (;;)
                {
                  if (i1 == 0) {
                    break label1777;
                  }
                  ((SpannableStringBuilder)localObject1).setSpan(new h(((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().vJ(true)), ((String)localObject2).length() + m - 1, ((String)localObject2).length() + m, 17);
                  break;
                  ((SpannableStringBuilder)localObject1).setSpan(new q(paramdzo.MZm, paramj, n), m, ((String)localObject2).length() + m, 33);
                }
                label1777:
                if (i == 0) {
                  break label803;
                }
                paramContext = ((com.tencent.mm.plugin.textstatus.a.c)g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).getTextStatusSpanSync(paramdzo.MZm, a.b.FXk, com.tencent.mm.cb.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.cb.a.ez(paramContext))));
                if (paramContext == null) {
                  break label803;
                }
                ((SpannableStringBuilder)localObject1).setSpan(paramContext, ((String)localObject2).length() + m - 1, ((String)localObject2).length() + m, 17);
                break label803;
              }
              i = 0;
              m = 0;
              localObject1 = localObject2;
            }
          }
          j = 0;
          k = 0;
        }
      }
    }
  }
  
  public static CharSequence b(SpannableStringBuilder paramSpannableStringBuilder)
  {
    AppMethodBeat.i(204001);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableStringBuilder);
    if (!Util.isNullOrNil(paramSpannableStringBuilder))
    {
      paramSpannableStringBuilder = (com.tencent.mm.pluginsdk.ui.span.p[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), com.tencent.mm.pluginsdk.ui.span.p.class);
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
            if ((str1 != null) && (str1.length() > ah.DKc) && (localSpannableStringBuilder.toString().contains(str1)))
            {
              String str2 = str1.substring(0, ah.DKc) + "...";
              SpannableString localSpannableString = new SpannableString(str2);
              localSpannableString.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(2, localObject.getHrefInfo()), 0, str2.length(), 33);
              int k = localSpannableStringBuilder.toString().indexOf(str1);
              localSpannableStringBuilder.replace(k, str1.length() + k, localSpannableString);
            }
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(204001);
    return localSpannableStringBuilder;
  }
  
  public static String b(dzo paramdzo)
  {
    AppMethodBeat.i(100536);
    as localas = aj.faC().bjK(paramdzo.Username);
    if (localas != null)
    {
      paramdzo = localas.arJ();
      AppMethodBeat.o(100536);
      return paramdzo;
    }
    if (paramdzo.Nickname != null)
    {
      paramdzo = paramdzo.Nickname;
      AppMethodBeat.o(100536);
      return paramdzo;
    }
    paramdzo = paramdzo.Username;
    AppMethodBeat.o(100536);
    return paramdzo;
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
  
  public static String c(ADXml paramADXml, String paramString)
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
  
  public static boolean c(dzo paramdzo)
  {
    return (paramdzo != null) && (paramdzo.DeleteFlag > 0);
  }
  
  public static boolean iY(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */