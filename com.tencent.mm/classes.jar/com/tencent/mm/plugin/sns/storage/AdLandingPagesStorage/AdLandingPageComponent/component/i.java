package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i
{
  protected int backgroundColor;
  protected View contentView = null;
  public Context context;
  protected int gHR;
  protected int gHS;
  private long gYS = 0L;
  protected s oFE;
  private int oFF = 0;
  private long oFG = 0L;
  boolean oFH = false;
  protected ViewGroup oFI;
  
  public i(Context paramContext, s params, ViewGroup paramViewGroup)
  {
    this.context = paramContext;
    this.oFE = params;
    this.oFI = paramViewGroup;
    paramContext = ad.ed(paramContext);
    this.gHR = paramContext[0];
    this.gHS = paramContext[1];
  }
  
  private int getGravity()
  {
    int i = 0;
    switch (this.oFE.oDq)
    {
    }
    for (;;)
    {
      switch (this.oFE.oDr)
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
  
  public void L(Map<String, Object> paramMap) {}
  
  public void W(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(s params)
  {
    s locals = this.oFE;
    if (locals == params) {}
    while ((locals != null) && (locals.equals(params))) {
      return;
    }
    this.oFE = params;
    bFj();
    bFd();
  }
  
  public boolean ah(JSONObject paramJSONObject)
  {
    if (this.gYS == 0L) {}
    while (this.oFE.oDt) {
      return false;
    }
    try
    {
      paramJSONObject.put("cid", this.oFE.oDg);
      paramJSONObject.put("exposureCount", this.oFF);
      paramJSONObject.put("stayTime", this.gYS);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      y.printErrStackTrace("MicroMsg.Sns.AdLandingPageBaseComponent", paramJSONObject, "", new Object[0]);
    }
    return false;
  }
  
  public void bES()
  {
    bEU();
  }
  
  public void bET()
  {
    if (this.oFH) {
      return;
    }
    this.oFH = true;
    this.oFG = System.currentTimeMillis();
    this.oFF += 1;
  }
  
  public void bEU()
  {
    if (!this.oFH) {
      return;
    }
    this.oFH = false;
    if (this.oFG > 0L) {
      this.gYS += System.currentTimeMillis() - this.oFG;
    }
    this.oFG = 0L;
  }
  
  public void bEX() {}
  
  protected void bFd()
  {
    jn(false);
  }
  
  public View bFf()
  {
    return this.contentView;
  }
  
  protected void bFj()
  {
    y.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
  }
  
  protected View bFk()
  {
    return null;
  }
  
  public final s bFm()
  {
    return this.oFE;
  }
  
  public final String bFn()
  {
    return this.oFE.oDg;
  }
  
  public void bFo() {}
  
  protected int getLayout()
  {
    return 2147483647;
  }
  
  public final View getView()
  {
    if (this.contentView != null) {
      return this.contentView;
    }
    if (this.contentView == null)
    {
      int i = getLayout();
      if (i != 2147483647) {
        this.contentView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(i, this.oFI, false);
      }
      while (this.contentView == null)
      {
        throw new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
        this.contentView = bFk();
        if ((this.contentView != null) && (this.contentView.getLayoutParams() == null))
        {
          this.oFI.addView(this.contentView);
          ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
          this.oFI.removeView(this.contentView);
          this.contentView.setLayoutParams(localLayoutParams);
        }
      }
    }
    bFf();
    bEX();
    bFj();
    bFd();
    return this.contentView;
  }
  
  protected final void jn(boolean paramBoolean)
  {
    if (this.contentView == null) {
      throw new IllegalStateException("set field contentView first");
    }
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject;
    int i;
    if (this.oFE != null)
    {
      localLayoutParams = this.contentView.getLayoutParams();
      if (localLayoutParams == null) {
        break label222;
      }
      if (this.oFE.oDm != 2.147484E+009F) {
        localLayoutParams.width = ((int)this.oFE.oDm);
      }
      if (this.oFE.oDn != 2.147484E+009F) {
        localLayoutParams.height = ((int)this.oFE.oDn);
      }
      if ((paramBoolean) && ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))) {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.oFE.oDk, (int)this.oFE.oDi, (int)this.oFE.oDl, (int)this.oFE.oDj);
      }
      if (!(localLayoutParams instanceof LinearLayout.LayoutParams)) {
        break label182;
      }
      localObject = (LinearLayout.LayoutParams)localLayoutParams;
      i = getGravity();
      if (i == 0) {
        break label173;
      }
      ((LinearLayout.LayoutParams)localObject).gravity = i;
    }
    for (;;)
    {
      this.contentView.setLayoutParams(localLayoutParams);
      return;
      label173:
      ((LinearLayout.LayoutParams)localObject).gravity = -1;
      continue;
      label182:
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject = (FrameLayout.LayoutParams)localLayoutParams;
        i = getGravity();
        if (i != 0) {
          ((FrameLayout.LayoutParams)localObject).gravity = i;
        } else {
          ((FrameLayout.LayoutParams)localObject).gravity = -1;
        }
      }
    }
    label222:
    y.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.oFI);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
  
  public boolean v(JSONArray paramJSONArray)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i
 * JD-Core Version:    0.7.0.1
 */