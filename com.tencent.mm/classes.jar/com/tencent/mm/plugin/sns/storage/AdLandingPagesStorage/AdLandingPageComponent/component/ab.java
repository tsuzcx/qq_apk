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
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends k
{
  private ImageView dhf;
  ProgressBar progressBar;
  String xMW;
  boolean yjc;
  g ymD;
  boolean ymx = true;
  
  public ab(Context paramContext, s params, ViewGroup paramViewGroup)
  {
    super(paramContext, params, paramViewGroup);
  }
  
  public final boolean aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96698);
    if (!super.aH(paramJSONObject))
    {
      AppMethodBeat.o(96698);
      return false;
    }
    try
    {
      if (!this.ymx)
      {
        String str = ah.dg(((s)this.ymQ).yjd);
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
      ac.printErrStackTrace("AdLandingPagePureImageComponet", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96698);
    }
    return false;
  }
  
  public final boolean ak(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96697);
    if (paramBitmap == null)
    {
      ac.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
      AppMethodBeat.o(96697);
      return false;
    }
    if (this.dhf == null)
    {
      ac.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
      AppMethodBeat.o(96697);
      return false;
    }
    if (paramBitmap.getWidth() == 0)
    {
      ac.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
      AppMethodBeat.o(96697);
      return false;
    }
    this.dhf.setImageBitmap(paramBitmap);
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(96697);
    return true;
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96693);
    this.dhf = ((ImageView)this.contentView.findViewById(2131304915));
    this.progressBar = ((ProgressBar)this.contentView.findViewById(2131303535));
    if (((s)this.ymQ).yje)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("qrExtInfo", ((s)this.ymQ).yjf);
      this.ymD = new g(this.context, dKH(), 1, localBundle);
      this.dhf.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(176279);
          ac.i("AdLandingPagePureImageComponet", "onLongClick, filePath=" + ab.this.xMW);
          boolean bool = ab.this.ymD.iT(ab.this.xMW, ab.a(ab.this).yjd);
          AppMethodBeat.o(176279);
          return bool;
        }
      });
    }
    AppMethodBeat.o(96693);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96695);
    if ((this.contentView == null) || (this.dhf == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(96695);
      return;
    }
    if ((s)this.ymQ == null)
    {
      AppMethodBeat.o(96695);
      return;
    }
    String str = ((s)this.ymQ).yjd;
    Object localObject = ((s)this.ymQ).yhq;
    float f2 = ((s)this.ymQ).height;
    float f1 = ((s)this.ymQ).width;
    this.yjc = ((s)this.ymQ).yjc;
    int i;
    if ((f2 != 0.0F) && (f1 != 0.0F) && (!this.yjc))
    {
      i = this.kWB - (int)((s)this.ymQ).paddingLeft - (int)((s)this.ymQ).paddingRight;
      if (f1 >= i) {}
    }
    for (;;)
    {
      f2 = f1 * ((s)this.ymQ).height / ((s)this.ymQ).width;
      this.dhf.setLayoutParams(new RelativeLayout.LayoutParams((int)f1, (int)f2));
      label205:
      if ((localObject != null) && (((String)localObject).length() > 0)) {}
      try
      {
        this.dhf.setBackgroundColor(Color.parseColor((String)localObject));
        label230:
        if ((str == null) || (str.length() <= 0))
        {
          ac.i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
          AppMethodBeat.o(96695);
          return;
          f1 = i;
          continue;
          if ((this.yjc) && (f2 != 0.0F) && (f1 != 0.0F))
          {
            this.dhf.setLayoutParams(new RelativeLayout.LayoutParams(this.kWB, this.kWC));
            break label205;
          }
          this.dhf.setLayoutParams(new RelativeLayout.LayoutParams(this.kWB, this.kWC));
          break label205;
        }
        localObject = h.jw("adId", str);
        if ((localObject != null) && (ak((Bitmap)localObject)))
        {
          ac.i("AdLandingPagePureImageComponet", "loaded cached image with  ".concat(String.valueOf(str)));
          str = h.js("adId", str);
          if ((!TextUtils.isEmpty(str)) && (i.eA(str))) {
            this.xMW = str;
          }
          this.ymx = true;
          AppMethodBeat.o(96695);
          return;
        }
        this.ymx = false;
        startLoading();
        h.a(str, ((s)this.ymQ).yjt, new f.a()
        {
          public final void asD(String paramAnonymousString)
          {
            AppMethodBeat.i(96685);
            try
            {
              Bitmap localBitmap = f.decodeFile(paramAnonymousString);
              ab.this.ak(localBitmap);
              ab.this.xMW = paramAnonymousString;
              AppMethodBeat.o(96685);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              ac.e("AdLandingPagePureImageComponet", "%s" + bs.m(paramAnonymousString));
              AppMethodBeat.o(96685);
            }
          }
          
          public final void dFC()
          {
            AppMethodBeat.i(96683);
            ab.this.startLoading();
            AppMethodBeat.o(96683);
          }
          
          public final void dFD()
          {
            AppMethodBeat.i(96684);
            ab.this.progressBar.setVisibility(8);
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
  
  protected final void dKs()
  {
    AppMethodBeat.i(96694);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((s)this.ymQ).paddingLeft, (int)((s)this.ymQ).paddingTop, (int)((s)this.ymQ).paddingRight, (int)((s)this.ymQ).paddingBottom);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab
 * JD-Core Version:    0.7.0.1
 */