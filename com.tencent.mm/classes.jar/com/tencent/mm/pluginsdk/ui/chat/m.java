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
import com.tencent.mm.emoji.b.c.d;
import com.tencent.mm.emoji.b.c.j.b;
import com.tencent.mm.emoji.b.c.l;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.f.b.a.mh;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.plugin.m.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.base.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  r DqF;
  public String DqJ;
  m.a Rki;
  int Rod;
  int Roe;
  View Rof;
  j Rog;
  public boolean Roh;
  RecyclerView Roi;
  public final ArrayList<l> Roj;
  c Rok;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> Rol;
  public mh Rom;
  public int Ron;
  b Roo;
  private RecyclerView.k Rop;
  private RecyclerView.l ahp;
  private View mContentView;
  Context mContext;
  public MMHandler mHandler;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(104700);
    this.DqJ = "";
    this.Roh = true;
    this.Roj = new ArrayList();
    this.Rom = new mh();
    this.Ron = 0;
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
          Log.i("MicroMsg.emoji.SuggestEmoticonBubble", "show: %s", new Object[] { Boolean.valueOf(paramAnonymousMessage.Roh) });
          paramAnonymousMessage.mHandler.removeMessages(20001);
          Object localObject1;
          int i;
          if (paramAnonymousMessage.Roh)
          {
            localObject1 = paramAnonymousMessage.Rok;
            Object localObject2 = paramAnonymousMessage.Roj;
            ((m.c)localObject1).uOp.clear();
            ((m.c)localObject1).uOp.addAll((Collection)localObject2);
            ((RecyclerView.a)localObject1).alc.notifyChanged();
            localObject1 = paramAnonymousMessage.Roi;
            localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            if (paramAnonymousMessage.Roj.size() <= 2) {
              break label317;
            }
            i = (int)(paramAnonymousMessage.Rod * 2.5F) + paramAnonymousMessage.Roe * 2;
            if (!paramAnonymousMessage.DqF.isShowing()) {
              break label360;
            }
            paramAnonymousMessage.DqF.update(i, -2);
            label247:
            if (paramAnonymousMessage.Roj.size() < 3) {
              break label450;
            }
            paramAnonymousMessage.mHandler.sendEmptyMessageDelayed(20001, 5000L);
          }
          for (;;)
          {
            paramAnonymousMessage.H(paramAnonymousMessage.Roj, paramAnonymousMessage.Ron);
            paramAnonymousMessage.Rom.giq = 0L;
            paramAnonymousMessage.Rom.bpa();
            paramAnonymousMessage.Ron = paramAnonymousMessage.Roj.size();
            AppMethodBeat.o(104690);
            return;
            label317:
            if (paramAnonymousMessage.Roj.size() == 2)
            {
              i = paramAnonymousMessage.Rod * 2 + paramAnonymousMessage.Roe * 2;
              break;
            }
            i = paramAnonymousMessage.Rod + paramAnonymousMessage.Roe * 2;
            break;
            label360:
            paramAnonymousMessage.DqF.setWidth(i);
            if (paramAnonymousMessage.Rof == null) {
              break label247;
            }
            localObject1 = new int[2];
            paramAnonymousMessage.Rof.getLocationInWindow((int[])localObject1);
            i = localObject1[0];
            int j = (paramAnonymousMessage.DqF.getWidth() - paramAnonymousMessage.Rof.getWidth()) / 2;
            int k = localObject1[1];
            int m = paramAnonymousMessage.DqF.getHeight();
            paramAnonymousMessage.DqF.showAtLocation(paramAnonymousMessage.Rof, 0, i - j, k - m);
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
    this.Roo = new b()
    {
      public final void a(int paramAnonymousInt, l paramAnonymousl)
      {
        AppMethodBeat.i(222910);
        if ((paramAnonymousl != null) && (m.this.Rog != null) && (m.this.Rki != null))
        {
          EmojiInfo localEmojiInfo = paramAnonymousl.jHh;
          if (bj.hyV().VFH.bxK(localEmojiInfo.field_md5) == null) {
            bj.hyV().VFH.L(localEmojiInfo);
          }
          m.this.Rog.o(localEmojiInfo);
          m.this.Rki.clear();
          m.this.H(Collections.singletonList(paramAnonymousl), 0);
          m.this.Rom.gzP = paramAnonymousInt;
          m.this.Rom.giq = 1L;
          m.this.Rom.bpa();
          m.this.Rom.gzP = 0L;
        }
        m.this.DqF.dismiss();
        AppMethodBeat.o(222910);
      }
    };
    this.Rop = new m.3(this);
    this.ahp = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(228644);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          m.this.H(null, 0);
          m.this.Rom.giq = 2L;
          m.this.Rom.bpa();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(228644);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(228646);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt1);
        localb.sg(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(228646);
      }
    };
    this.mContext = paramContext;
    this.Rol = new com.tencent.mm.vending.e.c();
    this.mContentView = View.inflate(this.mContext, a.h.chatting_footer_suggest_emoticon_bubble, null);
    this.Roi = ((RecyclerView)this.mContentView.findViewById(a.g.suggest_list_view));
    this.Roi.setLayoutManager(new LinearLayoutManager(0, false));
    this.Rok = new c();
    this.Roi.setAdapter(this.Rok);
    this.Roi.a(this.Rop);
    this.Roi.a(this.ahp);
    this.Rod = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 102);
    this.Roe = com.tencent.mm.ci.a.aY(this.mContext, a.e.Edge_1_5_A);
    this.DqF = new r(this.mContentView, this.Rod + this.Roe * 2, this.Rod + this.Roe * 2, true);
    this.DqF.setBackgroundDrawable(new ColorDrawable(0));
    this.DqF.setOutsideTouchable(true);
    this.DqF.setFocusable(false);
    this.DqF.setAnimationStyle(a.k.PopRightBottomAnimation);
    AppMethodBeat.o(104700);
  }
  
  final void H(List<l> paramList, int paramInt)
  {
    AppMethodBeat.i(225728);
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
        localStringBuilder3.append(locall.jHh.field_md5);
        localStringBuilder2.append(locall.type);
        localStringBuilder1.append(locall.jKP);
        i += 1;
      }
    }
    paramList = this.Rom;
    paramList.gFT = paramList.z("md5", localStringBuilder3.toString(), true);
    paramList = this.Rom;
    paramList.gTt = paramList.z("IsLocalSearch", localStringBuilder2.toString(), true);
    paramList = this.Rom;
    paramList.gTr = paramList.z("Index", localStringBuilder1.toString(), true);
    paramList = this.Rom;
    paramList.gTp = paramList.z("Word", this.DqJ.replace(",", ""), true);
    AppMethodBeat.o(225728);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(104701);
    Log.i("MicroMsg.emoji.SuggestEmoticonBubble", "hide: ");
    if (this.DqF == null)
    {
      AppMethodBeat.o(104701);
      return;
    }
    if (this.DqF.isShowing()) {
      this.DqF.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    if (this.Rol != null)
    {
      this.Rol.dead();
      this.Rol = null;
    }
    AppMethodBeat.o(104701);
  }
  
  static abstract interface b
  {
    public abstract void a(int paramInt, l paraml);
  }
  
  final class c
    extends RecyclerView.a<m.d>
  {
    LinkedList<l> uOp;
    
    c()
    {
      AppMethodBeat.i(232023);
      this.uOp = new LinkedList();
      AppMethodBeat.o(232023);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(232025);
      if (this.uOp == null)
      {
        AppMethodBeat.o(232025);
        return 0;
      }
      int i = this.uOp.size();
      AppMethodBeat.o(232025);
      return i;
    }
  }
  
  final class d
    extends RecyclerView.v
  {
    EmojiStatusView KUo;
    l Ror;
    
    d(View paramView)
    {
      super();
      AppMethodBeat.i(104699);
      this.KUo = ((EmojiStatusView)paramView.findViewById(a.g.suggest_emoticon_iv));
      this.KUo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(234695);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          m.this.Roo.a(m.d.this.md(), m.d.this.Ror);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(234695);
        }
      });
      AppMethodBeat.o(104699);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m
 * JD-Core Version:    0.7.0.1
 */