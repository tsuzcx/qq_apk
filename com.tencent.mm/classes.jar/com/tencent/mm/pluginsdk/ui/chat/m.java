package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.k;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ph;
import com.tencent.mm.emoji.c.c.d;
import com.tencent.mm.emoji.c.c.j.b;
import com.tencent.mm.emoji.c.c.l;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.plugin.m.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.base.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  public m.a IqP;
  v Jkn;
  private String Jkr;
  final ArrayList<l> YkA;
  c YkB;
  private com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> YkC;
  ph YkD;
  int YkE;
  b YkF;
  private RecyclerView.k YkG;
  int Yku;
  int Ykv;
  public View Ykw;
  public j Ykx;
  public boolean Yky;
  RecyclerView Ykz;
  private RecyclerView.l bVV;
  private View mContentView;
  Context mContext;
  MMHandler mHandler;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(104700);
    this.Jkr = "";
    this.Yky = true;
    this.YkA = new ArrayList();
    this.YkD = new ph();
    this.YkE = 0;
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(104690);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(104690);
          return;
          paramAnonymousMessage = m.this;
          Log.i("MicroMsg.emoji.SuggestEmoticonBubble", "show: %s", new Object[] { Boolean.valueOf(paramAnonymousMessage.Yky) });
          paramAnonymousMessage.mHandler.removeMessages(20001);
          Object localObject1;
          int i;
          if (paramAnonymousMessage.Yky)
          {
            localObject1 = paramAnonymousMessage.YkB;
            Object localObject2 = paramAnonymousMessage.YkA;
            ((m.c)localObject1).xWZ.clear();
            ((m.c)localObject1).xWZ.addAll((Collection)localObject2);
            ((RecyclerView.a)localObject1).bZE.notifyChanged();
            localObject1 = paramAnonymousMessage.Ykz;
            localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            if (paramAnonymousMessage.YkA.size() <= 2) {
              break label317;
            }
            i = (int)(paramAnonymousMessage.Yku * 2.5F) + paramAnonymousMessage.Ykv * 2;
            if (!paramAnonymousMessage.Jkn.isShowing()) {
              break label360;
            }
            paramAnonymousMessage.Jkn.update(i, -2);
            label247:
            if (paramAnonymousMessage.YkA.size() < 3) {
              break label450;
            }
            paramAnonymousMessage.mHandler.sendEmptyMessageDelayed(20001, 5000L);
          }
          for (;;)
          {
            paramAnonymousMessage.Z(paramAnonymousMessage.YkA, paramAnonymousMessage.YkE);
            paramAnonymousMessage.YkD.ioV = 0L;
            paramAnonymousMessage.YkD.bMH();
            paramAnonymousMessage.YkE = paramAnonymousMessage.YkA.size();
            AppMethodBeat.o(104690);
            return;
            label317:
            if (paramAnonymousMessage.YkA.size() == 2)
            {
              i = paramAnonymousMessage.Yku * 2 + paramAnonymousMessage.Ykv * 2;
              break;
            }
            i = paramAnonymousMessage.Yku + paramAnonymousMessage.Ykv * 2;
            break;
            label360:
            paramAnonymousMessage.Jkn.setWidth(i);
            if (paramAnonymousMessage.Ykw == null) {
              break label247;
            }
            localObject1 = new int[2];
            paramAnonymousMessage.Ykw.getLocationInWindow((int[])localObject1);
            i = localObject1[0];
            int j = (paramAnonymousMessage.Jkn.getWidth() - paramAnonymousMessage.Ykw.getWidth()) / 2;
            int k = localObject1[1];
            int m = paramAnonymousMessage.Jkn.getHeight();
            paramAnonymousMessage.Jkn.showAtLocation(paramAnonymousMessage.Ykw, 0, i - j, k - m);
            break label247;
            label450:
            paramAnonymousMessage.mHandler.sendEmptyMessageDelayed(20001, 3000L);
          }
          m.this.hide();
          AppMethodBeat.o(104690);
          return;
          removeMessages(20001);
        }
      }
    };
    this.YkF = new b()
    {
      public final void a(int paramAnonymousInt, l paramAnonymousl)
      {
        AppMethodBeat.i(245415);
        if ((paramAnonymousl != null) && (m.this.Ykx != null) && (m.this.IqP != null))
        {
          EmojiInfo localEmojiInfo = paramAnonymousl.mgK;
          if (bl.jba().adju.bza(localEmojiInfo.field_md5) == null) {
            bl.jba().adju.L(localEmojiInfo);
          }
          m.this.Ykx.o(localEmojiInfo);
          m.this.IqP.clear();
          m.this.Z(Collections.singletonList(paramAnonymousl), 0);
          m.this.YkD.iMe = paramAnonymousInt;
          m.this.YkD.ioV = 1L;
          m.this.YkD.bMH();
          m.this.YkD.iMe = 0L;
        }
        m.this.Jkn.dismiss();
        AppMethodBeat.o(245415);
      }
    };
    this.YkG = new m.3(this);
    this.bVV = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(245422);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          m.this.Z(null, 0);
          m.this.YkD.ioV = 2L;
          m.this.YkD.bMH();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(245422);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(245425);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(245425);
      }
    };
    this.mContext = paramContext;
    this.YkC = new com.tencent.mm.vending.e.c();
    this.mContentView = View.inflate(this.mContext, a.h.chatting_footer_suggest_emoticon_bubble, null);
    this.Ykz = ((RecyclerView)this.mContentView.findViewById(a.g.suggest_list_view));
    this.Ykz.setLayoutManager(new LinearLayoutManager(0, false));
    this.YkB = new c();
    this.Ykz.setAdapter(this.YkB);
    this.Ykz.a(this.YkG);
    this.Ykz.a(this.bVV);
    this.Yku = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 102);
    this.Ykv = com.tencent.mm.cd.a.br(this.mContext, a.e.Edge_1_5_A);
    this.Jkn = new v(this.mContentView, this.Yku + this.Ykv * 2, this.Yku + this.Ykv * 2, true);
    this.Jkn.setBackgroundDrawable(new ColorDrawable(0));
    this.Jkn.setOutsideTouchable(true);
    this.Jkn.setFocusable(false);
    this.Jkn.setAnimationStyle(a.k.PopRightBottomAnimation);
    AppMethodBeat.o(104700);
  }
  
  final void Z(List<l> paramList, int paramInt)
  {
    AppMethodBeat.i(245433);
    StringBuilder localStringBuilder3 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramList != null)
    {
      int i = paramInt;
      while (i < paramList.size())
      {
        l locall = (l)paramList.get(i);
        if (i != paramInt)
        {
          localStringBuilder3.append("#");
          localStringBuilder2.append("#");
          localStringBuilder1.append("#");
        }
        localStringBuilder3.append(locall.mgK.field_md5);
        localStringBuilder2.append(locall.type);
        localStringBuilder1.append(locall.mkb);
        i += 1;
      }
    }
    paramList = this.YkD;
    paramList.iqw = paramList.F("md5", localStringBuilder3.toString(), true);
    paramList = this.YkD;
    paramList.jlO = paramList.F("IsLocalSearch", localStringBuilder2.toString(), true);
    paramList = this.YkD;
    paramList.jlN = paramList.F("Index", localStringBuilder1.toString(), true);
    paramList = this.YkD;
    paramList.jlL = paramList.F("Word", this.Jkr.replace(",", ""), true);
    AppMethodBeat.o(245433);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(104701);
    Log.i("MicroMsg.emoji.SuggestEmoticonBubble", "hide: ");
    if (this.Jkn == null)
    {
      AppMethodBeat.o(104701);
      return;
    }
    if (this.Jkn.isShowing()) {
      this.Jkn.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    if (this.YkC != null)
    {
      this.YkC.dead();
      this.YkC = null;
    }
    AppMethodBeat.o(104701);
  }
  
  public final void pp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(245429);
    if (Util.isNullOrNil(paramString1))
    {
      this.mHandler.removeMessages(20003);
      this.mHandler.sendEmptyMessage(20001);
      this.Jkr = paramString1;
      if (this.YkC != null)
      {
        this.YkC.dead();
        this.YkC = null;
      }
      AppMethodBeat.o(245429);
      return;
    }
    if (!paramString1.equals(this.Jkr))
    {
      hide();
      if (this.YkC != null)
      {
        this.YkC.dead();
        this.YkC = null;
      }
      this.YkC = new com.tencent.mm.vending.e.c();
      String str = String.valueOf(Util.nowMilliSecond());
      this.YkD.wJ(str);
      this.YkD.wK(paramString2);
      this.YkA.clear();
      this.YkE = 0;
      com.tencent.mm.emoji.c.c.b localb = new com.tencent.mm.emoji.c.c.b(this.YkC);
      localb.ay(paramString2, str);
      localb.a(paramString1, new j.b()
      {
        public final void a(List<l> paramAnonymousList, com.tencent.mm.emoji.c.c.m paramAnonymousm)
        {
          AppMethodBeat.i(245421);
          m.this.YkA.clear();
          m.this.YkA.addAll(paramAnonymousList);
          m.this.YkD.jlM = m.this.YkA.size();
          ph localph = m.this.YkD;
          localph.jlP = localph.F("WordVersion", String.valueOf(paramAnonymousm.mjU), true);
          m.this.YkD.jlQ = paramAnonymousm.mjT;
          m.this.YkD.jlR = paramAnonymousm.mkc;
          localph = m.this.YkD;
          localph.jlS = localph.F("RecSessionId", paramAnonymousm.mkd, true);
          if (paramAnonymousList.isEmpty())
          {
            m.this.mHandler.removeMessages(20003);
            m.this.mHandler.sendEmptyMessage(20001);
            AppMethodBeat.o(245421);
            return;
          }
          long l = Util.nowMilliSecond();
          int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRF, 250);
          Log.i("MicroMsg.emoji.SuggestEmoticonBubble", "onResult: delay show %s, %s", new Object[] { Long.valueOf(l - this.esF), Integer.valueOf(i) });
          if (l - this.esF > i)
          {
            m.this.mHandler.sendEmptyMessage(20003);
            paramAnonymousList = d.mjQ;
            d.rG(23);
            AppMethodBeat.o(245421);
            return;
          }
          m.this.mHandler.sendEmptyMessageDelayed(20003, i - (l - this.esF));
          AppMethodBeat.o(245421);
        }
      });
    }
    this.Jkr = paramString1;
    AppMethodBeat.o(245429);
  }
  
  static abstract interface b
  {
    public abstract void a(int paramInt, l paraml);
  }
  
  final class c
    extends RecyclerView.a<m.d>
  {
    LinkedList<l> xWZ;
    
    c()
    {
      AppMethodBeat.i(245445);
      this.xWZ = new LinkedList();
      AppMethodBeat.o(245445);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(245449);
      if (this.xWZ == null)
      {
        AppMethodBeat.o(245449);
        return 0;
      }
      int i = this.xWZ.size();
      AppMethodBeat.o(245449);
      return i;
    }
  }
  
  final class d
    extends RecyclerView.v
  {
    EmojiStatusView Rum;
    l YkI;
    
    d(View paramView)
    {
      super();
      AppMethodBeat.i(104699);
      this.Rum = ((EmojiStatusView)paramView.findViewById(a.g.suggest_emoticon_iv));
      this.Rum.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(245305);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          m.this.YkF.a(m.d.this.KJ(), m.d.this.YkI);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(245305);
        }
      });
      AppMethodBeat.o(104699);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m
 * JD-Core Version:    0.7.0.1
 */