package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.e;
import com.tencent.mm.an.e.a;
import com.tencent.mm.an.e.a.a;
import com.tencent.mm.an.f;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.bizchat.BizChatSearchUI;
import com.tencent.mm.ui.conversation.presenter.BaseBizConversationUI;
import com.tencent.mm.ui.conversation.presenter.a.b;
import com.tencent.mm.ui.i;
import com.tencent.mm.ui.x.a;
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
      ((EnterpriseConversationFmUI)this.conversationFm).oVP = (System.currentTimeMillis() / 1000L);
    }
    super.finish();
    AppMethodBeat.o(38587);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38586);
    super.onCreate(paramBundle);
    this.contentView = com.tencent.mm.ui.af.mU(this).inflate(R.i.geL, null);
    setContentView(this.contentView);
    this.conversationFm = new EnterpriseConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(R.h.fOk, this.conversationFm).FW();
    com.tencent.mm.pluginsdk.h.b(this, this.contentView);
    AppMethodBeat.o(38586);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class EnterpriseConversationFmUI
    extends BaseConversationUI.BaseConversationFmUI
    implements MStorageEx.IOnStorageChange
  {
    private LinearLayout aebp;
    private int aebs;
    private e.a aebw;
    private String afpa;
    private View afpb;
    private ListView afpc;
    private o afpd;
    private String afpe;
    private MMHandler afpf;
    private int afpg;
    private String afph;
    private com.tencent.mm.ui.conversation.presenter.a afpi;
    private com.tencent.mm.ui.conversation.presenter.c afpj;
    private TextView emptyTipTv;
    private long enterTime;
    private int fromScene;
    long oVP;
    private String ovT;
    private long uWw;
    
    public EnterpriseConversationFmUI()
    {
      AppMethodBeat.i(38568);
      this.aebp = null;
      this.afpb = null;
      this.afpe = null;
      this.aebs = 0;
      this.enterTime = 0L;
      this.oVP = 0L;
      this.afpg = -2;
      this.uWw = 0L;
      this.afph = null;
      this.aebw = new e.a()
      {
        public final void a(e.a.a paramAnonymousa)
        {
          AppMethodBeat.i(256678);
          if ((paramAnonymousa != null) && (!Util.isNullOrNil(paramAnonymousa.ovT)) && (paramAnonymousa.ovT.equals(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this))))
          {
            int i = EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
            EnterpriseConversationUI.EnterpriseConversationFmUI.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this, i.cT(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)));
            if (EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this) != i) {
              EnterpriseConversationUI.EnterpriseConversationFmUI.k(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
            }
          }
          AppMethodBeat.o(256678);
        }
      };
      AppMethodBeat.o(38568);
    }
    
    private void jAm()
    {
      AppMethodBeat.i(38575);
      com.tencent.mm.an.d locald = com.tencent.mm.an.af.bHq().Mi(this.ovT);
      int i;
      int j;
      label40:
      long l1;
      if (locald != null)
      {
        i = locald.field_qyUin;
        if (locald == null) {
          break label190;
        }
        j = locald.field_userUin;
        if (locald == null) {
          break label195;
        }
        l1 = locald.field_wwCorpId;
        label51:
        if (locald == null) {
          break label200;
        }
      }
      label190:
      label195:
      label200:
      for (long l2 = locald.field_wwUserVid;; l2 = 0L)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
        Log.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
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
    
    private void jnJ()
    {
      AppMethodBeat.i(38574);
      this.aebs = i.cT(getContext(), this.ovT);
      Object localObject1;
      int i;
      Object localObject2;
      if ((this.aebs == 2) && (this.aebp == null))
      {
        this.aebp = ((LinearLayout)findViewById(R.h.bottom_bar));
        localObject1 = this.aebp.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cd.a.br(getContext(), R.f.DefaultTabbarHeight);
        this.aebp.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.afpb = com.tencent.mm.ui.af.mU(getContext()).inflate(R.i.enterprise_wework_view, this.aebp, false);
        float f = com.tencent.mm.cd.a.getScaleSize(getContext());
        localObject1 = (CdnImageView)this.afpb.findViewById(R.h.icon_iv);
        i = ((CdnImageView)localObject1).getLayoutParams().height;
        ((CdnImageView)localObject1).getLayoutParams().height = ((int)(i * f));
        ((CdnImageView)localObject1).getLayoutParams().width = ((int)(f * i));
        ((CdnImageView)localObject1).requestLayout();
        localObject2 = (TextView)this.afpb.findViewById(R.h.title_tv);
        com.tencent.mm.an.af.bHq();
        com.tencent.mm.an.af.bHq();
        String str = e.vO(0);
        if ((str == null) || (str.length() <= 0)) {
          break label347;
        }
        ((TextView)localObject2).setText(str);
      }
      for (;;)
      {
        com.tencent.mm.an.af.bHq();
        i = e.bGC();
        if (i != 0) {
          ((TextView)localObject2).setTextColor(i);
        }
        com.tencent.mm.an.af.bHq();
        localObject2 = e.bGB();
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          ((CdnImageView)localObject1).setUrl((String)localObject2);
        }
        i.bb(this.ovT, 1, 2);
        this.aebp.addView(this.afpb);
        this.afpb.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(38560);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            i.w(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), 3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38560);
          }
        });
        i.v(getContext(), this.ovT, 3);
        i.cU(getContext(), this.ovT);
        if (this.aebp == null) {
          break label367;
        }
        if (this.aebs != 2) {
          break;
        }
        this.aebp.setVisibility(0);
        jAm();
        AppMethodBeat.o(38574);
        return;
        label347:
        ((TextView)localObject2).setText(R.l.enterprise_wework_create_chat);
      }
      this.aebp.setVisibility(8);
      label367:
      AppMethodBeat.o(38574);
    }
    
    public int getLayoutId()
    {
      return R.i.enterprise_conversation;
    }
    
    public String getUserName()
    {
      return this.ovT;
    }
    
    public void onActivityCreated(final Bundle paramBundle)
    {
      AppMethodBeat.i(38569);
      super.onActivityCreated(paramBundle);
      this.ovT = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
      this.afpa = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
      this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
      setMMTitle(this.afpa);
      this.afpc = ((ListView)findViewById(R.h.tmessage_lv));
      this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
      this.emptyTipTv.setText(R.l.enterprise_empty_msg_tip);
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
      setToTop(new EnterpriseConversationUI.EnterpriseConversationFmUI.8(this));
      if (com.tencent.mm.an.g.hU(this.ovT) != null)
      {
        jnJ();
        if (this.ovT != null)
        {
          paramBundle = new com.tencent.mm.am.h()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(38559);
              EnterpriseConversationUI.EnterpriseConversationFmUI.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
              AppMethodBeat.o(38559);
            }
          };
          com.tencent.mm.an.af.bHq();
          e.a(this.ovT, paramBundle);
          Log.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", new Object[] { this.ovT });
          addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(38561);
              com.tencent.mm.an.af.bHf();
              Object localObject = f.Ms(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
              if (TextUtils.isEmpty((CharSequence)localObject))
              {
                paramAnonymousMenuItem = new Intent();
                paramAnonymousMenuItem.putExtra("enterprise_biz_name", EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                paramAnonymousMenuItem.addFlags(67108864);
                com.tencent.mm.br.c.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), "brandservice", ".ui.EnterpriseBizSearchUI", paramAnonymousMenuItem);
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
                paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousMenuItem);
                com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousMenuItem.aYi(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((EnterpriseConversationUI.EnterpriseConversationFmUI)localObject).startActivity((Intent)paramAnonymousMenuItem.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          });
          addIconOptionMenu(2, R.l.actionbar_title_new_group_chat, R.k.actionbar_icon_dark_add, new com.tencent.mm.ui.conversation.presenter.b(this.ui, this.ovT));
          this.afpd = new o(thisActivity(), this.ovT, new x.a()
          {
            public final void bWC()
            {
              AppMethodBeat.i(256634);
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getCount());
              AppMethodBeat.o(256634);
            }
          });
          paramBundle = this.afpd;
          Object localObject = new MMSlideDelView.c()
          {
            public final int eB(View paramAnonymousView)
            {
              AppMethodBeat.i(256616);
              int i = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getPositionForView(paramAnonymousView);
              AppMethodBeat.o(256616);
              return i;
            }
          };
          paramBundle.afqN.setGetViewPositionCallback((MMSlideDelView.c)localObject);
          paramBundle.afqO.setGetViewPositionCallback((MMSlideDelView.c)localObject);
          paramBundle = this.afpd;
          localObject = new MMSlideDelView.g()
          {
            public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(256615);
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(256615);
            }
          };
          paramBundle.afqN.setPerformItemClickListener((MMSlideDelView.g)localObject);
          paramBundle.afqO.setPerformItemClickListener((MMSlideDelView.g)localObject);
          paramBundle = this.afpd;
          localObject = new MMSlideDelView.f()
          {
            public final void es(Object paramAnonymousObject)
            {
              AppMethodBeat.i(256622);
              if (paramAnonymousObject == null)
              {
                Log.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
                AppMethodBeat.o(256622);
                return;
              }
              paramAnonymousObject = paramAnonymousObject.toString();
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousObject);
              AppMethodBeat.o(256622);
            }
          };
          paramBundle.afqN.a((MMSlideDelView.f)localObject);
          paramBundle.afqO.a((MMSlideDelView.f)localObject);
          this.afpc.setAdapter(this.afpd);
          this.afpc.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(256689);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousAdapterView);
              localb.cH(paramAnonymousView);
              localb.sc(paramAnonymousInt);
              localb.hB(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
              paramAnonymousAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).aDG(paramAnonymousInt);
              paramAnonymousView = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousAdapterView);
              if (paramAnonymousView == null)
              {
                Log.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getCount()) });
                EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(256689);
                return;
              }
              paramAnonymousView.a(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(256689);
            }
          });
          paramBundle = new Point();
          this.afpc.setOnTouchListener(new EnterpriseConversationUI.EnterpriseConversationFmUI.4(this, paramBundle));
          this.afpc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
          {
            public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(38550);
              paramAnonymousAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).aDG(paramAnonymousInt);
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
        bh.bCz();
        paramBundle = com.tencent.mm.model.c.bzG().bxM(this.ovT);
        if (paramBundle != null)
        {
          this.afpg = paramBundle.field_unReadCount;
          if ((this.afpg == 0) && (paramBundle.field_unReadMuteCount > 0)) {
            this.afpg = -1;
          }
          this.uWw = (paramBundle.field_conversationTime / 1000L);
          if (paramBundle.field_isSend != 1) {
            break label608;
          }
          paramBundle = null;
          label504:
          this.afph = paramBundle;
        }
        com.tencent.mm.an.af.bHq().a(this.aebw, thisActivity().getMainLooper());
        bh.bCz();
        com.tencent.mm.model.c.bzG().add(this);
        bh.bCz();
        com.tencent.mm.model.c.bzA().add(this);
        if (this.afpd != null)
        {
          if (this.afpf != null) {
            break label616;
          }
          this.afpf = new MMHandler()
          {
            public final void handleMessage(Message paramAnonymousMessage)
            {
              AppMethodBeat.i(256683);
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
                  paramAnonymousMessage = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).aDG(m);
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
                    if ((ab.IR(str)) && (com.tencent.mm.an.g.MD(str))) {
                      break label178;
                    }
                    Log.d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", new Object[] { str });
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
                au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str);
                boolean bool = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxV(str);
                int n;
                if ((localau != null) && ((localau.field_type & 0x800) != 0))
                {
                  n = 1;
                  label242:
                  if ((n == 0) || (bool)) {
                    break label317;
                  }
                  ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxT(str);
                }
                for (;;)
                {
                  if (com.tencent.mm.an.g.MC(str)) {
                    localLinkedList2.add(str);
                  }
                  if (paramAnonymousMessage.field_unReadCount <= 0) {
                    break label858;
                  }
                  if (!ab.Ja(str)) {
                    break label351;
                  }
                  j += 1;
                  break;
                  n = 0;
                  break label242;
                  if ((n == 0) && (bool)) {
                    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxU(str);
                  }
                }
                label351:
                k += 1;
                i = paramAnonymousMessage.field_unReadCount + i;
                continue;
                paramAnonymousMessage = com.tencent.mm.an.af.bHq().Mi(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
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
                  if (!Util.isNullOrNil(EnterpriseConversationUI.EnterpriseConversationFmUI.e(EnterpriseConversationUI.EnterpriseConversationFmUI.this))) {
                    n = com.tencent.mm.an.af.bHq().Mk(EnterpriseConversationUI.EnterpriseConversationFmUI.e(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                  }
                  com.tencent.mm.plugin.report.service.h.OAn.b(12892, new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                  Log.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                  if (localLinkedList1.size() > 0)
                  {
                    bh.bCz();
                    com.tencent.mm.model.c.bzG().cv(localLinkedList1);
                    EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).aNy();
                  }
                  if (com.tencent.mm.an.af.bHt().Mh(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)))
                  {
                    com.tencent.mm.an.af.bHq();
                    e.a(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), null);
                  }
                  com.tencent.mm.an.af.bHt().Mh(EnterpriseConversationUI.EnterpriseConversationFmUI.i(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                  if (localLinkedList2.size() <= 0) {
                    break label852;
                  }
                  i = 0;
                  while (i < localLinkedList2.size())
                  {
                    com.tencent.mm.an.af.bHt().Mh((String)localLinkedList2.get(i));
                    i += 1;
                  }
                  m = 0;
                  break;
                  l1 = 0L;
                  break label401;
                }
                AppMethodBeat.o(256683);
                return;
              }
            }
          };
        }
      }
      for (;;)
      {
        this.afpf.sendEmptyMessageDelayed(1, 500L);
        AppMethodBeat.o(38569);
        return;
        Log.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
        break;
        label608:
        paramBundle = paramBundle.field_digestUser;
        break label504;
        label616:
        this.afpf.removeMessages(1);
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
        com.tencent.mm.plugin.messenger.a.g.gaI().B(str1, str2, bool);
        com.tencent.mm.plugin.messenger.a.g.gaI().ke(paramIntent, str2);
        com.tencent.mm.ui.widget.snackbar.b.u(thisActivity(), getContext().getString(R.l.finish_sent));
        AppMethodBeat.o(38573);
        return;
      }
      AppMethodBeat.o(38573);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(38570);
      com.tencent.mm.an.af.bHq().a(this.aebw);
      if (bh.baz())
      {
        bh.bCz();
        com.tencent.mm.model.c.bzG().remove(this);
        bh.bCz();
        com.tencent.mm.model.c.bzA().remove(this);
      }
      if (this.afpd != null)
      {
        localObject = this.afpd;
        l locall = ((o)localObject).afqN;
        locall.afmX.stopTimer();
        if (locall.aebd != null)
        {
          locall.aebd.clear();
          locall.aebd = null;
        }
        locall.fSd();
        locall.jhO();
        bh.bCz();
        com.tencent.mm.model.c.bzG().remove(locall);
        ((o)localObject).afqO.onDestroy();
      }
      if (this.afpj != null)
      {
        localObject = this.afpj;
        bh.aZW().b(1394, (com.tencent.mm.am.h)localObject);
      }
      if ((this.enterTime <= 0L) || (this.oVP <= 0L))
      {
        super.onDestroy();
        AppMethodBeat.o(38570);
        return;
      }
      long l = this.oVP - this.enterTime;
      Object localObject = com.tencent.mm.an.af.bHq().Mi(this.ovT);
      int i;
      if (localObject != null)
      {
        i = ((com.tencent.mm.an.d)localObject).field_qyUin;
        label216:
        if (localObject == null) {
          break label337;
        }
      }
      label337:
      for (int j = ((com.tencent.mm.an.d)localObject).field_userUin;; j = 0)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
        Log.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
        break;
        i = 0;
        break label216;
      }
    }
    
    public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject) {}
    
    public void onPause()
    {
      AppMethodBeat.i(38572);
      Log.v("MicroMsg.EnterpriseConversationUI", "on pause");
      bh.bCz();
      com.tencent.mm.model.c.bzG().bxO(this.ovT);
      if (this.afpd != null)
      {
        o localo = this.afpd;
        localo.afqN.onPause();
        localo.afqO.onPause();
      }
      super.onPause();
      AppMethodBeat.o(38572);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(38571);
      Log.v("MicroMsg.EnterpriseConversationUI", "on resume");
      Object localObject;
      if (this.afpi != null)
      {
        localObject = this.afpi;
        if (0L != ((com.tencent.mm.ui.conversation.presenter.a)localObject).afuq)
        {
          if (((com.tencent.mm.ui.conversation.presenter.a)localObject).afup != null) {
            ((com.tencent.mm.ui.conversation.presenter.a)localObject).afup.Av(((com.tencent.mm.ui.conversation.presenter.a)localObject).afuq);
          }
          ((com.tencent.mm.ui.conversation.presenter.a)localObject).afuq = 0L;
        }
      }
      if (this.afpd != null)
      {
        localObject = this.afpd;
        ((o)localObject).afqN.onResume();
        ((o)localObject).afqO.onResume();
      }
      super.onResume();
      if (!ab.IR(this.ovT)) {
        finish();
      }
      AppMethodBeat.o(38571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI
 * JD-Core Version:    0.7.0.1
 */