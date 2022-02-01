package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends m
{
  boolean Kqb = true;
  ImageView fDJ;
  ProgressBar progressBar;
  
  public h(Context paramContext, ViewGroup paramViewGroup)
  {
    this(paramContext, paramViewGroup, (byte)0);
  }
  
  private h(Context paramContext, ViewGroup paramViewGroup, byte paramByte)
  {
    super(paramContext, null, paramViewGroup);
  }
  
  public final boolean by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96456);
    if (!super.by(paramJSONObject))
    {
      AppMethodBeat.o(96456);
      return false;
    }
    try
    {
      if (!this.Kqb)
      {
        String str = MD5Util.getMD5String(((u)this.KqB).Kmf);
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
  
  protected final void fKe()
  {
    AppMethodBeat.i(96453);
    if ((this.contentView == null) || (this.fDJ == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(96453);
      return;
    }
    if ((u)this.KqB == null)
    {
      AppMethodBeat.o(96453);
      return;
    }
    float f1 = ((u)this.KqB).paddingTop;
    float f2 = ((u)this.KqB).paddingBottom;
    float f3 = ((u)this.KqB).paddingLeft;
    float f4 = ((u)this.KqB).paddingRight;
    String str = ((u)this.KqB).Kmf;
    float f5 = ((u)this.KqB).height;
    float f6 = ((u)this.KqB).width;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.fDJ.getLayoutParams();
    localLayoutParams.width = ((int)f6);
    localLayoutParams.height = ((int)f5);
    this.fDJ.setLayoutParams(localLayoutParams);
    this.Kqb = false;
    startLoading();
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", str, new f.a()
    {
      public final void aYs(String paramAnonymousString)
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
          if (localh.fDJ == null)
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
        localh.fDJ.setImageBitmap(paramAnonymousString);
        localh.progressBar.setVisibility(8);
        AppMethodBeat.o(96451);
      }
      
      public final void fJU()
      {
        AppMethodBeat.i(96449);
        h.this.startLoading();
        AppMethodBeat.o(96449);
      }
      
      public final void fJV()
      {
        AppMethodBeat.i(96450);
        h.this.stopLoading();
        AppMethodBeat.o(96450);
      }
    });
    this.contentView.setPadding((int)f3, (int)f1, (int)f4, (int)f2);
    AppMethodBeat.o(96453);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(96452);
    View localView = this.contentView;
    this.fDJ = ((ImageView)localView.findViewById(i.f.sns_ad_native_landing_pages_items_pure_image_img));
    this.progressBar = ((ProgressBar)localView.findViewById(i.f.progressbar));
    AppMethodBeat.o(96452);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_image;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h
 * JD-Core Version:    0.7.0.1
 */