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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends k
{
  ImageView dhf;
  ProgressBar progressBar;
  boolean ymx = true;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    this(paramContext, paramViewGroup, (byte)0);
  }
  
  private g(Context paramContext, ViewGroup paramViewGroup, byte paramByte)
  {
    super(paramContext, null, paramViewGroup);
  }
  
  public final boolean aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96456);
    if (!super.aH(paramJSONObject))
    {
      AppMethodBeat.o(96456);
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
      AppMethodBeat.o(96456);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ac.printErrStackTrace("AdLandingImageComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96456);
    }
    return false;
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96452);
    View localView = this.contentView;
    this.dhf = ((ImageView)localView.findViewById(2131304915));
    this.progressBar = ((ProgressBar)localView.findViewById(2131303535));
    AppMethodBeat.o(96452);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96453);
    if ((this.contentView == null) || (this.dhf == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(96453);
      return;
    }
    if ((s)this.ymQ == null)
    {
      AppMethodBeat.o(96453);
      return;
    }
    float f1 = ((s)this.ymQ).paddingTop;
    float f2 = ((s)this.ymQ).paddingBottom;
    float f3 = ((s)this.ymQ).paddingLeft;
    float f4 = ((s)this.ymQ).paddingRight;
    String str = ((s)this.ymQ).yjd;
    float f5 = ((s)this.ymQ).height;
    float f6 = ((s)this.ymQ).width;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.dhf.getLayoutParams();
    localLayoutParams.width = ((int)f6);
    localLayoutParams.height = ((int)f5);
    this.dhf.setLayoutParams(localLayoutParams);
    this.ymx = false;
    startLoading();
    h.a(str, ((s)this.ymQ).yjt, new f.a()
    {
      public final void asD(String paramAnonymousString)
      {
        AppMethodBeat.i(96451);
        g localg;
        try
        {
          g.this.stopLoading();
          paramAnonymousString = f.decodeFile(paramAnonymousString);
          localg = g.this;
          if (paramAnonymousString == null)
          {
            ac.e("AdLandingImageComp", "when set image the bmp is null!");
            AppMethodBeat.o(96451);
            return;
          }
          if (localg.dhf == null)
          {
            ac.e("AdLandingImageComp", "when set image the imageView is null!");
            AppMethodBeat.o(96451);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          ac.e("AdLandingImageComp", "%s" + bs.m(paramAnonymousString));
          AppMethodBeat.o(96451);
          return;
        }
        if (paramAnonymousString.getWidth() == 0)
        {
          ac.e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
          AppMethodBeat.o(96451);
          return;
        }
        localg.dhf.setImageBitmap(paramAnonymousString);
        localg.progressBar.setVisibility(8);
        AppMethodBeat.o(96451);
      }
      
      public final void dFC()
      {
        AppMethodBeat.i(96449);
        g.this.startLoading();
        AppMethodBeat.o(96449);
      }
      
      public final void dFD()
      {
        AppMethodBeat.i(96450);
        g.this.stopLoading();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g
 * JD-Core Version:    0.7.0.1
 */