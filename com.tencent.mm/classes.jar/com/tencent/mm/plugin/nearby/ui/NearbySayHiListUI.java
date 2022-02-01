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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.i;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bu.d;
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
  private ListView jci;
  private View jfs;
  private int limit;
  private int maxCount;
  private n.e nUI;
  private p tipDialog;
  private c woz;
  private int wpA;
  private boolean wpB;
  private long wpC;
  private bs wpx;
  private a wpy;
  private int wpz;
  
  public NearbySayHiListUI()
  {
    AppMethodBeat.i(89912);
    this.wpx = null;
    this.limit = 0;
    this.wpz = 0;
    this.wpA = 0;
    this.maxCount = 0;
    this.tipDialog = null;
    this.nUI = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(89894);
        com.tencent.mm.kernel.g.ajA().aiF();
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlH().apP(String.valueOf(NearbySayHiListUI.h(NearbySayHiListUI.this)));
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
    this.jci = ((ListView)findViewById(2131304293));
    if (!com.tencent.mm.bq.a.eYD())
    {
      localObject = getLayoutInflater().inflate(2131495281, null);
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89892);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          NearbySayHiListUI.a(NearbySayHiListUI.this, NearbySayHiListUI.a(NearbySayHiListUI.this) + 8);
          ad.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.a(NearbySayHiListUI.this));
          paramAnonymousView = NearbySayHiListUI.b(NearbySayHiListUI.this);
          int i = NearbySayHiListUI.a(NearbySayHiListUI.this);
          paramAnonymousView.det();
          paramAnonymousView.limit = i;
          paramAnonymousView.Zu();
          if (NearbySayHiListUI.c(NearbySayHiListUI.this) <= NearbySayHiListUI.a(NearbySayHiListUI.this))
          {
            NearbySayHiListUI.d(NearbySayHiListUI.this).removeFooterView(this.wpD);
            ad.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.a(NearbySayHiListUI.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(89892);
        }
      });
      if ((this.wpz > 0) && (this.limit < this.wpz)) {
        this.jci.addFooterView((View)localObject);
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
            NearbySayHiListUI.e(NearbySayHiListUI.this).bcD();
            NearbySayHiListUI.b(NearbySayHiListUI.this).Zu();
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
    if (this.wpz == 0)
    {
      localObject = (TextView)findViewById(2131299468);
      ((TextView)localObject).setText(2131762792);
      ((TextView)localObject).setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.wpB) && (this.maxCount != 0) && (this.wpA >= this.maxCount) && (bt.jk(this)))
    {
      this.jfs = new CleanLocationHeaderView(this);
      this.jfs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89899);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          NearbySayHiListUI.a(NearbySayHiListUI.this, new c(2, 0.0F, 0.0F, 0, 0, "", ""));
          com.tencent.mm.kernel.g.aiU().a(NearbySayHiListUI.f(NearbySayHiListUI.this), 0);
          paramAnonymousView = NearbySayHiListUI.this;
          localObject = NearbySayHiListUI.this.getContext();
          NearbySayHiListUI.this.getString(2131755906);
          NearbySayHiListUI.a(paramAnonymousView, h.b((Context)localObject, NearbySayHiListUI.this.getString(2131761498), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(89898);
              com.tencent.mm.kernel.g.aiU().a(NearbySayHiListUI.f(NearbySayHiListUI.this));
              AppMethodBeat.o(89898);
            }
          }));
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(11429, "0");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(89899);
        }
      });
      this.jci.addHeaderView(this.jfs);
    }
    this.wpy = new a(this, this.wpx, this.limit);
    this.wpy.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(89900);
        int i = NearbySayHiListUI.d(NearbySayHiListUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(89900);
        return i;
      }
    });
    this.wpy.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(89901);
        NearbySayHiListUI.d(NearbySayHiListUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(89901);
      }
    });
    this.wpy.a(new MMSlideDelView.f()
    {
      public final void cP(Object paramAnonymousObject)
      {
        AppMethodBeat.i(89902);
        if (paramAnonymousObject == null)
        {
          ad.e("MicroMsg.SayHiListUI", "onItemDel object null");
          AppMethodBeat.o(89902);
          return;
        }
        com.tencent.mm.kernel.g.ajA().aiF();
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlH().apP(paramAnonymousObject.toString());
        NearbySayHiListUI.b(NearbySayHiListUI.this).a(null, null);
        AppMethodBeat.o(89902);
      }
    });
    this.jci.setAdapter(this.wpy);
    Object localObject = new com.tencent.mm.ui.tools.l(this);
    this.jci.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(89903);
        if (paramAnonymousInt < NearbySayHiListUI.d(NearbySayHiListUI.this).getHeaderViewsCount())
        {
          ad.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
          AppMethodBeat.o(89903);
          return true;
        }
        this.nUL.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, NearbySayHiListUI.this, NearbySayHiListUI.g(NearbySayHiListUI.this));
        AppMethodBeat.o(89903);
        return true;
      }
    });
    this.jci.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(89904);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        int i = paramAnonymousInt;
        if (NearbySayHiListUI.d(NearbySayHiListUI.this).getHeaderViewsCount() > 0) {
          i = paramAnonymousInt - NearbySayHiListUI.d(NearbySayHiListUI.this).getHeaderViewsCount();
        }
        br localbr = (br)NearbySayHiListUI.b(NearbySayHiListUI.this).getItem(i);
        if ((localbr == null) || (localbr.field_content == null))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(89904);
          return;
        }
        paramAnonymousView = bu.d.aUe(localbr.field_content);
        paramAnonymousAdapterView = new Intent();
        if (com.tencent.mm.bq.a.eYD())
        {
          paramAnonymousAdapterView.putExtra("Chat_User", localbr.field_sayhiencryptuser);
          paramAnonymousAdapterView.putExtra("lbs_mode", true);
          paramAnonymousAdapterView.putExtra("add_scene", 18);
          com.tencent.mm.plugin.nearby.a.iRG.d(paramAnonymousAdapterView, NearbySayHiListUI.this);
          paramAnonymousAdapterView = new i();
          paramAnonymousAdapterView.djN.scene = paramAnonymousView.scene;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(89904);
          return;
        }
        localObject = new Intent();
        if (bt.isNullOrNil(paramAnonymousView.dHm))
        {
          paramAnonymousAdapterView = localbr.field_sayhiuser;
          label269:
          ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
          ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.ffB);
          ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.nickname);
          ((Intent)localObject).putExtra("Contact_QuanPin", paramAnonymousView.jeV);
          ((Intent)localObject).putExtra("Contact_PyInitial", paramAnonymousView.jeU);
          ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.ePk);
          ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.signature);
          ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject).putExtra("Contact_City", paramAnonymousView.getCity());
          ((Intent)localObject).putExtra("Contact_Province", paramAnonymousView.getProvince());
          if (!bt.isNullOrNil(localbr.field_sayhicontent)) {
            break label648;
          }
        }
        label648:
        for (paramAnonymousAdapterView = NearbySayHiListUI.this.getString(2131757177);; paramAnonymousAdapterView = localbr.field_sayhicontent)
        {
          ((Intent)localObject).putExtra("Contact_Content", paramAnonymousAdapterView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_Uin", paramAnonymousView.wSt);
          ((Intent)localObject).putExtra("Contact_QQNick", paramAnonymousView.jeW);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramAnonymousView.IMm);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Verify_ticket", paramAnonymousView.txJ);
          ((Intent)localObject).putExtra("Contact_Source_FMessage", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_ShowFMessageList", true);
          paramAnonymousAdapterView = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramAnonymousView.dHm);
          if ((paramAnonymousAdapterView != null) && ((int)paramAnonymousAdapterView.gfj >= 0) && (!com.tencent.mm.o.b.lM(paramAnonymousAdapterView.field_type)))
          {
            paramAnonymousInt = paramAnonymousView.dsi;
            if ((paramAnonymousInt == 0) || (paramAnonymousInt == 2) || (paramAnonymousInt == 5)) {
              ((Intent)localObject).putExtra("User_Verify", true);
            }
            ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
            ((Intent)localObject).putExtra("Sns_from_Scene", 18);
          }
          com.tencent.mm.plugin.nearby.a.iRG.c((Intent)localObject, NearbySayHiListUI.this);
          break;
          paramAnonymousAdapterView = paramAnonymousView.dHm;
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
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = NearbySayHiListUI.d(NearbySayHiListUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
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
    this.maxCount = bt.aRe(com.tencent.mm.n.g.acA().getValue("ThresholdToCleanLocation"));
    this.wpB = getIntent().getBooleanExtra("show_clear_header", false);
    com.tencent.mm.kernel.g.ajA().aiF();
    this.wpx = ((bs)((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlH());
    setMMTitle(2131762789);
    this.wpA = this.wpx.bUJ();
    this.wpz = this.wpx.getCount();
    int i;
    if (com.tencent.mm.bq.a.eYD()) {
      i = this.wpz;
    }
    for (;;)
    {
      this.limit = i;
      paramBundle = this.wpx;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      AppMethodBeat.o(89913);
      return;
      if (this.wpA == 0) {
        i = 8;
      } else {
        i = this.wpA;
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(89919);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (br)this.wpy.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      ad.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(89919);
      return;
    }
    paramContextMenu.add(0, 0, 0, 2131755707);
    this.wpC = paramContextMenuInfo.field_svrid;
    AppMethodBeat.o(89919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(89915);
    this.wpy.det();
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
    com.tencent.mm.kernel.g.aiU().b(148, this);
    super.onPause();
    AppMethodBeat.o(89916);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89914);
    super.onResume();
    if (this.wpz != this.wpx.getCount())
    {
      this.wpz = this.wpx.getCount();
      if (this.wpz == 0)
      {
        TextView localTextView = (TextView)findViewById(2131299468);
        localTextView.setText(2131762792);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.wpy.Zu();
    }
    this.wpy.notifyDataSetChanged();
    com.tencent.mm.kernel.g.aiU().a(148, this);
    AppMethodBeat.o(89914);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(89921);
    ad.i("MicroMsg.SayHiListUI", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (((c)paramn).KR() == 2)
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
        this.woz = null;
        AppMethodBeat.o(89921);
      }
    }
    else {
      ad.w("MicroMsg.SayHiListUI", "[cpan] clear location failed.");
    }
    AppMethodBeat.o(89921);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends r<br>
  {
    private MMActivity fLP;
    int limit;
    protected MMSlideDelView.g nUw;
    protected MMSlideDelView.c nUx;
    protected MMSlideDelView.d nUz;
    protected MMSlideDelView.f wpH;
    private bs wpx;
    
    public a(Context paramContext, bs parambs, int paramInt)
    {
      super(new br());
      AppMethodBeat.i(89907);
      this.limit = -1;
      this.nUz = MMSlideDelView.getItemStatusCallBack();
      this.fLP = ((MMActivity)paramContext);
      this.limit = paramInt;
      this.wpx = parambs;
      AppMethodBeat.o(89907);
    }
    
    public final void Zu()
    {
      AppMethodBeat.i(89909);
      if (com.tencent.mm.bq.a.eYD()) {
        setCursor(this.wpx.aaV(this.limit));
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        AppMethodBeat.o(89909);
        return;
        setCursor(this.wpx.IE(this.limit));
      }
    }
    
    public final void Zv()
    {
      AppMethodBeat.i(89908);
      Zu();
      AppMethodBeat.o(89908);
    }
    
    public final void a(MMSlideDelView.f paramf)
    {
      this.wpH = paramf;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(89910);
      br localbr = (br)getItem(paramInt);
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = (MMSlideDelView)View.inflate(this.fLP, 2131493169, null);
        localObject = View.inflate(this.fLP, 2131495280, null);
        paramViewGroup.fRd = ((ImageView)((View)localObject).findViewById(2131298722));
        paramViewGroup.jbW = ((TextView)((View)localObject).findViewById(2131299149));
        paramViewGroup.vHM = ((TextView)((View)localObject).findViewById(2131304296));
        paramViewGroup.nUE = paramView.findViewById(2131304837);
        paramViewGroup.nUF = ((TextView)paramView.findViewById(2131304839));
        paramView.setView((View)localObject);
        paramView.setPerformItemClickListener(this.nUw);
        paramView.setGetViewPositionCallback(this.nUx);
        paramView.setItemStatusCallBack(this.nUz);
        paramView.setEnable(false);
        paramView.setTag(paramViewGroup);
        if (localbr.field_flag == 0) {
          break label289;
        }
      }
      label289:
      for (Object localObject = bu.d.aUe(localbr.field_content).nickname;; localObject = localbr.field_talker)
      {
        paramViewGroup.jbW.setText(k.b(this.fLP, (CharSequence)localObject, paramViewGroup.jbW.getTextSize()));
        paramViewGroup.vHM.setText(k.b(this.fLP, localbr.field_sayhicontent, paramViewGroup.vHM.getTextSize()));
        paramViewGroup.nUE.setTag(Long.valueOf(localbr.field_svrid));
        paramViewGroup.nUE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(89906);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.v("MicroMsg.SayHiAdapter", "on delView clicked");
            NearbySayHiListUI.a.this.nUz.deD();
            if (NearbySayHiListUI.a.this.wpH != null) {
              NearbySayHiListUI.a.this.wpH.cP(paramAnonymousView.getTag());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(89906);
          }
        });
        a.b.c(paramViewGroup.fRd, localbr.field_sayhiuser);
        AppMethodBeat.o(89910);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
      }
    }
    
    public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
    {
      this.nUx = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.nUw = paramg;
    }
    
    final class a
    {
      ImageView fRd;
      TextView jbW;
      View nUE;
      TextView nUF;
      TextView vHM;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI
 * JD-Core Version:    0.7.0.1
 */