package com.tencent.mm.plugin.nearby.ui;

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
import com.tencent.d.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.nearby.b.c;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.plugin.nearby.model.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cc.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.x;

public class NearbySayHiListUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private c MoS;
  private ca Mpt;
  private a Mpu;
  private int Mpv;
  private int Mpw;
  private boolean Mpx;
  private long Mpy;
  private int limit;
  private int lyL;
  private ListView pRl;
  private View pUv;
  private w tipDialog;
  private u.i vzr;
  
  public NearbySayHiListUI()
  {
    AppMethodBeat.i(89912);
    this.Mpt = null;
    this.limit = 0;
    this.Mpv = 0;
    this.Mpw = 0;
    this.lyL = 0;
    this.tipDialog = null;
    this.vzr = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(89894);
        com.tencent.mm.kernel.h.baC().aZJ();
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaW().aLy(String.valueOf(NearbySayHiListUI.j(NearbySayHiListUI.this)));
        NearbySayHiListUI.c(NearbySayHiListUI.this).onNotifyChange(null, null);
        if (NearbySayHiListUI.d(NearbySayHiListUI.this) > 0) {
          NearbySayHiListUI.k(NearbySayHiListUI.this);
        }
        NearbySayHiListUI.l(NearbySayHiListUI.this);
        AppMethodBeat.o(89894);
      }
    };
    AppMethodBeat.o(89912);
  }
  
  public int getLayoutId()
  {
    return b.d.lbs_say_hi_list;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89918);
    this.pRl = ((ListView)findViewById(b.c.say_hi_lv));
    if (!com.tencent.mm.bp.a.iGn())
    {
      localObject = getLayoutInflater().inflate(b.d.say_hi_list_footer, null);
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89892);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          NearbySayHiListUI.a(NearbySayHiListUI.this);
          Log.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.b(NearbySayHiListUI.this));
          paramAnonymousView = NearbySayHiListUI.c(NearbySayHiListUI.this);
          int i = NearbySayHiListUI.b(NearbySayHiListUI.this);
          paramAnonymousView.fSd();
          paramAnonymousView.limit = i;
          paramAnonymousView.aNy();
          if (NearbySayHiListUI.d(NearbySayHiListUI.this) <= NearbySayHiListUI.b(NearbySayHiListUI.this))
          {
            NearbySayHiListUI.e(NearbySayHiListUI.this).removeFooterView(this.Mpz);
            Log.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.b(NearbySayHiListUI.this));
          }
          ((e)com.tencent.mm.kernel.h.az(e.class)).nearbyReport(7L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(89892);
        }
      });
      if ((this.Mpv > 0) && (this.limit < this.Mpv)) {
        this.pRl.addFooterView((View)localObject);
      }
    }
    addTextOptionMenu(0, getString(b.g.app_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(89897);
        ((e)com.tencent.mm.kernel.h.az(e.class)).nearbyReport(8L);
        com.tencent.mm.ui.base.k.a(NearbySayHiListUI.this.getContext(), true, NearbySayHiListUI.this.getResources().getString(b.g.say_hi_clean_all_title), "", NearbySayHiListUI.this.getResources().getString(b.g.say_hi_clean_all_btn), NearbySayHiListUI.this.getString(b.g.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(89896);
            NearbySayHiListUI.f(NearbySayHiListUI.this).cju();
            NearbySayHiListUI.c(NearbySayHiListUI.this).aNy();
            paramAnonymous2DialogInterface = (TextView)NearbySayHiListUI.this.findViewById(b.c.empty_msg_tip_tv);
            paramAnonymous2DialogInterface.setText(b.g.say_hi_non);
            paramAnonymous2DialogInterface.setVisibility(0);
            NearbySayHiListUI.this.enableOptionMenu(false);
            ((e)com.tencent.mm.kernel.h.az(e.class)).nearbyReport(9L);
            AppMethodBeat.o(89896);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(262794);
            ((e)com.tencent.mm.kernel.h.az(e.class)).nearbyReport(10L);
            AppMethodBeat.o(262794);
          }
        });
        AppMethodBeat.o(89897);
        return true;
      }
    });
    if (this.Mpv == 0)
    {
      localObject = (TextView)findViewById(b.c.empty_msg_tip_tv);
      ((TextView)localObject).setText(b.g.say_hi_non);
      ((TextView)localObject).setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.Mpx) && (this.lyL != 0) && (this.Mpw >= this.lyL) && (Util.isOverseasUser(this)))
    {
      this.pUv = new CleanLocationHeaderView(this);
      this.pUv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89899);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          NearbySayHiListUI.a(NearbySayHiListUI.this, new c(2, 0.0F, 0.0F, 0, 0, "", ""));
          com.tencent.mm.kernel.h.aZW().a(NearbySayHiListUI.g(NearbySayHiListUI.this), 0);
          paramAnonymousView = NearbySayHiListUI.this;
          localObject = NearbySayHiListUI.this.getContext();
          NearbySayHiListUI.this.getString(b.g.app_tip);
          NearbySayHiListUI.a(paramAnonymousView, com.tencent.mm.ui.base.k.a((Context)localObject, NearbySayHiListUI.this.getString(b.g.Mon), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(89898);
              com.tencent.mm.kernel.h.aZW().a(NearbySayHiListUI.g(NearbySayHiListUI.this));
              AppMethodBeat.o(89898);
            }
          }));
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(11429, "0");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(89899);
        }
      });
      this.pRl.addHeaderView(this.pUv);
    }
    this.Mpu = new a(this, this.Mpt, this.limit);
    this.Mpu.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int eB(View paramAnonymousView)
      {
        AppMethodBeat.i(89900);
        int i = NearbySayHiListUI.e(NearbySayHiListUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(89900);
        return i;
      }
    });
    this.Mpu.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(89901);
        NearbySayHiListUI.e(NearbySayHiListUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(89901);
      }
    });
    this.Mpu.a(new MMSlideDelView.f()
    {
      public final void es(Object paramAnonymousObject)
      {
        AppMethodBeat.i(89902);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.SayHiListUI", "onItemDel object null");
          AppMethodBeat.o(89902);
          return;
        }
        com.tencent.mm.kernel.h.baC().aZJ();
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaW().aLy(paramAnonymousObject.toString());
        NearbySayHiListUI.c(NearbySayHiListUI.this).onNotifyChange(null, null);
        AppMethodBeat.o(89902);
      }
    });
    this.pRl.setAdapter(this.Mpu);
    Object localObject = new l(this);
    this.pRl.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(89903);
        if (paramAnonymousInt < NearbySayHiListUI.e(NearbySayHiListUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
          AppMethodBeat.o(89903);
          return true;
        }
        this.vzu.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, NearbySayHiListUI.this, NearbySayHiListUI.h(NearbySayHiListUI.this));
        AppMethodBeat.o(89903);
        return true;
      }
    });
    this.pRl.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(89904);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if (NearbySayHiListUI.e(NearbySayHiListUI.this).getHeaderViewsCount() > 0) {}
        for (int i = paramAnonymousInt - NearbySayHiListUI.e(NearbySayHiListUI.this).getHeaderViewsCount();; i = paramAnonymousInt)
        {
          bz localbz = (bz)NearbySayHiListUI.c(NearbySayHiListUI.this).getItem(i);
          if ((localbz == null) || (localbz.field_content == null))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(89904);
            return;
          }
          paramAnonymousView = cc.f.byv(localbz.field_content);
          paramAnonymousAdapterView = new Intent();
          if (com.tencent.mm.bp.a.iGn())
          {
            paramAnonymousAdapterView.putExtra("Chat_User", localbz.field_sayhiencryptuser);
            paramAnonymousAdapterView.putExtra("lbs_mode", true);
            paramAnonymousAdapterView.putExtra("add_scene", 18);
            com.tencent.mm.plugin.nearby.a.pFn.d(paramAnonymousAdapterView, NearbySayHiListUI.this);
            paramAnonymousAdapterView = new com.tencent.mm.autogen.a.k();
            paramAnonymousAdapterView.hyW.scene = paramAnonymousView.scene;
            paramAnonymousAdapterView.publish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(89904);
            return;
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 5);
          if (NearbySayHiListUI.i(NearbySayHiListUI.this))
          {
            i = 503;
            label271:
            ((Intent)localObject).putExtra("CONTACT_INFO_UI_SUB_SOURCE", i);
            if (!Util.isNullOrNil(paramAnonymousView.hgk)) {
              break label707;
            }
            paramAnonymousAdapterView = localbz.field_sayhiuser;
            label297:
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
            ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.kDc);
            ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.nickname);
            ((Intent)localObject).putExtra("Contact_QuanPin", paramAnonymousView.pTY);
            ((Intent)localObject).putExtra("Contact_PyInitial", paramAnonymousView.pTX);
            ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.sex);
            ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.signature);
            ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.scene);
            ((Intent)localObject).putExtra("Contact_FMessageCard", true);
            ((Intent)localObject).putExtra("Contact_City", paramAnonymousView.getCity());
            ((Intent)localObject).putExtra("Contact_Province", paramAnonymousView.getProvince());
            if (!Util.isNullOrNil(localbz.field_sayhicontent)) {
              break label715;
            }
          }
          label707:
          label715:
          for (paramAnonymousAdapterView = NearbySayHiListUI.this.getString(b.g.chatting_from_verify_lbs_tip);; paramAnonymousAdapterView = localbz.field_sayhicontent)
          {
            ((Intent)localObject).putExtra("Contact_Content", paramAnonymousAdapterView);
            ((Intent)localObject).putExtra("Contact_verify_Scene", paramAnonymousView.scene);
            ((Intent)localObject).putExtra("Contact_Uin", paramAnonymousView.MXS);
            ((Intent)localObject).putExtra("Contact_QQNick", paramAnonymousView.pTZ);
            ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramAnonymousView.adkz);
            ((Intent)localObject).putExtra("User_From_Fmessage", true);
            ((Intent)localObject).putExtra("Contact_from_msgType", 37);
            ((Intent)localObject).putExtra("Verify_ticket", paramAnonymousView.pPi);
            ((Intent)localObject).putExtra("Contact_Source_FMessage", paramAnonymousView.scene);
            ((Intent)localObject).putExtra("Contact_ShowFMessageList", true);
            paramAnonymousAdapterView = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramAnonymousView.hgk);
            if ((paramAnonymousAdapterView != null) && ((int)paramAnonymousAdapterView.maN >= 0) && (!d.rs(paramAnonymousAdapterView.field_type)))
            {
              i = paramAnonymousView.hId;
              if ((i == 0) || (i == 2) || (i == 5)) {
                ((Intent)localObject).putExtra("User_Verify", true);
              }
              ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
              ((Intent)localObject).putExtra("Sns_from_Scene", 18);
            }
            com.tencent.mm.plugin.nearby.a.pFn.c((Intent)localObject, NearbySayHiListUI.this);
            ((e)com.tencent.mm.kernel.h.az(e.class)).nearbySayHiReport(6L, paramAnonymousInt, paramAnonymousView.sex);
            break;
            i = 502;
            break label271;
            paramAnonymousAdapterView = paramAnonymousView.hgk;
            break label297;
          }
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = NearbySayHiListUI.e(NearbySayHiListUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
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
    this.lyL = Util.safeParseInt(i.aRC().getValue("ThresholdToCleanLocation"));
    this.Mpx = getIntent().getBooleanExtra("show_clear_header", false);
    com.tencent.mm.kernel.h.baC().aZJ();
    this.Mpt = ((ca)((n)com.tencent.mm.kernel.h.ax(n.class)).gaW());
    setMMTitle(b.g.say_hi_list_lbs_title);
    this.Mpw = this.Mpt.dkF();
    this.Mpv = this.Mpt.getCount();
    int i;
    if (com.tencent.mm.bp.a.iGn()) {
      i = this.Mpv;
    }
    for (;;)
    {
      this.limit = i;
      paramBundle = this.Mpt;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      AppMethodBeat.o(89913);
      return;
      if (this.Mpw == 0) {
        i = 8;
      } else {
        i = this.Mpw;
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(89919);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (bz)this.Mpu.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      Log.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(89919);
      return;
    }
    paramContextMenu.add(0, 0, 0, b.g.app_delete);
    this.Mpy = paramContextMenuInfo.field_svrid;
    AppMethodBeat.o(89919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(89915);
    this.Mpu.fSd();
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
    com.tencent.mm.kernel.h.aZW().b(148, this);
    super.onPause();
    AppMethodBeat.o(89916);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89914);
    super.onResume();
    if (this.Mpv != this.Mpt.getCount())
    {
      this.Mpv = this.Mpt.getCount();
      if (this.Mpv == 0)
      {
        TextView localTextView = (TextView)findViewById(b.c.empty_msg_tip_tv);
        localTextView.setText(b.g.say_hi_non);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.Mpu.aNy();
    }
    this.Mpu.notifyDataSetChanged();
    com.tencent.mm.kernel.h.aZW().a(148, this);
    AppMethodBeat.o(89914);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
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
      if (((c)paramp).bIO() == 2)
      {
        com.tencent.mm.ui.base.k.d(getContext(), getString(b.g.EHm), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(89895);
            NearbySayHiListUI.this.setResult(-1);
            NearbySayHiListUI.this.finish();
            AppMethodBeat.o(89895);
          }
        });
        this.MoS = null;
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
    extends x<bz>
  {
    protected MMSlideDelView.f MpD;
    private ca Mpt;
    int limit;
    private MMActivity lzt;
    protected MMSlideDelView.g vzf;
    protected MMSlideDelView.c vzg;
    protected MMSlideDelView.d vzi;
    
    public a(Context paramContext, ca paramca, int paramInt)
    {
      super(new bz());
      AppMethodBeat.i(89907);
      this.limit = -1;
      this.vzi = MMSlideDelView.getItemStatusCallBack();
      this.lzt = ((MMActivity)paramContext);
      this.limit = paramInt;
      this.Mpt = paramca;
      AppMethodBeat.o(89907);
    }
    
    public final void a(MMSlideDelView.f paramf)
    {
      this.MpD = paramf;
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(89909);
      if (com.tencent.mm.bp.a.iGn()) {
        w(this.Mpt.ayY(this.limit));
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        AppMethodBeat.o(89909);
        return;
        w(this.Mpt.Zj(this.limit));
      }
    }
    
    public final void aNz()
    {
      AppMethodBeat.i(89908);
      aNy();
      AppMethodBeat.o(89908);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(89910);
      bz localbz = (bz)getItem(paramInt);
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = (MMSlideDelView)View.inflate(this.lzt, b.d.base_slide_del_view, null);
        localObject = View.inflate(this.lzt, b.d.say_hi_item, null);
        paramViewGroup.lKK = ((ImageView)((View)localObject).findViewById(b.c.contactitem_avatar_iv));
        paramViewGroup.pQZ = ((TextView)((View)localObject).findViewById(b.c.display_name));
        paramViewGroup.KNR = ((TextView)((View)localObject).findViewById(b.c.sayhi_content));
        paramViewGroup.vzn = paramView.findViewById(b.c.slide_del_del_view);
        paramViewGroup.vzo = ((TextView)paramView.findViewById(b.c.slide_del_view_del_word));
        paramView.setView((View)localObject);
        paramView.setPerformItemClickListener(this.vzf);
        paramView.setGetViewPositionCallback(this.vzg);
        paramView.setItemStatusCallBack(this.vzi);
        paramView.setEnable(false);
        paramView.setTag(paramViewGroup);
        if (localbz.field_flag == 0) {
          break label296;
        }
      }
      label296:
      for (Object localObject = cc.f.byv(localbz.field_content).nickname;; localObject = localbz.field_talker)
      {
        paramViewGroup.pQZ.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.lzt, (CharSequence)localObject, paramViewGroup.pQZ.getTextSize()));
        paramViewGroup.KNR.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.lzt, localbz.field_sayhicontent, paramViewGroup.KNR.getTextSize()));
        paramViewGroup.vzn.setTag(Long.valueOf(localbz.field_svrid));
        paramViewGroup.vzn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(89906);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            Log.v("MicroMsg.SayHiAdapter", "on delView clicked");
            NearbySayHiListUI.a.this.vzi.fSn();
            if (NearbySayHiListUI.a.this.MpD != null) {
              NearbySayHiListUI.a.this.MpD.es(paramAnonymousView.getTag());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(89906);
          }
        });
        a.b.g(paramViewGroup.lKK, localbz.field_sayhiuser);
        AppMethodBeat.o(89910);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
      }
    }
    
    public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
    {
      this.vzg = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.vzf = paramg;
    }
    
    final class a
    {
      TextView KNR;
      ImageView lKK;
      TextView pQZ;
      View vzn;
      TextView vzo;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI
 * JD-Core Version:    0.7.0.1
 */