package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.ui.j;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.i;

public final class e
{
  public static CharSequence a(Context paramContext, dfn paramdfn, j paramj, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(100534);
    paramContext = b(paramContext, paramdfn, paramj, paramInt1, paramString, paramInt2, paramBoolean1, paramBoolean2, paramp);
    AppMethodBeat.o(100534);
    return paramContext;
  }
  
  public static String a(dfn paramdfn)
  {
    AppMethodBeat.i(100536);
    am localam = ag.dTS().aTk(paramdfn.Username);
    if (localam != null)
    {
      paramdfn = localam.adv();
      AppMethodBeat.o(100536);
      return paramdfn;
    }
    if (paramdfn.Nickname != null)
    {
      paramdfn = paramdfn.Nickname;
      AppMethodBeat.o(100536);
      return paramdfn;
    }
    paramdfn = paramdfn.Username;
    AppMethodBeat.o(100536);
    return paramdfn;
  }
  
  public static boolean a(final ImageView paramImageView, com.tencent.mm.plugin.sns.storage.p paramp, String paramString)
  {
    AppMethodBeat.i(100539);
    boolean bool2;
    if ((paramp != null) && (b(paramp, paramString)))
    {
      paramp = paramp.dRL();
      if ((paramp != null) && (paramp.zws) && (!TextUtils.isEmpty(paramp.zwu)))
      {
        paramp = paramp.zwu;
        paramImageView.setTag(2131305044, paramp);
        bool2 = true;
        ad.i("SnsCommentUtil", "trySetAdBossCommentAvater, isSet=true");
        paramString = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jF("adId", paramp);
        if (!i.fv(paramString)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramString = com.tencent.mm.plugin.sns.ad.d.l.yZH.getBitmap(paramString);
        bool1 = bool2;
        if (paramString != null)
        {
          paramImageView.setImageBitmap(paramString);
          ad.i("SnsCommentUtil", "trySetAdBossCommentAvater use local cache, url=".concat(String.valueOf(paramp)));
          bool1 = bool2;
        }
      }
      catch (Throwable paramImageView)
      {
        ad.e("SnsCommentUtil", "trySetAdBossCommentAvater decode exp=" + paramImageView.toString());
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(100539);
      return bool1;
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramp, false, new f.a()
      {
        public final void axG(String paramAnonymousString)
        {
          AppMethodBeat.i(100533);
          try
          {
            ad.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadedSucc, url=" + this.ADm);
            String str = (String)paramImageView.getTag(2131305044);
            if (TextUtils.isEmpty(str)) {}
            for (str = "";; str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jF("adId", str))
            {
              if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str)))
              {
                paramAnonymousString = com.tencent.mm.plugin.sns.ad.d.l.yZH.getBitmap(paramAnonymousString);
                if (paramAnonymousString != null)
                {
                  paramImageView.setImageBitmap(paramAnonymousString);
                  ad.i("SnsCommentUtil", "trySetAdBossCommentAvater setImageBitmap");
                }
              }
              AppMethodBeat.o(100533);
              return;
            }
            return;
          }
          catch (Throwable paramAnonymousString)
          {
            ad.e("SnsCommentUtil", "trySetAdBossCommentAvater, download decode, exp=" + paramAnonymousString.toString());
            AppMethodBeat.o(100533);
          }
        }
        
        public final void dRW() {}
        
        public final void dRX()
        {
          AppMethodBeat.i(100532);
          ad.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadError, url=" + this.ADm);
          AppMethodBeat.o(100532);
        }
      });
      boolean bool1 = bool2;
      continue;
      bool1 = false;
    }
  }
  
  private static CharSequence b(Context paramContext, dfn paramdfn, j paramj, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(100535);
    String str2 = "";
    String str1 = a(paramdfn);
    if (b(paramp, paramdfn.Username)) {
      str1 = b(paramp.dRL(), str1);
    }
    label410:
    label1440:
    label1442:
    for (;;)
    {
      Object localObject1 = "";
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject3 = ag.dTS().aTk(paramdfn.Hub);
      int n;
      label90:
      String str3;
      if ((paramBoolean1) && (com.tencent.mm.plugin.sns.f.a.ayq(paramdfn.Username)))
      {
        paramBoolean1 = true;
        if (paramInt1 != 21) {
          break label650;
        }
        n = 3;
        str3 = bt.nullAsNil(paramdfn.hDa);
        if (bt.isNullOrNil(paramString)) {
          break label1458;
        }
        g.ajD();
      }
      label1191:
      label1196:
      label1458:
      for (Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTj(paramString);; localObject2 = null)
      {
        int m;
        if (paramInt2 == 1) {
          if ((com.tencent.mm.plugin.sns.f.a.ayp(paramdfn.Username)) && (paramBoolean2) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()))
          {
            localObject1 = str1 + "  ";
            m = 1;
          }
        }
        for (;;)
        {
          label185:
          label231:
          int j;
          int i;
          int k;
          if ((ia(paramdfn.HtL, 1)) && (TextUtils.isEmpty(paramdfn.Hub))) {
            if (localObject2 != null) {
              if ((localObject2 == null) || (TextUtils.isEmpty(((am)localObject2).adv())))
              {
                localObject3 = paramString;
                localObject2 = localObject3;
                if (paramp != null)
                {
                  localObject2 = localObject3;
                  if (paramp.QM(32)) {
                    localObject2 = b(paramp.dRL(), (String)localObject3);
                  }
                }
                localObject1 = (String)localObject1 + paramContext.getString(2131763780);
                j = ((String)localObject1).length();
                localObject1 = (String)localObject1 + (String)localObject2;
                localObject1 = "" + (String)localObject1 + ": ";
                i = 0;
                k = 0;
                localObject3 = localObject2;
                localObject2 = localObject5;
              }
            }
          }
          for (;;)
          {
            paramContext = k.a(paramContext, (String)localObject1 + str3, com.tencent.mm.cc.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.cc.a.eb(paramContext))), 2, paramBoolean1);
            if (paramInt1 != 21) {
              break label1191;
            }
            paramInt1 = 3;
            paramContext = new SpannableStringBuilder(paramContext);
            if (paramInt2 == 1)
            {
              if (!b(paramp, paramdfn.Username)) {
                break label1202;
              }
              if (!ia(paramdfn.HtL, 32)) {
                break label1196;
              }
              paramInt2 = 27;
              label453:
              paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(paramp.QM(32), paramdfn.Username, paramp.dYK(), 0, paramInt2), paramj, paramInt1), 0, str1.length(), 33);
              label500:
              if (m != 0) {
                paramContext.setSpan(new h(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().sh(true)), str1.length() + 1, str1.length() + 2, 17);
              }
            }
            if (bt.isNullOrNil((String)localObject3)) {
              break label1261;
            }
            if ((paramp == null) || (!paramp.QM(32)) || (!paramString.equals(paramp.field_userName))) {
              break label1230;
            }
            paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(paramp.QM(32), paramString, paramp.dYK(), 0, 2), paramj, n), j, ((String)localObject3).length() + j, 33);
            label637:
            AppMethodBeat.o(100535);
            return paramContext;
            paramBoolean1 = false;
            break;
            n = 2;
            break label90;
            m = 0;
            localObject1 = str1;
            break label185;
            localObject3 = ((am)localObject2).adv();
            break label231;
            ad.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", new Object[] { paramString });
            i = 0;
            j = 0;
            k = 0;
            localObject2 = localObject5;
            localObject3 = localObject4;
            localObject1 = str2;
            continue;
            if (!ia(paramdfn.HtL, 8)) {
              break label883;
            }
            localObject3 = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(paramdfn.Hub);
            localObject2 = localObject1;
            if (!bt.isNullOrNil((String)localObject1)) {
              localObject2 = (String)localObject1 + ": ";
            }
            localObject1 = (String)localObject2 + paramContext.getString(2131763780);
            k = ((String)localObject1).length();
            localObject1 = (String)localObject1 + (String)localObject3;
            localObject1 = "" + (String)localObject1 + " ";
            i = 0;
            j = 0;
            localObject2 = localObject3;
            localObject3 = localObject4;
          }
          label883:
          if (!bt.isNullOrNil(paramdfn.Hub)) {
            if (localObject3 == null)
            {
              localObject3 = paramdfn.Hub;
              localObject2 = localObject3;
              if (paramp != null)
              {
                localObject2 = localObject3;
                if (paramp.QM(32))
                {
                  localObject2 = localObject3;
                  if (paramdfn.Hub.equals(paramp.field_userName)) {
                    localObject2 = b(paramp.dRL(), (String)localObject3);
                  }
                }
              }
              localObject3 = (String)localObject1 + paramContext.getString(2131763952);
              k = ((String)localObject3).length();
              if ((!com.tencent.mm.plugin.sns.f.a.ayp(paramdfn.Hub)) || (!paramBoolean2) || (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())) {
                break label1442;
              }
              localObject1 = (String)localObject2 + "  ";
              i = 1;
            }
          }
          for (;;)
          {
            localObject2 = (String)localObject3 + (String)localObject1;
            localObject3 = "" + (String)localObject2 + ": ";
            j = 0;
            localObject2 = localObject1;
            localObject1 = localObject3;
            localObject3 = localObject4;
            break;
            localObject3 = ((com.tencent.mm.o.b)localObject3).adv();
            break label904;
            localObject2 = localObject1;
            if (!bt.isNullOrNil((String)localObject1)) {
              localObject2 = (String)localObject1 + ": ";
            }
            localObject1 = "" + (String)localObject2;
            i = 0;
            j = 0;
            k = 0;
            localObject2 = localObject5;
            localObject3 = localObject4;
            break;
            paramInt1 = 2;
            break label410;
            paramInt2 = 2;
            break label453;
            label1202:
            paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(paramdfn.Username, paramj, paramInt1), 0, str1.length(), 33);
            break label500;
            label1230:
            paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(paramString, paramj, n), j, ((String)localObject3).length() + j, 33);
            break label637;
            label1261:
            if (bt.isNullOrNil((String)localObject2)) {
              break label637;
            }
            if ((paramp != null) && (paramp.QM(32)) && (paramdfn.Hub.equals(paramp.field_userName))) {
              paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(paramp.QM(32), paramdfn.Hub, paramp.dYK(), 0, 2), paramj, n), k, ((String)localObject2).length() + k, 33);
            }
            for (;;)
            {
              if (i == 0) {
                break label1440;
              }
              paramContext.setSpan(new h(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().sh(true)), ((String)localObject2).length() + k - 1, ((String)localObject2).length() + k, 17);
              break;
              paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(paramdfn.Hub, paramj, n), k, ((String)localObject2).length() + k, 33);
            }
            break label637;
            i = 0;
            localObject1 = localObject2;
          }
          m = 0;
        }
      }
    }
  }
  
  public static CharSequence b(SpannableStringBuilder paramSpannableStringBuilder)
  {
    AppMethodBeat.i(198609);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableStringBuilder);
    if (!bt.ai(paramSpannableStringBuilder))
    {
      paramSpannableStringBuilder = (com.tencent.mm.pluginsdk.ui.span.o[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), com.tencent.mm.pluginsdk.ui.span.o.class);
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
            if ((str1 != null) && (str1.length() > com.tencent.mm.plugin.sns.ui.a.b.a.ArI))
            {
              String str2 = str1.substring(0, com.tencent.mm.plugin.sns.ui.a.b.a.ArI) + "...";
              SpannableString localSpannableString = new SpannableString(str2);
              localSpannableString.setSpan(new com.tencent.mm.pluginsdk.ui.span.o(2, localObject.getHrefInfo()), 0, str2.length(), 33);
              int k = localSpannableStringBuilder.toString().indexOf(str1);
              localSpannableStringBuilder.replace(k, str1.length() + k, localSpannableString);
            }
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(198609);
    return localSpannableStringBuilder;
  }
  
  public static String b(com.tencent.mm.plugin.sns.storage.b paramb, String paramString)
  {
    AppMethodBeat.i(100537);
    String str = paramString;
    if (paramb != null)
    {
      if (!paramb.zws) {
        break label32;
      }
      str = paramb.zwt;
    }
    for (;;)
    {
      AppMethodBeat.o(100537);
      return str;
      label32:
      str = paramString;
      if (bt.isNullOrNil(paramString))
      {
        str = paramString;
        if (!bt.isNullOrNil(paramb.nickname)) {
          str = paramb.nickname;
        }
      }
    }
  }
  
  public static boolean b(com.tencent.mm.plugin.sns.storage.p paramp, String paramString)
  {
    AppMethodBeat.i(100538);
    if ((paramp != null) && (paramp.QM(32)) && (paramString != null) && (paramString.equals(paramp.field_userName)))
    {
      AppMethodBeat.o(100538);
      return true;
    }
    AppMethodBeat.o(100538);
    return false;
  }
  
  public static boolean b(dfn paramdfn)
  {
    return (paramdfn != null) && (paramdfn.DeleteFlag > 0);
  }
  
  public static boolean ia(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */