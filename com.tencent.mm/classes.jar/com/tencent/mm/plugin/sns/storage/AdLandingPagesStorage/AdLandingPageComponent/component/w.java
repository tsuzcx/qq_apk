package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import org.json.JSONException;
import org.json.JSONObject;

public final class w
  extends h
{
  private ImageView cuM;
  ProgressBar progressBar;
  boolean rsv;
  boolean ruX = true;
  
  public w(Context paramContext, o paramo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramo, paramViewGroup);
  }
  
  public final boolean W(Bitmap paramBitmap)
  {
    AppMethodBeat.i(37270);
    if (paramBitmap == null)
    {
      ab.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
      AppMethodBeat.o(37270);
      return false;
    }
    if (this.cuM == null)
    {
      ab.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
      AppMethodBeat.o(37270);
      return false;
    }
    if (paramBitmap.getWidth() == 0)
    {
      ab.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
      AppMethodBeat.o(37270);
      return false;
    }
    this.cuM.setImageBitmap(paramBitmap);
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(37270);
    return true;
  }
  
  public final boolean aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(37271);
    if (!super.aq(paramJSONObject))
    {
      AppMethodBeat.o(37271);
      return false;
    }
    try
    {
      if (!this.ruX)
      {
        String str = ag.cE(((o)this.rve).rsw);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("urlMd5", str);
        localJSONObject.put("needDownload", 1);
        paramJSONObject.put("imgUrlInfo", localJSONObject);
      }
      AppMethodBeat.o(37271);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ab.printErrStackTrace("AdLandingPagePureImageComponet", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(37271);
    }
    return false;
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(37266);
    this.cuM = ((ImageView)this.contentView.findViewById(2131827855));
    this.progressBar = ((ProgressBar)this.contentView.findViewById(2131821246));
    AppMethodBeat.o(37266);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37268);
    if ((this.contentView == null) || (this.cuM == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(37268);
      return;
    }
    if ((o)this.rve == null)
    {
      AppMethodBeat.o(37268);
      return;
    }
    String str = ((o)this.rve).rsw;
    Object localObject = ((o)this.rve).rrh;
    float f2 = ((o)this.rve).height;
    float f1 = ((o)this.rve).width;
    this.rsv = ((o)this.rve).rsv;
    int i;
    if ((f2 != 0.0F) && (f1 != 0.0F) && (!this.rsv))
    {
      i = this.iiW - (int)((o)this.rve).paddingLeft - (int)((o)this.rve).paddingRight;
      if (f1 >= i) {}
    }
    for (;;)
    {
      f2 = f1 * ((o)this.rve).height / ((o)this.rve).width;
      this.cuM.setLayoutParams(new RelativeLayout.LayoutParams((int)f1, (int)f2));
      label205:
      if ((localObject != null) && (((String)localObject).length() > 0)) {}
      try
      {
        this.cuM.setBackgroundColor(Color.parseColor((String)localObject));
        label230:
        if ((str == null) || (str.length() <= 0))
        {
          ab.i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
          AppMethodBeat.o(37268);
          return;
          f1 = i;
          continue;
          if ((this.rsv) && (f2 != 0.0F) && (f1 != 0.0F))
          {
            this.cuM.setLayoutParams(new RelativeLayout.LayoutParams(this.iiW, this.iiX));
            break label205;
          }
          this.cuM.setLayoutParams(new RelativeLayout.LayoutParams(this.iiW, this.iiX));
          break label205;
        }
        localObject = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.gB("adId", str);
        if ((localObject != null) && (W((Bitmap)localObject)))
        {
          ab.i("AdLandingPagePureImageComponet", "loaded cached image with  ".concat(String.valueOf(str)));
          this.ruX = true;
          AppMethodBeat.o(37268);
          return;
        }
        this.ruX = false;
        startLoading();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str, ((o)this.rve).rsJ, new w.1(this));
        AppMethodBeat.o(37268);
        return;
      }
      catch (Exception localException)
      {
        break label230;
      }
    }
  }
  
  protected final void cqQ()
  {
    AppMethodBeat.i(37267);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((o)this.rve).paddingLeft, (int)((o)this.rve).paddingTop, (int)((o)this.rve).paddingRight, (int)((o)this.rve).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(37267);
  }
  
  protected final int getLayout()
  {
    return 2130970787;
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(37269);
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(37269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w
 * JD-Core Version:    0.7.0.1
 */