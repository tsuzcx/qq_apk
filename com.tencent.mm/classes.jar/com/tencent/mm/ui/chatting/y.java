package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.b.l;
import com.tencent.mm.ui.chatting.e.b.a;
import com.tencent.mm.ui.chatting.e.d.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.SwipeBackLayout;

@SuppressLint({"ValidFragment"})
public class y
  extends e
{
  public static String unh;
  private int lf = 0;
  private p tipDialog = null;
  public com.tencent.mm.ui.chatting.a.a vlQ;
  ListView vlR;
  private Runnable vlS;
  private MMChattingListView vlT;
  private boolean vlU = true;
  protected boolean vlV = true;
  private boolean vlW = false;
  private boolean vlX = false;
  private int vlY = 0;
  private final int vlZ = 10;
  private com.tencent.mm.ui.chatting.k.a.a vma;
  
  @SuppressLint({"ValidFragment"})
  public y() {}
  
  @SuppressLint({"ValidFragment"})
  public y(byte paramByte)
  {
    super((byte)0);
  }
  
  private void nl(boolean paramBoolean)
  {
    int j = this.vlR.getLastVisiblePosition();
    int i = this.vlR.getCount() - 1;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "[scrollToLastImpl] is FirstScroll:%s, last visible:count=[%s:%s] force:%s", new Object[] { Boolean.valueOf(this.vlU), Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
    this.vlU = false;
    if ((j >= i - 1) || (paramBoolean))
    {
      j = this.vlQ.getCount();
      if ((j > 1) && (this.vlQ.GW(j - 2).isSystem())) {
        j.a(this.vlR, i - 1, 0, false);
      }
    }
    else
    {
      return;
    }
    j.a(this.vlR, i, 0, true);
  }
  
  public final void GT(int paramInt)
  {
    com.tencent.mm.ui.chatting.c.a.cFG().removeCallbacks(this.vlS);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "[setSelection] pos:%d isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(false) });
    ListView localListView = this.vlR;
    if (localListView != null)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUI.ScrollController", "setSelection position %s smooth %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(false) });
      localListView.setItemChecked(paramInt, true);
      localListView.setSelection(paramInt);
    }
  }
  
  public final void GU(int paramInt)
  {
    this.vlR.setVisibility(paramInt);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "[setListViewVisibility] visibility:" + paramInt + " stack:" + bk.csb().toString());
  }
  
  protected final void Y(ad paramad)
  {
    super.Y(paramad);
    unh = paramad.field_username;
  }
  
  public final void am(Bundle paramBundle)
  {
    this.vlT.am(paramBundle);
  }
  
  public final void an(Bundle paramBundle)
  {
    this.vlT.a(true, paramBundle);
  }
  
  public final void axW()
  {
    if (this.vlQ == null) {
      return;
    }
    this.vlQ.notifyDataSetChanged();
  }
  
  public final void bE(int paramInt)
  {
    com.tencent.mm.ui.chatting.c.a.cFG().removeCallbacks(this.vlS);
    this.vlR.post(new y.3(this, paramInt));
  }
  
  public final void btn()
  {
    au.DS().O(new y.2(this));
  }
  
  public final void c(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    dismissDialog();
    this.tipDialog = com.tencent.mm.ui.base.h.b(paramContext, paramString, true, paramOnCancelListener);
  }
  
  public void cBR()
  {
    this.vlX = false;
    this.vlU = true;
    this.vlV = true;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUIFragment", "isFromSearch  " + getBooleanExtra("finish_direct", false));
    int i;
    String str;
    Object localObject2;
    int j;
    label120:
    Object localObject1;
    if (this.byx.pSb == null)
    {
      i = 1;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "[doCreate] rawUserName from :%s to :%s ", new Object[] { this.byx.getTalkerUserName(), getStringExtra("Chat_User") });
      str = getStringExtra("Chat_User");
      au.Hx();
      localObject2 = com.tencent.mm.model.c.Fw().abl(str);
      if (localObject2 != null) {
        break label328;
      }
      j = -1;
      if (localObject2 != null) {
        break label338;
      }
      localObject1 = "null";
      label129:
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingUIFragment", "protectContactNotExist raw:%s contact:%d username:%s", new Object[] { str, Integer.valueOf(j), localObject1 });
      if ((localObject2 != null) && ((int)((com.tencent.mm.n.a)localObject2).dBe != 0) && (!bk.bl(((ao)localObject2).field_username))) {
        break label347;
      }
      localObject2 = new ad();
      ((ad)localObject2).setUsername(str);
      ((ad)localObject2).uzT = str;
      ((ad)localObject2).AI();
      ((ad)localObject2).fl(3);
      au.Hx();
      com.tencent.mm.model.c.Fw().U((ad)localObject2);
      au.Hx();
      ad localad = com.tencent.mm.model.c.Fw().abl(str);
      localObject1 = localad;
      if (localad != null) {
        break label350;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingUIFragment", "protectContactNotExist contact get from db is null!");
      finish();
    }
    for (;;)
    {
      Y((ad)localObject2);
      super.cBR();
      if (isSupportNavigationSwipeBack())
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().init();
      }
      if (i != 0) {
        com.tencent.mm.ui.chatting.c.a.cFG().post(new y.4(this));
      }
      cBT();
      return;
      i = 0;
      break;
      label328:
      j = (int)((com.tencent.mm.n.a)localObject2).dBe;
      break label120;
      label338:
      localObject1 = ((ao)localObject2).field_username;
      break label129;
      label347:
      localObject1 = localObject2;
      label350:
      localObject2 = localObject1;
      if (ad.hd(str))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "[protectContactNotExist] isBottleContact userName:" + str);
        ((ad)localObject1).uzT = str;
        ((ad)localObject1).setUsername(str);
        localObject2 = localObject1;
      }
    }
  }
  
  public void cBS()
  {
    super.cBS();
    if (getWindow() != null) {
      getWindow().setBackgroundDrawableResource(R.e.room_info_comment_layout_bg);
    }
    boolean bool1;
    boolean bool2;
    if (getContentView() != null)
    {
      bool1 = getContentView().isShown();
      if (getView() == null) {
        break label112;
      }
      bool2 = getView().isShown();
      label51:
      if (this.vlR.getVisibility() != 0) {
        break label117;
      }
    }
    label112:
    label117:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (this.byx.euf) {
        break label122;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b listviewShow:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label51;
    }
    label122:
    if (!au.DK())
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingUIFragment", "account not ready, mabey not call onDestroy!!!");
      finish();
      return;
    }
    this.vlQ.resume();
  }
  
  protected void cBT()
  {
    this.lf = 0;
    this.vlT = ((MMChattingListView)findViewById(R.h.chatting_history_lv));
    this.vlR = this.vlT.getListView();
    this.vlR.setVisibility(0);
    ((q)this.byx.ac(q.class)).cED();
    if (this.vlT.getBaseAdapter() == null)
    {
      this.vlQ = new com.tencent.mm.ui.chatting.a.a(this.byx, this.vlR);
      this.vlT.setAdapter(this.vlQ);
    }
    MMChattingListView localMMChattingListView = this.vlT;
    localMMChattingListView.getListView().setAdapter(localMMChattingListView.vAs);
    localMMChattingListView.nb(false);
    localMMChattingListView.nb(false);
    cCq();
    this.vma.a(d.a.vye, true, null);
    this.vlR.setOverScrollMode(2);
    if (!((com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFj()) {
      this.vlR.setTranscriptMode(1);
    }
    for (;;)
    {
      this.vlR.setOnTouchListener(new y.9(this));
      this.vlR.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        /* Error */
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          // Byte code:
          //   0: aload_0
          //   1: monitorenter
          //   2: aload_0
          //   3: getfield 17	com/tencent/mm/ui/chatting/y$10:vmb	Lcom/tencent/mm/ui/chatting/y;
          //   6: getfield 28	com/tencent/mm/ui/chatting/e:vhT	Lcom/tencent/mm/ui/chatting/b/l;
          //   9: aload_1
          //   10: iload_2
          //   11: iload_3
          //   12: iload 4
          //   14: invokevirtual 32	com/tencent/mm/ui/chatting/b/l:onScroll	(Landroid/widget/AbsListView;III)V
          //   17: aload_0
          //   18: getfield 17	com/tencent/mm/ui/chatting/y$10:vmb	Lcom/tencent/mm/ui/chatting/y;
          //   21: invokestatic 36	com/tencent/mm/ui/chatting/y:i	(Lcom/tencent/mm/ui/chatting/y;)Z
          //   24: ifeq +22 -> 46
          //   27: aload_0
          //   28: getfield 17	com/tencent/mm/ui/chatting/y$10:vmb	Lcom/tencent/mm/ui/chatting/y;
          //   31: invokestatic 40	com/tencent/mm/ui/chatting/y:a	(Lcom/tencent/mm/ui/chatting/y;)Landroid/widget/ListView;
          //   34: invokevirtual 46	android/widget/ListView:getLastVisiblePosition	()I
          //   37: istore_2
          //   38: iload_2
          //   39: iload 4
          //   41: iconst_1
          //   42: isub
          //   43: if_icmpeq +6 -> 49
          //   46: aload_0
          //   47: monitorexit
          //   48: return
          //   49: aload_0
          //   50: getfield 17	com/tencent/mm/ui/chatting/y$10:vmb	Lcom/tencent/mm/ui/chatting/y;
          //   53: invokestatic 49	com/tencent/mm/ui/chatting/y:j	(Lcom/tencent/mm/ui/chatting/y;)Z
          //   56: pop
          //   57: goto -11 -> 46
          //   60: astore_1
          //   61: aload_0
          //   62: monitorexit
          //   63: aload_1
          //   64: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	65	0	this	10
          //   0	65	1	paramAnonymousAbsListView	AbsListView
          //   0	65	2	paramAnonymousInt1	int
          //   0	65	3	paramAnonymousInt2	int
          //   0	65	4	paramAnonymousInt3	int
          // Exception table:
          //   from	to	target	type
          //   2	38	60	finally
          //   49	57	60	finally
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          y.this.vhT.onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
          y.a(y.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] [%s:%s]", new Object[] { Integer.valueOf(y.a(y.this).getFirstVisiblePosition()), Integer.valueOf(y.a(y.this).getLastVisiblePosition()) });
            if (y.a(y.this).getFirstVisiblePosition() != 0) {
              break label123;
            }
            paramAnonymousAbsListView = y.a(y.this).getChildAt(0);
            if ((paramAnonymousAbsListView != null) && (paramAnonymousAbsListView.getTop() == 0))
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load top more!");
              y.h(y.this).na(true);
            }
          }
          label123:
          do
          {
            do
            {
              return;
            } while (y.a(y.this).getLastVisiblePosition() != y.a(y.this).getCount() - 1);
            paramAnonymousAbsListView = y.a(y.this).getChildAt(y.a(y.this).getChildCount() - 1);
          } while ((paramAnonymousAbsListView == null) || (y.a(y.this).getBottom() - y.h(y.this).getBottomHeight() < paramAnonymousAbsListView.getBottom()));
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load bottom more!");
          y.h(y.this).nb(true);
        }
      });
      registerForContextMenu(this.vlR);
      nk(true);
      return;
      this.vlR.setTranscriptMode(0);
    }
  }
  
  public void cBU()
  {
    super.cBU();
    r.dismiss();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "on chatting ui pause  rawuser:%s", new Object[] { this.byx.getTalkerUserName() });
    if (this.byx.getTalkerUserName() == null) {
      return;
    }
    this.vlQ.pause();
    hideVKB();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUIFragment", "chattingui cancel pause auto download logic");
  }
  
  public final void cCW()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      nk(bool);
      return;
    }
  }
  
  public final void cCX()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "[smoothScrollBy] dis:%d duration:%d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.vlR.smoothScrollBy(0, 0);
  }
  
  public final void cCY()
  {
    this.vlT.setTopViewVisible(true);
  }
  
  public final void cCZ()
  {
    this.vlT.setIsTopShowAll(false);
  }
  
  public final void cCk()
  {
    super.cCk();
    if (this.byx.getTalkerUserName() == null) {}
  }
  
  public final t cCn()
  {
    if (this.byx.ac(q.class) == null) {
      return null;
    }
    return ((q)this.byx.ac(q.class)).cCn();
  }
  
  public final boolean cCo()
  {
    if (!isScreenEnable())
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingUIFragment", "Actionbar customView onclick screen not enable");
      return true;
    }
    y.7 local7 = new y.7(this);
    if (hideVKB())
    {
      ai.l(local7, 300L);
      return true;
    }
    local7.run();
    return true;
  }
  
  public final com.tencent.mm.ui.chatting.k.a.a cCp()
  {
    return this.vma;
  }
  
  public final void cCq()
  {
    if ((this.vlT == null) || (this.vlQ == null)) {
      return;
    }
    Object localObject1 = this.byx;
    Object localObject2 = new com.tencent.mm.ui.chatting.e.a(this.vlQ.vnR);
    com.tencent.mm.ui.chatting.e.b localb = new com.tencent.mm.ui.chatting.e.b(this.byx, this.vlT);
    localObject2 = new com.tencent.mm.ui.chatting.e.e(localb, (com.tencent.mm.ui.chatting.e.c)localObject2);
    if (((com.tencent.mm.ui.chatting.b.b.c)((com.tencent.mm.ui.chatting.c.a)localObject1).ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG()) {
      localObject1 = new com.tencent.mm.ui.chatting.k.a.b((com.tencent.mm.ui.chatting.c.a)localObject1, (com.tencent.mm.ui.chatting.e.e)localObject2);
    }
    for (;;)
    {
      localb.vya = ((b.a)localObject1);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingLoader.ChattingDataPresenterFactory", "[ChattingDataPresenterFactory] executor:%s", new Object[] { ((com.tencent.mm.ui.chatting.k.a.a)localObject1).toString() });
      this.vma = ((com.tencent.mm.ui.chatting.k.a.a)localObject1);
      this.vlQ.vob = this.vma;
      this.vlT.setLoadExecutor(this.vma);
      return;
      if (((o)((com.tencent.mm.ui.chatting.c.a)localObject1).ac(o.class)).cEB()) {
        localObject1 = new com.tencent.mm.ui.chatting.k.a.c((com.tencent.mm.ui.chatting.c.a)localObject1, (com.tencent.mm.ui.chatting.e.d)localObject2);
      } else if ((((com.tencent.mm.ui.chatting.b.b.y)((com.tencent.mm.ui.chatting.c.a)localObject1).ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFl()) || (((com.tencent.mm.ui.chatting.b.b.y)((com.tencent.mm.ui.chatting.c.a)localObject1).ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFj())) {
        localObject1 = new com.tencent.mm.ui.chatting.k.a.e((com.tencent.mm.ui.chatting.c.a)localObject1, (com.tencent.mm.ui.chatting.e.d)localObject2);
      } else {
        localObject1 = new com.tencent.mm.ui.chatting.k.a.d((com.tencent.mm.ui.chatting.c.a)localObject1, (com.tencent.mm.ui.chatting.e.e)localObject2);
      }
    }
  }
  
  public final void cDa()
  {
    this.vlT.na(false);
  }
  
  public final void cDb()
  {
    this.vlR.setTranscriptMode(0);
  }
  
  public final void cDc()
  {
    Object localObject = (com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class);
    if ((!((com.tencent.mm.ui.chatting.b.b.y)localObject).cFj()) && (!((com.tencent.mm.ui.chatting.b.b.y)localObject).cFl()))
    {
      int i = this.vlY;
      this.vlY = (i + 1);
      if ((i < 10) && (((thisActivity() instanceof ChattingUI)) || ((thisActivity() instanceof AppBrandServiceChattingUI))))
      {
        localObject = this.vlR;
        y.5 local5 = new y.5(this);
        if (this.vlY == 1) {}
        for (i = 10;; i = 100)
        {
          ((ListView)localObject).postDelayed(local5, i);
          return;
        }
      }
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingUIFragment", "scrollToLastProtect:%s, %s ,%s", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.b.b.y)localObject).cFj()), Boolean.valueOf(((com.tencent.mm.ui.chatting.b.b.y)localObject).cFl()), Integer.valueOf(this.vlY) });
  }
  
  protected final void cDd()
  {
    Object localObject = (com.tencent.mm.ui.chatting.b.b.h)this.byx.ac(com.tencent.mm.ui.chatting.b.b.h.class);
    com.tencent.mm.ui.chatting.b.b.y localy = (com.tencent.mm.ui.chatting.b.b.y)this.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class);
    if (((com.tencent.mm.ui.chatting.b.b.h)localObject).cEh())
    {
      if (localy.cFh())
      {
        localy.cFg();
        ((com.tencent.mm.ui.chatting.b.b.h)localObject).cEi();
      }
    }
    else
    {
      localObject = (com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class);
      if (!ad.aaR(this.byx.getTalkerUserName())) {
        break label129;
      }
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      com.tencent.mm.br.d.b(getContext(), "tmessage", ".ui.TConversationUI", (Intent)localObject);
    }
    label129:
    label291:
    do
    {
      for (;;)
      {
        finish();
        return;
        ((com.tencent.mm.ui.chatting.b.b.h)localObject).cEf();
        break;
        if (getIntExtra("chat_from_scene", 0) == 4)
        {
          finish();
          return;
        }
        if (((getIntExtra("chat_from_scene", 0) == 1) || (getIntExtra("chat_from_scene", 0) == 3)) && (this.byx.pSb != null) && (this.byx.pSb.cua()) && (((com.tencent.mm.ui.chatting.b.b.c)localObject).cDD() != null) && (((com.tencent.mm.ui.chatting.b.b.c)localObject).cDD().Lz()) && (((com.tencent.mm.ui.chatting.b.b.c)localObject).cDD().bS(false) != null) && (((com.tencent.mm.ui.chatting.b.b.c)localObject).cDD().bS(false).Mb() != null) && (!bk.bl(((com.tencent.mm.ui.chatting.b.b.c)localObject).cDD().LG())))
        {
          finish();
          return;
        }
        if (!((com.tencent.mm.ui.chatting.b.b.s)this.byx.ac(com.tencent.mm.ui.chatting.b.b.s.class)).cEW()) {
          break label291;
        }
        finish();
      }
    } while (getBooleanExtra("finish_direct", false).booleanValue());
    if (!this.isCurrentActivity)
    {
      finish();
      return;
    }
    localObject = new Intent(getContext(), LauncherUI.class);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    overridePendingTransition(MMFragmentActivity.a.uOg, MMFragmentActivity.a.uOh);
    finish();
  }
  
  public void cyT()
  {
    super.cyT();
    btn();
  }
  
  public final void cyV()
  {
    super.cyV();
    com.tencent.mm.ui.chatting.a.a locala = this.vlQ;
    locala.vnU = -1L;
    locala.vnT.clear();
    this.vma.vzL.cancel();
    btn();
  }
  
  public final void cyW()
  {
    super.cyW();
    dismissDialog();
  }
  
  protected void dealContentView(View paramView)
  {
    super.dealContentView(paramView);
    ((q)this.byx.ac(q.class)).dJ(paramView);
  }
  
  public final void dismissDialog()
  {
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
  }
  
  public void finish()
  {
    int i = 100;
    if (!hideVKB()) {
      i = 0;
    }
    ai.l(new y.8(this), i);
  }
  
  public final void fx(int paramInt1, int paramInt2)
  {
    com.tencent.mm.ui.chatting.c.a.cFG().removeCallbacks(this.vlS);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "[setSelectionFromTop] pos:%d offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(false) });
    j.a(this.vlR, paramInt1, paramInt2, false);
  }
  
  public final void gP(Context paramContext)
  {
    super.gP(paramContext);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingUIFragment", "[doAttach]:%s#0x%x task:%s hc:%d", new Object[] { thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), bk.fW(thisActivity()), Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.ap(3, true);
    }
  }
  
  public final int getBottomHeight()
  {
    return this.vlT.getBottomHeight();
  }
  
  public final int getFirstVisiblePosition()
  {
    return this.vlR.getFirstVisiblePosition();
  }
  
  protected int getLayoutId()
  {
    return R.i.chatting;
  }
  
  public final ListView getListView()
  {
    return this.vlR;
  }
  
  public final int getTopHeight()
  {
    return this.vlT.getTopHeight();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.byx.euf;
  }
  
  public boolean hideVKB()
  {
    ChatFooter localChatFooter = ((n)this.byx.ac(n.class)).cEq();
    if (localChatFooter != null) {
      return bk.hideVKB(localChatFooter);
    }
    return super.hideVKB();
  }
  
  public boolean isSupportCustomActionBar()
  {
    return isSupportNavigationSwipeBack();
  }
  
  public final void nb(boolean paramBoolean)
  {
    this.vlT.nb(paramBoolean);
  }
  
  @Deprecated
  public final void nk(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      com.tencent.mm.ui.chatting.c.a.cFG().removeCallbacks(this.vlS);
      ah localah = com.tencent.mm.ui.chatting.c.a.cFG();
      y.1 local1 = new y.1(this);
      this.vlS = local1;
      localah.postDelayed(local1, 10L);
      return;
    }
    nl(true);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 30763) || (paramInt1 == 30762)) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      paramIntent = paramIntent.getBundleExtra("result_data");
    } while ((paramIntent == null) || (!paramIntent.getString("go_next", "").equals("gdpr_auth_location")));
    g.DP().Dz().c(ac.a.uzP, Boolean.valueOf(true));
    if (paramInt1 == 30763)
    {
      com.tencent.mm.pluginsdk.permission.a.b(getActivity(), "android.permission.ACCESS_COARSE_LOCATION", 67);
      return;
    }
    com.tencent.mm.pluginsdk.permission.a.b(getActivity(), "android.permission.ACCESS_COARSE_LOCATION", 68);
  }
  
  public void onCancelDrag()
  {
    if ((isSupportNavigationSwipeBack()) && (this.vlQ != null)) {
      this.vlV = true;
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    if (!this.byx.euf) {
      return;
    }
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
  }
  
  public void onDragBegin()
  {
    if ((isSupportNavigationSwipeBack()) && (this.vlQ != null)) {
      this.vlV = false;
    }
  }
  
  public void onKeyboardStateChanged()
  {
    if (keyboardState() == 1) {
      this.vlR.post(new y.6(this));
    }
  }
  
  public void onSwipeBack()
  {
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingUIFragment", "onSwipeBack");
    cDd();
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    ((q)this.byx.ac(q.class)).setBackBtn(paramOnMenuItemClickListener);
  }
  
  public final void setBottomViewVisible(boolean paramBoolean)
  {
    this.vlT.setBottomViewVisible(paramBoolean);
  }
  
  public final void setIsBottomShowAll(boolean paramBoolean)
  {
    this.vlT.setIsBottomShowAll(paramBoolean);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    this.vlR.setKeepScreenOn(paramBoolean);
  }
  
  public void setMMSubTitle(int paramInt)
  {
    setMMSubTitle(getMMString(paramInt));
  }
  
  public void setMMSubTitle(String paramString)
  {
    ((q)this.byx.ac(q.class)).setMMSubTitle(paramString);
  }
  
  public void setMMTitle(int paramInt)
  {
    setMMTitle(getMMString(paramInt));
  }
  
  public void setMMTitle(String paramString)
  {
    ((q)this.byx.ac(q.class)).N(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.y
 * JD-Core Version:    0.7.0.1
 */