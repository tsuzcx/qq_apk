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
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.i.1;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.l;

public class ShakeItemListUI
  extends MMActivity
{
  private int dmr;
  private int id;
  private com.tencent.mm.av.a.a ifv;
  private ListView jjt;
  private View oPx;
  private n.e oao;
  public long zeI;
  private boolean zeJ;
  private a zeK;
  
  public ShakeItemListUI()
  {
    AppMethodBeat.i(28409);
    this.zeI = 0L;
    this.zeJ = false;
    this.ifv = null;
    this.oao = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28398);
        com.tencent.mm.plugin.shake.b.m.dSl().PR(ShakeItemListUI.f(ShakeItemListUI.this));
        AppMethodBeat.o(28398);
      }
    };
    AppMethodBeat.o(28409);
  }
  
  public static int PZ(int paramInt)
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
    this.ifv = new com.tencent.mm.av.a.a(this);
    bc.aCg();
    final int i = bu.a((Integer)com.tencent.mm.model.c.ajA().get(12290, null), 0);
    this.dmr = getIntent().getIntExtra("_key_show_type_", 0);
    Object localObject = getIntent().getStringExtra("_key_title_");
    if (!bu.isNullOrNil((String)localObject)) {
      setMMTitle((String)localObject);
    }
    this.zeJ = getIntent().getBooleanExtra("_key_show_from_shake_", false);
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
              ShakeItemListUI.b(ShakeItemListUI.this).ZD();
              ShakeItemListUI.c(ShakeItemListUI.this).setVisibility(8);
              paramAnonymous2DialogInterface = (TextView)ShakeItemListUI.this.findViewById(2131302694);
              paramAnonymous2DialogInterface.setText(ShakeItemListUI.PZ(ShakeItemListUI.a(ShakeItemListUI.this)));
              paramAnonymous2DialogInterface.setVisibility(0);
              ShakeItemListUI.this.enableOptionMenu(false);
              AppMethodBeat.o(28390);
              return;
              com.tencent.mm.plugin.shake.b.m.dSl().PS(0);
              com.tencent.mm.plugin.shake.b.m.dSl().dSa();
              continue;
              com.tencent.mm.plugin.shake.b.m.dSl().PS(0);
              continue;
              bc.ajU().aw(new i.1());
              com.tencent.mm.plugin.shake.b.m.dSl().PS(4);
              continue;
              com.tencent.mm.plugin.shake.b.m.dSl().PS(7);
              com.tencent.mm.plugin.shake.b.m.dSl().PS(6);
              com.tencent.mm.plugin.shake.b.m.dSl().PS(8);
              com.tencent.mm.plugin.shake.b.m.dSl().PS(9);
              com.tencent.mm.plugin.shake.b.m.dSl().PS(10);
              com.tencent.mm.plugin.shake.b.m.dSl().PS(12);
              continue;
              com.tencent.mm.plugin.shake.b.m.dSl().PS(11);
            }
          }
        }, null);
        AppMethodBeat.o(28391);
        return true;
      }
    });
    this.jjt = ((ListView)findViewById(2131302692));
    this.oPx = getLayoutInflater().inflate(2131495415, null);
    this.oPx.findViewById(2131304676).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28392);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ShakeItemListUI.a(ShakeItemListUI.this, ShakeItemListUI.a(ShakeItemListUI.this) ^ 0xFFFFFFFF);
        ShakeItemListUI.this.setShowType(ShakeItemListUI.a(ShakeItemListUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28392);
      }
    });
    this.jjt.addFooterView(this.oPx);
    if (this.dmr == -1)
    {
      this.oPx.findViewById(2131304676).setVisibility(0);
      this.zeK = new a(this);
      this.zeK.setShowType(this.dmr);
      if (this.zeK.getCount() > 0) {
        break label325;
      }
      this.jjt.setVisibility(8);
      localObject = (TextView)findViewById(2131302694);
      ((TextView)localObject).setText(PZ(this.dmr));
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = ShakeItemListUI.c(ShakeItemListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28396);
        }
      });
      this.jjt.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(28397);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          if (ShakeItemListUI.b(ShakeItemListUI.this) != null)
          {
            paramAnonymousView = ShakeItemListUI.b(ShakeItemListUI.this);
            if (paramAnonymousView.jgu != null) {
              paramAnonymousView.jgu.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(28397);
          return false;
        }
      });
      AppMethodBeat.o(28411);
      return;
      this.oPx.findViewById(2131304676).setVisibility(8);
      break;
      label325:
      this.jjt.setAdapter(this.zeK);
      this.jjt.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(28393);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousAdapterView = (com.tencent.mm.plugin.shake.b.d)ShakeItemListUI.b(ShakeItemListUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
          }
          paramAnonymousView = com.tencent.mm.plugin.shake.b.m.dSl();
          int i;
          if (paramAnonymousAdapterView == null)
          {
            ae.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
            i = paramAnonymousAdapterView.field_type;
            if (i != 4) {
              break label288;
            }
            paramAnonymousView = new Intent();
            if (!com.tencent.mm.ay.e.aKj()) {
              break label255;
            }
            com.tencent.mm.ay.a.c(i.d(paramAnonymousAdapterView.field_lvbuffer, 0L));
          }
          for (;;)
          {
            paramAnonymousView.putExtra("key_scene", 3);
            com.tencent.mm.br.d.b(ShakeItemListUI.this, "music", ".ui.MusicMainUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
            paramAnonymousAdapterView.field_insertBatch = 1;
            paramAnonymousAdapterView.dEu = 1024;
            if (-1 == paramAnonymousView.db.update("shakeitem1", paramAnonymousAdapterView.convertTo(), "shakeItemID=? and insertBatch=?", new String[] { paramAnonymousAdapterView.field_shakeItemID, "2" })) {
              break;
            }
            paramAnonymousView.doNotify();
            break;
            label255:
            com.tencent.mm.ay.a.aJX();
            paramAnonymousView.putExtra("key_mode", 1);
            paramAnonymousView.putExtra("KGlobalShakeMusic", true);
            com.tencent.mm.ay.a.d(i.d(paramAnonymousAdapterView.field_lvbuffer, 0L));
          }
          label288:
          if (i == 11)
          {
            if (System.currentTimeMillis() - ShakeItemListUI.this.zeI > 2000L)
            {
              ShakeItemListUI.this.zeI = System.currentTimeMillis();
              if ((paramAnonymousAdapterView.field_reserved3 == null) || (paramAnonymousAdapterView.field_reserved3.split(",").length != 3) || (paramAnonymousAdapterView.field_reserved3.split(",")[0] == null) || (paramAnonymousAdapterView.field_reserved3.split(",")[0].equals(""))) {
                break label494;
              }
              paramAnonymousView = paramAnonymousAdapterView.field_reserved3.split(",");
              localObject = new vq();
              ((vq)localObject).dKT.userName = paramAnonymousView[0];
              ((vq)localObject).dKT.dKV = bu.bI(paramAnonymousView[1], "");
              ((vq)localObject).dKT.dKW = Integer.parseInt(paramAnonymousView[2]);
              ((vq)localObject).dKT.scene = 1077;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
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
              com.tencent.mm.br.d.b(ak.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            }
          }
          if (com.tencent.mm.plugin.shake.d.a.k.PX(i))
          {
            com.tencent.mm.plugin.shake.d.a.k.a(paramAnonymousAdapterView, ShakeItemListUI.this, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
          }
          paramAnonymousView = paramAnonymousAdapterView.field_username;
          bc.aCg();
          localObject = com.tencent.mm.model.c.azF().BH(paramAnonymousView);
          ae.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramAnonymousView + " display:" + paramAnonymousAdapterView.field_nickname + " position:" + paramAnonymousInt + " contactName" + ((aw)localObject).field_username);
          ae.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.contact.c.lO(((aw)localObject).field_type) + "  contact:" + localObject);
          if (com.tencent.mm.contact.c.lO(((aw)localObject).field_type))
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
                if (((an)localObject).fug())
                {
                  g.yxI.kvStat(10298, paramAnonymousAdapterView.field_username + "," + localIntent.getIntExtra("Contact_Scene", 23));
                  localIntent.putExtra("Contact_Scene", 23);
                }
                com.tencent.mm.plugin.shake.a.iUz.c(localIntent, ShakeItemListUI.this);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(28393);
              return;
            }
          }
          ae.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramAnonymousView + " display:" + paramAnonymousAdapterView.field_nickname + " position:" + paramAnonymousInt + " contactName" + ((aw)localObject).field_username);
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
              g.yxI.kvStat(10298, paramAnonymousAdapterView.field_username + "," + paramAnonymousView.getIntExtra("Contact_Scene", 23));
            }
            com.tencent.mm.plugin.shake.a.iUz.c(paramAnonymousView, ShakeItemListUI.this);
            break;
          }
        }
      });
      localObject = new l(this);
      this.jjt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(28394);
          if (paramAnonymousInt < ShakeItemListUI.c(ShakeItemListUI.this).getHeaderViewsCount())
          {
            ae.w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
            AppMethodBeat.o(28394);
            return true;
          }
          this.oar.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeItemListUI.this, ShakeItemListUI.e(ShakeItemListUI.this));
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
    com.tencent.mm.plugin.shake.b.m.dSl().add(this.zeK);
    this.zeK.ZE();
    ae.i("MicroMsg.ShakeItemListUI", "onResume");
    AppMethodBeat.o(28410);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28412);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.id = ((com.tencent.mm.plugin.shake.b.d)this.zeK.getItem(paramView.position)).field_shakeItemID;
    paramContextMenu.add(paramView.position, 0, 0, 2131755707);
    AppMethodBeat.o(28412);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28414);
    this.zeK.dhl();
    a locala = this.zeK;
    if (locala.jgu != null)
    {
      locala.jgu.detach();
      locala.jgu = null;
    }
    com.tencent.mm.plugin.shake.b.m.dSl().remove(this.zeK);
    ae.i("MicroMsg.ShakeItemListUI", "onPause");
    if (this.ifv != null) {
      this.ifv.detach();
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
    this.zeK.setShowType(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28415);
      return;
      if (this.oPx != null)
      {
        this.oPx.findViewById(2131304676).setVisibility(8);
        AppMethodBeat.o(28415);
        return;
        if (this.oPx != null) {
          this.oPx.findViewById(2131304676).setVisibility(0);
        }
      }
    }
  }
  
  final class a
    extends r<com.tencent.mm.plugin.shake.b.d>
  {
    private int dmr;
    com.tencent.mm.ui.applet.b jgu;
    private b.b jgv;
    
    public a(ShakeItemListUI paramShakeItemListUI)
    {
      super(new com.tencent.mm.plugin.shake.b.d());
      AppMethodBeat.i(28403);
      this.dmr = 0;
      this.jgv = null;
      this.jgu = new com.tencent.mm.ui.applet.b(new b.a()
      {
        public final Bitmap Kc(String paramAnonymousString)
        {
          AppMethodBeat.i(28399);
          paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(28399);
          return paramAnonymousString;
        }
      });
      ZE();
      AppMethodBeat.o(28403);
    }
    
    public final void ZD()
    {
      AppMethodBeat.i(28406);
      if (!bc.ajM())
      {
        AppMethodBeat.o(28406);
        return;
      }
      switch (this.dmr)
      {
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        AppMethodBeat.o(28406);
        return;
        setCursor(com.tencent.mm.plugin.shake.b.m.dSl().dRR());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dSl().dRT());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dSl().dRS());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dSl().dRU());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dSl().dRV());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dSl().dRW());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dSl().dRX());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dSl().dRY());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.dSl().PQ(ShakeItemListUI.this.getIntent().getIntExtra("_ibeacon_new_insert_size", 2)));
      }
    }
    
    public final void ZE()
    {
      AppMethodBeat.i(28405);
      dhl();
      ZD();
      AppMethodBeat.o(28405);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(28404);
      if (this.jgv == null) {
        this.jgv = new b.b()
        {
          public final int aTk()
          {
            AppMethodBeat.i(28401);
            int i = ShakeItemListUI.a.this.getCount();
            AppMethodBeat.o(28401);
            return i;
          }
          
          public final String rq(int paramAnonymousInt)
          {
            AppMethodBeat.i(28400);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= ShakeItemListUI.a.this.getCount()))
            {
              ae.e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
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
      if (this.jgu != null) {
        this.jgu.a(paramInt, this.jgv);
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131495414, null);
        paramViewGroup.jgy = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.jeP = ((TextView)paramView.findViewById(2131302693));
        paramViewGroup.jgz = ((TextView)paramView.findViewById(2131302690));
        paramViewGroup.zeQ = ((ImageView)paramView.findViewById(2131302695));
        paramViewGroup.wEX = ((TextView)paramView.findViewById(2131302688));
        paramViewGroup.wEY = ((TextView)paramView.findViewById(2131302696));
        paramViewGroup.wEZ = ((ImageView)paramView.findViewById(2131302698));
        paramViewGroup.zeR = ((TextView)paramView.findViewById(2131304721));
        paramViewGroup.zeP = paramView.findViewById(2131304194);
        paramViewGroup.zeS = ((LinearLayout)paramView.findViewById(2131304681));
        paramViewGroup.zeT = ((TextView)paramView.findViewById(2131304682));
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
      if ((4 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) || ((com.tencent.mm.plugin.shake.d.a.k.PX(((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)) && (6 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)))
      {
        if (4 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) {
          paramViewGroup.jgy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        e.a(paramViewGroup.jgy, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_sns_bgurl, 2131689584, false);
        paramViewGroup.jgy.setVisibility(0);
        if ((7 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (10 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (12 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (13 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && ((8 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) || (!bu.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname)) || (!bu.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username)))) {
          break label508;
        }
        if (8 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) {
          break label493;
        }
        paramViewGroup.zeT.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
      }
      for (;;)
      {
        paramViewGroup.zeT.setVisibility(0);
        paramViewGroup.zeS.setVisibility(8);
        AppMethodBeat.o(28404);
        return paramView;
        if (11 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
        {
          ShakeItemListUI.g(ShakeItemListUI.this).loadImage(((com.tencent.mm.plugin.shake.b.d)localObject1).getProvince(), paramViewGroup.jgy);
          break;
        }
        a.b.c(paramViewGroup.jgy, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
        break;
        label493:
        paramViewGroup.zeT.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
      }
      label508:
      paramViewGroup.zeT.setVisibility(8);
      paramViewGroup.zeS.setVisibility(0);
      if ((8 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (bu.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname)))
      {
        ((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname = ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance;
        ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance = ((com.tencent.mm.plugin.shake.b.d)localObject1).field_username;
      }
      Object localObject2 = bu.nullAsNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
      paramViewGroup.jeP.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject2, paramViewGroup.jeP.getTextSize()));
      paramViewGroup.jeP.setVisibility(0);
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingLeft();
      if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_insertBatch == 2)
      {
        paramView.setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, 2131231817));
        paramView.setPadding(k, i, j, paramInt);
        switch (((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
        {
        default: 
          paramViewGroup.zeP.setVisibility(0);
          paramViewGroup.wEX.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
          paramViewGroup.wEX.setVisibility(0);
          if ((((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature == null) || (((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature.trim().equals("")))
          {
            paramViewGroup.wEY.setVisibility(8);
            label758:
            if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex != 1) {
              break label1059;
            }
            paramViewGroup.zeQ.setVisibility(0);
            paramViewGroup.zeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690323));
            paramViewGroup.zeQ.setContentDescription(this.context.getString(2131761078));
            label809:
            bc.aCg();
            localObject2 = com.tencent.mm.model.c.azF().BH(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
            if ((localObject2 == null) || (!com.tencent.mm.contact.c.lO(((aw)localObject2).field_type))) {
              break label1145;
            }
            paramViewGroup.jgz.setVisibility(0);
            if (!an.abz(((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1)) {
              break label1125;
            }
            paramViewGroup.jgz.setText(this.context.getString(2131761502));
            label880:
            if (6 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
            {
              paramViewGroup.wEX.setText(this.context.getString(2131763562));
              paramViewGroup.jgz.setVisibility(8);
            }
            if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1 == 0) {
              break label1157;
            }
            paramViewGroup.wEZ.setVisibility(0);
            localObject1 = BackwardSupportUtil.b.p(au.a.hII.ou(((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1), 2.0F);
            paramViewGroup.wEZ.setImageBitmap((Bitmap)localObject1);
            paramViewGroup.zeQ.setVisibility(8);
          }
          break;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(28404);
        return paramView;
        paramView.setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, 2131231818));
        break;
        paramViewGroup.zeR.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
        paramViewGroup.zeR.setVisibility(0);
        AppMethodBeat.o(28404);
        return paramView;
        paramViewGroup.wEY.setVisibility(0);
        paramViewGroup.wEY.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature, paramViewGroup.jeP.getTextSize()));
        break label758;
        label1059:
        if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex == 2)
        {
          paramViewGroup.zeQ.setVisibility(0);
          paramViewGroup.zeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690322));
          paramViewGroup.zeQ.setContentDescription(this.context.getString(2131759044));
          break label809;
        }
        paramViewGroup.zeQ.setVisibility(8);
        break label809;
        label1125:
        paramViewGroup.jgz.setText(this.context.getString(2131761507));
        break label880;
        label1145:
        paramViewGroup.jgz.setVisibility(8);
        break label880;
        label1157:
        paramViewGroup.wEZ.setVisibility(8);
      }
    }
    
    protected final void setShowType(int paramInt)
    {
      AppMethodBeat.i(28407);
      this.dmr = paramInt;
      ZE();
      AppMethodBeat.o(28407);
    }
    
    final class a
    {
      TextView jeP;
      ImageView jgy;
      TextView jgz;
      TextView wEX;
      TextView wEY;
      ImageView wEZ;
      View zeP;
      ImageView zeQ;
      TextView zeR;
      LinearLayout zeS;
      TextView zeT;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(28402);
        if (this.jgy != null)
        {
          this.jgy.setImageDrawable(null);
          this.jgy.setVisibility(8);
        }
        if (this.jeP != null)
        {
          this.jeP.setText("");
          this.jeP.setVisibility(8);
        }
        if (this.jgz != null) {
          this.jgz.setVisibility(8);
        }
        if (this.zeQ != null) {
          this.zeQ.setVisibility(8);
        }
        if (this.wEX != null)
        {
          this.wEX.setText("");
          this.wEX.setVisibility(8);
        }
        if (this.wEY != null)
        {
          this.wEY.setVisibility(8);
          this.zeP.setVisibility(8);
        }
        if (this.wEZ != null) {
          this.wEZ.setVisibility(8);
        }
        if (this.zeR != null)
        {
          this.zeR.setText("");
          this.zeR.setVisibility(8);
        }
        AppMethodBeat.o(28402);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI
 * JD-Core Version:    0.7.0.1
 */