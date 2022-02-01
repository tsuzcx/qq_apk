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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.a.j;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.plugin.nearby.b.c;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
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
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.v;

public class NearbySayHiListUI
  extends MMActivity
  implements i
{
  private c GsS;
  private by Gtt;
  private a Gtu;
  private int Gtv;
  private int Gtw;
  private boolean Gtx;
  private long Gty;
  private int iWH;
  private int limit;
  private ListView mUE;
  private View mXN;
  private q.g snt;
  private s tipDialog;
  
  public NearbySayHiListUI()
  {
    AppMethodBeat.i(89912);
    this.Gtt = null;
    this.limit = 0;
    this.Gtv = 0;
    this.Gtw = 0;
    this.iWH = 0;
    this.tipDialog = null;
    this.snt = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(89894);
        com.tencent.mm.kernel.h.aHE().aGH();
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSb().aOz(String.valueOf(NearbySayHiListUI.h(NearbySayHiListUI.this)));
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
    return b.d.lbs_say_hi_list;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89918);
    this.mUE = ((ListView)findViewById(b.c.say_hi_lv));
    if (!com.tencent.mm.bw.a.hft())
    {
      localObject = getLayoutInflater().inflate(b.d.say_hi_list_footer, null);
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89892);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          NearbySayHiListUI.a(NearbySayHiListUI.this, NearbySayHiListUI.a(NearbySayHiListUI.this) + 8);
          Log.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.a(NearbySayHiListUI.this));
          paramAnonymousView = NearbySayHiListUI.b(NearbySayHiListUI.this);
          int i = NearbySayHiListUI.a(NearbySayHiListUI.this);
          paramAnonymousView.eKd();
          paramAnonymousView.limit = i;
          paramAnonymousView.atr();
          if (NearbySayHiListUI.c(NearbySayHiListUI.this) <= NearbySayHiListUI.a(NearbySayHiListUI.this))
          {
            NearbySayHiListUI.d(NearbySayHiListUI.this).removeFooterView(this.Gtz);
            Log.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.a(NearbySayHiListUI.this));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(89892);
        }
      });
      if ((this.Gtv > 0) && (this.limit < this.Gtv)) {
        this.mUE.addFooterView((View)localObject);
      }
    }
    addTextOptionMenu(0, getString(b.g.app_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(89897);
        com.tencent.mm.ui.base.h.a(NearbySayHiListUI.this.getContext(), true, NearbySayHiListUI.this.getResources().getString(b.g.say_hi_clean_all_title), "", NearbySayHiListUI.this.getResources().getString(b.g.say_hi_clean_all_btn), NearbySayHiListUI.this.getString(b.g.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(89896);
            NearbySayHiListUI.e(NearbySayHiListUI.this).bJQ();
            NearbySayHiListUI.b(NearbySayHiListUI.this).atr();
            paramAnonymous2DialogInterface = (TextView)NearbySayHiListUI.this.findViewById(b.c.empty_msg_tip_tv);
            paramAnonymous2DialogInterface.setText(b.g.say_hi_non);
            paramAnonymous2DialogInterface.setVisibility(0);
            NearbySayHiListUI.this.enableOptionMenu(false);
            AppMethodBeat.o(89896);
          }
        }, null);
        AppMethodBeat.o(89897);
        return true;
      }
    });
    if (this.Gtv == 0)
    {
      localObject = (TextView)findViewById(b.c.empty_msg_tip_tv);
      ((TextView)localObject).setText(b.g.say_hi_non);
      ((TextView)localObject).setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.Gtx) && (this.iWH != 0) && (this.Gtw >= this.iWH) && (Util.isOverseasUser(this)))
    {
      this.mXN = new CleanLocationHeaderView(this);
      this.mXN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(89899);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          NearbySayHiListUI.a(NearbySayHiListUI.this, new c(2, 0.0F, 0.0F, 0, 0, "", ""));
          com.tencent.mm.kernel.h.aGY().a(NearbySayHiListUI.f(NearbySayHiListUI.this), 0);
          paramAnonymousView = NearbySayHiListUI.this;
          localObject = NearbySayHiListUI.this.getContext();
          NearbySayHiListUI.this.getString(b.g.app_tip);
          NearbySayHiListUI.a(paramAnonymousView, com.tencent.mm.ui.base.h.a((Context)localObject, NearbySayHiListUI.this.getString(b.g.nearby_friend_clearing_location), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(89898);
              com.tencent.mm.kernel.h.aGY().a(NearbySayHiListUI.f(NearbySayHiListUI.this));
              AppMethodBeat.o(89898);
            }
          }));
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(11429, "0");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(89899);
        }
      });
      this.mUE.addHeaderView(this.mXN);
    }
    this.Gtu = new a(this, this.Gtt, this.limit);
    this.Gtu.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(89900);
        int i = NearbySayHiListUI.d(NearbySayHiListUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(89900);
        return i;
      }
    });
    this.Gtu.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(89901);
        NearbySayHiListUI.d(NearbySayHiListUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(89901);
      }
    });
    this.Gtu.a(new MMSlideDelView.f()
    {
      public final void cW(Object paramAnonymousObject)
      {
        AppMethodBeat.i(89902);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.SayHiListUI", "onItemDel object null");
          AppMethodBeat.o(89902);
          return;
        }
        com.tencent.mm.kernel.h.aHE().aGH();
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSb().aOz(paramAnonymousObject.toString());
        NearbySayHiListUI.b(NearbySayHiListUI.this).onNotifyChange(null, null);
        AppMethodBeat.o(89902);
      }
    });
    this.mUE.setAdapter(this.Gtu);
    Object localObject = new com.tencent.mm.ui.tools.m(this);
    this.mUE.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
        this.snw.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, NearbySayHiListUI.this, NearbySayHiListUI.g(NearbySayHiListUI.this));
        AppMethodBeat.o(89903);
        return true;
      }
    });
    this.mUE.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(89904);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
        paramAnonymousView = ca.d.bxc(localbx.field_content);
        paramAnonymousAdapterView = new Intent();
        if (com.tencent.mm.bw.a.hft())
        {
          paramAnonymousAdapterView.putExtra("Chat_User", localbx.field_sayhiencryptuser);
          paramAnonymousAdapterView.putExtra("lbs_mode", true);
          paramAnonymousAdapterView.putExtra("add_scene", 18);
          com.tencent.mm.plugin.nearby.a.mIG.d(paramAnonymousAdapterView, NearbySayHiListUI.this);
          paramAnonymousAdapterView = new j();
          paramAnonymousAdapterView.fuE.scene = paramAnonymousView.scene;
          EventCenter.instance.publish(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(89904);
          return;
        }
        localObject = new Intent();
        if (Util.isNullOrNil(paramAnonymousView.fcC))
        {
          paramAnonymousAdapterView = localbx.field_sayhiuser;
          label269:
          ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
          ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.idS);
          ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.nickname);
          ((Intent)localObject).putExtra("Contact_QuanPin", paramAnonymousView.mXq);
          ((Intent)localObject).putExtra("Contact_PyInitial", paramAnonymousView.mXp);
          ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.sex);
          ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.signature);
          ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject).putExtra("Contact_City", paramAnonymousView.getCity());
          ((Intent)localObject).putExtra("Contact_Province", paramAnonymousView.getProvince());
          if (!Util.isNullOrNil(localbx.field_sayhicontent)) {
            break label652;
          }
        }
        label652:
        for (paramAnonymousAdapterView = NearbySayHiListUI.this.getString(b.g.chatting_from_verify_lbs_tip);; paramAnonymousAdapterView = localbx.field_sayhicontent)
        {
          ((Intent)localObject).putExtra("Contact_Content", paramAnonymousAdapterView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_Uin", paramAnonymousView.GZN);
          ((Intent)localObject).putExtra("Contact_QQNick", paramAnonymousView.mXr);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramAnonymousView.VGG);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Verify_ticket", paramAnonymousView.BLy);
          ((Intent)localObject).putExtra("Contact_Source_FMessage", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_ShowFMessageList", true);
          paramAnonymousAdapterView = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramAnonymousView.fcC);
          if ((paramAnonymousAdapterView != null) && ((int)paramAnonymousAdapterView.jxt >= 0) && (!d.rk(paramAnonymousAdapterView.field_type)))
          {
            paramAnonymousInt = paramAnonymousView.fDn;
            if ((paramAnonymousInt == 0) || (paramAnonymousInt == 2) || (paramAnonymousInt == 5)) {
              ((Intent)localObject).putExtra("User_Verify", true);
            }
            ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
            ((Intent)localObject).putExtra("Sns_from_Scene", 18);
          }
          com.tencent.mm.plugin.nearby.a.mIG.c((Intent)localObject, NearbySayHiListUI.this);
          break;
          paramAnonymousAdapterView = paramAnonymousView.fcC;
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = NearbySayHiListUI.d(NearbySayHiListUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$10", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sf(0));
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
    this.iWH = Util.safeParseInt(com.tencent.mm.n.h.axc().getValue("ThresholdToCleanLocation"));
    this.Gtx = getIntent().getBooleanExtra("show_clear_header", false);
    com.tencent.mm.kernel.h.aHE().aGH();
    this.Gtt = ((by)((n)com.tencent.mm.kernel.h.ae(n.class)).eSb());
    setMMTitle(b.g.say_hi_list_lbs_title);
    this.Gtw = this.Gtt.cHo();
    this.Gtv = this.Gtt.getCount();
    int i;
    if (com.tencent.mm.bw.a.hft()) {
      i = this.Gtv;
    }
    for (;;)
    {
      this.limit = i;
      paramBundle = this.Gtt;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      AppMethodBeat.o(89913);
      return;
      if (this.Gtw == 0) {
        i = 8;
      } else {
        i = this.Gtw;
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(89919);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (bx)this.Gtu.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      Log.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(89919);
      return;
    }
    paramContextMenu.add(0, 0, 0, b.g.app_delete);
    this.Gty = paramContextMenuInfo.field_svrid;
    AppMethodBeat.o(89919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(89915);
    this.Gtu.eKd();
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
    com.tencent.mm.kernel.h.aGY().b(148, this);
    super.onPause();
    AppMethodBeat.o(89916);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89914);
    super.onResume();
    if (this.Gtv != this.Gtt.getCount())
    {
      this.Gtv = this.Gtt.getCount();
      if (this.Gtv == 0)
      {
        TextView localTextView = (TextView)findViewById(b.c.empty_msg_tip_tv);
        localTextView.setText(b.g.say_hi_non);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.Gtu.atr();
    }
    this.Gtu.notifyDataSetChanged();
    com.tencent.mm.kernel.h.aGY().a(148, this);
    AppMethodBeat.o(89914);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
      if (((c)paramq).ZB() == 2)
      {
        com.tencent.mm.ui.base.h.d(getContext(), getString(b.g.nearby_friend_clear_location_ok), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(89895);
            NearbySayHiListUI.this.setResult(-1);
            NearbySayHiListUI.this.finish();
            AppMethodBeat.o(89895);
          }
        });
        this.GsS = null;
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
    extends v<bx>
  {
    protected MMSlideDelView.f GtD;
    private by Gtt;
    private MMActivity iXq;
    int limit;
    protected MMSlideDelView.g snh;
    protected MMSlideDelView.c sni;
    protected MMSlideDelView.d snk;
    
    public a(Context paramContext, by paramby, int paramInt)
    {
      super(new bx());
      AppMethodBeat.i(89907);
      this.limit = -1;
      this.snk = MMSlideDelView.getItemStatusCallBack();
      this.iXq = ((MMActivity)paramContext);
      this.limit = paramInt;
      this.Gtt = paramby;
      AppMethodBeat.o(89907);
    }
    
    public final void a(MMSlideDelView.f paramf)
    {
      this.GtD = paramf;
    }
    
    public final void atr()
    {
      AppMethodBeat.i(89909);
      if (com.tencent.mm.bw.a.hft()) {
        v(this.Gtt.asI(this.limit));
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        AppMethodBeat.o(89909);
        return;
        v(this.Gtt.Vo(this.limit));
      }
    }
    
    public final void ats()
    {
      AppMethodBeat.i(89908);
      atr();
      AppMethodBeat.o(89908);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(89910);
      bx localbx = (bx)getItem(paramInt);
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = (MMSlideDelView)View.inflate(this.iXq, b.d.base_slide_del_view, null);
        localObject = View.inflate(this.iXq, b.d.say_hi_item, null);
        paramViewGroup.jiu = ((ImageView)((View)localObject).findViewById(b.c.contactitem_avatar_iv));
        paramViewGroup.mUr = ((TextView)((View)localObject).findViewById(b.c.display_name));
        paramViewGroup.ETn = ((TextView)((View)localObject).findViewById(b.c.sayhi_content));
        paramViewGroup.snp = paramView.findViewById(b.c.slide_del_del_view);
        paramViewGroup.snq = ((TextView)paramView.findViewById(b.c.slide_del_view_del_word));
        paramView.setView((View)localObject);
        paramView.setPerformItemClickListener(this.snh);
        paramView.setGetViewPositionCallback(this.sni);
        paramView.setItemStatusCallBack(this.snk);
        paramView.setEnable(false);
        paramView.setTag(paramViewGroup);
        if (localbx.field_flag == 0) {
          break label296;
        }
      }
      label296:
      for (Object localObject = ca.d.bxc(localbx.field_content).nickname;; localObject = localbx.field_talker)
      {
        paramViewGroup.mUr.setText(l.b(this.iXq, (CharSequence)localObject, paramViewGroup.mUr.getTextSize()));
        paramViewGroup.ETn.setText(l.b(this.iXq, localbx.field_sayhicontent, paramViewGroup.ETn.getTextSize()));
        paramViewGroup.snp.setTag(Long.valueOf(localbx.field_svrid));
        paramViewGroup.snp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(89906);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.v("MicroMsg.SayHiAdapter", "on delView clicked");
            NearbySayHiListUI.a.this.snk.eKn();
            if (NearbySayHiListUI.a.this.GtD != null) {
              NearbySayHiListUI.a.this.GtD.cW(paramAnonymousView.getTag());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(89906);
          }
        });
        a.b.c(paramViewGroup.jiu, localbx.field_sayhiuser);
        AppMethodBeat.o(89910);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
      }
    }
    
    public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
    {
      this.sni = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.snh = paramg;
    }
    
    final class a
    {
      TextView ETn;
      ImageView jiu;
      TextView mUr;
      View snp;
      TextView snq;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI
 * JD-Core Version:    0.7.0.1
 */