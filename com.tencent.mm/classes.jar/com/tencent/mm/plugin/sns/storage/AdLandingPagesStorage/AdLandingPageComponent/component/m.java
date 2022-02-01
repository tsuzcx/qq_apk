package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m
{
  protected int backgroundColor;
  public View contentView;
  public Context context;
  long dCI;
  protected int lxZ;
  protected int lya;
  protected y zUP;
  int zUQ;
  private long zUR;
  boolean zUS;
  protected ViewGroup zUT;
  
  public m(Context paramContext, y paramy, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(96466);
    this.zUQ = 0;
    this.zUR = 0L;
    this.dCI = 0L;
    this.zUS = false;
    this.contentView = null;
    this.context = paramContext;
    this.zUP = paramy;
    this.zUT = paramViewGroup;
    paramy = an.gp(paramContext);
    this.lxZ = paramy[0];
    this.lya = paramy[1];
    if (al.aH(paramContext)) {
      this.lya -= al.aG(paramContext);
    }
    AppMethodBeat.o(96466);
  }
  
  public boolean E(JSONArray paramJSONArray)
  {
    return false;
  }
  
  public void a(y paramy)
  {
    AppMethodBeat.i(96467);
    y localy = this.zUP;
    if (localy == paramy)
    {
      AppMethodBeat.o(96467);
      return;
    }
    if ((localy != null) && (localy.equals(paramy)))
    {
      AppMethodBeat.o(96467);
      return;
    }
    this.zUP = paramy;
    dUJ();
    eaA();
    AppMethodBeat.o(96467);
  }
  
  public boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96475);
    if (this.zUQ == 0)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    if (this.zUP.zRp)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    try
    {
      paramJSONObject.put("cid", this.zUP.zRg);
      paramJSONObject.put("exposureCount", this.zUQ);
      paramJSONObject.put("stayTime", this.dCI);
      AppMethodBeat.o(96475);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ae.printErrStackTrace("MicroMsg.Sns.AdLandingPageBaseComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96475);
    }
    return false;
  }
  
  public void aS(Map<String, Object> paramMap) {}
  
  public void dUI() {}
  
  protected void dUJ()
  {
    AppMethodBeat.i(96469);
    ae.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
    AppMethodBeat.o(96469);
  }
  
  public void dUK()
  {
    AppMethodBeat.i(96470);
    if (this.zUS)
    {
      AppMethodBeat.o(96470);
      return;
    }
    this.zUS = true;
    this.zUR = System.currentTimeMillis();
    this.zUQ += 1;
    AppMethodBeat.o(96470);
  }
  
  public void dUL()
  {
    AppMethodBeat.i(96471);
    if (!this.zUS)
    {
      AppMethodBeat.o(96471);
      return;
    }
    this.zUS = false;
    if (this.zUR > 0L) {
      this.dCI += System.currentTimeMillis() - this.zUR;
    }
    this.zUR = 0L;
    AppMethodBeat.o(96471);
  }
  
  public void dUM()
  {
    AppMethodBeat.i(96474);
    dUL();
    AppMethodBeat.o(96474);
  }
  
  public void dZO() {}
  
  public final void eaA()
  {
    AppMethodBeat.i(96476);
    Object localObject1;
    if (this.contentView == null)
    {
      localObject1 = new IllegalStateException("set field contentView first");
      AppMethodBeat.o(96476);
      throw ((Throwable)localObject1);
    }
    if (this.zUP != null)
    {
      localObject1 = this.contentView.getLayoutParams();
      if (localObject1 != null)
      {
        if (this.zUP.zRi != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).width = ((int)this.zUP.zRi);
        }
        if (this.zUP.zRj != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).height = ((int)this.zUP.zRj);
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
      ae.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.zUT);
    }
    AppMethodBeat.o(96476);
  }
  
  public void eaB() {}
  
  protected final <T> T eaC()
  {
    try
    {
      y localy = this.zUP;
      return localy;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final af eaD()
  {
    AppMethodBeat.i(96477);
    if ((this.context instanceof SnsAdNativeLandingPagesUI))
    {
      localaf = ((SnsAdNativeLandingPagesUI)this.context).eaD();
      AppMethodBeat.o(96477);
      return localaf;
    }
    if ((this.context instanceof VideoFullScreenActivity))
    {
      localaf = VideoFullScreenActivity.eal();
      AppMethodBeat.o(96477);
      return localaf;
    }
    af localaf = new af();
    AppMethodBeat.o(96477);
    return localaf;
  }
  
  protected View eae()
  {
    return null;
  }
  
  protected void eah() {}
  
  public final y eaw()
  {
    return this.zUP;
  }
  
  public final int eax()
  {
    AppMethodBeat.i(96472);
    View localView = getView();
    int[] arrayOfInt = new int[2];
    localView.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    int j = localView.getHeight() + k;
    ae.d("MicroMsg.Sns.AdLandingPageBaseComponent", "comp %s , top %d,bottom %d ", new Object[] { this, Integer.valueOf(k), Integer.valueOf(j) });
    int i;
    if ((k >= 0) && (j <= this.lya)) {
      i = localView.getHeight();
    }
    for (;;)
    {
      AppMethodBeat.o(96472);
      return i;
      if ((k < 0) && (j > 0))
      {
        i = j;
        if (j <= this.lya) {}
      }
      else if ((k < 0) && (j > this.lya))
      {
        i = this.lya;
      }
      else if ((k < this.lya) && (j > this.lya))
      {
        i = this.lya - k;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public boolean eay()
  {
    AppMethodBeat.i(96473);
    if (eax() >= Math.min(getView().getHeight() >>> 1, this.lya >>> 1))
    {
      AppMethodBeat.o(96473);
      return true;
    }
    AppMethodBeat.o(96473);
    return false;
  }
  
  public final String eaz()
  {
    return this.zUP.zRg;
  }
  
  public final int getGravity()
  {
    int i = 0;
    switch (this.zUP.zRm)
    {
    }
    for (;;)
    {
      switch (this.zUP.zRn)
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
        this.contentView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(i, this.zUT, false);
      }
      while (this.contentView == null)
      {
        localObject = new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
        AppMethodBeat.o(96468);
        throw ((Throwable)localObject);
        this.contentView = eae();
        if ((this.contentView != null) && (this.contentView.getLayoutParams() == null))
        {
          this.zUT.addView(this.contentView);
          localObject = this.contentView.getLayoutParams();
          this.zUT.removeView(this.contentView);
          this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    dUI();
    dUJ();
    eah();
    eaA();
    Object localObject = this.contentView;
    AppMethodBeat.o(96468);
    return localObject;
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
 * JD-Core Version:    0.7.0.1
 */