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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.bzn;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ac.a;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.g.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OpenIMAddressUI$OpenIMAddressUIFragment
  extends MMFragment
  implements com.tencent.mm.an.i
{
  private ListView Een;
  private String XpB;
  boolean XpO;
  private boolean XpP;
  List<String> XpS;
  private com.tencent.mm.ui.voicesearch.b Xpz;
  private String XuR;
  private z XuS;
  private Runnable XuT;
  private ProgressDialog iXX;
  com.tencent.mm.pluginsdk.ui.e iYA;
  List<String> jkb;
  private int syc;
  private int syd;
  private com.tencent.mm.ui.widget.h syl;
  private q.g voR;
  
  public OpenIMAddressUI$OpenIMAddressUIFragment()
  {
    super(true);
    AppMethodBeat.i(37902);
    this.XuR = "";
    this.iXX = null;
    this.XpB = "";
    this.XpP = true;
    this.XuT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37901);
        OpenIMAddressUI.OpenIMAddressUIFragment.i(OpenIMAddressUI.OpenIMAddressUIFragment.this);
        AppMethodBeat.o(37901);
      }
    };
    this.voR = new q.g()
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
    this.iYA = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(37886);
        Log.i("MicroMsg.OpenIMAddressUI", "[onScroll] firstVisibleItem:%s", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        AppMethodBeat.o(37886);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(37887);
        Log.i("MicroMsg.OpenIMAddressUI", "[onScrollStateChanged] scrollState:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        AppMethodBeat.o(37887);
      }
    });
    this.jkb = new LinkedList();
    this.XpS = new LinkedList();
    AppMethodBeat.o(37902);
  }
  
  private void hUj()
  {
    AppMethodBeat.i(37906);
    this.jkb = new LinkedList();
    this.XpS = new LinkedList();
    com.tencent.mm.by.c.hok();
    this.jkb.add("tmessage");
    this.XpS.addAll(this.jkb);
    if (!this.jkb.contains("officialaccounts")) {
      this.jkb.add("officialaccounts");
    }
    this.jkb.add("helper_entry");
    if (this.XuS != null) {
      this.XuS.kw(this.jkb);
    }
    if (this.Xpz != null) {
      this.Xpz.kw(this.XpS);
    }
    AppMethodBeat.o(37906);
  }
  
  private void hUk()
  {
    try
    {
      AppMethodBeat.i(37910);
      long l = System.currentTimeMillis();
      hUj();
      Log.i("MicroMsg.OpenIMAddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
      if (this.XuS != null)
      {
        Log.v("MicroMsg.OpenIMAddressUI", "post to do refresh");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37888);
            OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).hUi();
            AppMethodBeat.o(37888);
          }
        });
      }
      if (this.Xpz != null) {
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
    return R.i.ejL;
  }
  
  public View getLayoutView()
  {
    AppMethodBeat.i(37903);
    com.tencent.mm.kiss.a.b.aIK();
    View localView = com.tencent.mm.kiss.a.b.d(getContext(), R.i.ejL);
    AppMethodBeat.o(37903);
    return localView;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(37908);
    super.onActivityCreated(paramBundle);
    Log.v("MicroMsg.OpenIMAddressUI", "on address ui create");
    bh.aGY().a(138, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(453, this);
    this.XuR = getStringExtra("key_openim_acctype_id");
    setMMTitle(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).b(this.XuR, "openim_acct_type_title", a.a.mxX));
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
    setTitleBarDoubleClickListener(this.XuT);
    Log.v("MicroMsg.OpenIMAddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
    this.Een = ((ListView)findViewById(R.h.address_contactlist));
    this.Een.setScrollingCacheEnabled(false);
    this.XuS = new z(getContext(), "@openim.contact", this.XuR);
    this.XuS.a(new g.a()
    {
      public final void bxN()
      {
        AppMethodBeat.i(37894);
        OpenIMAddressUI.OpenIMAddressUIFragment localOpenIMAddressUIFragment = OpenIMAddressUI.OpenIMAddressUIFragment.this;
        OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount();
        OpenIMAddressUI.OpenIMAddressUIFragment.b(localOpenIMAddressUIFragment);
        OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).hUg();
        AppMethodBeat.o(37894);
      }
      
      public final void hFP() {}
    });
    this.XuS.Xpf = true;
    this.XuS.XuX = this;
    this.XuS.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(37895);
        int i = OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(37895);
        return i;
      }
    });
    this.XuS.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(37896);
        OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(37896);
      }
    });
    this.XuS.a(new MMSlideDelView.f()
    {
      public final void cW(Object paramAnonymousObject)
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
    this.Xpz = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.Xpz.Hl(true);
    this.syl = new com.tencent.mm.ui.widget.h(getContext());
    this.Een.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37898);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
        boolean bool1;
        if (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null)
        {
          paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this);
          Log.i("MicroMsg.OpenIMAddressUI", paramAnonymousAdapterView);
          paramAnonymousInt -= OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount();
          if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null) || (!OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).XZK)) {
            break label937;
          }
          bool1 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).TR(paramAnonymousInt);
          boolean bool2 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).axB(paramAnonymousInt);
          Log.i("MicroMsg.OpenIMAddressUI", "onItemClick ".concat(String.valueOf(bool2)));
          if (!bool2) {
            break label230;
          }
          OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).bAW("");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(37898);
          return;
          paramAnonymousAdapterView = Boolean.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).XZK);
          break;
          label230:
          if (bool1)
          {
            paramAnonymousView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).axA(paramAnonymousInt);
            paramAnonymousAdapterView = paramAnonymousView.SrH.Ufy;
            bh.beI();
            localObject = com.tencent.mm.model.c.bbL().RG(paramAnonymousAdapterView);
            if (com.tencent.mm.contact.d.rk(((ax)localObject).field_type))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Contact_Scene", 3);
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
              {
                if (((as)localObject).hxX()) {
                  com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramAnonymousAdapterView + ",3");
                }
                e.a(paramAnonymousView, paramAnonymousAdapterView);
                com.tencent.mm.by.c.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
              }
            }
            else
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.SrH.Ufy);
              ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.mVD);
              ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.TtX.Ufy);
              ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.mVB);
              ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bl(paramAnonymousView.mVH, paramAnonymousView.mVz, paramAnonymousView.mVA));
              ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.mVy);
              ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.TxG);
              ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.TxF);
              ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.TxJ);
              ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.TxH);
              ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.TxI);
              ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.TxL.mVJ);
              ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.TxL.mVL);
              ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.TxL.mVK);
              if (paramAnonymousView.TxM != null) {}
              try
              {
                ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.TxM.toByteArray());
                if ((paramAnonymousView.TxF & 0x8) > 0) {
                  com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramAnonymousAdapterView + ",3");
                }
                com.tencent.mm.by.c.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
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
            paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).Qx(paramAnonymousInt);
            if (paramAnonymousAdapterView == null)
            {
              Log.e("MicroMsg.OpenIMAddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(37898);
              return;
            }
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            if (ab.QL(paramAnonymousAdapterView))
            {
              paramAnonymousView = new Intent(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), OpenIMAddressUI.class);
              paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
              paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.this;
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aFh(), "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(37898);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
            paramAnonymousView.putExtra("Contact_Scene", 3);
            if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
              com.tencent.mm.by.c.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
            }
          }
        }
        label937:
        paramAnonymousAdapterView = (f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).asW(paramAnonymousInt);
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
          if (ab.QL(paramAnonymousAdapterView))
          {
            Log.e("MicroMsg.OpenIMAddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
          }
          else
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
            if (ab.Qj(paramAnonymousAdapterView)) {
              ((Intent)localObject).putExtra("Is_group_card", true);
            }
            if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
            {
              e.a((Intent)localObject, paramAnonymousAdapterView);
              com.tencent.mm.by.c.b(paramAnonymousView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
            }
          }
        }
      }
    });
    this.Een.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
        if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) != null) && (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).XZK))
        {
          AppMethodBeat.o(37899);
          return true;
        }
        paramAnonymousAdapterView = (f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).asW(paramAnonymousInt - OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount());
        if (paramAnonymousAdapterView == null)
        {
          Log.e("MicroMsg.OpenIMAddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount()) });
          AppMethodBeat.o(37899);
          return true;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        if ((ab.QL(paramAnonymousAdapterView)) || (ab.QM(paramAnonymousAdapterView)))
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
    this.Een.setOnTouchListener(new View.OnTouchListener()
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
    this.Een.setOnScrollListener(this.iYA);
    this.Een.setDrawingCacheEnabled(false);
    bh.beI();
    com.tencent.mm.model.c.bbL().add(this.XuS);
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
    bh.beI();
    as localas = com.tencent.mm.model.c.bbL().RG(this.XpB);
    if (localas == null)
    {
      Log.e("MicroMsg.OpenIMAddressUI", "onCreateContextMenu, contact is null, username = " + this.XpB);
      AppMethodBeat.o(37904);
      return;
    }
    if (com.tencent.mm.model.z.bcZ().equals(localas.field_username))
    {
      AppMethodBeat.o(37904);
      return;
    }
    if (ab.Qj(this.XpB))
    {
      paramContextMenu.setHeaderTitle(l.c(paramView.getContext(), localas.ays()));
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.ent);
      AppMethodBeat.o(37904);
      return;
    }
    if ((ab.Qy(this.XpB)) || (ab.QO(this.XpB)))
    {
      AppMethodBeat.o(37904);
      return;
    }
    paramContextMenu.setHeaderTitle(l.c(paramView.getContext(), localas.ays()));
    if ((com.tencent.mm.contact.d.rk(localas.field_type)) && (localas.field_deleteFlag != 1)) {
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, R.l.eyI);
    }
    AppMethodBeat.o(37904);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37912);
    super.onDestroy();
    Log.v("MicroMsg.OpenIMAddressUI", "onDestory");
    bh.aGY().b(138, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(453, this);
    if (this.XuS != null)
    {
      this.XuS.Fk(true);
      this.XuS.detach();
      this.XuS.hFC();
    }
    if (this.Xpz != null)
    {
      this.Xpz.detach();
      this.Xpz.eKd();
    }
    if ((bh.aHB()) && (this.XuS != null))
    {
      bh.beI();
      com.tencent.mm.model.c.bbL().remove(this.XuS);
    }
    AppMethodBeat.o(37912);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37911);
    super.onPause();
    Log.i("MicroMsg.OpenIMAddressUI", "AddressUI on Pause");
    if (this.Xpz != null) {
      this.Xpz.onPause();
    }
    this.XuS.hUh();
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
    if (this.XpP)
    {
      this.XpP = false;
      this.XpO = false;
      hUj();
      this.Een.setAdapter(this.XuS);
      this.Een.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37890);
          Log.i("MicroMsg.OpenIMAddressUI", "post to first init finish");
          View localView = OpenIMAddressUI.OpenIMAddressUIFragment.this.findViewById(R.h.loading_tips_area);
          if (localView != null)
          {
            localView.setVisibility(8);
            localView.startAnimation(AnimationUtils.loadAnimation(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), R.a.fast_faded_out));
          }
          AppMethodBeat.o(37890);
        }
      });
      this.Xpz.Hk(false);
    }
    for (;;)
    {
      if (this.Xpz != null) {
        this.Xpz.onResume();
      }
      this.XuS.VTe = false;
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
      if (this.XpO)
      {
        this.XpO = false;
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
      if (!((bzn)d.c.b(((com.tencent.mm.openim.b.i)paramq).rr.lBS)).Tiq.isEmpty()) {
        hUk();
      }
      AppMethodBeat.o(37905);
      return;
    }
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if (!Util.isTopActivity(getContext()))
    {
      AppMethodBeat.o(37905);
      return;
    }
    if (ac.a.a(getContext(), paramInt1, paramInt2, paramString, 4))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment
 * JD-Core Version:    0.7.0.1
 */