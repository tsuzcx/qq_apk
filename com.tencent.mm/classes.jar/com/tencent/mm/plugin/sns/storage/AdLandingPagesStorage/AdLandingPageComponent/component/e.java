package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends h
{
  ImageView cuM;
  ProgressBar progressBar;
  boolean ruX = true;
  
  public e(Context paramContext, ViewGroup paramViewGroup)
  {
    this(paramContext, paramViewGroup, (byte)0);
  }
  
  private e(Context paramContext, ViewGroup paramViewGroup, byte paramByte)
  {
    super(paramContext, null, paramViewGroup);
  }
  
  public final boolean aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(37056);
    if (!super.aq(paramJSONObject))
    {
      AppMethodBeat.o(37056);
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
      AppMethodBeat.o(37056);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ab.printErrStackTrace("AdLandingImageComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(37056);
    }
    return false;
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(37052);
    View localView = this.contentView;
    this.cuM = ((ImageView)localView.findViewById(2131827855));
    this.progressBar = ((ProgressBar)localView.findViewById(2131821246));
    AppMethodBeat.o(37052);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37053);
    if ((this.contentView == null) || (this.cuM == null) || (this.progressBar == null))
    {
      AppMethodBeat.o(37053);
      return;
    }
    if ((o)this.rve == null)
    {
      AppMethodBeat.o(37053);
      return;
    }
    float f1 = ((o)this.rve).paddingTop;
    float f2 = ((o)this.rve).paddingBottom;
    float f3 = ((o)this.rve).paddingLeft;
    float f4 = ((o)this.rve).paddingRight;
    String str = ((o)this.rve).rsw;
    float f5 = ((o)this.rve).height;
    float f6 = ((o)this.rve).width;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.cuM.getLayoutParams();
    localLayoutParams.width = ((int)f6);
    localLayoutParams.height = ((int)f5);
    this.cuM.setLayoutParams(localLayoutParams);
    this.ruX = false;
    startLoading();
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str, ((o)this.rve).rsJ, new e.1(this));
    this.contentView.setPadding((int)f3, (int)f1, (int)f4, (int)f2);
    AppMethodBeat.o(37053);
  }
  
  protected final int getLayout()
  {
    return 2130970782;
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(37054);
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(37054);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(37055);
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(37055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e
 * JD-Core Version:    0.7.0.1
 */