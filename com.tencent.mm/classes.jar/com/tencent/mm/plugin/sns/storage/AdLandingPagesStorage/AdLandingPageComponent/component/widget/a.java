package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

public abstract class a
  extends l
{
  public a(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
  }
  
  public abstract void dWG();
  
  public abstract List<l> dWH();
  
  public final boolean dWU()
  {
    int i = dWT();
    ad.i("MicroMsg.AdLandingPageContainerComponent", "inScreenHeight %d", new Object[] { Integer.valueOf(i) });
    return i > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
 * JD-Core Version:    0.7.0.1
 */