package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.b.i;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.v.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OpenIMAddressUI$OpenIMAddressUIFragment
  extends MMFragment
  implements com.tencent.mm.ai.f
{
  boolean AaH;
  private boolean AaI;
  List<String> AaM;
  private com.tencent.mm.ui.voicesearch.b Aar;
  private String Aat;
  private String Aep;
  private u Aeq;
  private Runnable Aer;
  private ProgressDialog eeN;
  com.tencent.mm.pluginsdk.ui.d efo;
  List<String> ejc;
  private int jUm;
  private int jUn;
  private com.tencent.mm.ui.widget.f jUq;
  private n.d lNZ;
  private ListView nYW;
  
  public OpenIMAddressUI$OpenIMAddressUIFragment()
  {
    super(true);
    AppMethodBeat.i(33784);
    this.Aep = "";
    this.eeN = null;
    this.Aat = "";
    this.AaI = true;
    this.Aer = new OpenIMAddressUI.OpenIMAddressUIFragment.18(this);
    this.lNZ = new OpenIMAddressUI.OpenIMAddressUIFragment.3(this);
    this.efo = new com.tencent.mm.pluginsdk.ui.d(new OpenIMAddressUI.OpenIMAddressUIFragment.4(this));
    this.ejc = new LinkedList();
    this.AaM = new LinkedList();
    AppMethodBeat.o(33784);
  }
  
  private void dLE()
  {
    AppMethodBeat.i(33788);
    this.ejc = new LinkedList();
    this.AaM = new LinkedList();
    com.tencent.mm.bq.d.dpU();
    this.ejc.add("tmessage");
    this.AaM.addAll(this.ejc);
    if (!this.ejc.contains("officialaccounts")) {
      this.ejc.add("officialaccounts");
    }
    this.ejc.add("helper_entry");
    if (this.Aeq != null) {
      this.Aeq.ft(this.ejc);
    }
    if (this.Aar != null) {
      this.Aar.ft(this.AaM);
    }
    AppMethodBeat.o(33788);
  }
  
  private void dLF()
  {
    try
    {
      AppMethodBeat.i(33792);
      long l = System.currentTimeMillis();
      dLE();
      ab.i("MicroMsg.OpenIMAddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
      if (this.Aeq != null)
      {
        ab.v("MicroMsg.OpenIMAddressUI", "post to do refresh");
        al.d(new OpenIMAddressUI.OpenIMAddressUIFragment.5(this));
      }
      if (this.Aar != null) {
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33771);
            ab.v("MicroMsg.OpenIMAddressUI", "post search adapter to do refresh");
            OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).a(null, null);
            AppMethodBeat.o(33771);
          }
        });
      }
      ab.i("MicroMsg.OpenIMAddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(33792);
      return;
    }
    finally {}
  }
  
  public int getLayoutId()
  {
    return 2130970392;
  }
  
  public View getLayoutView()
  {
    AppMethodBeat.i(33785);
    com.tencent.mm.kiss.a.b.SH();
    View localView = com.tencent.mm.kiss.a.b.b(getContext(), 2130970392);
    AppMethodBeat.o(33785);
    return localView;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(33790);
    super.onActivityCreated(paramBundle);
    ab.v("MicroMsg.OpenIMAddressUI", "on address ui create");
    aw.Rc().a(138, this);
    g.RM();
    g.RK().eHt.a(453, this);
    this.Aep = getStringExtra("key_openim_acctype_id");
    setMMTitle(((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).b(this.Aep, "openim_acct_type_title", b.a.gfD));
    setBackBtn(new OpenIMAddressUI.OpenIMAddressUIFragment.1(this));
    setTitleBarDoubleClickListener(this.Aer);
    ab.v("MicroMsg.OpenIMAddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
    this.nYW = ((ListView)findViewById(2131821074));
    this.nYW.setScrollingCacheEnabled(false);
    this.Aeq = new u(getContext(), "@openim.contact", this.Aep);
    this.Aeq.a(new OpenIMAddressUI.OpenIMAddressUIFragment.11(this));
    this.Aeq.zZX = true;
    this.Aeq.Aev = this;
    this.Aeq.setGetViewPositionCallback(new OpenIMAddressUI.OpenIMAddressUIFragment.12(this));
    this.Aeq.setPerformItemClickListener(new OpenIMAddressUI.OpenIMAddressUIFragment.13(this));
    this.Aeq.a(new OpenIMAddressUI.OpenIMAddressUIFragment.14(this));
    this.Aar = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.Aar.rz(true);
    this.jUq = new com.tencent.mm.ui.widget.f(getContext());
    this.nYW.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33780);
        paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
        if (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null) {}
        boolean bool1;
        for (paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this);; paramAnonymousAdapterView = Boolean.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).ABF))
        {
          ab.i("MicroMsg.OpenIMAddressUI", paramAnonymousAdapterView);
          paramAnonymousInt -= OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount();
          if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null) || (!OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).ABF)) {
            break label792;
          }
          bool1 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).xj(paramAnonymousInt);
          boolean bool2 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).QW(paramAnonymousInt);
          ab.i("MicroMsg.OpenIMAddressUI", "onItemClick ".concat(String.valueOf(bool2)));
          if (!bool2) {
            break;
          }
          OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).avg("");
          AppMethodBeat.o(33780);
          return;
        }
        Object localObject;
        if (bool1)
        {
          paramAnonymousView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).QU(paramAnonymousInt);
          paramAnonymousAdapterView = paramAnonymousView.wOT.xJE;
          aw.aaz();
          localObject = c.YA().arw(paramAnonymousAdapterView);
          if (a.je(((aq)localObject).field_type))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
            paramAnonymousView.putExtra("Contact_Scene", 3);
            if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
            {
              if (((ad)localObject).dwz()) {
                h.qsU.kvStat(10298, paramAnonymousAdapterView + ",3");
              }
              e.a(paramAnonymousView, paramAnonymousAdapterView);
              com.tencent.mm.bq.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
            }
            AppMethodBeat.o(33780);
            return;
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.wOT.xJE);
          ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.gwU);
          ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.xmi.xJE);
          ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.gwS);
          ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.aF(paramAnonymousView.gwY, paramAnonymousView.gwQ, paramAnonymousView.gwR));
          ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.gwP);
          ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.xpf);
          ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.xpe);
          ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.xpi);
          ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.xpg);
          ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.xph);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.xpk.gxa);
          ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.xpk.gxc);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.xpk.gxb);
          if (paramAnonymousView.xpl != null) {}
          try
          {
            ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.xpl.toByteArray());
            if ((paramAnonymousView.xpe & 0x8) > 0) {
              h.qsU.kvStat(10298, paramAnonymousAdapterView + ",3");
            }
            com.tencent.mm.bq.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
            AppMethodBeat.o(33780);
            return;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.OpenIMAddressUI", localIOException, "", new Object[0]);
            }
          }
        }
        paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).QV(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ab.e("MicroMsg.OpenIMAddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(33780);
          return;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        if (t.ot(paramAnonymousAdapterView))
        {
          paramAnonymousAdapterView = new Intent(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), OpenIMAddressUI.class);
          paramAnonymousAdapterView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
          OpenIMAddressUI.OpenIMAddressUIFragment.this.startActivity(paramAnonymousAdapterView);
          AppMethodBeat.o(33780);
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
        paramAnonymousView.putExtra("Contact_Scene", 3);
        if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
          com.tencent.mm.bq.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
        }
        AppMethodBeat.o(33780);
        return;
        label792:
        paramAnonymousAdapterView = (com.tencent.mm.storage.f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).NM(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          paramAnonymousView = OpenIMAddressUI.OpenIMAddressUIFragment.this;
          if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.length() <= 0))
          {
            AppMethodBeat.o(33780);
            return;
          }
          if (t.ot(paramAnonymousAdapterView))
          {
            ab.e("MicroMsg.OpenIMAddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
            AppMethodBeat.o(33780);
            return;
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
          if (t.nR(paramAnonymousAdapterView)) {
            ((Intent)localObject).putExtra("Is_group_card", true);
          }
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
          {
            e.a((Intent)localObject, paramAnonymousAdapterView);
            com.tencent.mm.bq.d.b(paramAnonymousView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
          }
        }
        AppMethodBeat.o(33780);
      }
    });
    this.nYW.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33781);
        ab.i("MicroMsg.OpenIMAddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt < OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount())
        {
          ab.w("MicroMsg.OpenIMAddressUI", "on item long click, but match header view");
          AppMethodBeat.o(33781);
          return true;
        }
        if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) != null) && (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).ABF))
        {
          AppMethodBeat.o(33781);
          return true;
        }
        paramAnonymousAdapterView = (com.tencent.mm.storage.f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).NM(paramAnonymousInt - OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount());
        if (paramAnonymousAdapterView == null)
        {
          ab.e("MicroMsg.OpenIMAddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount()) });
          AppMethodBeat.o(33781);
          return true;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        if ((t.ot(paramAnonymousAdapterView)) || (t.ou(paramAnonymousAdapterView)))
        {
          AppMethodBeat.o(33781);
          return true;
        }
        OpenIMAddressUI.OpenIMAddressUIFragment.b(OpenIMAddressUI.OpenIMAddressUIFragment.this, paramAnonymousAdapterView);
        OpenIMAddressUI.OpenIMAddressUIFragment.h(OpenIMAddressUI.OpenIMAddressUIFragment.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, OpenIMAddressUI.OpenIMAddressUIFragment.this, OpenIMAddressUI.OpenIMAddressUIFragment.e(OpenIMAddressUI.OpenIMAddressUIFragment.this), OpenIMAddressUI.OpenIMAddressUIFragment.f(OpenIMAddressUI.OpenIMAddressUIFragment.this), OpenIMAddressUI.OpenIMAddressUIFragment.g(OpenIMAddressUI.OpenIMAddressUIFragment.this));
        AppMethodBeat.o(33781);
        return true;
      }
    });
    this.nYW.setOnTouchListener(new OpenIMAddressUI.OpenIMAddressUIFragment.17(this));
    this.nYW.setOnScrollListener(this.efo);
    this.nYW.setDrawingCacheEnabled(false);
    aw.aaz();
    c.YA().a(this.Aeq);
    AppMethodBeat.o(33790);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(33789);
    ab.i("MicroMsg.OpenIMAddressUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
    if ((paramInt1 == 6) && (paramInt2 == -1))
    {
      setResult(-1);
      finish();
      AppMethodBeat.o(33789);
      return;
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(33789);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33789);
      return;
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(33786);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    aw.aaz();
    ad localad = c.YA().arw(this.Aat);
    if (localad == null)
    {
      ab.e("MicroMsg.OpenIMAddressUI", "onCreateContextMenu, contact is null, username = " + this.Aat);
      AppMethodBeat.o(33786);
      return;
    }
    if (r.Zn().equals(localad.field_username))
    {
      AppMethodBeat.o(33786);
      return;
    }
    if (t.nR(this.Aat))
    {
      paramContextMenu.setHeaderTitle(j.b(paramView.getContext(), localad.Of()));
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131296458);
      AppMethodBeat.o(33786);
      return;
    }
    if ((t.og(this.Aat)) || (t.ow(this.Aat)))
    {
      AppMethodBeat.o(33786);
      return;
    }
    paramContextMenu.setHeaderTitle(j.b(paramView.getContext(), localad.Of()));
    if ((a.je(localad.field_type)) && (localad.field_deleteFlag != 1)) {
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131298670);
    }
    AppMethodBeat.o(33786);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33794);
    super.onDestroy();
    ab.v("MicroMsg.OpenIMAddressUI", "onDestory");
    aw.Rc().b(138, this);
    g.RM();
    g.RK().eHt.b(453, this);
    if (this.Aeq != null)
    {
      this.Aeq.qd(true);
      this.Aeq.detach();
      this.Aeq.dAW();
    }
    if (this.Aar != null)
    {
      this.Aar.detach();
      this.Aar.bKb();
    }
    if ((aw.RG()) && (this.Aeq != null))
    {
      aw.aaz();
      c.YA().b(this.Aeq);
    }
    AppMethodBeat.o(33794);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33793);
    super.onPause();
    ab.i("MicroMsg.OpenIMAddressUI", "AddressUI on Pause");
    if (this.Aar != null) {
      this.Aar.onPause();
    }
    this.Aeq.dLC();
    al.d(new OpenIMAddressUI.OpenIMAddressUIFragment.10(this));
    AppMethodBeat.o(33793);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33791);
    super.onResume();
    ab.v("MicroMsg.OpenIMAddressUI", "address ui on resume");
    if (this.AaI)
    {
      this.AaI = false;
      this.AaH = false;
      dLE();
      this.nYW.setAdapter(this.Aeq);
      this.nYW.post(new OpenIMAddressUI.OpenIMAddressUIFragment.7(this));
      this.Aar.ry(false);
    }
    for (;;)
    {
      if (this.Aar != null) {
        this.Aar.onResume();
      }
      this.Aeq.yVE = false;
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33774);
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).resume();
          AppMethodBeat.o(33774);
        }
      });
      AppMethodBeat.o(33791);
      return;
      if (this.AaH)
      {
        this.AaH = false;
        com.tencent.mm.sdk.g.d.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(33773);
            Process.setThreadPriority(10);
            OpenIMAddressUI.OpenIMAddressUIFragment.k(OpenIMAddressUI.OpenIMAddressUIFragment.this);
            AppMethodBeat.o(33773);
          }
        }, "AddressUI_updateUIData");
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(33787);
    if (paramm.getType() == 453)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(33787);
        return;
      }
      if (!((ane)((i)paramm).rr.fsW.fta).xdG.isEmpty()) {
        dLF();
      }
      AppMethodBeat.o(33787);
      return;
    }
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (!ah.cB(getContext()))
    {
      AppMethodBeat.o(33787);
      return;
    }
    if (v.a.a(getContext(), paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(33787);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(33787);
      return;
    }
    AppMethodBeat.o(33787);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment
 * JD-Core Version:    0.7.0.1
 */