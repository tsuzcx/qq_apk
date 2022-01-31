package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.plugin.story.api.f.a;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class d
{
  public static CharSequence a(Context paramContext, cds paramcds, com.tencent.mm.plugin.sns.ui.j paramj, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(40503);
    paramContext = b(paramContext, paramcds, paramj, paramInt1, paramString, paramInt2);
    AppMethodBeat.o(40503);
    return paramContext;
  }
  
  private static String a(cds paramcds)
  {
    AppMethodBeat.i(40505);
    ad localad = ag.coT().arv(paramcds.Username);
    if (localad != null)
    {
      paramcds = localad.Of();
      AppMethodBeat.o(40505);
      return paramcds;
    }
    if (paramcds.Nickname != null)
    {
      paramcds = paramcds.Nickname;
      AppMethodBeat.o(40505);
      return paramcds;
    }
    paramcds = paramcds.Username;
    AppMethodBeat.o(40505);
    return paramcds;
  }
  
  private static CharSequence b(Context paramContext, cds paramcds, com.tencent.mm.plugin.sns.ui.j paramj, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(40504);
    String str4 = "";
    String str2 = a(paramcds);
    String str1 = "";
    Object localObject2 = null;
    String str3 = null;
    int i = 0;
    int n = 0;
    boolean bool;
    int k;
    label77:
    String str5;
    if ((((e)com.tencent.mm.kernel.g.G(e.class)).getStoryBasicConfig().a(f.a.sqM)) && (com.tencent.mm.plugin.sns.e.a.ZS(paramcds.Username)))
    {
      bool = true;
      if (paramInt1 != 21) {
        break label499;
      }
      k = 3;
      str5 = bo.nullAsNil(paramcds.ntu);
      if (bo.isNullOrNil(paramString)) {
        break label1086;
      }
      com.tencent.mm.kernel.g.RM();
    }
    label516:
    label526:
    label559:
    label1080:
    label1086:
    for (Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(paramString);; localObject1 = null)
    {
      int m = i;
      label195:
      label231:
      int j;
      if (paramInt2 == 1)
      {
        if ((com.tencent.mm.plugin.sns.e.a.ZR(paramcds.Username)) && (((e)com.tencent.mm.kernel.g.G(e.class)).getStoryBasicConfig().a(f.a.sqN)) && (n.isShowStoryCheck()))
        {
          str1 = str2 + "  ";
          m = 1;
        }
      }
      else
      {
        if (!fS(paramcds.xOc, 1)) {
          break label559;
        }
        if (localObject1 == null) {
          break label526;
        }
        if ((localObject1 != null) && (!TextUtils.isEmpty(((ad)localObject1).Of()))) {
          break label516;
        }
        localObject1 = paramString;
        str1 = str1 + paramContext.getString(2131303777);
        i = str1.length();
        str1 = str1 + (String)localObject1;
        str1 = "" + str1 + ": ";
        j = 0;
        localObject2 = localObject1;
        localObject1 = str3;
      }
      for (;;)
      {
        paramContext = com.tencent.mm.pluginsdk.ui.d.j.a(paramContext, str1 + str5, com.tencent.mm.cb.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.cb.a.dr(paramContext))), 2, bool);
        if (paramInt1 != 21) {
          break label987;
        }
        paramInt1 = 3;
        label372:
        paramContext = new k(paramContext);
        if (paramInt2 == 1)
        {
          paramContext.a(new o(paramcds.Username, paramj, paramInt1), str2, 0);
          if (m != 0) {
            paramContext.setSpan(new g(((e)com.tencent.mm.kernel.g.G(e.class)).getStoryUIFactory().lO(true)), str2.length() + 1, str2.length() + 2, 17);
          }
        }
        if (bo.isNullOrNil(localObject2)) {
          break label992;
        }
        paramContext.a(new o(paramString, paramj, k), localObject2, i);
        label486:
        AppMethodBeat.o(40504);
        return paramContext;
        bool = false;
        break;
        label499:
        k = 2;
        break label77;
        str1 = str2;
        m = i;
        break label195;
        localObject1 = ((ad)localObject1).Of();
        break label231;
        ab.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", new Object[] { paramString });
        i = 0;
        j = 0;
        localObject1 = str3;
        str1 = str4;
        continue;
        if (!fS(paramcds.xOc, 8)) {
          break label716;
        }
        str3 = ((b)com.tencent.mm.kernel.g.E(b.class)).nE(paramcds.xOr);
        localObject1 = str1;
        if (!bo.isNullOrNil(str1)) {
          localObject1 = str1 + ": ";
        }
        str1 = (String)localObject1 + paramContext.getString(2131303777);
        j = str1.length();
        str1 = str1 + str3;
        str1 = "" + str1 + " ";
        i = 0;
        localObject1 = str3;
      }
      label716:
      if (!bo.isNullOrNil(paramcds.xOr))
      {
        localObject1 = ag.coT().arv(paramcds.xOr);
        if (localObject1 == null)
        {
          localObject1 = paramcds.xOr;
          label751:
          if ((!com.tencent.mm.plugin.sns.e.a.ZR(paramcds.xOr)) || (!((e)com.tencent.mm.kernel.g.G(e.class)).getStoryBasicConfig().a(f.a.sqN)) || (!n.isShowStoryCheck())) {
            break label1080;
          }
          localObject1 = (String)localObject1 + "  ";
        }
      }
      for (i = 1;; i = 0)
      {
        str1 = str1 + paramContext.getString(2131303938);
        j = str1.length();
        str1 = str1 + (String)localObject1;
        str1 = "" + str1 + ": ";
        n = i;
        i = 0;
        break;
        localObject1 = ((ad)localObject1).Of();
        break label751;
        localObject1 = str1;
        if (!bo.isNullOrNil(str1)) {
          localObject1 = str1 + ": ";
        }
        str1 = "" + (String)localObject1;
        i = 0;
        j = 0;
        localObject1 = str3;
        break;
        label987:
        paramInt1 = 2;
        break label372;
        label992:
        if (bo.isNullOrNil((String)localObject1)) {
          break label486;
        }
        paramContext.a(new o(paramcds.xOr, paramj, k), (CharSequence)localObject1, j);
        if (n == 0) {
          break label486;
        }
        paramContext.setSpan(new g(((e)com.tencent.mm.kernel.g.G(e.class)).getStoryUIFactory().lO(true)), ((String)localObject1).length() + j - 1, ((String)localObject1).length() + j, 17);
        break label486;
      }
    }
  }
  
  public static boolean fS(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */