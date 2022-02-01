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
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.i.1;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r;

public class ShakeItemListUI
  extends MMActivity
{
  private int cZX;
  private com.tencent.mm.av.a.a hJM;
  private ListView iNr;
  private int id;
  private n.d ntM;
  private View ofC;
  public long xzO;
  private boolean xzP;
  private a xzQ;
  
  public ShakeItemListUI()
  {
    AppMethodBeat.i(28409);
    this.xzO = 0L;
    this.xzP = false;
    this.hJM = null;
    this.ntM = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28398);
        m.dDl().NH(ShakeItemListUI.f(ShakeItemListUI.this));
        AppMethodBeat.o(28398);
      }
    };
    AppMethodBeat.o(28409);
  }
  
  public static int NP(int paramInt)
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
    this.hJM = new com.tencent.mm.av.a.a(this);
    az.ayM();
    final int i = bs.a((Integer)com.tencent.mm.model.c.agA().get(12290, null), 0);
    this.cZX = getIntent().getIntExtra("_key_show_type_", 0);
    Object localObject = getIntent().getStringExtra("_key_title_");
    if (!bs.isNullOrNil((String)localObject)) {
      setMMTitle((String)localObject);
    }
    this.xzP = getIntent().getBooleanExtra("_key_show_from_shake_", false);
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
              ShakeItemListUI.b(ShakeItemListUI.this).Xb();
              ShakeItemListUI.c(ShakeItemListUI.this).setVisibility(8);
              paramAnonymous2DialogInterface = (TextView)ShakeItemListUI.this.findViewById(2131302694);
              paramAnonymous2DialogInterface.setText(ShakeItemListUI.NP(ShakeItemListUI.a(ShakeItemListUI.this)));
              paramAnonymous2DialogInterface.setVisibility(0);
              ShakeItemListUI.this.enableOptionMenu(false);
              AppMethodBeat.o(28390);
              return;
              m.dDl().NI(0);
              m.dDl().dDa();
              continue;
              m.dDl().NI(0);
              continue;
              az.agU().az(new i.1());
              m.dDl().NI(4);
              continue;
              m.dDl().NI(7);
              m.dDl().NI(6);
              m.dDl().NI(8);
              m.dDl().NI(9);
              m.dDl().NI(10);
              m.dDl().NI(12);
              continue;
              m.dDl().NI(11);
            }
          }
        }, null);
        AppMethodBeat.o(28391);
        return true;
      }
    });
    this.iNr = ((ListView)findViewById(2131302692));
    this.ofC = getLayoutInflater().inflate(2131495415, null);
    this.ofC.findViewById(2131304676).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28392);
        ShakeItemListUI.a(ShakeItemListUI.this, ShakeItemListUI.a(ShakeItemListUI.this) ^ 0xFFFFFFFF);
        ShakeItemListUI.this.setShowType(ShakeItemListUI.a(ShakeItemListUI.this));
        AppMethodBeat.o(28392);
      }
    });
    this.iNr.addFooterView(this.ofC);
    if (this.cZX == -1)
    {
      this.ofC.findViewById(2131304676).setVisibility(0);
      this.xzQ = new a(this);
      this.xzQ.setShowType(this.cZX);
      if (this.xzQ.getCount() > 0) {
        break label325;
      }
      this.iNr.setVisibility(8);
      localObject = (TextView)findViewById(2131302694);
      ((TextView)localObject).setText(NP(this.cZX));
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
          paramAnonymousView = ShakeItemListUI.c(ShakeItemListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(28396);
        }
      });
      this.iNr.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(28397);
          if (ShakeItemListUI.b(ShakeItemListUI.this) != null)
          {
            paramAnonymousView = ShakeItemListUI.b(ShakeItemListUI.this);
            if (paramAnonymousView.iKs != null) {
              paramAnonymousView.iKs.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          AppMethodBeat.o(28397);
          return false;
        }
      });
      AppMethodBeat.o(28411);
      return;
      this.ofC.findViewById(2131304676).setVisibility(8);
      break;
      label325:
      this.iNr.setAdapter(this.xzQ);
      this.iNr.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(28393);
          paramAnonymousAdapterView = (com.tencent.mm.plugin.shake.b.d)ShakeItemListUI.b(ShakeItemListUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(28393);
            return;
          }
          paramAnonymousView = m.dDl();
          int i;
          if (paramAnonymousAdapterView == null)
          {
            ac.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
            i = paramAnonymousAdapterView.field_type;
            if (i != 4) {
              break label213;
            }
            paramAnonymousView = new Intent();
            if (!com.tencent.mm.ay.e.aGF()) {
              break label180;
            }
            com.tencent.mm.ay.a.c(i.d(paramAnonymousAdapterView.field_lvbuffer, 0L));
          }
          for (;;)
          {
            paramAnonymousView.putExtra("key_scene", 3);
            com.tencent.mm.br.d.b(ShakeItemListUI.this, "music", ".ui.MusicMainUI", paramAnonymousView);
            AppMethodBeat.o(28393);
            return;
            paramAnonymousAdapterView.field_insertBatch = 1;
            paramAnonymousAdapterView.drx = 1024;
            if (-1 == paramAnonymousView.db.update("shakeitem1", paramAnonymousAdapterView.convertTo(), "shakeItemID=? and insertBatch=?", new String[] { paramAnonymousAdapterView.field_shakeItemID, "2" })) {
              break;
            }
            paramAnonymousView.doNotify();
            break;
            label180:
            com.tencent.mm.ay.a.aGt();
            paramAnonymousView.putExtra("key_mode", 1);
            paramAnonymousView.putExtra("KGlobalShakeMusic", true);
            com.tencent.mm.ay.a.d(i.d(paramAnonymousAdapterView.field_lvbuffer, 0L));
          }
          label213:
          if (i == 11)
          {
            if (System.currentTimeMillis() - ShakeItemListUI.this.xzO > 2000L)
            {
              ShakeItemListUI.this.xzO = System.currentTimeMillis();
              if ((paramAnonymousAdapterView.field_reserved3 == null) || (paramAnonymousAdapterView.field_reserved3.split(",").length != 3) || (paramAnonymousAdapterView.field_reserved3.split(",")[0] == null) || (paramAnonymousAdapterView.field_reserved3.split(",")[0].equals(""))) {
                break label407;
              }
              paramAnonymousView = paramAnonymousAdapterView.field_reserved3.split(",");
              localObject = new ut();
              ((ut)localObject).dxt.userName = paramAnonymousView[0];
              ((ut)localObject).dxt.dxv = bs.bG(paramAnonymousView[1], "");
              ((ut)localObject).dxt.dxw = Integer.parseInt(paramAnonymousView[2]);
              ((ut)localObject).dxt.scene = 1077;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
            }
            for (;;)
            {
              if (ShakeItemListUI.d(ShakeItemListUI.this))
              {
                com.tencent.mm.plugin.shake.d.a.h.a(paramAnonymousAdapterView);
                com.tencent.mm.plugin.shake.d.a.h.b(paramAnonymousAdapterView);
              }
              AppMethodBeat.o(28393);
              return;
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.getCity());
              paramAnonymousView.putExtra("scene", 27);
              paramAnonymousView.putExtra("stastic_scene", 5);
              com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ai.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            }
          }
          label407:
          if (com.tencent.mm.plugin.shake.d.a.k.NN(i))
          {
            com.tencent.mm.plugin.shake.d.a.k.a(paramAnonymousAdapterView, ShakeItemListUI.this, true);
            AppMethodBeat.o(28393);
            return;
          }
          paramAnonymousView = paramAnonymousAdapterView.field_username;
          az.ayM();
          Object localObject = com.tencent.mm.model.c.awB().aNt(paramAnonymousView);
          ac.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramAnonymousView + " display:" + paramAnonymousAdapterView.field_nickname + " position:" + paramAnonymousInt + " contactName" + ((av)localObject).field_username);
          ac.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.n.b.ln(((av)localObject).field_type) + "  contact:" + localObject);
          if (com.tencent.mm.n.b.ln(((av)localObject).field_type))
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
                if (((com.tencent.mm.storage.ai)localObject).fad())
                {
                  com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, paramAnonymousAdapterView.field_username + "," + localIntent.getIntExtra("Contact_Scene", 23));
                  localIntent.putExtra("Contact_Scene", 23);
                }
                com.tencent.mm.plugin.shake.a.iyx.c(localIntent, ShakeItemListUI.this);
              }
              AppMethodBeat.o(28393);
              return;
            }
          }
          ac.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramAnonymousView + " display:" + paramAnonymousAdapterView.field_nickname + " position:" + paramAnonymousInt + " contactName" + ((av)localObject).field_username);
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
              com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, paramAnonymousAdapterView.field_username + "," + paramAnonymousView.getIntExtra("Contact_Scene", 23));
            }
            com.tencent.mm.plugin.shake.a.iyx.c(paramAnonymousView, ShakeItemListUI.this);
            AppMethodBeat.o(28393);
            return;
          }
        }
      });
      localObject = new com.tencent.mm.ui.tools.l(this);
      this.iNr.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(28394);
          if (paramAnonymousInt < ShakeItemListUI.c(ShakeItemListUI.this).getHeaderViewsCount())
          {
            ac.w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
            AppMethodBeat.o(28394);
            return true;
          }
          this.ntP.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeItemListUI.this, ShakeItemListUI.e(ShakeItemListUI.this));
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
    m.dDl().add(this.xzQ);
    this.xzQ.Xc();
    ac.i("MicroMsg.ShakeItemListUI", "onResume");
    AppMethodBeat.o(28410);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28412);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.id = ((com.tencent.mm.plugin.shake.b.d)this.xzQ.getItem(paramView.position)).field_shakeItemID;
    paramContextMenu.add(paramView.position, 0, 0, 2131755707);
    AppMethodBeat.o(28412);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28414);
    this.xzQ.cVi();
    a locala = this.xzQ;
    if (locala.iKs != null)
    {
      locala.iKs.detach();
      locala.iKs = null;
    }
    m.dDl().remove(this.xzQ);
    ac.i("MicroMsg.ShakeItemListUI", "onPause");
    if (this.hJM != null) {
      this.hJM.detach();
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
    this.xzQ.setShowType(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28415);
      return;
      if (this.ofC != null)
      {
        this.ofC.findViewById(2131304676).setVisibility(8);
        AppMethodBeat.o(28415);
        return;
        if (this.ofC != null) {
          this.ofC.findViewById(2131304676).setVisibility(0);
        }
      }
    }
  }
  
  final class a
    extends r<com.tencent.mm.plugin.shake.b.d>
  {
    private int cZX;
    com.tencent.mm.ui.applet.b iKs;
    private b.b iKt;
    
    public a(ShakeItemListUI paramShakeItemListUI)
    {
      super(new com.tencent.mm.plugin.shake.b.d());
      AppMethodBeat.i(28403);
      this.cZX = 0;
      this.iKt = null;
      this.iKs = new com.tencent.mm.ui.applet.b(new b.a()
      {
        public final Bitmap Go(String paramAnonymousString)
        {
          AppMethodBeat.i(28399);
          paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(28399);
          return paramAnonymousString;
        }
      });
      Xc();
      AppMethodBeat.o(28403);
    }
    
    public final void Xb()
    {
      AppMethodBeat.i(28406);
      if (!az.agM())
      {
        AppMethodBeat.o(28406);
        return;
      }
      switch (this.cZX)
      {
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        AppMethodBeat.o(28406);
        return;
        setCursor(m.dDl().dCR());
        continue;
        setCursor(m.dDl().dCT());
        continue;
        setCursor(m.dDl().dCS());
        continue;
        setCursor(m.dDl().dCU());
        continue;
        setCursor(m.dDl().dCV());
        continue;
        setCursor(m.dDl().dCW());
        continue;
        setCursor(m.dDl().dCX());
        continue;
        setCursor(m.dDl().dCY());
        continue;
        setCursor(m.dDl().NG(ShakeItemListUI.this.getIntent().getIntExtra("_ibeacon_new_insert_size", 2)));
      }
    }
    
    public final void Xc()
    {
      AppMethodBeat.i(28405);
      cVi();
      Xb();
      AppMethodBeat.o(28405);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(28404);
      if (this.iKt == null) {
        this.iKt = new b.b()
        {
          public final int aPz()
          {
            AppMethodBeat.i(28401);
            int i = ShakeItemListUI.a.this.getCount();
            AppMethodBeat.o(28401);
            return i;
          }
          
          public final String qN(int paramAnonymousInt)
          {
            AppMethodBeat.i(28400);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= ShakeItemListUI.a.this.getCount()))
            {
              ac.e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
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
      if (this.iKs != null) {
        this.iKs.a(paramInt, this.iKt);
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131495414, null);
        paramViewGroup.iKw = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.iIN = ((TextView)paramView.findViewById(2131302693));
        paramViewGroup.iKx = ((TextView)paramView.findViewById(2131302690));
        paramViewGroup.xzW = ((ImageView)paramView.findViewById(2131302695));
        paramViewGroup.vjW = ((TextView)paramView.findViewById(2131302688));
        paramViewGroup.vjX = ((TextView)paramView.findViewById(2131302696));
        paramViewGroup.vjY = ((ImageView)paramView.findViewById(2131302698));
        paramViewGroup.xzX = ((TextView)paramView.findViewById(2131304721));
        paramViewGroup.xzV = paramView.findViewById(2131304194);
        paramViewGroup.xzY = ((LinearLayout)paramView.findViewById(2131304681));
        paramViewGroup.xzZ = ((TextView)paramView.findViewById(2131304682));
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
      if ((4 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) || ((com.tencent.mm.plugin.shake.d.a.k.NN(((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)) && (6 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)))
      {
        if (4 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) {
          paramViewGroup.iKw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        e.a(paramViewGroup.iKw, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_sns_bgurl, 2131689584, false);
        paramViewGroup.iKw.setVisibility(0);
        if ((7 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (10 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (12 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (13 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && ((8 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) || (!bs.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname)) || (!bs.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username)))) {
          break label508;
        }
        if (8 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) {
          break label493;
        }
        paramViewGroup.xzZ.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
      }
      for (;;)
      {
        paramViewGroup.xzZ.setVisibility(0);
        paramViewGroup.xzY.setVisibility(8);
        AppMethodBeat.o(28404);
        return paramView;
        if (11 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
        {
          ShakeItemListUI.g(ShakeItemListUI.this).loadImage(((com.tencent.mm.plugin.shake.b.d)localObject1).getProvince(), paramViewGroup.iKw);
          break;
        }
        a.b.c(paramViewGroup.iKw, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
        break;
        label493:
        paramViewGroup.xzZ.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
      }
      label508:
      paramViewGroup.xzZ.setVisibility(8);
      paramViewGroup.xzY.setVisibility(0);
      if ((8 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (bs.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname)))
      {
        ((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname = ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance;
        ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance = ((com.tencent.mm.plugin.shake.b.d)localObject1).field_username;
      }
      Object localObject2 = bs.nullAsNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
      paramViewGroup.iIN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject2, paramViewGroup.iIN.getTextSize()));
      paramViewGroup.iIN.setVisibility(0);
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
          paramViewGroup.xzV.setVisibility(0);
          paramViewGroup.vjW.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
          paramViewGroup.vjW.setVisibility(0);
          if ((((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature == null) || (((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature.trim().equals("")))
          {
            paramViewGroup.vjX.setVisibility(8);
            label758:
            if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex != 1) {
              break label1059;
            }
            paramViewGroup.xzW.setVisibility(0);
            paramViewGroup.xzW.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690323));
            paramViewGroup.xzW.setContentDescription(this.context.getString(2131761078));
            label809:
            az.ayM();
            localObject2 = com.tencent.mm.model.c.awB().aNt(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
            if ((localObject2 == null) || (!com.tencent.mm.n.b.ln(((av)localObject2).field_type))) {
              break label1145;
            }
            paramViewGroup.iKx.setVisibility(0);
            if (!com.tencent.mm.storage.ai.YI(((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1)) {
              break label1125;
            }
            paramViewGroup.iKx.setText(this.context.getString(2131761502));
            label880:
            if (6 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
            {
              paramViewGroup.vjW.setText(this.context.getString(2131763562));
              paramViewGroup.iKx.setVisibility(8);
            }
            if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1 == 0) {
              break label1157;
            }
            paramViewGroup.vjY.setVisibility(0);
            localObject1 = BackwardSupportUtil.b.n(ar.a.hny.nR(((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1), 2.0F);
            paramViewGroup.vjY.setImageBitmap((Bitmap)localObject1);
            paramViewGroup.xzW.setVisibility(8);
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
        paramViewGroup.xzX.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
        paramViewGroup.xzX.setVisibility(0);
        AppMethodBeat.o(28404);
        return paramView;
        paramViewGroup.vjX.setVisibility(0);
        paramViewGroup.vjX.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature, paramViewGroup.iIN.getTextSize()));
        break label758;
        label1059:
        if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex == 2)
        {
          paramViewGroup.xzW.setVisibility(0);
          paramViewGroup.xzW.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131690322));
          paramViewGroup.xzW.setContentDescription(this.context.getString(2131759044));
          break label809;
        }
        paramViewGroup.xzW.setVisibility(8);
        break label809;
        label1125:
        paramViewGroup.iKx.setText(this.context.getString(2131761507));
        break label880;
        label1145:
        paramViewGroup.iKx.setVisibility(8);
        break label880;
        label1157:
        paramViewGroup.vjY.setVisibility(8);
      }
    }
    
    protected final void setShowType(int paramInt)
    {
      AppMethodBeat.i(28407);
      this.cZX = paramInt;
      Xc();
      AppMethodBeat.o(28407);
    }
    
    final class a
    {
      TextView iIN;
      ImageView iKw;
      TextView iKx;
      TextView vjW;
      TextView vjX;
      ImageView vjY;
      View xzV;
      ImageView xzW;
      TextView xzX;
      LinearLayout xzY;
      TextView xzZ;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(28402);
        if (this.iKw != null)
        {
          this.iKw.setImageDrawable(null);
          this.iKw.setVisibility(8);
        }
        if (this.iIN != null)
        {
          this.iIN.setText("");
          this.iIN.setVisibility(8);
        }
        if (this.iKx != null) {
          this.iKx.setVisibility(8);
        }
        if (this.xzW != null) {
          this.xzW.setVisibility(8);
        }
        if (this.vjW != null)
        {
          this.vjW.setText("");
          this.vjW.setVisibility(8);
        }
        if (this.vjX != null)
        {
          this.vjX.setVisibility(8);
          this.xzV.setVisibility(8);
        }
        if (this.vjY != null) {
          this.vjY.setVisibility(8);
        }
        if (this.xzX != null)
        {
          this.xzX.setText("");
          this.xzX.setVisibility(8);
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