package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.a.a.a;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.a.j;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.List;

public class ProductPurchaseAreaUI
  extends MMPreference
{
  protected f hcp;
  private String iZD;
  private List<a.a> nKb;
  private int nKc;
  
  private void bxJ()
  {
    if (this.nKb == null) {
      return;
    }
    int i = 0;
    while (i < this.nKb.size())
    {
      Object localObject = (a.a)this.nKb.get(i);
      if (localObject != null)
      {
        a locala = new a(this);
        locala.setKey(String.valueOf(i));
        locala.setTitle(((a.a)localObject).name);
        locala.setSummary(((a.a)localObject).desc);
        locala.nHW = ((a.a)localObject).dTF;
        this.hcp.a(locala);
        if (i != this.nKb.size() - 1)
        {
          localObject = new g(this.mController.uMN);
          this.hcp.a((Preference)localObject);
        }
      }
      i += 1;
    }
    this.hcp.notifyDataSetChanged();
  }
  
  private static void i(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", j.wN(paramInt));
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("pay_channel", 3);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    if (this.nKb == null) {
      return false;
    }
    for (;;)
    {
      a.a locala;
      try
      {
        int i = Integer.valueOf(paramPreference.mKey).intValue();
        if ((i < 0) || (i >= this.nKb.size())) {
          break label347;
        }
        locala = (a.a)this.nKb.get(i);
        if (locala == null) {
          return false;
        }
        paramPreference = null;
        switch (locala.type)
        {
        case 1: 
          y.i("MicroMsg.ProductPurchaseAreaUI", "Default go url:" + locala.eAl);
          paramf = paramPreference;
          if (!bk.bl(locala.eAl))
          {
            i(this.mController.uMN, locala.eAl, this.nKc);
            paramf = paramPreference;
          }
          paramf = new i(this.iZD, locala.nGG, locala.type, paramf, this.nKb.size(), locala.showType);
          au.Dk().a(paramf, 0);
          return true;
        }
      }
      catch (Exception paramf)
      {
        y.e("MicroMsg.ProductPurchaseAreaUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        y.printErrStackTrace("MicroMsg.ProductPurchaseAreaUI", paramf, "", new Object[0]);
        return false;
      }
      paramf = locala.eAl;
      if (!bk.bl(locala.eAl))
      {
        i(this.mController.uMN, locala.eAl, this.nKc);
      }
      else
      {
        y.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
        continue;
        paramPreference = locala.nGH;
        paramf = paramPreference;
        if (!bk.bl(locala.nGH))
        {
          paramf = new Intent();
          paramf.putExtra("key_product_id", locala.nGH);
          paramf.putExtra("key_product_scene", 12);
          d.b(this, "product", ".ui.MallProductUI", paramf);
          paramf = paramPreference;
          continue;
          label347:
          return false;
        }
      }
    }
  }
  
  protected final void initView()
  {
    setBackBtn(new ProductPurchaseAreaUI.1(this));
    this.hcp = this.vdd;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    paramBundle = j.cm(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle != null) && (paramBundle.nPR != null))
    {
      this.iZD = paramBundle.field_productid;
      this.nKc = paramBundle.field_functionType;
      String str = getIntent().getStringExtra("referkey");
      y.i("MicroMsg.ProductPurchaseAreaUI", "referkey:" + str);
      int i;
      if (!bk.bl(str)) {
        i = 0;
      }
      for (;;)
      {
        if (i < paramBundle.nPR.size())
        {
          if (str.equals(((com.tencent.mm.plugin.scanner.a.a)paramBundle.nPR.get(i)).nGA))
          {
            this.nKb = ((com.tencent.mm.plugin.scanner.a.a)paramBundle.nPR.get(i)).eAm;
            setMMTitle(((com.tencent.mm.plugin.scanner.a.a)paramBundle.nPR.get(i)).title);
            bxJ();
          }
        }
        else {
          return;
        }
        i += 1;
      }
    }
    y.w("MicroMsg.ProductPurchaseAreaUI", "Data product null");
  }
  
  public final int xj()
  {
    return R.o.product_purchase_area;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductPurchaseAreaUI
 * JD-Core Version:    0.7.0.1
 */