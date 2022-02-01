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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.openim.model.l;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ae.a;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.g.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OpenIMAddressUI
  extends MMActivity
{
  public MMFragment afaX;
  
  public int getLayoutId()
  {
    return R.i.gmL;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37918);
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.findFragmentById(16908290) == null)
    {
      this.afaX = new OpenIMAddressUIFragment();
      this.afaX.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(R.h.fKD, this.afaX).FW();
    }
    AppMethodBeat.o(37918);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class OpenIMAddressUIFragment
    extends MMFragment
    implements com.tencent.mm.am.h
  {
    private ListView JVY;
    com.tencent.mm.pluginsdk.ui.e adKd;
    private com.tencent.mm.ui.voicesearch.b afbb;
    private String afbd;
    boolean afbq;
    private boolean afbr;
    List<String> afbv;
    private String afgP;
    private aa afgQ;
    private Runnable afgR;
    List<String> lMF;
    private ProgressDialog lzP;
    private com.tencent.mm.ui.widget.h vDS;
    private int x_down;
    private u.i yBn;
    private int y_down;
    
    public OpenIMAddressUIFragment()
    {
      super();
      AppMethodBeat.i(37902);
      this.afgP = "";
      this.lzP = null;
      this.afbd = "";
      this.afbr = true;
      this.afgR = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37901);
          OpenIMAddressUI.OpenIMAddressUIFragment.i(OpenIMAddressUI.OpenIMAddressUIFragment.this);
          AppMethodBeat.o(37901);
        }
      };
      this.yBn = new u.i()
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
      this.adKd = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
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
      this.lMF = new LinkedList();
      this.afbv = new LinkedList();
      AppMethodBeat.o(37902);
    }
    
    private void jxZ()
    {
      AppMethodBeat.i(37906);
      this.lMF = new LinkedList();
      this.afbv = new LinkedList();
      if (com.tencent.mm.br.c.iPe()) {
        this.lMF.add("filehelper");
      }
      this.lMF.add("tmessage");
      this.afbv.addAll(this.lMF);
      if (!this.lMF.contains("officialaccounts")) {
        this.lMF.add("officialaccounts");
      }
      this.lMF.add("helper_entry");
      if (this.afgQ != null) {
        this.afgQ.nM(this.lMF);
      }
      if (this.afbb != null) {
        this.afbb.nM(this.afbv);
      }
      AppMethodBeat.o(37906);
    }
    
    private void jya()
    {
      try
      {
        AppMethodBeat.i(37910);
        long l = System.currentTimeMillis();
        jxZ();
        Log.i("MicroMsg.OpenIMAddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (this.afgQ != null)
        {
          Log.v("MicroMsg.OpenIMAddressUI", "post to do refresh");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37888);
              OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).jxY();
              AppMethodBeat.o(37888);
            }
          });
        }
        if (this.afbb != null) {
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
      return R.i.gmM;
    }
    
    public View getLayoutView()
    {
      AppMethodBeat.i(37903);
      com.tencent.mm.kiss.layout.b.bbG();
      View localView = com.tencent.mm.kiss.layout.b.d(getContext(), R.i.gmM);
      AppMethodBeat.o(37903);
      return localView;
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      AppMethodBeat.i(37908);
      super.onActivityCreated(paramBundle);
      Log.v("MicroMsg.OpenIMAddressUI", "on address ui create");
      bh.aZW().a(138, this);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(453, this);
      this.afgP = getStringExtra("key_openim_acctype_id");
      setMMTitle(((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).b(this.afgP, "openim_acct_type_title", e.a.prb));
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
      setTitleBarDoubleClickListener(this.afgR);
      Log.v("MicroMsg.OpenIMAddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
      this.JVY = ((ListView)findViewById(R.h.address_contactlist));
      this.JVY.setScrollingCacheEnabled(false);
      this.afgQ = new aa(getContext(), "@openim.contact", this.afgP);
      this.afgQ.a(new g.a()
      {
        public final void bWC()
        {
          AppMethodBeat.i(37894);
          OpenIMAddressUI.OpenIMAddressUIFragment localOpenIMAddressUIFragment = OpenIMAddressUI.OpenIMAddressUIFragment.this;
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount();
          OpenIMAddressUI.OpenIMAddressUIFragment.b(localOpenIMAddressUIFragment);
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).jxW();
          AppMethodBeat.o(37894);
        }
        
        public final void jia() {}
      });
      this.afgQ.afaH = true;
      this.afgQ.afgV = this;
      this.afgQ.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int eB(View paramAnonymousView)
        {
          AppMethodBeat.i(37895);
          int i = OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(37895);
          return i;
        }
      });
      this.afgQ.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(37896);
          OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(37896);
        }
      });
      this.afgQ.a(new MMSlideDelView.f()
      {
        public final void es(Object paramAnonymousObject)
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
      this.afbb = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
      this.afbb.Nh(true);
      this.vDS = new com.tencent.mm.ui.widget.h(getContext());
      this.JVY.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(37898);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
          boolean bool1;
          if (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null)
          {
            paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this);
            Log.i("MicroMsg.OpenIMAddressUI", paramAnonymousAdapterView);
            paramAnonymousInt -= OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount();
            if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null) || (!OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).afRG)) {
              break label937;
            }
            bool1 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).XL(paramAnonymousInt);
            boolean bool2 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).aEl(paramAnonymousInt);
            Log.i("MicroMsg.OpenIMAddressUI", "onItemClick ".concat(String.valueOf(bool2)));
            if (!bool2) {
              break label230;
            }
            OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).bDp("");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(37898);
            return;
            paramAnonymousAdapterView = Boolean.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).afRG);
            break;
            label230:
            if (bool1)
            {
              paramAnonymousView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).aEk(paramAnonymousInt);
              paramAnonymousAdapterView = paramAnonymousView.ZqL.abwM;
              bh.bCz();
              localObject = com.tencent.mm.model.c.bzA().JE(paramAnonymousAdapterView);
              if (d.rs(((az)localObject).field_type))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                paramAnonymousView.putExtra("Contact_Scene", 3);
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                {
                  if (((au)localObject).iZC()) {
                    com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  e.a(paramAnonymousView, paramAnonymousAdapterView);
                  com.tencent.mm.br.c.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                }
              }
              else
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.ZqL.abwM);
                ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.pSk);
                ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.aaIz.abwM);
                ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.pSi);
                ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bI(paramAnonymousView.pSo, paramAnonymousView.pSg, paramAnonymousView.pSh));
                ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.pSf);
                ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.aaMn);
                ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.aaMm);
                ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.aaMq);
                ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.aaMo);
                ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.aaMp);
                ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.aaMs.pSq);
                ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.aaMs.pSs);
                ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.aaMs.pSr);
                if (paramAnonymousView.aaMt != null) {}
                try
                {
                  ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.aaMt.toByteArray());
                  if ((paramAnonymousView.aaMm & 0x8) > 0) {
                    com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramAnonymousAdapterView + ",3");
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
              paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).TF(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                Log.e("MicroMsg.OpenIMAddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37898);
                return;
              }
              paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
              if (au.bwp(paramAnonymousAdapterView))
              {
                paramAnonymousView = new Intent(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), OpenIMAddressUI.class);
                paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.this;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aYi(), "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
          paramAnonymousAdapterView = (f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).azn(paramAnonymousInt);
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
            if (au.bwp(paramAnonymousAdapterView))
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
      this.JVY.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
          if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) != null) && (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).afRG))
          {
            AppMethodBeat.o(37899);
            return true;
          }
          paramAnonymousAdapterView = (f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).azn(paramAnonymousInt - OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            Log.e("MicroMsg.OpenIMAddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount()) });
            AppMethodBeat.o(37899);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if ((au.bwp(paramAnonymousAdapterView)) || (au.bwq(paramAnonymousAdapterView)))
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
      this.JVY.setOnTouchListener(new View.OnTouchListener()
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
      this.JVY.setOnScrollListener(this.adKd);
      this.JVY.setDrawingCacheEnabled(false);
      bh.bCz();
      com.tencent.mm.model.c.bzA().add(this.afgQ);
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
      bh.bCz();
      au localau = com.tencent.mm.model.c.bzA().JE(this.afbd);
      if (localau == null)
      {
        Log.e("MicroMsg.OpenIMAddressUI", "onCreateContextMenu, contact is null, username = " + this.afbd);
        AppMethodBeat.o(37904);
        return;
      }
      if (z.bAM().equals(localau.field_username))
      {
        AppMethodBeat.o(37904);
        return;
      }
      if (ab.IQ(this.afbd))
      {
        paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.p.b(paramView.getContext(), localau.aSV()));
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.gqu);
        AppMethodBeat.o(37904);
        return;
      }
      if ((au.bwc(this.afbd)) || (au.bws(this.afbd)))
      {
        AppMethodBeat.o(37904);
        return;
      }
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.p.b(paramView.getContext(), localau.aSV()));
      if ((d.rs(localau.field_type)) && (localau.field_deleteFlag != 1)) {
        paramContextMenu.add(paramContextMenuInfo.position, 7, 0, R.l.gBA);
      }
      AppMethodBeat.o(37904);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(37912);
      super.onDestroy();
      Log.v("MicroMsg.OpenIMAddressUI", "onDestory");
      bh.aZW().b(138, this);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(453, this);
      if (this.afgQ != null)
      {
        this.afgQ.KV(true);
        this.afgQ.detach();
        this.afgQ.jhO();
      }
      if (this.afbb != null)
      {
        this.afbb.detach();
        this.afbb.fSd();
      }
      if ((bh.baz()) && (this.afgQ != null))
      {
        bh.bCz();
        com.tencent.mm.model.c.bzA().remove(this.afgQ);
      }
      AppMethodBeat.o(37912);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(37911);
      super.onPause();
      Log.i("MicroMsg.OpenIMAddressUI", "AddressUI on Pause");
      if (this.afbb != null) {
        this.afbb.onPause();
      }
      this.afgQ.jxX();
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
      if (this.afbr)
      {
        this.afbr = false;
        this.afbq = false;
        jxZ();
        this.JVY.setAdapter(this.afgQ);
        this.JVY.post(new Runnable()
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
        this.afbb.Ng(false);
      }
      for (;;)
      {
        if (this.afbb != null) {
          this.afbb.onResume();
        }
        this.afgQ.adxn = false;
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
        if (this.afbq)
        {
          this.afbq = false;
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
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(37905);
      if (paramp.getType() == 453)
      {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(37905);
          return;
        }
        if (!((cow)c.c.b(((l)paramp).rr.otC)).aavO.isEmpty()) {
          jya();
        }
        AppMethodBeat.o(37905);
        return;
      }
      if (this.lzP != null)
      {
        this.lzP.dismiss();
        this.lzP = null;
      }
      if (!Util.isTopActivity(getContext()))
      {
        AppMethodBeat.o(37905);
        return;
      }
      if (ae.a.a(getContext(), paramInt1, paramInt2, paramString, 4))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI
 * JD-Core Version:    0.7.0.1
 */