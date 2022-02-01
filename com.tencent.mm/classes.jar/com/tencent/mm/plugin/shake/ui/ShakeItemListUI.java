package com.tencent.mm.plugin.shake.ui;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.mz;
import com.tencent.mm.aw.f;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.c.a.j;
import com.tencent.mm.plugin.shake.c.a.l.1;
import com.tencent.mm.plugin.shake.c.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.dlk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.x;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShakeItemListUI
  extends MMActivity
{
  public long PBZ;
  private boolean PCa;
  private a PCb;
  private int hAN;
  private int id;
  private com.tencent.mm.modelimage.loader.a oJu;
  private ListView pVC;
  private View uiF;
  private u.i vzr;
  
  public ShakeItemListUI()
  {
    AppMethodBeat.i(28409);
    this.PBZ = 0L;
    this.PCa = false;
    this.oJu = null;
    this.vzr = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28398);
        com.tencent.mm.plugin.shake.model.m.gXd().aja(ShakeItemListUI.f(ShakeItemListUI.this));
        AppMethodBeat.o(28398);
      }
    };
    AppMethodBeat.o(28409);
  }
  
  public static int aji(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return R.l.gVl;
    case 100: 
      return R.l.gVo;
    case -1: 
    case 0: 
      return R.l.gVl;
    case -5: 
    case 4: 
      return R.l.gVF;
    case -6: 
    case 5: 
      return R.l.gVQ;
    }
    return R.l.gVr;
  }
  
  private void c(com.tencent.mm.plugin.shake.model.d paramd)
  {
    AppMethodBeat.i(273590);
    Object localObject1 = com.tencent.mm.plugin.shake.a.PyM;
    com.tencent.mm.plugin.shake.a.a(103, null);
    localObject1 = new dlk();
    Object localObject2;
    try
    {
      ((dlk)localObject1).parseFrom(paramd.field_lvbuffer);
      if ((((dlk)localObject1).aaRA != null) && (((dlk)localObject1).aaRA.size() == 1))
      {
        paramd = (dli)((dlk)localObject1).aaRA.get(0);
        localObject1 = com.tencent.mm.plugin.shake.c.a.l.a(paramd);
        localObject2 = new Intent();
        if (paramd.ZTB != null)
        {
          com.tencent.mm.aw.a.d((f)localObject1);
          ((Intent)localObject2).putExtra("key_copyright", true);
        }
        for (;;)
        {
          ((Intent)localObject2).putExtra("key_offset", ((f)localObject1).oOw);
          ((Intent)localObject2).putExtra("key_pure", paramd.aaRw);
          ((Intent)localObject2).putExtra("key_byuser", paramd.type);
          ((Intent)localObject2).putExtra("key_history", true);
          com.tencent.mm.br.c.b(getContext(), "mv", ".ui.shake.MusicMainUINew", (Intent)localObject2);
          AppMethodBeat.o(273590);
          return;
          com.tencent.mm.aw.a.d((f)localObject1);
        }
      }
      if (((dlk)localObject1).aaRA == null) {
        break label358;
      }
    }
    catch (Exception paramd)
    {
      Log.printErrStackTrace("MicroMsg.ShakeItemListUI", paramd, "catch Exception in NewShake History", new Object[0]);
      AppMethodBeat.o(273590);
      return;
    }
    ArrayList localArrayList;
    int i;
    if (((dlk)localObject1).aaRA.size() > 1)
    {
      paramd = (dli)((dlk)localObject1).aaRA.get(0);
      localObject2 = com.tencent.mm.plugin.shake.c.a.l.a(paramd);
      com.tencent.mm.aw.a.d((f)localObject2);
      localArrayList = new ArrayList();
      i = 1;
    }
    for (;;)
    {
      if (i < ((dlk)localObject1).aaRA.size())
      {
        f localf = com.tencent.mm.plugin.shake.c.a.l.a((dli)((dlk)localObject1).aaRA.get(i));
        if (localObject2 != null) {
          localArrayList.add(localf);
        }
      }
      else
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_offset", ((f)localObject2).oOw);
        ((Intent)localObject1).putExtra("key_pure", paramd.aaRw);
        ((Intent)localObject1).putExtra("key_recommend_list", (Serializable)localArrayList);
        ((Intent)localObject1).putExtra("key_byuser", paramd.type);
        ((Intent)localObject1).putExtra("key_history", true);
        com.tencent.mm.br.c.b(getContext(), "mv", ".ui.shake.MusicMainUINew", (Intent)localObject1);
        label358:
        AppMethodBeat.o(273590);
        return;
      }
      i += 1;
    }
  }
  
  public int getLayoutId()
  {
    return R.i.gnZ;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28411);
    this.oJu = new com.tencent.mm.modelimage.loader.a(this);
    bh.bCz();
    final int i = Util.nullAs((Integer)com.tencent.mm.model.c.ban().d(12290, null), 0);
    this.hAN = getIntent().getIntExtra("_key_show_type_", 0);
    Object localObject = getIntent().getStringExtra("_key_title_");
    if (!Util.isNullOrNil((String)localObject)) {
      setMMTitle((String)localObject);
    }
    this.PCa = getIntent().getBooleanExtra("_key_show_from_shake_", false);
    addTextOptionMenu(0, getString(R.l.app_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28391);
        k.a(ShakeItemListUI.this, true, ShakeItemListUI.this.getString(R.l.say_hi_clean_all_title), "", ShakeItemListUI.this.getString(R.l.app_clear), ShakeItemListUI.this.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28390);
            switch (ShakeItemListUI.a(ShakeItemListUI.this))
            {
            }
            for (;;)
            {
              ShakeItemListUI.b(ShakeItemListUI.this).aNy();
              ShakeItemListUI.c(ShakeItemListUI.this).setVisibility(8);
              paramAnonymous2DialogInterface = (TextView)ShakeItemListUI.this.findViewById(R.h.fPi);
              paramAnonymous2DialogInterface.setText(ShakeItemListUI.aji(ShakeItemListUI.a(ShakeItemListUI.this)));
              paramAnonymous2DialogInterface.setVisibility(0);
              ShakeItemListUI.this.enableOptionMenu(false);
              paramAnonymous2DialogInterface = new mz();
              com.tencent.mm.plugin.shake.a locala = com.tencent.mm.plugin.shake.a.PyM;
              com.tencent.mm.plugin.shake.a.a(102, paramAnonymous2DialogInterface);
              AppMethodBeat.o(28390);
              return;
              com.tencent.mm.plugin.shake.model.m.gXd().ajb(0);
              com.tencent.mm.plugin.shake.model.m.gXd().gWR();
              continue;
              com.tencent.mm.plugin.shake.model.m.gXd().ajb(0);
              continue;
              bh.baH().postToWorker(new l.1());
              com.tencent.mm.plugin.shake.model.m.gXd().ajb(4);
              continue;
              com.tencent.mm.plugin.shake.model.m.gXd().ajb(7);
              com.tencent.mm.plugin.shake.model.m.gXd().ajb(6);
              com.tencent.mm.plugin.shake.model.m.gXd().ajb(8);
              com.tencent.mm.plugin.shake.model.m.gXd().ajb(9);
              com.tencent.mm.plugin.shake.model.m.gXd().ajb(10);
              com.tencent.mm.plugin.shake.model.m.gXd().ajb(12);
              continue;
              com.tencent.mm.plugin.shake.model.m.gXd().ajb(11);
            }
          }
        }, null);
        AppMethodBeat.o(28391);
        return true;
      }
    });
    this.pVC = ((ListView)findViewById(R.h.fPh));
    this.uiF = getLayoutInflater().inflate(R.i.gob, null);
    this.uiF.findViewById(R.h.fWd).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28392);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ShakeItemListUI.a(ShakeItemListUI.this, ShakeItemListUI.a(ShakeItemListUI.this) ^ 0xFFFFFFFF);
        ShakeItemListUI.this.setShowType(ShakeItemListUI.a(ShakeItemListUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28392);
      }
    });
    this.pVC.addFooterView(this.uiF);
    if (this.hAN == -1)
    {
      this.uiF.findViewById(R.h.fWd).setVisibility(0);
      this.PCb = new a(this);
      this.PCb.setShowType(this.hAN);
      if (this.PCb.getCount() > 0) {
        break label335;
      }
      this.pVC.setVisibility(8);
      localObject = (TextView)findViewById(R.h.fPi);
      ((TextView)localObject).setText(aji(this.hAN));
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
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = ShakeItemListUI.c(ShakeItemListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28396);
        }
      });
      this.pVC.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(28397);
          if (ShakeItemListUI.b(ShakeItemListUI.this) != null)
          {
            paramAnonymousView = ShakeItemListUI.b(ShakeItemListUI.this);
            if (paramAnonymousView.pSE != null) {
              paramAnonymousView.pSE.B(paramAnonymousMotionEvent);
            }
          }
          AppMethodBeat.o(28397);
          return false;
        }
      });
      AppMethodBeat.o(28411);
      return;
      this.uiF.findViewById(R.h.fWd).setVisibility(8);
      break;
      label335:
      this.pVC.setAdapter(this.PCb);
      this.pVC.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(28393);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousAdapterView = (com.tencent.mm.plugin.shake.model.d)ShakeItemListUI.b(ShakeItemListUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
          }
          paramAnonymousView = com.tencent.mm.plugin.shake.model.m.gXd();
          int i;
          if (paramAnonymousAdapterView == null)
          {
            Log.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
            i = paramAnonymousAdapterView.field_type;
            if (i != 4) {
              break label248;
            }
            if ((paramAnonymousAdapterView.field_reserved3 == null) || (!paramAnonymousAdapterView.field_reserved3.equals("newShake"))) {
              break label237;
            }
            ShakeItemListUI.a(ShakeItemListUI.this, paramAnonymousAdapterView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
            paramAnonymousAdapterView.field_insertBatch = 1;
            paramAnonymousAdapterView.eQp = 1024;
            if (-1 == paramAnonymousView.db.update("shakeitem1", paramAnonymousAdapterView.convertTo(), "shakeItemID=? and insertBatch=?", new String[] { paramAnonymousAdapterView.field_shakeItemID, "2" })) {
              break;
            }
            paramAnonymousView.doNotify();
            break;
            label237:
            ShakeItemListUI.b(ShakeItemListUI.this, paramAnonymousAdapterView);
          }
          label248:
          if (i == 11)
          {
            if (System.currentTimeMillis() - ShakeItemListUI.this.PBZ > 2000L)
            {
              ShakeItemListUI.this.PBZ = System.currentTimeMillis();
              if ((paramAnonymousAdapterView.field_reserved3 == null) || (paramAnonymousAdapterView.field_reserved3.split(",").length != 3) || (paramAnonymousAdapterView.field_reserved3.split(",")[0] == null) || (paramAnonymousAdapterView.field_reserved3.split(",")[0].equals(""))) {
                break label451;
              }
              paramAnonymousView = paramAnonymousAdapterView.field_reserved3.split(",");
              localObject = new zp();
              ((zp)localObject).icM.userName = paramAnonymousView[0];
              ((zp)localObject).icM.icO = Util.nullAs(paramAnonymousView[1], "");
              ((zp)localObject).icM.icP = Integer.parseInt(paramAnonymousView[2]);
              ((zp)localObject).icM.scene = 1077;
              ((zp)localObject).publish();
            }
            for (;;)
            {
              if (ShakeItemListUI.d(ShakeItemListUI.this))
              {
                j.a(paramAnonymousAdapterView);
                j.b(paramAnonymousAdapterView);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(28393);
              return;
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.getCity());
              paramAnonymousView.putExtra("scene", 27);
              paramAnonymousView.putExtra("stastic_scene", 5);
              com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            }
          }
          label451:
          if (n.ajg(i))
          {
            n.a(paramAnonymousAdapterView, ShakeItemListUI.this, true);
            paramAnonymousAdapterView = new mz();
            paramAnonymousView = com.tencent.mm.plugin.shake.a.PyM;
            com.tencent.mm.plugin.shake.a.a(104, paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
          }
          paramAnonymousView = paramAnonymousAdapterView.field_username;
          bh.bCz();
          localObject = com.tencent.mm.model.c.bzA().JE(paramAnonymousView);
          Log.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramAnonymousView + " display:" + paramAnonymousAdapterView.field_nickname + " position:" + paramAnonymousInt + " contactName" + ((az)localObject).field_username);
          Log.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.contact.d.rs(((az)localObject).field_type) + "  contact:" + localObject);
          if (com.tencent.mm.contact.d.rs(((az)localObject).field_type))
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("Contact_User", paramAnonymousView);
            if (i == paramAnonymousAdapterView.field_sex)
            {
              i = 23;
              localIntent.putExtra("Contact_Scene", i);
              localIntent.putExtra("Sns_from_Scene", 22);
              if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
              {
                if (((au)localObject).iZC())
                {
                  h.OAn.kvStat(10298, paramAnonymousAdapterView.field_username + "," + localIntent.getIntExtra("Contact_Scene", 23));
                  localIntent.putExtra("Contact_Scene", 23);
                }
                localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 31);
                localIntent.putExtra("CONTACT_INFO_UI_SUB_SOURCE", 3104);
                com.tencent.mm.plugin.shake.b.pFn.c(localIntent, ShakeItemListUI.this);
              }
              paramAnonymousView = new mz();
              paramAnonymousView.jcG = (paramAnonymousInt + 1);
              localObject = paramAnonymousView.vv(paramAnonymousAdapterView.field_username);
              if (!Util.isNullOrNil(paramAnonymousAdapterView.field_signature)) {
                break label1298;
              }
            }
          }
          label1298:
          for (paramAnonymousLong = 1L;; paramAnonymousLong = 2L)
          {
            ((mz)localObject).jcJ = paramAnonymousLong;
            ((mz)localObject).jcH = paramAnonymousAdapterView.field_sex;
            ((mz)localObject).vw(paramAnonymousAdapterView.field_distance);
            paramAnonymousAdapterView = com.tencent.mm.plugin.shake.a.PyM;
            com.tencent.mm.plugin.shake.a.a(101, paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeItemListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(28393);
            return;
            i = 24;
            break;
            Log.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + paramAnonymousView + " display:" + paramAnonymousAdapterView.field_nickname + " position:" + paramAnonymousInt + " contactName" + ((az)localObject).field_username);
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
            for (i = 23;; i = 24)
            {
              paramAnonymousView.putExtra("Contact_Scene", i);
              paramAnonymousView.putExtra("Sns_from_Scene", 22);
              paramAnonymousView.putExtra("Contact_KSnsIFlag", paramAnonymousAdapterView.field_snsFlag);
              paramAnonymousView.putExtra("Contact_KSnsBgUrl", paramAnonymousAdapterView.field_sns_bgurl);
              if ((paramAnonymousAdapterView.field_reserved1 & 0x8) > 0) {
                h.OAn.kvStat(10298, paramAnonymousAdapterView.field_username + "," + paramAnonymousView.getIntExtra("Contact_Scene", 23));
              }
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 31);
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SUB_SOURCE", 3104);
              com.tencent.mm.plugin.shake.b.pFn.c(paramAnonymousView, ShakeItemListUI.this);
              break;
            }
          }
        }
      });
      localObject = new com.tencent.mm.ui.tools.l(this);
      this.pVC.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
          this.vzu.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeItemListUI.this, ShakeItemListUI.e(ShakeItemListUI.this));
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
    com.tencent.mm.plugin.shake.model.m.gXd().add(this.PCb);
    this.PCb.aNz();
    Log.i("MicroMsg.ShakeItemListUI", "onResume");
    AppMethodBeat.o(28410);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28412);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.id = ((com.tencent.mm.plugin.shake.model.d)this.PCb.getItem(paramView.position)).field_shakeItemID;
    paramContextMenu.add(paramView.position, 0, 0, R.l.app_delete);
    AppMethodBeat.o(28412);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28414);
    this.PCb.fSd();
    a locala = this.PCb;
    if (locala.pSE != null)
    {
      locala.pSE.detach();
      locala.pSE = null;
    }
    com.tencent.mm.plugin.shake.model.m.gXd().remove(this.PCb);
    Log.i("MicroMsg.ShakeItemListUI", "onPause");
    if (this.oJu != null) {
      this.oJu.detach();
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
    this.PCb.setShowType(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28415);
      return;
      if (this.uiF != null)
      {
        this.uiF.findViewById(R.h.fWd).setVisibility(8);
        AppMethodBeat.o(28415);
        return;
        if (this.uiF != null) {
          this.uiF.findViewById(R.h.fWd).setVisibility(0);
        }
      }
    }
  }
  
  final class a
    extends x<com.tencent.mm.plugin.shake.model.d>
  {
    private int hAN;
    com.tencent.mm.ui.applet.b pSE;
    private b.b pSF;
    
    public a(ShakeItemListUI paramShakeItemListUI)
    {
      super(new com.tencent.mm.plugin.shake.model.d());
      AppMethodBeat.i(28403);
      this.hAN = 0;
      this.pSF = null;
      this.pSE = new com.tencent.mm.ui.applet.b(new b.a()
      {
        public final Bitmap getHeadImg(String paramAnonymousString)
        {
          AppMethodBeat.i(28399);
          paramAnonymousString = com.tencent.mm.modelavatar.d.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(28399);
          return paramAnonymousString;
        }
      });
      aNz();
      AppMethodBeat.o(28403);
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(28406);
      if (!bh.baz())
      {
        AppMethodBeat.o(28406);
        return;
      }
      switch (this.hAN)
      {
      }
      for (;;)
      {
        super.notifyDataSetChanged();
        AppMethodBeat.o(28406);
        return;
        w(com.tencent.mm.plugin.shake.model.m.gXd().gWJ());
        continue;
        w(com.tencent.mm.plugin.shake.model.m.gXd().gWL());
        continue;
        w(com.tencent.mm.plugin.shake.model.m.gXd().gWK());
        continue;
        w(com.tencent.mm.plugin.shake.model.m.gXd().gWM());
        continue;
        w(com.tencent.mm.plugin.shake.model.m.gXd().gWN());
        continue;
        w(com.tencent.mm.plugin.shake.model.m.gXd().gWO());
        continue;
        w(com.tencent.mm.plugin.shake.model.m.gXd().gWP());
        continue;
        w(com.tencent.mm.plugin.shake.model.m.gXd().gWQ());
        continue;
        w(com.tencent.mm.plugin.shake.model.m.gXd().aiZ(ShakeItemListUI.this.getIntent().getIntExtra("_ibeacon_new_insert_size", 2)));
      }
    }
    
    public final void aNz()
    {
      AppMethodBeat.i(28405);
      fSd();
      aNy();
      AppMethodBeat.o(28405);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(28404);
      if (this.pSF == null) {
        this.pSF = new b.b()
        {
          public final int bWT()
          {
            AppMethodBeat.i(28401);
            int i = ShakeItemListUI.a.this.getCount();
            AppMethodBeat.o(28401);
            return i;
          }
          
          public final String yq(int paramAnonymousInt)
          {
            AppMethodBeat.i(28400);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= ShakeItemListUI.a.this.getCount()))
            {
              Log.e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
              AppMethodBeat.o(28400);
              return null;
            }
            Object localObject = (com.tencent.mm.plugin.shake.model.d)ShakeItemListUI.a.this.getItem(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(28400);
              return null;
            }
            localObject = ((com.tencent.mm.plugin.shake.model.d)localObject).field_username;
            AppMethodBeat.o(28400);
            return localObject;
          }
        };
      }
      if (this.pSE != null) {
        this.pSE.a(paramInt, this.pSF);
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, R.i.goa, null);
        paramViewGroup.avatar = ((ImageView)paramView.findViewById(R.h.nearby_friend_avatar_iv));
        paramViewGroup.pQZ = ((TextView)paramView.findViewById(R.h.nearby_friend_name));
        paramViewGroup.pSI = ((TextView)paramView.findViewById(R.h.fPg));
        paramViewGroup.PCh = ((ImageView)paramView.findViewById(R.h.fPj));
        paramViewGroup.EPv = ((TextView)paramView.findViewById(R.h.fPf));
        paramViewGroup.EPw = ((TextView)paramView.findViewById(R.h.fPk));
        paramViewGroup.EPx = ((ImageView)paramView.findViewById(R.h.fPl));
        paramViewGroup.PCi = ((TextView)paramView.findViewById(R.h.fXf));
        paramViewGroup.PCg = paramView.findViewById(R.h.fUX);
        paramViewGroup.PCj = ((LinearLayout)paramView.findViewById(R.h.fWf));
        paramViewGroup.PCk = ((TextView)paramView.findViewById(R.h.fWg));
        paramView.setTag(paramViewGroup);
      }
      Object localObject1;
      for (;;)
      {
        localObject1 = (com.tencent.mm.plugin.shake.model.d)getItem(paramInt);
        if (localObject1 != null) {
          break;
        }
        paramViewGroup.clear();
        AppMethodBeat.o(28404);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.clear();
      if ((4 == ((com.tencent.mm.plugin.shake.model.d)localObject1).field_type) || ((n.ajg(((com.tencent.mm.plugin.shake.model.d)localObject1).field_type)) && (6 != ((com.tencent.mm.plugin.shake.model.d)localObject1).field_type)))
      {
        if (4 != ((com.tencent.mm.plugin.shake.model.d)localObject1).field_type) {
          paramViewGroup.avatar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        e.a(paramViewGroup.avatar, ((com.tencent.mm.plugin.shake.model.d)localObject1).field_sns_bgurl, R.k.app_attach_file_icon_webpage, false);
        paramViewGroup.avatar.setVisibility(0);
        if ((7 != ((com.tencent.mm.plugin.shake.model.d)localObject1).field_type) && (10 != ((com.tencent.mm.plugin.shake.model.d)localObject1).field_type) && (12 != ((com.tencent.mm.plugin.shake.model.d)localObject1).field_type) && (13 != ((com.tencent.mm.plugin.shake.model.d)localObject1).field_type) && ((8 != ((com.tencent.mm.plugin.shake.model.d)localObject1).field_type) || (!Util.isNullOrNil(((com.tencent.mm.plugin.shake.model.d)localObject1).field_nickname)) || (!Util.isNullOrNil(((com.tencent.mm.plugin.shake.model.d)localObject1).field_username)))) {
          break label521;
        }
        if (8 != ((com.tencent.mm.plugin.shake.model.d)localObject1).field_type) {
          break label506;
        }
        paramViewGroup.PCk.setText(((com.tencent.mm.plugin.shake.model.d)localObject1).field_distance);
      }
      for (;;)
      {
        paramViewGroup.PCk.setVisibility(0);
        paramViewGroup.PCj.setVisibility(8);
        AppMethodBeat.o(28404);
        return paramView;
        if (11 == ((com.tencent.mm.plugin.shake.model.d)localObject1).field_type)
        {
          ShakeItemListUI.g(ShakeItemListUI.this).loadImage(((com.tencent.mm.plugin.shake.model.d)localObject1).getProvince(), paramViewGroup.avatar);
          break;
        }
        a.b.g(paramViewGroup.avatar, ((com.tencent.mm.plugin.shake.model.d)localObject1).field_username);
        break;
        label506:
        paramViewGroup.PCk.setText(((com.tencent.mm.plugin.shake.model.d)localObject1).field_nickname);
      }
      label521:
      paramViewGroup.PCk.setVisibility(8);
      paramViewGroup.PCj.setVisibility(0);
      if ((8 == ((com.tencent.mm.plugin.shake.model.d)localObject1).field_type) && (Util.isNullOrNil(((com.tencent.mm.plugin.shake.model.d)localObject1).field_nickname)))
      {
        ((com.tencent.mm.plugin.shake.model.d)localObject1).field_nickname = ((com.tencent.mm.plugin.shake.model.d)localObject1).field_distance;
        ((com.tencent.mm.plugin.shake.model.d)localObject1).field_distance = ((com.tencent.mm.plugin.shake.model.d)localObject1).field_username;
      }
      Object localObject2 = Util.nullAsNil(((com.tencent.mm.plugin.shake.model.d)localObject1).field_nickname);
      paramViewGroup.pQZ.setText(p.b(this.context, (CharSequence)localObject2, paramViewGroup.pQZ.getTextSize()));
      paramViewGroup.pQZ.setVisibility(0);
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      paramView.setPadding(paramView.getPaddingLeft(), i, j, paramInt);
      switch (((com.tencent.mm.plugin.shake.model.d)localObject1).field_type)
      {
      default: 
        paramViewGroup.PCg.setVisibility(0);
        paramViewGroup.EPv.setText(((com.tencent.mm.plugin.shake.model.d)localObject1).field_distance);
        paramViewGroup.EPv.setVisibility(0);
        if ((((com.tencent.mm.plugin.shake.model.d)localObject1).field_signature == null) || (((com.tencent.mm.plugin.shake.model.d)localObject1).field_signature.trim().equals("")))
        {
          paramViewGroup.EPw.setVisibility(8);
          if (((com.tencent.mm.plugin.shake.model.d)localObject1).field_sex != 1) {
            break label1026;
          }
          paramViewGroup.PCh.setVisibility(0);
          paramViewGroup.PCh.setImageDrawable(com.tencent.mm.cd.a.m(this.context, R.k.ic_sex_male));
          paramViewGroup.PCh.setContentDescription(this.context.getString(R.l.male_Imgbtn));
          label793:
          bh.bCz();
          localObject2 = com.tencent.mm.model.c.bzA().JE(((com.tencent.mm.plugin.shake.model.d)localObject1).field_username);
          if ((localObject2 == null) || (!com.tencent.mm.contact.d.rs(((az)localObject2).field_type))) {
            break label1112;
          }
          paramViewGroup.pSI.setVisibility(0);
          if (!au.ayS(((com.tencent.mm.plugin.shake.model.d)localObject1).field_reserved1)) {
            break label1092;
          }
          paramViewGroup.pSI.setText(this.context.getString(R.l.gOo));
          label864:
          if (6 == ((com.tencent.mm.plugin.shake.model.d)localObject1).field_type)
          {
            paramViewGroup.EPv.setText(this.context.getString(R.l.gVn));
            paramViewGroup.pSI.setVisibility(8);
          }
          if (((com.tencent.mm.plugin.shake.model.d)localObject1).field_reserved1 == 0) {
            break label1124;
          }
          paramViewGroup.EPx.setVisibility(0);
          localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(az.a.okR.vd(((com.tencent.mm.plugin.shake.model.d)localObject1).field_reserved1), 2.0F);
          paramViewGroup.EPx.setImageBitmap((Bitmap)localObject1);
          paramViewGroup.PCh.setVisibility(8);
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(28404);
        return paramView;
        paramViewGroup.PCi.setText(((com.tencent.mm.plugin.shake.model.d)localObject1).field_nickname);
        paramViewGroup.PCi.setVisibility(0);
        AppMethodBeat.o(28404);
        return paramView;
        paramViewGroup.EPw.setVisibility(0);
        paramViewGroup.EPw.setText(p.b(this.context, ((com.tencent.mm.plugin.shake.model.d)localObject1).field_signature, paramViewGroup.pQZ.getTextSize()));
        break;
        label1026:
        if (((com.tencent.mm.plugin.shake.model.d)localObject1).field_sex == 2)
        {
          paramViewGroup.PCh.setVisibility(0);
          paramViewGroup.PCh.setImageDrawable(com.tencent.mm.cd.a.m(this.context, R.k.ic_sex_female));
          paramViewGroup.PCh.setContentDescription(this.context.getString(R.l.female_Imgbtn));
          break label793;
        }
        paramViewGroup.PCh.setVisibility(8);
        break label793;
        label1092:
        paramViewGroup.pSI.setText(this.context.getString(R.l.nearby_friend_is_contact));
        break label864;
        label1112:
        paramViewGroup.pSI.setVisibility(8);
        break label864;
        label1124:
        paramViewGroup.EPx.setVisibility(8);
      }
    }
    
    protected final void setShowType(int paramInt)
    {
      AppMethodBeat.i(28407);
      this.hAN = paramInt;
      aNz();
      AppMethodBeat.o(28407);
    }
    
    final class a
    {
      TextView EPv;
      TextView EPw;
      ImageView EPx;
      View PCg;
      ImageView PCh;
      TextView PCi;
      LinearLayout PCj;
      TextView PCk;
      ImageView avatar;
      TextView pQZ;
      TextView pSI;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(28402);
        if (this.avatar != null)
        {
          this.avatar.setImageDrawable(null);
          this.avatar.setVisibility(8);
        }
        if (this.pQZ != null)
        {
          this.pQZ.setText("");
          this.pQZ.setVisibility(8);
        }
        if (this.pSI != null) {
          this.pSI.setVisibility(8);
        }
        if (this.PCh != null) {
          this.PCh.setVisibility(8);
        }
        if (this.EPv != null)
        {
          this.EPv.setText("");
          this.EPv.setVisibility(8);
        }
        if (this.EPw != null)
        {
          this.EPw.setVisibility(8);
          this.PCg.setVisibility(8);
        }
        if (this.EPx != null) {
          this.EPx.setVisibility(8);
        }
        if (this.PCi != null)
        {
          this.PCi.setText("");
          this.PCi.setVisibility(8);
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