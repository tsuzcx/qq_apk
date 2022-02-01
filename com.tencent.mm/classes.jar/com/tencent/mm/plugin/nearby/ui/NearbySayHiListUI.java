package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.i;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bv.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r;

public class NearbySayHiListUI
  extends MMActivity
  implements f
{
  private ListView jfb;
  private View jil;
  private int limit;
  private int maxCount;
  private n.e oao;
  private p tipDialog;
  private com.tencent.mm.plugin.nearby.a.c wEi;
  private bt wFg;
  private a wFh;
  private int wFi;
  private int wFj;
  private boolean wFk;
  private long wFl;
  
  public NearbySayHiListUI()
  {
    AppMethodBeat.i(89912);
    this.wFg = null;
    this.limit = 0;
    this.wFi = 0;
    this.wFj = 0;
    this.maxCount = 0;
    this.tipDialog = null;
    this.oao = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(89894);
        com.tencent.mm.kernel.g.ajP().aiU();
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doG().aqU(String.valueOf(NearbySayHiListUI.h(NearbySayHiListUI.this)));
        NearbySayHiListUI.b(NearbySayHiListUI.this).a(null, null);
        if (NearbySayHiListUI.c(NearbySayHiListUI.this) > 0) {
          NearbySayHiListUI.i(NearbySayHiListUI.this);
        }
        NearbySayHiListUI.j(NearbySayHiListUI.this);
        AppMethodBeat.o(89894);
      }
    };
    AppMethodBeat.o(89912);
  }
  
  public int getLayoutId()
  {
    return 2131494580;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89918);
    this.jfb = ((ListView)findViewById(2131304293));
    if (!com.tencent.mm.bp.a.fcr())
    {
      localObject = getLayoutInflater().inflate(2131495281, null);
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89892);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          NearbySayHiListUI.a(NearbySayHiListUI.this, NearbySayHiListUI.a(NearbySayHiListUI.this) + 8);
          ae.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.a(NearbySayHiListUI.this));
          paramAnonymousView = NearbySayHiListUI.b(NearbySayHiListUI.this);
          int i = NearbySayHiListUI.a(NearbySayHiListUI.this);
          paramAnonymousView.dhl();
          paramAnonymousView.limit = i;
          paramAnonymousView.ZD();
          if (NearbySayHiListUI.c(NearbySayHiListUI.this) <= NearbySayHiListUI.a(NearbySayHiListUI.this))
          {
            NearbySayHiListUI.d(NearbySayHiListUI.this).removeFooterView(this.wFm);
            ae.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.a(NearbySayHiListUI.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(89892);
        }
      });
      if ((this.wFi > 0) && (this.limit < this.wFi)) {
        this.jfb.addFooterView((View)localObject);
      }
    }
    addTextOptionMenu(0, getString(2131755694), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(89897);
        h.a(NearbySayHiListUI.this.getContext(), true, NearbySayHiListUI.this.getResources().getString(2131762787), "", NearbySayHiListUI.this.getResources().getString(2131762786), NearbySayHiListUI.this.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(89896);
            NearbySayHiListUI.e(NearbySayHiListUI.this).bdi();
            NearbySayHiListUI.b(NearbySayHiListUI.this).ZD();
            paramAnonymous2DialogInterface = (TextView)NearbySayHiListUI.this.findViewById(2131299468);
            paramAnonymous2DialogInterface.setText(2131762792);
            paramAnonymous2DialogInterface.setVisibility(0);
            NearbySayHiListUI.this.enableOptionMenu(false);
            AppMethodBeat.o(89896);
          }
        }, null);
        AppMethodBeat.o(89897);
        return true;
      }
    });
    if (this.wFi == 0)
    {
      localObject = (TextView)findViewById(2131299468);
      ((TextView)localObject).setText(2131762792);
      ((TextView)localObject).setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.wFk) && (this.maxCount != 0) && (this.wFj >= this.maxCount) && (bu.jq(this)))
    {
      this.jil = new CleanLocationHeaderView(this);
      this.jil.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89899);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          NearbySayHiListUI.a(NearbySayHiListUI.this, new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", ""));
          com.tencent.mm.kernel.g.ajj().a(NearbySayHiListUI.f(NearbySayHiListUI.this), 0);
          paramAnonymousView = NearbySayHiListUI.this;
          localObject = NearbySayHiListUI.this.getContext();
          NearbySayHiListUI.this.getString(2131755906);
          NearbySayHiListUI.a(paramAnonymousView, h.b((Context)localObject, NearbySayHiListUI.this.getString(2131761498), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(89898);
              com.tencent.mm.kernel.g.ajj().a(NearbySayHiListUI.f(NearbySayHiListUI.this));
              AppMethodBeat.o(89898);
            }
          }));
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(11429, "0");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(89899);
        }
      });
      this.jfb.addHeaderView(this.jil);
    }
    this.wFh = new a(this, this.wFg, this.limit);
    this.wFh.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(89900);
        int i = NearbySayHiListUI.d(NearbySayHiListUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(89900);
        return i;
      }
    });
    this.wFh.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(89901);
        NearbySayHiListUI.d(NearbySayHiListUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(89901);
      }
    });
    this.wFh.a(new MMSlideDelView.f()
    {
      public final void cQ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(89902);
        if (paramAnonymousObject == null)
        {
          ae.e("MicroMsg.SayHiListUI", "onItemDel object null");
          AppMethodBeat.o(89902);
          return;
        }
        com.tencent.mm.kernel.g.ajP().aiU();
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doG().aqU(paramAnonymousObject.toString());
        NearbySayHiListUI.b(NearbySayHiListUI.this).a(null, null);
        AppMethodBeat.o(89902);
      }
    });
    this.jfb.setAdapter(this.wFh);
    Object localObject = new com.tencent.mm.ui.tools.l(this);
    this.jfb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(89903);
        if (paramAnonymousInt < NearbySayHiListUI.d(NearbySayHiListUI.this).getHeaderViewsCount())
        {
          ae.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
          AppMethodBeat.o(89903);
          return true;
        }
        this.oar.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, NearbySayHiListUI.this, NearbySayHiListUI.g(NearbySayHiListUI.this));
        AppMethodBeat.o(89903);
        return true;
      }
    });
    this.jfb.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(89904);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousAdapterView);
        ((b)localObject).bd(paramAnonymousView);
        ((b)localObject).mu(paramAnonymousInt);
        ((b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahF());
        int i = paramAnonymousInt;
        if (NearbySayHiListUI.d(NearbySayHiListUI.this).getHeaderViewsCount() > 0) {
          i = paramAnonymousInt - NearbySayHiListUI.d(NearbySayHiListUI.this).getHeaderViewsCount();
        }
        bs localbs = (bs)NearbySayHiListUI.b(NearbySayHiListUI.this).getItem(i);
        if ((localbs == null) || (localbs.field_content == null))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(89904);
          return;
        }
        paramAnonymousView = bv.d.aVF(localbs.field_content);
        paramAnonymousAdapterView = new Intent();
        if (com.tencent.mm.bp.a.fcr())
        {
          paramAnonymousAdapterView.putExtra("Chat_User", localbs.field_sayhiencryptuser);
          paramAnonymousAdapterView.putExtra("lbs_mode", true);
          paramAnonymousAdapterView.putExtra("add_scene", 18);
          com.tencent.mm.plugin.nearby.a.iUz.d(paramAnonymousAdapterView, NearbySayHiListUI.this);
          paramAnonymousAdapterView = new i();
          paramAnonymousAdapterView.dkP.scene = paramAnonymousView.scene;
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(89904);
          return;
        }
        localObject = new Intent();
        if (bu.isNullOrNil(paramAnonymousView.cUA))
        {
          paramAnonymousAdapterView = localbs.field_sayhiuser;
          label269:
          ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
          ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.fhy);
          ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.nickname);
          ((Intent)localObject).putExtra("Contact_QuanPin", paramAnonymousView.jhO);
          ((Intent)localObject).putExtra("Contact_PyInitial", paramAnonymousView.jhN);
          ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.eQV);
          ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.signature);
          ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject).putExtra("Contact_City", paramAnonymousView.getCity());
          ((Intent)localObject).putExtra("Contact_Province", paramAnonymousView.getProvince());
          if (!bu.isNullOrNil(localbs.field_sayhicontent)) {
            break label648;
          }
        }
        label648:
        for (paramAnonymousAdapterView = NearbySayHiListUI.this.getString(2131757177);; paramAnonymousAdapterView = localbs.field_sayhicontent)
        {
          ((Intent)localObject).putExtra("Contact_Content", paramAnonymousAdapterView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_Uin", paramAnonymousView.xik);
          ((Intent)localObject).putExtra("Contact_QQNick", paramAnonymousView.jhP);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramAnonymousView.JgT);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Verify_ticket", paramAnonymousView.tIA);
          ((Intent)localObject).putExtra("Contact_Source_FMessage", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_ShowFMessageList", true);
          paramAnonymousAdapterView = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramAnonymousView.cUA);
          if ((paramAnonymousAdapterView != null) && ((int)paramAnonymousAdapterView.ght >= 0) && (!com.tencent.mm.contact.c.lO(paramAnonymousAdapterView.field_type)))
          {
            paramAnonymousInt = paramAnonymousView.dto;
            if ((paramAnonymousInt == 0) || (paramAnonymousInt == 2) || (paramAnonymousInt == 5)) {
              ((Intent)localObject).putExtra("User_Verify", true);
            }
            ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
            ((Intent)localObject).putExtra("Sns_from_Scene", 18);
          }
          com.tencent.mm.plugin.nearby.a.iUz.c((Intent)localObject, NearbySayHiListUI.this);
          break;
          paramAnonymousAdapterView = paramAnonymousView.cUA;
          break label269;
        }
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(89905);
        NearbySayHiListUI.this.hideVKB();
        NearbySayHiListUI.this.setResult(0);
        NearbySayHiListUI.this.finish();
        AppMethodBeat.o(89905);
        return true;
      }
    });
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(89893);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        paramAnonymousView = NearbySayHiListUI.d(NearbySayHiListUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(89893);
      }
    });
    AppMethodBeat.o(89918);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(89920);
    setResult(0);
    super.onBackPressed();
    AppMethodBeat.o(89920);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(89913);
    super.onCreate(paramBundle);
    this.maxCount = bu.aSB(com.tencent.mm.n.g.acL().getValue("ThresholdToCleanLocation"));
    this.wFk = getIntent().getBooleanExtra("show_clear_header", false);
    com.tencent.mm.kernel.g.ajP().aiU();
    this.wFg = ((bt)((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doG());
    setMMTitle(2131762789);
    this.wFj = this.wFg.bVY();
    this.wFi = this.wFg.getCount();
    int i;
    if (com.tencent.mm.bp.a.fcr()) {
      i = this.wFi;
    }
    for (;;)
    {
      this.limit = i;
      paramBundle = this.wFg;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      AppMethodBeat.o(89913);
      return;
      if (this.wFj == 0) {
        i = 8;
      } else {
        i = this.wFj;
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(89919);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (bs)this.wFh.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      ae.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(89919);
      return;
    }
    paramContextMenu.add(0, 0, 0, 2131755707);
    this.wFl = paramContextMenuInfo.field_svrid;
    AppMethodBeat.o(89919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(89915);
    this.wFh.dhl();
    super.onDestroy();
    AppMethodBeat.o(89915);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(89917);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(89917);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(89916);
    com.tencent.mm.kernel.g.ajj().b(148, this);
    super.onPause();
    AppMethodBeat.o(89916);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89914);
    super.onResume();
    if (this.wFi != this.wFg.getCount())
    {
      this.wFi = this.wFg.getCount();
      if (this.wFi == 0)
      {
        TextView localTextView = (TextView)findViewById(2131299468);
        localTextView.setText(2131762792);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.wFh.ZD();
    }
    this.wFh.notifyDataSetChanged();
    com.tencent.mm.kernel.g.ajj().a(148, this);
    AppMethodBeat.o(89914);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(89921);
    ae.i("MicroMsg.SayHiListUI", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (((com.tencent.mm.plugin.nearby.a.c)paramn).KZ() == 2)
      {
        h.d(getContext(), getString(2131761497), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(89895);
            NearbySayHiListUI.this.setResult(-1);
            NearbySayHiListUI.this.finish();
            AppMethodBeat.o(89895);
          }
        });
        this.wEi = null;
        AppMethodBeat.o(89921);
      }
    }
    else {
      ae.w("MicroMsg.SayHiListUI", "[cpan] clear location failed.");
    }
    AppMethodBeat.o(89921);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends r<bs>
  {
    private MMActivity fNT;
    int limit;
    protected MMSlideDelView.g oac;
    protected MMSlideDelView.c oad;
    protected MMSlideDelView.d oaf;
    private bt wFg;
    protected MMSlideDelView.f wFq;
    
    public a(Context paramContext, bt parambt, int paramInt)
    {
      super(new bs());
      AppMethodBeat.i(89907);
      this.limit = -1;
      this.oaf = MMSlideDelView.getItemStatusCallBack();
      this.fNT = ((MMActivity)paramContext);
      this.limit = paramInt;
      this.wFg = parambt;
      AppMethodBeat.o(89907);
    }
    
    public final void ZD()
    {
      AppMethodBeat.i(89909);
      if (com.tencent.mm.bp.a.fcr()) {
        setCursor(this.wFg.abD(this.limit));
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        AppMethodBeat.o(89909);
        return;
        setCursor(this.wFg.Jc(this.limit));
      }
    }
    
    public final void ZE()
    {
      AppMethodBeat.i(89908);
      ZD();
      AppMethodBeat.o(89908);
    }
    
    public final void a(MMSlideDelView.f paramf)
    {
      this.wFq = paramf;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(89910);
      bs localbs = (bs)getItem(paramInt);
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = (MMSlideDelView)View.inflate(this.fNT, 2131493169, null);
        localObject = View.inflate(this.fNT, 2131495280, null);
        paramViewGroup.fTj = ((ImageView)((View)localObject).findViewById(2131298722));
        paramViewGroup.jeP = ((TextView)((View)localObject).findViewById(2131299149));
        paramViewGroup.vTQ = ((TextView)((View)localObject).findViewById(2131304296));
        paramViewGroup.oak = paramView.findViewById(2131304837);
        paramViewGroup.oal = ((TextView)paramView.findViewById(2131304839));
        paramView.setView((View)localObject);
        paramView.setPerformItemClickListener(this.oac);
        paramView.setGetViewPositionCallback(this.oad);
        paramView.setItemStatusCallBack(this.oaf);
        paramView.setEnable(false);
        paramView.setTag(paramViewGroup);
        if (localbs.field_flag == 0) {
          break label289;
        }
      }
      label289:
      for (Object localObject = bv.d.aVF(localbs.field_content).nickname;; localObject = localbs.field_talker)
      {
        paramViewGroup.jeP.setText(k.b(this.fNT, (CharSequence)localObject, paramViewGroup.jeP.getTextSize()));
        paramViewGroup.vTQ.setText(k.b(this.fNT, localbs.field_sayhicontent, paramViewGroup.vTQ.getTextSize()));
        paramViewGroup.oak.setTag(Long.valueOf(localbs.field_svrid));
        paramViewGroup.oak.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(89906);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.v("MicroMsg.SayHiAdapter", "on delView clicked");
            NearbySayHiListUI.a.this.oaf.dhv();
            if (NearbySayHiListUI.a.this.wFq != null) {
              NearbySayHiListUI.a.this.wFq.cQ(paramAnonymousView.getTag());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(89906);
          }
        });
        a.b.c(paramViewGroup.fTj, localbs.field_sayhiuser);
        AppMethodBeat.o(89910);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
      }
    }
    
    public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
    {
      this.oad = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.oac = paramg;
    }
    
    final class a
    {
      ImageView fTj;
      TextView jeP;
      View oak;
      TextView oal;
      TextView vTQ;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI
 * JD-Core Version:    0.7.0.1
 */