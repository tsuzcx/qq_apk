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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends l
{
  ImageView dsD;
  ProgressBar progressBar;
  boolean zDq = true;
  
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
      if (!this.zDq)
      {
        String str = ai.ee(((s)this.zDK).zzL);
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
      ad.printErrStackTrace("AdLandingImageComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96456);
    }
    return false;
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(96452);
    View localView = this.contentView;
    this.dsD = ((ImageView)localView.findViewById(2131304915));
    this.progressBar = ((ProgressBar)localView.findViewById(2131303535));
    AppMethodBeat.o(96452);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96453);
    if ((this.contentView == null) || (this.dsD == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(96453);
      return;
    }
    if ((s)this.zDK == null)
    {
      AppMethodBeat.o(96453);
      return;
    }
    float f1 = ((s)this.zDK).paddingTop;
    float f2 = ((s)this.zDK).paddingBottom;
    float f3 = ((s)this.zDK).paddingLeft;
    float f4 = ((s)this.zDK).paddingRight;
    String str = ((s)this.zDK).zzL;
    float f5 = ((s)this.zDK).height;
    float f6 = ((s)this.zDK).width;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.dsD.getLayoutParams();
    localLayoutParams.width = ((int)f6);
    localLayoutParams.height = ((int)f5);
    this.dsD.setLayoutParams(localLayoutParams);
    this.zDq = false;
    startLoading();
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str, ((s)this.zDK).zAh, new f.a()
    {
      public final void axG(String paramAnonymousString)
      {
        AppMethodBeat.i(96451);
        h localh;
        try
        {
          h.this.stopLoading();
          paramAnonymousString = g.decodeFile(paramAnonymousString);
          localh = h.this;
          if (paramAnonymousString == null)
          {
            ad.e("AdLandingImageComp", "when set image the bmp is null!");
            AppMethodBeat.o(96451);
            return;
          }
          if (localh.dsD == null)
          {
            ad.e("AdLandingImageComp", "when set image the imageView is null!");
            AppMethodBeat.o(96451);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          ad.e("AdLandingImageComp", "%s" + bt.n(paramAnonymousString));
          AppMethodBeat.o(96451);
          return;
        }
        if (paramAnonymousString.getWidth() == 0)
        {
          ad.e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
          AppMethodBeat.o(96451);
          return;
        }
        localh.dsD.setImageBitmap(paramAnonymousString);
        localh.progressBar.setVisibility(8);
        AppMethodBeat.o(96451);
      }
      
      public final void dRW()
      {
        AppMethodBeat.i(96449);
        h.this.startLoading();
        AppMethodBeat.o(96449);
      }
      
      public final void dRX()
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