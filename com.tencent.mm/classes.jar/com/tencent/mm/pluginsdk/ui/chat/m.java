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
import com.tencent.mm.emoji.a.b.d;
import com.tencent.mm.emoji.a.b.j.b;
import com.tencent.mm.emoji.a.b.l;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.g.b.a.gi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
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
  a Fad;
  int FdY;
  int FdZ;
  View Fea;
  j Feb;
  public boolean Fec;
  RecyclerView Fed;
  public final ArrayList<l> Fee;
  c Fef;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> Feg;
  public gi Feh;
  public int Fei;
  b Fej;
  private RecyclerView.l Fek;
  private RecyclerView.m ans;
  private View mContentView;
  Context mContext;
  public ap mHandler;
  o uCB;
  public String uCF;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(104700);
    this.uCF = "";
    this.Fec = true;
    this.Fee = new ArrayList();
    this.Feh = new gi();
    this.Fei = 0;
    this.mHandler = new ap()
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
          ad.i("MicroMsg.emoji.SuggestEmoticonBubble", "show: %s", new Object[] { Boolean.valueOf(paramAnonymousMessage.Fec) });
          paramAnonymousMessage.mHandler.removeMessages(20001);
          Object localObject1;
          int i;
          if (paramAnonymousMessage.Fec)
          {
            localObject1 = paramAnonymousMessage.Fef;
            Object localObject2 = paramAnonymousMessage.Fee;
            ((m.c)localObject1).pNz.clear();
            ((m.c)localObject1).pNz.addAll((Collection)localObject2);
            ((RecyclerView.a)localObject1).asY.notifyChanged();
            localObject1 = paramAnonymousMessage.Fed;
            localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            if (paramAnonymousMessage.Fee.size() <= 2) {
              break label317;
            }
            i = (int)(paramAnonymousMessage.FdY * 2.5F) + paramAnonymousMessage.FdZ * 2;
            if (!paramAnonymousMessage.uCB.isShowing()) {
              break label360;
            }
            paramAnonymousMessage.uCB.update(i, -2);
            label247:
            if (paramAnonymousMessage.Fee.size() < 3) {
              break label450;
            }
            paramAnonymousMessage.mHandler.sendEmptyMessageDelayed(20001, 5000L);
          }
          for (;;)
          {
            paramAnonymousMessage.z(paramAnonymousMessage.Fee, paramAnonymousMessage.Fei);
            paramAnonymousMessage.Feh.dSa = 0L;
            paramAnonymousMessage.Feh.aLk();
            paramAnonymousMessage.Fei = paramAnonymousMessage.Fee.size();
            AppMethodBeat.o(104690);
            return;
            label317:
            if (paramAnonymousMessage.Fee.size() == 2)
            {
              i = paramAnonymousMessage.FdY * 2 + paramAnonymousMessage.FdZ * 2;
              break;
            }
            i = paramAnonymousMessage.FdY + paramAnonymousMessage.FdZ * 2;
            break;
            label360:
            paramAnonymousMessage.uCB.setWidth(i);
            if (paramAnonymousMessage.Fea == null) {
              break label247;
            }
            localObject1 = new int[2];
            paramAnonymousMessage.Fea.getLocationInWindow((int[])localObject1);
            i = localObject1[0];
            int j = (paramAnonymousMessage.uCB.getWidth() - paramAnonymousMessage.Fea.getWidth()) / 2;
            int k = localObject1[1];
            int m = paramAnonymousMessage.uCB.getHeight();
            paramAnonymousMessage.uCB.showAtLocation(paramAnonymousMessage.Fea, 0, i - j, k - m);
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
    this.Fej = new b()
    {
      public final void a(int paramAnonymousInt, l paramAnonymousl)
      {
        AppMethodBeat.i(219026);
        if ((paramAnonymousl != null) && (m.this.Feb != null) && (m.this.Fad != null))
        {
          EmojiInfo localEmojiInfo = paramAnonymousl.gjb;
          if (bd.frc().ILn.aUK(localEmojiInfo.field_md5) == null) {
            bd.frc().ILn.J(localEmojiInfo);
          }
          m.this.Feb.B(localEmojiInfo);
          m.this.Fad.clear();
          m.this.z(Collections.singletonList(paramAnonymousl), 0);
          m.this.Feh.ebh = paramAnonymousInt;
          m.this.Feh.dSa = 1L;
          m.this.Feh.aLk();
          m.this.Feh.ebh = 0L;
        }
        m.this.uCB.dismiss();
        AppMethodBeat.o(219026);
      }
    };
    this.Fek = new RecyclerView.l()
    {
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(219027);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(219027);
          return false;
          m.this.mHandler.sendEmptyMessage(20002);
          continue;
          m.this.mHandler.sendEmptyMessageDelayed(20001, 3000L);
        }
      }
      
      public final void ai(boolean paramAnonymousBoolean) {}
      
      public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(219028);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$3", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.ahq());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$3", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(219028);
      }
    };
    this.ans = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(219030);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt1);
        localb.mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(219030);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(219029);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          m.this.z(null, 0);
          m.this.Feh.dSa = 2L;
          m.this.Feh.aLk();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(219029);
      }
    };
    this.mContext = paramContext;
    this.Feg = new com.tencent.mm.vending.e.c();
    this.mContentView = View.inflate(this.mContext, 2131493403, null);
    this.Fed = ((RecyclerView)this.mContentView.findViewById(2131305540));
    this.Fed.setLayoutManager(new LinearLayoutManager(0));
    this.Fef = new c();
    this.Fed.setAdapter(this.Fef);
    this.Fed.a(this.Fek);
    this.Fed.a(this.ans);
    this.FdY = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 102);
    this.FdZ = com.tencent.mm.cc.a.ax(this.mContext, 2131165284);
    this.uCB = new o(this.mContentView, this.FdY + this.FdZ * 2, this.FdY + this.FdZ * 2, true);
    this.uCB.setBackgroundDrawable(new ColorDrawable(0));
    this.uCB.setOutsideTouchable(true);
    this.uCB.setFocusable(false);
    this.uCB.setAnimationStyle(2131821219);
    AppMethodBeat.o(104700);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(104701);
    ad.i("MicroMsg.emoji.SuggestEmoticonBubble", "hide: ");
    if (this.uCB == null)
    {
      AppMethodBeat.o(104701);
      return;
    }
    if (this.uCB.isShowing()) {
      this.uCB.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    if (this.Feg != null)
    {
      this.Feg.dead();
      this.Feg = null;
    }
    AppMethodBeat.o(104701);
  }
  
  final void z(List<l> paramList, int paramInt)
  {
    AppMethodBeat.i(219037);
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
        localStringBuilder3.append(locall.gjb.field_md5);
        localStringBuilder2.append(locall.type);
        localStringBuilder1.append(locall.gmz);
        i += 1;
      }
    }
    paramList = this.Feh;
    paramList.eev = paramList.t("md5", localStringBuilder3.toString(), true);
    paramList = this.Feh;
    paramList.enM = paramList.t("IsLocalSearch", localStringBuilder2.toString(), true);
    paramList = this.Feh;
    paramList.enK = paramList.t("Index", localStringBuilder1.toString(), true);
    paramList = this.Feh;
    paramList.enI = paramList.t("Word", this.uCF.replace(",", ""), true);
    AppMethodBeat.o(219037);
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
    LinkedList<l> pNz;
    
    c()
    {
      AppMethodBeat.i(219032);
      this.pNz = new LinkedList();
      AppMethodBeat.o(219032);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(219033);
      if (this.pNz == null)
      {
        AppMethodBeat.o(219033);
        return 0;
      }
      int i = this.pNz.size();
      AppMethodBeat.o(219033);
      return i;
    }
  }
  
  final class d
    extends RecyclerView.w
  {
    EmojiStatusView AfS;
    l Fem;
    
    d(View paramView)
    {
      super();
      AppMethodBeat.i(104699);
      this.AfS = ((EmojiStatusView)paramView.findViewById(2131305539));
      this.AfS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(219036);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          m.this.Fej.a(m.d.this.lN(), m.d.this.Fem);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219036);
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