package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class ProductPurchaseAreaUI
  extends MMPreference
{
  protected com.tencent.mm.ui.base.preference.f mEx;
  private String pMk;
  private List<a.a> yHk;
  private int yHl;
  
  private static void n(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(51847);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", p.OW(paramInt));
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
    this.mEx = getPreferenceScreen();
    AppMethodBeat.o(51845);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(51844);
    super.onCreate(paramBundle);
    initView();
    paramBundle = p.eV(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle != null) && (paramBundle.yQm != null))
    {
      this.pMk = paramBundle.field_productid;
      this.yHl = paramBundle.field_functionType;
      Object localObject = getIntent().getStringExtra("referkey");
      ae.i("MicroMsg.ProductPurchaseAreaUI", "referkey:".concat(String.valueOf(localObject)));
      if (!bu.isNullOrNil((String)localObject))
      {
        int i = 0;
        while (i < paramBundle.yQm.size())
        {
          if (((String)localObject).equals(((com.tencent.mm.plugin.scanner.model.a)paramBundle.yQm.get(i)).yBX))
          {
            this.yHk = ((com.tencent.mm.plugin.scanner.model.a)paramBundle.yQm.get(i)).lJQ;
            setMMTitle(((com.tencent.mm.plugin.scanner.model.a)paramBundle.yQm.get(i)).title);
            if (this.yHk != null)
            {
              i = j;
              while (i < this.yHk.size())
              {
                paramBundle = (a.a)this.yHk.get(i);
                if (paramBundle != null)
                {
                  localObject = new a(this);
                  ((a)localObject).setKey(String.valueOf(i));
                  ((a)localObject).setTitle(paramBundle.name);
                  ((a)localObject).setSummary(paramBundle.desc);
                  ((a)localObject).yFk = paramBundle.hGg;
                  this.mEx.b((Preference)localObject);
                  if (i != this.yHk.size() - 1)
                  {
                    paramBundle = new f(getContext());
                    this.mEx.b(paramBundle);
                  }
                }
                i += 1;
              }
              this.mEx.notifyDataSetChanged();
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
    ae.w("MicroMsg.ProductPurchaseAreaUI", "Data product null");
    AppMethodBeat.o(51844);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(51846);
    if (this.yHk == null)
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
          int j = this.yHk.size();
          if (i < j) {}
        }
        else
        {
          AppMethodBeat.o(51846);
          return false;
        }
        locala = (a.a)this.yHk.get(i);
        if (locala == null)
        {
          AppMethodBeat.o(51846);
          return false;
        }
        paramPreference = null;
        switch (locala.type)
        {
        case 1: 
          ae.i("MicroMsg.ProductPurchaseAreaUI", "Default go url:" + locala.link);
          paramf = paramPreference;
          if (!bu.isNullOrNil(locala.link))
          {
            n(getContext(), locala.link, this.yHl);
            paramf = paramPreference;
          }
          paramf = new n(this.pMk, locala.yCd, locala.type, paramf, this.yHk.size(), locala.dmr);
          g.ajj().a(paramf, 0);
          AppMethodBeat.o(51846);
          return true;
        }
      }
      catch (Exception paramf)
      {
        ae.e("MicroMsg.ProductPurchaseAreaUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        ae.printErrStackTrace("MicroMsg.ProductPurchaseAreaUI", paramf, "", new Object[0]);
        AppMethodBeat.o(51846);
        return false;
      }
      paramf = locala.link;
      if (!bu.isNullOrNil(locala.link))
      {
        n(getContext(), locala.link, this.yHl);
      }
      else
      {
        ae.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
        continue;
        paramPreference = locala.yCe;
        paramf = paramPreference;
        if (!bu.isNullOrNil(locala.yCe))
        {
          paramf = new Intent();
          paramf.putExtra("key_product_id", locala.yCe);
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