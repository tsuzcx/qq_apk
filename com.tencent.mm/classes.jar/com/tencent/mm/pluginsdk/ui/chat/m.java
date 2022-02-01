package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.c.d;
import com.tencent.mm.emoji.b.c.j.b;
import com.tencent.mm.emoji.b.c.l;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.g.b.a.jy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  a Kjv;
  public jy KnA;
  public int KnB;
  b KnC;
  private RecyclerView.k KnD;
  int Knr;
  int Kns;
  View Knt;
  j Knu;
  public boolean Knv;
  RecyclerView Knw;
  public final ArrayList<l> Knx;
  c Kny;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> Knz;
  private RecyclerView.l anE;
  private View mContentView;
  Context mContext;
  public MMHandler mHandler;
  p ygD;
  public String ygH;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(104700);
    this.ygH = "";
    this.Knv = true;
    this.Knx = new ArrayList();
    this.KnA = new jy();
    this.KnB = 0;
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
          Log.i("MicroMsg.emoji.SuggestEmoticonBubble", "show: %s", new Object[] { Boolean.valueOf(paramAnonymousMessage.Knv) });
          paramAnonymousMessage.mHandler.removeMessages(20001);
          Object localObject1;
          int i;
          if (paramAnonymousMessage.Knv)
          {
            localObject1 = paramAnonymousMessage.Kny;
            Object localObject2 = paramAnonymousMessage.Knx;
            ((m.c)localObject1).rld.clear();
            ((m.c)localObject1).rld.addAll((Collection)localObject2);
            ((RecyclerView.a)localObject1).atj.notifyChanged();
            localObject1 = paramAnonymousMessage.Knw;
            localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            if (paramAnonymousMessage.Knx.size() <= 2) {
              break label317;
            }
            i = (int)(paramAnonymousMessage.Knr * 2.5F) + paramAnonymousMessage.Kns * 2;
            if (!paramAnonymousMessage.ygD.isShowing()) {
              break label360;
            }
            paramAnonymousMessage.ygD.update(i, -2);
            label247:
            if (paramAnonymousMessage.Knx.size() < 3) {
              break label450;
            }
            paramAnonymousMessage.mHandler.sendEmptyMessageDelayed(20001, 5000L);
          }
          for (;;)
          {
            paramAnonymousMessage.G(paramAnonymousMessage.Knx, paramAnonymousMessage.KnB);
            paramAnonymousMessage.KnA.enl = 0L;
            paramAnonymousMessage.KnA.bfK();
            paramAnonymousMessage.KnB = paramAnonymousMessage.Knx.size();
            AppMethodBeat.o(104690);
            return;
            label317:
            if (paramAnonymousMessage.Knx.size() == 2)
            {
              i = paramAnonymousMessage.Knr * 2 + paramAnonymousMessage.Kns * 2;
              break;
            }
            i = paramAnonymousMessage.Knr + paramAnonymousMessage.Kns * 2;
            break;
            label360:
            paramAnonymousMessage.ygD.setWidth(i);
            if (paramAnonymousMessage.Knt == null) {
              break label247;
            }
            localObject1 = new int[2];
            paramAnonymousMessage.Knt.getLocationInWindow((int[])localObject1);
            i = localObject1[0];
            int j = (paramAnonymousMessage.ygD.getWidth() - paramAnonymousMessage.Knt.getWidth()) / 2;
            int k = localObject1[1];
            int m = paramAnonymousMessage.ygD.getHeight();
            paramAnonymousMessage.ygD.showAtLocation(paramAnonymousMessage.Knt, 0, i - j, k - m);
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
    this.KnC = new b()
    {
      public final void a(int paramAnonymousInt, l paramAnonymousl)
      {
        AppMethodBeat.i(199794);
        if ((paramAnonymousl != null) && (m.this.Knu != null) && (m.this.Kjv != null))
        {
          EmojiInfo localEmojiInfo = paramAnonymousl.gWm;
          if (bj.gCJ().OpN.blk(localEmojiInfo.field_md5) == null) {
            bj.gCJ().OpN.K(localEmojiInfo);
          }
          m.this.Knu.B(localEmojiInfo);
          m.this.Kjv.clear();
          m.this.G(Collections.singletonList(paramAnonymousl), 0);
          m.this.KnA.eDd = paramAnonymousInt;
          m.this.KnA.enl = 1L;
          m.this.KnA.bfK();
          m.this.KnA.eDd = 0L;
        }
        m.this.ygD.dismiss();
        AppMethodBeat.o(199794);
      }
    };
    this.KnD = new RecyclerView.k()
    {
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(199795);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(199795);
          return false;
          m.this.mHandler.sendEmptyMessage(20002);
          continue;
          m.this.mHandler.sendEmptyMessageDelayed(20001, 3000L);
        }
      }
      
      public final void ah(boolean paramAnonymousBoolean) {}
      
      public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(199796);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$3", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$3", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(199796);
      }
    };
    this.anE = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(199797);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          m.this.G(null, 0);
          m.this.KnA.enl = 2L;
          m.this.KnA.bfK();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(199797);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(199798);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(199798);
      }
    };
    this.mContext = paramContext;
    this.Knz = new com.tencent.mm.vending.e.c();
    this.mContentView = View.inflate(this.mContext, 2131493497, null);
    this.Knw = ((RecyclerView)this.mContentView.findViewById(2131308761));
    this.Knw.setLayoutManager(new LinearLayoutManager(0, false));
    this.Kny = new c();
    this.Knw.setAdapter(this.Kny);
    this.Knw.a(this.KnD);
    this.Knw.a(this.anE);
    this.Knr = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 102);
    this.Kns = com.tencent.mm.cb.a.aG(this.mContext, 2131165289);
    this.ygD = new p(this.mContentView, this.Knr + this.Kns * 2, this.Knr + this.Kns * 2, true);
    this.ygD.setBackgroundDrawable(new ColorDrawable(0));
    this.ygD.setOutsideTouchable(true);
    this.ygD.setFocusable(false);
    this.ygD.setAnimationStyle(2131821257);
    AppMethodBeat.o(104700);
  }
  
  final void G(List<l> paramList, int paramInt)
  {
    AppMethodBeat.i(199805);
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
        localStringBuilder3.append(locall.gWm.field_md5);
        localStringBuilder2.append(locall.type);
        localStringBuilder1.append(locall.gZO);
        i += 1;
      }
    }
    paramList = this.KnA;
    paramList.eHs = paramList.x("md5", localStringBuilder3.toString(), true);
    paramList = this.KnA;
    paramList.eSY = paramList.x("IsLocalSearch", localStringBuilder2.toString(), true);
    paramList = this.KnA;
    paramList.eSW = paramList.x("Index", localStringBuilder1.toString(), true);
    paramList = this.KnA;
    paramList.eSU = paramList.x("Word", this.ygH.replace(",", ""), true);
    AppMethodBeat.o(199805);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(104701);
    Log.i("MicroMsg.emoji.SuggestEmoticonBubble", "hide: ");
    if (this.ygD == null)
    {
      AppMethodBeat.o(104701);
      return;
    }
    if (this.ygD.isShowing()) {
      this.ygD.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    if (this.Knz != null)
    {
      this.Knz.dead();
      this.Knz = null;
    }
    AppMethodBeat.o(104701);
  }
  
  public static abstract interface a
  {
    public abstract void clear();
  }
  
  static abstract interface b
  {
    public abstract void a(int paramInt, l paraml);
  }
  
  final class c
    extends RecyclerView.a<m.d>
  {
    LinkedList<l> rld;
    
    c()
    {
      AppMethodBeat.i(199800);
      this.rld = new LinkedList();
      AppMethodBeat.o(199800);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(199801);
      if (this.rld == null)
      {
        AppMethodBeat.o(199801);
        return 0;
      }
      int i = this.rld.size();
      AppMethodBeat.o(199801);
      return i;
    }
  }
  
  final class d
    extends RecyclerView.v
  {
    EmojiStatusView EGu;
    l KnF;
    
    d(View paramView)
    {
      super();
      AppMethodBeat.i(104699);
      this.EGu = ((EmojiStatusView)paramView.findViewById(2131308760));
      this.EGu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199804);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          m.this.KnC.a(m.d.this.lR(), m.d.this.KnF);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(199804);
        }
      });
      AppMethodBeat.o(104699);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m
 * JD-Core Version:    0.7.0.1
 */