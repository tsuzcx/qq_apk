package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.widget.Button;
import android.widget.Filter.FilterListener;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankRemitBankcardInputUI
  extends BankRemitBaseUI
{
  private String feA = "";
  private Button gJr;
  private com.tencent.mm.ui.widget.b.d mAF;
  private Dialog own = null;
  private WalletFormView qgA;
  private WalletFormView qgB;
  private ListPopupWindow qgC;
  private c qgD;
  private Filter.FilterListener qgE;
  private ArrayList<TransferRecordParcel> qgF;
  private ArrayList<TransferRecordParcel> qgG;
  private int qgH;
  private String qgI;
  private String qgJ;
  private String qgK;
  private String qgL;
  private String qgM;
  private String qgN;
  private EnterTimeParcel qgO;
  private BankcardElemParcel qgP;
  private TransferRecordParcel qgQ;
  private boolean qgR = true;
  private boolean qgS = false;
  private boolean qgT = false;
  private boolean qgU = false;
  private com.tencent.mm.plugin.remittance.bankcard.a.g qgV = null;
  private boolean qgW = false;
  private boolean qgX = false;
  private boolean qgY = true;
  private boolean qgZ = false;
  private CdnImageView qgr;
  private WalletFormView qgy;
  private WalletFormView qgz;
  private boolean qha = false;
  private boolean qhb = false;
  private String qhc;
  private String qhd;
  
  private static void a(TransferRecordParcel paramTransferRecordParcel, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(44551);
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.qgu.equals(paramTransferRecordParcel.qgu))
        {
          localTransferRecordParcel.qgx = paramTransferRecordParcel.qgx;
          AppMethodBeat.o(44551);
          return;
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(44551);
  }
  
  private void ab(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(44553);
    ab.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by seq: %s", new Object[] { paramString1 });
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.a(paramString1, paramString2, paramString3), false);
    AppMethodBeat.o(44553);
  }
  
  private void cgL()
  {
    AppMethodBeat.i(44556);
    ab.i("MicroMsg.BankRemitBankcardInputUI", "do operation");
    this.qha = true;
    doSceneProgress(new k(), false);
    AppMethodBeat.o(44556);
  }
  
  private void cgM()
  {
    AppMethodBeat.i(44558);
    this.qgz.cfJ();
    this.qgz.setContentEnabled(false);
    this.qgT = true;
    AppMethodBeat.o(44558);
  }
  
  private void cgN()
  {
    AppMethodBeat.i(44559);
    this.qgA.setClickable(false);
    this.qgU = true;
    AppMethodBeat.o(44559);
  }
  
  private void cgO()
  {
    AppMethodBeat.i(44560);
    if (this.qgQ != null)
    {
      this.qgy.setText(this.qgQ.qgw);
      this.qgS = true;
      this.qgz.setText(getString(2131297472, new Object[] { this.qgQ.qgv }));
      this.qgA.setText(this.qgQ.nLq);
      this.qgr.setUrl(this.qgQ.qfY);
      cgM();
      cgN();
    }
    AppMethodBeat.o(44560);
  }
  
  private void cgP()
  {
    AppMethodBeat.i(44561);
    if (this.qgP != null)
    {
      this.qgA.setText(this.qgP.nLq);
      this.qgr.setUrl(this.qgP.qfY);
    }
    AppMethodBeat.o(44561);
  }
  
  private void cgQ()
  {
    AppMethodBeat.i(44562);
    if (this.qgO != null)
    {
      if (!bo.isNullOrNil(this.qgO.color)) {
        this.qgB.setContentTextColor(Color.parseColor(this.qgO.color));
      }
      for (;;)
      {
        this.qgB.setText(this.qgO.qgi);
        this.qgB.setVisibility(0);
        AppMethodBeat.o(44562);
        return;
        this.qgB.setContentTextColorRes(2131689763);
      }
    }
    if ((this.qgP != null) && (!bo.isNullOrNil(this.qgP.qgb)))
    {
      this.qgB.setText(this.qgP.qgb);
      if (!bo.isNullOrNil(this.qgP.qgc)) {
        this.qgB.setContentTextColor(Color.parseColor(this.qgP.qgc));
      }
      for (;;)
      {
        this.qgB.setVisibility(0);
        AppMethodBeat.o(44562);
        return;
        this.qgB.setContentTextColorRes(2131689763);
      }
    }
    this.qgB.setVisibility(8);
    AppMethodBeat.o(44562);
  }
  
  private void cgR()
  {
    AppMethodBeat.i(44563);
    if (this.qgB.getVisibility() == 0)
    {
      this.qgA.setBackground(getResources().getDrawable(2130840829));
      AppMethodBeat.o(44563);
      return;
    }
    this.qgA.setBackground(getResources().getDrawable(2130837852));
    AppMethodBeat.o(44563);
  }
  
  private void cgS()
  {
    AppMethodBeat.i(44564);
    if ((!bo.isNullOrNil(this.qgy.getText())) && (!this.qgy.getText().trim().isEmpty()) && (!bo.isNullOrNil(this.qgz.getText())) && (this.qgy.asv()) && (!this.qgz.getText().trim().isEmpty()) && (this.qgz.asv()) && (!bo.isNullOrNil(this.qgA.getText())) && (this.qgB.getVisibility() == 0) && (!bo.isNullOrNil(this.qgB.getText())) && (this.qgP != null) && (bo.isNullOrNil(this.qgP.qgd)))
    {
      this.gJr.setEnabled(true);
      AppMethodBeat.o(44564);
      return;
    }
    this.gJr.setEnabled(false);
    AppMethodBeat.o(44564);
  }
  
  private void cgT()
  {
    AppMethodBeat.i(44565);
    if ((this.qgP != null) && (!bo.isNullOrNil(this.qgP.qgb)))
    {
      this.qgO = null;
      AppMethodBeat.o(44565);
      return;
    }
    if ((this.qgP != null) && (this.qgP.qge != null))
    {
      Iterator localIterator = this.qgP.qge.iterator();
      while (localIterator.hasNext())
      {
        EnterTimeParcel localEnterTimeParcel = (EnterTimeParcel)localIterator.next();
        if (localEnterTimeParcel.qgk > 0)
        {
          this.qgO = localEnterTimeParcel;
          AppMethodBeat.o(44565);
          return;
        }
      }
    }
    AppMethodBeat.o(44565);
  }
  
  private void kv(boolean paramBoolean)
  {
    AppMethodBeat.i(44554);
    ab.i("MicroMsg.BankRemitBankcardInputUI", "do fetch transfer record: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.m(), true);
      AppMethodBeat.o(44554);
      return;
    }
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.m(), false);
    AppMethodBeat.o(44554);
  }
  
  private static void q(String paramString, List<TransferRecordParcel> paramList)
  {
    AppMethodBeat.i(44552);
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        TransferRecordParcel localTransferRecordParcel = (TransferRecordParcel)paramList.get(i);
        if (localTransferRecordParcel.qgu.equals(paramString))
        {
          paramList.remove(localTransferRecordParcel);
          AppMethodBeat.o(44552);
          return;
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(44552);
  }
  
  private void s(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(44555);
    ab.i("MicroMsg.BankRemitBankcardInputUI", "do check bank bind: %s %s", new Object[] { paramString3, paramString4 });
    ab.d("MicroMsg.BankRemitBankcardInputUI", "payeeName: %s, bankCardNo: %s", new Object[] { paramString1, paramString2 });
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.d(paramString1, paramString2, paramString3, paramString4));
    AppMethodBeat.o(44555);
  }
  
  public int getLayoutId()
  {
    return 2130968818;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44557);
    this.qgy = ((WalletFormView)findViewById(2131821673));
    this.qgz = ((WalletFormView)findViewById(2131821674));
    this.qgA = ((WalletFormView)findViewById(2131821675));
    this.qgr = ((CdnImageView)this.qgA.findViewById(2131821671));
    this.qgB = ((WalletFormView)findViewById(2131821676));
    this.gJr = ((Button)findViewById(2131821677));
    this.qgy.setFilterChar("\\x20\\t\\r\\n".toCharArray());
    this.qgy.a(new BankRemitBankcardInputUI.22(this));
    this.qgy.setOnEditorActionListener(new BankRemitBankcardInputUI.23(this));
    this.qgy.dTc();
    com.tencent.mm.wallet_core.ui.formview.a.b(this.qgz);
    setEditFocusListener(this.qgz, 2, false, true);
    this.qgz.a(new BankRemitBankcardInputUI.24(this));
    this.qgA.setOnClickListener(new BankRemitBankcardInputUI.25(this));
    this.qgB.setOnClickListener(new BankRemitBankcardInputUI.26(this));
    this.gJr.setOnClickListener(new BankRemitBankcardInputUI.27(this));
    this.qgy.getInfoIv().setVisibility(0);
    this.qgy.getInfoIv().setClickable(true);
    this.qgy.getInfoIv().setEnabled(true);
    this.qgy.getInfoIv().setOnClickListener(new BankRemitBankcardInputUI.20(this));
    cgS();
    AppMethodBeat.o(44557);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(44550);
    Object localObject;
    if (paramInt1 == 1)
    {
      String str;
      Iterator localIterator;
      if (paramInt2 == -1)
      {
        this.qgR = false;
        this.qgK = paramIntent.getStringExtra("key_bank_card_seqno");
        str = this.qgK;
        if (this.qgF == null) {
          break label240;
        }
        localIterator = this.qgF.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (TransferRecordParcel)localIterator.next();
        } while (!((TransferRecordParcel)localObject).qgu.equals(str));
      }
      for (;;)
      {
        this.qgQ = ((TransferRecordParcel)localObject);
        cgO();
        cgS();
        if (this.qgQ != null) {
          ab(this.qgQ.qgu, this.qgJ, this.qgQ.poq);
        }
        al.p(new BankRemitBankcardInputUI.17(this), 50L);
        ab.i("MicroMsg.BankRemitBankcardInputUI", "resultCode: %s", new Object[] { Integer.valueOf(paramInt2) });
        if (paramIntent == null) {
          break label532;
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
          q(str, this.qgF);
          q(str, this.qgG);
        }
        label240:
        if (this.qgG != null)
        {
          localIterator = this.qgG.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject = (TransferRecordParcel)localIterator.next();
              if (((TransferRecordParcel)localObject).qgu.equals(str)) {
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
          a((TransferRecordParcel)localObject, this.qgF);
          a((TransferRecordParcel)localObject, this.qgG);
        }
      }
      AppMethodBeat.o(44550);
      return;
    }
    if (paramInt1 == 3)
    {
      if (paramInt2 == -1)
      {
        paramInt1 = paramIntent.getIntExtra("key_enter_time_scene", -1);
        if ((this.qgP != null) && (this.qgP.qge != null))
        {
          paramIntent = this.qgP.qge.iterator();
          while (paramIntent.hasNext())
          {
            localObject = (EnterTimeParcel)paramIntent.next();
            if (((EnterTimeParcel)localObject).qgh == paramInt1) {
              this.qgO = ((EnterTimeParcel)localObject);
            }
          }
        }
        for (;;)
        {
          cgQ();
          cgS();
          AppMethodBeat.o(44550);
          return;
          ab.w("MicroMsg.BankRemitBankcardInputUI", "can't find the right enter scene: %d", new Object[] { Integer.valueOf(paramInt1) });
        }
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == -1)
      {
        this.qgP = ((BankcardElemParcel)paramIntent.getParcelableExtra("key_bank_card_elem_parcel"));
        cgP();
        cgT();
        cgQ();
        cgR();
        cgS();
        AppMethodBeat.o(44550);
      }
    }
    else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    label532:
    AppMethodBeat.o(44550);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44546);
    super.onCreate(paramBundle);
    hideActionbarLine();
    initView();
    paramBundle = new vd();
    paramBundle.cLE.bSd = "12";
    paramBundle.callback = new BankRemitBankcardInputUI.1(this, paramBundle);
    com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
    addSceneEndListener(1348);
    addSceneEndListener(1542);
    addSceneEndListener(1378);
    addSceneEndListener(1349);
    addSceneEndListener(1280);
    this.qgN = ((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yII, ""));
    kv(false);
    cgL();
    setMMTitle(2131297521);
    addIconOptionMenu(0, 2131230740, new BankRemitBankcardInputUI.12(this));
    h.qsU.e(14673, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(44546);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44549);
    super.onDestroy();
    removeSceneEndListener(1348);
    removeSceneEndListener(1542);
    removeSceneEndListener(1378);
    removeSceneEndListener(1349);
    removeSceneEndListener(1280);
    AppMethodBeat.o(44549);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(44548);
    ab.i("MicroMsg.BankRemitBankcardInputUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramm.getType());
    if ((paramm instanceof com.tencent.mm.plugin.remittance.bankcard.a.a))
    {
      paramString = (com.tencent.mm.plugin.remittance.bankcard.a.a)paramm;
      if (!paramString.qfK.equals(this.qgQ.qgu))
      {
        ab.i("MicroMsg.BankRemitBankcardInputUI", "outdated request: %s, %s", new Object[] { paramString.qfK, this.qgK });
        AppMethodBeat.o(44548);
        return true;
      }
      paramString.a(new BankRemitBankcardInputUI.3(this, paramString)).b(new BankRemitBankcardInputUI.2(this, paramString)).c(new BankRemitBankcardInputUI.28(this));
    }
    for (;;)
    {
      AppMethodBeat.o(44548);
      return false;
      if ((paramm instanceof com.tencent.mm.plugin.remittance.bankcard.a.g))
      {
        paramString = (com.tencent.mm.plugin.remittance.bankcard.a.g)paramm;
        if (paramString == this.qgV)
        {
          ab.i("MicroMsg.BankRemitBankcardInputUI", "reset pending scene");
          this.qgV = null;
        }
        if (!paramString.cqq.equals(this.qgz.getMD5Value()))
        {
          ab.i("MicroMsg.BankRemitBankcardInputUI", "outdated card request: %s, %s", new Object[] { paramString.cqq, this.qgz.getMD5Value() });
          AppMethodBeat.o(44548);
          return true;
        }
        paramString.a(new BankRemitBankcardInputUI.6(this, paramString)).b(new BankRemitBankcardInputUI.5(this, paramString)).c(new BankRemitBankcardInputUI.4(this));
      }
      else if ((paramm instanceof com.tencent.mm.plugin.remittance.bankcard.a.m))
      {
        paramString = (com.tencent.mm.plugin.remittance.bankcard.a.m)paramm;
        this.qgX = true;
        paramString.a(new BankRemitBankcardInputUI.9(this, paramString)).b(new p.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.m paramAnonymousm)
          {
            AppMethodBeat.i(44520);
            ab.e("MicroMsg.BankRemitBankcardInputUI", "records response error: %s, %s", new Object[] { Integer.valueOf(paramString.qfV.cnK), paramString.qfV.kNv });
            if (!bo.isNullOrNil(paramString.qfV.kNv)) {
              Toast.makeText(BankRemitBankcardInputUI.this, paramString.qfV.kNv, 1).show();
            }
            BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this, true);
            AppMethodBeat.o(44520);
          }
        }).c(new BankRemitBankcardInputUI.7(this));
      }
      else if ((paramm instanceof com.tencent.mm.plugin.remittance.bankcard.a.d))
      {
        paramString = (com.tencent.mm.plugin.remittance.bankcard.a.d)paramm;
        paramString.a(new BankRemitBankcardInputUI.13(this, paramString)).b(new BankRemitBankcardInputUI.11(this, paramString)).c(new p.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.m paramAnonymousm)
          {
            AppMethodBeat.i(44522);
            ab.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramAnonymousm });
            AppMethodBeat.o(44522);
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
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI
 * JD-Core Version:    0.7.0.1
 */