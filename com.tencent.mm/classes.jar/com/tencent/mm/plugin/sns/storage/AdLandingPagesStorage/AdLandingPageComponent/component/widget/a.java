package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public abstract class a
  extends n
{
  public a(Context paramContext, aa paramaa, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaa, paramViewGroup);
  }
  
  public abstract List<n> hai();
  
  public abstract void har();
  
  public final boolean hji()
  {
    int i = hjh();
    Log.i("MicroMsg.AdLandingPageContainerComponent", "inScreenHeight %d", new Object[] { Integer.valueOf(i) });
    return i > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
 * JD-Core Version:    0.7.0.1
 */