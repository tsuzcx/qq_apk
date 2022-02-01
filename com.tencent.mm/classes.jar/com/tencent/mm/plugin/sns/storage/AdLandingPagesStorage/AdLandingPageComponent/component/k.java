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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k
{
  protected int backgroundColor;
  protected View contentView;
  protected Context context;
  long dpQ;
  protected int kWB;
  protected int kWC;
  protected x ymQ;
  int ymR;
  private long ymS;
  boolean ymT;
  protected ViewGroup ymU;
  
  public k(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(96466);
    this.ymR = 0;
    this.ymS = 0L;
    this.dpQ = 0L;
    this.ymT = false;
    this.contentView = null;
    this.context = paramContext;
    this.ymQ = paramx;
    this.ymU = paramViewGroup;
    paramx = al.gg(paramContext);
    this.kWB = paramx[0];
    this.kWC = paramx[1];
    if (aj.aG(paramContext)) {
      this.kWC -= aj.aF(paramContext);
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
    x localx = this.ymQ;
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
    this.ymQ = paramx;
    dKm();
    dKE();
    AppMethodBeat.o(96467);
  }
  
  public boolean aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96475);
    if (this.ymR == 0)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    if (this.ymQ.yjB)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    try
    {
      paramJSONObject.put("cid", this.ymQ.yjs);
      paramJSONObject.put("exposureCount", this.ymR);
      paramJSONObject.put("stayTime", this.dpQ);
      AppMethodBeat.o(96475);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ac.printErrStackTrace("MicroMsg.Sns.AdLandingPageBaseComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96475);
    }
    return false;
  }
  
  public void aJ(Map<String, Object> paramMap) {}
  
  public void dJW() {}
  
  public void dJX()
  {
    AppMethodBeat.i(96474);
    dJZ();
    AppMethodBeat.o(96474);
  }
  
  public void dJY()
  {
    AppMethodBeat.i(96470);
    if (this.ymT)
    {
      AppMethodBeat.o(96470);
      return;
    }
    this.ymT = true;
    this.ymS = System.currentTimeMillis();
    this.ymR += 1;
    AppMethodBeat.o(96470);
  }
  
  public void dJZ()
  {
    AppMethodBeat.i(96471);
    if (!this.ymT)
    {
      AppMethodBeat.o(96471);
      return;
    }
    this.ymT = false;
    if (this.ymS > 0L) {
      this.dpQ += System.currentTimeMillis() - this.ymS;
    }
    this.ymS = 0L;
    AppMethodBeat.o(96471);
  }
  
  public final x dKA()
  {
    return this.ymQ;
  }
  
  public final int dKB()
  {
    AppMethodBeat.i(96472);
    View localView = getView();
    int[] arrayOfInt = new int[2];
    localView.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    int j = localView.getHeight() + k;
    ac.d("MicroMsg.Sns.AdLandingPageBaseComponent", "comp %s , top %d,bottom %d ", new Object[] { this, Integer.valueOf(k), Integer.valueOf(j) });
    int i;
    if ((k >= 0) && (j <= this.kWC)) {
      i = localView.getHeight();
    }
    for (;;)
    {
      AppMethodBeat.o(96472);
      return i;
      if ((k < 0) && (j > 0))
      {
        i = j;
        if (j <= this.kWC) {}
      }
      else if ((k < 0) && (j > this.kWC))
      {
        i = this.kWC;
      }
      else if ((k < this.kWC) && (j > this.kWC))
      {
        i = this.kWC - k;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public boolean dKC()
  {
    AppMethodBeat.i(96473);
    if (dKB() >= Math.min(getView().getHeight() >>> 1, this.kWC >>> 1))
    {
      AppMethodBeat.o(96473);
      return true;
    }
    AppMethodBeat.o(96473);
    return false;
  }
  
  public final String dKD()
  {
    return this.ymQ.yjs;
  }
  
  public final void dKE()
  {
    AppMethodBeat.i(96476);
    Object localObject1;
    if (this.contentView == null)
    {
      localObject1 = new IllegalStateException("set field contentView first");
      AppMethodBeat.o(96476);
      throw ((Throwable)localObject1);
    }
    if (this.ymQ != null)
    {
      localObject1 = this.contentView.getLayoutParams();
      if (localObject1 != null)
      {
        if (this.ymQ.yju != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).width = ((int)this.ymQ.yju);
        }
        if (this.ymQ.yjv != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).height = ((int)this.ymQ.yjv);
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
      ac.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.ymU);
    }
    AppMethodBeat.o(96476);
  }
  
  public void dKF() {}
  
  protected final <T> T dKG()
  {
    try
    {
      x localx = this.ymQ;
      return localx;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final ae dKH()
  {
    AppMethodBeat.i(96477);
    if ((this.context instanceof SnsAdNativeLandingPagesUI))
    {
      localae = ((SnsAdNativeLandingPagesUI)this.context).dKH();
      AppMethodBeat.o(96477);
      return localae;
    }
    ae localae = new ae();
    AppMethodBeat.o(96477);
    return localae;
  }
  
  public void dKa() {}
  
  protected void dKm()
  {
    AppMethodBeat.i(96469);
    ac.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
    AppMethodBeat.o(96469);
  }
  
  protected View dKp()
  {
    return null;
  }
  
  protected void dKs() {}
  
  public final View getContentView()
  {
    return this.contentView;
  }
  
  public final int getGravity()
  {
    int i = 0;
    switch (this.ymQ.yjy)
    {
    }
    for (;;)
    {
      switch (this.ymQ.yjz)
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
        this.contentView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(i, this.ymU, false);
      }
      while (this.contentView == null)
      {
        localObject = new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
        AppMethodBeat.o(96468);
        throw ((Throwable)localObject);
        this.contentView = dKp();
        if ((this.contentView != null) && (this.contentView.getLayoutParams() == null))
        {
          this.ymU.addView(this.contentView);
          localObject = this.contentView.getLayoutParams();
          this.ymU.removeView(this.contentView);
          this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    dJW();
    dKm();
    dKs();
    dKE();
    Object localObject = this.contentView;
    AppMethodBeat.o(96468);
    return localObject;
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k
 * JD-Core Version:    0.7.0.1
 */