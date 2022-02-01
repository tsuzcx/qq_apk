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
import com.tencent.mm.g.b.a.fj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
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
  a DuU;
  int DyP;
  int DyQ;
  View DyR;
  j DyS;
  public boolean DyT;
  RecyclerView DyU;
  public final ArrayList<l> DyV;
  c DyW;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> DyX;
  public fj DyY;
  public int DyZ;
  b Dza;
  private RecyclerView.l Dzb;
  private RecyclerView.m alB;
  private View mContentView;
  Context mContext;
  public ao mHandler;
  o tzS;
  public String tzW;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(104700);
    this.tzW = "";
    this.DyT = true;
    this.DyV = new ArrayList();
    this.DyY = new fj();
    this.DyZ = 0;
    this.mHandler = new ao()
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
          ac.i("MicroMsg.emoji.SuggestEmoticonBubble", "show: %s", new Object[] { Boolean.valueOf(paramAnonymousMessage.DyT) });
          paramAnonymousMessage.mHandler.removeMessages(20001);
          Object localObject1;
          int i;
          if (paramAnonymousMessage.DyT)
          {
            localObject1 = paramAnonymousMessage.DyW;
            Object localObject2 = paramAnonymousMessage.DyV;
            ((m.c)localObject1).pjZ.clear();
            ((m.c)localObject1).pjZ.addAll((Collection)localObject2);
            ((RecyclerView.a)localObject1).arg.notifyChanged();
            localObject1 = paramAnonymousMessage.DyU;
            localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            if (paramAnonymousMessage.DyV.size() <= 2) {
              break label317;
            }
            i = (int)(paramAnonymousMessage.DyP * 2.5F) + paramAnonymousMessage.DyQ * 2;
            if (!paramAnonymousMessage.tzS.isShowing()) {
              break label360;
            }
            paramAnonymousMessage.tzS.update(i, -2);
            label247:
            if (paramAnonymousMessage.DyV.size() < 3) {
              break label450;
            }
            paramAnonymousMessage.mHandler.sendEmptyMessageDelayed(20001, 5000L);
          }
          for (;;)
          {
            paramAnonymousMessage.x(paramAnonymousMessage.DyV, paramAnonymousMessage.DyZ);
            paramAnonymousMessage.DyY.dFd = 0L;
            paramAnonymousMessage.DyY.aHZ();
            paramAnonymousMessage.DyZ = paramAnonymousMessage.DyV.size();
            AppMethodBeat.o(104690);
            return;
            label317:
            if (paramAnonymousMessage.DyV.size() == 2)
            {
              i = paramAnonymousMessage.DyP * 2 + paramAnonymousMessage.DyQ * 2;
              break;
            }
            i = paramAnonymousMessage.DyP + paramAnonymousMessage.DyQ * 2;
            break;
            label360:
            paramAnonymousMessage.tzS.setWidth(i);
            if (paramAnonymousMessage.DyR == null) {
              break label247;
            }
            localObject1 = new int[2];
            paramAnonymousMessage.DyR.getLocationInWindow((int[])localObject1);
            i = localObject1[0];
            int j = (paramAnonymousMessage.tzS.getWidth() - paramAnonymousMessage.DyR.getWidth()) / 2;
            int k = localObject1[1];
            int m = paramAnonymousMessage.tzS.getHeight();
            paramAnonymousMessage.tzS.showAtLocation(paramAnonymousMessage.DyR, 0, i - j, k - m);
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
    this.Dza = new b()
    {
      public final void a(int paramAnonymousInt, l paramAnonymousl)
      {
        AppMethodBeat.i(209785);
        if ((paramAnonymousl != null) && (m.this.DyS != null) && (m.this.DuU != null))
        {
          EmojiInfo localEmojiInfo = paramAnonymousl.fPB;
          if (az.faZ().GXZ.aOT(localEmojiInfo.field_md5) == null) {
            az.faZ().GXZ.K(localEmojiInfo);
          }
          m.this.DyS.B(localEmojiInfo);
          m.this.DuU.clear();
          m.this.x(Collections.singletonList(paramAnonymousl), 0);
          m.this.DyY.dMy = paramAnonymousInt;
          m.this.DyY.dFd = 1L;
          m.this.DyY.aHZ();
          m.this.DyY.dMy = 0L;
        }
        m.this.tzS.dismiss();
        AppMethodBeat.o(209785);
      }
    };
    this.Dzb = new RecyclerView.l()
    {
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(209786);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(209786);
          return false;
          m.this.mHandler.sendEmptyMessage(20002);
          continue;
          m.this.mHandler.sendEmptyMessageDelayed(20001, 3000L);
        }
      }
      
      public final void ai(boolean paramAnonymousBoolean) {}
      
      public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent) {}
    };
    this.alB = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(209788);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(209788);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(209787);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          m.this.x(null, 0);
          m.this.DyY.dFd = 2L;
          m.this.DyY.aHZ();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(209787);
      }
    };
    this.mContext = paramContext;
    this.DyX = new com.tencent.mm.vending.e.c();
    this.mContentView = View.inflate(this.mContext, 2131493403, null);
    this.DyU = ((RecyclerView)this.mContentView.findViewById(2131305540));
    this.DyU.setLayoutManager(new LinearLayoutManager(0));
    this.DyW = new c();
    this.DyU.setAdapter(this.DyW);
    this.DyU.a(this.Dzb);
    this.DyU.a(this.alB);
    this.DyP = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 102);
    this.DyQ = com.tencent.mm.cc.a.au(this.mContext, 2131165284);
    this.tzS = new o(this.mContentView, this.DyP + this.DyQ * 2, this.DyP + this.DyQ * 2, true);
    this.tzS.setBackgroundDrawable(new ColorDrawable(0));
    this.tzS.setOutsideTouchable(true);
    this.tzS.setFocusable(false);
    this.tzS.setAnimationStyle(2131821219);
    AppMethodBeat.o(104700);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(104701);
    ac.i("MicroMsg.emoji.SuggestEmoticonBubble", "hide: ");
    if (this.tzS == null)
    {
      AppMethodBeat.o(104701);
      return;
    }
    if (this.tzS.isShowing()) {
      this.tzS.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    if (this.DyX != null)
    {
      this.DyX.dead();
      this.DyX = null;
    }
    AppMethodBeat.o(104701);
  }
  
  final void x(List<l> paramList, int paramInt)
  {
    AppMethodBeat.i(209795);
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
        localStringBuilder3.append(locall.fPB.field_md5);
        localStringBuilder2.append(locall.type);
        localStringBuilder1.append(locall.fSV);
        i += 1;
      }
    }
    paramList = this.DyY;
    paramList.dPg = paramList.t("md5", localStringBuilder3.toString(), true);
    paramList = this.DyY;
    paramList.dXv = paramList.t("IsLocalSearch", localStringBuilder2.toString(), true);
    paramList = this.DyY;
    paramList.dXt = paramList.t("Index", localStringBuilder1.toString(), true);
    paramList = this.DyY;
    paramList.dXr = paramList.t("Word", this.tzW.replace(",", ""), true);
    AppMethodBeat.o(209795);
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
    LinkedList<l> pjZ;
    
    c()
    {
      AppMethodBeat.i(209790);
      this.pjZ = new LinkedList();
      AppMethodBeat.o(209790);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(209791);
      if (this.pjZ == null)
      {
        AppMethodBeat.o(209791);
        return 0;
      }
      int i = this.pjZ.size();
      AppMethodBeat.o(209791);
      return i;
    }
  }
  
  final class d
    extends RecyclerView.w
  {
    l Dzd;
    EmojiStatusView yOw;
    
    d(View paramView)
    {
      super();
      AppMethodBeat.i(104699);
      this.yOw = ((EmojiStatusView)paramView.findViewById(2131305539));
      this.yOw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(209794);
          m.this.Dza.a(m.d.this.lv(), m.d.this.Dzd);
          AppMethodBeat.o(209794);
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