package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.em;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.c.b.t;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;

public final class q
{
  public static void a(Context paramContext, final a parama, String paramString, final CharSequence paramCharSequence, final MMNeat7extView paramMMNeat7extView, final bo parambo, int paramInt)
  {
    AppMethodBeat.i(196703);
    Object localObject1 = paramCharSequence;
    if (((t)parama.bf(t.class)).bI(parambo))
    {
      localObject1 = parambo.field_solitaireFoldInfo;
      Object localObject2 = new StringBuilder();
      if (((bra)localObject1).Fge != null)
      {
        localObject3 = ((bra)localObject1).Fge.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (brb)((Iterator)localObject3).next();
          ((StringBuilder)localObject2).append(bs.bG(bs.bG(((brb)localObject4).Fgi, ""), "")).append(paramString.substring(((brb)localObject4).start, ((brb)localObject4).end));
        }
      }
      if (!bs.isNullOrNil(((StringBuilder)localObject2).toString())) {
        ((StringBuilder)localObject2).append("\n");
      }
      if ((!bs.isNullOrNil(((StringBuilder)localObject2).toString())) && (((bra)localObject1).tyQ == 1)) {
        ((StringBuilder)localObject2).append("\n");
      }
      localObject2 = k.a(paramContext, (CharSequence)localObject2, (int)paramMMNeat7extView.getTextSize(), paramInt);
      Object localObject4 = paramContext.getString(2131763114);
      Object localObject3 = new SpannableString((CharSequence)localObject4);
      ((SpannableString)localObject3).setSpan(new o(paramInt, parama)
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(196701);
          ac.d("MicroMsg.ChattingItemAppMsgGroupSolitatire", "fold click");
          if (!((t)parama.bf(t.class)).bI(parambo))
          {
            ac.i("MicroMsg.ChattingItemAppMsgGroupSolitatire", "not fold");
            AppMethodBeat.o(196701);
            return;
          }
          if (paramAnonymousView != null) {
            paramAnonymousView.setTag(2131307173, Long.valueOf(System.currentTimeMillis()));
          }
          paramMMNeat7extView.a(paramCharSequence, TextView.BufferType.SPANNABLE);
          ((t)parama.bf(t.class)).Bg(((Long)paramMMNeat7extView.getTag(2131298134)).longValue());
          ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          paramAnonymousView = parama.getTalkerUserName();
          bra localbra = this.Ilx;
          em localem = new em();
          localem.dEE = localem.t("ChatName", paramAnonymousView, true);
          localem.dUy = localbra.dpl;
          localem.dUC = localem.t("Identifier", localbra.key, true);
          localem.dUN = localbra.Fgf.size();
          localem.dUO = localbra.Fgh;
          localem.aHZ();
          AppMethodBeat.o(196701);
        }
      }, 0, ((String)localObject4).length(), 33);
      parama = new StringBuilder();
      parama.append("\n");
      if (((bra)localObject1).Fgf != null)
      {
        paramCharSequence = ((bra)localObject1).Fgf.iterator();
        while (paramCharSequence.hasNext())
        {
          parambo = (brb)paramCharSequence.next();
          parama.append(bs.bG(parambo.Fgi, "")).append(paramString.substring(parambo.start, parambo.end)).append("\n");
        }
      }
      if (((bra)localObject1).Fgg != null)
      {
        parama.append("\n");
        parama.append(bs.bG(((bra)localObject1).Fgg.Fgi, "")).append(paramString.substring(((bra)localObject1).Fgg.start, ((bra)localObject1).Fgg.end));
      }
      paramContext = k.a(paramContext, parama, (int)paramMMNeat7extView.getTextSize(), paramInt);
      localObject1 = TextUtils.concat(new CharSequence[] { TextUtils.concat(new CharSequence[] { localObject2, localObject3 }), paramContext });
    }
    paramMMNeat7extView.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
    AppMethodBeat.o(196703);
  }
  
  public static boolean ge(View paramView)
  {
    AppMethodBeat.i(196704);
    if (paramView == null)
    {
      AppMethodBeat.o(196704);
      return false;
    }
    try
    {
      long l1 = ((Long)paramView.getTag(2131307173)).longValue();
      long l2 = System.currentTimeMillis();
      l1 = l2 - l1;
      if ((l1 > 0L) && (l1 < 500L))
      {
        AppMethodBeat.o(196704);
        return true;
      }
    }
    catch (Exception paramView)
    {
      ac.e("MicroMsg.ChattingItemAppMsgGroupSolitatire", "checkSolitaireFoldDoubleClick Exception:%s %s", new Object[] { paramView.getClass().getSimpleName(), paramView.getMessage() });
      AppMethodBeat.o(196704);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q
 * JD-Core Version:    0.7.0.1
 */