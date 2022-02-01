package com.tencent.mm.ui.chatting.q;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.box.d.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.b.a.a;
import com.tencent.mm.vfs.u;
import java.util.Map;

public final class a
{
  public static void a(Context paramContext, CharSequence paramCharSequence, ca paramca, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(291051);
    if (Util.isNullOrNil(paramCharSequence))
    {
      AppMethodBeat.o(291051);
      return;
    }
    String str1 = "";
    int i;
    if ((2 == paramInt) || (1 == paramInt))
    {
      str1 = com.tencent.mm.plugin.fts.a.d.Sx(34) + "_" + cm.bfE();
      i = 34;
    }
    for (;;)
    {
      paramCharSequence = paramCharSequence.toString();
      String str2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(paramCharSequence);
      if (!Util.isNullOrNil(str2)) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramca, 2, bool, paramCharSequence, str1, paramInt);
        paramca = new ag();
        paramca.context = paramContext;
        paramca.scene = i;
        paramca.query = paramCharSequence;
        paramca.sessionId = str1;
        paramca.PyA = true;
        if (paramBoolean)
        {
          paramca.PyB = true;
          paramca.PyC = true;
          paramca.PyD = 1;
          paramca.PyE = com.tencent.mm.ci.a.w(paramContext, R.e.white);
          paramca.PyF = true;
          paramca.fPy.put("chatSearch", "1");
        }
        if (bool)
        {
          paramContext = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).getExposedFingerWord(str2);
          paramCharSequence = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).getMatchedFingerWord(str2, paramCharSequence);
          if (!TextUtils.isEmpty(paramContext)) {
            paramca.PyL.put("exposedFingerWord", paramContext);
          }
          if (!TextUtils.isEmpty(paramCharSequence)) {
            paramca.PyL.put("matchedFingerWord", paramCharSequence);
          }
        }
        ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a(paramca);
        AppMethodBeat.o(291051);
        return;
        if ((3 != paramInt) && (4 != paramInt)) {
          break label349;
        }
        str1 = com.tencent.mm.plugin.fts.a.d.Sx(65) + "_" + cm.bfE();
        i = 65;
        break;
      }
      label349:
      i = 34;
    }
  }
  
  private static void a(final ca paramca, final int paramInt1, boolean paramBoolean, String paramString1, final String paramString2, int paramInt2)
  {
    AppMethodBeat.i(291053);
    if (paramca == null)
    {
      AppMethodBeat.o(291053);
      return;
    }
    final String str2 = paramca.field_talker;
    final int i;
    final String str1;
    label44:
    final String str3;
    final long l;
    if (ab.Lj(str2))
    {
      i = 2;
      if (!ab.Lj(str2)) {
        break label168;
      }
      str1 = str2;
      str2 = l(paramca, str2);
      paramca = paramca.field_msgSvrId;
      str3 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).getWordBankVersionForStat();
      l = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).getSearchDuration();
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
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(280720);
          d.a locala = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(this.val$msg);
          com.tencent.mm.plugin.websearch.api.ar.a(paramInt1, paramString2, j, 1, locala.snT, str3, paramca, i, str1, l, this.val$msg.length(), this.XaW, locala.snR, locala.snU, locala.snS);
          AppMethodBeat.o(280720);
        }
      });
      AppMethodBeat.o(291053);
      return;
      i = 1;
      break;
      str1 = "0";
      break label44;
    }
    label182:
    com.tencent.mm.plugin.websearch.api.ar.a(paramInt1, paramString2, j, 0, "", str3, paramca, i, str1, l, paramString1.length(), paramInt2, "", "", -1);
    AppMethodBeat.o(291053);
  }
  
  public static void a(com.tencent.mm.ui.widget.b.a parama, final o paramo, Resources paramResources, CharSequence paramCharSequence, ca paramca, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(291050);
    if ((paramo == null) || (parama == null) || (Util.isNullOrNil(paramCharSequence)))
    {
      AppMethodBeat.o(291050);
      return;
    }
    paramo.a(0, 101, paramResources.getString(R.l.ewe), R.k.icons_filled_search_logo);
    paramo = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(paramCharSequence.toString());
    if ((!Util.isNullOrNil(paramo)) && (parama != null)) {
      parama.Yrp = new a.a()
      {
        public final View a(Context paramAnonymousContext, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(279598);
          if (paramAnonymousMenuItem.getItemId() == 101)
          {
            paramAnonymousMenuItem = View.inflate(paramAnonymousContext, R.i.ejS, null);
            ((TextView)paramAnonymousMenuItem.findViewById(R.h.title)).setText(this.XaV.getString(R.l.ewe));
            paramAnonymousContext = (TextView)paramAnonymousMenuItem.findViewById(R.h.hotword_tv);
            Object localObject = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).getExposedFingerWord(paramo);
            if (TextUtils.isEmpty((CharSequence)localObject))
            {
              paramAnonymousContext.setVisibility(8);
              localObject = (MMAnimateView)paramAnonymousMenuItem.findViewById(R.h.icon);
              if (!com.tencent.mm.ui.ar.isDarkMode()) {
                break label159;
              }
            }
            label159:
            for (paramAnonymousContext = "assets:///fireWork_dark.gif";; paramAnonymousContext = "assets:///fireWork_light.gif")
            {
              ((MMAnimateView)localObject).g(u.aY(paramAnonymousContext, 0, -1), "");
              paramAnonymousContext = (com.tencent.mm.plugin.gif.d)((MMAnimateView)localObject).getDrawable();
              if (paramAnonymousContext != null) {
                paramAnonymousContext.Dnr = 2;
              }
              AppMethodBeat.o(279598);
              return paramAnonymousMenuItem;
              paramAnonymousContext.setVisibility(0);
              paramAnonymousContext.setText((CharSequence)localObject);
              break;
            }
          }
          AppMethodBeat.o(279598);
          return null;
        }
      };
    }
    if (Util.isNullOrNil(paramo)) {
      parama.Yrp = null;
    }
    parama = "";
    if ((2 == paramInt) || (1 == paramInt)) {}
    for (parama = com.tencent.mm.plugin.fts.a.d.Sx(34) + "_";; parama = com.tencent.mm.plugin.fts.a.d.Sx(34) + "_") {
      do
      {
        parama = parama + cm.bfE();
        if (!Util.isNullOrNil(paramo)) {
          bool = true;
        }
        a(paramca, 1, bool, paramCharSequence.toString(), parama, paramInt);
        AppMethodBeat.o(291050);
        return;
      } while ((3 != paramInt) && (4 != paramInt));
    }
  }
  
  private static String l(ca paramca, String paramString)
  {
    AppMethodBeat.i(291052);
    if (paramca == null)
    {
      AppMethodBeat.o(291052);
      return "";
    }
    String str = Util.nullAs(paramString, "");
    boolean bool = ab.Lj(paramString);
    if (!bool)
    {
      AppMethodBeat.o(291052);
      return str;
    }
    if (bool)
    {
      paramca = bq.RL(paramca.field_content);
      if ((paramca == null) || (paramca.length() <= 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(291052);
      return paramca;
      paramca = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.a
 * JD-Core Version:    0.7.0.1
 */