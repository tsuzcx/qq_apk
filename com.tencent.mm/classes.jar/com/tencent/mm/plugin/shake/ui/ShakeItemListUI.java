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
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.c;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.i.1;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.l;

public class ShakeItemListUI
  extends MMActivity
{
  private int dlp;
  private com.tencent.mm.aw.a.a icC;
  private int id;
  private ListView jgA;
  private n.e nUI;
  private View oIV;
  private a yOA;
  public long yOy;
  private boolean yOz;
  
  public ShakeItemListUI()
  {
    AppMethodBeat.i(28409);
    this.yOy = 0L;
    this.yOz = false;
    this.icC = null;
    this.nUI = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28398);
        com.tencent.mm.plugin.shake.b.m.dOO().Pk(ShakeItemListUI.f(ShakeItemListUI.this));
        AppMethodBeat.o(28398);
      }
    };
    AppMethodBeat.o(28409);
  }
  
  public static int Ps(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 0: 
    default: 
      return 2131763559;
    case 100: 
      return 2131763563;
    case -5: 
    case 4: 
      return 2131763593;
    case -6: 
    case 5: 
      return 2131763633;
    }
    return 2131763566;
  }
  
  public int getLayoutId()
  {
    return 2131495413;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28411);
    this.icC = new com.tencent.mm.aw.a.a(this);
    ba.aBQ();
    final int i = bt.a((Integer)com.tencent.mm.model.c.ajl().get(12290, null), 0);
    this.dlp = getIntent().getIntExtra("_key_show_type_", 0);
    Object localObject = getIntent().getStringExtra("_key_title_");
    if (!bt.isNullOrNil((String)localObject)) {
      setMMTitle((String)localObject);
    }
    this.yOz = getIntent().getBooleanExtra("_key_show_from_shake_", false);
    addTextOptionMenu(0, getString(2131755694), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28391);
        com.tencent.mm.ui.base.h.a(ShakeItemListUI.this, true, ShakeItemListUI.this.getString(2131762787), "", ShakeItemListUI.this.getString(2131755694), ShakeItemListUI.this.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28390);
            switch (ShakeItemListUI.a(ShakeItemListUI.this))
            {
            }
            for (;;)
            {
              ShakeItemListUI.b(ShakeItemListUI.this).Zu();
              ShakeItemListUI.c(ShakeItemListUI.this).setVisibility(8);
              paramAnonymous2DialogInterface = (TextView)ShakeItemListUI.this.findViewById(2131302694);
              paramAnonymous2DialogInterface.setText(ShakeItemListUI.Ps(ShakeItemListUI.a(ShakeItemListUI.this)));
              paramAnonymous2DialogInterface.setVisibility(0);
              ShakeItemListUI.this.enableOptionMenu(false);
              AppMethodBeat.o(28390);
              return;
              com.tencent.mm.plugin.shake.b.m.dOO().Pl(0);
              com.tencent.mm.plugin.shake.b.m.dOO().dOD();
              continue;
              com.tencent.mm.plugin.shake.b.m.dOO().Pl(0);
              continue;
              ba.ajF().ay(new i.1());
              com.tencent.mm.plugin.shake.b.m.dOO().Pl(4);
              continue;
              com.tencent.mm.plugin.shake.b.m.dOO().Pl(7);
              com.tencent.mm.plugin.shake.b.m.dOO().Pl(6);
              com.tencent.mm.plugin.shake.b.m.dOO().Pl(8);
              com.tencent.mm.plugin.shake.b.m.dOO().Pl(9);
              com.tencent.mm.plugin.shake.b.m.dOO().Pl(10);
              com.tencent.mm.plugin.shake.b.m.dOO().Pl(12);
              continue;
              com.tencent.mm.plugin.shake.b.m.dOO().Pl(11);
            }
          }
        }, null);
        AppMethodBeat.o(28391);
        return true;
      }
    });
    this.jgA = ((ListView)findViewById(2131302692));
    this.oIV = getLayoutInflater().inflate(2131495415, null);
    this.oIV.findViewById(2131304676).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28392);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ShakeItemListUI.a(ShakeItemListUI.this, ShakeItemListUI.a(ShakeItemListUI.this) ^ 0xFFFFFFFF);
        ShakeItemListUI.this.setShowType(ShakeItemListUI.a(ShakeItemListUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28392);
      }
    });
    this.jgA.addFooterView(this.oIV);
    if (this.dlp == -1)
    {
      this.oIV.findViewById(2131304676).setVisibility(0);
      this.yOA = new a(this);
      this.yOA.setShowType(this.dlp);
      if (this.yOA.getCount() > 0) {
        break label325;
      }
      this.jgA.setVisibility(8);
      localObject = (TextView)findViewById(2131302694);
      ((TextView)localObject).setText(Ps(this.dlp));
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = ShakeItemListUI.c(ShakeItemListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28396);
        }
      });
      this.jgA.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(28397);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if (ShakeItemListUI.b(ShakeItemListUI.this) != null)
          {
            paramAnonymousView = ShakeItemListUI.b(ShakeItemListUI.this);
            if (paramAnonymousView.jdB != null) {
              paramAnonymousView.jdB.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(28397);
          return false;
        }
      });
      AppMethodBeat.o(28411);
      return;
      this.oIV.findViewById(2131304676).setVisibility(8);
      break;
      label325:
      this.jgA.setAdapter(this.yOA);
      this.jgA.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(28393);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousAdapterView = (com.tencent.mm.plugin.shake.b.d)ShakeItemListUI.b(ShakeItemListUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
          }
          paramAnonymousView = com.tencent.mm.plugin.shake.b.m.dOO();
          int i;
          if (paramAnonymousAdapterView == null)
          {
            ad.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
            i = paramAnonymousAdapterView.field_type;
            if (i != 4) {
              break label288;
            }
            paramAnonymousView = new Intent();
            if (!com.tencent.mm.az.e.aJQ()) {
              break label255;
            }
            com.tencent.mm.az.a.c(i.d(paramAnonymousAdapterView.field_lvbuffer, 0L));
          }
          for (;;)
          {
            paramAnonymousView.putExtra("key_scene", 3);
            com.tencent.mm.bs.d.b(ShakeItemListUI.this, "music", ".ui.MusicMainUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
            paramAnonymousAdapterView.field_insertBatch = 1;
            paramAnonymousAdapterView.dDp = 1024;
            if (-1 == paramAnonymousView.db.update("shakeitem1", paramAnonymousAdapterView.convertTo(), "shakeItemID=? and insertBatch=?", new String[] { paramAnonymousAdapterView.field_shakeItemID, "2" })) {
              break;
            }
            paramAnonymousView.doNotify();
            break;
            label255:
            com.tencent.mm.az.a.aJE();
            paramAnonymousView.putExtra("key_mode", 1);
            paramAnonymousView.putExtra("KGlobalShakeMusic", true);
            com.tencent.mm.az.a.d(i.d(paramAnonymousAdapterView.field_lvbuffer, 0L));
          }
          label288:
          if (i == 11)
          {
            if (System.currentTimeMillis() - ShakeItemListUI.this.yOy > 2000L)
            {
              ShakeItemListUI.this.yOy = System.currentTimeMillis();
              if ((paramAnonymousAdapterView.field_reserved3 == null) || (paramAnonymousAdapterView.field_reserved3.split(",").length != 3) || (paramAnonymousAdapterView.field_reserved3.split(",")[0] == null) || (paramAnonymousAdapterView.field_reserved3.split(",")[0].equals(""))) {
                break label494;
              }
              paramAnonymousView = paramAnonymousAdapterView.field_reserved3.split(",");
              localObject = new vm();
              ((vm)localObject).dJF.userName = paramAnonymousView[0];
              ((vm)localObject).dJF.dJH = bt.bI(paramAnonymousView[1], "");
              ((vm)localObject).dJF.dJI = Integer.parseInt(paramAnonymousView[2]);
              ((vm)localObject).dJF.scene = 1077;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
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
              com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            }
          }
          if (com.tencent.mm.plugin.shake.d.a.k.Pq(i))
          {
            com.tencent.mm.plugin.shake.d.a.k.a(paramAnonymousAdapterView, ShakeItemListUI.this, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
          }
          paramAnonymousView = paramAnonymousAdapterView.field_username;
          ba.aBQ();
          localObject = com.tencent.mm.model.c.azp().Bf(paramAnonymousView);
          ad.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramAnonymousView + " display:" + paramAnonymousAdapterView.field_nickname + " position:" + paramAnonymousInt + " contactName" + ((aw)localObject).field_username);
          ad.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.o.b.lM(((aw)localObject).field_type) + "  contact:" + localObject);
          if (com.tencent.mm.o.b.lM(((aw)localObject).field_type))
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
                if (((am)localObject).fqg())
                {
                  g.yhR.kvStat(10298, paramAnonymousAdapterView.field_username + "," + localIntent.getIntExtra("Contact_Scene", 23));
                  localIntent.putExtra("Contact_Scene", 23);
                }
                com.tencent.mm.plugin.shake.a.iRG.c(localIntent, ShakeItemListUI.this);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(28393);
              return;
            }
          }
          ad.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramAnonymousView + " display:" + paramAnonymousAdapterView.field_nickname + " position:" + paramAnonymousInt + " contactName" + ((aw)localObject).field_username);
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
              g.yhR.kvStat(10298, paramAnonymousAdapterView.field_username + "," + paramAnonymousView.getIntExtra("Contact_Scene", 23));
            }
            com.tencent.mm.plugin.shake.a.iRG.c(paramAnonymousView, ShakeItemListUI.this);
            break;
          }
        }
      });
      localObject = new l(this);
      this.jgA.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(28394);
          if (paramAnonymousInt < ShakeItemListUI.c(ShakeItemListUI.this).getHeaderViewsCount())
          {
            ad.w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
            AppMethodBeat.o(28394);
            return true;
          }
          this.nUL.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeItemListUI.this, ShakeItemListUI.e(ShakeItemListUI.this));
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
    com.tencent.mm.plugin.shake.b.m.dOO().add(this.yOA);
    this.yOA.Zv();
    ad.i("MicroMsg.ShakeItemListUI", "onResume");
    AppMethodBeat.o(28410);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28412);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.id = ((com.tencent.mm.plugin.shake.b.d)this.yOA.getItem(paramView.position)).field_shakeItemID;
    paramContextMenu.add(paramView.position, 0, 0, 2131755707);
    AppMethodBeat.o(28412);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28414);
    this.yOA.det();
    a locala = this.yOA;
    if (locala.jdB != null)
    {
      locala.jdB.detach();
      locala.jdB = null;
    }
    com.tencent.mm.plugin.shake.b.m.dOO().remove(this.yOA);
    ad.i("MicroMsg.ShakeItemListUI", "onPause");
    if (this.icC != null) {
      this.icC.detach();
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
    this.yOA.setShowType(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28415);
      return;
      if (this.oIV != null)
      {
        this.oIV.findViewById(2131304676).setVisibility(8);
        AppMethodBeat.o(28415);
        return;
        if (this.oIV != null) {
          this.oIV.findViewById(2131304676).setVisibility(0);
        }
      }
    }
  }
  
  final class a
    extends r<com.tencent.mm.plugin.shake.b.d>
  {
    private int dlp;
    com.tencent.mm.ui.applet.b jdB;
    private b.b jdC;
    
    public a(ShakeItemListUI paramShakeItemListUI)
    {
      super(new com.tencent.mm.plugin.shake.b.d());
      AppMethodBeat.i(28403);
      this.dlp = 0;
      this.jdC = null;
      this.jdB = new com.tencent.mm.ui.applet.b(new b.a()
      {
        public final Bitmap JD(String paramAnonymousString)
        {
          AppMethodBeat.i(28399);
          paramAnonymousString = com.tencent.mm.ak.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(28399);
          return paramAnonymousString;
        }
      });
      Zv();
      AppMethodBeat.o(28403);
    }
    
    public final void Zu()
    {
      AppMethodBeat.i(28406);
      if (!ba.ajx())
      {
        AppMethodBeat.o(28406);
        return;
      }
      switch (this.dlp)
      {
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        AppMethodBeat.o(28406);
        return;
        setCursor(com.tencent.mm.plugin.shake.b.m.dOO().dOu());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dOO().dOw());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dOO().dOv());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dOO().dOx());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dOO().dOy());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dOO().dOz());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dOO().dOA());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dOO().dOB());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dOO().Pj(ShakeItemListUI.this.getIntent().getIntExtra("_ibeacon_new_insert_size", 2)));
      }
    }
    
    public final void Zv()
    {
      AppMethodBeat.i(28405);
      det();
      Zu();
      AppMethodBeat.o(28405);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(28404);
      if (this.jdC == null) {
        this.jdC = new b.b()
        {
          public final int aSL()
          {
            AppMethodBeat.i(28401);
            int i = ShakeItemListUI.a.this.getCount();
            AppMethodBeat.o(28401);
            return i;
          }
          
          public final String rn(int paramAnonymousInt)
          {
            AppMethodBeat.i(28400);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= ShakeItemListUI.a.this.getCount()))
            {
              ad.e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
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
      if (this.jdB != null) {
        this.jdB.a(paramInt, this.jdC);
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131495414, null);
        paramViewGroup.jdF = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.jbW = ((TextView)paramView.findViewById(2131302693));
        paramViewGroup.jdG = ((TextView)paramView.findViewById(2131302690));
        paramViewGroup.yOG = ((ImageView)paramView.findViewById(2131302695));
        paramViewGroup.wpo = ((TextView)paramView.findViewById(2131302688));
        paramViewGroup.wpp = ((TextView)paramView.findViewById(2131302696));
        paramViewGroup.wpq = ((ImageView)paramView.findViewById(2131302698));
        paramViewGroup.yOH = ((TextView)paramView.findViewById(2131304721));
        paramViewGroup.yOF = paramView.findViewById(2131304194);
        paramViewGroup.yOI = ((LinearLayout)paramView.findViewById(2131304681));
        paramViewGroup.yOJ = ((TextView)paramView.findViewById(2131304682));
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
      if ((4 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) || ((com.tencent.mm.plugin.shake.d.a.k.Pq(((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)) && (6 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)))
      {
        if (4 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) {
          paramViewGroup.jdF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        e.a(paramViewGroup.jdF, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_sns_bgurl, 2131689584, false);
        paramViewGroup.jdF.setVisibility(0);
        if ((7 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (10 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (12 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (13 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && ((8 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) || (!bt.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname)) || (!bt.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username)))) {
          break label508;
        }
        if (8 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) {
          break label493;
        }
        paramViewGroup.yOJ.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
      }
      for (;;)
      {
        paramViewGroup.yOJ.setVisibility(0);
        paramViewGroup.yOI.setVisibility(8);
        AppMethodBeat.o(28404);
        return paramView;
        if (11 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
        {
          ShakeItemListUI.g(ShakeItemListUI.this).loadImage(((com.tencent.mm.plugin.shake.b.d)localObject1).getProvince(), paramViewGroup.jdF);
          break;
        }
        a.b.c(paramViewGroup.jdF, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
        break;
        label493:
        paramViewGroup.yOJ.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
      }
      label508:
      paramViewGroup.yOJ.setVisibility(8);
      paramViewGroup.yOI.setVisibility(0);
      if ((8 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (bt.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname)))
      {
        ((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname = ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance;
        ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance = ((com.tencent.mm.plugin.shake.b.d)localObject1).field_username;
      }
      Object localObject2 = bt.nullAsNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
      paramViewGroup.jbW.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject2, paramViewGroup.jbW.getTextSize()));
      paramViewGroup.jbW.setVisibility(0);
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingLeft();
      if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_insertBatch == 2)
      {
        paramView.setBackgroundDrawable(com.tencent.mm.cc.a.l(this.context, 2131231817));
        paramView.setPadding(k, i, j, paramInt);
        switch (((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
        {
        default: 
          paramViewGroup.yOF.setVisibility(0);
          paramViewGroup.wpo.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
          paramViewGroup.wpo.setVisibility(0);
          if ((((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature == null) || (((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature.trim().equals("")))
          {
            paramViewGroup.wpp.setVisibility(8);
            label758:
            if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex != 1) {
              break label1059;
            }
            paramViewGroup.yOG.setVisibility(0);
            paramViewGroup.yOG.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690323));
            paramViewGroup.yOG.setContentDescription(this.context.getString(2131761078));
            label809:
            ba.aBQ();
            localObject2 = com.tencent.mm.model.c.azp().Bf(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
            if ((localObject2 == null) || (!com.tencent.mm.o.b.lM(((aw)localObject2).field_type))) {
              break label1145;
            }
            paramViewGroup.jdG.setVisibility(0);
            if (!am.aaR(((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1)) {
              break label1125;
            }
            paramViewGroup.jdG.setText(this.context.getString(2131761502));
            label880:
            if (6 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
            {
              paramViewGroup.wpo.setText(this.context.getString(2131763562));
              paramViewGroup.jdG.setVisibility(8);
            }
            if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1 == 0) {
              break label1157;
            }
            paramViewGroup.wpq.setVisibility(0);
            localObject1 = BackwardSupportUtil.b.o(as.a.hFQ.or(((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1), 2.0F);
            paramViewGroup.wpq.setImageBitmap((Bitmap)localObject1);
            paramViewGroup.yOG.setVisibility(8);
          }
          break;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(28404);
        return paramView;
        paramView.setBackgroundDrawable(com.tencent.mm.cc.a.l(this.context, 2131231818));
        break;
        paramViewGroup.yOH.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
        paramViewGroup.yOH.setVisibility(0);
        AppMethodBeat.o(28404);
        return paramView;
        paramViewGroup.wpp.setVisibility(0);
        paramViewGroup.wpp.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature, paramViewGroup.jbW.getTextSize()));
        break label758;
        label1059:
        if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex == 2)
        {
          paramViewGroup.yOG.setVisibility(0);
          paramViewGroup.yOG.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690322));
          paramViewGroup.yOG.setContentDescription(this.context.getString(2131759044));
          break label809;
        }
        paramViewGroup.yOG.setVisibility(8);
        break label809;
        label1125:
        paramViewGroup.jdG.setText(this.context.getString(2131761507));
        break label880;
        label1145:
        paramViewGroup.jdG.setVisibility(8);
        break label880;
        label1157:
        paramViewGroup.wpq.setVisibility(8);
      }
    }
    
    protected final void setShowType(int paramInt)
    {
      AppMethodBeat.i(28407);
      this.dlp = paramInt;
      Zv();
      AppMethodBeat.o(28407);
    }
    
    final class a
    {
      TextView jbW;
      ImageView jdF;
      TextView jdG;
      TextView wpo;
      TextView wpp;
      ImageView wpq;
      View yOF;
      ImageView yOG;
      TextView yOH;
      LinearLayout yOI;
      TextView yOJ;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(28402);
        if (this.jdF != null)
        {
          this.jdF.setImageDrawable(null);
          this.jdF.setVisibility(8);
        }
        if (this.jbW != null)
        {
          this.jbW.setText("");
          this.jbW.setVisibility(8);
        }
        if (this.jdG != null) {
          this.jdG.setVisibility(8);
        }
        if (this.yOG != null) {
          this.yOG.setVisibility(8);
        }
        if (this.wpo != null)
        {
          this.wpo.setText("");
          this.wpo.setVisibility(8);
        }
        if (this.wpp != null)
        {
          this.wpp.setVisibility(8);
          this.yOF.setVisibility(8);
        }
        if (this.wpq != null) {
          this.wpq.setVisibility(8);
        }
        if (this.yOH != null)
        {
          this.yOH.setText("");
          this.yOH.setVisibility(8);
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