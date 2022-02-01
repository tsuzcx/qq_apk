package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.f.b;
import com.tencent.mm.emoji.a.b.h;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.g.b.a.du;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  a CcC;
  View CgA;
  j CgB;
  public boolean CgC;
  RecyclerView CgD;
  public final ArrayList<h> CgE;
  c CgF;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> CgG;
  public du CgH;
  public int CgI;
  b CgJ;
  private RecyclerView.l CgK;
  int Cgy;
  int Cgz;
  private RecyclerView.m akH;
  private View mContentView;
  Context mContext;
  public ap mHandler;
  o ssc;
  public String ssg;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(104700);
    this.ssg = "";
    this.CgC = true;
    this.CgE = new ArrayList();
    this.CgH = new du();
    this.CgI = 0;
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
          ad.i("MicroMsg.emoji.SuggestEmoticonBubble", "show: %s", new Object[] { Boolean.valueOf(paramAnonymousMessage.CgC) });
          paramAnonymousMessage.mHandler.removeMessages(20001);
          Object localObject;
          int i;
          if (paramAnonymousMessage.CgC)
          {
            paramAnonymousMessage.CgF.ad(paramAnonymousMessage.CgE);
            localObject = paramAnonymousMessage.CgD;
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            ((RecyclerView)localObject).ca(((Integer)locala.lS(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
            if (paramAnonymousMessage.CgE.size() <= 2) {
              break label289;
            }
            i = (int)(paramAnonymousMessage.Cgy * 2.5F) + paramAnonymousMessage.Cgz * 2;
            if (!paramAnonymousMessage.ssc.isShowing()) {
              break label332;
            }
            paramAnonymousMessage.ssc.update(i, -2);
            label219:
            if (paramAnonymousMessage.CgE.size() < 3) {
              break label422;
            }
            paramAnonymousMessage.mHandler.sendEmptyMessageDelayed(20001, 5000L);
          }
          for (;;)
          {
            paramAnonymousMessage.x(paramAnonymousMessage.CgE, paramAnonymousMessage.CgI);
            paramAnonymousMessage.CgH.dHq = 0L;
            paramAnonymousMessage.CgH.aBj();
            paramAnonymousMessage.CgI = paramAnonymousMessage.CgE.size();
            AppMethodBeat.o(104690);
            return;
            label289:
            if (paramAnonymousMessage.CgE.size() == 2)
            {
              i = paramAnonymousMessage.Cgy * 2 + paramAnonymousMessage.Cgz * 2;
              break;
            }
            i = paramAnonymousMessage.Cgy + paramAnonymousMessage.Cgz * 2;
            break;
            label332:
            paramAnonymousMessage.ssc.setWidth(i);
            if (paramAnonymousMessage.CgA == null) {
              break label219;
            }
            localObject = new int[2];
            paramAnonymousMessage.CgA.getLocationInWindow((int[])localObject);
            i = localObject[0];
            int j = (paramAnonymousMessage.ssc.getWidth() - paramAnonymousMessage.CgA.getWidth()) / 2;
            int k = localObject[1];
            int m = paramAnonymousMessage.ssc.getHeight();
            paramAnonymousMessage.ssc.showAtLocation(paramAnonymousMessage.CgA, 0, i - j, k - m);
            break label219;
            label422:
            paramAnonymousMessage.mHandler.sendEmptyMessageDelayed(20001, 3000L);
          }
          m.this.hide();
          AppMethodBeat.o(104690);
          return;
          removeMessages(20001);
        }
      }
    };
    this.CgJ = new b()
    {
      public final void a(int paramAnonymousInt, h paramAnonymoush)
      {
        AppMethodBeat.i(193422);
        if ((paramAnonymoush != null) && (m.this.CgB != null) && (m.this.CcC != null))
        {
          EmojiInfo localEmojiInfo = paramAnonymoush.fLP;
          if (aw.eLx().FyY.aJx(localEmojiInfo.field_md5) == null) {
            aw.eLx().FyY.K(localEmojiInfo);
          }
          m.this.CgB.B(localEmojiInfo);
          m.this.CcC.clear();
          m.this.x(Collections.singletonList(paramAnonymoush), 0);
          m.this.CgH.dMe = paramAnonymousInt;
          m.this.CgH.dHq = 1L;
          m.this.CgH.aBj();
          m.this.CgH.dMe = 0L;
        }
        m.this.ssc.dismiss();
        AppMethodBeat.o(193422);
      }
    };
    this.CgK = new RecyclerView.l()
    {
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(202412);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(202412);
          return false;
          m.this.mHandler.sendEmptyMessage(20002);
          continue;
          m.this.mHandler.sendEmptyMessageDelayed(20001, 3000L);
        }
      }
      
      public final void ai(boolean paramAnonymousBoolean) {}
      
      public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent) {}
    };
    this.akH = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(202413);
        b localb = new b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(202413);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(193424);
        b localb = new b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          m.this.x(null, 0);
          m.this.CgH.dHq = 2L;
          m.this.CgH.aBj();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(193424);
      }
    };
    this.mContext = paramContext;
    this.CgG = new com.tencent.mm.vending.e.c();
    this.mContentView = View.inflate(this.mContext, 2131493403, null);
    this.CgD = ((RecyclerView)this.mContentView.findViewById(2131305540));
    this.CgD.setLayoutManager(new LinearLayoutManager(0));
    this.CgF = new c();
    this.CgD.setAdapter(this.CgF);
    this.CgD.a(this.CgK);
    this.CgD.a(this.akH);
    this.Cgy = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 102);
    this.Cgz = com.tencent.mm.cd.a.ao(this.mContext, 2131165284);
    this.ssc = new o(this.mContentView, this.Cgy + this.Cgz * 2, this.Cgy + this.Cgz * 2, true);
    this.ssc.setBackgroundDrawable(new ColorDrawable(0));
    this.ssc.setOutsideTouchable(true);
    this.ssc.setFocusable(false);
    this.ssc.setAnimationStyle(2131821219);
    AppMethodBeat.o(104700);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(104701);
    ad.i("MicroMsg.emoji.SuggestEmoticonBubble", "hide: ");
    if (this.ssc == null)
    {
      AppMethodBeat.o(104701);
      return;
    }
    if (this.ssc.isShowing()) {
      this.ssc.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.CgE.clear();
    this.CgF.ad(this.CgE);
    if (this.CgG != null)
    {
      this.CgG.dead();
      this.CgG = null;
    }
    AppMethodBeat.o(104701);
  }
  
  final void x(List<h> paramList, int paramInt)
  {
    AppMethodBeat.i(193432);
    StringBuilder localStringBuilder3 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramList != null)
    {
      int i = paramInt;
      while (i < paramList.size())
      {
        h localh = (h)paramList.get(i);
        if (i != paramInt)
        {
          localStringBuilder3.append("#");
          localStringBuilder2.append("#");
          localStringBuilder1.append("#");
        }
        localStringBuilder3.append(localh.fLP.field_md5);
        localStringBuilder2.append(localh.type);
        localStringBuilder1.append(localh.fPc);
        i += 1;
      }
    }
    paramList = this.CgH;
    paramList.dNE = paramList.t("md5", localStringBuilder3.toString(), true);
    paramList = this.CgH;
    paramList.dVF = paramList.t("IsLocalSearch", localStringBuilder2.toString(), true);
    paramList = this.CgH;
    paramList.dVD = paramList.t("Index", localStringBuilder1.toString(), true);
    paramList = this.CgH;
    paramList.dVB = paramList.t("Word", this.ssg.replace(",", ""), true);
    AppMethodBeat.o(193432);
  }
  
  public static abstract interface a
  {
    public abstract void clear();
  }
  
  static abstract interface b
  {
    public abstract void a(int paramInt, h paramh);
  }
  
  final class c
    extends RecyclerView.a<m.d>
  {
    private LinkedList<h> oGz;
    
    c()
    {
      AppMethodBeat.i(193426);
      this.oGz = new LinkedList();
      AppMethodBeat.o(193426);
    }
    
    public final void ad(List<h> paramList)
    {
      AppMethodBeat.i(193427);
      int i = this.oGz.size();
      this.oGz.clear();
      this.oGz.addAll(paramList);
      int j = this.oGz.size();
      if (j > i)
      {
        aq(i, j - i);
        AppMethodBeat.o(193427);
        return;
      }
      if (j < i) {
        ar(j, i - j);
      }
      AppMethodBeat.o(193427);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(193428);
      if (this.oGz == null)
      {
        AppMethodBeat.o(193428);
        return 0;
      }
      int i = this.oGz.size();
      AppMethodBeat.o(193428);
      return i;
    }
  }
  
  final class d
    extends RecyclerView.v
  {
    h CgM;
    EmojiStatusView xBI;
    
    d(View paramView)
    {
      super();
      AppMethodBeat.i(104699);
      this.xBI = ((EmojiStatusView)paramView.findViewById(2131305539));
      this.xBI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(193431);
          m.this.CgJ.a(m.d.this.ln(), m.d.this.CgM);
          AppMethodBeat.o(193431);
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