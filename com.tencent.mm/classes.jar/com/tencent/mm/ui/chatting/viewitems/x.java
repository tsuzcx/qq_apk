package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.d;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.pluginsdk.ui.span.x.b;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.djt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.api.aa;
import com.tencent.mm.ui.chatting.i.a.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;

public final class x
{
  public static void a(Context paramContext, final com.tencent.mm.ui.chatting.d.a parama, String paramString, final CharSequence paramCharSequence, final MMNeat7extView paramMMNeat7extView, final cc paramcc, int paramInt)
  {
    AppMethodBeat.i(255014);
    Object localObject1 = paramCharSequence;
    if (((aa)parama.cm(aa.class)).cT(paramcc))
    {
      localObject1 = paramcc.field_solitaireFoldInfo;
      Object localObject3 = new StringBuilder();
      if (((djs)localObject1).aaPE != null)
      {
        localObject2 = ((djs)localObject1).aaPE.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (djt)((Iterator)localObject2).next();
          ((StringBuilder)localObject3).append(Util.nullAs(Util.nullAs(((djt)localObject4).aaPI, ""), "")).append(paramString.substring(((djt)localObject4).start, ((djt)localObject4).end));
        }
      }
      if (!Util.isNullOrNil(((StringBuilder)localObject3).toString())) {
        ((StringBuilder)localObject3).append("\n");
      }
      if ((!Util.isNullOrNil(((StringBuilder)localObject3).toString())) && (((djs)localObject1).Jjm == 1)) {
        ((StringBuilder)localObject3).append("\n");
      }
      Object localObject2 = com.tencent.mm.ui.chatting.i.a.aeJh;
      a.a.a(paramMMNeat7extView, paramcc, parama.juG(), parama.getSelfUserName());
      parama.getSelfUserName();
      localObject2 = bj.dG(paramcc);
      x.b.YpJ.d((Bundle)localObject2, com.tencent.mm.modelappbrand.a.KG(paramcc.field_talker));
      localObject3 = p.a(paramContext, (CharSequence)localObject3, (int)paramMMNeat7extView.getTextSize(), paramInt, localObject2, p.YoF);
      String str = paramContext.getString(R.l.gJh);
      Object localObject4 = new SpannableString(str);
      ((SpannableString)localObject4).setSpan(new t(paramInt, parama)
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(255504);
          Log.d("MicroMsg.ChattingItemAppMsgGroupSolitatire", "fold click");
          if (!((aa)parama.cm(aa.class)).cT(paramcc))
          {
            Log.i("MicroMsg.ChattingItemAppMsgGroupSolitatire", "not fold");
            AppMethodBeat.o(255504);
            return;
          }
          if (paramAnonymousView != null) {
            paramAnonymousView.setTag(R.h.fAg, Long.valueOf(System.currentTimeMillis()));
          }
          paramMMNeat7extView.a(paramCharSequence, TextView.BufferType.SPANNABLE);
          ((aa)parama.cm(aa.class)).zR(((Long)paramMMNeat7extView.getTag(R.h.fza)).longValue());
          ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          d.a(parama.getTalkerUserName(), this.aeQr);
          AppMethodBeat.o(255504);
        }
      }, 0, str.length(), 33);
      parama = new StringBuilder();
      parama.append("\n");
      if (((djs)localObject1).aaPF != null)
      {
        paramCharSequence = ((djs)localObject1).aaPF.iterator();
        while (paramCharSequence.hasNext())
        {
          paramcc = (djt)paramCharSequence.next();
          parama.append(Util.nullAs(paramcc.aaPI, "")).append(paramString.substring(paramcc.start, paramcc.end)).append("\n");
        }
      }
      if (((djs)localObject1).aaPG != null)
      {
        parama.append("\n");
        parama.append(Util.nullAs(((djs)localObject1).aaPG.aaPI, "")).append(paramString.substring(((djs)localObject1).aaPG.start, ((djs)localObject1).aaPG.end));
      }
      paramContext = p.a(paramContext, parama, (int)paramMMNeat7extView.getTextSize(), paramInt, localObject2, p.YoF);
      localObject1 = TextUtils.concat(new CharSequence[] { TextUtils.concat(new CharSequence[] { localObject3, localObject4 }), paramContext });
    }
    paramMMNeat7extView.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
    AppMethodBeat.o(255014);
  }
  
  public static boolean ly(View paramView)
  {
    AppMethodBeat.i(255017);
    if (paramView == null)
    {
      AppMethodBeat.o(255017);
      return false;
    }
    try
    {
      long l1 = ((Long)paramView.getTag(R.h.fAg)).longValue();
      long l2 = System.currentTimeMillis();
      l1 = l2 - l1;
      if ((l1 > 0L) && (l1 < 500L))
      {
        AppMethodBeat.o(255017);
        return true;
      }
    }
    catch (Exception paramView)
    {
      Log.e("MicroMsg.ChattingItemAppMsgGroupSolitatire", "checkSolitaireFoldDoubleClick Exception:%s %s", new Object[] { paramView.getClass().getSimpleName(), paramView.getMessage() });
      AppMethodBeat.o(255017);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x
 * JD-Core Version:    0.7.0.1
 */