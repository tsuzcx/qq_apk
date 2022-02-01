package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static ImageView a(Context paramContext, PhotosContent paramPhotosContent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202202);
    if ((paramContext == null) || (paramPhotosContent == null))
    {
      AppMethodBeat.o(202202);
      return null;
    }
    try
    {
      paramPhotosContent = paramPhotosContent.getChildAt(paramInt1);
      if (paramPhotosContent != null) {}
      for (paramPhotosContent = (ViewGroup.MarginLayoutParams)paramPhotosContent.getLayoutParams(); paramPhotosContent != null; paramPhotosContent = null)
      {
        ImageView localImageView = new ImageView(paramContext);
        paramPhotosContent = new ViewGroup.MarginLayoutParams(paramPhotosContent);
        paramPhotosContent.width = paramInt2;
        paramPhotosContent.height = paramInt2;
        localImageView.setImageDrawable(a.l(paramContext, 2131235696));
        localImageView.setLayoutParams(paramPhotosContent);
        AppMethodBeat.o(202202);
        return localImageView;
      }
      Log.e("AddWeAppIconHelper", "getEachImageViewLayoutParams is null");
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Log.e("AddWeAppIconHelper", paramContext.toString());
      }
    }
    AppMethodBeat.o(202202);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.c
 * JD-Core Version:    0.7.0.1
 */