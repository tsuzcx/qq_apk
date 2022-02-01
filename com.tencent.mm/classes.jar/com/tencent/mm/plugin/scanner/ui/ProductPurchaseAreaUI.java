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
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class ProductPurchaseAreaUI
  extends MMPreference
{
  protected com.tencent.mm.ui.base.preference.f lZC;
  private String pbW;
  private List<a.a> xdi;
  private int xdj;
  
  private static void o(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(51847);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", m.MO(paramInt));
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
    this.lZC = getPreferenceScreen();
    AppMethodBeat.o(51845);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(51844);
    super.onCreate(paramBundle);
    initView();
    paramBundle = m.ev(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle != null) && (paramBundle.xml != null))
    {
      this.pbW = paramBundle.field_productid;
      this.xdj = paramBundle.field_functionType;
      Object localObject = getIntent().getStringExtra("referkey");
      ac.i("MicroMsg.ProductPurchaseAreaUI", "referkey:".concat(String.valueOf(localObject)));
      if (!bs.isNullOrNil((String)localObject))
      {
        int i = 0;
        while (i < paramBundle.xml.size())
        {
          if (((String)localObject).equals(((com.tencent.mm.plugin.scanner.model.a)paramBundle.xml.get(i)).wYp))
          {
            this.xdi = ((com.tencent.mm.plugin.scanner.model.a)paramBundle.xml.get(i)).lio;
            setMMTitle(((com.tencent.mm.plugin.scanner.model.a)paramBundle.xml.get(i)).title);
            if (this.xdi != null)
            {
              i = j;
              while (i < this.xdi.size())
              {
                paramBundle = (a.a)this.xdi.get(i);
                if (paramBundle != null)
                {
                  localObject = new a(this);
                  ((a)localObject).setKey(String.valueOf(i));
                  ((a)localObject).setTitle(paramBundle.name);
                  ((a)localObject).setSummary(paramBundle.desc);
                  ((a)localObject).xbk = paramBundle.hlf;
                  this.lZC.b((Preference)localObject);
                  if (i != this.xdi.size() - 1)
                  {
                    paramBundle = new f(getContext());
                    this.lZC.b(paramBundle);
                  }
                }
                i += 1;
              }
              this.lZC.notifyDataSetChanged();
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
    ac.w("MicroMsg.ProductPurchaseAreaUI", "Data product null");
    AppMethodBeat.o(51844);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(51846);
    if (this.xdi == null)
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
          int j = this.xdi.size();
          if (i < j) {}
        }
        else
        {
          AppMethodBeat.o(51846);
          return false;
        }
        locala = (a.a)this.xdi.get(i);
        if (locala == null)
        {
          AppMethodBeat.o(51846);
          return false;
        }
        paramPreference = null;
        switch (locala.type)
        {
        case 1: 
          ac.i("MicroMsg.ProductPurchaseAreaUI", "Default go url:" + locala.link);
          paramf = paramPreference;
          if (!bs.isNullOrNil(locala.link))
          {
            o(getContext(), locala.link, this.xdj);
            paramf = paramPreference;
          }
          paramf = new k(this.pbW, locala.wYv, locala.type, paramf, this.xdi.size(), locala.cZX);
          g.agi().a(paramf, 0);
          AppMethodBeat.o(51846);
          return true;
        }
      }
      catch (Exception paramf)
      {
        ac.e("MicroMsg.ProductPurchaseAreaUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        ac.printErrStackTrace("MicroMsg.ProductPurchaseAreaUI", paramf, "", new Object[0]);
        AppMethodBeat.o(51846);
        return false;
      }
      paramf = locala.link;
      if (!bs.isNullOrNil(locala.link))
      {
        o(getContext(), locala.link, this.xdj);
      }
      else
      {
        ac.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
        continue;
        paramPreference = locala.wYw;
        paramf = paramPreference;
        if (!bs.isNullOrNil(locala.wYw))
        {
          paramf = new Intent();
          paramf.putExtra("key_product_id", locala.wYw);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductPurchaseAreaUI
 * JD-Core Version:    0.7.0.1
 */