package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.scanner.l.k;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class ProductPurchaseAreaUI
  extends MMPreference
{
  private int IQA;
  private List<a.a> IQz;
  protected com.tencent.mm.ui.base.preference.f mrf;
  private String uFI;
  
  private static void o(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(51847);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", p.adp(paramInt));
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("pay_channel", 3);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(51847);
  }
  
  public int getResourceId()
  {
    return l.k.IFK;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51845);
    setBackBtn(new ProductPurchaseAreaUI.1(this));
    this.mrf = getPreferenceScreen();
    AppMethodBeat.o(51845);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(51844);
    super.onCreate(paramBundle);
    initView();
    paramBundle = p.fP(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle != null) && (paramBundle.IZR != null))
    {
      this.uFI = paramBundle.field_productid;
      this.IQA = paramBundle.field_functionType;
      Object localObject = getIntent().getStringExtra("referkey");
      Log.i("MicroMsg.ProductPurchaseAreaUI", "referkey:".concat(String.valueOf(localObject)));
      if (!Util.isNullOrNil((String)localObject))
      {
        int i = 0;
        while (i < paramBundle.IZR.size())
        {
          if (((String)localObject).equals(((com.tencent.mm.plugin.scanner.model.a)paramBundle.IZR.get(i)).IKf))
          {
            this.IQz = ((com.tencent.mm.plugin.scanner.model.a)paramBundle.IZR.get(i)).pSC;
            setMMTitle(((com.tencent.mm.plugin.scanner.model.a)paramBundle.IZR.get(i)).title);
            if (this.IQz != null)
            {
              i = j;
              while (i < this.IQz.size())
              {
                paramBundle = (a.a)this.IQz.get(i);
                if (paramBundle != null)
                {
                  localObject = new a(this);
                  ((a)localObject).setKey(String.valueOf(i));
                  ((a)localObject).setTitle(paramBundle.name);
                  ((a)localObject).aF(paramBundle.desc);
                  ((a)localObject).IOC = paramBundle.lpM;
                  this.mrf.b((Preference)localObject);
                  if (i != this.IQz.size() - 1)
                  {
                    paramBundle = new f(getContext());
                    this.mrf.b(paramBundle);
                  }
                }
                i += 1;
              }
              this.mrf.notifyDataSetChanged();
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
    Log.w("MicroMsg.ProductPurchaseAreaUI", "Data product null");
    AppMethodBeat.o(51844);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(51846);
    if (this.IQz == null)
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
          int j = this.IQz.size();
          if (i < j) {}
        }
        else
        {
          AppMethodBeat.o(51846);
          return false;
        }
        locala = (a.a)this.IQz.get(i);
        if (locala == null)
        {
          AppMethodBeat.o(51846);
          return false;
        }
        paramPreference = null;
        switch (locala.type)
        {
        case 1: 
          Log.i("MicroMsg.ProductPurchaseAreaUI", "Default go url:" + locala.link);
          paramf = paramPreference;
          if (!Util.isNullOrNil(locala.link))
          {
            o(getContext(), locala.link, this.IQA);
            paramf = paramPreference;
          }
          paramf = new n(this.uFI, locala.IKl, locala.type, paramf, this.IQz.size(), locala.fwp);
          h.aGY().a(paramf, 0);
          AppMethodBeat.o(51846);
          return true;
        }
      }
      catch (Exception paramf)
      {
        Log.e("MicroMsg.ProductPurchaseAreaUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        Log.printErrStackTrace("MicroMsg.ProductPurchaseAreaUI", paramf, "", new Object[0]);
        AppMethodBeat.o(51846);
        return false;
      }
      paramf = locala.link;
      if (!Util.isNullOrNil(locala.link))
      {
        o(getContext(), locala.link, this.IQA);
      }
      else
      {
        Log.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
        continue;
        paramPreference = locala.IKm;
        paramf = paramPreference;
        if (!Util.isNullOrNil(locala.IKm))
        {
          paramf = new Intent();
          paramf.putExtra("key_product_id", locala.IKm);
          paramf.putExtra("key_product_scene", 12);
          c.b(this, "product", ".ui.MallProductUI", paramf);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductPurchaseAreaUI
 * JD-Core Version:    0.7.0.1
 */