package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.model.o;
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
  protected com.tencent.mm.ui.base.preference.f mzx;
  private String pFG;
  private List<a.a> yrk;
  private int yrl;
  
  private static void o(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(51847);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", o.Oq(paramInt));
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(51843);
        ProductPurchaseAreaUI.this.finish();
        AppMethodBeat.o(51843);
        return false;
      }
    });
    this.mzx = getPreferenceScreen();
    AppMethodBeat.o(51845);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(51844);
    super.onCreate(paramBundle);
    initView();
    paramBundle = o.eN(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle != null) && (paramBundle.yAm != null))
    {
      this.pFG = paramBundle.field_productid;
      this.yrl = paramBundle.field_functionType;
      Object localObject = getIntent().getStringExtra("referkey");
      ad.i("MicroMsg.ProductPurchaseAreaUI", "referkey:".concat(String.valueOf(localObject)));
      if (!bt.isNullOrNil((String)localObject))
      {
        int i = 0;
        while (i < paramBundle.yAm.size())
        {
          if (((String)localObject).equals(((com.tencent.mm.plugin.scanner.model.a)paramBundle.yAm.get(i)).ylY))
          {
            this.yrk = ((com.tencent.mm.plugin.scanner.model.a)paramBundle.yAm.get(i)).lFr;
            setMMTitle(((com.tencent.mm.plugin.scanner.model.a)paramBundle.yAm.get(i)).title);
            if (this.yrk != null)
            {
              i = j;
              while (i < this.yrk.size())
              {
                paramBundle = (a.a)this.yrk.get(i);
                if (paramBundle != null)
                {
                  localObject = new a(this);
                  ((a)localObject).setKey(String.valueOf(i));
                  ((a)localObject).setTitle(paramBundle.name);
                  ((a)localObject).setSummary(paramBundle.desc);
                  ((a)localObject).ypl = paramBundle.hDo;
                  this.mzx.b((Preference)localObject);
                  if (i != this.yrk.size() - 1)
                  {
                    paramBundle = new f(getContext());
                    this.mzx.b(paramBundle);
                  }
                }
                i += 1;
              }
              this.mzx.notifyDataSetChanged();
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
    if (this.yrk == null)
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
          int j = this.yrk.size();
          if (i < j) {}
        }
        else
        {
          AppMethodBeat.o(51846);
          return false;
        }
        locala = (a.a)this.yrk.get(i);
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
            o(getContext(), locala.link, this.yrl);
            paramf = paramPreference;
          }
          paramf = new m(this.pFG, locala.yme, locala.type, paramf, this.yrk.size(), locala.dlp);
          g.aiU().a(paramf, 0);
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
        o(getContext(), locala.link, this.yrl);
      }
      else
      {
        ad.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
        continue;
        paramPreference = locala.ymf;
        paramf = paramPreference;
        if (!bt.isNullOrNil(locala.ymf))
        {
          paramf = new Intent();
          paramf.putExtra("key_product_id", locala.ymf);
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