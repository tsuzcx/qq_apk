package com.tencent.mm.ui.chatting.l;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.f.b.b;

public final class g
  extends b
{
  int jmu = -1;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public static boolean Df(int paramInt)
  {
    AppMethodBeat.i(36572);
    if ((Util.safeParseInt("1001") == paramInt) || (Util.safeParseInt("1002") == paramInt) || (419430449 == paramInt))
    {
      AppMethodBeat.o(36572);
      return true;
    }
    AppMethodBeat.o(36572);
    return false;
  }
  
  private boolean hRi()
  {
    AppMethodBeat.i(270140);
    if ((ab.Lj(this.jkq)) || (ab.PQ(this.jkq)))
    {
      AppMethodBeat.o(270140);
      return true;
    }
    AppMethodBeat.o(270140);
    return false;
  }
  
  public final RecyclerView.v V(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(270139);
    paramViewGroup = new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.egX, paramViewGroup, false));
    AppMethodBeat.o(270139);
    return paramViewGroup;
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(36578);
    parama = (b)parama;
    g.a locala = (g.a)avy(paramInt);
    if (Util.isNullOrNil(locala.desc)) {
      parama.mrM.setVisibility(8);
    }
    for (;;)
    {
      paramInt = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 6);
      parama.qps.setPadding(paramInt, paramInt, paramInt, paramInt);
      parama.qps.setImageResource(locala.iconRes);
      parama.qps.setBackgroundColor(locala.rqS);
      AppMethodBeat.o(36578);
      return;
      parama.mrM.setVisibility(0);
      parama.mrM.setText(Util.nullAs(locala.desc, ""));
    }
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(36574);
    String str = this.mContext.getString(R.l.search_chatroom_pay);
    AppMethodBeat.o(36574);
    return str;
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final void hRu()
  {
    AppMethodBeat.i(36573);
    this.WYZ.hRy();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHJ().postToWorker(new g.1(this));
    AppMethodBeat.o(36573);
  }
  
  public final c.e hRv()
  {
    AppMethodBeat.i(36576);
    c.e local2 = new c.e()
    {
      public final void a(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb)
      {
        AppMethodBeat.i(36568);
        paramAnonymousView = g.this.mContext;
        String str = g.this.jkq;
        long l = paramAnonymousb.msgId;
        if (str == null)
        {
          Log.e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
          AppMethodBeat.o(36568);
          return;
        }
        bh.beI();
        l = c.bbO().Oq(l).field_msgId;
        Log.i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", new Object[] { Long.valueOf(l) });
        if (ab.Lj(str))
        {
          bh.beI();
          if (c.bbV().Rw(str) == null)
          {
            Log.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", new Object[] { str });
            com.tencent.mm.ui.base.h.d(paramAnonymousView, paramAnonymousView.getString(R.l.eQA), paramAnonymousView.getString(R.l.tip_title), null);
            AppMethodBeat.o(36568);
          }
        }
        else
        {
          bh.beI();
          paramAnonymousb = c.bbL().RG(str);
          if ((paramAnonymousb == null) || (!d.rk(paramAnonymousb.field_type)))
          {
            if (paramAnonymousb == null) {
              Log.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", new Object[] { str });
            }
            for (;;)
            {
              com.tencent.mm.ui.base.h.d(paramAnonymousView, paramAnonymousView.getString(R.l.eQA), paramAnonymousView.getString(R.l.tip_title), null);
              AppMethodBeat.o(36568);
              return;
              Log.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", new Object[] { str });
            }
          }
        }
        paramAnonymousb = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", l);
        paramAnonymousb.setClass(paramAnonymousView, ChattingUI.class);
        paramAnonymousb = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousb);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousb.aFh(), "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)paramAnonymousb.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36568);
      }
      
      public final void b(View paramAnonymousView, int paramAnonymousInt, c.b paramAnonymousb) {}
    };
    AppMethodBeat.o(36576);
    return local2;
  }
  
  public final String hRx()
  {
    AppMethodBeat.i(36575);
    String str = this.mContext.getString(R.l.search_chatroom_pay);
    AppMethodBeat.o(36575);
    return str;
  }
  
  final class b
    extends c.a
  {
    TextView mrM;
    ImageView qps;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(36571);
      this.qps = ((ImageView)paramView.findViewById(R.h.fav_icon));
      this.mNb.setSingleLine(false);
      this.mNb.setMaxLines(2);
      this.mrM = ((TextView)paramView.findViewById(R.h.fav_detail));
      AppMethodBeat.o(36571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.g
 * JD-Core Version:    0.7.0.1
 */