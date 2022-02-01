package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends m
{
  ImageView dtJ;
  ProgressBar progressBar;
  boolean zUs = true;
  
  public h(Context paramContext, ViewGroup paramViewGroup)
  {
    this(paramContext, paramViewGroup, (byte)0);
  }
  
  private h(Context paramContext, ViewGroup paramViewGroup, byte paramByte)
  {
    super(paramContext, null, paramViewGroup);
  }
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96456);
    if (!super.aQ(paramJSONObject))
    {
      AppMethodBeat.o(96456);
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
      AppMethodBeat.o(96456);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ae.printErrStackTrace("AdLandingImageComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96456);
    }
    return false;
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(96452);
    View localView = this.contentView;
    this.dtJ = ((ImageView)localView.findViewById(2131304915));
    this.progressBar = ((ProgressBar)localView.findViewById(2131303535));
    AppMethodBeat.o(96452);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96453);
    if ((this.contentView == null) || (this.dtJ == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(96453);
      return;
    }
    if ((s)this.zUP == null)
    {
      AppMethodBeat.o(96453);
      return;
    }
    float f1 = ((s)this.zUP).paddingTop;
    float f2 = ((s)this.zUP).paddingBottom;
    float f3 = ((s)this.zUP).paddingLeft;
    float f4 = ((s)this.zUP).paddingRight;
    String str = ((s)this.zUP).zQK;
    float f5 = ((s)this.zUP).height;
    float f6 = ((s)this.zUP).width;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.dtJ.getLayoutParams();
    localLayoutParams.width = ((int)f6);
    localLayoutParams.height = ((int)f5);
    this.dtJ.setLayoutParams(localLayoutParams);
    this.zUs = false;
    startLoading();
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str, ((s)this.zUP).zRh, new f.a()
    {
      public final void ayY(String paramAnonymousString)
      {
        AppMethodBeat.i(96451);
        h localh;
        try
        {
          h.this.stopLoading();
          paramAnonymousString = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString);
          localh = h.this;
          if (paramAnonymousString == null)
          {
            ae.e("AdLandingImageComp", "when set image the bmp is null!");
            AppMethodBeat.o(96451);
            return;
          }
          if (localh.dtJ == null)
          {
            ae.e("AdLandingImageComp", "when set image the imageView is null!");
            AppMethodBeat.o(96451);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          ae.e("AdLandingImageComp", "%s" + bu.o(paramAnonymousString));
          AppMethodBeat.o(96451);
          return;
        }
        if (paramAnonymousString.getWidth() == 0)
        {
          ae.e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
          AppMethodBeat.o(96451);
          return;
        }
        localh.dtJ.setImageBitmap(paramAnonymousString);
        localh.progressBar.setVisibility(8);
        AppMethodBeat.o(96451);
      }
      
      public final void dVu()
      {
        AppMethodBeat.i(96449);
        h.this.startLoading();
        AppMethodBeat.o(96449);
      }
      
      public final void dVv()
      {
        AppMethodBeat.i(96450);
        h.this.stopLoading();
        AppMethodBeat.o(96450);
      }
    });
    this.contentView.setPadding((int)f3, (int)f1, (int)f4, (int)f2);
    AppMethodBeat.o(96453);
  }
  
  protected final int getLayout()
  {
    return 2131495502;
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