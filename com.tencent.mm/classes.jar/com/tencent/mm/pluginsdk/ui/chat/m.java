package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.c.d;
import com.tencent.mm.emoji.a.c.j.b;
import com.tencent.mm.emoji.a.c.l;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  a FsB;
  public boolean FwA;
  RecyclerView FwB;
  public final ArrayList<l> FwC;
  c FwD;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> FwE;
  public gk FwF;
  public int FwG;
  b FwH;
  private RecyclerView.l FwI;
  int Fww;
  int Fwx;
  View Fwy;
  j Fwz;
  private RecyclerView.m ans;
  private View mContentView;
  Context mContext;
  public aq mHandler;
  o uOg;
  public String uOk;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(104700);
    this.uOk = "";
    this.FwA = true;
    this.FwC = new ArrayList();
    this.FwF = new gk();
    this.FwG = 0;
    this.mHandler = new aq()
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
          ae.i("MicroMsg.emoji.SuggestEmoticonBubble", "show: %s", new Object[] { Boolean.valueOf(paramAnonymousMessage.FwA) });
          paramAnonymousMessage.mHandler.removeMessages(20001);
          Object localObject1;
          int i;
          if (paramAnonymousMessage.FwA)
          {
            localObject1 = paramAnonymousMessage.FwD;
            Object localObject2 = paramAnonymousMessage.FwC;
            ((m.c)localObject1).pUe.clear();
            ((m.c)localObject1).pUe.addAll((Collection)localObject2);
            ((RecyclerView.a)localObject1).asY.notifyChanged();
            localObject1 = paramAnonymousMessage.FwB;
            localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            if (paramAnonymousMessage.FwC.size() <= 2) {
              break label317;
            }
            i = (int)(paramAnonymousMessage.Fww * 2.5F) + paramAnonymousMessage.Fwx * 2;
            if (!paramAnonymousMessage.uOg.isShowing()) {
              break label360;
            }
            paramAnonymousMessage.uOg.update(i, -2);
            label247:
            if (paramAnonymousMessage.FwC.size() < 3) {
              break label450;
            }
            paramAnonymousMessage.mHandler.sendEmptyMessageDelayed(20001, 5000L);
          }
          for (;;)
          {
            paramAnonymousMessage.A(paramAnonymousMessage.FwC, paramAnonymousMessage.FwG);
            paramAnonymousMessage.FwF.dTq = 0L;
            paramAnonymousMessage.FwF.aLH();
            paramAnonymousMessage.FwG = paramAnonymousMessage.FwC.size();
            AppMethodBeat.o(104690);
            return;
            label317:
            if (paramAnonymousMessage.FwC.size() == 2)
            {
              i = paramAnonymousMessage.Fww * 2 + paramAnonymousMessage.Fwx * 2;
              break;
            }
            i = paramAnonymousMessage.Fww + paramAnonymousMessage.Fwx * 2;
            break;
            label360:
            paramAnonymousMessage.uOg.setWidth(i);
            if (paramAnonymousMessage.Fwy == null) {
              break label247;
            }
            localObject1 = new int[2];
            paramAnonymousMessage.Fwy.getLocationInWindow((int[])localObject1);
            i = localObject1[0];
            int j = (paramAnonymousMessage.uOg.getWidth() - paramAnonymousMessage.Fwy.getWidth()) / 2;
            int k = localObject1[1];
            int m = paramAnonymousMessage.uOg.getHeight();
            paramAnonymousMessage.uOg.showAtLocation(paramAnonymousMessage.Fwy, 0, i - j, k - m);
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
    this.FwH = new b()
    {
      public final void a(int paramAnonymousInt, l paramAnonymousl)
      {
        AppMethodBeat.i(188505);
        if ((paramAnonymousl != null) && (m.this.Fwz != null) && (m.this.FsB != null))
        {
          EmojiInfo localEmojiInfo = paramAnonymousl.glt;
          if (be.fvc().JfU.aWl(localEmojiInfo.field_md5) == null) {
            be.fvc().JfU.J(localEmojiInfo);
          }
          m.this.Fwz.A(localEmojiInfo);
          m.this.FsB.clear();
          m.this.A(Collections.singletonList(paramAnonymousl), 0);
          m.this.FwF.ecC = paramAnonymousInt;
          m.this.FwF.dTq = 1L;
          m.this.FwF.aLH();
          m.this.FwF.ecC = 0L;
        }
        m.this.uOg.dismiss();
        AppMethodBeat.o(188505);
      }
    };
    this.FwI = new RecyclerView.l()
    {
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(188506);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(188506);
          return false;
          m.this.mHandler.sendEmptyMessage(20002);
          continue;
          m.this.mHandler.sendEmptyMessageDelayed(20001, 3000L);
        }
      }
      
      public final void ai(boolean paramAnonymousBoolean) {}
      
      public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(188507);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$3", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.ahF());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$3", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(188507);
      }
    };
    this.ans = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(188509);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt1);
        localb.mu(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(188509);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(188508);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          m.this.A(null, 0);
          m.this.FwF.dTq = 2L;
          m.this.FwF.aLH();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(188508);
      }
    };
    this.mContext = paramContext;
    this.FwE = new com.tencent.mm.vending.e.c();
    this.mContentView = View.inflate(this.mContext, 2131493403, null);
    this.FwB = ((RecyclerView)this.mContentView.findViewById(2131305540));
    this.FwB.setLayoutManager(new LinearLayoutManager(0));
    this.FwD = new c();
    this.FwB.setAdapter(this.FwD);
    this.FwB.a(this.FwI);
    this.FwB.a(this.ans);
    this.Fww = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 102);
    this.Fwx = com.tencent.mm.cb.a.ax(this.mContext, 2131165284);
    this.uOg = new o(this.mContentView, this.Fww + this.Fwx * 2, this.Fww + this.Fwx * 2, true);
    this.uOg.setBackgroundDrawable(new ColorDrawable(0));
    this.uOg.setOutsideTouchable(true);
    this.uOg.setFocusable(false);
    this.uOg.setAnimationStyle(2131821219);
    AppMethodBeat.o(104700);
  }
  
  final void A(List<l> paramList, int paramInt)
  {
    AppMethodBeat.i(188516);
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
        localStringBuilder3.append(locall.glt.field_md5);
        localStringBuilder2.append(locall.type);
        localStringBuilder1.append(locall.goV);
        i += 1;
      }
    }
    paramList = this.FwF;
    paramList.efV = paramList.t("md5", localStringBuilder3.toString(), true);
    paramList = this.FwF;
    paramList.epu = paramList.t("IsLocalSearch", localStringBuilder2.toString(), true);
    paramList = this.FwF;
    paramList.eps = paramList.t("Index", localStringBuilder1.toString(), true);
    paramList = this.FwF;
    paramList.epq = paramList.t("Word", this.uOk.replace(",", ""), true);
    AppMethodBeat.o(188516);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(104701);
    ae.i("MicroMsg.emoji.SuggestEmoticonBubble", "hide: ");
    if (this.uOg == null)
    {
      AppMethodBeat.o(104701);
      return;
    }
    if (this.uOg.isShowing()) {
      this.uOg.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    if (this.FwE != null)
    {
      this.FwE.dead();
      this.FwE = null;
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
    LinkedList<l> pUe;
    
    c()
    {
      AppMethodBeat.i(188511);
      this.pUe = new LinkedList();
      AppMethodBeat.o(188511);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(188512);
      if (this.pUe == null)
      {
        AppMethodBeat.o(188512);
        return 0;
      }
      int i = this.pUe.size();
      AppMethodBeat.o(188512);
      return i;
    }
  }
  
  final class d
    extends RecyclerView.w
  {
    EmojiStatusView Axe;
    l FwK;
    
    d(View paramView)
    {
      super();
      AppMethodBeat.i(104699);
      this.Axe = ((EmojiStatusView)paramView.findViewById(2131305539));
      this.Axe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(188515);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          m.this.FwH.a(m.d.this.lN(), m.d.this.FwK);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(188515);
        }
      });
      AppMethodBeat.o(104699);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m
 * JD-Core Version:    0.7.0.1
 */