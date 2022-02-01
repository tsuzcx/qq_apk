package com.tencent.mm.ui.chatting.m;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.box.d.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.b.a.a;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.Map;

public final class a
{
  public static void a(Context paramContext, CharSequence paramCharSequence, cc paramcc, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(253885);
    if (Util.isNullOrNil(paramCharSequence))
    {
      AppMethodBeat.o(253885);
      return;
    }
    String str1 = "";
    int i;
    if ((2 == paramInt) || (1 == paramInt))
    {
      str1 = com.tencent.mm.plugin.fts.a.d.We(34) + "_" + cn.bDw();
      i = 34;
    }
    for (;;)
    {
      paramCharSequence = paramCharSequence.toString();
      String str2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(paramCharSequence);
      boolean bool;
      if (!Util.isNullOrNil(str2))
      {
        bool = true;
        label101:
        a(paramcc, 2, bool, paramCharSequence, str1, paramInt);
        paramcc = new ah();
        paramcc.context = paramContext;
        paramcc.scene = i;
        paramcc.query = paramCharSequence;
        paramcc.sessionId = str1;
        paramcc.WoH = true;
        if (!paramBoolean) {
          break label349;
        }
        paramcc.WoI = true;
        paramcc.WoJ = false;
        paramcc.WoS = true;
        paramcc.WoL = com.tencent.mm.cd.a.w(paramContext, R.e.white);
        paramcc.WoM = true;
        paramcc.hVt.put("chatSearch", "1");
      }
      for (;;)
      {
        if (bool)
        {
          paramContext = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).getExposedFingerWord(str2);
          paramCharSequence = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).getMatchedFingerWord(str2, paramCharSequence);
          if (!TextUtils.isEmpty(paramContext)) {
            paramcc.WoT.put("exposedFingerWord", paramContext);
          }
          if (!TextUtils.isEmpty(paramCharSequence)) {
            paramcc.WoT.put("matchedFingerWord", paramCharSequence);
          }
        }
        ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a(paramcc);
        AppMethodBeat.o(253885);
        return;
        if ((3 != paramInt) && (4 != paramInt)) {
          break label357;
        }
        str1 = com.tencent.mm.plugin.fts.a.d.We(65) + "_" + cn.bDw();
        i = 65;
        break;
        bool = false;
        break label101;
        label349:
        paramcc.WoJ = false;
      }
      label357:
      i = 34;
    }
  }
  
  private static void a(final cc paramcc, final int paramInt1, boolean paramBoolean, String paramString1, final String paramString2, int paramInt2)
  {
    AppMethodBeat.i(253894);
    if (paramcc == null)
    {
      AppMethodBeat.o(253894);
      return;
    }
    final String str2 = paramcc.field_talker;
    final int i;
    final String str1;
    label44:
    final String str3;
    final long l;
    if (au.bwE(str2))
    {
      i = 2;
      if (!au.bwE(str2)) {
        break label168;
      }
      str1 = str2;
      str2 = l(paramcc, str2);
      paramcc = paramcc.field_msgSvrId;
      str3 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).getWordBankVersionForStat();
      l = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).getSearchDuration();
      if ((2 != paramInt2) && (1 != paramInt2)) {
        break label175;
      }
    }
    label168:
    label175:
    for (final int j = 34;; j = 65)
    {
      if (!paramBoolean) {
        break label182;
      }
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(253888);
          d.a locala = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(a.this);
          as.a(paramInt1, paramString2, j, 1, locala.vzR, str3, paramcc, i, str1, l, a.this.length(), this.aeKB, locala.vzP, locala.vzS, locala.vzQ);
          AppMethodBeat.o(253888);
        }
      });
      AppMethodBeat.o(253894);
      return;
      i = 1;
      break;
      str1 = "0";
      break label44;
    }
    label182:
    as.a(paramInt1, paramString2, j, 0, "", str3, paramcc, i, str1, l, paramString1.length(), paramInt2, "", "", -1);
    AppMethodBeat.o(253894);
  }
  
  public static void a(com.tencent.mm.ui.widget.b.a parama, final s params, Resources paramResources, CharSequence paramCharSequence, cc paramcc, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(253878);
    if ((params == null) || (parama == null) || (Util.isNullOrNil(paramCharSequence)))
    {
      AppMethodBeat.o(253878);
      return;
    }
    if (aj.aBu())
    {
      AppMethodBeat.o(253878);
      return;
    }
    params.a(0, 101, paramResources.getString(R.l.gyE), R.k.icons_filled_search_logo);
    params = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(paramCharSequence.toString());
    if ((!Util.isNullOrNil(params)) && (parama != null)) {
      parama.agjF = new a.a()
      {
        public final View a(Context paramAnonymousContext, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(253892);
          if (paramAnonymousMenuItem.getItemId() == 101)
          {
            paramAnonymousMenuItem = View.inflate(paramAnonymousContext, R.i.gmV, null);
            ((TextView)paramAnonymousMenuItem.findViewById(R.h.title)).setText(a.this.getString(R.l.gyE));
            paramAnonymousContext = (TextView)paramAnonymousMenuItem.findViewById(R.h.hotword_tv);
            Object localObject = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).getExposedFingerWord(params);
            if (TextUtils.isEmpty((CharSequence)localObject))
            {
              paramAnonymousContext.setVisibility(8);
              localObject = (MMAnimateView)paramAnonymousMenuItem.findViewById(R.h.icon);
              if (!aw.isDarkMode()) {
                break label159;
              }
            }
            label159:
            for (paramAnonymousContext = "assets:///fireWork_dark.gif";; paramAnonymousContext = "assets:///fireWork_light.gif")
            {
              ((MMAnimateView)localObject).g(y.bi(paramAnonymousContext, 0, -1), "");
              paramAnonymousContext = (com.tencent.mm.plugin.gif.d)((MMAnimateView)localObject).getDrawable();
              if (paramAnonymousContext != null) {
                paramAnonymousContext.Jhb = 2;
              }
              AppMethodBeat.o(253892);
              return paramAnonymousMenuItem;
              paramAnonymousContext.setVisibility(0);
              paramAnonymousContext.setText((CharSequence)localObject);
              break;
            }
          }
          AppMethodBeat.o(253892);
          return null;
        }
      };
    }
    if (Util.isNullOrNil(params)) {
      parama.agjF = null;
    }
    parama = "";
    if ((2 == paramInt) || (1 == paramInt)) {}
    for (parama = com.tencent.mm.plugin.fts.a.d.We(34) + "_";; parama = com.tencent.mm.plugin.fts.a.d.We(34) + "_") {
      do
      {
        parama = parama + cn.bDw();
        if (!Util.isNullOrNil(params)) {
          bool = true;
        }
        a(paramcc, 1, bool, paramCharSequence.toString(), parama, paramInt);
        AppMethodBeat.o(253878);
        return;
      } while ((3 != paramInt) && (4 != paramInt));
    }
  }
  
  private static String l(cc paramcc, String paramString)
  {
    AppMethodBeat.i(253891);
    if (paramcc == null)
    {
      AppMethodBeat.o(253891);
      return "";
    }
    String str = Util.nullAs(paramString, "");
    boolean bool = au.bwE(paramString);
    if (!bool)
    {
      AppMethodBeat.o(253891);
      return str;
    }
    if (bool)
    {
      paramcc = br.JJ(paramcc.field_content);
      if ((paramcc == null) || (paramcc.length() <= 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(253891);
      return paramcc;
      paramcc = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a
 * JD-Core Version:    0.7.0.1
 */