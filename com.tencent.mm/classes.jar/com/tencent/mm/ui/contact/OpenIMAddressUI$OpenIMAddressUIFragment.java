package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.z.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OpenIMAddressUI$OpenIMAddressUIFragment
  extends MMFragment
  implements com.tencent.mm.ak.i
{
  private com.tencent.mm.ui.voicesearch.b PSM;
  private String PSO;
  boolean PTd;
  private boolean PTe;
  List<String> PTh;
  private String PXZ;
  private x PYa;
  private Runnable PYb;
  private ProgressDialog gtM;
  com.tencent.mm.pluginsdk.ui.e gup;
  List<String> gzY;
  private int ppd;
  private int ppe;
  private com.tencent.mm.ui.widget.f ppm;
  private o.g rJj;
  private ListView yCT;
  
  public OpenIMAddressUI$OpenIMAddressUIFragment()
  {
    super(true);
    AppMethodBeat.i(37902);
    this.PXZ = "";
    this.gtM = null;
    this.PSO = "";
    this.PTe = true;
    this.PYb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37901);
        OpenIMAddressUI.OpenIMAddressUIFragment.i(OpenIMAddressUI.OpenIMAddressUIFragment.this);
        AppMethodBeat.o(37901);
      }
    };
    this.rJj = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(37885);
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(37885);
          return;
        case 1: 
        case 2: 
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this, OpenIMAddressUI.OpenIMAddressUIFragment.j(OpenIMAddressUI.OpenIMAddressUIFragment.this));
          AppMethodBeat.o(37885);
          return;
        }
        OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this, OpenIMAddressUI.OpenIMAddressUIFragment.j(OpenIMAddressUI.OpenIMAddressUIFragment.this));
        AppMethodBeat.o(37885);
      }
    };
    this.gup = new com.tencent.mm.pluginsdk.ui.e(new OpenIMAddressUI.OpenIMAddressUIFragment.4(this));
    this.gzY = new LinkedList();
    this.PTh = new LinkedList();
    AppMethodBeat.o(37902);
  }
  
  private void gUq()
  {
    AppMethodBeat.i(37906);
    this.gzY = new LinkedList();
    this.PTh = new LinkedList();
    com.tencent.mm.br.c.gsX();
    this.gzY.add("tmessage");
    this.PTh.addAll(this.gzY);
    if (!this.gzY.contains("officialaccounts")) {
      this.gzY.add("officialaccounts");
    }
    this.gzY.add("helper_entry");
    if (this.PYa != null) {
      this.PYa.jB(this.gzY);
    }
    if (this.PSM != null) {
      this.PSM.jB(this.PTh);
    }
    AppMethodBeat.o(37906);
  }
  
  private void gUr()
  {
    try
    {
      AppMethodBeat.i(37910);
      long l = System.currentTimeMillis();
      gUq();
      Log.i("MicroMsg.OpenIMAddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
      if (this.PYa != null)
      {
        Log.v("MicroMsg.OpenIMAddressUI", "post to do refresh");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37888);
            OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).gUp();
            AppMethodBeat.o(37888);
          }
        });
      }
      if (this.PSM != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37889);
            Log.v("MicroMsg.OpenIMAddressUI", "post search adapter to do refresh");
            OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).onNotifyChange(null, null);
            AppMethodBeat.o(37889);
          }
        });
      }
      Log.i("MicroMsg.OpenIMAddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(37910);
      return;
    }
    finally {}
  }
  
  public int getLayoutId()
  {
    return 2131495890;
  }
  
  public View getLayoutView()
  {
    AppMethodBeat.i(37903);
    com.tencent.mm.kiss.a.b.aBh();
    View localView = com.tencent.mm.kiss.a.b.c(getContext(), 2131495890);
    AppMethodBeat.o(37903);
    return localView;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(37908);
    super.onActivityCreated(paramBundle);
    Log.v("MicroMsg.OpenIMAddressUI", "on address ui create");
    bg.azz().a(138, this);
    g.aAi();
    g.aAg().hqi.a(453, this);
    this.PXZ = getStringExtra("key_openim_acctype_id");
    setMMTitle(((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).b(this.PXZ, "openim_acct_type_title", a.a.jGS));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(37883);
        OpenIMAddressUI.OpenIMAddressUIFragment.this.finish();
        AppMethodBeat.o(37883);
        return true;
      }
    });
    setTitleBarDoubleClickListener(this.PYb);
    Log.v("MicroMsg.OpenIMAddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
    this.yCT = ((ListView)findViewById(2131296545));
    this.yCT.setScrollingCacheEnabled(false);
    this.PYa = new x(getContext(), "@openim.contact", this.PXZ);
    this.PYa.a(new f.a()
    {
      public final void bnE()
      {
        AppMethodBeat.i(37894);
        OpenIMAddressUI.OpenIMAddressUIFragment localOpenIMAddressUIFragment = OpenIMAddressUI.OpenIMAddressUIFragment.this;
        OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount();
        OpenIMAddressUI.OpenIMAddressUIFragment.b(localOpenIMAddressUIFragment);
        OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).gUn();
        AppMethodBeat.o(37894);
      }
      
      public final void gHg() {}
    });
    this.PYa.PSs = true;
    this.PYa.PYf = this;
    this.PYa.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dr(View paramAnonymousView)
      {
        AppMethodBeat.i(37895);
        int i = OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(37895);
        return i;
      }
    });
    this.PYa.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(37896);
        OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(37896);
      }
    });
    this.PYa.a(new MMSlideDelView.f()
    {
      public final void cZ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(37897);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.OpenIMAddressUI", "onItemDel object null");
          AppMethodBeat.o(37897);
          return;
        }
        OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this, paramAnonymousObject.toString());
        AppMethodBeat.o(37897);
      }
    });
    this.PSM = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.PSM.CR(true);
    this.ppm = new com.tencent.mm.ui.widget.f(getContext());
    this.yCT.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37898);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
        boolean bool1;
        if (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null)
        {
          paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this);
          Log.i("MicroMsg.OpenIMAddressUI", paramAnonymousAdapterView);
          paramAnonymousInt -= OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount();
          if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null) || (!OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).QBl)) {
            break label937;
          }
          bool1 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).Ox(paramAnonymousInt);
          boolean bool2 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).aot(paramAnonymousInt);
          Log.i("MicroMsg.OpenIMAddressUI", "onItemClick ".concat(String.valueOf(bool2)));
          if (!bool2) {
            break label230;
          }
          OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).boh("");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(37898);
          return;
          paramAnonymousAdapterView = Boolean.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).QBl);
          break;
          label230:
          if (bool1)
          {
            paramAnonymousView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).aos(paramAnonymousInt);
            paramAnonymousAdapterView = paramAnonymousView.Lqk.MTo;
            bg.aVF();
            localObject = com.tencent.mm.model.c.aSN().Kn(paramAnonymousAdapterView);
            if (com.tencent.mm.contact.c.oR(((ax)localObject).field_type))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Contact_Scene", 3);
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
              {
                if (((as)localObject).gBM()) {
                  h.CyF.kvStat(10298, paramAnonymousAdapterView + ",3");
                }
                e.a(paramAnonymousView, paramAnonymousAdapterView);
                com.tencent.mm.br.c.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
              }
            }
            else
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.Lqk.MTo);
              ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.ked);
              ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.Mjj.MTo);
              ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.keb);
              ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bq(paramAnonymousView.keh, paramAnonymousView.kdZ, paramAnonymousView.kea));
              ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.kdY);
              ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.MmL);
              ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.MmK);
              ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.MmO);
              ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.MmM);
              ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.MmN);
              ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.MmQ.kej);
              ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.MmQ.kel);
              ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.MmQ.kek);
              if (paramAnonymousView.MmR != null) {}
              try
              {
                ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.MmR.toByteArray());
                if ((paramAnonymousView.MmK & 0x8) > 0) {
                  h.CyF.kvStat(10298, paramAnonymousAdapterView + ",3");
                }
                com.tencent.mm.br.c.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
              }
              catch (IOException localIOException)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.OpenIMAddressUI", localIOException, "", new Object[0]);
                }
              }
            }
          }
          else
          {
            paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).Ln(paramAnonymousInt);
            if (paramAnonymousAdapterView == null)
            {
              Log.e("MicroMsg.OpenIMAddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(37898);
              return;
            }
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            if (ab.Js(paramAnonymousAdapterView))
            {
              paramAnonymousView = new Intent(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), OpenIMAddressUI.class);
              paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
              paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.this;
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.axQ(), "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(37898);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
            paramAnonymousView.putExtra("Contact_Scene", 3);
            if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
              com.tencent.mm.br.c.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
            }
          }
        }
        label937:
        paramAnonymousAdapterView = (com.tencent.mm.storage.f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).akz(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          paramAnonymousView = OpenIMAddressUI.OpenIMAddressUIFragment.this;
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
            break label995;
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(37898);
          return;
          label995:
          if (ab.Js(paramAnonymousAdapterView))
          {
            Log.e("MicroMsg.OpenIMAddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
          }
          else
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
            if (ab.IQ(paramAnonymousAdapterView)) {
              ((Intent)localObject).putExtra("Is_group_card", true);
            }
            if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
            {
              e.a((Intent)localObject, paramAnonymousAdapterView);
              com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
            }
          }
        }
      }
    });
    this.yCT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37899);
        Log.i("MicroMsg.OpenIMAddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt < OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.OpenIMAddressUI", "on item long click, but match header view");
          AppMethodBeat.o(37899);
          return true;
        }
        if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) != null) && (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).QBl))
        {
          AppMethodBeat.o(37899);
          return true;
        }
        paramAnonymousAdapterView = (com.tencent.mm.storage.f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).akz(paramAnonymousInt - OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount());
        if (paramAnonymousAdapterView == null)
        {
          Log.e("MicroMsg.OpenIMAddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount()) });
          AppMethodBeat.o(37899);
          return true;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        if ((ab.Js(paramAnonymousAdapterView)) || (ab.Jt(paramAnonymousAdapterView)))
        {
          AppMethodBeat.o(37899);
          return true;
        }
        OpenIMAddressUI.OpenIMAddressUIFragment.b(OpenIMAddressUI.OpenIMAddressUIFragment.this, paramAnonymousAdapterView);
        OpenIMAddressUI.OpenIMAddressUIFragment.h(OpenIMAddressUI.OpenIMAddressUIFragment.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, OpenIMAddressUI.OpenIMAddressUIFragment.this, OpenIMAddressUI.OpenIMAddressUIFragment.e(OpenIMAddressUI.OpenIMAddressUIFragment.this), OpenIMAddressUI.OpenIMAddressUIFragment.f(OpenIMAddressUI.OpenIMAddressUIFragment.this), OpenIMAddressUI.OpenIMAddressUIFragment.g(OpenIMAddressUI.OpenIMAddressUIFragment.this));
        AppMethodBeat.o(37899);
        return true;
      }
    });
    this.yCT.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37900);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(37900);
          return false;
          OpenIMAddressUI.OpenIMAddressUIFragment.this.hideVKB();
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawX());
          OpenIMAddressUI.OpenIMAddressUIFragment.b(OpenIMAddressUI.OpenIMAddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    this.yCT.setOnScrollListener(this.gup);
    this.yCT.setDrawingCacheEnabled(false);
    bg.aVF();
    com.tencent.mm.model.c.aSN().add(this.PYa);
    AppMethodBeat.o(37908);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(37907);
    Log.i("MicroMsg.OpenIMAddressUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
    if ((paramInt1 == 6) && (paramInt2 == -1))
    {
      setResult(-1);
      finish();
      AppMethodBeat.o(37907);
      return;
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(37907);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37907);
      return;
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(37904);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    bg.aVF();
    as localas = com.tencent.mm.model.c.aSN().Kn(this.PSO);
    if (localas == null)
    {
      Log.e("MicroMsg.OpenIMAddressUI", "onCreateContextMenu, contact is null, username = " + this.PSO);
      AppMethodBeat.o(37904);
      return;
    }
    if (z.aTY().equals(localas.field_username))
    {
      AppMethodBeat.o(37904);
      return;
    }
    if (ab.IQ(this.PSO))
    {
      paramContextMenu.setHeaderTitle(l.c(paramView.getContext(), localas.arJ()));
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131755223);
      AppMethodBeat.o(37904);
      return;
    }
    if ((ab.Jf(this.PSO)) || (ab.Jv(this.PSO)))
    {
      AppMethodBeat.o(37904);
      return;
    }
    paramContextMenu.setHeaderTitle(l.c(paramView.getContext(), localas.arJ()));
    if ((com.tencent.mm.contact.c.oR(localas.field_type)) && (localas.field_deleteFlag != 1)) {
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131757968);
    }
    AppMethodBeat.o(37904);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37912);
    super.onDestroy();
    Log.v("MicroMsg.OpenIMAddressUI", "onDestory");
    bg.azz().b(138, this);
    g.aAi();
    g.aAg().hqi.b(453, this);
    if (this.PYa != null)
    {
      this.PYa.AV(true);
      this.PYa.detach();
      this.PYa.gGV();
    }
    if (this.PSM != null)
    {
      this.PSM.detach();
      this.PSM.ebf();
    }
    if ((bg.aAc()) && (this.PYa != null))
    {
      bg.aVF();
      com.tencent.mm.model.c.aSN().remove(this.PYa);
    }
    AppMethodBeat.o(37912);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37911);
    super.onPause();
    Log.i("MicroMsg.OpenIMAddressUI", "AddressUI on Pause");
    if (this.PSM != null) {
      this.PSM.onPause();
    }
    this.PYa.gUo();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37893);
        OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).pause();
        AppMethodBeat.o(37893);
      }
    });
    AppMethodBeat.o(37911);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37909);
    super.onResume();
    Log.v("MicroMsg.OpenIMAddressUI", "address ui on resume");
    if (this.PTe)
    {
      this.PTe = false;
      this.PTd = false;
      gUq();
      this.yCT.setAdapter(this.PYa);
      this.yCT.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37890);
          Log.i("MicroMsg.OpenIMAddressUI", "post to first init finish");
          View localView = OpenIMAddressUI.OpenIMAddressUIFragment.this.findViewById(2131303716);
          if (localView != null)
          {
            localView.setVisibility(8);
            localView.startAnimation(AnimationUtils.loadAnimation(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), 2130772060));
          }
          AppMethodBeat.o(37890);
        }
      });
      this.PSM.CQ(false);
    }
    for (;;)
    {
      if (this.PSM != null) {
        this.PSM.onResume();
      }
      this.PYa.OzQ = false;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37892);
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).resume();
          AppMethodBeat.o(37892);
        }
      });
      AppMethodBeat.o(37909);
      return;
      if (this.PTd)
      {
        this.PTd = false;
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37891);
            Process.setThreadPriority(10);
            OpenIMAddressUI.OpenIMAddressUIFragment.k(OpenIMAddressUI.OpenIMAddressUIFragment.this);
            AppMethodBeat.o(37891);
          }
        }, "AddressUI_updateUIData", 4);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(37905);
    if (paramq.getType() == 453)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(37905);
        return;
      }
      if (!((brr)((com.tencent.mm.openim.b.i)paramq).rr.iLL.iLR).LYW.isEmpty()) {
        gUr();
      }
      AppMethodBeat.o(37905);
      return;
    }
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (!Util.isTopActivity(getContext()))
    {
      AppMethodBeat.o(37905);
      return;
    }
    if (z.a.a(getContext(), paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(37905);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(37905);
      return;
    }
    AppMethodBeat.o(37905);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment
 * JD-Core Version:    0.7.0.1
 */