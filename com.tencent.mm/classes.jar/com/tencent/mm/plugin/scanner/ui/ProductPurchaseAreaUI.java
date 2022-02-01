package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class ProductPurchaseAreaUI
  extends MMPreference
{
  protected com.tencent.mm.ui.base.preference.f lxI;
  private String oyw;
  private List<a.a> vSx;
  private int vSy;
  
  private static void o(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(51847);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", m.KN(paramInt));
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("pay_channel", 3);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(51847);
  }
  
  public int getResourceId()
  {
    return 2131951703;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51845);
    setBackBtn(new ProductPurchaseAreaUI.1(this));
    this.lxI = getPreferenceScreen();
    AppMethodBeat.o(51845);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(51844);
    super.onCreate(paramBundle);
    initView();
    paramBundle = m.en(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle != null) && (paramBundle.wbf != null))
    {
      this.oyw = paramBundle.field_productid;
      this.vSy = paramBundle.field_functionType;
      Object localObject = getIntent().getStringExtra("referkey");
      ad.i("MicroMsg.ProductPurchaseAreaUI", "referkey:".concat(String.valueOf(localObject)));
      if (!bt.isNullOrNil((String)localObject))
      {
        int i = 0;
        while (i < paramBundle.wbf.size())
        {
          if (((String)localObject).equals(((com.tencent.mm.plugin.scanner.model.a)paramBundle.wbf.get(i)).vNT))
          {
            this.vSx = ((com.tencent.mm.plugin.scanner.model.a)paramBundle.wbf.get(i)).kGU;
            setMMTitle(((com.tencent.mm.plugin.scanner.model.a)paramBundle.wbf.get(i)).title);
            if (this.vSx != null)
            {
              i = j;
              while (i < this.vSx.size())
              {
                paramBundle = (a.a)this.vSx.get(i);
                if (paramBundle != null)
                {
                  localObject = new a(this);
                  ((a)localObject).setKey(String.valueOf(i));
                  ((a)localObject).setTitle(paramBundle.name);
                  ((a)localObject).setSummary(paramBundle.desc);
                  ((a)localObject).vQC = paramBundle.gKF;
                  this.lxI.b((Preference)localObject);
                  if (i != this.vSx.size() - 1)
                  {
                    paramBundle = new f(getContext());
                    this.lxI.b(paramBundle);
                  }
                }
                i += 1;
              }
              this.lxI.notifyDataSetChanged();
            }
            AppMethodBeat.o(51844);
            return;
          }
          i += 1;
        }
      }
      AppMethodBeat.o(51844);
      return;
    }
    ad.w("MicroMsg.ProductPurchaseAreaUI", "Data product null");
    AppMethodBeat.o(51844);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(51846);
    if (this.vSx == null)
    {
      AppMethodBeat.o(51846);
      return false;
    }
    for (;;)
    {
      a.a locala;
      try
      {
        int i = Integer.valueOf(paramPreference.mKey).intValue();
        if (i >= 0)
        {
          int j = this.vSx.size();
          if (i < j) {}
        }
        else
        {
          AppMethodBeat.o(51846);
          return false;
        }
        locala = (a.a)this.vSx.get(i);
        if (locala == null)
        {
          AppMethodBeat.o(51846);
          return false;
        }
        paramPreference = null;
        switch (locala.type)
        {
        case 1: 
          ad.i("MicroMsg.ProductPurchaseAreaUI", "Default go url:" + locala.link);
          paramf = paramPreference;
          if (!bt.isNullOrNil(locala.link))
          {
            o(getContext(), locala.link, this.vSy);
            paramf = paramPreference;
          }
          paramf = new k(this.oyw, locala.vNZ, locala.type, paramf, this.vSx.size(), locala.dcz);
          g.aeS().a(paramf, 0);
          AppMethodBeat.o(51846);
          return true;
        }
      }
      catch (Exception paramf)
      {
        ad.e("MicroMsg.ProductPurchaseAreaUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        ad.printErrStackTrace("MicroMsg.ProductPurchaseAreaUI", paramf, "", new Object[0]);
        AppMethodBeat.o(51846);
        return false;
      }
      paramf = locala.link;
      if (!bt.isNullOrNil(locala.link))
      {
        o(getContext(), locala.link, this.vSy);
      }
      else
      {
        ad.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
        continue;
        paramPreference = locala.vOa;
        paramf = paramPreference;
        if (!bt.isNullOrNil(locala.vOa))
        {
          paramf = new Intent();
          paramf.putExtra("key_product_id", locala.vOa);
          paramf.putExtra("key_product_scene", 12);
          d.b(this, "product", ".ui.MallProductUI", paramf);
          paramf = paramPreference;
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductPurchaseAreaUI
 * JD-Core Version:    0.7.0.1
 */