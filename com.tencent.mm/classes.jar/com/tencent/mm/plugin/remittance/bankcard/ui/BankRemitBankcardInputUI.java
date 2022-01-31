package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.widget.Button;
import android.widget.Filter.FilterListener;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankRemitBankcardInputUI
  extends BankRemitBaseUI
{
  private Button frP;
  private WalletFormView nvC;
  private WalletFormView nvD;
  private WalletFormView nvE;
  private WalletFormView nvF;
  private com.tencent.mm.ui.widget.a.d nvG;
  private ListPopupWindow nvH;
  private c nvI;
  private Filter.FilterListener nvJ;
  private ArrayList<TransferRecordParcel> nvK;
  private ArrayList<TransferRecordParcel> nvL;
  private String nvM;
  private String nvN;
  private String nvO;
  private String nvP;
  private String nvQ;
  private String nvR;
  private EnterTimeParcel nvS;
  private BankcardElemParcel nvT;
  private TransferRecordParcel nvU;
  private boolean nvV = true;
  private boolean nvW = false;
  private boolean nvX = false;
  private boolean nvY = false;
  private com.tencent.mm.plugin.remittance.bankcard.a.g nvZ = null;
  private CdnImageView nvv;
  private boolean nwa = false;
  private boolean nwb = false;
  private boolean nwc = true;
  
  private void S(String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by seq: %s", new Object[] { paramString1 });
    a(new com.tencent.mm.plugin.remittance.bankcard.a.a(paramString1, paramString2, paramString3), false, false);
  }
  
  private static void a(TransferRecordParcel paramTransferRecordParcel, List<TransferRecordParcel> paramList)
  {
    int i;
    if (paramList != null) {
      i = paramList.size() - 1;
    }
    for (;;)
    {
      if (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.nvy.equals(paramTransferRecordParcel.nvy)) {
          localTransferRecordParcel.nvB = paramTransferRecordParcel.nvB;
        }
      }
      else
      {
        return;
      }
      i -= 1;
    }
  }
  
  private void bvW()
  {
    if (this.nvU != null)
    {
      this.nvC.setText(this.nvU.nvA);
      this.nvW = true;
      this.nvD.setText(getString(a.i.bank_remit_bank_card_mask_text, new Object[] { this.nvU.nvz }));
      this.nvE.setText(this.nvU.lnT);
      this.nvv.setUrl(this.nvU.nve);
      this.nvD.bvq();
      this.nvD.setContentEnabled(false);
      this.nvX = true;
      this.nvE.setClickable(false);
      this.nvY = true;
    }
  }
  
  private void bvX()
  {
    if (this.nvT != null)
    {
      this.nvE.setText(this.nvT.lnT);
      this.nvv.setUrl(this.nvT.nve);
    }
  }
  
  private void bvY()
  {
    if (this.nvS != null)
    {
      if (!bk.bl(this.nvS.color)) {
        this.nvF.setContentTextColor(Color.parseColor(this.nvS.color));
      }
      for (;;)
      {
        this.nvF.setText(this.nvS.nvm);
        this.nvF.setVisibility(0);
        return;
        this.nvF.setContentTextColorRes(a.c.black);
      }
    }
    if (!bk.bl(this.nvT.nvh))
    {
      this.nvF.setText(this.nvT.nvh);
      if (!bk.bl(this.nvT.nvi)) {
        this.nvF.setContentTextColor(Color.parseColor(this.nvT.nvi));
      }
      for (;;)
      {
        this.nvF.setVisibility(0);
        return;
        this.nvF.setContentTextColorRes(a.c.black);
      }
    }
    this.nvF.setVisibility(8);
  }
  
  private void bvZ()
  {
    if (this.nvF.getVisibility() == 0)
    {
      this.nvE.setBackground(getResources().getDrawable(a.e.wallet_clickable_bg));
      return;
    }
    this.nvE.setBackground(getResources().getDrawable(a.e.bank_remit_form_item_corner_bg));
  }
  
  private void bwa()
  {
    if ((!bk.bl(this.nvC.getText())) && (!this.nvC.getText().trim().isEmpty()) && (!bk.bl(this.nvD.getText())) && (!this.nvD.getText().trim().isEmpty()) && (this.nvD.YL()) && (!bk.bl(this.nvE.getText())) && (this.nvF.getVisibility() == 0) && (!bk.bl(this.nvF.getText())) && (this.nvT != null) && (bk.bl(this.nvT.nvj)))
    {
      this.frP.setEnabled(true);
      return;
    }
    this.frP.setEnabled(false);
  }
  
  private void bwb()
  {
    if ((this.nvT != null) && (!bk.bl(this.nvT.nvh))) {
      this.nvS = null;
    }
    EnterTimeParcel localEnterTimeParcel;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((this.nvT == null) || (this.nvT.nvk == null)) {}
        localIterator = this.nvT.nvk.iterator();
      } while (!localIterator.hasNext());
      localEnterTimeParcel = (EnterTimeParcel)localIterator.next();
    } while (localEnterTimeParcel.nvo <= 0);
    this.nvS = localEnterTimeParcel;
  }
  
  private void ir(boolean paramBoolean)
  {
    y.i("MicroMsg.BankRemitBankcardInputUI", "do fetch transfer record: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      a(new com.tencent.mm.plugin.remittance.bankcard.a.m(), true, false);
      return;
    }
    a(new com.tencent.mm.plugin.remittance.bankcard.a.m(), false, false);
  }
  
  private static void p(String paramString, List<TransferRecordParcel> paramList)
  {
    int i;
    if (paramList != null) {
      i = paramList.size() - 1;
    }
    for (;;)
    {
      if (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.nvy.equals(paramString)) {
          paramList.remove(localTransferRecordParcel);
        }
      }
      else
      {
        return;
      }
      i -= 1;
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.remittance.bankcard.a.a))
    {
      paramString = (com.tencent.mm.plugin.remittance.bankcard.a.a)paramm;
      if (!paramString.nuR.equals(this.nvU.nvy))
      {
        y.i("MicroMsg.BankRemitBankcardInputUI", "outdated request: %s, %s", new Object[] { paramString.nuR, this.nvO });
        return true;
      }
      paramString.a(new BankRemitBankcardInputUI.3(this, paramString)).b(new BankRemitBankcardInputUI.2(this, paramString)).c(new BankRemitBankcardInputUI.28(this));
    }
    for (;;)
    {
      return false;
      if ((paramm instanceof com.tencent.mm.plugin.remittance.bankcard.a.g))
      {
        paramString = (com.tencent.mm.plugin.remittance.bankcard.a.g)paramm;
        if (paramString == this.nvZ)
        {
          y.i("MicroMsg.BankRemitBankcardInputUI", "reset pending scene");
          this.nvZ = null;
        }
        if (!paramString.bIW.equals(this.nvD.getMD5Value()))
        {
          y.i("MicroMsg.BankRemitBankcardInputUI", "outdated card request: %s, %s", new Object[] { paramString.bIW, this.nvD.getMD5Value() });
          return true;
        }
        paramString.a(new BankRemitBankcardInputUI.6(this, paramString)).b(new BankRemitBankcardInputUI.5(this, paramString)).c(new BankRemitBankcardInputUI.4(this));
      }
      else if ((paramm instanceof com.tencent.mm.plugin.remittance.bankcard.a.m))
      {
        paramString = (com.tencent.mm.plugin.remittance.bankcard.a.m)paramm;
        this.nwb = true;
        paramString.a(new BankRemitBankcardInputUI.9(this, paramString)).b(new n.a()
        {
          public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.m paramAnonymousm)
          {
            y.e("MicroMsg.BankRemitBankcardInputUI", "records response error: %s, %s", new Object[] { Integer.valueOf(paramString.nvc.iHq), paramString.nvc.iHr });
            if (!bk.bl(paramString.nvc.iHr)) {
              Toast.makeText(BankRemitBankcardInputUI.this, paramString.nvc.iHr, 1).show();
            }
            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, true);
          }
        }).c(new BankRemitBankcardInputUI.7(this));
      }
      else if ((paramm instanceof com.tencent.mm.plugin.remittance.bankcard.a.d))
      {
        paramString = (com.tencent.mm.plugin.remittance.bankcard.a.d)paramm;
        paramString.a(new BankRemitBankcardInputUI.13(this, paramString)).b(new BankRemitBankcardInputUI.11(this, paramString)).c(new n.a()
        {
          public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.m paramAnonymousm)
          {
            y.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousm });
          }
        });
      }
      else if ((paramm instanceof k))
      {
        paramString = (k)paramm;
        paramString.a(new BankRemitBankcardInputUI.16(this, paramString)).b(new BankRemitBankcardInputUI.15(this, paramString)).c(new BankRemitBankcardInputUI.14(this));
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.bank_remit_bankcard_input_ui;
  }
  
  protected final void initView()
  {
    this.nvC = ((WalletFormView)findViewById(a.f.brbi_name_et));
    this.nvD = ((WalletFormView)findViewById(a.f.brbi_card_et));
    this.nvE = ((WalletFormView)findViewById(a.f.brbi_bank_name_et));
    this.nvv = ((CdnImageView)this.nvE.findViewById(a.f.wallet_left_icon));
    this.nvF = ((WalletFormView)findViewById(a.f.brbi_arrive_time_et));
    this.frP = ((Button)findViewById(a.f.brbi_next_btn));
    this.nvC.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    this.nvC.a(new BankRemitBankcardInputUI.22(this));
    this.nvC.setOnEditorActionListener(new BankRemitBankcardInputUI.23(this));
    this.nvC.cNx();
    com.tencent.mm.wallet_core.ui.formview.a.b(this.nvD);
    a(this.nvD, 2, false, true);
    this.nvD.a(new BankRemitBankcardInputUI.24(this));
    this.nvE.setOnClickListener(new BankRemitBankcardInputUI.25(this));
    this.nvF.setOnClickListener(new BankRemitBankcardInputUI.26(this));
    this.frP.setOnClickListener(new BankRemitBankcardInputUI.27(this));
    this.nvC.getInfoIv().setVisibility(0);
    this.nvC.getInfoIv().setClickable(true);
    this.nvC.getInfoIv().setEnabled(true);
    this.nvC.getInfoIv().setOnClickListener(new BankRemitBankcardInputUI.20(this));
    bwa();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 1)
    {
      String str;
      Iterator localIterator;
      if (paramInt2 == -1)
      {
        this.nvV = false;
        this.nvO = paramIntent.getStringExtra("key_bank_card_seqno");
        str = this.nvO;
        if (this.nvK == null) {
          break label235;
        }
        localIterator = this.nvK.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (TransferRecordParcel)localIterator.next();
        } while (!((TransferRecordParcel)localObject).nvy.equals(str));
      }
      for (;;)
      {
        this.nvU = ((TransferRecordParcel)localObject);
        bvW();
        bwa();
        if (this.nvU != null) {
          S(this.nvU.nvy, this.nvN, this.nvU.mOb);
        }
        ai.l(new BankRemitBankcardInputUI.17(this), 50L);
        y.i("MicroMsg.BankRemitBankcardInputUI", "resultCode: %s", new Object[] { Integer.valueOf(paramInt2) });
        if (paramIntent == null) {
          break label435;
        }
        localObject = paramIntent.getStringArrayListExtra("key_delete_seq_no_list");
        paramIntent = paramIntent.getParcelableArrayListExtra("key_modified_record_list");
        if (localObject == null) {
          break;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          p(str, this.nvK);
          p(str, this.nvL);
        }
        label235:
        if (this.nvL != null)
        {
          localIterator = this.nvL.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject = (TransferRecordParcel)localIterator.next();
              if (((TransferRecordParcel)localObject).nvy.equals(str)) {
                break;
              }
            }
          }
        }
        localObject = null;
      }
      if (paramIntent != null)
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          localObject = (TransferRecordParcel)paramIntent.next();
          a((TransferRecordParcel)localObject, this.nvK);
          a((TransferRecordParcel)localObject, this.nvL);
        }
      }
    }
    else
    {
      if (paramInt1 != 3) {
        break label458;
      }
      if (paramInt2 == -1)
      {
        paramInt1 = paramIntent.getIntExtra("key_enter_time_scene", -1);
        if ((this.nvT == null) || (this.nvT.nvk == null)) {
          break label436;
        }
        paramIntent = this.nvT.nvk.iterator();
        while (paramIntent.hasNext())
        {
          localObject = (EnterTimeParcel)paramIntent.next();
          if (((EnterTimeParcel)localObject).nvl == paramInt1)
          {
            this.nvS = ((EnterTimeParcel)localObject);
            bvY();
            bwa();
          }
        }
      }
    }
    label435:
    label436:
    label458:
    do
    {
      return;
      y.w("MicroMsg.BankRemitBankcardInputUI", "can't find the right enter scene: %d", new Object[] { Integer.valueOf(paramInt1) });
      break;
      if (paramInt1 != 2) {
        break label503;
      }
    } while (paramInt2 != -1);
    this.nvT = ((BankcardElemParcel)paramIntent.getParcelableExtra("key_bank_card_elem_parcel"));
    bvX();
    bwb();
    bvY();
    bvZ();
    bwa();
    return;
    label503:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    czo();
    initView();
    paramBundle = new ti();
    paramBundle.ccU.bso = "12";
    paramBundle.bFJ = new BankRemitBankcardInputUI.1(this, paramBundle);
    com.tencent.mm.sdk.b.a.udP.m(paramBundle);
    kh(1348);
    kh(1542);
    kh(1378);
    kh(1349);
    kh(1280);
    this.nvR = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uyy, ""));
    ir(false);
    y.i("MicroMsg.BankRemitBankcardInputUI", "do operation");
    a(new k(), false, false);
    setMMTitle(a.i.bank_remit_title);
    addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new BankRemitBankcardInputUI.12(this));
    h.nFQ.f(14673, new Object[] { Integer.valueOf(1) });
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1348);
    ki(1542);
    ki(1378);
    ki(1349);
    ki(1280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI
 * JD-Core Version:    0.7.0.1
 */