package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fn;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.protocal.protobuf.bwi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.d.b.v;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.textview.a.e;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
{
  public static void a(Context paramContext, final com.tencent.mm.ui.chatting.e.a parama, String paramString, final CharSequence paramCharSequence, final MMNeat7extView paramMMNeat7extView, final bv parambv, int paramInt)
  {
    AppMethodBeat.i(187768);
    Object localObject1 = paramCharSequence;
    if (((v)parama.bh(v.class)).bN(parambv))
    {
      localObject1 = parambv.field_solitaireFoldInfo;
      Object localObject2 = new StringBuilder();
      if (((bwh)localObject1).Hji != null)
      {
        localObject3 = ((bwh)localObject1).Hji.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bwi)((Iterator)localObject3).next();
          ((StringBuilder)localObject2).append(bu.bI(bu.bI(((bwi)localObject4).Hjm, ""), "")).append(paramString.substring(((bwi)localObject4).start, ((bwi)localObject4).end));
        }
      }
      if (!bu.isNullOrNil(((StringBuilder)localObject2).toString())) {
        ((StringBuilder)localObject2).append("\n");
      }
      if ((!bu.isNullOrNil(((StringBuilder)localObject2).toString())) && (((bwh)localObject1).uNe == 1)) {
        ((StringBuilder)localObject2).append("\n");
      }
      localObject2 = k.a(paramContext, (CharSequence)localObject2, (int)paramMMNeat7extView.getTextSize(), paramInt);
      Object localObject4 = paramContext.getString(2131763114);
      Object localObject3 = new SpannableString((CharSequence)localObject4);
      ((SpannableString)localObject3).setSpan(new o(paramInt, parama)
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187762);
          ae.d("MicroMsg.ChattingItemAppMsgGroupSolitatire", "fold click");
          if (!((v)parama.bh(v.class)).bN(parambv))
          {
            ae.i("MicroMsg.ChattingItemAppMsgGroupSolitatire", "not fold");
            AppMethodBeat.o(187762);
            return;
          }
          if (paramAnonymousView != null) {
            paramAnonymousView.setTag(2131307173, Long.valueOf(System.currentTimeMillis()));
          }
          paramMMNeat7extView.a(paramCharSequence, TextView.BufferType.SPANNABLE);
          ((v)parama.bh(v.class)).Eu(((Long)paramMMNeat7extView.getTag(2131298134)).longValue());
          ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          paramAnonymousView = parama.getTalkerUserName();
          bwh localbwh = this.Kyp;
          fn localfn = new fn();
          localfn.dSR = localfn.t("ChatName", paramAnonymousView, true);
          localfn.emx = localbwh.dCd;
          localfn.emB = localfn.t("Identifier", localbwh.key, true);
          localfn.emM = localbwh.Hjj.size();
          localfn.emN = localbwh.Hjl;
          localfn.aLH();
          AppMethodBeat.o(187762);
        }
      }, 0, ((String)localObject4).length(), 33);
      parama = new StringBuilder();
      parama.append("\n");
      if (((bwh)localObject1).Hjj != null)
      {
        paramCharSequence = ((bwh)localObject1).Hjj.iterator();
        while (paramCharSequence.hasNext())
        {
          parambv = (bwi)paramCharSequence.next();
          parama.append(bu.bI(parambv.Hjm, "")).append(paramString.substring(parambv.start, parambv.end)).append("\n");
        }
      }
      if (((bwh)localObject1).Hjk != null)
      {
        parama.append("\n");
        parama.append(bu.bI(((bwh)localObject1).Hjk.Hjm, "")).append(paramString.substring(((bwh)localObject1).Hjk.start, ((bwh)localObject1).Hjk.end));
      }
      paramContext = k.a(paramContext, parama, (int)paramMMNeat7extView.getTextSize(), paramInt);
      localObject1 = TextUtils.concat(new CharSequence[] { TextUtils.concat(new CharSequence[] { localObject2, localObject3 }), paramContext });
    }
    paramMMNeat7extView.a((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
    AppMethodBeat.o(187768);
  }
  
  public static boolean gA(View paramView)
  {
    AppMethodBeat.i(187769);
    if (paramView == null)
    {
      AppMethodBeat.o(187769);
      return false;
    }
    try
    {
      long l1 = ((Long)paramView.getTag(2131307173)).longValue();
      long l2 = System.currentTimeMillis();
      l1 = l2 - l1;
      if ((l1 > 0L) && (l1 < 500L))
      {
        AppMethodBeat.o(187769);
        return true;
      }
    }
    catch (Exception paramView)
    {
      ae.e("MicroMsg.ChattingItemAppMsgGroupSolitatire", "checkSolitaireFoldDoubleClick Exception:%s %s", new Object[] { paramView.getClass().getSimpleName(), paramView.getMessage() });
      AppMethodBeat.o(187769);
    }
    return false;
  }
  
  static final class d
    implements a.e
  {
    private com.tencent.mm.ui.widget.textview.a JZr;
    
    d(com.tencent.mm.ui.widget.textview.a parama)
    {
      this.JZr = parama;
    }
    
    public final void fLJ()
    {
      AppMethodBeat.i(36963);
      ae.d("OnTouchOutside", "touchOutside");
      this.JZr.fRO();
      this.JZr.LCt = true;
      this.JZr.fRR();
      this.JZr.LCs = true;
      this.JZr.fRS();
      this.JZr.fRU();
      AppMethodBeat.o(36963);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r
 * JD-Core Version:    0.7.0.1
 */