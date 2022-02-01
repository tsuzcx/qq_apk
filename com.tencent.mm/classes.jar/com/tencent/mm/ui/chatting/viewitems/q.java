package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cy;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.t;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.LinkedList;

public final class q
{
  public static void a(Context paramContext, final a parama, String paramString, final CharSequence paramCharSequence, final MMNeat7extView paramMMNeat7extView, final bl parambl, int paramInt)
  {
    AppMethodBeat.i(191637);
    Object localObject1 = paramCharSequence;
    if (((t)parama.be(t.class)).bG(parambl))
    {
      localObject1 = parambl.field_solitaireFoldInfo;
      Object localObject2 = new StringBuilder();
      if (((bmk)localObject1).DJP != null)
      {
        localObject3 = ((bmk)localObject1).DJP.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bml)((Iterator)localObject3).next();
          ((StringBuilder)localObject2).append(bt.by(bt.by(((bml)localObject4).DJT, ""), "")).append(paramString.substring(((bml)localObject4).start, ((bml)localObject4).end));
        }
      }
      if (!bt.isNullOrNil(((StringBuilder)localObject2).toString())) {
        ((StringBuilder)localObject2).append("\n");
      }
      if ((!bt.isNullOrNil(((StringBuilder)localObject2).toString())) && (((bmk)localObject1).sqY == 1)) {
        ((StringBuilder)localObject2).append("\n");
      }
      localObject2 = k.a(paramContext, (CharSequence)localObject2, (int)paramMMNeat7extView.getTextSize(), paramInt);
      Object localObject4 = paramContext.getString(2131763114);
      Object localObject3 = new SpannableString((CharSequence)localObject4);
      ((SpannableString)localObject3).setSpan(new o(paramInt, parama)
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(191635);
          ad.d("MicroMsg.ChattingItemAppMsgGroupSolitatire", "fold click");
          if (!((t)parama.be(t.class)).bG(parambl))
          {
            ad.i("MicroMsg.ChattingItemAppMsgGroupSolitatire", "not fold");
            AppMethodBeat.o(191635);
            return;
          }
          if (paramAnonymousView != null) {
            paramAnonymousView.setTag(2131307173, Long.valueOf(System.currentTimeMillis()));
          }
          paramMMNeat7extView.a(paramCharSequence, TextView.BufferType.SPANNABLE);
          ((t)parama.be(t.class)).wD(((Long)paramMMNeat7extView.getTag(2131298134)).longValue());
          ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          paramAnonymousView = parama.getTalkerUserName();
          bmk localbmk = this.GLA;
          cy localcy = new cy();
          localcy.dGR = localcy.t("ChatName", paramAnonymousView, true);
          localcy.dSK = localbmk.drA;
          localcy.dSO = localcy.t("Identifier", localbmk.key, true);
          localcy.dTa = localbmk.DJQ.size();
          localcy.dTb = localbmk.DJS;
          localcy.aBj();
          AppMethodBeat.o(191635);
        }
      }, 0, ((String)localObject4).length(), 33);
      parama = new StringBuilder();
      parama.append("\n");
      if (((bmk)localObject1).DJQ != null)
      {
        paramCharSequence = ((bmk)localObject1).DJQ.iterator();
        while (paramCharSequence.hasNext())
        {
          parambl = (bml)paramCharSequence.next();
          parama.append(bt.by(parambl.DJT, "")).append(paramString.substring(parambl.start, parambl.end)).append("\n");
        }
      }
      if (((bmk)localObject1).DJR != null)
      {
        parama.append("\n");
        parama.append(bt.by(((bmk)localObject1).DJR.DJT, "")).append(paramString.substring(((bmk)localObject1).DJR.start, ((bmk)localObject1).DJR.end));
      }
      paramContext = k.a(paramContext, parama, (int)paramMMNeat7extView.getTextSize(), paramInt);
      localObject1 = TextUtils.concat(new CharSequence[] { TextUtils.concat(new CharSequence[] { localObject2, localObject3 }), paramContext });
    }
    paramMMNeat7extView.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
    AppMethodBeat.o(191637);
  }
  
  public static boolean fR(View paramView)
  {
    AppMethodBeat.i(191638);
    if (paramView == null)
    {
      AppMethodBeat.o(191638);
      return false;
    }
    try
    {
      long l1 = ((Long)paramView.getTag(2131307173)).longValue();
      long l2 = System.currentTimeMillis();
      l1 = l2 - l1;
      if ((l1 > 0L) && (l1 < 500L))
      {
        AppMethodBeat.o(191638);
        return true;
      }
    }
    catch (Exception paramView)
    {
      ad.e("MicroMsg.ChattingItemAppMsgGroupSolitatire", "checkSolitaireFoldDoubleClick Exception:%s %s", new Object[] { paramView.getClass().getSimpleName(), paramView.getMessage() });
      AppMethodBeat.o(191638);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q
 * JD-Core Version:    0.7.0.1
 */