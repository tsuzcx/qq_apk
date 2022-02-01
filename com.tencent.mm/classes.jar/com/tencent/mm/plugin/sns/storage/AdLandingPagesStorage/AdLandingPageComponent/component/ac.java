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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac
  extends l
{
  private ImageView dsD;
  ProgressBar progressBar;
  boolean zDq = true;
  com.tencent.mm.plugin.sns.data.g zDx;
  String zcO;
  boolean zzK;
  
  public ac(Context paramContext, s params, ViewGroup paramViewGroup)
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
      if (!this.zDq)
      {
        String str = ai.ee(((s)this.zDK).zzL);
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
      ad.printErrStackTrace("AdLandingPagePureImageComponet", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96698);
    }
    return false;
  }
  
  public final boolean am(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96697);
    if (paramBitmap == null)
    {
      ad.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
      AppMethodBeat.o(96697);
      return false;
    }
    if (this.dsD == null)
    {
      ad.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
      AppMethodBeat.o(96697);
      return false;
    }
    if (paramBitmap.getWidth() == 0)
    {
      ad.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
      AppMethodBeat.o(96697);
      return false;
    }
    this.dsD.setImageBitmap(paramBitmap);
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(96697);
    return true;
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(96693);
    this.dsD = ((ImageView)this.contentView.findViewById(2131304915));
    this.progressBar = ((ProgressBar)this.contentView.findViewById(2131303535));
    if (((s)this.zDK).zzM)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("qrExtInfo", ((s)this.zDK).zzN);
      this.zDx = new com.tencent.mm.plugin.sns.data.g(this.context, dWZ(), 1, localBundle);
      this.dsD.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(176279);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePureImageComponet$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
          ad.i("AdLandingPagePureImageComponet", "onLongClick, filePath=" + ac.this.zcO);
          boolean bool = ac.this.zDx.je(ac.this.zcO, ac.a(ac.this).zzL);
          a.a(bool, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePureImageComponet$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(176279);
          return bool;
        }
      });
    }
    AppMethodBeat.o(96693);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96695);
    if ((this.contentView == null) || (this.dsD == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(96695);
      return;
    }
    if ((s)this.zDK == null)
    {
      AppMethodBeat.o(96695);
      return;
    }
    String str = ((s)this.zDK).zzL;
    Object localObject = ((s)this.zDK).zxx;
    float f2 = ((s)this.zDK).height;
    float f1 = ((s)this.zDK).width;
    this.zzK = ((s)this.zDK).zzK;
    int i;
    if ((f2 != 0.0F) && (f1 != 0.0F) && (!this.zzK))
    {
      i = this.ltA - (int)((s)this.zDK).paddingLeft - (int)((s)this.zDK).paddingRight;
      if (f1 >= i) {}
    }
    for (;;)
    {
      f2 = f1 * ((s)this.zDK).height / ((s)this.zDK).width;
      this.dsD.setLayoutParams(new RelativeLayout.LayoutParams((int)f1, (int)f2));
      label205:
      if ((localObject != null) && (((String)localObject).length() > 0)) {}
      try
      {
        this.dsD.setBackgroundColor(Color.parseColor((String)localObject));
        label230:
        if ((str == null) || (str.length() <= 0))
        {
          ad.i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
          AppMethodBeat.o(96695);
          return;
          f1 = i;
          continue;
          if ((this.zzK) && (f2 != 0.0F) && (f1 != 0.0F))
          {
            this.dsD.setLayoutParams(new RelativeLayout.LayoutParams(this.ltA, this.ltB));
            break label205;
          }
          this.dsD.setLayoutParams(new RelativeLayout.LayoutParams(this.ltA, this.ltB));
          break label205;
        }
        localObject = h.jJ("adId", str);
        if ((localObject != null) && (am((Bitmap)localObject)))
        {
          ad.i("AdLandingPagePureImageComponet", "loaded cached image with  ".concat(String.valueOf(str)));
          str = h.jF("adId", str);
          if ((!TextUtils.isEmpty(str)) && (i.fv(str))) {
            this.zcO = str;
          }
          this.zDq = true;
          AppMethodBeat.o(96695);
          return;
        }
        this.zDq = false;
        startLoading();
        h.a(str, ((s)this.zDK).zAh, new f.a()
        {
          public final void axG(String paramAnonymousString)
          {
            AppMethodBeat.i(96685);
            try
            {
              Bitmap localBitmap = com.tencent.mm.sdk.platformtools.g.decodeFile(paramAnonymousString);
              ac.this.am(localBitmap);
              ac.this.zcO = paramAnonymousString;
              AppMethodBeat.o(96685);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              ad.e("AdLandingPagePureImageComponet", "%s" + bt.n(paramAnonymousString));
              AppMethodBeat.o(96685);
            }
          }
          
          public final void dRW()
          {
            AppMethodBeat.i(96683);
            ac.this.startLoading();
            AppMethodBeat.o(96683);
          }
          
          public final void dRX()
          {
            AppMethodBeat.i(96684);
            ac.this.progressBar.setVisibility(8);
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
  
  protected final void dWF()
  {
    AppMethodBeat.i(96694);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((s)this.zDK).paddingLeft, (int)((s)this.zDK).paddingTop, (int)((s)this.zDK).paddingRight, (int)((s)this.zDK).paddingBottom);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac
 * JD-Core Version:    0.7.0.1
 */