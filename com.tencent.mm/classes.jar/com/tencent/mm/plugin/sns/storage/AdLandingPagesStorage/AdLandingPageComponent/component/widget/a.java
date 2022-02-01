package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.List;

public abstract class a
  extends k
{
  public a(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
  }
  
  public final boolean dKC()
  {
    int i = dKB();
    ac.i("MicroMsg.AdLandingPageContainerComponent", "inScreenHeight %d", new Object[] { Integer.valueOf(i) });
    return i > 0;
  }
  
  public abstract void dKt();
  
  public abstract List<k> dKu();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
 * JD-Core Version:    0.7.0.1
 */