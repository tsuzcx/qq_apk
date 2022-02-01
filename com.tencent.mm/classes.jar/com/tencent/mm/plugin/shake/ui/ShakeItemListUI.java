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
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.i.1;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
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
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.s;

public class ShakeItemListUI
  extends MMActivity
{
  public long DjA;
  private boolean DjB;
  private a DjC;
  private int dDG;
  private int id;
  private com.tencent.mm.av.a.a jaq;
  private ListView khv;
  private o.g plk;
  private View qdl;
  
  public ShakeItemListUI()
  {
    AppMethodBeat.i(28409);
    this.DjA = 0L;
    this.DjB = false;
    this.jaq = null;
    this.plk = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28398);
        com.tencent.mm.plugin.shake.b.m.eUm().Xu(ShakeItemListUI.f(ShakeItemListUI.this));
        AppMethodBeat.o(28398);
      }
    };
    AppMethodBeat.o(28409);
  }
  
  public static int XC(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 0: 
    default: 
      return 2131765747;
    case 100: 
      return 2131765751;
    case -5: 
    case 4: 
      return 2131765781;
    case -6: 
    case 5: 
      return 2131765821;
    }
    return 2131765754;
  }
  
  public int getLayoutId()
  {
    return 2131496281;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28411);
    this.jaq = new com.tencent.mm.av.a.a(this);
    bg.aVF();
    final int i = Util.nullAs((Integer)com.tencent.mm.model.c.azQ().get(12290, null), 0);
    this.dDG = getIntent().getIntExtra("_key_show_type_", 0);
    Object localObject = getIntent().getStringExtra("_key_title_");
    if (!Util.isNullOrNil((String)localObject)) {
      setMMTitle((String)localObject);
    }
    this.DjB = getIntent().getBooleanExtra("_key_show_from_shake_", false);
    addTextOptionMenu(0, getString(2131755764), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28391);
        com.tencent.mm.ui.base.h.a(ShakeItemListUI.this, true, ShakeItemListUI.this.getString(2131764874), "", ShakeItemListUI.this.getString(2131755764), ShakeItemListUI.this.getString(2131755761), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28390);
            switch (ShakeItemListUI.a(ShakeItemListUI.this))
            {
            }
            for (;;)
            {
              ShakeItemListUI.b(ShakeItemListUI.this).anp();
              ShakeItemListUI.c(ShakeItemListUI.this).setVisibility(8);
              paramAnonymous2DialogInterface = (TextView)ShakeItemListUI.this.findViewById(2131305248);
              paramAnonymous2DialogInterface.setText(ShakeItemListUI.XC(ShakeItemListUI.a(ShakeItemListUI.this)));
              paramAnonymous2DialogInterface.setVisibility(0);
              ShakeItemListUI.this.enableOptionMenu(false);
              AppMethodBeat.o(28390);
              return;
              com.tencent.mm.plugin.shake.b.m.eUm().Xv(0);
              com.tencent.mm.plugin.shake.b.m.eUm().eUb();
              continue;
              com.tencent.mm.plugin.shake.b.m.eUm().Xv(0);
              continue;
              bg.aAk().postToWorker(new i.1());
              com.tencent.mm.plugin.shake.b.m.eUm().Xv(4);
              continue;
              com.tencent.mm.plugin.shake.b.m.eUm().Xv(7);
              com.tencent.mm.plugin.shake.b.m.eUm().Xv(6);
              com.tencent.mm.plugin.shake.b.m.eUm().Xv(8);
              com.tencent.mm.plugin.shake.b.m.eUm().Xv(9);
              com.tencent.mm.plugin.shake.b.m.eUm().Xv(10);
              com.tencent.mm.plugin.shake.b.m.eUm().Xv(12);
              continue;
              com.tencent.mm.plugin.shake.b.m.eUm().Xv(11);
            }
          }
        }, null);
        AppMethodBeat.o(28391);
        return true;
      }
    });
    this.khv = ((ListView)findViewById(2131305246));
    this.qdl = getLayoutInflater().inflate(2131496283, null);
    this.qdl.findViewById(2131307732).setOnClickListener(new ShakeItemListUI.2(this));
    this.khv.addFooterView(this.qdl);
    if (this.dDG == -1)
    {
      this.qdl.findViewById(2131307732).setVisibility(0);
      this.DjC = new a(this);
      this.DjC.setShowType(this.dDG);
      if (this.DjC.getCount() > 0) {
        break label325;
      }
      this.khv.setVisibility(8);
      localObject = (TextView)findViewById(2131305248);
      ((TextView)localObject).setText(XC(this.dDG));
      ((TextView)localObject).setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      setBackBtn(new ShakeItemListUI.5(this));
      setToTop(new ShakeItemListUI.6(this));
      this.khv.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(28397);
          if (ShakeItemListUI.b(ShakeItemListUI.this) != null)
          {
            paramAnonymousView = ShakeItemListUI.b(ShakeItemListUI.this);
            if (paramAnonymousView.kex != null) {
              paramAnonymousView.kex.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          AppMethodBeat.o(28397);
          return false;
        }
      });
      AppMethodBeat.o(28411);
      return;
      this.qdl.findViewById(2131307732).setVisibility(8);
      break;
      label325:
      this.khv.setAdapter(this.DjC);
      this.khv.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(28393);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousAdapterView = (d)ShakeItemListUI.b(ShakeItemListUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
          }
          paramAnonymousView = com.tencent.mm.plugin.shake.b.m.eUm();
          int i;
          if (paramAnonymousAdapterView == null)
          {
            Log.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
            i = paramAnonymousAdapterView.field_type;
            if (i != 4) {
              break label288;
            }
            paramAnonymousView = new Intent();
            if (!com.tencent.mm.ay.e.bem()) {
              break label255;
            }
            com.tencent.mm.ay.a.c(i.e(paramAnonymousAdapterView.field_lvbuffer, 0L));
          }
          for (;;)
          {
            paramAnonymousView.putExtra("key_scene", 3);
            com.tencent.mm.br.c.b(ShakeItemListUI.this, "music", ".ui.MusicMainUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
            paramAnonymousAdapterView.field_insertBatch = 1;
            paramAnonymousAdapterView.cSx = 1024;
            if (-1 == paramAnonymousView.db.update("shakeitem1", paramAnonymousAdapterView.convertTo(), "shakeItemID=? and insertBatch=?", new String[] { paramAnonymousAdapterView.field_shakeItemID, "2" })) {
              break;
            }
            paramAnonymousView.doNotify();
            break;
            label255:
            com.tencent.mm.ay.a.bea();
            paramAnonymousView.putExtra("key_mode", 1);
            paramAnonymousView.putExtra("KGlobalShakeMusic", true);
            com.tencent.mm.ay.a.d(i.e(paramAnonymousAdapterView.field_lvbuffer, 0L));
          }
          label288:
          if (i == 11)
          {
            if (System.currentTimeMillis() - ShakeItemListUI.this.DjA > 2000L)
            {
              ShakeItemListUI.this.DjA = System.currentTimeMillis();
              if ((paramAnonymousAdapterView.field_reserved3 == null) || (paramAnonymousAdapterView.field_reserved3.split(",").length != 3) || (paramAnonymousAdapterView.field_reserved3.split(",")[0] == null) || (paramAnonymousAdapterView.field_reserved3.split(",")[0].equals(""))) {
                break label494;
              }
              paramAnonymousView = paramAnonymousAdapterView.field_reserved3.split(",");
              localObject = new wq();
              ((wq)localObject).ecI.userName = paramAnonymousView[0];
              ((wq)localObject).ecI.ecK = Util.nullAs(paramAnonymousView[1], "");
              ((wq)localObject).ecI.ecL = Integer.parseInt(paramAnonymousView[2]);
              ((wq)localObject).ecI.scene = 1077;
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
              com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            }
          }
          if (k.XA(i))
          {
            k.a(paramAnonymousAdapterView, ShakeItemListUI.this, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
          }
          paramAnonymousView = paramAnonymousAdapterView.field_username;
          bg.aVF();
          localObject = com.tencent.mm.model.c.aSN().Kn(paramAnonymousView);
          Log.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramAnonymousView + " display:" + paramAnonymousAdapterView.field_nickname + " position:" + paramAnonymousInt + " contactName" + ((ax)localObject).field_username);
          Log.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.contact.c.oR(((ax)localObject).field_type) + "  contact:" + localObject);
          if (com.tencent.mm.contact.c.oR(((ax)localObject).field_type))
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
                if (((as)localObject).gBM())
                {
                  com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, paramAnonymousAdapterView.field_username + "," + localIntent.getIntExtra("Contact_Scene", 23));
                  localIntent.putExtra("Contact_Scene", 23);
                }
                com.tencent.mm.plugin.shake.a.jRt.c(localIntent, ShakeItemListUI.this);
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
              com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, paramAnonymousAdapterView.field_username + "," + paramAnonymousView.getIntExtra("Contact_Scene", 23));
            }
            com.tencent.mm.plugin.shake.a.jRt.c(paramAnonymousView, ShakeItemListUI.this);
            break;
          }
        }
      });
      localObject = new com.tencent.mm.ui.tools.l(this);
      this.khv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
          this.pln.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeItemListUI.this, ShakeItemListUI.e(ShakeItemListUI.this));
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
    com.tencent.mm.plugin.shake.b.m.eUm().add(this.DjC);
    this.DjC.anq();
    Log.i("MicroMsg.ShakeItemListUI", "onResume");
    AppMethodBeat.o(28410);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28412);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.id = ((d)this.DjC.getItem(paramView.position)).field_shakeItemID;
    paramContextMenu.add(paramView.position, 0, 0, 2131755778);
    AppMethodBeat.o(28412);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28414);
    this.DjC.ebf();
    a locala = this.DjC;
    if (locala.kex != null)
    {
      locala.kex.detach();
      locala.kex = null;
    }
    com.tencent.mm.plugin.shake.b.m.eUm().remove(this.DjC);
    Log.i("MicroMsg.ShakeItemListUI", "onPause");
    if (this.jaq != null) {
      this.jaq.detach();
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
    this.DjC.setShowType(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28415);
      return;
      if (this.qdl != null)
      {
        this.qdl.findViewById(2131307732).setVisibility(8);
        AppMethodBeat.o(28415);
        return;
        if (this.qdl != null) {
          this.qdl.findViewById(2131307732).setVisibility(0);
        }
      }
    }
  }
  
  final class a
    extends s<d>
  {
    private int dDG;
    com.tencent.mm.ui.applet.b kex;
    private b.b kez;
    
    public a(ShakeItemListUI paramShakeItemListUI)
    {
      super(new d());
      AppMethodBeat.i(28403);
      this.dDG = 0;
      this.kez = null;
      this.kex = new com.tencent.mm.ui.applet.b(new b.a()
      {
        public final Bitmap Ta(String paramAnonymousString)
        {
          AppMethodBeat.i(28399);
          paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(28399);
          return paramAnonymousString;
        }
      });
      anq();
      AppMethodBeat.o(28403);
    }
    
    public final void anp()
    {
      AppMethodBeat.i(28406);
      if (!bg.aAc())
      {
        AppMethodBeat.o(28406);
        return;
      }
      switch (this.dDG)
      {
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        AppMethodBeat.o(28406);
        return;
        setCursor(com.tencent.mm.plugin.shake.b.m.eUm().eTS());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.eUm().eTU());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.eUm().eTT());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.eUm().eTV());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.eUm().eTW());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.eUm().eTX());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.eUm().eTY());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.eUm().eTZ());
        continue;
        setCursor(com.tencent.mm.plugin.shake.b.m.eUm().Xt(ShakeItemListUI.this.getIntent().getIntExtra("_ibeacon_new_insert_size", 2)));
      }
    }
    
    public final void anq()
    {
      AppMethodBeat.i(28405);
      ebf();
      anp();
      AppMethodBeat.o(28405);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(28404);
      if (this.kez == null) {
        this.kez = new b.b()
        {
          public final int bnW()
          {
            AppMethodBeat.i(28401);
            int i = ShakeItemListUI.a.this.getCount();
            AppMethodBeat.o(28401);
            return i;
          }
          
          public final String vg(int paramAnonymousInt)
          {
            AppMethodBeat.i(28400);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= ShakeItemListUI.a.this.getCount()))
            {
              Log.e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
              AppMethodBeat.o(28400);
              return null;
            }
            Object localObject = (d)ShakeItemListUI.a.this.getItem(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(28400);
              return null;
            }
            localObject = ((d)localObject).field_username;
            AppMethodBeat.o(28400);
            return localObject;
          }
        };
      }
      if (this.kex != null) {
        this.kex.a(paramInt, this.kez);
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131496282, null);
        paramViewGroup.keC = ((ImageView)paramView.findViewById(2131305241));
        paramViewGroup.kcS = ((TextView)paramView.findViewById(2131305247));
        paramViewGroup.keD = ((TextView)paramView.findViewById(2131305244));
        paramViewGroup.DjI = ((ImageView)paramView.findViewById(2131305249));
        paramViewGroup.uSG = ((TextView)paramView.findViewById(2131305242));
        paramViewGroup.uSH = ((TextView)paramView.findViewById(2131305250));
        paramViewGroup.uSI = ((ImageView)paramView.findViewById(2131305252));
        paramViewGroup.DjJ = ((TextView)paramView.findViewById(2131307778));
        paramViewGroup.DjH = paramView.findViewById(2131307107);
        paramViewGroup.DjK = ((LinearLayout)paramView.findViewById(2131307737));
        paramViewGroup.DjL = ((TextView)paramView.findViewById(2131307738));
        paramView.setTag(paramViewGroup);
      }
      Object localObject1;
      for (;;)
      {
        localObject1 = (d)getItem(paramInt);
        if (localObject1 != null) {
          break;
        }
        paramViewGroup.clear();
        AppMethodBeat.o(28404);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.clear();
      if ((4 == ((d)localObject1).field_type) || ((k.XA(((d)localObject1).field_type)) && (6 != ((d)localObject1).field_type)))
      {
        if (4 != ((d)localObject1).field_type) {
          paramViewGroup.keC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        e.a(paramViewGroup.keC, ((d)localObject1).field_sns_bgurl, 2131689587, false);
        paramViewGroup.keC.setVisibility(0);
        if ((7 != ((d)localObject1).field_type) && (10 != ((d)localObject1).field_type) && (12 != ((d)localObject1).field_type) && (13 != ((d)localObject1).field_type) && ((8 != ((d)localObject1).field_type) || (!Util.isNullOrNil(((d)localObject1).field_nickname)) || (!Util.isNullOrNil(((d)localObject1).field_username)))) {
          break label508;
        }
        if (8 != ((d)localObject1).field_type) {
          break label493;
        }
        paramViewGroup.DjL.setText(((d)localObject1).field_distance);
      }
      for (;;)
      {
        paramViewGroup.DjL.setVisibility(0);
        paramViewGroup.DjK.setVisibility(8);
        AppMethodBeat.o(28404);
        return paramView;
        if (11 == ((d)localObject1).field_type)
        {
          ShakeItemListUI.g(ShakeItemListUI.this).loadImage(((d)localObject1).getProvince(), paramViewGroup.keC);
          break;
        }
        a.b.c(paramViewGroup.keC, ((d)localObject1).field_username);
        break;
        label493:
        paramViewGroup.DjL.setText(((d)localObject1).field_nickname);
      }
      label508:
      paramViewGroup.DjL.setVisibility(8);
      paramViewGroup.DjK.setVisibility(0);
      if ((8 == ((d)localObject1).field_type) && (Util.isNullOrNil(((d)localObject1).field_nickname)))
      {
        ((d)localObject1).field_nickname = ((d)localObject1).field_distance;
        ((d)localObject1).field_distance = ((d)localObject1).field_username;
      }
      Object localObject2 = Util.nullAsNil(((d)localObject1).field_nickname);
      paramViewGroup.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, (CharSequence)localObject2, paramViewGroup.kcS.getTextSize()));
      paramViewGroup.kcS.setVisibility(0);
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingLeft();
      if (((d)localObject1).field_insertBatch == 2)
      {
        paramView.setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, 2131231897));
        paramView.setPadding(k, i, j, paramInt);
        switch (((d)localObject1).field_type)
        {
        default: 
          paramViewGroup.DjH.setVisibility(0);
          paramViewGroup.uSG.setText(((d)localObject1).field_distance);
          paramViewGroup.uSG.setVisibility(0);
          if ((((d)localObject1).field_signature == null) || (((d)localObject1).field_signature.trim().equals("")))
          {
            paramViewGroup.uSH.setVisibility(8);
            label758:
            if (((d)localObject1).field_sex != 1) {
              break label1059;
            }
            paramViewGroup.DjI.setVisibility(0);
            paramViewGroup.DjI.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690428));
            paramViewGroup.DjI.setContentDescription(this.context.getString(2131762865));
            label809:
            bg.aVF();
            localObject2 = com.tencent.mm.model.c.aSN().Kn(((d)localObject1).field_username);
            if ((localObject2 == null) || (!com.tencent.mm.contact.c.oR(((ax)localObject2).field_type))) {
              break label1145;
            }
            paramViewGroup.keD.setVisibility(0);
            if (!as.akh(((d)localObject1).field_reserved1)) {
              break label1125;
            }
            paramViewGroup.keD.setText(this.context.getString(2131763444));
            label880:
            if (6 == ((d)localObject1).field_type)
            {
              paramViewGroup.uSG.setText(this.context.getString(2131765750));
              paramViewGroup.keD.setVisibility(8);
            }
            if (((d)localObject1).field_reserved1 == 0) {
              break label1157;
            }
            paramViewGroup.uSI.setVisibility(0);
            localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.iDs.rV(((d)localObject1).field_reserved1), 2.0F);
            paramViewGroup.uSI.setImageBitmap((Bitmap)localObject1);
            paramViewGroup.DjI.setVisibility(8);
          }
          break;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(28404);
        return paramView;
        paramView.setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, 2131231898));
        break;
        paramViewGroup.DjJ.setText(((d)localObject1).field_nickname);
        paramViewGroup.DjJ.setVisibility(0);
        AppMethodBeat.o(28404);
        return paramView;
        paramViewGroup.uSH.setVisibility(0);
        paramViewGroup.uSH.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, ((d)localObject1).field_signature, paramViewGroup.kcS.getTextSize()));
        break label758;
        label1059:
        if (((d)localObject1).field_sex == 2)
        {
          paramViewGroup.DjI.setVisibility(0);
          paramViewGroup.DjI.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131690427));
          paramViewGroup.DjI.setContentDescription(this.context.getString(2131759372));
          break label809;
        }
        paramViewGroup.DjI.setVisibility(8);
        break label809;
        label1125:
        paramViewGroup.keD.setText(this.context.getString(2131763449));
        break label880;
        label1145:
        paramViewGroup.keD.setVisibility(8);
        break label880;
        label1157:
        paramViewGroup.uSI.setVisibility(8);
      }
    }
    
    protected final void setShowType(int paramInt)
    {
      AppMethodBeat.i(28407);
      this.dDG = paramInt;
      anq();
      AppMethodBeat.o(28407);
    }
    
    final class a
    {
      View DjH;
      ImageView DjI;
      TextView DjJ;
      LinearLayout DjK;
      TextView DjL;
      TextView kcS;
      ImageView keC;
      TextView keD;
      TextView uSG;
      TextView uSH;
      ImageView uSI;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(28402);
        if (this.keC != null)
        {
          this.keC.setImageDrawable(null);
          this.keC.setVisibility(8);
        }
        if (this.kcS != null)
        {
          this.kcS.setText("");
          this.kcS.setVisibility(8);
        }
        if (this.keD != null) {
          this.keD.setVisibility(8);
        }
        if (this.DjI != null) {
          this.DjI.setVisibility(8);
        }
        if (this.uSG != null)
        {
          this.uSG.setText("");
          this.uSG.setVisibility(8);
        }
        if (this.uSH != null)
        {
          this.uSH.setVisibility(8);
          this.DjH.setVisibility(8);
        }
        if (this.uSI != null) {
          this.uSI.setVisibility(8);
        }
        if (this.DjJ != null)
        {
          this.DjJ.setText("");
          this.DjJ.setVisibility(8);
        }
        AppMethodBeat.o(28402);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI
 * JD-Core Version:    0.7.0.1
 */