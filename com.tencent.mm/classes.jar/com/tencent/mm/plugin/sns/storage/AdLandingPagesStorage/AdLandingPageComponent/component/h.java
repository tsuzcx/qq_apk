package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
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
  boolean Ecz = true;
  ImageView dKU;
  ProgressBar progressBar;
  
  public h(Context paramContext, ViewGroup paramViewGroup)
  {
    this(paramContext, paramViewGroup, (byte)0);
  }
  
  private h(Context paramContext, ViewGroup paramViewGroup, byte paramByte)
  {
    super(paramContext, null, paramViewGroup);
  }
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96456);
    if (!super.bp(paramJSONObject))
    {
      AppMethodBeat.o(96456);
      return false;
    }
    try
    {
      if (!this.Ecz)
      {
        String str = MD5Util.getMD5String(((t)this.EcX).DYK);
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
  
  protected final void eWT()
  {
    AppMethodBeat.i(96453);
    if ((this.contentView == null) || (this.dKU == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(96453);
      return;
    }
    if ((t)this.EcX == null)
    {
      AppMethodBeat.o(96453);
      return;
    }
    float f1 = ((t)this.EcX).paddingTop;
    float f2 = ((t)this.EcX).paddingBottom;
    float f3 = ((t)this.EcX).paddingLeft;
    float f4 = ((t)this.EcX).paddingRight;
    String str = ((t)this.EcX).DYK;
    float f5 = ((t)this.EcX).height;
    float f6 = ((t)this.EcX).width;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.dKU.getLayoutParams();
    localLayoutParams.width = ((int)f6);
    localLayoutParams.height = ((int)f5);
    this.dKU.setLayoutParams(localLayoutParams);
    this.Ecz = false;
    startLoading();
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str, ((t)this.EcX).DZj, new f.a()
    {
      public final void aNH(String paramAnonymousString)
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
          if (localh.dKU == null)
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
        localh.dKU.setImageBitmap(paramAnonymousString);
        localh.progressBar.setVisibility(8);
        AppMethodBeat.o(96451);
      }
      
      public final void eWN()
      {
        AppMethodBeat.i(96449);
        h.this.startLoading();
        AppMethodBeat.o(96449);
      }
      
      public final void eWO()
      {
        AppMethodBeat.i(96450);
        h.this.stopLoading();
        AppMethodBeat.o(96450);
      }
    });
    this.contentView.setPadding((int)f3, (int)f1, (int)f4, (int)f2);
    AppMethodBeat.o(96453);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(96452);
    View localView = this.contentView;
    this.dKU = ((ImageView)localView.findViewById(2131308051));
    this.progressBar = ((ProgressBar)localView.findViewById(2131306302));
    AppMethodBeat.o(96452);
  }
  
  protected final int getLayout()
  {
    return 2131496387;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h
 * JD-Core Version:    0.7.0.1
 */