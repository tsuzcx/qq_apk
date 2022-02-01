package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.ui.ai;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k
{
  protected int backgroundColor;
  protected View contentView;
  protected Context context;
  long dsf;
  protected int kvn;
  protected int kvo;
  protected x xab;
  int xac;
  private long xad;
  boolean xae;
  protected ViewGroup xaf;
  
  public k(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(96466);
    this.xac = 0;
    this.xad = 0L;
    this.dsf = 0L;
    this.xae = false;
    this.contentView = null;
    this.context = paramContext;
    this.xab = paramx;
    this.xaf = paramViewGroup;
    paramx = al.fU(paramContext);
    this.kvn = paramx[0];
    this.kvo = paramx[1];
    if (ai.aF(paramContext)) {
      this.kvo -= ai.aE(paramContext);
    }
    AppMethodBeat.o(96466);
  }
  
  public boolean C(JSONArray paramJSONArray)
  {
    return false;
  }
  
  public void a(x paramx)
  {
    AppMethodBeat.i(96467);
    x localx = this.xab;
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
    this.xab = paramx;
    dvN();
    dwf();
    AppMethodBeat.o(96467);
  }
  
  public void aF(Map<String, Object> paramMap) {}
  
  public boolean aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96475);
    if (this.xac == 0)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    if (this.xab.wWN)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    try
    {
      paramJSONObject.put("cid", this.xab.wWE);
      paramJSONObject.put("exposureCount", this.xac);
      paramJSONObject.put("stayTime", this.dsf);
      AppMethodBeat.o(96475);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.Sns.AdLandingPageBaseComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96475);
    }
    return false;
  }
  
  public void dvA()
  {
    AppMethodBeat.i(96471);
    if (!this.xae)
    {
      AppMethodBeat.o(96471);
      return;
    }
    this.xae = false;
    if (this.xad > 0L) {
      this.dsf += System.currentTimeMillis() - this.xad;
    }
    this.xad = 0L;
    AppMethodBeat.o(96471);
  }
  
  public void dvB() {}
  
  protected void dvN()
  {
    AppMethodBeat.i(96469);
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
    AppMethodBeat.o(96469);
  }
  
  protected View dvQ()
  {
    return null;
  }
  
  protected void dvT() {}
  
  public void dvx() {}
  
  public void dvy()
  {
    AppMethodBeat.i(96474);
    dvA();
    AppMethodBeat.o(96474);
  }
  
  public void dvz()
  {
    AppMethodBeat.i(96470);
    if (this.xae)
    {
      AppMethodBeat.o(96470);
      return;
    }
    this.xae = true;
    this.xad = System.currentTimeMillis();
    this.xac += 1;
    AppMethodBeat.o(96470);
  }
  
  public final x dwb()
  {
    return this.xab;
  }
  
  public final int dwc()
  {
    AppMethodBeat.i(96472);
    View localView = getView();
    int[] arrayOfInt = new int[2];
    localView.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    int j = localView.getHeight() + k;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingPageBaseComponent", "comp %s , top %d,bottom %d ", new Object[] { this, Integer.valueOf(k), Integer.valueOf(j) });
    int i;
    if ((k >= 0) && (j <= this.kvo)) {
      i = localView.getHeight();
    }
    for (;;)
    {
      AppMethodBeat.o(96472);
      return i;
      if ((k < 0) && (j > 0))
      {
        i = j;
        if (j <= this.kvo) {}
      }
      else if ((k < 0) && (j > this.kvo))
      {
        i = this.kvo;
      }
      else if ((k < this.kvo) && (j > this.kvo))
      {
        i = this.kvo - k;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public boolean dwd()
  {
    AppMethodBeat.i(96473);
    if (dwc() >= Math.min(getView().getHeight() >>> 1, this.kvo >>> 1))
    {
      AppMethodBeat.o(96473);
      return true;
    }
    AppMethodBeat.o(96473);
    return false;
  }
  
  public final String dwe()
  {
    return this.xab.wWE;
  }
  
  public final void dwf()
  {
    AppMethodBeat.i(96476);
    Object localObject1;
    if (this.contentView == null)
    {
      localObject1 = new IllegalStateException("set field contentView first");
      AppMethodBeat.o(96476);
      throw ((Throwable)localObject1);
    }
    if (this.xab != null)
    {
      localObject1 = this.contentView.getLayoutParams();
      if (localObject1 != null)
      {
        if (this.xab.wWG != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).width = ((int)this.xab.wWG);
        }
        if (this.xab.wWH != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).height = ((int)this.xab.wWH);
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.xaf);
    }
    AppMethodBeat.o(96476);
  }
  
  public void dwg() {}
  
  protected final <T> T dwh()
  {
    try
    {
      x localx = this.xab;
      return localx;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad dwi()
  {
    AppMethodBeat.i(96477);
    if ((this.context instanceof SnsAdNativeLandingPagesUI))
    {
      localad = ((SnsAdNativeLandingPagesUI)this.context).dwi();
      AppMethodBeat.o(96477);
      return localad;
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad localad = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad();
    AppMethodBeat.o(96477);
    return localad;
  }
  
  public final View getContentView()
  {
    return this.contentView;
  }
  
  public final int getGravity()
  {
    int i = 0;
    switch (this.xab.wWK)
    {
    }
    for (;;)
    {
      switch (this.xab.wWL)
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
        this.contentView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(i, this.xaf, false);
      }
      while (this.contentView == null)
      {
        localObject = new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
        AppMethodBeat.o(96468);
        throw ((Throwable)localObject);
        this.contentView = dvQ();
        if ((this.contentView != null) && (this.contentView.getLayoutParams() == null))
        {
          this.xaf.addView(this.contentView);
          localObject = this.contentView.getLayoutParams();
          this.xaf.removeView(this.contentView);
          this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    dvx();
    dvN();
    dvT();
    dwf();
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
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k
 * JD-Core Version:    0.7.0.1
 */