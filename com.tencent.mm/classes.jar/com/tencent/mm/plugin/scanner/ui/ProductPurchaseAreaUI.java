package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.i;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;

public class ProductPurchaseAreaUI
  extends MMPreference
{
  protected f iLA;
  private String liu;
  private List<a.a> qxD;
  private int qxE;
  
  private static void n(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(81076);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", k.CD(paramInt));
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("pay_channel", 3);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(81076);
  }
  
  public int getResourceId()
  {
    return 2131165260;
  }
  
  public void initView()
  {
    AppMethodBeat.i(81074);
    setBackBtn(new ProductPurchaseAreaUI.1(this));
    this.iLA = getPreferenceScreen();
    AppMethodBeat.o(81074);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(81073);
    super.onCreate(paramBundle);
    initView();
    paramBundle = k.dg(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
    if ((paramBundle != null) && (paramBundle.qDK != null))
    {
      this.liu = paramBundle.field_productid;
      this.qxE = paramBundle.field_functionType;
      Object localObject = getIntent().getStringExtra("referkey");
      ab.i("MicroMsg.ProductPurchaseAreaUI", "referkey:".concat(String.valueOf(localObject)));
      if (!bo.isNullOrNil((String)localObject))
      {
        int i = 0;
        while (i < paramBundle.qDK.size())
        {
          if (((String)localObject).equals(((com.tencent.mm.plugin.scanner.model.a)paramBundle.qDK.get(i)).qtQ))
          {
            this.qxD = ((com.tencent.mm.plugin.scanner.model.a)paramBundle.qDK.get(i)).fQb;
            setMMTitle(((com.tencent.mm.plugin.scanner.model.a)paramBundle.qDK.get(i)).title);
            if (this.qxD != null)
            {
              i = j;
              while (i < this.qxD.size())
              {
                paramBundle = (a.a)this.qxD.get(i);
                if (paramBundle != null)
                {
                  localObject = new a(this);
                  ((a)localObject).setKey(String.valueOf(i));
                  ((a)localObject).setTitle(paramBundle.name);
                  ((a)localObject).setSummary(paramBundle.desc);
                  ((a)localObject).qvw = paramBundle.fjL;
                  this.iLA.b((Preference)localObject);
                  if (i != this.qxD.size() - 1)
                  {
                    paramBundle = new g(getContext());
                    this.iLA.b(paramBundle);
                  }
                }
                i += 1;
              }
              this.iLA.notifyDataSetChanged();
            }
            AppMethodBeat.o(81073);
            return;
          }
          i += 1;
        }
      }
      AppMethodBeat.o(81073);
      return;
    }
    ab.w("MicroMsg.ProductPurchaseAreaUI", "Data product null");
    AppMethodBeat.o(81073);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(81075);
    if (this.qxD == null)
    {
      AppMethodBeat.o(81075);
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
          int j = this.qxD.size();
          if (i < j) {}
        }
        else
        {
          AppMethodBeat.o(81075);
          return false;
        }
        locala = (a.a)this.qxD.get(i);
        if (locala == null)
        {
          AppMethodBeat.o(81075);
          return false;
        }
        paramPreference = null;
        switch (locala.type)
        {
        case 1: 
          ab.i("MicroMsg.ProductPurchaseAreaUI", "Default go url:" + locala.link);
          paramf = paramPreference;
          if (!bo.isNullOrNil(locala.link))
          {
            n(getContext(), locala.link, this.qxE);
            paramf = paramPreference;
          }
          paramf = new i(this.liu, locala.qtW, locala.type, paramf, this.qxD.size(), locala.showType);
          com.tencent.mm.kernel.g.Rc().a(paramf, 0);
          AppMethodBeat.o(81075);
          return true;
        }
      }
      catch (Exception paramf)
      {
        ab.e("MicroMsg.ProductPurchaseAreaUI", "onPreferenceTreeClick, [%s]", new Object[] { paramf.getMessage() });
        ab.printErrStackTrace("MicroMsg.ProductPurchaseAreaUI", paramf, "", new Object[0]);
        AppMethodBeat.o(81075);
        return false;
      }
      paramf = locala.link;
      if (!bo.isNullOrNil(locala.link))
      {
        n(getContext(), locala.link, this.qxE);
      }
      else
      {
        ab.w("MicroMsg.ProductPurchaseAreaUI", "action link empty");
        continue;
        paramPreference = locala.qtX;
        paramf = paramPreference;
        if (!bo.isNullOrNil(locala.qtX))
        {
          paramf = new Intent();
          paramf.putExtra("key_product_id", locala.qtX);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductPurchaseAreaUI
 * JD-Core Version:    0.7.0.1
 */