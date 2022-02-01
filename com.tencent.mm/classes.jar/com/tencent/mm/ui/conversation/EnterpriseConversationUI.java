package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.am.d.a;
import com.tencent.mm.am.d.a.a;
import com.tencent.mm.am.f;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.bizchat.BizChatSearchUI;
import com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI;
import com.tencent.mm.ui.conversation.presenter.a.b;
import com.tencent.mm.ui.q.a;
import com.tencent.mm.ui.y;
import java.util.HashMap;
import java.util.LinkedList;

public class EnterpriseConversationUI
  extends BaseBizConversationUI
{
  private View contentView;
  
  public void finish()
  {
    AppMethodBeat.i(38587);
    if ((this.conversationFm != null) && ((this.conversationFm instanceof EnterpriseConversationFmUI))) {
      ((EnterpriseConversationFmUI)this.conversationFm).huT = (System.currentTimeMillis() / 1000L);
    }
    super.finish();
    AppMethodBeat.o(38587);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38586);
    super.onCreate(paramBundle);
    this.contentView = y.js(this).inflate(2131493232, null);
    setContentView(this.contentView);
    this.conversationFm = new EnterpriseConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131302341, this.conversationFm).commit();
    com.tencent.mm.pluginsdk.g.a(this, this.contentView);
    AppMethodBeat.o(38586);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class EnterpriseConversationFmUI
    extends BaseConversationUI.BaseConversationFmUI
    implements n.b
  {
    private LinearLayout Ghk;
    private int Ghn;
    private d.a Ghr;
    private ListView HaB;
    private String HaD;
    private View Hel;
    private l Hem;
    private String Hen;
    private ap Heo;
    private int Hep;
    private String Heq;
    private com.tencent.mm.ui.conversation.presenter.a Her;
    private com.tencent.mm.ui.conversation.presenter.c Hes;
    private TextView emptyTipTv;
    private long enterTime;
    private int fromScene;
    private String gWU;
    long huT;
    private long mqz;
    
    public EnterpriseConversationFmUI()
    {
      AppMethodBeat.i(38568);
      this.Ghk = null;
      this.Hel = null;
      this.Hen = null;
      this.Ghn = 0;
      this.enterTime = 0L;
      this.huT = 0L;
      this.Hep = -2;
      this.mqz = 0L;
      this.Heq = null;
      this.Ghr = new d.a()
      {
        public final void a(d.a.a paramAnonymousa)
        {
          AppMethodBeat.i(191729);
          if ((paramAnonymousa != null) && (!bt.isNullOrNil(paramAnonymousa.gWU)) && (paramAnonymousa.gWU.equals(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this))))
          {
            int i = EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
            EnterpriseConversationUI.EnterpriseConversationFmUI.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this, com.tencent.mm.ui.g.ca(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)));
            if (EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this) != i) {
              EnterpriseConversationUI.EnterpriseConversationFmUI.k(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
            }
          }
          AppMethodBeat.o(191729);
        }
      };
      AppMethodBeat.o(38568);
    }
    
    private void eTO()
    {
      AppMethodBeat.i(38574);
      this.Ghn = com.tencent.mm.ui.g.ca(getContext(), this.gWU);
      Object localObject1;
      int i;
      Object localObject2;
      if ((this.Ghn == 2) && (this.Ghk == null))
      {
        this.Ghk = ((LinearLayout)findViewById(2131297432));
        localObject1 = this.Ghk.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.ao(getContext(), 2131165256);
        this.Ghk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.Hel = y.js(getContext()).inflate(2131493849, this.Ghk, false);
        float f = com.tencent.mm.cd.a.dT(getContext());
        localObject1 = (CdnImageView)this.Hel.findViewById(2131300891);
        i = ((CdnImageView)localObject1).getLayoutParams().height;
        ((CdnImageView)localObject1).getLayoutParams().height = ((int)(i * f));
        ((CdnImageView)localObject1).getLayoutParams().width = ((int)(f * i));
        ((CdnImageView)localObject1).requestLayout();
        localObject2 = (TextView)this.Hel.findViewById(2131305948);
        com.tencent.mm.am.af.awn();
        com.tencent.mm.am.af.awn();
        String str = com.tencent.mm.am.d.nG(0);
        if ((str == null) || (str.length() <= 0)) {
          break label343;
        }
        ((TextView)localObject2).setText(str);
      }
      for (;;)
      {
        com.tencent.mm.am.af.awn();
        i = com.tencent.mm.am.d.avy();
        if (i != 0) {
          ((TextView)localObject2).setTextColor(i);
        }
        com.tencent.mm.am.af.awn();
        localObject2 = com.tencent.mm.am.d.avx();
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          ((CdnImageView)localObject1).setUrl((String)localObject2);
        }
        com.tencent.mm.ui.g.aL(this.gWU, 1, 2);
        this.Ghk.addView(this.Hel);
        this.Hel.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(38560);
            com.tencent.mm.ui.g.u(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), 3);
            AppMethodBeat.o(38560);
          }
        });
        com.tencent.mm.ui.g.t(getContext(), this.gWU, 3);
        com.tencent.mm.ui.g.cb(getContext(), this.gWU);
        if (this.Ghk == null) {
          break label363;
        }
        if (this.Ghn != 2) {
          break;
        }
        this.Ghk.setVisibility(0);
        fcw();
        AppMethodBeat.o(38574);
        return;
        label343:
        ((TextView)localObject2).setText(2131758452);
      }
      this.Ghk.setVisibility(8);
      label363:
      AppMethodBeat.o(38574);
    }
    
    private void fcw()
    {
      AppMethodBeat.i(38575);
      com.tencent.mm.am.c localc = com.tencent.mm.am.af.awn().wt(this.gWU);
      int i;
      int j;
      label40:
      long l1;
      if (localc != null)
      {
        i = localc.field_qyUin;
        if (localc == null) {
          break label190;
        }
        j = localc.field_userUin;
        if (localc == null) {
          break label195;
        }
        l1 = localc.field_wwCorpId;
        label51:
        if (localc == null) {
          break label200;
        }
      }
      label190:
      label195:
      label200:
      for (long l2 = localc.field_wwUserVid;; l2 = 0L)
      {
        h.vKh.f(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
        ad.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
        AppMethodBeat.o(38575);
        return;
        i = 0;
        break;
        j = 0;
        break label40;
        l1 = 0L;
        break label51;
      }
    }
    
    public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject) {}
    
    public int getLayoutId()
    {
      return 2131493848;
    }
    
    public String getUserName()
    {
      return this.gWU;
    }
    
    public void onActivityCreated(final Bundle paramBundle)
    {
      AppMethodBeat.i(38569);
      super.onActivityCreated(paramBundle);
      this.gWU = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
      this.HaD = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
      this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
      setMMTitle(this.HaD);
      this.HaB = ((ListView)findViewById(2131305951));
      this.emptyTipTv = ((TextView)findViewById(2131299468));
      this.emptyTipTv.setText(2131758439);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38546);
          EnterpriseConversationUI.EnterpriseConversationFmUI.this.finish();
          AppMethodBeat.o(38546);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38558);
          paramAnonymousView = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(38558);
        }
      });
      if (f.ei(this.gWU) != null)
      {
        eTO();
        if (this.gWU != null)
        {
          paramBundle = new com.tencent.mm.al.g()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
            {
              AppMethodBeat.i(38559);
              EnterpriseConversationUI.EnterpriseConversationFmUI.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
              AppMethodBeat.o(38559);
            }
          };
          com.tencent.mm.am.af.awn();
          com.tencent.mm.am.d.a(this.gWU, paramBundle);
          ad.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", new Object[] { this.gWU });
          addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(38561);
              Object localObject = new Intent(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), BizChatSearchUI.class);
              com.tencent.mm.am.af.awe();
              ((Intent)localObject).putExtra("enterprise_biz_name", com.tencent.mm.am.e.wC(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)));
              ((Intent)localObject).putExtra("enterprise_biz_father_name", EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
              ((Intent)localObject).putExtra("biz_chat_search_scene", 1);
              ((Intent)localObject).putExtra("biz_chat_search_text", "");
              ((Intent)localObject).addFlags(67108864);
              paramAnonymousMenuItem = EnterpriseConversationUI.EnterpriseConversationFmUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(38561);
              return true;
            }
          });
          addIconOptionMenu(2, 2131755134, 2131689489, new com.tencent.mm.ui.conversation.presenter.b(this.ui, this.gWU));
          this.Hem = new l(thisActivity(), this.gWU, new q.a()
          {
            public final void aIp()
            {
              AppMethodBeat.i(191730);
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getCount());
              AppMethodBeat.o(191730);
            }
          });
          paramBundle = this.Hem;
          Object localObject = new MMSlideDelView.c()
          {
            public final int dw(View paramAnonymousView)
            {
              AppMethodBeat.i(191731);
              int i = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getPositionForView(paramAnonymousView);
              AppMethodBeat.o(191731);
              return i;
            }
          };
          paramBundle.Hff.setGetViewPositionCallback((MMSlideDelView.c)localObject);
          paramBundle.Hfg.setGetViewPositionCallback((MMSlideDelView.c)localObject);
          paramBundle = this.Hem;
          localObject = new MMSlideDelView.g()
          {
            public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(191732);
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(191732);
            }
          };
          paramBundle.Hff.setPerformItemClickListener((MMSlideDelView.g)localObject);
          paramBundle.Hfg.setPerformItemClickListener((MMSlideDelView.g)localObject);
          paramBundle = this.Hem;
          localObject = new MMSlideDelView.f()
          {
            public final void cO(Object paramAnonymousObject)
            {
              AppMethodBeat.i(191733);
              if (paramAnonymousObject == null)
              {
                ad.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
                AppMethodBeat.o(191733);
                return;
              }
              paramAnonymousObject = paramAnonymousObject.toString();
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousObject);
              AppMethodBeat.o(191733);
            }
          };
          paramBundle.Hff.a((MMSlideDelView.f)localObject);
          paramBundle.Hfg.a((MMSlideDelView.f)localObject);
          this.HaB.setAdapter(this.Hem);
          this.HaB.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(191725);
              paramAnonymousAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).ZP(paramAnonymousInt);
              paramAnonymousView = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousAdapterView);
              if (paramAnonymousView == null)
              {
                ad.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getCount()) });
                EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).notifyDataSetChanged();
                AppMethodBeat.o(191725);
                return;
              }
              paramAnonymousView.a(paramAnonymousAdapterView);
              AppMethodBeat.o(191725);
            }
          });
          paramBundle = new Point();
          this.HaB.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(191727);
              if (paramAnonymousMotionEvent.getAction() == 0)
              {
                paramBundle.x = ((int)paramAnonymousMotionEvent.getRawX());
                paramBundle.y = ((int)paramAnonymousMotionEvent.getRawY());
              }
              AppMethodBeat.o(191727);
              return false;
            }
          });
          this.HaB.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
          {
            public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(38550);
              paramAnonymousAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).ZP(paramAnonymousInt);
              com.tencent.mm.ui.conversation.presenter.d locald = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousAdapterView);
              if (locald == null)
              {
                AppMethodBeat.o(38550);
                return false;
              }
              boolean bool = locald.a(paramAnonymousView, paramBundle, paramAnonymousInt, paramAnonymousLong, paramAnonymousAdapterView);
              AppMethodBeat.o(38550);
              return bool;
            }
          });
        }
      }
      else
      {
        this.enterTime = (System.currentTimeMillis() / 1000L);
        az.arV();
        paramBundle = com.tencent.mm.model.c.apR().aIn(this.gWU);
        if (paramBundle != null)
        {
          this.Hep = paramBundle.field_unReadCount;
          if ((this.Hep == 0) && (paramBundle.field_unReadMuteCount > 0)) {
            this.Hep = -1;
          }
          this.mqz = (paramBundle.field_conversationTime / 1000L);
          if (paramBundle.field_isSend != 1) {
            break label608;
          }
          paramBundle = null;
          label504:
          this.Heq = paramBundle;
        }
        com.tencent.mm.am.af.awn().a(this.Ghr, thisActivity().getMainLooper());
        az.arV();
        com.tencent.mm.model.c.apR().a(this);
        az.arV();
        com.tencent.mm.model.c.apM().a(this);
        if (this.Hem != null)
        {
          if (this.Heo != null) {
            break label616;
          }
          this.Heo = new ap()
          {
            public final void handleMessage(Message paramAnonymousMessage)
            {
              AppMethodBeat.i(191728);
              int i1;
              LinkedList localLinkedList1;
              LinkedList localLinkedList2;
              int j;
              int k;
              int i;
              int m;
              label106:
              String str;
              if ((paramAnonymousMessage != null) && (paramAnonymousMessage.what == 1) && (EnterpriseConversationUI.EnterpriseConversationFmUI.this.thisActivity() != null) && (!EnterpriseConversationUI.EnterpriseConversationFmUI.this.thisActivity().isFinishing()))
              {
                i1 = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getCount();
                localLinkedList1 = new LinkedList();
                localLinkedList2 = new LinkedList();
                j = 0;
                k = 0;
                i = 0;
                m = 0;
                if (m < i1)
                {
                  paramAnonymousMessage = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).ZP(m);
                  if (paramAnonymousMessage == null)
                  {
                    paramAnonymousMessage = null;
                    if (paramAnonymousMessage == null) {
                      break label858;
                    }
                    str = paramAnonymousMessage.field_username;
                    if (str == null) {
                      break label858;
                    }
                    if ((w.sD(str)) && (f.wN(str))) {
                      break label178;
                    }
                    ad.d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", new Object[] { str });
                    localLinkedList1.add(str);
                  }
                }
              }
              label178:
              label317:
              label840:
              label846:
              label852:
              label858:
              for (;;)
              {
                m += 1;
                break;
                paramAnonymousMessage = paramAnonymousMessage.conversation;
                break label106;
                com.tencent.mm.storage.af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str);
                boolean bool = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIv(str);
                int n;
                if ((localaf != null) && ((localaf.field_type & 0x800) != 0))
                {
                  n = 1;
                  label242:
                  if ((n == 0) || (bool)) {
                    break label317;
                  }
                  ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIt(str);
                }
                for (;;)
                {
                  if (f.wM(str)) {
                    localLinkedList2.add(str);
                  }
                  if (paramAnonymousMessage.field_unReadCount <= 0) {
                    break label858;
                  }
                  if (!w.tt(str)) {
                    break label351;
                  }
                  j += 1;
                  break;
                  n = 0;
                  break label242;
                  if ((n == 0) && (bool)) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIu(str);
                  }
                }
                label351:
                k += 1;
                i = paramAnonymousMessage.field_unReadCount + i;
                continue;
                paramAnonymousMessage = com.tencent.mm.am.af.awn().wt(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                long l1;
                if (paramAnonymousMessage != null)
                {
                  m = paramAnonymousMessage.field_qyUin;
                  if (paramAnonymousMessage == null) {
                    break label840;
                  }
                  l1 = paramAnonymousMessage.field_wwCorpId;
                  if (paramAnonymousMessage == null) {
                    break label846;
                  }
                }
                for (long l2 = paramAnonymousMessage.field_wwUserVid;; l2 = 0L)
                {
                  n = 0;
                  if (!bt.isNullOrNil(EnterpriseConversationUI.EnterpriseConversationFmUI.e(EnterpriseConversationUI.EnterpriseConversationFmUI.this))) {
                    n = com.tencent.mm.am.af.awn().wv(EnterpriseConversationUI.EnterpriseConversationFmUI.e(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                  }
                  h.vKh.f(12892, new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                  ad.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                  if (localLinkedList1.size() > 0)
                  {
                    az.arV();
                    com.tencent.mm.model.c.apR().be(localLinkedList1);
                    EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).Wd();
                  }
                  if (com.tencent.mm.am.af.awq().ws(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)))
                  {
                    com.tencent.mm.am.af.awn();
                    com.tencent.mm.am.d.a(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), null);
                  }
                  com.tencent.mm.am.af.awq().ws(EnterpriseConversationUI.EnterpriseConversationFmUI.i(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                  if (localLinkedList2.size() <= 0) {
                    break label852;
                  }
                  i = 0;
                  while (i < localLinkedList2.size())
                  {
                    com.tencent.mm.am.af.awq().ws((String)localLinkedList2.get(i));
                    i += 1;
                  }
                  m = 0;
                  break;
                  l1 = 0L;
                  break label401;
                }
                AppMethodBeat.o(191728);
                return;
              }
            }
          };
        }
      }
      for (;;)
      {
        this.Heo.sendEmptyMessageDelayed(1, 500L);
        AppMethodBeat.o(38569);
        return;
        ad.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
        break;
        label608:
        paramBundle = paramBundle.field_digestUser;
        break label504;
        label616:
        this.Heo.removeMessages(1);
      }
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(38573);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(38573);
        return;
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("be_send_card_name");
        String str2 = paramIntent.getStringExtra("received_card_name");
        boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        com.tencent.mm.plugin.messenger.a.j.cOB().q(str1, str2, bool);
        com.tencent.mm.plugin.messenger.a.j.cOB().hm(paramIntent, str2);
        com.tencent.mm.ui.widget.snackbar.b.n(thisActivity(), getContext().getString(2131759420));
        AppMethodBeat.o(38573);
        return;
      }
      AppMethodBeat.o(38573);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(38570);
      com.tencent.mm.am.af.awn().a(this.Ghr);
      if (az.afw())
      {
        az.arV();
        com.tencent.mm.model.c.apR().b(this);
        az.arV();
        com.tencent.mm.model.c.apM().b(this);
      }
      if (this.Hem != null)
      {
        localObject = this.Hem;
        j localj = ((l)localObject).Hff;
        localj.Hbs.stopTimer();
        if (localj.GgX != null)
        {
          localj.GgX.clear();
          localj.GgX = null;
        }
        localj.cHX();
        localj.ePu();
        az.arV();
        com.tencent.mm.model.c.apR().b(localj);
        ((l)localObject).Hfg.onDestroy();
      }
      if (this.Hes != null)
      {
        localObject = this.Hes;
        az.aeS().b(1394, (com.tencent.mm.al.g)localObject);
      }
      if ((this.enterTime <= 0L) || (this.huT <= 0L))
      {
        super.onDestroy();
        AppMethodBeat.o(38570);
        return;
      }
      long l = this.huT - this.enterTime;
      Object localObject = com.tencent.mm.am.af.awn().wt(this.gWU);
      int i;
      if (localObject != null)
      {
        i = ((com.tencent.mm.am.c)localObject).field_qyUin;
        label216:
        if (localObject == null) {
          break label337;
        }
      }
      label337:
      for (int j = ((com.tencent.mm.am.c)localObject).field_userUin;; j = 0)
      {
        h.vKh.f(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
        ad.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
        break;
        i = 0;
        break label216;
      }
    }
    
    public void onPause()
    {
      AppMethodBeat.i(38572);
      ad.v("MicroMsg.EnterpriseConversationUI", "on pause");
      az.arV();
      com.tencent.mm.model.c.apR().aIp(this.gWU);
      if (this.Hem != null)
      {
        l locall = this.Hem;
        locall.Hff.onPause();
        locall.Hfg.onPause();
      }
      super.onPause();
      AppMethodBeat.o(38572);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(38571);
      ad.v("MicroMsg.EnterpriseConversationUI", "on resume");
      Object localObject;
      if (this.Her != null)
      {
        localObject = this.Her;
        if (0L != ((com.tencent.mm.ui.conversation.presenter.a)localObject).HhQ)
        {
          if (((com.tencent.mm.ui.conversation.presenter.a)localObject).HhP != null) {
            ((com.tencent.mm.ui.conversation.presenter.a)localObject).HhP.wU(((com.tencent.mm.ui.conversation.presenter.a)localObject).HhQ);
          }
          ((com.tencent.mm.ui.conversation.presenter.a)localObject).HhQ = 0L;
        }
      }
      if (this.Hem != null)
      {
        localObject = this.Hem;
        ((l)localObject).Hff.onResume();
        ((l)localObject).Hfg.onResume();
      }
      super.onResume();
      if (!w.sD(this.gWU)) {
        finish();
      }
      AppMethodBeat.o(38571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI
 * JD-Core Version:    0.7.0.1
 */