package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.al.af;
import com.tencent.mm.al.d.a;
import com.tencent.mm.al.d.a.a;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.bizchat.BizChatSearchUI;
import com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI;
import com.tencent.mm.ui.conversation.presenter.a.b;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.z;
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
      ((EnterpriseConversationFmUI)this.conversationFm).hVv = (System.currentTimeMillis() / 1000L);
    }
    super.finish();
    AppMethodBeat.o(38587);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38586);
    super.onCreate(paramBundle);
    this.contentView = z.jD(this).inflate(2131493232, null);
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
    private LinearLayout HGZ;
    private int HHc;
    private d.a HHg;
    private ListView IAT;
    private String IAV;
    private String IEA;
    private ao IEB;
    private int IEC;
    private String IED;
    private com.tencent.mm.ui.conversation.presenter.a IEE;
    private com.tencent.mm.ui.conversation.presenter.c IEF;
    private View IEy;
    private l IEz;
    private TextView emptyTipTv;
    private long enterTime;
    private int fromScene;
    long hVv;
    private String hxt;
    private long mSB;
    
    public EnterpriseConversationFmUI()
    {
      AppMethodBeat.i(38568);
      this.HGZ = null;
      this.IEy = null;
      this.IEA = null;
      this.HHc = 0;
      this.enterTime = 0L;
      this.hVv = 0L;
      this.IEC = -2;
      this.mSB = 0L;
      this.IED = null;
      this.HHg = new d.a()
      {
        public final void a(d.a.a paramAnonymousa)
        {
          AppMethodBeat.i(196827);
          if ((paramAnonymousa != null) && (!bs.isNullOrNil(paramAnonymousa.hxt)) && (paramAnonymousa.hxt.equals(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this))))
          {
            int i = EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
            EnterpriseConversationUI.EnterpriseConversationFmUI.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this, com.tencent.mm.ui.g.cb(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)));
            if (EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this) != i) {
              EnterpriseConversationUI.EnterpriseConversationFmUI.k(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
            }
          }
          AppMethodBeat.o(196827);
        }
      };
      AppMethodBeat.o(38568);
    }
    
    private void fjB()
    {
      AppMethodBeat.i(38574);
      this.HHc = com.tencent.mm.ui.g.cb(getContext(), this.hxt);
      Object localObject1;
      int i;
      Object localObject2;
      if ((this.HHc == 2) && (this.HGZ == null))
      {
        this.HGZ = ((LinearLayout)findViewById(2131297432));
        localObject1 = this.HGZ.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cc.a.au(getContext(), 2131165256);
        this.HGZ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.IEy = z.jD(getContext()).inflate(2131493849, this.HGZ, false);
        float f = com.tencent.mm.cc.a.eb(getContext());
        localObject1 = (CdnImageView)this.IEy.findViewById(2131300891);
        i = ((CdnImageView)localObject1).getLayoutParams().height;
        ((CdnImageView)localObject1).getLayoutParams().height = ((int)(i * f));
        ((CdnImageView)localObject1).getLayoutParams().width = ((int)(f * i));
        ((CdnImageView)localObject1).requestLayout();
        localObject2 = (TextView)this.IEy.findViewById(2131305948);
        af.aDf();
        af.aDf();
        String str = com.tencent.mm.al.d.ou(0);
        if ((str == null) || (str.length() <= 0)) {
          break label345;
        }
        ((TextView)localObject2).setText(str);
      }
      for (;;)
      {
        af.aDf();
        i = com.tencent.mm.al.d.aCr();
        if (i != 0) {
          ((TextView)localObject2).setTextColor(i);
        }
        af.aDf();
        localObject2 = com.tencent.mm.al.d.aCq();
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          ((CdnImageView)localObject1).setUrl((String)localObject2);
        }
        com.tencent.mm.ui.g.aO(this.hxt, 1, 2);
        this.HGZ.addView(this.IEy);
        this.IEy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(38560);
            com.tencent.mm.ui.g.u(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), 3);
            AppMethodBeat.o(38560);
          }
        });
        com.tencent.mm.ui.g.t(getContext(), this.hxt, 3);
        com.tencent.mm.ui.g.cc(getContext(), this.hxt);
        if (this.HGZ == null) {
          break label365;
        }
        if (this.HHc != 2) {
          break;
        }
        this.HGZ.setVisibility(0);
        fsr();
        AppMethodBeat.o(38574);
        return;
        label345:
        ((TextView)localObject2).setText(2131758452);
      }
      this.HGZ.setVisibility(8);
      label365:
      AppMethodBeat.o(38574);
    }
    
    private void fsr()
    {
      AppMethodBeat.i(38575);
      com.tencent.mm.al.c localc = af.aDf().Az(this.hxt);
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
        h.wUl.f(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
        ac.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
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
      return this.hxt;
    }
    
    public void onActivityCreated(final Bundle paramBundle)
    {
      AppMethodBeat.i(38569);
      super.onActivityCreated(paramBundle);
      this.hxt = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
      this.IAV = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
      this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
      setMMTitle(this.IAV);
      this.IAT = ((ListView)findViewById(2131305951));
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
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(38558);
        }
      });
      if (f.dX(this.hxt) != null)
      {
        fjB();
        if (this.hxt != null)
        {
          paramBundle = new com.tencent.mm.ak.g()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(38559);
              EnterpriseConversationUI.EnterpriseConversationFmUI.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
              AppMethodBeat.o(38559);
            }
          };
          af.aDf();
          com.tencent.mm.al.d.a(this.hxt, paramBundle);
          ac.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", new Object[] { this.hxt });
          addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(38561);
              af.aCW();
              Object localObject = com.tencent.mm.al.e.AI(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
              if (TextUtils.isEmpty((CharSequence)localObject))
              {
                paramAnonymousMenuItem = new Intent();
                paramAnonymousMenuItem.putExtra("enterprise_biz_name", EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                paramAnonymousMenuItem.addFlags(67108864);
                com.tencent.mm.br.d.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), "brandservice", ".ui.EnterpriseBizSearchUI", paramAnonymousMenuItem);
              }
              for (;;)
              {
                AppMethodBeat.o(38561);
                return true;
                paramAnonymousMenuItem = new Intent(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), BizChatSearchUI.class);
                paramAnonymousMenuItem.putExtra("enterprise_biz_name", (String)localObject);
                paramAnonymousMenuItem.putExtra("enterprise_biz_father_name", EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                paramAnonymousMenuItem.putExtra("biz_chat_search_scene", 1);
                paramAnonymousMenuItem.putExtra("biz_chat_search_text", "");
                paramAnonymousMenuItem.addFlags(67108864);
                localObject = EnterpriseConversationUI.EnterpriseConversationFmUI.this;
                paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousMenuItem);
                com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousMenuItem.aeD(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((EnterpriseConversationUI.EnterpriseConversationFmUI)localObject).startActivity((Intent)paramAnonymousMenuItem.lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          });
          addIconOptionMenu(2, 2131755134, 2131689489, new com.tencent.mm.ui.conversation.presenter.b(this.ui, this.hxt));
          this.IEz = new l(thisActivity(), this.hxt, new r.a()
          {
            public final void aPg()
            {
              AppMethodBeat.i(196828);
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getCount());
              AppMethodBeat.o(196828);
            }
          });
          paramBundle = this.IEz;
          Object localObject = new MMSlideDelView.c()
          {
            public final int dy(View paramAnonymousView)
            {
              AppMethodBeat.i(196829);
              int i = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getPositionForView(paramAnonymousView);
              AppMethodBeat.o(196829);
              return i;
            }
          };
          paramBundle.IFy.setGetViewPositionCallback((MMSlideDelView.c)localObject);
          paramBundle.IFz.setGetViewPositionCallback((MMSlideDelView.c)localObject);
          paramBundle = this.IEz;
          localObject = new MMSlideDelView.g()
          {
            public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(196830);
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(196830);
            }
          };
          paramBundle.IFy.setPerformItemClickListener((MMSlideDelView.g)localObject);
          paramBundle.IFz.setPerformItemClickListener((MMSlideDelView.g)localObject);
          paramBundle = this.IEz;
          localObject = new MMSlideDelView.f()
          {
            public final void cN(Object paramAnonymousObject)
            {
              AppMethodBeat.i(196831);
              if (paramAnonymousObject == null)
              {
                ac.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
                AppMethodBeat.o(196831);
                return;
              }
              paramAnonymousObject = paramAnonymousObject.toString();
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousObject);
              AppMethodBeat.o(196831);
            }
          };
          paramBundle.IFy.a((MMSlideDelView.f)localObject);
          paramBundle.IFz.a((MMSlideDelView.f)localObject);
          this.IAT.setAdapter(this.IEz);
          this.IAT.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(196823);
              paramAnonymousAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).acc(paramAnonymousInt);
              paramAnonymousView = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousAdapterView);
              if (paramAnonymousView == null)
              {
                ac.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getCount()) });
                EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).notifyDataSetChanged();
                AppMethodBeat.o(196823);
                return;
              }
              paramAnonymousView.a(paramAnonymousAdapterView);
              AppMethodBeat.o(196823);
            }
          });
          paramBundle = new Point();
          this.IAT.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(196825);
              if (paramAnonymousMotionEvent.getAction() == 0)
              {
                paramBundle.x = ((int)paramAnonymousMotionEvent.getRawX());
                paramBundle.y = ((int)paramAnonymousMotionEvent.getRawY());
              }
              AppMethodBeat.o(196825);
              return false;
            }
          });
          this.IAT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
          {
            public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(38550);
              paramAnonymousAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).acc(paramAnonymousInt);
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
        com.tencent.mm.model.az.ayM();
        paramBundle = com.tencent.mm.model.c.awG().aNI(this.hxt);
        if (paramBundle != null)
        {
          this.IEC = paramBundle.field_unReadCount;
          if ((this.IEC == 0) && (paramBundle.field_unReadMuteCount > 0)) {
            this.IEC = -1;
          }
          this.mSB = (paramBundle.field_conversationTime / 1000L);
          if (paramBundle.field_isSend != 1) {
            break label608;
          }
          paramBundle = null;
          label504:
          this.IED = paramBundle;
        }
        af.aDf().a(this.HHg, thisActivity().getMainLooper());
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awG().a(this);
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awB().a(this);
        if (this.IEz != null)
        {
          if (this.IEB != null) {
            break label616;
          }
          this.IEB = new ao()
          {
            public final void handleMessage(Message paramAnonymousMessage)
            {
              AppMethodBeat.i(196826);
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
                  paramAnonymousMessage = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).acc(m);
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
                    if ((w.wG(str)) && (f.AT(str))) {
                      break label178;
                    }
                    ac.d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", new Object[] { str });
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
                ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str);
                boolean bool = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNQ(str);
                int n;
                if ((localai != null) && ((localai.field_type & 0x800) != 0))
                {
                  n = 1;
                  label242:
                  if ((n == 0) || (bool)) {
                    break label317;
                  }
                  ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNO(str);
                }
                for (;;)
                {
                  if (f.AS(str)) {
                    localLinkedList2.add(str);
                  }
                  if (paramAnonymousMessage.field_unReadCount <= 0) {
                    break label858;
                  }
                  if (!w.xw(str)) {
                    break label351;
                  }
                  j += 1;
                  break;
                  n = 0;
                  break label242;
                  if ((n == 0) && (bool)) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNP(str);
                  }
                }
                label351:
                k += 1;
                i = paramAnonymousMessage.field_unReadCount + i;
                continue;
                paramAnonymousMessage = af.aDf().Az(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
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
                  if (!bs.isNullOrNil(EnterpriseConversationUI.EnterpriseConversationFmUI.e(EnterpriseConversationUI.EnterpriseConversationFmUI.this))) {
                    n = af.aDf().AB(EnterpriseConversationUI.EnterpriseConversationFmUI.e(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                  }
                  h.wUl.f(12892, new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                  ac.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                  if (localLinkedList1.size() > 0)
                  {
                    com.tencent.mm.model.az.ayM();
                    com.tencent.mm.model.c.awG().bl(localLinkedList1);
                    EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).Xb();
                  }
                  if (af.aDi().Ay(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)))
                  {
                    af.aDf();
                    com.tencent.mm.al.d.a(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), null);
                  }
                  af.aDi().Ay(EnterpriseConversationUI.EnterpriseConversationFmUI.i(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                  if (localLinkedList2.size() <= 0) {
                    break label852;
                  }
                  i = 0;
                  while (i < localLinkedList2.size())
                  {
                    af.aDi().Ay((String)localLinkedList2.get(i));
                    i += 1;
                  }
                  m = 0;
                  break;
                  l1 = 0L;
                  break label401;
                }
                AppMethodBeat.o(196826);
                return;
              }
            }
          };
        }
      }
      for (;;)
      {
        this.IEB.sendEmptyMessageDelayed(1, 500L);
        AppMethodBeat.o(38569);
        return;
        ac.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
        break;
        label608:
        paramBundle = paramBundle.field_digestUser;
        break label504;
        label616:
        this.IEB.removeMessages(1);
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
        com.tencent.mm.plugin.messenger.a.j.dck().q(str1, str2, bool);
        com.tencent.mm.plugin.messenger.a.j.dck().hF(paramIntent, str2);
        com.tencent.mm.ui.widget.snackbar.b.n(thisActivity(), getContext().getString(2131759420));
        AppMethodBeat.o(38573);
        return;
      }
      AppMethodBeat.o(38573);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(38570);
      af.aDf().a(this.HHg);
      if (com.tencent.mm.model.az.agM())
      {
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awG().b(this);
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awB().b(this);
      }
      if (this.IEz != null)
      {
        localObject = this.IEz;
        j localj = ((l)localObject).IFy;
        localj.IBz.stopTimer();
        if (localj.HGM != null)
        {
          localj.HGM.clear();
          localj.HGM = null;
        }
        localj.cVi();
        localj.feY();
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awG().b(localj);
        ((l)localObject).IFz.onDestroy();
      }
      if (this.IEF != null)
      {
        localObject = this.IEF;
        com.tencent.mm.model.az.agi().b(1394, (com.tencent.mm.ak.g)localObject);
      }
      if ((this.enterTime <= 0L) || (this.hVv <= 0L))
      {
        super.onDestroy();
        AppMethodBeat.o(38570);
        return;
      }
      long l = this.hVv - this.enterTime;
      Object localObject = af.aDf().Az(this.hxt);
      int i;
      if (localObject != null)
      {
        i = ((com.tencent.mm.al.c)localObject).field_qyUin;
        label216:
        if (localObject == null) {
          break label337;
        }
      }
      label337:
      for (int j = ((com.tencent.mm.al.c)localObject).field_userUin;; j = 0)
      {
        h.wUl.f(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
        ac.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
        break;
        i = 0;
        break label216;
      }
    }
    
    public void onPause()
    {
      AppMethodBeat.i(38572);
      ac.v("MicroMsg.EnterpriseConversationUI", "on pause");
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awG().aNK(this.hxt);
      if (this.IEz != null)
      {
        l locall = this.IEz;
        locall.IFy.onPause();
        locall.IFz.onPause();
      }
      super.onPause();
      AppMethodBeat.o(38572);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(38571);
      ac.v("MicroMsg.EnterpriseConversationUI", "on resume");
      Object localObject;
      if (this.IEE != null)
      {
        localObject = this.IEE;
        if (0L != ((com.tencent.mm.ui.conversation.presenter.a)localObject).IIj)
        {
          if (((com.tencent.mm.ui.conversation.presenter.a)localObject).IIi != null) {
            ((com.tencent.mm.ui.conversation.presenter.a)localObject).IIi.Bx(((com.tencent.mm.ui.conversation.presenter.a)localObject).IIj);
          }
          ((com.tencent.mm.ui.conversation.presenter.a)localObject).IIj = 0L;
        }
      }
      if (this.IEz != null)
      {
        localObject = this.IEz;
        ((l)localObject).IFy.onResume();
        ((l)localObject).IFz.onResume();
      }
      super.onResume();
      if (!w.wG(this.hxt)) {
        finish();
      }
      AppMethodBeat.o(38571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI
 * JD-Core Version:    0.7.0.1
 */