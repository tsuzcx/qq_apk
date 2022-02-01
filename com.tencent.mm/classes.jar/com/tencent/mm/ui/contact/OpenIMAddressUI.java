package com.tencent.mm.ui.contact;

import android.app.Activity;
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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.b.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.y.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OpenIMAddressUI
  extends MMActivity
{
  public MMFragment IsM;
  
  public int getLayoutId()
  {
    return 2131495054;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37918);
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.findFragmentById(16908290) == null)
    {
      this.IsM = new OpenIMAddressUIFragment();
      this.IsM.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(2131301022, this.IsM).commit();
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
    implements com.tencent.mm.ak.g
  {
    private com.tencent.mm.ui.voicesearch.b IsQ;
    private String IsS;
    boolean Ith;
    private boolean Iti;
    List<String> Itl;
    private String IxW;
    private x IxX;
    private Runnable IxY;
    com.tencent.mm.pluginsdk.ui.d ftW;
    private ProgressDialog fts;
    List<String> fzw;
    private int nwY;
    private int nwZ;
    private com.tencent.mm.ui.widget.f nxh;
    private n.d pHX;
    private ListView tUA;
    
    public OpenIMAddressUIFragment()
    {
      super();
      AppMethodBeat.i(37902);
      this.IxW = "";
      this.fts = null;
      this.IsS = "";
      this.Iti = true;
      this.IxY = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37901);
          OpenIMAddressUI.OpenIMAddressUIFragment.i(OpenIMAddressUI.OpenIMAddressUIFragment.this);
          AppMethodBeat.o(37901);
        }
      };
      this.pHX = new n.d()
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
      this.ftW = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(37886);
          ac.i("MicroMsg.OpenIMAddressUI", "[onScroll] firstVisibleItem:%s", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(37886);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(37887);
          ac.i("MicroMsg.OpenIMAddressUI", "[onScrollStateChanged] scrollState:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == 2) {
            com.tencent.mm.cj.d.feq().fW(OpenIMAddressUI.class.getName() + ".Listview", 4);
          }
          AppMethodBeat.o(37887);
        }
      });
      this.fzw = new LinkedList();
      this.Itl = new LinkedList();
      AppMethodBeat.o(37902);
    }
    
    private void fqR()
    {
      AppMethodBeat.i(37906);
      this.fzw = new LinkedList();
      this.Itl = new LinkedList();
      com.tencent.mm.br.d.eQD();
      this.fzw.add("tmessage");
      this.Itl.addAll(this.fzw);
      if (!this.fzw.contains("officialaccounts")) {
        this.fzw.add("officialaccounts");
      }
      this.fzw.add("helper_entry");
      if (this.IxX != null) {
        this.IxX.ic(this.fzw);
      }
      if (this.IsQ != null) {
        this.IsQ.ic(this.Itl);
      }
      AppMethodBeat.o(37906);
    }
    
    private void fqS()
    {
      try
      {
        AppMethodBeat.i(37910);
        long l = System.currentTimeMillis();
        fqR();
        ac.i("MicroMsg.OpenIMAddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (this.IxX != null)
        {
          ac.v("MicroMsg.OpenIMAddressUI", "post to do refresh");
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37888);
              OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).fqQ();
              AppMethodBeat.o(37888);
            }
          });
        }
        if (this.IsQ != null) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37889);
              ac.v("MicroMsg.OpenIMAddressUI", "post search adapter to do refresh");
              OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).a(null, null);
              AppMethodBeat.o(37889);
            }
          });
        }
        ac.i("MicroMsg.OpenIMAddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
        AppMethodBeat.o(37910);
        return;
      }
      finally {}
    }
    
    public int getLayoutId()
    {
      return 2131495056;
    }
    
    public View getLayoutView()
    {
      AppMethodBeat.i(37903);
      com.tencent.mm.kiss.a.b.ahR();
      View localView = com.tencent.mm.kiss.a.b.c(getContext(), 2131495056);
      AppMethodBeat.o(37903);
      return localView;
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      AppMethodBeat.i(37908);
      super.onActivityCreated(paramBundle);
      ac.v("MicroMsg.OpenIMAddressUI", "on address ui create");
      az.agi().a(138, this);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(453, this);
      this.IxW = getStringExtra("key_openim_acctype_id");
      setMMTitle(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).b(this.IxW, "openim_acct_type_title", b.a.inW));
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
      setTitleBarDoubleClickListener(this.IxY);
      ac.v("MicroMsg.OpenIMAddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
      this.tUA = ((ListView)findViewById(2131296471));
      this.tUA.setScrollingCacheEnabled(false);
      this.IxX = new x(getContext(), "@openim.contact", this.IxW);
      this.IxX.a(new f.a()
      {
        public final void aPg()
        {
          AppMethodBeat.i(37894);
          OpenIMAddressUI.OpenIMAddressUIFragment localOpenIMAddressUIFragment = OpenIMAddressUI.OpenIMAddressUIFragment.this;
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount();
          OpenIMAddressUI.OpenIMAddressUIFragment.b(localOpenIMAddressUIFragment);
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).fqO();
          AppMethodBeat.o(37894);
        }
        
        public final void ffk() {}
      });
      this.IxX.Isx = true;
      this.IxX.Iyc = this;
      this.IxX.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dy(View paramAnonymousView)
        {
          AppMethodBeat.i(37895);
          int i = OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(37895);
          return i;
        }
      });
      this.IxX.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(37896);
          OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(37896);
        }
      });
      this.IxX.a(new MMSlideDelView.f()
      {
        public final void cN(Object paramAnonymousObject)
        {
          AppMethodBeat.i(37897);
          if (paramAnonymousObject == null)
          {
            ac.e("MicroMsg.OpenIMAddressUI", "onItemDel object null");
            AppMethodBeat.o(37897);
            return;
          }
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this, paramAnonymousObject.toString());
          AppMethodBeat.o(37897);
        }
      });
      this.IsQ = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
      this.IsQ.xU(true);
      this.nxh = new com.tencent.mm.ui.widget.f(getContext());
      this.tUA.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(37898);
          paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
          if (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null) {}
          boolean bool1;
          for (paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this);; paramAnonymousAdapterView = Boolean.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).IYA))
          {
            ac.i("MicroMsg.OpenIMAddressUI", paramAnonymousAdapterView);
            paramAnonymousInt -= OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount();
            if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null) || (!OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).IYA)) {
              break label861;
            }
            bool1 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).GF(paramAnonymousInt);
            boolean bool2 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).acA(paramAnonymousInt);
            ac.i("MicroMsg.OpenIMAddressUI", "onItemClick ".concat(String.valueOf(bool2)));
            if (!bool2) {
              break;
            }
            OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).aRB("");
            AppMethodBeat.o(37898);
            return;
          }
          Object localObject;
          if (bool1)
          {
            paramAnonymousView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).acy(paramAnonymousInt);
            paramAnonymousAdapterView = paramAnonymousView.EuE.FEm;
            az.ayM();
            localObject = c.awB().aNt(paramAnonymousAdapterView);
            if (com.tencent.mm.n.b.ln(((av)localObject).field_type))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Contact_Scene", 3);
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
              {
                if (((ai)localObject).fad()) {
                  h.wUl.kvStat(10298, paramAnonymousAdapterView + ",3");
                }
                e.a(paramAnonymousView, paramAnonymousAdapterView);
                com.tencent.mm.br.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
              }
              AppMethodBeat.o(37898);
              return;
            }
            localObject = new Intent();
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.EuE.FEm);
            ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.iJY);
            ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.Fbd.FEm);
            ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.iJW);
            ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.aW(paramAnonymousView.iKc, paramAnonymousView.iJU, paramAnonymousView.iJV));
            ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.iJT);
            ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.Fer);
            ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.Feq);
            ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.Feu);
            ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.Fes);
            ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.Fet);
            ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.Few.iKe);
            ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.Few.iKg);
            ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.Few.iKf);
            if (paramAnonymousView.Fex != null) {}
            try
            {
              ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.Fex.toByteArray());
              if ((paramAnonymousView.Feq & 0x8) > 0) {
                h.wUl.kvStat(10298, paramAnonymousAdapterView + ",3");
              }
              com.tencent.mm.br.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
              AppMethodBeat.o(37898);
              return;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                ac.printErrStackTrace("MicroMsg.OpenIMAddressUI", localIOException, "", new Object[0]);
              }
            }
          }
          paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).acz(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            ac.e("MicroMsg.OpenIMAddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
            AppMethodBeat.o(37898);
            return;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if (w.xg(paramAnonymousAdapterView))
          {
            paramAnonymousView = new Intent(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), OpenIMAddressUI.class);
            paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.aeD(), "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(37898);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
          paramAnonymousView.putExtra("Contact_Scene", 3);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
            com.tencent.mm.br.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
          }
          AppMethodBeat.o(37898);
          return;
          label861:
          paramAnonymousAdapterView = (com.tencent.mm.storage.f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).Za(paramAnonymousInt);
          if (paramAnonymousAdapterView != null)
          {
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            paramAnonymousView = OpenIMAddressUI.OpenIMAddressUIFragment.this;
            if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.length() <= 0))
            {
              AppMethodBeat.o(37898);
              return;
            }
            if (w.xg(paramAnonymousAdapterView))
            {
              ac.e("MicroMsg.OpenIMAddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
              AppMethodBeat.o(37898);
              return;
            }
            localObject = new Intent();
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
            if (w.wE(paramAnonymousAdapterView)) {
              ((Intent)localObject).putExtra("Is_group_card", true);
            }
            if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
            {
              e.a((Intent)localObject, paramAnonymousAdapterView);
              com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
            }
          }
          AppMethodBeat.o(37898);
        }
      });
      this.tUA.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(37899);
          ac.i("MicroMsg.OpenIMAddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt < OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount())
          {
            ac.w("MicroMsg.OpenIMAddressUI", "on item long click, but match header view");
            AppMethodBeat.o(37899);
            return true;
          }
          if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) != null) && (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).IYA))
          {
            AppMethodBeat.o(37899);
            return true;
          }
          paramAnonymousAdapterView = (com.tencent.mm.storage.f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).Za(paramAnonymousInt - OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            ac.e("MicroMsg.OpenIMAddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount()) });
            AppMethodBeat.o(37899);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if ((w.xg(paramAnonymousAdapterView)) || (w.xh(paramAnonymousAdapterView)))
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
      this.tUA.setOnTouchListener(new View.OnTouchListener()
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
      this.tUA.setOnScrollListener(this.ftW);
      this.tUA.setDrawingCacheEnabled(false);
      az.ayM();
      c.awB().a(this.IxX);
      AppMethodBeat.o(37908);
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(37907);
      ac.i("MicroMsg.OpenIMAddressUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
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
      az.ayM();
      ai localai = c.awB().aNt(this.IsS);
      if (localai == null)
      {
        ac.e("MicroMsg.OpenIMAddressUI", "onCreateContextMenu, contact is null, username = " + this.IsS);
        AppMethodBeat.o(37904);
        return;
      }
      if (u.axw().equals(localai.field_username))
      {
        AppMethodBeat.o(37904);
        return;
      }
      if (w.wE(this.IsS))
      {
        paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localai.aaS()));
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131755190);
        AppMethodBeat.o(37904);
        return;
      }
      if ((w.wT(this.IsS)) || (w.xj(this.IsS)))
      {
        AppMethodBeat.o(37904);
        return;
      }
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localai.aaS()));
      if ((com.tencent.mm.n.b.ln(localai.field_type)) && (localai.field_deleteFlag != 1)) {
        paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131757731);
      }
      AppMethodBeat.o(37904);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(37912);
      super.onDestroy();
      ac.v("MicroMsg.OpenIMAddressUI", "onDestory");
      az.agi().b(138, this);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(453, this);
      if (this.IxX != null)
      {
        this.IxX.wn(true);
        this.IxX.detach();
        this.IxX.feY();
      }
      if (this.IsQ != null)
      {
        this.IsQ.detach();
        this.IsQ.cVi();
      }
      if ((az.agM()) && (this.IxX != null))
      {
        az.ayM();
        c.awB().b(this.IxX);
      }
      AppMethodBeat.o(37912);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(37911);
      super.onPause();
      ac.i("MicroMsg.OpenIMAddressUI", "AddressUI on Pause");
      if (this.IsQ != null) {
        this.IsQ.onPause();
      }
      this.IxX.fqP();
      ap.f(new Runnable()
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
      ac.v("MicroMsg.OpenIMAddressUI", "address ui on resume");
      if (this.Iti)
      {
        this.Iti = false;
        this.Ith = false;
        fqR();
        this.tUA.setAdapter(this.IxX);
        this.tUA.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37890);
            ac.i("MicroMsg.OpenIMAddressUI", "post to first init finish");
            View localView = OpenIMAddressUI.OpenIMAddressUIFragment.this.findViewById(2131301512);
            if (localView != null)
            {
              localView.setVisibility(8);
              localView.startAnimation(AnimationUtils.loadAnimation(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), 2130772048));
            }
            AppMethodBeat.o(37890);
          }
        });
        this.IsQ.xT(false);
      }
      for (;;)
      {
        if (this.IsQ != null) {
          this.IsQ.onResume();
        }
        this.IxX.HhQ = false;
        ap.f(new Runnable()
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
        if (this.Ith)
        {
          this.Ith = false;
          com.tencent.mm.sdk.g.b.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37891);
              Process.setThreadPriority(10);
              OpenIMAddressUI.OpenIMAddressUIFragment.k(OpenIMAddressUI.OpenIMAddressUIFragment.this);
              AppMethodBeat.o(37891);
            }
          }, "AddressUI_updateUIData");
        }
      }
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(37905);
      if (paramn.getType() == 453)
      {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(37905);
          return;
        }
        if (!((bbb)((i)paramn).rr.hvs.hvw).ERM.isEmpty()) {
          fqS();
        }
        AppMethodBeat.o(37905);
        return;
      }
      if (this.fts != null)
      {
        this.fts.dismiss();
        this.fts = null;
      }
      if (!bs.iX(getContext()))
      {
        AppMethodBeat.o(37905);
        return;
      }
      if (y.a.a(getContext(), paramInt1, paramInt2, paramString, 4))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI
 * JD-Core Version:    0.7.0.1
 */