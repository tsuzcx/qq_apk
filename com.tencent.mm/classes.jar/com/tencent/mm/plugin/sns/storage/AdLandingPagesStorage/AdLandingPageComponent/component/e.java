package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends a
{
  private List<i> aPf;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e oFv;
  private l oFw;
  
  public e(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    super(paramContext, parame, paramViewGroup);
    this.oFv = parame;
    this.aPf = new ArrayList();
  }
  
  public final void W(int paramInt1, int paramInt2, int paramInt3)
  {
    super.W(paramInt1, paramInt2, paramInt3);
    Iterator localIterator = this.aPf.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).W(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void a(s params)
  {
    if ((params instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)) {
      this.oFv = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)params);
    }
    super.a(params);
  }
  
  public final void bES()
  {
    super.bES();
    Iterator localIterator = this.aPf.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).bES();
    }
  }
  
  public final void bET()
  {
    super.bET();
    Iterator localIterator = this.aPf.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).bET();
    }
  }
  
  public final void bEU()
  {
    super.bEU();
    Iterator localIterator = this.aPf.iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).bEU();
    }
  }
  
  protected final void bFj()
  {
    if (this.oFw == null)
    {
      this.oFw = new l(this.oFv.aPf, this.context, 0, (FrameLayout)this.contentView);
      this.oFw.bFX();
      return;
    }
    this.oFw.cA(this.oFv.aPf);
  }
  
  protected final View bFk()
  {
    return new FrameLayout(this.context);
  }
  
  public final boolean v(JSONArray paramJSONArray)
  {
    Object localObject = new JSONObject();
    if (super.ah((JSONObject)localObject)) {
      paramJSONArray.put(localObject);
    }
    localObject = this.aPf.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e
 * JD-Core Version:    0.7.0.1
 */