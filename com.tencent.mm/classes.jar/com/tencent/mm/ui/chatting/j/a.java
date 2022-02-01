package com.tencent.mm.ui.chatting.j;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.a.b;
import com.tencent.mm.plugin.multitask.f.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.File;

public final class a
  extends b
{
  private boolean WYK = false;
  private boolean WYL = false;
  private String id;
  
  public a(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final void d(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.WYK = paramBoolean1;
    this.WYL = paramBoolean2;
    this.id = paramString;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(286415);
    Object localObject = c.FNB;
    if (c.YO(4))
    {
      AppMethodBeat.o(286415);
      return null;
    }
    if (this.WYK)
    {
      localObject = MMApplicationContext.getContext().getExternalCacheDir().getAbsolutePath() + "//" + this.id;
      com.tencent.mm.plugin.multitask.f.a locala = com.tencent.mm.plugin.multitask.f.a.FNz;
      localObject = com.tencent.mm.plugin.multitask.f.a.aRg((String)localObject);
      AppMethodBeat.o(286415);
      return localObject;
    }
    if (this.WYL)
    {
      localObject = super.getBitmap();
      AppMethodBeat.o(286415);
      return localObject;
    }
    AppMethodBeat.o(286415);
    return null;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(286416);
    Object localObject = super.getContentView();
    int i;
    if (localObject == null)
    {
      ViewGroup localViewGroup = cuR();
      localObject = null;
      i = 0;
      int k = 1;
      int j = 1;
      if (i < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(i);
        if ((localView == null) || (localView.getHeight() * localView.getWidth() <= k * j)) {
          break label109;
        }
        k = localView.getWidth();
        j = localView.getHeight();
        localObject = localView;
      }
    }
    label109:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(286416);
      return localObject;
      AppMethodBeat.o(286416);
      return localObject;
    }
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(286417);
    ViewGroup localViewGroup = cuR();
    Object localObject = null;
    int i = 0;
    int k = 1;
    int j = 1;
    if (i < localViewGroup.getChildCount())
    {
      View localView = localViewGroup.getChildAt(i);
      if ((localView == null) || (localView.getHeight() * localView.getWidth() <= k * j)) {
        break label90;
      }
      k = localView.getWidth();
      j = localView.getHeight();
      localObject = localView;
    }
    label90:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(286417);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.a
 * JD-Core Version:    0.7.0.1
 */