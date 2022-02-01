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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.i;
import com.tencent.mm.g.c.au;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;

public class NearbySayHiListUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private ListView iiS;
  private View imc;
  private int limit;
  private n.d mRw;
  private int maxCount;
  private p tipDialog;
  private c uah;
  private bj ubh;
  private a ubi;
  private int ubj;
  private int ubk;
  private boolean ubl;
  private long ubm;
  
  public NearbySayHiListUI()
  {
    AppMethodBeat.i(89912);
    this.ubh = null;
    this.limit = 0;
    this.ubj = 0;
    this.ubk = 0;
    this.maxCount = 0;
    this.tipDialog = null;
    this.mRw = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(89894);
        com.tencent.mm.kernel.g.afz().aeD();
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOF().agi(String.valueOf(NearbySayHiListUI.h(NearbySayHiListUI.this)));
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
    this.iiS = ((ListView)findViewById(2131304293));
    if (!com.tencent.mm.bq.a.euw())
    {
      localObject = getLayoutInflater().inflate(2131495281, null);
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89892);
          NearbySayHiListUI.a(NearbySayHiListUI.this, NearbySayHiListUI.a(NearbySayHiListUI.this) + 8);
          ad.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.a(NearbySayHiListUI.this));
          paramAnonymousView = NearbySayHiListUI.b(NearbySayHiListUI.this);
          int i = NearbySayHiListUI.a(NearbySayHiListUI.this);
          paramAnonymousView.cHX();
          paramAnonymousView.limit = i;
          paramAnonymousView.Wd();
          if (NearbySayHiListUI.c(NearbySayHiListUI.this) <= NearbySayHiListUI.a(NearbySayHiListUI.this))
          {
            NearbySayHiListUI.d(NearbySayHiListUI.this).removeFooterView(this.ubn);
            ad.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.a(NearbySayHiListUI.this));
          }
          AppMethodBeat.o(89892);
        }
      });
      if ((this.ubj > 0) && (this.limit < this.ubj)) {
        this.iiS.addFooterView((View)localObject);
      }
    }
    addTextOptionMenu(0, getString(2131755694), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(89897);
        com.tencent.mm.ui.base.h.a(NearbySayHiListUI.this.getContext(), true, NearbySayHiListUI.this.getResources().getString(2131762787), "", NearbySayHiListUI.this.getResources().getString(2131762786), NearbySayHiListUI.this.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(89896);
            NearbySayHiListUI.e(NearbySayHiListUI.this).aSi();
            NearbySayHiListUI.b(NearbySayHiListUI.this).Wd();
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
    if (this.ubj == 0)
    {
      localObject = (TextView)findViewById(2131299468);
      ((TextView)localObject).setText(2131762792);
      ((TextView)localObject).setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.ubl) && (this.maxCount != 0) && (this.ubk >= this.maxCount) && (bt.iP(this)))
    {
      this.imc = new CleanLocationHeaderView(this);
      this.imc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89899);
          NearbySayHiListUI.a(NearbySayHiListUI.this, new c(2, 0.0F, 0.0F, 0, 0, "", ""));
          com.tencent.mm.kernel.g.aeS().a(NearbySayHiListUI.f(NearbySayHiListUI.this), 0);
          paramAnonymousView = NearbySayHiListUI.this;
          AppCompatActivity localAppCompatActivity = NearbySayHiListUI.this.getContext();
          NearbySayHiListUI.this.getString(2131755906);
          NearbySayHiListUI.a(paramAnonymousView, com.tencent.mm.ui.base.h.b(localAppCompatActivity, NearbySayHiListUI.this.getString(2131761498), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(89898);
              com.tencent.mm.kernel.g.aeS().a(NearbySayHiListUI.f(NearbySayHiListUI.this));
              AppMethodBeat.o(89898);
            }
          }));
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(11429, "0");
          AppMethodBeat.o(89899);
        }
      });
      this.iiS.addHeaderView(this.imc);
    }
    this.ubi = new a(this, this.ubh, this.limit);
    this.ubi.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dw(View paramAnonymousView)
      {
        AppMethodBeat.i(89900);
        int i = NearbySayHiListUI.d(NearbySayHiListUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(89900);
        return i;
      }
    });
    this.ubi.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(89901);
        NearbySayHiListUI.d(NearbySayHiListUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(89901);
      }
    });
    this.ubi.a(new MMSlideDelView.f()
    {
      public final void cO(Object paramAnonymousObject)
      {
        AppMethodBeat.i(89902);
        if (paramAnonymousObject == null)
        {
          ad.e("MicroMsg.SayHiListUI", "onItemDel object null");
          AppMethodBeat.o(89902);
          return;
        }
        com.tencent.mm.kernel.g.afz().aeD();
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOF().agi(paramAnonymousObject.toString());
        NearbySayHiListUI.b(NearbySayHiListUI.this).a(null, null);
        AppMethodBeat.o(89902);
      }
    });
    this.iiS.setAdapter(this.ubi);
    Object localObject = new com.tencent.mm.ui.tools.l(this);
    this.iiS.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
        this.mRz.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, NearbySayHiListUI.this, NearbySayHiListUI.g(NearbySayHiListUI.this));
        AppMethodBeat.o(89903);
        return true;
      }
    });
    this.iiS.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(89904);
        int i = paramAnonymousInt;
        if (NearbySayHiListUI.d(NearbySayHiListUI.this).getHeaderViewsCount() > 0) {
          i = paramAnonymousInt - NearbySayHiListUI.d(NearbySayHiListUI.this).getHeaderViewsCount();
        }
        bi localbi = (bi)NearbySayHiListUI.b(NearbySayHiListUI.this).getItem(i);
        if ((localbi == null) || (localbi.field_content == null))
        {
          AppMethodBeat.o(89904);
          return;
        }
        paramAnonymousView = bl.d.aIR(localbi.field_content);
        paramAnonymousAdapterView = new Intent();
        if (com.tencent.mm.bq.a.euw())
        {
          paramAnonymousAdapterView.putExtra("Chat_User", localbi.field_sayhiencryptuser);
          paramAnonymousAdapterView.putExtra("lbs_mode", true);
          paramAnonymousAdapterView.putExtra("add_scene", 18);
          com.tencent.mm.plugin.nearby.a.hYt.d(paramAnonymousAdapterView, NearbySayHiListUI.this);
          paramAnonymousAdapterView = new i();
          paramAnonymousAdapterView.daZ.scene = paramAnonymousView.scene;
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousAdapterView);
          AppMethodBeat.o(89904);
          return;
        }
        Intent localIntent = new Intent();
        if (bt.isNullOrNil(paramAnonymousView.yGA))
        {
          paramAnonymousAdapterView = localbi.field_sayhiuser;
          label194:
          localIntent.putExtra("Contact_User", paramAnonymousAdapterView);
          localIntent.putExtra("Contact_Alias", paramAnonymousView.eKn);
          localIntent.putExtra("Contact_Nick", paramAnonymousView.nickname);
          localIntent.putExtra("Contact_QuanPin", paramAnonymousView.ilF);
          localIntent.putExtra("Contact_PyInitial", paramAnonymousView.ilE);
          localIntent.putExtra("Contact_Sex", paramAnonymousView.evp);
          localIntent.putExtra("Contact_Signature", paramAnonymousView.signature);
          localIntent.putExtra("Contact_Scene", paramAnonymousView.scene);
          localIntent.putExtra("Contact_FMessageCard", true);
          localIntent.putExtra("Contact_City", paramAnonymousView.getCity());
          localIntent.putExtra("Contact_Province", paramAnonymousView.getProvince());
          if (!bt.isNullOrNil(localbi.field_sayhicontent)) {
            break label570;
          }
        }
        label570:
        for (paramAnonymousAdapterView = NearbySayHiListUI.this.getString(2131757177);; paramAnonymousAdapterView = localbi.field_sayhicontent)
        {
          localIntent.putExtra("Contact_Content", paramAnonymousAdapterView);
          localIntent.putExtra("Contact_verify_Scene", paramAnonymousView.scene);
          localIntent.putExtra("Contact_Uin", paramAnonymousView.uCr);
          localIntent.putExtra("Contact_QQNick", paramAnonymousView.ilG);
          localIntent.putExtra("Contact_Mobile_MD5", paramAnonymousView.FzV);
          localIntent.putExtra("User_From_Fmessage", true);
          localIntent.putExtra("Contact_from_msgType", 37);
          localIntent.putExtra("Verify_ticket", paramAnonymousView.rso);
          localIntent.putExtra("Contact_Source_FMessage", paramAnonymousView.scene);
          localIntent.putExtra("Contact_ShowFMessageList", true);
          paramAnonymousAdapterView = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramAnonymousView.yGA);
          if ((paramAnonymousAdapterView != null) && ((int)paramAnonymousAdapterView.fId >= 0) && (!b.ls(paramAnonymousAdapterView.field_type)))
          {
            paramAnonymousInt = paramAnonymousView.djq;
            if ((paramAnonymousInt == 0) || (paramAnonymousInt == 2) || (paramAnonymousInt == 5)) {
              localIntent.putExtra("User_Verify", true);
            }
            localIntent.putExtra("Contact_IsLBSFriend", true);
            localIntent.putExtra("Sns_from_Scene", 18);
          }
          com.tencent.mm.plugin.nearby.a.hYt.c(localIntent, NearbySayHiListUI.this);
          break;
          paramAnonymousAdapterView = paramAnonymousView.yGA;
          break label194;
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
        paramAnonymousView = NearbySayHiListUI.d(NearbySayHiListUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
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
    this.maxCount = bt.aGh(com.tencent.mm.m.g.Zd().getValue("ThresholdToCleanLocation"));
    this.ubl = getIntent().getBooleanExtra("show_clear_header", false);
    com.tencent.mm.kernel.g.afz().aeD();
    this.ubh = ((bj)((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOF());
    setMMTitle(2131762789);
    this.ubk = this.ubh.bIR();
    this.ubj = this.ubh.getCount();
    int i;
    if (com.tencent.mm.bq.a.euw()) {
      i = this.ubj;
    }
    for (;;)
    {
      this.limit = i;
      paramBundle = this.ubh;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      AppMethodBeat.o(89913);
      return;
      if (this.ubk == 0) {
        i = 8;
      } else {
        i = this.ubk;
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(89919);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (bi)this.ubi.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      ad.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(89919);
      return;
    }
    paramContextMenu.add(0, 0, 0, 2131755707);
    this.ubm = paramContextMenuInfo.field_svrid;
    AppMethodBeat.o(89919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(89915);
    this.ubi.cHX();
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
    com.tencent.mm.kernel.g.aeS().b(148, this);
    super.onPause();
    AppMethodBeat.o(89916);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89914);
    super.onResume();
    if (this.ubj != this.ubh.getCount())
    {
      this.ubj = this.ubh.getCount();
      if (this.ubj == 0)
      {
        TextView localTextView = (TextView)findViewById(2131299468);
        localTextView.setText(2131762792);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.ubi.Wd();
    }
    this.ubi.notifyDataSetChanged();
    com.tencent.mm.kernel.g.aeS().a(148, this);
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
      if (((c)paramn).JJ() == 2)
      {
        com.tencent.mm.ui.base.h.d(getContext(), getString(2131761497), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(89895);
            NearbySayHiListUI.this.setResult(-1);
            NearbySayHiListUI.this.finish();
            AppMethodBeat.o(89895);
          }
        });
        this.uah = null;
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
    extends com.tencent.mm.ui.q<bi>
  {
    private MMActivity imP;
    int limit;
    protected MMSlideDelView.g mRk;
    protected MMSlideDelView.c mRl;
    protected MMSlideDelView.d mRn;
    private bj ubh;
    protected MMSlideDelView.f ubr;
    
    public a(Context paramContext, bj parambj, int paramInt)
    {
      super(new bi());
      AppMethodBeat.i(89907);
      this.limit = -1;
      this.mRn = MMSlideDelView.getItemStatusCallBack();
      this.imP = ((MMActivity)paramContext);
      this.limit = paramInt;
      this.ubh = parambj;
      AppMethodBeat.o(89907);
    }
    
    public final void Wd()
    {
      AppMethodBeat.i(89909);
      if (com.tencent.mm.bq.a.euw()) {
        setCursor(this.ubh.WC(this.limit));
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        AppMethodBeat.o(89909);
        return;
        setCursor(this.ubh.Fn(this.limit));
      }
    }
    
    public final void We()
    {
      AppMethodBeat.i(89908);
      Wd();
      AppMethodBeat.o(89908);
    }
    
    public final void a(MMSlideDelView.f paramf)
    {
      this.ubr = paramf;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(89910);
      bi localbi = (bi)getItem(paramInt);
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = (MMSlideDelView)View.inflate(this.imP, 2131493169, null);
        localObject = View.inflate(this.imP, 2131495280, null);
        paramViewGroup.fuj = ((ImageView)((View)localObject).findViewById(2131298722));
        paramViewGroup.iiF = ((TextView)((View)localObject).findViewById(2131299149));
        paramViewGroup.twu = ((TextView)((View)localObject).findViewById(2131304296));
        paramViewGroup.mRs = paramView.findViewById(2131304837);
        paramViewGroup.mRt = ((TextView)paramView.findViewById(2131304839));
        paramView.setView((View)localObject);
        paramView.setPerformItemClickListener(this.mRk);
        paramView.setGetViewPositionCallback(this.mRl);
        paramView.setItemStatusCallBack(this.mRn);
        paramView.setEnable(false);
        paramView.setTag(paramViewGroup);
        if (localbi.field_flag == 0) {
          break label289;
        }
      }
      label289:
      for (Object localObject = bl.d.aIR(localbi.field_content).nickname;; localObject = localbi.field_talker)
      {
        paramViewGroup.iiF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.imP, (CharSequence)localObject, paramViewGroup.iiF.getTextSize()));
        paramViewGroup.twu.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.imP, localbi.field_sayhicontent, paramViewGroup.twu.getTextSize()));
        paramViewGroup.mRs.setTag(Long.valueOf(localbi.field_svrid));
        paramViewGroup.mRs.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(89906);
            ad.v("MicroMsg.SayHiAdapter", "on delView clicked");
            NearbySayHiListUI.a.this.mRn.cIh();
            if (NearbySayHiListUI.a.this.ubr != null) {
              NearbySayHiListUI.a.this.ubr.cO(paramAnonymousView.getTag());
            }
            AppMethodBeat.o(89906);
          }
        });
        a.b.c(paramViewGroup.fuj, localbi.field_sayhiuser);
        AppMethodBeat.o(89910);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
      }
    }
    
    public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
    {
      this.mRl = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.mRk = paramg;
    }
    
    final class a
    {
      ImageView fuj;
      TextView iiF;
      View mRs;
      TextView mRt;
      TextView twu;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI
 * JD-Core Version:    0.7.0.1
 */