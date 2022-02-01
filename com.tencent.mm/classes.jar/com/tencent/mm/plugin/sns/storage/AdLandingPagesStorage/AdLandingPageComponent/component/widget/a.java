package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.List;

public abstract class a
  extends m
{
  public a(Context paramContext, y paramy, ViewGroup paramViewGroup)
  {
    super(paramContext, paramy, paramViewGroup);
  }
  
  public abstract void eai();
  
  public abstract List<m> eaj();
  
  public final boolean eay()
  {
    int i = eax();
    ae.i("MicroMsg.AdLandingPageContainerComponent", "inScreenHeight %d", new Object[] { Integer.valueOf(i) });
    return i > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
 * JD-Core Version:    0.7.0.1
 */