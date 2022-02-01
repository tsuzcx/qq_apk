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
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.e;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.a.a;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
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
      ((EnterpriseConversationFmUI)this.conversationFm).irL = (System.currentTimeMillis() / 1000L);
    }
    super.finish();
    AppMethodBeat.o(38587);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38586);
    super.onCreate(paramBundle);
    this.contentView = z.jV(this).inflate(2131493232, null);
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
    private LinearLayout JPF;
    private int JPJ;
    private e.a JPN;
    private ListView KOt;
    private String KOv;
    private View KRV;
    private l KRW;
    private String KRX;
    private aq KRY;
    private int KRZ;
    private String KSa;
    private com.tencent.mm.ui.conversation.presenter.a KSb;
    private com.tencent.mm.ui.conversation.presenter.c KSc;
    private TextView emptyTipTv;
    private long enterTime;
    private int fromScene;
    private String hSG;
    long irL;
    private long nyu;
    
    public EnterpriseConversationFmUI()
    {
      AppMethodBeat.i(38568);
      this.JPF = null;
      this.KRV = null;
      this.KRX = null;
      this.JPJ = 0;
      this.enterTime = 0L;
      this.irL = 0L;
      this.KRZ = -2;
      this.nyu = 0L;
      this.KSa = null;
      this.JPN = new e.a()
      {
        public final void a(e.a.a paramAnonymousa)
        {
          AppMethodBeat.i(188073);
          if ((paramAnonymousa != null) && (!bu.isNullOrNil(paramAnonymousa.hSG)) && (paramAnonymousa.hSG.equals(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this))))
          {
            int i = EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
            EnterpriseConversationUI.EnterpriseConversationFmUI.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this, com.tencent.mm.ui.g.ch(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)));
            if (EnterpriseConversationUI.EnterpriseConversationFmUI.j(EnterpriseConversationUI.EnterpriseConversationFmUI.this) != i) {
              EnterpriseConversationUI.EnterpriseConversationFmUI.k(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
            }
          }
          AppMethodBeat.o(188073);
        }
      };
      AppMethodBeat.o(38568);
    }
    
    private void fDS()
    {
      AppMethodBeat.i(38574);
      this.JPJ = com.tencent.mm.ui.g.ch(getContext(), this.hSG);
      Object localObject1;
      int i;
      Object localObject2;
      if ((this.JPJ == 2) && (this.JPF == null))
      {
        this.JPF = ((LinearLayout)findViewById(2131297432));
        localObject1 = this.JPF.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.cb.a.ax(getContext(), 2131165256);
        this.JPF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.KRV = z.jV(getContext()).inflate(2131493849, this.JPF, false);
        float f = com.tencent.mm.cb.a.ef(getContext());
        localObject1 = (CdnImageView)this.KRV.findViewById(2131300891);
        i = ((CdnImageView)localObject1).getLayoutParams().height;
        ((CdnImageView)localObject1).getLayoutParams().height = ((int)(i * f));
        ((CdnImageView)localObject1).getLayoutParams().width = ((int)(f * i));
        ((CdnImageView)localObject1).requestLayout();
        localObject2 = (TextView)this.KRV.findViewById(2131305948);
        ag.aGy();
        ag.aGy();
        String str = e.oY(0);
        if ((str == null) || (str.length() <= 0)) {
          break label343;
        }
        ((TextView)localObject2).setText(str);
      }
      for (;;)
      {
        ag.aGy();
        i = e.aFK();
        if (i != 0) {
          ((TextView)localObject2).setTextColor(i);
        }
        ag.aGy();
        localObject2 = e.aFJ();
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          ((CdnImageView)localObject1).setUrl((String)localObject2);
        }
        com.tencent.mm.ui.g.aV(this.hSG, 1, 2);
        this.JPF.addView(this.KRV);
        this.KRV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(38560);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            com.tencent.mm.ui.g.t(EnterpriseConversationUI.EnterpriseConversationFmUI.this.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), 3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38560);
          }
        });
        com.tencent.mm.ui.g.s(getContext(), this.hSG, 3);
        com.tencent.mm.ui.g.ci(getContext(), this.hSG);
        if (this.JPF == null) {
          break label363;
        }
        if (this.JPJ != 2) {
          break;
        }
        this.JPF.setVisibility(0);
        fNw();
        AppMethodBeat.o(38574);
        return;
        label343:
        ((TextView)localObject2).setText(2131758452);
      }
      this.JPF.setVisibility(8);
      label363:
      AppMethodBeat.o(38574);
    }
    
    private void fNw()
    {
      AppMethodBeat.i(38575);
      com.tencent.mm.al.d locald = ag.aGy().Ea(this.hSG);
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
        com.tencent.mm.plugin.report.service.g.yxI.f(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
        ae.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
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
      return this.hSG;
    }
    
    public void onActivityCreated(final Bundle paramBundle)
    {
      AppMethodBeat.i(38569);
      super.onActivityCreated(paramBundle);
      this.hSG = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
      this.KOv = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
      this.fromScene = thisActivity().getIntent().getIntExtra("enterprise_from_scene", 5);
      setMMTitle(this.KOv);
      this.KOt = ((ListView)findViewById(2131305951));
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(38558);
        }
      });
      if (com.tencent.mm.al.g.eX(this.hSG) != null)
      {
        fDS();
        if (this.hSG != null)
        {
          paramBundle = new com.tencent.mm.ak.f()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
            {
              AppMethodBeat.i(38559);
              EnterpriseConversationUI.EnterpriseConversationFmUI.b(EnterpriseConversationUI.EnterpriseConversationFmUI.this);
              AppMethodBeat.o(38559);
            }
          };
          ag.aGy();
          e.a(this.hSG, paramBundle);
          ae.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", new Object[] { this.hSG });
          addIconOptionMenu(1, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(38561);
              ag.aGp();
              Object localObject = com.tencent.mm.al.f.Ej(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
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
                paramAnonymousMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMenuItem);
                com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousMenuItem.ahE(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((EnterpriseConversationUI.EnterpriseConversationFmUI)localObject).startActivity((Intent)paramAnonymousMenuItem.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          });
          addIconOptionMenu(2, 2131755134, 2131689489, new com.tencent.mm.ui.conversation.presenter.b(this.ui, this.hSG));
          this.KRW = new l(thisActivity(), this.hSG, new r.a()
          {
            public final void aSR()
            {
              AppMethodBeat.i(188074);
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getCount());
              AppMethodBeat.o(188074);
            }
          });
          paramBundle = this.KRW;
          Object localObject = new MMSlideDelView.c()
          {
            public final int dA(View paramAnonymousView)
            {
              AppMethodBeat.i(188075);
              int i = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getPositionForView(paramAnonymousView);
              AppMethodBeat.o(188075);
              return i;
            }
          };
          paramBundle.KSY.setGetViewPositionCallback((MMSlideDelView.c)localObject);
          paramBundle.KSZ.setGetViewPositionCallback((MMSlideDelView.c)localObject);
          paramBundle = this.KRW;
          localObject = new MMSlideDelView.g()
          {
            public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(188076);
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(188076);
            }
          };
          paramBundle.KSY.setPerformItemClickListener((MMSlideDelView.g)localObject);
          paramBundle.KSZ.setPerformItemClickListener((MMSlideDelView.g)localObject);
          paramBundle = this.KRW;
          localObject = new MMSlideDelView.f()
          {
            public final void cQ(Object paramAnonymousObject)
            {
              AppMethodBeat.i(188077);
              if (paramAnonymousObject == null)
              {
                ae.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
                AppMethodBeat.o(188077);
                return;
              }
              paramAnonymousObject = paramAnonymousObject.toString();
              EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousObject);
              AppMethodBeat.o(188077);
            }
          };
          paramBundle.KSY.a((MMSlideDelView.f)localObject);
          paramBundle.KSZ.a((MMSlideDelView.f)localObject);
          this.KOt.setAdapter(this.KRW);
          this.KOt.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(188069);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousAdapterView);
              localb.bd(paramAnonymousView);
              localb.mu(paramAnonymousInt);
              localb.rl(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
              paramAnonymousAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).afj(paramAnonymousInt);
              paramAnonymousView = EnterpriseConversationUI.EnterpriseConversationFmUI.a(EnterpriseConversationUI.EnterpriseConversationFmUI.this, paramAnonymousAdapterView);
              if (paramAnonymousView == null)
              {
                ae.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).getCount()) });
                EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).notifyDataSetChanged();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(188069);
                return;
              }
              paramAnonymousView.a(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(188069);
            }
          });
          paramBundle = new Point();
          this.KOt.setOnTouchListener(new EnterpriseConversationUI.EnterpriseConversationFmUI.4(this, paramBundle));
          this.KOt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
          {
            public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(38550);
              paramAnonymousAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).afj(paramAnonymousInt);
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
        bc.aCg();
        paramBundle = com.tencent.mm.model.c.azL().aVa(this.hSG);
        if (paramBundle != null)
        {
          this.KRZ = paramBundle.field_unReadCount;
          if ((this.KRZ == 0) && (paramBundle.field_unReadMuteCount > 0)) {
            this.KRZ = -1;
          }
          this.nyu = (paramBundle.field_conversationTime / 1000L);
          if (paramBundle.field_isSend != 1) {
            break label608;
          }
          paramBundle = null;
          label504:
          this.KSa = paramBundle;
        }
        ag.aGy().a(this.JPN, thisActivity().getMainLooper());
        bc.aCg();
        com.tencent.mm.model.c.azL().a(this);
        bc.aCg();
        com.tencent.mm.model.c.azF().a(this);
        if (this.KRW != null)
        {
          if (this.KRY != null) {
            break label616;
          }
          this.KRY = new aq()
          {
            public final void handleMessage(Message paramAnonymousMessage)
            {
              AppMethodBeat.i(188072);
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
                  paramAnonymousMessage = EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).afj(m);
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
                    if ((x.An(str)) && (com.tencent.mm.al.g.Eu(str))) {
                      break label178;
                    }
                    ae.d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", new Object[] { str });
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
                an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(str);
                boolean bool = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVi(str);
                int n;
                if ((localan != null) && ((localan.field_type & 0x800) != 0))
                {
                  n = 1;
                  label242:
                  if ((n == 0) || (bool)) {
                    break label317;
                  }
                  ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVg(str);
                }
                for (;;)
                {
                  if (com.tencent.mm.al.g.Et(str)) {
                    localLinkedList2.add(str);
                  }
                  if (paramAnonymousMessage.field_unReadCount <= 0) {
                    break label858;
                  }
                  if (!x.Be(str)) {
                    break label351;
                  }
                  j += 1;
                  break;
                  n = 0;
                  break label242;
                  if ((n == 0) && (bool)) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVh(str);
                  }
                }
                label351:
                k += 1;
                i = paramAnonymousMessage.field_unReadCount + i;
                continue;
                paramAnonymousMessage = ag.aGy().Ea(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
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
                  if (!bu.isNullOrNil(EnterpriseConversationUI.EnterpriseConversationFmUI.e(EnterpriseConversationUI.EnterpriseConversationFmUI.this))) {
                    n = ag.aGy().Ec(EnterpriseConversationUI.EnterpriseConversationFmUI.e(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                  }
                  com.tencent.mm.plugin.report.service.g.yxI.f(12892, new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                  ae.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.g(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.h(EnterpriseConversationUI.EnterpriseConversationFmUI.this)), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                  if (localLinkedList1.size() > 0)
                  {
                    bc.aCg();
                    com.tencent.mm.model.c.azL().bn(localLinkedList1);
                    EnterpriseConversationUI.EnterpriseConversationFmUI.d(EnterpriseConversationUI.EnterpriseConversationFmUI.this).ZD();
                  }
                  if (ag.aGB().DZ(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this)))
                  {
                    ag.aGy();
                    e.a(EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.this), null);
                  }
                  ag.aGB().DZ(EnterpriseConversationUI.EnterpriseConversationFmUI.i(EnterpriseConversationUI.EnterpriseConversationFmUI.this));
                  if (localLinkedList2.size() <= 0) {
                    break label852;
                  }
                  i = 0;
                  while (i < localLinkedList2.size())
                  {
                    ag.aGB().DZ((String)localLinkedList2.get(i));
                    i += 1;
                  }
                  m = 0;
                  break;
                  l1 = 0L;
                  break label401;
                }
                AppMethodBeat.o(188072);
                return;
              }
            }
          };
        }
      }
      for (;;)
      {
        this.KRY.sendEmptyMessageDelayed(1, 500L);
        AppMethodBeat.o(38569);
        return;
        ae.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
        break;
        label608:
        paramBundle = paramBundle.field_digestUser;
        break label504;
        label616:
        this.KRY.removeMessages(1);
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
        com.tencent.mm.plugin.messenger.a.g.doC().q(str1, str2, bool);
        com.tencent.mm.plugin.messenger.a.g.doC().hW(paramIntent, str2);
        com.tencent.mm.ui.widget.snackbar.b.n(thisActivity(), getContext().getString(2131759420));
        AppMethodBeat.o(38573);
        return;
      }
      AppMethodBeat.o(38573);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(38570);
      ag.aGy().a(this.JPN);
      if (bc.ajM())
      {
        bc.aCg();
        com.tencent.mm.model.c.azL().b(this);
        bc.aCg();
        com.tencent.mm.model.c.azF().b(this);
      }
      if (this.KRW != null)
      {
        localObject = this.KRW;
        j localj = ((l)localObject).KSY;
        localj.KOZ.stopTimer();
        if (localj.JPs != null)
        {
          localj.JPs.clear();
          localj.JPs = null;
        }
        localj.dhl();
        localj.fzh();
        bc.aCg();
        com.tencent.mm.model.c.azL().b(localj);
        ((l)localObject).KSZ.onDestroy();
      }
      if (this.KSc != null)
      {
        localObject = this.KSc;
        bc.ajj().b(1394, (com.tencent.mm.ak.f)localObject);
      }
      if ((this.enterTime <= 0L) || (this.irL <= 0L))
      {
        super.onDestroy();
        AppMethodBeat.o(38570);
        return;
      }
      long l = this.irL - this.enterTime;
      Object localObject = ag.aGy().Ea(this.hSG);
      int i;
      if (localObject != null)
      {
        i = ((com.tencent.mm.al.d)localObject).field_qyUin;
        label216:
        if (localObject == null) {
          break label337;
        }
      }
      label337:
      for (int j = ((com.tencent.mm.al.d)localObject).field_userUin;; j = 0)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
        ae.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
        break;
        i = 0;
        break label216;
      }
    }
    
    public void onPause()
    {
      AppMethodBeat.i(38572);
      ae.v("MicroMsg.EnterpriseConversationUI", "on pause");
      bc.aCg();
      com.tencent.mm.model.c.azL().aVc(this.hSG);
      if (this.KRW != null)
      {
        l locall = this.KRW;
        locall.KSY.onPause();
        locall.KSZ.onPause();
      }
      super.onPause();
      AppMethodBeat.o(38572);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(38571);
      ae.v("MicroMsg.EnterpriseConversationUI", "on resume");
      Object localObject;
      if (this.KSb != null)
      {
        localObject = this.KSb;
        if (0L != ((com.tencent.mm.ui.conversation.presenter.a)localObject).KVK)
        {
          if (((com.tencent.mm.ui.conversation.presenter.a)localObject).KVJ != null) {
            ((com.tencent.mm.ui.conversation.presenter.a)localObject).KVJ.ER(((com.tencent.mm.ui.conversation.presenter.a)localObject).KVK);
          }
          ((com.tencent.mm.ui.conversation.presenter.a)localObject).KVK = 0L;
        }
      }
      if (this.KRW != null)
      {
        localObject = this.KRW;
        ((l)localObject).KSY.onResume();
        ((l)localObject).KSZ.onResume();
      }
      super.onResume();
      if (!x.An(this.hSG)) {
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