package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.g.b.a.gl;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.ae;
import com.tencent.mm.ui.chatting.c.b.ak;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.chatting.c.b.y;
import com.tencent.mm.ui.chatting.g.b.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import java.util.LinkedList;

@SuppressLint({"ValidFragment"})
public class ChattingUIFragment
  extends BaseChattingUIFragment
{
  public static String FeN;
  public com.tencent.mm.ui.chatting.a.a GpE;
  ListView GpF;
  private Runnable GpG;
  private MMChattingListView GpH;
  private boolean GpI = true;
  protected boolean GpJ = true;
  private boolean GpK = false;
  private boolean GpL = false;
  private int GpM = 0;
  private final int GpN = 10;
  private com.tencent.mm.ui.chatting.m.a.a GpO;
  private int mScrollState = 0;
  private p tipDialog = null;
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment() {}
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment(byte paramByte)
  {
    super((byte)0);
  }
  
  private boolean eVX()
  {
    AppMethodBeat.i(34769);
    j localj = (j)this.cOd.be(j.class);
    ae localae = (ae)this.cOd.be(ae.class);
    if (localj.eXi())
    {
      if (localae.eYu())
      {
        localae.eYt();
        localj.eXj();
      }
      for (;;)
      {
        AppMethodBeat.o(34769);
        return true;
        localj.eXg();
      }
    }
    AppMethodBeat.o(34769);
    return false;
  }
  
  private void wd(final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(34728);
    int m = this.GpF.getLastVisiblePosition();
    int n = this.GpF.getFirstVisiblePosition();
    final int k = this.GpF.getCount();
    ad.i("MicroMsg.ChattingUIFragment", "[scrollToLastImpl] isFirstScroll:%s [%s:%s] count:%s force:%s", new Object[] { Boolean.valueOf(this.GpI), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
    this.GpI = false;
    final int i = j;
    if (paramBoolean)
    {
      i = j;
      if (m == n)
      {
        i = j;
        if (m >= k - 1)
        {
          i = j;
          if (this.GpF.getChildCount() > 0) {
            i = this.GpF.getChildAt(this.GpF.getChildCount() - 1).getHeight();
          }
        }
      }
    }
    if ((paramBoolean) && (this.GpH.bPj())) {
      ad.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom");
    }
    for (;;)
    {
      this.GpF.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34709);
          if ((paramBoolean) && (ChattingUIFragment.a(ChattingUIFragment.this).bPj()))
          {
            ad.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom in post");
            AppMethodBeat.o(34709);
            return;
          }
          com.tencent.mm.pluginsdk.ui.tools.n.a(ChattingUIFragment.b(ChattingUIFragment.this), k - 1, -i, true);
          AppMethodBeat.o(34709);
        }
      });
      AppMethodBeat.o(34728);
      return;
      com.tencent.mm.pluginsdk.ui.tools.n.a(this.GpF, k - 1, -i, true);
    }
  }
  
  public final void YA(int paramInt)
  {
    AppMethodBeat.i(34747);
    this.GpF.setVisibility(paramInt);
    if (ad.getLogLevel() == 2) {
      ad.i("MicroMsg.ChattingUIFragment", "[setListViewVisibility] visibility:" + paramInt + " stack:" + bt.eGN().toString());
    }
    AppMethodBeat.o(34747);
  }
  
  public final void Yz(int paramInt)
  {
    AppMethodBeat.i(34731);
    com.tencent.mm.ui.chatting.d.a.eZd().removeCallbacks(this.GpG);
    ad.i("MicroMsg.ChattingUIFragment", "[setSelection] pos:%d isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    ListView localListView = this.GpF;
    if (localListView != null)
    {
      ad.i("MicroMsg.ChattingUI.ScrollController", "setSelection position %s smooth %s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
      localListView.setItemChecked(paramInt, true);
      localListView.setSelection(paramInt);
    }
    AppMethodBeat.o(34731);
  }
  
  public final void a(com.tencent.mm.ui.chatting.g.d.a parama)
  {
    AppMethodBeat.i(191484);
    if (this.GpE == null)
    {
      AppMethodBeat.o(191484);
      return;
    }
    com.tencent.mm.ui.chatting.a.a locala = this.GpE;
    if (locala.GrS != null) {
      locala.GrS.a(parama, false, null);
    }
    AppMethodBeat.o(191484);
  }
  
  @Deprecated
  public final void aK(final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(34727);
    if (paramBoolean2)
    {
      com.tencent.mm.ui.chatting.d.a.eZd().removeCallbacks(this.GpG);
      ap localap = com.tencent.mm.ui.chatting.d.a.eZd();
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34702);
          ChattingUIFragment.a(ChattingUIFragment.this, paramBoolean1);
          AppMethodBeat.o(34702);
        }
      };
      this.GpG = local1;
      localap.post(local1);
      AppMethodBeat.o(34727);
      return;
    }
    wd(paramBoolean1);
    AppMethodBeat.o(34727);
  }
  
  public final void aV(Bundle paramBundle)
  {
    AppMethodBeat.i(34742);
    this.GpH.aV(paramBundle);
    AppMethodBeat.o(34742);
  }
  
  public final void aW(Bundle paramBundle)
  {
    AppMethodBeat.i(34744);
    this.GpH.a(true, paramBundle);
    AppMethodBeat.o(34744);
  }
  
  protected final void ai(af paramaf)
  {
    AppMethodBeat.i(34752);
    super.ai(paramaf);
    FeN = paramaf.field_username;
    AppMethodBeat.o(34752);
  }
  
  public final void b(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(34734);
    dismissDialog();
    this.tipDialog = com.tencent.mm.ui.base.h.b(paramContext, paramString, true, paramOnCancelListener);
    AppMethodBeat.o(34734);
  }
  
  public final void bCM()
  {
    AppMethodBeat.i(34724);
    if (this.GpE == null)
    {
      AppMethodBeat.o(34724);
      return;
    }
    this.GpE.notifyDataSetChanged();
    AppMethodBeat.o(34724);
  }
  
  public final void ca(final int paramInt)
  {
    AppMethodBeat.i(34729);
    com.tencent.mm.ui.chatting.d.a.eZd().removeCallbacks(this.GpG);
    this.GpF.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34710);
        ad.i("MicroMsg.ChattingUIFragment", "[scrollToPosition] scroll to pos:%d", new Object[] { Integer.valueOf(paramInt) });
        com.tencent.mm.ui.tools.q localq = new com.tencent.mm.ui.tools.q(ChattingUIFragment.this.GpF);
        int i = paramInt;
        int j = ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount() + i;
        localq.DQ.removeCallbacks(localq);
        localq.Htd = System.currentTimeMillis();
        localq.Hti = 0;
        i = localq.DQ.getFirstVisiblePosition();
        int k = localq.DQ.getChildCount() + i - 1;
        if (j <= i)
        {
          i = i - j + 1;
          localq.mMode = 2;
          if (i <= 0) {
            break label193;
          }
        }
        label193:
        for (localq.Htg = (1000 / i);; localq.Htg = 1000)
        {
          localq.Hte = j;
          localq.Htf = -1;
          localq.DQ.post(localq);
          AppMethodBeat.o(34710);
          return;
          if (j >= k)
          {
            i = j - k + 1;
            localq.mMode = 1;
            break;
          }
          AppMethodBeat.o(34710);
          return;
        }
      }
    });
    AppMethodBeat.o(34729);
  }
  
  public void dDq()
  {
    AppMethodBeat.i(34756);
    super.dDq();
    q.dismiss();
    ad.i("MicroMsg.ChattingUIFragment", "on chatting ui pause  rawuser:%s", new Object[] { this.cOd.getTalkerUserName() });
    if (this.cOd.getTalkerUserName() == null)
    {
      AppMethodBeat.o(34756);
      return;
    }
    this.GpE.pause();
    hideVKB();
    ad.d("MicroMsg.ChattingUIFragment", "chattingui cancel pause auto download logic");
    AppMethodBeat.o(34756);
  }
  
  public void ddQ()
  {
    AppMethodBeat.i(34773);
    az.afE().ax(new Runnable()
    {
      aa GpQ;
      String username;
      
      public final void run()
      {
        AppMethodBeat.i(34708);
        long l = System.currentTimeMillis();
        if (this.GpQ == null)
        {
          ad.e("MicroMsg.ChattingUIFragment", "messBoxComponent == null! without writeOpLogAndMarkRead!");
          AppMethodBeat.o(34708);
          return;
        }
        this.GpQ.aKL(this.username);
        ad.i("MicroMsg.ChattingUIFragment", "ChattingUI writeOpLogAndMarkRead last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(34708);
      }
    });
    AppMethodBeat.o(34773);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(34718);
    super.dealContentView(paramView);
    ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).fJ(paramView);
    AppMethodBeat.o(34718);
  }
  
  public final void dismissDialog()
  {
    AppMethodBeat.i(34735);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(34735);
  }
  
  protected void eUA()
  {
    AppMethodBeat.i(34772);
    this.mScrollState = 0;
    this.GpH = ((MMChattingListView)findViewById(2131298103));
    this.GpH.setIsReturnSuperDispatchWhenCancel(true);
    this.GpF = this.GpH.getListView();
    this.GpF.setVisibility(0);
    ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).eXO();
    if (this.GpH.getBaseAdapter() == null)
    {
      this.GpE = new com.tencent.mm.ui.chatting.a.a(this.cOd, this.GpF);
      this.GpH.setAdapter(this.GpE);
    }
    Object localObject = this.GpH;
    ((MMChattingListView)localObject).vM(false);
    ((MMChattingListView)localObject).vM(false);
    eUY();
    this.GpO.a(com.tencent.mm.ui.chatting.g.d.a.GEX, true, null);
    this.GpF.setOverScrollMode(2);
    if (!((ae)this.cOd.be(ae.class)).eYw()) {
      this.GpF.setTranscriptMode(1);
    }
    for (;;)
    {
      this.GpF.setOnTouchListener(new View.OnTouchListener()
      {
        boolean lSH = false;
        
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(34703);
          ChattingUIFragment.h(ChattingUIFragment.this);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            ad.i("MicroMsg.ChattingUIFragment", "onTouch: touch down");
            this.lSH = true;
          }
          while ((!this.lSH) || (!ChattingUIFragment.this.GpJ))
          {
            AppMethodBeat.o(34703);
            return false;
            if (paramAnonymousMotionEvent.getAction() == 1)
            {
              ad.i("MicroMsg.ChattingUIFragment", "onTouch: touch up");
              this.lSH = false;
            }
          }
          paramAnonymousView = (com.tencent.mm.ui.chatting.c.b.q)ChattingUIFragment.this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class);
          if ((paramAnonymousView == null) || (paramAnonymousView.eXs() == null))
          {
            AppMethodBeat.o(34703);
            return false;
          }
          paramAnonymousView.eXs().g(0, true, -1);
          AppMethodBeat.o(34703);
          return false;
        }
      });
      this.GpF.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        /* Error */
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          // Byte code:
          //   0: aload_0
          //   1: monitorenter
          //   2: ldc 23
          //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   7: aload_0
          //   8: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$3:GpP	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   11: getfield 35	com/tencent/mm/ui/chatting/BaseChattingUIFragment:cOd	Lcom/tencent/mm/ui/chatting/d/a;
          //   14: getfield 41	com/tencent/mm/ui/chatting/d/a:GzH	Lcom/tencent/mm/ui/chatting/c/n;
          //   17: aload_1
          //   18: iload_2
          //   19: iload_3
          //   20: iload 4
          //   22: invokevirtual 45	com/tencent/mm/ui/chatting/c/n:onScroll	(Landroid/widget/AbsListView;III)V
          //   25: aload_0
          //   26: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$3:GpP	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   29: invokestatic 48	com/tencent/mm/ui/chatting/ChattingUIFragment:i	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
          //   32: ifeq +36 -> 68
          //   35: aload_0
          //   36: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$3:GpP	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   39: invokestatic 52	com/tencent/mm/ui/chatting/ChattingUIFragment:b	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Landroid/widget/ListView;
          //   42: invokevirtual 58	android/widget/ListView:getLastVisiblePosition	()I
          //   45: iload 4
          //   47: iconst_1
          //   48: isub
          //   49: if_icmpeq +11 -> 60
          //   52: ldc 23
          //   54: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   57: aload_0
          //   58: monitorexit
          //   59: return
          //   60: aload_0
          //   61: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$3:GpP	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   64: invokestatic 64	com/tencent/mm/ui/chatting/ChattingUIFragment:j	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
          //   67: pop
          //   68: ldc 23
          //   70: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   73: goto -16 -> 57
          //   76: astore_1
          //   77: aload_0
          //   78: monitorexit
          //   79: aload_1
          //   80: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	81	0	this	3
          //   0	81	1	paramAnonymousAbsListView	AbsListView
          //   0	81	2	paramAnonymousInt1	int
          //   0	81	3	paramAnonymousInt2	int
          //   0	81	4	paramAnonymousInt3	int
          // Exception table:
          //   from	to	target	type
          //   2	57	76	finally
          //   60	68	76	finally
          //   68	73	76	finally
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(34704);
          ChattingUIFragment.this.cOd.GzH.onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
          ChattingUIFragment.a(ChattingUIFragment.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            ad.d("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] [%s:%s]", new Object[] { Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition()), Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition()) });
            LinkedList localLinkedList;
            label256:
            Object localObject;
            if (ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() == 0)
            {
              paramAnonymousAbsListView = ChattingUIFragment.b(ChattingUIFragment.this).getChildAt(0);
              if (paramAnonymousAbsListView != null)
              {
                if (paramAnonymousAbsListView.getTop() == 0)
                {
                  ad.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load top more!");
                  ChattingUIFragment.a(ChattingUIFragment.this).vL(true);
                }
              }
              else
              {
                ChattingUIFragment.this.GpE.eH(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
                com.tencent.mm.ui.chatting.a.a locala = ChattingUIFragment.this.GpE;
                paramAnonymousInt = ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition();
                int j = ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount();
                int i = ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition();
                if (locala.FQd == null) {
                  break label600;
                }
                paramAnonymousAbsListView = locala.FQd.zgX;
                if ((paramAnonymousAbsListView == null) || (paramAnonymousAbsListView.eKB())) {
                  break label600;
                }
                localLinkedList = new LinkedList();
                paramAnonymousInt -= j;
                if (paramAnonymousInt > i) {
                  break label542;
                }
                paramAnonymousAbsListView = locala.YH(paramAnonymousInt);
                if (paramAnonymousAbsListView != null)
                {
                  localObject = paramAnonymousAbsListView.field_content;
                  if (localObject != null)
                  {
                    paramAnonymousAbsListView = k.b.ar((String)localObject, paramAnonymousAbsListView.field_reserved);
                    if ((paramAnonymousAbsListView != null) && (paramAnonymousAbsListView.type == 5) && (!TextUtils.isEmpty(paramAnonymousAbsListView.url)))
                    {
                      localObject = new com.tencent.mm.plugin.brandservice.a.d.a();
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).url = paramAnonymousAbsListView.url;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).mSu = 1;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).appId = paramAnonymousAbsListView.appId;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).title = paramAnonymousAbsListView.title;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).desc = paramAnonymousAbsListView.description;
                      if (!locala.FQd.eZb()) {
                        break label536;
                      }
                    }
                  }
                }
              }
            }
            label536:
            for (paramAnonymousAbsListView = "groupmessage";; paramAnonymousAbsListView = "singlemessage")
            {
              ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).dvh = paramAnonymousAbsListView;
              localLinkedList.add(localObject);
              paramAnonymousInt += 1;
              break label256;
              if (paramAnonymousAbsListView.getTop() >= 0) {
                break;
              }
              ad.w("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] exception auto load top more wit reset adapter!");
              ChattingUIFragment.a(ChattingUIFragment.this).setAdapter(ChattingUIFragment.this.GpE);
              break;
              if (ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition() != ChattingUIFragment.b(ChattingUIFragment.this).getCount() - 1) {
                break;
              }
              paramAnonymousAbsListView = ChattingUIFragment.b(ChattingUIFragment.this).getChildAt(ChattingUIFragment.b(ChattingUIFragment.this).getChildCount() - 1);
              if ((paramAnonymousAbsListView == null) || (ChattingUIFragment.b(ChattingUIFragment.this).getBottom() - ChattingUIFragment.a(ChattingUIFragment.this).getBottomHeight() < paramAnonymousAbsListView.getBottom())) {
                break;
              }
              ad.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load bottom more!");
              ChattingUIFragment.a(ChattingUIFragment.this).vM(true);
              break;
            }
            label542:
            if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class) != null) && (localLinkedList.size() > 0))
            {
              ad.v("MicroMsg.ChattingDataAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
              ((com.tencent.mm.plugin.brandservice.a.d)g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).l(localLinkedList, 2);
            }
          }
          label600:
          AppMethodBeat.o(34704);
        }
      });
      this.GpF.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34706);
          ChattingUIFragment.this.GpE.eH(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
          ChattingUIFragment.b(ChattingUIFragment.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(34706);
        }
      });
      if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xA(2))
      {
        localObject = this.cOd;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).zgX;
          if ((localObject != null) && (((af)localObject).eKB())) {
            ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xB(0);
          }
        }
      }
      registerForContextMenu(this.GpF);
      aK(false, true);
      AppMethodBeat.o(34772);
      return;
      this.GpF.setTranscriptMode(0);
    }
  }
  
  public final void eUS()
  {
    AppMethodBeat.i(34757);
    super.eUS();
    if (this.cOd.getTalkerUserName() == null)
    {
      AppMethodBeat.o(34757);
      return;
    }
    AppMethodBeat.o(34757);
  }
  
  public final u eUV()
  {
    AppMethodBeat.i(34750);
    if (this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class) == null)
    {
      AppMethodBeat.o(34750);
      return null;
    }
    u localu = ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).eUV();
    AppMethodBeat.o(34750);
    return localu;
  }
  
  public final boolean eUW()
  {
    AppMethodBeat.i(34763);
    if (!isScreenEnable())
    {
      ad.w("MicroMsg.ChattingUIFragment", "Actionbar customView onclick screen not enable");
      AppMethodBeat.o(34763);
      return true;
    }
    hideVKB();
    if (getActivity() != null)
    {
      View localView = getActivity().findViewById(2131301337);
      if (localView == null) {
        break label82;
      }
      localView.setVisibility(0);
      localView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34714);
          ChattingUIFragment.this.eVV();
          AppMethodBeat.o(34714);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(34763);
      return true;
      label82:
      eVV();
    }
  }
  
  public final com.tencent.mm.ui.chatting.m.a.a eUX()
  {
    return this.GpO;
  }
  
  public final void eUY()
  {
    AppMethodBeat.i(34771);
    if ((this.GpH == null) || (this.GpE == null))
    {
      AppMethodBeat.o(34771);
      return;
    }
    Object localObject1 = this.cOd;
    Object localObject2 = new com.tencent.mm.ui.chatting.g.a(this.cOd, this.GpE.GrI);
    com.tencent.mm.ui.chatting.g.b localb = new com.tencent.mm.ui.chatting.g.b(this.cOd, this.GpH);
    localObject2 = new com.tencent.mm.ui.chatting.g.e(localb, (com.tencent.mm.ui.chatting.g.c)localObject2);
    if (((com.tencent.mm.ui.chatting.c.b.d)((com.tencent.mm.ui.chatting.d.a)localObject1).be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC()) {
      localObject1 = new com.tencent.mm.ui.chatting.m.a.b((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.g.e)localObject2);
    }
    for (;;)
    {
      localb.GES = ((b.a)localObject1);
      ad.i("MicroMsg.ChattingLoader.ChattingDataPresenterFactory", "[ChattingDataPresenterFactory] executor:%s", new Object[] { ((com.tencent.mm.ui.chatting.m.a.a)localObject1).toString() });
      this.GpO = ((com.tencent.mm.ui.chatting.m.a.a)localObject1);
      this.GpE.GrS = this.GpO;
      this.GpH.setLoadExecutor(this.GpO);
      AppMethodBeat.o(34771);
      return;
      if (((com.tencent.mm.ui.chatting.c.b.r)((com.tencent.mm.ui.chatting.d.a)localObject1).be(com.tencent.mm.ui.chatting.c.b.r.class)).eXF()) {
        localObject1 = new com.tencent.mm.ui.chatting.m.a.c((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.g.d)localObject2);
      } else if ((((ae)((com.tencent.mm.ui.chatting.d.a)localObject1).be(ae.class)).eYy()) || (((ae)((com.tencent.mm.ui.chatting.d.a)localObject1).be(ae.class)).eYz()) || (((ae)((com.tencent.mm.ui.chatting.d.a)localObject1).be(ae.class)).eYw())) {
        localObject1 = new com.tencent.mm.ui.chatting.m.a.e((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.g.d)localObject2);
      } else {
        localObject1 = new com.tencent.mm.ui.chatting.m.a.d((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.g.e)localObject2);
      }
    }
  }
  
  public void eUx()
  {
    AppMethodBeat.i(34754);
    this.GpL = false;
    this.GpI = true;
    this.GpJ = true;
    ad.d("MicroMsg.ChattingUIFragment", "isFromSearch  " + getBooleanExtra("finish_direct", false));
    int i;
    String str;
    Object localObject2;
    int j;
    label126:
    Object localObject1;
    if (this.cOd.zgX == null)
    {
      i = 1;
      ad.i("MicroMsg.ChattingUIFragment", "[doCreate] rawUserName from :%s to :%s ", new Object[] { this.cOd.getTalkerUserName(), getStringExtra("Chat_User") });
      str = getStringExtra("Chat_User");
      az.arV();
      localObject2 = com.tencent.mm.model.c.apM().aHY(str);
      if (localObject2 != null) {
        break label367;
      }
      j = -1;
      if (localObject2 != null) {
        break label377;
      }
      localObject1 = "null";
      label135:
      ad.w("MicroMsg.ChattingUIFragment", "protectContactNotExist raw:%s contact:%d username:%s", new Object[] { str, Integer.valueOf(j), localObject1 });
      if ((localObject2 != null) && ((int)((com.tencent.mm.n.b)localObject2).fId != 0) && (!bt.isNullOrNil(((au)localObject2).field_username))) {
        break label386;
      }
      localObject2 = new af();
      ((af)localObject2).setUsername(str);
      ((af)localObject2).FxJ = str;
      ((af)localObject2).Zl();
      ((af)localObject2).jI(3);
      az.arV();
      com.tencent.mm.model.c.apM().ae((af)localObject2);
      az.arV();
      af localaf = com.tencent.mm.model.c.apM().aHY(str);
      localObject1 = localaf;
      if (localaf != null) {
        break label389;
      }
      ad.e("MicroMsg.ChattingUIFragment", "protectContactNotExist contact get from db is null!");
    }
    for (;;)
    {
      ai((af)localObject2);
      ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).OY(this.cOd.getTalkerUserName());
      super.eUx();
      if (isSupportNavigationSwipeBack())
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().init();
      }
      if (i != 0) {
        com.tencent.mm.ui.chatting.d.a.eZd().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34711);
            ((com.tencent.mm.ui.chatting.c.b.w)ChattingUIFragment.this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).eXR();
            ((com.tencent.mm.ui.chatting.c.b.w)ChattingUIFragment.this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).eXQ();
            AppMethodBeat.o(34711);
          }
        });
      }
      eUA();
      com.tencent.mm.plugin.groupsolitaire.b.b.adi(this.cOd.getTalkerUserName());
      AppMethodBeat.o(34754);
      return;
      i = 0;
      break;
      label367:
      j = (int)((com.tencent.mm.n.b)localObject2).fId;
      break label126;
      label377:
      localObject1 = ((au)localObject2).field_username;
      break label135;
      label386:
      localObject1 = localObject2;
      label389:
      if (af.st(str))
      {
        ad.i("MicroMsg.ChattingUIFragment", "[protectContactNotExist] isBottleContact userName:".concat(String.valueOf(str)));
        ((af)localObject1).FxJ = str;
        ((af)localObject1).setUsername(str);
      }
      if (com.tencent.mm.model.w.sx(str))
      {
        localObject2 = new gl();
        ((gl)localObject2).dZv = 1L;
        ((gl)localObject2).aBj();
      }
      localObject2 = localObject1;
      if (com.tencent.mm.model.w.sy(str))
      {
        localObject2 = new gk();
        ((gk)localObject2).dZv = 1L;
        ((gk)localObject2).aBj();
        localObject2 = localObject1;
      }
    }
  }
  
  public void eUz()
  {
    AppMethodBeat.i(34755);
    super.eUz();
    if (getWindow() != null) {
      getWindow().setBackgroundDrawableResource(2131100810);
    }
    boolean bool1;
    boolean bool2;
    if (getContentView() != null)
    {
      bool1 = getContentView().isShown();
      if (getView() == null) {
        break label124;
      }
      bool2 = getView().isShown();
      label57:
      if (this.GpF.getVisibility() != 0) {
        break label129;
      }
    }
    label129:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (this.cOd.ctF) {
        break label134;
      }
      ad.i("MicroMsg.ChattingUIFragment", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b listviewShow:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(34755);
      return;
      bool1 = false;
      break;
      label124:
      bool2 = false;
      break label57;
    }
    label134:
    if (!az.afw())
    {
      ad.w("MicroMsg.ChattingUIFragment", "account not ready, mabey not call onDestroy!!!");
      finish();
      AppMethodBeat.o(34755);
      return;
    }
    this.GpE.resume();
    AppMethodBeat.o(34755);
  }
  
  public final void eVO()
  {
    AppMethodBeat.i(34725);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      aK(false, bool);
      AppMethodBeat.o(34725);
      return;
    }
  }
  
  public final void eVP()
  {
    AppMethodBeat.i(34730);
    ad.i("MicroMsg.ChattingUIFragment", "[smoothScrollBy] dis:%d duration:%d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.GpF.smoothScrollBy(0, 0);
    AppMethodBeat.o(34730);
  }
  
  public final void eVQ()
  {
    AppMethodBeat.i(34738);
    this.GpH.setTopViewVisible(true);
    AppMethodBeat.o(34738);
  }
  
  public final void eVR()
  {
    AppMethodBeat.i(34739);
    this.GpH.setIsTopShowAll(false);
    AppMethodBeat.o(34739);
  }
  
  public final void eVS()
  {
    AppMethodBeat.i(34743);
    this.GpH.vL(false);
    AppMethodBeat.o(34743);
  }
  
  public final void eVT()
  {
    AppMethodBeat.i(34748);
    this.GpF.setTranscriptMode(0);
    AppMethodBeat.o(34748);
  }
  
  public final void eVU()
  {
    AppMethodBeat.i(34761);
    Object localObject = (ae)this.cOd.be(ae.class);
    if ((!((ae)localObject).eYw()) && (!((ae)localObject).eYy()) && (!((ae)localObject).eYz()))
    {
      int i = this.GpM;
      this.GpM = (i + 1);
      if ((i < 10) && (((thisActivity() instanceof ChattingUI)) || ((thisActivity() instanceof AppBrandServiceChattingUI))))
      {
        localObject = this.GpF;
        Runnable local9 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34712);
            if ((ChattingUIFragment.c(ChattingUIFragment.this)) || (ChattingUIFragment.d(ChattingUIFragment.this) != 0))
            {
              ChattingUIFragment.e(ChattingUIFragment.this);
              ad.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect userTouched: %s state: %s", new Object[] { Boolean.valueOf(ChattingUIFragment.c(ChattingUIFragment.this)), Integer.valueOf(ChattingUIFragment.d(ChattingUIFragment.this)) });
              AppMethodBeat.o(34712);
              return;
            }
            int i = ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition();
            int j = ChattingUIFragment.b(ChattingUIFragment.this).getCount() - 1;
            ad.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", new Object[] { Integer.valueOf(ChattingUIFragment.f(ChattingUIFragment.this)), Integer.valueOf(i), Integer.valueOf(j) });
            if (i < j)
            {
              ChattingUIFragment.a(ChattingUIFragment.this, true);
              ChattingUIFragment.this.eVU();
              AppMethodBeat.o(34712);
              return;
            }
            ChattingUIFragment.e(ChattingUIFragment.this);
            AppMethodBeat.o(34712);
          }
        };
        if (this.GpM == 1) {}
        for (i = 10;; i = 100)
        {
          ((ListView)localObject).postDelayed(local9, i);
          AppMethodBeat.o(34761);
          return;
        }
      }
    }
    ad.d("MicroMsg.ChattingUIFragment", "scrollToLastProtect:%s, %s ,%s", new Object[] { Boolean.valueOf(((ae)localObject).eYw()), Boolean.valueOf(((ae)localObject).eYy()), Integer.valueOf(this.GpM) });
    AppMethodBeat.o(34761);
  }
  
  protected final void eVV()
  {
    AppMethodBeat.i(34764);
    ((ak)this.cOd.be(ak.class)).aG(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34715);
        ChattingUIFragment.this.onExitBegin();
        if ((ChattingUIFragment.this.isCurrentActivity) || (!ChattingUIFragment.this.isSupportNavigationSwipeBack()))
        {
          ChattingUIFragment.this.eVW();
          AppMethodBeat.o(34715);
          return;
        }
        SwipeBackLayout localSwipeBackLayout = ChattingUIFragment.this.getSwipeBackLayout();
        ad.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", new Object[] { Boolean.valueOf(localSwipeBackLayout.HBY), Boolean.valueOf(localSwipeBackLayout.HBW), Boolean.valueOf(localSwipeBackLayout.HBX) });
        if (!localSwipeBackLayout.ffa())
        {
          com.tencent.mm.ui.widget.h.bK(0.0F);
          localSwipeBackLayout.HBY = true;
          localSwipeBackLayout.HBX = false;
          int i = localSwipeBackLayout.mContentView.getWidth();
          int j = localSwipeBackLayout.HBT.getIntrinsicWidth();
          com.tencent.mm.ui.mogic.a locala = localSwipeBackLayout.HBR;
          locala.TN = localSwipeBackLayout.mContentView;
          locala.mActivePointerId = -1;
          locala.b(i + j + 10, 0, 0, 0, 260L);
          localSwipeBackLayout.invalidate();
          if (localSwipeBackLayout.HCe != null) {
            localSwipeBackLayout.HCe.onDrag();
          }
          com.tencent.mm.ui.widget.h.V(true, 0);
        }
        AppMethodBeat.o(34715);
      }
    });
    AppMethodBeat.o(34764);
  }
  
  protected final void eVW()
  {
    AppMethodBeat.i(34768);
    eVX();
    Object localObject = (com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class);
    if (af.aHE(this.cOd.getTalkerUserName()))
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      com.tencent.mm.bs.d.b(getContext(), "tmessage", ".ui.TConversationUI", (Intent)localObject);
    }
    do
    {
      for (;;)
      {
        finish();
        AppMethodBeat.o(34768);
        return;
        if (getIntExtra("chat_from_scene", 0) == 4)
        {
          finish();
          AppMethodBeat.o(34768);
          return;
        }
        if (((getIntExtra("chat_from_scene", 0) == 1) || (getIntExtra("chat_from_scene", 0) == 3)) && (this.cOd.zgX != null) && (this.cOd.zgX.eKB()) && (((com.tencent.mm.ui.chatting.c.b.d)localObject).eWz() != null) && (((com.tencent.mm.ui.chatting.c.b.d)localObject).eWz().Jf()) && (((com.tencent.mm.ui.chatting.c.b.d)localObject).eWz().bU(false) != null) && (((com.tencent.mm.ui.chatting.c.b.d)localObject).eWz().bU(false).JH() != null) && (!bt.isNullOrNil(((com.tencent.mm.ui.chatting.c.b.d)localObject).eWz().Jm())))
        {
          finish();
          AppMethodBeat.o(34768);
          return;
        }
        if (!((y)this.cOd.be(y.class)).eYj()) {
          break;
        }
        finish();
      }
    } while (getBooleanExtra("finish_direct", false).booleanValue());
    if (!this.isCurrentActivity)
    {
      finish();
      AppMethodBeat.o(34768);
      return;
    }
    localObject = new Intent(getContext(), LauncherUI.class);
    ((Intent)localObject).addFlags(67108864);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    overridePendingTransition(MMFragmentActivity.a.lLH, MMFragmentActivity.a.lLI);
    finish();
    AppMethodBeat.o(34768);
  }
  
  public void finish()
  {
    AppMethodBeat.i(34770);
    this.cOd.GzH.onFinish();
    Object localObject = (com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class);
    if ((localObject != null) && (((com.tencent.mm.ui.chatting.c.b.q)localObject).eXs() != null)) {
      ((com.tencent.mm.ui.chatting.c.b.q)localObject).eXs().g(0, true, -1);
    }
    if (!hideVKB()) {}
    for (int i = 0;; i = 100)
    {
      localObject = new Runnable()
      {
        public final void run()
        {
          boolean bool2 = true;
          boolean bool1 = true;
          AppMethodBeat.i(34716);
          ad.i("MicroMsg.ChattingUIFragment", "[finish] isCurrentActivity:%s", new Object[] { Boolean.valueOf(ChattingUIFragment.this.isCurrentActivity) });
          if (ChattingUIFragment.this.isCurrentActivity)
          {
            ChattingUIFragment.g(ChattingUIFragment.this);
            AppMethodBeat.o(34716);
            return;
          }
          Object localObject;
          if ((ChattingUIFragment.this.thisActivity() instanceof LauncherUI))
          {
            localObject = (LauncherUI)ChattingUIFragment.this.thisActivity();
            if (localObject != null)
            {
              if (!ChattingUIFragment.this.isSupportNavigationSwipeBack()) {}
              for (;;)
              {
                ((LauncherUI)localObject).closeChatting(bool1);
                AppMethodBeat.o(34716);
                return;
                bool1 = false;
              }
            }
            ad.e("MicroMsg.ChattingUIFragment", "LauncherUI is null!???");
            AppMethodBeat.o(34716);
            return;
          }
          if ((ChattingUIFragment.this.thisActivity() instanceof BaseConversationUI))
          {
            localObject = (BaseConversationUI)ChattingUIFragment.this.thisActivity();
            if (localObject != null) {
              if (ChattingUIFragment.this.isSupportNavigationSwipeBack()) {
                break label174;
              }
            }
          }
          label174:
          for (bool1 = bool2;; bool1 = false)
          {
            ((BaseConversationUI)localObject).closeChatting(bool1);
            AppMethodBeat.o(34716);
            return;
          }
        }
      };
      if (i == 0)
      {
        ((Runnable)localObject).run();
        AppMethodBeat.o(34770);
        return;
      }
      aq.n((Runnable)localObject, 100L);
      AppMethodBeat.o(34770);
      return;
    }
  }
  
  public final int getBottomHeight()
  {
    AppMethodBeat.i(34745);
    if (this.GpH == null)
    {
      AppMethodBeat.o(34745);
      return 0;
    }
    int i = this.GpH.getBottomHeight();
    AppMethodBeat.o(34745);
    return i;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(34749);
    int i = this.GpF.getFirstVisiblePosition();
    AppMethodBeat.o(34749);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131493382;
  }
  
  public final ListView getListView()
  {
    return this.GpF;
  }
  
  public final int getTopHeight()
  {
    AppMethodBeat.i(34746);
    int i = this.GpH.getTopHeight();
    AppMethodBeat.o(34746);
    return i;
  }
  
  public boolean getUserVisibleHint()
  {
    return this.cOd.ctF;
  }
  
  public boolean hideVKB()
  {
    AppMethodBeat.i(34733);
    ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class)).eXs();
    if (localChatFooter != null)
    {
      bool = localChatFooter.hideVKB();
      AppMethodBeat.o(34733);
      return bool;
    }
    boolean bool = super.hideVKB();
    AppMethodBeat.o(34733);
    return bool;
  }
  
  public boolean isSupportCustomActionBar()
  {
    AppMethodBeat.i(34751);
    boolean bool = isSupportNavigationSwipeBack();
    AppMethodBeat.o(34751);
    return bool;
  }
  
  public final void jM(Context paramContext)
  {
    AppMethodBeat.i(34753);
    super.jM(paramContext);
    ad.i("MicroMsg.ChattingUIFragment", "[doAttach]:%s#0x%x task:%s hc:%d", new Object[] { thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), bt.iQ(thisActivity()), Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.aT(3, true);
    }
    AppMethodBeat.o(34753);
  }
  
  public final void jt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34732);
    com.tencent.mm.ui.chatting.d.a.eZd().removeCallbacks(this.GpG);
    ad.i("MicroMsg.ChattingUIFragment", "[setSelectionFromTop] pos:%d offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    com.tencent.mm.pluginsdk.ui.tools.n.a(this.GpF, paramInt1, paramInt2, false);
    AppMethodBeat.o(34732);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34774);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 30763) || (paramInt1 == 30762))
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(34774);
        return;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getBundleExtra("result_data");
          if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
          {
            g.afB().afk().set(ae.a.FtT, Boolean.TRUE);
            if (paramInt1 == 30763)
            {
              com.tencent.mm.pluginsdk.permission.b.a(getActivity(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 67);
              AppMethodBeat.o(34774);
              return;
            }
            com.tencent.mm.pluginsdk.permission.b.a(getActivity(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68);
          }
        }
      }
    }
    AppMethodBeat.o(34774);
  }
  
  public void onCancelDrag()
  {
    AppMethodBeat.i(34767);
    if ((isSupportNavigationSwipeBack()) && (this.GpE != null)) {
      this.GpJ = true;
    }
    AppMethodBeat.o(34767);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    AppMethodBeat.i(34717);
    if (!this.cOd.ctF)
    {
      AppMethodBeat.o(34717);
      return;
    }
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    AppMethodBeat.o(34717);
  }
  
  public void onDragBegin()
  {
    AppMethodBeat.i(34766);
    if ((isSupportNavigationSwipeBack()) && (this.GpE != null)) {
      this.GpJ = false;
    }
    AppMethodBeat.o(34766);
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34758);
    super.onEnterBegin();
    ddQ();
    AppMethodBeat.o(34758);
  }
  
  public final void onExitBegin()
  {
    AppMethodBeat.i(34759);
    super.onExitBegin();
    com.tencent.mm.ui.chatting.a.a locala = this.GpE;
    locala.GrL = -1L;
    locala.GrK.clear();
    this.GpO.GGG.cancel();
    ddQ();
    AppMethodBeat.o(34759);
  }
  
  public final void onExitEnd()
  {
    AppMethodBeat.i(34760);
    super.onExitEnd();
    dismissDialog();
    AppMethodBeat.o(34760);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(34762);
    if (keyboardState() == 1) {
      this.GpF.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34713);
          ChattingUIFragment.this.aK(true, false);
          AppMethodBeat.o(34713);
        }
      });
    }
    AppMethodBeat.o(34762);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(34775);
    super.onMultiWindowModeChanged(paramBoolean);
    ad.i("MicroMsg.ChattingUIFragment", "onMultiWindowModeChanged: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class)).eXs();
    if (localChatFooter != null) {
      localChatFooter.setIsMultiWindow(paramBoolean);
    }
    AppMethodBeat.o(34775);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(34765);
    ad.w("MicroMsg.ChattingUIFragment", "onSwipeBack");
    eVW();
    if (com.tencent.mm.plugin.location.model.n.cJq().cJu())
    {
      fg localfg = new fg();
      localfg.dhF.username = com.tencent.mm.bj.d.hxy.aCm();
      com.tencent.mm.sdk.b.a.ESL.l(localfg);
    }
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    AppMethodBeat.o(34765);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(34723);
    ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).setBackBtn(paramOnMenuItemClickListener);
    AppMethodBeat.o(34723);
  }
  
  public final void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(34737);
    this.GpH.setBottomViewVisible(paramBoolean);
    AppMethodBeat.o(34737);
  }
  
  public final void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(34740);
    this.GpH.setIsBottomShowAll(paramBoolean);
    AppMethodBeat.o(34740);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(34736);
    if (this.GpF != null) {
      this.GpF.setKeepScreenOn(paramBoolean);
    }
    AppMethodBeat.o(34736);
  }
  
  public void setMMSubTitle(int paramInt)
  {
    AppMethodBeat.i(34722);
    setMMSubTitle(getMMString(paramInt));
    AppMethodBeat.o(34722);
  }
  
  public void setMMSubTitle(String paramString)
  {
    AppMethodBeat.i(34721);
    ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).setMMSubTitle(paramString);
    AppMethodBeat.o(34721);
  }
  
  public void setMMTitle(int paramInt)
  {
    AppMethodBeat.i(34719);
    setMMTitle(getMMString(paramInt));
    AppMethodBeat.o(34719);
  }
  
  public void setMMTitle(String paramString)
  {
    AppMethodBeat.i(34720);
    ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).setMMTitle(paramString);
    AppMethodBeat.o(34720);
  }
  
  public final void vM(boolean paramBoolean)
  {
    AppMethodBeat.i(34741);
    this.GpH.vM(paramBoolean);
    AppMethodBeat.o(34741);
  }
  
  public final void wc(boolean paramBoolean)
  {
    AppMethodBeat.i(34726);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      aK(paramBoolean, bool);
      AppMethodBeat.o(34726);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */