package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.al;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l
{
  protected int backgroundColor;
  public View contentView;
  public Context context;
  long dBD;
  protected int ltA;
  protected int ltB;
  protected x zDK;
  int zDL;
  private long zDM;
  boolean zDN;
  protected ViewGroup zDO;
  
  public l(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(96466);
    this.zDL = 0;
    this.zDM = 0L;
    this.dBD = 0L;
    this.zDN = false;
    this.contentView = null;
    this.context = paramContext;
    this.zDK = paramx;
    this.zDO = paramViewGroup;
    paramx = am.gk(paramContext);
    this.ltA = paramx[0];
    this.ltB = paramx[1];
    if (al.aG(paramContext)) {
      this.ltB -= al.aF(paramContext);
    }
    AppMethodBeat.o(96466);
  }
  
  public boolean D(JSONArray paramJSONArray)
  {
    return false;
  }
  
  public void a(x paramx)
  {
    AppMethodBeat.i(96467);
    x localx = this.zDK;
    if (localx == paramx)
    {
      AppMethodBeat.o(96467);
      return;
    }
    if ((localx != null) && (localx.equals(paramx)))
    {
      AppMethodBeat.o(96467);
      return;
    }
    this.zDK = paramx;
    dRl();
    dWW();
    AppMethodBeat.o(96467);
  }
  
  public void aM(Map<String, Object> paramMap) {}
  
  public boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96475);
    if (this.zDL == 0)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    if (this.zDK.zAp)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    try
    {
      paramJSONObject.put("cid", this.zDK.zAg);
      paramJSONObject.put("exposureCount", this.zDL);
      paramJSONObject.put("stayTime", this.dBD);
      AppMethodBeat.o(96475);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ad.printErrStackTrace("MicroMsg.Sns.AdLandingPageBaseComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96475);
    }
    return false;
  }
  
  public void dRk() {}
  
  protected void dRl()
  {
    AppMethodBeat.i(96469);
    ad.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
    AppMethodBeat.o(96469);
  }
  
  public void dRm()
  {
    AppMethodBeat.i(96470);
    if (this.zDN)
    {
      AppMethodBeat.o(96470);
      return;
    }
    this.zDN = true;
    this.zDM = System.currentTimeMillis();
    this.zDL += 1;
    AppMethodBeat.o(96470);
  }
  
  public void dRn()
  {
    AppMethodBeat.i(96471);
    if (!this.zDN)
    {
      AppMethodBeat.o(96471);
      return;
    }
    this.zDN = false;
    if (this.zDM > 0L) {
      this.dBD += System.currentTimeMillis() - this.zDM;
    }
    this.zDM = 0L;
    AppMethodBeat.o(96471);
  }
  
  public void dRo()
  {
    AppMethodBeat.i(96474);
    dRn();
    AppMethodBeat.o(96474);
  }
  
  protected View dWC()
  {
    return null;
  }
  
  protected void dWF() {}
  
  public final x dWS()
  {
    return this.zDK;
  }
  
  public final int dWT()
  {
    AppMethodBeat.i(96472);
    View localView = getView();
    int[] arrayOfInt = new int[2];
    localView.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    int j = localView.getHeight() + k;
    ad.d("MicroMsg.Sns.AdLandingPageBaseComponent", "comp %s , top %d,bottom %d ", new Object[] { this, Integer.valueOf(k), Integer.valueOf(j) });
    int i;
    if ((k >= 0) && (j <= this.ltB)) {
      i = localView.getHeight();
    }
    for (;;)
    {
      AppMethodBeat.o(96472);
      return i;
      if ((k < 0) && (j > 0))
      {
        i = j;
        if (j <= this.ltB) {}
      }
      else if ((k < 0) && (j > this.ltB))
      {
        i = this.ltB;
      }
      else if ((k < this.ltB) && (j > this.ltB))
      {
        i = this.ltB - k;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public boolean dWU()
  {
    AppMethodBeat.i(96473);
    if (dWT() >= Math.min(getView().getHeight() >>> 1, this.ltB >>> 1))
    {
      AppMethodBeat.o(96473);
      return true;
    }
    AppMethodBeat.o(96473);
    return false;
  }
  
  public final String dWV()
  {
    return this.zDK.zAg;
  }
  
  public final void dWW()
  {
    AppMethodBeat.i(96476);
    Object localObject1;
    if (this.contentView == null)
    {
      localObject1 = new IllegalStateException("set field contentView first");
      AppMethodBeat.o(96476);
      throw ((Throwable)localObject1);
    }
    if (this.zDK != null)
    {
      localObject1 = this.contentView.getLayoutParams();
      if (localObject1 != null)
      {
        if (this.zDK.zAi != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).width = ((int)this.zDK.zAi);
        }
        if (this.zDK.zAj != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).height = ((int)this.zDK.zAj);
        }
        Object localObject2;
        int i;
        if ((localObject1 instanceof LinearLayout.LayoutParams))
        {
          localObject2 = (LinearLayout.LayoutParams)localObject1;
          i = getGravity();
          if (i != 0) {
            ((LinearLayout.LayoutParams)localObject2).gravity = i;
          }
        }
        for (;;)
        {
          this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          AppMethodBeat.o(96476);
          return;
          if ((localObject1 instanceof FrameLayout.LayoutParams))
          {
            localObject2 = (FrameLayout.LayoutParams)localObject1;
            i = getGravity();
            if (i != 0) {
              ((FrameLayout.LayoutParams)localObject2).gravity = i;
            }
          }
        }
      }
      ad.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.zDO);
    }
    AppMethodBeat.o(96476);
  }
  
  public void dWX() {}
  
  protected final <T> T dWY()
  {
    try
    {
      x localx = this.zDK;
      return localx;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final ae dWZ()
  {
    AppMethodBeat.i(96477);
    if ((this.context instanceof SnsAdNativeLandingPagesUI))
    {
      localae = ((SnsAdNativeLandingPagesUI)this.context).dWZ();
      AppMethodBeat.o(96477);
      return localae;
    }
    if ((this.context instanceof VideoFullScreenActivity))
    {
      localae = VideoFullScreenActivity.dWJ();
      AppMethodBeat.o(96477);
      return localae;
    }
    ae localae = new ae();
    AppMethodBeat.o(96477);
    return localae;
  }
  
  public void dWm() {}
  
  public final int getGravity()
  {
    int i = 0;
    switch (this.zDK.zAm)
    {
    }
    for (;;)
    {
      switch (this.zDK.zAn)
      {
      default: 
        return i;
        i = 80;
        continue;
        i = 16;
        continue;
        i = 48;
      }
    }
    return i | 0x1;
    return i | 0x3;
    return i | 0x5;
  }
  
  protected int getLayout()
  {
    return 2147483647;
  }
  
  public final View getView()
  {
    AppMethodBeat.i(96468);
    if (this.contentView != null)
    {
      localObject = this.contentView;
      AppMethodBeat.o(96468);
      return localObject;
    }
    if (this.contentView == null)
    {
      int i = getLayout();
      if (i != 2147483647) {
        this.contentView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(i, this.zDO, false);
      }
      while (this.contentView == null)
      {
        localObject = new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
        AppMethodBeat.o(96468);
        throw ((Throwable)localObject);
        this.contentView = dWC();
        if ((this.contentView != null) && (this.contentView.getLayoutParams() == null))
        {
          this.zDO.addView(this.contentView);
          localObject = this.contentView.getLayoutParams();
          this.zDO.removeView(this.contentView);
          this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    dRk();
    dRl();
    dWF();
    dWW();
    Object localObject = this.contentView;
    AppMethodBeat.o(96468);
    return localObject;
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l
 * JD-Core Version:    0.7.0.1
 */