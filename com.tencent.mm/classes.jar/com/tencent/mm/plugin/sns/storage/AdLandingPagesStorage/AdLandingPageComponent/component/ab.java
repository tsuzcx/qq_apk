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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends k
{
  private ImageView djK;
  ProgressBar progressBar;
  String wAD;
  boolean wWo;
  boolean wZK = true;
  g wZQ;
  
  public ab(Context paramContext, s params, ViewGroup paramViewGroup)
  {
    super(paramContext, params, paramViewGroup);
  }
  
  public final boolean aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96698);
    if (!super.aG(paramJSONObject))
    {
      AppMethodBeat.o(96698);
      return false;
    }
    try
    {
      if (!this.wZK)
      {
        String str = ai.du(((s)this.xab).wWp);
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
  
  public final boolean aj(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96697);
    if (paramBitmap == null)
    {
      ad.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
      AppMethodBeat.o(96697);
      return false;
    }
    if (this.djK == null)
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
    this.djK.setImageBitmap(paramBitmap);
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(96697);
    return true;
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(96695);
    if ((this.contentView == null) || (this.djK == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(96695);
      return;
    }
    if ((s)this.xab == null)
    {
      AppMethodBeat.o(96695);
      return;
    }
    String str = ((s)this.xab).wWp;
    Object localObject = ((s)this.xab).wUC;
    float f2 = ((s)this.xab).height;
    float f1 = ((s)this.xab).width;
    this.wWo = ((s)this.xab).wWo;
    int i;
    if ((f2 != 0.0F) && (f1 != 0.0F) && (!this.wWo))
    {
      i = this.kvn - (int)((s)this.xab).paddingLeft - (int)((s)this.xab).paddingRight;
      if (f1 >= i) {}
    }
    for (;;)
    {
      f2 = f1 * ((s)this.xab).height / ((s)this.xab).width;
      this.djK.setLayoutParams(new RelativeLayout.LayoutParams((int)f1, (int)f2));
      label205:
      if ((localObject != null) && (((String)localObject).length() > 0)) {}
      try
      {
        this.djK.setBackgroundColor(Color.parseColor((String)localObject));
        label230:
        if ((str == null) || (str.length() <= 0))
        {
          ad.i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
          AppMethodBeat.o(96695);
          return;
          f1 = i;
          continue;
          if ((this.wWo) && (f2 != 0.0F) && (f1 != 0.0F))
          {
            this.djK.setLayoutParams(new RelativeLayout.LayoutParams(this.kvn, this.kvo));
            break label205;
          }
          this.djK.setLayoutParams(new RelativeLayout.LayoutParams(this.kvn, this.kvo));
          break label205;
        }
        localObject = h.iY("adId", str);
        if ((localObject != null) && (aj((Bitmap)localObject)))
        {
          ad.i("AdLandingPagePureImageComponet", "loaded cached image with  ".concat(String.valueOf(str)));
          str = h.iU("adId", str);
          if ((!TextUtils.isEmpty(str)) && (i.eK(str))) {
            this.wAD = str;
          }
          this.wZK = true;
          AppMethodBeat.o(96695);
          return;
        }
        this.wZK = false;
        startLoading();
        h.a(str, ((s)this.xab).wWF, new f.a()
        {
          public final void apm(String paramAnonymousString)
          {
            AppMethodBeat.i(96685);
            try
            {
              Bitmap localBitmap = f.decodeFile(paramAnonymousString);
              ab.this.aj(localBitmap);
              ab.this.wAD = paramAnonymousString;
              AppMethodBeat.o(96685);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              ad.e("AdLandingPagePureImageComponet", "%s" + bt.m(paramAnonymousString));
              AppMethodBeat.o(96685);
            }
          }
          
          public final void dsA()
          {
            AppMethodBeat.i(96684);
            ab.this.progressBar.setVisibility(8);
            AppMethodBeat.o(96684);
          }
          
          public final void duP()
          {
            AppMethodBeat.i(96683);
            ab.this.startLoading();
            AppMethodBeat.o(96683);
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
  
  protected final void dvT()
  {
    AppMethodBeat.i(96694);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((s)this.xab).paddingLeft, (int)((s)this.xab).paddingTop, (int)((s)this.xab).paddingRight, (int)((s)this.xab).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(96694);
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(96693);
    this.djK = ((ImageView)this.contentView.findViewById(2131304915));
    this.progressBar = ((ProgressBar)this.contentView.findViewById(2131303535));
    if (((s)this.xab).wWq)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("qrExtInfo", ((s)this.xab).wWr);
      this.wZQ = new g(this.context, dwi(), 1, localBundle);
      this.djK.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(176279);
          ad.i("AdLandingPagePureImageComponet", "onLongClick, filePath=" + ab.this.wAD);
          boolean bool = ab.this.wZQ.iw(ab.this.wAD, ab.a(ab.this).wWp);
          AppMethodBeat.o(176279);
          return bool;
        }
      });
    }
    AppMethodBeat.o(96693);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab
 * JD-Core Version:    0.7.0.1
 */