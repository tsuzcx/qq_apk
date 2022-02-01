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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.e;
import com.tencent.mm.ao.e.a;
import com.tencent.mm.ao.e.a.a;
import com.tencent.mm.ao.f;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.bizchat.BizChatSearchUI;
import com.tencent.mm.ui.conversation.presenter.a.b;
import com.tencent.mm.ui.v.a;
import java.util.HashMap;
import java.util.LinkedList;

public class EnterpriseConversationUI$EnterpriseConversationFmUI
  extends BaseConversationUI.BaseConversationFmUI
  implements MStorageEx.IOnStorageChange
{
  private LinearLayout WtX;
  private int Wua;
  private e.a Wue;
  private View XCg;
  private m XCh;
  private String XCi;
  private MMHandler XCj;
  private int XCk;
  private String XCl;
  private com.tencent.mm.ui.conversation.presenter.a XCm;
  private com.tencent.mm.ui.conversation.presenter.c XCn;
  private ListView XzG;
  private String XzI;
  private TextView emptyTipTv;
  private long enterTime;
  private int fromScene;
  private String lEm;
  long mcV;
  private long rLi;
  
  public EnterpriseConversationUI$EnterpriseConversationFmUI()
  {
    AppMethodBeat.i(38568);
    this.WtX = null;
    this.XCg = null;
    this.XCi = null;
    this.Wua = 0;
    this.enterTime = 0L;
    this.mcV = 0L;
    this.XCk = -2;
    this.rLi = 0L;
    this.XCl = null;
    this.Wue = new e.a()
    {
      public final void a(e.a.a paramAnonymousa)
      {
        AppMethodBeat.i(224106);
        if ((paramAnonymousa != null) && (!Util.isNullOrNil(paramAnonymousa.lEm)) && (paramAnonymousa.lEm.equals(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this))))
        {
          int i = EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
          EnterpriseConversationUI.EnterpriseConversationFmUI.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this, com.tencent.mm.ui.i.cI(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)));
          if (EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this) != i) {
            EnterpriseConversationUI.EnterpriseConversationFmUI.k(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
          }
        }
        AppMethodBeat.o(224106);
      }
    };
    AppMethodBeat.o(38568);
  }
  
  private void hLh()
  {
    AppMethodBeat.i(38574);
    this.Wua = com.tencent.mm.ui.i.cI(getContext(), this.lEm);
    Object localObject1;
    int i;
    Object localObject2;
    if ((this.Wua == 2) && (this.WtX == null))
    {
      this.WtX = ((LinearLayout)findViewById(R.h.bottom_bar));
      localObject1 = this.WtX.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.ci.a.aY(getContext(), R.f.DefaultTabbarHeight);
      this.WtX.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.XCg = ad.kS(getContext()).inflate(R.i.egc, this.WtX, false);
      float f = com.tencent.mm.ci.a.ez(getContext());
      localObject1 = (CdnImageView)this.XCg.findViewById(R.h.icon_iv);
      i = ((CdnImageView)localObject1).getLayoutParams().height;
      ((CdnImageView)localObject1).getLayoutParams().height = ((int)(i * f));
      ((CdnImageView)localObject1).getLayoutParams().width = ((int)(f * i));
      ((CdnImageView)localObject1).requestLayout();
      localObject2 = (TextView)this.XCg.findViewById(R.h.title_tv);
      af.bjF();
      af.bjF();
      String str = e.vJ(0);
      if ((str == null) || (str.length() <= 0)) {
        break label347;
      }
      ((TextView)localObject2).setText(str);
    }
    for (;;)
    {
      af.bjF();
      i = e.biS();
      if (i != 0) {
        ((TextView)localObject2).setTextColor(i);
      }
      af.bjF();
      localObject2 = e.biR();
      if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
        ((CdnImageView)localObject1).setUrl((String)localObject2);
      }
      com.tencent.mm.ui.i.aS(this.lEm, 1, 2);
      this.WtX.addView(this.XCg);
      this.XCg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(38560);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.ui.i.u(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38560);
        }
      });
      com.tencent.mm.ui.i.t(getContext(), this.lEm, 3);
      com.tencent.mm.ui.i.cJ(getContext(), this.lEm);
      if (this.WtX == null) {
        break label367;
      }
      if (this.Wua != 2) {
        break;
      }
      this.WtX.setVisibility(0);
      hWo();
      AppMethodBeat.o(38574);
      return;
      label347:
      ((TextView)localObject2).setText(R.l.eCz);
    }
    this.WtX.setVisibility(8);
    label367:
    AppMethodBeat.o(38574);
  }
  
  private void hWo()
  {
    AppMethodBeat.i(38575);
    com.tencent.mm.ao.d locald = af.bjF().Uj(this.lEm);
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
      com.tencent.mm.plugin.report.service.h.IzE.a(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
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
  
  public int getLayoutId()
  {
    return R.i.egb;
  }
  
  public String getUserName()
  {
    return this.lEm;
  }
  
  public void onActivityCreated(final Bundle paramBundle)
  {
    AppMethodBeat.i(38569);
    super.onActivityCreated(paramBundle);
    this.lEm = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
    this.XzI = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
    this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
    setMMTitle(this.XzI);
    this.XzG = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.eCq);
    setBackBtn(new EnterpriseConversationUI.EnterpriseConversationFmUI.1(this));
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38558);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(38558);
      }
    });
    if (com.tencent.mm.ao.g.gu(this.lEm) != null)
    {
      hLh();
      if (this.lEm != null)
      {
        paramBundle = new EnterpriseConversationUI.EnterpriseConversationFmUI.9(this);
        af.bjF();
        e.a(this.lEm, paramBundle);
        Log.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", new Object[] { this.lEm });
        addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(38561);
            af.bjv();
            Object localObject = f.Ut(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
            if (TextUtils.isEmpty((CharSequence)localObject))
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("enterprise_biz_name", EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
              paramAnonymousMenuItem.addFlags(67108864);
              com.tencent.mm.by.c.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), "brandservice", ".ui.EnterpriseBizSearchUI", paramAnonymousMenuItem);
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
              paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousMenuItem);
              com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousMenuItem.aFh(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((EnterpriseConversationUI.EnterpriseConversationFmUI)localObject).startActivity((Intent)paramAnonymousMenuItem.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        });
        addIconOptionMenu(2, R.l.actionbar_title_new_group_chat, R.k.actionbar_icon_dark_add, new com.tencent.mm.ui.conversation.presenter.b(this.ui, this.lEm));
        this.XCh = new m(thisActivity(), this.lEm, new v.a()
        {
          public final void bxN()
          {
            AppMethodBeat.i(274947);
            EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getCount());
            AppMethodBeat.o(274947);
          }
        });
        paramBundle = this.XCh;
        Object localObject = new MMSlideDelView.c()
        {
          public final int dO(View paramAnonymousView)
          {
            AppMethodBeat.i(281086);
            int i = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getPositionForView(paramAnonymousView);
            AppMethodBeat.o(281086);
            return i;
          }
        };
        paramBundle.XDk.setGetViewPositionCallback((MMSlideDelView.c)localObject);
        paramBundle.XDl.setGetViewPositionCallback((MMSlideDelView.c)localObject);
        paramBundle = this.XCh;
        localObject = new MMSlideDelView.g()
        {
          public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(281461);
            EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(281461);
          }
        };
        paramBundle.XDk.setPerformItemClickListener((MMSlideDelView.g)localObject);
        paramBundle.XDl.setPerformItemClickListener((MMSlideDelView.g)localObject);
        paramBundle = this.XCh;
        localObject = new MMSlideDelView.f()
        {
          public final void cW(Object paramAnonymousObject)
          {
            AppMethodBeat.i(284431);
            if (paramAnonymousObject == null)
            {
              Log.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
              AppMethodBeat.o(284431);
              return;
            }
            paramAnonymousObject = paramAnonymousObject.toString();
            EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousObject);
            AppMethodBeat.o(284431);
          }
        };
        paramBundle.XDk.a((MMSlideDelView.f)localObject);
        paramBundle.XDl.a((MMSlideDelView.f)localObject);
        this.XzG.setAdapter(this.XCh);
        this.XzG.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(279226);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousAdapterView);
            localb.bn(paramAnonymousView);
            localb.sg(paramAnonymousInt);
            localb.Fs(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
            paramAnonymousAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).awY(paramAnonymousInt);
            paramAnonymousView = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousAdapterView);
            if (paramAnonymousView == null)
            {
              Log.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getCount()) });
              EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).notifyDataSetChanged();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(279226);
              return;
            }
            paramAnonymousView.a(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(279226);
          }
        });
        paramBundle = new Point();
        this.XzG.setOnTouchListener(new EnterpriseConversationUI.EnterpriseConversationFmUI.4(this, paramBundle));
        this.XzG.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
          public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(38550);
            paramAnonymousAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).awY(paramAnonymousInt);
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
      bh.beI();
      paramBundle = com.tencent.mm.model.c.bbR().bwx(this.lEm);
      if (paramBundle != null)
      {
        this.XCk = paramBundle.field_unReadCount;
        if ((this.XCk == 0) && (paramBundle.field_unReadMuteCount > 0)) {
          this.XCk = -1;
        }
        this.rLi = (paramBundle.field_conversationTime / 1000L);
        if (paramBundle.field_isSend != 1) {
          break label608;
        }
        paramBundle = null;
        label504:
        this.XCl = paramBundle;
      }
      af.bjF().a(this.Wue, thisActivity().getMainLooper());
      bh.beI();
      com.tencent.mm.model.c.bbR().add(this);
      bh.beI();
      com.tencent.mm.model.c.bbL().add(this);
      if (this.XCh != null)
      {
        if (this.XCj != null) {
          break label616;
        }
        this.XCj = new MMHandler()
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            AppMethodBeat.i(234395);
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
                paramAnonymousMessage = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).awY(m);
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
                  if ((ab.Ql(str)) && (com.tencent.mm.ao.g.UE(str))) {
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
              as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(str);
              boolean bool = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwF(str);
              int n;
              if ((localas != null) && ((localas.field_type & 0x800) != 0))
              {
                n = 1;
                label242:
                if ((n == 0) || (bool)) {
                  break label317;
                }
                ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwD(str);
              }
              for (;;)
              {
                if (com.tencent.mm.ao.g.UD(str)) {
                  localLinkedList2.add(str);
                }
                if (paramAnonymousMessage.field_unReadCount <= 0) {
                  break label858;
                }
                if (!ab.Rc(str)) {
                  break label351;
                }
                j += 1;
                break;
                n = 0;
                break label242;
                if ((n == 0) && (bool)) {
                  ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwE(str);
                }
              }
              label351:
              k += 1;
              i = paramAnonymousMessage.field_unReadCount + i;
              continue;
              paramAnonymousMessage = af.bjF().Uj(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
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
                  n = af.bjF().Ul(EnterpriseConversationUI.EnterpriseConversationFmUI.e(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                }
                com.tencent.mm.plugin.report.service.h.IzE.a(12892, new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                Log.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                if (localLinkedList1.size() > 0)
                {
                  bh.beI();
                  com.tencent.mm.model.c.bbR().ch(localLinkedList1);
                  EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).atr();
                }
                if (af.bjI().Ui(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)))
                {
                  af.bjF();
                  e.a(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), null);
                }
                af.bjI().Ui(EnterpriseConversationUI.EnterpriseConversationFmUI.i(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                if (localLinkedList2.size() <= 0) {
                  break label852;
                }
                i = 0;
                while (i < localLinkedList2.size())
                {
                  af.bjI().Ui((String)localLinkedList2.get(i));
                  i += 1;
                }
                m = 0;
                break;
                l1 = 0L;
                break label401;
              }
              AppMethodBeat.o(234395);
              return;
            }
          }
        };
      }
    }
    for (;;)
    {
      this.XCj.sendEmptyMessageDelayed(1, 500L);
      AppMethodBeat.o(38569);
      return;
      Log.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
      break;
      label608:
      paramBundle = paramBundle.field_digestUser;
      break label504;
      label616:
      this.XCj.removeMessages(1);
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
      com.tencent.mm.plugin.messenger.a.g.eRW().u(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.eRW().iQ(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.r(thisActivity(), getContext().getString(R.l.finish_sent));
      AppMethodBeat.o(38573);
      return;
    }
    AppMethodBeat.o(38573);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38570);
    af.bjF().a(this.Wue);
    if (bh.aHB())
    {
      bh.beI();
      com.tencent.mm.model.c.bbR().remove(this);
      bh.beI();
      com.tencent.mm.model.c.bbL().remove(this);
    }
    if (this.XCh != null)
    {
      localObject = this.XCh;
      k localk = ((m)localObject).XDk;
      localk.XAp.stopTimer();
      if (localk.WtK != null)
      {
        localk.WtK.clear();
        localk.WtK = null;
      }
      localk.eKd();
      localk.hFC();
      bh.beI();
      com.tencent.mm.model.c.bbR().remove(localk);
      ((m)localObject).XDl.onDestroy();
    }
    if (this.XCn != null)
    {
      localObject = this.XCn;
      bh.aGY().b(1394, (com.tencent.mm.an.i)localObject);
    }
    if ((this.enterTime <= 0L) || (this.mcV <= 0L))
    {
      super.onDestroy();
      AppMethodBeat.o(38570);
      return;
    }
    long l = this.mcV - this.enterTime;
    Object localObject = af.bjF().Uj(this.lEm);
    int i;
    if (localObject != null)
    {
      i = ((com.tencent.mm.ao.d)localObject).field_qyUin;
      label216:
      if (localObject == null) {
        break label337;
      }
    }
    label337:
    for (int j = ((com.tencent.mm.ao.d)localObject).field_userUin;; j = 0)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
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
    bh.beI();
    com.tencent.mm.model.c.bbR().bwz(this.lEm);
    if (this.XCh != null)
    {
      m localm = this.XCh;
      localm.XDk.onPause();
      localm.XDl.onPause();
    }
    super.onPause();
    AppMethodBeat.o(38572);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38571);
    Log.v("MicroMsg.EnterpriseConversationUI", "on resume");
    Object localObject;
    if (this.XCm != null)
    {
      localObject = this.XCm;
      if (0L != ((com.tencent.mm.ui.conversation.presenter.a)localObject).XGf)
      {
        if (((com.tencent.mm.ui.conversation.presenter.a)localObject).XGe != null) {
          ((com.tencent.mm.ui.conversation.presenter.a)localObject).XGe.Wj(((com.tencent.mm.ui.conversation.presenter.a)localObject).XGf);
        }
        ((com.tencent.mm.ui.conversation.presenter.a)localObject).XGf = 0L;
      }
    }
    if (this.XCh != null)
    {
      localObject = this.XCh;
      ((m)localObject).XDk.onResume();
      ((m)localObject).XDl.onResume();
    }
    super.onResume();
    if (!ab.Ql(this.lEm)) {
      finish();
    }
    AppMethodBeat.o(38571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI
 * JD-Core Version:    0.7.0.1
 */