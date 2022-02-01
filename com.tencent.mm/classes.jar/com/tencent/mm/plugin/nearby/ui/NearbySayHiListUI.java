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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.j;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.n.f;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.s;

public class NearbySayHiListUI
  extends MMActivity
  implements i
{
  private by AAq;
  private a AAr;
  private int AAs;
  private int AAt;
  private boolean AAu;
  private long AAv;
  private com.tencent.mm.plugin.nearby.a.c AzP;
  private ListView kde;
  private View kgo;
  private int limit;
  private int maxCount;
  private o.g plk;
  private com.tencent.mm.ui.base.q tipDialog;
  
  public NearbySayHiListUI()
  {
    AppMethodBeat.i(89912);
    this.AAq = null;
    this.limit = 0;
    this.AAs = 0;
    this.AAt = 0;
    this.maxCount = 0;
    this.tipDialog = null;
    this.plk = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(89894);
        com.tencent.mm.kernel.g.aAf().azk();
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiv().aEp(String.valueOf(NearbySayHiListUI.h(NearbySayHiListUI.this)));
        NearbySayHiListUI.b(NearbySayHiListUI.this).onNotifyChange(null, null);
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
    return 2131495207;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89918);
    this.kde = ((ListView)findViewById(2131307221));
    if (!com.tencent.mm.bp.a.glC())
    {
      localObject = getLayoutInflater().inflate(2131496131, null);
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89892);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          NearbySayHiListUI.a(NearbySayHiListUI.this, NearbySayHiListUI.a(NearbySayHiListUI.this) + 8);
          Log.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.a(NearbySayHiListUI.this));
          paramAnonymousView = NearbySayHiListUI.b(NearbySayHiListUI.this);
          int i = NearbySayHiListUI.a(NearbySayHiListUI.this);
          paramAnonymousView.ebf();
          paramAnonymousView.limit = i;
          paramAnonymousView.anp();
          if (NearbySayHiListUI.c(NearbySayHiListUI.this) <= NearbySayHiListUI.a(NearbySayHiListUI.this))
          {
            NearbySayHiListUI.d(NearbySayHiListUI.this).removeFooterView(this.AAw);
            Log.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.a(NearbySayHiListUI.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(89892);
        }
      });
      if ((this.AAs > 0) && (this.limit < this.AAs)) {
        this.kde.addFooterView((View)localObject);
      }
    }
    addTextOptionMenu(0, getString(2131755764), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(89897);
        com.tencent.mm.ui.base.h.a(NearbySayHiListUI.this.getContext(), true, NearbySayHiListUI.this.getResources().getString(2131764874), "", NearbySayHiListUI.this.getResources().getString(2131764873), NearbySayHiListUI.this.getString(2131755761), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(89896);
            NearbySayHiListUI.e(NearbySayHiListUI.this).byC();
            NearbySayHiListUI.b(NearbySayHiListUI.this).anp();
            paramAnonymous2DialogInterface = (TextView)NearbySayHiListUI.this.findViewById(2131300096);
            paramAnonymous2DialogInterface.setText(2131764879);
            paramAnonymous2DialogInterface.setVisibility(0);
            NearbySayHiListUI.this.enableOptionMenu(false);
            AppMethodBeat.o(89896);
          }
        }, null);
        AppMethodBeat.o(89897);
        return true;
      }
    });
    if (this.AAs == 0)
    {
      localObject = (TextView)findViewById(2131300096);
      ((TextView)localObject).setText(2131764879);
      ((TextView)localObject).setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.AAu) && (this.maxCount != 0) && (this.AAt >= this.maxCount) && (Util.isOverseasUser(this)))
    {
      this.kgo = new CleanLocationHeaderView(this);
      this.kgo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89899);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          NearbySayHiListUI.a(NearbySayHiListUI.this, new com.tencent.mm.plugin.nearby.a.c(2, 0.0F, 0.0F, 0, 0, "", ""));
          com.tencent.mm.kernel.g.azz().a(NearbySayHiListUI.f(NearbySayHiListUI.this), 0);
          paramAnonymousView = NearbySayHiListUI.this;
          localObject = NearbySayHiListUI.this.getContext();
          NearbySayHiListUI.this.getString(2131755998);
          NearbySayHiListUI.a(paramAnonymousView, com.tencent.mm.ui.base.h.a((Context)localObject, NearbySayHiListUI.this.getString(2131763440), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(89898);
              com.tencent.mm.kernel.g.azz().a(NearbySayHiListUI.f(NearbySayHiListUI.this));
              AppMethodBeat.o(89898);
            }
          }));
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(11429, "0");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(89899);
        }
      });
      this.kde.addHeaderView(this.kgo);
    }
    this.AAr = new a(this, this.AAq, this.limit);
    this.AAr.setGetViewPositionCallback(new NearbySayHiListUI.7(this));
    this.AAr.setPerformItemClickListener(new NearbySayHiListUI.8(this));
    this.AAr.a(new MMSlideDelView.f()
    {
      public final void cZ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(89902);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.SayHiListUI", "onItemDel object null");
          AppMethodBeat.o(89902);
          return;
        }
        com.tencent.mm.kernel.g.aAf().azk();
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiv().aEp(paramAnonymousObject.toString());
        NearbySayHiListUI.b(NearbySayHiListUI.this).onNotifyChange(null, null);
        AppMethodBeat.o(89902);
      }
    });
    this.kde.setAdapter(this.AAr);
    Object localObject = new com.tencent.mm.ui.tools.l(this);
    this.kde.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(89903);
        if (paramAnonymousInt < NearbySayHiListUI.d(NearbySayHiListUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
          AppMethodBeat.o(89903);
          return true;
        }
        this.pln.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, NearbySayHiListUI.this, NearbySayHiListUI.g(NearbySayHiListUI.this));
        AppMethodBeat.o(89903);
        return true;
      }
    });
    this.kde.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(89904);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousAdapterView);
        ((b)localObject).bm(paramAnonymousView);
        ((b)localObject).pH(paramAnonymousInt);
        ((b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
        int i = paramAnonymousInt;
        if (NearbySayHiListUI.d(NearbySayHiListUI.this).getHeaderViewsCount() > 0) {
          i = paramAnonymousInt - NearbySayHiListUI.d(NearbySayHiListUI.this).getHeaderViewsCount();
        }
        bx localbx = (bx)NearbySayHiListUI.b(NearbySayHiListUI.this).getItem(i);
        if ((localbx == null) || (localbx.field_content == null))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(89904);
          return;
        }
        paramAnonymousView = ca.d.bkD(localbx.field_content);
        paramAnonymousAdapterView = new Intent();
        if (com.tencent.mm.bp.a.glC())
        {
          paramAnonymousAdapterView.putExtra("Chat_User", localbx.field_sayhiencryptuser);
          paramAnonymousAdapterView.putExtra("lbs_mode", true);
          paramAnonymousAdapterView.putExtra("add_scene", 18);
          com.tencent.mm.plugin.nearby.a.jRt.d(paramAnonymousAdapterView, NearbySayHiListUI.this);
          paramAnonymousAdapterView = new j();
          paramAnonymousAdapterView.dCb.scene = paramAnonymousView.scene;
          EventCenter.instance.publish(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(89904);
          return;
        }
        localObject = new Intent();
        if (Util.isNullOrNil(paramAnonymousView.dkU))
        {
          paramAnonymousAdapterView = localbx.field_sayhiuser;
          label269:
          ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
          ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.fMb);
          ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.nickname);
          ((Intent)localObject).putExtra("Contact_QuanPin", paramAnonymousView.kfR);
          ((Intent)localObject).putExtra("Contact_PyInitial", paramAnonymousView.kfQ);
          ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.fuA);
          ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.signature);
          ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject).putExtra("Contact_City", paramAnonymousView.getCity());
          ((Intent)localObject).putExtra("Contact_Province", paramAnonymousView.getProvince());
          if (!Util.isNullOrNil(localbx.field_sayhicontent)) {
            break label648;
          }
        }
        label648:
        for (paramAnonymousAdapterView = NearbySayHiListUI.this.getString(2131757381);; paramAnonymousAdapterView = localbx.field_sayhicontent)
        {
          ((Intent)localObject).putExtra("Contact_Content", paramAnonymousAdapterView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_Uin", paramAnonymousView.Bge);
          ((Intent)localObject).putExtra("Contact_QQNick", paramAnonymousView.kfS);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramAnonymousView.OqK);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Verify_ticket", paramAnonymousView.wZz);
          ((Intent)localObject).putExtra("Contact_Source_FMessage", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_ShowFMessageList", true);
          paramAnonymousAdapterView = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramAnonymousView.dkU);
          if ((paramAnonymousAdapterView != null) && ((int)paramAnonymousAdapterView.gMZ >= 0) && (!com.tencent.mm.contact.c.oR(paramAnonymousAdapterView.field_type)))
          {
            paramAnonymousInt = paramAnonymousView.dKy;
            if ((paramAnonymousInt == 0) || (paramAnonymousInt == 2) || (paramAnonymousInt == 5)) {
              ((Intent)localObject).putExtra("User_Verify", true);
            }
            ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
            ((Intent)localObject).putExtra("Sns_from_Scene", 18);
          }
          com.tencent.mm.plugin.nearby.a.jRt.c((Intent)localObject, NearbySayHiListUI.this);
          break;
          paramAnonymousAdapterView = paramAnonymousView.dkU;
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
    setToTop(new NearbySayHiListUI.2(this));
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
    this.maxCount = Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("ThresholdToCleanLocation"));
    this.AAu = getIntent().getBooleanExtra("show_clear_header", false);
    com.tencent.mm.kernel.g.aAf().azk();
    this.AAq = ((by)((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiv());
    setMMTitle(2131764876);
    this.AAt = this.AAq.ctM();
    this.AAs = this.AAq.getCount();
    int i;
    if (com.tencent.mm.bp.a.glC()) {
      i = this.AAs;
    }
    for (;;)
    {
      this.limit = i;
      paramBundle = this.AAq;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      AppMethodBeat.o(89913);
      return;
      if (this.AAt == 0) {
        i = 8;
      } else {
        i = this.AAt;
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(89919);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (bx)this.AAr.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      Log.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(89919);
      return;
    }
    paramContextMenu.add(0, 0, 0, 2131755778);
    this.AAv = paramContextMenuInfo.field_svrid;
    AppMethodBeat.o(89919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(89915);
    this.AAr.ebf();
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
    com.tencent.mm.kernel.g.azz().b(148, this);
    super.onPause();
    AppMethodBeat.o(89916);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89914);
    super.onResume();
    if (this.AAs != this.AAq.getCount())
    {
      this.AAs = this.AAq.getCount();
      if (this.AAs == 0)
      {
        TextView localTextView = (TextView)findViewById(2131300096);
        localTextView.setText(2131764879);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.AAr.anp();
    }
    this.AAr.notifyDataSetChanged();
    com.tencent.mm.kernel.g.azz().a(148, this);
    AppMethodBeat.o(89914);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(89921);
    Log.i("MicroMsg.SayHiListUI", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (((com.tencent.mm.plugin.nearby.a.c)paramq).Vj() == 2)
      {
        com.tencent.mm.ui.base.h.d(getContext(), getString(2131763439), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(89895);
            NearbySayHiListUI.this.setResult(-1);
            NearbySayHiListUI.this.finish();
            AppMethodBeat.o(89895);
          }
        });
        this.AzP = null;
        AppMethodBeat.o(89921);
      }
    }
    else {
      Log.w("MicroMsg.SayHiListUI", "[cpan] clear location failed.");
    }
    AppMethodBeat.o(89921);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends s<bx>
  {
    protected MMSlideDelView.f AAA;
    private by AAq;
    private MMActivity gte;
    int limit;
    protected MMSlideDelView.g pkY;
    protected MMSlideDelView.c pkZ;
    protected MMSlideDelView.d plb;
    
    public a(Context paramContext, by paramby, int paramInt)
    {
      super(new bx());
      AppMethodBeat.i(89907);
      this.limit = -1;
      this.plb = MMSlideDelView.getItemStatusCallBack();
      this.gte = ((MMActivity)paramContext);
      this.limit = paramInt;
      this.AAq = paramby;
      AppMethodBeat.o(89907);
    }
    
    public final void a(MMSlideDelView.f paramf)
    {
      this.AAA = paramf;
    }
    
    public final void anp()
    {
      AppMethodBeat.i(89909);
      if (com.tencent.mm.bp.a.glC()) {
        setCursor(this.AAq.akl(this.limit));
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        AppMethodBeat.o(89909);
        return;
        setCursor(this.AAq.Pf(this.limit));
      }
    }
    
    public final void anq()
    {
      AppMethodBeat.i(89908);
      anp();
      AppMethodBeat.o(89908);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(89910);
      bx localbx = (bx)getItem(paramInt);
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = (MMSlideDelView)View.inflate(this.gte, 2131493215, null);
        localObject = View.inflate(this.gte, 2131496130, null);
        paramViewGroup.gyr = ((ImageView)((View)localObject).findViewById(2131299160));
        paramViewGroup.kcS = ((TextView)((View)localObject).findViewById(2131299677));
        paramViewGroup.znW = ((TextView)((View)localObject).findViewById(2131307224));
        paramViewGroup.plg = paramView.findViewById(2131307923);
        paramViewGroup.plh = ((TextView)paramView.findViewById(2131307925));
        paramView.setView((View)localObject);
        paramView.setPerformItemClickListener(this.pkY);
        paramView.setGetViewPositionCallback(this.pkZ);
        paramView.setItemStatusCallBack(this.plb);
        paramView.setEnable(false);
        paramView.setTag(paramViewGroup);
        if (localbx.field_flag == 0) {
          break label289;
        }
      }
      label289:
      for (Object localObject = ca.d.bkD(localbx.field_content).nickname;; localObject = localbx.field_talker)
      {
        paramViewGroup.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, (CharSequence)localObject, paramViewGroup.kcS.getTextSize()));
        paramViewGroup.znW.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.gte, localbx.field_sayhicontent, paramViewGroup.znW.getTextSize()));
        paramViewGroup.plg.setTag(Long.valueOf(localbx.field_svrid));
        paramViewGroup.plg.setOnClickListener(new NearbySayHiListUI.a.1(this));
        a.b.c(paramViewGroup.gyr, localbx.field_sayhiuser);
        AppMethodBeat.o(89910);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
      }
    }
    
    public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
    {
      this.pkZ = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.pkY = paramg;
    }
    
    final class a
    {
      ImageView gyr;
      TextView kcS;
      View plg;
      TextView plh;
      TextView znW;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI
 * JD-Core Version:    0.7.0.1
 */