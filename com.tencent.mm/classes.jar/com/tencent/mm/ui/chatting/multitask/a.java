package com.tencent.mm.ui.chatting.multitask;

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
  private boolean PDX = false;
  private boolean PDY = false;
  private String id;
  
  public a(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final void e(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.PDX = paramBoolean1;
    this.PDY = paramBoolean2;
    this.id = paramString;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(233463);
    Object localObject = c.AgL;
    if (c.Ss(4))
    {
      AppMethodBeat.o(233463);
      return null;
    }
    if (this.PDX)
    {
      localObject = MMApplicationContext.getContext().getExternalCacheDir().getAbsolutePath() + "//" + this.id;
      com.tencent.mm.plugin.multitask.f.a locala = com.tencent.mm.plugin.multitask.f.a.AgJ;
      localObject = com.tencent.mm.plugin.multitask.f.a.aGR((String)localObject);
      AppMethodBeat.o(233463);
      return localObject;
    }
    if (this.PDY)
    {
      localObject = super.getBitmap();
      AppMethodBeat.o(233463);
      return localObject;
    }
    AppMethodBeat.o(233463);
    return null;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(233464);
    Object localObject = super.getContentView();
    int i;
    if (localObject == null)
    {
      ViewGroup localViewGroup = chG();
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
      AppMethodBeat.o(233464);
      return localObject;
      AppMethodBeat.o(233464);
      return localObject;
    }
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(233465);
    ViewGroup localViewGroup = chG();
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
      AppMethodBeat.o(233465);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.multitask.a
 * JD-Core Version:    0.7.0.1
 */