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
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.i.1;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.q;

public class ShakeItemListUI
  extends MMActivity
{
  private int dcz;
  private com.tencent.mm.aw.a.a hjj;
  private int id;
  private ListView inl;
  private n.d mRw;
  private View nCB;
  public long wox;
  private boolean woy;
  private a woz;
  
  public ShakeItemListUI()
  {
    AppMethodBeat.i(28409);
    this.wox = 0L;
    this.woy = false;
    this.hjj = null;
    this.mRw = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28398);
        m.dpb().LH(ShakeItemListUI.f(ShakeItemListUI.this));
        AppMethodBeat.o(28398);
      }
    };
    AppMethodBeat.o(28409);
  }
  
  public static int LP(int paramInt)
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
    this.hjj = new com.tencent.mm.aw.a.a(this);
    az.arV();
    final int i = bt.a((Integer)com.tencent.mm.model.c.afk().get(12290, null), 0);
    this.dcz = getIntent().getIntExtra("_key_show_type_", 0);
    Object localObject = getIntent().getStringExtra("_key_title_");
    if (!bt.isNullOrNil((String)localObject)) {
      setMMTitle((String)localObject);
    }
    this.woy = getIntent().getBooleanExtra("_key_show_from_shake_", false);
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
              ShakeItemListUI.b(ShakeItemListUI.this).Wd();
              ShakeItemListUI.c(ShakeItemListUI.this).setVisibility(8);
              paramAnonymous2DialogInterface = (TextView)ShakeItemListUI.this.findViewById(2131302694);
              paramAnonymous2DialogInterface.setText(ShakeItemListUI.LP(ShakeItemListUI.a(ShakeItemListUI.this)));
              paramAnonymous2DialogInterface.setVisibility(0);
              ShakeItemListUI.this.enableOptionMenu(false);
              AppMethodBeat.o(28390);
              return;
              m.dpb().LI(0);
              m.dpb().doQ();
              continue;
              m.dpb().LI(0);
              continue;
              az.afE().ax(new i.1());
              m.dpb().LI(4);
              continue;
              m.dpb().LI(7);
              m.dpb().LI(6);
              m.dpb().LI(8);
              m.dpb().LI(9);
              m.dpb().LI(10);
              m.dpb().LI(12);
              continue;
              m.dpb().LI(11);
            }
          }
        }, null);
        AppMethodBeat.o(28391);
        return true;
      }
    });
    this.inl = ((ListView)findViewById(2131302692));
    this.nCB = getLayoutInflater().inflate(2131495415, null);
    this.nCB.findViewById(2131304676).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28392);
        ShakeItemListUI.a(ShakeItemListUI.this, ShakeItemListUI.a(ShakeItemListUI.this) ^ 0xFFFFFFFF);
        ShakeItemListUI.this.setShowType(ShakeItemListUI.a(ShakeItemListUI.this));
        AppMethodBeat.o(28392);
      }
    });
    this.inl.addFooterView(this.nCB);
    if (this.dcz == -1)
    {
      this.nCB.findViewById(2131304676).setVisibility(0);
      this.woz = new a(this);
      this.woz.setShowType(this.dcz);
      if (this.woz.getCount() > 0) {
        break label325;
      }
      this.inl.setVisibility(8);
      localObject = (TextView)findViewById(2131302694);
      ((TextView)localObject).setText(LP(this.dcz));
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
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(28396);
        }
      });
      this.inl.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(28397);
          if (ShakeItemListUI.b(ShakeItemListUI.this) != null)
          {
            paramAnonymousView = ShakeItemListUI.b(ShakeItemListUI.this);
            if (paramAnonymousView.ikl != null) {
              paramAnonymousView.ikl.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          AppMethodBeat.o(28397);
          return false;
        }
      });
      AppMethodBeat.o(28411);
      return;
      this.nCB.findViewById(2131304676).setVisibility(8);
      break;
      label325:
      this.inl.setAdapter(this.woz);
      this.inl.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
          paramAnonymousView = m.dpb();
          int i;
          if (paramAnonymousAdapterView == null)
          {
            ad.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
            i = paramAnonymousAdapterView.field_type;
            if (i != 4) {
              break label213;
            }
            paramAnonymousView = new Intent();
            if (!com.tencent.mm.az.e.azP()) {
              break label180;
            }
            com.tencent.mm.az.a.c(i.d(paramAnonymousAdapterView.field_lvbuffer, 0L));
          }
          for (;;)
          {
            paramAnonymousView.putExtra("key_scene", 3);
            com.tencent.mm.bs.d.b(ShakeItemListUI.this, "music", ".ui.MusicMainUI", paramAnonymousView);
            AppMethodBeat.o(28393);
            return;
            paramAnonymousAdapterView.field_insertBatch = 1;
            paramAnonymousAdapterView.dtM = 1024;
            if (-1 == paramAnonymousView.db.update("shakeitem1", paramAnonymousAdapterView.convertTo(), "shakeItemID=? and insertBatch=?", new String[] { paramAnonymousAdapterView.field_shakeItemID, "2" })) {
              break;
            }
            paramAnonymousView.doNotify();
            break;
            label180:
            com.tencent.mm.az.a.azD();
            paramAnonymousView.putExtra("key_mode", 1);
            paramAnonymousView.putExtra("KGlobalShakeMusic", true);
            com.tencent.mm.az.a.d(i.d(paramAnonymousAdapterView.field_lvbuffer, 0L));
          }
          label213:
          if (i == 11)
          {
            if (System.currentTimeMillis() - ShakeItemListUI.this.wox > 2000L)
            {
              ShakeItemListUI.this.wox = System.currentTimeMillis();
              if ((paramAnonymousAdapterView.field_reserved3 == null) || (paramAnonymousAdapterView.field_reserved3.split(",").length != 3) || (paramAnonymousAdapterView.field_reserved3.split(",")[0] == null) || (paramAnonymousAdapterView.field_reserved3.split(",")[0].equals(""))) {
                break label407;
              }
              paramAnonymousView = paramAnonymousAdapterView.field_reserved3.split(",");
              localObject = new uj();
              ((uj)localObject).dzH.userName = paramAnonymousView[0];
              ((uj)localObject).dzH.dzJ = bt.by(paramAnonymousView[1], "");
              ((uj)localObject).dzH.dzK = Integer.parseInt(paramAnonymousView[2]);
              ((uj)localObject).dzH.scene = 1077;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
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
              com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            }
          }
          label407:
          if (com.tencent.mm.plugin.shake.d.a.k.LN(i))
          {
            com.tencent.mm.plugin.shake.d.a.k.a(paramAnonymousAdapterView, ShakeItemListUI.this, true);
            AppMethodBeat.o(28393);
            return;
          }
          paramAnonymousView = paramAnonymousAdapterView.field_username;
          az.arV();
          Object localObject = com.tencent.mm.model.c.apM().aHY(paramAnonymousView);
          ad.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramAnonymousView + " display:" + paramAnonymousAdapterView.field_nickname + " position:" + paramAnonymousInt + " contactName" + ((au)localObject).field_username);
          ad.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.n.b.ls(((au)localObject).field_type) + "  contact:" + localObject);
          if (com.tencent.mm.n.b.ls(((au)localObject).field_type))
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
                if (((af)localObject).eKB())
                {
                  com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, paramAnonymousAdapterView.field_username + "," + localIntent.getIntExtra("Contact_Scene", 23));
                  localIntent.putExtra("Contact_Scene", 23);
                }
                com.tencent.mm.plugin.shake.a.hYt.c(localIntent, ShakeItemListUI.this);
              }
              AppMethodBeat.o(28393);
              return;
            }
          }
          ad.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramAnonymousView + " display:" + paramAnonymousAdapterView.field_nickname + " position:" + paramAnonymousInt + " contactName" + ((au)localObject).field_username);
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
              com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, paramAnonymousAdapterView.field_username + "," + paramAnonymousView.getIntExtra("Contact_Scene", 23));
            }
            com.tencent.mm.plugin.shake.a.hYt.c(paramAnonymousView, ShakeItemListUI.this);
            AppMethodBeat.o(28393);
            return;
          }
        }
      });
      localObject = new com.tencent.mm.ui.tools.l(this);
      this.inl.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
          this.mRz.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeItemListUI.this, ShakeItemListUI.e(ShakeItemListUI.this));
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
    m.dpb().add(this.woz);
    this.woz.We();
    ad.i("MicroMsg.ShakeItemListUI", "onResume");
    AppMethodBeat.o(28410);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28412);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.id = ((com.tencent.mm.plugin.shake.b.d)this.woz.getItem(paramView.position)).field_shakeItemID;
    paramContextMenu.add(paramView.position, 0, 0, 2131755707);
    AppMethodBeat.o(28412);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28414);
    this.woz.cHX();
    a locala = this.woz;
    if (locala.ikl != null)
    {
      locala.ikl.detach();
      locala.ikl = null;
    }
    m.dpb().remove(this.woz);
    ad.i("MicroMsg.ShakeItemListUI", "onPause");
    if (this.hjj != null) {
      this.hjj.detach();
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
    this.woz.setShowType(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28415);
      return;
      if (this.nCB != null)
      {
        this.nCB.findViewById(2131304676).setVisibility(8);
        AppMethodBeat.o(28415);
        return;
        if (this.nCB != null) {
          this.nCB.findViewById(2131304676).setVisibility(0);
        }
      }
    }
  }
  
  final class a
    extends q<com.tencent.mm.plugin.shake.b.d>
  {
    private int dcz;
    com.tencent.mm.ui.applet.b ikl;
    private b.b ikm;
    
    public a(ShakeItemListUI paramShakeItemListUI)
    {
      super(new com.tencent.mm.plugin.shake.b.d());
      AppMethodBeat.i(28403);
      this.dcz = 0;
      this.ikm = null;
      this.ikl = new com.tencent.mm.ui.applet.b(new b.a()
      {
        public final Bitmap Cl(String paramAnonymousString)
        {
          AppMethodBeat.i(28399);
          paramAnonymousString = com.tencent.mm.ak.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(28399);
          return paramAnonymousString;
        }
      });
      We();
      AppMethodBeat.o(28403);
    }
    
    public final void Wd()
    {
      AppMethodBeat.i(28406);
      if (!az.afw())
      {
        AppMethodBeat.o(28406);
        return;
      }
      switch (this.dcz)
      {
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        AppMethodBeat.o(28406);
        return;
        setCursor(m.dpb().doH());
        continue;
        setCursor(m.dpb().doJ());
        continue;
        setCursor(m.dpb().doI());
        continue;
        setCursor(m.dpb().doK());
        continue;
        setCursor(m.dpb().doL());
        continue;
        setCursor(m.dpb().doM());
        continue;
        setCursor(m.dpb().doN());
        continue;
        setCursor(m.dpb().doO());
        continue;
        setCursor(m.dpb().LG(ShakeItemListUI.this.getIntent().getIntExtra("_ibeacon_new_insert_size", 2)));
      }
    }
    
    public final void We()
    {
      AppMethodBeat.i(28405);
      cHX();
      Wd();
      AppMethodBeat.o(28405);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(28404);
      if (this.ikm == null) {
        this.ikm = new b.b()
        {
          public final int aII()
          {
            AppMethodBeat.i(28401);
            int i = ShakeItemListUI.a.this.getCount();
            AppMethodBeat.o(28401);
            return i;
          }
          
          public final String qa(int paramAnonymousInt)
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
      if (this.ikl != null) {
        this.ikl.a(paramInt, this.ikm);
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131495414, null);
        paramViewGroup.ikp = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.iiF = ((TextView)paramView.findViewById(2131302693));
        paramViewGroup.ikq = ((TextView)paramView.findViewById(2131302690));
        paramViewGroup.woF = ((ImageView)paramView.findViewById(2131302695));
        paramViewGroup.uaX = ((TextView)paramView.findViewById(2131302688));
        paramViewGroup.uaY = ((TextView)paramView.findViewById(2131302696));
        paramViewGroup.uaZ = ((ImageView)paramView.findViewById(2131302698));
        paramViewGroup.woG = ((TextView)paramView.findViewById(2131304721));
        paramViewGroup.woE = paramView.findViewById(2131304194);
        paramViewGroup.woH = ((LinearLayout)paramView.findViewById(2131304681));
        paramViewGroup.woI = ((TextView)paramView.findViewById(2131304682));
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
      if ((4 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) || ((com.tencent.mm.plugin.shake.d.a.k.LN(((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)) && (6 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)))
      {
        if (4 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) {
          paramViewGroup.ikp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        e.a(paramViewGroup.ikp, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_sns_bgurl, 2131689584, false);
        paramViewGroup.ikp.setVisibility(0);
        if ((7 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (10 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (12 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (13 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && ((8 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) || (!bt.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname)) || (!bt.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username)))) {
          break label508;
        }
        if (8 != ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) {
          break label493;
        }
        paramViewGroup.woI.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
      }
      for (;;)
      {
        paramViewGroup.woI.setVisibility(0);
        paramViewGroup.woH.setVisibility(8);
        AppMethodBeat.o(28404);
        return paramView;
        if (11 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
        {
          ShakeItemListUI.g(ShakeItemListUI.this).loadImage(((com.tencent.mm.plugin.shake.b.d)localObject1).getProvince(), paramViewGroup.ikp);
          break;
        }
        a.b.c(paramViewGroup.ikp, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
        break;
        label493:
        paramViewGroup.woI.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
      }
      label508:
      paramViewGroup.woI.setVisibility(8);
      paramViewGroup.woH.setVisibility(0);
      if ((8 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type) && (bt.isNullOrNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname)))
      {
        ((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname = ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance;
        ((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance = ((com.tencent.mm.plugin.shake.b.d)localObject1).field_username;
      }
      Object localObject2 = bt.nullAsNil(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
      paramViewGroup.iiF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, (CharSequence)localObject2, paramViewGroup.iiF.getTextSize()));
      paramViewGroup.iiF.setVisibility(0);
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingLeft();
      if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_insertBatch == 2)
      {
        paramView.setBackgroundDrawable(com.tencent.mm.cd.a.l(this.context, 2131231817));
        paramView.setPadding(k, i, j, paramInt);
        switch (((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
        {
        default: 
          paramViewGroup.woE.setVisibility(0);
          paramViewGroup.uaX.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_distance);
          paramViewGroup.uaX.setVisibility(0);
          if ((((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature == null) || (((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature.trim().equals("")))
          {
            paramViewGroup.uaY.setVisibility(8);
            label758:
            if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex != 1) {
              break label1059;
            }
            paramViewGroup.woF.setVisibility(0);
            paramViewGroup.woF.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131690323));
            paramViewGroup.woF.setContentDescription(this.context.getString(2131761078));
            label809:
            az.arV();
            localObject2 = com.tencent.mm.model.c.apM().aHY(((com.tencent.mm.plugin.shake.b.d)localObject1).field_username);
            if ((localObject2 == null) || (!com.tencent.mm.n.b.ls(((au)localObject2).field_type))) {
              break label1145;
            }
            paramViewGroup.ikq.setVisibility(0);
            if (!af.Wy(((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1)) {
              break label1125;
            }
            paramViewGroup.ikq.setText(this.context.getString(2131761502));
            label880:
            if (6 == ((com.tencent.mm.plugin.shake.b.d)localObject1).field_type)
            {
              paramViewGroup.uaX.setText(this.context.getString(2131763562));
              paramViewGroup.ikq.setVisibility(8);
            }
            if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1 == 0) {
              break label1157;
            }
            paramViewGroup.uaZ.setVisibility(0);
            localObject1 = BackwardSupportUtil.b.n(ar.a.gMY.nd(((com.tencent.mm.plugin.shake.b.d)localObject1).field_reserved1), 2.0F);
            paramViewGroup.uaZ.setImageBitmap((Bitmap)localObject1);
            paramViewGroup.woF.setVisibility(8);
          }
          break;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(28404);
        return paramView;
        paramView.setBackgroundDrawable(com.tencent.mm.cd.a.l(this.context, 2131231818));
        break;
        paramViewGroup.woG.setText(((com.tencent.mm.plugin.shake.b.d)localObject1).field_nickname);
        paramViewGroup.woG.setVisibility(0);
        AppMethodBeat.o(28404);
        return paramView;
        paramViewGroup.uaY.setVisibility(0);
        paramViewGroup.uaY.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, ((com.tencent.mm.plugin.shake.b.d)localObject1).field_signature, paramViewGroup.iiF.getTextSize()));
        break label758;
        label1059:
        if (((com.tencent.mm.plugin.shake.b.d)localObject1).field_sex == 2)
        {
          paramViewGroup.woF.setVisibility(0);
          paramViewGroup.woF.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131690322));
          paramViewGroup.woF.setContentDescription(this.context.getString(2131759044));
          break label809;
        }
        paramViewGroup.woF.setVisibility(8);
        break label809;
        label1125:
        paramViewGroup.ikq.setText(this.context.getString(2131761507));
        break label880;
        label1145:
        paramViewGroup.ikq.setVisibility(8);
        break label880;
        label1157:
        paramViewGroup.uaZ.setVisibility(8);
      }
    }
    
    protected final void setShowType(int paramInt)
    {
      AppMethodBeat.i(28407);
      this.dcz = paramInt;
      We();
      AppMethodBeat.o(28407);
    }
    
    final class a
    {
      TextView iiF;
      ImageView ikp;
      TextView ikq;
      TextView uaX;
      TextView uaY;
      ImageView uaZ;
      View woE;
      ImageView woF;
      TextView woG;
      LinearLayout woH;
      TextView woI;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(28402);
        if (this.ikp != null)
        {
          this.ikp.setImageDrawable(null);
          this.ikp.setVisibility(8);
        }
        if (this.iiF != null)
        {
          this.iiF.setText("");
          this.iiF.setVisibility(8);
        }
        if (this.ikq != null) {
          this.ikq.setVisibility(8);
        }
        if (this.woF != null) {
          this.woF.setVisibility(8);
        }
        if (this.uaX != null)
        {
          this.uaX.setText("");
          this.uaX.setVisibility(8);
        }
        if (this.uaY != null)
        {
          this.uaY.setVisibility(8);
          this.woE.setVisibility(8);
        }
        if (this.uaZ != null) {
          this.uaZ.setVisibility(8);
        }
        if (this.woG != null)
        {
          this.woG.setText("");
          this.woG.setVisibility(8);
        }
        AppMethodBeat.o(28402);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI
 * JD-Core Version:    0.7.0.1
 */