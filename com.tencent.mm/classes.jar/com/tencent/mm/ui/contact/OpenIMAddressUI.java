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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.openim.b.i;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.y.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OpenIMAddressUI
  extends MMActivity
{
  public MMFragment KFM;
  
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
      this.KFM = new OpenIMAddressUIFragment();
      this.KFM.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(2131301022, this.KFM).commit();
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
    implements com.tencent.mm.ak.f
  {
    private com.tencent.mm.ui.voicesearch.b KFQ;
    private String KFS;
    boolean KGh;
    private boolean KGi;
    List<String> KGl;
    private String KKY;
    private x KKZ;
    private Runnable KLa;
    private ProgressDialog fOC;
    com.tencent.mm.pluginsdk.ui.e fPf;
    List<String> fUR;
    private int oef;
    private int oeg;
    private com.tencent.mm.ui.widget.f oeo;
    private n.e qsh;
    private ListView viQ;
    
    public OpenIMAddressUIFragment()
    {
      super();
      AppMethodBeat.i(37902);
      this.KKY = "";
      this.fOC = null;
      this.KFS = "";
      this.KGi = true;
      this.KLa = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37901);
          OpenIMAddressUI.OpenIMAddressUIFragment.i(OpenIMAddressUI.OpenIMAddressUIFragment.this);
          AppMethodBeat.o(37901);
        }
      };
      this.qsh = new n.e()
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
      this.fPf = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(37886);
          ae.i("MicroMsg.OpenIMAddressUI", "[onScroll] firstVisibleItem:%s", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(37886);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(37887);
          ae.i("MicroMsg.OpenIMAddressUI", "[onScrollStateChanged] scrollState:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == 2) {
            com.tencent.mm.ci.d.fyy().gC(OpenIMAddressUI.class.getName() + ".Listview", 4);
          }
          AppMethodBeat.o(37887);
        }
      });
      this.fUR = new LinkedList();
      this.KGl = new LinkedList();
      AppMethodBeat.o(37902);
    }
    
    private void fLW()
    {
      AppMethodBeat.i(37906);
      this.fUR = new LinkedList();
      this.KGl = new LinkedList();
      com.tencent.mm.br.d.fjx();
      this.fUR.add("tmessage");
      this.KGl.addAll(this.fUR);
      if (!this.fUR.contains("officialaccounts")) {
        this.fUR.add("officialaccounts");
      }
      this.fUR.add("helper_entry");
      if (this.KKZ != null) {
        this.KKZ.iy(this.fUR);
      }
      if (this.KFQ != null) {
        this.KFQ.iy(this.KGl);
      }
      AppMethodBeat.o(37906);
    }
    
    private void fLX()
    {
      try
      {
        AppMethodBeat.i(37910);
        long l = System.currentTimeMillis();
        fLW();
        ae.i("MicroMsg.OpenIMAddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (this.KKZ != null)
        {
          ae.v("MicroMsg.OpenIMAddressUI", "post to do refresh");
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37888);
              OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).fLV();
              AppMethodBeat.o(37888);
            }
          });
        }
        if (this.KFQ != null) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37889);
              ae.v("MicroMsg.OpenIMAddressUI", "post search adapter to do refresh");
              OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).a(null, null);
              AppMethodBeat.o(37889);
            }
          });
        }
        ae.i("MicroMsg.OpenIMAddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
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
      com.tencent.mm.kiss.a.b.akR();
      View localView = com.tencent.mm.kiss.a.b.c(getContext(), 2131495056);
      AppMethodBeat.o(37903);
      return localView;
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      AppMethodBeat.i(37908);
      super.onActivityCreated(paramBundle);
      ae.v("MicroMsg.OpenIMAddressUI", "on address ui create");
      bc.ajj().a(138, this);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(453, this);
      this.KKY = getStringExtra("key_openim_acctype_id");
      setMMTitle(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).b(this.KKY, "openim_acct_type_title", a.a.iKm));
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
      setTitleBarDoubleClickListener(this.KLa);
      ae.v("MicroMsg.OpenIMAddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
      this.viQ = ((ListView)findViewById(2131296471));
      this.viQ.setScrollingCacheEnabled(false);
      this.KKZ = new x(getContext(), "@openim.contact", this.KKY);
      this.KKZ.a(new f.a()
      {
        public final void aSR()
        {
          AppMethodBeat.i(37894);
          OpenIMAddressUI.OpenIMAddressUIFragment localOpenIMAddressUIFragment = OpenIMAddressUI.OpenIMAddressUIFragment.this;
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount();
          OpenIMAddressUI.OpenIMAddressUIFragment.b(localOpenIMAddressUIFragment);
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).fLT();
          AppMethodBeat.o(37894);
        }
        
        public final void fzs() {}
      });
      this.KKZ.KFw = true;
      this.KKZ.KLe = this;
      this.KKZ.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dA(View paramAnonymousView)
        {
          AppMethodBeat.i(37895);
          int i = OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(37895);
          return i;
        }
      });
      this.KKZ.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(37896);
          OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(37896);
        }
      });
      this.KKZ.a(new MMSlideDelView.f()
      {
        public final void cQ(Object paramAnonymousObject)
        {
          AppMethodBeat.i(37897);
          if (paramAnonymousObject == null)
          {
            ae.e("MicroMsg.OpenIMAddressUI", "onItemDel object null");
            AppMethodBeat.o(37897);
            return;
          }
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this, paramAnonymousObject.toString());
          AppMethodBeat.o(37897);
        }
      });
      this.KFQ = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
      this.KFQ.yW(true);
      this.oeo = new com.tencent.mm.ui.widget.f(getContext());
      this.viQ.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(37898);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
          boolean bool1;
          if (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null)
          {
            paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this);
            ae.i("MicroMsg.OpenIMAddressUI", paramAnonymousAdapterView);
            paramAnonymousInt -= OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount();
            if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null) || (!OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).Lmd)) {
              break label937;
            }
            bool1 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).Iw(paramAnonymousInt);
            boolean bool2 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).afG(paramAnonymousInt);
            ae.i("MicroMsg.OpenIMAddressUI", "onItemClick ".concat(String.valueOf(bool2)));
            if (!bool2) {
              break label230;
            }
            OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).aZb("");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(37898);
            return;
            paramAnonymousAdapterView = Boolean.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).Lmd);
            break;
            label230:
            if (bool1)
            {
              paramAnonymousView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).afF(paramAnonymousInt);
              paramAnonymousAdapterView = paramAnonymousView.GuF.HId;
              bc.aCg();
              localObject = com.tencent.mm.model.c.azF().BH(paramAnonymousAdapterView);
              if (com.tencent.mm.contact.c.lO(((aw)localObject).field_type))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                paramAnonymousView.putExtra("Contact_Scene", 3);
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                {
                  if (((an)localObject).fug()) {
                    com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  e.a(paramAnonymousView, paramAnonymousAdapterView);
                  com.tencent.mm.br.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                }
              }
              else
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.GuF.HId);
                ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.jga);
                ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.Hed.HId);
                ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.jfY);
                ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bg(paramAnonymousView.jge, paramAnonymousView.jfW, paramAnonymousView.jfX));
                ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.jfV);
                ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.Hhv);
                ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.Hhu);
                ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.Hhy);
                ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.Hhw);
                ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.Hhx);
                ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.HhA.jgg);
                ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.HhA.jgi);
                ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.HhA.jgh);
                if (paramAnonymousView.HhB != null) {}
                try
                {
                  ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.HhB.toByteArray());
                  if ((paramAnonymousView.Hhu & 0x8) > 0) {
                    com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  com.tencent.mm.br.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
                }
                catch (IOException localIOException)
                {
                  for (;;)
                  {
                    ae.printErrStackTrace("MicroMsg.OpenIMAddressUI", localIOException, "", new Object[0]);
                  }
                }
              }
            }
            else
            {
              paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).Ga(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ae.e("MicroMsg.OpenIMAddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37898);
                return;
              }
              paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
              if (com.tencent.mm.model.x.AN(paramAnonymousAdapterView))
              {
                paramAnonymousView = new Intent(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), OpenIMAddressUI.class);
                paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.this;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahE(), "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37898);
                return;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Contact_Scene", 3);
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
                com.tencent.mm.br.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
              }
            }
          }
          label937:
          paramAnonymousAdapterView = (com.tencent.mm.storage.f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).abR(paramAnonymousInt);
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
            if (com.tencent.mm.model.x.AN(paramAnonymousAdapterView))
            {
              ae.e("MicroMsg.OpenIMAddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
            }
            else
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
              if (com.tencent.mm.model.x.Al(paramAnonymousAdapterView)) {
                ((Intent)localObject).putExtra("Is_group_card", true);
              }
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
              {
                e.a((Intent)localObject, paramAnonymousAdapterView);
                com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
              }
            }
          }
        }
      });
      this.viQ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(37899);
          ae.i("MicroMsg.OpenIMAddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt < OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount())
          {
            ae.w("MicroMsg.OpenIMAddressUI", "on item long click, but match header view");
            AppMethodBeat.o(37899);
            return true;
          }
          if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) != null) && (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).Lmd))
          {
            AppMethodBeat.o(37899);
            return true;
          }
          paramAnonymousAdapterView = (com.tencent.mm.storage.f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).abR(paramAnonymousInt - OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            ae.e("MicroMsg.OpenIMAddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount()) });
            AppMethodBeat.o(37899);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if ((com.tencent.mm.model.x.AN(paramAnonymousAdapterView)) || (com.tencent.mm.model.x.AO(paramAnonymousAdapterView)))
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
      this.viQ.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(37900);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(37900);
            return false;
            OpenIMAddressUI.OpenIMAddressUIFragment.this.hideVKB();
            OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawX());
            OpenIMAddressUI.OpenIMAddressUIFragment.b(OpenIMAddressUI.OpenIMAddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.viQ.setOnScrollListener(this.fPf);
      this.viQ.setDrawingCacheEnabled(false);
      bc.aCg();
      com.tencent.mm.model.c.azF().a(this.KKZ);
      AppMethodBeat.o(37908);
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(37907);
      ae.i("MicroMsg.OpenIMAddressUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
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
      bc.aCg();
      an localan = com.tencent.mm.model.c.azF().BH(this.KFS);
      if (localan == null)
      {
        ae.e("MicroMsg.OpenIMAddressUI", "onCreateContextMenu, contact is null, username = " + this.KFS);
        AppMethodBeat.o(37904);
        return;
      }
      if (v.aAC().equals(localan.field_username))
      {
        AppMethodBeat.o(37904);
        return;
      }
      if (com.tencent.mm.model.x.Al(this.KFS))
      {
        paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localan.adG()));
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131755190);
        AppMethodBeat.o(37904);
        return;
      }
      if ((com.tencent.mm.model.x.AA(this.KFS)) || (com.tencent.mm.model.x.AQ(this.KFS)))
      {
        AppMethodBeat.o(37904);
        return;
      }
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localan.adG()));
      if ((com.tencent.mm.contact.c.lO(localan.field_type)) && (localan.field_deleteFlag != 1)) {
        paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131757731);
      }
      AppMethodBeat.o(37904);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(37912);
      super.onDestroy();
      ae.v("MicroMsg.OpenIMAddressUI", "onDestory");
      bc.ajj().b(138, this);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(453, this);
      if (this.KKZ != null)
      {
        this.KKZ.xh(true);
        this.KKZ.detach();
        this.KKZ.fzh();
      }
      if (this.KFQ != null)
      {
        this.KFQ.detach();
        this.KFQ.dhl();
      }
      if ((bc.ajM()) && (this.KKZ != null))
      {
        bc.aCg();
        com.tencent.mm.model.c.azF().b(this.KKZ);
      }
      AppMethodBeat.o(37912);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(37911);
      super.onPause();
      ae.i("MicroMsg.OpenIMAddressUI", "AddressUI on Pause");
      if (this.KFQ != null) {
        this.KFQ.onPause();
      }
      this.KKZ.fLU();
      ar.f(new Runnable()
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
      ae.v("MicroMsg.OpenIMAddressUI", "address ui on resume");
      if (this.KGi)
      {
        this.KGi = false;
        this.KGh = false;
        fLW();
        this.viQ.setAdapter(this.KKZ);
        this.viQ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37890);
            ae.i("MicroMsg.OpenIMAddressUI", "post to first init finish");
            View localView = OpenIMAddressUI.OpenIMAddressUIFragment.this.findViewById(2131301512);
            if (localView != null)
            {
              localView.setVisibility(8);
              localView.startAnimation(AnimationUtils.loadAnimation(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), 2130772048));
            }
            AppMethodBeat.o(37890);
          }
        });
        this.KFQ.yV(false);
      }
      for (;;)
      {
        if (this.KFQ != null) {
          this.KFQ.onResume();
        }
        this.KKZ.JpP = false;
        ar.f(new Runnable()
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
        if (this.KGh)
        {
          this.KGh = false;
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
        if (!((bfv)((i)paramn).rr.hQE.hQJ).GUE.isEmpty()) {
          fLX();
        }
        AppMethodBeat.o(37905);
        return;
      }
      if (this.fOC != null)
      {
        this.fOC.dismiss();
        this.fOC = null;
      }
      if (!bu.jn(getContext()))
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