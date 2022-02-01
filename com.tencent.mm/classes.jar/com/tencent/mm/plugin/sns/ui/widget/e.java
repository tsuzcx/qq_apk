package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.ui.j;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.vfs.i;

public final class e
{
  public static CharSequence a(Context paramContext, cuo paramcuo, j paramj, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(100534);
    paramContext = b(paramContext, paramcuo, paramj, paramInt1, paramString, paramInt2, paramBoolean1, paramBoolean2, paramp);
    AppMethodBeat.o(100534);
    return paramContext;
  }
  
  public static String a(com.tencent.mm.plugin.sns.storage.b paramb, String paramString)
  {
    AppMethodBeat.i(100537);
    String str = paramString;
    if (paramb != null)
    {
      if (!paramb.wTG) {
        break label30;
      }
      str = paramb.wTH;
    }
    for (;;)
    {
      AppMethodBeat.o(100537);
      return str;
      label30:
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
  
  private static String a(cuo paramcuo)
  {
    AppMethodBeat.i(100536);
    com.tencent.mm.storage.af localaf = com.tencent.mm.plugin.sns.model.af.dti().aHX(paramcuo.Username);
    if (localaf != null)
    {
      paramcuo = localaf.ZX();
      AppMethodBeat.o(100536);
      return paramcuo;
    }
    if (paramcuo.Nickname != null)
    {
      paramcuo = paramcuo.Nickname;
      AppMethodBeat.o(100536);
      return paramcuo;
    }
    paramcuo = paramcuo.Username;
    AppMethodBeat.o(100536);
    return paramcuo;
  }
  
  public static boolean a(final ImageView paramImageView, com.tencent.mm.plugin.sns.storage.p paramp, String paramString)
  {
    AppMethodBeat.i(100539);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramp != null)
    {
      bool1 = bool2;
      if (b(paramp, paramString))
      {
        paramp = paramp.dxs();
        bool1 = bool2;
        if (paramp != null)
        {
          bool1 = bool2;
          if (paramp.wTG)
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(paramp.wTI))
            {
              paramp = paramp.wTI;
              paramImageView.setTag(2131305044, paramp);
              bool2 = true;
              ad.i("SnsCommentUtil", "trySetAdBossCommentAvater, isSet=true");
              paramString = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.iU("adId", paramp);
              if (!i.eK(paramString)) {
                break label172;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString = l.wyR.getBitmap(paramString);
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
      label172:
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramp, new f.a()
      {
        public final void apm(String paramAnonymousString)
        {
          AppMethodBeat.i(100533);
          try
          {
            ad.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadedSucc, url=" + this.xYk);
            String str = (String)paramImageView.getTag(2131305044);
            if (TextUtils.isEmpty(str)) {}
            for (str = "";; str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.iU("adId", str))
            {
              if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str)))
              {
                paramAnonymousString = l.wyR.getBitmap(paramAnonymousString);
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
        
        public final void dsA()
        {
          AppMethodBeat.i(100532);
          ad.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadError, url=" + this.xYk);
          AppMethodBeat.o(100532);
        }
        
        public final void duP() {}
      });
      bool1 = bool2;
    }
  }
  
  private static CharSequence b(Context paramContext, cuo paramcuo, j paramj, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(100535);
    String str2 = "";
    String str1 = a(paramcuo);
    if (b(paramp, paramcuo.Username)) {
      str1 = a(paramp.dxs(), str1);
    }
    label410:
    label1440:
    label1442:
    for (;;)
    {
      Object localObject1 = "";
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject3 = com.tencent.mm.plugin.sns.model.af.dti().aHX(paramcuo.Emu);
      int n;
      label90:
      String str3;
      if ((paramBoolean1) && (com.tencent.mm.plugin.sns.g.a.anZ(paramcuo.Username)))
      {
        paramBoolean1 = true;
        if (paramInt1 != 21) {
          break label650;
        }
        n = 3;
        str3 = bt.nullAsNil(paramcuo.gKr);
        if (bt.isNullOrNil(paramString)) {
          break label1458;
        }
        g.afC();
      }
      label1191:
      label1196:
      label1458:
      for (Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW(paramString);; localObject2 = null)
      {
        int m;
        if (paramInt2 == 1) {
          if ((com.tencent.mm.plugin.sns.g.a.anY(paramcuo.Username)) && (paramBoolean2) && (o.isShowStoryCheck()))
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
          if ((hA(paramcuo.Eme, 1)) && (TextUtils.isEmpty(paramcuo.Emu))) {
            if (localObject2 != null) {
              if ((localObject2 == null) || (TextUtils.isEmpty(((com.tencent.mm.storage.af)localObject2).ZX())))
              {
                localObject3 = paramString;
                localObject2 = localObject3;
                if (paramp != null)
                {
                  localObject2 = localObject3;
                  if (paramp.Nb(32)) {
                    localObject2 = a(paramp.dxs(), (String)localObject3);
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
            paramContext = com.tencent.mm.pluginsdk.ui.span.k.a(paramContext, (String)localObject1 + str3, com.tencent.mm.cd.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.cd.a.dT(paramContext))), 2, paramBoolean1);
            if (paramInt1 != 21) {
              break label1191;
            }
            paramInt1 = 3;
            paramContext = new SpannableStringBuilder(paramContext);
            if (paramInt2 == 1)
            {
              if (!b(paramp, paramcuo.Username)) {
                break label1202;
              }
              if (!hA(paramcuo.Eme, 32)) {
                break label1196;
              }
              paramInt2 = 27;
              label453:
              paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(paramp.Nb(32), paramcuo.Username, paramp.dxX(), 0, paramInt2), paramj, paramInt1), 0, str1.length(), 33);
              label500:
              if (m != 0) {
                paramContext.setSpan(new h(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().qD(true)), str1.length() + 1, str1.length() + 2, 17);
              }
            }
            if (bt.isNullOrNil((String)localObject3)) {
              break label1261;
            }
            if ((paramp == null) || (!paramp.Nb(32)) || (!paramString.equals(paramp.field_userName))) {
              break label1230;
            }
            paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(paramp.Nb(32), paramString, paramp.dxX(), 0, 2), paramj, n), j, ((String)localObject3).length() + j, 33);
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
            localObject3 = ((com.tencent.mm.storage.af)localObject2).ZX();
            break label231;
            ad.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", new Object[] { paramString });
            i = 0;
            j = 0;
            k = 0;
            localObject2 = localObject5;
            localObject3 = localObject4;
            localObject1 = str2;
            continue;
            if (!hA(paramcuo.Eme, 8)) {
              break label883;
            }
            localObject3 = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(paramcuo.Emu);
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
          if (!bt.isNullOrNil(paramcuo.Emu)) {
            if (localObject3 == null)
            {
              localObject3 = paramcuo.Emu;
              localObject2 = localObject3;
              if (paramp != null)
              {
                localObject2 = localObject3;
                if (paramp.Nb(32))
                {
                  localObject2 = localObject3;
                  if (paramcuo.Emu.equals(paramp.field_userName)) {
                    localObject2 = a(paramp.dxs(), (String)localObject3);
                  }
                }
              }
              localObject3 = (String)localObject1 + paramContext.getString(2131763952);
              k = ((String)localObject3).length();
              if ((!com.tencent.mm.plugin.sns.g.a.anY(paramcuo.Emu)) || (!paramBoolean2) || (!o.isShowStoryCheck())) {
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
            localObject3 = ((com.tencent.mm.n.b)localObject3).ZX();
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
            paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(paramcuo.Username, paramj, paramInt1), 0, str1.length(), 33);
            break label500;
            label1230:
            paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(paramString, paramj, n), j, ((String)localObject3).length() + j, 33);
            break label637;
            label1261:
            if (bt.isNullOrNil((String)localObject2)) {
              break label637;
            }
            if ((paramp != null) && (paramp.Nb(32)) && (paramcuo.Emu.equals(paramp.field_userName))) {
              paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(paramp.Nb(32), paramcuo.Emu, paramp.dxX(), 0, 2), paramj, n), k, ((String)localObject2).length() + k, 33);
            }
            for (;;)
            {
              if (i == 0) {
                break label1440;
              }
              paramContext.setSpan(new h(((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().qD(true)), ((String)localObject2).length() + k - 1, ((String)localObject2).length() + k, 17);
              break;
              paramContext.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(paramcuo.Emu, paramj, n), k, ((String)localObject2).length() + k, 33);
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
  
  public static boolean b(com.tencent.mm.plugin.sns.storage.p paramp, String paramString)
  {
    AppMethodBeat.i(100538);
    if ((paramp != null) && (paramp.Nb(32)) && (paramString != null) && (paramString.equals(paramp.field_userName)))
    {
      AppMethodBeat.o(100538);
      return true;
    }
    AppMethodBeat.o(100538);
    return false;
  }
  
  public static boolean hA(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */