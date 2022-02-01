package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m
{
  int Dzo;
  protected z EcX;
  private long EcY;
  boolean EcZ;
  protected ViewGroup Eda;
  protected int backgroundColor;
  public View contentView;
  public Context context;
  private long dUy;
  protected int mEX;
  protected int mEY;
  
  public m(Context paramContext, z paramz, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(96466);
    this.Dzo = 0;
    this.EcY = 0L;
    this.dUy = 0L;
    this.EcZ = false;
    this.contentView = null;
    this.context = paramContext;
    this.EcX = paramz;
    this.Eda = paramViewGroup;
    paramz = ap.ha(paramContext);
    this.mEX = paramz[0];
    this.mEY = paramz[1];
    if (ao.aQ(paramContext)) {
      this.mEY -= ao.aP(paramContext);
    }
    AppMethodBeat.o(96466);
  }
  
  public boolean G(JSONArray paramJSONArray)
  {
    return false;
  }
  
  public void aQ(Map<String, Object> paramMap) {}
  
  public void b(z paramz)
  {
    AppMethodBeat.i(96467);
    z localz = this.EcX;
    if (localz == paramz)
    {
      AppMethodBeat.o(96467);
      return;
    }
    if ((localz != null) && (localz.equals(paramz)))
    {
      AppMethodBeat.o(96467);
      return;
    }
    this.EcX = paramz;
    eWT();
    fdp();
    AppMethodBeat.o(96467);
  }
  
  public boolean bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96475);
    if (this.Dzo == 0)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    if (this.EcX.DZr)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    try
    {
      paramJSONObject.put("cid", this.EcX.DZi);
      paramJSONObject.put("exposureCount", this.Dzo);
      paramJSONObject.put("stayTime", fdo());
      AppMethodBeat.o(96475);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.Sns.AdLandingPageBaseComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96475);
    }
    return false;
  }
  
  protected void eWT()
  {
    AppMethodBeat.i(96469);
    Log.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
    AppMethodBeat.o(96469);
  }
  
  protected void eWX() {}
  
  protected View eWY()
  {
    return null;
  }
  
  public void eWZ()
  {
    AppMethodBeat.i(96470);
    if (this.EcZ)
    {
      AppMethodBeat.o(96470);
      return;
    }
    this.EcZ = true;
    this.EcY = System.currentTimeMillis();
    this.Dzo += 1;
    AppMethodBeat.o(96470);
  }
  
  public void eXa()
  {
    AppMethodBeat.i(96471);
    if (!this.EcZ)
    {
      AppMethodBeat.o(96471);
      return;
    }
    this.EcZ = false;
    if (this.EcY > 0L) {
      this.dUy += System.currentTimeMillis() - this.EcY;
    }
    this.EcY = 0L;
    AppMethodBeat.o(96471);
  }
  
  public void eXb() {}
  
  public void eXd()
  {
    AppMethodBeat.i(96474);
    eXa();
    AppMethodBeat.o(96474);
  }
  
  public void eXe() {}
  
  public final z fdk()
  {
    return this.EcX;
  }
  
  public final int fdl()
  {
    AppMethodBeat.i(96472);
    View localView = getView();
    int[] arrayOfInt = new int[2];
    localView.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    int j = localView.getHeight() + k;
    Log.d("MicroMsg.Sns.AdLandingPageBaseComponent", "comp %s , top %d,bottom %d ", new Object[] { this, Integer.valueOf(k), Integer.valueOf(j) });
    int i;
    if ((k >= 0) && (j <= this.mEY)) {
      i = localView.getHeight();
    }
    for (;;)
    {
      AppMethodBeat.o(96472);
      return i;
      if ((k < 0) && (j > 0))
      {
        i = j;
        if (j <= this.mEY) {}
      }
      else if ((k < 0) && (j > this.mEY))
      {
        i = this.mEY;
      }
      else if ((k < this.mEY) && (j > this.mEY))
      {
        i = this.mEY - k;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public boolean fdm()
  {
    AppMethodBeat.i(96473);
    if (fdl() >= Math.min(getView().getHeight() >>> 1, this.mEY >>> 1))
    {
      AppMethodBeat.o(96473);
      return true;
    }
    AppMethodBeat.o(96473);
    return false;
  }
  
  public final String fdn()
  {
    return this.EcX.DZi;
  }
  
  public long fdo()
  {
    return this.dUy;
  }
  
  public final void fdp()
  {
    AppMethodBeat.i(96476);
    Object localObject1;
    if (this.contentView == null)
    {
      localObject1 = new IllegalStateException("set field contentView first");
      AppMethodBeat.o(96476);
      throw ((Throwable)localObject1);
    }
    if (this.EcX != null)
    {
      localObject1 = this.contentView.getLayoutParams();
      if (localObject1 != null)
      {
        if (this.EcX.DZk != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).width = ((int)this.EcX.DZk);
        }
        if (this.EcX.DZl != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).height = ((int)this.EcX.DZl);
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
      Log.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.Eda);
    }
    AppMethodBeat.o(96476);
  }
  
  public void fdq() {}
  
  protected final <T> T fdr()
  {
    try
    {
      z localz = this.EcX;
      return localz;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final ah fds()
  {
    AppMethodBeat.i(96477);
    if ((this.context instanceof SnsAdNativeLandingPagesUI))
    {
      localah = ((SnsAdNativeLandingPagesUI)this.context).fds();
      AppMethodBeat.o(96477);
      return localah;
    }
    if ((this.context instanceof VideoFullScreenActivity))
    {
      localah = VideoFullScreenActivity.fcZ();
      AppMethodBeat.o(96477);
      return localah;
    }
    ah localah = new ah();
    AppMethodBeat.o(96477);
    return localah;
  }
  
  public final int getGravity()
  {
    int i = 0;
    switch (this.EcX.DZo)
    {
    }
    for (;;)
    {
      switch (this.EcX.DZp)
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
        this.contentView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(i, this.Eda, false);
      }
      while (this.contentView == null)
      {
        localObject = new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
        AppMethodBeat.o(96468);
        throw ((Throwable)localObject);
        this.contentView = eWY();
        if ((this.contentView != null) && (this.contentView.getLayoutParams() == null))
        {
          this.Eda.addView(this.contentView);
          localObject = this.contentView.getLayoutParams();
          this.Eda.removeView(this.contentView);
          this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    eXe();
    eWT();
    eWX();
    fdp();
    Object localObject = this.contentView;
    AppMethodBeat.o(96468);
    return localObject;
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
 * JD-Core Version:    0.7.0.1
 */