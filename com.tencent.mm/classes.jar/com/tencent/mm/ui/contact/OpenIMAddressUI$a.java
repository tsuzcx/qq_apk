package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.n.a;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.b.i;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.w.a;
import com.tencent.mm.ui.x;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class OpenIMAddressUI$a
  extends x
  implements com.tencent.mm.ah.f
{
  com.tencent.mm.pluginsdk.ui.d dnR = new com.tencent.mm.pluginsdk.ui.d(new OpenIMAddressUI.a.4(this));
  private ProgressDialog dnm = null;
  List<String> dru = new LinkedList();
  private com.tencent.mm.ui.widget.e idC;
  private int idy;
  private int idz;
  private n.d jEB = new OpenIMAddressUI.a.3(this);
  private ListView lBK;
  private com.tencent.mm.ui.voicesearch.b vIV;
  private String vIX = "";
  boolean vJl;
  private boolean vJm = true;
  List<String> vJq = new LinkedList();
  private String vMM = "";
  private t vMN;
  private Runnable vMO = new OpenIMAddressUI.a.18(this);
  
  public OpenIMAddressUI$a()
  {
    super(true);
  }
  
  private void cHo()
  {
    this.dru = new LinkedList();
    this.vJq = new LinkedList();
    com.tencent.mm.br.d.coz();
    this.dru.add("tmessage");
    this.vJq.addAll(this.dru);
    if (!this.dru.contains("officialaccounts")) {
      this.dru.add("officialaccounts");
    }
    this.dru.add("helper_entry");
    if (this.vMN != null) {
      this.vMN.ej(this.dru);
    }
    if (this.vIV != null) {
      this.vIV.ej(this.vJq);
    }
  }
  
  private void cHp()
  {
    try
    {
      long l = System.currentTimeMillis();
      cHo();
      y.i("MicroMsg.OpenIMAddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
      if (this.vMN != null)
      {
        y.v("MicroMsg.OpenIMAddressUI", "post to do refresh");
        ai.d(new OpenIMAddressUI.a.5(this));
      }
      if (this.vIV != null) {
        ai.d(new OpenIMAddressUI.a.6(this));
      }
      y.i("MicroMsg.OpenIMAddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
      return;
    }
    finally {}
  }
  
  protected final int getLayoutId()
  {
    return R.i.openim_address;
  }
  
  protected final View getLayoutView()
  {
    return com.tencent.mm.kiss.a.b.ED().a(getContext(), "R.layout.openim_address", R.i.openim_address);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    y.v("MicroMsg.OpenIMAddressUI", "on address ui create");
    au.Dk().a(138, this);
    g.DQ();
    g.DO().dJT.a(453, this);
    this.vMM = getStringExtra("key_openim_acctype_id");
    setMMTitle(((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).b(this.vMM, "openim_acct_type_title", b.a.ePI));
    setBackBtn(new OpenIMAddressUI.a.1(this));
    setTitleBarDoubleClickListener(this.vMO);
    y.v("MicroMsg.OpenIMAddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
    this.lBK = ((ListView)findViewById(R.h.address_contactlist));
    this.lBK.setScrollingCacheEnabled(false);
    this.vMN = new t(getContext(), "@openim.contact", this.vMM);
    this.vMN.a(new OpenIMAddressUI.a.11(this));
    this.vMN.vIF = true;
    this.vMN.vMS = this;
    this.vMN.setGetViewPositionCallback(new OpenIMAddressUI.a.12(this));
    this.vMN.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void D(View paramAnonymousView, int paramAnonymousInt)
      {
        OpenIMAddressUI.a.c(OpenIMAddressUI.a.this).performItemClick(paramAnonymousView, paramAnonymousInt, 0L);
      }
    });
    this.vMN.a(new OpenIMAddressUI.a.14(this));
    this.vIV = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.vIV.nP(true);
    this.idC = new com.tencent.mm.ui.widget.e(getContext());
    this.lBK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
        boolean bool1;
        if (OpenIMAddressUI.a.d(OpenIMAddressUI.a.this) == null)
        {
          paramAnonymousAdapterView = OpenIMAddressUI.a.d(OpenIMAddressUI.a.this);
          y.i("MicroMsg.OpenIMAddressUI", paramAnonymousAdapterView);
          paramAnonymousInt -= OpenIMAddressUI.a.c(OpenIMAddressUI.a.this).getHeaderViewsCount();
          if ((OpenIMAddressUI.a.d(OpenIMAddressUI.a.this) == null) || (!OpenIMAddressUI.a.d(OpenIMAddressUI.a.this).wiO)) {
            break label762;
          }
          bool1 = OpenIMAddressUI.a.d(OpenIMAddressUI.a.this).sk(paramAnonymousInt);
          boolean bool2 = OpenIMAddressUI.a.d(OpenIMAddressUI.a.this).Ik(paramAnonymousInt);
          y.i("MicroMsg.OpenIMAddressUI", "onItemClick " + bool2);
          if (!bool2) {
            break label164;
          }
          OpenIMAddressUI.a.d(OpenIMAddressUI.a.this).aet("");
        }
        label164:
        Object localObject;
        label307:
        label610:
        label762:
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  paramAnonymousAdapterView = Boolean.valueOf(OpenIMAddressUI.a.d(OpenIMAddressUI.a.this).wiO);
                  break;
                  if (!bool1) {
                    break label610;
                  }
                  paramAnonymousView = OpenIMAddressUI.a.d(OpenIMAddressUI.a.this).Ii(paramAnonymousInt);
                  paramAnonymousAdapterView = paramAnonymousView.sQs.tFO;
                  au.Hx();
                  localObject = c.Fw().abl(paramAnonymousAdapterView);
                  if (!a.gR(((ao)localObject).field_type)) {
                    break label307;
                  }
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                  paramAnonymousView.putExtra("Contact_Scene", 3);
                } while ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.length() <= 0));
                if (((ad)localObject).cua()) {
                  h.nFQ.aC(10298, paramAnonymousAdapterView + ",3");
                }
                e.a(paramAnonymousView, paramAnonymousAdapterView);
                com.tencent.mm.br.d.b(OpenIMAddressUI.a.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                return;
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.sQs.tFO);
                ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.ffm);
                ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.tmw.tFO);
                ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.ffk);
                ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.ao(paramAnonymousView.ffq, paramAnonymousView.ffi, paramAnonymousView.ffj));
                ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.ffh);
                ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.tph);
                ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.tpg);
                ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.tpk);
                ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.tpi);
                ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.tpj);
                ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.tpm.ffs);
                ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.tpm.ffu);
                ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.tpm.fft);
                if (paramAnonymousView.tpn != null) {}
                try
                {
                  ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.tpn.toByteArray());
                  if ((paramAnonymousView.tpg & 0x8) > 0) {
                    h.nFQ.aC(10298, paramAnonymousAdapterView + ",3");
                  }
                  com.tencent.mm.br.d.b(OpenIMAddressUI.a.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
                  return;
                }
                catch (IOException localIOException)
                {
                  for (;;)
                  {
                    y.printErrStackTrace("MicroMsg.OpenIMAddressUI", localIOException, "", new Object[0]);
                  }
                }
                paramAnonymousAdapterView = OpenIMAddressUI.a.d(OpenIMAddressUI.a.this).Ij(paramAnonymousInt);
                if (paramAnonymousAdapterView == null)
                {
                  y.e("MicroMsg.OpenIMAddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(OpenIMAddressUI.a.d(OpenIMAddressUI.a.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                  return;
                }
                paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
                if (s.hK(paramAnonymousAdapterView))
                {
                  paramAnonymousAdapterView = new Intent(OpenIMAddressUI.a.this.getContext(), OpenIMAddressUI.class);
                  paramAnonymousAdapterView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                  OpenIMAddressUI.a.this.startActivity(paramAnonymousAdapterView);
                  return;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                paramAnonymousView.putExtra("Contact_Scene", 3);
              } while ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.length() <= 0));
              com.tencent.mm.br.d.b(OpenIMAddressUI.a.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
              return;
              paramAnonymousAdapterView = (com.tencent.mm.storage.f)OpenIMAddressUI.a.a(OpenIMAddressUI.a.this).FC(paramAnonymousInt);
            } while (paramAnonymousAdapterView == null);
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            paramAnonymousView = OpenIMAddressUI.a.this;
          } while ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.length() <= 0));
          if (s.hK(paramAnonymousAdapterView))
          {
            y.e("MicroMsg.OpenIMAddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
            return;
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
          if (s.hi(paramAnonymousAdapterView)) {
            ((Intent)localObject).putExtra("Is_group_card", true);
          }
        } while ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.length() <= 0));
        e.a((Intent)localObject, paramAnonymousAdapterView);
        com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
      }
    });
    this.lBK.setOnItemLongClickListener(new OpenIMAddressUI.a.16(this));
    this.lBK.setOnTouchListener(new OpenIMAddressUI.a.17(this));
    this.lBK.setOnScrollListener(this.dnR);
    this.lBK.setDrawingCacheEnabled(false);
    au.Hx();
    c.Fw().a(this.vMN);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.OpenIMAddressUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
    if ((paramInt1 == 6) && (paramInt2 == -1))
    {
      setResult(-1);
      finish();
    }
    while (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    setResult(-1, paramIntent);
    finish();
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    au.Hx();
    ad localad = c.Fw().abl(this.vIX);
    if (localad == null) {
      y.e("MicroMsg.OpenIMAddressUI", "onCreateContextMenu, contact is null, username = " + this.vIX);
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (q.Gj().equals(localad.field_username));
        if (s.hi(this.vIX))
        {
          paramContextMenu.setHeaderTitle(j.b(paramView.getContext(), localad.Bq()));
          paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.address_delgroupcard);
          return;
        }
      } while ((s.hx(this.vIX)) || (s.hN(this.vIX)));
      paramContextMenu.setHeaderTitle(j.b(paramView.getContext(), localad.Bq()));
    } while ((!a.gR(localad.field_type)) || (localad.field_deleteFlag == 1));
    paramContextMenu.add(paramContextMenuInfo.position, 7, 0, R.l.contact_info_mod_remark_labelinfo);
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    y.v("MicroMsg.OpenIMAddressUI", "onDestory");
    au.Dk().b(138, this);
    g.DQ();
    g.DO().dJT.b(453, this);
    if (this.vMN != null)
    {
      this.vMN.mK(true);
      this.vMN.detach();
      this.vMN.cxZ();
    }
    if (this.vIV != null)
    {
      this.vIV.detach();
      this.vIV.bcS();
    }
    if ((au.DK()) && (this.vMN != null))
    {
      au.Hx();
      c.Fw().b(this.vMN);
    }
  }
  
  public final void onPause()
  {
    super.onPause();
    y.i("MicroMsg.OpenIMAddressUI", "AddressUI on Pause");
    if (this.vIV != null) {
      this.vIV.onPause();
    }
    this.vMN.cHm();
    ai.d(new OpenIMAddressUI.a.10(this));
  }
  
  public final void onResume()
  {
    super.onResume();
    y.v("MicroMsg.OpenIMAddressUI", "address ui on resume");
    if (this.vJm)
    {
      this.vJm = false;
      this.vJl = false;
      cHo();
      this.lBK.setAdapter(this.vMN);
      this.lBK.post(new OpenIMAddressUI.a.7(this));
      this.vIV.nO(false);
    }
    for (;;)
    {
      if (this.vIV != null) {
        this.vIV.onResume();
      }
      this.vMN.uIl = false;
      ai.d(new OpenIMAddressUI.a.9(this));
      return;
      if (this.vJl)
      {
        this.vJl = false;
        com.tencent.mm.sdk.f.e.a(new OpenIMAddressUI.a.8(this), "AddressUI_updateUIData", 4);
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() == 453) {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    }
    do
    {
      do
      {
        return;
      } while (((aid)((i)paramm).dmK.ecF.ecN).tfv.isEmpty());
      cHp();
      return;
      if (this.dnm != null)
      {
        this.dnm.dismiss();
        this.dnm = null;
      }
    } while ((!ah.bU(getContext())) || (w.a.a(getContext(), paramInt1, paramInt2, paramString, 4)) || (paramInt1 != 0) || (paramInt2 == 0));
  }
  
  public final boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.a
 * JD-Core Version:    0.7.0.1
 */