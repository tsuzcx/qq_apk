package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.i.1;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.v;

public class ShakeItemListUI
  extends MMActivity
{
  public long Jpc;
  private boolean Jpd;
  private a Jpe;
  private int fwp;
  private int id;
  private com.tencent.mm.ay.a.a lQK;
  private ListView mYU;
  private q.g snt;
  private View tzi;
  
  public ShakeItemListUI()
  {
    AppMethodBeat.i(28409);
    this.Jpc = 0L;
    this.Jpd = false;
    this.lQK = null;
    this.snt = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28398);
        com.tencent.mm.plugin.shake.b.m.fHo().aet(ShakeItemListUI.f(ShakeItemListUI.this));
        AppMethodBeat.o(28398);
      }
    };
    AppMethodBeat.o(28409);
  }
  
  public static int aeB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return R.l.eSx;
    case 100: 
      return R.l.eSA;
    case -1: 
    case 0: 
      return R.l.eSx;
    case -5: 
    case 4: 
      return R.l.eSS;
    case -6: 
    case 5: 
      return R.l.eTf;
    }
    return R.l.eSD;
  }
  
  public int getLayoutId()
  {
    return R.i.ekR;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28411);
    this.lQK = new com.tencent.mm.ay.a.a(this);
    bh.beI();
    final int i = Util.nullAs((Integer)com.tencent.mm.model.c.aHp().b(12290, null), 0);
    this.fwp = getIntent().getIntExtra("_key_show_type_", 0);
    Object localObject = getIntent().getStringExtra("_key_title_");
    if (!Util.isNullOrNil((String)localObject)) {
      setMMTitle((String)localObject);
    }
    this.Jpd = getIntent().getBooleanExtra("_key_show_from_shake_", false);
    addTextOptionMenu(0, getString(R.l.app_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28391);
        com.tencent.mm.ui.base.h.a(ShakeItemListUI.this, true, ShakeItemListUI.this.getString(R.l.say_hi_clean_all_title), "", ShakeItemListUI.this.getString(R.l.app_clear), ShakeItemListUI.this.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28390);
            switch (ShakeItemListUI.a(ShakeItemListUI.this))
            {
            }
            for (;;)
            {
              ShakeItemListUI.b(ShakeItemListUI.this).atr();
              ShakeItemListUI.c(ShakeItemListUI.this).setVisibility(8);
              paramAnonymous2DialogInterface = (TextView)ShakeItemListUI.this.findViewById(R.h.nearby_friend_not_found);
              paramAnonymous2DialogInterface.setText(ShakeItemListUI.aeB(ShakeItemListUI.a(ShakeItemListUI.this)));
              paramAnonymous2DialogInterface.setVisibility(0);
              ShakeItemListUI.this.enableOptionMenu(false);
              AppMethodBeat.o(28390);
              return;
              com.tencent.mm.plugin.shake.b.m.fHo().aeu(0);
              com.tencent.mm.plugin.shake.b.m.fHo().fHd();
              continue;
              com.tencent.mm.plugin.shake.b.m.fHo().aeu(0);
              continue;
              bh.aHJ().postToWorker(new i.1());
              com.tencent.mm.plugin.shake.b.m.fHo().aeu(4);
              continue;
              com.tencent.mm.plugin.shake.b.m.fHo().aeu(7);
              com.tencent.mm.plugin.shake.b.m.fHo().aeu(6);
              com.tencent.mm.plugin.shake.b.m.fHo().aeu(8);
              com.tencent.mm.plugin.shake.b.m.fHo().aeu(9);
              com.tencent.mm.plugin.shake.b.m.fHo().aeu(10);
              com.tencent.mm.plugin.shake.b.m.fHo().aeu(12);
              continue;
              com.tencent.mm.plugin.shake.b.m.fHo().aeu(11);
            }
          }
        }, null);
        AppMethodBeat.o(28391);
        return true;
      }
    });
    this.mYU = ((ListView)findViewById(R.h.nearby_friend_lv));
    this.tzi = getLayoutInflater().inflate(R.i.ekT, null);
    this.tzi.findViewById(R.h.dTV).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28392);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ShakeItemListUI.a(ShakeItemListUI.this, ShakeItemListUI.a(ShakeItemListUI.this) ^ 0xFFFFFFFF);
        ShakeItemListUI.this.setShowType(ShakeItemListUI.a(ShakeItemListUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28392);
      }
    });
    this.mYU.addFooterView(this.tzi);
    if (this.fwp == -1)
    {
      this.tzi.findViewById(R.h.dTV).setVisibility(0);
      this.Jpe = new a(this);
      this.Jpe.setShowType(this.fwp);
      if (this.Jpe.getCount() > 0) {
        break label332;
      }
      this.mYU.setVisibility(8);
      localObject = (TextView)findViewById(R.h.nearby_friend_not_found);
      ((TextView)localObject).setText(aeB(this.fwp));
      ((TextView)localObject).setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(28395);
          ShakeItemListUI.this.hideVKB();
          ShakeItemListUI.this.finish();
          AppMethodBeat.o(28395);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(28396);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = ShakeItemListUI.c(ShakeItemListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28396);
        }
      });
      this.mYU.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(28397);
          if (ShakeItemListUI.b(ShakeItemListUI.this) != null)
          {
            paramAnonymousView = ShakeItemListUI.b(ShakeItemListUI.this);
            if (paramAnonymousView.mVX != null) {
              paramAnonymousView.mVX.B(paramAnonymousMotionEvent);
            }
          }
          AppMethodBeat.o(28397);
          return false;
        }
      });
      AppMethodBeat.o(28411);
      return;
      this.tzi.findViewById(R.h.dTV).setVisibility(8);
      break;
      label332:
      this.mYU.setAdapter(this.Jpe);
      this.mYU.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(28393);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousAdapterView = (com.tencent.mm.plugin.shake.b.d)ShakeItemListUI.b(ShakeItemListUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
          }
          paramAnonymousView = com.tencent.mm.plugin.shake.b.m.fHo();
          int i;
          if (paramAnonymousAdapterView == null)
          {
            Log.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
            i = paramAnonymousAdapterView.field_type;
            if (i != 4) {
              break label288;
            }
            paramAnonymousView = new Intent();
            if (!com.tencent.mm.bb.e.bnH()) {
              break label255;
            }
            com.tencent.mm.bb.a.c(i.f(paramAnonymousAdapterView.field_lvbuffer, 0L));
          }
          for (;;)
          {
            paramAnonymousView.putExtra("key_scene", 3);
            com.tencent.mm.by.c.b(ShakeItemListUI.this, "music", ".ui.MusicMainUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
            paramAnonymousAdapterView.field_insertBatch = 1;
            paramAnonymousAdapterView.cUP = 1024;
            if (-1 == paramAnonymousView.db.update("shakeitem1", paramAnonymousAdapterView.convertTo(), "shakeItemID=? and insertBatch=?", new String[] { paramAnonymousAdapterView.field_shakeItemID, "2" })) {
              break;
            }
            paramAnonymousView.doNotify();
            break;
            label255:
            com.tencent.mm.bb.a.bnv();
            paramAnonymousView.putExtra("key_mode", 1);
            paramAnonymousView.putExtra("KGlobalShakeMusic", true);
            com.tencent.mm.bb.a.d(i.f(paramAnonymousAdapterView.field_lvbuffer, 0L));
          }
          label288:
          if (i == 11)
          {
            if (System.currentTimeMillis() - ShakeItemListUI.this.Jpc > 2000L)
            {
              ShakeItemListUI.this.Jpc = System.currentTimeMillis();
              if ((paramAnonymousAdapterView.field_reserved3 == null) || (paramAnonymousAdapterView.field_reserved3.split(",").length != 3) || (paramAnonymousAdapterView.field_reserved3.split(",")[0] == null) || (paramAnonymousAdapterView.field_reserved3.split(",")[0].equals(""))) {
                break label494;
              }
              paramAnonymousView = paramAnonymousAdapterView.field_reserved3.split(",");
              localObject = new xw();
              ((xw)localObject).fWN.userName = paramAnonymousView[0];
              ((xw)localObject).fWN.fWP = Util.nullAs(paramAnonymousView[1], "");
              ((xw)localObject).fWN.fWQ = Integer.parseInt(paramAnonymousView[2]);
              ((xw)localObject).fWN.scene = 1077;
              EventCenter.instance.publish((IEvent)localObject);
            }
            for (;;)
            {
              if (ShakeItemListUI.d(ShakeItemListUI.this))
              {
                com.tencent.mm.plugin.shake.d.a.h.a(paramAnonymousAdapterView);
                com.tencent.mm.plugin.shake.d.a.h.b(paramAnonymousAdapterView);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(28393);
              return;
              label494:
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.getCity());
              paramAnonymousView.putExtra("scene", 27);
              paramAnonymousView.putExtra("stastic_scene", 5);
              com.tencent.mm.by.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            }
          }
          if (k.aez(i))
          {
            k.a(paramAnonymousAdapterView, ShakeItemListUI.this, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
          }
          paramAnonymousView = paramAnonymousAdapterView.field_username;
          bh.beI();
          localObject = com.tencent.mm.model.c.bbL().RG(paramAnonymousView);
          Log.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramAnonymousView + " display:" + paramAnonymousAdapterView.field_nickname + " position:" + paramAnonymousInt + " contactName" + ((ax)localObject).field_username);
          Log.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.contact.d.rk(((ax)localObject).field_type) + "  contact:" + localObject);
          if (com.tencent.mm.contact.d.rk(((ax)localObject).field_type))
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("Contact_User", paramAnonymousView);
            if (i == paramAnonymousAdapterView.field_sex) {}
            for (paramAnonymousInt = 23;; paramAnonymousInt = 24)
            {
              localIntent.putExtra("Contact_Scene", paramAnonymousInt);
              localIntent.putExtra("Sns_from_Scene", 22);
              if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
              {
                if (((as)localObject).hxX())
                {
                  com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramAnonymousAdapterView.field_username + "," + localIntent.getIntExtra("Contact_Scene", 23));
                  localIntent.putExtra("Contact_Scene", 23);
                }
                com.tencent.mm.plugin.shake.a.mIG.c(localIntent, ShakeItemListUI.this);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(28393);
              return;
            }
          }
          Log.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramAnonymousView + " display:" + paramAnonymousAdapterView.field_nickname + " position:" + paramAnonymousInt + " contactName" + ((ax)localObject).field_username);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.field_username);
          paramAnonymousView.putExtra("Contact_Nick", paramAnonymousAdapterView.field_nickname);
          paramAnonymousView.putExtra("Contact_Distance", paramAnonymousAdapterView.field_distance);
          paramAnonymousView.putExtra("Contact_Signature", paramAnonymousAdapterView.field_signature);
          paramAnonymousView.putExtra("Contact_Province", paramAnonymousAdapterView.getProvince());
          paramAnonymousView.putExtra("Contact_City", paramAnonymousAdapterView.getCity());
          paramAnonymousView.putExtra("Contact_Sex", paramAnonymousAdapterView.field_sex);
          paramAnonymousView.putExtra("Contact_IsLBSFriend", true);
          paramAnonymousView.putExtra("Contact_VUser_Info", paramAnonymousAdapterView.field_reserved3);
          paramAnonymousView.putExtra("Contact_VUser_Info_Flag", paramAnonymousAdapterView.field_reserved1);
          if (i == paramAnonymousAdapterView.field_sex) {}
          for (paramAnonymousInt = 23;; paramAnonymousInt = 24)
          {
            paramAnonymousView.putExtra("Contact_Scene", paramAnonymousInt);
            paramAnonymousView.putExtra("Sns_from_Scene", 22);
            paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.field_snsFlag);
            paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.field_sns_bgurl);
            if ((paramAnonymousAdapterView.field_reserved1 & 0x8) > 0) {
              com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramAnonymousAdapterView.field_username + "," + paramAnonymousView.getIntExtra("Contact_Scene", 23));
            }
            com.tencent.mm.plugin.shake.a.mIG.c(paramAnonymousView, ShakeItemListUI.this);
            break;
          }
        }
      });
      localObject = new com.tencent.mm.ui.tools.m(this);
      this.mYU.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(28394);
          if (paramAnonymousInt < ShakeItemListUI.c(ShakeItemListUI.this).getHeaderViewsCount())
          {
            Log.w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
            AppMethodBeat.o(28394);
            return true;
          }
          this.snw.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeItemListUI.this, ShakeItemListUI.e(ShakeItemListUI.this));
          AppMethodBeat.o(28394);
          return true;
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28410);
    super.onCreate(paramBundle);
    initView();
    com.tencent.mm.plugin.shake.b.m.fHo().add(this.Jpe);
    this.Jpe.ats();
    Log.i("MicroMsg.ShakeItemListUI", "onResume");
    AppMethodBeat.o(28410);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28412);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.id = ((com.tencent.mm.plugin.shake.b.d)this.Jpe.getItem(paramView.position)).field_shakeItemID;
    paramContextMenu.add(paramView.position, 0, 0, R.l.app_delete);
    AppMethodBeat.o(28412);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28414);
    this.Jpe.eKd();
    a locala = this.Jpe;
    if (locala.mVX != null)
    {
      locala.mVX.detach();
      locala.mVX = null;
    }
    com.tencent.mm.plugin.shake.b.m.fHo().remove(this.Jpe);
    Log.i("MicroMsg.ShakeItemListUI", "onPause");
    if (this.lQK != null) {
      this.lQK.detach();
    }
    super.onDestroy();
    AppMethodBeat.o(28414);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(28413);
    super.onPause();
    AppMethodBeat.o(28413);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void setShowType(int paramInt)
  {
    AppMethodBeat.i(28415);
    this.Jpe.setShowType(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28415);
      return;
      if (this.tzi != null)
      {
        this.tzi.findViewById(R.h.dTV).setVisibility(8);
        AppMethodBeat.o(28415);
        return;
        if (this.tzi != null) {
          this.tzi.findViewById(R.h.dTV).setVisibility(0);
        }
      }
    }
  }
  
  final class a
    extends v<com.tencent.mm.plugin.shake.b.d>
  {
    private int fwp;
    com.tencent.mm.ui.applet.b mVX;
    private b.b mVY;
    
    public a(ShakeItemListUI paramShakeItemListUI)
    {
      super(new com.tencent.mm.plugin.shake.b.d());
      AppMethodBeat.i(28403);
      this.fwp = 0;
      this.mVY = null;
      this.mVX = new com.tencent.mm.ui.applet.b(new b.a()
      {
        public final Bitmap aaG(String paramAnonymousString)
        {
          AppMethodBeat.i(28399);
          paramAnonymousString = com.tencent.mm.am.d.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(28399);
          return paramAnonymousString;
        }
      });
      ats();
      AppMethodBeat.o(28403);
    }
    
    public final void atr()
    {
      AppMethodBeat.i(28406);
      if (!bh.aHB())
      {
        AppMethodBeat.o(28406);
        return;
      }
      switch (this.fwp)
      {
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        AppMethodBeat.o(28406);
        return;
        v(com.tencent.mm.plugin.shake.b.m.fHo().fGU());
        continue;
        v(com.tencent.mm.plugin.shake.b.m.fHo().fGW());
        continue;
        v(com.tencent.mm.plugin.shake.b.m.fHo().fGV());
        continue;
        v(com.tencent.mm.plugin.shake.b.m.fHo().fGX());
        continue;
        v(com.tencent.mm.plugin.shake.b.m.fHo().fGY());
        continue;
        v(com.tencent.mm.plugin.shake.b.m.fHo().fGZ());
        continue;
        v(com.tencent.mm.plugin.shake.b.m.fHo().fHa());
        continue;
        v(com.tencent.mm.plugin.shake.b.m.fHo().fHb());
        continue;
        v(com.tencent.mm.plugin.shake.b.m.fHo().aes(ShakeItemListUI.this.getIntent().getIntExtra("_ibeacon_new_insert_size", 2)));
      }
    }
    
    public final void ats()
    {
      AppMethodBeat.i(28405);
      eKd();
      atr();
      AppMethodBeat.o(28405);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(28404);
      if (this.mVY == null) {
        this.mVY = new b.b()
        {
          public final int byf()
          {
            AppMethodBeat.i(28401);
            int i = ShakeItemListUI.a.this.getCount();
            AppMethodBeat.o(28401);
            return i;
          }
          
          public final String yk(int paramAnonymousInt)
          {
            AppMethodBeat.i(28400);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= ShakeItemListUI.a.this.getCount()))
            {
              Log.e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
              AppMethodBeat.o(28400);
              return null;
            }
            Object localObject = (com.tencent.mm.plugin.shake.b.d)ShakeItemListUI.a.this.getItem(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(28400);
              return null;
            }
            localObject = ((com.tencent.mm.plugin.shake.b.d)localObject).field_username;
            AppMethodBeat.o(28400);
            return localObject;
          }
        };
      }
      if (this.mVX != null) {
        this.mVX.a(paramInt, this.mVY);
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, R.i.ekS, null);
        paramViewGroup.mWb = ((ImageView)paramView.findViewById(R.h.nearby_friend_avatar_iv));
        paramViewGroup.mUr = ((TextView)paramView.findViewById(R.h.nearby_friend_name));
        paramViewGroup.mWc = ((TextView)paramView.findViewById(R.h.nearby_friend_is_friend));
        paramViewGroup.Jpk = ((ImageView)paramView.findViewById(R.h.nearby_friend_sex));
        paramViewGroup.zHU = ((TextView)paramView.findViewById(R.h.nearby_friend_distance));
        paramViewGroup.zHV = ((TextView)paramView.findViewById(R.h.nearby_friend_sign));
        paramViewGroup.zHW = ((ImageView)paramView.findViewById(R.h.nearby_friend_vuserinfo));
        paramViewGroup.Jpl = ((TextView)paramView.findViewById(R.h.dUJ));
        paramViewGroup.Jpj = paramView.findViewById(R.h.right_span);
        paramViewGroup.Jpm = ((LinearLayout)paramView.findViewById(R.h.dTX));
        paramViewGroup.Jpn = ((TextView)paramView.findViewById(R.h.dTY));
        paramView.setTag(paramViewGroup);
      }
      Object localObject1;
      for (;;)
      {
        localObject1 = (com.tencent.mm.plugin.shake.b.d)getItem(paramInt);
        if (localObject1 != null) {
          break;
        }
        paramViewGroup.clear();
        AppMethodBeat.o(28404);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.clear();
      if ((4 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) || ((k.aez(((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)) && (6 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)))
      {
        if (4 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) {
          paramViewGroup.mWb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        e.a(paramViewGroup.mWb, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_sns_bgurl, R.k.app_attach_file_icon_webpage, false);
        paramViewGroup.mWb.setVisibility(0);
        if ((7 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (10 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (12 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (13 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && ((8 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) || (!Util.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname)) || (!Util.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username)))) {
          break label521;
        }
        if (8 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) {
          break label506;
        }
        paramViewGroup.Jpn.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
      }
      for (;;)
      {
        paramViewGroup.Jpn.setVisibility(0);
        paramViewGroup.Jpm.setVisibility(8);
        AppMethodBeat.o(28404);
        return paramView;
        if (11 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
        {
          ShakeItemListUI.g(ShakeItemListUI.this).loadImage(((com.tencent.mm.plugin.shake.b.d)localObject1).getProvince(), paramViewGroup.mWb);
          break;
        }
        a.b.c(paramViewGroup.mWb, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
        break;
        label506:
        paramViewGroup.Jpn.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
      }
      label521:
      paramViewGroup.Jpn.setVisibility(8);
      paramViewGroup.Jpm.setVisibility(0);
      if ((8 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (Util.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname)))
      {
        ((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname = ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance;
        ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance = ((com.tencent.mm.plugin.shake.b.d)localObject1).field_username;
      }
      Object localObject2 = Util.nullAsNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
      paramViewGroup.mUr.setText(l.b(this.context, (CharSequence)localObject2, paramViewGroup.mUr.getTextSize()));
      paramViewGroup.mUr.setVisibility(0);
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingLeft();
      if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_insertBatch == 2)
      {
        paramView.setBackgroundDrawable(com.tencent.mm.ci.a.m(this.context, R.g.comm_item_highlight_selector));
        paramView.setPadding(k, i, j, paramInt);
        switch (((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
        {
        default: 
          paramViewGroup.Jpj.setVisibility(0);
          paramViewGroup.zHU.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
          paramViewGroup.zHU.setVisibility(0);
          if ((((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature == null) || (((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature.trim().equals("")))
          {
            paramViewGroup.zHV.setVisibility(8);
            label770:
            if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex != 1) {
              break label1071;
            }
            paramViewGroup.Jpk.setVisibility(0);
            paramViewGroup.Jpk.setImageDrawable(com.tencent.mm.ci.a.m(this.context, R.k.ic_sex_male));
            paramViewGroup.Jpk.setContentDescription(this.context.getString(R.l.male_Imgbtn));
            label821:
            bh.beI();
            localObject2 = com.tencent.mm.model.c.bbL().RG(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
            if ((localObject2 == null) || (!com.tencent.mm.contact.d.rk(((ax)localObject2).field_type))) {
              break label1157;
            }
            paramViewGroup.mWc.setVisibility(0);
            if (!as.asD(((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1)) {
              break label1137;
            }
            paramViewGroup.mWc.setText(this.context.getString(R.l.nearby_friend_followed));
            label892:
            if (6 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
            {
              paramViewGroup.zHU.setText(this.context.getString(R.l.eSz));
              paramViewGroup.mWc.setVisibility(8);
            }
            if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1 == 0) {
              break label1169;
            }
            paramViewGroup.zHW.setVisibility(0);
            localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.ltt.uS(((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1), 2.0F);
            paramViewGroup.zHW.setImageBitmap((Bitmap)localObject1);
            paramViewGroup.Jpk.setVisibility(8);
          }
          break;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(28404);
        return paramView;
        paramView.setBackgroundDrawable(com.tencent.mm.ci.a.m(this.context, R.g.comm_list_item_selector));
        break;
        paramViewGroup.Jpl.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
        paramViewGroup.Jpl.setVisibility(0);
        AppMethodBeat.o(28404);
        return paramView;
        paramViewGroup.zHV.setVisibility(0);
        paramViewGroup.zHV.setText(l.b(this.context, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature, paramViewGroup.mUr.getTextSize()));
        break label770;
        label1071:
        if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex == 2)
        {
          paramViewGroup.Jpk.setVisibility(0);
          paramViewGroup.Jpk.setImageDrawable(com.tencent.mm.ci.a.m(this.context, R.k.ic_sex_female));
          paramViewGroup.Jpk.setContentDescription(this.context.getString(R.l.female_Imgbtn));
          break label821;
        }
        paramViewGroup.Jpk.setVisibility(8);
        break label821;
        label1137:
        paramViewGroup.mWc.setText(this.context.getString(R.l.nearby_friend_is_contact));
        break label892;
        label1157:
        paramViewGroup.mWc.setVisibility(8);
        break label892;
        label1169:
        paramViewGroup.zHW.setVisibility(8);
      }
    }
    
    protected final void setShowType(int paramInt)
    {
      AppMethodBeat.i(28407);
      this.fwp = paramInt;
      ats();
      AppMethodBeat.o(28407);
    }
    
    final class a
    {
      View Jpj;
      ImageView Jpk;
      TextView Jpl;
      LinearLayout Jpm;
      TextView Jpn;
      TextView mUr;
      ImageView mWb;
      TextView mWc;
      TextView zHU;
      TextView zHV;
      ImageView zHW;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(28402);
        if (this.mWb != null)
        {
          this.mWb.setImageDrawable(null);
          this.mWb.setVisibility(8);
        }
        if (this.mUr != null)
        {
          this.mUr.setText("");
          this.mUr.setVisibility(8);
        }
        if (this.mWc != null) {
          this.mWc.setVisibility(8);
        }
        if (this.Jpk != null) {
          this.Jpk.setVisibility(8);
        }
        if (this.zHU != null)
        {
          this.zHU.setText("");
          this.zHU.setVisibility(8);
        }
        if (this.zHV != null)
        {
          this.zHV.setVisibility(8);
          this.Jpj.setVisibility(8);
        }
        if (this.zHW != null) {
          this.zHW.setVisibility(8);
        }
        if (this.Jpl != null)
        {
          this.Jpl.setText("");
          this.Jpl.setVisibility(8);
        }
        AppMethodBeat.o(28402);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI
 * JD-Core Version:    0.7.0.1
 */