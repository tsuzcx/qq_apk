package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends n
{
  boolean QOi = true;
  ImageView hIz;
  ProgressBar progressBar;
  
  public h(Context paramContext, ViewGroup paramViewGroup)
  {
    this(paramContext, paramViewGroup, (byte)0);
  }
  
  private h(Context paramContext, ViewGroup paramViewGroup, byte paramByte)
  {
    super(paramContext, null, paramViewGroup);
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(96452);
    View localView = this.contentView;
    this.hIz = ((ImageView)localView.findViewById(b.f.sns_ad_native_landing_pages_items_pure_image_img));
    this.progressBar = ((ProgressBar)localView.findViewById(b.f.progressbar));
    AppMethodBeat.o(96452);
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96456);
    if (!super.bP(paramJSONObject))
    {
      AppMethodBeat.o(96456);
      return false;
    }
    try
    {
      if (!this.QOi)
      {
        String str = MD5Util.getMD5String(((u)this.QOV).QKj);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("urlMd5", str);
        localJSONObject.put("needDownload", 1);
        paramJSONObject.put("imgUrlInfo", localJSONObject);
      }
      AppMethodBeat.o(96456);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("AdLandingImageComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96456);
    }
    return false;
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_image;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96453);
    if ((this.contentView == null) || (this.hIz == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(96453);
      return;
    }
    if ((u)this.QOV == null)
    {
      AppMethodBeat.o(96453);
      return;
    }
    float f1 = ((u)this.QOV).paddingTop;
    float f2 = ((u)this.QOV).paddingBottom;
    float f3 = ((u)this.QOV).paddingLeft;
    float f4 = ((u)this.QOV).paddingRight;
    String str = ((u)this.QOV).QKj;
    float f5 = ((u)this.QOV).height;
    float f6 = ((u)this.QOV).width;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.hIz.getLayoutParams();
    localLayoutParams.width = ((int)f6);
    localLayoutParams.height = ((int)f5);
    this.hIz.setLayoutParams(localLayoutParams);
    this.QOi = false;
    startLoading();
    k.b("adId", str, new g.a()
    {
      public final void aWn(String paramAnonymousString)
      {
        AppMethodBeat.i(96451);
        h localh;
        try
        {
          h.this.stopLoading();
          paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
          localh = h.this;
          if (paramAnonymousString == null)
          {
            Log.e("AdLandingImageComp", "when set image the bmp is null!");
            AppMethodBeat.o(96451);
            return;
          }
          if (localh.hIz == null)
          {
            Log.e("AdLandingImageComp", "when set image the imageView is null!");
            AppMethodBeat.o(96451);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("AdLandingImageComp", "%s" + Util.stackTraceToString(paramAnonymousString));
          AppMethodBeat.o(96451);
          return;
        }
        if (paramAnonymousString.getWidth() == 0)
        {
          Log.e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
          AppMethodBeat.o(96451);
          return;
        }
        localh.hIz.setImageBitmap(paramAnonymousString);
        localh.progressBar.setVisibility(8);
        AppMethodBeat.o(96451);
      }
      
      public final void gZM()
      {
        AppMethodBeat.i(96449);
        h.this.startLoading();
        AppMethodBeat.o(96449);
      }
      
      public final void gZN()
      {
        AppMethodBeat.i(96450);
        h.this.stopLoading();
        AppMethodBeat.o(96450);
      }
    });
    this.contentView.setPadding((int)f3, (int)f1, (int)f4, (int)f2);
    AppMethodBeat.o(96453);
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(96454);
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(96454);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(96455);
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(96455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h
 * JD-Core Version:    0.7.0.1
 */