package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class n
{
  private long Ndw;
  private int PXy;
  public aa QOV;
  boolean QOW;
  protected ViewGroup QOX;
  protected int QOY;
  protected int backgroundColor;
  public View contentView;
  public Context context;
  private long hTS;
  protected int pvg;
  protected int sJv;
  
  public n(Context paramContext, aa paramaa, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(96466);
    this.PXy = 0;
    this.Ndw = 0L;
    this.hTS = 0L;
    this.QOW = false;
    this.contentView = null;
    this.QOY = 0;
    this.context = paramContext;
    this.QOV = paramaa;
    this.QOX = paramViewGroup;
    paramaa = ar.jR(paramContext);
    this.sJv = paramaa[0];
    this.pvg = paramaa[1];
    if (aw.bx(paramContext))
    {
      int i = aw.bw(paramContext);
      this.pvg -= i;
      this.QOY = i;
    }
    AppMethodBeat.o(96466);
  }
  
  public void Gs() {}
  
  public boolean M(JSONArray paramJSONArray)
  {
    return false;
  }
  
  public boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96475);
    if (this.PXy == 0)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    if (this.QOV.QKP)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    try
    {
      paramJSONObject.put("cid", this.QOV.QKG);
      paramJSONObject.put("exposureCount", this.PXy);
      paramJSONObject.put("stayTime", hjj());
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
  
  public void bb(Map<String, Object> paramMap) {}
  
  public void c(aa paramaa)
  {
    AppMethodBeat.i(96467);
    aa localaa = this.QOV;
    if (localaa == paramaa)
    {
      AppMethodBeat.o(96467);
      return;
    }
    if ((localaa != null) && (localaa.equals(paramaa)))
    {
      AppMethodBeat.o(96467);
      return;
    }
    this.QOV = paramaa;
    had();
    haC();
    AppMethodBeat.o(96467);
  }
  
  public View getContentView()
  {
    return this.contentView;
  }
  
  public final int getGravity()
  {
    int i = 0;
    switch (this.QOV.QKM)
    {
    }
    for (;;)
    {
      switch (this.QOV.QKN)
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
        this.contentView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(i, this.QOX, false);
      }
      while (this.contentView == null)
      {
        localObject = new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
        AppMethodBeat.o(96468);
        throw ((Throwable)localObject);
        this.contentView = ham();
        if ((this.contentView != null) && (this.contentView.getLayoutParams() == null))
        {
          this.QOX.addView(this.contentView);
          localObject = this.contentView.getLayoutParams();
          this.QOX.removeView(this.contentView);
          this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    Gs();
    had();
    hal();
    haC();
    Object localObject = this.contentView;
    AppMethodBeat.o(96468);
    return localObject;
  }
  
  public void haC()
  {
    AppMethodBeat.i(96476);
    Object localObject1;
    if (this.contentView == null)
    {
      localObject1 = new IllegalStateException("set field contentView first");
      AppMethodBeat.o(96476);
      throw ((Throwable)localObject1);
    }
    if (this.QOV != null)
    {
      localObject1 = this.contentView.getLayoutParams();
      if (localObject1 != null)
      {
        if (this.QOV.QKI != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).width = ((int)this.QOV.QKI);
        }
        if (this.QOV.QKJ != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).height = ((int)this.QOV.QKJ);
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
      Log.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.QOX);
    }
    AppMethodBeat.o(96476);
  }
  
  protected void had()
  {
    AppMethodBeat.i(96469);
    Log.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
    AppMethodBeat.o(96469);
  }
  
  protected void hal() {}
  
  protected View ham()
  {
    return null;
  }
  
  public void hao()
  {
    AppMethodBeat.i(96470);
    if (this.QOW)
    {
      AppMethodBeat.o(96470);
      return;
    }
    this.QOW = true;
    this.Ndw = System.currentTimeMillis();
    this.PXy += 1;
    AppMethodBeat.o(96470);
  }
  
  public void hap()
  {
    AppMethodBeat.i(96471);
    if (!this.QOW)
    {
      AppMethodBeat.o(96471);
      return;
    }
    this.QOW = false;
    if (this.Ndw > 0L) {
      this.hTS += System.currentTimeMillis() - this.Ndw;
    }
    this.Ndw = 0L;
    AppMethodBeat.o(96471);
  }
  
  public void haq() {}
  
  public void has()
  {
    AppMethodBeat.i(96474);
    hap();
    AppMethodBeat.o(96474);
  }
  
  public final int hjh()
  {
    AppMethodBeat.i(96472);
    int i = this.pvg;
    int j = this.QOY + i;
    View localView = getView();
    int[] arrayOfInt = new int[2];
    localView.getLocationOnScreen(arrayOfInt);
    int m = arrayOfInt[1];
    int k = localView.getHeight() + m;
    Log.d("MicroMsg.Sns.AdLandingPageBaseComponent", "comp %s , top %d,bottom %d ", new Object[] { this, Integer.valueOf(m), Integer.valueOf(k) });
    if ((m >= 0) && (k <= j)) {
      i = localView.getHeight();
    }
    for (;;)
    {
      AppMethodBeat.o(96472);
      return i;
      if ((m < 0) && (k > 0))
      {
        i = k;
        if (k <= j) {}
      }
      else if ((m < 0) && (k > j))
      {
        i = j;
      }
      else if ((m < j) && (k > j))
      {
        i = j - m;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public boolean hji()
  {
    AppMethodBeat.i(96473);
    if (hjh() >= Math.min(getView().getHeight() >>> 1, this.pvg >>> 1))
    {
      AppMethodBeat.o(96473);
      return true;
    }
    AppMethodBeat.o(96473);
    return false;
  }
  
  public long hjj()
  {
    return this.hTS;
  }
  
  public final int hjk()
  {
    return this.PXy;
  }
  
  public void hjl() {}
  
  protected final <T> T hjm()
  {
    try
    {
      aa localaa = this.QOV;
      return localaa;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final ai hjn()
  {
    AppMethodBeat.i(96477);
    if ((this.context instanceof SnsAdNativeLandingPagesUI))
    {
      localai = ((SnsAdNativeLandingPagesUI)this.context).hjn();
      AppMethodBeat.o(96477);
      return localai;
    }
    if ((this.context instanceof VideoFullScreenActivity))
    {
      localai = VideoFullScreenActivity.hiS();
      AppMethodBeat.o(96477);
      return localai;
    }
    ai localai = new ai();
    AppMethodBeat.o(96477);
    return localai;
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n
 * JD-Core Version:    0.7.0.1
 */