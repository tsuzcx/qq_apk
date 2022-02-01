package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.scanner.l.k;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.v;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class ProductPurchaseAreaUI
  extends MMPreference
{
  private List<a.a> OZv;
  private int OZw;
  protected com.tencent.mm.ui.base.preference.f pkD;
  private String xOk;
  
  private static void q(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(51847);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", x.ahM(paramInt));
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("pay_channel", 3);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(51847);
  }
  
  public int getResourceId()
  {
    return l.k.OLT;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51845);
    setBackBtn(new ProductPurchaseAreaUI.1(this));
    this.pkD = getPreferenceScreen();
    AppMethodBeat.o(51845);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(51844);
    super.onCreate(paramBundle);
    initView();
    paramBundle = x.gI(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle != null) && (paramBundle.PjJ != null))
    {
      this.xOk = paramBundle.field_productid;
      this.OZw = paramBundle.field_functionType;
      Object localObject = getIntent().getStringExtra("referkey");
      Log.i("MicroMsg.ProductPurchaseAreaUI", "referkey:".concat(String.valueOf(localObject)));
      if (!Util.isNullOrNil((String)localObject))
      {
        int i = 0;
        while (i < paramBundle.PjJ.size())
        {
          if (((String)localObject).equals(((com.tencent.mm.plugin.scanner.model.a)paramBundle.PjJ.get(i)).OQP))
          {
            this.OZv = ((com.tencent.mm.plugin.scanner.model.a)paramBundle.PjJ.get(i)).sXD;
            setMMTitle(((com.tencent.mm.plugin.scanner.model.a)paramBundle.PjJ.get(i)).title);
            if (this.OZv != null)
            {
              i = j;
              while (i < this.OZv.size())
              {
                paramBundle = (a.a)this.OZv.get(i);
                if (paramBundle != null)
                {
                  localObject = new a(this);
                  ((a)localObject).setKey(String.valueOf(i));
                  ((a)localObject).setTitle(paramBundle.name);
                  ((a)localObject).aS(paramBundle.desc);
                  ((a)localObject).OXe = paramBundle.nUO;
                  this.pkD.c((Preference)localObject);
                  if (i != this.OZv.size() - 1)
                  {
                    paramBundle = new f(getContext());
                    this.pkD.c(paramBundle);
                  }
                }
                i += 1;
              }
              this.pkD.notifyDataSetChanged();
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
    if (this.OZv == null)
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
          int j = this.OZv.size();
          if (i < j) {}
        }
        else
        {
          AppMethodBeat.o(51846);
          return false;
        }
        locala = (a.a)this.OZv.get(i);
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
            q(getContext(), locala.link, this.OZw);
            paramf = paramPreference;
          }
          paramf = new v(this.xOk, locala.OQV, locala.type, paramf, this.OZv.size(), locala.hAN);
          h.aZW().a(paramf, 0);
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
        q(getContext(), locala.link, this.OZw);
      }
      else
      {
        Log.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
        continue;
        paramPreference = locala.productid;
        paramf = paramPreference;
        if (!Util.isNullOrNil(locala.productid))
        {
          paramf = new Intent();
          paramf.putExtra("key_product_id", locala.productid);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductPurchaseAreaUI
 * JD-Core Version:    0.7.0.1
 */