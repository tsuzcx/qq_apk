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
import com.tencent.mm.ui.ar;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m
{
  private long Hgs;
  private int JGy;
  public aa KqB;
  boolean KqC;
  protected ViewGroup KqD;
  protected int backgroundColor;
  public View contentView;
  public Context context;
  private long fOa;
  public int pEj;
  public int pEk;
  
  public m(Context paramContext, aa paramaa, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(96466);
    this.JGy = 0;
    this.Hgs = 0L;
    this.fOa = 0L;
    this.KqC = false;
    this.contentView = null;
    this.context = paramContext;
    this.KqB = paramaa;
    this.KqD = paramViewGroup;
    paramaa = ao.ib(paramContext);
    this.pEj = paramaa[0];
    this.pEk = paramaa[1];
    if (ar.aN(paramContext)) {
      this.pEk -= ar.aM(paramContext);
    }
    AppMethodBeat.o(96466);
  }
  
  public boolean H(JSONArray paramJSONArray)
  {
    return false;
  }
  
  public void aK(Map<String, Object> paramMap) {}
  
  public boolean by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96475);
    if (this.JGy == 0)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    if (this.KqB.KmK)
    {
      AppMethodBeat.o(96475);
      return false;
    }
    try
    {
      paramJSONObject.put("cid", this.KqB.KmB);
      paramJSONObject.put("exposureCount", this.JGy);
      paramJSONObject.put("stayTime", fRk());
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
  
  public void c(aa paramaa)
  {
    AppMethodBeat.i(96467);
    aa localaa = this.KqB;
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
    this.KqB = paramaa;
    fKe();
    fRm();
    AppMethodBeat.o(96467);
  }
  
  protected void fKe()
  {
    AppMethodBeat.i(96469);
    Log.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
    AppMethodBeat.o(96469);
  }
  
  protected void fKi() {}
  
  protected View fKj()
  {
    return null;
  }
  
  public void fKk()
  {
    AppMethodBeat.i(96470);
    if (this.KqC)
    {
      AppMethodBeat.o(96470);
      return;
    }
    this.KqC = true;
    this.Hgs = System.currentTimeMillis();
    this.JGy += 1;
    AppMethodBeat.o(96470);
  }
  
  public void fKl()
  {
    AppMethodBeat.i(96471);
    if (!this.KqC)
    {
      AppMethodBeat.o(96471);
      return;
    }
    this.KqC = false;
    if (this.Hgs > 0L) {
      this.fOa += System.currentTimeMillis() - this.Hgs;
    }
    this.Hgs = 0L;
    AppMethodBeat.o(96471);
  }
  
  public void fKm() {}
  
  public void fKo()
  {
    AppMethodBeat.i(96474);
    fKl();
    AppMethodBeat.o(96474);
  }
  
  public void fKp() {}
  
  public final int fRi()
  {
    AppMethodBeat.i(96472);
    View localView = getView();
    int[] arrayOfInt = new int[2];
    localView.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    int j = localView.getHeight() + k;
    Log.d("MicroMsg.Sns.AdLandingPageBaseComponent", "comp %s , top %d,bottom %d ", new Object[] { this, Integer.valueOf(k), Integer.valueOf(j) });
    int i;
    if ((k >= 0) && (j <= this.pEk)) {
      i = localView.getHeight();
    }
    for (;;)
    {
      AppMethodBeat.o(96472);
      return i;
      if ((k < 0) && (j > 0))
      {
        i = j;
        if (j <= this.pEk) {}
      }
      else if ((k < 0) && (j > this.pEk))
      {
        i = this.pEk;
      }
      else if ((k < this.pEk) && (j > this.pEk))
      {
        i = this.pEk - k;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public boolean fRj()
  {
    AppMethodBeat.i(96473);
    if (fRi() >= Math.min(getView().getHeight() >>> 1, this.pEk >>> 1))
    {
      AppMethodBeat.o(96473);
      return true;
    }
    AppMethodBeat.o(96473);
    return false;
  }
  
  public long fRk()
  {
    return this.fOa;
  }
  
  public final int fRl()
  {
    return this.JGy;
  }
  
  public final void fRm()
  {
    AppMethodBeat.i(96476);
    Object localObject1;
    if (this.contentView == null)
    {
      localObject1 = new IllegalStateException("set field contentView first");
      AppMethodBeat.o(96476);
      throw ((Throwable)localObject1);
    }
    if (this.KqB != null)
    {
      localObject1 = this.contentView.getLayoutParams();
      if (localObject1 != null)
      {
        if (this.KqB.KmD != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).width = ((int)this.KqB.KmD);
        }
        if (this.KqB.KmE != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).height = ((int)this.KqB.KmE);
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
      Log.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.KqD);
    }
    AppMethodBeat.o(96476);
  }
  
  public void fRn() {}
  
  protected final <T> T fRo()
  {
    try
    {
      aa localaa = this.KqB;
      return localaa;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final ai fRp()
  {
    AppMethodBeat.i(96477);
    if ((this.context instanceof SnsAdNativeLandingPagesUI))
    {
      localai = ((SnsAdNativeLandingPagesUI)this.context).fRp();
      AppMethodBeat.o(96477);
      return localai;
    }
    if ((this.context instanceof VideoFullScreenActivity))
    {
      localai = VideoFullScreenActivity.fQU();
      AppMethodBeat.o(96477);
      return localai;
    }
    ai localai = new ai();
    AppMethodBeat.o(96477);
    return localai;
  }
  
  public View getContentView()
  {
    return this.contentView;
  }
  
  public final int getGravity()
  {
    int i = 0;
    switch (this.KqB.KmH)
    {
    }
    for (;;)
    {
      switch (this.KqB.KmI)
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
        this.contentView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(i, this.KqD, false);
      }
      while (this.contentView == null)
      {
        localObject = new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
        AppMethodBeat.o(96468);
        throw ((Throwable)localObject);
        this.contentView = fKj();
        if ((this.contentView != null) && (this.contentView.getLayoutParams() == null))
        {
          this.KqD.addView(this.contentView);
          localObject = this.contentView.getLayoutParams();
          this.KqD.removeView(this.contentView);
          this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    fKp();
    fKe();
    fKi();
    fRm();
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
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
 * JD-Core Version:    0.7.0.1
 */