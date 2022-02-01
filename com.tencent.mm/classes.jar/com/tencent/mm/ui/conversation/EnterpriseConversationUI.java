package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.k;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.e;
import com.tencent.mm.am.e.a;
import com.tencent.mm.am.e.a.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
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
      ((EnterpriseConversationFmUI)this.conversationFm).ioQ = (System.currentTimeMillis() / 1000L);
    }
    super.finish();
    AppMethodBeat.o(38587);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38586);
    super.onCreate(paramBundle);
    this.contentView = z.jO(this).inflate(2131493232, null);
    setContentView(this.contentView);
    this.conversationFm = new EnterpriseConversationFmUI();
    getSupportFragmentManager().beginTransaction().a(2131302341, this.conversationFm).commit();
    h.a(this, this.contentView);
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
    private LinearLayout JuQ;
    private int JuT;
    private e.a JuX;
    private ListView KrZ;
    private String Ksb;
    private View KvB;
    private l KvC;
    private String KvD;
    private ap KvE;
    private int KvF;
    private String KvG;
    private com.tencent.mm.ui.conversation.presenter.a KvH;
    private com.tencent.mm.ui.conversation.presenter.c KvI;
    private TextView emptyTipTv;
    private long enterTime;
    private int fromScene;
    private String hPO;
    long ioQ;
    private long nsZ;
    
    public EnterpriseConversationFmUI()
    {
      AppMethodBeat.i(38568);
      this.JuQ = null;
      this.KvB = null;
      this.KvD = null;
      this.JuT = 0;
      this.enterTime = 0L;
      this.ioQ = 0L;
      this.KvF = -2;
      this.nsZ = 0L;
      this.KvG = null;
      this.JuX = new e.a()
      {
        public final void a(e.a.a paramAnonymousa)
        {
          AppMethodBeat.i(194671);
          if ((paramAnonymousa != null) && (!bt.isNullOrNil(paramAnonymousa.hPO)) && (paramAnonymousa.hPO.equals(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this))))
          {
            int i = EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
            EnterpriseConversationUI.EnterpriseConversationFmUI.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this, com.tencent.mm.ui.g.cg(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)));
            if (EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this) != i) {
              EnterpriseConversationUI.EnterpriseConversationFmUI.k(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
            }
          }
          AppMethodBeat.o(194671);
        }
      };
      AppMethodBeat.o(38568);
    }
    
    private void fJf()
    {
      AppMethodBeat.i(38575);
      com.tencent.mm.am.d locald = ag.aGi().Dy(this.hPO);
      int i;
      int j;
      label39:
      long l1;
      if (locald != null)
      {
        i = locald.field_qyUin;
        if (locald == null) {
          break label188;
        }
        j = locald.field_userUin;
        if (locald == null) {
          break label193;
        }
        l1 = locald.field_wwCorpId;
        label50:
        if (locald == null) {
          break label198;
        }
      }
      label188:
      label193:
      label198:
      for (long l2 = locald.field_wwUserVid;; l2 = 0L)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
        ad.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
        AppMethodBeat.o(38575);
        return;
        i = 0;
        break;
        j = 0;
        break label39;
        l1 = 0L;
        break label50;
      }
    }
    
    private void fzQ()
    {
      AppMethodBeat.i(38574);
      this.JuT = com.tencent.mm.ui.g.cg(getContext(), this.hPO);
      Object localObject1;
      int i;
      Object localObject2;
      if ((this.JuT == 2) && (this.JuQ == null))
      {
        this.JuQ = ((LinearLayout)findViewById(2131297432));
        localObject1 = this.JuQ.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cc.a.ax(getContext(), 2131165256);
        this.JuQ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.KvB = z.jO(getContext()).inflate(2131493849, this.JuQ, false);
        float f = com.tencent.mm.cc.a.eb(getContext());
        localObject1 = (CdnImageView)this.KvB.findViewById(2131300891);
        i = ((CdnImageView)localObject1).getLayoutParams().height;
        ((CdnImageView)localObject1).getLayoutParams().height = ((int)(i * f));
        ((CdnImageView)localObject1).getLayoutParams().width = ((int)(f * i));
        ((CdnImageView)localObject1).requestLayout();
        localObject2 = (TextView)this.KvB.findViewById(2131305948);
        ag.aGi();
        ag.aGi();
        String str = e.oV(0);
        if ((str == null) || (str.length() <= 0)) {
          break label345;
        }
        ((TextView)localObject2).setText(str);
      }
      for (;;)
      {
        ag.aGi();
        i = e.aFu();
        if (i != 0) {
          ((TextView)localObject2).setTextColor(i);
        }
        ag.aGi();
        localObject2 = e.aFt();
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          ((CdnImageView)localObject1).setUrl((String)localObject2);
        }
        com.tencent.mm.ui.g.aS(this.hPO, 1, 2);
        this.JuQ.addView(this.KvB);
        this.KvB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(38560);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.ui.g.u(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), 3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38560);
          }
        });
        com.tencent.mm.ui.g.t(getContext(), this.hPO, 3);
        com.tencent.mm.ui.g.ch(getContext(), this.hPO);
        if (this.JuQ == null) {
          break label365;
        }
        if (this.JuT != 2) {
          break;
        }
        this.JuQ.setVisibility(0);
        fJf();
        AppMethodBeat.o(38574);
        return;
        label345:
        ((TextView)localObject2).setText(2131758452);
      }
      this.JuQ.setVisibility(8);
      label365:
      AppMethodBeat.o(38574);
    }
    
    public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject) {}
    
    public int getLayoutId()
    {
      return 2131493848;
    }
    
    public String getUserName()
    {
      return this.hPO;
    }
    
    public void onActivityCreated(final Bundle paramBundle)
    {
      AppMethodBeat.i(38569);
      super.onActivityCreated(paramBundle);
      this.hPO = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
      this.Ksb = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
      this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
      setMMTitle(this.Ksb);
      this.KrZ = ((ListView)findViewById(2131305951));
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
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38558);
        }
      });
      if (com.tencent.mm.am.g.eS(this.hPO) != null)
      {
        fzQ();
        if (this.hPO != null)
        {
          paramBundle = new com.tencent.mm.al.f()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
            {
              AppMethodBeat.i(38559);
              EnterpriseConversationUI.EnterpriseConversationFmUI.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
              AppMethodBeat.o(38559);
            }
          };
          ag.aGi();
          e.a(this.hPO, paramBundle);
          ad.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", new Object[] { this.hPO });
          addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(38561);
              ag.aFZ();
              Object localObject = com.tencent.mm.am.f.DH(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
              if (TextUtils.isEmpty((CharSequence)localObject))
              {
                paramAnonymousMenuItem = new Intent();
                paramAnonymousMenuItem.putExtra("enterprise_biz_name", EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                paramAnonymousMenuItem.addFlags(67108864);
                com.tencent.mm.bs.d.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), "brandservice", ".ui.EnterpriseBizSearchUI", paramAnonymousMenuItem);
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
                paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMenuItem);
                com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousMenuItem.ahp(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((EnterpriseConversationUI.EnterpriseConversationFmUI)localObject).startActivity((Intent)paramAnonymousMenuItem.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          });
          addIconOptionMenu(2, 2131755134, 2131689489, new com.tencent.mm.ui.conversation.presenter.b(this.ui, this.hPO));
          this.KvC = new l(thisActivity(), this.hPO, new r.a()
          {
            public final void aSs()
            {
              AppMethodBeat.i(194672);
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getCount());
              AppMethodBeat.o(194672);
            }
          });
          paramBundle = this.KvC;
          Object localObject = new MMSlideDelView.c()
          {
            public final int dA(View paramAnonymousView)
            {
              AppMethodBeat.i(194673);
              int i = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getPositionForView(paramAnonymousView);
              AppMethodBeat.o(194673);
              return i;
            }
          };
          paramBundle.KwE.setGetViewPositionCallback((MMSlideDelView.c)localObject);
          paramBundle.KwF.setGetViewPositionCallback((MMSlideDelView.c)localObject);
          paramBundle = this.KvC;
          localObject = new MMSlideDelView.g()
          {
            public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(194674);
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(194674);
            }
          };
          paramBundle.KwE.setPerformItemClickListener((MMSlideDelView.g)localObject);
          paramBundle.KwF.setPerformItemClickListener((MMSlideDelView.g)localObject);
          paramBundle = this.KvC;
          localObject = new MMSlideDelView.f()
          {
            public final void cP(Object paramAnonymousObject)
            {
              AppMethodBeat.i(194675);
              if (paramAnonymousObject == null)
              {
                ad.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
                AppMethodBeat.o(194675);
                return;
              }
              paramAnonymousObject = paramAnonymousObject.toString();
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousObject);
              AppMethodBeat.o(194675);
            }
          };
          paramBundle.KwE.a((MMSlideDelView.f)localObject);
          paramBundle.KwF.a((MMSlideDelView.f)localObject);
          this.KrZ.setAdapter(this.KvC);
          this.KrZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(194667);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousAdapterView);
              localb.bd(paramAnonymousView);
              localb.mr(paramAnonymousInt);
              localb.qY(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
              paramAnonymousAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).aeA(paramAnonymousInt);
              paramAnonymousView = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousAdapterView);
              if (paramAnonymousView == null)
              {
                ad.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getCount()) });
                EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(194667);
                return;
              }
              paramAnonymousView.a(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(194667);
            }
          });
          paramBundle = new Point();
          this.KrZ.setOnTouchListener(new EnterpriseConversationUI.EnterpriseConversationFmUI.4(this, paramBundle));
          this.KrZ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
          {
            public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(38550);
              paramAnonymousAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).aeA(paramAnonymousInt);
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
        com.tencent.mm.model.ba.aBQ();
        paramBundle = com.tencent.mm.model.c.azv().aTz(this.hPO);
        if (paramBundle != null)
        {
          this.KvF = paramBundle.field_unReadCount;
          if ((this.KvF == 0) && (paramBundle.field_unReadMuteCount > 0)) {
            this.KvF = -1;
          }
          this.nsZ = (paramBundle.field_conversationTime / 1000L);
          if (paramBundle.field_isSend != 1) {
            break label608;
          }
          paramBundle = null;
          label504:
          this.KvG = paramBundle;
        }
        ag.aGi().a(this.JuX, thisActivity().getMainLooper());
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().a(this);
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azp().a(this);
        if (this.KvC != null)
        {
          if (this.KvE != null) {
            break label616;
          }
          this.KvE = new ap()
          {
            public final void handleMessage(Message paramAnonymousMessage)
            {
              AppMethodBeat.i(194670);
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
                  paramAnonymousMessage = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).aeA(m);
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
                    if ((w.zD(str)) && (com.tencent.mm.am.g.DS(str))) {
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
                am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(str);
                boolean bool = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTH(str);
                int n;
                if ((localam != null) && ((localam.field_type & 0x800) != 0))
                {
                  n = 1;
                  label242:
                  if ((n == 0) || (bool)) {
                    break label317;
                  }
                  ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTF(str);
                }
                for (;;)
                {
                  if (com.tencent.mm.am.g.DR(str)) {
                    localLinkedList2.add(str);
                  }
                  if (paramAnonymousMessage.field_unReadCount <= 0) {
                    break label858;
                  }
                  if (!w.Au(str)) {
                    break label351;
                  }
                  j += 1;
                  break;
                  n = 0;
                  break label242;
                  if ((n == 0) && (bool)) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().aTG(str);
                  }
                }
                label351:
                k += 1;
                i = paramAnonymousMessage.field_unReadCount + i;
                continue;
                paramAnonymousMessage = ag.aGi().Dy(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
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
                    n = ag.aGi().DA(EnterpriseConversationUI.EnterpriseConversationFmUI.e(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                  }
                  com.tencent.mm.plugin.report.service.g.yhR.f(12892, new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                  ad.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                  if (localLinkedList1.size() > 0)
                  {
                    com.tencent.mm.model.ba.aBQ();
                    com.tencent.mm.model.c.azv().bm(localLinkedList1);
                    EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).Zu();
                  }
                  if (ag.aGl().Dx(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)))
                  {
                    ag.aGi();
                    e.a(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), null);
                  }
                  ag.aGl().Dx(EnterpriseConversationUI.EnterpriseConversationFmUI.i(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                  if (localLinkedList2.size() <= 0) {
                    break label852;
                  }
                  i = 0;
                  while (i < localLinkedList2.size())
                  {
                    ag.aGl().Dx((String)localLinkedList2.get(i));
                    i += 1;
                  }
                  m = 0;
                  break;
                  l1 = 0L;
                  break label401;
                }
                AppMethodBeat.o(194670);
                return;
              }
            }
          };
        }
      }
      for (;;)
      {
        this.KvE.sendEmptyMessageDelayed(1, 500L);
        AppMethodBeat.o(38569);
        return;
        ad.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
        break;
        label608:
        paramBundle = paramBundle.field_digestUser;
        break label504;
        label616:
        this.KvE.removeMessages(1);
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
        com.tencent.mm.plugin.messenger.a.g.dlD().q(str1, str2, bool);
        com.tencent.mm.plugin.messenger.a.g.dlD().hP(paramIntent, str2);
        com.tencent.mm.ui.widget.snackbar.b.n(thisActivity(), getContext().getString(2131759420));
        AppMethodBeat.o(38573);
        return;
      }
      AppMethodBeat.o(38573);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(38570);
      ag.aGi().a(this.JuX);
      if (com.tencent.mm.model.ba.ajx())
      {
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().b(this);
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azp().b(this);
      }
      if (this.KvC != null)
      {
        localObject = this.KvC;
        j localj = ((l)localObject).KwE;
        localj.KsF.stopTimer();
        if (localj.JuD != null)
        {
          localj.JuD.clear();
          localj.JuD = null;
        }
        localj.det();
        localj.fvg();
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().b(localj);
        ((l)localObject).KwF.onDestroy();
      }
      if (this.KvI != null)
      {
        localObject = this.KvI;
        com.tencent.mm.model.ba.aiU().b(1394, (com.tencent.mm.al.f)localObject);
      }
      if ((this.enterTime <= 0L) || (this.ioQ <= 0L))
      {
        super.onDestroy();
        AppMethodBeat.o(38570);
        return;
      }
      long l = this.ioQ - this.enterTime;
      Object localObject = ag.aGi().Dy(this.hPO);
      int i;
      if (localObject != null)
      {
        i = ((com.tencent.mm.am.d)localObject).field_qyUin;
        label216:
        if (localObject == null) {
          break label337;
        }
      }
      label337:
      for (int j = ((com.tencent.mm.am.d)localObject).field_userUin;; j = 0)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
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
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().aTB(this.hPO);
      if (this.KvC != null)
      {
        l locall = this.KvC;
        locall.KwE.onPause();
        locall.KwF.onPause();
      }
      super.onPause();
      AppMethodBeat.o(38572);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(38571);
      ad.v("MicroMsg.EnterpriseConversationUI", "on resume");
      Object localObject;
      if (this.KvH != null)
      {
        localObject = this.KvH;
        if (0L != ((com.tencent.mm.ui.conversation.presenter.a)localObject).Kzq)
        {
          if (((com.tencent.mm.ui.conversation.presenter.a)localObject).Kzp != null) {
            ((com.tencent.mm.ui.conversation.presenter.a)localObject).Kzp.Ep(((com.tencent.mm.ui.conversation.presenter.a)localObject).Kzq);
          }
          ((com.tencent.mm.ui.conversation.presenter.a)localObject).Kzq = 0L;
        }
      }
      if (this.KvC != null)
      {
        localObject = this.KvC;
        ((l)localObject).KwE.onResume();
        ((l)localObject).KwF.onResume();
      }
      super.onResume();
      if (!w.zD(this.hPO)) {
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