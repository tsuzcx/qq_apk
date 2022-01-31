package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.af;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h
{
  protected int backgroundColor;
  protected View contentView;
  protected Context context;
  private long iHh;
  protected int iiW;
  protected int iiX;
  protected t rve;
  private int rvf;
  private long rvg;
  boolean rvh;
  protected ViewGroup rvi;
  
  public h(Context paramContext, t paramt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37066);
    this.rvf = 0;
    this.rvg = 0L;
    this.iHh = 0L;
    this.rvh = false;
    this.contentView = null;
    this.context = paramContext;
    this.rve = paramt;
    this.rvi = paramViewGroup;
    paramt = ae.eU(paramContext);
    this.iiW = paramt[0];
    this.iiX = paramt[1];
    if (af.hW(paramContext)) {
      this.iiX -= af.hV(paramContext);
    }
    AppMethodBeat.o(37066);
  }
  
  public boolean A(JSONArray paramJSONArray)
  {
    return false;
  }
  
  public void a(t paramt)
  {
    AppMethodBeat.i(37067);
    t localt = this.rve;
    if (localt == paramt)
    {
      AppMethodBeat.o(37067);
      return;
    }
    if ((localt != null) && (localt.equals(paramt)))
    {
      AppMethodBeat.o(37067);
      return;
    }
    this.rve = paramt;
    cqP();
    cqZ();
    AppMethodBeat.o(37067);
  }
  
  public void ae(Map<String, Object> paramMap) {}
  
  public boolean aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(37075);
    if (this.rvf == 0)
    {
      AppMethodBeat.o(37075);
      return false;
    }
    if (this.rve.rsR)
    {
      AppMethodBeat.o(37075);
      return false;
    }
    try
    {
      paramJSONObject.put("cid", this.rve.rsI);
      paramJSONObject.put("exposureCount", this.rvf);
      paramJSONObject.put("stayTime", this.iHh);
      AppMethodBeat.o(37075);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ab.printErrStackTrace("MicroMsg.Sns.AdLandingPageBaseComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(37075);
    }
    return false;
  }
  
  public void cqA()
  {
    AppMethodBeat.i(37070);
    if (this.rvh)
    {
      AppMethodBeat.o(37070);
      return;
    }
    this.rvh = true;
    this.rvg = System.currentTimeMillis();
    this.rvf += 1;
    AppMethodBeat.o(37070);
  }
  
  public void cqB()
  {
    AppMethodBeat.i(37071);
    if (!this.rvh)
    {
      AppMethodBeat.o(37071);
      return;
    }
    this.rvh = false;
    if (this.rvg > 0L) {
      this.iHh += System.currentTimeMillis() - this.rvg;
    }
    this.rvg = 0L;
    AppMethodBeat.o(37071);
  }
  
  public void cqC() {}
  
  public void cqK() {}
  
  protected void cqP()
  {
    AppMethodBeat.i(37069);
    ab.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
    AppMethodBeat.o(37069);
  }
  
  protected void cqQ() {}
  
  protected View cqR()
  {
    return null;
  }
  
  public final t cqV()
  {
    return this.rve;
  }
  
  public final int cqW()
  {
    AppMethodBeat.i(37072);
    View localView = getView();
    int[] arrayOfInt = new int[2];
    localView.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    int j = localView.getHeight() + k;
    ab.v("MicroMsg.Sns.AdLandingPageBaseComponent", "comp %s , top %d,bottom %d ", new Object[] { this, Integer.valueOf(k), Integer.valueOf(j) });
    int i;
    if ((k >= 0) && (j <= this.iiX)) {
      i = localView.getHeight();
    }
    for (;;)
    {
      AppMethodBeat.o(37072);
      return i;
      if ((k < 0) && (j > 0))
      {
        i = j;
        if (j <= this.iiX) {}
      }
      else if ((k < 0) && (j > this.iiX))
      {
        i = this.iiX;
      }
      else if ((k < this.iiX) && (j > this.iiX))
      {
        i = this.iiX - k;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public boolean cqX()
  {
    AppMethodBeat.i(37073);
    if (cqW() >= Math.min(getView().getHeight() >>> 1, this.iiX >>> 1))
    {
      AppMethodBeat.o(37073);
      return true;
    }
    AppMethodBeat.o(37073);
    return false;
  }
  
  public final String cqY()
  {
    return this.rve.rsI;
  }
  
  public final void cqZ()
  {
    AppMethodBeat.i(37076);
    Object localObject1;
    if (this.contentView == null)
    {
      localObject1 = new IllegalStateException("set field contentView first");
      AppMethodBeat.o(37076);
      throw ((Throwable)localObject1);
    }
    if (this.rve != null)
    {
      localObject1 = this.contentView.getLayoutParams();
      if (localObject1 != null)
      {
        if (this.rve.rsK != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).width = ((int)this.rve.rsK);
        }
        if (this.rve.rsL != 2.147484E+009F) {
          ((ViewGroup.LayoutParams)localObject1).height = ((int)this.rve.rsL);
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
          AppMethodBeat.o(37076);
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
      ab.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.rvi);
    }
    AppMethodBeat.o(37076);
  }
  
  public void cqz()
  {
    AppMethodBeat.i(37074);
    cqB();
    AppMethodBeat.o(37074);
  }
  
  public void cra() {}
  
  protected final <T> T crb()
  {
    try
    {
      t localt = this.rve;
      return localt;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final x crc()
  {
    AppMethodBeat.i(37077);
    if ((this.context instanceof SnsAdNativeLandingPagesUI))
    {
      localObject = (SnsAdNativeLandingPagesUI)this.context;
      if (((SnsAdNativeLandingPagesUI)localObject).rMJ != null)
      {
        localObject = ((SnsAdNativeLandingPagesUI)localObject).rMJ;
        AppMethodBeat.o(37077);
        return localObject;
      }
      ((SnsAdNativeLandingPagesUI)localObject).rMJ = new x();
      x localx = ((SnsAdNativeLandingPagesUI)localObject).rMJ;
      if (((SnsAdNativeLandingPagesUI)localObject).rtf == 0) {}
      for (int i = ((SnsAdNativeLandingPagesUI)localObject).cpt;; i = ((SnsAdNativeLandingPagesUI)localObject).rtf)
      {
        localx.rtf = i;
        ((SnsAdNativeLandingPagesUI)localObject).rMJ.rtg = ((SnsAdNativeLandingPagesUI)localObject).rMm;
        ((SnsAdNativeLandingPagesUI)localObject).rMJ.cFe = ((SnsAdNativeLandingPagesUI)localObject).cFe;
        ((SnsAdNativeLandingPagesUI)localObject).rMJ.uin = ((SnsAdNativeLandingPagesUI)localObject).uin;
        ((SnsAdNativeLandingPagesUI)localObject).rMJ.rth = ((SnsAdNativeLandingPagesUI)localObject).rth;
        ((SnsAdNativeLandingPagesUI)localObject).rMJ.rpv = ((SnsAdNativeLandingPagesUI)localObject).rpv;
        ((SnsAdNativeLandingPagesUI)localObject).rMJ.heu = ((SnsAdNativeLandingPagesUI)localObject).heu;
        localx = ((SnsAdNativeLandingPagesUI)localObject).rMJ;
        Map localMap = ((SnsAdNativeLandingPagesUI)localObject).rti;
        localx.rti.putAll(localMap);
        localObject = ((SnsAdNativeLandingPagesUI)localObject).rMJ;
        AppMethodBeat.o(37077);
        return localObject;
      }
    }
    Object localObject = new x();
    AppMethodBeat.o(37077);
    return localObject;
  }
  
  public final int getGravity()
  {
    int i = 0;
    switch (this.rve.rsO)
    {
    }
    for (;;)
    {
      switch (this.rve.rsP)
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
    AppMethodBeat.i(37068);
    if (this.contentView != null)
    {
      localObject = this.contentView;
      AppMethodBeat.o(37068);
      return localObject;
    }
    if (this.contentView == null)
    {
      int i = getLayout();
      if (i != 2147483647) {
        this.contentView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(i, this.rvi, false);
      }
      while (this.contentView == null)
      {
        localObject = new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
        AppMethodBeat.o(37068);
        throw ((Throwable)localObject);
        this.contentView = cqR();
        if ((this.contentView != null) && (this.contentView.getLayoutParams() == null))
        {
          this.rvi.addView(this.contentView);
          localObject = this.contentView.getLayoutParams();
          this.rvi.removeView(this.contentView);
          this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    cqK();
    cqP();
    cqQ();
    cqZ();
    Object localObject = this.contentView;
    AppMethodBeat.o(37068);
    return localObject;
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h
 * JD-Core Version:    0.7.0.1
 */