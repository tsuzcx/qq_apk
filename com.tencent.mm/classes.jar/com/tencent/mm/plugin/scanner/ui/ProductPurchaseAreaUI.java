package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.b;
import com.tencent.mm.plugin.scanner.model.b.a;
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.plugin.scanner.model.r;
import com.tencent.mm.plugin.scanner.util.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class ProductPurchaseAreaUI
  extends MMPreference
{
  private List<b.a> CKY;
  private int CKZ;
  protected com.tencent.mm.ui.base.preference.f nRm;
  private String rcD;
  
  private static void n(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(51847);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", r.Wu(paramInt));
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("pay_channel", 3);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(51847);
  }
  
  public int getResourceId()
  {
    return 2132017247;
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
    this.nRm = getPreferenceScreen();
    AppMethodBeat.o(51845);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(51844);
    super.onCreate(paramBundle);
    initView();
    paramBundle = r.fn(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle != null) && (paramBundle.CUx != null))
    {
      this.rcD = paramBundle.field_productid;
      this.CKZ = paramBundle.field_functionType;
      Object localObject = getIntent().getStringExtra("referkey");
      Log.i("MicroMsg.ProductPurchaseAreaUI", "referkey:".concat(String.valueOf(localObject)));
      if (!Util.isNullOrNil((String)localObject))
      {
        int i = 0;
        while (i < paramBundle.CUx.size())
        {
          if (((String)localObject).equals(((b)paramBundle.CUx.get(i)).CEG))
          {
            this.CKY = ((b)paramBundle.CUx.get(i)).mRG;
            setMMTitle(((b)paramBundle.CUx.get(i)).title);
            if (this.CKY != null)
            {
              i = j;
              while (i < this.CKY.size())
              {
                paramBundle = (b.a)this.CKY.get(i);
                if (paramBundle != null)
                {
                  localObject = new a(this);
                  ((a)localObject).setKey(String.valueOf(i));
                  ((a)localObject).setTitle(paramBundle.name);
                  ((a)localObject).setSummary(paramBundle.desc);
                  ((a)localObject).CJc = paramBundle.iAq;
                  this.nRm.c((Preference)localObject);
                  if (i != this.CKY.size() - 1)
                  {
                    paramBundle = new f(getContext());
                    this.nRm.c(paramBundle);
                  }
                }
                i += 1;
              }
              this.nRm.notifyDataSetChanged();
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
    if (this.CKY == null)
    {
      AppMethodBeat.o(51846);
      return false;
    }
    for (;;)
    {
      b.a locala;
      try
      {
        int i = Integer.valueOf(paramPreference.mKey).intValue();
        if (i >= 0)
        {
          int j = this.CKY.size();
          if (i < j) {}
        }
        else
        {
          AppMethodBeat.o(51846);
          return false;
        }
        locala = (b.a)this.CKY.get(i);
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
            n(getContext(), locala.link, this.CKZ);
            paramf = paramPreference;
          }
          paramf = new p(this.rcD, locala.CEM, locala.type, paramf, this.CKY.size(), locala.dDG);
          g.azz().a(paramf, 0);
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
        n(getContext(), locala.link, this.CKZ);
      }
      else
      {
        Log.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
        continue;
        paramPreference = locala.CEN;
        paramf = paramPreference;
        if (!Util.isNullOrNil(locala.CEN))
        {
          paramf = new Intent();
          paramf.putExtra("key_product_id", locala.CEN);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductPurchaseAreaUI
 * JD-Core Version:    0.7.0.1
 */