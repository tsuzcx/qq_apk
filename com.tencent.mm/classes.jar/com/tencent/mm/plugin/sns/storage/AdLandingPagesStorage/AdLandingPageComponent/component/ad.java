package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad
  extends m
{
  private ImageView dtJ;
  ProgressBar progressBar;
  boolean zQJ;
  com.tencent.mm.plugin.sns.data.h zUA;
  boolean zUs = true;
  String ztE;
  
  public ad(Context paramContext, s params, ViewGroup paramViewGroup)
  {
    super(paramContext, params, paramViewGroup);
  }
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96698);
    if (!super.aQ(paramJSONObject))
    {
      AppMethodBeat.o(96698);
      return false;
    }
    try
    {
      if (!this.zUs)
      {
        String str = aj.ej(((s)this.zUP).zQK);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("urlMd5", str);
        localJSONObject.put("needDownload", 1);
        paramJSONObject.put("imgUrlInfo", localJSONObject);
      }
      AppMethodBeat.o(96698);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ae.printErrStackTrace("AdLandingPagePureImageComponet", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96698);
    }
    return false;
  }
  
  public final boolean an(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96697);
    if (paramBitmap == null)
    {
      ae.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
      AppMethodBeat.o(96697);
      return false;
    }
    if (this.dtJ == null)
    {
      ae.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
      AppMethodBeat.o(96697);
      return false;
    }
    if (paramBitmap.getWidth() == 0)
    {
      ae.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
      AppMethodBeat.o(96697);
      return false;
    }
    this.dtJ.setImageBitmap(paramBitmap);
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(96697);
    return true;
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(96693);
    this.dtJ = ((ImageView)this.contentView.findViewById(2131304915));
    this.progressBar = ((ProgressBar)this.contentView.findViewById(2131303535));
    if (((s)this.zUP).zQL)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("qrExtInfo", ((s)this.zUP).zQM);
      this.zUA = new com.tencent.mm.plugin.sns.data.h(this.context, eaD(), 1, localBundle);
      this.dtJ.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(176279);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePureImageComponet$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
          ae.i("AdLandingPagePureImageComponet", "onLongClick, filePath=" + ad.this.ztE);
          boolean bool = ad.this.zUA.jl(ad.this.ztE, ad.a(ad.this).zQK);
          a.a(bool, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePureImageComponet$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(176279);
          return bool;
        }
      });
    }
    AppMethodBeat.o(96693);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96695);
    if ((this.contentView == null) || (this.dtJ == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(96695);
      return;
    }
    if ((s)this.zUP == null)
    {
      AppMethodBeat.o(96695);
      return;
    }
    String str = ((s)this.zUP).zQK;
    Object localObject = ((s)this.zUP).zOW;
    float f2 = ((s)this.zUP).height;
    float f1 = ((s)this.zUP).width;
    this.zQJ = ((s)this.zUP).zQJ;
    int i;
    if ((f2 != 0.0F) && (f1 != 0.0F) && (!this.zQJ))
    {
      i = this.lxZ - (int)((s)this.zUP).paddingLeft - (int)((s)this.zUP).paddingRight;
      if (f1 >= i) {}
    }
    for (;;)
    {
      f2 = f1 * ((s)this.zUP).height / ((s)this.zUP).width;
      this.dtJ.setLayoutParams(new RelativeLayout.LayoutParams((int)f1, (int)f2));
      label205:
      if ((localObject != null) && (((String)localObject).length() > 0)) {}
      try
      {
        this.dtJ.setBackgroundColor(Color.parseColor((String)localObject));
        label230:
        if ((str == null) || (str.length() <= 0))
        {
          ae.i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
          AppMethodBeat.o(96695);
          return;
          f1 = i;
          continue;
          if ((this.zQJ) && (f2 != 0.0F) && (f1 != 0.0F))
          {
            this.dtJ.setLayoutParams(new RelativeLayout.LayoutParams(this.lxZ, this.lya));
            break label205;
          }
          this.dtJ.setLayoutParams(new RelativeLayout.LayoutParams(this.lxZ, this.lya));
          break label205;
        }
        localObject = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jP("adId", str);
        if ((localObject != null) && (an((Bitmap)localObject)))
        {
          ae.i("AdLandingPagePureImageComponet", "loaded cached image with  ".concat(String.valueOf(str)));
          str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", str);
          if ((!TextUtils.isEmpty(str)) && (o.fB(str))) {
            this.ztE = str;
          }
          this.zUs = true;
          AppMethodBeat.o(96695);
          return;
        }
        this.zUs = false;
        startLoading();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str, ((s)this.zUP).zRh, new f.a()
        {
          public final void ayY(String paramAnonymousString)
          {
            AppMethodBeat.i(96685);
            try
            {
              Bitmap localBitmap = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString);
              ad.this.an(localBitmap);
              ad.this.ztE = paramAnonymousString;
              AppMethodBeat.o(96685);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              ae.e("AdLandingPagePureImageComponet", "%s" + bu.o(paramAnonymousString));
              AppMethodBeat.o(96685);
            }
          }
          
          public final void dVu()
          {
            AppMethodBeat.i(96683);
            ad.this.startLoading();
            AppMethodBeat.o(96683);
          }
          
          public final void dVv()
          {
            AppMethodBeat.i(96684);
            ad.this.progressBar.setVisibility(8);
            AppMethodBeat.o(96684);
          }
        });
        AppMethodBeat.o(96695);
        return;
      }
      catch (Exception localException)
      {
        break label230;
      }
    }
  }
  
  protected final void eah()
  {
    AppMethodBeat.i(96694);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((s)this.zUP).paddingLeft, (int)((s)this.zUP).paddingTop, (int)((s)this.zUP).paddingRight, (int)((s)this.zUP).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(96694);
  }
  
  protected final int getLayout()
  {
    return 2131495507;
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(96696);
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(96696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad
 * JD-Core Version:    0.7.0.1
 */