package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.ad.e.m;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.ui.j;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;

public final class e
{
  public static CharSequence a(Context paramContext, dgh paramdgh, j paramj, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(100534);
    paramContext = b(paramContext, paramdgh, paramj, paramInt1, paramString, paramInt2, paramBoolean1, paramBoolean2, paramp);
    AppMethodBeat.o(100534);
    return paramContext;
  }
  
  public static String a(dgh paramdgh)
  {
    AppMethodBeat.i(100536);
    an localan = ah.dXs().aUL(paramdgh.Username);
    if (localan != null)
    {
      paramdgh = localan.adG();
      AppMethodBeat.o(100536);
      return paramdgh;
    }
    if (paramdgh.Nickname != null)
    {
      paramdgh = paramdgh.Nickname;
      AppMethodBeat.o(100536);
      return paramdgh;
    }
    paramdgh = paramdgh.Username;
    AppMethodBeat.o(100536);
    return paramdgh;
  }
  
  public static boolean a(final ImageView paramImageView, com.tencent.mm.plugin.sns.storage.p paramp, String paramString)
  {
    AppMethodBeat.i(100539);
    boolean bool2;
    if ((paramp != null) && (b(paramp, paramString)))
    {
      paramp = paramp.dVj();
      if ((paramp != null) && (paramp.zNN) && (!TextUtils.isEmpty(paramp.zNP)))
      {
        paramp = paramp.zNP;
        paramImageView.setTag(2131305044, paramp);
        bool2 = true;
        ae.i("SnsCommentUtil", "trySetAdBossCommentAvater, isSet=true");
        paramString = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", paramp);
        if (!com.tencent.mm.vfs.o.fB(paramString)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramString = m.zqi.getBitmap(paramString);
        bool1 = bool2;
        if (paramString != null)
        {
          paramImageView.setImageBitmap(paramString);
          ae.i("SnsCommentUtil", "trySetAdBossCommentAvater use local cache, url=".concat(String.valueOf(paramp)));
          bool1 = bool2;
        }
      }
      catch (Throwable paramImageView)
      {
        ae.e("SnsCommentUtil", "trySetAdBossCommentAvater decode exp=" + paramImageView.toString());
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(100539);
      return bool1;
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramp, false, new f.a()
      {
        public final void ayY(String paramAnonymousString)
        {
          AppMethodBeat.i(100533);
          try
          {
            ae.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadedSucc, url=" + this.AUN);
            String str = (String)paramImageView.getTag(2131305044);
            if (TextUtils.isEmpty(str)) {}
            for (str = "";; str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", str))
            {
              if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str)))
              {
                paramAnonymousString = m.zqi.getBitmap(paramAnonymousString);
                if (paramAnonymousString != null)
                {
                  paramImageView.setImageBitmap(paramAnonymousString);
                  ae.i("SnsCommentUtil", "trySetAdBossCommentAvater setImageBitmap");
                }
              }
              AppMethodBeat.o(100533);
              return;
            }
            return;
          }
          catch (Throwable paramAnonymousString)
          {
            ae.e("SnsCommentUtil", "trySetAdBossCommentAvater, download decode, exp=" + paramAnonymousString.toString());
            AppMethodBeat.o(100533);
          }
        }
        
        public final void dVu() {}
        
        public final void dVv()
        {
          AppMethodBeat.i(100532);
          ae.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadError, url=" + this.AUN);
          AppMethodBeat.o(100532);
        }
      });
      boolean bool1 = bool2;
      continue;
      bool1 = false;
    }
  }
  
  private static CharSequence b(Context paramContext, dgh paramdgh, j paramj, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(100535);
    String str2 = "";
    String str1 = a(paramdgh);
    if (b(paramp, paramdgh.Username)) {
      str1 = b(paramp.dVj(), str1);
    }
    label410:
    label1440:
    label1442:
    for (;;)
    {
      Object localObject1 = "";
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject3 = ah.dXs().aUL(paramdgh.HNE);
      int n;
      label90:
      String str3;
      if ((paramBoolean1) && (com.tencent.mm.plugin.sns.f.a.azH(paramdgh.Username)))
      {
        paramBoolean1 = true;
        if (paramInt1 != 21) {
          break label650;
        }
        n = 3;
        str3 = bu.nullAsNil(paramdgh.hFS);
        if (bu.isNullOrNil(paramString)) {
          break label1458;
        }
        g.ajS();
      }
      label1191:
      label1196:
      label1458:
      for (Object localObject2 = ((l)g.ab(l.class)).azF().aUK(paramString);; localObject2 = null)
      {
        int m;
        if (paramInt2 == 1) {
          if ((com.tencent.mm.plugin.sns.f.a.azG(paramdgh.Username)) && (paramBoolean2) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()))
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
          if ((id(paramdgh.HNo, 1)) && (TextUtils.isEmpty(paramdgh.HNE))) {
            if (localObject2 != null) {
              if ((localObject2 == null) || (TextUtils.isEmpty(((an)localObject2).adG())))
              {
                localObject3 = paramString;
                localObject2 = localObject3;
                if (paramp != null)
                {
                  localObject2 = localObject3;
                  if (paramp.Rt(32)) {
                    localObject2 = b(paramp.dVj(), (String)localObject3);
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
            paramContext = k.a(paramContext, (String)localObject1 + str3, com.tencent.mm.cb.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.cb.a.ef(paramContext))), 2, paramBoolean1);
            if (paramInt1 != 21) {
              break label1191;
            }
            paramInt1 = 3;
            paramContext = new SpannableStringBuilder(paramContext);
            if (paramInt2 == 1)
            {
              if (!b(paramp, paramdgh.Username)) {
                break label1202;
              }
              if (!id(paramdgh.HNo, 32)) {
                break label1196;
              }
              paramInt2 = 27;
              label453:
              paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(paramp.Rt(32), paramdgh.Username, paramp.eco(), 0, paramInt2), paramj, paramInt1), 0, str1.length(), 33);
              label500:
              if (m != 0) {
                paramContext.setSpan(new h(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().so(true)), str1.length() + 1, str1.length() + 2, 17);
              }
            }
            if (bu.isNullOrNil((String)localObject3)) {
              break label1261;
            }
            if ((paramp == null) || (!paramp.Rt(32)) || (!paramString.equals(paramp.field_userName))) {
              break label1230;
            }
            paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(paramp.Rt(32), paramString, paramp.eco(), 0, 2), paramj, n), j, ((String)localObject3).length() + j, 33);
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
            localObject3 = ((an)localObject2).adG();
            break label231;
            ae.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", new Object[] { paramString });
            i = 0;
            j = 0;
            k = 0;
            localObject2 = localObject5;
            localObject3 = localObject4;
            localObject1 = str2;
            continue;
            if (!id(paramdgh.HNo, 8)) {
              break label883;
            }
            localObject3 = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP(paramdgh.HNE);
            localObject2 = localObject1;
            if (!bu.isNullOrNil((String)localObject1)) {
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
          if (!bu.isNullOrNil(paramdgh.HNE)) {
            if (localObject3 == null)
            {
              localObject3 = paramdgh.HNE;
              localObject2 = localObject3;
              if (paramp != null)
              {
                localObject2 = localObject3;
                if (paramp.Rt(32))
                {
                  localObject2 = localObject3;
                  if (paramdgh.HNE.equals(paramp.field_userName)) {
                    localObject2 = b(paramp.dVj(), (String)localObject3);
                  }
                }
              }
              localObject3 = (String)localObject1 + paramContext.getString(2131763952);
              k = ((String)localObject3).length();
              if ((!com.tencent.mm.plugin.sns.f.a.azG(paramdgh.HNE)) || (!paramBoolean2) || (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())) {
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
            localObject3 = ((c)localObject3).adG();
            break label904;
            localObject2 = localObject1;
            if (!bu.isNullOrNil((String)localObject1)) {
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
            paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(paramdgh.Username, paramj, paramInt1), 0, str1.length(), 33);
            break label500;
            label1230:
            paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(paramString, paramj, n), j, ((String)localObject3).length() + j, 33);
            break label637;
            label1261:
            if (bu.isNullOrNil((String)localObject2)) {
              break label637;
            }
            if ((paramp != null) && (paramp.Rt(32)) && (paramdgh.HNE.equals(paramp.field_userName))) {
              paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(paramp.Rt(32), paramdgh.HNE, paramp.eco(), 0, 2), paramj, n), k, ((String)localObject2).length() + k, 33);
            }
            for (;;)
            {
              if (i == 0) {
                break label1440;
              }
              paramContext.setSpan(new h(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().so(true)), ((String)localObject2).length() + k - 1, ((String)localObject2).length() + k, 17);
              break;
              paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(paramdgh.HNE, paramj, n), k, ((String)localObject2).length() + k, 33);
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
    AppMethodBeat.i(220156);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableStringBuilder);
    if (!bu.ah(paramSpannableStringBuilder))
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
            if ((str1 != null) && (str1.length() > com.tencent.mm.plugin.sns.ui.a.b.a.AIW))
            {
              String str2 = str1.substring(0, com.tencent.mm.plugin.sns.ui.a.b.a.AIW) + "...";
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
    AppMethodBeat.o(220156);
    return localSpannableStringBuilder;
  }
  
  public static String b(com.tencent.mm.plugin.sns.storage.b paramb, String paramString)
  {
    AppMethodBeat.i(100537);
    String str = paramString;
    if (paramb != null)
    {
      if (!paramb.zNN) {
        break label32;
      }
      str = paramb.zNO;
    }
    for (;;)
    {
      AppMethodBeat.o(100537);
      return str;
      label32:
      str = paramString;
      if (bu.isNullOrNil(paramString))
      {
        str = paramString;
        if (!bu.isNullOrNil(paramb.nickname)) {
          str = paramb.nickname;
        }
      }
    }
  }
  
  public static boolean b(com.tencent.mm.plugin.sns.storage.p paramp, String paramString)
  {
    AppMethodBeat.i(100538);
    if ((paramp != null) && (paramp.Rt(32)) && (paramString != null) && (paramString.equals(paramp.field_userName)))
    {
      AppMethodBeat.o(100538);
      return true;
    }
    AppMethodBeat.o(100538);
    return false;
  }
  
  public static boolean b(dgh paramdgh)
  {
    return (paramdgh != null) && (paramdgh.DeleteFlag > 0);
  }
  
  public static boolean id(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */