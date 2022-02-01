package com.tencent.mm.plugin.sns.ad.timeline.helper;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
{
  public static ImageView a(Context paramContext, PhotosContent paramPhotosContent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(311136);
    if ((paramContext == null) || (paramPhotosContent == null))
    {
      AppMethodBeat.o(311136);
      return null;
    }
    try
    {
      paramPhotosContent = paramPhotosContent.getChildAt(paramInt1);
      if (paramPhotosContent != null) {}
      for (paramPhotosContent = (FrameLayout.LayoutParams)paramPhotosContent.getLayoutParams(); paramPhotosContent != null; paramPhotosContent = null)
      {
        ImageView localImageView = new ImageView(paramContext);
        paramPhotosContent = new FrameLayout.LayoutParams(paramPhotosContent);
        paramPhotosContent.width = paramInt2;
        paramPhotosContent.height = paramInt2;
        localImageView.setImageDrawable(a.m(paramContext, b.e.we_app_icon));
        localImageView.setLayoutParams(paramPhotosContent);
        AppMethodBeat.o(311136);
        return localImageView;
      }
      Log.e("AddWeAppIconHelper", "getEachImageViewLayoutParams is null");
    }
    finally
    {
      for (;;)
      {
        Log.e("AddWeAppIconHelper", paramContext.toString());
      }
    }
    AppMethodBeat.o(311136);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.d
 * JD-Core Version:    0.7.0.1
 */