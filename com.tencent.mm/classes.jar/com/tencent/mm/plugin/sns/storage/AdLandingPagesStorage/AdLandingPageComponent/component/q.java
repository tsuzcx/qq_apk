package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q
  extends a
{
  private l oFw;
  LinearLayout oGP;
  
  public q(Context paramContext, r paramr, ViewGroup paramViewGroup)
  {
    super(paramContext, paramr, paramViewGroup);
  }
  
  public final void W(int paramInt1, int paramInt2, int paramInt3)
  {
    super.W(paramInt1, paramInt2, paramInt3);
    Iterator localIterator = this.oFw.bFL().iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).W(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void bES()
  {
    super.bES();
    Iterator localIterator = this.oFw.bFL().iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).bES();
    }
  }
  
  public final void bET()
  {
    super.bET();
    Iterator localIterator = this.oFw.bFL().iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).bET();
    }
  }
  
  public final void bEU()
  {
    super.bEU();
    Iterator localIterator = this.oFw.bFL().iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).bEU();
    }
  }
  
  public final View bFf()
  {
    View localView = this.contentView;
    this.oGP = ((LinearLayout)localView.findViewById(i.f.sns_ad_native_landing_pages_item_page_linear_layout));
    return localView;
  }
  
  protected final void bFj()
  {
    if (((r)this.oFE).oDf == 0) {
      this.oGP.setOrientation(1);
    }
    while (this.oFw == null)
    {
      this.oFw = new l(((r)this.oFE).oDe, this.context, ((r)this.oFE).bgColor, this.oGP);
      this.oFw.bFX();
      return;
      if (((r)this.oFE).oDf == 1) {
        this.oGP.setOrientation(0);
      }
    }
    this.oFw.cA(((r)this.oFE).oDe);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_linear_layout;
  }
  
  public final boolean v(JSONArray paramJSONArray)
  {
    Object localObject = new JSONObject();
    if (super.ah((JSONObject)localObject)) {
      paramJSONArray.put(localObject);
    }
    localObject = this.oFw.bFL().iterator();
    while (((Iterator)localObject).hasNext())
    {
      i locali = (i)((Iterator)localObject).next();
      JSONObject localJSONObject = new JSONObject();
      if ((locali != null) && (locali.ah(localJSONObject))) {
        paramJSONArray.put(localJSONObject);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
 * JD-Core Version:    0.7.0.1
 */