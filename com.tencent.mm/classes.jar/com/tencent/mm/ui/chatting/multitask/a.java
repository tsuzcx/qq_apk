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
  private boolean aeIk = false;
  private boolean aeIl = false;
  private String id;
  
  public a(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final void e(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.aeIk = paramBoolean1;
    this.aeIl = paramBoolean2;
    this.id = paramString;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(254001);
    Object localObject = c.LIw;
    if (c.ada(4))
    {
      AppMethodBeat.o(254001);
      return null;
    }
    if (this.aeIk)
    {
      localObject = MMApplicationContext.getContext().getExternalCacheDir().getAbsolutePath() + "//" + this.id;
      com.tencent.mm.plugin.multitask.f.a locala = com.tencent.mm.plugin.multitask.f.a.LIu;
      localObject = com.tencent.mm.plugin.multitask.f.a.aNY((String)localObject);
      AppMethodBeat.o(254001);
      return localObject;
    }
    if (this.aeIl)
    {
      localObject = super.getBitmap();
      AppMethodBeat.o(254001);
      return localObject;
    }
    AppMethodBeat.o(254001);
    return null;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(254005);
    Object localObject = super.getContentView();
    int i;
    if (localObject == null)
    {
      ViewGroup localViewGroup = cXB();
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
      AppMethodBeat.o(254005);
      return localObject;
      AppMethodBeat.o(254005);
      return localObject;
    }
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(254011);
    ViewGroup localViewGroup = cXB();
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
      AppMethodBeat.o(254011);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.multitask.a
 * JD-Core Version:    0.7.0.1
 */